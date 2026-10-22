package com.bytedance.lark.lark_markdown_render_android;

import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ>\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\u0006\u0010\u001e\u001a\u00020\u001fJ\t\u0010 \u001a\u00020!HÖ\u0001R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\u000f\u0010\t\"\u0004\b\u0010\u0010\u000bR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\u0011\u0010\t\"\u0004\b\u0012\u0010\u000b¨\u0006\""}, d2 = {"Lcom/bytedance/lark/lark_markdown_render_android/EdgeInsets;", "", "top", "", "right", "bottom", CustomHeaderConfig.TitleConfig.Position.LEFT, "(Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;)V", "getBottom", "()Ljava/lang/Float;", "setBottom", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "getLeft", "setLeft", "getRight", "setRight", "getTop", "setTop", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;)Lcom/bytedance/lark/lark_markdown_render_android/EdgeInsets;", "equals", "", "other", "hashCode", "", "into", "Llark_markdown_render/proto/EdgeInsets;", "toString", "", "lark_markdown_render_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class EdgeInsets {
    private Float bottom;
    private Float left;
    private Float right;
    private Float top;

    public static /* synthetic */ EdgeInsets copy$default(EdgeInsets r0, Float r1, Float r2, Float r3, Float r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.top;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.right;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.bottom;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.left;
    L15:
        return r0.copy(r1, r2, r3, r4);
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

    public final EdgeInsets copy(Float r2, Float r3, Float r4, Float r5) {
        return new EdgeInsets(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof EdgeInsets) == true) goto L8;
        return false;
    L8:
        EdgeInsets r6 = (EdgeInsets) r5;
        if (Intrinsics.areEqual(this.top, r6.top) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.right, r6.right) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.bottom, r6.bottom) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.left, r6.left) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        Float r0 = this.top;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Float r4 = this.right;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Float r7 = this.bottom;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Float r10 = this.left;
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

    public final void setBottom(Float r1) {
        this.bottom = r1;
    }

    public final void setLeft(Float r1) {
        this.left = r1;
    }

    public final void setRight(Float r1) {
        this.right = r1;
    }

    public final void setTop(Float r1) {
        this.top = r1;
    }

    public EdgeInsets(Float r1, Float r2, Float r3, Float r4) {
        this.top = r1;
        this.right = r2;
        this.bottom = r3;
        this.left = r4;
    }
}
