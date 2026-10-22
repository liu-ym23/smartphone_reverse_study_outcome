package pj5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i {
    public boolean a;
    public final String b;
    public final boolean c;
    public final boolean d;
    public String e;
    public final int f;
    public final boolean g;
    public final int h;
    public final boolean i;
    public long j;

    public i() {
        this(false, null, false, false, null, false, 0, false, 0, 1023);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof i) == true) goto L8;
        return false;
    L8:
        i r9 = (i) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r9.f) goto L27;
        return false;
    L27:
        if (this.g == r9.g) goto L30;
        return false;
    L30:
        if (this.h == r9.h) goto L33;
        return false;
    L33:
        if (this.i == r9.i) goto L36;
        return false;
    L36:
        if (this.j == r9.j) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = ((r0 * 31) + this.b.hashCode()) * 31;
        if (this.c == false) goto L9;
        int r3 = 1231;
    L10:
        int r4 = (r2 + r3) * 31;
        if (this.d == false) goto L13;
        int r5 = 1231;
    L14:
        int r6 = (((((r4 + r5) * 31) + this.e.hashCode()) * 31) + this.f) * 31;
        if (this.g == false) goto L17;
        int r7 = 1231;
    L18:
        int r8 = (((r6 + r7) * 31) + this.h) * 31;
        if (this.i == true) goto L22;
        r1 = 1237;
    L22:
        int r9 = (r8 + r1) * 31;
        long r10 = this.j;
        return r9 + ((int) (r10 ^ (r10 >>> 32)));
    L17:
        r7 = 1237;
        goto L18
    L13:
        r5 = 1237;
        goto L14
    L9:
        r3 = 1237;
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "DocFreshNessEntity(isSelected=" + this.a + ", srcName=" + this.b + ", isNews=" + this.c + ", showDesc=" + this.d + ", description=" + this.e + ", descColor=" + this.f + ", showUpdateTime=" + this.g + ", freshStatus=" + this.h + ", isCustomer=" + this.i + ", dateTime=" + this.j + ')';
    }

    public i(boolean r5, String r6, boolean r7, boolean r8, String r9, boolean r10, int r11, boolean r12, long r13, int r15) {
        if ((r15 & 1) == 0) goto L6;
        r5 = false;
    L6:
        if ((r15 & 2) == 0) goto L9;
        r6 = "";
    L9:
        if ((r15 & 4) == 0) goto L12;
        r7 = false;
    L12:
        if ((r15 & 8) == 0) goto L15;
        r8 = false;
    L15:
        if ((r15 & 16) == 0) goto L18;
        r9 = "";
    L18:
        if ((r15 & 32) == 0) goto L20;
        int r0 = -1;
    L22:
        if ((r15 & 64) == 0) goto L25;
        r10 = false;
    L25:
        if ((r15 & 128) == 0) goto L28;
        r11 = -1;
    L28:
        if ((r15 & 256) == 0) goto L31;
        r12 = false;
    L31:
        if ((r15 & 512) == 0) goto L33;
        r13 = -1;
    L33:
        Intrinsics.checkNotNullParameter(r6, "srcName");
        Intrinsics.checkNotNullParameter(r9, "description");
        this.a = r5;
        this.b = r6;
        this.c = r7;
        this.d = r8;
        this.e = r9;
        this.f = r0;
        this.g = r10;
        this.h = r11;
        this.i = r12;
        this.j = r13;
        return;
    L20:
        r0 = 0;
        goto L22
    }
}
