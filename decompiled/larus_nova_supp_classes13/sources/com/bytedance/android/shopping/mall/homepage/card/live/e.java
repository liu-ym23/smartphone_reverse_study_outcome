package com.bytedance.android.shopping.mall.homepage.card.live;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;

    public e() {
        this(null, null, null, null, 127);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof e) == false) goto L20;
        e r4 = (e) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
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
        if (Intrinsics.areEqual(this.e, r4.e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r4.f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.g, r4.g) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

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
        String r7 = this.c;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.d;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.e;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.f;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.g;
        if (r19 == null) goto L30;
        r1 = r19.hashCode();
    L30:
        return r18 + r1;
    L25:
        r17 = 0;
        goto L26
    L21:
        r14 = 0;
        goto L22
    L17:
        r11 = 0;
        goto L18
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
        return "LiveOrVideoImageXMonitorTag(bizTag=" + this.a + ", coverSceneTag=" + this.b + ", avatarSceneTag=" + this.c + ", productTag=" + this.d + ", redPackSceneTag=" + this.e + ", simpleProductTag=" + this.f + ", coverBlurSceneTag=" + this.g + ")";
    }

    public /* synthetic */ e(String r11, String r12, String r13, String r14, int r15) {
        if ((r15 & 1) == 0) goto L5;
        String r3 = "";
    L7:
        if ((r15 & 2) == 0) goto L9;
        String r4 = "";
    L11:
        if ((r15 & 4) == 0) goto L13;
        String r5 = "";
    L15:
        if ((r15 & 8) == 0) goto L17;
        String r6 = "";
    L19:
        if ((r15 & 16) == 0) goto L21;
        String r7 = "";
    L23:
        if ((r15 & 32) == 0) goto L25;
        String r8 = "";
    L27:
        if ((r15 & 64) == 0) goto L29;
        String r9 = "";
    L30:
        this(r3, r4, r5, r6, r7, r8, r9);
        return;
    L29:
        r9 = null;
        goto L30
    L25:
        r8 = null;
        goto L27
    L21:
        r7 = null;
        goto L23
    L17:
        r6 = r14;
        goto L19
    L13:
        r5 = r13;
        goto L15
    L9:
        r4 = r12;
        goto L11
    L5:
        r3 = r11;
        goto L7
    }

    public e(String r2, String r3, String r4, String r5, String r6, String r7, String r8) {
        Intrinsics.checkNotNullParameter(r2, "bizTag");
        Intrinsics.checkNotNullParameter(r3, "coverSceneTag");
        Intrinsics.checkNotNullParameter(r4, "avatarSceneTag");
        Intrinsics.checkNotNullParameter(r5, "productTag");
        Intrinsics.checkNotNullParameter(r6, "redPackSceneTag");
        Intrinsics.checkNotNullParameter(r7, "simpleProductTag");
        Intrinsics.checkNotNullParameter(r8, "coverBlurSceneTag");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }
}
