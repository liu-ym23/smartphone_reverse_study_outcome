package com.ss.ttvideoengine.source.strategy;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.TTVideoEngineConfig;
import com.ss.ttvideoengine.model.IVideoModel;
import com.ss.ttvideoengine.model.VideoInfo;
import com.ss.ttvideoengine.model.VideoModel;
import com.ss.ttvideoengine.net.TTHTTPNetwork;
import com.ss.ttvideoengine.net.TTVNetClient;
import com.ss.ttvideoengine.utils.Error;
import com.ss.ttvideoengine.utils.TTHelper;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import com.ss.ttvideoengine.utils.WeakHandler;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes35.dex */
public class SmartUrlFetcher implements WeakHandler.IHandler {
    public static final int CACHE_TYPE_HINT_CACHE = 1;
    public static final int CACHE_TYPE_NONE = 0;
    private static final int MSG_COMPLETE = 1;
    private static final int MSG_ERROR = 2;
    private static final String TAG = "CodecStrategy_SmartUrlFetcher";
    private final Callback mCallback;
    private volatile boolean mCanceled;
    private final Handler mH;
    private final TTVNetClient mHttpClient;
    private RequestParams mRequestParams;

    public interface Callback {
        void onComplete(RequestParams r100, int r101, Result r102);

        void onError(RequestParams r100, Error r101);
    }

    public static class RequestParams {
        public String cacheKey;
        public String codec;
        public String definition;
        public String playUrl;
        public String videoId;

        public RequestParams() {
        }

        public String toString() {
            return "RequestParams{videoId='" + this.videoId + "', playUrl='" + this.playUrl + "', cacheKey='" + this.cacheKey + "', codec='" + this.codec + "', definition='" + this.definition + "'}";
        }
    }

    public static class Result {
        public static final int DataStoreStatusHasEncodeStream = 3;
        public static final int DataStoreStatusHasOriginalStream = 2;
        public static final int DataStoreStatusNotExist = 1;
        public static final int DataStoreStatusUndefined = 0;
        public static final int StreamTypeFallbackEncodeStream = 3;
        public static final int StreamTypeOriginalStream = 1;
        public static final int StreamTypeStrategyEncodeStream = 2;
        public static final int StreamTypeUndefined = 0;
        public final int dataStoreStatus;
        public final Error error;
        public final JSONObject jsonResult;
        public final String originalPlayUrl;
        public final int streamType;
        public final IVideoModel videoModel;

        private static boolean isStreamTypeValid(int r100) {
            if (r100 != 2) goto L5;
        L8:
            return true;
        L5:
            if (r100 == 3) goto L8;
            return false;
        }

        public boolean isEncodeStream() {
            IVideoModel r100 = this.videoModel;
            if (r100 != null) goto L5;
            return false;
        L5:
            if (r100.getVideoRefStr(2) == null) goto L15;
            Resolution r101 = CodecStrategy.SmartUrlVod.findTargetResolution(this.videoModel);
            VideoInfo r102 = this.videoModel.getVideoInfo(r101, false);
            if (r102 == null) goto L16;
            String r103 = r102.getValueStr(0);
            String r104 = r102.getValueStr(17);
            if (TextUtils.isEmpty(r103) == true) goto L11;
        L12:
            return true;
        L11:
            if (TextUtils.isEmpty(r104) == false) goto L12;
            return false;
        L16:
            return false;
        L15:
            return false;
        }

        public String toString() {
            return "Result{dataStoreStatus=" + this.dataStoreStatus + ", streamType=" + this.streamType + ", originalPlayUrl='" + this.originalPlayUrl + "', videoModel=" + this.videoModel + ", jsonResult=" + this.jsonResult + ", error=" + this.error + '}';
        }

        public static /* synthetic */ Result access$200(JSONObject r100) {
            return parseResult(r100);
        }

        private static Result parseResult(JSONObject r110) {
            JSONObject r100 = r110.optJSONObject("Result");
            if (r100 == null) goto L5;
            int r101 = r100.optInt("DataStoreStatus");
            int r111 = r100.optInt("StreamType");
            String r112 = r100.optString("OriginalPlayUrl");
            JSONObject r102 = r100.optJSONObject("PlayInfoModel");
            if (r102 == null) goto L17;
            if (isStreamTypeValid(r111) == false) goto L17;
            VideoModel r103 = new VideoModel();     // Catch: Throwable -> L13
            r103.extractFields(r102);     // Catch: Throwable -> L13
            return new Result(r101, r111, r112, r103, r110, null);
        L13:
            th = move-exception;
            return new Result(r101, r111, r112, null, r110, new Error(Error.FetchingSmartUrlInfo, Error.VideoModelExtractError, "video model extract failed: " + th));
        L17:
            return new Result(r101, r111, r112, null, r110, null);
        L5:
            return new Result(r110, new Error(Error.FetchingSmartUrlInfo, Error.ParseJsonError, "Result is null"));
        }

