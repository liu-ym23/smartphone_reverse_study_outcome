package com.ss.android.ugc.aweme.discover.model.suggest;

import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bq\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\rJ\u0011\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0011J\u0011\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0006HÆ\u0003Jz\u0010 \u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00032\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\u0006HÖ\u0001R\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u001e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0018\u0010\u0011¨\u0006)"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/suggest/IconTextSegment;", "Ljava/io/Serializable;", DBDefinition.SEGMENT_TABLE_NAME, "", "Lcom/ss/android/ugc/aweme/discover/model/suggest/IconText;", "gradientColors", "", "gradientCornerRadius", "", "labelPadding", "labelMargin", "textLabelStrokeWidth", "textLabelStrokeColor", "(Ljava/util/List;Ljava/util/List;Ljava/lang/Float;Ljava/util/List;Ljava/util/List;Ljava/lang/Float;Ljava/lang/String;)V", "getGradientColors", "()Ljava/util/List;", "getGradientCornerRadius", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getLabelMargin", "getLabelPadding", "getSegments", "getTextLabelStrokeColor", "()Ljava/lang/String;", "getTextLabelStrokeWidth", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/util/List;Ljava/util/List;Ljava/lang/Float;Ljava/util/List;Ljava/util/List;Ljava/lang/Float;Ljava/lang/String;)Lcom/ss/android/ugc/aweme/discover/model/suggest/IconTextSegment;", "equals", "", "other", "", "hashCode", "", "toString", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IconTextSegment implements Serializable {

    @SerializedName("gradient_colors")
    private final List<String> gradientColors;

    @SerializedName("gradient_corner_radius")
    private final Float gradientCornerRadius;

    @SerializedName("label_margin")
    private final List<Float> labelMargin;

    @SerializedName("label_padding")
    private final List<Float> labelPadding;

    @SerializedName(DBDefinition.SEGMENT_TABLE_NAME)
    private final List<IconText> segments;

    @SerializedName("text_label_stroke_color")
    private final String textLabelStrokeColor;

    @SerializedName("text_label_stroke_width")
    private final Float textLabelStrokeWidth;

    public IconTextSegment() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IconTextSegment copy$default(IconTextSegment r100, List r101, List r102, Float r103, List r104, List r110, Float r111, String r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.segments;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.gradientColors;
    L8:
        List r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.gradientCornerRadius;
    L11:
        Float r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.labelPadding;
    L14:
        List r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.labelMargin;
    L17:
        List r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.textLabelStrokeWidth;
    L20:
        Float r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.textLabelStrokeColor;
    L23:
        List r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final List<IconText> component1() {
        return this.segments;
    }

    public final List<String> component2() {
        return this.gradientColors;
    }

    public final Float component3() {
        return this.gradientCornerRadius;
    }

    public final List<Float> component4() {
        return this.labelPadding;
    }

    public final List<Float> component5() {
        return this.labelMargin;
    }

    public final Float component6() {
        return this.textLabelStrokeWidth;
    }

    public final String component7() {
        return this.textLabelStrokeColor;
    }

    public final IconTextSegment copy(List<IconText> r110, List<String> r111, Float r112, List<Float> r113, List<Float> r114, Float r115, String r116) {
        return new IconTextSegment(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof IconTextSegment) == false) goto L20;
        IconTextSegment r101 = (IconTextSegment) r100;
        if (Intrinsics.areEqual(this.segments, r101.segments) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.gradientColors, r101.gradientColors) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.gradientCornerRadius, r101.gradientCornerRadius) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.labelPadding, r101.labelPadding) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.labelMargin, r101.labelMargin) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.textLabelStrokeWidth, r101.textLabelStrokeWidth) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.textLabelStrokeColor, r101.textLabelStrokeColor) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public int hashCode() {
        List<IconText> r100 = this.segments;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.gradientColors;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Float r107 = this.gradientCornerRadius;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        List<Float> r110 = this.labelPadding;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        List<Float> r113 = this.labelMargin;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Float r116 = this.textLabelStrokeWidth;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.textLabelStrokeColor;
        if (r119 == null) goto L30;
        r101 = r119.hashCode();
    L30:
        return r118 + r101;
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "IconTextSegment(segments=" + this.segments + ", gradientColors=" + this.gradientColors + ", gradientCornerRadius=" + this.gradientCornerRadius + ", labelPadding=" + this.labelPadding + ", labelMargin=" + this.labelMargin + ", textLabelStrokeWidth=" + this.textLabelStrokeWidth + ", textLabelStrokeColor=" + this.textLabelStrokeColor + ")";
    }

    public final List<String> getGradientColors() {
        return this.gradientColors;
    }

    public final Float getGradientCornerRadius() {
        return this.gradientCornerRadius;
    }

    public final List<Float> getLabelMargin() {
        return this.labelMargin;
    }

    public final List<Float> getLabelPadding() {
        return this.labelPadding;
    }

    public final List<IconText> getSegments() {
        return this.segments;
    }

    public final String getTextLabelStrokeColor() {
        return this.textLabelStrokeColor;
    }

    public final Float getTextLabelStrokeWidth() {
        return this.textLabelStrokeWidth;
    }

    public IconTextSegment(List<IconText> r100, List<String> r101, Float r102, List<Float> r103, List<Float> r104, Float r105, String r106) {
        this.segments = r100;
        this.gradientColors = r101;
        this.gradientCornerRadius = r102;
        this.labelPadding = r103;
        this.labelMargin = r104;
        this.textLabelStrokeWidth = r105;
        this.textLabelStrokeColor = r106;
    }

    public /* synthetic */ IconTextSegment(List r100, List r101, Float r102, List r110, List r111, Float r112, String r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 1) == 0) goto L5;
        List r116 = null;
    L7:
        if ((r114 & 2) == 0) goto L9;
        List r103 = null;
    L11:
        if ((r114 & 4) == 0) goto L13;
        Float r104 = null;
    L15:
        if ((r114 & 8) == 0) goto L17;
        List r105 = null;
    L19:
        if ((r114 & 16) == 0) goto L21;
        List r106 = null;
    L23:
        if ((r114 & 32) == 0) goto L25;
        Float r107 = null;
    L27:
        if ((r114 & 64) == 0) goto L29;
        String r117 = null;
    L30:
        this(r116, r103, r104, r105, r106, r107, r117);
        return;
    L29:
        r117 = r113;
        goto L30
    L25:
        r107 = r112;
        goto L27
    L21:
        r106 = r111;
        goto L23
    L17:
        r105 = r110;
        goto L19
    L13:
        r104 = r102;
        goto L15
    L9:
        r103 = r101;
        goto L11
    L5:
        r116 = r100;
        goto L7
    }
}
