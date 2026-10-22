package com.google.common.collect;

import java.util.Map;

/* JADX INFO: loaded from: classes23.dex */
public final class v0 extends b<Object, ImmutableSet<Object>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Map.Entry f275531a;

    @Override // com.google.common.collect.b, java.util.Map.Entry
    public final Object getKey() {
        return this.f275531a.getKey();
    }

    @Override // com.google.common.collect.b, java.util.Map.Entry
    public final Object getValue() {
        return ImmutableSet.of(this.f275531a.getValue());
    }

    public v0(Map.Entry r100) {
        this.f275531a = r100;
    }
}
