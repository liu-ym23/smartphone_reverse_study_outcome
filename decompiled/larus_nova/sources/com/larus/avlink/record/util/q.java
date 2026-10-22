package com.larus.avlink.record.util;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f294430a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f294431b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f294432c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f294433d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f294434e;

    public q() {
        this(null, 0, null, 0, 31);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q) == true) goto L8;
        return false;
    L8:
        q r101 = (q) r100;
        if (Intrinsics.areEqual(this.f294430a, r101.f294430a) == true) goto L12;
        return false;
    L12:
        if (this.f294431b == r101.f294431b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f294432c, r101.f294432c) == true) goto L18;
        return false;
    L18:
        if (this.f294433d == r101.f294433d) goto L21;
        return false;
    L21:
        if (this.f294434e == r101.f294434e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f294430a.hashCode() * 31) + this.f294431b) * 31) + this.f294432c.hashCode()) * 31) + this.f294433d) * 31;
        long r101 = this.f294434e;
        return r100 + ((int) (r101 ^ (r101 >>> 32)));
    }

    public final String toString() {
        return "PendingRecordSession(messageId=" + this.f294430a + ", wakeId=" + this.f294431b + ", source=" + this.f294432c + ", recordType=" + this.f294433d + ", createdAt=" + this.f294434e + ')';
    }

    public /* synthetic */ q(String r110, int r111, String r112, int r113, int r114) {
        if ((r114 & 1) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r114 & 2) == 0) goto L9;
        int r101 = 0;
    L11:
        if ((r114 & 4) == 0) goto L13;
        String r102 = "";
    L15:
        if ((r114 & 8) == 0) goto L17;
        int r103 = 0;
    L19:
        if ((r114 & 16) == 0) goto L21;
        long r115 = System.currentTimeMillis();
    L22:
        this(r100, r101, r102, r103, r115);
        return;
    L21:
        r115 = 0;
        goto L22
    L17:
        r103 = r113;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    public static q a(q r100, String r101, int r102, int r110, int r111) {
        if ((r111 & 1) == 0) goto L5;
        r101 = r100.f294430a;
    L5:
        String r103 = r101;
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.f294431b;
    L8:
        int r104 = r102;
        if ((r111 & 4) == 0) goto L11;
        String r105 = r100.f294432c;
    L12:
        String r106 = r105;
        if ((r111 & 8) == 0) goto L15;
        r110 = r100.f294433d;
    L15:
        int r107 = r110;
        if ((r111 & 16) == 0) goto L18;
        long r108 = r100.f294434e;
    L19:
        Intrinsics.checkNotNullParameter(r103, "messageId");
        Intrinsics.checkNotNullParameter(r106, "source");
        return new q(r103, r104, r106, r107, r108);
    L18:
        r108 = 0;
        goto L19
    L11:
        r105 = null;
        goto L12
    }

    public q(String r100, int r101, String r102, int r103, long r104) {
        Intrinsics.checkNotNullParameter(r100, "messageId");
        Intrinsics.checkNotNullParameter(r102, "source");
        this.f294430a = r100;
        this.f294431b = r101;
        this.f294432c = r102;
        this.f294433d = r103;
        this.f294434e = r104;
    }
}
