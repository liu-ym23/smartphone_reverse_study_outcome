package com.google.common.collect;

import java.util.Iterator;

/* JADX INFO: loaded from: classes23.dex */
public final class y0 extends d0<Object> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Iterable f275544b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.google.common.base.g f275545c;

    @Override // java.lang.Iterable
    public final Iterator<Object> iterator() {
        Iterator r100 = this.f275544b.iterator();
        com.google.common.base.g r101 = this.f275545c;
        r101.getClass();
        return new c1(r100, r101);
    }

    public y0(Iterable r100, com.google.common.base.g r101) {
        this.f275544b = r100;
        this.f275545c = r101;
    }
}
