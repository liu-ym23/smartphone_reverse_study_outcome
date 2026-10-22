package com.obric.common.oea.foundation.animation.builder;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class c {
    public static b.a a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$animator");
        b.a r101 = new b.a(r100);
        if (1.0f <= 0) goto L6;
        r101.f396368a = 1.0f;
        r101.f396369b = 90.0f;
        return r101;
    L6:
        int r102 = ija.b.f490154a;
        Intrinsics.checkNotNullParameter("animationSpeed必须大于 0", "message");
        throw new IllegalArgumentException("animationSpeed必须大于 0");
    }
}
