package q38;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0099\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\u0012\b\u0002\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0013\u0010,\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\rHÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u009b\u0001\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00072\u0012\b\u0002\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00105\u001a\u00020\u0005HÖ\u0001J\t\u00106\u001a\u00020\u0007HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR \u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0016\u0010\u000f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0016R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001aR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001aR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001a¨\u00067"}, d2 = {"Lcom/larus/account/base/model/BaseInfo;", "", "userId", "", "appId", "", "avatarUrl", "", "screenName", "mobile", "safeMobile", "email", "connectInfo", "", "Lcom/larus/account/base/model/ConnectInfo;", "registerTime", "registerType", "registerApp", "lastLoginTime", "<init>", "(JILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getUserId", "()J", "getAppId", "()I", "getAvatarUrl", "()Ljava/lang/String;", "getScreenName", "getMobile", "getSafeMobile", "getEmail", "getConnectInfo", "()Ljava/util/List;", "getRegisterTime", "getRegisterType", "getRegisterApp", "getLastLoginTime", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "equals", "", "other", "hashCode", "toString", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class g {

    @SerializedName("app_id")
    private final int appId;

    @SerializedName("avatar_url")
    private final String avatarUrl;

    @SerializedName("connect_info")
    private final List<k> connectInfo;

    @SerializedName("email")
    private final String email;

    @SerializedName("last_login_time")
    private final String lastLoginTime;

    @SerializedName("mobile")
    private final String mobile;

    @SerializedName("register_app")
    private final String registerApp;

    @SerializedName("register_time")
    private final long registerTime;

    @SerializedName("register_type")
    private final String registerType;

    @SerializedName("safe_mobile")
    private final String safeMobile;

    @SerializedName("screen_name")
    private final String screenName;

    @SerializedName("user_id")
    private final long userId;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (this.userId == r101.userId) goto L12;
        return false;
    L12:
        if (this.appId == r101.appId) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.avatarUrl, r101.avatarUrl) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.screenName, r101.screenName) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.mobile, r101.mobile) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.safeMobile, r101.safeMobile) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.email, r101.email) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.connectInfo, r101.connectInfo) == true) goto L33;
        return false;
    L33:
        if (this.registerTime == r101.registerTime) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.registerType, r101.registerType) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.registerApp, r101.registerApp) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.lastLoginTime, r101.lastLoginTime) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        long r100 = this.userId;
        int r101 = ((((int) (r100 ^ (r100 >>> 32))) * 31) + this.appId) * 31;
        String r102 = this.avatarUrl;
        int r103 = 0;
        if (r102 != null) goto L5;
        int r104 = 0;
    L6:
        int r105 = (r101 + r104) * 31;
        String r106 = this.screenName;
        if (r106 != null) goto L9;
        int r107 = 0;
    L10:
        int r108 = (r105 + r107) * 31;
        String r109 = this.mobile;
        if (r109 != null) goto L13;
        int r110 = 0;
    L14:
        int r111 = (r108 + r110) * 31;
        String r112 = this.safeMobile;
        if (r112 != null) goto L17;
        int r113 = 0;
    L18:
        int r114 = (r111 + r113) * 31;
        String r115 = this.email;
        if (r115 != null) goto L21;
        int r116 = 0;
    L22:
        int r117 = (r114 + r116) * 31;
        List<k> r118 = this.connectInfo;
        if (r118 != null) goto L25;
        int r119 = 0;
    L26:
        long r120 = this.registerTime;
        int r121 = (((r117 + r119) * 31) + ((int) (r120 ^ (r120 >>> 32)))) * 31;
        String r122 = this.registerType;
        if (r122 != null) goto L29;
        int r123 = 0;
    L30:
        int r124 = (r121 + r123) * 31;
        String r125 = this.registerApp;
        if (r125 != null) goto L33;
        int r126 = 0;
    L34:
        int r127 = (r124 + r126) * 31;
        String r128 = this.lastLoginTime;
        if (r128 == null) goto L39;
        r103 = r128.hashCode();
    L39:
        return r127 + r103;
    L33:
        r126 = r125.hashCode();
        goto L34
    L29:
        r123 = r122.hashCode();
        goto L30
    L25:
        r119 = r118.hashCode();
        goto L26
    L21:
        r116 = r115.hashCode();
        goto L22
    L17:
        r113 = r112.hashCode();
        goto L18
    L13:
        r110 = r109.hashCode();
        goto L14
    L9:
        r107 = r106.hashCode();
        goto L10
    L5:
        r104 = r102.hashCode();
        goto L6
    }

    public final String toString() {
        return "BaseInfo(userId=" + this.userId + ", appId=" + this.appId + ", avatarUrl=" + this.avatarUrl + ", screenName=" + this.screenName + ", mobile=" + this.mobile + ", safeMobile=" + this.safeMobile + ", email=" + this.email + ", connectInfo=" + this.connectInfo + ", registerTime=" + this.registerTime + ", registerType=" + this.registerType + ", registerApp=" + this.registerApp + ", lastLoginTime=" + this.lastLoginTime + ')';
    }

    public g() {
        this.userId = 0;
        this.appId = 0;
        this.avatarUrl = null;
        this.screenName = null;
        this.mobile = null;
        this.safeMobile = null;
        this.email = null;
        this.connectInfo = null;
        this.registerTime = 0;
        this.registerType = null;
        this.registerApp = null;
        this.lastLoginTime = null;
    }

    public final String a() {
        return this.avatarUrl;
    }

    public final List<k> b() {
        return this.connectInfo;
    }

    public final String c() {
        return this.email;
    }

    public final String d() {
        return this.mobile;
    }

    public final String e() {
        return this.screenName;
    }
}
