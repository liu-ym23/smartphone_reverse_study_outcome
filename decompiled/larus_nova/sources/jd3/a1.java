package jd3;

import com.bytedance.common.wschannel.WsConstants;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Ljd3/a1;", "", "", "userId", "Ljava/lang/String;", "getUserId", "()Ljava/lang/String;", "appId", "getAppId", "hostAppId", "getHostAppId", "promotionId", "getPromotionId", "productId", "getProductId", "bizIdentity", "getBizIdentity", RemoteMessageConst.Notification.CHANNEL_ID, "getChannelId", "", "channelType", "Ljava/lang/Integer;", "getChannelType", "()Ljava/lang/Integer;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a1 {

    @SerializedName("app_id")
    private final String appId;

    @SerializedName("biz_identity")
    private final String bizIdentity;

    @SerializedName("channel_id")
    private final String channelId;

    @SerializedName(WsConstants.KEY_CHANNEL_TYPE)
    private final Integer channelType;

    @SerializedName("host_app_id")
    private final String hostAppId;

    @SerializedName("product_id")
    private final String productId;

    @SerializedName("promotion_id")
    private final String promotionId;

    @SerializedName("user_id")
    private final String userId;

    public a1() {
        this(null, null, null, null, null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a1) == false) goto L22;
        a1 r101 = (a1) r100;
        if (Intrinsics.areEqual(this.userId, r101.userId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.appId, r101.appId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.hostAppId, r101.hostAppId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.promotionId, r101.promotionId) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.productId, r101.productId) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.bizIdentity, r101.bizIdentity) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.channelId, r101.channelId) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.channelType, r101.channelType) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public final int hashCode() {
        String r100 = this.userId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.appId;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.hostAppId;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.promotionId;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.productId;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.bizIdentity;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.channelId;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        Integer r122 = this.channelType;
        if (r122 == null) goto L34;
        r101 = r122.hashCode();
    L34:
        return r121 + r101;
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ViewBaseInfo(userId=" + this.userId + ", appId=" + this.appId + ", hostAppId=" + this.hostAppId + ", promotionId=" + this.promotionId + ", productId=" + this.productId + ", bizIdentity=" + this.bizIdentity + ", channelId=" + this.channelId + ", channelType=" + this.channelType + ")";
    }

    public a1(String r100, String r101, String r102, String r103, String r104, String r105, String r106, Integer r107) {
        this.userId = r100;
        this.appId = r101;
        this.hostAppId = r102;
        this.promotionId = r103;
        this.productId = r104;
        this.bizIdentity = r105;
        this.channelId = r106;
        this.channelType = r107;
    }
}
