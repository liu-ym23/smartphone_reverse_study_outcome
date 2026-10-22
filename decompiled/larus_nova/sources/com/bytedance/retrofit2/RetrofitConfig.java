package com.bytedance.retrofit2;

/* JADX INFO: loaded from: classes3.dex */
public class RetrofitConfig {
    private static boolean loadServiceMethodOpt;

    public RetrofitConfig() {
    }

    public static void enableLoadServiceMethodOpt() {
        loadServiceMethodOpt = true;
    }

    public static boolean isLoadServiceMethodOptOpen() {
        return loadServiceMethodOpt;
    }
}
