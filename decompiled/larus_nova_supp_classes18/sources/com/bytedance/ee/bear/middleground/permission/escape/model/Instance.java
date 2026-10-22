package com.bytedance.ee.bear.middleground.permission.escape.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
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

    @SerializedName("user_name")
    private final String userName;

    public Instance() {
        this(null, 0, null, null, null, null, 0, 127, null);
    }

    public static /* synthetic */ Instance copy$default(Instance r9, String r10, int r11, String r12, String r13, String r14, String r15, long r16, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        String r1 = r9.instanceCode;
    L7:
        if ((r18 & 2) == 0) goto L9;
        int r2 = r9.objType;
    L11:
        if ((r18 & 4) == 0) goto L13;
        String r3 = r9.objId;
    L15:
        if ((r18 & 8) == 0) goto L17;
        String r4 = r9.userId;
    L19:
        if ((r18 & 16) == 0) goto L21;
        String r5 = r9.userName;
    L23:
        if ((r18 & 32) == 0) goto L25;
        String r6 = r9.userAvatarUrl;
    L27:
        if ((r18 & 64) == 0) goto L29;
        long r7 = r9.createTime;
    L31:
        return r9.copy(r1, r2, r3, r4, r5, r6, r7);
    L29:
        r7 = r16;
        goto L31
    L25:
        r6 = r15;
        goto L27
    L21:
        r5 = r14;
        goto L23
    L17:
        r4 = r13;
        goto L19
    L13:
        r3 = r12;
        goto L15
    L9:
        r2 = r11;
        goto L11
    L5:
        r1 = r10;
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

    public final Instance copy(String r11, int r12, String r13, String r14, String r15, String r16, long r17) {
        Intrinsics.checkNotNullParameter(r11, "instanceCode");
        Intrinsics.checkNotNullParameter(r13, "objId");
        Intrinsics.checkNotNullParameter(r14, "userId");
        Intrinsics.checkNotNullParameter(r15, "userName");
        Intrinsics.checkNotNullParameter(r16, "userAvatarUrl");
        return new Instance(r11, r12, r13, r14, r15, r16, r17);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof Instance) == true) goto L8;
        return false;
    L8:
        Instance r9 = (Instance) r8;
        if (Intrinsics.areEqual(this.instanceCode, r9.instanceCode) == true) goto L12;
        return false;
    L12:
        if (this.objType == r9.objType) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.objId, r9.objId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.userId, r9.userId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.userName, r9.userName) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.userAvatarUrl, r9.userAvatarUrl) == true) goto L27;
        return false;
    L27:
        if (this.createTime == r9.createTime) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((((((this.instanceCode.hashCode() * 31) + this.objType) * 31) + this.objId.hashCode()) * 31) + this.userId.hashCode()) * 31) + this.userName.hashCode()) * 31) + this.userAvatarUrl.hashCode()) * 31;
        long r1 = this.createTime;
        return r0 + ((int) (r1 ^ (r1 >>> 32)));
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

    public Instance(String r2, int r3, String r4, String r5, String r6, String r7, long r8) {
        Intrinsics.checkNotNullParameter(r2, "instanceCode");
        Intrinsics.checkNotNullParameter(r4, "objId");
        Intrinsics.checkNotNullParameter(r5, "userId");
        Intrinsics.checkNotNullParameter(r6, "userName");
        Intrinsics.checkNotNullParameter(r7, "userAvatarUrl");
        this.instanceCode = r2;
        this.objType = r3;
        this.objId = r4;
        this.userId = r5;
        this.userName = r6;
        this.userAvatarUrl = r7;
        this.createTime = r8;
    }

    public /* synthetic */ Instance(String r6, int r7, String r8, String r9, String r10, String r11, long r12, int r14, DefaultConstructorMarker r15) {
        String r0 = "";
        if ((r14 & 1) == 0) goto L5;
        String r16 = "";
    L7:
        if ((r14 & 2) == 0) goto L9;
        int r1 = 0;
    L11:
        if ((r14 & 4) == 0) goto L13;
        String r2 = "";
    L15:
        if ((r14 & 8) == 0) goto L17;
        String r3 = "";
    L19:
        if ((r14 & 16) == 0) goto L21;
        String r4 = "";
    L23:
        if ((r14 & 32) != 0) goto L27;
        r0 = r11;
    L27:
        if ((r14 & 64) == 0) goto L29;
        r12 = 0;
    L29:
        long r13 = r12;
        this(r16, r1, r2, r3, r4, r0, r13);
        return;
    L21:
        r4 = r10;
        goto L23
    L17:
        r3 = r9;
        goto L19
    L13:
        r2 = r8;
        goto L15
    L9:
        r1 = r7;
        goto L11
    L5:
        r16 = r6;
        goto L7
    }
}
