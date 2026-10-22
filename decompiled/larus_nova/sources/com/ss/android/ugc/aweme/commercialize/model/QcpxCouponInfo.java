package com.ss.android.ugc.aweme.commercialize.model;

import com.android.ttcjpaysdk.kmp.common.pay_ability.cancel_retain.api.CancelRetainContactInfoFunctions;
import com.google.gson.annotations.SerializedName;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b;\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0085\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u001a\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f¢\u0006\u0002\u0010!J\t\u0010@\u001a\u00020\u0003HÆ\u0003J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\t\u0010B\u001a\u00020\u0005HÆ\u0003J\t\u0010C\u001a\u00020\u0005HÆ\u0003J\t\u0010D\u001a\u00020\u0007HÆ\u0003J\t\u0010E\u001a\u00020\u0007HÆ\u0003J\t\u0010F\u001a\u00020\u0007HÆ\u0003J\t\u0010G\u001a\u00020\u0007HÆ\u0003J\t\u0010H\u001a\u00020\u0003HÆ\u0003J\t\u0010I\u001a\u00020\u0007HÆ\u0003J\t\u0010J\u001a\u00020\u0003HÆ\u0003J\t\u0010K\u001a\u00020\u0005HÆ\u0003J\t\u0010L\u001a\u00020\u0003HÆ\u0003J\t\u0010M\u001a\u00020\u001aHÆ\u0003J\t\u0010N\u001a\u00020\u0007HÆ\u0003J\t\u0010O\u001a\u00020\u0003HÆ\u0003J\t\u0010P\u001a\u00020\u0007HÆ\u0003J\u000f\u0010Q\u001a\b\u0012\u0004\u0012\u00020 0\u001fHÆ\u0003J\t\u0010R\u001a\u00020\u0007HÆ\u0003J\t\u0010S\u001a\u00020\u0003HÆ\u0003J\t\u0010T\u001a\u00020\u0003HÆ\u0003J\t\u0010U\u001a\u00020\u0003HÆ\u0003J\t\u0010V\u001a\u00020\u0003HÆ\u0003J\t\u0010W\u001a\u00020\u0007HÆ\u0003J\t\u0010X\u001a\u00020\u0003HÆ\u0003J\u0089\u0002\u0010Y\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00072\b\b\u0002\u0010\u0012\u001a\u00020\u00072\b\b\u0002\u0010\u0013\u001a\u00020\u00072\b\b\u0002\u0010\u0014\u001a\u00020\u00072\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00072\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00072\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00072\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fHÆ\u0001J\u0013\u0010Z\u001a\u00020\u001a2\b\u0010[\u001a\u0004\u0018\u00010\\HÖ\u0003J\t\u0010]\u001a\u00020\u0007HÖ\u0001J\t\u0010^\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0010\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0016\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010%R\u0016\u0010\u000f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010#R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010)R\u0016\u0010\u0018\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010)R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010)R\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010)R\u0016\u0010\u001b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010%R\u0016\u0010\u001c\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010)R\u0016\u0010\u0017\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010)R\u0016\u0010\u0019\u001a\u00020\u001a8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0016\u0010\u0014\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010%R\u0016\u0010\u0015\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010)R\u0016\u0010\u0016\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010%R\u0016\u0010\u0013\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010%R\u0016\u0010\u0012\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u0010%R\u0016\u0010\u001d\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010%R\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010)R\u0016\u0010\u0011\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010%R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010)R\u0016\u0010\u000e\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010)R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010#¨\u0006_"}, d2 = {"Lcom/ss/android/ugc/aweme/commercialize/model/QcpxCouponInfo;", "Ljava/io/Serializable;", "scene", "", "userId", "", "applyTime", "", "couponId", "couponMetaId", "couponMetaType", "couponType", "appId", "reqId", "token", "cid", "adId", "roomId", "qponValue", "qponThreshold", "orderId", "orderStatus", "orderTime", "extra", "couponMetaName", "lifeUGCouponTag", "", Keys.API_PARAM_KEY_SDK_EXPIRETIME, "expireTimeStr", "receiveNumber", "receiveUserList", "", "Lcom/ss/android/ugc/aweme/commercialize/model/ReceiveUser;", "(Ljava/lang/String;JILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;JJIIIILjava/lang/String;ILjava/lang/String;Ljava/lang/String;ZILjava/lang/String;ILjava/util/List;)V", "getAdId", "()J", "getAppId", "()I", "getApplyTime", "getCid", "getCouponId", "()Ljava/lang/String;", "getCouponMetaId", "getCouponMetaName", "getCouponMetaType", "getCouponType", "getExpireTime", "getExpireTimeStr", "getExtra", "getLifeUGCouponTag", "()Z", "getOrderId", "getOrderStatus", "getOrderTime", "getQponThreshold", "getQponValue", "getReceiveNumber", "getReceiveUserList", "()Ljava/util/List;", "getReqId", "getRoomId", "getScene", "getToken", "getUserId", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "toString", "trade-search-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class QcpxCouponInfo implements Serializable {

    @SerializedName("AdID")
    private final long adId;

    @SerializedName("AppID")
    private final int appId;

    @SerializedName("ApplyTime")
    private final int applyTime;

    @SerializedName("Cid")
    private final long cid;

    @SerializedName("CouponID")
    private final String couponId;

    @SerializedName("CouponMetaID")
    private final String couponMetaId;

    @SerializedName("CouponMetaName")
    private final String couponMetaName;

    @SerializedName("CouponMetaType")
    private final String couponMetaType;

    @SerializedName("CouponType")
    private final String couponType;

    @SerializedName("ExpireTime")
    private final int expireTime;

    @SerializedName("ExpireTimeStr")
    private final String expireTimeStr;

    @SerializedName("Extra")
    private final String extra;

    @SerializedName("LifeUGCouponTag")
    private final boolean lifeUGCouponTag;

    @SerializedName("OrderID")
    private final int orderId;

    @SerializedName("OrderStatus")
    private final String orderStatus;

    @SerializedName("OrderTime")
    private final int orderTime;

    @SerializedName("QponThreshold")
    private final int qponThreshold;

    @SerializedName("QponValue")
    private final int qponValue;

    @SerializedName("ReceiveNumber")
    private final int receiveNumber;

    @SerializedName("ReceiveUserList")
    private final List<ReceiveUser> receiveUserList;

    @SerializedName("ReqID")
    private final String reqId;

    @SerializedName("RoomID")
    private final int roomId;

    @SerializedName("Scene")
    private final String scene;

    @SerializedName(CancelRetainContactInfoFunctions.Token)
    private final String token;

    @SerializedName("UserId")
    private final long userId;

    public QcpxCouponInfo() {
        this(null, 0, 0, null, null, null, null, 0, null, null, 0, 0, 0, 0, 0, 0, null, 0, null, null, false, 0, null, 0, null, 33554431, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ QcpxCouponInfo copy$default(QcpxCouponInfo r110, String r111, long r112, int r210, String r211, String r212, String r213, String r214, int r215, String r216, String r217, long r218, long r310, int r311, int r312, int r313, int r314, String r315, int r316, String r317, String r410, boolean r411, int r412, String r413, int r414, List r415, int r416, Object r417) {
        if ((r416 & 1) == 0) goto L5;
        String r100 = r110.scene;
    L7:
        if ((r416 & 2) == 0) goto L9;
        long r101 = r110.userId;
    L11:
        if ((r416 & 4) == 0) goto L13;
        int r102 = r110.applyTime;
    L15:
        if ((r416 & 8) == 0) goto L17;
        String r103 = r110.couponId;
    L19:
        if ((r416 & 16) == 0) goto L21;
        String r104 = r110.couponMetaId;
    L23:
        if ((r416 & 32) == 0) goto L25;
        String r105 = r110.couponMetaType;
    L27:
        if ((r416 & 64) == 0) goto L29;
        String r106 = r110.couponType;
    L31:
        if ((r416 & 128) == 0) goto L33;
        int r113 = r110.appId;
    L35:
        if ((r416 & 256) == 0) goto L37;
        String r114 = r110.reqId;
    L39:
        if ((r416 & 512) == 0) goto L41;
        String r115 = r110.token;
    L43:
        if ((r416 & 1024) == 0) goto L45;
        long r116 = r110.cid;
    L46:
        long r219 = r116;
        if ((r416 & 2048) == 0) goto L49;
        long r117 = r110.adId;
    L51:
        if ((r416 & 4096) == 0) goto L53;
        int r118 = r110.roomId;
    L54:
        int r318 = r118;
        if ((r416 & 8192) == 0) goto L57;
        int r119 = r110.qponValue;
    L58:
        int r319 = r119;
        if ((r416 & 16384) == 0) goto L61;
        int r120 = r110.qponThreshold;
    L62:
        int r320 = r120;
        if ((r416 & 32768) == 0) goto L65;
        int r121 = r110.orderId;
    L66:
        int r321 = r121;
        if ((r416 & 65536) == 0) goto L69;
        String r122 = r110.orderStatus;
    L70:
        String r322 = r122;
        if ((r416 & 131072) == 0) goto L73;
        int r123 = r110.orderTime;
    L74:
        int r323 = r123;
        if ((r416 & 262144) == 0) goto L77;
        String r124 = r110.extra;
    L78:
        String r324 = r124;
        if ((r416 & 524288) == 0) goto L81;
        String r125 = r110.couponMetaName;
    L82:
        String r418 = r125;
        if ((r416 & 1048576) == 0) goto L85;
        boolean r126 = r110.lifeUGCouponTag;
    L86:
        boolean r419 = r126;
        if ((r416 & 2097152) == 0) goto L89;
        int r127 = r110.expireTime;
    L90:
        int r420 = r127;
        if ((r416 & 4194304) == 0) goto L93;
        String r128 = r110.expireTimeStr;
    L94:
        String r421 = r128;
        if ((r416 & 8388608) == 0) goto L97;
        int r129 = r110.receiveNumber;
    L99:
        if ((r416 & 16777216) == 0) goto L101;
        List r107 = r110.receiveUserList;
    L103:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r113, r114, r115, r219, r117, r318, r319, r320, r321, r322, r323, r324, r418, r419, r420, r421, r129, r107);
    L101:
        r107 = r415;
        goto L103
    L97:
        r129 = r414;
        goto L99
    L93:
        r128 = r413;
        goto L94
    L89:
        r127 = r412;
        goto L90
    L85:
        r126 = r411;
        goto L86
    L81:
        r125 = r410;
        goto L82
    L77:
        r124 = r317;
        goto L78
    L73:
        r123 = r316;
        goto L74
    L69:
        r122 = r315;
        goto L70
    L65:
        r121 = r314;
        goto L66
    L61:
        r120 = r313;
        goto L62
    L57:
        r119 = r312;
        goto L58
    L53:
        r118 = r311;
        goto L54
    L49:
        r117 = r310;
        goto L51
    L45:
        r116 = r218;
        goto L46
    L41:
        r115 = r217;
        goto L43
    L37:
        r114 = r216;
        goto L39
    L33:
        r113 = r215;
        goto L35
    L29:
        r106 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final String component1() {
        return this.scene;
    }

    public final String component10() {
        return this.token;
    }

    public final long component11() {
        return this.cid;
    }

    public final long component12() {
        return this.adId;
    }

    public final int component13() {
        return this.roomId;
    }

    public final int component14() {
        return this.qponValue;
    }

    public final int component15() {
        return this.qponThreshold;
    }

    public final int component16() {
        return this.orderId;
    }

    public final String component17() {
        return this.orderStatus;
    }

    public final int component18() {
        return this.orderTime;
    }

    public final String component19() {
        return this.extra;
    }

    public final long component2() {
        return this.userId;
    }

    public final String component20() {
        return this.couponMetaName;
    }

    public final boolean component21() {
        return this.lifeUGCouponTag;
    }

    public final int component22() {
        return this.expireTime;
    }

    public final String component23() {
        return this.expireTimeStr;
    }

    public final int component24() {
        return this.receiveNumber;
    }

    public final List<ReceiveUser> component25() {
        return this.receiveUserList;
    }

    public final int component3() {
        return this.applyTime;
    }

    public final String component4() {
        return this.couponId;
    }

    public final String component5() {
        return this.couponMetaId;
    }

    public final String component6() {
        return this.couponMetaType;
    }

    public final String component7() {
        return this.couponType;
    }

    public final int component8() {
        return this.appId;
    }

    public final String component9() {
        return this.reqId;
    }

    public final QcpxCouponInfo copy(String r310, long r311, int r312, String r313, String r314, String r315, String r316, int r410, String r411, String r412, long r413, long r414, int r415, int r416, int r417, int r510, String r511, int r512, String r513, String r514, boolean r515, int r516, String r517, int r518, List<ReceiveUser> r519) {
        Intrinsics.checkNotNullParameter(r310, "scene");
        Intrinsics.checkNotNullParameter(r313, "couponId");
        Intrinsics.checkNotNullParameter(r314, "couponMetaId");
        Intrinsics.checkNotNullParameter(r315, "couponMetaType");
        Intrinsics.checkNotNullParameter(r316, "couponType");
        Intrinsics.checkNotNullParameter(r411, "reqId");
        Intrinsics.checkNotNullParameter(r412, "token");
        Intrinsics.checkNotNullParameter(r511, "orderStatus");
        Intrinsics.checkNotNullParameter(r513, "extra");
        Intrinsics.checkNotNullParameter(r514, "couponMetaName");
        Intrinsics.checkNotNullParameter(r517, "expireTimeStr");
        Intrinsics.checkNotNullParameter(r519, "receiveUserList");
        return new QcpxCouponInfo(r310, r311, r312, r313, r314, r315, r316, r410, r411, r412, r413, r414, r415, r416, r417, r510, r511, r512, r513, r514, r515, r516, r517, r518, r519);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof QcpxCouponInfo) == true) goto L8;
        return false;
    L8:
        QcpxCouponInfo r101 = (QcpxCouponInfo) r100;
        if (Intrinsics.areEqual(this.scene, r101.scene) == true) goto L12;
        return false;
    L12:
        if (this.userId == r101.userId) goto L15;
        return false;
    L15:
        if (this.applyTime == r101.applyTime) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.couponId, r101.couponId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.couponMetaId, r101.couponMetaId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.couponMetaType, r101.couponMetaType) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.couponType, r101.couponType) == true) goto L30;
        return false;
    L30:
        if (this.appId == r101.appId) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.reqId, r101.reqId) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.token, r101.token) == true) goto L39;
        return false;
    L39:
        if (this.cid == r101.cid) goto L42;
        return false;
    L42:
        if (this.adId == r101.adId) goto L45;
        return false;
    L45:
        if (this.roomId == r101.roomId) goto L48;
        return false;
    L48:
        if (this.qponValue == r101.qponValue) goto L51;
        return false;
    L51:
        if (this.qponThreshold == r101.qponThreshold) goto L54;
        return false;
    L54:
        if (this.orderId == r101.orderId) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.orderStatus, r101.orderStatus) == true) goto L60;
        return false;
    L60:
        if (this.orderTime == r101.orderTime) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.couponMetaName, r101.couponMetaName) == true) goto L69;
        return false;
    L69:
        if (this.lifeUGCouponTag == r101.lifeUGCouponTag) goto L72;
        return false;
    L72:
        if (this.expireTime == r101.expireTime) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.expireTimeStr, r101.expireTimeStr) == true) goto L78;
        return false;
    L78:
        if (this.receiveNumber == r101.receiveNumber) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.receiveUserList, r101.receiveUserList) == true) goto L83;
        return false;
    L83:
        return true;
    }

    public int hashCode() {
        int r100 = this.scene.hashCode() * 31;
        long r101 = this.userId;
        int r102 = (((((((((((((((((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.applyTime) * 31) + this.couponId.hashCode()) * 31) + this.couponMetaId.hashCode()) * 31) + this.couponMetaType.hashCode()) * 31) + this.couponType.hashCode()) * 31) + this.appId) * 31) + this.reqId.hashCode()) * 31) + this.token.hashCode()) * 31;
        long r103 = this.cid;
        int r104 = (r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        long r105 = this.adId;
        int r106 = (((((((((((((((((r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31) + this.roomId) * 31) + this.qponValue) * 31) + this.qponThreshold) * 31) + this.orderId) * 31) + this.orderStatus.hashCode()) * 31) + this.orderTime) * 31) + this.extra.hashCode()) * 31) + this.couponMetaName.hashCode()) * 31;
        if (this.lifeUGCouponTag == false) goto L5;
        int r107 = 1231;
    L7:
        return ((((((((r106 + r107) * 31) + this.expireTime) * 31) + this.expireTimeStr.hashCode()) * 31) + this.receiveNumber) * 31) + this.receiveUserList.hashCode();
    L5:
        r107 = 1237;
        goto L7
    }

    public String toString() {
        return "QcpxCouponInfo(scene=" + this.scene + ", userId=" + this.userId + ", applyTime=" + this.applyTime + ", couponId=" + this.couponId + ", couponMetaId=" + this.couponMetaId + ", couponMetaType=" + this.couponMetaType + ", couponType=" + this.couponType + ", appId=" + this.appId + ", reqId=" + this.reqId + ", token=" + this.token + ", cid=" + this.cid + ", adId=" + this.adId + ", roomId=" + this.roomId + ", qponValue=" + this.qponValue + ", qponThreshold=" + this.qponThreshold + ", orderId=" + this.orderId + ", orderStatus=" + this.orderStatus + ", orderTime=" + this.orderTime + ", extra=" + this.extra + ", couponMetaName=" + this.couponMetaName + ", lifeUGCouponTag=" + this.lifeUGCouponTag + ", expireTime=" + this.expireTime + ", expireTimeStr=" + this.expireTimeStr + ", receiveNumber=" + this.receiveNumber + ", receiveUserList=" + this.receiveUserList + ')';
    }

    public final long getAdId() {
        return this.adId;
    }

    public final int getAppId() {
        return this.appId;
    }

    public final int getApplyTime() {
        return this.applyTime;
    }

    public final long getCid() {
        return this.cid;
    }

    public final String getCouponId() {
        return this.couponId;
    }

    public final String getCouponMetaId() {
        return this.couponMetaId;
    }

    public final String getCouponMetaName() {
        return this.couponMetaName;
    }

    public final String getCouponMetaType() {
        return this.couponMetaType;
    }

    public final String getCouponType() {
        return this.couponType;
    }

    public final int getExpireTime() {
        return this.expireTime;
    }

    public final String getExpireTimeStr() {
        return this.expireTimeStr;
    }

    public final String getExtra() {
        return this.extra;
    }

    public final boolean getLifeUGCouponTag() {
        return this.lifeUGCouponTag;
    }

    public final int getOrderId() {
        return this.orderId;
    }

    public final String getOrderStatus() {
        return this.orderStatus;
    }

    public final int getOrderTime() {
        return this.orderTime;
    }

    public final int getQponThreshold() {
        return this.qponThreshold;
    }

    public final int getQponValue() {
        return this.qponValue;
    }

    public final int getReceiveNumber() {
        return this.receiveNumber;
    }

    public final List<ReceiveUser> getReceiveUserList() {
        return this.receiveUserList;
    }

    public final String getReqId() {
        return this.reqId;
    }

    public final int getRoomId() {
        return this.roomId;
    }

    public final String getScene() {
        return this.scene;
    }

    public final String getToken() {
        return this.token;
    }

    public final long getUserId() {
        return this.userId;
    }

    public QcpxCouponInfo(String r110, long r111, int r112, String r210, String r211, String r212, String r213, int r214, String r215, String r216, long r217, long r218, int r310, int r311, int r312, int r313, String r314, int r315, String r316, String r317, boolean r318, int r410, String r411, int r412, List<ReceiveUser> r413) {
        Intrinsics.checkNotNullParameter(r110, "scene");
        Intrinsics.checkNotNullParameter(r210, "couponId");
        Intrinsics.checkNotNullParameter(r211, "couponMetaId");
        Intrinsics.checkNotNullParameter(r212, "couponMetaType");
        Intrinsics.checkNotNullParameter(r213, "couponType");
        Intrinsics.checkNotNullParameter(r215, "reqId");
        Intrinsics.checkNotNullParameter(r216, "token");
        Intrinsics.checkNotNullParameter(r314, "orderStatus");
        Intrinsics.checkNotNullParameter(r316, "extra");
        Intrinsics.checkNotNullParameter(r317, "couponMetaName");
        Intrinsics.checkNotNullParameter(r411, "expireTimeStr");
        Intrinsics.checkNotNullParameter(r413, "receiveUserList");
        this.scene = r110;
        this.userId = r111;
        this.applyTime = r112;
        this.couponId = r210;
        this.couponMetaId = r211;
        this.couponMetaType = r212;
        this.couponType = r213;
        this.appId = r214;
        this.reqId = r215;
        this.token = r216;
        this.cid = r217;
        this.adId = r218;
        this.roomId = r310;
        this.qponValue = r311;
        this.qponThreshold = r312;
        this.orderId = r313;
        this.orderStatus = r314;
        this.orderTime = r315;
        this.extra = r316;
        this.couponMetaName = r317;
        this.lifeUGCouponTag = r318;
        this.expireTime = r410;
        this.expireTimeStr = r411;
        this.receiveNumber = r412;
        this.receiveUserList = r413;
    }

    public /* synthetic */ QcpxCouponInfo(String r310, long r311, int r312, String r313, String r314, String r315, String r316, int r317, String r318, String r410, long r411, long r412, int r413, int r414, int r415, int r416, String r417, int r510, String r511, String r512, boolean r513, int r514, String r515, int r516, List r517, int r518, DefaultConstructorMarker r519) {
        if ((r518 & 1) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r518 & 2) == 0) goto L9;
        long r101 = 0;
    L11:
        if ((r518 & 4) == 0) goto L13;
        int r102 = 0;
    L15:
        if ((r518 & 8) == 0) goto L17;
        String r103 = "";
    L19:
        if ((r518 & 16) == 0) goto L21;
        String r110 = "";
    L23:
        if ((r518 & 32) == 0) goto L25;
        String r111 = "";
    L27:
        if ((r518 & 64) == 0) goto L29;
        String r112 = "";
    L31:
        if ((r518 & 128) == 0) goto L33;
        int r113 = 0;
    L35:
        if ((r518 & 256) == 0) goto L37;
        String r114 = "";
    L39:
        if ((r518 & 512) == 0) goto L41;
        String r115 = "";
    L43:
        if ((r518 & 1024) == 0) goto L45;
        long r104 = 0;
    L47:
        if ((r518 & 2048) == 0) goto L49;
        long r116 = 0;
    L51:
        if ((r518 & 4096) == 0) goto L53;
        int r105 = 0;
    L55:
        if ((r518 & 8192) == 0) goto L57;
        int r106 = 0;
    L58:
        int r117 = r106;
        if ((r518 & 16384) == 0) goto L61;
        int r107 = 0;
    L63:
        if ((r518 & 32768) == 0) goto L65;
        int r118 = 0;
    L67:
        if ((r518 & 65536) == 0) goto L69;
        String r210 = "";
    L71:
        if ((r518 & 131072) == 0) goto L73;
        int r211 = 0;
    L75:
        if ((r518 & 262144) == 0) goto L77;
        String r212 = "";
    L79:
        if ((r518 & 524288) == 0) goto L81;
        String r213 = "";
    L83:
        if ((r518 & 1048576) == 0) goto L85;
        boolean r214 = false;
    L87:
        if ((r518 & 2097152) == 0) goto L89;
        int r215 = 0;
    L91:
        if ((r518 & 4194304) == 0) goto L93;
        String r216 = "";
    L95:
        if ((r518 & 8388608) == 0) goto L97;
        int r217 = 0;
    L99:
        if ((r518 & 16777216) == 0) goto L101;
        List r108 = CollectionsKt.emptyList();
    L102:
        this(r100, r101, r102, r103, r110, r111, r112, r113, r114, r115, r104, r116, r105, r117, r107, r118, r210, r211, r212, r213, r214, r215, r216, r217, r108);
        return;
    L101:
        r108 = r517;
        goto L102
    L97:
        r217 = r516;
        goto L99
    L93:
        r216 = r515;
        goto L95
    L89:
        r215 = r514;
        goto L91
    L85:
        r214 = r513;
        goto L87
    L81:
        r213 = r512;
        goto L83
    L77:
        r212 = r511;
        goto L79
    L73:
        r211 = r510;
        goto L75
    L69:
        r210 = r417;
        goto L71
    L65:
        r118 = r416;
        goto L67
    L61:
        r107 = r415;
        goto L63
    L57:
        r106 = r414;
        goto L58
    L53:
        r105 = r413;
        goto L55
    L49:
        r116 = r412;
        goto L51
    L45:
        r104 = r411;
        goto L47
    L41:
        r115 = r410;
        goto L43
    L37:
        r114 = r318;
        goto L39
    L33:
        r113 = r317;
        goto L35
    L29:
        r112 = r316;
        goto L31
    L25:
        r111 = r315;
        goto L27
    L21:
        r110 = r314;
        goto L23
    L17:
        r103 = r313;
        goto L19
    L13:
        r102 = r312;
        goto L15
    L9:
        r101 = r311;
        goto L11
    L5:
        r100 = r310;
        goto L7
    }
}
