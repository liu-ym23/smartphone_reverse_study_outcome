package com.bytedance.ee.bear.screenshot;

import android.graphics.Bitmap;
import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.vfs.VFSPath;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class FastPngEncoder {
    public long a;
    public boolean b;

    private native long nativeDestroy(long r1);

    private native long nativeInit(String r1, int r2, int r3, int r4, int r5, int r6);

    private static native boolean nativeIsBitmapAnyLineBlackOrWhite(Bitmap r0);

    private native void nativeWriteBitmap(long r1, Bitmap r3, int r4, int r5, boolean r6);

    static {
        Intrinsics.checkNotNullParameter("fastpngencoder", "libName");
        FLogger r0 = FLogger.a;
        r0.i("Librarian_loadLib", "loadLibrary start libName -> fastpngencoder");
        a.c("fastpngencoder");
        r0.i("Librarian_loadLib", "loadLibrary success by librarian -> fastpngencoder");
    }

    public final void a() {
        if (this.b == false) goto L5;
        return;
    L5:
        this.b = true;
        this.a = nativeDestroy(this.a);
    }

    public static boolean b(Bitmap r0) {
        return nativeIsBitmapAnyLineBlackOrWhite(r0);
    }

    public final void c(Bitmap r10) {
        if (this.b == true) goto L18;
        Bitmap.Config r0 = r10.getConfig();
        tt5.a.h("FastPngEncoder", "writeBitmap config:" + r0);
        Bitmap.Config r1 = r10.getConfig();
        if (r1 != Bitmap.Config.ARGB_8888) goto L7;
    L11:
        boolean r2 = false;
    L12:
        if (r2 == true) goto L16;
        nativeWriteBitmap(this.a, r10, 0, r10.getHeight(), false);
        return;
    L16:
        throw new IllegalStateException("writeBitmap bitmapType not Support FastPng:" + r0);
    L7:
        if (r1 == Bitmap.Config.ARGB_4444) goto L11;
        if (r1 == Bitmap.Config.RGB_565) goto L11;
        r2 = true;
        goto L12
    L18:
        throw new IllegalStateException("Native instance is destroyed!");
    }

    public FastPngEncoder(VFSPath r9, int r10, int r11) {
        this.b = false;
        if (r9 == null) goto L6;
        this.a = nativeInit(r9.getRealPath(), r10, r11, 3, 8, 0);
        return;
    }

    public final void d(Bitmap r10, int r11, int r12) {
        if (this.b == true) goto L18;
        Bitmap.Config r0 = r10.getConfig();
        tt5.a.h("FastPngEncoder", "writeLastBitmap config:" + r0);
        if (r0 != Bitmap.Config.ARGB_8888) goto L7;
    L11:
        boolean r1 = false;
    L12:
        if (r1 == true) goto L16;
        nativeWriteBitmap(this.a, r10, r11, r12, true);
        a();
        return;
    L16:
        throw new IllegalStateException("writeLastBitmap Bitmap Type not Support FastPng:" + r0);
    L7:
        if (r0 == Bitmap.Config.ARGB_4444) goto L11;
        if (r0 == Bitmap.Config.RGB_565) goto L11;
        r1 = true;
        goto L12
    L18:
        throw new IllegalStateException("Native instance is destroyed!");
    }
}
