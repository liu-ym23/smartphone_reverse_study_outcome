package com.bytedance.android.livesdk.livecommerce.intro.model.resp;

import com.google.gson.annotations.SerializedName;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001fR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001a\u0010\u0012\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0013\u0010\rR\u001a\u0010\u0014\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0015\u0010\rR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006R\u001a\u0010\u0019\u001a\u00020\u00188\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u00188\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001a\u001a\u0004\b\u001e\u0010\u001c¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/IntroProduct;", "", "", "productId", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "promotionId", "i", "", "channelId", "J", "b", "()J", "channelType", "c", "detailUrl", "d", "shopId", "j", "itemType", "f", "bizIdentity", "a", "", "productType", "I", "h", "()I", "industryType", "e", "Companion", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IntroProduct {

    @SerializedName("biz_identity")
    private final String bizIdentity;

    @SerializedName("channel_id")
    private final long channelId;

    @SerializedName("channel_type")
    private final long channelType;

    @SerializedName("detail_url")
    private final String detailUrl;

    @SerializedName("industry_type")
    private final int industryType;

    @SerializedName("item_type")
    private final long itemType;

    @SerializedName("product_id")
    private final String productId;

    @SerializedName("product_type")
    private final int productType;

    @SerializedName("promotion_id")
    private final String promotionId;

    @SerializedName("shop_id")
    private final long shopId;

    public static final class Companion {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/IntroProduct$Companion$IntroIndustryType;", "", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
        @Retention(RetentionPolicy.SOURCE)
        @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
        public @interface IntroIndustryType {
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/IntroProduct$Companion$IntroProductType;", "", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
        @Retention(RetentionPolicy.SOURCE)
        @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
        public @interface IntroProductType {
        }
    }

    static {
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof IntroProduct) == false) goto L26;
        IntroProduct r7 = (IntroProduct) r6;
        if (Intrinsics.areEqual(this.productId, r7.productId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.promotionId, r7.promotionId) == true) goto L10;
        return false;
    L10:
        if (this.channelId == r7.channelId) goto L12;
        return false;
    L12:
        if (this.channelType == r7.channelType) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.detailUrl, r7.detailUrl) == true) goto L16;
        return false;
    L16:
        if (this.shopId == r7.shopId) goto L18;
        return false;
    L18:
        if (this.itemType == r7.itemType) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.bizIdentity, r7.bizIdentity) == true) goto L22;
        return false;
    L22:
        if (this.productType == r7.productType) goto L24;
        return false;
    L24:
        if (this.industryType == r7.industryType) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    public final int hashCode() {
        String r0 = this.productId;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.promotionId;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        long r7 = this.channelId;
        int r8 = (r6 + ((int) (r7 ^ (r7 >>> 32)))) * 31;
        long r9 = this.channelType;
        int r10 = (r8 + ((int) (r9 ^ (r9 >>> 32)))) * 31;
        String r11 = this.detailUrl;
        if (r11 == null) goto L13;
        int r12 = r11.hashCode();
    L14:
        int r13 = (r10 + r12) * 31;
        long r14 = this.shopId;
        int r15 = (r13 + ((int) (r14 ^ (r14 >>> 32)))) * 31;
        long r16 = this.itemType;
        int r17 = (r15 + ((int) (r16 ^ (r16 >>> 32)))) * 31;
        String r18 = this.bizIdentity;
        if (r18 == null) goto L18;
        r1 = r18.hashCode();
    L18:
        return ((((r17 + r1) * 31) + this.productType) * 31) + this.industryType;
    L13:
        r12 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "IntroProduct(productId=" + this.productId + ", promotionId=" + this.promotionId + ", channelId=" + this.channelId + ", channelType=" + this.channelType + ", detailUrl=" + this.detailUrl + ", shopId=" + this.shopId + ", itemType=" + this.itemType + ", bizIdentity=" + this.bizIdentity + ", productType=" + this.productType + ", industryType=" + this.industryType + ")";
    }

    public IntroProduct() {
        this.productId = null;
        this.promotionId = null;
        this.channelId = 0;
        this.channelType = 0;
        this.detailUrl = null;
        this.shopId = 0;
        this.itemType = 0;
        this.bizIdentity = null;
        this.productType = 0;
        this.industryType = 0;
    }

    public final String a() {
        return this.bizIdentity;
    }

    public final long b() {
        return this.channelId;
    }

    public final long c() {
        return this.channelType;
    }

    public final String d() {
        return this.detailUrl;
    }

    public final int e() {
        return this.industryType;
    }

    public final long f() {
        return this.itemType;
    }

    public final String g() {
        return this.productId;
    }

    public final int h() {
        return this.productType;
    }

    public final String i() {
        return this.promotionId;
    }

    public final long j() {
        return this.shopId;
    }
}
