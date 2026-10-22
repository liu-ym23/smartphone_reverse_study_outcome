package com.larus.dora.impl.file.upload;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.file.upload.DoraFileUploaderImpl", f = "DoraFileUploaderImpl.kt", i = {0, 0}, l = {133}, m = "upload", n = {"task", "trigger"}, s = {"L$0", "L$1"})
public final class DoraFileUploaderImpl$upload$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraFileUploaderImpl this$0;

    public DoraFileUploaderImpl$upload$1(DoraFileUploaderImpl r100, Continuation<? super DoraFileUploaderImpl$upload$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, null, this);
    }
}
