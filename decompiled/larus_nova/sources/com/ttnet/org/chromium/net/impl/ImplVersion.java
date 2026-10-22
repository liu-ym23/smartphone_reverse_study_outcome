package com.ttnet.org.chromium.net.impl;

/* JADX INFO: loaded from: classes.dex */
public class ImplVersion {
    private static final int API_LEVEL = 16;
    private static final String CRONET_VERSION = "107.0.5273.2";
    private static final String LAST_CHANGE = "c32625e60b30bd4e17ba51b4f29f7004a2c0a529";

    private ImplVersion() {
    }

    public static int getApiLevel() {
        return 16;
    }

    public static String getCronetVersion() {
        return CRONET_VERSION;
    }

    public static String getLastChange() {
        return LAST_CHANGE;
    }

    public static String getCronetVersionWithLastChange() {
        return "107.0.5273.2@c32625e6";
    }
}
