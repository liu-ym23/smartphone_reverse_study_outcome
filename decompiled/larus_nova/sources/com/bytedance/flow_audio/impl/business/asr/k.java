package com.bytedance.flow_audio.impl.business.asr;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Long> f243989a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f243990b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f243991c;

    public final void a() {
        if (this.f243991c > 0) goto L6;
        this.f243991c = this.f243989a.invoke().longValue();
        return;
    }

    public final long b() {
        long r100 = this.f243990b;
        long r101 = this.f243991c;
        if (r101 > 0) goto L6;
        r101 = this.f243989a.invoke().longValue();
    L6:
        boolean r102 = false;
        if (1 <= r100) goto L9;
    L11:
        if (r102 == true) goto L14;
        return 0;
    L14:
        return r101 - r100;
    L9:
        if (r100 >= r101) goto L11;
        r102 = true;
        goto L11
    }

    public k(Function0<Long> r100) {
        Intrinsics.checkNotNullParameter(r100, "clockMs");
        this.f243989a = r100;
    }
}
