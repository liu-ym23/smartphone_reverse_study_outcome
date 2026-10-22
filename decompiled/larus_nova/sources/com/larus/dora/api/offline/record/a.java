package com.larus.dora.api.offline.record;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f331779a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f331780b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f331781c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f331782d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f331783e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f331784f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f331785g;

    /* JADX INFO: renamed from: com.larus.dora.api.offline.record.a$a, reason: collision with other inner class name */
    public static final class C4206a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f331779a == r101.f331779a) goto L12;
        return false;
    L12:
        if (this.f331780b == r101.f331780b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f331781c, r101.f331781c) == true) goto L18;
        return false;
    L18:
        if (this.f331782d == r101.f331782d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f331783e, r101.f331783e) == true) goto L24;
        return false;
    L24:
        if (this.f331784f == r101.f331784f) goto L27;
        return false;
    L27:
        if (this.f331785g == r101.f331785g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f331779a * 31) + this.f331780b) * 31) + this.f331781c.hashCode()) * 31) + this.f331782d) * 31;
        String r101 = this.f331783e;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (((r100 + r102) * 31) + this.f331784f) * 31;
        long r104 = this.f331785g;
        return r103 + ((int) (r104 ^ (r104 >>> 32)));
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "DoraOfflineRecordFileReadyNotify(status=" + this.f331779a + ", businessType=" + this.f331780b + ", vuiId=" + this.f331781c + ", contextType=" + this.f331782d + ", contextId=" + this.f331783e + ", fileType=" + this.f331784f + ", durationSec=" + this.f331785g + ')';
    }

    public a(int r100, int r101, String r102, int r103, String r104, int r105, long r106) {
        Intrinsics.checkNotNullParameter(r102, "vuiId");
        this.f331779a = r100;
        this.f331780b = r101;
        this.f331781c = r102;
        this.f331782d = r103;
        this.f331783e = r104;
        this.f331784f = r105;
        this.f331785g = r106;
    }
}
