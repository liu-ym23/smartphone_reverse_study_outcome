package com.bytedance.lark.lark_markdown_render_android;

import kotlin.Metadata;
import kotlin.UInt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0007HÆ\u0003J\u0016\u0010#\u001a\u00020\tHÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b$\u0010\rJ\u0016\u0010%\u001a\u00020\tHÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b&\u0010\rJO\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tHÆ\u0001ø\u0001\u0000¢\u0006\u0004\b(\u0010)J\u0013\u0010*\u001a\u00020\u00072\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020-HÖ\u0001J\u0006\u0010.\u001a\u00020/J\t\u00100\u001a\u000201HÖ\u0001R\"\u0010\n\u001a\u00020\tX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\b\u001a\u00020\tX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0019\u0010\r\"\u0004\b\u001a\u0010\u000fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00062"}, d2 = {"Lcom/bytedance/lark/lark_markdown_render_android/FfiCaret;", "", "x", "", "y", "height", "direction", "", "uuid", "Lkotlin/UInt;", "canvasId", "(FFFZIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getCanvasId-pVg5ArA", "()I", "setCanvasId-WZ4Q5Ns", "(I)V", "I", "getDirection", "()Z", "setDirection", "(Z)V", "getHeight", "()F", "setHeight", "(F)V", "getUuid-pVg5ArA", "setUuid-WZ4Q5Ns", "getX", "setX", "getY", "setY", "component1", "component2", "component3", "component4", "component5", "component5-pVg5ArA", "component6", "component6-pVg5ArA", "copy", "copy-rhtGY3M", "(FFFZII)Lcom/bytedance/lark/lark_markdown_render_android/FfiCaret;", "equals", "other", "hashCode", "", "into", "Llark_markdown_render/proto/FfiCaret;", "toString", "", "lark_markdown_render_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FfiCaret {
    private int canvasId;
    private boolean direction;
    private float height;
    private int uuid;
    private float x;
    private float y;

    public /* synthetic */ FfiCaret(float r1, float r2, float r3, boolean r4, int r5, int r6, DefaultConstructorMarker r7) {
        this(r1, r2, r3, r4, r5, r6);
    }

    /* JADX INFO: renamed from: copy-rhtGY3M$default, reason: not valid java name */
    public static /* synthetic */ FfiCaret m454copyrhtGY3M$default(FfiCaret r4, float r5, float r6, float r7, boolean r8, int r9, int r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.x;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.y;
    L8:
        float r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.height;
    L11:
        float r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.direction;
    L14:
        boolean r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.uuid;
    L17:
        int r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.canvasId;
    L20:
        float r14 = r5;
        return r4.m457copyrhtGY3M(r14, r13, r0, r1, r2, r10);
    }

    public final float component1() {
        return this.x;
    }

    public final float component2() {
        return this.y;
    }

    public final float component3() {
        return this.height;
    }

    public final boolean component4() {
        return this.direction;
    }

    /* JADX INFO: renamed from: component5-pVg5ArA, reason: not valid java name */
    public final int m455component5pVg5ArA() {
        return this.uuid;
    }

    /* JADX INFO: renamed from: component6-pVg5ArA, reason: not valid java name */
    public final int m456component6pVg5ArA() {
        return this.canvasId;
    }

    /* JADX INFO: renamed from: copy-rhtGY3M, reason: not valid java name */
    public final FfiCaret m457copyrhtGY3M(float r10, float r11, float r12, boolean r13, int r14, int r16) {
        return new FfiCaret(r10, r11, r12, r13, r14, r16, null);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof FfiCaret) == true) goto L8;
        return false;
    L8:
        FfiCaret r6 = (FfiCaret) r5;
        if (Float.compare(this.x, r6.x) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.y, r6.y) == 0) goto L15;
        return false;
    L15:
        if (Float.compare(this.height, r6.height) == 0) goto L18;
        return false;
    L18:
        if (this.direction == r6.direction) goto L21;
        return false;
    L21:
        if (this.uuid == r6.uuid) goto L24;
        return false;
    L24:
        if (this.canvasId == r6.canvasId) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r0 = ((((Float.floatToIntBits(this.x) * 31) + Float.floatToIntBits(this.y)) * 31) + Float.floatToIntBits(this.height)) * 31;
        if (this.direction == false) goto L5;
        int r1 = 1231;
    L7:
        return ((((r0 + r1) * 31) + UInt.hashCode-impl(this.uuid)) * 31) + UInt.hashCode-impl(this.canvasId);
    L5:
        r1 = 1237;
        goto L7
    }

    public String toString() {
        return "FfiCaret(x=" + this.x + ", y=" + this.y + ", height=" + this.height + ", direction=" + this.direction + ", uuid=" + UInt.toString-impl(this.uuid) + ", canvasId=" + UInt.toString-impl(this.canvasId) + ')';
    }

    public final lark_markdown_render.proto.FfiCaret into() {
        return new lark_markdown_render.proto.FfiCaret(Float.valueOf(this.x), Float.valueOf(this.y), Float.valueOf(this.height), Boolean.valueOf(this.direction), Integer.valueOf(this.uuid), Integer.valueOf(this.canvasId));
    }

    /* JADX INFO: renamed from: getCanvasId-pVg5ArA, reason: not valid java name */
    public final int m458getCanvasIdpVg5ArA() {
        return this.canvasId;
    }

    public final boolean getDirection() {
        return this.direction;
    }

    public final float getHeight() {
        return this.height;
    }

    /* JADX INFO: renamed from: getUuid-pVg5ArA, reason: not valid java name */
    public final int m459getUuidpVg5ArA() {
        return this.uuid;
    }

    public final float getX() {
        return this.x;
    }

    public final float getY() {
        return this.y;
    }

    /* JADX INFO: renamed from: setCanvasId-WZ4Q5Ns, reason: not valid java name */
    public final void m460setCanvasIdWZ4Q5Ns(int r1) {
        this.canvasId = r1;
    }

    public final void setDirection(boolean r1) {
        this.direction = r1;
    }

    public final void setHeight(float r1) {
        this.height = r1;
    }

    /* JADX INFO: renamed from: setUuid-WZ4Q5Ns, reason: not valid java name */
    public final void m461setUuidWZ4Q5Ns(int r1) {
        this.uuid = r1;
    }

    public final void setX(float r1) {
        this.x = r1;
    }

    public final void setY(float r1) {
        this.y = r1;
    }

    private FfiCaret(float r1, float r2, float r3, boolean r4, int r5, int r6) {
        this.x = r1;
        this.y = r2;
        this.height = r3;
        this.direction = r4;
        this.uuid = r5;
        this.canvasId = r6;
    }
}
