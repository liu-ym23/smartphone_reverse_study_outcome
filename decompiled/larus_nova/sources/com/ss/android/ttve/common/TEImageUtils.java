package com.ss.android.ttve.common;

import com.ss.android.ttve.model.VEFrame;
import com.ss.android.ttve.nativePort.TECodecNativeLibsLoader;

/* JADX INFO: loaded from: classes38.dex */
public class TEImageUtils {
    public TEImageUtils() {
    }

    private static native int nativeConvertFrame(VEFrame r100, VEFrame r101, int r102);

    static {
        TECodecNativeLibsLoader.d();
    }

    public static void a(VEFrame r100, VEFrame r101, VEFrame.Operation r102) {
        nativeConvertFrame(r100, r101, r102.ordinal());
    }
}
