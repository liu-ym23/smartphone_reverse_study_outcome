package com.bytedance.dux.indicator;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class b {
    public static final void a(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.getLayoutParams().width = r101;
        r100.requestLayout();
    }
}
