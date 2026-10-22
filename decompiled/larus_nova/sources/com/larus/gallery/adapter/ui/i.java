package com.larus.gallery.adapter.ui;

import android.graphics.Matrix;
import android.graphics.Rect;
import com.facebook.drawee.drawable.ScalingUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class i implements ScalingUtils.ScaleType {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f343774e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f343775f;

    public i() {
        this(0);
    }

    public i(int r100) {
        this.f343774e = r100;
    }

    @Override // com.facebook.drawee.drawable.ScalingUtils.ScaleType
    public final Matrix getTransform(Matrix r100, Rect r101, int r102, int r103, float r104, float r110) {
        Intrinsics.checkNotNullParameter(r100, "outTransform");
        Intrinsics.checkNotNullParameter(r101, "parentBounds");
        float r105 = r102;
        float r106 = r101.width() / r105;
        float r107 = r103;
        float r111 = r101.height() / r107;
        float r108 = Math.min(r106, r111);
        float r109 = r101.left + ((r101.width() - (r105 * r108)) * 0.5f);
        float r112 = r107 * r108;
        float r113 = r101.top + ((r101.height() - r112) * 0.5f);
        if (r106 >= r111) goto L5;
        r113 = r113 + (Math.min(this.f343774e, (r101.height() - r112) * 0.5f) * (1.0f - this.f343775f));
    L5:
        r100.setScale(r108, r108);
        r100.postTranslate((int) r109, (int) r113);
        return r100;
    }
}
