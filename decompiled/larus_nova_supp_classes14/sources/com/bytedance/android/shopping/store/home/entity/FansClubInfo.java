package com.bytedance.android.shopping.store.home.entity;

import com.bytedance.android.shopping.store.repository.dto.StoreFollowGiftConfig;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010(\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\fHÆ\u0003JR\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010,J\u0006\u0010-\u001a\u00020\u0000J\u0013\u0010.\u001a\u00020\u00032\b\u0010/\u001a\u0004\u0018\u000100HÖ\u0003J\t\u00101\u001a\u00020\u0006HÖ\u0001J\t\u00102\u001a\u00020\bHÖ\u0001R \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R \u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010 \"\u0004\b$\u0010\"¨\u00063"}, d2 = {"Lcom/bytedance/android/shopping/store/home/entity/FansClubInfo;", "Ljava/io/Serializable;", "openFansClub", "", "joinStatus", "fansClubLevel", "", "fansClubUrl", "", "fansClubBubbleConfig", "Lcom/bytedance/android/shopping/store/home/entity/FansClubBubbleConfig;", "fansClubCouponConfig", "Lcom/bytedance/android/shopping/store/repository/dto/StoreFollowGiftConfig;", "(ZZLjava/lang/Integer;Ljava/lang/String;Lcom/bytedance/android/shopping/store/home/entity/FansClubBubbleConfig;Lcom/bytedance/android/shopping/store/repository/dto/StoreFollowGiftConfig;)V", "getFansClubBubbleConfig", "()Lcom/bytedance/android/shopping/store/home/entity/FansClubBubbleConfig;", "setFansClubBubbleConfig", "(Lcom/bytedance/android/shopping/store/home/entity/FansClubBubbleConfig;)V", "getFansClubCouponConfig", "()Lcom/bytedance/android/shopping/store/repository/dto/StoreFollowGiftConfig;", "setFansClubCouponConfig", "(Lcom/bytedance/android/shopping/store/repository/dto/StoreFollowGiftConfig;)V", "getFansClubLevel", "()Ljava/lang/Integer;", "setFansClubLevel", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getFansClubUrl", "()Ljava/lang/String;", "setFansClubUrl", "(Ljava/lang/String;)V", "getJoinStatus", "()Z", "setJoinStatus", "(Z)V", "getOpenFansClub", "setOpenFansClub", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(ZZLjava/lang/Integer;Ljava/lang/String;Lcom/bytedance/android/shopping/store/home/entity/FansClubBubbleConfig;Lcom/bytedance/android/shopping/store/repository/dto/StoreFollowGiftConfig;)Lcom/bytedance/android/shopping/store/home/entity/FansClubInfo;", "deepCopy", "equals", "other", "", "hashCode", "toString", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FansClubInfo implements Serializable {

    @SerializedName("fans_config")
    private FansClubBubbleConfig fansClubBubbleConfig;

    @SerializedName("fans_club_coupon_config")
    private StoreFollowGiftConfig fansClubCouponConfig;

    @SerializedName("fans_club_level")
    private Integer fansClubLevel;

    @SerializedName("fans_club_url")
    private String fansClubUrl;

    @SerializedName("join_status")
    private boolean joinStatus;

    @SerializedName("open_fans_club")
    private boolean openFansClub;

    public FansClubInfo() {
        this(false, false, null, null, null, null, 63, null);
    }

    public static /* synthetic */ FansClubInfo copy$default(FansClubInfo r4, boolean r5, boolean r6, Integer r7, String r8, FansClubBubbleConfig r9, StoreFollowGiftConfig r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.openFansClub;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.joinStatus;
    L8:
        boolean r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.fansClubLevel;
    L11:
        Integer r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.fansClubUrl;
    L14:
        String r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.fansClubBubbleConfig;
    L17:
        FansClubBubbleConfig r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.fansClubCouponConfig;
    L20:
        boolean r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final boolean component1() {
        return this.openFansClub;
    }

    public final boolean component2() {
        return this.joinStatus;
    }

    public final Integer component3() {
        return this.fansClubLevel;
    }

    public final String component4() {
        return this.fansClubUrl;
    }

    public final FansClubBubbleConfig component5() {
        return this.fansClubBubbleConfig;
    }

    public final StoreFollowGiftConfig component6() {
        return this.fansClubCouponConfig;
    }

    public final FansClubInfo copy(boolean r9, boolean r10, Integer r11, String r12, FansClubBubbleConfig r13, StoreFollowGiftConfig r14) {
        return new FansClubInfo(r9, r10, r11, r12, r13, r14);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof FansClubInfo) == false) goto L18;
        FansClubInfo r4 = (FansClubInfo) r3;
        if (this.openFansClub == r4.openFansClub) goto L8;
        return false;
    L8:
        if (this.joinStatus == r4.joinStatus) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.fansClubLevel, r4.fansClubLevel) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.fansClubUrl, r4.fansClubUrl) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.fansClubBubbleConfig, r4.fansClubBubbleConfig) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.fansClubCouponConfig, r4.fansClubCouponConfig) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v15 */
    public int hashCode() {
        boolean r0 = this.openFansClub;
        ?? r1 = 1;
        ?? r2 = r0;
        if (r0 == false) goto L5;
        r2 = 1;
    L5:
        int r3 = r2 * 31;
        boolean r4 = this.joinStatus;
        if (r4 == true) goto L9;
        r1 = r4;
    L9:
        int r5 = (r3 + r1) * 31;
        Integer r6 = this.fansClubLevel;
        int r7 = 0;
        if (r6 == null) goto L12;
        int r8 = r6.hashCode();
    L13:
        int r9 = (r5 + r8) * 31;
        String r10 = this.fansClubUrl;
        if (r10 == null) goto L16;
        int r11 = r10.hashCode();
    L17:
        int r12 = (r9 + r11) * 31;
        FansClubBubbleConfig r13 = this.fansClubBubbleConfig;
        if (r13 == null) goto L20;
        int r14 = r13.hashCode();
    L21:
        int r15 = (r12 + r14) * 31;
        StoreFollowGiftConfig r16 = this.fansClubCouponConfig;
        if (r16 == null) goto L25;
        r7 = r16.hashCode();
    L25:
        return r15 + r7;
    L20:
        r14 = 0;
        goto L21
    L16:
        r11 = 0;
        goto L17
    L12:
        r8 = 0;
        goto L13
    }

    public String toString() {
        return "FansClubInfo(openFansClub=" + this.openFansClub + ", joinStatus=" + this.joinStatus + ", fansClubLevel=" + this.fansClubLevel + ", fansClubUrl=" + this.fansClubUrl + ", fansClubBubbleConfig=" + this.fansClubBubbleConfig + ", fansClubCouponConfig=" + this.fansClubCouponConfig + ")";
    }

    public final FansClubInfo deepCopy() {
        boolean r1 = this.openFansClub;
        boolean r2 = this.joinStatus;
        Integer r3 = this.fansClubLevel;
        String r4 = this.fansClubUrl;
        FansClubBubbleConfig r0 = this.fansClubBubbleConfig;
        if (r0 == null) goto L5;
        FansClubBubbleConfig r6 = r0.deepCopy();
    L6:
        StoreFollowGiftConfig r5 = this.fansClubCouponConfig;
        if (r5 == null) goto L9;
        StoreFollowGiftConfig r8 = r5.deepCopy();
    L11:
        return new FansClubInfo(r1, r2, r3, r4, r6, r8);
    L9:
        r8 = null;
        goto L11
    L5:
        r6 = null;
        goto L6
    }

    public final FansClubBubbleConfig getFansClubBubbleConfig() {
        return this.fansClubBubbleConfig;
    }

    public final StoreFollowGiftConfig getFansClubCouponConfig() {
        return this.fansClubCouponConfig;
    }

    public final Integer getFansClubLevel() {
        return this.fansClubLevel;
    }

    public final String getFansClubUrl() {
        return this.fansClubUrl;
    }

    public final boolean getJoinStatus() {
        return this.joinStatus;
    }

    public final boolean getOpenFansClub() {
        return this.openFansClub;
    }

    public final void setFansClubBubbleConfig(FansClubBubbleConfig r1) {
        this.fansClubBubbleConfig = r1;
    }

    public final void setFansClubCouponConfig(StoreFollowGiftConfig r1) {
        this.fansClubCouponConfig = r1;
    }

    public final void setFansClubLevel(Integer r1) {
        this.fansClubLevel = r1;
    }

    public final void setFansClubUrl(String r1) {
        this.fansClubUrl = r1;
    }

    public final void setJoinStatus(boolean r1) {
        this.joinStatus = r1;
    }

    public final void setOpenFansClub(boolean r1) {
        this.openFansClub = r1;
    }

    public FansClubInfo(boolean r1, boolean r2, Integer r3, String r4, FansClubBubbleConfig r5, StoreFollowGiftConfig r6) {
        this.openFansClub = r1;
        this.joinStatus = r2;
        this.fansClubLevel = r3;
        this.fansClubUrl = r4;
        this.fansClubBubbleConfig = r5;
        this.fansClubCouponConfig = r6;
    }

    public /* synthetic */ FansClubInfo(boolean r5, boolean r6, Integer r7, String r8, FansClubBubbleConfig r9, StoreFollowGiftConfig r10, int r11, DefaultConstructorMarker r12) {
        boolean r0 = false;
        if ((r11 & 1) == 0) goto L5;
        boolean r13 = false;
    L7:
        if ((r11 & 2) != 0) goto L11;
        r0 = r6;
    L11:
        if ((r11 & 4) == 0) goto L13;
        Integer r1 = null;
    L15:
        if ((r11 & 8) == 0) goto L17;
        String r2 = null;
    L19:
        if ((r11 & 16) == 0) goto L21;
        FansClubBubbleConfig r3 = null;
    L23:
        if ((r11 & 32) == 0) goto L25;
        StoreFollowGiftConfig r14 = null;
    L26:
        this(r13, r0, r1, r2, r3, r14);
        return;
    L25:
        r14 = r10;
        goto L26
    L21:
        r3 = r9;
        goto L23
    L17:
        r2 = r8;
        goto L19
    L13:
        r1 = r7;
        goto L15
    L5:
        r13 = r5;
        goto L7
    }
}
