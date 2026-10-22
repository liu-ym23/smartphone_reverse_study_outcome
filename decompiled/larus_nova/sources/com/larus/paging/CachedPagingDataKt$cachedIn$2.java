package com.larus.paging;

import androidx.exifinterface.media.ExifInterface;
import com.byted.cast.common.TeaEventTrack;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\b\b\u0000\u0010\u0001*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u008a@"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/larus/paging/w;", "prev", TeaEventTrack.ACTION_DRAMA_NEXT, "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.larus.paging.CachedPagingDataKt$cachedIn$2", f = "CachedPagingData.kt", i = {0}, l = {99}, m = "invokeSuspend", n = {TeaEventTrack.ACTION_DRAMA_NEXT}, s = {"L$0"})
final class CachedPagingDataKt$cachedIn$2 extends SuspendLambda implements Function3<w<Object>, w<Object>, Continuation<? super w<Object>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    public CachedPagingDataKt$cachedIn$2(Continuation<? super CachedPagingDataKt$cachedIn$2> r100) {
        super(3, r100);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(w<Object> r100, w<Object> r101, Continuation<? super w<Object>> r102) {
        CachedPagingDataKt$cachedIn$2 r103 = new CachedPagingDataKt$cachedIn$2(r102);
        r103.L$0 = r100;
        r103.L$1 = r101;
        return r103.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(w<Object> r100, w<Object> r101, Continuation<? super w<Object>> r102) {
        return invoke2(r100, r101, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        w r103 = (w) this.L$0;
        ResultKt.throwOnFailure(r100);
        return r103;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        w r104 = (w) this.L$0;
        w r105 = (w) this.L$1;
        this.L$0 = r105;
        this.label = 1;
        Job.DefaultImpls.cancel$default(r104.f363931c.f363833d, null, 1, null);
        if (Unit.INSTANCE != r101) goto L12;
        return r101;
    L12:
        return r105;
    }
}
