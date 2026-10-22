package com.bytedance.android.window.shop.repository.vo;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.window.base.shop.WindowFansClubInfo;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b+\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005¢\u0006\u0002\u0010\u000eJ\u0010\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010#J\u0010\u0010-\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010#J\t\u0010.\u001a\u00020\u0005HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u00102\u001a\u00020\u0005HÆ\u0003Jj\u00103\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\r\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u00104J\u0013\u00105\u001a\u00020\u00052\b\u00106\u001a\u0004\u0018\u000107HÖ\u0003J\t\u00108\u001a\u00020\u0003HÖ\u0001J\t\u00109\u001a\u00020:HÖ\u0001R \u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001f\"\u0004\b(\u0010!R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\b)\u0010#\"\u0004\b*\u0010%¨\u0006;"}, d2 = {"Lcom/bytedance/android/window/shop/repository/vo/ShopHeaderControlVO;", "Ljava/io/Serializable;", "followStatus", "", "shopGuideDisplay", "", "showSearch", "showFollow", "fansClubInfo", "Lcom/bytedance/android/ec/window/base/shop/WindowFansClubInfo;", "followButtonBubble", "Lcom/bytedance/android/ec/model/ECUrlModel;", "fansRedPackBubble", "newReputationStyle", "(Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;ZLcom/bytedance/android/ec/window/base/shop/WindowFansClubInfo;Lcom/bytedance/android/ec/model/ECUrlModel;Lcom/bytedance/android/ec/model/ECUrlModel;Z)V", "getFansClubInfo", "()Lcom/bytedance/android/ec/window/base/shop/WindowFansClubInfo;", "setFansClubInfo", "(Lcom/bytedance/android/ec/window/base/shop/WindowFansClubInfo;)V", "getFansRedPackBubble", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "setFansRedPackBubble", "(Lcom/bytedance/android/ec/model/ECUrlModel;)V", "getFollowButtonBubble", "setFollowButtonBubble", "getFollowStatus", "()Ljava/lang/Integer;", "setFollowStatus", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getNewReputationStyle", "()Z", "setNewReputationStyle", "(Z)V", "getShopGuideDisplay", "()Ljava/lang/Boolean;", "setShopGuideDisplay", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getShowFollow", "setShowFollow", "getShowSearch", "setShowSearch", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;ZLcom/bytedance/android/ec/window/base/shop/WindowFansClubInfo;Lcom/bytedance/android/ec/model/ECUrlModel;Lcom/bytedance/android/ec/model/ECUrlModel;Z)Lcom/bytedance/android/window/shop/repository/vo/ShopHeaderControlVO;", "equals", "other", "", "hashCode", "toString", "", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShopHeaderControlVO implements Serializable {

    @SerializedName("fans_club_info")
    private WindowFansClubInfo fansClubInfo;
    private ECUrlModel fansRedPackBubble;
    private ECUrlModel followButtonBubble;
    private Integer followStatus;
    private boolean newReputationStyle;
    private Boolean shopGuideDisplay;
    private boolean showFollow;
    private Boolean showSearch;

    public ShopHeaderControlVO() {
        this(null, null, null, false, null, null, null, false, 255, null);
    }

    public static /* synthetic */ ShopHeaderControlVO copy$default(ShopHeaderControlVO r9, Integer r10, Boolean r11, Boolean r12, boolean r13, WindowFansClubInfo r14, ECUrlModel r15, ECUrlModel r16, boolean r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        Integer r2 = r9.followStatus;
    L7:
        if ((r18 & 2) == 0) goto L9;
        Boolean r3 = r9.shopGuideDisplay;
    L11:
        if ((r18 & 4) == 0) goto L13;
        Boolean r4 = r9.showSearch;
    L15:
        if ((r18 & 8) == 0) goto L17;
        boolean r5 = r9.showFollow;
    L19:
        if ((r18 & 16) == 0) goto L21;
        WindowFansClubInfo r6 = r9.fansClubInfo;
    L23:
        if ((r18 & 32) == 0) goto L25;
        ECUrlModel r7 = r9.followButtonBubble;
    L27:
        if ((r18 & 64) == 0) goto L29;
        ECUrlModel r8 = r9.fansRedPackBubble;
    L31:
        if ((r18 & 128) == 0) goto L33;
        boolean r1 = r9.newReputationStyle;
    L35:
        return r9.copy(r2, r3, r4, r5, r6, r7, r8, r1);
    L33:
        r1 = r17;
        goto L35
    L29:
        r8 = r16;
        goto L31
    L25:
        r7 = r15;
        goto L27
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r2 = r10;
        goto L7
    }

    public final Integer component1() {
        return this.followStatus;
    }

    public final Boolean component2() {
        return this.shopGuideDisplay;
    }

    public final Boolean component3() {
        return this.showSearch;
    }

    public final boolean component4() {
        return this.showFollow;
    }

    public final WindowFansClubInfo component5() {
        return this.fansClubInfo;
    }

    public final ECUrlModel component6() {
        return this.followButtonBubble;
    }

    public final ECUrlModel component7() {
        return this.fansRedPackBubble;
    }

    public final boolean component8() {
        return this.newReputationStyle;
    }

    public final ShopHeaderControlVO copy(Integer r11, Boolean r12, Boolean r13, boolean r14, WindowFansClubInfo r15, ECUrlModel r16, ECUrlModel r17, boolean r18) {
        return new ShopHeaderControlVO(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof ShopHeaderControlVO) == false) goto L22;
        ShopHeaderControlVO r4 = (ShopHeaderControlVO) r3;
        if (Intrinsics.areEqual(this.followStatus, r4.followStatus) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.shopGuideDisplay, r4.shopGuideDisplay) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.showSearch, r4.showSearch) == true) goto L12;
        return false;
    L12:
        if (this.showFollow == r4.showFollow) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.fansClubInfo, r4.fansClubInfo) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.followButtonBubble, r4.followButtonBubble) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.fansRedPackBubble, r4.fansRedPackBubble) == true) goto L20;
        return false;
    L20:
        if (this.newReputationStyle == r4.newReputationStyle) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        Integer r0 = this.followStatus;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Boolean r4 = this.shopGuideDisplay;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Boolean r7 = this.showSearch;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        boolean r10 = this.showFollow;
        ?? r11 = 1;
        ?? r12 = r10;
        if (r10 == false) goto L17;
        r12 = 1;
    L17:
        int r13 = (r9 + r12) * 31;
        WindowFansClubInfo r14 = this.fansClubInfo;
        if (r14 == null) goto L20;
        int r15 = r14.hashCode();
    L21:
        int r16 = (r13 + r15) * 31;
        ECUrlModel r17 = this.followButtonBubble;
        if (r17 == null) goto L24;
        int r18 = r17.hashCode();
    L25:
        int r19 = (r16 + r18) * 31;
        ECUrlModel r20 = this.fansRedPackBubble;
        if (r20 == null) goto L28;
        r1 = r20.hashCode();
    L28:
        int r21 = (r19 + r1) * 31;
        boolean r22 = this.newReputationStyle;
        if (r22 == true) goto L33;
        r11 = r22;
    L33:
        return r21 + r11;
    L24:
        r18 = 0;
        goto L25
    L20:
        r15 = 0;
        goto L21
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
        return "ShopHeaderControlVO(followStatus=" + this.followStatus + ", shopGuideDisplay=" + this.shopGuideDisplay + ", showSearch=" + this.showSearch + ", showFollow=" + this.showFollow + ", fansClubInfo=" + this.fansClubInfo + ", followButtonBubble=" + this.followButtonBubble + ", fansRedPackBubble=" + this.fansRedPackBubble + ", newReputationStyle=" + this.newReputationStyle + ")";
    }

    public final WindowFansClubInfo getFansClubInfo() {
        return this.fansClubInfo;
    }

    public final ECUrlModel getFansRedPackBubble() {
        return this.fansRedPackBubble;
    }

    public final ECUrlModel getFollowButtonBubble() {
        return this.followButtonBubble;
    }

    public final Integer getFollowStatus() {
        return this.followStatus;
    }

    public final boolean getNewReputationStyle() {
        return this.newReputationStyle;
    }

    public final Boolean getShopGuideDisplay() {
        return this.shopGuideDisplay;
    }

    public final boolean getShowFollow() {
        return this.showFollow;
    }

    public final Boolean getShowSearch() {
        return this.showSearch;
    }

    public final void setFansClubInfo(WindowFansClubInfo r1) {
        this.fansClubInfo = r1;
    }

    public final void setFansRedPackBubble(ECUrlModel r1) {
        this.fansRedPackBubble = r1;
    }

    public final void setFollowButtonBubble(ECUrlModel r1) {
        this.followButtonBubble = r1;
    }

    public final void setFollowStatus(Integer r1) {
        this.followStatus = r1;
    }

    public final void setNewReputationStyle(boolean r1) {
        this.newReputationStyle = r1;
    }

    public final void setShopGuideDisplay(Boolean r1) {
        this.shopGuideDisplay = r1;
    }

    public final void setShowFollow(boolean r1) {
        this.showFollow = r1;
    }

    public final void setShowSearch(Boolean r1) {
        this.showSearch = r1;
    }

    public ShopHeaderControlVO(Integer r1, Boolean r2, Boolean r3, boolean r4, WindowFansClubInfo r5, ECUrlModel r6, ECUrlModel r7, boolean r8) {
        this.followStatus = r1;
        this.shopGuideDisplay = r2;
        this.showSearch = r3;
        this.showFollow = r4;
        this.fansClubInfo = r5;
        this.followButtonBubble = r6;
        this.fansRedPackBubble = r7;
        this.newReputationStyle = r8;
    }

    public /* synthetic */ ShopHeaderControlVO(Integer r11, Boolean r12, Boolean r13, boolean r14, WindowFansClubInfo r15, ECUrlModel r16, ECUrlModel r17, boolean r18, int r19, DefaultConstructorMarker r20) {
        ECUrlModel r2 = null;
        if ((r19 & 1) == 0) goto L5;
        Integer r1 = null;
    L7:
        if ((r19 & 2) == 0) goto L9;
        Boolean r3 = null;
    L11:
        if ((r19 & 4) == 0) goto L13;
        Boolean r4 = Boolean.FALSE;
    L14:
        boolean r6 = false;
        if ((r19 & 8) == 0) goto L17;
        boolean r5 = false;
    L19:
        if ((r19 & 16) == 0) goto L21;
        WindowFansClubInfo r7 = null;
    L23:
        if ((r19 & 32) == 0) goto L25;
        ECUrlModel r8 = null;
    L27:
        if ((r19 & 64) != 0) goto L31;
        r2 = r17;
    L31:
        if ((r19 & 128) != 0) goto L34;
        r6 = r18;
    L34:
        this(r1, r3, r4, r5, r7, r8, r2, r6);
        return;
    L25:
        r8 = r16;
        goto L27
    L21:
        r7 = r15;
        goto L23
    L17:
        r5 = r14;
        goto L19
    L13:
        r4 = r13;
        goto L14
    L9:
        r3 = r12;
        goto L11
    L5:
        r1 = r11;
        goto L7
    }
}
