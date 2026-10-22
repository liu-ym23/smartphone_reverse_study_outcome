package com.google.common.collect;

import java.util.Collection;
import java.util.Map;

/* JADX INFO: loaded from: classes23.dex */
public final class r1 extends MultimapBuilder.b<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f275499a;

    public r1() {
        this.f275499a = 8;
    }

    @Override // com.google.common.collect.MultimapBuilder.b
    public final <K, V> Map<K, Collection<V>> a() {
        return CompactLinkedHashMap.createWithExpectedSize(this.f275499a);
    }
}
