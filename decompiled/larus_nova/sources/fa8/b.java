package fa8;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f476041a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f476042b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f476041a, r101.f476041a) == true) goto L12;
        return false;
    L12:
        if (this.f476042b == r101.f476042b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (Arrays.hashCode(this.f476041a) * 31) + this.f476042b;
    }

    public final String toString() {
        return "BufferChunk(data=" + Arrays.toString(this.f476041a) + ", readOffset=" + this.f476042b + ')';
    }

    public b(byte[] r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.f476041a = r100;
        this.f476042b = 0;
    }
}
