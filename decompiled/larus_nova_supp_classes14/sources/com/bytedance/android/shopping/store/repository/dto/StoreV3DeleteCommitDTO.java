package com.bytedance.android.shopping.store.repository.dto;

import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J2\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/shopping/store/repository/dto/StoreV3DeleteCommitDTO;", "Lcom/bytedance/android/ec/model/api/CommerceBaseResponse;", "followButtonDisplay", "", "followIconType", "", "followGiftConfig", "Lcom/bytedance/android/shopping/store/repository/dto/StoreFollowGiftConfig;", "(Ljava/lang/String;Ljava/lang/Integer;Lcom/bytedance/android/shopping/store/repository/dto/StoreFollowGiftConfig;)V", "getFollowButtonDisplay", "()Ljava/lang/String;", "getFollowGiftConfig", "()Lcom/bytedance/android/shopping/store/repository/dto/StoreFollowGiftConfig;", "getFollowIconType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Lcom/bytedance/android/shopping/store/repository/dto/StoreFollowGiftConfig;)Lcom/bytedance/android/shopping/store/repository/dto/StoreV3DeleteCommitDTO;", "equals", "", "other", "", "hashCode", "toString", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StoreV3DeleteCommitDTO extends CommerceBaseResponse {

    @SerializedName("follow_button_display")
    private final String followButtonDisplay;

    @SerializedName("follow_config")
    private final StoreFollowGiftConfig followGiftConfig;

    @SerializedName("follow_icon_type")
    private final Integer followIconType;

    public StoreV3DeleteCommitDTO() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ StoreV3DeleteCommitDTO copy$default(StoreV3DeleteCommitDTO r0, String r1, Integer r2, StoreFollowGiftConfig r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.followButtonDisplay;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.followIconType;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.followGiftConfig;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.followButtonDisplay;
    }

    public final Integer component2() {
        return this.followIconType;
    }

    public final StoreFollowGiftConfig component3() {
        return this.followGiftConfig;
    }

    public final StoreV3DeleteCommitDTO copy(String r2, Integer r3, StoreFollowGiftConfig r4) {
        return new StoreV3DeleteCommitDTO(r2, r3, r4);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof StoreV3DeleteCommitDTO) == false) goto L12;
        StoreV3DeleteCommitDTO r4 = (StoreV3DeleteCommitDTO) r3;
        if (Intrinsics.areEqual(this.followButtonDisplay, r4.followButtonDisplay) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.followIconType, r4.followIconType) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.followGiftConfig, r4.followGiftConfig) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        String r0 = this.followButtonDisplay;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.followIconType;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        StoreFollowGiftConfig r7 = this.followGiftConfig;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "StoreV3DeleteCommitDTO(followButtonDisplay=" + this.followButtonDisplay + ", followIconType=" + this.followIconType + ", followGiftConfig=" + this.followGiftConfig + ")";
    }

    public final String getFollowButtonDisplay() {
        return this.followButtonDisplay;
    }

    public final StoreFollowGiftConfig getFollowGiftConfig() {
        return this.followGiftConfig;
    }

    public final Integer getFollowIconType() {
        return this.followIconType;
    }

    public StoreV3DeleteCommitDTO(String r1, Integer r2, StoreFollowGiftConfig r3) {
        this.followButtonDisplay = r1;
        this.followIconType = r2;
        this.followGiftConfig = r3;
    }

    public /* synthetic */ StoreV3DeleteCommitDTO(String r2, Integer r3, StoreFollowGiftConfig r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }
}
