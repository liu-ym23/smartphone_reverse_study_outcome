package com.lynx.tasm.ui.image;

import android.graphics.Matrix;
import android.graphics.Rect;
import com.bytedance.android.ecom.arch.slice.render.SlcScaleType;
import com.facebook.drawee.drawable.ScalingUtils;

/* JADX INFO: loaded from: classes32.dex */
public final class l0 implements ScalingUtils.ScaleType {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final l0 f384019e = null;

    public l0() {
    }

    static {
        f384019e = new l0();
    }

    public final String toString() {
        u7a.m.b.f549123a.getClass();
        return SlcScaleType.FIT_XY;
    }

    @Override // com.facebook.drawee.drawable.ScalingUtils.ScaleType
    public final Matrix getTransform(Matrix r100, Rect r101, int r102, int r103, float r104, float r105) {
        u7a.m.b.f549123a.a(r100, r101, r102, r103);
        return r100;
    }
}
