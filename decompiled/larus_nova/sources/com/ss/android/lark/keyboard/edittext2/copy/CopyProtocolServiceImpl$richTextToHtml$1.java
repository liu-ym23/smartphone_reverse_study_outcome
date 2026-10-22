package com.ss.android.lark.keyboard.edittext2.copy;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.keyboard.edittext2.copy.CopyProtocolServiceImpl", f = "CopyProtocolServiceImpl.kt", i = {}, l = {52}, m = "richTextToHtml", n = {}, s = {})
public final class CopyProtocolServiceImpl$richTextToHtml$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CopyProtocolServiceImpl this$0;

    public CopyProtocolServiceImpl$richTextToHtml$1(CopyProtocolServiceImpl r100, Continuation<? super CopyProtocolServiceImpl$richTextToHtml$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, null, this);
    }
}
