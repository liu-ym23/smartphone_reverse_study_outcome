package com.larus.audio.call.aec;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f289022a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f289023b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f289024c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f289025d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof z) == true) goto L8;
        return false;
    L8:
        z r101 = (z) r100;
        if (this.f289022a == r101.f289022a) goto L12;
        return false;
    L12:
        if (this.f289023b == r101.f289023b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f289024c, r101.f289024c) == true) goto L18;
        return false;
    L18:
        if (this.f289025d == r101.f289025d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f289022a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f289023b;
        int r103 = (((r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31) + Arrays.hashCode(this.f289024c)) * 31;
        if (this.f289025d == false) goto L5;
        int r104 = 1231;
    L7:
        return r103 + r104;
    L5:
        r104 = 1237;
        goto L7
    }

    public final String toString() {
        return "TtsData(startTime=" + this.f289022a + ", endTime=" + this.f289023b + ", data=" + Arrays.toString(this.f289024c) + ", hasModify=" + this.f289025d + ')';
    }

    public z(long r100, long r101, byte[] r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r102, "data");
        this.f289022a = r100;
        this.f289023b = r101;
        this.f289024c = r102;
        this.f289025d = r103;
    }

    public static z a(z r100, long r101, long r110, byte[] r111, boolean r112, int r113) {
        if ((r113 & 1) == 0) goto L5;
        r101 = r100.f289022a;
    L5:
        long r102 = r101;
        if ((r113 & 2) == 0) goto L8;
        r110 = r100.f289023b;
    L8:
        long r103 = r110;
        if ((r113 & 4) == 0) goto L11;
        r111 = r100.f289024c;
    L11:
        byte[] r104 = r111;
        if ((r113 & 8) == 0) goto L14;
        r112 = r100.f289025d;
    L14:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r104, "data");
        return new z(r102, r103, r104, r112);
    }
}
