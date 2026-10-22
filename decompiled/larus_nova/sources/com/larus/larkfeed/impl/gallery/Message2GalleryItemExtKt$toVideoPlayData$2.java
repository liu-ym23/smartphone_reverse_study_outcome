package com.larus.larkfeed.impl.gallery;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.larkfeed.impl.gallery.Message2GalleryItemExtKt$toVideoPlayData$2", f = "Message2GalleryItemExt.kt", i = {}, l = {133, 133}, m = "invokeSuspend", n = {}, s = {})
public final class Message2GalleryItemExtKt$toVideoPlayData$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends String, ? extends String>>, Object> {
    final /* synthetic */ kza.p $this_toVideoPlayData;
    Object L$0;
    int label;

    public Message2GalleryItemExtKt$toVideoPlayData$2(kza.p r100, Continuation<? super Message2GalleryItemExtKt$toVideoPlayData$2> r101) {
        this.$this_toVideoPlayData = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new Message2GalleryItemExtKt$toVideoPlayData$2(this.$this_toVideoPlayData, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Pair<? extends String, ? extends String>> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Pair<String, String>> r101) {
        return ((Message2GalleryItemExtKt$toVideoPlayData$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        String r103 = null;
        if (r102 == 0) goto L10;
        if (r102 == 1) goto L9;
        if (r102 != 2) goto L8;
        String r104 = (String) this.L$0;
        ResultKt.throwOnFailure(r100);
    L23:
        r103 = (String) r100;
        String r105 = r104;
    L25:
        return TuplesKt.to(r105, r103);
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r100);
    L15:
        r105 = (String) r100;
    L17:
        Function1<? super Continuation<? super String>, ? extends Object> r106 = this.$this_toVideoPlayData.f506806j;
        if (r106 == null) goto L25;
        this.L$0 = r105;
        this.label = 2;
        Object r107 = r106.invoke(this);
        if (r107 != r101) goto L22;
        return r101;
    L22:
        r104 = r105;
        r100 = r107;
        goto L23
    L10:
        ResultKt.throwOnFailure(r100);
        Function1<? super Continuation<? super String>, ? extends Object> r108 = this.$this_toVideoPlayData.f506799c;
        if (r108 == null) goto L16;
        this.label = 1;
        r100 = r108.invoke(this);
        if (r100 != r101) goto L15;
        return r101;
    L16:
        r105 = null;
        goto L17
    }
}
