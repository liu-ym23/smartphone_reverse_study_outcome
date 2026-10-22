package com.bytedance.awemeopen.apps.photo.pinch;

import android.view.View;
import android.view.ViewGroup;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class e {
    public static final <T> Lazy<T> a(Function0<? extends T> r100) {
        Intrinsics.checkNotNullParameter(r100, "initializer");
        return LazyKt.lazy(LazyThreadSafetyMode.NONE, r100);
    }

    public static final <T> void b(View r100, Function1<? super T, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "block");
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if (r102 != null) goto L5;
        r102 = null;
    L5:
        if (r102 != null) goto L7;
        return;
    L7:
        r101.invoke(r102);
        r100.setLayoutParams(r102);
    }
}
