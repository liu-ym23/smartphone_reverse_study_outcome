package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.MmRecordingSubtitleRepo$opt$2$1$observeSpeakerState$6", f = "MmRecordingSubtitleRepo.kt", i = {}, l = {1318}, m = "invokeSuspend", n = {}, s = {})
final class MmRecordingSubtitleRepo$opt$2$1$observeSpeakerState$6 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Continuation<? super Unit>, Object> $apply;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public MmRecordingSubtitleRepo$opt$2$1$observeSpeakerState$6(Function1<? super Continuation<? super Unit>, ? extends Object> r100, Continuation<? super MmRecordingSubtitleRepo$opt$2$1$observeSpeakerState$6> r101) {
        this.$apply = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new MmRecordingSubtitleRepo$opt$2$1$observeSpeakerState$6(this.$apply, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Boolean r100, Continuation<? super Unit> r101) {
        return invoke(r100.booleanValue(), r101);
    }

    public final Object invoke(boolean r100, Continuation<? super Unit> r101) {
        return ((MmRecordingSubtitleRepo$opt$2$1$observeSpeakerState$6) create(Boolean.valueOf(r100), r101)).invokeSuspend(Unit.INSTANCE);
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
        Function1<Continuation<? super Unit>, Object> r103 = this.$apply;
        this.label = 1;
        if (r103.invoke(this) != r101) goto L12;
        return r101;
    }
}
