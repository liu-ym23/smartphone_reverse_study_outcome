package com.bytedance.ee.bear.browser.plugin;

import java.util.Objects;

/* JADX INFO: loaded from: classes16.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f216618a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f216619b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f216620c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f216621d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f216622e;

    public d() {
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.f216618a), Integer.valueOf(this.f216619b), Float.valueOf(this.f216620c)});
    }

    public final String toString() {
        return "DeviceInfo{statusBarHeight=" + this.f216618a + ", titleBarHeight=" + this.f216619b + ", titleBarVisiblePercent=" + this.f216620c + ", titleBarLayoutVisiblePercent=" + this.f216621d + '}';
    }

    public d(d r100) {
        this.f216618a = r100.f216618a;
        this.f216619b = r100.f216619b;
        this.f216620c = r100.f216620c;
        this.f216621d = r100.f216621d;
        this.f216622e = r100.f216622e;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L21:
        return false;
    L8:
        if (d.class != r100.getClass()) goto L21;
        d r101 = (d) r100;
        if (this.f216618a == r101.f216618a) goto L13;
    L19:
        return false;
    L13:
        if (this.f216619b != r101.f216619b) goto L19;
        if (this.f216622e != r101.f216622e) goto L19;
        if (Float.compare(r101.f216620c, this.f216620c) != 0) goto L19;
        return true;
    }
}