        public Result(JSONObject r100, Error r101) {
            this.dataStoreStatus = -1;
            this.streamType = -1;
            this.originalPlayUrl = null;
            this.videoModel = null;
            this.jsonResult = r100;
            this.error = r101;
        }

        public Result(int r100, int r101, String r102, IVideoModel r103, JSONObject r104, Error r105) {
            this.dataStoreStatus = r100;
            this.streamType = r101;
            this.originalPlayUrl = r102;
            this.videoModel = r103;
            this.jsonResult = r104;
            this.error = r105;
        }
    }

    public static class SmartUrlCache {
        public static final String TAG = "CodecStrategy_SmartUrlCache";
        private static final Map<String, CacheHolder> sCacheMap = null;

        public static class CacheHolder {
            private final long expiredMS;
            private final Result result;

            public static /* synthetic */ long access$400(CacheHolder r100) {
                return r100.expiredMS;
            }

            public static /* synthetic */ Result access$500(CacheHolder r100) {
                return r100.result;
            }

            public CacheHolder(Result r100, long r101) {
                this.result = r100;
                this.expiredMS = r101;
            }
        }

        public SmartUrlCache() {
        }

        static {
            sCacheMap = new HashMap();
        }

        public static void clear() {
            if (TTVideoEngineLog.d() == false) goto L5;
            TTVideoEngineLog.d(TAG, "clear");
        L5:
            sCacheMap.clear();
        }

        private static Result find(String r100) {
            CacheHolder r101 = sCacheMap.get(r100);
            if (r101 != null) goto L6;
            return null;
        L6:
            if (CacheHolder.access$400(r101) != (-1)) goto L10;
            return CacheHolder.access$500(r101);
        L10:
            if (CacheHolder.access$400(r101) < SystemClock.uptimeMillis()) goto L12;
            return null;
        L12:
            return CacheHolder.access$500(r101);
        }

        public static Result get(String r100) {
            Result r101 = find(r100);
            TTVideoEngineLog.d(TAG, "get " + r100 + " " + r101);
            return r101;
        }

        public static String key(RequestParams r100) {
            if (TextUtils.isEmpty(r100.cacheKey) == true) goto L7;
            return r100.cacheKey;
        L7:
            return r100.playUrl;
        }

        public static void remove(String r100) {
            if (TTVideoEngineLog.d() == false) goto L5;
            TTVideoEngineLog.d(TAG, "remove " + r100);
        L5:
            sCacheMap.remove(r100);
        }

        public static void put(String r100, Result r101) {
            if (TTVideoEngineLog.d() == false) goto L5;
            TTVideoEngineLog.d(TAG, "put " + r100 + " " + r101);
        L5:
            sCacheMap.put(r100, new CacheHolder(r101, -1));
        }
    }

    public void cancel() {
        if (this.mCanceled == false) goto L5;
        return;
    L5:
        this.mCanceled = true;
        this.mHttpClient.cancel();
        this.mH.removeCallbacksAndMessages(null);
        if (TTVideoEngineLog.d() == false) goto L9;
        TTVideoEngineLog.d(TAG, "cancel " + this.mRequestParams);
        return;
    }

    public void start() {
        if (TTVideoEngineLog.d() == false) goto L5;
        TTVideoEngineLog.d(TAG, "start " + this.mRequestParams);
    L5:
        RequestParams r100 = this.mRequestParams;
        String r101 = SmartUrlCache.key(r100);
        Result r102 = SmartUrlCache.get(r101);
        if (r102 == null) goto L8;
        notifyComplete(r100, 1, r102);
        return;
    L8:
        fetch(r101, r100);
    }

    public boolean isCanceled() {
        return this.mCanceled;
    }

