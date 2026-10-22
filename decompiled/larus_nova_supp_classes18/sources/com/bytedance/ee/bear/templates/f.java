package com.bytedance.ee.bear.templates;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f {
    public final String a;
    public final String b;
    public final String c;
    public final String d;

    public f() {
        String r0 = null;
        this(r0, r0, 15);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof f) == true) goto L8;
        return false;
    L8:
        f r6 = (f) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.d;
        if (r10 == null) goto L19;
        r1 = r10.hashCode();
    L19:
        return r9 + r1;
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "TemplateShowReportParams(templateToken=" + this.a + ", templateName=" + this.b + ", setName=" + this.c + ", templateType=" + this.d + ')';
    }

    public /* synthetic */ f(String r4, String r5, int r6) {
        String r1 = "";
        if ((r6 & 1) == 0) goto L6;
        r4 = "";
    L6:
        if ((r6 & 2) == 0) goto L9;
        r5 = "";
    L9:
        if ((r6 & 4) == 0) goto L11;
        String r0 = "";
    L13:
        if ((r6 & 8) != 0) goto L16;
        r1 = null;
    L16:
        this(r4, r5, r0, r1);
        return;
    L11:
        r0 = null;
        goto L13
    }

    public f(String r1, String r2, String r3, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
