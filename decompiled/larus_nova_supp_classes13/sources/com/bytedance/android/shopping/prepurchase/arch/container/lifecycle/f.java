package com.bytedance.android.shopping.prepurchase.arch.container.lifecycle;

import java.util.concurrent.atomic.AtomicReference;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f {
    public static final CoroutineScope a(Lifecycle r7) {
        Intrinsics.checkNotNullParameter(r7, "$this$coroutineScope");
    L3:
        CoroutineScope r0 = r7.a.get();
        if (r0 != null) goto L5;
        boolean r2 = true;
        c r1 = new c(r7, SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate()));
        AtomicReference<CoroutineScope> r3 = r7.a;
    L8:
        if (r3.compareAndSet(null, r1) == true) goto L13;
        if (r3.get() == null) goto L8;
        r2 = false;
    L13:
        if (r2 == false) goto L3;
        BuildersKt.launch$default(r1, Dispatchers.getMain().getImmediate(), null, new LifecycleCoroutineScopeImpl$register$1(r1, null), 2, null);
        return r1;
    L5:
        return r0;
    }

    public static void b(e r3, Function2 r4) {
        EmptyCoroutineContext r0 = EmptyCoroutineContext.INSTANCE;
        CoroutineStart r1 = CoroutineStart.DEFAULT;
        Intrinsics.checkNotNullParameter(r3, "$this$launch");
        Intrinsics.checkNotNullParameter(r0, "context");
        Intrinsics.checkNotNullParameter(r1, "start");
        Intrinsics.checkNotNullParameter(r4, "block");
        BuildersKt.launch(a(r3.getLifecycle()), r0, r1, r4);
    }
}
