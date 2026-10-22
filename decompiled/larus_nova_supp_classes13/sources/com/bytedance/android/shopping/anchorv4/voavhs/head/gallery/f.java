package com.bytedance.android.shopping.anchorv4.voavhs.head.gallery;

import android.view.View;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.anchorv4.voavhs.head.holder.t;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f {
    public final View a;
    public final ECUrlModel b;
    public final String c;
    public final b d;
    public final int e;
    public final String f;
    public final String g;
    public final boolean h;
    public final Float i;
    public final String j;
    public final String k;

    public f() {
        this(null, null, null, null, null, null, false, null, null, 2047);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof f) == false) goto L28;
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
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L14;
        return false;
    L14:
        if (this.e == r4.e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r4.f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.g, r4.g) == true) goto L20;
        return false;
    L20:
        if (this.h == r4.h) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.i, r4.i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.j, r4.j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.k, r4.k) == true) goto L43;
        return false;
    L43:
        return true;
    L28:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r2v17, types: [int] */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v33 */
    public final int hashCode() {
        View r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        ECUrlModel r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.c;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        b r10 = this.d;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (((r9 + r11) * 31) + this.e) * 31;
        String r13 = this.f;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.g;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        boolean r19 = this.h;
        ?? r20 = r19;
        if (r19 == false) goto L29;
        r20 = 1;
    L29:
        int r21 = (r18 + r20) * 31;
        Float r22 = this.i;
        if (r22 == null) goto L32;
        int r23 = r22.hashCode();
    L33:
        int r24 = (r21 + r23) * 31;
        String r25 = this.j;
        if (r25 == null) goto L36;
        int r26 = r25.hashCode();
    L37:
        int r27 = (r24 + r26) * 31;
        String r28 = this.k;
        if (r28 == null) goto L41;
        r1 = r28.hashCode();
    L41:
        return r27 + r1;
    L36:
        r26 = 0;
        goto L37
    L32:
        r23 = 0;
        goto L33
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
        return "BrowseNode(customView=" + this.a + ", remoteImage=" + this.b + ", skuImageTitle=" + this.c + ", videoInfo=" + this.d + ", itemViewType=" + this.e + ", findSameGoodsSchema=" + this.f + ", contentDescription=" + this.g + ", injectKolFeedFragment=" + this.h + ", commentVideoProgress=" + this.i + ", videoItemId=" + this.j + ", tabTypeName=" + this.k + ")";
    }

    public static f a(f r12, int r13, String r14) {
        View r1 = r12.a;
        ECUrlModel r2 = r12.b;
        String r3 = r12.c;
        b r4 = r12.d;
        String r6 = r12.f;
        String r7 = r12.g;
        boolean r8 = r12.h;
        Float r9 = r12.i;
        String r10 = r12.j;
        r12.getClass();
        return new f(r1, r2, r3, r4, r13, r6, r7, r8, r9, r10, r14);
    }

    public /* synthetic */ f(View r16, ECUrlModel r17, String r18, t r19, String r20, String r21, boolean r22, Float r23, String r24, int r25) {
        if ((r25 & 1) == 0) goto L5;
        View r4 = null;
    L7:
        if ((r25 & 2) == 0) goto L9;
        ECUrlModel r5 = null;
    L11:
        if ((r25 & 4) == 0) goto L13;
        String r6 = null;
    L15:
        if ((r25 & 8) == 0) goto L17;
        t r7 = null;
    L19:
        if ((r25 & 32) == 0) goto L21;
        String r9 = null;
    L23:
        if ((r25 & 64) == 0) goto L25;
        String r10 = null;
    L27:
        if ((r25 & 128) == 0) goto L29;
        boolean r11 = false;
    L31:
        if ((r25 & 256) == 0) goto L33;
        Float r12 = null;
    L35:
        if ((r25 & 512) == 0) goto L37;
        String r13 = null;
    L38:
        this(r4, r5, r6, r7, 0, r9, r10, r11, r12, r13, null);
        return;
    L37:
        r13 = r24;
        goto L38
    L33:
        r12 = r23;
        goto L35
    L29:
        r11 = r22;
        goto L31
    L25:
        r10 = r21;
        goto L27
    L21:
        r9 = r20;
        goto L23
    L17:
        r7 = r19;
        goto L19
    L13:
        r6 = r18;
        goto L15
    L9:
        r5 = r17;
        goto L11
    L5:
        r4 = r16;
        goto L7
    }

    public f(View r1, ECUrlModel r2, String r3, b r4, int r5, String r6, String r7, boolean r8, Float r9, String r10, String r11) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
        this.k = r11;
    }
}
