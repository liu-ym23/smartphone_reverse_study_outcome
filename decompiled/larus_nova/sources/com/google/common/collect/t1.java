package com.google.common.collect;

/* JADX INFO: loaded from: classes23.dex */
public final class t1 extends MultimapBuilder.a<Object, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f275508a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MultimapBuilder.b f275509b;

    public final <K, V> f1<K, V> a() {
        return new Multimaps.CustomListMultimap(this.f275509b.a(), new MultimapBuilder.ArrayListSupplier(this.f275508a));
    }

    public t1(r1 r100) {
        this.f275509b = r100;
        this.f275508a = 2;
    }
}
