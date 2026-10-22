package com.bytedance.android.window.shop.repository.dto;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.window.base.shop.WindowFansClubInfo;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR$\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010$\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010\u001f\u001a\u0004\b%\u0010!\"\u0004\b&\u0010#R$\u0010'\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010\u000b\u001a\u0004\b(\u0010\r\"\u0004\b)\u0010\u000f¨\u0006*"}, d2 = {"Lcom/bytedance/android/window/shop/repository/dto/g0;", "", "", "followStatus", "Ljava/lang/Integer;", "b", "()Ljava/lang/Integer;", "setFollowStatus", "(Ljava/lang/Integer;)V", "", "windowGuideDisplay", "Ljava/lang/Boolean;", "e", "()Ljava/lang/Boolean;", "setWindowGuideDisplay", "(Ljava/lang/Boolean;)V", "showSearch", "getShowSearch", "setShowSearch", "showFollow", "d", "setShowFollow", "Lcom/bytedance/android/ec/window/base/shop/WindowFansClubInfo;", "fansInfo", "Lcom/bytedance/android/ec/window/base/shop/WindowFansClubInfo;", "a", "()Lcom/bytedance/android/ec/window/base/shop/WindowFansClubInfo;", "setFansInfo", "(Lcom/bytedance/android/ec/window/base/shop/WindowFansClubInfo;)V", "Lcom/bytedance/android/ec/model/ECUrlModel;", "followButtonBubble", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getFollowButtonBubble", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "setFollowButtonBubble", "(Lcom/bytedance/android/ec/model/ECUrlModel;)V", "fansRedPackBubble", "getFansRedPackBubble", "setFansRedPackBubble", "newReputationStyle", "c", "setNewReputationStyle", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class g0 {

    @SerializedName("fans_info")
    private WindowFansClubInfo fansInfo;

    @SerializedName("fans_redpack_apply_bubble")
    private ECUrlModel fansRedPackBubble;

    @SerializedName("follow_button_bubble")
    private ECUrlModel followButtonBubble;

    @SerializedName("follow_status")
    private Integer followStatus;

    @SerializedName("new_reputation_style")
    private Boolean newReputationStyle;

    @SerializedName("window_show_follow_button")
    private Boolean showFollow;

    @SerializedName("show_search")
    private Boolean showSearch;

    @SerializedName("window_guide_display")
    private Boolean windowGuideDisplay;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof g0) == false) goto L22;
        g0 r4 = (g0) r3;
        if (Intrinsics.areEqual(this.followStatus, r4.followStatus) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.windowGuideDisplay, r4.windowGuideDisplay) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.showSearch, r4.showSearch) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.showFollow, r4.showFollow) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.fansInfo, r4.fansInfo) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.followButtonBubble, r4.followButtonBubble) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.fansRedPackBubble, r4.fansRedPackBubble) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.newReputationStyle, r4.newReputationStyle) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public final int hashCode() {
        Integer r0 = this.followStatus;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Boolean r4 = this.windowGuideDisplay;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Boolean r7 = this.showSearch;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Boolean r10 = this.showFollow;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        WindowFansClubInfo r13 = this.fansInfo;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        ECUrlModel r16 = this.followButtonBubble;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        ECUrlModel r19 = this.fansRedPackBubble;
        if (r19 == null) goto L29;
        int r20 = r19.hashCode();
    L30:
        int r21 = (r18 + r20) * 31;
        Boolean r22 = this.newReputationStyle;
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
        return "WindowHeaderControlDTO(followStatus=" + this.followStatus + ", windowGuideDisplay=" + this.windowGuideDisplay + ", showSearch=" + this.showSearch + ", showFollow=" + this.showFollow + ", fansInfo=" + this.fansInfo + ", followButtonBubble=" + this.followButtonBubble + ", fansRedPackBubble=" + this.fansRedPackBubble + ", newReputationStyle=" + this.newReputationStyle + ")";
    }

    public g0() {
        Boolean r0 = Boolean.FALSE;
        this.followStatus = null;
        this.windowGuideDisplay = null;
        this.showSearch = r0;
        this.showFollow = r0;
        this.fansInfo = null;
        this.followButtonBubble = null;
        this.fansRedPackBubble = null;
        this.newReputationStyle = r0;
    }

    public final WindowFansClubInfo a() {
        return this.fansInfo;
    }

    public final Integer b() {
        return this.followStatus;
    }

    public final Boolean c() {
        return this.newReputationStyle;
    }

    public final Boolean d() {
        return this.showFollow;
    }

    public final Boolean e() {
        return this.windowGuideDisplay;
    }
}
