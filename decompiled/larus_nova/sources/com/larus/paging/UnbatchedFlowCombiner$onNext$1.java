package com.larus.paging;

import com.ss.ttvideoengine.model.VideoRef;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.larus.paging.UnbatchedFlowCombiner", f = "FlowExt.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2}, l = {188, VideoRef.VALUE_VIDEO_REF_POPULARITY_LEVEL, 205}, m = "onNext", n = {"this", "value", "index", "this", "value", "$this$withLock$iv", "index", "this", "$this$withLock$iv"}, s = {"L$0", "L$1", "I$0", "L$0", "L$1", "L$2", "I$0", "L$0", "L$1"})
public final class UnbatchedFlowCombiner$onNext$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UnbatchedFlowCombiner<T1, T2> this$0;

    public UnbatchedFlowCombiner$onNext$1(UnbatchedFlowCombiner<T1, T2> r100, Continuation<? super UnbatchedFlowCombiner$onNext$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type kotlin.coroutines.Continuation to com.larus.paging.UnbatchedFlowCombiner$onNext$1 for r2v1 'this'  kotlin.coroutines.Continuation
        	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
        	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
        	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r3) {
        r2.result = r3;
        int r3 = r2.label;
        int r3 = r3 | Integer.MIN_VALUE;
        r2.label = r3;
        com.larus.paging.UnbatchedFlowCombiner<T1, T2> r3 = r2.this$0;
        kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation<? super kotlin.Unit>) r2;
        java.lang.Object r3 = r3.a(0, null, r2);
        return r3;
    }
}
