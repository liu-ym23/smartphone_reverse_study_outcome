package com.larus.dora.impl.network;

import com.google.gson.annotations.SerializedName;
import com.tencent.connect.common.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b%\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u0000 82\u00020\u0001:\u00018B\u0089\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00101\u001a\u00020\u000eHÆ\u0003J\u008b\u0001\u00102\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001J\u0013\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00106\u001a\u00020\u000eHÖ\u0001J\t\u00107\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R \u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0012\"\u0004\b\u001c\u0010\u0014R \u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0012\"\u0004\b\u001e\u0010\u0014R \u0010\t\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014R \u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0012\"\u0004\b\"\u0010\u0014R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0012R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0012R\u0016\u0010\r\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&¨\u00069"}, d2 = {"Lcom/larus/dora/impl/network/UserSettingsExtra;", "", "pvad", "", "notificationStatus", "notificationFrequency", "notificationPrivacyStatus", "proactiveStatus", "proactiveMethod", "proactiveFrequency", "proactivePrivacyStatus", "defaultIconLight", "defaultIconDark", "doraSseFrontierDuration", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getPvad", "()Ljava/lang/String;", "setPvad", "(Ljava/lang/String;)V", "getNotificationStatus", "setNotificationStatus", "getNotificationFrequency", "setNotificationFrequency", "getNotificationPrivacyStatus", "setNotificationPrivacyStatus", "getProactiveStatus", "setProactiveStatus", "getProactiveMethod", "setProactiveMethod", "getProactiveFrequency", "setProactiveFrequency", "getProactivePrivacyStatus", "setProactivePrivacyStatus", "getDefaultIconLight", "getDefaultIconDark", "getDoraSseFrontierDuration", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class g0 {

    @SerializedName("app_default_icon_dark")
    private final String defaultIconDark;

    @SerializedName("app_default_icon_light")
    private final String defaultIconLight;

    @SerializedName("dora_sse_frontier_duration")
    private final int doraSseFrontierDuration;

    @SerializedName("dora_notification_frequence")
    private String notificationFrequency;

    @SerializedName("dora_notification_privacy")
    private String notificationPrivacyStatus;

    @SerializedName("dora_notification_status")
    private String notificationStatus;

    @SerializedName("dora_proactive_frequence")
    private String proactiveFrequency;

    @SerializedName("dora_proactive_method")
    private String proactiveMethod;

    @SerializedName("dora_proactive_privacy")
    private String proactivePrivacyStatus;

    @SerializedName("dora_proactive_status")
    private String proactiveStatus;

    @SerializedName("pvad")
    private String pvad;

    public static final class a {
    }

    static {
    }

    public g0() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g0) == true) goto L8;
        return false;
    L8:
        g0 r101 = (g0) r100;
        if (Intrinsics.areEqual(this.pvad, r101.pvad) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.notificationStatus, r101.notificationStatus) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.notificationFrequency, r101.notificationFrequency) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.notificationPrivacyStatus, r101.notificationPrivacyStatus) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.proactiveStatus, r101.proactiveStatus) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.proactiveMethod, r101.proactiveMethod) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.proactiveFrequency, r101.proactiveFrequency) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.proactivePrivacyStatus, r101.proactivePrivacyStatus) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.defaultIconLight, r101.defaultIconLight) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.defaultIconDark, r101.defaultIconDark) == true) goto L39;
        return false;
    L39:
        if (this.doraSseFrontierDuration == r101.doraSseFrontierDuration) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        String r100 = this.pvad;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.notificationStatus;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.notificationFrequency;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.notificationPrivacyStatus;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.proactiveStatus;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.proactiveMethod;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.proactiveFrequency;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.proactivePrivacyStatus;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.defaultIconLight;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.defaultIconDark;
        if (r128 == null) goto L43;
        r101 = r128.hashCode();
    L43:
        return ((r127 + r101) * 31) + this.doraSseFrontierDuration;
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
        return "UserSettingsExtra(pvad=" + this.pvad + ", notificationStatus=" + this.notificationStatus + ", notificationFrequency=" + this.notificationFrequency + ", notificationPrivacyStatus=" + this.notificationPrivacyStatus + ", proactiveStatus=" + this.proactiveStatus + ", proactiveMethod=" + this.proactiveMethod + ", proactiveFrequency=" + this.proactiveFrequency + ", proactivePrivacyStatus=" + this.proactivePrivacyStatus + ", defaultIconLight=" + this.defaultIconLight + ", defaultIconDark=" + this.defaultIconDark + ", doraSseFrontierDuration=" + this.doraSseFrontierDuration + ')';
    }

    public final String b() {
        return this.defaultIconDark;
    }

    public final String c() {
        return this.defaultIconLight;
    }

    public final int d() {
        return this.doraSseFrontierDuration;
    }

    public final String e() {
        return this.notificationFrequency;
    }

    public final String f() {
        return this.notificationPrivacyStatus;
    }

    public final String g() {
        return this.notificationStatus;
    }

    public final String h() {
        return this.proactiveFrequency;
    }

    public final String i() {
        return this.proactiveMethod;
    }

    public final String j() {
        return this.proactiveStatus;
    }

    public final String k() {
        return this.pvad;
    }

    public /* synthetic */ g0(int r110) {
        this(null, "2", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, "1", "2", "2", "3", "1", "", "", 70);
    }

    public static g0 a(g0 r110, String r111, String r112, String r113, String r210, String r211, String r212, int r213) {
        String r100 = null;
        if ((r213 & 1) == 0) goto L5;
        String r101 = r110.pvad;
    L7:
        if ((r213 & 2) == 0) goto L9;
        String r102 = r110.notificationStatus;
    L11:
        if ((r213 & 4) == 0) goto L13;
        String r103 = r110.notificationFrequency;
    L15:
        if ((r213 & 8) == 0) goto L17;
        String r104 = r110.notificationPrivacyStatus;
    L19:
        if ((r213 & 16) == 0) goto L21;
        String r105 = r110.proactiveStatus;
    L23:
        if ((r213 & 32) == 0) goto L25;
        String r114 = r110.proactiveMethod;
    L27:
        if ((r213 & 64) == 0) goto L29;
        String r115 = r110.proactiveFrequency;
    L31:
        if ((r213 & 128) == 0) goto L33;
        String r116 = r110.proactivePrivacyStatus;
    L35:
        if ((r213 & 256) == 0) goto L37;
        String r117 = r110.defaultIconLight;
    L39:
        if ((r213 & 512) == 0) goto L41;
        r100 = r110.defaultIconDark;
    L41:
        String r118 = r100;
        if ((r213 & 1024) == 0) goto L44;
        int r119 = r110.doraSseFrontierDuration;
    L46:
        return new g0(r101, r102, r103, r104, r105, r114, r115, r116, r117, r118, r119);
    L44:
        r119 = 0;
        goto L46
    L37:
        r117 = null;
        goto L39
    L33:
        r116 = null;
        goto L35
    L29:
        r115 = r212;
        goto L31
    L25:
        r114 = r211;
        goto L27
    L21:
        r105 = r210;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = null;
        goto L7
    }

    public g0(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, String r108, String r110, int r111) {
        this.pvad = r100;
        this.notificationStatus = r101;
        this.notificationFrequency = r102;
        this.notificationPrivacyStatus = r103;
        this.proactiveStatus = r104;
        this.proactiveMethod = r105;
        this.proactiveFrequency = r106;
        this.proactivePrivacyStatus = r107;
        this.defaultIconLight = r108;
        this.defaultIconDark = r110;
        this.doraSseFrontierDuration = r111;
    }
}
