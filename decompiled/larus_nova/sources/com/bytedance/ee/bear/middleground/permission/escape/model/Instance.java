package com.bytedance.ee.bear.middleground.permission.escape.model;

import com.bytedance.sdk.account.platform.api.ITwitterService;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u000bHÆ\u0003JO\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\u0005HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006&"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/escape/model/Instance;", "Ljava/io/Serializable;", "instanceCode", "", "objType", "", "objId", "userId", "userName", "userAvatarUrl", "createTime", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getInstanceCode", "()Ljava/lang/String;", "getObjType", "()I", "getObjId", "getUserId", "getUserName", "getUserAvatarUrl", "getCreateTime", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "hashCode", "toString", "middleground-permission-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Instance implements Serializable {

    @SerializedName("create_time")
    private final long createTime;

    @SerializedName("instance_code")
    private final String instanceCode;

    @SerializedName("obj_id")
    private final String objId;

    @SerializedName("obj_type")
    private final int objType;

    @SerializedName("user_avatar_url")
    private final String userAvatarUrl;

    @SerializedName("user_id")
    private final String userId;

    @SerializedName(ITwitterService.ResponseConstants.USER_NAME)
    private final String userName;

    public Instance() {
        this(null, 0, null, null, null, null, 0, 127, null);
    }

    public static /* synthetic */ Instance copy$default(Instance r100, String r110, int r111, String r112, String r113, String r114, String r115, long r116, int r117, Object r118) {
        if ((r117 & 1) == 0) goto L5;
        String r101 = r100.instanceCode;
    L7:
        if ((r117 & 2) == 0) goto L9;
        int r102 = r100.objType;
    L11:
        if ((r117 & 4) == 0) goto L13;
        String r103 = r100.objId;
    L15:
        if ((r117 & 8) == 0) goto L17;
        String r104 = r100.userId;
    L19:
        if ((r117 & 16) == 0) goto L21;
        String r105 = r100.userName;
    L23:
        if ((r117 & 32) == 0) goto L25;
        String r106 = r100.userAvatarUrl;
    L27:
        if ((r117 & 64) == 0) goto L29;
        long r107 = r100.createTime;
    L31:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107);
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public final String component1() {
        return this.instanceCode;
    }

    public final int component2() {
        return this.objType;
    }

    public final String component3() {
        return this.objId;
    }

    public final String component4() {
        return this.userId;
    }

    public final String component5() {
        return this.userName;
    }

    public final String component6() {
        return this.userAvatarUrl;
    }

    public final long component7() {
        return this.createTime;
    }

    public final Instance copy(String r110, int r111, String r112, String r113, String r114, String r115, long r116) {
        Intrinsics.checkNotNullParameter(r110, "instanceCode");
        Intrinsics.checkNotNullParameter(r112, "objId");
        Intrinsics.checkNotNullParameter(r113, "userId");
        Intrinsics.checkNotNullParameter(r114, "userName");
        Intrinsics.checkNotNullParameter(r115, "userAvatarUrl");
        return new Instance(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Instance) == true) goto L8;
        return false;
    L8:
        Instance r101 = (Instance) r100;
        if (Intrinsics.areEqual(this.instanceCode, r101.instanceCode) == true) goto L12;
        return false;
    L12:
        if (this.objType == r101.objType) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.objId, r101.objId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.userId, r101.userId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.userName, r101.userName) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.userAvatarUrl, r101.userAvatarUrl) == true) goto L27;
        return false;
    L27:
        if (this.createTime == r101.createTime) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        int r100 = ((((((((((this.instanceCode.hashCode() * 31) + this.objType) * 31) + this.objId.hashCode()) * 31) + this.userId.hashCode()) * 31) + this.userName.hashCode()) * 31) + this.userAvatarUrl.hashCode()) * 31;
        long r101 = this.createTime;
        return r100 + ((int) (r101 ^ (r101 >>> 32)));
    }

    public String toString() {
        return "Instance(instanceCode=" + this.instanceCode + ", objType=" + this.objType + ", objId=" + this.objId + ", userId=" + this.userId + ", userName=" + this.userName + ", userAvatarUrl=" + this.userAvatarUrl + ", createTime=" + this.createTime + ')';
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    public final String getInstanceCode() {
        return this.instanceCode;
    }

    public final String getObjId() {
        return this.objId;
    }

    public final int getObjType() {
        return this.objType;
    }

    public final String getUserAvatarUrl() {
        return this.userAvatarUrl;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getUserName() {
        return this.userName;
    }

    public Instance(String r100, int r101, String r102, String r103, String r104, String r105, long r106) {
        Intrinsics.checkNotNullParameter(r100, "instanceCode");
        Intrinsics.checkNotNullParameter(r102, "objId");
        Intrinsics.checkNotNullParameter(r103, "userId");
        Intrinsics.checkNotNullParameter(r104, "userName");
        Intrinsics.checkNotNullParameter(r105, "userAvatarUrl");
        this.instanceCode = r100;
        this.objType = r101;
        this.objId = r102;
        this.userId = r103;
        this.userName = r104;
        this.userAvatarUrl = r105;
        this.createTime = r106;
    }

    public /* synthetic */ Instance(String r100, int r101, String r102, String r103, String r110, String r111, long r112, int r113, DefaultConstructorMarker r114) {
        String r104 = "";
        if ((r113 & 1) == 0) goto L5;
        String r115 = "";
    L7:
        if ((r113 & 2) == 0) goto L9;
        int r105 = 0;
    L11:
        if ((r113 & 4) == 0) goto L13;
        String r106 = "";
    L15:
        if ((r113 & 8) == 0) goto L17;
        String r107 = "";
    L19:
        if ((r113 & 16) == 0) goto L21;
        String r108 = "";
    L23:
        if ((r113 & 32) != 0) goto L27;
        r104 = r111;
    L27:
        if ((r113 & 64) == 0) goto L29;
        r112 = 0;
    L29:
        long r116 = r112;
        this(r115, r105, r106, r107, r108, r104, r116);
        return;
    L21:
        r108 = r110;
        goto L23
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r115 = r100;
        goto L7
    }
}
