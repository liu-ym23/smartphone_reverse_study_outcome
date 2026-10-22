package com.bytedance.android.shopping.prepurchase.arch.exposure;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class Scheduler {
    public CoroutineScope a;
    public Job b;
    public boolean c;
    public boolean d;
    public boolean e;
    public final long f;
    public final i g;

    public final void b() {
        this.d = true;
        if (this.c == false) goto L8;
        CoroutineScope r1 = this.a;
        if (r1 == null) goto L9;
        BuildersKt.launch$default(r1, Dispatchers.getMain().getImmediate(), null, new Scheduler$resume$1(this, null), 2, null);
        return;
    L9:
        return;
    }

    public Scheduler(long r2, ExposureEngine.c r4) {
        Intrinsics.checkNotNullParameter(r4, "scheduler");
        this.f = r2;
        this.g = r4;
    }

    public static final Object a(Scheduler r3, Continuation r4) {
        r3.getClass();
        Object r5 = BuildersKt.withContext(Dispatchers.getMain().getImmediate(), new Scheduler$scheduleOnce$2(r3, null), r4);
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r5;
    L6:
        return Unit.INSTANCE;
    }
}
