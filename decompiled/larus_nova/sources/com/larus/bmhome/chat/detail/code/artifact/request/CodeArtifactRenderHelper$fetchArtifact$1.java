package com.larus.bmhome.chat.detail.code.artifact.request;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.detail.code.artifact.request.CodeArtifactRenderHelper", f = "CodeArtifactRenderHelper.kt", i = {}, l = {39}, m = "fetchArtifact", n = {}, s = {})
final class CodeArtifactRenderHelper$fetchArtifact$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ a this$0;

    public CodeArtifactRenderHelper$fetchArtifact$1(a r100, Continuation<? super CodeArtifactRenderHelper$fetchArtifact$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return a.a(this.this$0, 0, null, this);
    }
}
