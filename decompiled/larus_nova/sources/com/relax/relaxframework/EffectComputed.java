package com.relax.relaxframework;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class EffectComputed extends k0<Integer> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static long f404709j;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f404710h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public t0 f404711i;

    public static final class a {
    }

    static {
    }

    public EffectComputed(final t0 r100) {
        Intrinsics.checkNotNullParameter(r100, "effect");
        super(new AnonymousClass1(r100));
        long r101 = f404709j;
        f404709j = 1 + r101;
        this.f404710h = r101;
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f404711i = r100;
    }
}
