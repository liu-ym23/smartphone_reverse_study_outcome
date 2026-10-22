package com.bytedance.ee.bear.more.protocol3.panel;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f234935a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f234936b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f234937c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b0) == true) goto L8;
        return false;
    L8:
        b0 r101 = (b0) r100;
        if (Intrinsics.areEqual(this.f234935a, r101.f234935a) == true) goto L12;
        return false;
    L12:
        if (this.f234936b == r101.f234936b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f234937c, r101.f234937c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f234935a.hashCode() * 31) + this.f234936b) * 31) + this.f234937c.hashCode();
    }

    public final String toString() {
        return "MorePanelMeta(token=" + this.f234935a + ", type=" + this.f234936b + ", subType=" + this.f234937c + ')';
    }

    public final int getType() {
        return this.f234936b;
    }

    public b0(String r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "token");
        Intrinsics.checkNotNullParameter(r102, "subType");
        this.f234935a = r100;
        this.f234936b = r101;
        this.f234937c = r102;
    }
}
