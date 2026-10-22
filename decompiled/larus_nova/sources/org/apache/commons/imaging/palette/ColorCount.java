package org.apache.commons.imaging.palette;

/* JADX INFO: loaded from: classes42.dex */
class ColorCount {
    public final int alpha;
    public final int argb;
    public final int blue;
    public final int green;
    public final int red;

    public int hashCode() {
        return this.argb;
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof ColorCount) == true) goto L5;
        return false;
    L5:
        if (((ColorCount) r100).argb != this.argb) goto L9;
        return true;
    L9:
        return false;
    }
}
