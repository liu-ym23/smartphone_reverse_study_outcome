package com.larus.basic.experience.downgrade.impl.strategy;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.basic.experience.downgrade.impl.strategy.DelayDowngradeStrategy", f = "DelayDowngradeStrategy.kt", i = {0}, l = {44}, m = "preProcess", n = {"downgradeContext"}, s = {"L$0"})
public final class DelayDowngradeStrategy$preProcess$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DelayDowngradeStrategy<T> this$0;

    public DelayDowngradeStrategy$preProcess$1(DelayDowngradeStrategy<T> r100, Continuation<? super DelayDowngradeStrategy$preProcess$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type kotlin.coroutines.Continuation to com.larus.basic.experience.downgrade.impl.strategy.DelayDowngradeStrategy$preProcess$1 for r1v1 'this'  kotlin.coroutines.Continuation
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
        com.larus.basic.experience.downgrade.impl.strategy.DelayDowngradeStrategy<T> r2 = r1.this$0;
        kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation<? super com.larus.basic.experience.downgrade.impl.strategy.b<T>>) r1;
        java.lang.Object r2 = r2.e(null, r1);
        return r2;
    }
}
