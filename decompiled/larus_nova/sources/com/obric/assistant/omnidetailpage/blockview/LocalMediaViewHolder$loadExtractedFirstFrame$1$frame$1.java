package com.obric.assistant.omnidetailpage.blockview;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/graphics/Bitmap;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.omnidetailpage.blockview.LocalMediaViewHolder$loadExtractedFirstFrame$1$frame$1", f = "TaskLocalMediaPreviewView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class LocalMediaViewHolder$loadExtractedFirstFrame$1$frame$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
    final /* synthetic */ ifa.c.b $item;
    int label;
    final /* synthetic */ j this$0;

    public LocalMediaViewHolder$loadExtractedFirstFrame$1$frame$1(j r100, ifa.c.b r101, Continuation<? super LocalMediaViewHolder$loadExtractedFirstFrame$1$frame$1> r102) {
        this.this$0 = r100;
        this.$item = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new LocalMediaViewHolder$loadExtractedFirstFrame$1$frame$1(this.this$0, this.$item, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Bitmap> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Bitmap> r101) {
        return ((LocalMediaViewHolder$loadExtractedFirstFrame$1$frame$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L19;
        ResultKt.throwOnFailure(r100);
        j r101 = this.this$0;
        String r102 = this.$item.f489663c;
        int r103 = j.f390632q;
        r101.getClass();
        MediaMetadataRetriever r104 = new MediaMetadataRetriever();
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L7
        r104.setDataSource(r102);     // Catch: Throwable -> L7
        Object r106 = Result.m9449constructorimpl(r104.getFrameAtTime(0, 2));     // Catch: Throwable -> L7
    L10:
        if (Result.m9455isFailureimpl(r106) == false) goto L12;
        r106 = null;
    L12:
        Bitmap r107 = (Bitmap) r106;
        r104.release();     // Catch: Throwable -> L15
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L15
    L17:
        return r107;
    L15:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
