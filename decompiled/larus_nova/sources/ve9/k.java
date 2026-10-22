package ve9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f554469a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f554470b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f554471c;

    public k() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (this.f554469a == r101.f554469a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f554470b, r101.f554470b) == true) goto L15;
        return false;
    L15:
        if (this.f554471c == r101.f554471c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        if (this.f554469a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = ((r100 * 31) + this.f554470b.hashCode()) * 31;
        long r102 = this.f554471c;
        return r101 + ((int) (r102 ^ (r102 >>> 32)));
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "OneshotConfig(enable=" + this.f554469a + ", keyword=" + this.f554470b + ", offset=" + this.f554471c + ')';
    }

    public k(int r100) {
        Intrinsics.checkNotNullParameter("", "keyword");
        this.f554469a = false;
        this.f554470b = "";
        this.f554471c = 0;
    }
}
