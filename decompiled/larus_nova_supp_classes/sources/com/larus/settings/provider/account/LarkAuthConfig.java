package com.larus.settings.provider.account;

import android.util.EventsUtils;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u001f\b\u0087\b\u0018\u00002\u00020\u0001Bm\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\u0012\b\u0002\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0006HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010$\u001a\u00020\u0006HÆ\u0003J\t\u0010%\u001a\u00020\u0006HÆ\u0003J\u0013\u0010&\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\fHÆ\u0003J\t\u0010'\u001a\u00020\u0006HÆ\u0003J\t\u0010(\u001a\u00020\u000fHÆ\u0003Jo\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\u0012\b\u0002\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u000fHÆ\u0001J\u0013\u0010*\u001a\u00020\u00062\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020\u0003HÖ\u0001J\t\u0010-\u001a\u00020\bHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\t\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0016\u0010\n\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R \u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\r\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0016\u0010\u000e\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006."}, d2 = {"Lcom/larus/settings/provider/account/LarkAuthConfig;", XmlPullParser.NO_NAMESPACE, "heartBeatInterval", XmlPullParser.NO_NAMESPACE, "maxRetryCount", "fetchDomainsAll", XmlPullParser.NO_NAMESPACE, "enterpriseAuthScope", XmlPullParser.NO_NAMESPACE, "enableEnterpriseLogin", "enableEnterpriseLoginForIntranet", "supportAppLinkPackageNames", XmlPullParser.NO_NAMESPACE, "enterpriseAddAccountTipEnabled", "refreshAt", XmlPullParser.NO_NAMESPACE, "<init>", "(IIZLjava/lang/String;ZZLjava/util/List;ZF)V", "getHeartBeatInterval", "()I", "getMaxRetryCount", "getFetchDomainsAll", "()Z", "getEnterpriseAuthScope", "()Ljava/lang/String;", "getEnableEnterpriseLogin", "getEnableEnterpriseLoginForIntranet", "getSupportAppLinkPackageNames", "()Ljava/util/List;", "getEnterpriseAddAccountTipEnabled", "getRefreshAt", "()F", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
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
    public static /* synthetic */ LarkAuthConfig copy$default(LarkAuthConfig r10, int r11, int r12, boolean r13, String r14, boolean r15, boolean r16, List r17, boolean r18, float r19, int r20, Object r21) {
        if ((r20 & 1) == 0) goto L5;
        int r2 = r10.heartBeatInterval;
    L7:
        if ((r20 & 2) == 0) goto L9;
        int r3 = r10.maxRetryCount;
    L11:
        if ((r20 & 4) == 0) goto L13;
        boolean r4 = r10.fetchDomainsAll;
    L15:
        if ((r20 & 8) == 0) goto L17;
        String r5 = r10.enterpriseAuthScope;
    L19:
        if ((r20 & 16) == 0) goto L21;
        boolean r6 = r10.enableEnterpriseLogin;
    L23:
        if ((r20 & 32) == 0) goto L25;
        boolean r7 = r10.enableEnterpriseLoginForIntranet;
    L27:
        if ((r20 & 64) == 0) goto L29;
        List r8 = r10.supportAppLinkPackageNames;
    L31:
        if ((r20 & 128) == 0) goto L33;
        boolean r9 = r10.enterpriseAddAccountTipEnabled;
    L35:
        if ((r20 & 256) == 0) goto L37;
        float r1 = r10.refreshAt;
    L39:
        return r10.copy(r2, r3, r4, r5, r6, r7, r8, r9, r1);
    L37:
        r1 = r19;
        goto L39
    L33:
        r9 = r18;
        goto L35
    L29:
        r8 = r17;
        goto L31
    L25:
        r7 = r16;
        goto L27
    L21:
        r6 = r15;
        goto L23
    L17:
        r5 = r14;
        goto L19
    L13:
        r4 = r13;
        goto L15
    L9:
        r3 = r12;
        goto L11
    L5:
        r2 = r11;
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

    public final LarkAuthConfig copy(int r12, int r13, boolean r14, String r15, boolean r16, boolean r17, List<String> r18, boolean r19, float r20) {
        return new LarkAuthConfig(r12, r13, r14, r15, r16, r17, r18, r19, r20);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof LarkAuthConfig) == true) goto L8;
        return false;
    L8:
        LarkAuthConfig r6 = (LarkAuthConfig) r5;
        if (this.heartBeatInterval == r6.heartBeatInterval) goto L12;
        return false;
    L12:
        if (this.maxRetryCount == r6.maxRetryCount) goto L15;
        return false;
    L15:
        if (this.fetchDomainsAll == r6.fetchDomainsAll) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.enterpriseAuthScope, r6.enterpriseAuthScope) == true) goto L21;
        return false;
    L21:
        if (this.enableEnterpriseLogin == r6.enableEnterpriseLogin) goto L24;
        return false;
    L24:
        if (this.enableEnterpriseLoginForIntranet == r6.enableEnterpriseLoginForIntranet) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.supportAppLinkPackageNames, r6.supportAppLinkPackageNames) == true) goto L30;
        return false;
    L30:
        if (this.enterpriseAddAccountTipEnabled == r6.enterpriseAddAccountTipEnabled) goto L33;
        return false;
    L33:
        if (Float.compare(this.refreshAt, r6.refreshAt) == 0) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.heartBeatInterval * 31) + this.maxRetryCount) * 31;
        int r2 = 1231;
        if (this.fetchDomainsAll == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        String r4 = this.enterpriseAuthScope;
        int r5 = 0;
        if (r4 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r3 + r6) * 31;
        if (this.enableEnterpriseLogin == false) goto L13;
        int r8 = 1231;
    L14:
        int r9 = (r7 + r8) * 31;
        if (this.enableEnterpriseLoginForIntranet == false) goto L17;
        int r10 = 1231;
    L18:
        int r11 = (r9 + r10) * 31;
        List<String> r12 = this.supportAppLinkPackageNames;
        if (r12 == null) goto L22;
        r5 = r12.hashCode();
    L22:
        int r13 = (r11 + r5) * 31;
        if (this.enterpriseAddAccountTipEnabled == true) goto L27;
        r2 = 1237;
    L27:
        return ((r13 + r2) * 31) + Float.floatToIntBits(this.refreshAt);
    L17:
        r10 = 1237;
        goto L18
    L13:
        r8 = 1237;
        goto L14
    L9:
        r6 = r4.hashCode();
        goto L10
    L5:
        r1 = 1237;
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

    public LarkAuthConfig(int r1, int r2, boolean r3, String r4, boolean r5, boolean r6, List<String> r7, boolean r8, float r9) {
        this.heartBeatInterval = r1;
        this.maxRetryCount = r2;
        this.fetchDomainsAll = r3;
        this.enterpriseAuthScope = r4;
        this.enableEnterpriseLogin = r5;
        this.enableEnterpriseLoginForIntranet = r6;
        this.supportAppLinkPackageNames = r7;
        this.enterpriseAddAccountTipEnabled = r8;
        this.refreshAt = r9;
    }

    public /* synthetic */ LarkAuthConfig(int r13, int r14, boolean r15, String r16, boolean r17, boolean r18, List r19, boolean r20, float r21, int r22, DefaultConstructorMarker r23) {
        if ((r22 & 1) == 0) goto L5;
        int r1 = 3600;
    L6:
        boolean r3 = false;
        if ((r22 & 2) == 0) goto L9;
        int r2 = 0;
    L11:
        if ((r22 & 4) == 0) goto L13;
        boolean r4 = false;
    L15:
        if ((r22 & 8) == 0) goto L17;
        String r5 = "offline_access doubao:userinfo:readonly doubao:suitemanagement:manage";
    L18:
        boolean r7 = true;
        if ((r22 & 16) == 0) goto L21;
        boolean r6 = true;
    L23:
        if ((r22 & 32) != 0) goto L27;
        r7 = r18;
    L27:
        if ((r22 & 64) == 0) goto L29;
        List r8 = CollectionsKt.listOf(new String[]{"com.ss.android.lark", "com.ss.android.lark.debug", "com.larksuite.suite", "com.larksuite.suite.debug"});
    L31:
        if ((r22 & 128) != 0) goto L35;
        r3 = r20;
    L35:
        if ((r22 & 256) == 0) goto L37;
        float r0 = 0.8f;
    L38:
        this(r1, r2, r4, r5, r6, r7, r8, r3, r0);
        return;
    L37:
        r0 = r21;
        goto L38
    L29:
        r8 = r19;
        goto L31
    L21:
        r6 = r17;
        goto L23
    L17:
        r5 = r16;
        goto L18
    L13:
        r4 = r15;
        goto L15
    L9:
        r2 = r14;
        goto L11
    L5:
        r1 = r13;
        goto L6
    }
}
