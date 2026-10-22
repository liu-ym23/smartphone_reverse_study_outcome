package com.bytedance.android.shopping.api.mall.feed;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b {
    public final String a;
    public final String b;
    public final boolean c;
    public final Integer d;
    public final com.bytedance.android.shopping.api.mall.feed.a e;
    public final c f;
    public final i g;
    public final String h;
    public final String i;
    public final ECMallFeedStickyConfig j;
    public final Map<String, Object> k;
    public final String l;
    public final boolean m;
    public final com.bytedance.android.shopping.api.mall.idl.c n;

    public static final class a {
    }

    static {
    }

    public b() {
        throw null;
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof b) == false) goto L34;
        b r4 = (b) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (this.c == r4.c) goto L12;
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
        if (Intrinsics.areEqual(this.g, r4.g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.h, r4.h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.i, r4.i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.j, r4.j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.k, r4.k) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.l, r4.l) == true) goto L30;
        return false;
    L30:
        if (this.m == r4.m) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.n, r4.n) == true) goto L52;
        return false;
    L52:
        return true;
    L34:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v43 */
    /* JADX WARN: Type inference failed for: r2v45 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
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
        boolean r7 = this.c;
        ?? r8 = 1;
        ?? r9 = r7;
        if (r7 == false) goto L13;
        r9 = 1;
    L13:
        int r10 = (r6 + r9) * 31;
        Integer r11 = this.d;
        if (r11 == null) goto L16;
        int r12 = r11.hashCode();
    L17:
        int r13 = (r10 + r12) * 31;
        com.bytedance.android.shopping.api.mall.feed.a r14 = this.e;
        if (r14 == null) goto L20;
        int r15 = r14.hashCode();
    L21:
        int r16 = (r13 + r15) * 31;
        c r17 = this.f;
        if (r17 == null) goto L24;
        int r18 = r17.hashCode();
    L25:
        int r19 = (r16 + r18) * 31;
        i r20 = this.g;
        if (r20 == null) goto L28;
        int r21 = r20.hashCode();
    L29:
        int r22 = (r19 + r21) * 31;
        String r23 = this.h;
        if (r23 == null) goto L32;
        int r24 = r23.hashCode();
    L33:
        int r25 = (r22 + r24) * 31;
        String r26 = this.i;
        if (r26 == null) goto L36;
        int r27 = r26.hashCode();
    L37:
        int r28 = (r25 + r27) * 31;
        ECMallFeedStickyConfig r29 = this.j;
        if (r29 == null) goto L40;
        int r30 = r29.hashCode();
    L41:
        int r31 = (r28 + r30) * 31;
        Map<String, Object> r32 = this.k;
        if (r32 == null) goto L44;
        int r33 = r32.hashCode();
    L45:
        int r34 = (r31 + r33) * 31;
        String r35 = this.l;
        if (r35 == null) goto L48;
        int r36 = r35.hashCode();
    L49:
        int r37 = (r34 + r36) * 31;
        boolean r38 = this.m;
        if (r38 == true) goto L53;
        r8 = r38;
    L53:
        int r39 = (r37 + r8) * 31;
        com.bytedance.android.shopping.api.mall.idl.c r40 = this.n;
        if (r40 == null) goto L57;
        r1 = r40.hashCode();
    L57:
        return r39 + r1;
    L48:
        r36 = 0;
        goto L49
    L44:
        r33 = 0;
        goto L45
    L40:
        r30 = 0;
        goto L41
    L36:
        r27 = 0;
        goto L37
    L32:
        r24 = 0;
        goto L33
    L28:
        r21 = 0;
        goto L29
    L24:
        r18 = 0;
        goto L25
    L20:
        r15 = 0;
        goto L21
    L16:
        r12 = 0;
        goto L17
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "ECMallFeedConfig(pageName=" + this.a + ", title=" + this.b + ", initImmediately=" + this.c + ", triggerLoadMoreThreshold=" + this.d + ", apiCacheConfig=" + this.e + ", imagePrefetchConfig=" + this.f + ", titleUi=" + this.g + ", bundleConfigUrl=" + this.h + ", pageCardUrl=" + this.i + ", stickyConfig=" + this.j + ", logExtra=" + this.k + ", fetchId=" + this.l + ", isInSplit=" + this.m + ", screenModel=" + this.n + ")";
    }

    public b(String r17, String r18, Integer r19, com.bytedance.android.shopping.api.mall.feed.a r20, c r21, i r22, String r23, String r24, ECMallFeedStickyConfig r25, String r26, boolean r27, com.bytedance.android.shopping.api.mall.idl.c r28, int r29) {
        if ((r29 & 2) == 0) goto L5;
        String r3 = null;
    L7:
        if ((r29 & 8) == 0) goto L9;
        Integer r5 = null;
    L11:
        if ((r29 & 16) == 0) goto L13;
        com.bytedance.android.shopping.api.mall.feed.a r6 = null;
    L15:
        if ((r29 & 32) == 0) goto L17;
        c r7 = null;
    L19:
        if ((r29 & 64) == 0) goto L21;
        i r8 = null;
    L23:
        if ((r29 & 128) == 0) goto L25;
        String r9 = null;
    L27:
        if ((r29 & 256) == 0) goto L29;
        String r10 = null;
    L31:
        if ((r29 & 512) == 0) goto L33;
        ECMallFeedStickyConfig r11 = null;
    L35:
        if ((r29 & 2048) == 0) goto L37;
        String r12 = null;
    L39:
        if ((r29 & 4096) == 0) goto L41;
        boolean r13 = false;
    L43:
        if ((r29 & 8192) == 0) goto L45;
        com.bytedance.android.shopping.api.mall.idl.c r2 = null;
    L46:
        Intrinsics.checkNotNullParameter(r17, "pageName");
        this.a = r17;
        this.b = r3;
        this.c = false;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
        this.k = null;
        this.l = r12;
        this.m = r13;
        this.n = r2;
        return;
    L45:
        r2 = r28;
        goto L46
    L41:
        r13 = r27;
        goto L43
    L37:
        r12 = r26;
        goto L39
    L33:
        r11 = r25;
        goto L35
    L29:
        r10 = r24;
        goto L31
    L25:
        r9 = r23;
        goto L27
    L21:
        r8 = r22;
        goto L23
    L17:
        r7 = r21;
        goto L19
    L13:
        r6 = r20;
        goto L15
    L9:
        r5 = r19;
        goto L11
    L5:
        r3 = r18;
        goto L7
    }
}
