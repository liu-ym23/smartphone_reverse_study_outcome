package com.larus.agents.impl.webfetch;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f286859a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f286860b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f286861c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f286862d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f286863e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f286864f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f286859a, r101.f286859a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f286860b, r101.f286860b) == true) goto L15;
        return false;
    L15:
        if (this.f286861c == r101.f286861c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f286862d, r101.f286862d) == true) goto L21;
        return false;
    L21:
        if (this.f286863e == r101.f286863e) goto L24;
        return false;
    L24:
        if (this.f286864f == r101.f286864f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f286859a.hashCode() * 31) + this.f286860b.hashCode()) * 31) + this.f286861c) * 31;
        String r101 = this.f286862d;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f286863e == false) goto L9;
        int r104 = 1231;
    L11:
        return ((r103 + r104) * 31) + this.f286864f;
    L9:
        r104 = 1237;
        goto L11
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "WebFetchCommand(redacted)";
    }

    public i(String r100, String r101, int r102, String r103, boolean r104, int r105) {
        Intrinsics.checkNotNullParameter(r100, "commandId");
        Intrinsics.checkNotNullParameter(r101, "sourceDeviceId");
        this.f286859a = r100;
        this.f286860b = r101;
        this.f286861c = r102;
        this.f286862d = r103;
        this.f286863e = r104;
        this.f286864f = r105;
    }
}
