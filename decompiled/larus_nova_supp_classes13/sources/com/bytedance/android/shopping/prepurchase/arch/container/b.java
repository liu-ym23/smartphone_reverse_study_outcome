package com.bytedance.android.shopping.prepurchase.arch.container;

import com.bytedance.android.shopping.prepurchase.arch.container.intf.i;
import com.bytedance.android.shopping.prepurchase.arch.container.intf.m;
import com.bytedance.android.shopping.prepurchase.arch.container.model.Biz;
import com.bytedance.android.shopping.prepurchase.arch.container.state.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b<STATE extends h, STORE> {
    public com.bytedance.android.shopping.prepurchase.arch.container.intf.h a;
    public xi.b b;
    public i c;
    public pg3.c<STATE, STORE> d;
    public com.bytedance.android.shopping.prepurchase.arch.container.intf.f e;
    public final og3.c f;

    public final f<STATE, STORE> a() {
        boolean r1 = false;
        if (this.a == null) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        this.a = new com.bytedance.android.shopping.prepurchase.arch.container.intf.d();
    L9:
        if (this.b == null) goto L11;
        boolean r2 = true;
    L12:
        if (r2 == true) goto L15;
        Biz r3 = this.f.a;
        this.b = new m(r3, new com.bytedance.android.shopping.prepurchase.arch.container.intf.c(r3));
    L15:
        if (this.c == null) goto L17;
        r1 = true;
    L17:
        if (r1 == true) goto L20;
        this.c = new com.bytedance.android.shopping.prepurchase.arch.container.intf.e();
    L20:
        return new f(this);
    L11:
        r2 = false;
        goto L12
    L5:
        r0 = false;
        goto L6
    }

    public b(og3.c r2) {
        Intrinsics.checkNotNullParameter(r2, "pageInfo");
        this.f = r2;
    }
}
