package com.larus.dora.obric.device_management.setting.earbuds.gesture;

import android.os.Handler;
import androidx.fragment.app.FragmentActivity;
import com.larus.dora.impl.device.settings.gesture.wakeup.GestureWakeupType;
import com.larus.nova.R;
import kotlin.KotlinNothingValueException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.d1;

/* JADX INFO: loaded from: classes27.dex */
public final class DoraObricEarbudsGestureWakeUpFragment$observeState$1$1<T> implements FlowCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DoraObricEarbudsGestureWakeUpFragment f340103a;

    public static final class a<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DoraObricEarbudsGestureWakeUpFragment f340104a;

        public a(DoraObricEarbudsGestureWakeUpFragment r100) {
            this.f340104a = r100;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(Object r100, Continuation r101) {
            com.larus.dora.impl.device.settings.gesture.wakeup.h r102 = (com.larus.dora.impl.device.settings.gesture.wakeup.h) r100;
            if (r102 == null) goto L8;
            GestureWakeupType r103 = r102.getType();
            if (r103 == null) goto L8;
            DoraObricEarbudsGestureWakeUpFragment.W90(this.f340104a, r102.f334536b, r103);
        L8:
            return Unit.INSTANCE;
        }
    }

    public DoraObricEarbudsGestureWakeUpFragment$observeState$1$1(DoraObricEarbudsGestureWakeUpFragment r100) {
        this.f340103a = r100;
    }

    public final Object a(boolean r100, Continuation<? super Unit> r101) {
        if ((r101 instanceof DoraObricEarbudsGestureWakeUpFragment$observeState$1$1$emit$1) == false) goto L7;
        DoraObricEarbudsGestureWakeUpFragment$observeState$1$1$emit$1 r102 = (DoraObricEarbudsGestureWakeUpFragment$observeState$1$1$emit$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L12;
        ResultKt.throwOnFailure(r104);
    L23:
        throw new KotlinNothingValueException();
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        if (r100 == true) goto L25;
        FragmentActivity r107 = this.f340103a.getActivity();
        if (r107 == null) goto L19;
        DoraObricEarbudsGestureWakeUpFragment r108 = this.f340103a;
        Handler r109 = com.obric.oui.toast.f.f403695n;
        com.obric.oui.toast.f.a.a(r107, r108.getString(R.string.larus_dora_toast_update_failed_cn));
    L19:
        DoraObricEarbudsGestureWakeUpFragment r110 = this.f340103a;
        int r111 = DoraObricEarbudsGestureWakeUpFragment.f340091p;
        d1<com.larus.dora.impl.device.settings.gesture.wakeup.h> r112 = r110.Y90().getGestureWakeupStateFlow();
        a r113 = new a(this.f340103a);
        r102.label = 1;
        if (r112.collect(r113, r102) != r105) goto L23;
        return r105;
    L25:
        return Unit.INSTANCE;
    L7:
        r102 = new DoraObricEarbudsGestureWakeUpFragment$observeState$1$1$emit$1(this, r101);
        goto L8
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final /* bridge */ /* synthetic */ Object emit(Object r100, Continuation r101) {
        return a(((Boolean) r100).booleanValue(), r101);
    }
}
