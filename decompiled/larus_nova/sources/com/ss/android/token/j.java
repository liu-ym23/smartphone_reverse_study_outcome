package com.ss.android.token;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class j {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f449754h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f449755a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f449756b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f449757c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f449758d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f449759e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final transient String f449760f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final transient String f449761g;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L34:
        return true;
    L5:
        if ((r100 instanceof j) == false) goto L33;
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.f449755a, r101.f449755a) == false) goto L33;
        if (this.f449756b != r101.f449756b) goto L11;
        boolean r102 = true;
    L12:
        if (r102 == false) goto L33;
        if (this.f449757c != r101.f449757c) goto L16;
        boolean r103 = true;
    L17:
        if (r103 == false) goto L33;
        if (this.f449758d != r101.f449758d) goto L21;
        boolean r104 = true;
    L22:
        if (r104 == false) goto L33;
        if (this.f449759e != r101.f449759e) goto L26;
        boolean r105 = true;
    L27:
        if (r105 == false) goto L33;
        if (Intrinsics.areEqual(this.f449760f, r101.f449760f) == false) goto L33;
        if (Intrinsics.areEqual(this.f449761g, r101.f449761g) == false) goto L33;
    L26:
        r105 = false;
        goto L27
    L21:
        r104 = false;
        goto L22
    L16:
        r103 = false;
        goto L17
    L11:
        r102 = false;
    L33:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f449755a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        long r103 = this.f449756b;
        int r104 = ((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        long r105 = this.f449757c;
        int r106 = (r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        long r107 = this.f449758d;
        int r108 = (((r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31) + this.f449759e) * 31;
        String r109 = this.f449760f;
        if (r109 == null) goto L9;
        int r110 = r109.hashCode();
    L10:
        int r111 = (r108 + r110) * 31;
        String r112 = this.f449761g;
        if (r112 == null) goto L14;
        r101 = r112.hashCode();
    L14:
        return r111 + r101;
    L9:
        r110 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "SecTimeStruct(secTime=" + this.f449755a + ", serverTime=" + this.f449756b + ", systemTime=" + this.f449757c + ", elapsedRealTimeMs=" + this.f449758d + ", rebootTimes=" + this.f449759e + ", path=" + this.f449760f + ", logId=" + this.f449761g + ")";
    }

    public j(String r100, long r101, long r102, long r103, int r104, String r105, String r110) {
        this.f449755a = r100;
        this.f449756b = r101;
        this.f449757c = r102;
        this.f449758d = r103;
        this.f449759e = r104;
        this.f449760f = r105;
        this.f449761g = r110;
    }
}
