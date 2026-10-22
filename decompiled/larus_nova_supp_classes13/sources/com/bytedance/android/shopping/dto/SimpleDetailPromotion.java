package com.bytedance.android.shopping.dto;

import android.app.Application;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.g1;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.anchorv3.PromotionDiscountLabel;
import com.bytedance.android.shopping.utils.h;
import com.google.gson.annotations.SerializedName;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import uf4.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010/\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004R&\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u00020\u00178\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001a\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001e\u0010 \u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR&\u0010#\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0007\"\u0004\b&\u0010\tR\u0018\u0010'\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0013R \u0010)\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.¨\u00060"}, d2 = {"Lcom/bytedance/android/shopping/dto/SimpleDetailPromotion;", "Lcom/bytedance/android/shopping/dto/BaseDetailPromotion;", "()V", "discountLabel", "", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionDiscountLabel;", "getDiscountLabel", "()Ljava/util/List;", "setDiscountLabel", "(Ljava/util/List;)V", "jumpToUrl", "", "getJumpToUrl", "()Z", "setJumpToUrl", "(Z)V", "lastAwemeId", "", "getLastAwemeId", "()Ljava/lang/String;", "setLastAwemeId", "(Ljava/lang/String;)V", "productKind", "", "getProductKind", "()I", "reputationPercentage", "", "getReputationPercentage", "()D", "setReputationPercentage", "(D)V", "reputationScore", "getReputationScore", "setReputationScore", "shopIcons", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getShopIcons", "setShopIcons", "storeUrl", "getStoreUrl", "thirdCoupon", "Lcom/bytedance/android/shopping/dto/ThirdCoupon;", "getThirdCoupon", "()Lcom/bytedance/android/shopping/dto/ThirdCoupon;", "setThirdCoupon", "(Lcom/bytedance/android/shopping/dto/ThirdCoupon;)V", "createDiscountLabel", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SimpleDetailPromotion extends BaseDetailPromotion {

    @SerializedName("discount_labels")
    private List<PromotionDiscountLabel> discountLabel;

    @SerializedName("jump_to_url")
    private boolean jumpToUrl;

    @SerializedName("last_aweme_id")
    private String lastAwemeId;

    @SerializedName("biz_kind")
    private final int productKind;

    @SerializedName("reputation_percentage")
    private double reputationPercentage;

    @SerializedName("reputation_score")
    private double reputationScore;

    @SerializedName("shop_icons")
    private List<? extends ECUrlModel> shopIcons;

    @SerializedName("store_url")
    private final String storeUrl;

    @SerializedName("third_platform")
    private ThirdCoupon thirdCoupon;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r26v0, types: [com.bytedance.android.shopping.dto.BaseDetailPromotion, com.bytedance.android.shopping.dto.SimpleDetailPromotion, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v10, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r4v11, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r4v12, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r4v8, types: [java.util.ArrayList] */
    public final List<PromotionDiscountLabel> createDiscountLabel() {
        if (isThirdParty() == false) goto L78;
        int r0 = h.a;
        Intrinsics.checkNotNullParameter(this, "good");
        ArrayList r2 = new ArrayList();
        String r3 = "";
        if (isTaobaoGood() == false) goto L25;
        TaoBao r1 = getTaobao();
        if (r1 == null) goto L10;
        TaobaoCouponInfo r4 = r1.getCoupon();
    L11:
        TaobaoCouponInfo r5 = r4;
        if (r5 == null) goto L68;
        if (r5.isValid() != true) goto L68;
        String r6 = new BigDecimal(r5.getCouponAmount()).stripTrailingZeros().toPlainString();     // Catch: Exception -> L17
    L19:
        PromotionDiscountLabel r15 = new PromotionDiscountLabel(null, null, 0, null, 0, 0, null, 0, null, null, null, null, null, 8191, null);
        int r7 = g1.a;
        Application r8 = a.a();
        Object[] r9 = new Object[1];
        if (r6 == null) goto L23;
        r3 = r6;
    L23:
        r9[0] = r3;
        r15.setTag(g1.a.c(r8, 2131896020, r9));
        Unit r10 = Unit.INSTANCE;
        r2.add(r15);
    L17:
        e = move-exception;
        ECExceptionMonitor.e(e);
        r6 = r5.getCouponAmount();
    L68:
        return r2;
    L10:
        r4 = null;
        goto L11
    L25:
        if (getThirdCoupon() == null) goto L40;
        ThirdCoupon r11 = getThirdCoupon();
        if (r11 == null) goto L37;
        List<Coupon> r12 = r11.getCoupons();
        if (r12 == null) goto L37;
        List<Coupon> r13 = r12;
        List r14 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));
        Iterator r16 = r13.iterator();
    L32:
        if (r16.hasNext() == false) goto L38;
        Coupon r17 = (Coupon) r16.next();
        PromotionDiscountLabel r18 = new PromotionDiscountLabel(null, null, 0, null, 0, 0, null, 0, null, null, null, null, null, 8191, null);
        String r19 = r17.getCouponText();
        if (r19 != null) goto L36;
        r19 = "";
    L36:
        r18.setTag(r19);
        r14.add(r18);
    L38:
        r2.addAll(r14);
    L37:
        r14 = CollectionsKt.emptyList();
        goto L38
    L40:
        if ((this instanceof DetailPromotion) == false) goto L56;
        DetailPromotion r20 = (DetailPromotion) this;
        if (r20.getThirdCoupon() == null) goto L56;
        ThirdCoupon r21 = r20.getThirdCoupon();
        if (r21 == null) goto L54;
        List<Coupon> r22 = r21.getCoupons();
        if (r22 == null) goto L54;
        List<Coupon> r23 = r22;
        List r24 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r23, 10));
        Iterator r25 = r23.iterator();
    L49:
        if (r25.hasNext() == false) goto L55;
        Coupon r26 = (Coupon) r25.next();
        PromotionDiscountLabel r110 = new PromotionDiscountLabel(null, null, 0, null, 0, 0, null, 0, null, null, null, null, null, 8191, null);
        String r27 = r26.getCouponText();
        if (r27 != null) goto L53;
        r27 = "";
    L53:
        r110.setTag(r27);
        r24.add(r110);
    L55:
        r2.addAll(r24);
    L54:
        r24 = CollectionsKt.emptyList();
    L56:
        PromotionToutiao r28 = getToutiao();
        if (r28 == null) goto L68;
        List<String> r29 = r28.getCouponRule();
        if (r29 == null) goto L68;
        if ((!r29.isEmpty()) == false) goto L68;
        List<String> r30 = r29;
        ArrayList r31 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r30, 10));
        Iterator r32 = r30.iterator();
    L64:
        if (r32.hasNext() == false) goto L66;
        String r33 = (String) r32.next();
        PromotionDiscountLabel r111 = new PromotionDiscountLabel(null, null, 0, null, 0, 0, null, 0, null, null, null, null, null, 8191, null);
        r111.setTag(r33);
        r31.add(r111);
        goto L64
    L66:
        r2.addAll(r31);
        goto L68
    L78:
        return this.discountLabel;
    }

    public SimpleDetailPromotion() {
    }

    public final List<PromotionDiscountLabel> getDiscountLabel() {
        return this.discountLabel;
    }

    public final boolean getJumpToUrl() {
        return this.jumpToUrl;
    }

    public final String getLastAwemeId() {
        return this.lastAwemeId;
    }

    public final int getProductKind() {
        return this.productKind;
    }

    public final double getReputationPercentage() {
        return this.reputationPercentage;
    }

    public final double getReputationScore() {
        return this.reputationScore;
    }

    public final List<ECUrlModel> getShopIcons() {
        return this.shopIcons;
    }

    public final String getStoreUrl() {
        return this.storeUrl;
    }

    public final ThirdCoupon getThirdCoupon() {
        return this.thirdCoupon;
    }

    public final void setDiscountLabel(List<PromotionDiscountLabel> r1) {
        this.discountLabel = r1;
    }

    public final void setJumpToUrl(boolean r1) {
        this.jumpToUrl = r1;
    }

    public final void setLastAwemeId(String r1) {
        this.lastAwemeId = r1;
    }

    public final void setReputationPercentage(double r1) {
        this.reputationPercentage = r1;
    }

    public final void setReputationScore(double r1) {
        this.reputationScore = r1;
    }

    public final void setShopIcons(List<? extends ECUrlModel> r1) {
        this.shopIcons = r1;
    }

    public final void setThirdCoupon(ThirdCoupon r1) {
        this.thirdCoupon = r1;
    }
}
