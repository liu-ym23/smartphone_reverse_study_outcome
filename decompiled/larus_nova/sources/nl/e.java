package nl;

import com.bytedance.android.ec.model.ClickButtonParam;
import com.bytedance.android.ec.model.order.ECOrderTrackerData;
import com.bytedance.android.ec.model.order.ProductDetailPageParams;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ECOrderTrackerData f519516a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ProductDetailPageParams f519517b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PromotionProductStruct f519518c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f519519d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f519520e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f519521f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ClickButtonParam f519522g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final a f519523h;

    public e() {
        this(null, null, null, false, null, 0, null, null, 511);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L24;
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f519516a, r101.f519516a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f519517b, r101.f519517b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f519518c, r101.f519518c) == true) goto L12;
        return false;
    L12:
        if (this.f519519d == r101.f519519d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f519520e, r101.f519520e) == true) goto L16;
        return false;
    L16:
        if (this.f519521f == r101.f519521f) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f519522g, r101.f519522g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f519523h, r101.f519523h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(null, null) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    public final int hashCode() {
        ECOrderTrackerData r100 = this.f519516a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        int r102 = r101 * 31;
        ProductDetailPageParams r103 = this.f519517b;
        if (r103 == null) goto L9;
        int r104 = r103.hashCode();
    L10:
        int r105 = (r102 + r104) * 31;
        PromotionProductStruct r106 = this.f519518c;
        if (r106 == null) goto L13;
        int r107 = r106.hashCode();
    L14:
        int r108 = (r105 + r107) * 31;
        boolean r109 = this.f519519d;
        ?? r110 = r109;
        if (r109 == false) goto L17;
        r110 = 1;
    L17:
        int r111 = (r108 + r110) * 31;
        String r112 = this.f519520e;
        if (r112 == null) goto L20;
        int r113 = r112.hashCode();
    L21:
        int r114 = (((r111 + r113) * 31) + this.f519521f) * 31;
        ClickButtonParam r115 = this.f519522g;
        if (r115 == null) goto L24;
        int r116 = r115.hashCode();
    L25:
        int r117 = (r114 + r116) * 31;
        a r118 = this.f519523h;
        if (r118 == null) goto L28;
        int r119 = r118.hashCode();
    L30:
        return ((r117 + r119) * 31) + 0;
    L28:
        r119 = 0;
        goto L30
    L24:
        r116 = 0;
        goto L25
    L20:
        r113 = 0;
        goto L21
    L13:
        r107 = 0;
        goto L14
    L9:
        r104 = 0;
        goto L10
    L5:
        r101 = 0;
        goto L6
    }

    public final String toString() {
        return "OrderSchemaVO(orderTrackerData=" + this.f519516a + ", productDetailPageParams=" + this.f519517b + ", mPromotion=" + this.f519518c + ", isUserJoinActivity=" + this.f519519d + ", passThroughEventData=" + this.f519520e + ", index=" + this.f519521f + ", mClickButtonParam=" + this.f519522g + ", adParams=" + this.f519523h + ", skuOrderParams=null)";
    }

    public e(ECOrderTrackerData r100, ProductDetailPageParams r101, PromotionProductStruct r102, boolean r103, String r104, int r105, ClickButtonParam r106, a r110, int r111) {
        if ((r111 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r111 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r111 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r111 & 8) == 0) goto L15;
        r103 = true;
    L15:
        if ((r111 & 16) == 0) goto L18;
        r104 = null;
    L18:
        if ((r111 & 32) == 0) goto L21;
        r105 = -1;
    L21:
        if ((r111 & 64) == 0) goto L24;
        r106 = null;
    L24:
        if ((r111 & 128) == 0) goto L26;
        r110 = null;
    L26:
        this.f519516a = r100;
        this.f519517b = r101;
        this.f519518c = r102;
        this.f519519d = r103;
        this.f519520e = r104;
        this.f519521f = r105;
        this.f519522g = r106;
        this.f519523h = r110;
    }
}
