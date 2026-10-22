package com.larus.account.saas.core.internal.network;

import b48.j;
import b48.l;
import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.bytedance.sdk.account.platform.api.ITwitterService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001e\b\u0081\b\u0018\u00002\u00020\u0001BU\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u0014\u001a\u00020\f\u0012\b\b\u0002\u0010\u0015\u001a\u00020\f¢\u0006\u0004\b(\u0010)J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010\r\u001a\u00020\fHÆ\u0003J\t\u0010\u000e\u001a\u00020\fHÆ\u0003JW\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00042\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u0014\u001a\u00020\f2\b\b\u0002\u0010\u0015\u001a\u00020\fHÆ\u0001J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\u001a\u001a\u00020\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001a\u0010\u000f\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b!\u0010 R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001e\u001a\u0004\b\"\u0010 R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010#\u001a\u0004\b$\u0010%R\u001a\u0010\u0014\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010&\u001a\u0004\b\u0014\u0010'R\u001a\u0010\u0015\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010&\u001a\u0004\b\u0015\u0010'¨\u0006*"}, d2 = {"Lcom/larus/account/saas/core/internal/network/NetworkUserInfo;", "", "Lb48/l;", "toUserInfo", "", "component1", "", "component2", "component3", "component4", "Lcom/larus/account/saas/core/internal/network/NetworkAvatarInfo;", "component5", "", "component6", "component7", "userType", "userId", "nickName", "userName", "avatar", "isNicknameDefault", "isAvatarDefault", "copy", "toString", "hashCode", "other", "equals", "I", "getUserType", "()I", "Ljava/lang/String;", "getUserId", "()Ljava/lang/String;", "getNickName", "getUserName", "Lcom/larus/account/saas/core/internal/network/NetworkAvatarInfo;", "getAvatar", "()Lcom/larus/account/saas/core/internal/network/NetworkAvatarInfo;", "Z", "()Z", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/account/saas/core/internal/network/NetworkAvatarInfo;ZZ)V", "account-saas-core_release"}, k = 1, mv = {1, 7, 1})
public final class NetworkUserInfo {

    @SerializedName("image")
    private final NetworkAvatarInfo avatar;

    @SerializedName("is_default_avatar")
    private final boolean isAvatarDefault;

    @SerializedName("is_default_nickname")
    private final boolean isNicknameDefault;

    @SerializedName(InstantPlayContext.NICKNAME)
    private final String nickName;

    @SerializedName(PickerReporterConstants.KEY.ENTITY_ID)
    private final String userId;

    @SerializedName(ITwitterService.ResponseConstants.USER_NAME)
    private final String userName;

    @SerializedName("user_type")
    private final int userType;

    public NetworkUserInfo() {
        this(0, null, null, null, null, false, false, 127, null);
    }

