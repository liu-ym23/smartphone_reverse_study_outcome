package com.bytedance.awemeopen.bizmodels.feed.poi;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ`\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\u0005HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u001a\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\rR\u001a\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0010\u0010\rR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0014\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006&"}, d2 = {"Lcom/bytedance/awemeopen/bizmodels/feed/poi/PoiAnchorContentElement;", "Ljava/io/Serializable;", "text", "", "truncateMinLength", "", "textSize", "textColor", "iconWidth", "iconHeight", "elementType", "(Ljava/lang/String;ILjava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getElementType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getIconHeight", "getIconWidth", "getText", "()Ljava/lang/String;", "getTextColor", "getTextSize", "getTruncateMinLength", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;ILjava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/bytedance/awemeopen/bizmodels/feed/poi/PoiAnchorContentElement;", "equals", "", "other", "", "hashCode", "toString", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PoiAnchorContentElement implements Serializable {

    @SerializedName("anchor_content_element_type")
    private final Integer elementType;

    @SerializedName("icon_height")
    private final Integer iconHeight;

    @SerializedName("icon_width")
    private final Integer iconWidth;

    @SerializedName("text")
    private final String text;

    @SerializedName("text_color")
    private final String textColor;

    @SerializedName("text_size")
    private final Integer textSize;

    @SerializedName("truncate_min_len")
    private final int truncateMinLength;

    public PoiAnchorContentElement() {
        this(null, 0, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ PoiAnchorContentElement copy$default(PoiAnchorContentElement r100, String r101, int r102, Integer r103, String r104, Integer r110, Integer r111, Integer r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.text;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.truncateMinLength;
    L8:
        int r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.textSize;
    L11:
        Integer r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.textColor;
    L14:
        String r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.iconWidth;
    L17:
        Integer r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.iconHeight;
    L20:
        Integer r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.elementType;
    L23:
        String r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final String component1() {
        return this.text;
    }

    public final int component2() {
        return this.truncateMinLength;
    }

    public final Integer component3() {
        return this.textSize;
    }

    public final String component4() {
        return this.textColor;
    }

    public final Integer component5() {
        return this.iconWidth;
    }

    public final Integer component6() {
        return this.iconHeight;
    }

    public final Integer component7() {
        return this.elementType;
    }

    public final PoiAnchorContentElement copy(String r110, int r111, Integer r112, String r113, Integer r114, Integer r115, Integer r116) {
        return new PoiAnchorContentElement(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PoiAnchorContentElement) == true) goto L8;
        return false;
    L8:
        PoiAnchorContentElement r101 = (PoiAnchorContentElement) r100;
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L12;
        return false;
    L12:
        if (this.truncateMinLength == r101.truncateMinLength) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.textSize, r101.textSize) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.textColor, r101.textColor) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.iconWidth, r101.iconWidth) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.iconHeight, r101.iconHeight) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.elementType, r101.elementType) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        String r100 = this.text;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.truncateMinLength) * 31;
        Integer r104 = this.textSize;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.textColor;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.iconWidth;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.iconHeight;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.elementType;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return r115 + r101;
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
        return "PoiAnchorContentElement(text=" + this.text + ", truncateMinLength=" + this.truncateMinLength + ", textSize=" + this.textSize + ", textColor=" + this.textColor + ", iconWidth=" + this.iconWidth + ", iconHeight=" + this.iconHeight + ", elementType=" + this.elementType + ')';
    }

    public final Integer getElementType() {
        return this.elementType;
    }

    public final Integer getIconHeight() {
        return this.iconHeight;
    }

    public final Integer getIconWidth() {
        return this.iconWidth;
    }

    public final String getText() {
        return this.text;
    }

    public final String getTextColor() {
        return this.textColor;
    }

    public final Integer getTextSize() {
        return this.textSize;
    }

    public final int getTruncateMinLength() {
        return this.truncateMinLength;
    }

    public PoiAnchorContentElement(String r100, int r101, Integer r102, String r103, Integer r104, Integer r105, Integer r106) {
        this.text = r100;
        this.truncateMinLength = r101;
        this.textSize = r102;
        this.textColor = r103;
        this.iconWidth = r104;
        this.iconHeight = r105;
        this.elementType = r106;
    }

    public /* synthetic */ PoiAnchorContentElement(String r100, int r101, Integer r102, String r103, Integer r110, Integer r111, Integer r112, int r113, DefaultConstructorMarker r114) {
        String r104 = "";
        if ((r113 & 1) == 0) goto L5;
        String r115 = "";
    L7:
        if ((r113 & 2) == 0) goto L9;
        int r105 = -1;
    L11:
        if ((r113 & 4) == 0) goto L13;
        Integer r106 = null;
    L15:
        if ((r113 & 8) != 0) goto L19;
        r104 = r103;
    L19:
        if ((r113 & 16) == 0) goto L21;
        Integer r107 = null;
    L23:
        if ((r113 & 32) == 0) goto L25;
        Integer r108 = null;
    L27:
        if ((r113 & 64) == 0) goto L29;
        r112 = 0;
    L29:
        this(r115, r105, r106, r104, r107, r108, r112);
        return;
    L25:
        r108 = r111;
        goto L27
    L21:
        r107 = r110;
        goto L23
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r115 = r100;
        goto L7
    }
}
