package com.larus.image.loader;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.image.loader.ImageLoaderKt", f = "ImageLoader.kt", i = {0, 0}, l = {522}, m = "getImageUri", n = {"metric", "tag"}, s = {"L$0", "L$1"})
public final class ImageLoaderKt$getImageUri$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    public ImageLoaderKt$getImageUri$1(Continuation<? super ImageLoaderKt$getImageUri$1> r100) {
        super(r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return ImageLoaderKt.q(null, null, null, this);
    }
}
