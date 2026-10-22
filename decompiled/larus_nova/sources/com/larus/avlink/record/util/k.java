package com.larus.avlink.record.util;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f294424a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f294425b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f294426c;

    public k() {
        this(0, "", 0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (this.f294424a == r101.f294424a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f294425b, r101.f294425b) == true) goto L15;
        return false;
    L15:
        if (this.f294426c == r101.f294426c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f294424a * 31) + this.f294425b.hashCode()) * 31) + this.f294426c;
    }

    public final String toString() {
        return "LarkRecordSession(wakeId=" + this.f294424a + ", source=" + this.f294425b + ", recordType=" + this.f294426c + ')';
    }

    public k(int r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r101, "source");
        this.f294424a = r100;
        this.f294425b = r101;
        this.f294426c = r102;
    }
}
