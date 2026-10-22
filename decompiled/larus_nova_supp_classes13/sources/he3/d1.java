package he3;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010%\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0014\u0010\u000bR*\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\t\u001a\u0004\b\u001b\u0010\u000b¨\u0006\u001c"}, d2 = {"Lhe3/d1;", "", "", "", "couponMetaIds", "Ljava/util/List;", "a", "()Ljava/util/List;", "prizeActivityId", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "", "discountId", "Ljava/lang/Long;", "getDiscountId", "()Ljava/lang/Long;", "discountType", "getDiscountType", "discount", "c", "", "custom", "Ljava/util/Map;", "b", "()Ljava/util/Map;", "applySource", "getApplySource", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d1 {

    @SerializedName("apply_source")
    private final String applySource;

    @SerializedName("coupon_meta_ids")
    private final List<String> couponMetaIds;

    @SerializedName("custom")
    private final Map<String, Object> custom;

    @SerializedName("discount")
    private final String discount;

    @SerializedName("discount_id")
    private final Long discountId;

    @SerializedName("discount_type")
    private final Long discountType;

    @SerializedName("prize_activity_id")
    private final String prizeActivityId;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof d1) == false) goto L20;
        d1 r4 = (d1) r3;
        if (Intrinsics.areEqual(this.couponMetaIds, r4.couponMetaIds) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.prizeActivityId, r4.prizeActivityId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.discountId, r4.discountId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.discountType, r4.discountType) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.discount, r4.discount) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.custom, r4.custom) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.applySource, r4.applySource) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
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
        Long r7 = this.discountId;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Long r10 = this.discountType;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.discount;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        Map<String, Object> r16 = this.custom;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.applySource;
        if (r19 == null) goto L30;
        r1 = r19.hashCode();
    L30:
        return r18 + r1;
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
        return "ProductApplyPrizeInfo(couponMetaIds=" + this.couponMetaIds + ", prizeActivityId=" + this.prizeActivityId + ", discountId=" + this.discountId + ", discountType=" + this.discountType + ", discount=" + this.discount + ", custom=" + this.custom + ", applySource=" + this.applySource + ")";
    }

    public d1() {
        this.couponMetaIds = null;
        this.prizeActivityId = null;
        this.discountId = null;
        this.discountType = null;
        this.discount = null;
        this.custom = null;
        this.applySource = null;
    }

    public final List<String> a() {
        return this.couponMetaIds;
    }

    public final Map<String, Object> b() {
        return this.custom;
    }

    public final String c() {
        return this.discount;
    }

    public final String d() {
        return this.prizeActivityId;
    }
}
