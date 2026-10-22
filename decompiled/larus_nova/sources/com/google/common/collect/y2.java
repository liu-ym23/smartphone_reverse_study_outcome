package com.google.common.collect;

/* JADX INFO: loaded from: classes23.dex */
public final class y2 extends Multisets.a<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TreeMultiset.d f275546a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TreeMultiset f275547b;

    @Override // com.google.common.collect.y1.a
    public final int getCount() {
        TreeMultiset.d r100 = this.f275546a;
        int r101 = r100.f275386b;
        if (r101 == 0) goto L5;
        return r101;
    L5:
        return this.f275547b.count(r100.f275385a);
    }

    @Override // com.google.common.collect.y1.a
    @ParametricNullness
    public final Object getElement() {
        return this.f275546a.f275385a;
    }

    public y2(TreeMultiset r100, TreeMultiset.d r101) {
        this.f275547b = r100;
        this.f275546a = r101;
    }
}
