package com.larus.paging;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u0004\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000\"\b\b\u0002\u0010\u0002*\u00020\u0000*\u00020\u0003H\u008a@"}, d2 = {"", "K", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;", "Lcom/larus/paging/PagingSource$b$c;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.larus.paging.PagedList$Companion$create$resolvedInitialPage$1", f = "PagedList.kt", i = {}, l = {183}, m = "invokeSuspend", n = {}, s = {})
final class PagedList$Companion$create$resolvedInitialPage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super PagingSource.b.c<Object, Object>>, Object> {
    final /* synthetic */ PagingSource<Object, Object> $pagingSource;
    final /* synthetic */ PagingSource.a.d<Object> $params;
    int label;

    public PagedList$Companion$create$resolvedInitialPage$1(PagingSource<Object, Object> r100, PagingSource.a.d<Object> r101, Continuation<? super PagedList$Companion$create$resolvedInitialPage$1> r102) {
        this.$pagingSource = r100;
        this.$params = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new PagedList$Companion$create$resolvedInitialPage$1(this.$pagingSource, this.$params, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super PagingSource.b.c<Object, Object>> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super PagingSource.b.c<Object, Object>> r101) {
        return ((PagedList$Companion$create$resolvedInitialPage$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L11:
        PagingSource.b r103 = (PagingSource.b) r100;
        if ((r103 instanceof PagingSource.b.c) == false) goto L16;
        return (PagingSource.b.c) r103;
    L16:
        if ((r103 instanceof PagingSource.b.a) == true) goto L24;
        if ((r103 instanceof PagingSource.b.C4455b) == false) goto L22;
        throw new IllegalStateException("Failed to create PagedList. The provided PagingSource returned LoadResult.Invalid, but a LoadResult.Page was expected. To use a PagingSource which supports invalidation, use a PagedList builder that accepts a factory method for PagingSource or DataSource.Factory, such as LivePagedList.");
    L22:
        throw new NoWhenBranchMatchedException();
    L24:
        throw ((PagingSource.b.a) r103).f363728a;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        PagingSource<Object, Object> r104 = this.$pagingSource;
        PagingSource.a.d<Object> r105 = this.$params;
        this.label = 1;
        r100 = r104.c(r105, this);
        if (r100 != r101) goto L11;
        return r101;
    }
}
