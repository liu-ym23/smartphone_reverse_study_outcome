package com.obric.assistant.live.island;

import com.obric.livecard.api.entity.IslandWidget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IslandWidget f390149a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IslandWidget f390150b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final IslandWidget f390151c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final t f390152d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f390153e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof u) == true) goto L8;
        return false;
    L8:
        u r101 = (u) r100;
        if (Intrinsics.areEqual(this.f390149a, r101.f390149a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f390150b, r101.f390150b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f390151c, r101.f390151c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f390152d, r101.f390152d) == true) goto L21;
        return false;
    L21:
        if (this.f390153e == r101.f390153e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f390149a.hashCode() * 31) + this.f390150b.hashCode()) * 31) + this.f390151c.hashCode()) * 31) + this.f390152d.hashCode()) * 31;
        long r101 = this.f390153e;
        return r100 + ((int) (r101 ^ (r101 >>> 32)));
    }

    public final String toString() {
        return "SessionCreationParams(collapseWidget=" + this.f390149a + ", expandWidget=" + this.f390150b + ", notificationWidget=" + this.f390151c + ", behavior=" + this.f390152d + ", flags=" + this.f390153e + ')';
    }

    public u(IslandWidget r100, IslandWidget r101, IslandWidget r102, t r103, long r104) {
        Intrinsics.checkNotNullParameter(r100, "collapseWidget");
        Intrinsics.checkNotNullParameter(r101, "expandWidget");
        Intrinsics.checkNotNullParameter(r102, "notificationWidget");
        Intrinsics.checkNotNullParameter(r103, "behavior");
        this.f390149a = r100;
        this.f390150b = r101;
        this.f390151c = r102;
        this.f390152d = r103;
        this.f390153e = r104;
    }
}
