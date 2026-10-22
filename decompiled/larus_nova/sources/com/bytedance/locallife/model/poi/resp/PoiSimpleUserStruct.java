package com.bytedance.locallife.model.poi.resp;

import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.poi.model.PoiImageUrlModel;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010\u001e\u001a\u00020\u000bHÆ\u0003JO\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\u000bHÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014¨\u0006&"}, d2 = {"Lcom/bytedance/locallife/model/poi/resp/PoiSimpleUserStruct;", "Ljava/io/Serializable;", "uid", "", "secUid", "nickName", "avatar", "Lcom/ss/android/ugc/aweme/poi/model/PoiImageUrlModel;", "avatarFrame", "Lcom/bytedance/locallife/model/poi/resp/PoiAvatarFrameStruct;", "followStatus", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/ugc/aweme/poi/model/PoiImageUrlModel;Lcom/bytedance/locallife/model/poi/resp/PoiAvatarFrameStruct;I)V", "getAvatar", "()Lcom/ss/android/ugc/aweme/poi/model/PoiImageUrlModel;", "getAvatarFrame", "()Lcom/bytedance/locallife/model/poi/resp/PoiAvatarFrameStruct;", "getFollowStatus", "()I", "getNickName", "()Ljava/lang/String;", "setNickName", "(Ljava/lang/String;)V", "getSecUid", "getUid", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "toString", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class PoiSimpleUserStruct implements Serializable {

    @SerializedName("avatar_thumb")
    private final PoiImageUrlModel avatar;

    @SerializedName("avatar_frame")
    private final PoiAvatarFrameStruct avatarFrame;

    @SerializedName("FollowStatus")
    private final int followStatus;

    @SerializedName(InstantPlayContext.NICKNAME)
    private String nickName;

    @SerializedName("sec_uid")
    private final String secUid;

    @SerializedName("uid")
    private final String uid;

    public PoiSimpleUserStruct() {
        this(null, null, null, null, null, 0, 63, null);
    }

    public static /* synthetic */ PoiSimpleUserStruct copy$default(PoiSimpleUserStruct r100, String r101, String r102, String r103, PoiImageUrlModel r104, PoiAvatarFrameStruct r105, int r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.uid;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.secUid;
    L8:
        String r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.nickName;
    L11:
        String r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.avatar;
    L14:
        PoiImageUrlModel r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.avatarFrame;
    L17:
        PoiAvatarFrameStruct r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.followStatus;
    L20:
        String r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final String component1() {
        return this.uid;
    }

    public final String component2() {
        return this.secUid;
    }

    public final String component3() {
        return this.nickName;
    }

    public final PoiImageUrlModel component4() {
        return this.avatar;
    }

    public final PoiAvatarFrameStruct component5() {
        return this.avatarFrame;
    }

    public final int component6() {
        return this.followStatus;
    }

    public final PoiSimpleUserStruct copy(String r100, String r110, String r111, PoiImageUrlModel r112, PoiAvatarFrameStruct r113, int r114) {
        return new PoiSimpleUserStruct(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PoiSimpleUserStruct) == true) goto L8;
        return false;
    L8:
        PoiSimpleUserStruct r101 = (PoiSimpleUserStruct) r100;
        if (Intrinsics.areEqual(this.uid, r101.uid) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.secUid, r101.secUid) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.nickName, r101.nickName) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.avatar, r101.avatar) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.avatarFrame, r101.avatarFrame) == true) goto L24;
        return false;
    L24:
        if (this.followStatus == r101.followStatus) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        String r100 = this.uid;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.secUid;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.nickName;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        PoiImageUrlModel r110 = this.avatar;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        PoiAvatarFrameStruct r113 = this.avatarFrame;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return ((r112 + r101) * 31) + this.followStatus;
    L17:
        r111 = r110.hashCode();
        goto L18
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
        return "PoiSimpleUserStruct(uid=" + this.uid + ", secUid=" + this.secUid + ", nickName=" + this.nickName + ", avatar=" + this.avatar + ", avatarFrame=" + this.avatarFrame + ", followStatus=" + this.followStatus + ')';
    }

    public final PoiImageUrlModel getAvatar() {
        return this.avatar;
    }

    public final PoiAvatarFrameStruct getAvatarFrame() {
        return this.avatarFrame;
    }

    public final int getFollowStatus() {
        return this.followStatus;
    }

    public final String getNickName() {
        return this.nickName;
    }

    public final String getSecUid() {
        return this.secUid;
    }

    public final String getUid() {
        return this.uid;
    }

    public final void setNickName(String r100) {
        this.nickName = r100;
    }

    public PoiSimpleUserStruct(String r100, String r101, String r102, PoiImageUrlModel r103, PoiAvatarFrameStruct r104, int r105) {
        this.uid = r100;
        this.secUid = r101;
        this.nickName = r102;
        this.avatar = r103;
        this.avatarFrame = r104;
        this.followStatus = r105;
    }

    public /* synthetic */ PoiSimpleUserStruct(String r100, String r101, String r102, PoiImageUrlModel r103, PoiAvatarFrameStruct r104, int r110, int r111, DefaultConstructorMarker r112) {
        PoiAvatarFrameStruct r105 = null;
        if ((r111 & 1) == 0) goto L5;
        String r113 = null;
    L7:
        if ((r111 & 2) == 0) goto L9;
        String r106 = null;
    L11:
        if ((r111 & 4) == 0) goto L13;
        String r107 = null;
    L15:
        if ((r111 & 8) == 0) goto L17;
        PoiImageUrlModel r108 = null;
    L19:
        if ((r111 & 16) != 0) goto L23;
        r105 = r104;
    L23:
        if ((r111 & 32) == 0) goto L25;
        int r114 = 0;
    L26:
        this(r113, r106, r107, r108, r105, r114);
        return;
    L25:
        r114 = r110;
        goto L26
    L17:
        r108 = r103;
        goto L19
    L13:
        r107 = r102;
        goto L15
    L9:
        r106 = r101;
        goto L11
    L5:
        r113 = r100;
        goto L7
    }
}
