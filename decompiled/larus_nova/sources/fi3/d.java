package fi3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f477252c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f477253a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f477254b;

    public static final class a {
    }

    static {
    }

    public d() {
        this(null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L10;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f477253a, r101.f477253a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f477254b, r101.f477254b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f477253a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f477254b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ClickSearchBarActionParams(schema=" + this.f477253a + ", btm=" + this.f477254b + ")";
    }

    public d(String r100, String r101) {
        this.f477253a = r100;
        this.f477254b = r101;
    }
}
