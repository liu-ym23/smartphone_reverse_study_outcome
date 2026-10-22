package jba;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f498057a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f498058b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f498059c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f498060d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f498061e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f498062f;

    /* JADX WARN: Multi-variable type inference failed */
    public f() {
        int r100 = 0;
        Object[] r101 = 0 == true ? 1 : 0;
        this(r100, r101, null, 63);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (this.f498057a == r101.f498057a) goto L12;
        return false;
    L12:
        if (this.f498058b == r101.f498058b) goto L15;
        return false;
    L15:
        if (this.f498059c == r101.f498059c) goto L18;
        return false;
    L18:
        if (this.f498060d == r101.f498060d) goto L21;
        return false;
    L21:
        if (this.f498061e == r101.f498061e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f498062f, r101.f498062f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f498057a * 31) + this.f498058b) * 31) + this.f498059c) * 31) + this.f498060d) * 31;
        if (this.f498061e == false) goto L5;
        int r101 = 1231;
    L7:
        return ((r100 + r101) * 31) + this.f498062f.hashCode();
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "ObricNavigationBarInsetsSnapshot(left=" + this.f498057a + ", top=" + this.f498058b + ", right=" + this.f498059c + ", bottom=" + this.f498060d + ", visible=" + this.f498061e + ", source=" + this.f498062f + ')';
    }

    public /* synthetic */ f(int r100, boolean r101, String r110, int r111) {
        if ((r111 & 4) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r111 & 16) == 0) goto L8;
        boolean r102 = false;
    L10:
        if ((r111 & 32) == 0) goto L12;
        r110 = "";
    L12:
        int r103 = r100;
        this(0, 0, r103, 0, r102, r110);
        return;
    L8:
        r102 = r101;
        goto L10
    }

    public f(int r100, int r101, int r102, int r103, boolean r104, String r105) {
        Intrinsics.checkNotNullParameter(r105, "source");
        this.f498057a = r100;
        this.f498058b = r101;
        this.f498059c = r102;
        this.f498060d = r103;
        this.f498061e = r104;
        this.f498062f = r105;
    }
}
