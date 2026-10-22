package com.ss.mediakit.net;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: loaded from: classes40.dex */
public class BaseDNS {
    private static final String TAG = "BaseDNS";
    protected boolean mCancelled;
    protected Handler mHandler;
    public String mHostname;
    public String mId;
    protected DNSCompletionListener mListener;
    protected AVMDLNetClient mNetClient;
    public int mTaskType;

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

    public void notifyError(AVMDLDNSInfo r100) {
        Message r101 = this.mHandler.obtainMessage(2, r100);
        this.mHandler.sendMessage(r101);
    }

    public void notifyRetry(Error r100) {
        Message r101 = this.mHandler.obtainMessage(1, r100);
        this.mHandler.sendMessage(r101);
    }

    public void notifySuccess(AVMDLDNSInfo r100) {
        Message r101 = this.mHandler.obtainMessage(3, r100);
        this.mHandler.sendMessage(r101);
    }

    public void setCompletionListener(DNSCompletionListener r100) {
        this.mListener = r100;
    }

    public BaseDNS(String r100, Handler r101, int r102) {
        this.mCancelled = false;
        this.mNetClient = null;
        this.mHostname = r100;
        this.mHandler = r101;
        this.mTaskType = r102;
        this.mId = Long.toString(System.nanoTime()) + Integer.toString(System.identityHashCode(this));
    }

    public BaseDNS(String r100, AVMDLNetClient r101, Handler r102, int r103) {
        this.mCancelled = false;
        this.mNetClient = null;
        this.mHostname = r100;
        this.mHandler = r102;
        if (r101 != null) goto L5;
        r101 = AVMDLDNSParser.getNetClient();
    L5:
        this.mNetClient = r101;
        this.mTaskType = r103;
        this.mId = Long.toString(System.nanoTime()) + Integer.toString(System.identityHashCode(this));
    }
}