    public SmartUrlFetcher(Callback r100) {
        this.mCallback = r100;
        TTVNetClient r101 = TTVideoEngineConfig.gNetClient;
        if (r101 == null) goto L5;
        this.mHttpClient = r101;
    L7:
        if (Looper.myLooper() != null) goto L9;
        Looper r102 = Looper.getMainLooper();
    L10:
        this.mH = new WeakHandler(r102, this);
        return;
    L9:
        r102 = Looper.myLooper();
        goto L10
    L5:
        this.mHttpClient = new TTHTTPNetwork();
        goto L7
    }

    public static /* synthetic */ boolean access$000(SmartUrlFetcher r100) {
        return r100.mCanceled;
    }

    private static String buildRequestUrl(RequestParams r100) {
        LinkedHashMap r101 = new LinkedHashMap();
        r101.put("PlayUrl", r100.playUrl);
        r101.put("Codec", r100.codec);
        r101.put("Definition", r100.definition);
        StringBuilder r102 = new StringBuilder();
        String r103 = CodecStrategy.SmartUrlVod.getApiHost();
        if (r103 != null) goto L5;
    L7:
        r102.append(r103);
        r102.append("/api/general/getSmartStrategyLitePlayInfo20220101?");
        r102.append(TTHelper.buildUrlEncodedQuery(r101));
        return r102.toString();
    L5:
        if (r103.startsWith("http") == true) goto L7;
        r102.append("https://");
        goto L7
    }

    @Override // com.ss.ttvideoengine.utils.WeakHandler.IHandler
    public void handleMessage(Message r100) {
        int r101 = r100.what;
        if (r101 == 1) goto L7;
        if (r101 != 2) goto L10;
        Object[] r102 = (Object[]) r100.obj;
        notifyError((RequestParams) r102[0], (Error) r102[1]);
        return;
    L10:
        return;
    L7:
        Object[] r103 = (Object[]) r100.obj;
        notifyComplete((RequestParams) r103[0], ((Integer) r103[1]).intValue(), (Result) r103[2]);
    }

    public void setRequestParams(RequestParams r100) {
        this.mRequestParams = r100;
    }

    private void fetch(final String r100, final RequestParams r101) {
        String r102 = buildRequestUrl(r101);
        this.mHttpClient.startTask(r102, new AnonymousClass1(this, r101, r100));
        if (TTVideoEngineLog.d() == false) goto L6;
        TTVideoEngineLog.d(TAG, "fetch " + r101 + ", requestUrl = " + r102);
        return;
    }

    private void notifyError(RequestParams r100, Error r101) {
        r101.domain = Error.FetchingSmartUrlInfo;
        if (this.mH.getLooper() == Looper.myLooper()) goto L5;
        this.mH.obtainMessage(2, new Object[]{r100, r101}).sendToTarget();
        return;
    L5:
        if (this.mCanceled == false) goto L11;
        if (TTVideoEngineLog.d() == false) goto L19;
        TTVideoEngineLog.d(TAG, "notifyError canceled");
        return;
    L19:
        return;
    L11:
        if (this.mCallback != null) goto L14;
        return;
    L14:
        if (TTVideoEngineLog.d() == false) goto L16;
        TTVideoEngineLog.d(TAG, "notifyError " + r100 + " " + r101);
    L16:
        this.mCallback.onError(r100, r101);
    }

    public static /* synthetic */ void access$100(SmartUrlFetcher r100, RequestParams r101, Error r102) {
        r100.notifyError(r101, r102);
    }

    private void notifyComplete(RequestParams r100, int r101, Result r102) {
        if (this.mH.getLooper() == Looper.myLooper()) goto L5;
        this.mH.obtainMessage(1, new Object[]{r100, Integer.valueOf(r101), r102}).sendToTarget();
        return;
    L5:
        if (this.mCanceled == false) goto L11;
        if (TTVideoEngineLog.d() == false) goto L19;
        TTVideoEngineLog.d(TAG, "notifyComplete canceled");
        return;
    L19:
        return;
    L11:
        if (this.mCallback != null) goto L14;
        return;
    L14:
        if (TTVideoEngineLog.d() == false) goto L16;
        TTVideoEngineLog.d(TAG, "notifyComplete " + r100 + " " + r101 + " " + r102);
    L16:
        this.mCallback.onComplete(r100, r101, r102);
    }

    public static /* synthetic */ void access$300(SmartUrlFetcher r100, RequestParams r101, int r102, Result r103) {
        r100.notifyComplete(r101, r102, r103);
    }
}
