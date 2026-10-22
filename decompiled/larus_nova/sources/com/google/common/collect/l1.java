package com.google.common.collect;

import java.util.Map;

/* JADX INFO: loaded from: classes23.dex */
public final class l1 extends b<Object, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Map.Entry f275483a;

    @Override // com.google.common.collect.b, java.util.Map.Entry
    @ParametricNullness
    public final Object getKey() {
        return this.f275483a.getKey();
    }

    @Override // com.google.common.collect.b, java.util.Map.Entry
    @ParametricNullness
    public final Object getValue() {
        return this.f275483a.getValue();
    }

    public l1(Map.Entry r100) {
        this.f275483a = r100;
    }
}
