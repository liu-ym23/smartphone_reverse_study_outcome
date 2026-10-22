package com.larus.photopicker.v2.impl.data;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.photopicker.v2.impl.data.MediaRepositoryImpl", f = "MediaRepositoryImpl.kt", i = {}, l = {50}, m = "fastLoadMediaItems", n = {}, s = {})
public final class MediaRepositoryImpl$fastLoadMediaItems$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MediaRepositoryImpl this$0;

    public MediaRepositoryImpl$fastLoadMediaItems$1(MediaRepositoryImpl r100, Continuation<? super MediaRepositoryImpl$fastLoadMediaItems$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.f(0, 0, null, this);
    }
}
