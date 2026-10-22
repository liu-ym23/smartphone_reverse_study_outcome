package jj2;

import com.bytedance.android.ec.model.response.q0;
import com.bytedance.android.livesdk.livecommerce.promotion.card.UpdateType;
import com.bytedance.android.livesdk.livecommerce.promotion.card.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q0 f499302a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final UpdateType f499303b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k f499304c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f499305d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f499306e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L16;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f499302a, r101.f499302a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f499303b, r101.f499303b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f499304c, r101.f499304c) == true) goto L12;
        return false;
    L12:
        if (this.f499305d == r101.f499305d) goto L14;
        return false;
    L14:
        if (this.f499306e == r101.f499306e) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v8 */
    public final int hashCode() {
        q0 r100 = this.f499302a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        UpdateType r104 = this.f499303b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        k r107 = this.f499304c;
        if (r107 == null) goto L13;
        r101 = r107.hashCode();
    L13:
        int r108 = (r106 + r101) * 31;
        boolean r109 = this.f499305d;
        ?? r110 = r109;
        if (r109 == false) goto L16;
        r110 = 1;
    L16:
        int r111 = (r108 + r110) * 31;
        long r112 = this.f499306e;
        return r111 + ((int) (r112 ^ (r112 >>> 32)));
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "PromotionInfoModel(promotionBenefits=" + this.f499302a + ", bindType=" + this.f499303b + ", style=" + this.f499304c + ", isAuction=" + this.f499305d + ", auctionType=" + this.f499306e + ")";
    }

    public d(q0 r100, UpdateType r101, k r102, boolean r103, long r104) {
        Intrinsics.checkNotNullParameter(r100, "promotionBenefits");
        Intrinsics.checkNotNullParameter(r101, "bindType");
        Intrinsics.checkNotNullParameter(r102, "style");
        this.f499302a = r100;
        this.f499303b = r101;
        this.f499304c = r102;
        this.f499305d = r103;
        this.f499306e = r104;
    }
}
