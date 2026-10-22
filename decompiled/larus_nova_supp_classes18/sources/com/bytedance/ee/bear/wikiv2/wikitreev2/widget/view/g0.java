package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import android.view.View;
import com.bytedance.ee.bear.contract.route.parcelable.WikNodePerm;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g0 implements View.OnClickListener {
    public final /* synthetic */ c0 a;
    public final /* synthetic */ WikNodePerm b;
    public final /* synthetic */ com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j c;

    public g0(c0 r1, WikNodePerm r2, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        c0 r4 = this.a;
        WikNodePerm r0 = this.b;
        Intrinsics.checkNotNull(r0);
        r4.k(r0, this.c);
    }
}
