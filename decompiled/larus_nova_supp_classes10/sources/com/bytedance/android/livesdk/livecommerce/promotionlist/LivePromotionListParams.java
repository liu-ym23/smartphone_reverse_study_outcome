package com.bytedance.android.livesdk.livecommerce.promotionlist;

import com.bytedance.bdlocation.network.model.DeviceStatus$DiffDimension;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010$\n\u0002\b7\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u008d\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\b\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\b\u0012\b\b\u0002\u0010\u0013\u001a\u00020\b\u0012\b\b\u0002\u0010\u0014\u001a\u00020\b\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0018\u001a\u00020\n\u0012\u0016\b\u0002\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u001dJ\t\u00108\u001a\u00020\u0003HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010;\u001a\u00020\bHÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010=\u001a\u00020\bHÆ\u0003J\t\u0010>\u001a\u00020\bHÆ\u0003J\t\u0010?\u001a\u00020\bHÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\t\u0010D\u001a\u00020\nHÆ\u0003J\u0017\u0010E\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001aHÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010H\u001a\u00020\u0003HÆ\u0003J\t\u0010I\u001a\u00020\u0003HÆ\u0003J\t\u0010J\u001a\u00020\bHÆ\u0003J\t\u0010K\u001a\u00020\nHÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010M\u001a\u00020\u0003HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0091\u0002\u0010O\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0010\u001a\u00020\b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\b2\b\b\u0002\u0010\u0014\u001a\u00020\b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0018\u001a\u00020\n2\u0016\b\u0002\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010P\u001a\u00020\b2\b\u0010Q\u001a\u0004\u0018\u00010RHÖ\u0003J\t\u0010S\u001a\u00020\nHÖ\u0001J\t\u0010T\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001fR\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001fR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001fR\u0011\u0010\u0012\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\"R\u0011\u0010\u0010\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\"R\u0011\u0010\u0013\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\"R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001fR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001fR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001fR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001fR\u0011\u0010\u0014\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\"R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001fR\u001f\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001a¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001fR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u001fR\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u001fR\u0011\u0010\u0018\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b4\u0010(R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u001f\"\u0004\b6\u00107¨\u0006U"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotionlist/LivePromotionListParams;", "Ljava/io/Serializable;", "roomId", "", "containerRoomId", "anchorId", "anchorSecId", "autoApplyCoupon", "", "listApplyCoupon", "", "openMethod", "monitorName", "couponId", "liveListChannel", "scrollPromotionId", "isPromotionId", "extraEntranceInfo", "isFromLiveRoom", "isVsVerticalVideo", "recommendProductDisplayed", "tabUniqueIndex", "shoppingCartTaskItemId", "shoppingCartTaskMetaID", "shoppingCartTaskScene", "schemaEventParams", "", "cartAnimRelatedInfo", "preferredCoupon", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;ZZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/Map;Ljava/lang/String;Ljava/lang/String;)V", "getAnchorId", "()Ljava/lang/String;", "getAnchorSecId", "getAutoApplyCoupon", "()Z", "getCartAnimRelatedInfo", "getContainerRoomId", "getCouponId", "getExtraEntranceInfo", "getListApplyCoupon", "()I", "getLiveListChannel", "getMonitorName", "getOpenMethod", "getPreferredCoupon", "getRecommendProductDisplayed", "getRoomId", "getSchemaEventParams", "()Ljava/util/Map;", "getScrollPromotionId", "getShoppingCartTaskItemId", "getShoppingCartTaskMetaID", "getShoppingCartTaskScene", "getTabUniqueIndex", "setTabUniqueIndex", "(Ljava/lang/String;)V", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "toString", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LivePromotionListParams implements Serializable {
    private final String anchorId;
    private final String anchorSecId;
    private final boolean autoApplyCoupon;
    private final String cartAnimRelatedInfo;
    private final String containerRoomId;
    private final String couponId;
    private final String extraEntranceInfo;
    private final boolean isFromLiveRoom;
    private final boolean isPromotionId;
    private final boolean isVsVerticalVideo;
    private final int listApplyCoupon;
    private final String liveListChannel;
    private final String monitorName;
    private final String openMethod;

    @SerializedName("preferred_coupon")
    private final String preferredCoupon;
    private final boolean recommendProductDisplayed;
    private final String roomId;
    private final Map<String, String> schemaEventParams;
    private final String scrollPromotionId;
    private final String shoppingCartTaskItemId;
    private final String shoppingCartTaskMetaID;
    private final int shoppingCartTaskScene;
    private String tabUniqueIndex;

    public LivePromotionListParams() {
        this(null, null, null, null, false, 0, null, null, null, null, null, false, null, false, false, false, null, null, null, 0, null, null, null, 8388607, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LivePromotionListParams copy$default(LivePromotionListParams r17, String r18, String r19, String r20, String r21, boolean r22, int r23, String r24, String r25, String r26, String r27, String r28, boolean r29, String r30, boolean r31, boolean r32, boolean r33, String r34, String r35, String r36, int r37, Map r38, String r39, String r40, int r41, Object r42) {
        if ((r41 & 1) == 0) goto L5;
        String r2 = r17.roomId;
    L7:
        if ((r41 & 2) == 0) goto L9;
        String r3 = r17.containerRoomId;
    L11:
        if ((r41 & 4) == 0) goto L13;
        String r4 = r17.anchorId;
    L15:
        if ((r41 & 8) == 0) goto L17;
        String r5 = r17.anchorSecId;
    L19:
        if ((r41 & 16) == 0) goto L21;
        boolean r6 = r17.autoApplyCoupon;
    L23:
        if ((r41 & 32) == 0) goto L25;
        int r7 = r17.listApplyCoupon;
    L27:
        if ((r41 & 64) == 0) goto L29;
        String r8 = r17.openMethod;
    L31:
        if ((r41 & DeviceStatus$DiffDimension.DIFF_RESTRICTED_MODE) == 0) goto L33;
        String r9 = r17.monitorName;
    L35:
        if ((r41 & DeviceStatus$DiffDimension.DIFF_LOCATION_MODE) == 0) goto L37;
        String r10 = r17.couponId;
    L39:
        if ((r41 & DeviceStatus$DiffDimension.DIFF_IS_STRICT_RESTRICTED_MODE) == 0) goto L41;
        String r11 = r17.liveListChannel;
    L43:
        if ((r41 & DeviceStatus$DiffDimension.DIFF_BLUETOOTH_PERMISSION) == 0) goto L45;
        String r12 = r17.scrollPromotionId;
    L47:
        if ((r41 & 2048) == 0) goto L49;
        boolean r13 = r17.isPromotionId;
    L51:
        if ((r41 & 4096) == 0) goto L53;
        String r14 = r17.extraEntranceInfo;
    L55:
        if ((r41 & 8192) == 0) goto L57;
        boolean r15 = r17.isFromLiveRoom;
    L58:
        boolean r310 = r15;
        if ((r41 & 16384) == 0) goto L61;
        boolean r16 = r17.isVsVerticalVideo;
    L62:
        boolean r311 = r16;
        if ((r41 & 32768) == 0) goto L65;
        boolean r110 = r17.recommendProductDisplayed;
    L66:
        boolean r312 = r110;
        if ((r41 & 65536) == 0) goto L69;
        String r111 = r17.tabUniqueIndex;
    L70:
        String r313 = r111;
        if ((r41 & 131072) == 0) goto L73;
        String r112 = r17.shoppingCartTaskItemId;
    L74:
        String r314 = r112;
        if ((r41 & 262144) == 0) goto L77;
        String r113 = r17.shoppingCartTaskMetaID;
    L78:
        String r315 = r113;
        if ((r41 & 524288) == 0) goto L81;
        int r114 = r17.shoppingCartTaskScene;
    L82:
        int r316 = r114;
        if ((r41 & 1048576) == 0) goto L85;
        Map r115 = r17.schemaEventParams;
    L86:
        Map r317 = r115;
        if ((r41 & 2097152) == 0) goto L89;
        String r116 = r17.cartAnimRelatedInfo;
    L91:
        if ((r41 & 4194304) == 0) goto L93;
        String r1 = r17.preferredCoupon;
    L95:
        return r17.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r310, r311, r312, r313, r314, r315, r316, r317, r116, r1);
    L93:
        r1 = r40;
        goto L95
    L89:
        r116 = r39;
        goto L91
    L85:
        r115 = r38;
        goto L86
    L81:
        r114 = r37;
        goto L82
    L77:
        r113 = r36;
        goto L78
    L73:
        r112 = r35;
        goto L74
    L69:
        r111 = r34;
        goto L70
    L65:
        r110 = r33;
        goto L66
    L61:
        r16 = r32;
        goto L62
    L57:
        r15 = r31;
        goto L58
    L53:
        r14 = r30;
        goto L55
    L49:
        r13 = r29;
        goto L51
    L45:
        r12 = r28;
        goto L47
    L41:
        r11 = r27;
        goto L43
    L37:
        r10 = r26;
        goto L39
    L33:
        r9 = r25;
        goto L35
    L29:
        r8 = r24;
        goto L31
    L25:
        r7 = r23;
        goto L27
    L21:
        r6 = r22;
        goto L23
    L17:
        r5 = r21;
        goto L19
    L13:
        r4 = r20;
        goto L15
    L9:
        r3 = r19;
        goto L11
    L5:
        r2 = r18;
        goto L7
    }

    public final String component1() {
        return this.roomId;
    }

    public final String component10() {
        return this.liveListChannel;
    }

    public final String component11() {
        return this.scrollPromotionId;
    }

    public final boolean component12() {
        return this.isPromotionId;
    }

    public final String component13() {
        return this.extraEntranceInfo;
    }

    public final boolean component14() {
        return this.isFromLiveRoom;
    }

    public final boolean component15() {
        return this.isVsVerticalVideo;
    }

    public final boolean component16() {
        return this.recommendProductDisplayed;
    }

    public final String component17() {
        return this.tabUniqueIndex;
    }

    public final String component18() {
        return this.shoppingCartTaskItemId;
    }

    public final String component19() {
        return this.shoppingCartTaskMetaID;
    }

    public final String component2() {
        return this.containerRoomId;
    }

    public final int component20() {
        return this.shoppingCartTaskScene;
    }

    public final Map<String, String> component21() {
        return this.schemaEventParams;
    }

    public final String component22() {
        return this.cartAnimRelatedInfo;
    }

    public final String component23() {
        return this.preferredCoupon;
    }

    public final String component3() {
        return this.anchorId;
    }

    public final String component4() {
        return this.anchorSecId;
    }

    public final boolean component5() {
        return this.autoApplyCoupon;
    }

    public final int component6() {
        return this.listApplyCoupon;
    }

    public final String component7() {
        return this.openMethod;
    }

    public final String component8() {
        return this.monitorName;
    }

    public final String component9() {
        return this.couponId;
    }

    public final LivePromotionListParams copy(String r27, String r28, String r29, String r30, boolean r31, int r32, String r33, String r34, String r35, String r36, String r37, boolean r38, String r39, boolean r40, boolean r41, boolean r42, String r43, String r44, String r45, int r46, Map<String, String> r47, String r48, String r49) {
        Intrinsics.checkNotNullParameter(r27, "roomId");
        Intrinsics.checkNotNullParameter(r28, "containerRoomId");
        Intrinsics.checkNotNullParameter(r29, "anchorId");
        Intrinsics.checkNotNullParameter(r30, "anchorSecId");
        Intrinsics.checkNotNullParameter(r34, "monitorName");
        return new LivePromotionListParams(r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof LivePromotionListParams) == false) goto L52;
        LivePromotionListParams r4 = (LivePromotionListParams) r3;
        if (Intrinsics.areEqual(this.roomId, r4.roomId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.containerRoomId, r4.containerRoomId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.anchorId, r4.anchorId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.anchorSecId, r4.anchorSecId) == true) goto L14;
        return false;
    L14:
        if (this.autoApplyCoupon == r4.autoApplyCoupon) goto L16;
        return false;
    L16:
        if (this.listApplyCoupon == r4.listApplyCoupon) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.openMethod, r4.openMethod) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.monitorName, r4.monitorName) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.couponId, r4.couponId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.liveListChannel, r4.liveListChannel) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.scrollPromotionId, r4.scrollPromotionId) == true) goto L28;
        return false;
    L28:
        if (this.isPromotionId == r4.isPromotionId) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.extraEntranceInfo, r4.extraEntranceInfo) == true) goto L32;
        return false;
    L32:
        if (this.isFromLiveRoom == r4.isFromLiveRoom) goto L34;
        return false;
    L34:
        if (this.isVsVerticalVideo == r4.isVsVerticalVideo) goto L36;
        return false;
    L36:
        if (this.recommendProductDisplayed == r4.recommendProductDisplayed) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.tabUniqueIndex, r4.tabUniqueIndex) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.shoppingCartTaskItemId, r4.shoppingCartTaskItemId) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.shoppingCartTaskMetaID, r4.shoppingCartTaskMetaID) == true) goto L44;
        return false;
    L44:
        if (this.shoppingCartTaskScene == r4.shoppingCartTaskScene) goto L46;
        return false;
    L46:
        if (Intrinsics.areEqual(this.schemaEventParams, r4.schemaEventParams) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.cartAnimRelatedInfo, r4.cartAnimRelatedInfo) == true) goto L50;
        return false;
    L50:
        if (Intrinsics.areEqual(this.preferredCoupon, r4.preferredCoupon) == true) goto L79;
        return false;
    L79:
        return true;
    L52:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v28, types: [int] */
    /* JADX WARN: Type inference failed for: r2v33, types: [int] */
    /* JADX WARN: Type inference failed for: r2v35, types: [int] */
    /* JADX WARN: Type inference failed for: r2v59 */
    /* JADX WARN: Type inference failed for: r2v60 */
    /* JADX WARN: Type inference failed for: r2v62 */
    /* JADX WARN: Type inference failed for: r2v68 */
    /* JADX WARN: Type inference failed for: r2v72 */
    /* JADX WARN: Type inference failed for: r2v73 */
    /* JADX WARN: Type inference failed for: r2v74 */
    /* JADX WARN: Type inference failed for: r2v75 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        String r0 = this.roomId;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.containerRoomId;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.anchorId;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.anchorSecId;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        boolean r13 = this.autoApplyCoupon;
        ?? r14 = 1;
        ?? r15 = r13;
        if (r13 == false) goto L21;
        r15 = 1;
    L21:
        int r16 = (((r12 + r15) * 31) + this.listApplyCoupon) * 31;
        String r17 = this.openMethod;
        if (r17 == null) goto L24;
        int r18 = r17.hashCode();
    L25:
        int r19 = (r16 + r18) * 31;
        String r20 = this.monitorName;
        if (r20 == null) goto L28;
        int r21 = r20.hashCode();
    L29:
        int r22 = (r19 + r21) * 31;
        String r23 = this.couponId;
        if (r23 == null) goto L32;
        int r24 = r23.hashCode();
    L33:
        int r25 = (r22 + r24) * 31;
        String r26 = this.liveListChannel;
        if (r26 == null) goto L36;
        int r27 = r26.hashCode();
    L37:
        int r28 = (r25 + r27) * 31;
        String r29 = this.scrollPromotionId;
        if (r29 == null) goto L40;
        int r30 = r29.hashCode();
    L41:
        int r31 = (r28 + r30) * 31;
        boolean r32 = this.isPromotionId;
        ?? r33 = r32;
        if (r32 == false) goto L44;
        r33 = 1;
    L44:
        int r34 = (r31 + r33) * 31;
        String r35 = this.extraEntranceInfo;
        if (r35 == null) goto L47;
        int r36 = r35.hashCode();
    L48:
        int r37 = (r34 + r36) * 31;
        boolean r38 = this.isFromLiveRoom;
        ?? r39 = r38;
        if (r38 == false) goto L51;
        r39 = 1;
    L51:
        int r40 = (r37 + r39) * 31;
        boolean r41 = this.isVsVerticalVideo;
        ?? r42 = r41;
        if (r41 == false) goto L54;
        r42 = 1;
    L54:
        int r43 = (r40 + r42) * 31;
        boolean r44 = this.recommendProductDisplayed;
        if (r44 == true) goto L58;
        r14 = r44;
    L58:
        int r45 = (r43 + r14) * 31;
        String r46 = this.tabUniqueIndex;
        if (r46 == null) goto L61;
        int r47 = r46.hashCode();
    L62:
        int r48 = (r45 + r47) * 31;
        String r49 = this.shoppingCartTaskItemId;
        if (r49 == null) goto L65;
        int r50 = r49.hashCode();
    L66:
        int r51 = (r48 + r50) * 31;
        String r52 = this.shoppingCartTaskMetaID;
        if (r52 == null) goto L69;
        int r53 = r52.hashCode();
    L70:
        int r54 = (((r51 + r53) * 31) + this.shoppingCartTaskScene) * 31;
        Map<String, String> r55 = this.schemaEventParams;
        if (r55 == null) goto L73;
        int r56 = r55.hashCode();
    L74:
        int r57 = (r54 + r56) * 31;
        String r58 = this.cartAnimRelatedInfo;
        if (r58 == null) goto L77;
        int r59 = r58.hashCode();
    L78:
        int r60 = (r57 + r59) * 31;
        String r61 = this.preferredCoupon;
        if (r61 == null) goto L82;
        r1 = r61.hashCode();
    L82:
        return r60 + r1;
    L77:
        r59 = 0;
        goto L78
    L73:
        r56 = 0;
        goto L74
    L69:
        r53 = 0;
        goto L70
    L65:
        r50 = 0;
        goto L66
    L61:
        r47 = 0;
        goto L62
    L47:
        r36 = 0;
        goto L48
    L40:
        r30 = 0;
        goto L41
    L36:
        r27 = 0;
        goto L37
    L32:
        r24 = 0;
        goto L33
    L28:
        r21 = 0;
        goto L29
    L24:
        r18 = 0;
        goto L25
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
        return "LivePromotionListParams(roomId=" + this.roomId + ", containerRoomId=" + this.containerRoomId + ", anchorId=" + this.anchorId + ", anchorSecId=" + this.anchorSecId + ", autoApplyCoupon=" + this.autoApplyCoupon + ", listApplyCoupon=" + this.listApplyCoupon + ", openMethod=" + this.openMethod + ", monitorName=" + this.monitorName + ", couponId=" + this.couponId + ", liveListChannel=" + this.liveListChannel + ", scrollPromotionId=" + this.scrollPromotionId + ", isPromotionId=" + this.isPromotionId + ", extraEntranceInfo=" + this.extraEntranceInfo + ", isFromLiveRoom=" + this.isFromLiveRoom + ", isVsVerticalVideo=" + this.isVsVerticalVideo + ", recommendProductDisplayed=" + this.recommendProductDisplayed + ", tabUniqueIndex=" + this.tabUniqueIndex + ", shoppingCartTaskItemId=" + this.shoppingCartTaskItemId + ", shoppingCartTaskMetaID=" + this.shoppingCartTaskMetaID + ", shoppingCartTaskScene=" + this.shoppingCartTaskScene + ", schemaEventParams=" + this.schemaEventParams + ", cartAnimRelatedInfo=" + this.cartAnimRelatedInfo + ", preferredCoupon=" + this.preferredCoupon + ")";
    }

    public final String getAnchorId() {
        return this.anchorId;
    }

    public final String getAnchorSecId() {
        return this.anchorSecId;
    }

    public final boolean getAutoApplyCoupon() {
        return this.autoApplyCoupon;
    }

    public final String getCartAnimRelatedInfo() {
        return this.cartAnimRelatedInfo;
    }

    public final String getContainerRoomId() {
        return this.containerRoomId;
    }

    public final String getCouponId() {
        return this.couponId;
    }

    public final String getExtraEntranceInfo() {
        return this.extraEntranceInfo;
    }

    public final int getListApplyCoupon() {
        return this.listApplyCoupon;
    }

    public final String getLiveListChannel() {
        return this.liveListChannel;
    }

    public final String getMonitorName() {
        return this.monitorName;
    }

    public final String getOpenMethod() {
        return this.openMethod;
    }

    public final String getPreferredCoupon() {
        return this.preferredCoupon;
    }

    public final boolean getRecommendProductDisplayed() {
        return this.recommendProductDisplayed;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public final Map<String, String> getSchemaEventParams() {
        return this.schemaEventParams;
    }

    public final String getScrollPromotionId() {
        return this.scrollPromotionId;
    }

    public final String getShoppingCartTaskItemId() {
        return this.shoppingCartTaskItemId;
    }

    public final String getShoppingCartTaskMetaID() {
        return this.shoppingCartTaskMetaID;
    }

    public final int getShoppingCartTaskScene() {
        return this.shoppingCartTaskScene;
    }

    public final String getTabUniqueIndex() {
        return this.tabUniqueIndex;
    }

    public final boolean isFromLiveRoom() {
        return this.isFromLiveRoom;
    }

    public final boolean isPromotionId() {
        return this.isPromotionId;
    }

    public final boolean isVsVerticalVideo() {
        return this.isVsVerticalVideo;
    }

    public final void setTabUniqueIndex(String r1) {
        this.tabUniqueIndex = r1;
    }

    public LivePromotionListParams(String r8, String r9, String r10, String r11, boolean r12, int r13, String r14, String r15, String r16, String r17, String r18, boolean r19, String r20, boolean r21, boolean r22, boolean r23, String r24, String r25, String r26, int r27, Map<String, String> r28, String r29, String r30) {
        Intrinsics.checkNotNullParameter(r8, "roomId");
        Intrinsics.checkNotNullParameter(r9, "containerRoomId");
        Intrinsics.checkNotNullParameter(r10, "anchorId");
        Intrinsics.checkNotNullParameter(r11, "anchorSecId");
        Intrinsics.checkNotNullParameter(r15, "monitorName");
        this.roomId = r8;
        this.containerRoomId = r9;
        this.anchorId = r10;
        this.anchorSecId = r11;
        this.autoApplyCoupon = r12;
        this.listApplyCoupon = r13;
        this.openMethod = r14;
        this.monitorName = r15;
        this.couponId = r16;
        this.liveListChannel = r17;
        this.scrollPromotionId = r18;
        this.isPromotionId = r19;
        this.extraEntranceInfo = r20;
        this.isFromLiveRoom = r21;
        this.isVsVerticalVideo = r22;
        this.recommendProductDisplayed = r23;
        this.tabUniqueIndex = r24;
        this.shoppingCartTaskItemId = r25;
        this.shoppingCartTaskMetaID = r26;
        this.shoppingCartTaskScene = r27;
        this.schemaEventParams = r28;
        this.cartAnimRelatedInfo = r29;
        this.preferredCoupon = r30;
    }

    public /* synthetic */ LivePromotionListParams(String r25, String r26, String r27, String r28, boolean r29, int r30, String r31, String r32, String r33, String r34, String r35, boolean r36, String r37, boolean r38, boolean r39, boolean r40, String r41, String r42, String r43, int r44, Map r45, String r46, String r47, int r48, DefaultConstructorMarker r49) {
        String r2 = "";
        if ((r48 & 1) == 0) goto L5;
        String r1 = "";
    L7:
        if ((r48 & 2) == 0) goto L9;
        String r3 = "";
    L11:
        if ((r48 & 4) == 0) goto L13;
        String r4 = "";
    L15:
        if ((r48 & 8) == 0) goto L17;
        String r5 = "";
    L19:
        if ((r48 & 16) == 0) goto L21;
        boolean r6 = false;
    L23:
        if ((r48 & 32) == 0) goto L25;
        int r8 = -1;
    L27:
        if ((r48 & 64) == 0) goto L29;
        String r9 = null;
    L31:
        if ((r48 & DeviceStatus$DiffDimension.DIFF_RESTRICTED_MODE) != 0) goto L35;
        r2 = r32;
    L35:
        if ((r48 & DeviceStatus$DiffDimension.DIFF_LOCATION_MODE) == 0) goto L37;
        String r11 = null;
    L39:
        if ((r48 & DeviceStatus$DiffDimension.DIFF_IS_STRICT_RESTRICTED_MODE) == 0) goto L41;
        String r12 = null;
    L43:
        if ((r48 & DeviceStatus$DiffDimension.DIFF_BLUETOOTH_PERMISSION) == 0) goto L45;
        String r13 = null;
    L47:
        if ((r48 & 2048) == 0) goto L49;
        boolean r14 = false;
    L51:
        if ((r48 & 4096) == 0) goto L53;
        String r15 = null;
    L55:
        if ((r48 & 8192) == 0) goto L57;
        boolean r7 = true;
    L59:
        if ((r48 & 16384) == 0) goto L61;
        boolean r10 = false;
    L63:
        if ((r48 & 32768) == 0) goto L65;
        boolean r16 = false;
    L67:
        if ((r48 & 65536) == 0) goto L69;
        String r17 = null;
    L71:
        if ((r48 & 131072) == 0) goto L73;
        String r18 = null;
    L75:
        if ((r48 & 262144) == 0) goto L77;
        String r19 = null;
    L79:
        if ((r48 & 524288) == 0) goto L81;
        int r20 = 0;
    L83:
        if ((r48 & 1048576) == 0) goto L85;
        Map r21 = null;
    L87:
        if ((r48 & 2097152) == 0) goto L89;
        String r22 = null;
    L91:
        if ((r48 & 4194304) == 0) goto L93;
        String r0 = null;
    L94:
        this(r1, r3, r4, r5, r6, r8, r9, r2, r11, r12, r13, r14, r15, r7, r10, r16, r17, r18, r19, r20, r21, r22, r0);
        return;
    L93:
        r0 = r47;
        goto L94
    L89:
        r22 = r46;
        goto L91
    L85:
        r21 = r45;
        goto L87
    L81:
        r20 = r44;
        goto L83
    L77:
        r19 = r43;
        goto L79
    L73:
        r18 = r42;
        goto L75
    L69:
        r17 = r41;
        goto L71
    L65:
        r16 = r40;
        goto L67
    L61:
        r10 = r39;
        goto L63
    L57:
        r7 = r38;
        goto L59
    L53:
        r15 = r37;
        goto L55
    L49:
        r14 = r36;
        goto L51
    L45:
        r13 = r35;
        goto L47
    L41:
        r12 = r34;
        goto L43
    L37:
        r11 = r33;
        goto L39
    L29:
        r9 = r31;
        goto L31
    L25:
        r8 = r30;
        goto L27
    L21:
        r6 = r29;
        goto L23
    L17:
        r5 = r28;
        goto L19
    L13:
        r4 = r27;
        goto L15
    L9:
        r3 = r26;
        goto L11
    L5:
        r1 = r25;
        goto L7
    }
}
