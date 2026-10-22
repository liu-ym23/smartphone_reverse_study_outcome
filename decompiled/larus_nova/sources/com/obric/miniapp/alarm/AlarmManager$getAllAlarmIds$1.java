package com.obric.miniapp.alarm;

import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.miniapp.alarm.AlarmManager$getAllAlarmIds$1", f = "AlarmManager.kt", i = {}, l = {TTVideoEngineInterface.PLAYER_OPTION_AE_LU_RANG}, m = "invokeSuspend", n = {}, s = {})
final class AlarmManager$getAllAlarmIds$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<List<String>, Unit> $onResult;
    Object L$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public AlarmManager$getAllAlarmIds$1(Function1<? super List<String>, Unit> r100, Continuation<? super AlarmManager$getAllAlarmIds$1> r101) {
        this.$onResult = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new AlarmManager$getAllAlarmIds$1(this.$onResult, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((AlarmManager$getAllAlarmIds$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        Function1 r103 = (Function1) this.L$0;
        ResultKt.throwOnFailure(r100);
    L12:
        r103.invoke(r100);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        Function1<List<String>, Unit> r104 = this.$onResult;
        AlarmManager.f397387a.getClass();
        b r105 = AlarmManager.i();
        this.L$0 = r104;
        this.label = 1;
        Object r106 = r105.d(this);
        if (r106 != r101) goto L11;
        return r101;
    L11:
        r103 = r104;
        r100 = r106;
        goto L12
    }
}
