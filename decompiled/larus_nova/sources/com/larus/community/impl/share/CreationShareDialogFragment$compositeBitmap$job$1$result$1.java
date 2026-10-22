package com.larus.community.impl.share;

import android.graphics.Bitmap;
import kotlin.Metadata;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/graphics/Bitmap;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.community.impl.share.CreationShareDialogFragment$compositeBitmap$job$1$result$1", f = "CreationShareDialogFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CreationShareDialogFragment$compositeBitmap$job$1$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
    final /* synthetic */ Bitmap $downloadBitmap;
    final /* synthetic */ Bitmap $refBitmap;
    int label;

    public CreationShareDialogFragment$compositeBitmap$job$1$result$1(Bitmap r100, Bitmap r101, Continuation<? super CreationShareDialogFragment$compositeBitmap$job$1$result$1> r102) {
        this.$downloadBitmap = r100;
        this.$refBitmap = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new CreationShareDialogFragment$compositeBitmap$job$1$result$1(this.$downloadBitmap, this.$refBitmap, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Bitmap> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Bitmap> r101) {
        return ((CreationShareDialogFragment$compositeBitmap$job$1$result$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r100);
        if (this.$downloadBitmap.getWidth() < this.$downloadBitmap.getHeight()) goto L7;
        p r101 = p.f329836a;
        Bitmap r102 = this.$refBitmap;
        Bitmap r103 = this.$downloadBitmap;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "refBitmap");
        Intrinsics.checkNotNullParameter(r103, "rawBitmap");
        return p.c(new n(r102, r103), r103.getWidth(), r103.getHeight(), r103);
    L7:
        p r104 = p.f329836a;
        Bitmap r105 = this.$refBitmap;
        Bitmap r106 = this.$downloadBitmap;
        r104.getClass();
        Intrinsics.checkNotNullParameter(r105, "refBitmap");
        Intrinsics.checkNotNullParameter(r106, "rawBitmap");
        return p.c(new o(r105, r106), r106.getWidth(), r106.getHeight(), r106);
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
