package ev6;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f474317a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f474318b;

    public g0() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g0) == true) goto L8;
        return false;
    L8:
        g0 r101 = (g0) r100;
        if (this.f474317a == r101.f474317a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f474318b, r101.f474318b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.f474317a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        String r102 = this.f474318b;
        if (r102 != null) goto L9;
        int r103 = 0;
    L11:
        return r101 + r103;
    L9:
        r103 = r102.hashCode();
        goto L11
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "ShelfProductStatusInfoUIData(visible=" + this.f474317a + ", text=" + this.f474318b + ')';
    }

    public g0(int r100) {
        this.f474317a = false;
        this.f474318b = null;
    }
}
