package jj2;

import com.bytedance.android.ec.model.response.q0;
import com.bytedance.android.livesdk.livecommerce.promotion.card.UpdateType;
import com.bytedance.android.livesdk.livecommerce.promotion.card.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d {
    public final q0 a;
    public final UpdateType b;
    public final k c;
    public final boolean d;
    public final long e;

    public final boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof d) == false) goto L16;
        d r6 = (d) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L12;
        return false;
    L12:
        if (this.d == r6.d) goto L14;
        return false;
    L14:
        if (this.e == r6.e) goto L25;
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
        q0 r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        UpdateType r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        k r7 = this.c;
        if (r7 == null) goto L13;
        r1 = r7.hashCode();
    L13:
        int r8 = (r6 + r1) * 31;
        boolean r9 = this.d;
        ?? r10 = r9;
        if (r9 == false) goto L16;
        r10 = 1;
    L16:
        int r11 = (r8 + r10) * 31;
        long r12 = this.e;
        return r11 + ((int) (r12 ^ (r12 >>> 32)));
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "PromotionInfoModel(promotionBenefits=" + this.a + ", bindType=" + this.b + ", style=" + this.c + ", isAuction=" + this.d + ", auctionType=" + this.e + ")";
    }

    public d(q0 r2, UpdateType r3, k r4, boolean r5, long r6) {
        Intrinsics.checkNotNullParameter(r2, "promotionBenefits");
        Intrinsics.checkNotNullParameter(r3, "bindType");
        Intrinsics.checkNotNullParameter(r4, "style");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
