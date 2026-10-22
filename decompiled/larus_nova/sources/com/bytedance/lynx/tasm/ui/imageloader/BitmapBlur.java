package com.bytedance.lynx.tasm.ui.imageloader;

import android.graphics.Bitmap;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public class BitmapBlur {
    public BitmapBlur() {
    }

    public static native void nativeBlur(Bitmap r100, int r101);

    static {
        Intrinsics.checkNotNullParameter("lynx-imageloader", "libName");
        FLogger r100 = FLogger.f375446a;
        r100.i("Librarian_loadLib", "loadLibrary start libName -> lynx-imageloader");
        com.bytedance.librarian.a.c("lynx-imageloader");
        r100.i("Librarian_loadLib", "loadLibrary success by librarian -> lynx-imageloader");
    }
}
