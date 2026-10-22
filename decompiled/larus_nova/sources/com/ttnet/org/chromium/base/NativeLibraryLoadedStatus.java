package com.ttnet.org.chromium.base;

import com.ttnet.org.chromium.build.BuildConfig;

/* JADX INFO: loaded from: classes5.dex */
public class NativeLibraryLoadedStatus {
    private static NativeLibraryLoadedStatusProvider sProvider;

    /* JADX INFO: loaded from: classes6.dex */
    public interface NativeLibraryLoadedStatusProvider {
        boolean areMainDexNativeMethodsReady();

        boolean areNativeMethodsReady();
    }

    public NativeLibraryLoadedStatus() {
    }

    public static NativeLibraryLoadedStatusProvider getProviderForTesting() {
        return sProvider;
    }

    public static void checkLoaded(boolean r100) {
        if (BuildConfig.ENABLE_ASSERTS == true) goto L5;
        return;
    L5:
        NativeLibraryLoadedStatusProvider r101 = sProvider;
        if (r101 != null) goto L8;
        return;
    L8:
        if (r100 == false) goto L10;
        boolean r102 = r101.areMainDexNativeMethodsReady();
    L11:
        if (r102 == false) goto L14;
        return;
    L14:
        throw new JniException("Native method called before the native library was ready.");
    L10:
        r102 = r101.areNativeMethodsReady();
        goto L11
    }

    public static void setProvider(NativeLibraryLoadedStatusProvider r100) {
        sProvider = r100;
    }
}
