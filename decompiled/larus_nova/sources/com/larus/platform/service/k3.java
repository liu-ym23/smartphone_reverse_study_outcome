package com.larus.platform.service;

import com.larus.platform.api.a4;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class k3 implements a4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k3 f365757a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f365758b = null;

    public k3() {
    }

    static {
        f365757a = new k3();
        f365758b = LazyKt.lazy(new j3());
    }

    @Override // com.larus.platform.api.a4
    public final boolean isInitialized() {
        a4 r100 = (a4) f365758b.getValue();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isInitialized();
    }

    @Override // com.larus.platform.api.a4
    public final void a(String r100, String r101, Function2<? super String, ? super String, Unit> r102, Function0<Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "contentProducer");
        Intrinsics.checkNotNullParameter(r101, "contentPropagator");
        Intrinsics.checkNotNullParameter(r102, "monitorLogSend");
        Intrinsics.checkNotNullParameter(r103, "onInitFinished");
        a4 r104 = (a4) f365758b.getValue();
        if (r104 != null) goto L6;
        r103.invoke();
        return;
    L6:
        r104.a(r100, r101, r102, r103);
    }
}
