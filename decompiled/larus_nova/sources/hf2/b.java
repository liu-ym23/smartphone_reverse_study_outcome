package hf2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f484914a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f484915b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f484916c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f484917d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f484918e;

    public b() {
        this(0, null, null, null, null, 31);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L16;
        b r101 = (b) r100;
        if (this.f484914a == r101.f484914a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f484915b, r101.f484915b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f484916c, r101.f484916c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f484917d, r101.f484917d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f484918e, r101.f484918e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f484914a * 31;
        String r101 = this.f484915b;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f484916c;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f484917d;
        if (r108 == null) goto L13;
        int r109 = r108.hashCode();
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f484918e;
        if (r111 == null) goto L18;
        r102 = r111.hashCode();
    L18:
        return r110 + r102;
    L13:
        r109 = 0;
        goto L14
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public final String toString() {
        return "LinkVideoIntroduceVo(type=" + this.f484914a + ", title=" + this.f484915b + ", des=" + this.f484916c + ", pic1Url=" + this.f484917d + ", pic2Url=" + this.f484918e + ")";
    }

    public final int getType() {
        return this.f484914a;
    }

    public b(int r100, String r101, String r102, String r103, String r104) {
        this.f484914a = r100;
        this.f484915b = r101;
        this.f484916c = r102;
        this.f484917d = r103;
        this.f484918e = r104;
    }

    public /* synthetic */ b(int r100, String r101, String r102, String r110, String r111, int r112) {
        if ((r112 & 1) == 0) goto L5;
        int r103 = -1;
    L7:
        if ((r112 & 2) == 0) goto L9;
        String r104 = null;
    L11:
        if ((r112 & 4) == 0) goto L13;
        String r105 = null;
    L15:
        if ((r112 & 8) == 0) goto L17;
        String r106 = null;
    L19:
        if ((r112 & 16) == 0) goto L21;
        String r107 = null;
    L22:
        this(r103, r104, r105, r106, r107);
        return;
    L21:
        r107 = r111;
        goto L22
    L17:
        r106 = r110;
        goto L19
    L13:
        r105 = r102;
        goto L15
    L9:
        r104 = r101;
        goto L11
    L5:
        r103 = r100;
        goto L7
    }
}
