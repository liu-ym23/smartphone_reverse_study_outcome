package com.facebook.imagepipeline.nativecode;

import com.facebook.imageutils.FrescoSoLoader;

/* JADX INFO: loaded from: classes23.dex */
public class NativeFiltersLoader {
    public NativeFiltersLoader() {
    }

    public static void load() {
        FrescoSoLoader.loadLibrary("native-filters");
    }
}
