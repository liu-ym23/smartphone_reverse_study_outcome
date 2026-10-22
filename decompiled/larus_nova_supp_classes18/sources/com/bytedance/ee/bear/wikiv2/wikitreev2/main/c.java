package com.bytedance.ee.bear.wikiv2.wikitreev2.main;

import com.bytedance.ee.bear.contract.route.parcelable.WikiInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final WikiInfo f;
    public final String g;
    public final String h;
    public final String i;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r6 = (c) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        String r1 = this.c;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.d;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.e;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        WikiInfo r11 = this.f;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        String r14 = this.g;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        String r17 = this.h;
        if (r17 == null) goto L27;
        r2 = r17.hashCode();
    L27:
        return ((r16 + r2) * 31) + this.i.hashCode();
    L21:
        r15 = r14.hashCode();
        goto L22
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "NavigationParams(openType=" + this.a + ", targetToken=" + this.b + ", targetSpaceId=" + this.c + ", targetSpaceName=" + this.d + ", title=" + this.e + ", wikiInfo=" + this.f + ", targetUniqueUiId=" + this.g + ", from=" + this.h + ", visibleSpaceId=" + this.i + ')';
    }

    public c(String r3, String r4, String r5, String r6, String r7, WikiInfo r8, String r9, String r10, String r11, int r12) {
        if ((r12 & 4) == 0) goto L6;
        r5 = null;
    L6:
        if ((r12 & 8) == 0) goto L9;
        r6 = null;
    L9:
        if ((r12 & 16) == 0) goto L12;
        r7 = null;
    L12:
        if ((r12 & 32) == 0) goto L15;
        r8 = null;
    L15:
        if ((r12 & 64) == 0) goto L18;
        r9 = null;
    L18:
        if ((r12 & 128) == 0) goto L21;
        r10 = null;
    L21:
        if ((r12 & 256) == 0) goto L23;
        r11 = "";
    L23:
        Intrinsics.checkNotNullParameter(r3, "openType");
        Intrinsics.checkNotNullParameter(r4, "targetToken");
        Intrinsics.checkNotNullParameter(r11, "visibleSpaceId");
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
    }
}
