package oe2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f {
    public String a;
    public String b;
    public py.k c;
    public boolean d;
    public Boolean e;

    public f() {
        this(0);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof f) == false) goto L16;
        f r4 = (f) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
        return false;
    L12:
        if (this.d == r4.d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r4.e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9 */
    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        py.k r7 = this.c;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        boolean r10 = this.d;
        ?? r11 = r10;
        if (r10 == false) goto L17;
        r11 = 1;
    L17:
        int r12 = (r9 + r11) * 31;
        Boolean r13 = this.e;
        if (r13 == null) goto L21;
        r1 = r13.hashCode();
    L21:
        return r12 + r1;
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "KtvStageUIState(singerName=" + this.a + ", singSongName=" + this.b + ", singerImageModel=" + this.c + ", avatarAnimShow=" + this.d + ", singEndFeedBackVisible=" + this.e + ")";
    }

    public /* synthetic */ f(int r7) {
        this(null, null, null, false, null);
    }

    public f(String r1, String r2, py.k r3, boolean r4, Boolean r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public static f a(f r6, String r7, String r8, py.k r9, boolean r10, Boolean r11, int r12) {
        if ((r12 & 1) == 0) goto L5;
        r7 = r6.a;
    L5:
        String r1 = r7;
        if ((r12 & 2) == 0) goto L8;
        r8 = r6.b;
    L8:
        String r2 = r8;
        if ((r12 & 4) == 0) goto L11;
        r9 = r6.c;
    L11:
        py.k r3 = r9;
        if ((r12 & 8) == 0) goto L14;
        r10 = r6.d;
    L14:
        boolean r4 = r10;
        if ((r12 & 16) == 0) goto L17;
        r11 = r6.e;
    L17:
        r6.getClass();
        return new f(r1, r2, r3, r4, r11);
    }
}
