package com.bytedance.android.window.shop.repository.dto;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.anchorv3.AuthorReputationDTO;
import com.bytedance.android.ec.window.base.common.floatelement.WindowCartEntryConfig;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u000f\u001a\u0004\b\u0018\u0010\u0011R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u000f\u001a\u0004\b \u0010\u0011R\u001c\u0010!\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\u0004\u001a\u0004\b\"\u0010\u0006R$\u0010$\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010+\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010*8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u001c\u0010/\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b/\u0010\u0004\u001a\u0004\b0\u0010\u0006R\u001c\u00102\u001a\u0004\u0018\u0001018\u0006X\u0087\u0004¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u001c\u00107\u001a\u0004\u0018\u0001068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\"\u0010<\u001a\n\u0012\u0004\u0012\u00020;\u0018\u00010*8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b<\u0010,\u001a\u0004\b=\u0010.R\u001c\u0010>\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b>\u0010\u0004\u001a\u0004\b?\u0010\u0006R\"\u0010A\u001a\n\u0012\u0004\u0012\u00020@\u0018\u00010*8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bA\u0010,\u001a\u0004\bB\u0010.R\u001c\u0010D\u001a\u0004\u0018\u00010C8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010GR\u001c\u0010H\u001a\u0004\u0018\u00010C8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bH\u0010E\u001a\u0004\bI\u0010GR\u001c\u0010K\u001a\u0004\u0018\u00010J8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N¨\u0006O"}, d2 = {"Lcom/bytedance/android/window/shop/repository/dto/d0;", "", "", "userAvatarMediumBackgroundRgbId", "Ljava/lang/String;", "m", "()Ljava/lang/String;", "userId", "getUserId", "secAuthorId", "getSecAuthorId", "nickName", "i", "Lcom/bytedance/android/ec/model/ECUrlModel;", "avatarMedium", "Lcom/bytedance/android/ec/model/ECUrlModel;", "a", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "Lcom/bytedance/android/ec/model/response/anchorv3/AuthorReputationDTO;", "reputation", "Lcom/bytedance/android/ec/model/response/anchorv3/AuthorReputationDTO;", "k", "()Lcom/bytedance/android/ec/model/response/anchorv3/AuthorReputationDTO;", "backgroundImg", "b", "coverBackgroundRgb", "e", "orderUrl", "j", "shopGuideText", "l", "shopGuideIcon", "getShopGuideIcon", "storeUrl", "getStoreUrl", "Lcom/bytedance/android/ec/window/base/common/floatelement/WindowCartEntryConfig;", "cartEntryConfig", "Lcom/bytedance/android/ec/window/base/common/floatelement/WindowCartEntryConfig;", "d", "()Lcom/bytedance/android/ec/window/base/common/floatelement/WindowCartEntryConfig;", "setCartEntryConfig", "(Lcom/bytedance/android/ec/window/base/common/floatelement/WindowCartEntryConfig;)V", "", "followerUrls", "Ljava/util/List;", "getFollowerUrls", "()Ljava/util/List;", "followerOrderCount", "getFollowerOrderCount", "Lyn/u;", "liveInfo", "Lyn/u;", "h", "()Lyn/u;", "Lcom/bytedance/android/window/shop/repository/dto/x;", "fansInfo", "Lcom/bytedance/android/window/shop/repository/dto/x;", "f", "()Lcom/bytedance/android/window/shop/repository/dto/x;", "Lcom/bytedance/android/window/shop/repository/dto/r0;", "impressionWords", "g", "windowDetailUrl", "n", "Lcom/bytedance/android/window/shop/repository/dto/n;", "bubble", "c", "Lcom/bytedance/android/window/shop/repository/dto/x0;", "fansNumForBuy", "Lcom/bytedance/android/window/shop/repository/dto/x0;", "getFansNumForBuy", "()Lcom/bytedance/android/window/shop/repository/dto/x0;", "salesNum", "getSalesNum", "Lcom/bytedance/android/window/shop/repository/dto/z;", "goodAuthorIcon", "Lcom/bytedance/android/window/shop/repository/dto/z;", "getGoodAuthorIcon", "()Lcom/bytedance/android/window/shop/repository/dto/z;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d0 {

    @SerializedName("avatar_medium")
    private final ECUrlModel avatarMedium;

    @SerializedName("cover_url")
    private final ECUrlModel backgroundImg;

    @SerializedName("bubble")
    private final List<n> bubble;

    @SerializedName("cart_entry_info")
    private WindowCartEntryConfig cartEntryConfig;

    @SerializedName("cover_background_rgb")
    private final String coverBackgroundRgb;

    @SerializedName("fans_info")
    private final x fansInfo;

    @SerializedName("fans_num_for_buy")
    private final x0 fansNumForBuy;

    @SerializedName("follower_order_count")
    private final String followerOrderCount;

    @SerializedName("follower_urls")
    private final List<ECUrlModel> followerUrls;

    @SerializedName("good_author_for_ecom")
    private final z goodAuthorIcon;

    @SerializedName("impression_words")
    private final List<r0> impressionWords;

    @SerializedName("live_info")
    private final yn.u liveInfo;

    @SerializedName("nick_name")
    private final String nickName;

    @SerializedName("order_url")
    private final String orderUrl;

    @SerializedName("reputation")
    private final AuthorReputationDTO reputation;

    @SerializedName("sales_num")
    private final x0 salesNum;

    @SerializedName("sec_author_id")
    private final String secAuthorId;

    @SerializedName("window_guide_icon")
    private final ECUrlModel shopGuideIcon;

    @SerializedName("window_guide_text")
    private final String shopGuideText;

    @SerializedName("store_url")
    private final String storeUrl;

    @SerializedName("avatar_medium_background_rgb")
    private final String userAvatarMediumBackgroundRgbId;

    @SerializedName("user_id")
    private final String userId;

    @SerializedName("detail_url")
    private final String windowDetailUrl;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof d0) == false) goto L52;
        d0 r4 = (d0) r3;
        if (Intrinsics.areEqual(this.userAvatarMediumBackgroundRgbId, r4.userAvatarMediumBackgroundRgbId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.userId, r4.userId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.secAuthorId, r4.secAuthorId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.nickName, r4.nickName) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.avatarMedium, r4.avatarMedium) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.reputation, r4.reputation) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.backgroundImg, r4.backgroundImg) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.coverBackgroundRgb, r4.coverBackgroundRgb) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.orderUrl, r4.orderUrl) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.shopGuideText, r4.shopGuideText) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.shopGuideIcon, r4.shopGuideIcon) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.storeUrl, r4.storeUrl) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.cartEntryConfig, r4.cartEntryConfig) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.followerUrls, r4.followerUrls) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.followerOrderCount, r4.followerOrderCount) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.liveInfo, r4.liveInfo) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.fansInfo, r4.fansInfo) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.impressionWords, r4.impressionWords) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.windowDetailUrl, r4.windowDetailUrl) == true) goto L44;
        return false;
    L44:
        if (Intrinsics.areEqual(this.bubble, r4.bubble) == true) goto L46;
        return false;
    L46:
        if (Intrinsics.areEqual(this.fansNumForBuy, r4.fansNumForBuy) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.salesNum, r4.salesNum) == true) goto L50;
        return false;
    L50:
        if (Intrinsics.areEqual(this.goodAuthorIcon, r4.goodAuthorIcon) == true) goto L79;
        return false;
    L79:
        return true;
    L52:
        return false;
    }

    public final int hashCode() {
        String r0 = this.userAvatarMediumBackgroundRgbId;
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
        String r7 = this.secAuthorId;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.nickName;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        ECUrlModel r13 = this.avatarMedium;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        AuthorReputationDTO r16 = this.reputation;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        ECUrlModel r19 = this.backgroundImg;
        if (r19 == null) goto L29;
        int r20 = r19.hashCode();
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.coverBackgroundRgb;
        if (r22 == null) goto L33;
        int r23 = r22.hashCode();
    L34:
        int r24 = (r21 + r23) * 31;
        String r25 = this.orderUrl;
        if (r25 == null) goto L37;
        int r26 = r25.hashCode();
    L38:
        int r27 = (r24 + r26) * 31;
        String r28 = this.shopGuideText;
        if (r28 == null) goto L41;
        int r29 = r28.hashCode();
    L42:
        int r30 = (r27 + r29) * 31;
        ECUrlModel r31 = this.shopGuideIcon;
        if (r31 == null) goto L45;
        int r32 = r31.hashCode();
    L46:
        int r33 = (r30 + r32) * 31;
        String r34 = this.storeUrl;
        if (r34 == null) goto L49;
        int r35 = r34.hashCode();
    L50:
        int r36 = (r33 + r35) * 31;
        WindowCartEntryConfig r37 = this.cartEntryConfig;
        if (r37 == null) goto L53;
        int r38 = r37.hashCode();
    L54:
        int r39 = (r36 + r38) * 31;
        List<ECUrlModel> r40 = this.followerUrls;
        if (r40 == null) goto L57;
        int r41 = r40.hashCode();
    L58:
        int r42 = (r39 + r41) * 31;
        String r43 = this.followerOrderCount;
        if (r43 == null) goto L61;
        int r44 = r43.hashCode();
    L62:
        int r45 = (r42 + r44) * 31;
        yn.u r46 = this.liveInfo;
        if (r46 == null) goto L65;
        int r47 = r46.hashCode();
    L66:
        int r48 = (r45 + r47) * 31;
        x r49 = this.fansInfo;
        if (r49 == null) goto L69;
        int r50 = r49.hashCode();
    L70:
        int r51 = (r48 + r50) * 31;
        List<r0> r52 = this.impressionWords;
        if (r52 == null) goto L73;
        int r53 = r52.hashCode();
    L74:
        int r54 = (r51 + r53) * 31;
        String r55 = this.windowDetailUrl;
        if (r55 == null) goto L77;
        int r56 = r55.hashCode();
    L78:
        int r57 = (r54 + r56) * 31;
        List<n> r58 = this.bubble;
        if (r58 == null) goto L81;
        int r59 = r58.hashCode();
    L82:
        int r60 = (r57 + r59) * 31;
        x0 r61 = this.fansNumForBuy;
        if (r61 == null) goto L85;
        int r62 = r61.hashCode();
    L86:
        int r63 = (r60 + r62) * 31;
        x0 r64 = this.salesNum;
        if (r64 == null) goto L89;
        int r65 = r64.hashCode();
    L90:
        int r66 = (r63 + r65) * 31;
        z r67 = this.goodAuthorIcon;
        if (r67 == null) goto L94;
        r1 = r67.hashCode();
    L94:
        return r66 + r1;
    L89:
        r65 = 0;
        goto L90
    L85:
        r62 = 0;
        goto L86
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
        return "WindowHeaderBaseInfoDTO(userAvatarMediumBackgroundRgbId=" + this.userAvatarMediumBackgroundRgbId + ", userId=" + this.userId + ", secAuthorId=" + this.secAuthorId + ", nickName=" + this.nickName + ", avatarMedium=" + this.avatarMedium + ", reputation=" + this.reputation + ", backgroundImg=" + this.backgroundImg + ", coverBackgroundRgb=" + this.coverBackgroundRgb + ", orderUrl=" + this.orderUrl + ", shopGuideText=" + this.shopGuideText + ", shopGuideIcon=" + this.shopGuideIcon + ", storeUrl=" + this.storeUrl + ", cartEntryConfig=" + this.cartEntryConfig + ", followerUrls=" + this.followerUrls + ", followerOrderCount=" + this.followerOrderCount + ", liveInfo=" + this.liveInfo + ", fansInfo=" + this.fansInfo + ", impressionWords=" + this.impressionWords + ", windowDetailUrl=" + this.windowDetailUrl + ", bubble=" + this.bubble + ", fansNumForBuy=" + this.fansNumForBuy + ", salesNum=" + this.salesNum + ", goodAuthorIcon=" + this.goodAuthorIcon + ")";
    }

    public d0() {
        this.userAvatarMediumBackgroundRgbId = null;
        this.userId = null;
        this.secAuthorId = null;
        this.nickName = null;
        this.avatarMedium = null;
        this.reputation = null;
        this.backgroundImg = null;
        this.coverBackgroundRgb = null;
        this.orderUrl = null;
        this.shopGuideText = null;
        this.shopGuideIcon = null;
        this.storeUrl = null;
        this.cartEntryConfig = null;
        this.followerUrls = null;
        this.followerOrderCount = null;
        this.liveInfo = null;
        this.fansInfo = null;
        this.impressionWords = null;
        this.windowDetailUrl = null;
        this.bubble = null;
        this.fansNumForBuy = null;
        this.salesNum = null;
        this.goodAuthorIcon = null;
    }

    public final ECUrlModel a() {
        return this.avatarMedium;
    }

    public final ECUrlModel b() {
        return this.backgroundImg;
    }

    public final List<n> c() {
        return this.bubble;
    }

    public final WindowCartEntryConfig d() {
        return this.cartEntryConfig;
    }

    public final String e() {
        return this.coverBackgroundRgb;
    }

    public final x f() {
        return this.fansInfo;
    }

    public final List<r0> g() {
        return this.impressionWords;
    }

    public final yn.u h() {
        return this.liveInfo;
    }

    public final String i() {
        return this.nickName;
    }

    public final String j() {
        return this.orderUrl;
    }

    public final AuthorReputationDTO k() {
        return this.reputation;
    }

    public final String l() {
        return this.shopGuideText;
    }

    public final String m() {
        return this.userAvatarMediumBackgroundRgbId;
    }

    public final String n() {
        return this.windowDetailUrl;
    }
}
