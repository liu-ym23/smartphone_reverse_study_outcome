package com.ss.android.lark.cameraview;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class a implements z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f410856a = null;

    static {
        f410856a = new a();
    }

    public a() {
    }

    @Override // com.ss.android.lark.cameraview.z0
    public final Matrix b(int r100) {
        Matrix r101 = new Matrix();
        r101.setRotate(r100);
        return r101;
    }

    @Override // com.ss.android.lark.cameraview.z0
    public final void a(Bitmap r100, int r101, e.f r102) {
        Intrinsics.checkNotNullParameter(r100, "finalBitmap");
        if (r101 != 90) goto L5;
    L7:
        r102.a(r100);
        return;
    L5:
        if (r101 == 270) goto L7;
        r102.a(r100);
    }
}
