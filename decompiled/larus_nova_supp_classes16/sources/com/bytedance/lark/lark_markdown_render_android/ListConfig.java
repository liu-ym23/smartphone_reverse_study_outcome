package com.bytedance.lark.lark_markdown_render_android;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010(\u001a\u0004\u0018\u00010\u000bHÆ\u0003Jb\u0010)\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010*J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020/HÖ\u0001J\u0006\u00100\u001a\u000201J\t\u00102\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\u001c\u0010\u000e\"\u0004\b\u001d\u0010\u0010R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0019\"\u0004\b\u001f\u0010\u001bR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b \u0010\u000e\"\u0004\b!\u0010\u0010¨\u00063"}, d2 = {"Lcom/bytedance/lark/lark_markdown_render_android/ListConfig;", "", "orderedMarkerColor", "", "orderedMarkerFontSize", "", "unorderedMarkerColor", "unorderedMarkerFontSize", "blockGap", "itemGap", "itemPadding", "Lcom/bytedance/lark/lark_markdown_render_android/EdgeInsets;", "(Ljava/lang/String;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Lcom/bytedance/lark/lark_markdown_render_android/EdgeInsets;)V", "getBlockGap", "()Ljava/lang/Float;", "setBlockGap", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "getItemGap", "setItemGap", "getItemPadding", "()Lcom/bytedance/lark/lark_markdown_render_android/EdgeInsets;", "setItemPadding", "(Lcom/bytedance/lark/lark_markdown_render_android/EdgeInsets;)V", "getOrderedMarkerColor", "()Ljava/lang/String;", "setOrderedMarkerColor", "(Ljava/lang/String;)V", "getOrderedMarkerFontSize", "setOrderedMarkerFontSize", "getUnorderedMarkerColor", "setUnorderedMarkerColor", "getUnorderedMarkerFontSize", "setUnorderedMarkerFontSize", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Lcom/bytedance/lark/lark_markdown_render_android/EdgeInsets;)Lcom/bytedance/lark/lark_markdown_render_android/ListConfig;", "equals", "", "other", "hashCode", "", "into", "Llark_markdown_render/proto/ListConfig;", "toString", "lark_markdown_render_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ListConfig {
    private Float blockGap;
    private Float itemGap;
    private EdgeInsets itemPadding;
    private String orderedMarkerColor;
    private Float orderedMarkerFontSize;
    private String unorderedMarkerColor;
    private Float unorderedMarkerFontSize;

    public static /* synthetic */ ListConfig copy$default(ListConfig r5, String r6, Float r7, String r8, Float r9, Float r10, Float r11, EdgeInsets r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.orderedMarkerColor;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.orderedMarkerFontSize;
    L8:
        Float r16 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.unorderedMarkerColor;
    L11:
        String r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.unorderedMarkerFontSize;
    L14:
        Float r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r10 = r5.blockGap;
    L17:
        Float r2 = r10;
        if ((r13 & 32) == 0) goto L20;
        r11 = r5.itemGap;
    L20:
        Float r3 = r11;
        if ((r13 & 64) == 0) goto L23;
        r12 = r5.itemPadding;
    L23:
        String r17 = r6;
        return r5.copy(r17, r16, r0, r1, r2, r3, r12);
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

    public final ListConfig copy(String r10, Float r11, String r12, Float r13, Float r14, Float r16, EdgeInsets r17) {
        return new ListConfig(r10, r11, r12, r13, r14, r16, r17);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ListConfig) == true) goto L8;
        return false;
    L8:
        ListConfig r6 = (ListConfig) r5;
        if (Intrinsics.areEqual(this.orderedMarkerColor, r6.orderedMarkerColor) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.orderedMarkerFontSize, r6.orderedMarkerFontSize) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.unorderedMarkerColor, r6.unorderedMarkerColor) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.unorderedMarkerFontSize, r6.unorderedMarkerFontSize) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.blockGap, r6.blockGap) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.itemGap, r6.itemGap) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.itemPadding, r6.itemPadding) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        String r0 = this.orderedMarkerColor;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Float r4 = this.orderedMarkerFontSize;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.unorderedMarkerColor;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Float r10 = this.unorderedMarkerFontSize;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Float r13 = this.blockGap;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r16 = (r12 + r14) * 31;
        Float r17 = this.itemGap;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r19 = (r16 + r18) * 31;
        EdgeInsets r20 = this.itemPadding;
        if (r20 == null) goto L31;
        r1 = r20.hashCode();
    L31:
        return r19 + r1;
    L25:
        r18 = r17.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "ListConfig(orderedMarkerColor=" + this.orderedMarkerColor + ", orderedMarkerFontSize=" + this.orderedMarkerFontSize + ", unorderedMarkerColor=" + this.unorderedMarkerColor + ", unorderedMarkerFontSize=" + this.unorderedMarkerFontSize + ", blockGap=" + this.blockGap + ", itemGap=" + this.itemGap + ", itemPadding=" + this.itemPadding + ')';
    }

    public final lark_markdown_render.proto.ListConfig into() {
        String r1 = this.orderedMarkerColor;
        Float r2 = this.orderedMarkerFontSize;
        String r3 = this.unorderedMarkerColor;
        Float r4 = this.unorderedMarkerFontSize;
        Float r5 = this.blockGap;
        Float r6 = this.itemGap;
        EdgeInsets r0 = this.itemPadding;
        if (r0 == null) goto L5;
        lark_markdown_render.proto.EdgeInsets r7 = r0.into();
    L7:
        return new lark_markdown_render.proto.ListConfig(r1, r2, r3, r4, r5, r6, r7);
    L5:
        r7 = null;
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

    public final void setBlockGap(Float r1) {
        this.blockGap = r1;
    }

    public final void setItemGap(Float r1) {
        this.itemGap = r1;
    }

    public final void setItemPadding(EdgeInsets r1) {
        this.itemPadding = r1;
    }

    public final void setOrderedMarkerColor(String r1) {
        this.orderedMarkerColor = r1;
    }

    public final void setOrderedMarkerFontSize(Float r1) {
        this.orderedMarkerFontSize = r1;
    }

    public final void setUnorderedMarkerColor(String r1) {
        this.unorderedMarkerColor = r1;
    }

    public final void setUnorderedMarkerFontSize(Float r1) {
        this.unorderedMarkerFontSize = r1;
    }

    public ListConfig(String r1, Float r2, String r3, Float r4, Float r5, Float r6, EdgeInsets r7) {
        this.orderedMarkerColor = r1;
        this.orderedMarkerFontSize = r2;
        this.unorderedMarkerColor = r3;
        this.unorderedMarkerFontSize = r4;
        this.blockGap = r5;
        this.itemGap = r6;
        this.itemPadding = r7;
    }
}
