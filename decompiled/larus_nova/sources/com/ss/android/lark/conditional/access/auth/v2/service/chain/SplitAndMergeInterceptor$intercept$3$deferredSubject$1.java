package com.ss.android.lark.conditional.access.auth.v2.service.chain;

import com.ss.android.lark.security.compliance.api.model.filepolicy.PolicyModel;
import i8b.l;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "", "Lcom/ss/android/lark/conditional/access/auth/v2/FilePolicyResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.conditional.access.auth.v2.service.chain.SplitAndMergeInterceptor$intercept$3$deferredSubject$1", f = "SplitAndMergeInterceptor.kt", i = {0}, l = {61}, m = "invokeSuspend", n = {"preTraceId$iv$iv"}, s = {"L$0"})
public final class SplitAndMergeInterceptor$intercept$3$deferredSubject$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Map<String, ? extends com.ss.android.lark.conditional.access.auth.v2.c>>, Object> {
    final /* synthetic */ l $chain;
    final /* synthetic */ List<PolicyModel> $models;
    Object L$0;
    int label;

    public SplitAndMergeInterceptor$intercept$3$deferredSubject$1(l r100, List<PolicyModel> r101, Continuation<? super SplitAndMergeInterceptor$intercept$3$deferredSubject$1> r102) {
        this.$chain = r100;
        this.$models = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new SplitAndMergeInterceptor$intercept$3$deferredSubject$1(this.$chain, this.$models, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Map<String, ? extends com.ss.android.lark.conditional.access.auth.v2.c>> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Map<String, com.ss.android.lark.conditional.access.auth.v2.c>> r101) {
        return ((SplitAndMergeInterceptor$intercept$3$deferredSubject$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L12;
        if (r102 != 1) goto L11;
        String r103 = (String) this.L$0;
        ResultKt.throwOnFailure(r100);     // Catch: Throwable -> L8
    L18:
        Map r104 = (Map) r100;     // Catch: Throwable -> L8
        qqb.a.a();
        qqb.a.f(r103);
        return r104;
    L8:
        th = th;
    L25:
        qqb.a.a();
        qqb.a.f(r103);
        throw th;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r100);
        String r105 = this.$chain.getTraceId();
        l r106 = this.$chain;
        List<PolicyModel> r107 = this.$models;
        String r108 = qqb.a.d();     // Catch: Throwable -> L23
        qqb.a.f(r105);     // Catch: Throwable -> L21
        this.L$0 = r108;     // Catch: Throwable -> L21
        this.label = 1;     // Catch: Throwable -> L21
        r100 = r106.a(r107, this);     // Catch: Throwable -> L21
        if (r100 != r101) goto L17;
        return r101;
    L17:
        r103 = r108;
    L21:
        th = th;
        r103 = r108;
    L23:
        th = th;
        r103 = "";
        goto L25
    }
}
