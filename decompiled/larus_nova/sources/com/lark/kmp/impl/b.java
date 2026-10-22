package com.lark.kmp.impl;

import gy7.e;
import gy7.f;
import gy7.j;
import gy7.l;
import gy7.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: classes7.dex */
public final class b implements f, e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<hy7.b> f278592a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final gy7.a f278593b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<gy7.d> f278594c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<hy7.a> f278595d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CoroutineScope f278596e;

    /* JADX WARN: Multi-variable type inference failed */
    public b(List<? extends hy7.b> r100) {
        Intrinsics.checkNotNullParameter(r100, "staticConventions");
        this.f278592a = r100;
        gy7.a r101 = gy7.c.f483344a;
        this.f278593b = r101;
        p r102 = r101.f483343a;
        if (r102 == null) goto L7;
        loa.a r103 = r102.f483348a;
        if (r103 == null) goto L7;
        String r104 = r103.f510160a;
    L7:
        this.f278594c = new ArrayList();
        this.f278595d = new ArrayList();
        this.f278596e = CoroutineScopeKt.CoroutineScope(a.f278589a);
    }

    @Override // gy7.e
    public final void a(j r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Iterator r101 = CollectionsKt.plus(CollectionsKt.toList(this.f278595d), this.f278592a).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((hy7.a) r101.next()).b();
        goto L4
    }

    @Override // gy7.e
    public final void b(l r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Iterator r101 = CollectionsKt.plus(CollectionsKt.toList(this.f278595d), this.f278592a).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((hy7.a) r101.next()).f();
        goto L4
    }

    @Override // gy7.e
    public final void d(l r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Iterator r101 = CollectionsKt.plus(CollectionsKt.toList(this.f278595d), this.f278592a).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((hy7.a) r101.next()).a();
        goto L4
    }

    @Override // gy7.e
    public final Unit e(gy7.b r100) {
        Iterator r101 = ((ArrayList) this.f278594c).iterator();
    L4:
        if (r101.hasNext() == false) goto L7;
        ((gy7.d) r101.next()).a();
        goto L4
    L7:
        return Unit.INSTANCE;
    }

    @Override // gy7.e
    public final void g(j r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Iterator r101 = CollectionsKt.plus(CollectionsKt.toList(this.f278595d), this.f278592a).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((hy7.a) r101.next()).d();
        goto L4
    }

    @Override // gy7.e
    public final void c(gy7.b r100, p r101) {
        Intrinsics.checkNotNullParameter(r100, "currentState");
        Iterator r102 = CollectionsKt.plus(CollectionsKt.toList(this.f278595d), this.f278592a).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((hy7.a) r102.next()).c();
        goto L4
    }

    @Override // gy7.e
    public final void f(gy7.b r100, p r101) {
        Intrinsics.checkNotNullParameter(r100, "currentState");
        Iterator r102 = CollectionsKt.plus(CollectionsKt.toList(this.f278595d), this.f278592a).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((hy7.a) r102.next()).e();
        goto L4
    }
}
