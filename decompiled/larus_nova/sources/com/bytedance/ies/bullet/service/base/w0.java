package com.bytedance.ies.bullet.service.base;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class w0 extends t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f247925a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f247926b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f247927c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof w0) == true) goto L8;
        return false;
    L8:
        w0 r101 = (w0) r100;
        if (Intrinsics.areEqual(this.f247925a, r101.f247925a) == true) goto L12;
        return false;
    L12:
        if (this.f247926b == r101.f247926b) goto L15;
        return false;
    L15:
        if (this.f247927c == r101.f247927c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f247925a.hashCode() * 31) + this.f247926b) * 31;
        if (this.f247927c == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "PreloadGeckoChannelConfig(channel=" + this.f247925a + ", priority=" + this.f247926b + ", serial=" + this.f247927c + ')';
    }

    public w0(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "channel");
        this.f247925a = r100;
        this.f247926b = r101;
        this.f247927c = false;
    }
}
