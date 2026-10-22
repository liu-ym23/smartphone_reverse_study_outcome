package com.bytedance.locallife.live.util;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class a {
    public static final void a(View r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 == false) goto L5;
        int r102 = 0;
    L6:
        r100.setVisibility(r102);
        return;
    L5:
        r102 = 8;
        goto L6
    }

    public static void b(Context r100, AttributeSet r101, int[] r102, Function1 r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r102, "attrs");
        Intrinsics.checkNotNullParameter(r103, "block");
        TypedArray r104 = r100.obtainStyledAttributes(r101, r102, 0, 0);
        r103.invoke(r104);
        r104.recycle();
    }
}
