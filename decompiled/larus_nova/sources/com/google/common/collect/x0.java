package com.google.common.collect;

import java.util.Iterator;

/* JADX INFO: loaded from: classes23.dex */
public final class x0 extends d0<Object> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Iterable f275537b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.google.common.base.n f275538c;

    @Override // java.lang.Iterable
    public final Iterator<Object> iterator() {
        Iterator r100 = this.f275537b.iterator();
        com.google.common.base.n r101 = this.f275538c;
        r100.getClass();
        r101.getClass();
        return new b1(r100, r101);
    }

    public x0(Iterable r100, com.google.common.base.n r101) {
        this.f275537b = r100;
        this.f275538c = r101;
    }
}
