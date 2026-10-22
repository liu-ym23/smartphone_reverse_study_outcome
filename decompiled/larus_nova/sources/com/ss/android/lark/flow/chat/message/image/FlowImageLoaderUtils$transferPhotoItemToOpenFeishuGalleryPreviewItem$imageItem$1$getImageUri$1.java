package com.ss.android.lark.flow.chat.message.image;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.flow.chat.message.image.FlowImageLoaderUtils$transferPhotoItemToOpenFeishuGalleryPreviewItem$imageItem$1", f = "FlowImageLoaderUtils.kt", i = {}, l = {262}, m = "getImageUri", n = {}, s = {})
public final class FlowImageLoaderUtils$transferPhotoItemToOpenFeishuGalleryPreviewItem$imageItem$1$getImageUri$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FlowImageLoaderUtils$transferPhotoItemToOpenFeishuGalleryPreviewItem$imageItem$1 this$0;

    public FlowImageLoaderUtils$transferPhotoItemToOpenFeishuGalleryPreviewItem$imageItem$1$getImageUri$1(FlowImageLoaderUtils$transferPhotoItemToOpenFeishuGalleryPreviewItem$imageItem$1 r100, Continuation<? super FlowImageLoaderUtils$transferPhotoItemToOpenFeishuGalleryPreviewItem$imageItem$1$getImageUri$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, false, this);
    }
}
