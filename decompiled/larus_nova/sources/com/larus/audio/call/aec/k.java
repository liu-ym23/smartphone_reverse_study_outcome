package com.larus.audio.call.aec;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f289008a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f289009b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f289010c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (this.f289008a == r101.f289008a) goto L12;
        return false;
    L12:
        if (this.f289009b == r101.f289009b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f289010c, r101.f289010c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f289008a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f289009b;
        return ((r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31) + Arrays.hashCode(this.f289010c);
    }

    public final String toString() {
        return "AecRefBlock(startTime=" + this.f289008a + ", endTime=" + this.f289009b + ", data=" + Arrays.toString(this.f289010c) + ')';
    }

    public k(long r100, long r101, byte[] r102) {
        Intrinsics.checkNotNullParameter(r102, "data");
        this.f289008a = r100;
        this.f289009b = r101;
        this.f289010c = r102;
    }

    public static k a(k r100, long r101, long r102) {
        byte[] r103 = r100.f289010c;
        Intrinsics.checkNotNullParameter(r103, "data");
        return new k(r101, r102, r103);
    }
}
