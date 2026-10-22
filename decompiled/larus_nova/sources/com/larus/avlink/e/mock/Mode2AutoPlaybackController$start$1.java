package com.larus.avlink.e.mock;

import com.larus.utils.logger.FLogger;
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

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.avlink.e.mock.Mode2AutoPlaybackController$start$1", f = "Mode2AutoPlaybackController.kt", i = {}, l = {68, 74, 84}, m = "invokeSuspend", n = {}, s = {})
final class Mode2AutoPlaybackController$start$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ l this$0;

    public Mode2AutoPlaybackController$start$1(l r100, Continuation<? super Mode2AutoPlaybackController$start$1> r101) {
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new Mode2AutoPlaybackController$start$1(null, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((Mode2AutoPlaybackController$start$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L24;
        if (r102 != 1) goto L6;
        ResultKt.throwOnFailure(r100);     // Catch: Exception -> L22 Throwable -> L33
    L28:
        FLogger r103 = FLogger.f375446a;     // Catch: Exception -> L22 Throwable -> L33
        int r104 = l.f291819a;     // Catch: Exception -> L22 Throwable -> L33
        throw null;     // Catch: Exception -> L22 Throwable -> L33
    L6:
        if (r102 != 2) goto L8;
        ResultKt.throwOnFailure(r100);     // Catch: Exception -> L22 Throwable -> L33
        if (((Boolean) r100).booleanValue() == true) goto L18;
        FLogger r105 = FLogger.f375446a;     // Catch: Exception -> L22 Throwable -> L33
        r105.e("Mode2AutoPlayback", "❌ Failed to play cycle, stopping auto playback");     // Catch: Exception -> L22 Throwable -> L33
        r105.i("Mode2AutoPlayback", "🛑 Mode2 auto playback stopped");     // Catch: Exception -> L22 Throwable -> L33
        int r106 = l.f291819a;
        throw null;
    L18:
        int r107 = l.f291819a;     // Catch: Exception -> L22 Throwable -> L33
        throw null;     // Catch: Exception -> L22 Throwable -> L33
    L8:
        if (r102 != 3) goto L10;
        ResultKt.throwOnFailure(r100);     // Catch: Exception -> L22 Throwable -> L33
        int r108 = l.f291819a;     // Catch: Exception -> L22 Throwable -> L33
        throw null;     // Catch: Exception -> L22 Throwable -> L33
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L24:
        ResultKt.throwOnFailure(r100);
        FLogger.f375446a.i("Mode2AutoPlayback", "🎬 Mode2 auto playback starting in 3000ms...");     // Catch: Exception -> L22 Throwable -> L33
        this.label = 1;     // Catch: Exception -> L22 Throwable -> L33
        if (DelayKt.delay(3000, this) != r101) goto L28;
        return r101;
    L22:
        e = move-exception;
        FLogger.f375446a.e("Mode2AutoPlayback", "Auto playback error", e);     // Catch: Throwable -> L33
        int r109 = l.f291819a;
        throw null;
    L33:
        int r110 = l.f291819a;
        throw null;
    }
}
