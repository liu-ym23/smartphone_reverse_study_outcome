package io.ktor.util.pipeline;

import com.ss.ttvideoengine.TTVideoEngineInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0006\u001a\u00020\u0005\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000*\u0010\u0012\u0006\b\u0001\u0012\u00020\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0000H\u008a@"}, d2 = {"", "TSubject", "TContext", "Lio/ktor/util/pipeline/b;", com.bytedance.android.ec.core.event.a.KEY_SUBJECT, "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "io.ktor.util.pipeline.PipelineKt$intercept$1", f = "Pipeline.kt", i = {}, l = {TTVideoEngineInterface.PLAYER_OPTION_ENABLE_ABR}, m = "invokeSuspend", n = {}, s = {})
public final class PipelineKt$intercept$1 extends SuspendLambda implements Function3<b<? extends Object, Object>, Object, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function3<b<Object, Object>, Object, Continuation<? super Unit>, Object> $block;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public PipelineKt$intercept$1(Function3<? super b<Object, Object>, Object, ? super Continuation<? super Unit>, ? extends Object> r100, Continuation<? super PipelineKt$intercept$1> r101) {
        this.$block = r100;
        super(3, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(b<? extends Object, Object> r100, Object r101, Continuation<? super Unit> r102) {
        PipelineKt$intercept$1 r103 = new PipelineKt$intercept$1(this.$block, r102);
        r103.L$0 = r100;
        r103.L$1 = r101;
        return r103.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(b<? extends Object, Object> r100, Object r101, Continuation<? super Unit> r102) {
        return invoke2(r100, r101, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L21:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        b<Object, Object> r103 = (b) this.L$0;
        Object r104 = this.L$1;
        Intrinsics.reifiedOperationMarker(3, "TSubject");
        if ((r104 instanceof Object) == true) goto L13;
        return Unit.INSTANCE;
    L13:
        if ((r103 instanceof b) == true) goto L16;
        r103 = null;
    L16:
        if (r103 == null) goto L21;
        Function3<b<Object, Object>, Object, Continuation<? super Unit>, Object> r105 = this.$block;
        this.L$0 = null;
        this.label = 1;
        if (r105.invoke(r103, r104, this) != r101) goto L21;
        return r101;
    }
}
