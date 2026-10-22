package com.larus.video.impl.sdk.prefetch;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, c> f375883a;

    public j() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f375883a, ((j) r100).f375883a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f375883a.hashCode();
    }

    public final String toString() {
        return "CachedUserFirstClickMessageVideoDataMapWrapper(cachedUserFirstClickMessageVideoDataMap=" + this.f375883a + ')';
    }

    public j(ConcurrentHashMap<String, c> r100) {
        Intrinsics.checkNotNullParameter(r100, "cachedUserFirstClickMessageVideoDataMap");
        this.f375883a = r100;
    }

    public /* synthetic */ j(int r100) {
        this(new ConcurrentHashMap());
    }
}
