package com.larus.chat.gallery.impl.preview;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.chat.gallery.impl.preview.OriginalImagePreloader", f = "OriginalImagePreloader.kt", i = {}, l = {50}, m = "awaitReady", n = {}, s = {})
public final class OriginalImagePreloader$awaitReady$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OriginalImagePreloader this$0;

    public OriginalImagePreloader$awaitReady$1(OriginalImagePreloader r100, Continuation<? super OriginalImagePreloader$awaitReady$1> r101) {
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
