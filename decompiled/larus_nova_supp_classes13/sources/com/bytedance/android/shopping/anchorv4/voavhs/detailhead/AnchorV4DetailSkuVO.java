package com.bytedance.android.shopping.anchorv4.voavhs.detailhead;

import com.bytedance.android.ec.model.ECUrlModel;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0002\u0010\rJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003JS\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0001J\u0013\u0010\u001f\u001a\u00020\t2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006%"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/detailhead/AnchorV4DetailSkuVO;", "Ljava/io/Serializable;", "jumpUrl", "", "skuId", "name", "pic", "Lcom/bytedance/android/ec/model/ECUrlModel;", "showBottomView", "", "subProducts", "", "Lcom/bytedance/android/shopping/anchorv4/voavhs/detailhead/AnchorV4SubProduct;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/ec/model/ECUrlModel;ZLjava/util/List;)V", "getJumpUrl", "()Ljava/lang/String;", "getName", "getPic", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "getShowBottomView", "()Z", "getSkuId", "getSubProducts", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "", "hashCode", "", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4DetailSkuVO implements Serializable {
    private final String jumpUrl;
    private final String name;
    private final ECUrlModel pic;
    private final boolean showBottomView;
    private final String skuId;
    private final List<AnchorV4SubProduct> subProducts;

    public AnchorV4DetailSkuVO() {
        this(null, null, null, null, false, null, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AnchorV4DetailSkuVO copy$default(AnchorV4DetailSkuVO r4, String r5, String r6, String r7, ECUrlModel r8, boolean r9, List r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.jumpUrl;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.skuId;
    L8:
        String r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.name;
    L11:
        String r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.pic;
    L14:
        ECUrlModel r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.showBottomView;
    L17:
        boolean r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.subProducts;
    L20:
        String r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final String component1() {
        return this.jumpUrl;
    }

    public final String component2() {
        return this.skuId;
    }

    public final String component3() {
        return this.name;
    }

    public final ECUrlModel component4() {
        return this.pic;
    }

    public final boolean component5() {
        return this.showBottomView;
    }

    public final List<AnchorV4SubProduct> component6() {
        return this.subProducts;
    }

    public final AnchorV4DetailSkuVO copy(String r9, String r10, String r11, ECUrlModel r12, boolean r13, List<AnchorV4SubProduct> r14) {
        Intrinsics.checkNotNullParameter(r14, "subProducts");
        return new AnchorV4DetailSkuVO(r9, r10, r11, r12, r13, r14);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof AnchorV4DetailSkuVO) == false) goto L18;
        AnchorV4DetailSkuVO r4 = (AnchorV4DetailSkuVO) r3;
        if (Intrinsics.areEqual(this.jumpUrl, r4.jumpUrl) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.skuId, r4.skuId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.name, r4.name) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.pic, r4.pic) == true) goto L14;
        return false;
    L14:
        if (this.showBottomView == r4.showBottomView) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.subProducts, r4.subProducts) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v16 */
    public int hashCode() {
        String r0 = this.jumpUrl;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.skuId;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.name;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        ECUrlModel r10 = this.pic;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        boolean r13 = this.showBottomView;
        ?? r14 = r13;
        if (r13 == false) goto L21;
        r14 = 1;
    L21:
        int r15 = (r12 + r14) * 31;
        List<AnchorV4SubProduct> r16 = this.subProducts;
        if (r16 == null) goto L25;
        r1 = r16.hashCode();
    L25:
        return r15 + r1;
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
        return "AnchorV4DetailSkuVO(jumpUrl=" + this.jumpUrl + ", skuId=" + this.skuId + ", name=" + this.name + ", pic=" + this.pic + ", showBottomView=" + this.showBottomView + ", subProducts=" + this.subProducts + ")";
    }

    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public final String getName() {
        return this.name;
    }

    public final ECUrlModel getPic() {
        return this.pic;
    }

    public final boolean getShowBottomView() {
        return this.showBottomView;
    }

    public final String getSkuId() {
        return this.skuId;
    }

    public final List<AnchorV4SubProduct> getSubProducts() {
        return this.subProducts;
    }

    public AnchorV4DetailSkuVO(String r2, String r3, String r4, ECUrlModel r5, boolean r6, List<AnchorV4SubProduct> r7) {
        Intrinsics.checkNotNullParameter(r7, "subProducts");
        this.jumpUrl = r2;
        this.skuId = r3;
        this.name = r4;
        this.pic = r5;
        this.showBottomView = r6;
        this.subProducts = r7;
    }

    public /* synthetic */ AnchorV4DetailSkuVO(String r5, String r6, String r7, ECUrlModel r8, boolean r9, List r10, int r11, DefaultConstructorMarker r12) {
        String r0 = "";
        if ((r11 & 1) == 0) goto L5;
        String r13 = "";
    L7:
        if ((r11 & 2) != 0) goto L11;
        r0 = r6;
    L11:
        if ((r11 & 4) == 0) goto L13;
        String r1 = null;
    L15:
        if ((r11 & 8) == 0) goto L17;
        ECUrlModel r2 = null;
    L19:
        if ((r11 & 16) == 0) goto L21;
        boolean r3 = false;
    L23:
        if ((r11 & 32) == 0) goto L25;
        r10 = CollectionsKt.emptyList();
    L25:
        this(r13, r0, r1, r2, r3, r10);
        return;
    L21:
        r3 = r9;
        goto L23
    L17:
        r2 = r8;
        goto L19
    L13:
        r1 = r7;
        goto L15
    L5:
        r13 = r5;
        goto L7
    }
}
