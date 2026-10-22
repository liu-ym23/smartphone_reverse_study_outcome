package com.larus.office.base.host;

import hm9.v;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class p implements bxa.a, v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f360535a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList<bxa.a.InterfaceC0374a> f360536b;

    @Override // bxa.a
    public final boolean l1() {
        hm9.j r100 = hm9.j.f485959a;
        if (hm9.j.a() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f360535a == true) goto L7;
        return true;
    }

    public p() {
        this.f360536b = new CopyOnWriteArrayList();
        hm9.j r100 = hm9.j.f485959a;
        Intrinsics.checkNotNullParameter(this, "callback");
        hm9.j.f485962d.addIfAbsent(this);
        X0(hm9.j.a());
    }

    @Override // bxa.a
    public final void I1(djb.a r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f360536b.remove(r100);
    }

    @Override // hm9.v
    public final void X0(boolean r100) {
        if (r100 == true) goto L4;
    L6:
        boolean r101 = false;
    L7:
        Iterator<T> r102 = this.f360536b.iterator();
    L9:
        if (r102.hasNext() == false) goto L11;
        ((bxa.a.InterfaceC0374a) r102.next()).onStateChanged(r101);
        goto L9
    L11:
        return;
    L4:
        if (this.f360535a == true) goto L6;
        r101 = true;
        goto L7
    }

    @Override // bxa.a
    public final void h0(djb.a r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f360536b.addIfAbsent(r100);
        r100.onStateChanged(l1());
    }
}
