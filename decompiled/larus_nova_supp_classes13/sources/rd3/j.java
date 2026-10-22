package rd3;

import com.bytedance.android.ec.model.response.anchorv3.MarketingBanner;
import com.bytedance.android.ec.model.response.anchorv3.MarketingTip;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lrd3/j;", "", "Lcom/bytedance/android/ec/model/response/anchorv3/MarketingBanner;", "marketingBanner", "Lcom/bytedance/android/ec/model/response/anchorv3/MarketingBanner;", "a", "()Lcom/bytedance/android/ec/model/response/anchorv3/MarketingBanner;", "Lcom/bytedance/android/ec/model/response/anchorv3/MarketingTip;", "marketingTip", "Lcom/bytedance/android/ec/model/response/anchorv3/MarketingTip;", "b", "()Lcom/bytedance/android/ec/model/response/anchorv3/MarketingTip;", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class j {

    @SerializedName("marketing_banner")
    private final MarketingBanner marketingBanner;

    @SerializedName("marketing_tip")
    private final MarketingTip marketingTip;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof j) == false) goto L10;
        j r4 = (j) r3;
        if (Intrinsics.areEqual(this.marketingBanner, r4.marketingBanner) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.marketingTip, r4.marketingTip) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        MarketingBanner r0 = this.marketingBanner;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        MarketingTip r4 = this.marketingTip;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "MemberMarketingInfo(marketingBanner=" + this.marketingBanner + ", marketingTip=" + this.marketingTip + ")";
    }

    public j() {
        this.marketingBanner = null;
        this.marketingTip = null;
    }

    public final MarketingBanner a() {
        return this.marketingBanner;
    }

    public final MarketingTip b() {
        return this.marketingTip;
    }
}
