package lh2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f509227a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f509228b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final transient ql.a f509229c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L12;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f509227a, r101.f509227a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f509228b, r101.f509228b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f509229c, r101.f509229c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f509227a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f509228b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        ql.a r107 = this.f509229c;
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
        return "ProductAddCartParamModel(roomId=" + this.f509227a + ", roomUniqueKey=" + this.f509228b + ", promotion=" + this.f509229c + ")";
    }

    public a(String r100, String r101, ql.a r102) {
        Intrinsics.checkNotNullParameter(r102, "promotion");
        this.f509227a = r100;
        this.f509228b = r101;
        this.f509229c = r102;
    }
}
