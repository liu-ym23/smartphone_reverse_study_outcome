package yt1;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f569037a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f569038b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f569039c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof q) == false) goto L12;
        q r101 = (q) r100;
        if (Intrinsics.areEqual(this.f569037a, r101.f569037a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f569038b, r101.f569038b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f569039c, r101.f569039c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f569037a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f569038b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f569039c;
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
        return "TemplateKey(id=" + this.f569037a + ", hashCode=" + this.f569038b + ", version=" + this.f569039c + ")";
    }

    public q(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "hashCode");
        Intrinsics.checkNotNullParameter("", "version");
        this.f569037a = r100;
        this.f569038b = r101;
        this.f569039c = "";
    }
}
