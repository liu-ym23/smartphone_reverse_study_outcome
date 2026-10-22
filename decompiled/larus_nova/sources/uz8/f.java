package uz8;

import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.larus.doc.sdk.api.VoiceInputFrom;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u007f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0011\u0010\u0012J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0019J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0019J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u0086\u0001\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\t2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u000bHÖ\u0001R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u0013R\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u0013R\u0012\u0010\r\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/larus/commercemembership/api/model/SubscriptionEntryConfig;", "", "actionBar", "Lcom/larus/commercemembership/api/model/SubscriptionActionBar;", "settingsPage", "Lcom/larus/commercemembership/api/model/SubscriptionSettingsPage;", "settingsUpgradePage", "settingsManagementPage", "hasActiveSubscription", "", "subsStatus", "", "showMembershipName", "membershipDisplayName", LiveEndPageData.TAG_SUBSCRIPTION, "Lcom/larus/commercemembership/api/model/SubscriptionInfo;", CommonConstant.KEY_COUNTRY_CODE, "<init>", "(Lcom/larus/commercemembership/api/model/SubscriptionActionBar;Lcom/larus/commercemembership/api/model/SubscriptionSettingsPage;Lcom/larus/commercemembership/api/model/SubscriptionSettingsPage;Lcom/larus/commercemembership/api/model/SubscriptionSettingsPage;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Lcom/larus/commercemembership/api/model/SubscriptionInfo;Ljava/lang/String;)V", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "()Ljava/lang/Boolean;", "component6", "component7", "component8", "component9", "component10", "copy", "(Lcom/larus/commercemembership/api/model/SubscriptionActionBar;Lcom/larus/commercemembership/api/model/SubscriptionSettingsPage;Lcom/larus/commercemembership/api/model/SubscriptionSettingsPage;Lcom/larus/commercemembership/api/model/SubscriptionSettingsPage;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Lcom/larus/commercemembership/api/model/SubscriptionInfo;Ljava/lang/String;)Lcom/larus/commercemembership/api/model/SubscriptionEntryConfig;", "equals", "other", "hashCode", "", "toString", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class f {

    @SerializedName(VoiceInputFrom.ACTION_BAR)
    public final e actionBar;

    @SerializedName("country_code")
    public final String countryCode;

    @SerializedName("has_active_subscription")
    public final Boolean hasActiveSubscription;

    @SerializedName("membership_display_name")
    public final String membershipDisplayName;

    @SerializedName("settings_management_page")
    public final h settingsManagementPage;

    @SerializedName("settings_page")
    public final h settingsPage;

    @SerializedName("settings_upgrade_page")
    public final h settingsUpgradePage;

    @SerializedName("show_membership_name")
    public final Boolean showMembershipName;

    @SerializedName("subs_status")
    public final String subsStatus;

    @SerializedName(LiveEndPageData.TAG_SUBSCRIPTION)
    public final g subscription;

    public f() {
        this(null, null, null, null, null, null, null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.actionBar, r101.actionBar) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.settingsPage, r101.settingsPage) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.settingsUpgradePage, r101.settingsUpgradePage) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.settingsManagementPage, r101.settingsManagementPage) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.hasActiveSubscription, r101.hasActiveSubscription) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.subsStatus, r101.subsStatus) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.showMembershipName, r101.showMembershipName) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.membershipDisplayName, r101.membershipDisplayName) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.subscription, r101.subscription) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.countryCode, r101.countryCode) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        e r100 = this.actionBar;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        h r104 = this.settingsPage;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        h r107 = this.settingsUpgradePage;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        h r110 = this.settingsManagementPage;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Boolean r113 = this.hasActiveSubscription;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.subsStatus;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Boolean r119 = this.showMembershipName;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.membershipDisplayName;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        g r125 = this.subscription;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.countryCode;
        if (r128 == null) goto L43;
        r101 = r128.hashCode();
    L43:
        return r127 + r101;
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
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
        return "SubscriptionEntryConfig(actionBar=" + this.actionBar + ", settingsPage=" + this.settingsPage + ", settingsUpgradePage=" + this.settingsUpgradePage + ", settingsManagementPage=" + this.settingsManagementPage + ", hasActiveSubscription=" + this.hasActiveSubscription + ", subsStatus=" + this.subsStatus + ", showMembershipName=" + this.showMembershipName + ", membershipDisplayName=" + this.membershipDisplayName + ", subscription=" + this.subscription + ", countryCode=" + this.countryCode + ')';
    }

    public f(e r100, h r101, h r102, h r103, Boolean r104, String r105, Boolean r106, String r107, g r108, String r110) {
        this.actionBar = r100;
        this.settingsPage = r101;
        this.settingsUpgradePage = r102;
        this.settingsManagementPage = r103;
        this.hasActiveSubscription = r104;
        this.subsStatus = r105;
        this.showMembershipName = r106;
        this.membershipDisplayName = r107;
        this.subscription = r108;
        this.countryCode = r110;
    }
}
