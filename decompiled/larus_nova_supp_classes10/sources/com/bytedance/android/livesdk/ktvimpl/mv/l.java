package com.bytedance.android.livesdk.ktvimpl.mv;

import com.bytedance.android.livesdk.message.model.ed;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class l {
    public Integer a;
    public String b;
    public String c;
    public final String d;
    public final String e;
    public final long f;
    public final String g;
    public final List<ed> h;
    public final Integer i;
    public final int j;
    public String k;
    public String l;
    public Long m;

    public static final class a {
    }

    static {
    }

    public l() {
        throw null;
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof l) == false) goto L26;
        l r7 = (l) r6;
        if (Intrinsics.areEqual(this.d, r7.d) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.e, r7.e) == true) goto L10;
        return false;
    L10:
        if (this.f == r7.f) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.g, r7.g) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.h, r7.h) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.i, r7.i) == true) goto L18;
        return false;
    L18:
        if (this.j == r7.j) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.k, r7.k) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.l, r7.l) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.m, r7.m) == true) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    public final int hashCode() {
        String r0 = this.d;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.e;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        long r7 = this.f;
        int r8 = (r6 + ((int) (r7 ^ (r7 >>> 32)))) * 31;
        String r9 = this.g;
        if (r9 == null) goto L13;
        int r10 = r9.hashCode();
    L14:
        int r11 = (r8 + r10) * 31;
        List<ed> r12 = this.h;
        if (r12 == null) goto L17;
        int r13 = r12.hashCode();
    L18:
        int r14 = (r11 + r13) * 31;
        Integer r15 = this.i;
        if (r15 == null) goto L21;
        int r16 = r15.hashCode();
    L22:
        int r17 = (((r14 + r16) * 31) + this.j) * 31;
        String r18 = this.k;
        if (r18 == null) goto L25;
        int r19 = r18.hashCode();
    L26:
        int r20 = (r17 + r19) * 31;
        String r21 = this.l;
        if (r21 == null) goto L29;
        int r22 = r21.hashCode();
    L30:
        int r23 = (r20 + r22) * 31;
        Long r24 = this.m;
        if (r24 == null) goto L34;
        r1 = r24.hashCode();
    L34:
        return r23 + r1;
    L29:
        r22 = 0;
        goto L30
    L25:
        r19 = 0;
        goto L26
    L21:
        r16 = 0;
        goto L22
    L17:
        r13 = 0;
        goto L18
    L13:
        r10 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "vid=" + this.d + "，songId=" + this.f + "，orderUid=" + this.g + "，playFrom=" + this.k + "，，saveFrom=" + this.l;
    }

    public /* synthetic */ l(y r9, String r10, String r11, List r12, int r13) {
        this(r9, r10, r11, r12, null, r13, "null");
    }

    public l(y r13, String r14, String r15, List<ed> r16, Integer r17, int r18, String r19) {
        Intrinsics.checkNotNullParameter(r13, "songParam");
        Intrinsics.checkNotNullParameter(r14, "vid");
        Intrinsics.checkNotNullParameter(r19, "saveFrom");
        this(r14, r15, r13.b, r13.d, r16, r17, r18, r19);
    }

    public l(String r3, String r4, long r5, String r7, List r8, Integer r9, int r10, String r11) {
        Intrinsics.checkNotNullParameter(r3, "vid");
        Intrinsics.checkNotNullParameter(r7, "orderUidString");
        Intrinsics.checkNotNullParameter("null", "playFrom");
        Intrinsics.checkNotNullParameter(r11, "saveFrom");
        this.d = r3;
        this.e = r4;
        this.f = r5;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
        this.k = "null";
        this.l = r11;
        this.m = null;
    }
}
