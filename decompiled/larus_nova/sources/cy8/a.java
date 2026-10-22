package cy8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f465801a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i f465802b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n f465803c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h f465804d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final e f465805e;

    public a() {
        this(null, null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f465801a, r101.f465801a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f465802b, r101.f465802b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f465803c, r101.f465803c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f465804d, r101.f465804d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f465805e, r101.f465805e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        k r100 = this.f465801a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        i r104 = this.f465802b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        n r107 = this.f465803c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        h r110 = this.f465804d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        e r113 = this.f465805e;
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
        return "CanvasBlockContent(canvasInfo=" + this.f465801a + ", image=" + this.f465802b + ", msgInfo=" + this.f465803c + ", generateData=" + this.f465804d + ", creation=" + this.f465805e + ')';
    }

    public a(k r100, i r101, n r102, h r103, e r104) {
        this.f465801a = r100;
        this.f465802b = r101;
        this.f465803c = r102;
        this.f465804d = r103;
        this.f465805e = r104;
    }
}
