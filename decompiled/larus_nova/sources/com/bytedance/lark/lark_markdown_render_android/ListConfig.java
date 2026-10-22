package com.bytedance.lark.lark_markdown_render_android;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010(\u001a\u0004\u0018\u00010\u000bHÆ\u0003Jb\u0010)\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010*J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020/HÖ\u0001J\u0006\u00100\u001a\u000201J\t\u00102\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\u001c\u0010\u000e\"\u0004\b\u001d\u0010\u0010R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0019\"\u0004\b\u001f\u0010\u001bR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b \u0010\u000e\"\u0004\b!\u0010\u0010¨\u00063"}, d2 = {"Lcom/bytedance/lark/lark_markdown_render_android/ListConfig;", "", "orderedMarkerColor", "", "orderedMarkerFontSize", "", "unorderedMarkerColor", "unorderedMarkerFontSize", "blockGap", "itemGap", "itemPadding", "Lcom/bytedance/lark/lark_markdown_render_android/EdgeInsets;", "(Ljava/lang/String;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Lcom/bytedance/lark/lark_markdown_render_android/EdgeInsets;)V", "getBlockGap", "()Ljava/lang/Float;", "setBlockGap", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "getItemGap", "setItemGap", "getItemPadding", "()Lcom/bytedance/lark/lark_markdown_render_android/EdgeInsets;", "setItemPadding", "(Lcom/bytedance/lark/lark_markdown_render_android/EdgeInsets;)V", "getOrderedMarkerColor", "()Ljava/lang/String;", "setOrderedMarkerColor", "(Ljava/lang/String;)V", "getOrderedMarkerFontSize", "setOrderedMarkerFontSize", "getUnorderedMarkerColor", "setUnorderedMarkerColor", "getUnorderedMarkerFontSize", "setUnorderedMarkerFontSize", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Lcom/bytedance/lark/lark_markdown_render_android/EdgeInsets;)Lcom/bytedance/lark/lark_markdown_render_android/ListConfig;", "equals", "", "other", "hashCode", "", "into", "Llark_markdown_render/proto/ListConfig;", "toString", "lark_markdown_render_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ListConfig {
    private Float blockGap;
    private Float itemGap;
    private EdgeInsets itemPadding;
    private String orderedMarkerColor;
    private Float orderedMarkerFontSize;
    private String unorderedMarkerColor;
    private Float unorderedMarkerFontSize;

    public static /* synthetic */ ListConfig copy$default(ListConfig r100, String r101, Float r102, String r103, Float r104, Float r110, Float r111, EdgeInsets r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.orderedMarkerColor;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.orderedMarkerFontSize;
    L8:
        Float r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.unorderedMarkerColor;
    L11:
        String r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.unorderedMarkerFontSize;
    L14:
        Float r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.blockGap;
    L17:
        Float r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.itemGap;
    L20:
        Float r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.itemPadding;
    L23:
        String r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final String component1() {
        return this.orderedMarkerColor;
    }

    public final Float component2() {
        return this.orderedMarkerFontSize;
    }

    public final String component3() {
        return this.unorderedMarkerColor;
    }

    public final Float component4() {
        return this.unorderedMarkerFontSize;
    }

    public final Float component5() {
        return this.blockGap;
    }

    public final Float component6() {
        return this.itemGap;
    }

    public final EdgeInsets component7() {
        return this.itemPadding;
    }

    public final ListConfig copy(String r110, Float r111, String r112, Float r113, Float r114, Float r115, EdgeInsets r116) {
        return new ListConfig(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ListConfig) == true) goto L8;
        return false;
    L8:
        ListConfig r101 = (ListConfig) r100;
        if (Intrinsics.areEqual(this.orderedMarkerColor, r101.orderedMarkerColor) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.orderedMarkerFontSize, r101.orderedMarkerFontSize) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.unorderedMarkerColor, r101.unorderedMarkerColor) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.unorderedMarkerFontSize, r101.unorderedMarkerFontSize) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.blockGap, r101.blockGap) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.itemGap, r101.itemGap) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.itemPadding, r101.itemPadding) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        String r100 = this.orderedMarkerColor;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Float r104 = this.orderedMarkerFontSize;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.unorderedMarkerColor;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Float r110 = this.unorderedMarkerFontSize;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Float r113 = this.blockGap;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Float r116 = this.itemGap;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        EdgeInsets r119 = this.itemPadding;
        if (r119 == null) goto L31;
        r101 = r119.hashCode();
    L31:
        return r118 + r101;
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
        return "ListConfig(orderedMarkerColor=" + this.orderedMarkerColor + ", orderedMarkerFontSize=" + this.orderedMarkerFontSize + ", unorderedMarkerColor=" + this.unorderedMarkerColor + ", unorderedMarkerFontSize=" + this.unorderedMarkerFontSize + ", blockGap=" + this.blockGap + ", itemGap=" + this.itemGap + ", itemPadding=" + this.itemPadding + ')';
    }

    public final lark_markdown_render.proto.ListConfig into() {
        String r100 = this.orderedMarkerColor;
        Float r101 = this.orderedMarkerFontSize;
        String r102 = this.unorderedMarkerColor;
        Float r103 = this.unorderedMarkerFontSize;
        Float r104 = this.blockGap;
        Float r105 = this.itemGap;
        EdgeInsets r106 = this.itemPadding;
        if (r106 == null) goto L5;
        lark_markdown_render.proto.EdgeInsets r107 = r106.into();
    L7:
        return new lark_markdown_render.proto.ListConfig(r100, r101, r102, r103, r104, r105, r107);
    L5:
        r107 = null;
        goto L7
    }

    public final Float getBlockGap() {
        return this.blockGap;
    }

    public final Float getItemGap() {
        return this.itemGap;
    }

    public final EdgeInsets getItemPadding() {
        return this.itemPadding;
    }

    public final String getOrderedMarkerColor() {
        return this.orderedMarkerColor;
    }

    public final Float getOrderedMarkerFontSize() {
        return this.orderedMarkerFontSize;
    }

    public final String getUnorderedMarkerColor() {
        return this.unorderedMarkerColor;
    }

    public final Float getUnorderedMarkerFontSize() {
        return this.unorderedMarkerFontSize;
    }

    public final void setBlockGap(Float r100) {
        this.blockGap = r100;
    }

    public final void setItemGap(Float r100) {
        this.itemGap = r100;
    }

    public final void setItemPadding(EdgeInsets r100) {
        this.itemPadding = r100;
    }

    public final void setOrderedMarkerColor(String r100) {
        this.orderedMarkerColor = r100;
    }

    public final void setOrderedMarkerFontSize(Float r100) {
        this.orderedMarkerFontSize = r100;
    }

    public final void setUnorderedMarkerColor(String r100) {
        this.unorderedMarkerColor = r100;
    }

    public final void setUnorderedMarkerFontSize(Float r100) {
        this.unorderedMarkerFontSize = r100;
    }

    public ListConfig(String r100, Float r101, String r102, Float r103, Float r104, Float r105, EdgeInsets r106) {
        this.orderedMarkerColor = r100;
        this.orderedMarkerFontSize = r101;
        this.unorderedMarkerColor = r102;
        this.unorderedMarkerFontSize = r103;
        this.blockGap = r104;
        this.itemGap = r105;
        this.itemPadding = r106;
    }
}
