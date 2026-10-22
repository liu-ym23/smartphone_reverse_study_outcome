package com.bytedance.badger.v;

import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f199356a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TimeUnit f199357b;

    public w(long r100, TimeUnit r101) {
        this.f199356a = r100;
        this.f199357b = r101;
    }

    public final long a() {
        return this.f199357b.toMillis(this.f199356a);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L15:
        return true;
    L5:
        if ((r100 instanceof w) == false) goto L14;
        w r101 = (w) r100;
        if (this.f199356a != r101.f199356a) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L14;
        if (Intrinsics.areEqual(this.f199357b, r101.f199357b) == false) goto L14;
    L9:
        r102 = false;
    L14:
        return false;
    }

    public final int hashCode() {
        long r100 = this.f199356a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        TimeUnit r102 = this.f199357b;
        if (r102 == null) goto L5;
        int r103 = r102.hashCode();
    L7:
        return r101 + r103;
    L5:
        r103 = 0;
        goto L7
    }

    public final String toString() {
        return "SimpleDuration(value=" + this.f199356a + ", unit=" + this.f199357b + ")";
    }
}
