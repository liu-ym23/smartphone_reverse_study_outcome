package com.bytedance.commerce.base.drawable;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes15.dex */
public final class a {
    public static final Drawable a(Function1<? super c, Unit> r100) {
        GradientDrawable r101 = new GradientDrawable();
        r100.invoke(new b(r101));
        return r101;
    }
}
