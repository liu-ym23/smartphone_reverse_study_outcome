package com.bytedance.lark.lark_markdown_render_android;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003JQ\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\u0006\u0010$\u001a\u00020%J\t\u0010&\u001a\u00020'HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\rR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\r¨\u0006("}, d2 = {"Lcom/bytedance/lark/lark_markdown_render_android/HeadingConfig;", "", "h1", "Lcom/bytedance/lark/lark_markdown_render_android/HeadingLevelConfig;", "h2", "h3", "h4", "h5", "h6", "(Lcom/bytedance/lark/lark_markdown_render_android/HeadingLevelConfig;Lcom/bytedance/lark/lark_markdown_render_android/HeadingLevelConfig;Lcom/bytedance/lark/lark_markdown_render_android/HeadingLevelConfig;Lcom/bytedance/lark/lark_markdown_render_android/HeadingLevelConfig;Lcom/bytedance/lark/lark_markdown_render_android/HeadingLevelConfig;Lcom/bytedance/lark/lark_markdown_render_android/HeadingLevelConfig;)V", "getH1", "()Lcom/bytedance/lark/lark_markdown_render_android/HeadingLevelConfig;", "setH1", "(Lcom/bytedance/lark/lark_markdown_render_android/HeadingLevelConfig;)V", "getH2", "setH2", "getH3", "setH3", "getH4", "setH4", "getH5", "setH5", "getH6", "setH6", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "into", "Llark_markdown_render/proto/HeadingConfig;", "toString", "", "lark_markdown_render_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class HeadingConfig {

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    private HeadingLevelConfig f253235h1;

    /* JADX INFO: renamed from: h2, reason: collision with root package name */
    private HeadingLevelConfig f253236h2;

    /* JADX INFO: renamed from: h3, reason: collision with root package name */
    private HeadingLevelConfig f253237h3;

    /* JADX INFO: renamed from: h4, reason: collision with root package name */
    private HeadingLevelConfig f253238h4;

    /* JADX INFO: renamed from: h5, reason: collision with root package name */
    private HeadingLevelConfig f253239h5;

    /* JADX INFO: renamed from: h6, reason: collision with root package name */
    private HeadingLevelConfig f253240h6;

    public static /* synthetic */ HeadingConfig copy$default(HeadingConfig r100, HeadingLevelConfig r101, HeadingLevelConfig r102, HeadingLevelConfig r103, HeadingLevelConfig r104, HeadingLevelConfig r105, HeadingLevelConfig r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.f253235h1;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.f253236h2;
    L8:
        HeadingLevelConfig r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.f253237h3;
    L11:
        HeadingLevelConfig r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.f253238h4;
    L14:
        HeadingLevelConfig r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.f253239h5;
    L17:
        HeadingLevelConfig r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.f253240h6;
    L20:
        HeadingLevelConfig r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final HeadingLevelConfig component1() {
        return this.f253235h1;
    }

    public final HeadingLevelConfig component2() {
        return this.f253236h2;
    }

    public final HeadingLevelConfig component3() {
        return this.f253237h3;
    }

    public final HeadingLevelConfig component4() {
        return this.f253238h4;
    }

    public final HeadingLevelConfig component5() {
        return this.f253239h5;
    }

    public final HeadingLevelConfig component6() {
        return this.f253240h6;
    }

    public final HeadingConfig copy(HeadingLevelConfig r100, HeadingLevelConfig r110, HeadingLevelConfig r111, HeadingLevelConfig r112, HeadingLevelConfig r113, HeadingLevelConfig r114) {
        return new HeadingConfig(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof HeadingConfig) == true) goto L8;
        return false;
    L8:
        HeadingConfig r101 = (HeadingConfig) r100;
        if (Intrinsics.areEqual(this.f253235h1, r101.f253235h1) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f253236h2, r101.f253236h2) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f253237h3, r101.f253237h3) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f253238h4, r101.f253238h4) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f253239h5, r101.f253239h5) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f253240h6, r101.f253240h6) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        HeadingLevelConfig r100 = this.f253235h1;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        HeadingLevelConfig r104 = this.f253236h2;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        HeadingLevelConfig r107 = this.f253237h3;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        HeadingLevelConfig r110 = this.f253238h4;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        HeadingLevelConfig r113 = this.f253239h5;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        HeadingLevelConfig r116 = this.f253240h6;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return r115 + r101;
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
        return "HeadingConfig(h1=" + this.f253235h1 + ", h2=" + this.f253236h2 + ", h3=" + this.f253237h3 + ", h4=" + this.f253238h4 + ", h5=" + this.f253239h5 + ", h6=" + this.f253240h6 + ')';
    }

    public final lark_markdown_render.proto.HeadingConfig into() {
        HeadingLevelConfig r100 = this.f253235h1;
        lark_markdown_render.proto.HeadingLevelConfig r101 = null;
        if (r100 == null) goto L5;
        lark_markdown_render.proto.HeadingLevelConfig r102 = r100.into();
    L6:
        HeadingLevelConfig r103 = this.f253236h2;
        if (r103 == null) goto L9;
        lark_markdown_render.proto.HeadingLevelConfig r104 = r103.into();
    L10:
        HeadingLevelConfig r105 = this.f253237h3;
        if (r105 == null) goto L13;
        lark_markdown_render.proto.HeadingLevelConfig r106 = r105.into();
    L14:
        HeadingLevelConfig r107 = this.f253238h4;
        if (r107 == null) goto L17;
        lark_markdown_render.proto.HeadingLevelConfig r108 = r107.into();
    L18:
        HeadingLevelConfig r109 = this.f253239h5;
        if (r109 == null) goto L21;
        lark_markdown_render.proto.HeadingLevelConfig r110 = r109.into();
    L22:
        HeadingLevelConfig r111 = this.f253240h6;
        if (r111 == null) goto L26;
        r101 = r111.into();
    L26:
        return new lark_markdown_render.proto.HeadingConfig(r102, r104, r106, r108, r110, r101);
    L21:
        r110 = null;
        goto L22
    L17:
        r108 = null;
        goto L18
    L13:
        r106 = null;
        goto L14
    L9:
        r104 = null;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    public final HeadingLevelConfig getH1() {
        return this.f253235h1;
    }

    public final HeadingLevelConfig getH2() {
        return this.f253236h2;
    }

    public final HeadingLevelConfig getH3() {
        return this.f253237h3;
    }

    public final HeadingLevelConfig getH4() {
        return this.f253238h4;
    }

    public final HeadingLevelConfig getH5() {
        return this.f253239h5;
    }

    public final HeadingLevelConfig getH6() {
        return this.f253240h6;
    }

    public final void setH1(HeadingLevelConfig r100) {
        this.f253235h1 = r100;
    }

    public final void setH2(HeadingLevelConfig r100) {
        this.f253236h2 = r100;
    }

    public final void setH3(HeadingLevelConfig r100) {
        this.f253237h3 = r100;
    }

    public final void setH4(HeadingLevelConfig r100) {
        this.f253238h4 = r100;
    }

    public final void setH5(HeadingLevelConfig r100) {
        this.f253239h5 = r100;
    }

    public final void setH6(HeadingLevelConfig r100) {
        this.f253240h6 = r100;
    }

    public HeadingConfig(HeadingLevelConfig r100, HeadingLevelConfig r101, HeadingLevelConfig r102, HeadingLevelConfig r103, HeadingLevelConfig r104, HeadingLevelConfig r105) {
        this.f253235h1 = r100;
        this.f253236h2 = r101;
        this.f253237h3 = r102;
        this.f253238h4 = r103;
        this.f253239h5 = r104;
        this.f253240h6 = r105;
    }
}
