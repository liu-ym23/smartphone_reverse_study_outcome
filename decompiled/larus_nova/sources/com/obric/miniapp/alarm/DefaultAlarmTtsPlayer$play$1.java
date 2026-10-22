package com.obric.miniapp.alarm;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.miniapp.alarm.DefaultAlarmTtsPlayer$play$1", f = "AlarmTtsNotificationDispatcher.kt", i = {}, l = {213}, m = "invokeSuspend", n = {}, s = {})
final class DefaultAlarmTtsPlayer$play$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $content;
    final /* synthetic */ String $messageId;
    int label;
    final /* synthetic */ v this$0;

    public DefaultAlarmTtsPlayer$play$1(v r100, String r101, String r102, Continuation<? super DefaultAlarmTtsPlayer$play$1> r103) {
        this.this$0 = r100;
        this.$messageId = r101;
        this.$content = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new DefaultAlarmTtsPlayer$play$1(this.this$0, this.$messageId, this.$content, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((DefaultAlarmTtsPlayer$play$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L11:
        v r103 = this.this$0;
        String r104 = this.$messageId;
        String r105 = this.$content;
        int r106 = v.f397486c;
        r103.b(r104, r105);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        v r107 = this.this$0;
        int r108 = v.f397486c;
        r107.getClass();
        this.label = 1;
        if (DelayKt.delay(500, this) != r101) goto L11;
        return r101;
    }
}
