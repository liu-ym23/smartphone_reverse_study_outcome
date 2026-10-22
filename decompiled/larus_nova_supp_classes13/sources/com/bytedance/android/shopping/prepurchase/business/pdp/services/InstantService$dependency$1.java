package com.bytedance.android.shopping.prepurchase.business.pdp.services;

import j73.j;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class InstantService$dependency$1 implements j {
    public final /* synthetic */ InstantService a;

    public final Map<String, Object> A() {
        return this.a.k;
    }

    public final boolean E() {
        return this.a.n;
    }

    public final Map<String, Object> l0() {
        return this.a.i;
    }

    public final Map<String, String> o0() {
        return this.a.m;
    }

    public final Map<String, Object> x() {
        return this.a.j;
    }

    public InstantService$dependency$1(InstantService r1) {
        this.a = r1;
    }

    public final void J(List<com.bytedance.android.ecom.arch.slice.adapter.b> r3) {
        Intrinsics.checkNotNullParameter(r3, "items");
        List<com.bytedance.android.ecom.arch.slice.adapter.b> r0 = this.a.p.a();
        ArrayList r1 = new ArrayList();
        if (r0 == null) goto L5;
        r1.addAll(r0);
    L5:
        r1.addAll(r3);
        this.a.p.g(r1);
    }

    public final void K(Map<String, Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "map");
        this.a.i = r2;
    }

    public final void j0(Function1<? super Map<String, ? extends Object>, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "calcCB");
        r2.invoke(this.a.o.a());
    }

    public final void p0(boolean r2) {
        this.a.l = r2;
    }

    public final void q0(boolean r2) {
        this.a.n = r2;
    }

    public final void u0(final int r2) {
        j0(new InstantService$dependency$1$updateInstantSupermarketCartBarData$1(this, r2));
    }
}
