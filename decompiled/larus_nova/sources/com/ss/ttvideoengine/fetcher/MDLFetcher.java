package com.ss.ttvideoengine.fetcher;

import android.content.Context;
import android.text.TextUtils;
import com.ss.mediakit.fetcher.AVMDLURLFetcherInterface;
import com.ss.mediakit.fetcher.AVMDLURLFetcherListener;
import com.ss.ttvideoengine.VideoModelCache;
import com.ss.ttvideoengine.model.VideoInfo;
import com.ss.ttvideoengine.model.VideoModel;
import com.ss.ttvideoengine.utils.Error;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import com.ss.ttvideoengine.utils.TTVideoEngineUtils;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: loaded from: classes34.dex */
public class MDLFetcher implements AVMDLURLFetcherInterface {
    private static final String TAG = "MDLFetcher";
    private Context mContext;
    private String mFallbackAPI;
    private VideoInfoFetcher mFetcher;
    private String mFileHash;
    private String mKeyseed;
    private AVMDLURLFetcherListener mListener;
    private String[] mNewUrls;
    private String mOldUrl;
    private String mVideoID;

    public static class MyFetcherListener implements VideoInfoFetcher.FetcherListener {
        private final WeakReference<MDLFetcher> mFetcherRef;

        @Override // com.ss.ttvideoengine.fetcher.VideoInfoFetcher.FetcherListener
        public void onLog(String r100) {
        }

        @Override // com.ss.ttvideoengine.fetcher.VideoInfoFetcher.FetcherListener
        public void onRetry(Error r100) {
        }

        public MyFetcherListener(MDLFetcher r100) {
            this.mFetcherRef = new WeakReference(r100);
        }

        @Override // com.ss.ttvideoengine.fetcher.VideoInfoFetcher.FetcherListener
        public void onCompletion(VideoModel r100, Error r101) {
            TTVideoEngineLog.i(MDLFetcher.TAG, "onCompletion model " + r100 + ", error " + r101);
            MDLFetcher r102 = this.mFetcherRef.get();
            if (r102 != null) goto L7;
            TTVideoEngineLog.i(MDLFetcher.TAG, "onCompletion but fetcher is null");
            return;
        L7:
            if (r100 == null) goto L19;
            if (r101 != null) goto L19;
            MDLFetcher.access$302(r102, MDLFetcher.access$400(r102, r100, MDLFetcher.access$200(r102)));
            TTVideoEngineLog.i(MDLFetcher.TAG, "onCompletion newUrls " + Arrays.toString(MDLFetcher.access$300(r102)));
            if (MDLFetcher.access$600(MDLFetcher.access$300(r102), MDLFetcher.access$500(r102)) == false) goto L15;
            TTVideoEngineLog.i(MDLFetcher.TAG, "onCompletion success");
            if (MDLFetcher.access$000(r102) == null) goto L26;
            MDLFetcher.access$000(r102).onCompletion(0, MDLFetcher.access$100(r102), MDLFetcher.access$200(r102), MDLFetcher.access$300(r102));
            return;
        L26:
            return;
        L15:
            TTVideoEngineLog.i(MDLFetcher.TAG, "onCompletion invalid");
            if (MDLFetcher.access$000(r102) == null) goto L28;
            MDLFetcher.access$000(r102).onCompletion(-1, MDLFetcher.access$100(r102), MDLFetcher.access$200(r102), null);
            return;
        L28:
            return;
        L19:
            if (r101 == null) goto L21;
            int r103 = r101.code;
        L23:
            if (MDLFetcher.access$000(r102) == null) goto L29;
            MDLFetcher.access$000(r102).onCompletion(r103, MDLFetcher.access$100(r102), MDLFetcher.access$200(r102), null);
            return;
        L29:
            return;
        L21:
            r103 = Error.ResultEmpty;
            goto L23
        }

        @Override // com.ss.ttvideoengine.fetcher.VideoInfoFetcher.FetcherListener
        public void onStatusException(int r100, String r101) {
            MDLFetcher r102 = this.mFetcherRef.get();
            if (r102 != null) goto L7;
            TTVideoEngineLog.i(MDLFetcher.TAG, "onStatusException but fetcher is null");
            return;
        L7:
            if (MDLFetcher.access$000(r102) == null) goto L10;
            MDLFetcher.access$000(r102).onCompletion(r100, MDLFetcher.access$100(r102), MDLFetcher.access$200(r102), null);
            return;
        }
    }

    @Override // com.ss.mediakit.fetcher.AVMDLURLFetcherInterface
    public void close() {
        VideoInfoFetcher r100 = this.mFetcher;
        if (r100 == null) goto L5;
        r100.cancel();
        this.mFetcher = null;
    L5:
        this.mNewUrls = null;
    }

