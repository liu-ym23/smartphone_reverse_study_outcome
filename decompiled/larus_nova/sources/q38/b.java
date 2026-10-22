package q38;

import com.bytedance.sdk.account.platform.api.IGoogleService;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.support.feature.result.CommonConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b%\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u00014B\u0083\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\n\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\n¢\u0006\u0004\b\u0011\u0010\u0012J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010'\u001a\u00020\nHÆ\u0003J\t\u0010(\u001a\u00020\fHÆ\u0003J\t\u0010)\u001a\u00020\nHÆ\u0003J\u0010\u0010*\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010,\u001a\u00020\nHÆ\u0003J\u008a\u0001\u0010-\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0010\u001a\u00020\nHÆ\u0001¢\u0006\u0002\u0010.J\u0013\u0010/\u001a\u00020\n2\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00101\u001a\u000202HÖ\u0001J\t\u00103\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u001aR\u0016\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\r\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u001a\u0010\u000e\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0014R\u0016\u0010\u0010\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u001a¨\u00065"}, d2 = {"Lcom/larus/account/base/model/AccountLocalItem;", "", "userId", "", "secUserId", CommonConstant.KEY_DISPLAY_NAME, "avatarUrl", "tenant", "Lcom/larus/account/base/model/AccountLocalItem$TenantInfo;", "isEnterprise", "", "lastActiveTime", "", "hasValidLogin", "showMembershipName", "membershipDisplayName", "isCurrent", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/account/base/model/AccountLocalItem$TenantInfo;ZJZLjava/lang/Boolean;Ljava/lang/String;Z)V", "getUserId", "()Ljava/lang/String;", "getSecUserId", "getDisplayName", "getAvatarUrl", "getTenant", "()Lcom/larus/account/base/model/AccountLocalItem$TenantInfo;", "()Z", "getLastActiveTime", "()J", "getHasValidLogin", "getShowMembershipName", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getMembershipDisplayName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/account/base/model/AccountLocalItem$TenantInfo;ZJZLjava/lang/Boolean;Ljava/lang/String;Z)Lcom/larus/account/base/model/AccountLocalItem;", "equals", "other", "hashCode", "", "toString", "TenantInfo", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class b {

    @SerializedName("avatar_url")
    private final String avatarUrl;

    @SerializedName(IGoogleService.ResponseKey.DISPLAY_NAME)
    private final String displayName;

    @SerializedName("has_valid_login")
    private final boolean hasValidLogin;

    @SerializedName("is_current")
    private final boolean isCurrent;

    @SerializedName("is_enterprise")
    private final boolean isEnterprise;

    @SerializedName("last_active_time")
    private final long lastActiveTime;

    @SerializedName("membership_display_name")
    private final String membershipDisplayName;

    @SerializedName("sec_user_id")
    private final String secUserId;

    @SerializedName("show_membership_name")
    private final Boolean showMembershipName;

    @SerializedName("tenant")
    private final a tenant;

    @SerializedName("user_id")
    private final String userId;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/larus/account/base/model/AccountLocalItem$TenantInfo;", "", "id", "", "name", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        @SerializedName("id")
        private final String f531535id;

        @SerializedName("name")
        private final String name;

        public a() {
            this(null, 3);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f531535id, r101.f531535id) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.name, r101.name) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f531535id;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.name;
            if (r104 == null) goto L11;
            r101 = r104.hashCode();
        L11:
            return r103 + r101;
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "TenantInfo(id=" + this.f531535id + ", name=" + this.name + ')';
        }

        public final String a() {
            return this.f531535id;
        }

        public final String b() {
            return this.name;
        }

        public /* synthetic */ a(String r100, int r101) {
            if ((r101 & 2) == 0) goto L5;
            r100 = null;
        L5:
            this(null, r100);
        }

        public a(String r100, String r101) {
            this.f531535id = r100;
            this.name = r101;
        }
    }

    public b() {
        this(null, null, null, null, null, false, 0, false, false, 2047);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.userId, r101.userId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.secUserId, r101.secUserId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.displayName, r101.displayName) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.avatarUrl, r101.avatarUrl) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.tenant, r101.tenant) == true) goto L24;
        return false;
    L24:
        if (this.isEnterprise == r101.isEnterprise) goto L27;
        return false;
    L27:
        if (this.lastActiveTime == r101.lastActiveTime) goto L30;
        return false;
    L30:
        if (this.hasValidLogin == r101.hasValidLogin) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.showMembershipName, r101.showMembershipName) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.membershipDisplayName, r101.membershipDisplayName) == true) goto L39;
        return false;
    L39:
        if (this.isCurrent == r101.isCurrent) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        String r100 = this.userId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.secUserId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.displayName;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.avatarUrl;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        a r113 = this.tenant;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        int r116 = 1231;
        if (this.isEnterprise == false) goto L25;
        int r117 = 1231;
    L26:
        long r118 = this.lastActiveTime;
        int r119 = (((r115 + r117) * 31) + ((int) (r118 ^ (r118 >>> 32)))) * 31;
        if (this.hasValidLogin == false) goto L29;
        int r120 = 1231;
    L30:
        int r121 = (r119 + r120) * 31;
        Boolean r122 = this.showMembershipName;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.membershipDisplayName;
        if (r125 == null) goto L38;
        r101 = r125.hashCode();
    L38:
        int r126 = (r124 + r101) * 31;
        if (this.isCurrent == true) goto L43;
        r116 = 1237;
    L43:
        return r126 + r116;
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = 1237;
        goto L30
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
        return "AccountLocalItem(userId=" + this.userId + ", secUserId=" + this.secUserId + ", displayName=" + this.displayName + ", avatarUrl=" + this.avatarUrl + ", tenant=" + this.tenant + ", isEnterprise=" + this.isEnterprise + ", lastActiveTime=" + this.lastActiveTime + ", hasValidLogin=" + this.hasValidLogin + ", showMembershipName=" + this.showMembershipName + ", membershipDisplayName=" + this.membershipDisplayName + ", isCurrent=" + this.isCurrent + ')';
    }

    public final String b() {
        return this.avatarUrl;
    }

    public final String c() {
        return this.displayName;
    }

    public final boolean d() {
        return this.hasValidLogin;
    }

    public final long e() {
        return this.lastActiveTime;
    }

    public final String f() {
        return this.membershipDisplayName;
    }

    public final String g() {
        return this.secUserId;
    }

    public final Boolean h() {
        return this.showMembershipName;
    }

    public final a i() {
        return this.tenant;
    }

    public final String j() {
        return this.userId;
    }

    public final boolean k() {
        return this.isCurrent;
    }

    public final boolean l() {
        return this.isEnterprise;
    }

    public /* synthetic */ b(String r110, String r111, String r112, String r210, a r211, boolean r212, long r213, boolean r214, boolean r215, int r216) {
        if ((r216 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r216 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r216 & 4) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r216 & 8) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r216 & 16) == 0) goto L21;
        a r104 = null;
    L23:
        if ((r216 & 32) == 0) goto L25;
        boolean r105 = false;
    L27:
        if ((r216 & 64) == 0) goto L29;
        long r113 = 0;
    L31:
        if ((r216 & 128) == 0) goto L33;
        boolean r114 = true;
    L35:
        if ((r216 & 1024) == 0) goto L37;
        boolean r115 = false;
    L38:
        this(r100, r101, r102, r103, r104, r105, r113, r114, null, null, r115);
        return;
    L37:
        r115 = r215;
        goto L38
    L33:
        r114 = r214;
        goto L35
    L29:
        r113 = r213;
        goto L31
    L25:
        r105 = r212;
        goto L27
    L21:
        r104 = r211;
        goto L23
    L17:
        r103 = r210;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    public b(String r100, String r101, String r102, String r103, a r104, boolean r105, long r106, boolean r107, Boolean r110, String r111, boolean r112) {
        this.userId = r100;
        this.secUserId = r101;
        this.displayName = r102;
        this.avatarUrl = r103;
        this.tenant = r104;
        this.isEnterprise = r105;
        this.lastActiveTime = r106;
        this.hasValidLogin = r107;
        this.showMembershipName = r110;
        this.membershipDisplayName = r111;
        this.isCurrent = r112;
    }

    public static b a(b r110, String r111, String r112, a r210, boolean r211, long r212, boolean r213, Boolean r214, String r215, boolean r216, int r217) {
        String r100 = null;
        if ((r217 & 1) == 0) goto L5;
        String r101 = r110.userId;
    L7:
        if ((r217 & 2) == 0) goto L9;
        r100 = r110.secUserId;
    L9:
        String r102 = r100;
        if ((r217 & 4) == 0) goto L12;
        String r103 = r110.displayName;
    L14:
        if ((r217 & 8) == 0) goto L16;
        String r104 = r110.avatarUrl;
    L18:
        if ((r217 & 16) == 0) goto L20;
        a r105 = r110.tenant;
    L22:
        if ((r217 & 32) == 0) goto L24;
        boolean r113 = r110.isEnterprise;
    L26:
        if ((r217 & 64) == 0) goto L28;
        long r114 = r110.lastActiveTime;
    L30:
        if ((r217 & 128) == 0) goto L32;
        boolean r115 = r110.hasValidLogin;
    L34:
        if ((r217 & 256) == 0) goto L36;
        Boolean r116 = r110.showMembershipName;
    L38:
        if ((r217 & 512) == 0) goto L40;
        String r117 = r110.membershipDisplayName;
    L42:
        if ((r217 & 1024) == 0) goto L44;
        boolean r118 = r110.isCurrent;
    L45:
        r110.getClass();
        return new b(r101, r102, r103, r104, r105, r113, r114, r115, r116, r117, r118);
    L44:
        r118 = r216;
        goto L45
    L40:
        r117 = r215;
        goto L42
    L36:
        r116 = r214;
        goto L38
    L32:
        r115 = r213;
        goto L34
    L28:
        r114 = r212;
        goto L30
    L24:
        r113 = r211;
        goto L26
    L20:
        r105 = r210;
        goto L22
    L16:
        r104 = r112;
        goto L18
    L12:
        r103 = r111;
        goto L14
    L5:
        r101 = null;
        goto L7
    }
}
