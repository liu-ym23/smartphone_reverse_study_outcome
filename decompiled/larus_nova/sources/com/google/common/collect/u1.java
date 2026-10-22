package com.google.common.collect;

/* JADX INFO: loaded from: classes23.dex */
public final class u1 extends MultimapBuilder.c<Object, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f275512a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MultimapBuilder.b f275513b;

    public final <K, V> k2<K, V> a() {
        return new Multimaps.CustomSetMultimap(this.f275513b.a(), new MultimapBuilder.LinkedHashSetSupplier(this.f275512a));
    }

    public u1(s1 r100) {
        this.f275513b = r100;
        this.f275512a = 2;
    }
}
