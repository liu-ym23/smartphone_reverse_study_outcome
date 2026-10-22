package com.larus.drive.sdk.impl.view.preview;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.sdk.impl.view.preview.AiFilePreviewShareSheet", f = "AiFilePreviewShareSheet.kt", i = {}, l = {166}, m = "resolveShareUrl", n = {}, s = {})
final class AiFilePreviewShareSheet$resolveShareUrl$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AiFilePreviewShareSheet this$0;

    public AiFilePreviewShareSheet$resolveShareUrl$1(AiFilePreviewShareSheet r100, Continuation<? super AiFilePreviewShareSheet$resolveShareUrl$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return AiFilePreviewShareSheet.U90(this.this$0, null, this);
    }
}
