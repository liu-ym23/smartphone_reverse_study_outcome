package com.bytedance.ee.bear.bitable.core;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class g implements do4.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f210168a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArraySet<do4.c.a> f210169b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f210170c;

    @Override // do4.c
    public final int F() {
        return this.f210168a;
    }

    @Override // do4.c
    public final int L() {
        return this.f210170c;
    }

    public g(int r100) {
        this.f210168a = r100;
        this.f210169b = new CopyOnWriteArraySet();
        this.f210170c = r100;
    }

    @Override // do4.c
    public final void B1(int r100) {
        if (this.f210170c != r100) goto L5;
        return;
    L5:
        this.f210170c = r100;
        Iterator<T> r101 = this.f210169b.iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        ((do4.c.a) r101.next()).onChanged(r100);
        goto L7
    }

    @Override // do4.c
    public final void Z5(do4.c.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f210169b.add(r100);
        r100.onChanged(this.f210170c);
    }

    @Override // do4.c
    public final void le(do4.c.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f210169b.remove(r100);
    }
}
