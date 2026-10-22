package com.bytedance.dora.utils;

import com.bytedance.librarian.a;
import com.larus.media.MediaScene;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class OPUtils {
    public OPUtils() {
    }

    public static native synchronized void OPE_destroy();

    public static native synchronized byte[] OPE_encode(byte[] r100, int r101, int r102);

    public static native synchronized void OPE_init(int r100, int r101);

    static {
        Intrinsics.checkNotNullParameter(MediaScene.DORA, "libName");
        FLogger r100 = FLogger.f375446a;
        r100.i("Librarian_loadLib", "loadLibrary start libName -> dora");
        a.c(MediaScene.DORA);
        r100.i("Librarian_loadLib", "loadLibrary success by librarian -> dora");
    }
}
