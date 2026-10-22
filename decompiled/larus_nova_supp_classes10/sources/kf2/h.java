package kf2;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class h {
    public final String a;
    public final long b;
    public final String c;
    public final long d;
    public final long e;
    public final String f;
    public final String g;
    public final String h;
    public final Map<String, Object> i;
    public final long j;
    public final long k;
    public final String l;
    public final String m;
    public final String n;
    public final String o;
    public final String p;
    public final String q;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof h) == false) goto L40;
        h r7 = (h) r6;
        if (Intrinsics.areEqual(this.a, r7.a) == true) goto L8;
        return false;
    L8:
        if (this.b == r7.b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r7.c) == true) goto L12;
        return false;
    L12:
        if (this.d == r7.d) goto L14;
        return false;
    L14:
        if (this.e == r7.e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r7.f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.g, r7.g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.h, r7.h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.i, r7.i) == true) goto L24;
        return false;
    L24:
        if (this.j == r7.j) goto L26;
        return false;
    L26:
        if (this.k == r7.k) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.l, r7.l) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.m, r7.m) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.n, r7.n) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.o, r7.o) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.p, r7.p) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.q, r7.q) == true) goto L61;
        return false;
    L61:
        return true;
    L40:
        return false;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        long r3 = this.b;
        int r4 = ((r2 * 31) + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        String r5 = this.c;
        if (r5 == null) goto L9;
        int r6 = r5.hashCode();
    L10:
        int r7 = (r4 + r6) * 31;
        long r8 = this.d;
        int r9 = (r7 + ((int) (r8 ^ (r8 >>> 32)))) * 31;
        long r10 = this.e;
        int r11 = (r9 + ((int) (r10 ^ (r10 >>> 32)))) * 31;
        String r12 = this.f;
        if (r12 == null) goto L13;
        int r13 = r12.hashCode();
    L14:
        int r14 = (r11 + r13) * 31;
        String r15 = this.g;
        if (r15 == null) goto L17;
        int r16 = r15.hashCode();
    L18:
        int r17 = (r14 + r16) * 31;
        String r18 = this.h;
        if (r18 == null) goto L21;
        int r19 = r18.hashCode();
    L22:
        int r20 = (r17 + r19) * 31;
        Map<String, Object> r21 = this.i;
        if (r21 == null) goto L25;
        int r22 = r21.hashCode();
    L26:
        int r23 = (r20 + r22) * 31;
        long r24 = this.j;
        int r25 = (r23 + ((int) (r24 ^ (r24 >>> 32)))) * 31;
        long r26 = this.k;
        int r27 = (r25 + ((int) (r26 ^ (r26 >>> 32)))) * 31;
        String r28 = this.l;
        if (r28 == null) goto L29;
        int r29 = r28.hashCode();
    L30:
        int r30 = (r27 + r29) * 31;
        String r31 = this.m;
        if (r31 == null) goto L33;
        int r32 = r31.hashCode();
    L34:
        int r33 = (r30 + r32) * 31;
        String r34 = this.n;
        if (r34 == null) goto L37;
        int r35 = r34.hashCode();
    L38:
        int r36 = (r33 + r35) * 31;
        String r37 = this.o;
        if (r37 == null) goto L41;
        int r38 = r37.hashCode();
    L42:
        int r39 = (r36 + r38) * 31;
        String r40 = this.p;
        if (r40 == null) goto L45;
        int r41 = r40.hashCode();
    L46:
        int r42 = (r39 + r41) * 31;
        String r43 = this.q;
        if (r43 == null) goto L50;
        r1 = r43.hashCode();
    L50:
        return r42 + r1;
    L45:
        r41 = 0;
        goto L46
    L41:
        r38 = 0;
        goto L42
    L37:
        r35 = 0;
        goto L38
    L33:
        r32 = 0;
        goto L34
    L29:
        r29 = 0;
        goto L30
    L25:
        r22 = 0;
        goto L26
    L21:
        r19 = 0;
        goto L22
    L17:
        r16 = 0;
        goto L18
    L13:
        r13 = 0;
        goto L14
    L9:
        r6 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "RequestParam(url=" + this.a + ", maxTime=" + this.b + ", reqFrom=" + this.c + ", isDraw=" + this.d + ", roomId=" + this.e + ", anchorId=" + this.f + ", enterSource=" + this.g + ", exemptImpressionGidList=" + this.h + ", forceMap=" + this.i + ", groupId=" + this.j + ", groupType=" + this.k + ", featureSequence=" + this.l + ", skipFeatureSequence=" + this.m + ", impressionRoomIds=" + this.n + ", innerImprGids=" + this.o + ", retryType=" + this.p + ", cutKey=" + this.q + ")";
    }

    public h(String r13, long r14, String r16, long r17, long r19, String r21, String r22, String r23, Map<String, ? extends Object> r24, long r25, long r27, String r29, String r30, String r31, String r32, String r33, String r34) {
        Intrinsics.checkNotNullParameter(r13, "url");
        Intrinsics.checkNotNullParameter(r16, "reqFrom");
        Intrinsics.checkNotNullParameter(r21, "anchorId");
        Intrinsics.checkNotNullParameter(r22, "enterSource");
        Intrinsics.checkNotNullParameter(r23, "exemptImpressionGidList");
        Intrinsics.checkNotNullParameter(r24, "forceMap");
        Intrinsics.checkNotNullParameter(r29, "featureSequence");
        Intrinsics.checkNotNullParameter(r30, "skipFeatureSequence");
        Intrinsics.checkNotNullParameter(r31, "impressionRoomIds");
        this.a = r13;
        this.b = r14;
        this.c = r16;
        this.d = r17;
        this.e = r19;
        this.f = r21;
        this.g = r22;
        this.h = r23;
        this.i = r24;
        this.j = r25;
        this.k = r27;
        this.l = r29;
        this.m = r30;
        this.n = r31;
        this.o = r32;
        this.p = r33;
        this.q = r34;
    }
}
