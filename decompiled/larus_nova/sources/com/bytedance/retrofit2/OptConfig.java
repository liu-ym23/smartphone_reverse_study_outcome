package com.bytedance.retrofit2;

/* JADX INFO: loaded from: classes3.dex */
public class OptConfig {
    private static volatile boolean sEnableRequestOpt;

    public OptConfig() {
    }

    public static boolean isEnableRequestOpt() {
        return sEnableRequestOpt;
    }

    public static void setEnableRequestOpt(boolean r100) {
        sEnableRequestOpt = r100;
    }
}
