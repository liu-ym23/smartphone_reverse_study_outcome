package com.bytedance.live.layout;

import android.graphics.RectF;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a {
    public static final float a(RectF r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return r100.bottom - r100.top;
    }

    public static final float b(RectF r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return r100.right - r100.left;
    }
}
