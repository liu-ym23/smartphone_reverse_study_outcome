package com.ss.ttvideoengine.net;

import android.os.Handler;
import android.os.Message;
import com.ss.ttvideoengine.utils.Error;
import com.ss.ttvideoengine.utils.TTHelper;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class BaseDNS {
    private static final int MSG_IS_CANCELLED = 0;
    private static final int MSG_IS_ERROR = 2;
    private static final int MSG_IS_RETRY = 1;
    private static final int MSG_IS_SUCCESS = 3;
    protected boolean mCancelled;
    protected Handler mHandler;
    protected String mHostname;
    protected DNSCompletionListener mListener;
    protected TTVNetClient mNetClient;

    public static class MyHandler extends Handler {
        private final WeakReference<BaseDNS> mDNSRef;

        public MyHandler(BaseDNS r100) {
            super(TTHelper.getLooper());
            this.mDNSRef = new WeakReference(r100);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r100) {
            BaseDNS r101 = this.mDNSRef.get();
            if (r101 != null) goto L5;
            return;
        L5:
            DNSCompletionListener r102 = r101.mListener;
            if (r102 != null) goto L9;
            return;
        L9:
            if (r101.mCancelled == false) goto L11;
            return;
        L11:
            int r103 = r100.what;
            if (r103 != 0) goto L14;
            r102.onCancelled();
            return;
        L14:
            if (r103 != 1) goto L16;
            r101.close();
            r102.onRetry((Error) r100.obj);
            return;
        L16:
            if (r103 != 2) goto L18;
            r101.close();
            r102.onCompletion(null, (Error) r100.obj);
            return;
        L18:
            if (r103 != 3) goto L28;
            r101.close();
            r102.onCompletion((JSONObject) r100.obj, null);
            return;
        }
    }

    public void cancel() {
    }

    public void close() {
    }

    public void start() {
    }

    public void notifyCancelled() {
        this.mHandler.sendEmptyMessage(0);
    }

    public BaseDNS(String r100) {
        this.mCancelled = false;
        this.mNetClient = null;
        this.mHostname = r100;
        this.mHandler = new MyHandler(this);
    }

    public void notifyError(Error r100) {
        Message r101 = this.mHandler.obtainMessage(2, r100);
        this.mHandler.sendMessage(r101);
    }

    public void notifyRetry(Error r100) {
        Message r101 = this.mHandler.obtainMessage(1, r100);
        this.mHandler.sendMessage(r101);
    }

    public void notifySuccess(JSONObject r100) {
        Message r101 = this.mHandler.obtainMessage(3, r100);
        this.mHandler.sendMessage(r101);
    }

    public void setCompletionListener(DNSCompletionListener r100) {
        this.mListener = r100;
    }

    public BaseDNS(String r100, TTVNetClient r101) {
        this.mCancelled = false;
        this.mNetClient = null;
        this.mHostname = r100;
        this.mHandler = new MyHandler(this);
        if (r101 != null) goto L5;
        r101 = new TTHTTPNetwork();
    L5:
        this.mNetClient = r101;
    }
}
