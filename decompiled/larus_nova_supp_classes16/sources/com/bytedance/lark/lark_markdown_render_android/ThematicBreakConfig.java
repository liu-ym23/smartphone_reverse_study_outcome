package com.bytedance.lark.lark_markdown_render_android;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J<\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\u0006\u0010#\u001a\u00020$J\t\u0010%\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014¨\u0006&"}, d2 = {"Lcom/bytedance/lark/lark_markdown_render_android/ThematicBreakConfig;", "", "height", "", "lineColor", "", "marginTop", "marginBottom", "(FLjava/lang/String;Ljava/lang/Float;Ljava/lang/Float;)V", "getHeight", "()F", "setHeight", "(F)V", "getLineColor", "()Ljava/lang/String;", "setLineColor", "(Ljava/lang/String;)V", "getMarginBottom", "()Ljava/lang/Float;", "setMarginBottom", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "getMarginTop", "setMarginTop", "component1", "component2", "component3", "component4", "copy", "(FLjava/lang/String;Ljava/lang/Float;Ljava/lang/Float;)Lcom/bytedance/lark/lark_markdown_render_android/ThematicBreakConfig;", "equals", "", "other", "hashCode", "", "into", "Llark_markdown_render/proto/ThematicBreakConfig;", "toString", "lark_markdown_render_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ThematicBreakConfig {
    private float height;
    private String lineColor;
    private Float marginBottom;
    private Float marginTop;

    public static /* synthetic */ ThematicBreakConfig copy$default(ThematicBreakConfig r0, float r1, String r2, Float r3, Float r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.height;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.lineColor;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.marginTop;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.marginBottom;
    L15:
        return r0.copy(r1, r2, r3, r4);
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

    public final ThematicBreakConfig copy(float r2, String r3, Float r4, Float r5) {
        return new ThematicBreakConfig(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ThematicBreakConfig) == true) goto L8;
        return false;
    L8:
        ThematicBreakConfig r6 = (ThematicBreakConfig) r5;
        if (Float.compare(this.height, r6.height) == 0) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.lineColor, r6.lineColor) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.marginTop, r6.marginTop) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.marginBottom, r6.marginBottom) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = Float.floatToIntBits(this.height) * 31;
        String r1 = this.lineColor;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Float r5 = this.marginTop;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        Float r8 = this.marginBottom;
        if (r8 == null) goto L15;
        r2 = r8.hashCode();
    L15:
        return r7 + r2;
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
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

    public final void setHeight(float r1) {
        this.height = r1;
    }

    public final void setLineColor(String r1) {
        this.lineColor = r1;
    }

    public final void setMarginBottom(Float r1) {
        this.marginBottom = r1;
    }

    public final void setMarginTop(Float r1) {
        this.marginTop = r1;
    }

    public ThematicBreakConfig(float r1, String r2, Float r3, Float r4) {
        this.height = r1;
        this.lineColor = r2;
        this.marginTop = r3;
        this.marginBottom = r4;
    }
}
