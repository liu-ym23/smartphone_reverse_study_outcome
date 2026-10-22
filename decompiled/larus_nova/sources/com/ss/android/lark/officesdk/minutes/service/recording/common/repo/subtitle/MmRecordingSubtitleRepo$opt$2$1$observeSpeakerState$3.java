package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle;

import com.ss.ttm.player.MediaPlayer;
import java.util.Map;
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
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\n"}, d2 = {"<anonymous>", "", "it", "", "", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/speaker/MmMarkedSpeaker;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.MmRecordingSubtitleRepo$opt$2$1$observeSpeakerState$3", f = "MmRecordingSubtitleRepo.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_AUTO_DISCONNECTED_CPU}, m = "invokeSuspend", n = {}, s = {})
final class MmRecordingSubtitleRepo$opt$2$1$observeSpeakerState$3 extends SuspendLambda implements Function2<Map<String, ? extends com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.c>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Continuation<? super Unit>, Object> $apply;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public MmRecordingSubtitleRepo$opt$2$1$observeSpeakerState$3(Function1<? super Continuation<? super Unit>, ? extends Object> r100, Continuation<? super MmRecordingSubtitleRepo$opt$2$1$observeSpeakerState$3> r101) {
        this.$apply = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new MmRecordingSubtitleRepo$opt$2$1$observeSpeakerState$3(this.$apply, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Map<String, ? extends com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.c> r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Map<String, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.c> r100, Continuation<? super Unit> r101) {
        return ((MmRecordingSubtitleRepo$opt$2$1$observeSpeakerState$3) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
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
