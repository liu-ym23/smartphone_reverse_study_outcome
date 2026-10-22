package com.larus.uploader.impl.preheat;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.uploader.impl.preheat.ImageUploadPreheatServiceImpl", f = "ImageUploadPreheatServiceImpl.kt", i = {0, 0, 0, 0, 0}, l = {71}, m = "preheat", n = {"uid", "uploader", "targetCount", "threshold", "startAt"}, s = {"L$0", "L$1", "I$0", "I$1", "J$0"})
final class ImageUploadPreheatServiceImpl$preheat$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ImageUploadPreheatServiceImpl this$0;

    public ImageUploadPreheatServiceImpl$preheat$1(ImageUploadPreheatServiceImpl r100, Continuation<? super ImageUploadPreheatServiceImpl$preheat$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(0, 0, null, null, this);
    }
}
