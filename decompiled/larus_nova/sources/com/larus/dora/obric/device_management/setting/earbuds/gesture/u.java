package com.larus.dora.obric.device_management.setting.earbuds.gesture;

import com.larus.dora.impl.device.settings.gesture.wakeup.GestureWakeupType;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes27.dex */
public final class u<T> implements FlowCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DoraObricEarbudsGestureWakeUpFragment f340138a;

    public u(DoraObricEarbudsGestureWakeUpFragment r100) {
        this.f340138a = r100;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object r100, Continuation r101) {
        com.larus.dora.impl.device.settings.gesture.wakeup.h r102 = (com.larus.dora.impl.device.settings.gesture.wakeup.h) r100;
        if (r102 == null) goto L8;
        GestureWakeupType r103 = r102.getType();
        if (r103 == null) goto L8;
        DoraObricEarbudsGestureWakeUpFragment.W90(this.f340138a, r102.f334536b, r103);
    L8:
        return Unit.INSTANCE;
    }
}
