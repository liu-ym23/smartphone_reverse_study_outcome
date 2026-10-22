package va8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f553979a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f553980b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f553981c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof t0) == true) goto L8;
        return false;
    L8:
        t0 r101 = (t0) r100;
        if (Intrinsics.areEqual(this.f553979a, r101.f553979a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f553980b, r101.f553980b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f553981c, r101.f553981c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f553979a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f553980b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f553981c;
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
        return "ViewBusinessPayload(biz=" + this.f553979a + ", type=" + this.f553980b + ", bizParam=" + this.f553981c + ')';
    }

    public final String getType() {
        return this.f553980b;
    }

    public t0(String r100, String r101, String r102) {
        this.f553979a = r100;
        this.f553980b = r101;
        this.f553981c = r102;
    }
}
