package com.bytedance.common.jato.boost;

import com.bytedance.common.jato.JatoNativeLoader;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;

/* JADX INFO: loaded from: classes15.dex */
public class TextureOpt {
    public TextureOpt() {
    }

    private static native int nativeUnblockJNISurfaceTexture();

    public static int unblockJNISurfaceTexture() {
        if (JatoNativeLoader.loadLibrary() == true) goto L7;
        return -1;
    L7:
        if (new PolarisFileWrapper("/data/local/tmp/disable_sf_opt").exists() == false) goto L11;
        return 0;
    L11:
        return nativeUnblockJNISurfaceTexture();
    }
}
