package dsc;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class v0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f469932a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f469933b;

    public v0() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof v0) == true) goto L8;
        return false;
    L8:
        v0 r101 = (v0) r100;
        if (Intrinsics.areEqual(this.f469932a, r101.f469932a) == true) goto L12;
        return false;
    L12:
        if (Float.compare(this.f469933b, r101.f469933b) == 0) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f469932a.hashCode() * 31) + Float.floatToIntBits(this.f469933b);
    }

    public final String toString() {
        return "TextSubLine(text=" + this.f469932a + ", width=" + this.f469933b + ')';
    }

    public v0(int r100) {
        Intrinsics.checkNotNullParameter("", "text");
        this.f469932a = "";
        this.f469933b = 0.0f;
    }
}
