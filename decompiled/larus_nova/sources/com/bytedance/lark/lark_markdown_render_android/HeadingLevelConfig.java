package com.bytedance.lark.lark_markdown_render_android;

import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\bHÆ\u0003J>\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\u0006\u0010$\u001a\u00020%J\t\u0010&\u001a\u00020'HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\u0013\u0010\u000b\"\u0004\b\u0014\u0010\rR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006("}, d2 = {"Lcom/bytedance/lark/lark_markdown_render_android/HeadingLevelConfig;", "", "fontSize", "", "fontWeight", "Lcom/bytedance/lark/lark_markdown_render_android/FontWeight;", "lineHeight", GXTemplateKey.FLEXBOX_PADDING, "Lcom/bytedance/lark/lark_markdown_render_android/EdgeInsets;", "(Ljava/lang/Float;Lcom/bytedance/lark/lark_markdown_render_android/FontWeight;Ljava/lang/Float;Lcom/bytedance/lark/lark_markdown_render_android/EdgeInsets;)V", "getFontSize", "()Ljava/lang/Float;", "setFontSize", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "getFontWeight", "()Lcom/bytedance/lark/lark_markdown_render_android/FontWeight;", "setFontWeight", "(Lcom/bytedance/lark/lark_markdown_render_android/FontWeight;)V", "getLineHeight", "setLineHeight", "getPadding", "()Lcom/bytedance/lark/lark_markdown_render_android/EdgeInsets;", "setPadding", "(Lcom/bytedance/lark/lark_markdown_render_android/EdgeInsets;)V", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Float;Lcom/bytedance/lark/lark_markdown_render_android/FontWeight;Ljava/lang/Float;Lcom/bytedance/lark/lark_markdown_render_android/EdgeInsets;)Lcom/bytedance/lark/lark_markdown_render_android/HeadingLevelConfig;", "equals", "", "other", "hashCode", "", "into", "Llark_markdown_render/proto/HeadingLevelConfig;", "toString", "", "lark_markdown_render_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class HeadingLevelConfig {
    private Float fontSize;
    private FontWeight fontWeight;
    private Float lineHeight;
    private EdgeInsets padding;

    public static /* synthetic */ HeadingLevelConfig copy$default(HeadingLevelConfig r100, Float r101, FontWeight r102, Float r103, EdgeInsets r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.fontSize;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.fontWeight;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.lineHeight;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.padding;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final Float component1() {
        return this.fontSize;
    }

    public final FontWeight component2() {
        return this.fontWeight;
    }

    public final Float component3() {
        return this.lineHeight;
    }

    public final EdgeInsets component4() {
        return this.padding;
    }

    public final HeadingLevelConfig copy(Float r100, FontWeight r101, Float r102, EdgeInsets r103) {
        return new HeadingLevelConfig(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof HeadingLevelConfig) == true) goto L8;
        return false;
    L8:
        HeadingLevelConfig r101 = (HeadingLevelConfig) r100;
        if (Intrinsics.areEqual(this.fontSize, r101.fontSize) == true) goto L12;
        return false;
    L12:
        if (this.fontWeight == r101.fontWeight) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.lineHeight, r101.lineHeight) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.padding, r101.padding) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        Float r100 = this.fontSize;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        FontWeight r104 = this.fontWeight;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Float r107 = this.lineHeight;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        EdgeInsets r110 = this.padding;
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
        return "HeadingLevelConfig(fontSize=" + this.fontSize + ", fontWeight=" + this.fontWeight + ", lineHeight=" + this.lineHeight + ", padding=" + this.padding + ')';
    }

    public final lark_markdown_render.proto.HeadingLevelConfig into() {
        Float r100 = this.fontSize;
        FontWeight r101 = this.fontWeight;
        lark_markdown_render.proto.EdgeInsets r102 = null;
        if (r101 == null) goto L5;
        lark_markdown_render.proto.FontWeight r103 = r101.into();
    L6:
        Float r104 = this.lineHeight;
        EdgeInsets r105 = this.padding;
        if (r105 == null) goto L10;
        r102 = r105.into();
    L10:
        return new lark_markdown_render.proto.HeadingLevelConfig(r100, r103, r104, r102);
    L5:
        r103 = null;
        goto L6
    }

    public final Float getFontSize() {
        return this.fontSize;
    }

    public final FontWeight getFontWeight() {
        return this.fontWeight;
    }

    public final Float getLineHeight() {
        return this.lineHeight;
    }

    public final EdgeInsets getPadding() {
        return this.padding;
    }

    public final void setFontSize(Float r100) {
        this.fontSize = r100;
    }

    public final void setFontWeight(FontWeight r100) {
        this.fontWeight = r100;
    }

    public final void setLineHeight(Float r100) {
        this.lineHeight = r100;
    }

    public final void setPadding(EdgeInsets r100) {
        this.padding = r100;
    }

    public HeadingLevelConfig(Float r100, FontWeight r101, Float r102, EdgeInsets r103) {
        this.fontSize = r100;
        this.fontWeight = r101;
        this.lineHeight = r102;
        this.padding = r103;
    }
}
