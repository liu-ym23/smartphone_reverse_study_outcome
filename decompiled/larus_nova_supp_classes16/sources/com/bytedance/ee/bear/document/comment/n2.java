package com.bytedance.ee.bear.document.comment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class n2 implements o2 {
    public final int a;

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof n2) == true) goto L9;
        return false;
    L9:
        if (this.a == ((n2) r4).a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.a;
    }

    public final String toString() {
        return "HeightChangeEvent(height=" + this.a + ')';
    }

    public n2(int r1) {
        this.a = r1;
    }
}
