package com.ss.android.lark.cameraview;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class w0 implements z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w0 f411051a = null;

    static {
        f411051a = new w0();
    }

    public w0() {
    }

    @Override // com.ss.android.lark.cameraview.z0
    public final Matrix b(int r100) {
        return new Matrix();
    }

    @Override // com.ss.android.lark.cameraview.z0
    public final void a(Bitmap r100, int r101, e.f r102) {
        Intrinsics.checkNotNullParameter(r100, "finalBitmap");
        r102.a(r100);
    }
}
