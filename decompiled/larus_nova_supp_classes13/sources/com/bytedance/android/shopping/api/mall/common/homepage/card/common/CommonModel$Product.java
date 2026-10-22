package com.bytedance.android.shopping.api.mall.common.homepage.card.common;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0019\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\b\u0012\u0006\u0010\u0014\u001a\u00020\n\u0012\u0006\u0010\u0015\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0002¢\u0006\u0004\b0\u00101J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\t\u0010\u0006\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0007\u001a\u00020\u0004HÆ\u0003J\t\u0010\t\u001a\u00020\bHÆ\u0003J\t\u0010\u000b\u001a\u00020\nHÆ\u0003J\t\u0010\f\u001a\u00020\u0004HÆ\u0003J\t\u0010\r\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\t\u0010\u0010\u001a\u00020\u0002HÆ\u0003J[\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u0011\u001a\u00020\u00042\b\b\u0002\u0010\u0012\u001a\u00020\u00042\b\b\u0002\u0010\u0013\u001a\u00020\b2\b\b\u0002\u0010\u0014\u001a\u00020\n2\b\b\u0002\u0010\u0015\u001a\u00020\u00042\b\b\u0002\u0010\u0016\u001a\u00020\u00042\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u0018\u001a\u00020\u0002HÆ\u0001J\t\u0010\u001b\u001a\u00020\u0004HÖ\u0001J\t\u0010\u001c\u001a\u00020\nHÖ\u0001J\u0013\u0010\u001e\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\u0011\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010\u0012\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u001f\u001a\u0004\b\"\u0010!R\u0017\u0010\u0013\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u0013\u0010#\u001a\u0004\b$\u0010%R\u0017\u0010\u0014\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u0014\u0010&\u001a\u0004\b'\u0010(R\u0017\u0010\u0015\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u001f\u001a\u0004\b)\u0010!R\u0017\u0010\u0016\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u001f\u001a\u0004\b*\u0010!R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b\u0017\u0010+\u001a\u0004\b,\u0010-R\u0017\u0010\u0018\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0018\u0010.\u001a\u0004\b\u0018\u0010/¨\u00062"}, d2 = {"com/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$Product", "", "", "isReturnRewardContainerVisible", "", "getRewardText", "component1", "component2", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$Price;", "component3", "", "component4", "component5", "component6", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$MarketingData;", "component7", "component8", "cover", "title", "price", "sales", "accessibilityLabel", "recReason", "marketingData", "isCoverInPool", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$Product;", "copy", "toString", "hashCode", "other", "equals", "Ljava/lang/String;", "getCover", "()Ljava/lang/String;", "getTitle", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$Price;", "getPrice", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$Price;", "I", "getSales", "()I", "getAccessibilityLabel", "getRecReason", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$MarketingData;", "getMarketingData", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$MarketingData;", "Z", "()Z", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$Price;ILjava/lang/String;Ljava/lang/String;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$MarketingData;Z)V", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommonModel$Product {
    private final String accessibilityLabel;
    private final String cover;
    private final boolean isCoverInPool;
    private final CommonData.MarketingData marketingData;
    private final CommonModel$Price price;
    private final String recReason;
    private final int sales;
    private final String title;

    public static /* synthetic */ CommonModel$Product copy$default(CommonModel$Product r9, String r10, String r11, CommonModel$Price r12, int r13, String r14, String r15, CommonData.MarketingData r16, boolean r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        String r2 = r9.cover;
    L7:
        if ((r18 & 2) == 0) goto L9;
        String r3 = r9.title;
    L11:
        if ((r18 & 4) == 0) goto L13;
        CommonModel$Price r4 = r9.price;
    L15:
        if ((r18 & 8) == 0) goto L17;
        int r5 = r9.sales;
    L19:
        if ((r18 & 16) == 0) goto L21;
        String r6 = r9.accessibilityLabel;
    L23:
        if ((r18 & 32) == 0) goto L25;
        String r7 = r9.recReason;
    L27:
        if ((r18 & 64) == 0) goto L29;
        CommonData.MarketingData r8 = r9.marketingData;
    L31:
        if ((r18 & 128) == 0) goto L33;
        boolean r1 = r9.isCoverInPool;
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

    public final String component1() {
        return this.cover;
    }

    public final String component2() {
        return this.title;
    }

    public final CommonModel$Price component3() {
        return this.price;
    }

    public final int component4() {
        return this.sales;
    }

    public final String component5() {
        return this.accessibilityLabel;
    }

    public final String component6() {
        return this.recReason;
    }

    public final CommonData.MarketingData component7() {
        return this.marketingData;
    }

    public final boolean component8() {
        return this.isCoverInPool;
    }

    public final CommonModel$Product copy(String r11, String r12, CommonModel$Price r13, int r14, String r15, String r16, CommonData.MarketingData r17, boolean r18) {
        Intrinsics.checkNotNullParameter(r11, "cover");
        Intrinsics.checkNotNullParameter(r12, "title");
        Intrinsics.checkNotNullParameter(r13, "price");
        Intrinsics.checkNotNullParameter(r15, "accessibilityLabel");
        Intrinsics.checkNotNullParameter(r16, "recReason");
        return new CommonModel$Product(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof CommonModel$Product) == false) goto L22;
        CommonModel$Product r4 = (CommonModel$Product) r3;
        if (Intrinsics.areEqual(this.cover, r4.cover) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.title, r4.title) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.price, r4.price) == true) goto L12;
        return false;
    L12:
        if (this.sales == r4.sales) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.accessibilityLabel, r4.accessibilityLabel) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.recReason, r4.recReason) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.marketingData, r4.marketingData) == true) goto L20;
        return false;
    L20:
        if (this.isCoverInPool == r4.isCoverInPool) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        String r0 = this.cover;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.title;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        CommonModel$Price r7 = this.price;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (((r6 + r8) * 31) + this.sales) * 31;
        String r10 = this.accessibilityLabel;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.recReason;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        CommonData.MarketingData r16 = this.marketingData;
        if (r16 == null) goto L25;
        r1 = r16.hashCode();
    L25:
        int r17 = (r15 + r1) * 31;
        boolean r18 = this.isCoverInPool;
        ?? r19 = r18;
        if (r18 == false) goto L29;
        r19 = 1;
    L29:
        return r17 + r19;
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
        return "Product(cover=" + this.cover + ", title=" + this.title + ", price=" + this.price + ", sales=" + this.sales + ", accessibilityLabel=" + this.accessibilityLabel + ", recReason=" + this.recReason + ", marketingData=" + this.marketingData + ", isCoverInPool=" + this.isCoverInPool + ")";
    }

    public final String getRewardText() {
        StringBuilder r0 = new StringBuilder();
        CommonData.MarketingData r1 = this.marketingData;
        String r2 = null;
        if (r1 == null) goto L5;
        String r3 = r1.getReturnRewardPrefix();
    L6:
        r0.append(r3);
        CommonData.MarketingData r4 = this.marketingData;
        if (r4 == null) goto L9;
        String r5 = r4.getReturnReward();
    L10:
        r0.append(r5);
        CommonData.MarketingData r6 = this.marketingData;
        if (r6 == null) goto L13;
        r2 = r6.getReturnRewardUnit();
    L13:
        r0.append(r2);
        return r0.toString();
    L9:
        r5 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    public final boolean isReturnRewardContainerVisible() {
        CommonData.MarketingData r0 = this.marketingData;
        if (r0 == null) goto L5;
        String r1 = r0.getReturnRewardPrefix();
    L6:
        if (r1 != null) goto L8;
    L12:
        return false;
    L8:
        if (this.marketingData.getReturnReward() == null) goto L12;
        if (this.marketingData.getReturnRewardUnit() == null) goto L12;
        return true;
    L5:
        r1 = null;
        goto L6
    }

    public final String getAccessibilityLabel() {
        return this.accessibilityLabel;
    }

    public final String getCover() {
        return this.cover;
    }

    public final CommonData.MarketingData getMarketingData() {
        return this.marketingData;
    }

    public final CommonModel$Price getPrice() {
        return this.price;
    }

    public final String getRecReason() {
        return this.recReason;
    }

    public final int getSales() {
        return this.sales;
    }

    public final String getTitle() {
        return this.title;
    }

    public final boolean isCoverInPool() {
        return this.isCoverInPool;
    }

    public CommonModel$Product(String r2, String r3, CommonModel$Price r4, int r5, String r6, String r7, CommonData.MarketingData r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r2, "cover");
        Intrinsics.checkNotNullParameter(r3, "title");
        Intrinsics.checkNotNullParameter(r4, "price");
        Intrinsics.checkNotNullParameter(r6, "accessibilityLabel");
        Intrinsics.checkNotNullParameter(r7, "recReason");
        this.cover = r2;
        this.title = r3;
        this.price = r4;
        this.sales = r5;
        this.accessibilityLabel = r6;
        this.recReason = r7;
        this.marketingData = r8;
        this.isCoverInPool = r9;
    }

    public /* synthetic */ CommonModel$Product(String r12, String r13, CommonModel$Price r14, int r15, String r16, String r17, CommonData.MarketingData r18, boolean r19, int r20, DefaultConstructorMarker r21) {
        if ((r20 & 32) == 0) goto L5;
        String r8 = "";
    L7:
        if ((r20 & 64) == 0) goto L9;
        CommonData.MarketingData r9 = null;
    L11:
        if ((r20 & 128) == 0) goto L13;
        boolean r10 = false;
    L14:
        this(r12, r13, r14, r15, r16, r8, r9, r10);
        return;
    L13:
        r10 = r19;
        goto L14
    L9:
        r9 = r18;
        goto L11
    L5:
        r8 = r17;
        goto L7
    }
}
