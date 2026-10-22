package jj2;

import com.bytedance.android.ec.model.response.ECPromotionAuctionInfo;
import com.bytedance.android.ec.model.response.z0;
import com.bytedance.android.livesdk.livecommerce.promotion.card.UpdateType;
import com.bytedance.android.livesdk.livecommerce.promotion.card.k;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.model.AuctionAtmosphereState;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.model.HotAtmosphereState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c {
    public final HotAtmosphereState a;
    public final AuctionAtmosphereState b;
    public final z0 c;
    public final UpdateType d;
    public final k e;
    public final String f;
    public final String g;
    public final boolean h;
    public final int i;
    public final boolean j;
    public final ECPromotionAuctionInfo k;
    public final String l;
    public final String m;
    public final boolean n;
    public final boolean o;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof c) == false) goto L32;
        c r4 = (c) r3;
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.e, r4.e) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f, r4.f) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.g, r4.g) == true) goto L16;
        return false;
    L16:
        if (this.h == r4.h) goto L18;
        return false;
    L18:
        if (this.i == r4.i) goto L20;
        return false;
    L20:
        if (this.j == r4.j) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.k, r4.k) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.l, r4.l) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.m, r4.m) == true) goto L28;
        return false;
    L28:
        if (this.n == r4.n) goto L30;
        return false;
    L30:
        if (this.o == r4.o) goto L49;
        return false;
    L49:
        return true;
    L32:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r0v24, types: [int] */
    /* JADX WARN: Type inference failed for: r0v26, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r2v13, types: [int] */
    /* JADX WARN: Type inference failed for: r2v16, types: [int] */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v32 */
    /* JADX WARN: Type inference failed for: r2v33 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        z0 r0 = this.c;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        UpdateType r4 = this.d;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        k r7 = this.e;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.f;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.g;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        boolean r16 = this.h;
        ?? r17 = 1;
        ?? r18 = r16;
        if (r16 == false) goto L25;
        r18 = 1;
    L25:
        int r19 = (((r15 + r18) * 31) + this.i) * 31;
        boolean r20 = this.j;
        ?? r21 = r20;
        if (r20 == false) goto L28;
        r21 = 1;
    L28:
        int r22 = (r19 + r21) * 31;
        ECPromotionAuctionInfo r23 = this.k;
        if (r23 == null) goto L31;
        int r24 = r23.hashCode();
    L32:
        int r25 = (r22 + r24) * 31;
        String r26 = this.l;
        if (r26 == null) goto L35;
        int r27 = r26.hashCode();
    L36:
        int r28 = (r25 + r27) * 31;
        String r29 = this.m;
        if (r29 == null) goto L39;
        r1 = r29.hashCode();
    L39:
        int r30 = (r28 + r1) * 31;
        boolean r31 = this.n;
        ?? r32 = r31;
        if (r31 == false) goto L42;
        r32 = 1;
    L42:
        int r33 = (r30 + r32) * 31;
        boolean r34 = this.o;
        if (r34 == true) goto L47;
        r17 = r34;
    L47:
        return r33 + r17;
    L35:
        r27 = 0;
        goto L36
    L31:
        r24 = 0;
        goto L32
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
        return "PromotionImageModel(promotionImage=" + this.c + ", bindType=" + this.d + ", style=" + this.e + ", promotionId=" + this.f + ", productId=" + this.g + ", isExplain=" + this.h + ", ironIndex=" + this.i + ", isAuction=" + this.j + ", auctionInfo=" + this.k + ", roomId=" + this.l + ", roomUniqueKey=" + this.m + ", isCacheData=" + this.n + ", hasPreferredCouponEffect=" + this.o + ")";
    }

    public c(z0 r2, UpdateType r3, k r4, String r5, String r6, boolean r7, int r8, boolean r9, ECPromotionAuctionInfo r10, String r11, String r12, boolean r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r2, "promotionImage");
        Intrinsics.checkNotNullParameter(r3, "bindType");
        Intrinsics.checkNotNullParameter(r4, "style");
        Intrinsics.checkNotNullParameter(r5, "promotionId");
        Intrinsics.checkNotNullParameter(r6, "productId");
        Intrinsics.checkNotNullParameter(r11, "roomId");
        Intrinsics.checkNotNullParameter(r12, "roomUniqueKey");
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.f = r5;
        this.g = r6;
        this.h = r7;
        this.i = r8;
        this.j = r9;
        this.k = r10;
        this.l = r11;
        this.m = r12;
        this.n = r13;
        this.o = r14;
        this.a = new HotAtmosphereState();
        this.b = new AuctionAtmosphereState();
    }
}
