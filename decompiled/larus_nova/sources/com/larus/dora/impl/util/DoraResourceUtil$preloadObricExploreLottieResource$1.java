package com.larus.dora.impl.util;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.util.DoraResourceUtil", f = "DoraResourceUtil.kt", i = {}, l = {170}, m = "preloadObricExploreLottieResource", n = {}, s = {})
final class DoraResourceUtil$preloadObricExploreLottieResource$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraResourceUtil this$0;

    public DoraResourceUtil$preloadObricExploreLottieResource$1(DoraResourceUtil r100, Continuation<? super DoraResourceUtil$preloadObricExploreLottieResource$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return DoraResourceUtil.a(this.this$0, this);
    }
}
