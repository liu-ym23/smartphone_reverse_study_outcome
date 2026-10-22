package io.ktor.util.pipeline;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.ktor.util.KtorDsl;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
@KtorDsl
public final class DebugPipelineContext<TSubject, TContext> extends b<TSubject, TContext> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Function3<b<TSubject, TContext>, TSubject, Continuation<? super Unit>, Object>> f491971b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CoroutineContext f491972c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TSubject f491973d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f491974e;

    @Override // io.ktor.util.pipeline.b
    public final void b() {
        this.f491974e = -1;
    }

    @Override // io.ktor.util.pipeline.b
    public final TSubject c() {
        return this.f491973d;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext getCoroutineContext() {
        return this.f491972c;
    }

    @Override // io.ktor.util.pipeline.b
    public final Object d(Continuation<? super TSubject> r100) {
        int r101 = this.f491974e;
        if (r101 >= 0) goto L7;
        return this.f491973d;
    L7:
        if (r101 < this.f491971b.size()) goto L11;
        this.f491974e = -1;
        return this.f491973d;
    L11:
        return f(r100);
    }

    public final Object f(Continuation<? super TSubject> r100) {
        if ((r100 instanceof DebugPipelineContext$proceedLoop$1) == false) goto L7;
        DebugPipelineContext$proceedLoop$1 r101 = (DebugPipelineContext$proceedLoop$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        DebugPipelineContext<TSubject, TContext> r106 = (DebugPipelineContext) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L15:
        int r107 = r106.f491974e;
        if (r107 == (-1)) goto L22;
        List<Function3<b<TSubject, TContext>, TSubject, Continuation<? super Unit>, Object>> r108 = r106.f491971b;
        if (r107 >= r108.size()) goto L20;
        Function3 r109 = (Function3) ListProtector.get(r108, r107);
        r106.f491974e = r107 + 1;
        Intrinsics.checkNotNull(r109, "null cannot be cast to non-null type @[ExtensionFunctionType] kotlin.coroutines.SuspendFunction2<io.ktor.util.pipeline.PipelineContext<TSubject of io.ktor.util.pipeline.DebugPipelineContext, TContext of io.ktor.util.pipeline.DebugPipelineContext>, TSubject of io.ktor.util.pipeline.DebugPipelineContext, kotlin.Unit>{ io.ktor.util.pipeline.PipelineKt.PipelineInterceptor<TSubject of io.ktor.util.pipeline.DebugPipelineContext, TContext of io.ktor.util.pipeline.DebugPipelineContext> }");
        TSubject r110 = r106.f491973d;
        r101.L$0 = r106;
        r101.label = 1;
        if (r109.invoke(r106, r110, r101) != r104) goto L15;
        return r104;
    L20:
        r106.f491974e = -1;
    L22:
        return r106.f491973d;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        r106 = this;
    L7:
        r101 = new DebugPipelineContext$proceedLoop$1(this, r100);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.ktor.util.pipeline.b
    public final Object a(Unit r100, Continuation r101) {
        this.f491974e = 0;
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f491973d = r100;
        return d(r101);
    }

    @Override // io.ktor.util.pipeline.b
    public final Object e(TSubject r100, Continuation<? super TSubject> r101) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f491973d = r100;
        return d(r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DebugPipelineContext(Object r100, List r101, Unit r102, CoroutineContext r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "interceptors");
        Intrinsics.checkNotNullParameter(r102, com.bytedance.android.ec.core.event.a.KEY_SUBJECT);
        Intrinsics.checkNotNullParameter(r103, "coroutineContext");
        super(r100);
        this.f491971b = r101;
        this.f491972c = r103;
        this.f491973d = r102;
    }
}
