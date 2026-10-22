package ct9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f465364a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f465365b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Boolean f465366c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f465367d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f465364a, r101.f465364a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f465365b, r101.f465365b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f465366c, r101.f465366c) == true) goto L18;
        return false;
    L18:
        if (this.f465367d == r101.f465367d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f465364a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f465365b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.f465366c;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return ((r106 + r101) * 31) + this.f465367d;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ThirdPartyAccountUiData(thirdPartyKey=" + this.f465364a + ", thirdPartyName=" + this.f465365b + ", choseStatus=" + this.f465366c + ", uiStatus=" + this.f465367d + ')';
    }

    public b() {
        this("", "", Boolean.FALSE, 0);
    }

    public b(String r100, String r101, Boolean r102, int r103) {
        this.f465364a = r100;
        this.f465365b = r101;
        this.f465366c = r102;
        this.f465367d = r103;
    }

    public static b a(b r100, Boolean r101, int r102, int r103) {
        String r104 = null;
        if ((r103 & 1) == 0) goto L5;
        String r105 = r100.f465364a;
    L7:
        if ((r103 & 2) == 0) goto L10;
        r104 = r100.f465365b;
    L10:
        if ((r103 & 4) == 0) goto L13;
        r101 = r100.f465366c;
    L13:
        if ((r103 & 8) == 0) goto L16;
        r102 = r100.f465367d;
    L16:
        return new b(r105, r104, r101, r102);
    L5:
        r105 = null;
        goto L7
    }
}
