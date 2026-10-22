package com.larus.drive.sdk.impl.preview;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.sdk.impl.preview.AiFilePreviewCoordinator", f = "AiFilePreviewCoordinator.kt", i = {0}, l = {136}, m = "resolveRequest", n = {"request"}, s = {"L$0"})
final class AiFilePreviewCoordinator$resolveRequest$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AiFilePreviewCoordinator this$0;

    public AiFilePreviewCoordinator$resolveRequest$1(AiFilePreviewCoordinator r100, Continuation<? super AiFilePreviewCoordinator$resolveRequest$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return AiFilePreviewCoordinator.c(this.this$0, null, this);
    }
}
