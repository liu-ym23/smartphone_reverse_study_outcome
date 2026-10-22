package com.google.common.collect;

/* JADX INFO: loaded from: classes23.dex */
public final class u extends Multisets.a<Enum<Object>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f275510a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ EnumMultiset.b f275511b;

    @Override // com.google.common.collect.y1.a
    public final int getCount() {
        return EnumMultiset.access$100(this.f275511b.f275020d)[this.f275510a];
    }

    @Override // com.google.common.collect.y1.a
    public final Object getElement() {
        return EnumMultiset.access$000(this.f275511b.f275020d)[this.f275510a];
    }

    public u(EnumMultiset.b r100, int r101) {
        this.f275511b = r100;
        this.f275510a = r101;
    }
}
