package com.larus.office;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f362214a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f362215b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f362216c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f362217d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f362218e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.f362214a, r101.f362214a) == true) goto L12;
        return false;
    L12:
        if (this.f362215b == r101.f362215b) goto L15;
        return false;
    L15:
        if (this.f362216c == r101.f362216c) goto L18;
        return false;
    L18:
        if (this.f362217d == r101.f362217d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f362218e, r101.f362218e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f362214a.hashCode() * 31;
        long r101 = this.f362215b;
        int r102 = (((((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f362216c) * 31) + this.f362217d) * 31;
        String r103 = this.f362218e;
        if (r103 != null) goto L5;
        int r104 = 0;
    L7:
        return r102 + r104;
    L5:
        r104 = r103.hashCode();
        goto L7
    }

    public final String toString() {
        return "OfficeOnlineDocumentRetryRequest(conversationId=" + this.f362214a + ", messageId=" + this.f362215b + ", resourceType=" + this.f362216c + ", sourceType=" + this.f362217d + ", realToken=" + this.f362218e + ')';
    }

    public j(String r100, long r101, int r102, int r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        this.f362214a = r100;
        this.f362215b = r101;
        this.f362216c = r102;
        this.f362217d = r103;
        this.f362218e = r104;
    }
}
