package rp8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class a implements m1a.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Boolean f538872a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f538873b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Boolean f538874c;

    public a() {
        this(null, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f538872a, r101.f538872a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f538873b, r101.f538873b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f538874c, r101.f538874c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        Boolean r100 = this.f538872a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.f538873b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.f538874c;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ActionEntranceConfig(enabled=" + this.f538872a + ", entranceType=" + this.f538873b + ", keepVisibleOnFocus=" + this.f538874c + ')';
    }

    public /* synthetic */ a(Integer r100, int r101) {
        if ((r101 & 2) == 0) goto L5;
        r100 = null;
    L5:
        this(null, r100, null);
    }

    public a(Boolean r100, Integer r101, Boolean r102) {
        this.f538872a = r100;
        this.f538873b = r101;
        this.f538874c = r102;
    }
}
