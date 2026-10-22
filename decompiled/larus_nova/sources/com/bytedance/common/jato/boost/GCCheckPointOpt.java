package com.bytedance.common.jato.boost;

import com.bytedance.common.jato.JatoNativeLoader;

/* JADX INFO: loaded from: classes15.dex */
public class GCCheckPointOpt {
    public GCCheckPointOpt() {
    }

    public static native void SetDisableReclaimPhaseCheckPoint();

    public static native void SetDisableSharedModeCheckPoint();

    static {
        JatoNativeLoader.loadLibrary();
    }
}
