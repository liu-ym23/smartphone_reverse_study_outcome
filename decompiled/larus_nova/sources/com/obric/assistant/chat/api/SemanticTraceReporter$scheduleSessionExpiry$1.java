package com.obric.assistant.chat.api;

import com.ss.ttm.player.MediaPlayer;
import java.util.LinkedHashMap;
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

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.chat.api.SemanticTraceReporter$scheduleSessionExpiry$1", f = "SemanticTraceReporter.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RATE}, m = "invokeSuspend", n = {}, s = {})
final class SemanticTraceReporter$scheduleSessionExpiry$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $traceKey;
    int label;

    public SemanticTraceReporter$scheduleSessionExpiry$1(String r100, Continuation<? super SemanticTraceReporter$scheduleSessionExpiry$1> r101) {
        this.$traceKey = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new SemanticTraceReporter$scheduleSessionExpiry$1(this.$traceKey, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((SemanticTraceReporter$scheduleSessionExpiry$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        boolean r102 = true;
        if (r101 == 0) goto L8;
        if (r101 != 1) goto L7;
        ResultKt.throwOnFailure(r110);
    L11:
        long r103 = System.currentTimeMillis();
        Object r111 = f.f386617b;
        String r104 = this.$traceKey;
        monitor-enter(r111);
        f.a r105 = (f.a) ((LinkedHashMap) f.f386621f).get(r104);     // Catch: Throwable -> L29
        if (r105 != null) goto L16;
    L26:
        monitor-exit(r111);
        return Unit.INSTANCE;
    L16:
        if (r105.f386635l == false) goto L18;
    L20:
        r102 = false;
    L21:
        if (r102 == true) goto L24;
        r105 = null;
    L24:
        if (r105 == null) goto L26;
        CoroutineScope r106 = f.f386616a;     // Catch: Throwable -> L29
        f.m(r105, r103);     // Catch: Throwable -> L29
        goto L26
    L18:
        if ((r103 - r105.f386627d) < 1800000) goto L20;
    L29:
        th = move-exception;
        throw th;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r110);
        this.label = 1;
        if (DelayKt.delay(1800000, this) != r100) goto L11;
        return r100;
    }
}
