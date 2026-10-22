package ev6;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f474263a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Float f474264b;

    public a0() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a0) == true) goto L8;
        return false;
    L8:
        a0 r101 = (a0) r100;
        if (Intrinsics.areEqual(this.f474263a, r101.f474263a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f474264b, r101.f474264b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f474263a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Float r104 = this.f474264b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ShelfProductPrefixPriceUIData(text=" + this.f474263a + ", textSize=" + this.f474264b + ')';
    }

    public a0(int r100) {
        this.f474263a = null;
        this.f474264b = null;
    }
}
