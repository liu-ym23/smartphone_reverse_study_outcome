package com.ss.bduploader.net;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: loaded from: classes40.dex */
public class BaseDNS {
    private static final int MSG_IS_CANCELLED = 0;
    private static final int MSG_IS_ERROR = 2;
    private static final int MSG_IS_RETRY = 1;
    private static final int MSG_IS_SUCCESS = 3;
    private static final String TAG = "BaseDNS";
    protected boolean mCancelled;
    protected Handler mHandler;
    public String mHostname;
    public String mId;
    protected DNSCompletionListener mListener;
    protected BDVNetClient mNetClient;

    public void cancel() {
    }

    public void close() {
    }

    public boolean isRunning() {
        return true;
    }

    public void start() {
    }

    public void notifyCancelled() {
        this.mHandler.sendEmptyMessage(0);
    }

    public void notifyError(BDUploadDNSInfo r100) {
        Message r101 = this.mHandler.obtainMessage(2, r100);
        this.mHandler.sendMessage(r101);
    }

    public void notifyRetry(Error r100) {
        Message r101 = this.mHandler.obtainMessage(1, r100);
        this.mHandler.sendMessage(r101);
    }

    public void notifySuccess(BDUploadDNSInfo r100) {
        Message r101 = this.mHandler.obtainMessage(3, r100);
        this.mHandler.sendMessage(r101);
    }

    public void setCompletionListener(DNSCompletionListener r100) {
        this.mListener = r100;
    }

    public BaseDNS(String r100, Handler r101) {
        this.mCancelled = false;
        this.mNetClient = null;
        this.mHostname = r100;
        this.mHandler = r101;
        this.mId = Long.toString(System.nanoTime()) + Integer.toString(System.identityHashCode(this));
    }

    public BaseDNS(String r100, BDVNetClient r101, Handler r102) {
        this.mCancelled = false;
        this.mNetClient = null;
        this.mHostname = r100;
        this.mHandler = r102;
        if (r101 != null) goto L5;
        r101 = new BDHTTPNetwork();
    L5:
        this.mNetClient = r101;
        this.mId = Long.toString(System.nanoTime()) + Integer.toString(System.identityHashCode(this));
    }
}
