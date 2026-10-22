package com.obric.assistant.view.listening;

import androidx.camera.video.AudioStats;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
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

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.view.listening.ObricListeningViewController$setAudioData$1$1", f = "ObricListeningViewController.kt", i = {}, l = {213}, m = "invokeSuspend", n = {}, s = {})
final class ObricListeningViewController$setAudioData$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ byte[] $data;
    final /* synthetic */ b $target;
    int label;
    final /* synthetic */ f this$0;

    public ObricListeningViewController$setAudioData$1$1(byte[] r100, f r101, b r102, Continuation<? super ObricListeningViewController$setAudioData$1$1> r103) {
        this.$data = r100;
        this.this$0 = r101;
        this.$target = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new ObricListeningViewController$setAudioData$1$1(this.$data, this.this$0, this.$target, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((ObricListeningViewController$setAudioData$1$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L11:
        ArrayList<Double> r103 = (ArrayList) r100;
        Iterator r104 = r103.iterator();
        if (r104.hasNext() == true) goto L14;
        Double r105 = null;
    L19:
        if (r105 == null) goto L21;
        double r106 = r105.doubleValue();
    L22:
        f r107 = this.this$0;
        b r108 = this.$target;
        AtomicLong r109 = f.f394312l;
        if (r107.e(r108, r106) == true) goto L26;
        this.this$0.f394315c.b(r103);
    L26:
        return Unit.INSTANCE;
    L21:
        r106 = AudioStats.AUDIO_AMPLITUDE_NONE;
        goto L22
    L14:
        double r110 = Math.abs(((Number) r104.next()).doubleValue());
    L16:
        if (r104.hasNext() == false) goto L18;
        r110 = Math.max(r110, Math.abs(((Number) r104.next()).doubleValue()));
        goto L16
    L18:
        r105 = Boxing.boxDouble(r110);
        goto L19
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        int r111 = com.larus.common_ui.widget.input.a.f328681a;
        byte[] r112 = this.$data;
        this.label = 1;
        r100 = com.larus.common_ui.widget.input.a.a(r112, 45, this);
        if (r100 != r101) goto L11;
        return r101;
    }
}
