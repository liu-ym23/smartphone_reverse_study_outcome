package com.google.common.collect;

import java.util.Map;

/* JADX INFO: loaded from: classes23.dex */
public final class a2 extends l0<Class<Object>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Map.Entry f275426a;

    @Override // com.google.common.collect.o0
    public final Object delegate() {
        return this.f275426a;
    }

    @Override // com.google.common.collect.l0
    public final Map.Entry<Class<Object>, Object> e() {
        return this.f275426a;
    }

    public a2(Map.Entry r100) {
        this.f275426a = r100;
    }

    @Override // com.google.common.collect.l0, java.util.Map.Entry
    @ParametricNullness
    public final Object setValue(@ParametricNullness Object r100) {
        MutableClassToInstanceMap.access$000(getKey(), r100);
        return super.setValue(r100);
    }
}
