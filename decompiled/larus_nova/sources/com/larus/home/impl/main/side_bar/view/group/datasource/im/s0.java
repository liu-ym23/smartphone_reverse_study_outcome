package com.larus.home.impl.main.side_bar.view.group.datasource.im;

import com.larus.home.impl.main.side_bar.view.group.datasource.GroupSortPolicy;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class s0 implements zb9.s<com.larus.home.impl.main.side_bar.data.j0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<com.larus.home.impl.main.side_bar.data.j0> f345385a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final zb9.t<com.larus.home.impl.main.side_bar.data.j0> f345386b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.larus.home.impl.main.side_bar.data.j0 f345387c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public GroupSortPolicy f345388d;

    public final zb9.k<zb9.i<com.larus.home.impl.main.side_bar.data.j0>> b() {
        com.larus.home.impl.main.side_bar.data.j0 r100 = this.f345387c;
        if (r100 == null) goto L5;
        zb9.i r110 = new zb9.i(r100, 0, 0, 0, true, 14);
    L7:
        return new zb9.k(CollectionsKt.listOfNotNull(r110));
    L5:
        r110 = null;
        goto L7
    }

    @Override // zb9.s
    public final GroupSortPolicy e() {
        return this.f345388d;
    }

    public s0(Function0<com.larus.home.impl.main.side_bar.data.j0> r100) {
        Intrinsics.checkNotNullParameter(r100, "itemProvider");
        this.f345385a = r100;
        this.f345386b = new zb9.t();
        this.f345388d = GroupSortPolicy.UpdateTime;
    }

    @Override // zb9.s
    public final void a(zb9.j r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        this.f345386b.b(b());
    }

    @Override // zb9.s
    public final void d(zb9.u<com.larus.home.impl.main.side_bar.data.j0> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f345386b.a(r100);
    }

    @Override // zb9.s
    public final void f(zb9.u<com.larus.home.impl.main.side_bar.data.j0> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f345386b.d(r100);
    }

    @Override // zb9.s
    public final void g(zb9.j r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        this.f345387c = this.f345385a.invoke();
        this.f345386b.b(b());
    }

    @Override // zb9.s
    public final void h(GroupSortPolicy r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f345388d = r100;
    }
}
