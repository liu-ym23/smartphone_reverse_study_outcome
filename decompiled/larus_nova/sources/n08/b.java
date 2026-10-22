package n08;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f516610a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a[] f516611b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f516610a == r101.f516610a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f516611b, r101.f516611b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f516610a * 31) + Arrays.hashCode(this.f516611b);
    }

    public final String toString() {
        return "Week(row=" + this.f516610a + ", baseDays=" + Arrays.toString(this.f516611b) + ')';
    }

    public b(int r100) {
        a[] r101 = new a[7];
        Intrinsics.checkNotNullParameter(r101, "baseDays");
        this.f516610a = r100;
        this.f516611b = r101;
    }
}
