package com.bytedance.ee.bear.more.view3.ui;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ a a;
    public final /* synthetic */ View.OnClickListener b;

    public b(a r1, View.OnClickListener r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r6) {
        a r0 = this.a;
        Intrinsics.checkNotNull(r6);
        a r1 = this.a;
        boolean r2 = r1.h;
        String r3 = r1.i;
        View.OnClickListener r4 = r1.j;
        View.OnClickListener r5 = this.b;
        r0.getClass();
        a.h(r6, r2, r3, r4, r5);
    }
}
