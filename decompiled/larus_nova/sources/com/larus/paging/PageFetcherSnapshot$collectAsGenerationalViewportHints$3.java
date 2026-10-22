package com.larus.paging;

import com.byted.cast.common.TeaEventTrack;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u008a@"}, d2 = {"", "Key", "Value", "Lcom/larus/paging/o;", "previous", TeaEventTrack.ACTION_DRAMA_NEXT, "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.larus.paging.PageFetcherSnapshot$collectAsGenerationalViewportHints$3", f = "PageFetcherSnapshot.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class PageFetcherSnapshot$collectAsGenerationalViewportHints$3 extends SuspendLambda implements Function3<o, o, Continuation<? super o>, Object> {
    final /* synthetic */ LoadType $loadType;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    public PageFetcherSnapshot$collectAsGenerationalViewportHints$3(LoadType r100, Continuation<? super PageFetcherSnapshot$collectAsGenerationalViewportHints$3> r101) {
        this.$loadType = r100;
        super(3, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(o r100, o r101, Continuation<? super o> r102) {
        PageFetcherSnapshot$collectAsGenerationalViewportHints$3 r103 = new PageFetcherSnapshot$collectAsGenerationalViewportHints$3(this.$loadType, r102);
        r103.L$0 = r100;
        r103.L$1 = r101;
        return r103.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(o r100, o r101, Continuation<? super o> r102) {
        return invoke2(r100, r101, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r100);
        o r101 = (o) this.L$0;
        o r102 = (o) this.L$1;
        LoadType r103 = this.$loadType;
        Intrinsics.checkNotNullParameter(r102, "<this>");
        Intrinsics.checkNotNullParameter(r101, "previous");
        Intrinsics.checkNotNullParameter(r103, "loadType");
        int r104 = r102.f363901a;
        int r105 = r101.f363901a;
        if (r104 <= r105) goto L7;
        boolean r106 = true;
    L10:
        if (r106 == true) goto L12;
        return r101;
    L12:
        return r102;
    L7:
        if (r104 >= r105) goto L9;
        r106 = false;
        goto L10
    L9:
        r106 = q.a(r102.f363902b, r101.f363902b, r103);
        goto L10
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
