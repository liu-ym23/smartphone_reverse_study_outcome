package lc5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class p {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final int h;
    public final String i;
    public final String j;
    public final boolean k;
    public final boolean l;
    public final boolean m;
    public final int n;
    public final Boolean o;
    public final String p;
    public final String q;
    public final String r;
    public final String s;
    public final String t;

    public final int getType() {
        return this.h;
    }

    public p(String r11, String r12, String r13, String r14, String r15, String r16) {
        Intrinsics.checkNotNullParameter(r11, "module");
        Intrinsics.checkNotNullParameter(r12, "subModule");
        Intrinsics.checkNotNullParameter(r13, "click");
        Intrinsics.checkNotNullParameter(r14, "target");
        Intrinsics.checkNotNullParameter(r15, "currentSubView");
        this(r11, r12, r13, r14, r15, r16, null, null);
    }

    public p(String r22, String r23, String r24, int r25, String r26, Boolean r27, String r28) {
        Intrinsics.checkNotNullParameter("recent", "currentSubView");
        this("ccm_space_home_page_click", "home", "recent", r22, r23, "recent", r24, r25, r26, "", false, false, false, 0, r27, r28, null, null, null, "list");
    }

    public p(String r22, String r23, String r24, String r25, String r26, String r27, String r28, String r29) {
        Intrinsics.checkNotNullParameter(r26, "currentSubView");
        int r8 = sbb.e.e.b;
        Intrinsics.checkNotNullParameter(r26, "currentSubView");
        if (r27 != null) goto L5;
        String r1 = "ccm_space_home_page_click";
    L6:
        this(r1, r22, r23, r24, r25, r26, "", r8, "", "", false, false, false, 0, null, "", null, r28, r29, null);
        return;
    L5:
        r1 = r27;
        goto L6
    }

    public p(String r23, String r24, String r25, String r26, String r27, String r28, int r29, String r30, Boolean r31, String r32, String r33) {
        Intrinsics.checkNotNullParameter(r27, "currentSubView");
        if (r33 != null) goto L5;
        String r2 = "ccm_space_home_page_click";
    L6:
        this(r2, r23, r24, r25, r26, r27, r28, r29, r30, "", false, false, false, 0, r31, r32, null, null, null, null);
        return;
    L5:
        r2 = r33;
        goto L6
    }

    public p(String r23, String r24, String r25, String r26, String r27, String r28, int r29, String r30, String r31, boolean r32, boolean r33, boolean r34, int r35, Boolean r36, String r37, String r38) {
        Intrinsics.checkNotNullParameter(r27, "target");
        this(r23, r24, r25, r26, r27, "", r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, null, null, null);
    }

    public p(String r3, String r4, String r5, String r6, String r7, String r8, String r9, int r10, String r11, String r12, boolean r13, boolean r14, boolean r15, int r16, Boolean r17, String r18, String r19, String r20, String r21, String r22) {
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
        this.j = r12;
        this.k = r13;
        this.l = r14;
        this.m = r15;
        this.n = r16;
        this.o = r17;
        this.p = r18;
        this.q = r19;
        this.r = r20;
        this.s = r21;
        this.t = r22;
    }
}
