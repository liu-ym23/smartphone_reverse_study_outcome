package com.bytedance.android.shopping.deepfeed.viewmodel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public final int a;

    public final boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof a) == true) goto L6;
        return false;
    L6:
        if (this.a == ((a) r2).a) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        return this.a;
    }

    public final String toString() {
        return "DeeFeedEnterDetailStatus(position=" + this.a + ")";
    }

    public a(int r1) {
        this.a = r1;
    }
}
