package com.larus.livetutor.impl.typing.looper;

import com.larus.livetutor.impl.typing.enumeration.TypingStreamStatus;
import com.larus.livetutor.impl.typing.rhythm.ITypingRhythmController;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.livetutor.impl.typing.looper.TypingLooper$loop$2", f = "TypingLooper.kt", i = {0, 0, 1, 1, 1, 2, 2, 2, 3, 3}, l = {79, 94, 98, 100}, m = "invokeSuspend", n = {"$this$coroutineScope", "typingInfoGetter", "$this$coroutineScope", "typingInfoGetter", "newBeat", "$this$coroutineScope", "typingInfoGetter", "timeInterval", "$this$coroutineScope", "typingInfoGetter"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "J$0", "L$0", "L$1"})
final class TypingLooper$loop$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ TypingLooper this$0;

    public TypingLooper$loop$2(TypingLooper r100, Continuation<? super TypingLooper$loop$2> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        TypingLooper$loop$2 r102 = new TypingLooper$loop$2(this.this$0, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((TypingLooper$loop$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:71:0x0163 -> B:14:0x0050). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L15;
        if (r101 == 1) goto L13;
        if (r101 == 2) goto L12;
        if (r101 == 3) goto L11;
        if (r101 == 4) goto L13;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        long r102 = this.J$0;
        TypingLooper.b r103 = (TypingLooper.b) this.L$1;
        CoroutineScope r111 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r110);
        CoroutineScope r112 = r111;
        TypingLooper$loop$2 r113 = this;
    L66:
        long r114 = r102;
        CoroutineScope r104 = r112;
    L68:
        r113.L$0 = r104;
        r113.L$1 = r103;
        r113.L$2 = null;
        r113.label = 4;
        if (DelayKt.delay(r114, r113) != r100) goto L71;
        return r100;
    L71:
        TypingLooper$loop$2 r105 = r113;
    L14:
        CoroutineScope r115 = r104;
        TypingLooper.b r106 = r103;
    L20:
        Object r107 = r100;
    L22:
        if (r105.this$0.f356611f == false) goto L73;
        if (CoroutineScopeKt.isActive(r115) == false) goto L73;
        int r108 = r106.d();
        TypingStreamStatus r116 = r106.a();
        if (r108 > 0) goto L40;
        if (r106.e() == true) goto L29;
        int r109 = r106.b();
        Integer r117 = r105.this$0.f356612g;
        if (r117 != null) goto L35;
    L36:
        r105.this$0.f356612g = Boxing.boxInt(r106.b());
    L37:
        long r118 = r105.this$0.f356610e.getTime();
        r105.L$0 = r115;
        r105.L$1 = r106;
        r105.label = 1;
        if (DelayKt.delay(r118, r105) != r107) goto L22;
        return r107;
    L35:
        if (r109 == r117.intValue()) goto L37;
    L29:
        r105.this$0.f356611f = false;
        return Unit.INSTANCE;
    L40:
        r114 = r105.this$0.f356610e.getTime();
        TypingLooper r119 = r105.this$0;
        ITypingRhythmController r120 = r119.f356607b;
        if (r120 != null) goto L74;
        TypingLooper.c r121 = r119.f356609d;
        if (r121 == null) goto L67;
        int r122 = r119.f356610e.getStep();
        long r123 = r105.this$0.f356610e.getTime();
        r105.L$0 = r115;
        r105.L$1 = r106;
        r105.J$0 = r114;
        r105.label = 3;
        if (r121.e(r122, r123, r105) != r107) goto L65;
        return r107;
    L65:
        r100 = r107;
        r103 = r106;
        r112 = r115;
        r113 = r105;
        r102 = r114;
    L67:
        r100 = r107;
        r103 = r106;
        r104 = r115;
        r113 = r105;
        goto L68
    L74:
        Result.Companion r124 = Result.Companion;     // Catch: Throwable -> L44
        r106.b();     // Catch: Throwable -> L44
        r106.c();     // Catch: Throwable -> L44
        Object r125 = Result.m9449constructorimpl(r120.a(r119.f356610e, r116));     // Catch: Throwable -> L44
    L47:
        if (Result.m9455isFailureimpl(r125) == false) goto L49;
        r125 = null;
    L49:
        ITypingRhythmController.Beat r126 = (ITypingRhythmController.Beat) r125;
        if (r126 != null) goto L52;
        r126 = r105.this$0.f356610e;
    L52:
        TypingLooper.c r127 = r105.this$0.f356609d;
        if (r127 == null) goto L59;
        int r128 = r126.getStep();
        long r129 = r126.getTime();
        r105.L$0 = r115;
        r105.L$1 = r106;
        r105.L$2 = r126;
        r105.label = 2;
        if (r127.e(r128, r129, r105) != r107) goto L57;
        return r107;
    L57:
        ITypingRhythmController.Beat r130 = r126;
        r100 = r107;
    L58:
        ITypingRhythmController.Beat r131 = r130;
        r107 = r100;
        r126 = r131;
    L59:
        r114 = r126.getTime();
        r105.this$0.f356610e = r126;
    L44:
        th = move-exception;
        Result.Companion r132 = Result.Companion;
        r125 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L73:
        return Unit.INSTANCE;
    L12:
        r130 = (ITypingRhythmController.Beat) this.L$2;
        r106 = (TypingLooper.b) this.L$1;
        CoroutineScope r133 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r110);
        r115 = r133;
        r105 = this;
    L13:
        r103 = (TypingLooper.b) this.L$1;
        r104 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r110);
        r105 = this;
        goto L14
    L15:
        ResultKt.throwOnFailure(r110);
        CoroutineScope r134 = (CoroutineScope) this.L$0;
        r106 = this.this$0.f356608c;
        if (r106 == null) goto L18;
        r105 = this;
        r115 = r134;
        goto L20
    L18:
        return Unit.INSTANCE;
    }
}
