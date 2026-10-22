package aw3;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class s0 {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final Double g;
    public final Double h;

    public s0() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof s0) == true) goto L8;
        return false;
    L8:
        s0 r6 = (s0) r5;
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
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L32;
        return false;
    L32:
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
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.e;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.f;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        Double r19 = this.g;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        Double r22 = this.h;
        if (r22 == null) goto L35;
        r1 = r22.hashCode();
    L35:
        return r21 + r1;
    L29:
        r20 = r19.hashCode();
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
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
        return "BackgroundAudioStateUpdate(src=" + this.a + ", title=" + this.b + ", epname=" + this.c + ", singer=" + this.d + ", coverImgUrl=" + this.e + ", webUrl=" + this.f + ", startTime=" + this.g + ", playbackRate=" + this.h + ')';
    }

    public final String a() {
        String[] r0 = new String[8];
        StringBuilder r1 = new StringBuilder("src: ");
        boolean r3 = true;
        if (this.a == null) goto L5;
        boolean r2 = true;
    L6:
        r1.append(r2);
        r0[0] = r1.toString();
        StringBuilder r4 = new StringBuilder("title: ");
        if (this.b == null) goto L9;
        boolean r5 = true;
    L10:
        r4.append(r5);
        r0[1] = r4.toString();
        StringBuilder r6 = new StringBuilder("epname: ");
        if (this.c == null) goto L13;
        boolean r7 = true;
    L14:
        r6.append(r7);
        r0[2] = r6.toString();
        StringBuilder r8 = new StringBuilder("singer: ");
        if (this.d == null) goto L17;
        boolean r9 = true;
    L18:
        r8.append(r9);
        r0[3] = r8.toString();
        StringBuilder r10 = new StringBuilder("cover: ");
        if (this.e == null) goto L21;
        boolean r11 = true;
    L22:
        r10.append(r11);
        r0[4] = r10.toString();
        StringBuilder r12 = new StringBuilder("webUrl: ");
        if (this.f != null) goto L26;
        r3 = false;
    L26:
        r12.append(r3);
        r0[5] = r12.toString();
        Double r13 = this.g;
        String r14 = "null";
        if (r13 == null) goto L30;
        String r15 = r0.a(r13.doubleValue());
        if (r15 == null) goto L30;
    L31:
        r0[6] = "startTime: ".concat(r15);
        Double r16 = this.h;
        if (r16 == null) goto L37;
        String r17 = r0.a(r16.doubleValue());
        if (r17 == null) goto L37;
        r14 = r17;
    L37:
        r0[7] = "playbackRate: ".concat(r14);
        return CollectionsKt.joinToString$default(CollectionsKt.listOf(r0), ", ", null, null, 0, null, null, 62, null);
    L30:
        r15 = "null";
        goto L31
    L21:
        r11 = false;
        goto L22
    L17:
        r9 = false;
        goto L18
    L13:
        r7 = false;
        goto L14
    L9:
        r5 = false;
        goto L10
    L5:
        r2 = false;
        goto L6
    }

    public /* synthetic */ s0(int r10) {
        this(null, null, null, null, null, null, null, null);
    }

    public s0(String r1, String r2, String r3, String r4, String r5, String r6, Double r7, Double r8) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
    }
}
