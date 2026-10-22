package hf2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b {
    public final int a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;

    public b() {
        this(0, null, null, null, null, 31);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof b) == false) goto L16;
        b r4 = (b) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r4.e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        int r0 = this.a * 31;
        String r1 = this.b;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.c;
        if (r5 == null) goto L9;
        int r6 = r5.hashCode();
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.d;
        if (r8 == null) goto L13;
        int r9 = r8.hashCode();
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.e;
        if (r11 == null) goto L18;
        r2 = r11.hashCode();
    L18:
        return r10 + r2;
    L13:
        r9 = 0;
        goto L14
    L9:
        r6 = 0;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }

    public final String toString() {
        return "LinkVideoIntroduceVo(type=" + this.a + ", title=" + this.b + ", des=" + this.c + ", pic1Url=" + this.d + ", pic2Url=" + this.e + ")";
    }

    public final int getType() {
        return this.a;
    }

    public b(int r1, String r2, String r3, String r4, String r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public /* synthetic */ b(int r7, String r8, String r9, String r10, String r11, int r12) {
        if ((r12 & 1) == 0) goto L5;
        int r1 = -1;
    L7:
        if ((r12 & 2) == 0) goto L9;
        String r2 = null;
    L11:
        if ((r12 & 4) == 0) goto L13;
        String r3 = null;
    L15:
        if ((r12 & 8) == 0) goto L17;
        String r4 = null;
    L19:
        if ((r12 & 16) == 0) goto L21;
        String r5 = null;
    L22:
        this(r1, r2, r3, r4, r5);
        return;
    L21:
        r5 = r11;
        goto L22
    L17:
        r4 = r10;
        goto L19
    L13:
        r3 = r9;
        goto L15
    L9:
        r2 = r8;
        goto L11
    L5:
        r1 = r7;
        goto L7
    }
}
