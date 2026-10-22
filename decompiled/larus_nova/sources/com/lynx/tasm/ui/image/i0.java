package com.lynx.tasm.ui.image;

import android.graphics.Matrix;
import android.graphics.Rect;
import com.facebook.drawee.drawable.ScalingUtils;

/* JADX INFO: loaded from: classes32.dex */
public final class i0 implements ScalingUtils.ScaleType {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final i0 f384011e = null;

    public i0() {
    }

    static {
        f384011e = new i0();
    }

    public final String toString() {
        u7a.m.b.f549125c.getClass();
        return "center";
    }

    @Override // com.facebook.drawee.drawable.ScalingUtils.ScaleType
    public final Matrix getTransform(Matrix r100, Rect r101, int r102, int r103, float r104, float r105) {
        u7a.m.b.f549125c.a(r100, r101, r102, r103);
        return r100;
    }
}
