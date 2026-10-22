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
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/graphics/Bitmap;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.community.impl.share.SharePuzzleImageItemViewHolder$bind$1$refBitmapDeferred$1", f = "SharePuzzleImageItemViewHolder.kt", i = {}, l = {113}, m = "invokeSuspend", n = {}, s = {})
public final class SharePuzzleImageItemViewHolder$bind$1$refBitmapDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
    final /* synthetic */ m $closeableHolder;
    final /* synthetic */ q $shareImagePuzzleItem;
    int label;
    final /* synthetic */ SharePuzzleImageItemViewHolder this$0;

    public SharePuzzleImageItemViewHolder$bind$1$refBitmapDeferred$1(SharePuzzleImageItemViewHolder r100, q r101, m r102, Continuation<? super SharePuzzleImageItemViewHolder$bind$1$refBitmapDeferred$1> r103) {
        this.this$0 = r100;
        this.$shareImagePuzzleItem = r101;
        this.$closeableHolder = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new SharePuzzleImageItemViewHolder$bind$1$refBitmapDeferred$1(this.this$0, this.$shareImagePuzzleItem, this.$closeableHolder, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Bitmap> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Bitmap> r101) {
        return ((SharePuzzleImageItemViewHolder$bind$1$refBitmapDeferred$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L11:
        return r100;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        SharePuzzleImageItemViewHolder r103 = this.this$0;
        String r104 = this.$shareImagePuzzleItem.f329838b;
        String r105 = "ref:" + this.$shareImagePuzzleItem.f329838b;
        m r106 = this.$closeableHolder;
        this.label = 1;
        r100 = SharePuzzleImageItemViewHolder.T3(r103, r104, r105, r106, this);
        if (r100 != r101) goto L11;
        return r101;
    }
}
