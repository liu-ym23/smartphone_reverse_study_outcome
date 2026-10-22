package com.bytedance.common.jato.views;

/* JADX INFO: loaded from: classes15.dex */
public class ViewOpt {
    private static boolean sIsDebug = false;
    private static boolean sIsDispatchGlobalLayout = true;
    private static boolean sIsStrictMode;

    public static boolean isDebug() {
        return sIsDebug;
    }

    public static boolean isDispatchGlobalLayout() {
        return sIsDispatchGlobalLayout;
    }

    public static boolean isIsStrictMode() {
        return sIsStrictMode;
    }
}
