package zg1;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class a2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Long f571791a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f571792b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f571793c;

    public a2() {
        this(null, null, null, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a2) == false) goto L12;
        a2 r101 = (a2) r100;
        if (Intrinsics.areEqual(this.f571791a, r101.f571791a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f571792b, r101.f571792b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f571793c, r101.f571793c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        Long r100 = this.f571791a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f571792b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f571793c;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "OpenInteractItemEvent(gameId=" + this.f571791a + ", appId=" + this.f571792b + ", guideActivityName=" + this.f571793c + ")";
    }

    public a2(Long r100, String r101, String r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r100 = -1L;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this.f571791a = r100;
        this.f571792b = r101;
        this.f571793c = r102;
    }
}
