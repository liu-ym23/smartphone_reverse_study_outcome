package com.obric.assistant.performance;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.performance.ObricMemoryUploadServiceImpl", f = "ObricMemoryUploadServiceImpl.kt", i = {0}, l = {151}, m = "uploadMemoryInfoFilesOnce", n = {com.bytedance.android.ec.core.event.a.KEY_DID}, s = {"L$0"})
final class ObricMemoryUploadServiceImpl$uploadMemoryInfoFilesOnce$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ObricMemoryUploadServiceImpl this$0;

    public ObricMemoryUploadServiceImpl$uploadMemoryInfoFilesOnce$1(ObricMemoryUploadServiceImpl r100, Continuation<? super ObricMemoryUploadServiceImpl$uploadMemoryInfoFilesOnce$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return ObricMemoryUploadServiceImpl.b(this.this$0, null, null, this);
    }
}
