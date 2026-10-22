package com.lark.kmp.impl;

import com.lark.kmp.rustclient.internal.e0;
import gy7.h;
import gy7.i;
import gy7.t;
import gy7.u;
import gy7.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: classes7.dex */
public final class d implements i, h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<hy7.d> f278598a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CoroutineScope f278599b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final u f278600c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<hy7.d> f278601d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<t> f278602e;

    @Override // gy7.h
    public final void a(u r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Iterator r101 = CollectionsKt.plus(CollectionsKt.toList(this.f278601d), this.f278598a).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((hy7.d) r101.next()).a(r100);
        goto L4
    }

    @Override // gy7.h
    public final void b(u r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Iterator r101 = CollectionsKt.plus(CollectionsKt.toList(this.f278601d), this.f278598a).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((hy7.d) r101.next()).b(r100);
        goto L4
    }

    @Override // gy7.h
    public final void c(u r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Iterator r101 = CollectionsKt.plus(CollectionsKt.toList(this.f278601d), this.f278598a).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((hy7.d) r101.next()).c(r100);
        goto L4
    }

    @Override // gy7.i
    public final void d(e0 r100) {
        Intrinsics.checkNotNullParameter(r100, "convention");
        BuildersKt.launch$default(this.f278599b, null, null, new UserServiceImpl$registerConvention$1(this, r100, null), 3, null);
    }

    @Override // gy7.h
    public final void f(u r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Iterator r101 = CollectionsKt.plus(CollectionsKt.toList(this.f278601d), this.f278598a).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((hy7.d) r101.next()).f(r100);
        goto L4
    }

    @Override // gy7.h
    public final Unit g(u r100) {
        Iterator r101 = ((ArrayList) this.f278602e).iterator();
    L4:
        if (r101.hasNext() == false) goto L7;
        ((t) r101.next()).a();
        goto L4
    L7:
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(String r100, List<? extends hy7.d> r101) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        Intrinsics.checkNotNullParameter(r101, "userStaticConventions");
        this.f278598a = r101;
        CoroutineDispatcher r102 = a.f278589a;
        this.f278599b = CoroutineScopeKt.CoroutineScope(a.f278589a);
        this.f278600c = v.f483353a;
        this.f278601d = new ArrayList();
        this.f278602e = new ArrayList();
    }
}
