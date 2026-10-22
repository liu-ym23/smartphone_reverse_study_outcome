package com.larus.platform.api.creation;

import com.google.gson.annotations.SerializedName;
import com.ss.texturerender.VideoSurfaceTexture;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zp9.c;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0010J>\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0012\u0010\u0010¨\u0006\u001f"}, d2 = {"Lcom/larus/platform/api/creation/CreationFeedCacheEntity;", "", "creationRecommendType", "", "listData", "Lcom/larus/platform/api/creation/CommonCreationFeedData;", "randomSeed", "", VideoSurfaceTexture.KEY_TIME, "<init>", "(Ljava/lang/String;Lcom/larus/platform/api/creation/CommonCreationFeedData;Ljava/lang/Long;Ljava/lang/Long;)V", "getCreationRecommendType", "()Ljava/lang/String;", "getListData", "()Lcom/larus/platform/api/creation/CommonCreationFeedData;", "getRandomSeed", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getTimeStamp", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Lcom/larus/platform/api/creation/CommonCreationFeedData;Ljava/lang/Long;Ljava/lang/Long;)Lcom/larus/platform/api/creation/CreationFeedCacheEntity;", "equals", "", "other", "hashCode", "", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationFeedCacheEntity {

    @SerializedName("creation_recommend_type")
    private final String creationRecommendType;

    @SerializedName("list_data")
    private final c listData;

    @SerializedName("random_seed")
    private final Long randomSeed;

    @SerializedName("time_stamp")
    private final Long timeStamp;

    public CreationFeedCacheEntity() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ CreationFeedCacheEntity copy$default(CreationFeedCacheEntity r100, String r101, c r102, Long r103, Long r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.creationRecommendType;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.listData;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.randomSeed;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.timeStamp;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.creationRecommendType;
    }

    public final c component2() {
        return this.listData;
    }

    public final Long component3() {
        return this.randomSeed;
    }

    public final Long component4() {
        return this.timeStamp;
    }

    public final CreationFeedCacheEntity copy(String r100, c r101, Long r102, Long r103) {
        return new CreationFeedCacheEntity(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CreationFeedCacheEntity) == true) goto L8;
        return false;
    L8:
        CreationFeedCacheEntity r101 = (CreationFeedCacheEntity) r100;
        if (Intrinsics.areEqual(this.creationRecommendType, r101.creationRecommendType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.listData, r101.listData) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.randomSeed, r101.randomSeed) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.timeStamp, r101.timeStamp) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r100 = this.creationRecommendType;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        c r104 = this.listData;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.randomSeed;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Long r110 = this.timeStamp;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "CreationFeedCacheEntity(creationRecommendType=" + this.creationRecommendType + ", listData=" + this.listData + ", randomSeed=" + this.randomSeed + ", timeStamp=" + this.timeStamp + ')';
    }

    public final String getCreationRecommendType() {
        return this.creationRecommendType;
    }

    public final c getListData() {
        return this.listData;
    }

    public final Long getRandomSeed() {
        return this.randomSeed;
    }

    public final Long getTimeStamp() {
        return this.timeStamp;
    }

    public CreationFeedCacheEntity(String r100, c r101, Long r102, Long r103) {
        this.creationRecommendType = r100;
        this.listData = r101;
        this.randomSeed = r102;
        this.timeStamp = r103;
    }

    public /* synthetic */ CreationFeedCacheEntity(String r100, c r101, Long r102, Long r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = 0L;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = 0L;
    L14:
        this(r100, r101, r102, r103);
    }
}
