package com.larus.login.api.ecommerce;

import com.bytedance.android.ec.common.api.inflow.AnchorBenefitToast;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b#\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0099\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0018\b\u0002\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0019J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010*\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0019J\u0010\u0010+\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0019J\u0010\u0010,\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0019J\u000b\u0010-\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u0019\u0010/\u001a\u0012\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u0011HÆ\u0003J \u0001\u00100\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0018\b\u0002\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u0011HÆ\u0001¢\u0006\u0002\u00101J\u0013\u00102\u001a\u00020\u00072\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00104\u001a\u000205HÖ\u0001J\t\u00106\u001a\u00020\rHÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u001a\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001c\u0010\u0019R\u001a\u0010\n\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001d\u0010\u0019R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001e\u0010\u0019R\u0018\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R&\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$¨\u00067"}, d2 = {"Lcom/larus/login/api/ecommerce/EcomSceneTextConfig;", "", "mainTitle", "Lcom/larus/login/api/ecommerce/EcomTextContent;", "subTitles", "primaryAction", "showSecondaryAction", "", "secondaryAction", "showLearnMore", "simplifiedStyle", "shouldAuthCoupon", "extra", "", AnchorBenefitToast.TYPE_COUPON, "Lcom/larus/login/api/ecommerce/Coupon;", "trackData", "", "<init>", "(Lcom/larus/login/api/ecommerce/EcomTextContent;Lcom/larus/login/api/ecommerce/EcomTextContent;Lcom/larus/login/api/ecommerce/EcomTextContent;Ljava/lang/Boolean;Lcom/larus/login/api/ecommerce/EcomTextContent;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Lcom/larus/login/api/ecommerce/Coupon;Ljava/util/Map;)V", "getMainTitle", "()Lcom/larus/login/api/ecommerce/EcomTextContent;", "getSubTitles", "getPrimaryAction", "getShowSecondaryAction", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getSecondaryAction", "getShowLearnMore", "getSimplifiedStyle", "getShouldAuthCoupon", "getExtra", "()Ljava/lang/String;", "getCoupon", "()Lcom/larus/login/api/ecommerce/Coupon;", "getTrackData", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "(Lcom/larus/login/api/ecommerce/EcomTextContent;Lcom/larus/login/api/ecommerce/EcomTextContent;Lcom/larus/login/api/ecommerce/EcomTextContent;Ljava/lang/Boolean;Lcom/larus/login/api/ecommerce/EcomTextContent;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Lcom/larus/login/api/ecommerce/Coupon;Ljava/util/Map;)Lcom/larus/login/api/ecommerce/EcomSceneTextConfig;", "equals", "other", "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class l {

    @SerializedName(AnchorBenefitToast.TYPE_COUPON)
    private final b coupon;

    @SerializedName("extra")
    private final String extra;

    @SerializedName(BdpAppEventConstant.PARAMS_MAIN_TITLE)
    private final o mainTitle;

    @SerializedName("primary_action")
    private final o primaryAction;

    @SerializedName("secondary_action")
    private final o secondaryAction;

    @SerializedName("should_auth_coupon")
    private final Boolean shouldAuthCoupon;

    @SerializedName("show_learn_more")
    private final Boolean showLearnMore;

    @SerializedName("show_secondary_action")
    private final Boolean showSecondaryAction;

    @SerializedName("simplified_style")
    private final Boolean simplifiedStyle;

    @SerializedName("sub_titles")
    private final o subTitles;

    @SerializedName("track_data")
    private final Map<String, String> trackData;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L8;
        return false;
    L8:
        l r101 = (l) r100;
        if (Intrinsics.areEqual(this.mainTitle, r101.mainTitle) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.subTitles, r101.subTitles) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.primaryAction, r101.primaryAction) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.showSecondaryAction, r101.showSecondaryAction) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.secondaryAction, r101.secondaryAction) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.showLearnMore, r101.showLearnMore) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.simplifiedStyle, r101.simplifiedStyle) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.shouldAuthCoupon, r101.shouldAuthCoupon) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.coupon, r101.coupon) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.trackData, r101.trackData) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        o r100 = this.mainTitle;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        o r104 = this.subTitles;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        o r107 = this.primaryAction;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.showSecondaryAction;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        o r113 = this.secondaryAction;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Boolean r116 = this.showLearnMore;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Boolean r119 = this.simplifiedStyle;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Boolean r122 = this.shouldAuthCoupon;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.extra;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        b r128 = this.coupon;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        Map<String, String> r131 = this.trackData;
        if (r131 == null) goto L47;
        r101 = r131.hashCode();
    L47:
        return r130 + r101;
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
        return "EcomSceneTextConfig(mainTitle=" + this.mainTitle + ", subTitles=" + this.subTitles + ", primaryAction=" + this.primaryAction + ", showSecondaryAction=" + this.showSecondaryAction + ", secondaryAction=" + this.secondaryAction + ", showLearnMore=" + this.showLearnMore + ", simplifiedStyle=" + this.simplifiedStyle + ", shouldAuthCoupon=" + this.shouldAuthCoupon + ", extra=" + this.extra + ", coupon=" + this.coupon + ", trackData=" + this.trackData + ')';
    }

    public l() {
        this.mainTitle = null;
        this.subTitles = null;
        this.primaryAction = null;
        this.showSecondaryAction = null;
        this.secondaryAction = null;
        this.showLearnMore = null;
        this.simplifiedStyle = null;
        this.shouldAuthCoupon = null;
        this.extra = null;
        this.coupon = null;
        this.trackData = null;
    }

    public final b a() {
        return this.coupon;
    }

    public final String b() {
        return this.extra;
    }

    public final o c() {
        return this.mainTitle;
    }

    public final o d() {
        return this.primaryAction;
    }

    public final o e() {
        return this.secondaryAction;
    }

    public final Boolean f() {
        return this.shouldAuthCoupon;
    }

    public final Boolean g() {
        return this.showLearnMore;
    }

    public final Boolean h() {
        return this.showSecondaryAction;
    }

    public final Boolean i() {
        return this.simplifiedStyle;
    }

    public final o j() {
        return this.subTitles;
    }

    public final Map<String, String> k() {
        return this.trackData;
    }
}
