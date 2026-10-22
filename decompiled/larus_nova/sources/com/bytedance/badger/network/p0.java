package com.bytedance.badger.network;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicInteger f199134a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a0 f199135b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f199136c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f199137d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function6 f199138e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f199139f;

    public p0(a0 r100, int r101, int r102, Function6 r103, long r104) {
        this.f199135b = r100;
        this.f199136c = r101;
        this.f199137d = r102;
        this.f199138e = r103;
        this.f199139f = r104;
        this.f199134a = new AtomicInteger(r102);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L27:
        return true;
    L5:
        if ((r100 instanceof p0) == false) goto L26;
        p0 r101 = (p0) r100;
        if (Intrinsics.areEqual(this.f199135b, r101.f199135b) == false) goto L26;
        if (this.f199136c != r101.f199136c) goto L11;
        boolean r102 = true;
    L12:
        if (r102 == false) goto L26;
        if (this.f199137d != r101.f199137d) goto L16;
        boolean r103 = true;
    L17:
        if (r103 == false) goto L26;
        if (Intrinsics.areEqual(this.f199138e, r101.f199138e) == false) goto L26;
        if (this.f199139f != r101.f199139f) goto L23;
        boolean r104 = true;
    L24:
        if (r104 == false) goto L26;
    L23:
        r104 = false;
        goto L24
    L16:
        r103 = false;
        goto L17
    L11:
        r102 = false;
    L26:
        return false;
    }

    public final int hashCode() {
        a0 r100 = this.f199135b;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((((r102 * 31) + this.f199136c) * 31) + this.f199137d) * 31;
        Function6 r104 = this.f199138e;
        if (r104 == null) goto L9;
        r101 = r104.hashCode();
    L9:
        int r105 = (r103 + r101) * 31;
        long r106 = this.f199139f;
        return r105 + ((int) (r106 ^ (r106 >>> 32)));
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "DelayedRetryTask(requestBundle=" + this.f199135b + ", immediateRetryCount=" + this.f199136c + ", retryCount=" + this.f199137d + ", callback=" + this.f199138e + ", addedTime=" + this.f199139f + ")";
    }
}
