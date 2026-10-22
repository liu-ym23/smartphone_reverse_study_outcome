package com.larus.im.internal.tracking;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f350290a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f350291b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f350292c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f350293d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f350294e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f350295f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f350296g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f350297h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f350290a, r101.f350290a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f350291b, r101.f350291b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f350292c, r101.f350292c) == true) goto L18;
        return false;
    L18:
        if (this.f350293d == r101.f350293d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f350294e, r101.f350294e) == true) goto L24;
        return false;
    L24:
        if (this.f350295f == r101.f350295f) goto L27;
        return false;
    L27:
        if (this.f350296g == r101.f350296g) goto L30;
        return false;
    L30:
        if (this.f350297h == r101.f350297h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f350290a.hashCode() * 31) + this.f350291b.hashCode()) * 31) + this.f350292c.hashCode()) * 31;
        long r101 = this.f350293d;
        int r102 = (((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f350294e.hashCode()) * 31;
        long r103 = this.f350295f;
        int r104 = (r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        long r105 = this.f350296g;
        int r106 = (r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        long r107 = this.f350297h;
        return r106 + ((int) (r107 ^ (r107 >>> 32)));
    }

    public final String toString() {
        return "ChunkDataInterceptInfo(conversationId=" + this.f350290a + ", questionId=" + this.f350291b + ", token=" + this.f350292c + ", cmd=" + this.f350293d + ", answerId=" + this.f350294e + ", seqNo=" + this.f350295f + ", receiveStartTime=" + this.f350296g + ", interceptTime=" + this.f350297h + ')';
    }

    public a() {
        this("", "", "", -1, "", -1, -1, -1);
    }

    public a(String r100, String r101, String r102, long r103, String r104, long r105, long r110, long r111) {
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        Intrinsics.checkNotNullParameter(r101, "questionId");
        Intrinsics.checkNotNullParameter(r102, "token");
        Intrinsics.checkNotNullParameter(r104, "answerId");
        this.f350290a = r100;
        this.f350291b = r101;
        this.f350292c = r102;
        this.f350293d = r103;
        this.f350294e = r104;
        this.f350295f = r105;
        this.f350296g = r110;
        this.f350297h = r111;
    }
}
