package com.bytedance.ee.bear.bitable.homepage.recommend;

import com.bytedance.ee.util.io.NonProguard;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ee/bear/bitable/homepage/recommend/BitableRecommendItemOwnerData;", "Lcom/bytedance/ee/util/io/NonProguard;", "ownerId", "", "ownerName", "avatarUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getOwnerId", "()Ljava/lang/String;", "getOwnerName", "getAvatarUrl", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableRecommendItemOwnerData implements NonProguard {

    @SerializedName("avatar_url")
    private final String avatarUrl;

    @SerializedName("owner_id")
    private final String ownerId;

    @SerializedName("owner_name")
    private final String ownerName;

    public static /* synthetic */ BitableRecommendItemOwnerData copy$default(BitableRecommendItemOwnerData r100, String r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.ownerId;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.ownerName;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.avatarUrl;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.ownerId;
    }

    public final String component2() {
        return this.ownerName;
    }

    public final String component3() {
        return this.avatarUrl;
    }

    public final BitableRecommendItemOwnerData copy(String r100, String r101, String r102) {
        return new BitableRecommendItemOwnerData(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof BitableRecommendItemOwnerData) == true) goto L8;
        return false;
    L8:
        BitableRecommendItemOwnerData r101 = (BitableRecommendItemOwnerData) r100;
        if (Intrinsics.areEqual(this.ownerId, r101.ownerId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.ownerName, r101.ownerName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.avatarUrl, r101.avatarUrl) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r100 = this.ownerId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.ownerName;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.avatarUrl;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "BitableRecommendItemOwnerData(ownerId=" + this.ownerId + ", ownerName=" + this.ownerName + ", avatarUrl=" + this.avatarUrl + ')';
    }

    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    public final String getOwnerId() {
        return this.ownerId;
    }

    public final String getOwnerName() {
        return this.ownerName;
    }

    public BitableRecommendItemOwnerData(String r100, String r101, String r102) {
        this.ownerId = r100;
        this.ownerName = r101;
        this.avatarUrl = r102;
    }
}
