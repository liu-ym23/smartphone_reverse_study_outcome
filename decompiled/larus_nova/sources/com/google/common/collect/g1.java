package com.google.common.collect;

import java.util.Map;

/* JADX INFO: loaded from: classes23.dex */
public final class g1 extends b<Object, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Map.Entry f275465a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Maps.d f275466b;

    @Override // com.google.common.collect.b, java.util.Map.Entry
    @ParametricNullness
    public final Object getKey() {
        return this.f275465a.getKey();
    }

    @Override // com.google.common.collect.b, java.util.Map.Entry
    @ParametricNullness
    public final Object getValue() {
        Maps.d r100 = this.f275466b;
        this.f275465a.getKey();
        return r100.a(this.f275465a.getValue());
    }

    public g1(Map.Entry r100, Maps.d r101) {
        this.f275465a = r100;
        this.f275466b = r101;
    }
}
