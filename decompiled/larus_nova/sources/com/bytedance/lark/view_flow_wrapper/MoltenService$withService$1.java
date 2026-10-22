package com.bytedance.lark.view_flow_wrapper;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.lark.view_flow_wrapper.MoltenService", f = "MoltenService.kt", i = {}, l = {30}, m = "withService-gIAlu-s", n = {}, s = {})
public final class MoltenService$withService$1<R> extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MoltenService<S> this$0;

    public MoltenService$withService$1(MoltenService<S> r100, Continuation<? super MoltenService$withService$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type kotlin.coroutines.Continuation to com.bytedance.lark.view_flow_wrapper.MoltenService$withService$1<R> for r1v1 'this'  kotlin.coroutines.Continuation
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
        com.bytedance.lark.view_flow_wrapper.MoltenService<S> r2 = r1.this$0;
        kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation<? super kotlin.Result<? extends R>>) r1;
        java.lang.Object r2 = r2.c(null, r1);
        java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (r2 != r0) goto L5;
        return r2;
    L5:
        kotlin.Result r2 = kotlin.Result.m9448boximpl(r2);
        return r2;
    }
}
