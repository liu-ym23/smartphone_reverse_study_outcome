package com.google.common.collect;

import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
class Sets$CartesianSet$1 extends ImmutableList<List<Object>> {
    final /* synthetic */ ImmutableList val$axes;

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.val$axes.size();
    }

    public Sets$CartesianSet$1(ImmutableList r100) {
        this.val$axes = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.List
    public List<Object> get(int r100) {
        return ((ImmutableSet) this.val$axes.get(r100)).asList();
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ Object get(int r100) {
        return get(r100);
    }
}
