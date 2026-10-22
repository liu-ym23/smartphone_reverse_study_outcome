package com.obric.assistant.activation.presentation.runtime.session;

import android.os.SystemClock;
import com.larus.utils.logger.FLogger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.activation.presentation.runtime.session.InteractionSessionProxy$closeSystemDialogsFromMain$1$1", f = "InteractionSessionProxy.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class InteractionSessionProxy$closeSystemDialogsFromMain$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ InteractionSessionProxy this$0;

    public InteractionSessionProxy$closeSystemDialogsFromMain$1$1(InteractionSessionProxy r100, Continuation<? super InteractionSessionProxy$closeSystemDialogsFromMain$1$1> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        InteractionSessionProxy$closeSystemDialogsFromMain$1$1 r102 = new InteractionSessionProxy$closeSystemDialogsFromMain$1$1(this.this$0, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((InteractionSessionProxy$closeSystemDialogsFromMain$1$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L18;
        ResultKt.throwOnFailure(r110);
        CoroutineScope r111 = (CoroutineScope) this.L$0;
        long r100 = SystemClock.elapsedRealtime();
        InteractionSessionProxy r112 = this.this$0;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L7
        AtomicLong r102 = InteractionSessionProxy.f385477d;     // Catch: Throwable -> L7
        r112.closeSystemDialogs();     // Catch: Throwable -> L7
        Object r113 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        InteractionSessionProxy r103 = this.this$0;
        Throwable r104 = Result.m9452exceptionOrNullimpl(r113);
        if (r104 == null) goto L12;
        FLogger.f375446a.w("InteractionSessionProxy", "closeSystemDialogs failed, id=" + r103.f385478a + ", cost=" + (SystemClock.elapsedRealtime() - r100), r104);
    L12:
        InteractionSessionProxy r105 = this.this$0;
        if (Result.m9456isSuccessimpl(r113) == false) goto L16;
        Unit r114 = (Unit) r113;
        FLogger.f375446a.i("InteractionSessionProxy", "closeSystemDialogs success, id=" + r105.f385478a + ", cost=" + (SystemClock.elapsedRealtime() - r100));
    L16:
        return Unit.INSTANCE;
    L7:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L9
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
