package com.larus.paging;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010\u0003\u001a\u00028\u0000H\u008a@¨\u0006\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlinx/coroutines/flow/FlowCollector;", "it", "", "com/larus/paging/FlowExtKt$simpleMapLatest$1", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.larus.paging.CachedPagingDataKt$cachedIn$$inlined$simpleMapLatest$1", f = "CachedPagingData.kt", i = {}, l = {103}, m = "invokeSuspend", n = {}, s = {})
public final class CachedPagingDataKt$cachedIn$$inlined$simpleMapLatest$1 extends SuspendLambda implements Function3<FlowCollector<? super w<Object>>, k0<Object>, Continuation<? super Unit>, Object> {
    final /* synthetic */ CoroutineScope $scope$inlined;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    public CachedPagingDataKt$cachedIn$$inlined$simpleMapLatest$1(Continuation r100, CoroutineScope r101) {
        this.$scope$inlined = r101;
        super(3, r100);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super w<Object>> r100, k0<Object> r101, Continuation<? super Unit> r102) {
        return invoke(r100, r101, r102);
    }

    public final Object invoke(FlowCollector<? super w<Object>> r100, k0<Object> r101, Continuation<? super Unit> r102) {
        CachedPagingDataKt$cachedIn$$inlined$simpleMapLatest$1 r103 = new CachedPagingDataKt$cachedIn$$inlined$simpleMapLatest$1(r102, this.$scope$inlined);
        r103.L$0 = r100;
        r103.L$1 = r101;
        return r103.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        FlowCollector r103 = (FlowCollector) this.L$0;
        k0 r104 = (k0) this.L$1;
        w r105 = new w(this.$scope$inlined, r104);
        this.label = 1;
        if (r103.emit(r105, this) != r101) goto L12;
        return r101;
    }
}
