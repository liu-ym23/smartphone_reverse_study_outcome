package com.bytedance.android.livesdk.livecommerce.iron.listheader;

import com.bytedance.android.ec.model.response.ECRitTag;
import com.bytedance.android.livesdk.livecommerce.network.response.ECPromotionEnhancedSearchEntry;
import com.bytedance.android.livesdk.livecommerce.network.response.ECPromotionEntry;
import com.bytedance.android.livesdk.livecommerce.network.response.ECPromotionHeaderLayoutControl;
import com.bytedance.android.livesdk.livecommerce.network.response.ECPromotionList;
import com.bytedance.android.livesdk.livecommerce.network.response.ECPromotionSingleEntry;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b {
    public static final /* synthetic */ int m = 0;
    public final Map<String, List<ECRitTag>> a;
    public final ECPromotionList.d b;
    public final ECPromotionList.v c;
    public final ECPromotionList.f d;
    public final List<ECPromotionEntry> e;
    public final Map<String, String> f;
    public final boolean g;
    public int h;
    public final boolean i;
    public final ECPromotionHeaderLayoutControl j;
    public final ECPromotionEnhancedSearchEntry k;
    public final ECPromotionSingleEntry l;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof b) == false) goto L30;
        b r4 = (b) r3;
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
        if (this.g == r4.g) goto L20;
        return false;
    L20:
        if (this.h == r4.h) goto L22;
        return false;
    L22:
        if (this.i == r4.i) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.j, r4.j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.k, r4.k) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.l, r4.l) == true) goto L46;
        return false;
    L46:
        return true;
    L30:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v16, types: [int] */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v34 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        Map<String, List<ECRitTag>> r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        ECPromotionList.d r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        ECPromotionList.v r7 = this.c;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        ECPromotionList.f r10 = this.d;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        List<ECPromotionEntry> r13 = this.e;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        Map<String, String> r16 = this.f;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        boolean r19 = this.g;
        ?? r20 = 1;
        ?? r21 = r19;
        if (r19 == false) goto L29;
        r21 = 1;
    L29:
        int r22 = (((r18 + r21) * 31) + this.h) * 31;
        boolean r23 = this.i;
        if (r23 == true) goto L33;
        r20 = r23;
    L33:
        int r24 = (r22 + r20) * 31;
        ECPromotionHeaderLayoutControl r25 = this.j;
        if (r25 == null) goto L36;
        int r26 = r25.hashCode();
    L37:
        int r27 = (r24 + r26) * 31;
        ECPromotionEnhancedSearchEntry r28 = this.k;
        if (r28 == null) goto L40;
        int r29 = r28.hashCode();
    L41:
        int r30 = (r27 + r29) * 31;
        ECPromotionSingleEntry r31 = this.l;
        if (r31 == null) goto L45;
        r1 = r31.hashCode();
    L45:
        return r30 + r1;
    L40:
        r29 = 0;
        goto L41
    L36:
        r26 = 0;
        goto L37
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
        return "IronListHeaderData(anchorTags=" + this.a + ", authorReputation=" + this.b + ", storeEntranceInfo=" + this.c + ", authorShopInfo=" + this.d + ", entries=" + this.e + ", extraParams=" + this.f + ", isCouponList=" + this.g + ", promotionCount=" + this.h + ", isFlashRoom=" + this.i + ", layoutControl=" + this.j + ", searchEntry=" + this.k + ", singleEntry=" + this.l + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(Map<String, ? extends List<ECRitTag>> r2, ECPromotionList.d r3, ECPromotionList.v r4, ECPromotionList.f r5, List<ECPromotionEntry> r6, Map<String, String> r7, boolean r8, int r9, boolean r10, ECPromotionHeaderLayoutControl r11, ECPromotionEnhancedSearchEntry r12, ECPromotionSingleEntry r13) {
        Intrinsics.checkNotNullParameter(r7, "extraParams");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
        this.k = r12;
        this.l = r13;
    }
}
