package com.larus.platform.service;

import com.lynx.lottieadapter.LottieAdapterView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class n1 implements com.larus.platform.api.s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n1 f365777a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f365778b = null;

    public n1() {
    }

    static {
        f365777a = new n1();
        f365778b = LazyKt.lazy(new m1());
    }

    @Override // com.larus.platform.api.s0
    public final void a(LottieAdapterView r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        com.larus.platform.api.s0 r101 = (com.larus.platform.api.s0) f365778b.getValue();
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }
}
