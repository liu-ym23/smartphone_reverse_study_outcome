package com.bytedance.android.livesdk.lottie;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class i {
    public final boolean a;

    public final boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof i) == true) goto L6;
        return false;
    L6:
        if (this.a == ((i) r2).a) goto L13;
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
        return "FinishLottieAnimationEvent(finish=" + this.a + ")";
    }

    public i() {
        this.a = true;
    }
}
