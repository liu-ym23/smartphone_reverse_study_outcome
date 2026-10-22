package com.larus.livetutor.impl.tutor.controller;

import com.larus.livetutor.api.idl.ControlReason;
import com.larus.livetutor.impl.tutor.data.LiveTutorPauseEvent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.livetutor.impl.tutor.controller.LiveTutorPauseController$resume$1", f = "LiveTutorPauseController.kt", i = {}, l = {127}, m = "invokeSuspend", n = {}, s = {})
final class LiveTutorPauseController$resume$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $pauseKey;
    final /* synthetic */ ControlReason $pauseReason;
    final /* synthetic */ boolean $withAnim;
    int label;
    final /* synthetic */ LiveTutorPauseController this$0;

    public LiveTutorPauseController$resume$1(LiveTutorPauseController r100, ControlReason r101, int r102, boolean r103, Continuation<? super LiveTutorPauseController$resume$1> r104) {
        this.this$0 = r100;
        this.$pauseReason = r101;
        this.$pauseKey = r102;
        this.$withAnim = r103;
        super(2, r104);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new LiveTutorPauseController$resume$1(this.this$0, this.$pauseReason, this.$pauseKey, this.$withAnim, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((LiveTutorPauseController$resume$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L8;
        if (r101 != 1) goto L7;
        ResultKt.throwOnFailure(r110);
    L12:
        if (((Boolean) r110).booleanValue() == false) goto L14;
        this.this$0.f356450c.remove(Boxing.boxInt(this.$pauseKey));
        this.this$0.f356449b.setValue(new LiveTutorPauseEvent(false, false, this.$pauseReason, false, this.$withAnim, 10, null));
    L16:
        return Unit.INSTANCE;
    L14:
        this.this$0.f356452e.invoke(this.$pauseReason);
        goto L16
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r110);
        LiveTutorPauseController r111 = this.this$0;
        ControlReason r102 = this.$pauseReason;
        this.label = 1;
        int r103 = LiveTutorPauseController.f356447f;
        r110 = r111.f(r102, 3, this);
        if (r110 != r100) goto L12;
        return r100;
    }
}
