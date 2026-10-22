package com.bytedance.locallife.model.poi.resp;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.poi.model.PoiImageUrlModel;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J-\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/bytedance/locallife/model/poi/resp/PoiAvatarFrameStruct;", "Ljava/io/Serializable;", "avatarFrameThumb", "Lcom/ss/android/ugc/aweme/poi/model/PoiImageUrlModel;", "avatarFrameId", "", "activityId", "(Lcom/ss/android/ugc/aweme/poi/model/PoiImageUrlModel;Ljava/lang/String;Ljava/lang/String;)V", "getActivityId", "()Ljava/lang/String;", "getAvatarFrameId", "getAvatarFrameThumb", "()Lcom/ss/android/ugc/aweme/poi/model/PoiImageUrlModel;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class PoiAvatarFrameStruct implements Serializable {

    @SerializedName("activity_id")
    private final String activityId;

    @SerializedName("avatar_frame_id")
    private final String avatarFrameId;

    @SerializedName("avatar_frame_thumb")
    private final PoiImageUrlModel avatarFrameThumb;

    public PoiAvatarFrameStruct() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ PoiAvatarFrameStruct copy$default(PoiAvatarFrameStruct r100, PoiImageUrlModel r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.avatarFrameThumb;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.avatarFrameId;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.activityId;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final PoiImageUrlModel component1() {
        return this.avatarFrameThumb;
    }

    public final String component2() {
        return this.avatarFrameId;
    }

    public final String component3() {
        return this.activityId;
    }

    public final PoiAvatarFrameStruct copy(PoiImageUrlModel r100, String r101, String r102) {
        return new PoiAvatarFrameStruct(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PoiAvatarFrameStruct) == true) goto L8;
        return false;
    L8:
        PoiAvatarFrameStruct r101 = (PoiAvatarFrameStruct) r100;
        if (Intrinsics.areEqual(this.avatarFrameThumb, r101.avatarFrameThumb) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.avatarFrameId, r101.avatarFrameId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.activityId, r101.activityId) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        PoiImageUrlModel r100 = this.avatarFrameThumb;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.avatarFrameId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.activityId;
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
        return "PoiAvatarFrameStruct(avatarFrameThumb=" + this.avatarFrameThumb + ", avatarFrameId=" + this.avatarFrameId + ", activityId=" + this.activityId + ')';
    }

    public final String getActivityId() {
        return this.activityId;
    }

    public final String getAvatarFrameId() {
        return this.avatarFrameId;
    }

    public final PoiImageUrlModel getAvatarFrameThumb() {
        return this.avatarFrameThumb;
    }

    public PoiAvatarFrameStruct(PoiImageUrlModel r100, String r101, String r102) {
        this.avatarFrameThumb = r100;
        this.avatarFrameId = r101;
        this.activityId = r102;
    }

    public /* synthetic */ PoiAvatarFrameStruct(PoiImageUrlModel r100, String r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
