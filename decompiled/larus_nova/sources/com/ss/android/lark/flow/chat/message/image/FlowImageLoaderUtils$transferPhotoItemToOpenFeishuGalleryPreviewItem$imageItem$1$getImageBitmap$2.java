package com.ss.android.lark.flow.chat.message.image;

import android.content.Context;
import android.graphics.Bitmap;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.DiskCacheStrategy;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\t\u0018\u00010\u0001¢\u0006\u0002\b\u0002*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Landroid/graphics/Bitmap;", "Lkotlin/jvm/internal/EnhancedNullability;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.flow.chat.message.image.FlowImageLoaderUtils$transferPhotoItemToOpenFeishuGalleryPreviewItem$imageItem$1$getImageBitmap$2", f = "FlowImageLoaderUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class FlowImageLoaderUtils$transferPhotoItemToOpenFeishuGalleryPreviewItem$imageItem$1$getImageBitmap$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ File $file;
    int label;

    public FlowImageLoaderUtils$transferPhotoItemToOpenFeishuGalleryPreviewItem$imageItem$1$getImageBitmap$2(Context r100, File r101, Continuation<? super FlowImageLoaderUtils$transferPhotoItemToOpenFeishuGalleryPreviewItem$imageItem$1$getImageBitmap$2> r102) {
        this.$context = r100;
        this.$file = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new FlowImageLoaderUtils$transferPhotoItemToOpenFeishuGalleryPreviewItem$imageItem$1$getImageBitmap$2(this.$context, this.$file, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Bitmap> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Bitmap> r101) {
        return ((FlowImageLoaderUtils$transferPhotoItemToOpenFeishuGalleryPreviewItem$imageItem$1$getImageBitmap$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        return ImageLoader.with(this.$context).load(this.$file).diskCacheStrategy(DiskCacheStrategy.ALL).getBitmap(Integer.MIN_VALUE, Integer.MIN_VALUE);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
