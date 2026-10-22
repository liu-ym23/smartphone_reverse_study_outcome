package jd3;

import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Ljd3/a1;", "", "", "userId", "Ljava/lang/String;", "getUserId", "()Ljava/lang/String;", "appId", "getAppId", "hostAppId", "getHostAppId", "promotionId", "getPromotionId", "productId", "getProductId", "bizIdentity", "getBizIdentity", "channelId", "getChannelId", "", "channelType", "Ljava/lang/Integer;", "getChannelType", "()Ljava/lang/Integer;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a1 {

    @SerializedName("app_id")
    private final String appId;

    @SerializedName("biz_identity")
    private final String bizIdentity;

    @SerializedName("channel_id")
    private final String channelId;

    @SerializedName("channel_type")
    private final Integer channelType;

    @SerializedName("host_app_id")
    private final String hostAppId;

    @SerializedName(PdpOpenThirdParam.KEY_PRODUCT_ID)
    private final String productId;

    @SerializedName(PdpOpenThirdParam.KEY_PROMOTION_ID)
    private final String promotionId;

    @SerializedName("user_id")
    private final String userId;

    public a1() {
        this(null, null, null, null, null, null, null, null);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof a1) == false) goto L22;
        a1 r4 = (a1) r3;
        if (Intrinsics.areEqual(this.userId, r4.userId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.appId, r4.appId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.hostAppId, r4.hostAppId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.promotionId, r4.promotionId) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.productId, r4.productId) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.bizIdentity, r4.bizIdentity) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.channelId, r4.channelId) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.channelType, r4.channelType) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public final int hashCode() {
        String r0 = this.userId;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.appId;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.hostAppId;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.promotionId;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.productId;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.bizIdentity;
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
        return "ViewBaseInfo(userId=" + this.userId + ", appId=" + this.appId + ", hostAppId=" + this.hostAppId + ", promotionId=" + this.promotionId + ", productId=" + this.productId + ", bizIdentity=" + this.bizIdentity + ", channelId=" + this.channelId + ", channelType=" + this.channelType + ")";
    }

    public a1(String r1, String r2, String r3, String r4, String r5, String r6, String r7, Integer r8) {
        this.userId = r1;
        this.appId = r2;
        this.hostAppId = r3;
        this.promotionId = r4;
        this.productId = r5;
        this.bizIdentity = r6;
        this.channelId = r7;
        this.channelType = r8;
    }
}
