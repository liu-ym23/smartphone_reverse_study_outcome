package com.bytedance.ee.bear.middleground.permission.apply;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class n0 implements View.OnClickListener {
    public final /* synthetic */ n a;

    public n0(g r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        n r0 = this.a;
        Intrinsics.checkNotNull(r2);
        r0.c(r2);
    }
}
