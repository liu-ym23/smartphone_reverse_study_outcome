package com.ss.android.ugc.aweme.discover.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001Bw\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u000fJ\u0011\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010 \u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010!\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010\"\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u0080\u0001\u0010&\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010'J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+HÖ\u0003J\t\u0010,\u001a\u00020\u0006HÖ\u0001J\t\u0010-\u001a\u00020\u000bHÖ\u0001R\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u001a\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0017\u0010\u0015R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0018\u0010\u0015R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0019\u0010\u0015R\u0018\u0010\r\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006."}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/IconText;", "Ljava/io/Serializable;", DBDefinition.SEGMENT_TABLE_NAME, "", "Lcom/ss/android/ugc/aweme/discover/model/Segment;", "marginLeft", "", "marginTop", "marginRight", "marginBottom", "frameArgb", "", "bgArgb", "radius", "fontSize", "(Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBgArgb", "()Ljava/lang/String;", "getFontSize", "getFrameArgb", "getMarginBottom", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMarginLeft", "getMarginRight", "getMarginTop", "getRadius", "getSegments", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/ss/android/ugc/aweme/discover/model/IconText;", "equals", "", "other", "", "hashCode", "toString", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IconText implements Serializable {

    @SerializedName("bg_argb")
    private final String bgArgb;

    @SerializedName("font_size")
    private final String fontSize;

    @SerializedName("frame_argb")
    private final String frameArgb;

    @SerializedName("margin_bottom")
    private final Integer marginBottom;

    @SerializedName("margin_left")
    private final Integer marginLeft;

    @SerializedName("margin_right")
    private final Integer marginRight;

    @SerializedName("margin_top")
    private final Integer marginTop;

    @SerializedName("radius")
    private final String radius;

    @SerializedName(DBDefinition.SEGMENT_TABLE_NAME)
    private final List<Segment> segments;

    public IconText() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IconText copy$default(IconText r110, List r111, Integer r112, Integer r113, Integer r114, Integer r115, String r116, String r117, String r118, String r119, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        List r100 = r110.segments;
    L7:
        if ((r210 & 2) == 0) goto L9;
        Integer r101 = r110.marginLeft;
    L11:
        if ((r210 & 4) == 0) goto L13;
        Integer r102 = r110.marginTop;
    L15:
        if ((r210 & 8) == 0) goto L17;
        Integer r103 = r110.marginRight;
    L19:
        if ((r210 & 16) == 0) goto L21;
        Integer r104 = r110.marginBottom;
    L23:
        if ((r210 & 32) == 0) goto L25;
        String r105 = r110.frameArgb;
    L27:
        if ((r210 & 64) == 0) goto L29;
        String r106 = r110.bgArgb;
    L31:
        if ((r210 & 128) == 0) goto L33;
        String r107 = r110.radius;
    L35:
        if ((r210 & 256) == 0) goto L37;
        String r108 = r110.fontSize;
    L39:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r108);
    L37:
        r108 = r119;
        goto L39
    L33:
        r107 = r118;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
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

    public final List<Segment> component1() {
        return this.segments;
    }

    public final Integer component2() {
        return this.marginLeft;
    }

    public final Integer component3() {
        return this.marginTop;
    }

    public final Integer component4() {
        return this.marginRight;
    }

    public final Integer component5() {
        return this.marginBottom;
    }

    public final String component6() {
        return this.frameArgb;
    }

    public final String component7() {
        return this.bgArgb;
    }

    public final String component8() {
        return this.radius;
    }

    public final String component9() {
        return this.fontSize;
    }

    public final IconText copy(List<Segment> r110, Integer r111, Integer r112, Integer r113, Integer r114, String r115, String r116, String r117, String r210) {
        return new IconText(r110, r111, r112, r113, r114, r115, r116, r117, r210);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof IconText) == false) goto L24;
        IconText r101 = (IconText) r100;
        if (Intrinsics.areEqual(this.segments, r101.segments) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.marginLeft, r101.marginLeft) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.marginTop, r101.marginTop) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.marginRight, r101.marginRight) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.marginBottom, r101.marginBottom) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.frameArgb, r101.frameArgb) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.bgArgb, r101.bgArgb) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.radius, r101.radius) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.fontSize, r101.fontSize) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    public int hashCode() {
        List<Segment> r100 = this.segments;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.marginLeft;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.marginTop;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.marginRight;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.marginBottom;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.frameArgb;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.bgArgb;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.radius;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.fontSize;
        if (r125 == null) goto L38;
        r101 = r125.hashCode();
    L38:
        return r124 + r101;
    L33:
        r123 = 0;
        goto L34
    L29:
        r120 = 0;
        goto L30
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
        return "IconText(segments=" + this.segments + ", marginLeft=" + this.marginLeft + ", marginTop=" + this.marginTop + ", marginRight=" + this.marginRight + ", marginBottom=" + this.marginBottom + ", frameArgb=" + this.frameArgb + ", bgArgb=" + this.bgArgb + ", radius=" + this.radius + ", fontSize=" + this.fontSize + ")";
    }

    public final String getBgArgb() {
        return this.bgArgb;
    }

    public final String getFontSize() {
        return this.fontSize;
    }

    public final String getFrameArgb() {
        return this.frameArgb;
    }

    public final Integer getMarginBottom() {
        return this.marginBottom;
    }

    public final Integer getMarginLeft() {
        return this.marginLeft;
    }

    public final Integer getMarginRight() {
        return this.marginRight;
    }

    public final Integer getMarginTop() {
        return this.marginTop;
    }

    public final String getRadius() {
        return this.radius;
    }

    public final List<Segment> getSegments() {
        return this.segments;
    }

    public IconText(List<Segment> r100, Integer r101, Integer r102, Integer r103, Integer r104, String r105, String r106, String r107, String r108) {
        this.segments = r100;
        this.marginLeft = r101;
        this.marginTop = r102;
        this.marginRight = r103;
        this.marginBottom = r104;
        this.frameArgb = r105;
        this.bgArgb = r106;
        this.radius = r107;
        this.fontSize = r108;
    }

    public /* synthetic */ IconText(List r110, Integer r111, Integer r112, Integer r113, Integer r114, String r115, String r116, String r117, String r118, int r210, DefaultConstructorMarker r211) {
        String r100 = null;
        if ((r210 & 1) == 0) goto L5;
        List r101 = null;
    L7:
        if ((r210 & 2) == 0) goto L9;
        Integer r102 = null;
    L11:
        if ((r210 & 4) == 0) goto L13;
        Integer r103 = null;
    L15:
        if ((r210 & 8) == 0) goto L17;
        Integer r104 = null;
    L19:
        if ((r210 & 16) == 0) goto L21;
        Integer r105 = null;
    L23:
        if ((r210 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r210 & 64) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r210 & 128) == 0) goto L33;
        String r108 = null;
    L35:
        if ((r210 & 256) != 0) goto L38;
        r100 = r118;
    L38:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r100);
        return;
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
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
        r101 = r110;
        goto L7
    }
}
