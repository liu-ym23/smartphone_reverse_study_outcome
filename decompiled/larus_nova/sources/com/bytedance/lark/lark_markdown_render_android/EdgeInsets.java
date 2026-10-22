package com.bytedance.lark.lark_markdown_render_android;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ>\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\u0006\u0010\u001e\u001a\u00020\u001fJ\t\u0010 \u001a\u00020!HÖ\u0001R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\u000f\u0010\t\"\u0004\b\u0010\u0010\u000bR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\u0011\u0010\t\"\u0004\b\u0012\u0010\u000b¨\u0006\""}, d2 = {"Lcom/bytedance/lark/lark_markdown_render_android/EdgeInsets;", "", "top", "", "right", "bottom", "left", "(Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;)V", "getBottom", "()Ljava/lang/Float;", "setBottom", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "getLeft", "setLeft", "getRight", "setRight", "getTop", "setTop", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;)Lcom/bytedance/lark/lark_markdown_render_android/EdgeInsets;", "equals", "", "other", "hashCode", "", "into", "Llark_markdown_render/proto/EdgeInsets;", "toString", "", "lark_markdown_render_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class EdgeInsets {
    private Float bottom;
    private Float left;
    private Float right;
    private Float top;

    public static /* synthetic */ EdgeInsets copy$default(EdgeInsets r100, Float r101, Float r102, Float r103, Float r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.top;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.right;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.bottom;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.left;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final Float component1() {
        return this.top;
    }

    public final Float component2() {
        return this.right;
    }

    public final Float component3() {
        return this.bottom;
    }

    public final Float component4() {
        return this.left;
    }

    public final EdgeInsets copy(Float r100, Float r101, Float r102, Float r103) {
        return new EdgeInsets(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof EdgeInsets) == true) goto L8;
        return false;
    L8:
        EdgeInsets r101 = (EdgeInsets) r100;
        if (Intrinsics.areEqual(this.top, r101.top) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.right, r101.right) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.bottom, r101.bottom) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.left, r101.left) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        Float r100 = this.top;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Float r104 = this.right;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Float r107 = this.bottom;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Float r110 = this.left;
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
        return "EdgeInsets(top=" + this.top + ", right=" + this.right + ", bottom=" + this.bottom + ", left=" + this.left + ')';
    }

    public final lark_markdown_render.proto.EdgeInsets into() {
        return new lark_markdown_render.proto.EdgeInsets(this.top, this.right, this.bottom, this.left);
    }

    public final Float getBottom() {
        return this.bottom;
    }

    public final Float getLeft() {
        return this.left;
    }

    public final Float getRight() {
        return this.right;
    }

    public final Float getTop() {
        return this.top;
    }

    public final void setBottom(Float r100) {
        this.bottom = r100;
    }

    public final void setLeft(Float r100) {
        this.left = r100;
    }

    public final void setRight(Float r100) {
        this.right = r100;
    }

    public final void setTop(Float r100) {
        this.top = r100;
    }

    public EdgeInsets(Float r100, Float r101, Float r102, Float r103) {
        this.top = r100;
        this.right = r101;
        this.bottom = r102;
        this.left = r103;
    }
}
