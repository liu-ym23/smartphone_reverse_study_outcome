package com.bytedance.flow.search.kmp.impl.middleware;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;", "com/flow/kmp/common/thread/MainThreadUtilsKt$runOnMainThreadIfNeed$1"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.flow.search.kmp.impl.middleware.SearchHistoryMiddleware$ensureHistoryLoaded$lambda$14$$inlined$runOnMainThreadIfNeed$1", f = "SearchHistoryMiddleware.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class SearchHistoryMiddleware$ensureHistoryLoaded$lambda$14$$inlined$runOnMainThreadIfNeed$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ String $key$inlined;
    int label;
    final /* synthetic */ SearchHistoryMiddleware this$0;

    public SearchHistoryMiddleware$ensureHistoryLoaded$lambda$14$$inlined$runOnMainThreadIfNeed$1(Continuation r100, SearchHistoryMiddleware r101, String r102) {
        this.this$0 = r101;
        this.$key$inlined = r102;
        super(2, r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new SearchHistoryMiddleware$ensureHistoryLoaded$lambda$14$$inlined$runOnMainThreadIfNeed$1(r101, this.this$0, this.$key$inlined);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super String> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super String> r101) {
        return ((SearchHistoryMiddleware$ensureHistoryLoaded$lambda$14$$inlined$runOnMainThreadIfNeed$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r100);
        String r101 = ((gb6.c) this.this$0.f243582e.getValue()).getString(this.$key$inlined, "");
        if (r101 != null) goto L8;
        return "";
    L8:
        return r101;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
