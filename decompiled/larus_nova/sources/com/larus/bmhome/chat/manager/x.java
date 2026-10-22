package com.larus.bmhome.chat.manager;

import android.view.View;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class x implements Function1<View, Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x f306874a = null;

    static {
        f306874a = new x();
    }

    public x() {
    }

    @Override // kotlin.jvm.functions.Function1
    public final Integer invoke(View r100) {
        View r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "menuView");
        return Integer.valueOf(-r101.getPaddingLeft());
    }
}
