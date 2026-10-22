package com.larus.basic.experience.downgrade.impl.strategy;

import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.basic.experience.downgrade.impl.strategy.DowngradeStrategyGroup", f = "IDowngradeStrategy.kt", i = {0, 1, 1, 2, 2}, l = {90, 96, 103}, m = "process", n = {PerfLog.PARAM_KEY_CONTEXT_ID, PerfLog.PARAM_KEY_CONTEXT_ID, "resp", PerfLog.PARAM_KEY_CONTEXT_ID, "resp"}, s = {"L$0", "L$0", "L$1", "L$0", "L$1"})
public final class DowngradeStrategyGroup$process$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DowngradeStrategyGroup<T> this$0;

    public DowngradeStrategyGroup$process$1(DowngradeStrategyGroup<T> r100, Continuation<? super DowngradeStrategyGroup$process$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type kotlin.coroutines.Continuation to com.larus.basic.experience.downgrade.impl.strategy.DowngradeStrategyGroup$process$1 for r1v1 'this'  kotlin.coroutines.Continuation
        	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
        	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
        	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r2) {
        r1.result = r2;
        int r2 = r1.label;
        int r2 = r2 | Integer.MIN_VALUE;
        r1.label = r2;
        com.larus.basic.experience.downgrade.impl.strategy.DowngradeStrategyGroup<T> r2 = r1.this$0;
        kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation<? super kotlin.Pair<? extends com.larus.network.http.a<? extends T>, com.larus.basic.experience.downgrade.impl.strategy.b<T>>>) r1;
        java.lang.Object r2 = r2.a(r1);
        return r2;
    }
}
