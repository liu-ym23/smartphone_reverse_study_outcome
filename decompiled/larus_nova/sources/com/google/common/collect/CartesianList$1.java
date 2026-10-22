package com.google.common.collect;

/* JADX INFO: loaded from: classes23.dex */
class CartesianList$1 extends ImmutableList<Object> {
    final /* synthetic */ n this$0;
    final /* synthetic */ int val$index;

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        int r100 = n.f275485a;
        throw null;
    }

    @Override // java.util.List
    public Object get(int r100) {
        com.google.common.base.m.j(r100, size());
        int r101 = n.f275485a;
        throw null;
    }

    public CartesianList$1(n r100, int r101) {
        this.val$index = r101;
    }
}
