package com.bytedance.lark.lark_markdown_render_android;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003JQ\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\u0006\u0010$\u001a\u00020%J\t\u0010&\u001a\u00020'HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\rR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\r¨\u0006("}, d2 = {"Lcom/bytedance/lark/lark_markdown_render_android/HeadingConfig;", "", "h1", "Lcom/bytedance/lark/lark_markdown_render_android/HeadingLevelConfig;", "h2", "h3", "h4", "h5", "h6", "(Lcom/bytedance/lark/lark_markdown_render_android/HeadingLevelConfig;Lcom/bytedance/lark/lark_markdown_render_android/HeadingLevelConfig;Lcom/bytedance/lark/lark_markdown_render_android/HeadingLevelConfig;Lcom/bytedance/lark/lark_markdown_render_android/HeadingLevelConfig;Lcom/bytedance/lark/lark_markdown_render_android/HeadingLevelConfig;Lcom/bytedance/lark/lark_markdown_render_android/HeadingLevelConfig;)V", "getH1", "()Lcom/bytedance/lark/lark_markdown_render_android/HeadingLevelConfig;", "setH1", "(Lcom/bytedance/lark/lark_markdown_render_android/HeadingLevelConfig;)V", "getH2", "setH2", "getH3", "setH3", "getH4", "setH4", "getH5", "setH5", "getH6", "setH6", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "into", "Llark_markdown_render/proto/HeadingConfig;", "toString", "", "lark_markdown_render_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class HeadingConfig {
    private HeadingLevelConfig h1;
    private HeadingLevelConfig h2;
    private HeadingLevelConfig h3;
    private HeadingLevelConfig h4;
    private HeadingLevelConfig h5;
    private HeadingLevelConfig h6;

    public static /* synthetic */ HeadingConfig copy$default(HeadingConfig r4, HeadingLevelConfig r5, HeadingLevelConfig r6, HeadingLevelConfig r7, HeadingLevelConfig r8, HeadingLevelConfig r9, HeadingLevelConfig r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.h1;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.h2;
    L8:
        HeadingLevelConfig r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.h3;
    L11:
        HeadingLevelConfig r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.h4;
    L14:
        HeadingLevelConfig r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.h5;
    L17:
        HeadingLevelConfig r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.h6;
    L20:
        HeadingLevelConfig r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final HeadingLevelConfig component1() {
        return this.h1;
    }

    public final HeadingLevelConfig component2() {
        return this.h2;
    }

    public final HeadingLevelConfig component3() {
        return this.h3;
    }

    public final HeadingLevelConfig component4() {
        return this.h4;
    }

    public final HeadingLevelConfig component5() {
        return this.h5;
    }

    public final HeadingLevelConfig component6() {
        return this.h6;
    }

    public final HeadingConfig copy(HeadingLevelConfig r9, HeadingLevelConfig r10, HeadingLevelConfig r11, HeadingLevelConfig r12, HeadingLevelConfig r13, HeadingLevelConfig r14) {
        return new HeadingConfig(r9, r10, r11, r12, r13, r14);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof HeadingConfig) == true) goto L8;
        return false;
    L8:
        HeadingConfig r6 = (HeadingConfig) r5;
        if (Intrinsics.areEqual(this.h1, r6.h1) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.h2, r6.h2) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.h3, r6.h3) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.h4, r6.h4) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.h5, r6.h5) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.h6, r6.h6) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        HeadingLevelConfig r0 = this.h1;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        HeadingLevelConfig r4 = this.h2;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        HeadingLevelConfig r7 = this.h3;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        HeadingLevelConfig r10 = this.h4;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        HeadingLevelConfig r13 = this.h5;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r16 = (r12 + r14) * 31;
        HeadingLevelConfig r17 = this.h6;
        if (r17 == null) goto L27;
        r1 = r17.hashCode();
    L27:
        return r16 + r1;
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
        return "HeadingConfig(h1=" + this.h1 + ", h2=" + this.h2 + ", h3=" + this.h3 + ", h4=" + this.h4 + ", h5=" + this.h5 + ", h6=" + this.h6 + ')';
    }

    public final lark_markdown_render.proto.HeadingConfig into() {
        HeadingLevelConfig r0 = this.h1;
        lark_markdown_render.proto.HeadingLevelConfig r1 = null;
        if (r0 == null) goto L5;
        lark_markdown_render.proto.HeadingLevelConfig r3 = r0.into();
    L6:
        HeadingLevelConfig r2 = this.h2;
        if (r2 == null) goto L9;
        lark_markdown_render.proto.HeadingLevelConfig r4 = r2.into();
    L10:
        HeadingLevelConfig r5 = this.h3;
        if (r5 == null) goto L13;
        lark_markdown_render.proto.HeadingLevelConfig r6 = r5.into();
    L14:
        HeadingLevelConfig r7 = this.h4;
        if (r7 == null) goto L17;
        lark_markdown_render.proto.HeadingLevelConfig r8 = r7.into();
    L18:
        HeadingLevelConfig r9 = this.h5;
        if (r9 == null) goto L21;
        lark_markdown_render.proto.HeadingLevelConfig r10 = r9.into();
    L22:
        HeadingLevelConfig r11 = this.h6;
        if (r11 == null) goto L26;
        r1 = r11.into();
    L26:
        return new lark_markdown_render.proto.HeadingConfig(r3, r4, r6, r8, r10, r1);
    L21:
        r10 = null;
        goto L22
    L17:
        r8 = null;
        goto L18
    L13:
        r6 = null;
        goto L14
    L9:
        r4 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    public final HeadingLevelConfig getH1() {
        return this.h1;
    }

    public final HeadingLevelConfig getH2() {
        return this.h2;
    }

    public final HeadingLevelConfig getH3() {
        return this.h3;
    }

    public final HeadingLevelConfig getH4() {
        return this.h4;
    }

    public final HeadingLevelConfig getH5() {
        return this.h5;
    }

    public final HeadingLevelConfig getH6() {
        return this.h6;
    }

    public final void setH1(HeadingLevelConfig r1) {
        this.h1 = r1;
    }

    public final void setH2(HeadingLevelConfig r1) {
        this.h2 = r1;
    }

    public final void setH3(HeadingLevelConfig r1) {
        this.h3 = r1;
    }

    public final void setH4(HeadingLevelConfig r1) {
        this.h4 = r1;
    }

    public final void setH5(HeadingLevelConfig r1) {
        this.h5 = r1;
    }

    public final void setH6(HeadingLevelConfig r1) {
        this.h6 = r1;
    }

    public HeadingConfig(HeadingLevelConfig r1, HeadingLevelConfig r2, HeadingLevelConfig r3, HeadingLevelConfig r4, HeadingLevelConfig r5, HeadingLevelConfig r6) {
        this.h1 = r1;
        this.h2 = r2;
        this.h3 = r3;
        this.h4 = r4;
        this.h5 = r5;
        this.h6 = r6;
    }
}
