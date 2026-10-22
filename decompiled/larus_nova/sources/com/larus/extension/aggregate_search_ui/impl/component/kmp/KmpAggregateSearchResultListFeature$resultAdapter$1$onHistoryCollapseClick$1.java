package com.larus.extension.aggregate_search_ui.impl.component.kmp;

import com.larus.extension.aggregate_search_ui.api.kmp.KmpISearchEventTrackerAbility;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.extension.aggregate_search_ui.impl.component.kmp.KmpAggregateSearchResultListFeature$resultAdapter$1$onHistoryCollapseClick$1", f = "KmpAggregateSearchResultListFeature.kt", i = {}, l = {182}, m = "invokeSuspend", n = {}, s = {})
public final class KmpAggregateSearchResultListFeature$resultAdapter$1$onHistoryCollapseClick$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $beforeCnt;
    int label;
    final /* synthetic */ KmpAggregateSearchResultListFeature this$0;

    public KmpAggregateSearchResultListFeature$resultAdapter$1$onHistoryCollapseClick$1(KmpAggregateSearchResultListFeature r100, int r101, Continuation<? super KmpAggregateSearchResultListFeature$resultAdapter$1$onHistoryCollapseClick$1> r102) {
        this.this$0 = r100;
        this.$beforeCnt = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new KmpAggregateSearchResultListFeature$resultAdapter$1$onHistoryCollapseClick$1(this.this$0, this.$beforeCnt, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((KmpAggregateSearchResultListFeature$resultAdapter$1$onHistoryCollapseClick$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L8;
        if (r101 != 1) goto L7;
        ResultKt.throwOnFailure(r110);
    L14:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r110);
        KmpAggregateSearchResultListFeature r111 = this.this$0;
        int r102 = KmpAggregateSearchResultListFeature.A;
        KmpISearchEventTrackerAbility r103 = r111.m3();
        if (r103 == null) goto L14;
        int r104 = this.$beforeCnt;
        this.label = 1;
        if (r103.trackSearchHistoryManage("collapse", "", -1, r104, this) != r100) goto L14;
        return r100;
    }
}
