package com.google.common.collect;

import java.util.Iterator;

/* JADX INFO: loaded from: classes23.dex */
public final class s extends Multisets.c<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t f275501a;

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator<y1.a<Object>> iterator() {
        return ((h.a) this.f275501a).f275468d.descendingEntryIterator();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return ((h.a) this.f275501a).f275468d.entrySet().size();
    }

    @Override // com.google.common.collect.Multisets.c
    public final y1<Object> a() {
        return this.f275501a;
    }

    public s(t r100) {
        this.f275501a = r100;
    }
}
