package com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class x {
    public static final /* synthetic */ int d = 0;
    public final int a;
    public final int b;
    public final long c;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof x) == false) goto L12;
        x r6 = (x) r5;
        if (this.a == r6.a) goto L8;
        return false;
    L8:
        if (this.b == r6.b) goto L10;
        return false;
    L10:
        if (this.c == r6.c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        int r0 = ((this.a * 31) + this.b) * 31;
        long r1 = this.c;
        return r0 + ((int) (r1 ^ (r1 >>> 32)));
    }

    public final String toString() {
        return "SinghotInfo(status=" + this.a + ", level=" + this.b + ", hot=" + this.c + ")";
    }

    public x(int r1, int r2, long r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
