package com.bytedance.lynx.webview.glue.sdk112;

import com.bytedance.lynx.webview.glue.sdk111.IGlueToSdk111;
import com.bytedance.lynx.webview.internal.TTWebContext;
import l17.k;

/* JADX INFO: loaded from: classes21.dex */
public abstract class IGlueToSdk112 extends IGlueToSdk111 {
    public static void onEffectiveConnectionTypeChanged(int r100) {
    }

    public static void onRTTOrThroughputEstimatesComputed(long r100, long r101, int r102) {
    }

    public static String getIsolateDirectorySuffix() {
        return TTWebContext.i();
    }

    public static boolean hasInitializeNative() {
        return TTWebContext.h().f265222h.get();
    }

    public static boolean setInitializeNative() {
        TTWebContext.h().f265222h.set(true);
        return true;
    }

    public IGlueToSdk112() {
    }

    public static boolean isEnableSelectMenu(boolean r100) {
        return TTWebContext.f265207s;
    }

    public static void LogD(String r100, String r101) {
        k.a(new String[]{r100, r101});
    }

    public static void LogE(String r100, String r101) {
        k.b(new String[]{r100, r101});
    }

    public static void LogI(String r100, String r101) {
        k.d(new String[]{r100, r101});
    }
}
