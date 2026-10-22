package com.larus.avlink.e.mock;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.avlink.e.mock.Mode2AutoPlaybackController", f = "Mode2AutoPlaybackController.kt", i = {0}, l = {133}, m = "playOneCycle", n = {"imageUuidList"}, s = {"L$0"})
final class Mode2AutoPlaybackController$playOneCycle$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ l this$0;

    public Mode2AutoPlaybackController$playOneCycle$1(l r100, Continuation<? super Mode2AutoPlaybackController$playOneCycle$1> r101) {
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        int r101 = l.f291819a;
        throw null;
    }
}
