package com.google.common.collect;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes23.dex */
public final class o1 extends Maps.c<Object, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Maps.b f275487a;

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator<Map.Entry<Object, Object>> iterator() {
        return ((e.a) this.f275487a).f275460d.b();
    }

    @Override // com.google.common.collect.Maps.c
    public final Map<Object, Object> a() {
        return this.f275487a;
    }

    public o1(Maps.b r100) {
        this.f275487a = r100;
    }
}
