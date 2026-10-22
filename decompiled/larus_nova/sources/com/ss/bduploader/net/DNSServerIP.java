package com.ss.bduploader.net;

/* JADX INFO: loaded from: classes40.dex */
public class DNSServerIP {
    private static final String TAG = "DNSServerIP";
    private static final int UPDATE_PEROID = 300000;
    private static volatile String mServerIP;
    private static volatile long mServerIPTime;

    public DNSServerIP() {
    }

    public static String getDNSServerIP() {
        updateDNSServerIP();
        return mServerIP;
    }

    public static void updateDNSServerIP() {
        if ((System.currentTimeMillis() - mServerIPTime) >= 300000) goto L5;
        return;
    L5:
        BDUploadThreadPool.addExecuteTask(new AnonymousClass1());
    }

    public static /* synthetic */ String access$002(String r100) {
        mServerIP = r100;
        return r100;
    }

    public static /* synthetic */ long access$102(long r100) {
        mServerIPTime = r100;
        return r100;
    }
}
