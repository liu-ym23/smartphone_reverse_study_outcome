package com.bytedance.android.shopping.store.home.entity;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Be\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\rHÆ\u0003Ji\u0010%\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020+HÖ\u0001J\t\u0010,\u001a\u00020\u000bHÖ\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R \u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0010R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0010¨\u0006-"}, d2 = {"Lcom/bytedance/android/shopping/store/home/entity/ECShopToolsInfo;", "Ljava/io/Serializable;", "customServiceEntry", "Lcom/bytedance/android/shopping/store/home/entity/ToolEntryInfo;", "shareEntry", "cartEntry", "orderEntry", "memberEntry", "couponRedPackEntry", "Lcom/bytedance/android/shopping/store/home/entity/CouponRedPackEntryInfo;", "lynxUrl", "", "couponIcon", "Lcom/bytedance/android/ec/model/ECUrlModel;", "(Lcom/bytedance/android/shopping/store/home/entity/ToolEntryInfo;Lcom/bytedance/android/shopping/store/home/entity/ToolEntryInfo;Lcom/bytedance/android/shopping/store/home/entity/ToolEntryInfo;Lcom/bytedance/android/shopping/store/home/entity/ToolEntryInfo;Lcom/bytedance/android/shopping/store/home/entity/ToolEntryInfo;Lcom/bytedance/android/shopping/store/home/entity/CouponRedPackEntryInfo;Ljava/lang/String;Lcom/bytedance/android/ec/model/ECUrlModel;)V", "getCartEntry", "()Lcom/bytedance/android/shopping/store/home/entity/ToolEntryInfo;", "getCouponIcon", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "setCouponIcon", "(Lcom/bytedance/android/ec/model/ECUrlModel;)V", "getCouponRedPackEntry", "()Lcom/bytedance/android/shopping/store/home/entity/CouponRedPackEntryInfo;", "getCustomServiceEntry", "getLynxUrl", "()Ljava/lang/String;", "getMemberEntry", "getOrderEntry", "getShareEntry", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopToolsInfo implements Serializable {

    @SerializedName("cart_entry_info")
    private final ToolEntryInfo cartEntry;

    @SerializedName("coupon_icon")
    private ECUrlModel couponIcon;

    @SerializedName("coupon_red_pack_entry_info")
    private final CouponRedPackEntryInfo couponRedPackEntry;

    @SerializedName("service_entry_info")
    private final ToolEntryInfo customServiceEntry;

    @SerializedName("render_lynx_url")
    private final String lynxUrl;

    @SerializedName("member_entry_info")
    private final ToolEntryInfo memberEntry;

    @SerializedName("order_entry_info")
    private final ToolEntryInfo orderEntry;

    @SerializedName("share_entry_info")
    private final ToolEntryInfo shareEntry;

    public ECShopToolsInfo() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public static /* synthetic */ ECShopToolsInfo copy$default(ECShopToolsInfo r9, ToolEntryInfo r10, ToolEntryInfo r11, ToolEntryInfo r12, ToolEntryInfo r13, ToolEntryInfo r14, CouponRedPackEntryInfo r15, String r16, ECUrlModel r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        ToolEntryInfo r2 = r9.customServiceEntry;
    L7:
        if ((r18 & 2) == 0) goto L9;
        ToolEntryInfo r3 = r9.shareEntry;
    L11:
        if ((r18 & 4) == 0) goto L13;
        ToolEntryInfo r4 = r9.cartEntry;
    L15:
        if ((r18 & 8) == 0) goto L17;
        ToolEntryInfo r5 = r9.orderEntry;
    L19:
        if ((r18 & 16) == 0) goto L21;
        ToolEntryInfo r6 = r9.memberEntry;
    L23:
        if ((r18 & 32) == 0) goto L25;
        CouponRedPackEntryInfo r7 = r9.couponRedPackEntry;
    L27:
        if ((r18 & 64) == 0) goto L29;
        String r8 = r9.lynxUrl;
    L31:
        if ((r18 & 128) == 0) goto L33;
        ECUrlModel r1 = r9.couponIcon;
    L35:
        return r9.copy(r2, r3, r4, r5, r6, r7, r8, r1);
    L33:
        r1 = r17;
        goto L35
    L29:
        r8 = r16;
        goto L31
    L25:
        r7 = r15;
        goto L27
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r2 = r10;
        goto L7
    }

    public final ToolEntryInfo component1() {
        return this.customServiceEntry;
    }

    public final ToolEntryInfo component2() {
        return this.shareEntry;
    }

    public final ToolEntryInfo component3() {
        return this.cartEntry;
    }

    public final ToolEntryInfo component4() {
        return this.orderEntry;
    }

    public final ToolEntryInfo component5() {
        return this.memberEntry;
    }

    public final CouponRedPackEntryInfo component6() {
        return this.couponRedPackEntry;
    }

    public final String component7() {
        return this.lynxUrl;
    }

    public final ECUrlModel component8() {
        return this.couponIcon;
    }

    public final ECShopToolsInfo copy(ToolEntryInfo r11, ToolEntryInfo r12, ToolEntryInfo r13, ToolEntryInfo r14, ToolEntryInfo r15, CouponRedPackEntryInfo r16, String r17, ECUrlModel r18) {
        return new ECShopToolsInfo(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof ECShopToolsInfo) == false) goto L22;
        ECShopToolsInfo r4 = (ECShopToolsInfo) r3;
        if (Intrinsics.areEqual(this.customServiceEntry, r4.customServiceEntry) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.shareEntry, r4.shareEntry) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.cartEntry, r4.cartEntry) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.orderEntry, r4.orderEntry) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.memberEntry, r4.memberEntry) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.couponRedPackEntry, r4.couponRedPackEntry) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.lynxUrl, r4.lynxUrl) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.couponIcon, r4.couponIcon) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public int hashCode() {
        ToolEntryInfo r0 = this.customServiceEntry;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        ToolEntryInfo r4 = this.shareEntry;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        ToolEntryInfo r7 = this.cartEntry;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        ToolEntryInfo r10 = this.orderEntry;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        ToolEntryInfo r13 = this.memberEntry;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        CouponRedPackEntryInfo r16 = this.couponRedPackEntry;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.lynxUrl;
        if (r19 == null) goto L29;
        int r20 = r19.hashCode();
    L30:
        int r21 = (r18 + r20) * 31;
        ECUrlModel r22 = this.couponIcon;
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

    public String toString() {
        return "ECShopToolsInfo(customServiceEntry=" + this.customServiceEntry + ", shareEntry=" + this.shareEntry + ", cartEntry=" + this.cartEntry + ", orderEntry=" + this.orderEntry + ", memberEntry=" + this.memberEntry + ", couponRedPackEntry=" + this.couponRedPackEntry + ", lynxUrl=" + this.lynxUrl + ", couponIcon=" + this.couponIcon + ")";
    }

    public final ToolEntryInfo getCartEntry() {
        return this.cartEntry;
    }

    public final ECUrlModel getCouponIcon() {
        return this.couponIcon;
    }

    public final CouponRedPackEntryInfo getCouponRedPackEntry() {
        return this.couponRedPackEntry;
    }

    public final ToolEntryInfo getCustomServiceEntry() {
        return this.customServiceEntry;
    }

    public final String getLynxUrl() {
        return this.lynxUrl;
    }

    public final ToolEntryInfo getMemberEntry() {
        return this.memberEntry;
    }

    public final ToolEntryInfo getOrderEntry() {
        return this.orderEntry;
    }

    public final ToolEntryInfo getShareEntry() {
        return this.shareEntry;
    }

    public final void setCouponIcon(ECUrlModel r1) {
        this.couponIcon = r1;
    }

    public ECShopToolsInfo(ToolEntryInfo r1, ToolEntryInfo r2, ToolEntryInfo r3, ToolEntryInfo r4, ToolEntryInfo r5, CouponRedPackEntryInfo r6, String r7, ECUrlModel r8) {
        this.customServiceEntry = r1;
        this.shareEntry = r2;
        this.cartEntry = r3;
        this.orderEntry = r4;
        this.memberEntry = r5;
        this.couponRedPackEntry = r6;
        this.lynxUrl = r7;
        this.couponIcon = r8;
    }

    public /* synthetic */ ECShopToolsInfo(ToolEntryInfo r10, ToolEntryInfo r11, ToolEntryInfo r12, ToolEntryInfo r13, ToolEntryInfo r14, CouponRedPackEntryInfo r15, String r16, ECUrlModel r17, int r18, DefaultConstructorMarker r19) {
        ECUrlModel r2 = null;
        if ((r18 & 1) == 0) goto L5;
        ToolEntryInfo r1 = null;
    L7:
        if ((r18 & 2) == 0) goto L9;
        ToolEntryInfo r3 = null;
    L11:
        if ((r18 & 4) == 0) goto L13;
        ToolEntryInfo r4 = null;
    L15:
        if ((r18 & 8) == 0) goto L17;
        ToolEntryInfo r5 = null;
    L19:
        if ((r18 & 16) == 0) goto L21;
        ToolEntryInfo r6 = null;
    L23:
        if ((r18 & 32) == 0) goto L25;
        CouponRedPackEntryInfo r7 = null;
    L27:
        if ((r18 & 64) == 0) goto L29;
        String r8 = null;
    L31:
        if ((r18 & 128) != 0) goto L34;
        r2 = r17;
    L34:
        this(r1, r3, r4, r5, r6, r7, r8, r2);
        return;
    L29:
        r8 = r16;
        goto L31
    L25:
        r7 = r15;
        goto L27
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r1 = r10;
        goto L7
    }
}
