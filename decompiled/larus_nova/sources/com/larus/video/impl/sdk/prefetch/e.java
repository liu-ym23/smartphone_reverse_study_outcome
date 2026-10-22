package com.larus.video.impl.sdk.prefetch;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, d> f375854a;

    public e() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f375854a, ((e) r100).f375854a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f375854a.hashCode();
    }

    public final String toString() {
        return "CachedFirstScreenDataMapWrapper(cachedFirstScreenDataMap=" + this.f375854a + ')';
    }

    public e(ConcurrentHashMap<String, d> r100) {
        Intrinsics.checkNotNullParameter(r100, "cachedFirstScreenDataMap");
        this.f375854a = r100;
    }

    public /* synthetic */ e(int r100) {
        this(new ConcurrentHashMap());
    }
}
