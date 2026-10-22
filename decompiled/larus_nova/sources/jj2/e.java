package jj2;

import com.bytedance.android.ec.model.response.d1;
import com.bytedance.android.livesdk.livecommerce.promotion.card.UpdateType;
import com.bytedance.android.livesdk.livecommerce.promotion.card.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d1 f499307a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final UpdateType f499308b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k f499309c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L12;
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f499307a, r101.f499307a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f499308b, r101.f499308b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f499309c, r101.f499309c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        d1 r100 = this.f499307a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        UpdateType r104 = this.f499308b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        k r107 = this.f499309c;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "PromotionPriceModel(promotionPrice=" + this.f499307a + ", bindType=" + this.f499308b + ", style=" + this.f499309c + ")";
    }

    public e(d1 r100, UpdateType r101, k r102) {
        Intrinsics.checkNotNullParameter(r100, "promotionPrice");
        Intrinsics.checkNotNullParameter(r101, "bindType");
        Intrinsics.checkNotNullParameter(r102, "style");
        this.f499307a = r100;
        this.f499308b = r101;
        this.f499309c = r102;
    }
}
