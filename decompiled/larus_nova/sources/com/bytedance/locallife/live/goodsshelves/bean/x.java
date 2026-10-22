package com.bytedance.locallife.live.goodsshelves.bean;

import androidx.core.provider.FontsContractCompat;
import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b.\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR*\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010%\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R$\u0010,\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R$\u00102\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b2\u0010\u0018\u001a\u0004\b3\u0010\u001a\"\u0004\b4\u0010\u001cR$\u00105\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b5\u0010\u0018\u001a\u0004\b6\u0010\u001a\"\u0004\b7\u0010\u001cR$\u00108\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b8\u0010\u0018\u001a\u0004\b9\u0010\u001a\"\u0004\b:\u0010\u001cR$\u0010;\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b;\u0010\u0018\u001a\u0004\b<\u0010\u001a\"\u0004\b=\u0010\u001cR$\u0010>\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b>\u0010\u0018\u001a\u0004\b?\u0010\u001a\"\u0004\b@\u0010\u001cR$\u0010A\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bA\u0010\u0018\u001a\u0004\bB\u0010\u001a\"\u0004\bC\u0010\u001cR$\u0010D\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bD\u0010\u0018\u001a\u0004\bE\u0010\u001a\"\u0004\bF\u0010\u001cR$\u0010G\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bG\u0010\u0018\u001a\u0004\bH\u0010\u001a\"\u0004\bI\u0010\u001cR$\u0010J\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bJ\u0010\u001f\u001a\u0004\bK\u0010!\"\u0004\bL\u0010#R$\u0010M\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bM\u0010\u0004\u001a\u0004\bN\u0010\u0006\"\u0004\bO\u0010\bR$\u0010P\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bP\u0010\u0004\u001a\u0004\bQ\u0010\u0006\"\u0004\bR\u0010\bR$\u0010S\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bS\u0010\u0004\u001a\u0004\bT\u0010\u0006\"\u0004\bU\u0010\bR$\u0010V\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bV\u0010&\u001a\u0004\bW\u0010(\"\u0004\bX\u0010*¨\u0006Y"}, d2 = {"Lcom/bytedance/locallife/live/goodsshelves/bean/x;", "", "", "text", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "fontFamily", "getFontFamily", "setFontFamily", "fontColor", "c", RXScreenCaptureService.KEY_INDEX, "", "gradientColors", "Ljava/util/List;", "getGradientColors", "()Ljava/util/List;", "setGradientColors", "(Ljava/util/List;)V", "", "fontSize", "Ljava/lang/Float;", "d", "()Ljava/lang/Float;", "setFontSize", "(Ljava/lang/Float;)V", "", "strikethrough", "Ljava/lang/Boolean;", "getStrikethrough", "()Ljava/lang/Boolean;", "setStrikethrough", "(Ljava/lang/Boolean;)V", "", "delimiter", "Ljava/lang/Integer;", "b", "()Ljava/lang/Integer;", "h", "(Ljava/lang/Integer;)V", "Lcom/bytedance/locallife/live/goodsshelves/bean/t;", "delimiterImage", "Lcom/bytedance/locallife/live/goodsshelves/bean/t;", "getDelimiterImage", "()Lcom/bytedance/locallife/live/goodsshelves/bean/t;", "setDelimiterImage", "(Lcom/bytedance/locallife/live/goodsshelves/bean/t;)V", "marginLeft", "getMarginLeft", "setMarginLeft", "marginRight", "getMarginRight", "setMarginRight", "marginTop", "getMarginTop", "setMarginTop", "marginBottom", "getMarginBottom", "setMarginBottom", "paddingLeft", "getPaddingLeft", "setPaddingLeft", "paddingRight", "getPaddingRight", "setPaddingRight", "paddingTop", "getPaddingTop", "setPaddingTop", "paddingBottom", "getPaddingBottom", "setPaddingBottom", "abbreviated", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, ce.f26391f, "backgroundColor", "getBackgroundColor", "setBackgroundColor", "fontWeight", "getFontWeight", "setFontWeight", "customStyle", "getCustomStyle", "setCustomStyle", "textMaxLine", "f", "setTextMaxLine", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class x {

    @SerializedName("abbreviated")
    private Boolean abbreviated;

    @SerializedName("background_color")
    private String backgroundColor;

    @SerializedName("custom_style")
    private String customStyle;

    @SerializedName("delimiter")
    private Integer delimiter;

    @SerializedName("delimiter_image")
    private t delimiterImage;

    @SerializedName("font_color")
    private String fontColor;

    @SerializedName("font_family")
    private String fontFamily;

    @SerializedName("font_size")
    private Float fontSize;

    @SerializedName(FontsContractCompat.Columns.WEIGHT)
    private String fontWeight;

    @SerializedName("gradient_colors")
    private List<String> gradientColors;

    @SerializedName("margin_bottom")
    private Float marginBottom;

    @SerializedName("margin_left")
    private Float marginLeft;

    @SerializedName("margin_right")
    private Float marginRight;

    @SerializedName("margin_top")
    private Float marginTop;

    @SerializedName("padding_bottom")
    private Float paddingBottom;

    @SerializedName("padding_left")
    private Float paddingLeft;

    @SerializedName("padding_right")
    private Float paddingRight;

    @SerializedName("padding_top")
    private Float paddingTop;

    @SerializedName("strikethrough")
    private Boolean strikethrough;

    @SerializedName("text")
    private String text;

    @SerializedName("text_max_line")
    private Integer textMaxLine;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof x) == true) goto L8;
        return false;
    L8:
        x r101 = (x) r100;
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.fontFamily, r101.fontFamily) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.fontColor, r101.fontColor) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.gradientColors, r101.gradientColors) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.fontSize, r101.fontSize) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.strikethrough, r101.strikethrough) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.delimiter, r101.delimiter) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.delimiterImage, r101.delimiterImage) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.marginLeft, r101.marginLeft) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.marginRight, r101.marginRight) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.marginTop, r101.marginTop) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.marginBottom, r101.marginBottom) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.paddingLeft, r101.paddingLeft) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.paddingRight, r101.paddingRight) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.paddingTop, r101.paddingTop) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.paddingBottom, r101.paddingBottom) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.abbreviated, r101.abbreviated) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.backgroundColor, r101.backgroundColor) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.fontWeight, r101.fontWeight) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.customStyle, r101.customStyle) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.textMaxLine, r101.textMaxLine) == true) goto L71;
        return false;
    L71:
        return true;
    }

    public final int hashCode() {
        String r100 = this.text;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.fontFamily;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.fontColor;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        List<String> r110 = this.gradientColors;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Float r113 = this.fontSize;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Boolean r116 = this.strikethrough;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.delimiter;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        t r122 = this.delimiterImage;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Float r125 = this.marginLeft;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        Float r128 = this.marginRight;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        Float r131 = this.marginTop;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        Float r134 = this.marginBottom;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        Float r137 = this.paddingLeft;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        int r139 = (r136 + r138) * 31;
        Float r140 = this.paddingRight;
        if (r140 != null) goto L57;
        int r141 = 0;
    L58:
        int r142 = (r139 + r141) * 31;
        Float r143 = this.paddingTop;
        if (r143 != null) goto L61;
        int r144 = 0;
    L62:
        int r145 = (r142 + r144) * 31;
        Float r146 = this.paddingBottom;
        if (r146 != null) goto L65;
        int r147 = 0;
    L66:
        int r148 = (r145 + r147) * 31;
        Boolean r149 = this.abbreviated;
        if (r149 != null) goto L69;
        int r150 = 0;
    L70:
        int r151 = (r148 + r150) * 31;
        String r152 = this.backgroundColor;
        if (r152 != null) goto L73;
        int r153 = 0;
    L74:
        int r154 = (r151 + r153) * 31;
        String r155 = this.fontWeight;
        if (r155 != null) goto L77;
        int r156 = 0;
    L78:
        int r157 = (r154 + r156) * 31;
        String r158 = this.customStyle;
        if (r158 != null) goto L81;
        int r159 = 0;
    L82:
        int r160 = (r157 + r159) * 31;
        Integer r161 = this.textMaxLine;
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
        return "LiveLifeBFFCardRichTextInfo(text=" + this.text + ", fontFamily=" + this.fontFamily + ", fontColor=" + this.fontColor + ", gradientColors=" + this.gradientColors + ", fontSize=" + this.fontSize + ", strikethrough=" + this.strikethrough + ", delimiter=" + this.delimiter + ", delimiterImage=" + this.delimiterImage + ", marginLeft=" + this.marginLeft + ", marginRight=" + this.marginRight + ", marginTop=" + this.marginTop + ", marginBottom=" + this.marginBottom + ", paddingLeft=" + this.paddingLeft + ", paddingRight=" + this.paddingRight + ", paddingTop=" + this.paddingTop + ", paddingBottom=" + this.paddingBottom + ", abbreviated=" + this.abbreviated + ", backgroundColor=" + this.backgroundColor + ", fontWeight=" + this.fontWeight + ", customStyle=" + this.customStyle + ", textMaxLine=" + this.textMaxLine + ')';
    }

    public final void i() {
        this.fontColor = "#161823bf";
    }

    public final Boolean a() {
        return this.abbreviated;
    }

    public final Integer b() {
        return this.delimiter;
    }

    public final String c() {
        return this.fontColor;
    }

    public final Float d() {
        return this.fontSize;
    }

    public final String e() {
        return this.text;
    }

    public final Integer f() {
        return this.textMaxLine;
    }

    public final void g(Boolean r100) {
        this.abbreviated = r100;
    }

    public final void h(Integer r100) {
        this.delimiter = r100;
    }
}
