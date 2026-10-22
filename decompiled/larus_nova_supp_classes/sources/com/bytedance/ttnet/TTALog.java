package com.bytedance.ttnet;

import com.bytedance.frameworks.baselib.network.http.cronet.impl.SsCronetHttpClient;
import com.ss.android.agilelogger.ALog;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class TTALog {
    private static final String TAG = "TTNET_ALog";
    private static volatile long sALogFuncAddr;

    public TTALog() {
    }

    public static /* synthetic */ void a(long r0) {
        lambda$ensureALogInitialized$0(r0);
    }

    private static void ensureALogInitialized() {
        sALogFuncAddr = ALog.getALogWriteFuncAddr();
        if (sALogFuncAddr != 0) goto L6;
        ALog.addNativeFuncAddrCallback(new a());
        return;
    }

    private static SsCronetHttpClient getCronetHttpClient() throws Exception {
        if (HttpClient.isCronetClientEnable() == true) goto L5;
        return null;
    L5:
        return SsCronetHttpClient.inst(TTNetInit.getTTNetDepend().getContext());
    }

    public static long getALogFuncAddr() {
        return sALogFuncAddr;
    }

    public static void init() {
        ensureALogInitialized();
    }

    private static /* synthetic */ void lambda$ensureALogInitialized$0(long r5) {
        if (sALogFuncAddr == 0) goto L6;
        return;
    L6:
        if (r5 != 0) goto L8;
        return;
    L8:
        sALogFuncAddr = r5;
        SsCronetHttpClient r6 = getCronetHttpClient();     // Catch: Exception -> L13
        if (r6 == null) goto L18;
        r6.setAlogFuncAddr(sALogFuncAddr);     // Catch: Exception -> L13
        return;
    L18:
        return;
    L13:
        e = move-exception;
        e.printStackTrace();
    }
}
