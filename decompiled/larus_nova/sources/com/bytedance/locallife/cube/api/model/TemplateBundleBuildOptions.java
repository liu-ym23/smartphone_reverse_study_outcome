package com.bytedance.locallife.cube.api.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/bytedance/locallife/cube/api/model/TemplateBundleBuildOptions;", "", "lepusNGVMPoolSize", "", "enableAutoFill", "", "(IZ)V", "getEnableAutoFill", "()Z", "getLepusNGVMPoolSize", "()I", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "", "cube-saas_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class TemplateBundleBuildOptions {
    private final boolean enableAutoFill;
    private final int lepusNGVMPoolSize;

    public static /* synthetic */ TemplateBundleBuildOptions copy$default(TemplateBundleBuildOptions r100, int r101, boolean r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.lepusNGVMPoolSize;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.enableAutoFill;
    L9:
        return r100.copy(r101, r102);
    }

    public final int component1() {
        return this.lepusNGVMPoolSize;
    }

    public final boolean component2() {
        return this.enableAutoFill;
    }

    public final TemplateBundleBuildOptions copy(int r100, boolean r101) {
        return new TemplateBundleBuildOptions(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TemplateBundleBuildOptions) == true) goto L8;
        return false;
    L8:
        TemplateBundleBuildOptions r101 = (TemplateBundleBuildOptions) r100;
        if (this.lepusNGVMPoolSize == r101.lepusNGVMPoolSize) goto L12;
        return false;
    L12:
        if (this.enableAutoFill == r101.enableAutoFill) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r100 = this.lepusNGVMPoolSize * 31;
        if (this.enableAutoFill == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public String toString() {
        return "TemplateBundleBuildOptions(lepusNGVMPoolSize=" + this.lepusNGVMPoolSize + ", enableAutoFill=" + this.enableAutoFill + ')';
    }

    public final boolean getEnableAutoFill() {
        return this.enableAutoFill;
    }

    public final int getLepusNGVMPoolSize() {
        return this.lepusNGVMPoolSize;
    }

    public TemplateBundleBuildOptions(int r100, boolean r101) {
        this.lepusNGVMPoolSize = r100;
        this.enableAutoFill = r101;
    }
}
