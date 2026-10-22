package com.bytedance.kmp.image.utils;

import androidx.compose.ui.layout.ContentScale;
import com.bytedance.kmp.image.options.j;
import com.bytedance.kmp.image.options.n;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.imagepipeline.common.Priority;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class b {
    public static final Priority a(n r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof n.a) == false) goto L7;
        return Priority.MEDIUM;
    L7:
        throw new NoWhenBranchMatchedException();
    }

    public static final ScalingUtils.ScaleType b(j r100) {
        if (r100 == null) goto L5;
        ContentScale r101 = r100.f252161a;
    L6:
        ContentScale.Companion r102 = ContentScale.Companion;
        if (Intrinsics.areEqual(r101, r102.getCrop()) == false) goto L10;
        return ScalingUtils.ScaleType.CENTER_CROP;
    L10:
        if (Intrinsics.areEqual(r101, r102.getFit()) == false) goto L13;
        return ScalingUtils.ScaleType.FIT_CENTER;
    L13:
        if (Intrinsics.areEqual(r101, r102.getInside()) == false) goto L16;
        return ScalingUtils.ScaleType.CENTER_INSIDE;
    L16:
        if (Intrinsics.areEqual(r101, r102.getFillBounds()) == true) goto L18;
        return null;
    L18:
        return ScalingUtils.ScaleType.FIT_XY;
    L5:
        r101 = null;
        goto L6
    }
}
