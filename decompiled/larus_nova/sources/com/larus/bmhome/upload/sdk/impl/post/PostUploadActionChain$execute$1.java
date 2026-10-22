package com.larus.bmhome.upload.sdk.impl.post;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.upload.sdk.impl.post.PostUploadActionChain", f = "PostUploadAction.kt", i = {}, l = {58}, m = "execute", n = {}, s = {})
public final class PostUploadActionChain$execute$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PostUploadActionChain this$0;

    public PostUploadActionChain$execute$1(PostUploadActionChain r100, Continuation<? super PostUploadActionChain$execute$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, this);
    }
}
