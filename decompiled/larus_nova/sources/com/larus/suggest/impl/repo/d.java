package com.larus.suggest.impl.repo;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f369915a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f369916b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f369917c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f369918d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f369919e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f369920f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f369921g;

    public d() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (this.f369915a == r101.f369915a) goto L12;
        return false;
    L12:
        if (this.f369916b == r101.f369916b) goto L15;
        return false;
    L15:
        if (this.f369917c == r101.f369917c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f369918d, r101.f369918d) == true) goto L21;
        return false;
    L21:
        if (this.f369919e == r101.f369919e) goto L24;
        return false;
    L24:
        if (this.f369920f == r101.f369920f) goto L27;
        return false;
    L27:
        if (this.f369921g == r101.f369921g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f369915a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f369916b;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.f369917c;
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        String r106 = this.f369918d;
        if (r106 != null) goto L5;
        int r107 = 0;
    L6:
        long r108 = this.f369919e;
        int r109 = (((r105 + r107) * 31) + ((int) (r108 ^ (r108 >>> 32)))) * 31;
        long r110 = this.f369920f;
        int r111 = (r109 + ((int) (r110 ^ (r110 >>> 32)))) * 31;
        long r112 = this.f369921g;
        return r111 + ((int) (r112 ^ (r112 >>> 32)));
    L5:
        r107 = r106.hashCode();
        goto L6
    }

    public final String toString() {
        return "WcbPolicyState(expireTimeSec=" + this.f369915a + ", responseVersion=" + this.f369916b + ", lastRequestTimeMs=" + this.f369917c + ", throughToken=" + this.f369918d + ", freqReqIntervalSec=" + this.f369919e + ", freqControlIntervalSec=" + this.f369920f + ", updateTimeMs=" + this.f369921g + ')';
    }

    public /* synthetic */ d(int r110) {
        this(0, 0, 0, null, 0, 0, 0);
    }

    public d(long r100, long r101, long r102, String r103, long r104, long r110, long r111) {
        this.f369915a = r100;
        this.f369916b = r101;
        this.f369917c = r102;
        this.f369918d = r103;
        this.f369919e = r104;
        this.f369920f = r110;
        this.f369921g = r111;
    }

    public static d a(d r110, long r111, long r112, long r113, String r210, long r211, long r212, long r213, int r214) {
        if ((r214 & 1) == 0) goto L5;
        long r100 = r110.f369915a;
    L7:
        if ((r214 & 2) == 0) goto L9;
        long r101 = r110.f369916b;
    L11:
        if ((r214 & 4) == 0) goto L13;
        long r102 = r110.f369917c;
    L15:
        if ((r214 & 8) == 0) goto L17;
        String r103 = r110.f369918d;
    L19:
        if ((r214 & 16) == 0) goto L21;
        long r104 = r110.f369919e;
    L23:
        if ((r214 & 32) == 0) goto L25;
        long r114 = r110.f369920f;
    L27:
        if ((r214 & 64) == 0) goto L29;
        long r115 = r110.f369921g;
    L31:
        return new d(r100, r101, r102, r103, r104, r114, r115);
    L29:
        r115 = r213;
        goto L31
    L25:
        r114 = r212;
        goto L27
    L21:
        r104 = r211;
        goto L23
    L17:
        r103 = r210;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }
}
