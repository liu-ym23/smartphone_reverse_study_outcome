package com.ss.ttvideoengine.fetcher;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.ss.ttvideoengine.net.ChannelSelect;
import com.ss.ttvideoengine.net.TTHTTPNetwork;
import com.ss.ttvideoengine.net.TTVNetClient;
import com.ss.ttvideoengine.utils.Error;
import com.ss.ttvideoengine.utils.TTHelper;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class SubInfoFetcher {
    private static final String KEY_CODE = "code";
    private static final String KEY_LOGID = "trace_id";
    private static final String KEY_MESSAGE = "message";
    private static final int MSG_IS_ERROR = 1;
    private static final int MSG_IS_SUCCESS = 2;
    private static final String TAG = "SubInfoFetcher";
    private boolean mCancelled;
    private Context mContext;
    private int mErrorCode;
    private Handler mHandler;
    private String mHost;
    private FetcherListener mListener;
    private int mMaxRetryCount;
    private TTVNetClient mNetworkSession;
    private int mRetryIndex;
    private String mSubApiString;
    private ArrayList<String> mTriedHost;

    public interface FetcherListener {
        void onCompletion(String r100, Error r101);

        void onLog(String r100);
    }

    public static class MyHandler extends Handler {
        private final WeakReference<SubInfoFetcher> mFetcherRef;

        @Override // android.os.Handler
        public void handleMessage(Message r100) {
            SubInfoFetcher r101 = this.mFetcherRef.get();
            if (r101 != null) goto L5;
            return;
        L5:
            FetcherListener r102 = SubInfoFetcher.access$000(r101);
            if (r102 != null) goto L9;
            return;
        L9:
            if (SubInfoFetcher.access$100(r101) == false) goto L12;
            r102.onLog("fetcher is cancelled");
            return;
        L12:
            int r103 = r100.what;
            if (r103 != 1) goto L15;
            r102.onCompletion(null, (Error) r100.obj);
            return;
        L15:
            if (r103 != 2) goto L21;
            r102.onCompletion((String) r100.obj, null);
            return;
        }

        public MyHandler(SubInfoFetcher r100, Looper r101) {
            super(r101);
            this.mFetcherRef = new WeakReference(r100);
        }
    }

    public String _extractFields(JSONObject r100) {
        return "";
    }

    public void cancel() {
        monitor-enter(this);
        this.mHandler.removeCallbacksAndMessages(null);     // Catch: Throwable -> L14
        FetcherListener r100 = this.mListener;     // Catch: Throwable -> L14
        if (r100 != null) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L14
        return;
    L7:
        r100.onLog("fetcher cancelled");     // Catch: Throwable -> L14
        if (this.mCancelled == false) goto L11;
        monitor-exit(this);     // Catch: Throwable -> L14
        return;
    L11:
        this.mCancelled = true;     // Catch: Throwable -> L14
        this.mNetworkSession.cancel();     // Catch: Throwable -> L14
        monitor-exit(this);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }

    private void _fetchInfoInternal() {
        if (TextUtils.isEmpty(this.mSubApiString) == false) goto L6;
        _notifyError(new Error(Error.SubFetchingInfo, Error.SubParameterNull, "sub ApiString empty"));
        return;
    L6:
        _beginToFetch(this.mSubApiString);
    }

    private boolean _isTriedAllHost() {
        if (this.mTriedHost != null) goto L5;
        return false;
    L5:
        List r100 = ChannelSelect.getInstance().groupByApiVersionLocked(4);
        if (r100 != null) goto L8;
        return false;
    L8:
        if (r100.size() == this.mTriedHost.size()) goto L10;
        return false;
    L10:
        return true;
    }

    private void _beginToFetch(String r100) {
        this.mNetworkSession.startTask(r100, new AnonymousClass1(this));
    }

    private void _getInfoSuccess(JSONObject r100) {
        monitor-enter(this);
    L23:
        th = move-exception;
        throw th;
    L5:
        if (this.mCancelled == true) goto L21;
        if (r100 == null) goto L21;
        TTVideoEngineLog.d(TAG, "sub jsonObject:" + r100.toString());     // Catch: Throwable -> L23
        int r101 = r100.optInt("code");     // Catch: Throwable -> L23
        String r102 = r100.optString("message");     // Catch: Throwable -> L23
        String r103 = r100.optString("trace_id");     // Catch: Throwable -> L23
        if (r101 == 200) goto L13;
        Error r104 = new Error(Error.SubFetchingInfo, Error.SubInvalidVideoInfoRequest, r101, r102);     // Catch: Throwable -> L23
        r104.parameters.put("log_id", r103);     // Catch: Throwable -> L23
        _notifyError(r104);     // Catch: Throwable -> L23
        monitor-exit(this);     // Catch: Throwable -> L23
        return;
    L13:
        JSONObject r105 = r100.optJSONObject("data");     // Catch: Throwable -> L23
        if (r105 != null) goto L18;
        _notifyError(new Error(Error.SubFetchingInfo, Error.SubResultEmpty, "sub fetched info Result is empty"));     // Catch: Throwable -> L23
        monitor-exit(this);     // Catch: Throwable -> L23
        return;
    L18:
        _notifySuccess(r105.toString());     // Catch: Throwable -> L23
        monitor-exit(this);     // Catch: Throwable -> L23
        return;
    L21:
        monitor-exit(this);     // Catch: Throwable -> L23
    }

    private void _notifyError(Error r100) {
        Message r101 = this.mHandler.obtainMessage(1, r100);
        this.mHandler.sendMessage(r101);
    }

    private void _notifySuccess(String r100) {
        Message r101 = this.mHandler.obtainMessage(2, r100);
        this.mHandler.sendMessage(r101);
    }

    private void _retryIfNeeded(Error r100) {
        TTVideoEngineLog.i(TAG, "_retryIfNeeded error " + r100);
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.mCancelled == false) goto L8;
        monitor-exit(this);     // Catch: Throwable -> L14
        return;
    L8:
        int r101 = this.mRetryIndex;     // Catch: Throwable -> L14
        if (r101 >= this.mMaxRetryCount) goto L11;
        this.mRetryIndex = r101 + 1;     // Catch: Throwable -> L14
        _fetchInfoInternal();     // Catch: Throwable -> L14
    L12:
        monitor-exit(this);     // Catch: Throwable -> L14
        return;
    L11:
        r100.description += ("<apiStr:" + this.mSubApiString + ">");     // Catch: Throwable -> L14
        _notifyError(r100);     // Catch: Throwable -> L14
        goto L12
    }

    public static /* synthetic */ FetcherListener access$000(SubInfoFetcher r100) {
        return r100.mListener;
    }

    public static /* synthetic */ boolean access$100(SubInfoFetcher r100) {
        return r100.mCancelled;
    }

    public void fetchInfo(String r100) {
        this.mSubApiString = r100;
        this.mHost = new URL(r100).getHost();     // Catch: MalformedURLException -> L5
    L7:
        _fetchInfoInternal();
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public void setListener(FetcherListener r100) {
        this.mListener = r100;
    }

    public SubInfoFetcher(Context r100, TTVNetClient r101) {
        this.mCancelled = false;
        this.mSubApiString = "";
        this.mErrorCode = -1;
        this.mRetryIndex = 0;
        this.mMaxRetryCount = 1;
        this.mContext = r100;
        this.mHandler = new MyHandler(this, TTHelper.getLooper());
        if (r101 != null) goto L5;
        this.mNetworkSession = new TTHTTPNetwork();
        return;
    L5:
        this.mNetworkSession = r101;
    }

    public static /* synthetic */ int access$202(SubInfoFetcher r100, int r101) {
        r100.mErrorCode = r101;
        return r101;
    }

    public static /* synthetic */ void access$300(SubInfoFetcher r100, JSONObject r101) {
        r100._getInfoSuccess(r101);
    }

    public static /* synthetic */ void access$400(SubInfoFetcher r100, Error r101) {
        r100._notifyError(r101);
    }
}
