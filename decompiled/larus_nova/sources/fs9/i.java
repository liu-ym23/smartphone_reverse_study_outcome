package fs9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final nr9.g f478675a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f478676b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f478677c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f478678d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f478679e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f478675a, r101.f478675a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f478676b, r101.f478676b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f478677c, r101.f478677c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f478678d, r101.f478678d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f478679e, r101.f478679e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f478675a.hashCode() * 31;
        String r101 = this.f478676b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f478677c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f478678d;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f478679e;
        if (r111 == null) goto L19;
        r102 = r111.hashCode();
    L19:
        return r110 + r102;
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "DoVideoEditInitParams(videoPlayData=" + this.f478675a + ", msgId=" + this.f478676b + ", prompt=" + this.f478677c + ", refImageUrl=" + this.f478678d + ", creationTaskId=" + this.f478679e + ')';
    }

    public i(nr9.g r100, String r101, String r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "videoPlayData");
        this.f478675a = r100;
        this.f478676b = r101;
        this.f478677c = r102;
        this.f478678d = r103;
        this.f478679e = r104;
    }
}
