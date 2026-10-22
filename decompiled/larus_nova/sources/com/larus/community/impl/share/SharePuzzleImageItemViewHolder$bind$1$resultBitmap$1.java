package com.larus.community.impl.share;

import android.graphics.Bitmap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/graphics/Bitmap;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.community.impl.share.SharePuzzleImageItemViewHolder$bind$1$resultBitmap$1", f = "SharePuzzleImageItemViewHolder.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class SharePuzzleImageItemViewHolder$bind$1$resultBitmap$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
    final /* synthetic */ Bitmap $rawBitmap;
    final /* synthetic */ Bitmap $refBitmap;
    private /* synthetic */ Object L$0;
    int label;

    public SharePuzzleImageItemViewHolder$bind$1$resultBitmap$1(Bitmap r100, Bitmap r101, Continuation<? super SharePuzzleImageItemViewHolder$bind$1$resultBitmap$1> r102) {
        this.$rawBitmap = r100;
        this.$refBitmap = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        SharePuzzleImageItemViewHolder$bind$1$resultBitmap$1 r102 = new SharePuzzleImageItemViewHolder$bind$1$resultBitmap$1(this.$rawBitmap, this.$refBitmap, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Bitmap> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Bitmap> r101) {
        return ((SharePuzzleImageItemViewHolder$bind$1$resultBitmap$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L19;
        ResultKt.throwOnFailure(r100);
        CoroutineScope r101 = (CoroutineScope) this.L$0;
        Bitmap r102 = this.$rawBitmap;
        Bitmap r103 = this.$refBitmap;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L12
        if (r102.getWidth() < r102.getHeight()) goto L9;
        p.f329836a.getClass();     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r103, "refBitmap");     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r102, "rawBitmap");     // Catch: Throwable -> L12
        Bitmap r105 = p.c(new n(r103, r102), r102.getWidth(), r102.getHeight(), r102);     // Catch: Throwable -> L12
    L10:
        Object r106 = Result.m9449constructorimpl(r105);     // Catch: Throwable -> L12
    L15:
        if (Result.m9455isFailureimpl(r106) == false) goto L22;
        return null;
    L22:
        return r106;
    L9:
        p.f329836a.getClass();     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r103, "refBitmap");     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r102, "rawBitmap");     // Catch: Throwable -> L12
        r105 = p.c(new o(r103, r102), r102.getWidth(), r102.getHeight(), r102);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
