package com.lynx.tasm.ui.image;

import android.graphics.Matrix;
import android.graphics.Rect;
import com.bytedance.android.ecom.arch.slice.render.SlcScaleType;
import com.facebook.drawee.drawable.ScalingUtils;

/* JADX INFO: loaded from: classes32.dex */
public final class j0 implements ScalingUtils.ScaleType {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final j0 f384016e = null;

    public j0() {
    }

    static {
        f384016e = new j0();
    }

    public final String toString() {
        u7a.m.b.f549126d.getClass();
        return SlcScaleType.CENTER_CROP;
    }

    @Override // com.facebook.drawee.drawable.ScalingUtils.ScaleType
    public final Matrix getTransform(Matrix r100, Rect r101, int r102, int r103, float r104, float r105) {
        u7a.m.b.f549126d.a(r100, r101, r102, r103);
        return r100;
    }
}
