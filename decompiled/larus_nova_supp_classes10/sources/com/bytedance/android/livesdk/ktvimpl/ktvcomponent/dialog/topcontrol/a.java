package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.topcontrol;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a {
    public final int a;
    public final int b;

    public a() {
        this(0);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof a) == false) goto L10;
        a r4 = (a) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        return (this.a * 31) + this.b;
    }

    public final String toString() {
        return "PauseResumeIcons(pauseIcon=" + this.a + ", resumeIcon=" + this.b + ")";
    }

    public /* synthetic */ a(int r2) {
        this(2131252056, 2131252057);
    }

    public a(int r1, int r2) {
        this.a = r1;
        this.b = r2;
    }
}
