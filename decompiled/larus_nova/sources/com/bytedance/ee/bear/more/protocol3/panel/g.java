package com.bytedance.ee.bear.more.protocol3.panel;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class g implements z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b0 f234967a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c0 f234968b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a0 f234969c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f234967a, r101.f234967a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f234968b, r101.f234968b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f234969c, r101.f234969c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f234967a.hashCode() * 31) + this.f234968b.hashCode()) * 31) + this.f234969c.hashCode();
    }

    public final String toString() {
        return "DefaultMorePanelInfo(meta=" + this.f234967a + ", permission=" + this.f234968b + ", jsState=" + this.f234969c + ')';
    }

    @Override // com.bytedance.ee.bear.more.protocol3.panel.z
    public final c0 getPermission() {
        return this.f234968b;
    }

    public g(b0 r100, c0 r101, a0 r102) {
        Intrinsics.checkNotNullParameter(r100, "meta");
        Intrinsics.checkNotNullParameter(r101, "permission");
        Intrinsics.checkNotNullParameter(r102, "jsState");
        this.f234967a = r100;
        this.f234968b = r101;
        this.f234969c = r102;
    }
}
