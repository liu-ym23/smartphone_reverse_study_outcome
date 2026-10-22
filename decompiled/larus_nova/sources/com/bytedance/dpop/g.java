package com.bytedance.dpop;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f204788a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f204789b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h f204790c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f204788a, r101.f204788a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f204789b, r101.f204789b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f204790c, r101.f204790c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.f204788a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f204789b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        h r107 = this.f204790c;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "DPoPTicketResponse(code=" + this.f204788a + ", msg=" + this.f204789b + ", data=" + this.f204790c + ')';
    }

    public g() {
        this.f204788a = null;
        this.f204789b = null;
        this.f204790c = null;
    }
}
