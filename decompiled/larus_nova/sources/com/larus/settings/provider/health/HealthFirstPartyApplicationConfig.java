package com.larus.settings.provider.health;

import com.google.gson.annotations.SerializedName;
import com.larus.common.apphost.AppHost;
import com.larus.home.impl.sdk.e2;
import com.larus.nova.R;
import com.larus.platform.IFlowSdkDepend;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B_\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u000b\u0010\fR \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R \u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/larus/settings/provider/health/HealthFirstPartyApplicationConfig;", "Ljava/io/Serializable;", "healthBotList", "", "", "panelTotalContent", "panelLinkRanges", "Lcom/larus/settings/provider/health/HealthAgreementInfo;", "settingAgreementTitle", "settingAgreementUrl", "settingAgreementTrackName", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getHealthBotList", "()Ljava/util/List;", "getPanelTotalContent", "()Ljava/lang/String;", "getPanelLinkRanges", "getSettingAgreementTitle", "getSettingAgreementUrl", "getSettingAgreementTrackName", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HealthFirstPartyApplicationConfig implements Serializable {

    @SerializedName("bot_ids")
    private final List<String> healthBotList;

    @SerializedName("panel_link_ranges")
    private final List<HealthAgreementInfo> panelLinkRanges;

    @SerializedName("panel_total_content")
    private final String panelTotalContent;

    @SerializedName("setting_agreement_title")
    private final String settingAgreementTitle;

    @SerializedName("setting_agreement_track_name")
    private final String settingAgreementTrackName;

    @SerializedName("setting_agreement_url")
    private final String settingAgreementUrl;

    public HealthFirstPartyApplicationConfig() {
        this(null, null, null, null, null, null, 63, null);
    }

    public final List<String> getHealthBotList() {
        return this.healthBotList;
    }

    public final List<HealthAgreementInfo> getPanelLinkRanges() {
        return this.panelLinkRanges;
    }

    public final String getPanelTotalContent() {
        return this.panelTotalContent;
    }

    public final String getSettingAgreementTitle() {
        return this.settingAgreementTitle;
    }

    public final String getSettingAgreementTrackName() {
        return this.settingAgreementTrackName;
    }

    public final String getSettingAgreementUrl() {
        return this.settingAgreementUrl;
    }

    public HealthFirstPartyApplicationConfig(List<String> r100, String r101, List<HealthAgreementInfo> r102, String r103, String r104, String r105) {
        this.healthBotList = r100;
        this.panelTotalContent = r101;
        this.panelLinkRanges = r102;
        this.settingAgreementTitle = r103;
        this.settingAgreementUrl = r104;
        this.settingAgreementTrackName = r105;
    }

    public HealthFirstPartyApplicationConfig(List r100, String r101, List r110, String r111, String r112, String r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 1) == 0) goto L6;
        r100 = CollectionsKt.emptyList();
    L6:
        if ((r114 & 2) == 0) goto L8;
        r101 = AppHost.f326268a.getApplication().getString(R.string.larus_Health_compliance_popup);
    L8:
        String r116 = r101;
        String r102 = "notice_for_health_consultation";
        String r103 = "";
        if ((r114 & 4) == 0) goto L29;
        HealthAgreementInfo[] r104 = new HealthAgreementInfo[3];
        IFlowSdkDepend r105 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r105 == null) goto L13;
        r105.r0();
        e2 r106 = e2.f346164a;
        String r107 = e2.f346165b;
    L14:
        if (r107 != null) goto L16;
        r107 = "";
    L16:
        r104[0] = new HealthAgreementInfo(r107, 87, 10, "user_service_agreement");
        IFlowSdkDepend r108 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r108 == null) goto L19;
        r108.r0();
        e2 r109 = e2.f346164a;
        String r117 = e2.f346167d;
    L20:
        if (r117 != null) goto L22;
        r117 = "";
    L22:
        r104[1] = new HealthAgreementInfo(r117, 97, 8, "privacy_policy");
        IFlowSdkDepend r118 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r118 == null) goto L25;
        r118.r0();
        e2 r119 = e2.f346164a;
        String r120 = e2.f346166c;
    L26:
        if (r120 != null) goto L28;
        r120 = "";
    L28:
        r104[2] = new HealthAgreementInfo(r120, 107, 14, "notice_for_health_consultation");
        r110 = CollectionsKt.listOf(r104);
        goto L29
    L25:
        r120 = null;
        goto L26
    L19:
        r117 = null;
        goto L20
    L13:
        r107 = null;
    L29:
        List r121 = r110;
        if ((r114 & 8) == 0) goto L32;
        r111 = AppHost.f326268a.getApplication().getString(R.string.larus_Health_compliance_popup_notice);
    L32:
        String r122 = r111;
        if ((r114 & 16) == 0) goto L40;
        IFlowSdkDepend r123 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r123 == null) goto L37;
        r123.r0();
        e2 r124 = e2.f346164a;
        r112 = e2.f346166c;
    L38:
        if (r112 != null) goto L40;
    L42:
        if ((r114 & 32) != 0) goto L45;
        r102 = r113;
    L45:
        this(r100, r116, r121, r122, r103, r102);
        return;
    L37:
        r112 = null;
    L40:
        r103 = r112;
        goto L42
    }
}
