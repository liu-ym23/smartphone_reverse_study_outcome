package jj2;

import com.bytedance.android.ec.model.response.g1;
import com.bytedance.android.livesdk.livecommerce.promotion.card.UpdateType;
import com.bytedance.android.livesdk.livecommerce.promotion.card.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g1 f499277a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final UpdateType f499278b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k f499279c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f499280d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f499281e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f499282f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L18;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f499277a, r101.f499277a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f499278b, r101.f499278b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f499279c, r101.f499279c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f499280d, r101.f499280d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f499281e, r101.f499281e) == true) goto L16;
        return false;
    L16:
        if (this.f499282f == r101.f499282f) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        g1 r100 = this.f499277a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        UpdateType r104 = this.f499278b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        k r107 = this.f499279c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f499280d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f499281e;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return ((r112 + r101) * 31) + this.f499282f;
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
        return "PromotionButtonModel(promotionButton=" + this.f499277a + ", bindType=" + this.f499278b + ", style=" + this.f499279c + ", promotionId=" + this.f499280d + ", productId=" + this.f499281e + ", ironIndex=" + this.f499282f + ")";
    }

    public a(g1 r100, UpdateType r101, k r102, String r103, String r104, int r105) {
        Intrinsics.checkNotNullParameter(r100, "promotionButton");
        Intrinsics.checkNotNullParameter(r101, "bindType");
        Intrinsics.checkNotNullParameter(r102, "style");
        Intrinsics.checkNotNullParameter(r103, "promotionId");
        Intrinsics.checkNotNullParameter(r104, "productId");
        this.f499277a = r100;
        this.f499278b = r101;
        this.f499279c = r102;
        this.f499280d = r103;
        this.f499281e = r104;
        this.f499282f = r105;
    }
}
