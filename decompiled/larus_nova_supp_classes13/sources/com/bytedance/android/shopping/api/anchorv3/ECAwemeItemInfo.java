package com.bytedance.android.shopping.api.anchorv3;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b3\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001Bé\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\t\u0012\b\b\u0002\u0010\u0013\u001a\u00020\t\u0012\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010\u001b\u001a\u00020\t¢\u0006\u0002\u0010\u001cJ\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\tHÆ\u0003J\t\u0010;\u001a\u00020\tHÆ\u0003J\u0011\u0010<\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0015HÆ\u0003J\u0010\u0010=\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010$J\u0010\u0010>\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010$J\u0010\u0010?\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010$J\u000b\u0010@\u001a\u0004\u0018\u00010\u001aHÆ\u0003J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\t\u0010B\u001a\u00020\tHÆ\u0003J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\u0010\u0010D\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010$J\t\u0010E\u001a\u00020\tHÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010G\u001a\u00020\tHÆ\u0003J\t\u0010H\u001a\u00020\u0007HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jò\u0001\u0010J\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\t2\b\b\u0002\u0010\u0013\u001a\u00020\t2\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\tHÆ\u0001¢\u0006\u0002\u0010KJ\u0013\u0010L\u001a\u00020\t2\b\u0010M\u001a\u0004\u0018\u00010NHÖ\u0003J\t\u0010O\u001a\u00020\u0007HÖ\u0001J\t\u0010P\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0016\u0010\u001b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010%\u001a\u0004\b#\u0010$R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u001a8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010%\u001a\u0004\b(\u0010$R\u0015\u0010\u0017\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010%\u001a\u0004\b)\u0010$R\u0019\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010%\u001a\u0004\b,\u0010$R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\"R\u0011\u0010\u0013\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\"R\u0011\u0010\u0012\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\"R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001eR\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001eR\u0011\u0010\u000b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\"R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u001eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u001eR\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u001e¨\u0006Q"}, d2 = {"Lcom/bytedance/android/shopping/api/anchorv3/ECAwemeItemInfo;", "Ljava/io/Serializable;", "itemId", "", "userId", "secUid", "followStatus", "", "isAd", "", "adType", "shouldEnterProductFeed", "pageInternalFlowStyle", "topLabelText", "aggParams", "Lorg/json/JSONObject;", "rawCreativeId", "userOpenId", "isStar", "isAds", "goodPriceParam", "", "goodPriceCardGuessLikeOpt", "goodPriceCardMainOpt", "innerLandingImageSearch", "fullProductFlowConfig", "Lcom/google/gson/JsonObject;", "enableInflowList", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ZLjava/lang/String;ZILjava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;ZZLjava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/google/gson/JsonObject;Z)V", "getAdType", "()Ljava/lang/String;", "getAggParams", "()Lorg/json/JSONObject;", "getEnableInflowList", "()Z", "getFollowStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getFullProductFlowConfig", "()Lcom/google/gson/JsonObject;", "getGoodPriceCardGuessLikeOpt", "getGoodPriceCardMainOpt", "getGoodPriceParam", "()Ljava/util/List;", "getInnerLandingImageSearch", "getItemId", "getPageInternalFlowStyle", "()I", "getRawCreativeId", "getSecUid", "getShouldEnterProductFeed", "getTopLabelText", "getUserId", "getUserOpenId", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ZLjava/lang/String;ZILjava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;ZZLjava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/google/gson/JsonObject;Z)Lcom/bytedance/android/shopping/api/anchorv3/ECAwemeItemInfo;", "equals", "other", "", "hashCode", "toString", "ec-shopping-api_release"}, k = 1, mv = {1, 4, 3})
public final class ECAwemeItemInfo implements Serializable {
    private final String adType;
    private final JSONObject aggParams;

    @SerializedName("enable_inflow_list")
    private final boolean enableInflowList;
    private final Integer followStatus;

    @SerializedName("full_product_flow_config")
    private final JsonObject fullProductFlowConfig;
    private final Integer goodPriceCardGuessLikeOpt;
    private final Integer goodPriceCardMainOpt;
    private final List<String> goodPriceParam;
    private final Integer innerLandingImageSearch;
    private final boolean isAd;
    private final boolean isAds;
    private final boolean isStar;
    private final String itemId;
    private final int pageInternalFlowStyle;
    private final String rawCreativeId;
    private final String secUid;
    private final boolean shouldEnterProductFeed;
    private final String topLabelText;
    private final String userId;
    private final String userOpenId;

