package com.obric.sva.sdk.ipc;

import com.obric.sva.sdk.utils.LogUtils;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.sva.sdk.ipc.TrackerManager$traceDataInInteractor$1$2$3$1", f = "TrackerManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class TrackerManager$traceDataInInteractor$1$2$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $eventName;
    final /* synthetic */ JSONObject $payload;
    final /* synthetic */ Ref.ObjectRef<String> $wakeupStage;
    final /* synthetic */ Ref.BooleanRef $wakeupSuccess;
    private /* synthetic */ Object L$0;
    int label;

    public TrackerManager$traceDataInInteractor$1$2$3$1(String r100, Ref.ObjectRef<String> r101, Ref.BooleanRef r102, JSONObject r103, Continuation<? super TrackerManager$traceDataInInteractor$1$2$3$1> r104) {
        this.$eventName = r100;
        this.$wakeupStage = r101;
        this.$wakeupSuccess = r102;
        this.$payload = r103;
        super(2, r104);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        TrackerManager$traceDataInInteractor$1$2$3$1 r102 = new TrackerManager$traceDataInInteractor$1$2$3$1(this.$eventName, this.$wakeupStage, this.$wakeupSuccess, this.$payload, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((TrackerManager$traceDataInInteractor$1$2$3$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L15;
        ResultKt.throwOnFailure(r100);
        CoroutineScope r101 = (CoroutineScope) this.L$0;
        String r102 = this.$eventName;
        Ref.ObjectRef<String> r103 = this.$wakeupStage;
        Ref.BooleanRef r104 = this.$wakeupSuccess;
        JSONObject r105 = this.$payload;
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L7
        Lazy r107 = com.obric.assistant.common.utils.s.f387888a;     // Catch: Throwable -> L7
        Object r108 = Result.m9449constructorimpl(com.obric.assistant.common.utils.s.e(r102, r103.element, r104.element, r105));     // Catch: Throwable -> L7
    L9:
        String r109 = this.$eventName;
        Throwable r110 = Result.m9452exceptionOrNullimpl(r108);
        if (r110 == null) goto L13;
        LogUtils.w("TrackerManager", "reportWakeupEventViaSysPb failed event=" + r109 + ": " + r110.getMessage(), new Object[0]);
    L13:
        return Unit.INSTANCE;
    L7:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L9
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
