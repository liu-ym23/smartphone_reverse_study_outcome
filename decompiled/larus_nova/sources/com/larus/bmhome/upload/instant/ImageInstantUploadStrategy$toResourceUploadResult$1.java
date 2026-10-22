package com.larus.bmhome.upload.instant;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.upload.instant.ImageInstantUploadStrategy", f = "ImageInstantUploadStrategy.kt", i = {0}, l = {351}, m = "toResourceUploadResult", n = {"registerInfo"}, s = {"L$0"})
public final class ImageInstantUploadStrategy$toResourceUploadResult$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ImageInstantUploadStrategy this$0;

    public ImageInstantUploadStrategy$toResourceUploadResult$1(ImageInstantUploadStrategy r100, Continuation<? super ImageInstantUploadStrategy$toResourceUploadResult$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        ImageInstantUploadStrategy r101 = this.this$0;
        ImageInstantUploadStrategy r102 = ImageInstantUploadStrategy.f314769a;
        return r101.n(null, null, null, this);
    }
}
