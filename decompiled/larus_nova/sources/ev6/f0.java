package ev6;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f474312a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f474313b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Float f474314c;

    public f0() {
        this(false, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f0) == true) goto L8;
        return false;
    L8:
        f0 r101 = (f0) r100;
        if (this.f474312a == r101.f474312a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f474313b, r101.f474313b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f474314c, r101.f474314c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        if (this.f474312a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        String r102 = this.f474313b;
        int r103 = 0;
        if (r102 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r101 + r104) * 31;
        Float r106 = this.f474314c;
        if (r106 == null) goto L15;
        r103 = r106.hashCode();
    L15:
        return r105 + r103;
    L9:
        r104 = r102.hashCode();
        goto L10
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "ShelfProductSoldInfoUIData(visible=" + this.f474312a + ", text=" + this.f474313b + ", textSize=" + this.f474314c + ')';
    }

    public f0(boolean r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        r100 = false;
    L5:
        this.f474312a = r100;
        this.f474313b = null;
        this.f474314c = null;
    }
}
