package com.bytedance.locallife.live.goodsshelves.bean;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b#\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u0004\u001a\u0004\b\u001f\u0010\u0006R\u001c\u0010 \u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b \u0010\u0004\u001a\u0004\b!\u0010\u0006R\u001c\u0010\"\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010\u0004\u001a\u0004\b#\u0010\u0006R\u001c\u0010$\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010\u0004\u001a\u0004\b%\u0010\u0006R\u001c\u0010&\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010\u0004\u001a\u0004\b'\u0010\u0006R\u001c\u0010(\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010\u0004\u001a\u0004\b)\u0010\u0006R\u001c\u0010*\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b*\u0010\u0004\u001a\u0004\b+\u0010\u0006R\u001c\u0010,\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b,\u0010\u0004\u001a\u0004\b-\u0010\u0006R\u001c\u0010.\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b.\u0010\u0004\u001a\u0004\b/\u0010\u0006R\u001c\u00100\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b0\u0010\u0004\u001a\u0004\b1\u0010\u0006¨\u00062"}, d2 = {"Lcom/bytedance/locallife/live/goodsshelves/bean/m0;", "", "", "borderColor", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "prefixTextColor", "p", "prefixBgColor", "f", "prefixTextPadding", "getPrefixTextPadding", "prefixDividerColor", "h", "", "prefixIconType", "Ljava/lang/Integer;", ce.f26395j, "()Ljava/lang/Integer;", "prefixIconSrc", RXScreenCaptureService.KEY_INDEX, "prefixBgRadius", "getPrefixBgRadius", "suffixTextColor", "r", "suffixBgColor", "q", "curveImg", "d", "prefixBgImage", ce.f26391f, "prefixBgImageSize", "getPrefixBgImageSize", "bgBackgroundImage", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "bgBorder", "b", "prefixOnlyImageUrl", OfficeSDKRequestTag.KEY_NEW_USER, "prefixOnlyImageWidth", "o", "prefixImageTextIconSrc", "l", "prefixImageTextIconWidth", "m", "prefixImageTextBgImageUrl", ce.f26396k, "imageTextCurveImg", "e", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class m0 {

    @SerializedName("bg_background_image")
    private final String bgBackgroundImage;

    @SerializedName("bg_border")
    private final String bgBorder;

    @SerializedName("border_color")
    private final String borderColor;

    @SerializedName("curve_img")
    private final String curveImg;

    @SerializedName("image_text_curve_img")
    private final String imageTextCurveImg;

    @SerializedName("prefix_bg_color")
    private final String prefixBgColor;

    @SerializedName("prefix_bg_image")
    private final String prefixBgImage;

    @SerializedName("prefix_bg_image_size")
    private final String prefixBgImageSize;

    @SerializedName("prefix_bg_radius")
    private final String prefixBgRadius;

    @SerializedName("prefix_divider_color")
    private final String prefixDividerColor;

    @SerializedName("prefix_icon_src")
    private final String prefixIconSrc;

    @SerializedName("prefix_icon_type")
    private final Integer prefixIconType;

    @SerializedName("prefix_image_text_bg_image_url")
    private final String prefixImageTextBgImageUrl;

    @SerializedName("prefix_image_text_icon_src")
    private final String prefixImageTextIconSrc;

    @SerializedName("prefix_image_text_icon_width")
    private final String prefixImageTextIconWidth;

    @SerializedName("prefix_only_image_url")
    private final String prefixOnlyImageUrl;

    @SerializedName("prefix_only_image_width")
    private final String prefixOnlyImageWidth;

    @SerializedName("prefix_text_color")
    private final String prefixTextColor;

    @SerializedName("prefix_text_padding")
    private final String prefixTextPadding;

    @SerializedName("suffix_bg_color")
    private final String suffixBgColor;

    @SerializedName("suffix_text_color")
    private final String suffixTextColor;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m0) == true) goto L8;
        return false;
    L8:
        m0 r101 = (m0) r100;
        if (Intrinsics.areEqual(this.borderColor, r101.borderColor) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.prefixTextColor, r101.prefixTextColor) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.prefixBgColor, r101.prefixBgColor) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.prefixTextPadding, r101.prefixTextPadding) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.prefixDividerColor, r101.prefixDividerColor) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.prefixIconType, r101.prefixIconType) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.prefixIconSrc, r101.prefixIconSrc) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.prefixBgRadius, r101.prefixBgRadius) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.suffixTextColor, r101.suffixTextColor) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.suffixBgColor, r101.suffixBgColor) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.curveImg, r101.curveImg) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.prefixBgImage, r101.prefixBgImage) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.prefixBgImageSize, r101.prefixBgImageSize) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.bgBackgroundImage, r101.bgBackgroundImage) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.bgBorder, r101.bgBorder) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.prefixOnlyImageUrl, r101.prefixOnlyImageUrl) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.prefixOnlyImageWidth, r101.prefixOnlyImageWidth) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.prefixImageTextIconSrc, r101.prefixImageTextIconSrc) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.prefixImageTextIconWidth, r101.prefixImageTextIconWidth) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.prefixImageTextBgImageUrl, r101.prefixImageTextBgImageUrl) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.imageTextCurveImg, r101.imageTextCurveImg) == true) goto L71;
        return false;
    L71:
        return true;
    }

    public final int hashCode() {
        String r100 = this.borderColor;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.prefixTextColor;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.prefixBgColor;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.prefixTextPadding;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.prefixDividerColor;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.prefixIconType;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.prefixIconSrc;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.prefixBgRadius;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.suffixTextColor;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.suffixBgColor;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.curveImg;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        String r134 = this.prefixBgImage;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        String r137 = this.prefixBgImageSize;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        int r139 = (r136 + r138) * 31;
        String r140 = this.bgBackgroundImage;
        if (r140 != null) goto L57;
        int r141 = 0;
    L58:
        int r142 = (r139 + r141) * 31;
        String r143 = this.bgBorder;
        if (r143 != null) goto L61;
        int r144 = 0;
    L62:
        int r145 = (r142 + r144) * 31;
        String r146 = this.prefixOnlyImageUrl;
        if (r146 != null) goto L65;
        int r147 = 0;
    L66:
        int r148 = (r145 + r147) * 31;
        String r149 = this.prefixOnlyImageWidth;
        if (r149 != null) goto L69;
        int r150 = 0;
    L70:
        int r151 = (r148 + r150) * 31;
        String r152 = this.prefixImageTextIconSrc;
        if (r152 != null) goto L73;
        int r153 = 0;
    L74:
        int r154 = (r151 + r153) * 31;
        String r155 = this.prefixImageTextIconWidth;
        if (r155 != null) goto L77;
        int r156 = 0;
    L78:
        int r157 = (r154 + r156) * 31;
        String r158 = this.prefixImageTextBgImageUrl;
        if (r158 != null) goto L81;
        int r159 = 0;
    L82:
        int r160 = (r157 + r159) * 31;
        String r161 = this.imageTextCurveImg;
        if (r161 == null) goto L87;
        r101 = r161.hashCode();
    L87:
        return r160 + r101;
    L81:
        r159 = r158.hashCode();
        goto L82
    L77:
        r156 = r155.hashCode();
        goto L78
    L73:
        r153 = r152.hashCode();
        goto L74
    L69:
        r150 = r149.hashCode();
        goto L70
    L65:
        r147 = r146.hashCode();
        goto L66
    L61:
        r144 = r143.hashCode();
        goto L62
    L57:
        r141 = r140.hashCode();
        goto L58
    L53:
        r138 = r137.hashCode();
        goto L54
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
        return "MarketingToolStyle(borderColor=" + this.borderColor + ", prefixTextColor=" + this.prefixTextColor + ", prefixBgColor=" + this.prefixBgColor + ", prefixTextPadding=" + this.prefixTextPadding + ", prefixDividerColor=" + this.prefixDividerColor + ", prefixIconType=" + this.prefixIconType + ", prefixIconSrc=" + this.prefixIconSrc + ", prefixBgRadius=" + this.prefixBgRadius + ", suffixTextColor=" + this.suffixTextColor + ", suffixBgColor=" + this.suffixBgColor + ", curveImg=" + this.curveImg + ", prefixBgImage=" + this.prefixBgImage + ", prefixBgImageSize=" + this.prefixBgImageSize + ", bgBackgroundImage=" + this.bgBackgroundImage + ", bgBorder=" + this.bgBorder + ", prefixOnlyImageUrl=" + this.prefixOnlyImageUrl + ", prefixOnlyImageWidth=" + this.prefixOnlyImageWidth + ", prefixImageTextIconSrc=" + this.prefixImageTextIconSrc + ", prefixImageTextIconWidth=" + this.prefixImageTextIconWidth + ", prefixImageTextBgImageUrl=" + this.prefixImageTextBgImageUrl + ", imageTextCurveImg=" + this.imageTextCurveImg + ')';
    }

    public m0() {
        this.borderColor = null;
        this.prefixTextColor = null;
        this.prefixBgColor = null;
        this.prefixTextPadding = null;
        this.prefixDividerColor = null;
        this.prefixIconType = null;
        this.prefixIconSrc = null;
        this.prefixBgRadius = null;
        this.suffixTextColor = null;
        this.suffixBgColor = null;
        this.curveImg = null;
        this.prefixBgImage = null;
        this.prefixBgImageSize = null;
        this.bgBackgroundImage = null;
        this.bgBorder = null;
        this.prefixOnlyImageUrl = null;
        this.prefixOnlyImageWidth = null;
        this.prefixImageTextIconSrc = null;
        this.prefixImageTextIconWidth = null;
        this.prefixImageTextBgImageUrl = null;
        this.imageTextCurveImg = null;
    }

    public final String a() {
        return this.bgBackgroundImage;
    }

    public final String b() {
        return this.bgBorder;
    }

    public final String c() {
        return this.borderColor;
    }

    public final String d() {
        return this.curveImg;
    }

    public final String e() {
        return this.imageTextCurveImg;
    }

    public final String f() {
        return this.prefixBgColor;
    }

    public final String g() {
        return this.prefixBgImage;
    }

    public final String h() {
        return this.prefixDividerColor;
    }

    public final String i() {
        return this.prefixIconSrc;
    }

    public final Integer j() {
        return this.prefixIconType;
    }

    public final String k() {
        return this.prefixImageTextBgImageUrl;
    }

    public final String l() {
        return this.prefixImageTextIconSrc;
    }

    public final String m() {
        return this.prefixImageTextIconWidth;
    }

    public final String n() {
        return this.prefixOnlyImageUrl;
    }

    public final String o() {
        return this.prefixOnlyImageWidth;
    }

    public final String p() {
        return this.prefixTextColor;
    }

    public final String q() {
        return this.suffixBgColor;
    }

    public final String r() {
        return this.suffixTextColor;
    }
}
