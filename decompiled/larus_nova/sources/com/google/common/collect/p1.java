package com.google.common.collect;

import java.util.Map;

/* JADX INFO: loaded from: classes23.dex */
public final class p1 extends l0<Object, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Map.Entry f275491a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Maps.e.a.C3849a f275492b;

    @Override // com.google.common.collect.o0
    public final Object delegate() {
        return this.f275491a;
    }

    @Override // com.google.common.collect.l0
    public final Map.Entry<Object, Object> e() {
        return this.f275491a;
    }

    @Override // com.google.common.collect.l0, java.util.Map.Entry
    @ParametricNullness
    public final Object setValue(@ParametricNullness Object r100) {
        com.google.common.base.m.b(this.f275492b.f275253b.f275252a.d(getKey(), r100));
        return super.setValue(r100);
    }

    public p1(Maps.e.a.C3849a r100, Map.Entry r101) {
        this.f275492b = r100;
        this.f275491a = r101;
    }
}
