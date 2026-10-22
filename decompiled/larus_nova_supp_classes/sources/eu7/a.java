package eu7;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class a {
    public final String a;
    public final long b;
    public final String c;
    public final String d;
    public final Boolean e;
    public final String f;
    public final long g;
    public final String h;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof a) == true) goto L8;
        return false;
    L8:
        a r9 = (a) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r9.f) == true) goto L27;
        return false;
    L27:
        if (this.g == r9.g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r9.h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        long r1 = this.b;
        int r2 = (((((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
        Boolean r3 = this.e;
        if (r3 != null) goto L5;
        int r4 = 0;
    L6:
        int r5 = (((r2 + r4) * 31) + this.f.hashCode()) * 31;
        long r6 = this.g;
        return ((r5 + ((int) (r6 ^ (r6 >>> 32)))) * 31) + this.h.hashCode();
    L5:
        r4 = r3.hashCode();
        goto L6
    }

    public final String toString() {
        return "PerfTracer(info=" + this.a + ", duration=" + this.b + ", threadName=" + this.c + ", appState=" + this.d + ", isCharging=" + this.e + ", screenState=" + this.f + ", appStartTime=" + this.g + ", extra=" + this.h + ')';
    }

    public a(String r2, long r3, String r5, String r6, Boolean r7, String r8, long r9, String r11) {
        Intrinsics.checkNotNullParameter(r2, "info");
        Intrinsics.checkNotNullParameter(r5, "threadName");
        Intrinsics.checkNotNullParameter(r6, "appState");
        Intrinsics.checkNotNullParameter(r8, "screenState");
        Intrinsics.checkNotNullParameter(r11, "extra");
        this.a = r2;
        this.b = r3;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r11;
    }
}
