package com.bytedance.android.window.shop.repository.dto;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.anchorv3.AuthorReputationDTO;
import com.bytedance.android.ec.window.base.common.floatelement.WindowCartEntryConfig;
import com.bytedance.android.ec.window.base.shop.WindowFansClubInfo;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR$\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006R$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001c\u0010$\u001a\u0004\u0018\u00010#8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u001c\u0010(\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010\u0004\u001a\u0004\b)\u0010\u0006R\u001c\u0010*\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b*\u0010\u0004\u001a\u0004\b+\u0010\u0006R$\u0010-\u001a\u0004\u0018\u00010,8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001c\u00103\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b3\u0010\u0004\u001a\u0004\b4\u0010\u0006R\u001c\u00105\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b5\u0010\u0004\u001a\u0004\b6\u0010\u0006R\u001c\u00107\u001a\u0004\u0018\u00010#8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b7\u0010%\u001a\u0004\b8\u0010'R\u001c\u0010:\u001a\u0004\u0018\u0001098\u0006X\u0087\u0004¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u001c\u0010>\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b>\u0010\u0004\u001a\u0004\b?\u0010\u0006R\u001c\u0010@\u001a\u0004\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\b@\u0010\u0019\u001a\u0004\bA\u0010\u001bR\u001c\u0010C\u001a\u0004\u0018\u00010B8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010FR(\u0010H\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010G8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010KR\u001c\u0010L\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\bL\u0010\u0004\u001a\u0004\bM\u0010\u0006R.\u0010O\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020N\u0018\u00010G8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bO\u0010I\u001a\u0004\bP\u0010K¨\u0006Q"}, d2 = {"Lcom/bytedance/android/window/shop/repository/dto/k0;", "", "", "searchHint", "Ljava/lang/String;", "getSearchHint", "()Ljava/lang/String;", "shopGuideText", "o", "Lcom/bytedance/android/ec/model/response/anchorv3/AuthorReputationDTO;", "reputation", "Lcom/bytedance/android/ec/model/response/anchorv3/AuthorReputationDTO;", "m", "()Lcom/bytedance/android/ec/model/response/anchorv3/AuthorReputationDTO;", "Lcom/bytedance/android/ec/window/base/common/floatelement/WindowCartEntryConfig;", "cartEntryConfig", "Lcom/bytedance/android/ec/window/base/common/floatelement/WindowCartEntryConfig;", "c", "()Lcom/bytedance/android/ec/window/base/common/floatelement/WindowCartEntryConfig;", "setCartEntryConfig", "(Lcom/bytedance/android/ec/window/base/common/floatelement/WindowCartEntryConfig;)V", "orderUrl", "l", "", "shopGuideDisplay", "Ljava/lang/Boolean;", "n", "()Ljava/lang/Boolean;", "setShopGuideDisplay", "(Ljava/lang/Boolean;)V", "Lyn/u;", "liveInfo", "Lyn/u;", "i", "()Lyn/u;", "Lcom/bytedance/android/ec/model/ECUrlModel;", "backgroundImg", "Lcom/bytedance/android/ec/model/ECUrlModel;", "b", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "coverBackgroundRgb", "d", "userAvatarMediumBackgroundRgbId", "q", "", "followStatus", "Ljava/lang/Integer;", "g", "()Ljava/lang/Integer;", "setFollowStatus", "(Ljava/lang/Integer;)V", "nickName", "j", "nickNameSuffix", "k", "avatarMedium", "a", "Lcom/bytedance/android/ec/window/base/shop/WindowFansClubInfo;", "fansClubInfo", "Lcom/bytedance/android/ec/window/base/shop/WindowFansClubInfo;", "f", "()Lcom/bytedance/android/ec/window/base/shop/WindowFansClubInfo;", "windowDetailUrl", "r", "showFollow", "p", "Lcom/bytedance/android/window/shop/repository/dto/y;", "imEntry", "Lcom/bytedance/android/window/shop/repository/dto/y;", "h", "()Lcom/bytedance/android/window/shop/repository/dto/y;", "", "extraParams", "Ljava/util/Map;", "e", "()Ljava/util/Map;", "eventHandlerLynxUrl", "getEventHandlerLynxUrl", "", "windowSplitControl", "s", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class k0 {

    @SerializedName("avatar_medium")
    private final ECUrlModel avatarMedium;

    @SerializedName("cover_url")
    private final ECUrlModel backgroundImg;

    @SerializedName("cart_entry_info")
    private WindowCartEntryConfig cartEntryConfig;

    @SerializedName("cover_background_rgb")
    private final String coverBackgroundRgb;

    @SerializedName("event_handler_lynx_url")
    private final String eventHandlerLynxUrl;

    @SerializedName("extra_params")
    private final Map<String, String> extraParams;

    @SerializedName("fans_club_info")
    private final WindowFansClubInfo fansClubInfo;

    @SerializedName("follow_status")
    private Integer followStatus;

    @SerializedName("im_entry")
    private final y imEntry;

    @SerializedName("live_info")
    private final yn.u liveInfo;

    @SerializedName("nick_name")
    private final String nickName;

    @SerializedName("nick_name_suffix")
    private final String nickNameSuffix;

    @SerializedName("order_url")
    private final String orderUrl;

    @SerializedName("reputation")
    private final AuthorReputationDTO reputation;

    @SerializedName("search_hint")
    private final String searchHint;

    @SerializedName("window_guide_display")
    private Boolean shopGuideDisplay;

    @SerializedName("window_guide_text")
    private final String shopGuideText;

    @SerializedName("window_show_follow_button")
    private final Boolean showFollow;

    @SerializedName("avatar_medium_background_rgb")
    private final String userAvatarMediumBackgroundRgbId;

    @SerializedName("detail_url")
    private final String windowDetailUrl;

    @SerializedName("split_config")
    private final Map<String, List<String>> windowSplitControl;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof k0) == false) goto L48;
        k0 r4 = (k0) r3;
        if (Intrinsics.areEqual(this.searchHint, r4.searchHint) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.shopGuideText, r4.shopGuideText) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.reputation, r4.reputation) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.cartEntryConfig, r4.cartEntryConfig) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.orderUrl, r4.orderUrl) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.shopGuideDisplay, r4.shopGuideDisplay) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.liveInfo, r4.liveInfo) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.backgroundImg, r4.backgroundImg) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.coverBackgroundRgb, r4.coverBackgroundRgb) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.userAvatarMediumBackgroundRgbId, r4.userAvatarMediumBackgroundRgbId) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.followStatus, r4.followStatus) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.nickName, r4.nickName) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.nickNameSuffix, r4.nickNameSuffix) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.avatarMedium, r4.avatarMedium) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.fansClubInfo, r4.fansClubInfo) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.windowDetailUrl, r4.windowDetailUrl) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.showFollow, r4.showFollow) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.imEntry, r4.imEntry) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.extraParams, r4.extraParams) == true) goto L44;
        return false;
    L44:
        if (Intrinsics.areEqual(this.eventHandlerLynxUrl, r4.eventHandlerLynxUrl) == true) goto L46;
        return false;
    L46:
        if (Intrinsics.areEqual(this.windowSplitControl, r4.windowSplitControl) == true) goto L73;
        return false;
    L73:
        return true;
    L48:
        return false;
    }

    public final int hashCode() {
        String r0 = this.searchHint;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.shopGuideText;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        AuthorReputationDTO r7 = this.reputation;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        WindowCartEntryConfig r10 = this.cartEntryConfig;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.orderUrl;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        Boolean r16 = this.shopGuideDisplay;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        yn.u r19 = this.liveInfo;
        if (r19 == null) goto L29;
        int r20 = r19.hashCode();
    L30:
        int r21 = (r18 + r20) * 31;
        ECUrlModel r22 = this.backgroundImg;
        if (r22 == null) goto L33;
        int r23 = r22.hashCode();
    L34:
        int r24 = (r21 + r23) * 31;
        String r25 = this.coverBackgroundRgb;
        if (r25 == null) goto L37;
        int r26 = r25.hashCode();
    L38:
        int r27 = (r24 + r26) * 31;
        String r28 = this.userAvatarMediumBackgroundRgbId;
        if (r28 == null) goto L41;
        int r29 = r28.hashCode();
    L42:
        int r30 = (r27 + r29) * 31;
        Integer r31 = this.followStatus;
        if (r31 == null) goto L45;
        int r32 = r31.hashCode();
    L46:
        int r33 = (r30 + r32) * 31;
        String r34 = this.nickName;
        if (r34 == null) goto L49;
        int r35 = r34.hashCode();
    L50:
        int r36 = (r33 + r35) * 31;
        String r37 = this.nickNameSuffix;
        if (r37 == null) goto L53;
        int r38 = r37.hashCode();
    L54:
        int r39 = (r36 + r38) * 31;
        ECUrlModel r40 = this.avatarMedium;
        if (r40 == null) goto L57;
        int r41 = r40.hashCode();
    L58:
        int r42 = (r39 + r41) * 31;
        WindowFansClubInfo r43 = this.fansClubInfo;
        if (r43 == null) goto L61;
        int r44 = r43.hashCode();
    L62:
        int r45 = (r42 + r44) * 31;
        String r46 = this.windowDetailUrl;
        if (r46 == null) goto L65;
        int r47 = r46.hashCode();
    L66:
        int r48 = (r45 + r47) * 31;
        Boolean r49 = this.showFollow;
        if (r49 == null) goto L69;
        int r50 = r49.hashCode();
    L70:
        int r51 = (r48 + r50) * 31;
        y r52 = this.imEntry;
        if (r52 == null) goto L73;
        int r53 = r52.hashCode();
    L74:
        int r54 = (r51 + r53) * 31;
        Map<String, String> r55 = this.extraParams;
        if (r55 == null) goto L77;
        int r56 = r55.hashCode();
    L78:
        int r57 = (r54 + r56) * 31;
        String r58 = this.eventHandlerLynxUrl;
        if (r58 == null) goto L81;
        int r59 = r58.hashCode();
    L82:
        int r60 = (r57 + r59) * 31;
        Map<String, List<String>> r61 = this.windowSplitControl;
        if (r61 == null) goto L86;
        r1 = r61.hashCode();
    L86:
        return r60 + r1;
    L81:
        r59 = 0;
        goto L82
    L77:
        r56 = 0;
        goto L78
    L73:
        r53 = 0;
        goto L74
    L69:
        r50 = 0;
        goto L70
    L65:
        r47 = 0;
        goto L66
    L61:
        r44 = 0;
        goto L62
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
        return "WindowHeaderOtherInfoDTO(searchHint=" + this.searchHint + ", shopGuideText=" + this.shopGuideText + ", reputation=" + this.reputation + ", cartEntryConfig=" + this.cartEntryConfig + ", orderUrl=" + this.orderUrl + ", shopGuideDisplay=" + this.shopGuideDisplay + ", liveInfo=" + this.liveInfo + ", backgroundImg=" + this.backgroundImg + ", coverBackgroundRgb=" + this.coverBackgroundRgb + ", userAvatarMediumBackgroundRgbId=" + this.userAvatarMediumBackgroundRgbId + ", followStatus=" + this.followStatus + ", nickName=" + this.nickName + ", nickNameSuffix=" + this.nickNameSuffix + ", avatarMedium=" + this.avatarMedium + ", fansClubInfo=" + this.fansClubInfo + ", windowDetailUrl=" + this.windowDetailUrl + ", showFollow=" + this.showFollow + ", imEntry=" + this.imEntry + ", extraParams=" + this.extraParams + ", eventHandlerLynxUrl=" + this.eventHandlerLynxUrl + ", windowSplitControl=" + this.windowSplitControl + ")";
    }

    public k0() {
        Boolean r0 = Boolean.FALSE;
        this.searchHint = null;
        this.shopGuideText = null;
        this.reputation = null;
        this.cartEntryConfig = null;
        this.orderUrl = null;
        this.shopGuideDisplay = null;
        this.liveInfo = null;
        this.backgroundImg = null;
        this.coverBackgroundRgb = null;
        this.userAvatarMediumBackgroundRgbId = null;
        this.followStatus = null;
        this.nickName = null;
        this.nickNameSuffix = null;
        this.avatarMedium = null;
        this.fansClubInfo = null;
        this.windowDetailUrl = null;
        this.showFollow = r0;
        this.imEntry = null;
        this.extraParams = null;
        this.eventHandlerLynxUrl = null;
        this.windowSplitControl = null;
    }

    public final ECUrlModel a() {
        return this.avatarMedium;
    }

    public final ECUrlModel b() {
        return this.backgroundImg;
    }

    public final WindowCartEntryConfig c() {
        return this.cartEntryConfig;
    }

    public final String d() {
        return this.coverBackgroundRgb;
    }

    public final Map<String, String> e() {
        return this.extraParams;
    }

    public final WindowFansClubInfo f() {
        return this.fansClubInfo;
    }

    public final Integer g() {
        return this.followStatus;
    }

    public final y h() {
        return this.imEntry;
    }

    public final yn.u i() {
        return this.liveInfo;
    }

    public final String j() {
        return this.nickName;
    }

    public final String k() {
        return this.nickNameSuffix;
    }

    public final String l() {
        return this.orderUrl;
    }

    public final AuthorReputationDTO m() {
        return this.reputation;
    }

    public final Boolean n() {
        return this.shopGuideDisplay;
    }

    public final String o() {
        return this.shopGuideText;
    }

    public final Boolean p() {
        return this.showFollow;
    }

    public final String q() {
        return this.userAvatarMediumBackgroundRgbId;
    }

    public final String r() {
        return this.windowDetailUrl;
    }

    public final Map<String, List<String>> s() {
        return this.windowSplitControl;
    }
}
