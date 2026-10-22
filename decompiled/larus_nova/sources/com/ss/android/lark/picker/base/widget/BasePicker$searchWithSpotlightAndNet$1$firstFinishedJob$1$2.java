package com.ss.android.lark.picker.base.widget;

import com.ss.android.lark.search.dto.SearchResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.Deferred;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\n"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/Deferred;", "Lcom/ss/android/lark/search/dto/SearchResponse;", "it"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.picker.base.widget.BasePicker$searchWithSpotlightAndNet$1$firstFinishedJob$1$2", f = "BasePicker.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class BasePicker$searchWithSpotlightAndNet$1$firstFinishedJob$1$2 extends SuspendLambda implements Function2<SearchResponse, Continuation<? super Deferred<? extends SearchResponse>>, Object> {
    final /* synthetic */ Deferred<SearchResponse> $netJob;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public BasePicker$searchWithSpotlightAndNet$1$firstFinishedJob$1$2(Deferred<? extends SearchResponse> r100, Continuation<? super BasePicker$searchWithSpotlightAndNet$1$firstFinishedJob$1$2> r101) {
        this.$netJob = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new BasePicker$searchWithSpotlightAndNet$1$firstFinishedJob$1$2(this.$netJob, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(SearchResponse r100, Continuation<? super Deferred<? extends SearchResponse>> r101) {
        return ((BasePicker$searchWithSpotlightAndNet$1$firstFinishedJob$1$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(SearchResponse r100, Continuation<? super Deferred<? extends SearchResponse>> r101) {
        return invoke2(r100, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        return this.$netJob;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
