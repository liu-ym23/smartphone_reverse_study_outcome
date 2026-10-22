package com.bytedance.awemeopen.bizmodels.feed.poi;

import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002BY\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f¢\u0006\u0002\u0010\u000eJ\u0011\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0000H\u0096\u0002J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÆ\u0003J\t\u0010 \u001a\u00020\u0006HÆ\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0011\u0010#\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fHÆ\u0003Jb\u0010$\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010%J\u0013\u0010&\u001a\u00020'2\b\u0010\u001c\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020\u0006HÖ\u0001J\t\u0010*\u001a\u00020\u0004HÖ\u0001R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0016\u0010\b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u001a\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015¨\u0006+"}, d2 = {"Lcom/bytedance/awemeopen/bizmodels/feed/poi/PoiAnchorContentStruct;", "Ljava/io/Serializable;", "", "content", "", "type", "", "style", "priority", "truncateMinLength", "greyBackgroundColor", SlcElement.KEY_ELEMENTS, "", "Lcom/bytedance/awemeopen/bizmodels/feed/poi/PoiAnchorContentElement;", "(Ljava/lang/String;IIILjava/lang/Integer;Ljava/lang/String;Ljava/util/List;)V", "getContent", "()Ljava/lang/String;", "getElements", "()Ljava/util/List;", "getGreyBackgroundColor", "getPriority", "()I", "getStyle", "getTruncateMinLength", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getType", "compareTo", "other", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;IIILjava/lang/Integer;Ljava/lang/String;Ljava/util/List;)Lcom/bytedance/awemeopen/bizmodels/feed/poi/PoiAnchorContentStruct;", "equals", "", "", "hashCode", "toString", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PoiAnchorContentStruct implements Serializable, Comparable<PoiAnchorContentStruct> {

    @SerializedName("content")
    private final String content;

    @SerializedName(SlcElement.KEY_ELEMENTS)
    private final List<PoiAnchorContentElement> elements;

    @SerializedName("background_color")
    private final String greyBackgroundColor;

    @SerializedName("priority")
    private final int priority;

    @SerializedName("style")
    private final int style;

    @SerializedName("truncate_min_len")
    private final Integer truncateMinLength;

    @SerializedName("type")
    private final int type;

    public PoiAnchorContentStruct() {
        this(null, 0, 0, 0, null, null, null, 127, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PoiAnchorContentStruct copy$default(PoiAnchorContentStruct r100, String r101, int r102, int r103, int r104, Integer r110, String r111, List r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.content;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.type;
    L8:
        int r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.style;
    L11:
        int r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.priority;
    L14:
        int r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.truncateMinLength;
    L17:
        Integer r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.greyBackgroundColor;
    L20:
        String r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.elements;
    L23:
        String r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final String component1() {
        return this.content;
    }

    public final int component2() {
        return this.type;
    }

    public final int component3() {
        return this.style;
    }

    public final int component4() {
        return this.priority;
    }

    public final Integer component5() {
        return this.truncateMinLength;
    }

    public final String component6() {
        return this.greyBackgroundColor;
    }

    public final List<PoiAnchorContentElement> component7() {
        return this.elements;
    }

    public final PoiAnchorContentStruct copy(String r110, int r111, int r112, int r113, Integer r114, String r115, List<PoiAnchorContentElement> r116) {
        return new PoiAnchorContentStruct(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PoiAnchorContentStruct) == true) goto L8;
        return false;
    L8:
        PoiAnchorContentStruct r101 = (PoiAnchorContentStruct) r100;
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L12;
        return false;
    L12:
        if (this.type == r101.type) goto L15;
        return false;
    L15:
        if (this.style == r101.style) goto L18;
        return false;
    L18:
        if (this.priority == r101.priority) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.truncateMinLength, r101.truncateMinLength) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.greyBackgroundColor, r101.greyBackgroundColor) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.elements, r101.elements) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        String r100 = this.content;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((((((r102 * 31) + this.type) * 31) + this.style) * 31) + this.priority) * 31;
        Integer r104 = this.truncateMinLength;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.greyBackgroundColor;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        List<PoiAnchorContentElement> r110 = this.elements;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
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
        return "PoiAnchorContentStruct(content=" + this.content + ", type=" + this.type + ", style=" + this.style + ", priority=" + this.priority + ", truncateMinLength=" + this.truncateMinLength + ", greyBackgroundColor=" + this.greyBackgroundColor + ", elements=" + this.elements + ')';
    }

    public final String getContent() {
        return this.content;
    }

    public final List<PoiAnchorContentElement> getElements() {
        return this.elements;
    }

    public final String getGreyBackgroundColor() {
        return this.greyBackgroundColor;
    }

    public final int getPriority() {
        return this.priority;
    }

    public final int getStyle() {
        return this.style;
    }

    public final Integer getTruncateMinLength() {
        return this.truncateMinLength;
    }

    public final int getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(PoiAnchorContentStruct r100) {
        Intrinsics.checkNotNullParameter(r100, "other");
        if (this.priority <= r100.priority) goto L5;
        return -1;
    L5:
        return 1;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(PoiAnchorContentStruct r100) {
        return compareTo2(r100);
    }

    public PoiAnchorContentStruct(String r100, int r101, int r102, int r103, Integer r104, String r105, List<PoiAnchorContentElement> r106) {
        this.content = r100;
        this.type = r101;
        this.style = r102;
        this.priority = r103;
        this.truncateMinLength = r104;
        this.greyBackgroundColor = r105;
        this.elements = r106;
    }

    public /* synthetic */ PoiAnchorContentStruct(String r100, int r101, int r102, int r110, Integer r111, String r112, List r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 1) == 0) goto L5;
        String r116 = null;
    L6:
        int r103 = 0;
        if ((r114 & 2) == 0) goto L9;
        int r104 = 0;
    L11:
        if ((r114 & 4) == 0) goto L13;
        int r105 = 0;
    L15:
        if ((r114 & 8) != 0) goto L19;
        r103 = r110;
    L19:
        if ((r114 & 16) == 0) goto L21;
        r111 = -1;
    L21:
        Integer r106 = r111;
        if ((r114 & 32) == 0) goto L24;
        String r107 = null;
    L26:
        if ((r114 & 64) == 0) goto L28;
        List r117 = null;
    L29:
        this(r116, r104, r105, r103, r106, r107, r117);
        return;
    L28:
        r117 = r113;
        goto L29
    L24:
        r107 = r112;
        goto L26
    L13:
        r105 = r102;
        goto L15
    L9:
        r104 = r101;
        goto L11
    L5:
        r116 = r100;
        goto L6
    }
}
