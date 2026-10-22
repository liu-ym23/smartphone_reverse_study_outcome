package he3;

import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0014\u0010\u000bR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\t\u001a\u0004\b\u0016\u0010\u000bR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0018\u0010\u001aR*\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lhe3/k;", "", "", "", "couponMetaIds", "Ljava/util/List;", "getCouponMetaIds", "()Ljava/util/List;", "prizeActivityId", "Ljava/lang/String;", "getPrizeActivityId", "()Ljava/lang/String;", "applySource", "getApplySource", "", "couponSourceType", "Ljava/lang/Long;", "getCouponSourceType", "()Ljava/lang/Long;", "productId", "getProductId", "couponApplyReqKey", "getCouponApplyReqKey", "", "isNeedPopup", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "", "bizParam", "Ljava/util/Map;", "getBizParam", "()Ljava/util/Map;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class k {

    @SerializedName("apply_source")
    private final String applySource;

    @SerializedName("biz_param")
    private final Map<String, String> bizParam;

    @SerializedName("coupon_apply_req_key")
    private final String couponApplyReqKey;

    @SerializedName("coupon_meta_ids")
    private final List<String> couponMetaIds;

    @SerializedName("coupon_source_type")
    private final Long couponSourceType;

    @SerializedName("is_need_popup")
    private final Boolean isNeedPopup;

    @SerializedName("prize_activity_id")
    private final String prizeActivityId;

    @SerializedName(PdpOpenThirdParam.KEY_PRODUCT_ID)
    private final String productId;

    public k() {
        this(null, null, null, null, null, null, null, null);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof k) == false) goto L22;
        k r4 = (k) r3;
        if (Intrinsics.areEqual(this.couponMetaIds, r4.couponMetaIds) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.prizeActivityId, r4.prizeActivityId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.applySource, r4.applySource) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.couponSourceType, r4.couponSourceType) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.productId, r4.productId) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.couponApplyReqKey, r4.couponApplyReqKey) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.isNeedPopup, r4.isNeedPopup) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.bizParam, r4.bizParam) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public final int hashCode() {
        List<String> r0 = this.couponMetaIds;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.prizeActivityId;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.applySource;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Long r10 = this.couponSourceType;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.productId;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.couponApplyReqKey;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        Boolean r19 = this.isNeedPopup;
        if (r19 == null) goto L29;
        int r20 = r19.hashCode();
    L30:
        int r21 = (r18 + r20) * 31;
        Map<String, String> r22 = this.bizParam;
        if (r22 == null) goto L34;
        r1 = r22.hashCode();
    L34:
        return r21 + r1;
    L29:
        r20 = 0;
        goto L30
    L25:
        r17 = 0;
        goto L26
    L21:
        r14 = 0;
        goto L22
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "DeepFeedCouponReq(couponMetaIds=" + this.couponMetaIds + ", prizeActivityId=" + this.prizeActivityId + ", applySource=" + this.applySource + ", couponSourceType=" + this.couponSourceType + ", productId=" + this.productId + ", couponApplyReqKey=" + this.couponApplyReqKey + ", isNeedPopup=" + this.isNeedPopup + ", bizParam=" + this.bizParam + ")";
    }

    public k(List<String> r1, String r2, String r3, Long r4, String r5, String r6, Boolean r7, Map<String, String> r8) {
        this.couponMetaIds = r1;
        this.prizeActivityId = r2;
        this.applySource = r3;
        this.couponSourceType = r4;
        this.productId = r5;
        this.couponApplyReqKey = r6;
        this.isNeedPopup = r7;
        this.bizParam = r8;
    }
}
