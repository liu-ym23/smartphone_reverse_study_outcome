package com.larus.livetutor.impl.utils;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f356670a = 0;

    static {
    }

    public d() {
    }

    public static Drawable a(GradientDrawable.Orientation r100, int[] r101) {
        Intrinsics.checkNotNullParameter(r100, "orientation");
        Intrinsics.checkNotNullParameter(r101, "colors");
        GradientDrawable r102 = new GradientDrawable(r100, r101);
        if (0 <= 0.0f) goto L5;
        r102.setStroke(0, 0);
    L5:
        return r102;
    }
}
