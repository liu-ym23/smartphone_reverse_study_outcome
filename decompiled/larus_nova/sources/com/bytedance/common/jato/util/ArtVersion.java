package com.bytedance.common.jato.util;

import com.bytedance.common.jato.JatoNativeLoader;

/* JADX INFO: loaded from: classes15.dex */
public class ArtVersion {
    public ArtVersion() {
    }

    public static native int getVersion();

    static {
        JatoNativeLoader.loadLibrary();
    }
}
