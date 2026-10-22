package jj2;

import com.bytedance.android.ec.model.response.v0;
import com.bytedance.android.livesdk.livecommerce.promotion.card.UpdateType;
import com.bytedance.android.livesdk.livecommerce.promotion.card.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v0 f499283a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final UpdateType f499284b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k f499285c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f499286d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L14;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f499283a, r101.f499283a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f499284b, r101.f499284b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f499285c, r101.f499285c) == true) goto L12;
        return false;
    L12:
        if (this.f499286d == r101.f499286d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        v0 r100 = this.f499283a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        UpdateType r104 = this.f499284b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        k r107 = this.f499285c;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return ((r106 + r101) * 31) + this.f499286d;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "PromotionExtendModel(promotionExtend=" + this.f499283a + ", bindType=" + this.f499284b + ", style=" + this.f499285c + ", ironIndex=" + this.f499286d + ")";
    }

    public b(v0 r100, UpdateType r101, k r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "promotionExtend");
        Intrinsics.checkNotNullParameter(r101, "bindType");
        Intrinsics.checkNotNullParameter(r102, "style");
        this.f499283a = r100;
        this.f499284b = r101;
        this.f499285c = r102;
        this.f499286d = r103;
    }
}
