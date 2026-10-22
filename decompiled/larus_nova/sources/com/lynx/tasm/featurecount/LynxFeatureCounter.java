package com.lynx.tasm.featurecount;

import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxEnvKey;

/* JADX INFO: loaded from: classes32.dex */
public class LynxFeatureCounter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f383335a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f383336b;

    public LynxFeatureCounter() {
    }

    public static native void nativeFeatureCount(int r100, int r101);

    static {
        f383336b = LynxEnv.getBooleanFromExternalEnv(LynxEnvKey.ENABLE_FEATURE_COUNTER, false);
    }

    public static void a(int r100, int r101) {
        if (f383336b == true) goto L6;
        return;
    L6:
        if (f383335a == true) goto L9;
        f383335a = LynxEnv.inst().isNativeLibraryLoaded();
    L9:
        if (f383335a == false) goto L12;
        nativeFeatureCount(r100, r101);
        return;
    }
}
