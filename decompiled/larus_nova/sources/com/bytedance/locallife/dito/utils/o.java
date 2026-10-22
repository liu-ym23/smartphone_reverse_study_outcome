package com.bytedance.locallife.dito.utils;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class o {
    public static final Drawable a(Function1<? super r, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "init");
        p r101 = new p(new GradientDrawable());
        r100.invoke(r101);
        return r101.f258713a;
    }
}
