package com.bytedance.android.livesdk.livecommerce.room.model;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.StandardEventTrack;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR(\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\r\u001a\u0004\b\u001d\u0010\u000fR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u0004\u001a\u0004\b\u001f\u0010\u0006R\u001c\u0010 \u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b \u0010\u0004\u001a\u0004\b!\u0010\u0006R\u001c\u0010\"\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010\u0004\u001a\u0004\b#\u0010\u0006R\u001c\u0010%\u001a\u0004\u0018\u00010$8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u001c\u0010)\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b)\u0010\u0004\u001a\u0004\b*\u0010\u0006R\u001c\u0010+\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b+\u0010\u0004\u001a\u0004\b,\u0010\u0006R\u001a\u0010.\u001a\u00020-8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R$\u00102\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b2\u0010\u0004\u001a\u0004\b3\u0010\u0006\"\u0004\b4\u00105R$\u00106\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b6\u0010\u0004\u001a\u0004\b7\u0010\u0006\"\u0004\b8\u00105¨\u00069"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/room/model/c;", "", "", "eventItemType", "Ljava/lang/String;", "getEventItemType", "()Ljava/lang/String;", "productId", "getProductId", "promotionId", "getPromotionId", "", "status", "Ljava/lang/Integer;", "getStatus", "()Ljava/lang/Integer;", "", "eventParams", "Ljava/util/Map;", "getEventParams", "()Ljava/util/Map;", "Lcom/bytedance/android/ec/model/response/StandardEventTrack;", "standardEventTrack", "Lcom/bytedance/android/ec/model/response/StandardEventTrack;", "getStandardEventTrack", "()Lcom/bytedance/android/ec/model/response/StandardEventTrack;", "channelId", "getChannelId", "channelType", "getChannelType", "scheme", "getScheme", "shopId", "getShopId", "leafCategory", "getLeafCategory", "Lcom/bytedance/android/ec/model/ECUrlModel;", "detailCover", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getDetailCover", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "cover", "getCover", "title", "getTitle", "", "singleSku", "Z", "getSingleSku", "()Z", "bizIdentity", "getBizIdentity", "setBizIdentity", "(Ljava/lang/String;)V", "checkCallback", "getCheckCallback", "setCheckCallback", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName("biz_identity")
    private String bizIdentity;

    @SerializedName("channel_id")
    private final String channelId;

    @SerializedName("channel_type")
    private final Integer channelType;

    @SerializedName("check_callback")
    private String checkCallback;

    @SerializedName("cover")
    private final String cover;

    @SerializedName("detail_cover")
    private final ECUrlModel detailCover;

    @SerializedName("event_item_type")
    private final String eventItemType;

    @SerializedName("event_params")
    private final Map<String, String> eventParams;

    @SerializedName("leaf_category")
    private final String leafCategory;

    @SerializedName("product_id")
    private final String productId;

    @SerializedName("promotion_id")
    private final String promotionId;

    @SerializedName("scheme")
    private final String scheme;

    @SerializedName("shop_id")
    private final String shopId;

    @SerializedName("single_sku")
    private final boolean singleSku;

    @SerializedName("standard_event_track")
    private final StandardEventTrack standardEventTrack;

    @SerializedName("status")
    private final Integer status;

    @SerializedName("title")
    private final String title;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof c) == false) goto L40;
        c r4 = (c) r3;
        if (Intrinsics.areEqual(this.eventItemType, r4.eventItemType) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.productId, r4.productId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.promotionId, r4.promotionId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.status, r4.status) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.eventParams, r4.eventParams) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.standardEventTrack, r4.standardEventTrack) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.channelId, r4.channelId) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.channelType, r4.channelType) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.scheme, r4.scheme) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.shopId, r4.shopId) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.leafCategory, r4.leafCategory) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.detailCover, r4.detailCover) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.cover, r4.cover) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.title, r4.title) == true) goto L34;
        return false;
    L34:
        if (this.singleSku == r4.singleSku) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.bizIdentity, r4.bizIdentity) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.checkCallback, r4.checkCallback) == true) goto L61;
        return false;
    L61:
        return true;
    L40:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v30, types: [int] */
    /* JADX WARN: Type inference failed for: r2v40, types: [int] */
    /* JADX WARN: Type inference failed for: r2v46 */
    /* JADX WARN: Type inference failed for: r2v60 */
    public final int hashCode() {
        String r0 = this.eventItemType;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.productId;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.promotionId;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.status;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        Map<String, String> r13 = this.eventParams;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        StandardEventTrack r16 = this.standardEventTrack;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.channelId;
        if (r19 == null) goto L29;
        int r20 = r19.hashCode();
    L30:
        int r21 = (r18 + r20) * 31;
        Integer r22 = this.channelType;
        if (r22 == null) goto L33;
        int r23 = r22.hashCode();
    L34:
        int r24 = (r21 + r23) * 31;
        String r25 = this.scheme;
        if (r25 == null) goto L37;
        int r26 = r25.hashCode();
    L38:
        int r27 = (r24 + r26) * 31;
        String r28 = this.shopId;
        if (r28 == null) goto L41;
        int r29 = r28.hashCode();
    L42:
        int r30 = (r27 + r29) * 31;
        String r31 = this.leafCategory;
        if (r31 == null) goto L45;
        int r32 = r31.hashCode();
    L46:
        int r33 = (r30 + r32) * 31;
        ECUrlModel r34 = this.detailCover;
        if (r34 == null) goto L49;
        int r35 = r34.hashCode();
    L50:
        int r36 = (r33 + r35) * 31;
        String r37 = this.cover;
        if (r37 == null) goto L53;
        int r38 = r37.hashCode();
    L54:
        int r39 = (r36 + r38) * 31;
        String r40 = this.title;
        if (r40 == null) goto L57;
        int r41 = r40.hashCode();
    L58:
        int r42 = (r39 + r41) * 31;
        boolean r43 = this.singleSku;
        ?? r44 = r43;
        if (r43 == false) goto L61;
        r44 = 1;
    L61:
        int r45 = (r42 + r44) * 31;
        String r46 = this.bizIdentity;
        if (r46 == null) goto L64;
        int r47 = r46.hashCode();
    L65:
        int r48 = (r45 + r47) * 31;
        String r49 = this.checkCallback;
        if (r49 == null) goto L69;
        r1 = r49.hashCode();
    L69:
        return r48 + r1;
    L64:
        r47 = 0;
        goto L65
    L57:
        r41 = 0;
        goto L58
    L53:
        r38 = 0;
        goto L54
    L49:
        r35 = 0;
        goto L50
    L45:
        r32 = 0;
        goto L46
    L41:
        r29 = 0;
        goto L42
    L37:
        r26 = 0;
        goto L38
    L33:
        r23 = 0;
        goto L34
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
        return "ECLiveHybridPromotion(eventItemType=" + this.eventItemType + ", productId=" + this.productId + ", promotionId=" + this.promotionId + ", status=" + this.status + ", eventParams=" + this.eventParams + ", standardEventTrack=" + this.standardEventTrack + ", channelId=" + this.channelId + ", channelType=" + this.channelType + ", scheme=" + this.scheme + ", shopId=" + this.shopId + ", leafCategory=" + this.leafCategory + ", detailCover=" + this.detailCover + ", cover=" + this.cover + ", title=" + this.title + ", singleSku=" + this.singleSku + ", bizIdentity=" + this.bizIdentity + ", checkCallback=" + this.checkCallback + ")";
    }

    public c() {
        this.eventItemType = null;
        this.productId = null;
        this.promotionId = null;
        this.status = null;
        this.eventParams = null;
        this.standardEventTrack = null;
        this.channelId = null;
        this.channelType = null;
        this.scheme = null;
        this.shopId = null;
        this.leafCategory = null;
        this.detailCover = null;
        this.cover = null;
        this.title = null;
        this.singleSku = false;
        this.bizIdentity = null;
        this.checkCallback = null;
    }

    public final ql.a a(ql.a r3) {
        if (r3 != null) goto L4;
        r3 = new a(this.cover, this.title);
    L4:
        r3.setEventItemType(this.eventItemType);
        String r0 = this.productId;
        String r1 = "";
        if (r0 != null) goto L7;
        r0 = "";
    L7:
        r3.setProductId(r0);
        String r2 = this.promotionId;
        if (r2 != null) goto L10;
        r2 = "";
    L10:
        r3.setPromotionId(r2);
        Integer r4 = this.status;
        if (r4 == null) goto L13;
        int r5 = r4.intValue();
    L14:
        r3.setStatus(r5);
        r3.setEventParams(this.eventParams);
        r3.setStandardEventTrack(this.standardEventTrack);
        r3.setChannelId(this.channelId);
        r3.setChannelType(this.channelType);
        r3.setScheme(this.scheme);
        String r6 = this.shopId;
        if (r6 == null) goto L18;
        r1 = r6;
    L18:
        r3.setShopId(r1);
        r3.setLeafCategory(this.leafCategory);
        r3.setDetailCover(this.detailCover);
        r3.setSingleSku(this.singleSku);
        r3.setBizIdentity(this.bizIdentity);
        r3.setCheckCallback(this.checkCallback);
        return r3;
    L13:
        r5 = 0;
        goto L14
    }
}
