package com.larus.larkfeed.impl.voice.service.record;

import com.ss.android.lark.officesdk.utils.di.j;
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

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.larkfeed.impl.voice.service.record.FlowVoiceSession$readLoop$1", f = "FlowVoiceSession.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class FlowVoiceSession$readLoop$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ FlowVoiceSession this$0;

    public FlowVoiceSession$readLoop$1(FlowVoiceSession r100, Continuation<? super FlowVoiceSession$readLoop$1> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new FlowVoiceSession$readLoop$1(this.this$0, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((FlowVoiceSession$readLoop$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L42;
        ResultKt.throwOnFailure(r100);
        FlowVoiceSession r101 = this.this$0;     // Catch: Throwable -> L35
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L8
        Object r103 = Result.m9449constructorimpl(Result.m9448boximpl(FlowVoiceSession.b(r101)));     // Catch: Throwable -> L8
    L10:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);     // Catch: Throwable -> L35
        if (r104 == null) goto L17;
        String r105 = r104.getMessage();     // Catch: Throwable -> L35
        if (r105 != null) goto L16;
        r105 = "Failed to process audio frame";
    L16:
        r103 = Result.m9448boximpl(Result.m9449constructorimpl(ResultKt.createFailure(new IllegalStateException(r105, r104))));     // Catch: Throwable -> L35
    L17:
        Object r106 = ((Result) r103).m9458unboximpl();     // Catch: Throwable -> L35
        if (Result.m9455isFailureimpl(r106) == false) goto L23;
        if (this.this$0.f355687i.get() == false) goto L23;
        this.this$0.f355688j.set(false);     // Catch: Throwable -> L35
        FlowVoiceSession.a(this.this$0, Result.m9452exceptionOrNullimpl(r106));     // Catch: Throwable -> L35
    L23:
        if (this.this$0.f355688j.get() == false) goto L30;
        Throwable r107 = Result.m9452exceptionOrNullimpl(this.this$0.f(new byte[0], true));     // Catch: Throwable -> L35
        if (r107 == null) goto L30;
        String r108 = r107.getMessage();     // Catch: Throwable -> L35
        if (r108 != null) goto L29;
        r108 = "";
    L29:
        j.c("FlowVoiceSession", "【VoiceApp】".concat(r108), r107);     // Catch: Throwable -> L35
    L30:
        Throwable r109 = this.this$0.d();
        if (r109 == null) goto L33;
        j.c("FlowVoiceSession", "【VoiceApp】failed to close voice record file", r109);
    L33:
        this.this$0.f355687i.set(false);
        this.this$0.f355686h = null;
        return Unit.INSTANCE;
    L8:
        th = move-exception;
        Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L35
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        FlowVoiceSession r111 = this.this$0;
        FlowVoiceSession.a r112 = FlowVoiceSession.f355678l;
        Throwable r113 = r111.d();
        if (r113 == null) goto L39;
        j.c("FlowVoiceSession", "【VoiceApp】failed to close voice record file", r113);
    L39:
        this.this$0.f355687i.set(false);
        this.this$0.f355686h = null;
        throw th;
    L42:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
