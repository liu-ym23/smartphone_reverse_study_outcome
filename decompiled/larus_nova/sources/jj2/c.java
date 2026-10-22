package jj2;

import com.bytedance.android.ec.model.response.ECPromotionAuctionInfo;
import com.bytedance.android.ec.model.response.z0;
import com.bytedance.android.livesdk.livecommerce.promotion.card.UpdateType;
import com.bytedance.android.livesdk.livecommerce.promotion.card.k;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.model.AuctionAtmosphereState;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.model.HotAtmosphereState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HotAtmosphereState f499287a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AuctionAtmosphereState f499288b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final z0 f499289c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final UpdateType f499290d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final k f499291e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f499292f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f499293g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f499294h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f499295i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f499296j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ECPromotionAuctionInfo f499297k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f499298l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f499299m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f499300n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f499301o;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L32;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f499289c, r101.f499289c) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f499290d, r101.f499290d) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f499291e, r101.f499291e) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f499292f, r101.f499292f) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f499293g, r101.f499293g) == true) goto L16;
        return false;
    L16:
        if (this.f499294h == r101.f499294h) goto L18;
        return false;
    L18:
        if (this.f499295i == r101.f499295i) goto L20;
        return false;
    L20:
        if (this.f499296j == r101.f499296j) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f499297k, r101.f499297k) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f499298l, r101.f499298l) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.f499299m, r101.f499299m) == true) goto L28;
        return false;
    L28:
        if (this.f499300n == r101.f499300n) goto L30;
        return false;
    L30:
        if (this.f499301o == r101.f499301o) goto L49;
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
        z0 r100 = this.f499289c;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        UpdateType r104 = this.f499290d;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        k r107 = this.f499291e;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f499292f;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f499293g;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        boolean r116 = this.f499294h;
        ?? r117 = 1;
        ?? r118 = r116;
        if (r116 == false) goto L25;
        r118 = 1;
    L25:
        int r119 = (((r115 + r118) * 31) + this.f499295i) * 31;
        boolean r120 = this.f499296j;
        ?? r121 = r120;
        if (r120 == false) goto L28;
        r121 = 1;
    L28:
        int r122 = (r119 + r121) * 31;
        ECPromotionAuctionInfo r123 = this.f499297k;
        if (r123 == null) goto L31;
        int r124 = r123.hashCode();
    L32:
        int r125 = (r122 + r124) * 31;
        String r126 = this.f499298l;
        if (r126 == null) goto L35;
        int r127 = r126.hashCode();
    L36:
        int r128 = (r125 + r127) * 31;
        String r129 = this.f499299m;
        if (r129 == null) goto L39;
        r101 = r129.hashCode();
    L39:
        int r130 = (r128 + r101) * 31;
        boolean r131 = this.f499300n;
        ?? r132 = r131;
        if (r131 == false) goto L42;
        r132 = 1;
    L42:
        int r133 = (r130 + r132) * 31;
        boolean r134 = this.f499301o;
        if (r134 == true) goto L47;
        r117 = r134;
    L47:
        return r133 + r117;
    L35:
        r127 = 0;
        goto L36
    L31:
        r124 = 0;
        goto L32
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "PromotionImageModel(promotionImage=" + this.f499289c + ", bindType=" + this.f499290d + ", style=" + this.f499291e + ", promotionId=" + this.f499292f + ", productId=" + this.f499293g + ", isExplain=" + this.f499294h + ", ironIndex=" + this.f499295i + ", isAuction=" + this.f499296j + ", auctionInfo=" + this.f499297k + ", roomId=" + this.f499298l + ", roomUniqueKey=" + this.f499299m + ", isCacheData=" + this.f499300n + ", hasPreferredCouponEffect=" + this.f499301o + ")";
    }

    public c(z0 r100, UpdateType r101, k r102, String r103, String r104, boolean r105, int r106, boolean r107, ECPromotionAuctionInfo r110, String r111, String r112, boolean r113, boolean r114) {
        Intrinsics.checkNotNullParameter(r100, "promotionImage");
        Intrinsics.checkNotNullParameter(r101, "bindType");
        Intrinsics.checkNotNullParameter(r102, "style");
        Intrinsics.checkNotNullParameter(r103, "promotionId");
        Intrinsics.checkNotNullParameter(r104, "productId");
        Intrinsics.checkNotNullParameter(r111, "roomId");
        Intrinsics.checkNotNullParameter(r112, "roomUniqueKey");
        this.f499289c = r100;
        this.f499290d = r101;
        this.f499291e = r102;
        this.f499292f = r103;
        this.f499293g = r104;
        this.f499294h = r105;
        this.f499295i = r106;
        this.f499296j = r107;
        this.f499297k = r110;
        this.f499298l = r111;
        this.f499299m = r112;
        this.f499300n = r113;
        this.f499301o = r114;
        this.f499287a = new HotAtmosphereState();
        this.f499288b = new AuctionAtmosphereState();
    }
}
