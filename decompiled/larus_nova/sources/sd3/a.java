package sd3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Boolean f541445a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f541446b;

    public a() {
        this(null, 3);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L10;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f541445a, r101.f541445a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f541446b, r101.f541446b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        Boolean r100 = this.f541445a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f541446b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "GestureModel(isShowGesture=" + this.f541445a + ", productId=" + this.f541446b + ")";
    }

    public /* synthetic */ a(Boolean r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100, null);
    }

    public a(Boolean r100, String r101) {
        this.f541445a = r100;
        this.f541446b = r101;
    }
}
