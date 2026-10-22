package com.google.common.collect;

import java.util.Iterator;

/* JADX INFO: loaded from: classes23.dex */
public final class c1 extends v2<Object, Object> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.google.common.base.g f275437b;

    @Override // com.google.common.collect.v2
    @ParametricNullness
    public final Object a(@ParametricNullness Object r100) {
        return this.f275437b.apply(r100);
    }

    public c1(Iterator r100, com.google.common.base.g r101) {
        this.f275437b = r101;
        super(r100);
    }
}
