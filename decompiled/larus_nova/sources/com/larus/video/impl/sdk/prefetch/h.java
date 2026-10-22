package com.larus.video.impl.sdk.prefetch;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, g> f375867a;

    public h() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f375867a, ((h) r100).f375867a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f375867a.hashCode();
    }

    public final String toString() {
        return "CachedPreloadItemIdsDataMapWrapper(cachedPreloadItemIdsDataMap=" + this.f375867a + ')';
    }

    public h(ConcurrentHashMap<String, g> r100) {
        Intrinsics.checkNotNullParameter(r100, "cachedPreloadItemIdsDataMap");
        this.f375867a = r100;
    }

    public /* synthetic */ h(int r100) {
        this(new ConcurrentHashMap());
    }
}
