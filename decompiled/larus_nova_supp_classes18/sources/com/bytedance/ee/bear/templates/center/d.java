package com.bytedance.ee.bear.templates.center;

import com.bytedance.ee.bear.content.creation.location.CreateSelectResult;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d {
    public final String a;
    public final long b;
    public final String c;
    public final String d;
    public final String e;
    public final int f;
    public final boolean g;
    public final boolean h;
    public final String i;
    public final CreateSelectResult j;
    public final String k;
    public final boolean l;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof d) == true) goto L8;
        return false;
    L8:
        d r9 = (d) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
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
        if (Intrinsics.areEqual(this.i, r9.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r9.j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r9.k) == true) goto L42;
        return false;
    L42:
        if (this.l == r9.l) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        long r1 = this.b;
        int r2 = (((((((((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f) * 31;
        int r3 = 1231;
        if (this.g == false) goto L5;
        int r4 = 1231;
    L6:
        int r5 = (r2 + r4) * 31;
        if (this.h == false) goto L9;
        int r6 = 1231;
    L10:
        int r7 = (((((((r5 + r6) * 31) + this.i.hashCode()) * 31) + this.j.hashCode()) * 31) + this.k.hashCode()) * 31;
        if (this.l == true) goto L15;
        r3 = 1237;
    L15:
        return r7 + r3;
    L9:
        r6 = 1237;
        goto L10
    L5:
        r4 = 1237;
        goto L6
    }

    public final String toString() {
        return "TemplateCenterFragmentParams(openTemplateCenter=" + this.a + ", categoryId=" + this.b + ", enterSource=" + this.c + ", parentToken=" + this.d + ", module=" + this.e + ", filterType=" + this.f + ", fixedFilter=" + this.g + ", isSpaceV2=" + this.h + ", templateSource=" + this.i + ", createSelectResult=" + this.j + ", spaceId=" + this.k + ", createBlank=" + this.l + ')';
    }

    public d(String r2, long r3, String r5, String r6, String r7, int r8, boolean r9, boolean r10, String r11, CreateSelectResult r12, String r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r2, "openTemplateCenter");
        Intrinsics.checkNotNullParameter(r5, "enterSource");
        Intrinsics.checkNotNullParameter(r6, "parentToken");
        Intrinsics.checkNotNullParameter(r7, "module");
        Intrinsics.checkNotNullParameter(r11, "templateSource");
        Intrinsics.checkNotNullParameter(r12, "createSelectResult");
        Intrinsics.checkNotNullParameter(r13, "spaceId");
        this.a = r2;
        this.b = r3;
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
    }
}
