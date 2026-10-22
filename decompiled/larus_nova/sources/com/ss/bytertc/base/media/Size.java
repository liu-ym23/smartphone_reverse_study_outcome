package com.ss.bytertc.base.media;

import com.byted.cast.common.CastMonitor;

/* JADX INFO: loaded from: classes40.dex */
public class Size {
    public int height;
    public int width;

    public String toString() {
        return this.width + "x" + this.height;
    }

    public int hashCode() {
        return ((this.width * CastMonitor.EVENT_TRACK) + 1) + this.height;
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof Size) == true) goto L5;
        return false;
    L5:
        Size r101 = (Size) r100;
        if (this.width == r101.width) goto L8;
        return false;
    L8:
        if (this.height != r101.height) goto L12;
        return true;
    L12:
        return false;
    }

    public Size(int r100, int r101) {
        this.width = r100;
        this.height = r101;
    }
}
