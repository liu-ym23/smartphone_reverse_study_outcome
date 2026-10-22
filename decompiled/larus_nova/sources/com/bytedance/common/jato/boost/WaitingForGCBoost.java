package com.bytedance.common.jato.boost;

import com.bytedance.common.jato.JatoNativeLoader;
import com.bytedance.common.jato.JatoXL;

/* JADX INFO: loaded from: classes15.dex */
public class WaitingForGCBoost {
    public WaitingForGCBoost() {
    }

    private static native boolean nBoost(int r100);

    private static native boolean nUnboost();

    public static boolean unboost() {
        if (JatoXL.isInited() == true) goto L5;
        return false;
    L5:
        if (JatoNativeLoader.isLoaded() == true) goto L8;
        return false;
    L8:
        return nUnboost();
    }

    public static boolean boost(int r100) {
        if (JatoXL.isInited() == true) goto L5;
        return false;
    L5:
        if (JatoNativeLoader.isLoaded() == true) goto L8;
        return false;
    L8:
        return nBoost(r100);
    }
}
