package com.facebook.drawee.components;

/* JADX INFO: loaded from: classes23.dex */
public final class DraweeAsyncConfig {
    private static volatile boolean sAttachEnabled;
    private static volatile boolean sRequestEnabled;

    private DraweeAsyncConfig() {
    }

    public static boolean isAttachEnabled() {
        return sAttachEnabled;
    }

    public static boolean isRequestEnabled() {
        return sRequestEnabled;
    }

    public static void setAttachEnabled(boolean r100) {
        sAttachEnabled = r100;
    }

    public static void setRequestEnabled(boolean r100) {
        sRequestEnabled = r100;
    }
}
