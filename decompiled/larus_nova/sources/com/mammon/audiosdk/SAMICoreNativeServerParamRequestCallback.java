package com.mammon.audiosdk;

/* JADX INFO: loaded from: classes4.dex */
public class SAMICoreNativeServerParamRequestCallback {
    private static SAMICoreServerParamRequestCallback userCallback;

    public SAMICoreNativeServerParamRequestCallback() {
    }

    public static void setServerParamRequestCallback(SAMICoreServerParamRequestCallback r100) {
        userCallback = r100;
    }

    public static String onServerParamRequest(String r100, int r101) {
        SAMICoreServerParamRequestCallback r102 = userCallback;
        if (r102 != null) goto L5;
        return "";
    L5:
        return r102.onServerParamRequest(r100, r101);
    }
}
