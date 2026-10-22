package com.larus.im.internal.audio.session.v1.sami;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.audio.session.v1.sami.SAMIMediaSession", f = "SAMIMediaSession.kt", i = {}, l = {106}, m = "launchPushStreamTask$suspendImpl", n = {}, s = {})
public final class SAMIMediaSession$launchPushStreamTask$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SAMIMediaSession this$0;

    public SAMIMediaSession$launchPushStreamTask$1(SAMIMediaSession r100, Continuation<? super SAMIMediaSession$launchPushStreamTask$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return SAMIMediaSession.X(this.this$0, this);
    }
}
