package com.facebook.soloader;

import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
class MergedSoMapping {
    public MergedSoMapping() {
    }

    @Nullable
    public static String mapLibName(String r100) {
        return null;
    }

    public static void invokeJniOnload(String r100) {
        throw new IllegalArgumentException("Unknown library: " + r100);
    }
}
