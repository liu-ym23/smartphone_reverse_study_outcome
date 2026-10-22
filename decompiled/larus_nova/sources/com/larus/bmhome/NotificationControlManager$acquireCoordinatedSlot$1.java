package com.larus.bmhome;

import com.larus.utils.t0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class NotificationControlManager$acquireCoordinatedSlot$1 extends FunctionReferenceImpl implements Function0<Unit> {
    public NotificationControlManager$acquireCoordinatedSlot$1(Object r100) {
        super(0, r100, i0.class, "preemptNotification", "preemptNotification()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        i0 r100 = (i0) this.receiver;
        i0 r101 = i0.f311775a;
        monitor-enter(r100);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (i0.f311778d != null) goto L8;
        monitor-exit(r100);
        return;
    L8:
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r100);
        t0.f375468a.post(new d0());
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
