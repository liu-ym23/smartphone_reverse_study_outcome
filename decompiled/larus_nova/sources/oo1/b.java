package oo1;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f524519a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f524520b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f524521c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L12;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f524519a, r101.f524519a) == true) goto L8;
        return false;
    L8:
        if (this.f524520b == r101.f524520b) goto L10;
        return false;
    L10:
        if (this.f524521c == r101.f524521c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        byte[] r100 = this.f524519a;
        if (r100 == null) goto L5;
        int r101 = Arrays.hashCode(r100);
    L6:
        int r102 = ((r101 * 31) + this.f524520b) * 31;
        long r103 = this.f524521c;
        return r102 + ((int) (r103 ^ (r103 >>> 32)));
    L5:
        r101 = 0;
        goto L6
    }

    public final String toString() {
        return "AudioDataFrame(inout=" + Arrays.toString(this.f524519a) + ", samples=" + this.f524520b + ", timestamp=" + this.f524521c + ")";
    }

    public b(byte[] r100, int r101, long r102) {
        this.f524519a = r100;
        this.f524520b = r101;
        this.f524521c = r102;
    }
}
