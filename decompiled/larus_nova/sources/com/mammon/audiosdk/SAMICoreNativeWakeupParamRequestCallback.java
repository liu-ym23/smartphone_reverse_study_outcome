package com.mammon.audiosdk;

/* JADX INFO: loaded from: classes4.dex */
public class SAMICoreNativeWakeupParamRequestCallback {
    private static SAMICoreWakeupParamRequestCallback userCallback;

    public SAMICoreNativeWakeupParamRequestCallback() {
    }

    public static void setWakeupParamRequestCallback(SAMICoreWakeupParamRequestCallback r100) {
        userCallback = r100;
    }

    public static String onWakeupParamRequest(String r100, int r101) {
        SAMICoreWakeupParamRequestCallback r102 = userCallback;
        if (r102 != null) goto L5;
        return "";
    L5:
        return r102.onWakeupParamRequest(r100, r101);
    }
}
