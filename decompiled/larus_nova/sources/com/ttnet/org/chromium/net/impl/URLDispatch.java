package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.base.Log;
import com.ttnet.org.chromium.net.urlconnection.MessageLoop;
import java.io.IOException;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: loaded from: classes6.dex */
public class URLDispatch {
    public static final String KEY_EPOCH = "epoch";
    public static final String KEY_ETAG = "etag";
    public static final String KEY_FINAL_URL = "final_url";
    public static final String KEY_TTNET_ORIGIN_HOST = "ttnet_origin_host";
    private static final String TAG = null;
    private static final int TIME_OUT_MILLISECONDS = 300;
    private String mEpoch;
    private String mEtag;
    private String mFinalUrl;
    private MessageLoop mMessageLoop;
    private String mOriginalUrl;
    private String mTTNetOriginHost;

    static {
        TAG = "URLDispatch";
    }

    public void done() {
        this.mMessageLoop.quit();
    }

    public String getEpoch() {
        return this.mEpoch;
    }

    public String getEtag() {
        return this.mEtag;
    }

    public String getFinalUrl() {
        return this.mFinalUrl;
    }

    public String getOriginalUrl() {
        return this.mOriginalUrl;
    }

    public String getTTNetOriginHost() {
        return this.mTTNetOriginHost;
    }

    public URLDispatch(String r100) {
        this.mOriginalUrl = r100;
        this.mMessageLoop = new MessageLoop();
    }

    public void resume(Runnable r100) {
        this.mMessageLoop.execute(r100);     // Catch: RejectedExecutionException -> L4
        return;
    L4:
        e = move-exception;
        Log.e(TAG, "Exception URLDispatch resume ", new Object[]{e});
    }

    public void waitResult(int r100) throws IOException {
        MessageLoop r101 = this.mMessageLoop;
        if (r100 > 0) goto L6;
        r100 = 300;
    L6:
        r101.loop(r100);
    }

    public void setResult(String r100, String r101, String r102, String r103) {
        this.mFinalUrl = r100;
        this.mEtag = r101;
        this.mEpoch = r102;
        this.mTTNetOriginHost = r103;
    }
}
