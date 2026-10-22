package com.bytedance.ies.bullet.service.base;

import android.net.Uri;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f247889a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Uri f247890b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CacheType f247891c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f247889a, r101.f247889a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f247890b, r101.f247890b) == true) goto L15;
        return false;
    L15:
        if (this.f247891c == r101.f247891c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f247889a.hashCode() * 31) + this.f247890b.hashCode()) * 31) + this.f247891c.hashCode();
    }

    public final String toString() {
        return "Event(originSchema=" + this.f247889a + ", uniqueSchema=" + this.f247890b + ", cacheType=" + this.f247891c + ')';
    }

    public f(Uri r100, Uri r101, CacheType r102) {
        Intrinsics.checkNotNullParameter(r100, "originSchema");
        Intrinsics.checkNotNullParameter(r101, "uniqueSchema");
        Intrinsics.checkNotNullParameter(r102, "cacheType");
        this.f247889a = r100;
        this.f247890b = r101;
        this.f247891c = r102;
    }
}