    @Override // com.ss.mediakit.fetcher.AVMDLURLFetcherInterface
    public String[] getURLs() {
        String[] r100 = this.mNewUrls;
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r100.length <= 0) goto L10;
        TTVideoEngineLog.d(TAG, "get urls from cache. + urls.length = " + this.mNewUrls.length);
        return this.mNewUrls;
    L10:
        return null;
    }

    public static /* synthetic */ AVMDLURLFetcherListener access$000(MDLFetcher r100) {
        return r100.mListener;
    }

    public static /* synthetic */ String access$100(MDLFetcher r100) {
        return r100.mVideoID;
    }

    public static /* synthetic */ String access$200(MDLFetcher r100) {
        return r100.mFileHash;
    }

    public static /* synthetic */ String[] access$300(MDLFetcher r100) {
        return r100.mNewUrls;
    }

    public static /* synthetic */ String access$500(MDLFetcher r100) {
        return r100.mOldUrl;
    }

    private String[] _getUrlsFromVideoModelByFileHash(VideoModel r100, String r101) {
        if (r100 != null) goto L5;
    L17:
        TTVideoEngineLog.d(TAG, "_getUrlsFromVideoModel videoModel is null or fileHash is empty " + r101);
        return null;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L17;
        HashMap r102 = new HashMap();
        r102.put(15, r101);
        VideoInfo r103 = r100.getVideoInfo(r102);
        if (r103 == null) goto L15;
        String[] r104 = r103.getValueStrArr(16);
        TTVideoEngineLog.d(TAG, "_getUrlsFromVideoModel " + Arrays.toString(r104));
        if (r104 != null) goto L12;
    L14:
        return null;
    L12:
        if (r104.length <= 0) goto L14;
        return r104;
    L15:
        TTVideoEngineLog.d(TAG, "_getUrlsFromVideoModel videoInfo is null");
        return null;
    }

    public static /* synthetic */ String[] access$302(MDLFetcher r100, String[] r101) {
        r100.mNewUrls = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$600(String[] r100, String r101) {
        return isNewUrlsValid(r100, r101);
    }

    private static boolean isNewUrlsValid(String[] r100, String r101) {
        if (r100 != null) goto L5;
    L18:
        return false;
    L5:
        if (r100.length <= 0) goto L18;
        if (TextUtils.isEmpty(r101) == false) goto L10;
        return true;
    L10:
        int r102 = r100.length;
        int r103 = 0;
    L11:
        if (r103 >= r102) goto L17;
        if (TextUtils.equals(r100[r103], r101) == true) goto L14;
        r103 = r103 + 1;
        goto L11
    L14:
        TTVideoEngineLog.d(TAG, "new urls is invalid");
        return false;
    L17:
        return true;
    }

    public MDLFetcher(Context r100, String r101, String r102) {
        this.mNewUrls = null;
        this.mContext = r100;
        this.mFallbackAPI = TTVideoEngineUtils.BuildHttpsApi(r101);
        this.mKeyseed = r102;
    }

    public static /* synthetic */ String[] access$400(MDLFetcher r100, VideoModel r101, String r102) {
        return r100._getUrlsFromVideoModelByFileHash(r101, r102);
    }

    @Override // com.ss.mediakit.fetcher.AVMDLURLFetcherInterface
    public int start(String r100, String r101, String r102, AVMDLURLFetcherListener r110) {
        TTVideoEngineLog.i(TAG, "start rawKey " + r100 + ", fileKey " + r101 + ", olderUrl " + r102 + ", listener " + r110);
        this.mVideoID = r100;
        this.mFileHash = r101;
        this.mListener = r110;
        this.mOldUrl = r102;
        monitor-enter(MDLFetcher.class);
        VideoModelCache.VideoModelCacheInfo r111 = VideoModelCache.getInstance().get(this.mVideoID, this.mFallbackAPI);     // Catch: Throwable -> L41
        monitor-exit(MDLFetcher.class);     // Catch: Throwable -> L41
        if (r111 != null) goto L9;
    L36:
        VideoInfoFetcher r103 = new VideoInfoFetcher(this.mContext, null);
        this.mFetcher = r103;
        if (this.mContext == null) goto L39;
        r103.setUseVideoModelCache(true);
    L39:
        this.mFetcher.setVideoID(r100);
        this.mFetcher.setListener(new MyFetcherListener(this));
        this.mFetcher.setUseFallbakApi(Boolean.valueOf(!TextUtils.isEmpty(this.mFallbackAPI)));
        this.mFetcher.fetchInfo(this.mFallbackAPI, null, 0, this.mKeyseed);
        return 0;
    L9:
        if (r111.isExpired == true) goto L36;
        TTVideoEngineLog.i(TAG, String.format("get videoModel from cache,key is %s; videoId = %s", new Object[]{this.mFileHash, this.mVideoID}));
        String[] r112 = _getUrlsFromVideoModelByFileHash(r111.model, this.mFileHash);
        if (TextUtils.isEmpty(r102) == true) goto L22;
        if (r112 == null) goto L22;
        if (r112.length <= 0) goto L22;
        this.mNewUrls = r112;
        int r104 = 0;
    L17:
        if (r104 >= r112.length) goto L22;
        if (r112[r104].equals(r102) == true) goto L20;
        r104 = r104 + 1;
        goto L17
    L20:
        boolean r105 = false;
    L23:
        if (r105 == true) goto L25;
        this.mNewUrls = null;
        monitor-enter(MDLFetcher.class);
        VideoModelCache.getInstance().remove(this.mVideoID, this.mFallbackAPI);     // Catch: Throwable -> L33
        monitor-exit(MDLFetcher.class);     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        throw th;
    L25:
        if (this.mNewUrls == null) goto L36;
        TTVideoEngineLog.i(TAG, "start get urls from cache " + Arrays.toString(this.mNewUrls));
        return 1;
    L22:
        r105 = true;
    L41:
        th = move-exception;
        throw th;
    }
}
