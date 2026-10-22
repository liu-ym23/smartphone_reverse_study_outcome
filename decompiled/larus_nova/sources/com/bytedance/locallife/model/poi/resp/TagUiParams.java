package com.bytedance.locallife.model.poi.resp;

import androidx.core.provider.FontsContractCompat;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.facebook.keyframes.model.KFFeature;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b+\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B¯\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0000¢\u0006\u0002\u0010\u0013J\u0010\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u0010*\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0000HÆ\u0003J\u0010\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0011\u0010/\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006HÆ\u0003J\u0011\u00100\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006HÆ\u0003J\u0011\u00101\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0006HÆ\u0003J\u0010\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u00104\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010'J\u000b\u00105\u001a\u0004\u0018\u00010\tHÆ\u0003J¸\u0001\u00106\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00062\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0000HÆ\u0001¢\u0006\u0002\u00107J\u0013\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010;HÖ\u0003J\t\u0010<\u001a\u00020\u0003HÖ\u0001J\t\u0010=\u001a\u00020\tHÖ\u0001R\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00008\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0010\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u0011\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b \u0010\u001eR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b!\u0010\u001eR\u001a\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\"\u0010\u001eR\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0015R\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0015R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001cR\u001a\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010(\u001a\u0004\b&\u0010'¨\u0006>"}, d2 = {"Lcom/bytedance/locallife/model/poi/resp/TagUiParams;", "Ljava/io/Serializable;", "fontSize", "", "fontWeight", GXTemplateKey.FLEXBOX_PADDING, "", GXTemplateKey.FLEXBOX_MARGIN, "backgroundColors", "", "gradientOrientation", "cornerRadius", "strokeWidth", "", "strokeColor", "contentColor", "breakMode", "breakPriority", "blackTheme", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/String;IILcom/bytedance/locallife/model/poi/resp/TagUiParams;)V", "getBackgroundColors", "()Ljava/util/List;", "getBlackTheme", "()Lcom/bytedance/locallife/model/poi/resp/TagUiParams;", "getBreakMode", "()I", "getBreakPriority", "getContentColor", "()Ljava/lang/String;", "getCornerRadius", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getFontSize", "getFontWeight", "getGradientOrientation", "getMargin", "getPadding", "getStrokeColor", "getStrokeWidth", "()Ljava/lang/Float;", "Ljava/lang/Float;", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/String;IILcom/bytedance/locallife/model/poi/resp/TagUiParams;)Lcom/bytedance/locallife/model/poi/resp/TagUiParams;", "equals", "", "other", "", "hashCode", "toString", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class TagUiParams implements Serializable {

    @SerializedName("background_colors")
    private final List<String> backgroundColors;

    @SerializedName("black_theme")
    private final TagUiParams blackTheme;

    @SerializedName("break_mode")
    private final int breakMode;

    @SerializedName("break_priority")
    private final int breakPriority;

    @SerializedName("content_color")
    private final String contentColor;

    @SerializedName("corner_radius")
    private final Integer cornerRadius;

    @SerializedName("font_size")
    private final Integer fontSize;

    @SerializedName(FontsContractCompat.Columns.WEIGHT)
    private final Integer fontWeight;

    @SerializedName("gradient_orientation")
    private final Integer gradientOrientation;

    @SerializedName(GXTemplateKey.FLEXBOX_MARGIN)
    private final List<Integer> margin;

    @SerializedName(GXTemplateKey.FLEXBOX_PADDING)
    private final List<Integer> padding;

    @SerializedName(KFFeature.STROKE_COLOR_JSON_FIELD)
    private final String strokeColor;

    @SerializedName(KFFeature.STROKE_WIDTH_JSON_FIELD)
    private final Float strokeWidth;

    public TagUiParams() {
        this(null, null, null, null, null, null, null, null, null, null, 0, 0, null, 8191, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TagUiParams copy$default(TagUiParams r110, Integer r111, Integer r112, List r113, List r114, List r115, Integer r210, Integer r211, Float r212, String r213, String r214, int r215, int r216, TagUiParams r217, int r218, Object r219) {
        if ((r218 & 1) == 0) goto L5;
        Integer r100 = r110.fontSize;
    L7:
        if ((r218 & 2) == 0) goto L9;
        Integer r101 = r110.fontWeight;
    L11:
        if ((r218 & 4) == 0) goto L13;
        List r102 = r110.padding;
    L15:
        if ((r218 & 8) == 0) goto L17;
        List r103 = r110.margin;
    L19:
        if ((r218 & 16) == 0) goto L21;
        List r104 = r110.backgroundColors;
    L23:
        if ((r218 & 32) == 0) goto L25;
        Integer r105 = r110.gradientOrientation;
    L27:
        if ((r218 & 64) == 0) goto L29;
        Integer r106 = r110.cornerRadius;
    L31:
        if ((r218 & 128) == 0) goto L33;
        Float r107 = r110.strokeWidth;
    L35:
        if ((r218 & 256) == 0) goto L37;
        String r116 = r110.strokeColor;
    L39:
        if ((r218 & 512) == 0) goto L41;
        String r117 = r110.contentColor;
    L43:
        if ((r218 & 1024) == 0) goto L45;
        int r118 = r110.breakMode;
    L47:
        if ((r218 & 2048) == 0) goto L49;
        int r119 = r110.breakPriority;
    L51:
        if ((r218 & 4096) == 0) goto L53;
        TagUiParams r108 = r110.blackTheme;
    L55:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r116, r117, r118, r119, r108);
    L53:
        r108 = r217;
        goto L55
    L49:
        r119 = r216;
        goto L51
    L45:
        r118 = r215;
        goto L47
    L41:
        r117 = r214;
        goto L43
    L37:
        r116 = r213;
        goto L39
    L33:
        r107 = r212;
        goto L35
    L29:
        r106 = r211;
        goto L31
    L25:
        r105 = r210;
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

    public final Integer component1() {
        return this.fontSize;
    }

    public final String component10() {
        return this.contentColor;
    }

    public final int component11() {
        return this.breakMode;
    }

    public final int component12() {
        return this.breakPriority;
    }

    public final TagUiParams component13() {
        return this.blackTheme;
    }

    public final Integer component2() {
        return this.fontWeight;
    }

    public final List<Integer> component3() {
        return this.padding;
    }

    public final List<Integer> component4() {
        return this.margin;
    }

    public final List<String> component5() {
        return this.backgroundColors;
    }

    public final Integer component6() {
        return this.gradientOrientation;
    }

    public final Integer component7() {
        return this.cornerRadius;
    }

    public final Float component8() {
        return this.strokeWidth;
    }

    public final String component9() {
        return this.strokeColor;
    }

    public final TagUiParams copy(Integer r110, Integer r111, List<Integer> r112, List<Integer> r113, List<String> r210, Integer r211, Integer r212, Float r213, String r214, String r215, int r216, int r217, TagUiParams r218) {
        return new TagUiParams(r110, r111, r112, r113, r210, r211, r212, r213, r214, r215, r216, r217, r218);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TagUiParams) == true) goto L8;
        return false;
    L8:
        TagUiParams r101 = (TagUiParams) r100;
        if (Intrinsics.areEqual(this.fontSize, r101.fontSize) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.fontWeight, r101.fontWeight) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.padding, r101.padding) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.margin, r101.margin) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.backgroundColors, r101.backgroundColors) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.gradientOrientation, r101.gradientOrientation) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.cornerRadius, r101.cornerRadius) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.strokeWidth, r101.strokeWidth) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.strokeColor, r101.strokeColor) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.contentColor, r101.contentColor) == true) goto L39;
        return false;
    L39:
        if (this.breakMode == r101.breakMode) goto L42;
        return false;
    L42:
        if (this.breakPriority == r101.breakPriority) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.blackTheme, r101.blackTheme) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public int hashCode() {
        Integer r100 = this.fontSize;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.fontWeight;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        List<Integer> r107 = this.padding;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        List<Integer> r110 = this.margin;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        List<String> r113 = this.backgroundColors;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.gradientOrientation;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.cornerRadius;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Float r122 = this.strokeWidth;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.strokeColor;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.contentColor;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (((((r127 + r129) * 31) + this.breakMode) * 31) + this.breakPriority) * 31;
        TagUiParams r131 = this.blackTheme;
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

    public String toString() {
        return "TagUiParams(fontSize=" + this.fontSize + ", fontWeight=" + this.fontWeight + ", padding=" + this.padding + ", margin=" + this.margin + ", backgroundColors=" + this.backgroundColors + ", gradientOrientation=" + this.gradientOrientation + ", cornerRadius=" + this.cornerRadius + ", strokeWidth=" + this.strokeWidth + ", strokeColor=" + this.strokeColor + ", contentColor=" + this.contentColor + ", breakMode=" + this.breakMode + ", breakPriority=" + this.breakPriority + ", blackTheme=" + this.blackTheme + ')';
    }

    public final List<String> getBackgroundColors() {
        return this.backgroundColors;
    }

    public final TagUiParams getBlackTheme() {
        return this.blackTheme;
    }

    public final int getBreakMode() {
        return this.breakMode;
    }

    public final int getBreakPriority() {
        return this.breakPriority;
    }

    public final String getContentColor() {
        return this.contentColor;
    }

    public final Integer getCornerRadius() {
        return this.cornerRadius;
    }

    public final Integer getFontSize() {
        return this.fontSize;
    }

    public final Integer getFontWeight() {
        return this.fontWeight;
    }

    public final Integer getGradientOrientation() {
        return this.gradientOrientation;
    }

    public final List<Integer> getMargin() {
        return this.margin;
    }

    public final List<Integer> getPadding() {
        return this.padding;
    }

    public final String getStrokeColor() {
        return this.strokeColor;
    }

    public final Float getStrokeWidth() {
        return this.strokeWidth;
    }

    public TagUiParams(Integer r100, Integer r101, List<Integer> r102, List<Integer> r103, List<String> r104, Integer r105, Integer r106, Float r107, String r108, String r110, int r111, int r112, TagUiParams r113) {
        this.fontSize = r100;
        this.fontWeight = r101;
        this.padding = r102;
        this.margin = r103;
        this.backgroundColors = r104;
        this.gradientOrientation = r105;
        this.cornerRadius = r106;
        this.strokeWidth = r107;
        this.strokeColor = r108;
        this.contentColor = r110;
        this.breakMode = r111;
        this.breakPriority = r112;
        this.blackTheme = r113;
    }

    public /* synthetic */ TagUiParams(Integer r110, Integer r111, List r112, List r113, List r210, Integer r211, Integer r212, Float r213, String r214, String r215, int r216, int r217, TagUiParams r218, int r219, DefaultConstructorMarker r310) {
        int r100 = 0;
        Integer r101 = 0;
        if ((r219 & 1) == 0) goto L5;
        Integer r102 = r101;
    L7:
        if ((r219 & 2) != 0) goto L10;
        r101 = r111;
    L10:
        TagUiParams r103 = null;
        if ((r219 & 4) == 0) goto L13;
        List r104 = null;
    L15:
        if ((r219 & 8) == 0) goto L17;
        List r105 = null;
    L19:
        if ((r219 & 16) == 0) goto L21;
        List r106 = null;
    L23:
        if ((r219 & 32) == 0) goto L25;
        Integer r107 = null;
    L27:
        if ((r219 & 64) == 0) goto L29;
        Integer r108 = null;
    L31:
        if ((r219 & 128) == 0) goto L33;
        Float r114 = null;
    L34:
        String r115 = "";
        if ((r219 & 256) == 0) goto L37;
        String r116 = "";
    L39:
        if ((r219 & 512) != 0) goto L43;
        r115 = r215;
    L43:
        if ((r219 & 1024) == 0) goto L45;
        int r117 = RateTagBreakMode.BREAK_MODE_END.getMode();
    L47:
        if ((r219 & 2048) != 0) goto L51;
        r100 = r217;
    L51:
        if ((r219 & 4096) != 0) goto L54;
        r103 = r218;
    L54:
        this(r102, r101, r104, r105, r106, r107, r108, r114, r116, r115, r117, r100, r103);
        return;
    L45:
        r117 = r216;
        goto L47
    L37:
        r116 = r214;
        goto L39
    L33:
        r114 = r213;
        goto L34
    L29:
        r108 = r212;
        goto L31
    L25:
        r107 = r211;
        goto L27
    L21:
        r106 = r210;
        goto L23
    L17:
        r105 = r113;
        goto L19
    L13:
        r104 = r112;
        goto L15
    L5:
        r102 = r110;
        goto L7
    }
}