    public static /* synthetic */ NetworkUserInfo copy$default(NetworkUserInfo r100, int r101, String r102, String r103, String r104, NetworkAvatarInfo r110, boolean r111, boolean r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.userType;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.userId;
    L8:
        String r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.nickName;
    L11:
        String r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.userName;
    L14:
        String r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.avatar;
    L17:
        NetworkAvatarInfo r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.isNicknameDefault;
    L20:
        boolean r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.isAvatarDefault;
    L23:
        int r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final int component1() {
        return this.userType;
    }

    public final String component2() {
        return this.userId;
    }

    public final String component3() {
        return this.nickName;
    }

    public final String component4() {
        return this.userName;
    }

    public final NetworkAvatarInfo component5() {
        return this.avatar;
    }

    public final boolean component6() {
        return this.isNicknameDefault;
    }

    public final boolean component7() {
        return this.isAvatarDefault;
    }

    public final NetworkUserInfo copy(int r110, String r111, String r112, String r113, NetworkAvatarInfo r114, boolean r115, boolean r116) {
        return new NetworkUserInfo(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof NetworkUserInfo) == true) goto L8;
        return false;
    L8:
        NetworkUserInfo r101 = (NetworkUserInfo) r100;
        if (this.userType == r101.userType) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.userId, r101.userId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.nickName, r101.nickName) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.userName, r101.userName) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.avatar, r101.avatar) == true) goto L24;
        return false;
    L24:
        if (this.isNicknameDefault == r101.isNicknameDefault) goto L27;
        return false;
    L27:
        if (this.isAvatarDefault == r101.isAvatarDefault) goto L29;
        return false;
    L29:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11, types: [int] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4 */
    public int hashCode() {
        int r100 = this.userType * 31;
        String r101 = this.userId;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.nickName;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.userName;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        NetworkAvatarInfo r111 = this.avatar;
        if (r111 == null) goto L18;
        r102 = r111.hashCode();
    L18:
        int r112 = (r110 + r102) * 31;
        boolean r113 = this.isNicknameDefault;
        ?? r114 = 1;
        ?? r115 = r113;
        if (r113 == false) goto L21;
        r115 = 1;
    L21:
        int r116 = (r112 + r115) * 31;
        boolean r117 = this.isAvatarDefault;
        if (r117 == true) goto L26;
        r114 = r117;
    L26:
        return r116 + r114;
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "NetworkUserInfo(userType=" + this.userType + ", userId=" + this.userId + ", nickName=" + this.nickName + ", userName=" + this.userName + ", avatar=" + this.avatar + ", isNicknameDefault=" + this.isNicknameDefault + ", isAvatarDefault=" + this.isAvatarDefault + ')';
    }

    public final l toUserInfo() {
        int r100 = this.userType;
        String r101 = this.userId;
        String r102 = this.nickName;
        String r103 = this.userName;
        NetworkAvatarInfo r104 = this.avatar;
        if (r104 == null) goto L5;
        j r105 = r104.toAvatarInfo();
    L7:
        return new l(r100, r101, r102, r103, r105, this.isNicknameDefault, this.isAvatarDefault);
    L5:
        r105 = null;
        goto L7
    }

    public final NetworkAvatarInfo getAvatar() {
        return this.avatar;
    }

    public final String getNickName() {
        return this.nickName;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getUserName() {
        return this.userName;
    }

    public final int getUserType() {
        return this.userType;
    }

    public final boolean isAvatarDefault() {
        return this.isAvatarDefault;
    }

    public final boolean isNicknameDefault() {
        return this.isNicknameDefault;
    }

    public NetworkUserInfo(int r100, String r101, String r102, String r103, NetworkAvatarInfo r104, boolean r105, boolean r106) {
        this.userType = r100;
        this.userId = r101;
        this.nickName = r102;
        this.userName = r103;
        this.avatar = r104;
        this.isNicknameDefault = r105;
        this.isAvatarDefault = r106;
    }

    public /* synthetic */ NetworkUserInfo(int r100, String r101, String r102, String r110, NetworkAvatarInfo r111, boolean r112, boolean r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 1) == 0) goto L5;
        int r116 = 0;
    L6:
        NetworkAvatarInfo r103 = null;
        if ((r114 & 2) == 0) goto L9;
        String r104 = null;
    L11:
        if ((r114 & 4) == 0) goto L13;
        String r105 = null;
    L15:
        if ((r114 & 8) == 0) goto L17;
        String r106 = null;
    L19:
        if ((r114 & 16) != 0) goto L23;
        r103 = r111;
    L23:
        if ((r114 & 32) == 0) goto L25;
        boolean r107 = false;
    L27:
        if ((r114 & 64) == 0) goto L29;
        boolean r117 = false;
    L30:
        this(r116, r104, r105, r106, r103, r107, r117);
        return;
    L29:
        r117 = r113;
        goto L30
    L25:
        r107 = r112;
        goto L27
    L17:
        r106 = r110;
        goto L19
    L13:
        r105 = r102;
        goto L15
    L9:
        r104 = r101;
        goto L11
    L5:
        r116 = r100;
        goto L6
    }
}
