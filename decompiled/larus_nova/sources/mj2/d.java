package mj2;

import com.bytedance.android.ec.model.promotion.ECUIPromotionLiveListConfig;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f514170a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f514171b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ql.d f514172c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f514173d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ECUIPromotionLiveListConfig f514174e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final g f514175f;

    public d() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L18;
        d r101 = (d) r100;
        if (this.f514170a == r101.f514170a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f514171b, r101.f514171b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f514172c, r101.f514172c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f514173d, r101.f514173d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f514174e, r101.f514174e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f514175f, r101.f514175f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    public final int hashCode() {
        boolean r100 = this.f514170a;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = r101 * 31;
        List<String> r103 = this.f514171b;
        int r104 = 0;
        if (r103 == null) goto L8;
        int r105 = r103.hashCode();
    L9:
        int r106 = (r102 + r105) * 31;
        ql.d r107 = this.f514172c;
        if (r107 == null) goto L12;
        int r108 = r107.hashCode();
    L13:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f514173d;
        if (r110 == null) goto L16;
        int r111 = r110.hashCode();
    L17:
        int r112 = (r109 + r111) * 31;
        ECUIPromotionLiveListConfig r113 = this.f514174e;
        if (r113 == null) goto L20;
        int r114 = r113.hashCode();
    L21:
        int r115 = (r112 + r114) * 31;
        g r116 = this.f514175f;
        if (r116 == null) goto L25;
        r104 = r116.hashCode();
    L25:
        return r115 + r104;
    L20:
        r114 = 0;
        goto L21
    L16:
        r111 = 0;
        goto L17
    L12:
        r108 = 0;
        goto L13
    L8:
        r105 = 0;
        goto L9
    }

    public final String toString() {
        return "LivePromotionListItemExtraInfo(hasAuthorShopInfo=" + this.f514170a + ", promotionListHeaderLabelNames=" + this.f514171b + ", listLevelState=" + this.f514172c + ", authorSellScore=" + this.f514173d + ", config=" + this.f514174e + ", smartProductInfoLogData=" + this.f514175f + ")";
    }

    public /* synthetic */ d(int r100) {
        this(true, null, null, null, null, null);
    }

    public d(boolean r100, List<String> r101, ql.d r102, String r103, ECUIPromotionLiveListConfig r104, g r105) {
        this.f514170a = r100;
        this.f514171b = r101;
        this.f514172c = r102;
        this.f514173d = r103;
        this.f514174e = r104;
        this.f514175f = r105;
    }
}
