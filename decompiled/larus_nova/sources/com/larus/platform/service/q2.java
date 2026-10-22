package com.larus.platform.service;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class q2 implements com.larus.platform.api.k1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q2 f365792a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f365793b = null;

    public q2() {
    }

    static {
        f365792a = new q2();
        f365793b = LazyKt.lazy(new p2());
    }

    @Override // com.larus.platform.api.k1
    public final boolean a(com.larus.audio.w1 r100) {
        Intrinsics.checkNotNullParameter(r100, "paramBuilder");
        com.larus.platform.api.k1 r101 = (com.larus.platform.api.k1) f365793b.getValue();
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.a(r100);
    }
}
