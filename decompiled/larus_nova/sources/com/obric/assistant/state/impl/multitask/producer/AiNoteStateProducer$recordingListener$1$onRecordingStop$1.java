package com.obric.assistant.state.impl.multitask.producer;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.state.impl.multitask.producer.AiNoteStateProducer$recordingListener$1$onRecordingStop$1", f = "AiNoteStateProducer.kt", i = {}, l = {73}, m = "invokeSuspend", n = {}, s = {})
public final class AiNoteStateProducer$recordingListener$1$onRecordingStop$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $recordedSeconds;
    int label;
    final /* synthetic */ AiNoteStateProducer this$0;

    public AiNoteStateProducer$recordingListener$1$onRecordingStop$1(AiNoteStateProducer r100, int r101, Continuation<? super AiNoteStateProducer$recordingListener$1$onRecordingStop$1> r102) {
        this.this$0 = r100;
        this.$recordedSeconds = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new AiNoteStateProducer$recordingListener$1$onRecordingStop$1(this.this$0, this.$recordedSeconds, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((AiNoteStateProducer$recordingListener$1$onRecordingStop$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        AiNoteStateProducer r103 = this.this$0;
        Map r104 = MapsKt.mapOf(new Pair[]{TuplesKt.to("reason", "stop"), TuplesKt.to("recorded_seconds", Boxing.boxInt(this.$recordedSeconds))});
        this.label = 1;
        if (AiNoteStateProducer.a(r103, r104) != r101) goto L12;
        return r101;
    }
}
