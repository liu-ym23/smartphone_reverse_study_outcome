package com.larus.dora.impl.device.settings.gesture.wakeup;

import android.app.Application;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import kotlin.KotlinNothingValueException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.d1;
import t19.s;

/* JADX INFO: loaded from: classes27.dex */
public final class GestureWakeupFragment$onViewCreated$1$1<T> implements FlowCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GestureWakeupFragment f334503a;

    public static final class a<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GestureWakeupFragment f334504a;

        public a(GestureWakeupFragment r100) {
            this.f334504a = r100;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(Object r100, Continuation r101) {
            h r102 = (h) r100;
            if (r102 == null) goto L8;
            GestureWakeupType r103 = r102.getType();
            if (r103 == null) goto L8;
            GestureWakeupFragment.W90(this.f334504a, r102.f334536b, r103);
        L8:
            return Unit.INSTANCE;
        }
    }

    public GestureWakeupFragment$onViewCreated$1$1(GestureWakeupFragment r100) {
        this.f334503a = r100;
    }

    public final Object a(boolean r100, Continuation<? super Unit> r101) {
        if ((r101 instanceof GestureWakeupFragment$onViewCreated$1$1$emit$1) == false) goto L7;
        GestureWakeupFragment$onViewCreated$1$1$emit$1 r102 = (GestureWakeupFragment$onViewCreated$1$1$emit$1) r101;
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
    L20:
        throw new KotlinNothingValueException();
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        if (r100 == true) goto L22;
        s r107 = s.f544207a;
        Application r108 = AppHost.f326268a.getApplication();
        r107.getClass();
        s.b(r108, R.string.larus_dora_toast_update_failed_cn, false);
        GestureWakeupFragment r109 = this.f334503a;
        int r110 = GestureWakeupFragment.f334496i;
        d1<h> r111 = r109.X90().getGestureWakeupStateFlow();
        a r112 = new a(this.f334503a);
        r102.label = 1;
        if (r111.collect(r112, r102) != r105) goto L20;
        return r105;
    L22:
        return Unit.INSTANCE;
    L7:
        r102 = new GestureWakeupFragment$onViewCreated$1$1$emit$1(this, r101);
        goto L8
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final /* bridge */ /* synthetic */ Object emit(Object r100, Continuation r101) {
        return a(((Boolean) r100).booleanValue(), r101);
    }
}
