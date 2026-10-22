package com.bytedance.android.shopping.prepurchase.arch.atom_event;

import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0005R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/shopping/prepurchase/arch/atom_event/g;", "", "", "promotionSource", "J", "a", "()J", "", "ecomGroupType", "Ljava/lang/String;", "getEcomGroupType", "()Ljava/lang/String;", "carrierSource", "getCarrierSource", "ecomEntranceForm", "getEcomEntranceForm", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class g {
    public static final /* synthetic */ int a = 0;

    @SerializedName("carrier_source")
    private final String carrierSource;

    @SerializedName("ecom_entrance_form")
    private final String ecomEntranceForm;

    @SerializedName("ecom_group_type")
    private final String ecomGroupType;

    @SerializedName(PdpOpenThirdParam.KEY_PROMOTION_SOURCE)
    private final long promotionSource;

    public static final class a {
        public static g a(Map r8) {
            Object r0 = null;
            if (r8 != null) goto L5;
            return null;
        L5:
            Object r1 = r8.get(PdpOpenThirdParam.KEY_PROMOTION_SOURCE);
            if ((r1 instanceof Long) == true) goto L8;
            r1 = null;
        L8:
            Long r2 = (Long) r1;
            if (r2 == null) goto L11;
            long r3 = r2.longValue();
        L12:
            long r4 = r3;
            Object r5 = r8.get("ecom_group_type");
            if ((r5 instanceof String) == true) goto L15;
            r5 = null;
        L15:
            String r6 = (String) r5;
            Object r7 = r8.get("carrier_source");
            if ((r7 instanceof String) == true) goto L18;
            r7 = null;
        L18:
            String r9 = (String) r7;
            Object r10 = r8.get("ecom_entrance_form");
            if ((r10 instanceof String) == false) goto L23;
            r0 = r10;
        L23:
            return new g(r4, r6, r9, (String) r0);
        L11:
            r3 = 0;
            goto L12
        }
    }

    static {
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof g) == false) goto L14;
        g r7 = (g) r6;
        if (this.promotionSource == r7.promotionSource) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.ecomGroupType, r7.ecomGroupType) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.carrierSource, r7.carrierSource) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.ecomEntranceForm, r7.ecomEntranceForm) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        long r0 = this.promotionSource;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        String r2 = this.ecomGroupType;
        int r3 = 0;
        if (r2 == null) goto L5;
        int r4 = r2.hashCode();
    L6:
        int r5 = (r1 + r4) * 31;
        String r6 = this.carrierSource;
        if (r6 == null) goto L9;
        int r7 = r6.hashCode();
    L10:
        int r8 = (r5 + r7) * 31;
        String r9 = this.ecomEntranceForm;
        if (r9 == null) goto L14;
        r3 = r9.hashCode();
    L14:
        return r8 + r3;
    L9:
        r7 = 0;
        goto L10
    L5:
        r4 = 0;
        goto L6
    }

    public final String toString() {
        return "PDPLegalVerificationActionAtomEventParams(promotionSource=" + this.promotionSource + ", ecomGroupType=" + this.ecomGroupType + ", carrierSource=" + this.carrierSource + ", ecomEntranceForm=" + this.ecomEntranceForm + ")";
    }

    public g() {
        this(0, "", "", "");
    }

    public final long a() {
        return this.promotionSource;
    }

    public g(long r1, String r3, String r4, String r5) {
        this.promotionSource = r1;
        this.ecomGroupType = r3;
        this.carrierSource = r4;
        this.ecomEntranceForm = r5;
    }
}
