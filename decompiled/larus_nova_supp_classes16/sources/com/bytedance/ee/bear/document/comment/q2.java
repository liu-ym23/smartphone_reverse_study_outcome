package com.bytedance.ee.bear.document.comment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class q2 implements o2 {
    public final int a;

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof q2) == true) goto L9;
        return false;
    L9:
        if (this.a == ((q2) r4).a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.a;
    }

    public final String toString() {
        return "InputHeightChangeEvent(height=" + this.a + ')';
    }

    public q2(int r1) {
        this.a = r1;
    }
}
