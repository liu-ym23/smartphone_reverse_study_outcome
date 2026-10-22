package com.bytedance.android.livesdk.ktvimpl.ktvroom.theme;

import android.graphics.Matrix;
import android.graphics.Rect;
import com.facebook.drawee.drawable.ScalingUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d extends ScalingUtils.AbstractScaleType {
    public static final d e = null;

    static {
        e = new d();
    }

    public d() {
    }

    public final void getTransformImpl(Matrix r1, Rect r2, int r3, int r4, float r5, float r6, float r7, float r8) {
        Intrinsics.checkNotNullParameter(r1, "outTransform");
        Intrinsics.checkNotNullParameter(r2, "parentRect");
        float r9 = r2.left;
        float r10 = r2.top;
        r1.setScale(r7, r8);
        r1.postTranslate(r9 + 0.5f, r10 + 0.5f);
    }
}
