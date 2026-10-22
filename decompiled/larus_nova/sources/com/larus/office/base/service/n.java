package com.larus.office.base.service;

import android.view.ViewGroup;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class n implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList<b> f361119a;

    @Override // com.larus.office.base.service.a
    public final Function0<String> getIdGetter() {
        return null;
    }

    @Override // com.larus.office.base.service.b
    public final ViewGroup b() {
        b r100 = (b) CollectionsKt.lastOrNull(this.f361119a);
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.b();
    }

    @Override // com.larus.office.base.service.b
    public final void f() {
        Iterator<T> r100 = this.f361119a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((b) r100.next()).f();
        goto L4
    }

    public n() {
        this.f361119a = new CopyOnWriteArrayList();
    }

    @Override // com.larus.office.base.service.b
    public final void c(boolean r100) {
        Iterator<b> r101 = this.f361119a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().c(r100);
        goto L4
    }

    @Override // com.larus.office.base.service.b
    public final void d(ViewGroup r100) {
        Iterator<T> r101 = this.f361119a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((b) r101.next()).d(r100);
        goto L4
    }

    @Override // com.larus.office.base.service.b
    public final void e(BizMenuData r100, com.larus.office.base.plugins.titlebar.c r101, com.larus.office.base.plugins.titlebar.d r102) {
        Intrinsics.checkNotNullParameter(r101, "onMenuClick");
        Iterator<b> r103 = this.f361119a.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r103.next().e(r100, r101, r102);
        goto L4
    }

    @Override // com.larus.office.base.service.b
    public final void a(Integer r100, String r101, String r102, String r103) {
        Iterator<T> r104 = this.f361119a.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        ((b) r104.next()).a(r100, r101, r102, r103);
        goto L4
    }
}
