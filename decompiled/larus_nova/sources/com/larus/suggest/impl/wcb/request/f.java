package com.larus.suggest.impl.wcb.request;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f370113a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f370114b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f370115c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f370116d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f370117e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c f370118f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f370113a, r101.f370113a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f370114b, r101.f370114b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f370115c, r101.f370115c) == true) goto L18;
        return false;
    L18:
        if (this.f370116d == r101.f370116d) goto L21;
        return false;
    L21:
        if (this.f370117e == r101.f370117e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f370118f, r101.f370118f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f370113a.hashCode() * 31) + this.f370114b.hashCode()) * 31) + this.f370115c.hashCode()) * 31;
        long r101 = this.f370116d;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.f370117e;
        return ((r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31) + this.f370118f.hashCode();
    }

    public final String toString() {
        return "WcbRequestSnapshot(userId=" + this.f370113a + ", conversationId=" + this.f370114b + ", botId=" + this.f370115c + ", chatKey=" + this.f370116d + ", executionId=" + this.f370117e + ", request=" + this.f370118f + ')';
    }

    public f(String r100, String r101, String r102, long r103, long r104, c r105) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        Intrinsics.checkNotNullParameter(r101, "conversationId");
        Intrinsics.checkNotNullParameter(r102, "botId");
        Intrinsics.checkNotNullParameter(r105, "request");
        this.f370113a = r100;
        this.f370114b = r101;
        this.f370115c = r102;
        this.f370116d = r103;
        this.f370117e = r104;
        this.f370118f = r105;
    }
}
