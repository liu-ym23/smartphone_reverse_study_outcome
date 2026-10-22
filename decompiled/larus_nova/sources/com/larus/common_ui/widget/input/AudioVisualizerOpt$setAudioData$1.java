package com.larus.common_ui.widget.input;

import androidx.camera.video.AudioStats;
import java.util.ArrayList;
import java.util.Iterator;
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

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.common_ui.widget.input.AudioVisualizerOpt$setAudioData$1", f = "AudioVisualizerOpt.kt", i = {}, l = {300}, m = "invokeSuspend", n = {}, s = {})
public final class AudioVisualizerOpt$setAudioData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ byte[] $data;
    int label;
    final /* synthetic */ AudioVisualizerOpt this$0;

    public AudioVisualizerOpt$setAudioData$1(byte[] r100, AudioVisualizerOpt r101, Continuation<? super AudioVisualizerOpt$setAudioData$1> r102) {
        this.$data = r100;
        this.this$0 = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new AudioVisualizerOpt$setAudioData$1(this.$data, this.this$0, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((AudioVisualizerOpt$setAudioData$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L11:
        Iterator r103 = ((ArrayList) r100).iterator();
        if (r103.hasNext() == true) goto L14;
        Double r104 = null;
    L19:
        if (r104 == null) goto L21;
        double r105 = r104.doubleValue();
    L22:
        AudioVisualizerOpt r106 = this.this$0;
        AudioVisualizerOpt.b(r106, AudioVisualizerOpt.a(r106, r105));
        return Unit.INSTANCE;
    L21:
        r105 = AudioStats.AUDIO_AMPLITUDE_NONE;
        goto L22
    L14:
        double r107 = Math.abs(((Number) r103.next()).doubleValue());
    L16:
        if (r103.hasNext() == false) goto L18;
        r107 = Math.max(r107, Math.abs(((Number) r103.next()).doubleValue()));
        goto L16
    L18:
        r104 = Boxing.boxDouble(r107);
        goto L19
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        int r108 = a.f328681a;
        byte[] r109 = this.$data;
        int r110 = this.this$0.f328661b;
        this.label = 1;
        r100 = a.a(r109, r110, this);
        if (r100 != r101) goto L11;
        return r101;
    }
}
