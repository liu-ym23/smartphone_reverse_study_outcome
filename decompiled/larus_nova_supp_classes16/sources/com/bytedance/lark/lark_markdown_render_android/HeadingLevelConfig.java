package com.bytedance.lark.lark_markdown_render_android;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\bHÆ\u0003J>\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\u0006\u0010$\u001a\u00020%J\t\u0010&\u001a\u00020'HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\u0013\u0010\u000b\"\u0004\b\u0014\u0010\rR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006("}, d2 = {"Lcom/bytedance/lark/lark_markdown_render_android/HeadingLevelConfig;", "", "fontSize", "", "fontWeight", "Lcom/bytedance/lark/lark_markdown_render_android/FontWeight;", "lineHeight", "padding", "Lcom/bytedance/lark/lark_markdown_render_android/EdgeInsets;", "(Ljava/lang/Float;Lcom/bytedance/lark/lark_markdown_render_android/FontWeight;Ljava/lang/Float;Lcom/bytedance/lark/lark_markdown_render_android/EdgeInsets;)V", "getFontSize", "()Ljava/lang/Float;", "setFontSize", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "getFontWeight", "()Lcom/bytedance/lark/lark_markdown_render_android/FontWeight;", "setFontWeight", "(Lcom/bytedance/lark/lark_markdown_render_android/FontWeight;)V", "getLineHeight", "setLineHeight", "getPadding", "()Lcom/bytedance/lark/lark_markdown_render_android/EdgeInsets;", "setPadding", "(Lcom/bytedance/lark/lark_markdown_render_android/EdgeInsets;)V", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Float;Lcom/bytedance/lark/lark_markdown_render_android/FontWeight;Ljava/lang/Float;Lcom/bytedance/lark/lark_markdown_render_android/EdgeInsets;)Lcom/bytedance/lark/lark_markdown_render_android/HeadingLevelConfig;", "equals", "", "other", "hashCode", "", "into", "Llark_markdown_render/proto/HeadingLevelConfig;", "toString", "", "lark_markdown_render_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class HeadingLevelConfig {
    private Float fontSize;
    private FontWeight fontWeight;
    private Float lineHeight;
    private EdgeInsets padding;

    public static /* synthetic */ HeadingLevelConfig copy$default(HeadingLevelConfig r0, Float r1, FontWeight r2, Float r3, EdgeInsets r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.fontSize;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.fontWeight;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.lineHeight;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.padding;
    L15:
        return r0.copy(r1, r2, r3, r4);
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

    public final HeadingLevelConfig copy(Float r2, FontWeight r3, Float r4, EdgeInsets r5) {
        return new HeadingLevelConfig(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof HeadingLevelConfig) == true) goto L8;
        return false;
    L8:
        HeadingLevelConfig r6 = (HeadingLevelConfig) r5;
        if (Intrinsics.areEqual(this.fontSize, r6.fontSize) == true) goto L12;
        return false;
    L12:
        if (this.fontWeight == r6.fontWeight) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.lineHeight, r6.lineHeight) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.padding, r6.padding) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        Float r0 = this.fontSize;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        FontWeight r4 = this.fontWeight;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Float r7 = this.lineHeight;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        EdgeInsets r10 = this.padding;
        if (r10 == null) goto L19;
        r1 = r10.hashCode();
    L19:
        return r9 + r1;
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
        return "HeadingLevelConfig(fontSize=" + this.fontSize + ", fontWeight=" + this.fontWeight + ", lineHeight=" + this.lineHeight + ", padding=" + this.padding + ')';
    }

    public final lark_markdown_render.proto.HeadingLevelConfig into() {
        Float r0 = this.fontSize;
        FontWeight r1 = this.fontWeight;
        lark_markdown_render.proto.EdgeInsets r2 = null;
        if (r1 == null) goto L5;
        lark_markdown_render.proto.FontWeight r3 = r1.into();
    L6:
        Float r4 = this.lineHeight;
        EdgeInsets r5 = this.padding;
        if (r5 == null) goto L10;
        r2 = r5.into();
    L10:
        return new lark_markdown_render.proto.HeadingLevelConfig(r0, r3, r4, r2);
    L5:
        r3 = null;
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

    public final void setFontSize(Float r1) {
        this.fontSize = r1;
    }

    public final void setFontWeight(FontWeight r1) {
        this.fontWeight = r1;
    }

    public final void setLineHeight(Float r1) {
        this.lineHeight = r1;
    }

    public final void setPadding(EdgeInsets r1) {
        this.padding = r1;
    }

    public HeadingLevelConfig(Float r1, FontWeight r2, Float r3, EdgeInsets r4) {
        this.fontSize = r1;
        this.fontWeight = r2;
        this.lineHeight = r3;
        this.padding = r4;
    }
}
