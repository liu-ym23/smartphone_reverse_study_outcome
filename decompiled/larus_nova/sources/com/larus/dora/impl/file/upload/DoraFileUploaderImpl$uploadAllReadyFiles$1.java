package com.larus.dora.impl.file.upload;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.file.upload.DoraFileUploaderImpl", f = "DoraFileUploaderImpl.kt", i = {0, 0}, l = {109}, m = "uploadAllReadyFiles", n = {"trigger", "task"}, s = {"L$0", "L$2"})
final class DoraFileUploaderImpl$uploadAllReadyFiles$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraFileUploaderImpl this$0;

    public DoraFileUploaderImpl$uploadAllReadyFiles$1(DoraFileUploaderImpl r100, Continuation<? super DoraFileUploaderImpl$uploadAllReadyFiles$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return DoraFileUploaderImpl.b(this.this$0, null, this);
    }
}
