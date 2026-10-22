package com.larus.paging;

import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.DiffUtil;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.IntIterator;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u0002H\u008a@"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;", "Lcom/larus/paging/z;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.larus.paging.AsyncPagingDataDiffer$differBase$1$presentNewList$diffResult$1", f = "AsyncPagingDataDiffer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class AsyncPagingDataDiffer$differBase$1$presentNewList$diffResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super z>, Object> {
    final /* synthetic */ a0<Object> $newList;
    final /* synthetic */ a0<Object> $previousList;
    int label;
    final /* synthetic */ e<Object> this$0;

    public AsyncPagingDataDiffer$differBase$1$presentNewList$diffResult$1(a0<Object> r100, a0<Object> r101, e<Object> r102, Continuation<? super AsyncPagingDataDiffer$differBase$1$presentNewList$diffResult$1> r103) {
        this.$previousList = r100;
        this.$newList = r101;
        this.this$0 = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new AsyncPagingDataDiffer$differBase$1$presentNewList$diffResult$1(this.$previousList, this.$newList, this.this$0, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super z> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super z> r101) {
        return ((AsyncPagingDataDiffer$differBase$1$presentNewList$diffResult$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L22;
        ResultKt.throwOnFailure(r100);
        final a0<Object> r101 = this.$previousList;
        final a0<Object> r102 = this.$newList;
        final DiffUtil.ItemCallback<Object> r103 = this.this$0.f363806a;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        Intrinsics.checkNotNullParameter(r102, "newList");
        Intrinsics.checkNotNullParameter(r103, "diffCallback");
        final int r104 = r101.d();
        final int r105 = r102.d();
        boolean r106 = true;
        DiffUtil.DiffResult r107 = DiffUtil.calculateDiff(new NullPaddedListDiffHelperKt$computeDiff$diffResult$1(r101, r102, r103, r104, r105), true);
        Iterable r108 = RangesKt.until(0, r101.d());
        if ((r108 instanceof Collection) == true) goto L7;
    L9:
        Iterator r109 = r108.iterator();
    L11:
        if (r109.hasNext() == false) goto L18;
        if (r107.convertOldPositionToNew(((IntIterator) r109).nextInt()) == (-1)) goto L15;
        boolean r110 = true;
    L16:
        if (r110 == false) goto L11;
    L20:
        return new z(r107, r106);
    L15:
        r110 = false;
    L18:
        r106 = false;
        goto L20
    L7:
        if (((Collection) r108).isEmpty() == false) goto L9;
    L22:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
