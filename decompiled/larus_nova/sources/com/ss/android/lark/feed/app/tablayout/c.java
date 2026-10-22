package com.ss.android.lark.feed.app.tablayout;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class c {
    public static final int a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return (r100.getMeasuredHeight() - r100.getPaddingTop()) - r100.getPaddingBottom();
    }

    public static final int b(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return (r100.getMeasuredWidth() - r100.getPaddingLeft()) - r100.getPaddingRight();
    }
}
