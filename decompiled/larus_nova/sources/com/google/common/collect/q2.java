package com.google.common.collect;

import java.util.Map;

/* JADX INFO: loaded from: classes23.dex */
public final class q2 extends b<Object, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Map.Entry f275493a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ StandardTable.b.C3853b f275494b;

    @Override // com.google.common.collect.b, java.util.Map.Entry
    public final Object getKey() {
        return this.f275493a.getKey();
    }

    @Override // com.google.common.collect.b, java.util.Map.Entry
    public final Object getValue() {
        return ((Map) this.f275493a.getValue()).get(this.f275494b.f275338d.f275334d);
    }

    @Override // com.google.common.collect.b, java.util.Map.Entry
    public final Object setValue(Object r100) {
        Map r101 = (Map) this.f275493a.getValue();
        C r102 = this.f275494b.f275338d.f275334d;
        r100.getClass();
        return r101.put(r102, r100);
    }

    public q2(StandardTable.b.C3853b r100, Map.Entry r101) {
        this.f275494b = r100;
        this.f275493a = r101;
    }
}
