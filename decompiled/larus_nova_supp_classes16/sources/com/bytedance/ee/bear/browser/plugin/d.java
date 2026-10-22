package com.bytedance.ee.bear.browser.plugin;

import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d {
    public int a;
    public int b;
    public float c;
    public float d;
    public boolean e;

    public d() {
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.a), Integer.valueOf(this.b), Float.valueOf(this.c)});
    }

    public final String toString() {
        return "DeviceInfo{statusBarHeight=" + this.a + ", titleBarHeight=" + this.b + ", titleBarVisiblePercent=" + this.c + ", titleBarLayoutVisiblePercent=" + this.d + '}';
    }

    public d(d r2) {
        this.a = r2.a;
        this.b = r2.b;
        this.c = r2.c;
        this.d = r2.d;
        this.e = r2.e;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L21:
        return false;
    L8:
        if (d.class != r5.getClass()) goto L21;
        d r6 = (d) r5;
        if (this.a == r6.a) goto L13;
    L19:
        return false;
    L13:
        if (this.b != r6.b) goto L19;
        if (this.e != r6.e) goto L19;
        if (Float.compare(r6.c, this.c) != 0) goto L19;
        return true;
    }
}
