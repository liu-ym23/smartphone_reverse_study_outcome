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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e {
    public static final <T> Lazy<T> a(Function0<? extends T> r1) {
        Intrinsics.checkNotNullParameter(r1, "initializer");
        return LazyKt.lazy(LazyThreadSafetyMode.NONE, r1);
    }

    public static final <T> void b(View r1, Function1<? super T, Unit> r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "block");
        ViewGroup.LayoutParams r0 = r1.getLayoutParams();
        if (r0 != null) goto L5;
        r0 = null;
    L5:
        if (r0 != null) goto L7;
        return;
    L7:
        r2.invoke(r0);
        r1.setLayoutParams(r0);
    }
}
