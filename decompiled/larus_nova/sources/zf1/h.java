package zf1;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f571657a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f571658b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f571659c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof h) == false) goto L12;
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f571657a, r101.f571657a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f571658b, r101.f571658b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f571659c, r101.f571659c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f571657a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f571658b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f571659c;
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
        return "HighlightPreviewData(mainTitle=" + this.f571657a + ", subTitle=" + this.f571658b + ", m3u8Url=" + this.f571659c + ")";
    }

    public h(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "mainTitle");
        Intrinsics.checkNotNullParameter(r101, "subTitle");
        Intrinsics.checkNotNullParameter(r102, "m3u8Url");
        this.f571657a = r100;
        this.f571658b = r101;
        this.f571659c = r102;
    }
}
