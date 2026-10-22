package com.bytedance.android.shopping.prepurchase.arch.utils;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ViewExtensionsKt {
    public static final void a(final View r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$removeParent");
        Function1<ViewGroup, Unit> r0 = new ViewExtensionsKt$removeParent$1(r2);
        ViewParent r3 = r2.getParent();
        if (r3 != null) goto L5;
        return;
    L5:
        if ((r3 instanceof ViewGroup) == true) goto L8;
        r3 = null;
    L8:
        if (r3 == null) goto L12;
        r0.invoke((ViewGroup) r3);
        return;
    }
}
