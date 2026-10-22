package q38;

import com.google.gson.annotations.SerializedName;
import com.tencent.connect.common.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b*\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0099\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010'\u001a\u00020\bHÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010*\u001a\u00020\bHÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010-\u001a\u00020\bHÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u009b\u0001\u00101\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000b\u001a\u00020\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000e\u001a\u00020\b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00105\u001a\u00020\u0005HÖ\u0001J\t\u00106\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u0016\u0010\u000b\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0015R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0015R\u0016\u0010\u000e\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001aR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0015R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0015R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0015¨\u00067"}, d2 = {"Lcom/larus/account/base/model/ConnectInfo;", "", "platform", "", "platformAppId", "", "profileImageUrl", "expiredTime", "", "expiresIn", "platformScreenName", "userId", "platformUid", "secPlatformUid", "modifyTime", "accessToken", "openId", "extra", "<init>", "(Ljava/lang/String;ILjava/lang/String;JILjava/lang/String;JLjava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getPlatform", "()Ljava/lang/String;", "getPlatformAppId", "()I", "getProfileImageUrl", "getExpiredTime", "()J", "getExpiresIn", "getPlatformScreenName", "getUserId", "getPlatformUid", "getSecPlatformUid", "getModifyTime", "getAccessToken", "getOpenId", "getExtra", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "equals", "", "other", "hashCode", "toString", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class k {

    @SerializedName("access_token")
    private final String accessToken;

    @SerializedName("expired_time")
    private final long expiredTime;

    @SerializedName("expires_in")
    private final int expiresIn;

    @SerializedName("extra")
    private final String extra;

    @SerializedName("modify_time")
    private final long modifyTime;

    @SerializedName(Constants.JumpUrlConstants.URL_KEY_OPENID)
    private final String openId;

    @SerializedName("platform")
    private final String platform;

    @SerializedName("platform_app_id")
    private final int platformAppId;

    @SerializedName("platform_screen_name")
    private final String platformScreenName;

    @SerializedName("platform_uid")
    private final String platformUid;

    @SerializedName("profile_image_url")
    private final String profileImageUrl;

    @SerializedName("sec_platform_uid")
    private final String secPlatformUid;

    @SerializedName("user_id")
    private final long userId;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.platform, r101.platform) == true) goto L12;
        return false;
    L12:
        if (this.platformAppId == r101.platformAppId) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.profileImageUrl, r101.profileImageUrl) == true) goto L18;
        return false;
    L18:
        if (this.expiredTime == r101.expiredTime) goto L21;
        return false;
    L21:
        if (this.expiresIn == r101.expiresIn) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.platformScreenName, r101.platformScreenName) == true) goto L27;
        return false;
    L27:
        if (this.userId == r101.userId) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.platformUid, r101.platformUid) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.secPlatformUid, r101.secPlatformUid) == true) goto L36;
        return false;
    L36:
        if (this.modifyTime == r101.modifyTime) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.accessToken, r101.accessToken) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.openId, r101.openId) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        String r100 = this.platform;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.platformAppId) * 31;
        String r104 = this.profileImageUrl;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        long r107 = this.expiredTime;
        int r108 = (((r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31) + this.expiresIn) * 31;
        String r109 = this.platformScreenName;
        if (r109 != null) goto L13;
        int r110 = 0;
    L14:
        int r111 = (r108 + r110) * 31;
        long r112 = this.userId;
        int r113 = (r111 + ((int) (r112 ^ (r112 >>> 32)))) * 31;
        String r114 = this.platformUid;
        if (r114 != null) goto L17;
        int r115 = 0;
    L18:
        int r116 = (r113 + r115) * 31;
        String r117 = this.secPlatformUid;
        if (r117 != null) goto L21;
        int r118 = 0;
    L22:
        int r119 = (r116 + r118) * 31;
        long r120 = this.modifyTime;
        int r121 = (r119 + ((int) (r120 ^ (r120 >>> 32)))) * 31;
        String r122 = this.accessToken;
        if (r122 != null) goto L25;
        int r123 = 0;
    L26:
        int r124 = (r121 + r123) * 31;
        String r125 = this.openId;
        if (r125 != null) goto L29;
        int r126 = 0;
    L30:
        int r127 = (r124 + r126) * 31;
        String r128 = this.extra;
        if (r128 == null) goto L35;
        r101 = r128.hashCode();
    L35:
        return r127 + r101;
    L29:
        r126 = r125.hashCode();
        goto L30
    L25:
        r123 = r122.hashCode();
        goto L26
    L21:
        r118 = r117.hashCode();
        goto L22
    L17:
        r115 = r114.hashCode();
        goto L18
    L13:
        r110 = r109.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ConnectInfo(platform=" + this.platform + ", platformAppId=" + this.platformAppId + ", profileImageUrl=" + this.profileImageUrl + ", expiredTime=" + this.expiredTime + ", expiresIn=" + this.expiresIn + ", platformScreenName=" + this.platformScreenName + ", userId=" + this.userId + ", platformUid=" + this.platformUid + ", secPlatformUid=" + this.secPlatformUid + ", modifyTime=" + this.modifyTime + ", accessToken=" + this.accessToken + ", openId=" + this.openId + ", extra=" + this.extra + ')';
    }

    public k() {
        this.platform = null;
        this.platformAppId = 0;
        this.profileImageUrl = null;
        this.expiredTime = 0;
        this.expiresIn = 0;
        this.platformScreenName = null;
        this.userId = 0;
        this.platformUid = null;
        this.secPlatformUid = null;
        this.modifyTime = 0;
        this.accessToken = null;
        this.openId = null;
        this.extra = null;
    }

    public final int a() {
        return this.platformAppId;
    }
}
