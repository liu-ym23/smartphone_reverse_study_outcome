package com.larus.settings.provider.account;

import com.bytedance.android.livesdk.announcement.AnnouncementViewModel;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u001f\b\u0087\b\u0018\u00002\u00020\u0001Bm\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\u0012\b\u0002\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0006HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010$\u001a\u00020\u0006HÆ\u0003J\t\u0010%\u001a\u00020\u0006HÆ\u0003J\u0013\u0010&\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\fHÆ\u0003J\t\u0010'\u001a\u00020\u0006HÆ\u0003J\t\u0010(\u001a\u00020\u000fHÆ\u0003Jo\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\u0012\b\u0002\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u000fHÆ\u0001J\u0013\u0010*\u001a\u00020\u00062\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020\u0003HÖ\u0001J\t\u0010-\u001a\u00020\bHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\t\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0016\u0010\n\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R \u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\r\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0016\u0010\u000e\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006."}, d2 = {"Lcom/larus/settings/provider/account/LarkAuthConfig;", "", "heartBeatInterval", "", "maxRetryCount", "fetchDomainsAll", "", "enterpriseAuthScope", "", "enableEnterpriseLogin", "enableEnterpriseLoginForIntranet", "supportAppLinkPackageNames", "", "enterpriseAddAccountTipEnabled", "refreshAt", "", "<init>", "(IIZLjava/lang/String;ZZLjava/util/List;ZF)V", "getHeartBeatInterval", "()I", "getMaxRetryCount", "getFetchDomainsAll", "()Z", "getEnterpriseAuthScope", "()Ljava/lang/String;", "getEnableEnterpriseLogin", "getEnableEnterpriseLoginForIntranet", "getSupportAppLinkPackageNames", "()Ljava/util/List;", "getEnterpriseAddAccountTipEnabled", "getRefreshAt", "()F", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LarkAuthConfig {

    @SerializedName("enable_enterprise_login")
    private final boolean enableEnterpriseLogin;

    @SerializedName("enable_enterprise_login_for_intranet")
    private final boolean enableEnterpriseLoginForIntranet;

    @SerializedName("enterprise_add_account_tip_enabled")
    private final boolean enterpriseAddAccountTipEnabled;

    @SerializedName("enterprise_auth_scope")
    private final String enterpriseAuthScope;

    @SerializedName("fetch_domains_all")
    private final boolean fetchDomainsAll;

    @SerializedName("heartbeat_interval")
    private final int heartBeatInterval;

    @SerializedName("max_retry_count")
    private final int maxRetryCount;

    @SerializedName("refresh_at")
    private final float refreshAt;

    @SerializedName("support_applink_package_names")
    private final List<String> supportAppLinkPackageNames;

    public LarkAuthConfig() {
        this(0, 0, false, null, false, false, null, false, 0.0f, 511, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LarkAuthConfig copy$default(LarkAuthConfig r110, int r111, int r112, boolean r113, String r114, boolean r115, boolean r116, List r117, boolean r118, float r119, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        int r100 = r110.heartBeatInterval;
    L7:
        if ((r210 & 2) == 0) goto L9;
        int r101 = r110.maxRetryCount;
    L11:
        if ((r210 & 4) == 0) goto L13;
        boolean r102 = r110.fetchDomainsAll;
    L15:
        if ((r210 & 8) == 0) goto L17;
        String r103 = r110.enterpriseAuthScope;
    L19:
        if ((r210 & 16) == 0) goto L21;
        boolean r104 = r110.enableEnterpriseLogin;
    L23:
        if ((r210 & 32) == 0) goto L25;
        boolean r105 = r110.enableEnterpriseLoginForIntranet;
    L27:
        if ((r210 & 64) == 0) goto L29;
        List r106 = r110.supportAppLinkPackageNames;
    L31:
        if ((r210 & 128) == 0) goto L33;
        boolean r107 = r110.enterpriseAddAccountTipEnabled;
    L35:
        if ((r210 & 256) == 0) goto L37;
        float r108 = r110.refreshAt;
    L39:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r108);
    L37:
        r108 = r119;
        goto L39
    L33:
        r107 = r118;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final int component1() {
        return this.heartBeatInterval;
    }

    public final int component2() {
        return this.maxRetryCount;
    }

    public final boolean component3() {
        return this.fetchDomainsAll;
    }

    public final String component4() {
        return this.enterpriseAuthScope;
    }

    public final boolean component5() {
        return this.enableEnterpriseLogin;
    }

    public final boolean component6() {
        return this.enableEnterpriseLoginForIntranet;
    }

    public final List<String> component7() {
        return this.supportAppLinkPackageNames;
    }

    public final boolean component8() {
        return this.enterpriseAddAccountTipEnabled;
    }

    public final float component9() {
        return this.refreshAt;
    }

    public final LarkAuthConfig copy(int r110, int r111, boolean r112, String r113, boolean r114, boolean r115, List<String> r116, boolean r117, float r210) {
        return new LarkAuthConfig(r110, r111, r112, r113, r114, r115, r116, r117, r210);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof LarkAuthConfig) == true) goto L8;
        return false;
    L8:
        LarkAuthConfig r101 = (LarkAuthConfig) r100;
        if (this.heartBeatInterval == r101.heartBeatInterval) goto L12;
        return false;
    L12:
        if (this.maxRetryCount == r101.maxRetryCount) goto L15;
        return false;
    L15:
        if (this.fetchDomainsAll == r101.fetchDomainsAll) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.enterpriseAuthScope, r101.enterpriseAuthScope) == true) goto L21;
        return false;
    L21:
        if (this.enableEnterpriseLogin == r101.enableEnterpriseLogin) goto L24;
        return false;
    L24:
        if (this.enableEnterpriseLoginForIntranet == r101.enableEnterpriseLoginForIntranet) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.supportAppLinkPackageNames, r101.supportAppLinkPackageNames) == true) goto L30;
        return false;
    L30:
        if (this.enterpriseAddAccountTipEnabled == r101.enterpriseAddAccountTipEnabled) goto L33;
        return false;
    L33:
        if (Float.compare(this.refreshAt, r101.refreshAt) == 0) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.heartBeatInterval * 31) + this.maxRetryCount) * 31;
        int r101 = 1231;
        if (this.fetchDomainsAll == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        String r104 = this.enterpriseAuthScope;
        int r105 = 0;
        if (r104 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r103 + r106) * 31;
        if (this.enableEnterpriseLogin == false) goto L13;
        int r108 = 1231;
    L14:
        int r109 = (r107 + r108) * 31;
        if (this.enableEnterpriseLoginForIntranet == false) goto L17;
        int r110 = 1231;
    L18:
        int r111 = (r109 + r110) * 31;
        List<String> r112 = this.supportAppLinkPackageNames;
        if (r112 == null) goto L22;
        r105 = r112.hashCode();
    L22:
        int r113 = (r111 + r105) * 31;
        if (this.enterpriseAddAccountTipEnabled == true) goto L27;
        r101 = 1237;
    L27:
        return ((r113 + r101) * 31) + Float.floatToIntBits(this.refreshAt);
    L17:
        r110 = 1237;
        goto L18
    L13:
        r108 = 1237;
        goto L14
    L9:
        r106 = r104.hashCode();
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public String toString() {
        return "LarkAuthConfig(heartBeatInterval=" + this.heartBeatInterval + ", maxRetryCount=" + this.maxRetryCount + ", fetchDomainsAll=" + this.fetchDomainsAll + ", enterpriseAuthScope=" + this.enterpriseAuthScope + ", enableEnterpriseLogin=" + this.enableEnterpriseLogin + ", enableEnterpriseLoginForIntranet=" + this.enableEnterpriseLoginForIntranet + ", supportAppLinkPackageNames=" + this.supportAppLinkPackageNames + ", enterpriseAddAccountTipEnabled=" + this.enterpriseAddAccountTipEnabled + ", refreshAt=" + this.refreshAt + ')';
    }

    public final boolean getEnableEnterpriseLogin() {
        return this.enableEnterpriseLogin;
    }

    public final boolean getEnableEnterpriseLoginForIntranet() {
        return this.enableEnterpriseLoginForIntranet;
    }

    public final boolean getEnterpriseAddAccountTipEnabled() {
        return this.enterpriseAddAccountTipEnabled;
    }

    public final String getEnterpriseAuthScope() {
        return this.enterpriseAuthScope;
    }

    public final boolean getFetchDomainsAll() {
        return this.fetchDomainsAll;
    }

    public final int getHeartBeatInterval() {
        return this.heartBeatInterval;
    }

    public final int getMaxRetryCount() {
        return this.maxRetryCount;
    }

    public final float getRefreshAt() {
        return this.refreshAt;
    }

    public final List<String> getSupportAppLinkPackageNames() {
        return this.supportAppLinkPackageNames;
    }

    public LarkAuthConfig(int r100, int r101, boolean r102, String r103, boolean r104, boolean r105, List<String> r106, boolean r107, float r108) {
        this.heartBeatInterval = r100;
        this.maxRetryCount = r101;
        this.fetchDomainsAll = r102;
        this.enterpriseAuthScope = r103;
        this.enableEnterpriseLogin = r104;
        this.enableEnterpriseLoginForIntranet = r105;
        this.supportAppLinkPackageNames = r106;
        this.enterpriseAddAccountTipEnabled = r107;
        this.refreshAt = r108;
    }

    public /* synthetic */ LarkAuthConfig(int r110, int r111, boolean r112, String r113, boolean r114, boolean r115, List r116, boolean r210, float r211, int r212, DefaultConstructorMarker r213) {
        if ((r212 & 1) == 0) goto L5;
        int r100 = AnnouncementViewModel.HOUR_DURATION;
    L6:
        boolean r101 = false;
        if ((r212 & 2) == 0) goto L9;
        int r102 = 0;
    L11:
        if ((r212 & 4) == 0) goto L13;
        boolean r103 = false;
    L15:
        if ((r212 & 8) == 0) goto L17;
        String r104 = "offline_access doubao:userinfo:readonly doubao:suitemanagement:manage";
    L18:
        boolean r105 = true;
        if ((r212 & 16) == 0) goto L21;
        boolean r106 = true;
    L23:
        if ((r212 & 32) != 0) goto L27;
        r105 = r115;
    L27:
        if ((r212 & 64) == 0) goto L29;
        List r107 = CollectionsKt.listOf(new String[]{"com.ss.android.lark", "com.ss.android.lark.debug", "com.larksuite.suite", "com.larksuite.suite.debug"});
    L31:
        if ((r212 & 128) != 0) goto L35;
        r101 = r210;
    L35:
        if ((r212 & 256) == 0) goto L37;
        float r108 = 0.8f;
    L38:
        this(r100, r102, r103, r104, r106, r105, r107, r101, r108);
        return;
    L37:
        r108 = r211;
        goto L38
    L29:
        r107 = r116;
        goto L31
    L21:
        r106 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L18
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L6
    }
}
