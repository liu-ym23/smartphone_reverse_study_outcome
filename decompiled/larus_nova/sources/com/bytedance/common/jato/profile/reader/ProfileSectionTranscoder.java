package com.bytedance.common.jato.profile.reader;

import com.bytedance.common.jato.JatoNativeLoader;
import java.util.HashMap;

/* JADX INFO: loaded from: classes15.dex */
public class ProfileSectionTranscoder {
    private static HashMap<String, Long> mDexFileCookies;
    public static volatile boolean mIsInited;

    public ProfileSectionTranscoder() {
    }

    private static native String nativePrettyClass(long r100, int r101);

    private static native String nativePrettyMethod(long r100, int r101, boolean r102);

    static {
        JatoNativeLoader.loadLibrary();
        mIsInited = false;
        mDexFileCookies = null;
    }
}
