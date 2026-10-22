package com.bytedance.ee.bear.document.render.node.perf;

import com.bytedance.ee.bear.document.DocOpenConfig;
import com.bytedance.ee.bear.document.render.node.DocLoadingState;
import com.bytedance.ee.bear.document.render.node.g;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ee.bear.document.render.node.perf.PerfReportRenderNode$addTimeoutJob$1", f = "PerfReportRenderNode.kt", i = {}, l = {82}, m = "invokeSuspend", n = {}, s = {})
final class PerfReportRenderNode$addTimeoutJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ PerfReportRenderNode this$0;

    public PerfReportRenderNode$addTimeoutJob$1(PerfReportRenderNode r1, Continuation<? super PerfReportRenderNode$addTimeoutJob$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new PerfReportRenderNode$addTimeoutJob$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L11:
        PerfReportRenderNode r7 = this.this$0;
        com.bytedance.ee.bear.document.render.node.f r2 = r7.d;
        if (r2 == null) goto L18;
        g r8 = r7.c;
        if (r8 == null) goto L16;
        DocLoadingState r9 = r8.state();
    L17:
        int r10 = r2.c(r9, this.this$0.c);
    L19:
        PerfReportRenderNode r3 = this.this$0;
        OvertimeDocException r4 = new OvertimeDocException(r10, "openDoc timeout");
        Map<String, String> r5 = this.this$0.e;
        if (r5 != null) goto L22;
        r5 = MapsKt.emptyMap();
    L22:
        r3.e(r10, r4, r5);
        return Unit.INSTANCE;
    L16:
        r9 = null;
        goto L17
    L18:
        int r11 = a05.c.b.a;
        r10 = 999;
        goto L19
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        long r12 = DocOpenConfig.d();
        this.label = 1;
        if (DelayKt.delay(r12, this) != r0) goto L11;
        return r0;
    }
}
