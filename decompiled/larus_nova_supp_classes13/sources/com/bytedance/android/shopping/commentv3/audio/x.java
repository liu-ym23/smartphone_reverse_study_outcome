package com.bytedance.android.shopping.commentv3.audio;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class x {
    public final boolean a;

    public x() {
        this(true);
    }

    public final boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof x) == true) goto L6;
        return false;
    L6:
        if (this.a == ((x) r2).a) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        boolean r0 = this.a;
        if (r0 == false) goto L6;
        return 1;
    L6:
        return r0 ? 1 : 0;
    }

    public final String toString() {
        return "StopDecision(restoreExternalAudio=" + this.a + ")";
    }

    public x(boolean r1) {
        this.a = r1;
    }
}
