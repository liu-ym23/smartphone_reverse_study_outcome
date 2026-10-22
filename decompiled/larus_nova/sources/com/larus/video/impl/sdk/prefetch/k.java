package com.larus.video.impl.sdk.prefetch;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, i> f375884a;

    public k() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f375884a, ((k) r100).f375884a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f375884a.hashCode();
    }

    public final String toString() {
        return "CachedUserRefreshCountDataMapWrapper(cachedUserRefreshCountDataMap=" + this.f375884a + ')';
    }

    public k(ConcurrentHashMap<String, i> r100) {
        Intrinsics.checkNotNullParameter(r100, "cachedUserRefreshCountDataMap");
        this.f375884a = r100;
    }

    public /* synthetic */ k(int r100) {
        this(new ConcurrentHashMap());
    }
}
