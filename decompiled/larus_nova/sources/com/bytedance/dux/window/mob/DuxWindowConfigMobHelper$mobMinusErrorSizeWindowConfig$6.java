package com.bytedance.dux.window.mob;

import em4.d;
import em4.f;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.bytedance.dux.window.mob.DuxWindowConfigMobHelper$mobMinusErrorSizeWindowConfig$6", f = "DuxWindowConfigMobHelper.kt", i = {}, l = {72}, m = "invokeSuspend", n = {}, s = {})
final class DuxWindowConfigMobHelper$mobMinusErrorSizeWindowConfig$6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Map<String, String> $param;
    int label;

    public DuxWindowConfigMobHelper$mobMinusErrorSizeWindowConfig$6(Map<String, String> r100, Continuation<? super DuxWindowConfigMobHelper$mobMinusErrorSizeWindowConfig$6> r101) {
        this.$param = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new DuxWindowConfigMobHelper$mobMinusErrorSizeWindowConfig$6(this.$param, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((DuxWindowConfigMobHelper$mobMinusErrorSizeWindowConfig$6) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L11:
        int r103 = f.f473062a;
        Map<String, String> r104 = this.$param;
        Intrinsics.checkNotNullParameter("minus_error_window_size", "eventName");
        Intrinsics.checkNotNullParameter(r104, "params");
        int r105 = d.f473061a;
        d.b("DuxWindowConfigMobHelper", "set windowConfigSize error: " + this.$param);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        this.label = 1;
        if (DelayKt.delay(2000, this) != r101) goto L11;
        return r101;
    }
}
