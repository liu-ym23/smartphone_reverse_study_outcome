package jv2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f500543a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f500544b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L10;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f500543a, r101.f500543a) == true) goto L8;
        return false;
    L8:
        if (this.f500544b == r101.f500544b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f500543a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L7:
        return (r101 * 31) + this.f500544b;
    L5:
        r101 = 0;
        goto L7
    }

    public final String toString() {
        return "CropProcessResult(filePath=" + this.f500543a + ", errorMsgId=" + this.f500544b + ")";
    }

    public a(String r100, int r101) {
        this.f500543a = r100;
        this.f500544b = r101;
    }
}
