package com.obric.assistant.network.okhttp;

import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: classes4.dex */
public final class a {
    public static GlobalNetworkGate.Decision a(String r100, String r101) {
        return GlobalNetworkGate.a(r100, r101);
    }

    public static boolean c(String r100, String r101) {
        if (GlobalNetworkGate.a(r100, r101) == GlobalNetworkGate.Decision.ALLOW) goto L5;
        return true;
    L5:
        return false;
    }

    public static void b(GlobalNetworkGate.Decision r100, String r101, String r102) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100 != GlobalNetworkGate.Decision.ALLOW) goto L12;
        return;
    L12:
        GlobalNetworkGate.d(r100, r101, r102);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        FLogger.f375446a.e("NetSpyTracker", "report failed: " + th.getMessage());
    }
}
