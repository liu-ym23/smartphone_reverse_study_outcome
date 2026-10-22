package com.larus.livetutor.impl.repository;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.livetutor.impl.repository.LiveTutorApi$Companion", f = "LiveTutorApi.kt", i = {}, l = {58}, m = "safeCall", n = {}, s = {})
public final class LiveTutorApi$Companion$safeCall$1<T> extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LiveTutorApi.Companion this$0;

    public LiveTutorApi$Companion$safeCall$1(LiveTutorApi.Companion r100, Continuation<? super LiveTutorApi$Companion$safeCall$1> r101) {
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
