package com.bytedance.kmp.image.options;

/* JADX INFO: loaded from: classes19.dex */
public final class b implements k {
    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L9;
        return false;
    L9:
        ((b) r100).getClass();
        return true;
    }

    @Override // com.bytedance.kmp.image.options.k
    public int getType() {
        return 4;
    }

    public final int hashCode() {
        return (int) 0;
    }

    public final String toString() {
        return "ColorSource(color=0)";
    }
}
