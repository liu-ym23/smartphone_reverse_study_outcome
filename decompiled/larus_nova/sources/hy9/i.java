package hy9;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b'\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B©\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0019J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010.\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001dJ\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u00104\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000fHÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00107\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0002\u0010)J°\u0001\u00108\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÆ\u0001¢\u0006\u0002\u00109J\u0013\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010=\u001a\u00020\u0013HÖ\u0001J\t\u0010>\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001dR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0017R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0017R\u001e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0017R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0017R\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010*\u001a\u0004\b(\u0010)¨\u0006?"}, d2 = {"Lcom/larus/uaigc/bean/StaticConfig;", "", "guideUrl", "", "guideRatio", "", "actionBarRedDotText", "actionBarRedDotItemId", "", "actionBarRedDotTextColor", "actionBarRedDotBgColor", "actionBarRedDotTextDarkColor", "actionBarRedDotBgDarkColor", "imListTxt", "onboardingMs", "", "warmUrl", "entryColor", "forceShowGuide", "", "<init>", "(Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getGuideUrl", "()Ljava/lang/String;", "getGuideRatio", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getActionBarRedDotText", "getActionBarRedDotItemId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getActionBarRedDotTextColor", "getActionBarRedDotBgColor", "getActionBarRedDotTextDarkColor", "getActionBarRedDotBgDarkColor", "getImListTxt", "getOnboardingMs", "()Ljava/util/List;", "getWarmUrl", "getEntryColor", "getForceShowGuide", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "(Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/larus/uaigc/bean/StaticConfig;", "equals", "", "other", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class i {

    @SerializedName("bg_color")
    private final String actionBarRedDotBgColor;

    @SerializedName("bg_dark_color")
    private final String actionBarRedDotBgDarkColor;

    @SerializedName("item_id")
    private final Long actionBarRedDotItemId;

    @SerializedName("text")
    private final String actionBarRedDotText;

    @SerializedName("txt_color")
    private final String actionBarRedDotTextColor;

    @SerializedName("txt_dark_color")
    private final String actionBarRedDotTextDarkColor;

    @SerializedName("entry_color")
    private final String entryColor;

    @SerializedName("force_show_guide")
    private final Integer forceShowGuide;

    @SerializedName(MapBundleKey.OfflineMapKey.OFFLINE_RATION)
    private final Double guideRatio;

    @SerializedName("url")
    private final String guideUrl;

    @SerializedName("im_list_txt")
    private final String imListTxt;

    @SerializedName("onboarding_ms")
    private final List<Long> onboardingMs;

    @SerializedName("warm_url")
    private final String warmUrl;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.guideUrl, r101.guideUrl) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.guideRatio, r101.guideRatio) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.actionBarRedDotText, r101.actionBarRedDotText) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.actionBarRedDotItemId, r101.actionBarRedDotItemId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.actionBarRedDotTextColor, r101.actionBarRedDotTextColor) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.actionBarRedDotBgColor, r101.actionBarRedDotBgColor) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.actionBarRedDotTextDarkColor, r101.actionBarRedDotTextDarkColor) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.actionBarRedDotBgDarkColor, r101.actionBarRedDotBgDarkColor) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.imListTxt, r101.imListTxt) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.onboardingMs, r101.onboardingMs) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.warmUrl, r101.warmUrl) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.entryColor, r101.entryColor) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.forceShowGuide, r101.forceShowGuide) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        String r100 = this.guideUrl;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Double r104 = this.guideRatio;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.actionBarRedDotText;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Long r110 = this.actionBarRedDotItemId;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.actionBarRedDotTextColor;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.actionBarRedDotBgColor;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.actionBarRedDotTextDarkColor;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.actionBarRedDotBgDarkColor;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.imListTxt;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        List<Long> r128 = this.onboardingMs;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.warmUrl;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        String r134 = this.entryColor;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        Integer r137 = this.forceShowGuide;
        if (r137 == null) goto L55;
        r101 = r137.hashCode();
    L55:
        return r136 + r101;
    L49:
        r135 = r134.hashCode();
        goto L50
    L45:
        r132 = r131.hashCode();
        goto L46
    L41:
        r129 = r128.hashCode();
        goto L42
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
        return "StaticConfig(guideUrl=" + this.guideUrl + ", guideRatio=" + this.guideRatio + ", actionBarRedDotText=" + this.actionBarRedDotText + ", actionBarRedDotItemId=" + this.actionBarRedDotItemId + ", actionBarRedDotTextColor=" + this.actionBarRedDotTextColor + ", actionBarRedDotBgColor=" + this.actionBarRedDotBgColor + ", actionBarRedDotTextDarkColor=" + this.actionBarRedDotTextDarkColor + ", actionBarRedDotBgDarkColor=" + this.actionBarRedDotBgDarkColor + ", imListTxt=" + this.imListTxt + ", onboardingMs=" + this.onboardingMs + ", warmUrl=" + this.warmUrl + ", entryColor=" + this.entryColor + ", forceShowGuide=" + this.forceShowGuide + ')';
    }

    public i() {
        this.guideUrl = null;
        this.guideRatio = null;
        this.actionBarRedDotText = null;
        this.actionBarRedDotItemId = null;
        this.actionBarRedDotTextColor = null;
        this.actionBarRedDotBgColor = null;
        this.actionBarRedDotTextDarkColor = null;
        this.actionBarRedDotBgDarkColor = null;
        this.imListTxt = null;
        this.onboardingMs = null;
        this.warmUrl = null;
        this.entryColor = null;
        this.forceShowGuide = null;
    }

    public final String a() {
        return this.entryColor;
    }

    public final Integer b() {
        return this.forceShowGuide;
    }

    public final List<Long> c() {
        return this.onboardingMs;
    }

    public final String d() {
        return this.warmUrl;
    }
}
