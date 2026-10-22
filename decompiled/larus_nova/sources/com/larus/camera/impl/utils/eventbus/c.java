package com.larus.camera.impl.utils.eventbus;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.a1;

/* JADX INFO: loaded from: classes26.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MutableSharedFlow<g> f322750a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a1 f322751b = null;

    static {
        MutableSharedFlow<g> r100 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        f322750a = r100;
        f322751b = kotlinx.coroutines.flow.e.a(r100);
    }

    public static void a(CoroutineScope r100, g r101) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        Intrinsics.checkNotNullParameter(r101, "event");
        BuildersKt.launch$default(r100, null, null, new CameraEventBus$post$1(r101, null), 3, null);
    }
}
