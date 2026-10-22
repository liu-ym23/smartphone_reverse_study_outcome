package com.bytedance.common.jato.jit;

import com.bytedance.common.jato.JatoNativeLoader;

/* JADX INFO: loaded from: classes15.dex */
public class ProfileSaverOpt {
    public ProfileSaverOpt() {
    }

    public static native void disableInlineCache();

    public static native int disableProfileSave();

    public static native void enableInlineCache();

    public static native void profileSaveBackup();

    static {
        JatoNativeLoader.loadLibrary();
    }
}
