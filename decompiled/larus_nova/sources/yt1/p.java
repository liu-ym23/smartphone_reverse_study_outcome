package yt1;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f569035a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f569036b;

    public p() {
        String r100 = null;
        this(r100, r100, 3);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof p) == false) goto L10;
        p r101 = (p) r100;
        if (Intrinsics.areEqual(this.f569035a, r101.f569035a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f569036b, r101.f569036b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f569035a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f569036b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "TemplateDataSource(content=" + this.f569035a + ", url=" + this.f569036b + ")";
    }

    public p(String r100, String r101) {
        this.f569035a = r100;
        this.f569036b = r101;
    }

    public /* synthetic */ p(String r100, String r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
