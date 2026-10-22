package com.mammon.audiosdk;

/* JADX INFO: loaded from: classes4.dex */
public class SAMICoreNativeLogCallback {
    private static volatile SAMICoreLogCallback userCallback;

    public SAMICoreNativeLogCallback() {
    }

    public static void setLogCallback(SAMICoreLogCallback r100) {
        userCallback = r100;
    }

    public static void onLogReceived(int r100, String r101) {
        SAMICoreLogCallback r102 = userCallback;
        if (r102 == null) goto L10;
        if (r101 == null) goto L11;
        r102.onHandle(r100, r101);     // Catch: Throwable -> L7
        return;
    L12:
        return;
    L11:
        return;
    }
}
