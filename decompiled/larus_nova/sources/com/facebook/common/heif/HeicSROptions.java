package com.facebook.common.heif;

import com.facebook.common.util.HashCodeUtil;

/* JADX INFO: loaded from: classes22.dex */
public class HeicSROptions {
    int chooseAlg;
    public boolean isAdaptiveSr;
    int optimizeLevel;
    public int scaleType;
    public int targetHeight;
    public int targetWidth;
    boolean useOpenGL;

    public String toString() {
        return String.format(null, "%b,%d,%dx%d", new Object[]{Boolean.valueOf(this.isAdaptiveSr), Integer.valueOf(this.scaleType), Integer.valueOf(this.targetWidth), Integer.valueOf(this.targetHeight)});
    }

    public int hashCode() {
        return HashCodeUtil.hashCode(this.targetWidth, this.targetHeight, this.scaleType);
    }

    public HeicSROptions(int r100) {
        this(SRMonitorUtil.isUseOpenGL(), SRMonitorUtil.getOptimizeLevel(), false, r100, -1, -1);
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof HeicSROptions) == true) goto L8;
        return false;
    L8:
        HeicSROptions r101 = (HeicSROptions) r100;
        if (this.targetWidth == r101.targetWidth) goto L11;
    L15:
        return false;
    L11:
        if (this.targetHeight != r101.targetHeight) goto L15;
        if (this.scaleType != r101.scaleType) goto L15;
        return true;
    }

    public HeicSROptions(int r100, int r101) {
        this(SRMonitorUtil.isUseOpenGL(), SRMonitorUtil.getOptimizeLevel(), true, 32768, r100, r101);
    }

    public HeicSROptions(boolean r100, int r101) {
        this(SRMonitorUtil.isUseOpenGL(), SRMonitorUtil.getOptimizeLevel(), r100, r101, -1, -1);
    }

    public HeicSROptions(boolean r100, int r101, int r110, int r111) {
        this(SRMonitorUtil.isUseOpenGL(), SRMonitorUtil.getOptimizeLevel(), r100, r101, r110, r111);
    }

    public HeicSROptions(boolean r100, int r101, boolean r102, int r103, int r104, int r105) {
        this.useOpenGL = r100;
        this.optimizeLevel = r101;
        this.isAdaptiveSr = r102;
        this.scaleType = r103;
        this.targetWidth = r104;
        this.targetHeight = r105;
    }
}
