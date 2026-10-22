package ry6;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.discover.model.CardProtocolType;
import com.ss.android.ugc.aweme.poi.model.PoiCommodity;
import com.ss.android.ugc.aweme.poi.model.PoiDetailCouponShareSetting;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lry6/a;", "", "Lcom/ss/android/ugc/aweme/poi/model/PoiCommodity;", "poiCommodity", "Lcom/ss/android/ugc/aweme/poi/model/PoiCommodity;", "getPoiCommodity", "()Lcom/ss/android/ugc/aweme/poi/model/PoiCommodity;", "Lcom/ss/android/ugc/aweme/poi/model/PoiDetailCouponShareSetting;", "couponShareSetting", "Lcom/ss/android/ugc/aweme/poi/model/PoiDetailCouponShareSetting;", "getCouponShareSetting", "()Lcom/ss/android/ugc/aweme/poi/model/PoiDetailCouponShareSetting;", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("coupon_share_setting")
    private final PoiDetailCouponShareSetting couponShareSetting;

    @SerializedName(CardProtocolType.COMMODITY)
    private final PoiCommodity poiCommodity;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.poiCommodity, r101.poiCommodity) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.couponShareSetting, r101.couponShareSetting) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        PoiCommodity r100 = this.poiCommodity;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        PoiDetailCouponShareSetting r104 = this.couponShareSetting;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "PoiCouponData(poiCommodity=" + this.poiCommodity + ", couponShareSetting=" + this.couponShareSetting + ')';
    }

    public a() {
        this.poiCommodity = null;
        this.couponShareSetting = null;
    }
}
