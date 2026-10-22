package com.larus.video.impl.sdk.prefetch;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, a> f375848a;

    public b() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f375848a, ((b) r100).f375848a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f375848a.hashCode();
    }

    public final String toString() {
        return "CachedFirstBindPreloadDataMapWrapper(cachedFirstBindPreloadData=" + this.f375848a + ')';
    }

    public b(ConcurrentHashMap<String, a> r100) {
        Intrinsics.checkNotNullParameter(r100, "cachedFirstBindPreloadData");
        this.f375848a = r100;
    }

    public /* synthetic */ b(int r100) {
        this(new ConcurrentHashMap());
    }
}
