package wa8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class e1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f558849a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f558850b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f558851c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f558852d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f558853e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e1) == true) goto L8;
        return false;
    L8:
        e1 r101 = (e1) r100;
        if (Intrinsics.areEqual(this.f558849a, r101.f558849a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f558850b, r101.f558850b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f558851c, r101.f558851c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f558852d, r101.f558852d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f558853e, r101.f558853e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f558849a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f558850b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.f558851c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.f558852d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.f558853e;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "CreationReferenceIcon(uri=" + this.f558849a + ", url=" + this.f558850b + ", width=" + this.f558851c + ", height=" + this.f558852d + ", radius=" + this.f558853e + ')';
    }

    public e1(String r100, String r101, Integer r102, Integer r103, Integer r104) {
        this.f558849a = r100;
        this.f558850b = r101;
        this.f558851c = r102;
        this.f558852d = r103;
        this.f558853e = r104;
    }
}
