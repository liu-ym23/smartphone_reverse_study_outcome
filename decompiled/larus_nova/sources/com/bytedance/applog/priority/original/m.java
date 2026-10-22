package com.bytedance.applog.priority.original;

import java.security.SecureRandom;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f192763a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t f192764b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f192765c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f192766d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicInteger f192767e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicInteger f192768f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f192769g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f192770h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f192771i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f192772j;

    public final Model$GroupFrequencyAllow a() {
        long r100 = System.currentTimeMillis() / ((long) 1000);
        this.f192770h = r100;
        if (this.f192763a == true) goto L5;
        int r101 = this.f192767e.get();
        boolean r102 = true;
        if (r101 != 0) goto L23;
        if ((r100 - this.f192769g) < 60) goto L19;
        boolean r103 = true;
    L20:
        if (r103 == false) goto L29;
        this.f192768f.set(0);
        this.f192769g = this.f192770h;
    L30:
        boolean r104 = true;
    L32:
        if (r104 == false) goto L34;
        int r105 = this.f192765c;
        if (r105 != 0) goto L38;
    L44:
        if (r102 == true) goto L48;
        return Model$GroupFrequencyAllow.BlockByBackoff;
    L48:
        return Model$GroupFrequencyAllow.Allow;
    L38:
        if (r105 == this.f192771i) goto L44;
        if (new SecureRandom().nextInt(this.f192771i) > this.f192765c) goto L44;
        this.f192768f.incrementAndGet();
        r102 = false;
        goto L44
    L34:
        return Model$GroupFrequencyAllow.BlockByFrequency;
    L29:
        if (this.f192768f.get() < this.f192766d) goto L30;
        r104 = false;
        goto L32
    L19:
        r103 = false;
        goto L20
    L23:
        if ((r100 - this.f192769g) < (((long) 60) * ((long) Math.pow(2.0d, r101)))) goto L25;
        boolean r106 = true;
    L26:
        if (r106 == false) goto L29;
        this.f192768f.set(0);
        this.f192769g = this.f192770h;
        goto L30
    L25:
        r106 = false;
        goto L26
    L5:
        if (this.f192767e.get() <= 0) goto L13;
        long r107 = this.f192770h;
        if ((r107 - this.f192769g) <= 5) goto L11;
        this.f192769g = r107;
        return Model$GroupFrequencyAllow.Allow;
    L11:
        return Model$GroupFrequencyAllow.BlockByFrequency;
    L13:
        return Model$GroupFrequencyAllow.Allow;
    }

    public m(boolean r100, t r101, int r102, int r103, AtomicInteger r104, AtomicInteger r105) {
        Intrinsics.checkNotNullParameter(r101, "version");
        Intrinsics.checkNotNullParameter(r104, "level");
        Intrinsics.checkNotNullParameter(r105, "levelSuccessCnt");
        this.f192763a = r100;
        this.f192764b = r101;
        this.f192765c = r102;
        this.f192766d = r103;
        this.f192767e = r104;
        this.f192768f = r105;
        this.f192769g = 0;
        this.f192770h = 0;
        this.f192771i = 10000;
        this.f192772j = 5;
    }
}
