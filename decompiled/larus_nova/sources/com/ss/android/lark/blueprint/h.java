package com.ss.android.lark.blueprint;

import android.util.LruCache;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class h<Data> implements o<Data> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o<Data> f410654a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class<Data> f410655b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LruCache<Integer, n> f410656c;

    @Override // com.ss.android.lark.blueprint.o
    public final Class<Data> getDataType() {
        return this.f410655b;
    }

    @Override // com.ss.android.lark.blueprint.o
    public final n a(Data r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        int r101 = r100.hashCode();
        n r102 = this.f410656c.get(Integer.valueOf(r101));
        if (r102 == null) goto L5;
        return r102;
    L5:
        n r103 = this.f410654a.a(r100);
        if (r103 == null) goto L8;
        this.f410656c.put(Integer.valueOf(r101), r103);
        return r103;
    L8:
        return null;
    }

    public h(o<Data> r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        this.f410654a = r100;
        this.f410655b = r100.getDataType();
        this.f410656c = new LruCache(r101);
    }
}
