package com.larus.dora.impl.dynamic.widget;

import c59.e0;
import c59.f0;
import c59.s;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/dora/impl/dynamic/dsl/DslTabConfig;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.dynamic.widget.NestedDynamicPageView$setPageInfo$2$tabConfig$1", f = "NestedDynamicPageView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class NestedDynamicPageView$setPageInfo$2$tabConfig$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super f0>, Object> {
    final /* synthetic */ e0 $tab;
    int label;

    public NestedDynamicPageView$setPageInfo$2$tabConfig$1(e0 r100, Continuation<? super NestedDynamicPageView$setPageInfo$2$tabConfig$1> r101) {
        this.$tab = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new NestedDynamicPageView$setPageInfo$2$tabConfig$1(this.$tab, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super f0> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super f0> r101) {
        return ((NestedDynamicPageView$setPageInfo$2$tabConfig$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        Lazy r101 = s.f22521a;
        return s.c(this.$tab.f22508a, f0.class);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
