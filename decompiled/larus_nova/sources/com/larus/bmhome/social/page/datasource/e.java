package com.larus.bmhome.social.page.datasource;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class e<Key> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Key f314023a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f314024b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f314023a, r101.f314023a) == true) goto L12;
        return false;
    L12:
        if (this.f314024b == r101.f314024b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        Key r100 = this.f314023a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (r101 * 31) + this.f314024b;
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public final String toString() {
        return "FlowPagingRequest(offset=" + this.f314023a + ", pageSize=" + this.f314024b + ')';
    }

    public e() {
        this.f314023a = null;
        this.f314024b = 0;
    }
}
