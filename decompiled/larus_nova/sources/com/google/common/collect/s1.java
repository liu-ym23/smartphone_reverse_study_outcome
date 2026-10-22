package com.google.common.collect;

import java.util.Collection;
import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: loaded from: classes23.dex */
public final class s1 extends MultimapBuilder.b<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Class f275502a;

    @Override // com.google.common.collect.MultimapBuilder.b
    public final <K, V> Map<K, Collection<V>> a() {
        return new EnumMap(this.f275502a);
    }

    public s1(Class r100) {
        this.f275502a = r100;
    }
}
