package r38;

import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.bytedance.sdk.account.platform.api.ITwitterService;
import com.google.gson.annotations.SerializedName;
import com.larus.account.base.model.profile.AvatarInfo;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\"\b\u0086\b\u0018\u00002\u00020\u0001B{\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010&\u001a\u00020\u000bHÆ\u0003J\t\u0010'\u001a\u00020\u000bHÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010)\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0082\u0001\u0010+\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010,J\u0013\u0010-\u001a\u00020\u000b2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u00020\u0003HÖ\u0001J\t\u00100\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u001cR\u0016\u0010\f\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u001cR\u001a\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u001d\u0010\u0014R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017¨\u00061"}, d2 = {"Lcom/larus/account/base/model/profile/UserInfo;", "", "userType", "", "userId", "", "nickName", "userName", "avatar", "Lcom/larus/account/base/model/profile/AvatarInfo;", "isNicknameDefault", "", "isAvatarDefault", "enterpriseUserType", "tenantInfo", "Lcom/larus/account/base/model/profile/LarkTenantInfo;", "larkUserId", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/account/base/model/profile/AvatarInfo;ZZLjava/lang/Integer;Lcom/larus/account/base/model/profile/LarkTenantInfo;Ljava/lang/String;)V", "getUserType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getUserId", "()Ljava/lang/String;", "getNickName", "getUserName", "getAvatar", "()Lcom/larus/account/base/model/profile/AvatarInfo;", "()Z", "getEnterpriseUserType", "getTenantInfo", "()Lcom/larus/account/base/model/profile/LarkTenantInfo;", "getLarkUserId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/account/base/model/profile/AvatarInfo;ZZLjava/lang/Integer;Lcom/larus/account/base/model/profile/LarkTenantInfo;Ljava/lang/String;)Lcom/larus/account/base/model/profile/UserInfo;", "equals", "other", "hashCode", "toString", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class b {

    @SerializedName("image")
    private final AvatarInfo avatar;

    @SerializedName(alternate = {"EnterpriseUserType"}, value = "enterprise_user_type")
    private final Integer enterpriseUserType;

    @SerializedName("is_default_avatar")
    private final boolean isAvatarDefault;

    @SerializedName("is_default_nickname")
    private final boolean isNicknameDefault;

    @SerializedName("lark_user_id")
    private final String larkUserId;

    @SerializedName(InstantPlayContext.NICKNAME)
    private final String nickName;

    @SerializedName(alternate = {"TenantInfo"}, value = "tenant_info")
    private final a tenantInfo;

    @SerializedName(PickerReporterConstants.KEY.ENTITY_ID)
    private final String userId;

    @SerializedName(ITwitterService.ResponseConstants.USER_NAME)
    private final String userName;

    @SerializedName("user_type")
    private final Integer userType;

    public b() {
        this(null, null, null, null, 1023);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.userType, r101.userType) == true) goto L12;
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
        if (this.isAvatarDefault == r101.isAvatarDefault) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.enterpriseUserType, r101.enterpriseUserType) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.tenantInfo, r101.tenantInfo) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.larkUserId, r101.larkUserId) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.userType;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.userId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.nickName;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.userName;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        AvatarInfo r113 = this.avatar;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        int r116 = 1231;
        if (this.isNicknameDefault == false) goto L25;
        int r117 = 1231;
    L26:
        int r118 = (r115 + r117) * 31;
        if (this.isAvatarDefault == true) goto L30;
        r116 = 1237;
    L30:
        int r119 = (r118 + r116) * 31;
        Integer r120 = this.enterpriseUserType;
        if (r120 != null) goto L33;
        int r121 = 0;
    L34:
        int r122 = (r119 + r121) * 31;
        a r123 = this.tenantInfo;
        if (r123 != null) goto L37;
        int r124 = 0;
    L38:
        int r125 = (r122 + r124) * 31;
        String r126 = this.larkUserId;
        if (r126 == null) goto L43;
        r101 = r126.hashCode();
    L43:
        return r125 + r101;
    L37:
        r124 = r123.hashCode();
        goto L38
    L33:
        r121 = r120.hashCode();
        goto L34
    L25:
        r117 = 1237;
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
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

    public final String toString() {
        return "UserInfo(userType=" + this.userType + ", userId=" + this.userId + ", nickName=" + this.nickName + ", userName=" + this.userName + ", avatar=" + this.avatar + ", isNicknameDefault=" + this.isNicknameDefault + ", isAvatarDefault=" + this.isAvatarDefault + ", enterpriseUserType=" + this.enterpriseUserType + ", tenantInfo=" + this.tenantInfo + ", larkUserId=" + this.larkUserId + ')';
    }

    public final AvatarInfo a() {
        return this.avatar;
    }

    public final Integer b() {
        return this.enterpriseUserType;
    }

    public final String c() {
        return this.larkUserId;
    }

    public final String d() {
        return this.nickName;
    }

    public final a e() {
        return this.tenantInfo;
    }

    public final String f() {
        return this.userId;
    }

    public final String g() {
        return this.userName;
    }

    public final Integer h() {
        return this.userType;
    }

    public final boolean i() {
        return this.isAvatarDefault;
    }

    public final boolean j() {
        return this.isNicknameDefault;
    }

    public b(String r100, String r101, String r102, AvatarInfo r103, int r104) {
        if ((r104 & 1) == 0) goto L5;
        Integer r105 = 0;
    L7:
        if ((r104 & 2) == 0) goto L10;
        r100 = null;
    L10:
        if ((r104 & 4) == 0) goto L13;
        r101 = null;
    L13:
        if ((r104 & 8) == 0) goto L16;
        r102 = null;
    L16:
        if ((r104 & 16) == 0) goto L18;
        r103 = null;
    L18:
        this.userType = r105;
        this.userId = r100;
        this.nickName = r101;
        this.userName = r102;
        this.avatar = r103;
        this.isNicknameDefault = false;
        this.isAvatarDefault = false;
        this.enterpriseUserType = null;
        this.tenantInfo = null;
        this.larkUserId = null;
        return;
    L5:
        r105 = null;
        goto L7
    }
}
