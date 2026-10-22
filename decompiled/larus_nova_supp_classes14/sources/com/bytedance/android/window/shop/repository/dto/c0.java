package com.bytedance.android.window.shop.repository.dto;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.anchorv3.AuthorReputationDTO;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R$\u0010#\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R$\u0010)\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010\t\u001a\u0004\b*\u0010\u000b\"\u0004\b+\u0010,R\u001c\u0010.\u001a\u0004\u0018\u00010-8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R*\u00104\u001a\n\u0012\u0004\u0012\u000203\u0018\u0001028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R*\u0010;\u001a\n\u0012\u0004\u0012\u00020:\u0018\u0001028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b;\u00105\u001a\u0004\b<\u00107\"\u0004\b=\u00109R*\u0010>\u001a\n\u0012\u0004\u0012\u00020:\u0018\u0001028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b>\u00105\u001a\u0004\b?\u00107\"\u0004\b@\u00109R*\u0010A\u001a\n\u0012\u0004\u0012\u00020:\u0018\u0001028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bA\u00105\u001a\u0004\bB\u00107\"\u0004\bC\u00109R\u001c\u0010E\u001a\u0004\u0018\u00010D8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bG\u0010HR\u001c\u0010I\u001a\u0004\u0018\u00010D8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bI\u0010F\u001a\u0004\bJ\u0010HR$\u0010K\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bK\u0010\t\u001a\u0004\bL\u0010\u000b\"\u0004\bM\u0010,R\u001c\u0010N\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\bN\u0010\u0004\u001a\u0004\bO\u0010\u0006¨\u0006P"}, d2 = {"Lcom/bytedance/android/window/shop/repository/dto/c0;", "", "", "nickName", "Ljava/lang/String;", "getNickName", "()Ljava/lang/String;", "Lcom/bytedance/android/ec/model/ECUrlModel;", "avatarMedium", "Lcom/bytedance/android/ec/model/ECUrlModel;", "b", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "followerOrderCount", "getFollowerOrderCount", "Lcom/bytedance/android/window/shop/repository/dto/e;", "rankInfo", "Lcom/bytedance/android/window/shop/repository/dto/e;", "n", "()Lcom/bytedance/android/window/shop/repository/dto/e;", "Lcom/bytedance/android/ec/model/response/anchorv3/AuthorReputationDTO;", "reputation", "Lcom/bytedance/android/ec/model/response/anchorv3/AuthorReputationDTO;", "o", "()Lcom/bytedance/android/ec/model/response/anchorv3/AuthorReputationDTO;", "Lcom/bytedance/android/window/shop/repository/dto/s0;", "levelInfo", "Lcom/bytedance/android/window/shop/repository/dto/s0;", "m", "()Lcom/bytedance/android/window/shop/repository/dto/s0;", "Lcom/bytedance/android/window/shop/repository/dto/x;", "fansInfo", "Lcom/bytedance/android/window/shop/repository/dto/x;", "d", "()Lcom/bytedance/android/window/shop/repository/dto/x;", "", "newReputationStyle", "Ljava/lang/Boolean;", "getNewReputationStyle", "()Ljava/lang/Boolean;", "setNewReputationStyle", "(Ljava/lang/Boolean;)V", "followButtonBubble", "f", "setFollowButtonBubble", "(Lcom/bytedance/android/ec/model/ECUrlModel;)V", "", "followStatus", "Ljava/lang/Integer;", "g", "()Ljava/lang/Integer;", "", "Lcom/bytedance/android/window/shop/repository/dto/x0;", "guideInfo", "Ljava/util/List;", "i", "()Ljava/util/List;", "setGuideInfo", "(Ljava/util/List;)V", "Lcom/bytedance/android/window/shop/repository/dto/m;", "guideInfoTop", "l", "setGuideInfoTop", "guideInfoSelfIntro", "k", "setGuideInfoSelfIntro", "guideInfoBottom", "j", "setGuideInfoBottom", "Lcom/bytedance/android/window/shop/repository/dto/z;", "authorNameIcon", "Lcom/bytedance/android/window/shop/repository/dto/z;", "a", "()Lcom/bytedance/android/window/shop/repository/dto/z;", "goodAuthorIcon", "h", "fansRedPackBubble", "e", "setFansRedPackBubble", "fansAmountDes", "c", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c0 {

    @SerializedName("author_name_icon")
    private final z authorNameIcon;

    @SerializedName("avatar_medium")
    private final ECUrlModel avatarMedium;

    @SerializedName("fans_amount_des")
    private final String fansAmountDes;

    @SerializedName("fans_info")
    private final x fansInfo;

    @SerializedName("fans_redpack_apply_bubble")
    private ECUrlModel fansRedPackBubble;

    @SerializedName("follow_button_bubble")
    private ECUrlModel followButtonBubble;

    @SerializedName("follow_status")
    private final Integer followStatus;

    @SerializedName("follower_order_count")
    private final String followerOrderCount;

    @SerializedName("good_author_for_ecom")
    private final z goodAuthorIcon;

    @SerializedName("guide_info")
    private List<x0> guideInfo;

    @SerializedName("author_guide_info_bottom")
    private List<m> guideInfoBottom;

    @SerializedName("author_guide_info_self_intro")
    private List<m> guideInfoSelfIntro;

    @SerializedName("author_guide_info_top")
    private List<m> guideInfoTop;

    @SerializedName("level_info")
    private final s0 levelInfo;

    @SerializedName("new_reputation_style")
    private Boolean newReputationStyle;

    @SerializedName("nick_name")
    private final String nickName;

    @SerializedName("rank_info")
    private final e rankInfo;

    @SerializedName("reputation")
    private final AuthorReputationDTO reputation;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof c0) == false) goto L42;
        c0 r4 = (c0) r3;
        if (Intrinsics.areEqual(this.nickName, r4.nickName) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.avatarMedium, r4.avatarMedium) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.followerOrderCount, r4.followerOrderCount) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.rankInfo, r4.rankInfo) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.reputation, r4.reputation) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.levelInfo, r4.levelInfo) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.fansInfo, r4.fansInfo) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.newReputationStyle, r4.newReputationStyle) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.followButtonBubble, r4.followButtonBubble) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.followStatus, r4.followStatus) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.guideInfo, r4.guideInfo) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.guideInfoTop, r4.guideInfoTop) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.guideInfoSelfIntro, r4.guideInfoSelfIntro) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.guideInfoBottom, r4.guideInfoBottom) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.authorNameIcon, r4.authorNameIcon) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.goodAuthorIcon, r4.goodAuthorIcon) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.fansRedPackBubble, r4.fansRedPackBubble) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.fansAmountDes, r4.fansAmountDes) == true) goto L64;
        return false;
    L64:
        return true;
    L42:
        return false;
    }

    public final int hashCode() {
        String r0 = this.nickName;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        ECUrlModel r4 = this.avatarMedium;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.followerOrderCount;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        e r10 = this.rankInfo;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        AuthorReputationDTO r13 = this.reputation;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        s0 r16 = this.levelInfo;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        x r19 = this.fansInfo;
        if (r19 == null) goto L29;
        int r20 = r19.hashCode();
    L30:
        int r21 = (r18 + r20) * 31;
        Boolean r22 = this.newReputationStyle;
        if (r22 == null) goto L33;
        int r23 = r22.hashCode();
    L34:
        int r24 = (r21 + r23) * 31;
        ECUrlModel r25 = this.followButtonBubble;
        if (r25 == null) goto L37;
        int r26 = r25.hashCode();
    L38:
        int r27 = (r24 + r26) * 31;
        Integer r28 = this.followStatus;
        if (r28 == null) goto L41;
        int r29 = r28.hashCode();
    L42:
        int r30 = (r27 + r29) * 31;
        List<x0> r31 = this.guideInfo;
        if (r31 == null) goto L45;
        int r32 = r31.hashCode();
    L46:
        int r33 = (r30 + r32) * 31;
        List<m> r34 = this.guideInfoTop;
        if (r34 == null) goto L49;
        int r35 = r34.hashCode();
    L50:
        int r36 = (r33 + r35) * 31;
        List<m> r37 = this.guideInfoSelfIntro;
        if (r37 == null) goto L53;
        int r38 = r37.hashCode();
    L54:
        int r39 = (r36 + r38) * 31;
        List<m> r40 = this.guideInfoBottom;
        if (r40 == null) goto L57;
        int r41 = r40.hashCode();
    L58:
        int r42 = (r39 + r41) * 31;
        z r43 = this.authorNameIcon;
        if (r43 == null) goto L61;
        int r44 = r43.hashCode();
    L62:
        int r45 = (r42 + r44) * 31;
        z r46 = this.goodAuthorIcon;
        if (r46 == null) goto L65;
        int r47 = r46.hashCode();
    L66:
        int r48 = (r45 + r47) * 31;
        ECUrlModel r49 = this.fansRedPackBubble;
        if (r49 == null) goto L69;
        int r50 = r49.hashCode();
    L70:
        int r51 = (r48 + r50) * 31;
        String r52 = this.fansAmountDes;
        if (r52 == null) goto L74;
        r1 = r52.hashCode();
    L74:
        return r51 + r1;
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
        return "WindowHeaderAuthorInfoDTO(nickName=" + this.nickName + ", avatarMedium=" + this.avatarMedium + ", followerOrderCount=" + this.followerOrderCount + ", rankInfo=" + this.rankInfo + ", reputation=" + this.reputation + ", levelInfo=" + this.levelInfo + ", fansInfo=" + this.fansInfo + ", newReputationStyle=" + this.newReputationStyle + ", followButtonBubble=" + this.followButtonBubble + ", followStatus=" + this.followStatus + ", guideInfo=" + this.guideInfo + ", guideInfoTop=" + this.guideInfoTop + ", guideInfoSelfIntro=" + this.guideInfoSelfIntro + ", guideInfoBottom=" + this.guideInfoBottom + ", authorNameIcon=" + this.authorNameIcon + ", goodAuthorIcon=" + this.goodAuthorIcon + ", fansRedPackBubble=" + this.fansRedPackBubble + ", fansAmountDes=" + this.fansAmountDes + ")";
    }

    public c0() {
        Boolean r0 = Boolean.FALSE;
        this.nickName = null;
        this.avatarMedium = null;
        this.followerOrderCount = null;
        this.rankInfo = null;
        this.reputation = null;
        this.levelInfo = null;
        this.fansInfo = null;
        this.newReputationStyle = r0;
        this.followButtonBubble = null;
        this.followStatus = null;
        this.guideInfo = null;
        this.guideInfoTop = null;
        this.guideInfoSelfIntro = null;
        this.guideInfoBottom = null;
        this.authorNameIcon = null;
        this.goodAuthorIcon = null;
        this.fansRedPackBubble = null;
        this.fansAmountDes = null;
    }

    public final z a() {
        return this.authorNameIcon;
    }

    public final ECUrlModel b() {
        return this.avatarMedium;
    }

    public final String c() {
        return this.fansAmountDes;
    }

    public final x d() {
        return this.fansInfo;
    }

    public final ECUrlModel e() {
        return this.fansRedPackBubble;
    }

    public final ECUrlModel f() {
        return this.followButtonBubble;
    }

    public final Integer g() {
        return this.followStatus;
    }

    public final z h() {
        return this.goodAuthorIcon;
    }

    public final List<x0> i() {
        return this.guideInfo;
    }

    public final List<m> j() {
        return this.guideInfoBottom;
    }

    public final List<m> k() {
        return this.guideInfoSelfIntro;
    }

    public final List<m> l() {
        return this.guideInfoTop;
    }

    public final s0 m() {
        return this.levelInfo;
    }

    public final e n() {
        return this.rankInfo;
    }

    public final AuthorReputationDTO o() {
        return this.reputation;
    }
}
