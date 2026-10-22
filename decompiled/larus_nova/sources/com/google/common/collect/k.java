package com.google.common.collect;

/* JADX INFO: loaded from: classes23.dex */
public final class k extends b<Object, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f275480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ArrayTable.c f275481b;

    @Override // com.google.common.collect.b, java.util.Map.Entry
    public final Object getKey() {
        ArrayTable.c r100 = this.f275481b;
        int r101 = this.f275480a;
        return r100.f274951a.keySet().asList().get(r101);
    }

    @Override // com.google.common.collect.b, java.util.Map.Entry
    @ParametricNullness
    public final Object getValue() {
        return this.f275481b.c(this.f275480a);
    }

    @Override // com.google.common.collect.b, java.util.Map.Entry
    @ParametricNullness
    public final Object setValue(@ParametricNullness Object r100) {
        return this.f275481b.d(this.f275480a, r100);
    }

    public k(ArrayTable.c r100, int r101) {
        this.f275481b = r100;
        this.f275480a = r101;
    }
}
