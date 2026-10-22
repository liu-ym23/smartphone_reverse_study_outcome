package com.larus.dora.impl.onboarding.othersmart.streamlined;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f337296a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n0 f337297b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f337298c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final o0 f337299d;

    /* JADX WARN: Multi-variable type inference failed */
    public o() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 15);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o) == true) goto L8;
        return false;
    L8:
        o r101 = (o) r100;
        if (this.f337296a == r101.f337296a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f337297b, r101.f337297b) == true) goto L15;
        return false;
    L15:
        if (this.f337298c == r101.f337298c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f337299d, r101.f337299d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f337296a;
        int r101 = ((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f337297b.hashCode()) * 31;
        if (this.f337298c == false) goto L5;
        int r102 = 1231;
    L7:
        return ((r101 + r102) * 31) + this.f337299d.hashCode();
    L5:
        r102 = 1237;
        goto L7
    }

    public final String toString() {
        return "DoraHStreamlinedInterruptUiState(roundToken=" + this.f337296a + ", query=" + this.f337297b + ", shouldPlayEntryAnimation=" + this.f337298c + ", reply=" + this.f337299d + ')';
    }

    public /* synthetic */ o(n0.a r100, o0.b r101, int r102) {
        if ((r102 & 2) == 0) goto L5;
        r100 = n0.a.f337289a;
    L5:
        n0.a r103 = r100;
        if ((r102 & 8) == 0) goto L8;
        r101 = o0.b.f337302a;
    L8:
        this(0, r103, false, r101);
    }

    public o(long r100, n0 r101, boolean r102, o0 r103) {
        Intrinsics.checkNotNullParameter(r101, "query");
        Intrinsics.checkNotNullParameter(r103, "reply");
        this.f337296a = r100;
        this.f337297b = r101;
        this.f337298c = r102;
        this.f337299d = r103;
    }

    public static o a(o r100, long r101, n0 r102, o0 r110, int r111) {
        if ((r111 & 1) == 0) goto L5;
        r101 = r100.f337296a;
    L5:
        long r103 = r101;
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.f337297b;
    L8:
        n0 r104 = r102;
        if ((r111 & 4) == 0) goto L11;
        boolean r105 = r100.f337298c;
    L13:
        if ((r111 & 8) == 0) goto L15;
        r110 = r100.f337299d;
    L15:
        o0 r106 = r110;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r104, "query");
        Intrinsics.checkNotNullParameter(r106, "reply");
        return new o(r103, r104, r105, r106);
    L11:
        r105 = false;
        goto L13
    }
}
