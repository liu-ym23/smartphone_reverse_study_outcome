package com.bytedance.ee.bear.screenshot;

import android.graphics.Bitmap;
import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.vfs.VFSPath;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public class FastPngEncoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f236821a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f236822b;

    private native long nativeDestroy(long r100);

    private native long nativeInit(String r100, int r101, int r102, int r103, int r104, int r105);

    private static native boolean nativeIsBitmapAnyLineBlackOrWhite(Bitmap r100);

    private native void nativeWriteBitmap(long r100, Bitmap r101, int r102, int r103, boolean r104);

    static {
        Intrinsics.checkNotNullParameter("fastpngencoder", "libName");
        FLogger r100 = FLogger.f375446a;
        r100.i("Librarian_loadLib", "loadLibrary start libName -> fastpngencoder");
        a.c("fastpngencoder");
        r100.i("Librarian_loadLib", "loadLibrary success by librarian -> fastpngencoder");
    }

    public final void a() {
        if (this.f236822b == false) goto L5;
        return;
    L5:
        this.f236822b = true;
        this.f236821a = nativeDestroy(this.f236821a);
    }

    public static boolean b(Bitmap r100) {
        return nativeIsBitmapAnyLineBlackOrWhite(r100);
    }

    public final void c(Bitmap r110) {
        if (this.f236822b == true) goto L18;
        Bitmap.Config r100 = r110.getConfig();
        tt5.a.h("FastPngEncoder", "writeBitmap config:" + r100);
        Bitmap.Config r101 = r110.getConfig();
        if (r101 != Bitmap.Config.ARGB_8888) goto L7;
    L11:
        boolean r102 = false;
    L12:
        if (r102 == true) goto L16;
        nativeWriteBitmap(this.f236821a, r110, 0, r110.getHeight(), false);
        return;
    L16:
        throw new IllegalStateException("writeBitmap bitmapType not Support FastPng:" + r100);
    L7:
        if (r101 == Bitmap.Config.ARGB_4444) goto L11;
        if (r101 == Bitmap.Config.RGB_565) goto L11;
        r102 = true;
        goto L12
    L18:
        throw new IllegalStateException("Native instance is destroyed!");
    }

    public FastPngEncoder(VFSPath r100, int r110, int r111) {
        this.f236822b = false;
        if (r100 == null) goto L6;
        this.f236821a = nativeInit(r100.getRealPath(), r110, r111, 3, 8, 0);
        return;
    }

    public final void d(Bitmap r110, int r111, int r112) {
        if (this.f236822b == true) goto L18;
        Bitmap.Config r100 = r110.getConfig();
        tt5.a.h("FastPngEncoder", "writeLastBitmap config:" + r100);
        if (r100 != Bitmap.Config.ARGB_8888) goto L7;
    L11:
        boolean r101 = false;
    L12:
        if (r101 == true) goto L16;
        nativeWriteBitmap(this.f236821a, r110, r111, r112, true);
        a();
        return;
    L16:
        throw new IllegalStateException("writeLastBitmap Bitmap Type not Support FastPng:" + r100);
    L7:
        if (r100 == Bitmap.Config.ARGB_4444) goto L11;
        if (r100 == Bitmap.Config.RGB_565) goto L11;
        r101 = true;
        goto L12
    L18:
        throw new IllegalStateException("Native instance is destroyed!");
    }
}
