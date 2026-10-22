package com.google.common.collect;

/* JADX INFO: loaded from: classes23.dex */
public final class n1 implements Maps.d<Object, Object, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.google.common.base.g f275486a;

    public n1(com.google.common.base.g r100) {
        this.f275486a = r100;
    }

    @Override // com.google.common.collect.Maps.d
    @ParametricNullness
    public final Object a(@ParametricNullness Object r100) {
        return this.f275486a.apply(r100);
    }
}