    public ECAwemeItemInfo() {
        this(null, null, null, null, false, null, false, 0, null, null, null, null, false, false, null, null, null, null, null, false, 1048575, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ECAwemeItemInfo copy$default(ECAwemeItemInfo r17, String r18, String r19, String r20, Integer r21, boolean r22, String r23, boolean r24, int r25, String r26, JSONObject r27, String r28, String r29, boolean r30, boolean r31, List r32, Integer r33, Integer r34, Integer r35, JsonObject r36, boolean r37, int r38, Object r39) {
        if ((r38 & 1) == 0) goto L5;
        String r2 = r17.itemId;
    L7:
        if ((r38 & 2) == 0) goto L9;
        String r3 = r17.userId;
    L11:
        if ((r38 & 4) == 0) goto L13;
        String r4 = r17.secUid;
    L15:
        if ((r38 & 8) == 0) goto L17;
        Integer r5 = r17.followStatus;
    L19:
        if ((r38 & 16) == 0) goto L21;
        boolean r6 = r17.isAd;
    L23:
        if ((r38 & 32) == 0) goto L25;
        String r7 = r17.adType;
    L27:
        if ((r38 & 64) == 0) goto L29;
        boolean r8 = r17.shouldEnterProductFeed;
    L31:
        if ((r38 & 128) == 0) goto L33;
        int r9 = r17.pageInternalFlowStyle;
    L35:
        if ((r38 & 256) == 0) goto L37;
        String r10 = r17.topLabelText;
    L39:
        if ((r38 & 512) == 0) goto L41;
        JSONObject r11 = r17.aggParams;
    L43:
        if ((r38 & 1024) == 0) goto L45;
        String r12 = r17.rawCreativeId;
    L47:
        if ((r38 & 2048) == 0) goto L49;
        String r13 = r17.userOpenId;
    L51:
        if ((r38 & 4096) == 0) goto L53;
        boolean r14 = r17.isStar;
    L55:
        if ((r38 & 8192) == 0) goto L57;
        boolean r15 = r17.isAds;
    L58:
        boolean r310 = r15;
        if ((r38 & 16384) == 0) goto L61;
        List r16 = r17.goodPriceParam;
    L62:
        List r311 = r16;
        if ((r38 & 32768) == 0) goto L65;
        Integer r110 = r17.goodPriceCardGuessLikeOpt;
    L66:
        Integer r312 = r110;
        if ((r38 & 65536) == 0) goto L69;
        Integer r111 = r17.goodPriceCardMainOpt;
    L70:
        Integer r313 = r111;
        if ((r38 & 131072) == 0) goto L73;
        Integer r112 = r17.innerLandingImageSearch;
    L74:
        Integer r314 = r112;
        if ((r38 & 262144) == 0) goto L77;
        JsonObject r113 = r17.fullProductFlowConfig;
    L79:
        if ((r38 & 524288) == 0) goto L81;
        boolean r1 = r17.enableInflowList;
    L83:
        return r17.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r310, r311, r312, r313, r314, r113, r1);
    L81:
        r1 = r37;
        goto L83
    L77:
        r113 = r36;
        goto L79
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
        return this.itemId;
    }

    public final JSONObject component10() {
        return this.aggParams;
    }

    public final String component11() {
        return this.rawCreativeId;
    }

    public final String component12() {
        return this.userOpenId;
    }

    public final boolean component13() {
        return this.isStar;
    }

    public final boolean component14() {
        return this.isAds;
    }

    public final List<String> component15() {
        return this.goodPriceParam;
    }

    public final Integer component16() {
        return this.goodPriceCardGuessLikeOpt;
    }

    public final Integer component17() {
        return this.goodPriceCardMainOpt;
    }

    public final Integer component18() {
        return this.innerLandingImageSearch;
    }

    public final JsonObject component19() {
        return this.fullProductFlowConfig;
    }

    public final String component2() {
        return this.userId;
    }

    public final boolean component20() {
        return this.enableInflowList;
    }

    public final String component3() {
        return this.secUid;
    }

    public final Integer component4() {
        return this.followStatus;
    }

    public final boolean component5() {
        return this.isAd;
    }

    public final String component6() {
        return this.adType;
    }

    public final boolean component7() {
        return this.shouldEnterProductFeed;
    }

    public final int component8() {
        return this.pageInternalFlowStyle;
    }

    public final String component9() {
        return this.topLabelText;
    }

    public final ECAwemeItemInfo copy(String r23, String r24, String r25, Integer r26, boolean r27, String r28, boolean r29, int r30, String r31, JSONObject r32, String r33, String r34, boolean r35, boolean r36, List<String> r37, Integer r38, Integer r39, Integer r40, JsonObject r41, boolean r42) {
        Intrinsics.checkNotNullParameter(r24, "userId");
        Intrinsics.checkNotNullParameter(r25, "secUid");
        Intrinsics.checkNotNullParameter(r34, "userOpenId");
        return new ECAwemeItemInfo(r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof ECAwemeItemInfo) == false) goto L46;
        ECAwemeItemInfo r4 = (ECAwemeItemInfo) r3;
        if (Intrinsics.areEqual(this.itemId, r4.itemId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.userId, r4.userId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.secUid, r4.secUid) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.followStatus, r4.followStatus) == true) goto L14;
        return false;
    L14:
        if (this.isAd == r4.isAd) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.adType, r4.adType) == true) goto L18;
        return false;
    L18:
        if (this.shouldEnterProductFeed == r4.shouldEnterProductFeed) goto L20;
        return false;
    L20:
        if (this.pageInternalFlowStyle == r4.pageInternalFlowStyle) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.topLabelText, r4.topLabelText) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.aggParams, r4.aggParams) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.rawCreativeId, r4.rawCreativeId) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.userOpenId, r4.userOpenId) == true) goto L30;
        return false;
    L30:
        if (this.isStar == r4.isStar) goto L32;
        return false;
    L32:
        if (this.isAds == r4.isAds) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.goodPriceParam, r4.goodPriceParam) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.goodPriceCardGuessLikeOpt, r4.goodPriceCardGuessLikeOpt) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.goodPriceCardMainOpt, r4.goodPriceCardMainOpt) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.innerLandingImageSearch, r4.innerLandingImageSearch) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.fullProductFlowConfig, r4.fullProductFlowConfig) == true) goto L44;
        return false;
    L44:
        if (this.enableInflowList == r4.enableInflowList) goto L70;
        return false;
    L70:
        return true;
    L46:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v40, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v15, types: [int] */
    /* JADX WARN: Type inference failed for: r2v30, types: [int] */
    /* JADX WARN: Type inference failed for: r2v32, types: [int] */
    /* JADX WARN: Type inference failed for: r2v50 */
    /* JADX WARN: Type inference failed for: r2v51 */
    /* JADX WARN: Type inference failed for: r2v56 */
    /* JADX WARN: Type inference failed for: r2v58 */
    /* JADX WARN: Type inference failed for: r2v62 */
    /* JADX WARN: Type inference failed for: r2v63 */
    /* JADX WARN: Type inference failed for: r2v64 */
    /* JADX WARN: Type inference failed for: r2v65 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        String r0 = this.itemId;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.userId;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.secUid;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.followStatus;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        boolean r13 = this.isAd;
        ?? r14 = 1;
        ?? r15 = r13;
        if (r13 == false) goto L21;
        r15 = 1;
    L21:
        int r16 = (r12 + r15) * 31;
        String r17 = this.adType;
        if (r17 == null) goto L24;
        int r18 = r17.hashCode();
    L25:
        int r19 = (r16 + r18) * 31;
        boolean r20 = this.shouldEnterProductFeed;
        ?? r21 = r20;
        if (r20 == false) goto L28;
        r21 = 1;
    L28:
        int r22 = (((r19 + r21) * 31) + this.pageInternalFlowStyle) * 31;
        String r23 = this.topLabelText;
        if (r23 == null) goto L31;
        int r24 = r23.hashCode();
    L32:
        int r25 = (r22 + r24) * 31;
        JSONObject r26 = this.aggParams;
        if (r26 == null) goto L35;
        int r27 = r26.hashCode();
    L36:
        int r28 = (r25 + r27) * 31;
        String r29 = this.rawCreativeId;
        if (r29 == null) goto L39;
        int r30 = r29.hashCode();
    L40:
        int r31 = (r28 + r30) * 31;
        String r32 = this.userOpenId;
        if (r32 == null) goto L43;
        int r33 = r32.hashCode();
    L44:
        int r34 = (r31 + r33) * 31;
        boolean r35 = this.isStar;
        ?? r36 = r35;
        if (r35 == false) goto L47;
        r36 = 1;
    L47:
        int r37 = (r34 + r36) * 31;
        boolean r38 = this.isAds;
        ?? r39 = r38;
        if (r38 == false) goto L50;
        r39 = 1;
    L50:
        int r40 = (r37 + r39) * 31;
        List<String> r41 = this.goodPriceParam;
        if (r41 == null) goto L53;
        int r42 = r41.hashCode();
    L54:
        int r43 = (r40 + r42) * 31;
        Integer r44 = this.goodPriceCardGuessLikeOpt;
        if (r44 == null) goto L57;
        int r45 = r44.hashCode();
    L58:
        int r46 = (r43 + r45) * 31;
        Integer r47 = this.goodPriceCardMainOpt;
        if (r47 == null) goto L61;
        int r48 = r47.hashCode();
    L62:
        int r49 = (r46 + r48) * 31;
        Integer r50 = this.innerLandingImageSearch;
        if (r50 == null) goto L65;
        int r51 = r50.hashCode();
    L66:
        int r52 = (r49 + r51) * 31;
        JsonObject r53 = this.fullProductFlowConfig;
        if (r53 == null) goto L69;
        r1 = r53.hashCode();
    L69:
        int r54 = (r52 + r1) * 31;
        boolean r55 = this.enableInflowList;
        if (r55 == true) goto L74;
        r14 = r55;
    L74:
        return r54 + r14;
    L65:
        r51 = 0;
        goto L66
    L61:
        r48 = 0;
        goto L62
    L57:
        r45 = 0;
        goto L58
    L53:
        r42 = 0;
        goto L54
    L43:
        r33 = 0;
        goto L44
    L39:
        r30 = 0;
        goto L40
    L35:
        r27 = 0;
        goto L36
    L31:
        r24 = 0;
        goto L32
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
        return "ECAwemeItemInfo(itemId=" + this.itemId + ", userId=" + this.userId + ", secUid=" + this.secUid + ", followStatus=" + this.followStatus + ", isAd=" + this.isAd + ", adType=" + this.adType + ", shouldEnterProductFeed=" + this.shouldEnterProductFeed + ", pageInternalFlowStyle=" + this.pageInternalFlowStyle + ", topLabelText=" + this.topLabelText + ", aggParams=" + this.aggParams + ", rawCreativeId=" + this.rawCreativeId + ", userOpenId=" + this.userOpenId + ", isStar=" + this.isStar + ", isAds=" + this.isAds + ", goodPriceParam=" + this.goodPriceParam + ", goodPriceCardGuessLikeOpt=" + this.goodPriceCardGuessLikeOpt + ", goodPriceCardMainOpt=" + this.goodPriceCardMainOpt + ", innerLandingImageSearch=" + this.innerLandingImageSearch + ", fullProductFlowConfig=" + this.fullProductFlowConfig + ", enableInflowList=" + this.enableInflowList + ")";
    }

    public final String getAdType() {
        return this.adType;
    }

    public final JSONObject getAggParams() {
        return this.aggParams;
    }

    public final boolean getEnableInflowList() {
        return this.enableInflowList;
    }

    public final Integer getFollowStatus() {
        return this.followStatus;
    }

    public final JsonObject getFullProductFlowConfig() {
        return this.fullProductFlowConfig;
    }

    public final Integer getGoodPriceCardGuessLikeOpt() {
        return this.goodPriceCardGuessLikeOpt;
    }

    public final Integer getGoodPriceCardMainOpt() {
        return this.goodPriceCardMainOpt;
    }

    public final List<String> getGoodPriceParam() {
        return this.goodPriceParam;
    }

    public final Integer getInnerLandingImageSearch() {
        return this.innerLandingImageSearch;
    }

    public final String getItemId() {
        return this.itemId;
    }

    public final int getPageInternalFlowStyle() {
        return this.pageInternalFlowStyle;
    }

    public final String getRawCreativeId() {
        return this.rawCreativeId;
    }

    public final String getSecUid() {
        return this.secUid;
    }

    public final boolean getShouldEnterProductFeed() {
        return this.shouldEnterProductFeed;
    }

    public final String getTopLabelText() {
        return this.topLabelText;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getUserOpenId() {
        return this.userOpenId;
    }

    public final boolean isAd() {
        return this.isAd;
    }

    public final boolean isAds() {
        return this.isAds;
    }

    public final boolean isStar() {
        return this.isStar;
    }

    public ECAwemeItemInfo(String r6, String r7, String r8, Integer r9, boolean r10, String r11, boolean r12, int r13, String r14, JSONObject r15, String r16, String r17, boolean r18, boolean r19, List<String> r20, Integer r21, Integer r22, Integer r23, JsonObject r24, boolean r25) {
        Intrinsics.checkNotNullParameter(r7, "userId");
        Intrinsics.checkNotNullParameter(r8, "secUid");
        Intrinsics.checkNotNullParameter(r17, "userOpenId");
        this.itemId = r6;
        this.userId = r7;
        this.secUid = r8;
        this.followStatus = r9;
        this.isAd = r10;
        this.adType = r11;
        this.shouldEnterProductFeed = r12;
        this.pageInternalFlowStyle = r13;
        this.topLabelText = r14;
        this.aggParams = r15;
        this.rawCreativeId = r16;
        this.userOpenId = r17;
        this.isStar = r18;
        this.isAds = r19;
        this.goodPriceParam = r20;
        this.goodPriceCardGuessLikeOpt = r21;
        this.goodPriceCardMainOpt = r22;
        this.innerLandingImageSearch = r23;
        this.fullProductFlowConfig = r24;
        this.enableInflowList = r25;
    }

    public /* synthetic */ ECAwemeItemInfo(String r23, String r24, String r25, Integer r26, boolean r27, String r28, boolean r29, int r30, String r31, JSONObject r32, String r33, String r34, boolean r35, boolean r36, List r37, Integer r38, Integer r39, Integer r40, JsonObject r41, boolean r42, int r43, DefaultConstructorMarker r44) {
        if ((r43 & 1) == 0) goto L5;
        String r1 = null;
    L6:
        String r4 = "";
        if ((r43 & 2) == 0) goto L9;
        String r3 = "";
    L11:
        if ((r43 & 4) == 0) goto L13;
        String r5 = "";
    L15:
        if ((r43 & 8) == 0) goto L17;
        Integer r6 = null;
    L19:
        if ((r43 & 16) == 0) goto L21;
        boolean r7 = false;
    L23:
        if ((r43 & 32) == 0) goto L25;
        String r9 = null;
    L27:
        if ((r43 & 64) == 0) goto L29;
        boolean r10 = false;
    L31:
        if ((r43 & 128) == 0) goto L33;
        int r11 = 0;
    L35:
        if ((r43 & 256) == 0) goto L37;
        String r12 = null;
    L39:
        if ((r43 & 512) == 0) goto L41;
        JSONObject r13 = null;
    L43:
        if ((r43 & 1024) == 0) goto L45;
        String r14 = null;
    L47:
        if ((r43 & 2048) != 0) goto L51;
        r4 = r34;
    L51:
        if ((r43 & 4096) == 0) goto L53;
        boolean r15 = false;
    L55:
        if ((r43 & 8192) == 0) goto L57;
        boolean r2 = false;
    L59:
        if ((r43 & 16384) == 0) goto L61;
        List r8 = null;
    L63:
        if ((r43 & 32768) == 0) goto L65;
        boolean r16 = false;
        Integer r17 = 0;
    L67:
        if ((r43 & 65536) == 0) goto L69;
        Integer r18 = Integer.valueOf(r16 ? 1 : 0);
    L71:
        if ((r43 & 131072) == 0) goto L73;
        Integer r19 = null;
    L75:
        if ((r43 & 262144) == 0) goto L77;
        JsonObject r20 = null;
    L79:
        if ((r43 & 524288) != 0) goto L82;
        r16 = r42;
    L82:
        this(r1, r3, r5, r6, r7, r9, r10, r11, r12, r13, r14, r4, r15, r2, r8, r17, r18, r19, r20, r16);
        return;
    L77:
        r20 = r41;
        goto L79
    L73:
        r19 = r40;
        goto L75
    L69:
        r18 = r39;
        goto L71
    L65:
        r16 = false;
        r17 = r38;
        goto L67
    L61:
        r8 = r37;
        goto L63
    L57:
        r2 = r36;
        goto L59
    L53:
        r15 = r35;
        goto L55
    L45:
        r14 = r33;
        goto L47
    L41:
        r13 = r32;
        goto L43
    L37:
        r12 = r31;
        goto L39
    L33:
        r11 = r30;
        goto L35
    L29:
        r10 = r29;
        goto L31
    L25:
        r9 = r28;
        goto L27
    L21:
        r7 = r27;
        goto L23
    L17:
        r6 = r26;
        goto L19
    L13:
        r5 = r25;
        goto L15
    L9:
        r3 = r24;
        goto L11
    L5:
        r1 = r23;
        goto L6
    }
}
