package com.bytedance.ee.bear.middleground.comment.input.utils;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements View.OnClickListener {
    public final long a;
    public final Function1<View, Unit> b;
    public long c;

    public a(Function1 r3) {
        Intrinsics.checkNotNullParameter(r3, "click");
        this.a = 100;
        this.b = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r8) {
        Intrinsics.checkNotNullParameter(r8, "view");
        long r0 = System.currentTimeMillis();
        if ((r0 - this.c) < this.a) goto L6;
        this.c = r0;
        this.b.invoke(r8);
        return;
    }
}
