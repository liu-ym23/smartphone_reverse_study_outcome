package com.bytedance.lark.lark_markdown_render_android;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J<\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\u0006\u0010#\u001a\u00020$J\t\u0010%\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014¨\u0006&"}, d2 = {"Lcom/bytedance/lark/lark_markdown_render_android/ThematicBreakConfig;", "", "height", "", "lineColor", "", "marginTop", "marginBottom", "(FLjava/lang/String;Ljava/lang/Float;Ljava/lang/Float;)V", "getHeight", "()F", "setHeight", "(F)V", "getLineColor", "()Ljava/lang/String;", "setLineColor", "(Ljava/lang/String;)V", "getMarginBottom", "()Ljava/lang/Float;", "setMarginBottom", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "getMarginTop", "setMarginTop", "component1", "component2", "component3", "component4", "copy", "(FLjava/lang/String;Ljava/lang/Float;Ljava/lang/Float;)Lcom/bytedance/lark/lark_markdown_render_android/ThematicBreakConfig;", "equals", "", "other", "hashCode", "", "into", "Llark_markdown_render/proto/ThematicBreakConfig;", "toString", "lark_markdown_render_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ThematicBreakConfig {
    private float height;
    private String lineColor;
    private Float marginBottom;
    private Float marginTop;

    public static /* synthetic */ ThematicBreakConfig copy$default(ThematicBreakConfig r100, float r101, String r102, Float r103, Float r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.height;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.lineColor;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.marginTop;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.marginBottom;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final float component1() {
        return this.height;
    }

    public final String component2() {
        return this.lineColor;
    }

    public final Float component3() {
        return this.marginTop;
    }

    public final Float component4() {
        return this.marginBottom;
    }

    public final ThematicBreakConfig copy(float r100, String r101, Float r102, Float r103) {
        return new ThematicBreakConfig(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ThematicBreakConfig) == true) goto L8;
        return false;
    L8:
        ThematicBreakConfig r101 = (ThematicBreakConfig) r100;
        if (Float.compare(this.height, r101.height) == 0) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.lineColor, r101.lineColor) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.marginTop, r101.marginTop) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.marginBottom, r101.marginBottom) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r100 = Float.floatToIntBits(this.height) * 31;
        String r101 = this.lineColor;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Float r105 = this.marginTop;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        Float r108 = this.marginBottom;
        if (r108 == null) goto L15;
        r102 = r108.hashCode();
    L15:
        return r107 + r102;
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "ThematicBreakConfig(height=" + this.height + ", lineColor=" + this.lineColor + ", marginTop=" + this.marginTop + ", marginBottom=" + this.marginBottom + ')';
    }

    public final lark_markdown_render.proto.ThematicBreakConfig into() {
        return new lark_markdown_render.proto.ThematicBreakConfig(Float.valueOf(this.height), this.lineColor, this.marginTop, this.marginBottom);
    }

    public final float getHeight() {
        return this.height;
    }

    public final String getLineColor() {
        return this.lineColor;
    }

    public final Float getMarginBottom() {
        return this.marginBottom;
    }

    public final Float getMarginTop() {
        return this.marginTop;
    }

    public final void setHeight(float r100) {
        this.height = r100;
    }

    public final void setLineColor(String r100) {
        this.lineColor = r100;
    }

    public final void setMarginBottom(Float r100) {
        this.marginBottom = r100;
    }

    public final void setMarginTop(Float r100) {
        this.marginTop = r100;
    }

    public ThematicBreakConfig(float r100, String r101, Float r102, Float r103) {
        this.height = r100;
        this.lineColor = r101;
        this.marginTop = r102;
        this.marginBottom = r103;
    }
}
