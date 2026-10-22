package com.bytedance.kmp.image.options;

/* JADX INFO: loaded from: classes19.dex */
public final class d {
    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L9;
        return false;
    L9:
        ((d) r100).getClass();
        return true;
    }

    public final int hashCode() {
        return 0;
    }

    public final String toString() {
        return "ImageBlurOption(radius=0)";
    }
}
