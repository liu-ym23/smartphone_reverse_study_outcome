package p5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f527730a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f527731b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f527732c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f527733d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f527734e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f527735f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f527730a, r101.f527730a) == true) goto L12;
        return false;
    L12:
        if (this.f527731b == r101.f527731b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f527732c, r101.f527732c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f527733d, r101.f527733d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f527734e, r101.f527734e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f527735f, r101.f527735f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f527730a.hashCode() * 31;
        long r101 = this.f527731b;
        int r102 = (((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f527732c.hashCode()) * 31;
        String r103 = this.f527733d;
        int r104 = 0;
        if (r103 != null) goto L5;
        int r105 = 0;
    L6:
        int r106 = (r102 + r105) * 31;
        b r107 = this.f527734e;
        if (r107 == null) goto L11;
        r104 = r107.hashCode();
    L11:
        return ((r106 + r104) * 31) + this.f527735f.hashCode();
    L5:
        r105 = r103.hashCode();
        goto L6
    }

    public final String toString() {
        return "AppletResponse(response=" + this.f527730a + ", version=" + this.f527731b + ", resFrom=" + this.f527732c + ", filePath=" + this.f527733d + ", byteArray=" + this.f527734e + ", uri=" + this.f527735f + ')';
    }

    public a(String r100, long r101, String r102, String r103, b r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "response");
        Intrinsics.checkNotNullParameter(r102, "resFrom");
        Intrinsics.checkNotNullParameter(r105, "uri");
        this.f527730a = r100;
        this.f527731b = r101;
        this.f527732c = r102;
        this.f527733d = r103;
        this.f527734e = r104;
        this.f527735f = r105;
    }
}
