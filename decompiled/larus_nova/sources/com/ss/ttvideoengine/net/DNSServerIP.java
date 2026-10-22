package com.ss.ttvideoengine.net;

import android.os.SystemClock;
import com.ss.ttvideoengine.utils.EngineThreadPool;

/* JADX INFO: loaded from: classes34.dex */
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
        if ((SystemClock.elapsedRealtime() - mServerIPTime) >= 300000) goto L5;
        return;
    L5:
        EngineThreadPool.addExecuteTask(new AnonymousClass1());
    }

    public static /* synthetic */ String access$000() {
        return mServerIP;
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
