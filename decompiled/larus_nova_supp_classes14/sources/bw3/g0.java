package bw3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class g0 {
    public final String a;
    public final String b;
    public final int c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof g0) == true) goto L8;
        return false;
    L8:
        g0 r6 = (g0) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c;
    }

    public final String toString() {
        return "InnerAudioResolvedSource(originalSrc=" + this.a + ", playSource=" + this.b + ", sourceType=" + this.c + ')';
    }

    public g0(String r2, String r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "originalSrc");
        Intrinsics.checkNotNullParameter(r3, "playSource");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
