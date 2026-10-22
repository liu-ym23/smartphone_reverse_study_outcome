package guc;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes42.dex */
public final class a implements Comparable<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f482804a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f482805b;

    public final int hashCode() {
        throw new UnsupportedOperationException("DecimalFraction is not supposed to be used as a hash key");
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder();
        int r101 = b.f482806a[this.f482805b];
        r100.append(this.f482804a / r101);
        r100.append('.');
        r100.append(StringsKt.removePrefix(String.valueOf(r101 + (this.f482804a % r101)), "1"));
        return r100.toString();
    }

    public final int a(int r100) {
        int r101 = this.f482805b;
        if (r100 == r101) goto L10;
        int[] r102 = b.f482806a;
        if (r100 <= r101) goto L9;
        int r103 = this.f482804a;
        return r102[r100 - r101] * r103;
    L9:
        return this.f482804a / r102[r101 - r100];
    L10:
        return this.f482804a;
    }

    @Override // java.lang.Comparable
    public final int compareTo(a r100) {
        a r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "other");
        int r102 = Math.max(this.f482805b, r101.f482805b);
        return Intrinsics.compare(a(r102), r101.a(r102));
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof a) == false) goto L7;
        a r101 = (a) r100;
        Intrinsics.checkNotNullParameter(r101, "other");
        int r102 = Math.max(this.f482805b, r101.f482805b);
        if (Intrinsics.compare(a(r102), r101.a(r102)) != 0) goto L7;
        return true;
    L7:
        return false;
    }

    public a(int r100, int r101) {
        this.f482804a = r100;
        this.f482805b = r101;
        if (r101 < 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L9;
        return;
    L9:
        throw new IllegalArgumentException(("Digits must be non-negative, but was " + r101).toString());
    L5:
        r102 = false;
        goto L6
    }
}
