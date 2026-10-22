package com.larus.bmhome.chat.standarduikit.localfileblock.remote;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.standarduikit.localfileblock.remote.PcRemoteFileRepository", f = "PcRemoteFileRepository.kt", i = {0, 0, 1, 1, 1, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5}, l = {137, 312, 143, 323, 155, 333, 180, 180}, m = "prepareFile", n = {"key", "request", "key", "request", "$this$withLock_u24default$iv", "key", "request", "key", "url", "directory", com.bytedance.android.ec.core.event.a.KEY_DESTINATION, "saved", "$this$withLock_u24default$iv", "key", "directory", com.bytedance.android.ec.core.event.a.KEY_DESTINATION, "saved", "key", "directory", com.bytedance.android.ec.core.event.a.KEY_DESTINATION, "saved", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4"})
final class PcRemoteFileRepository$prepareFile$2 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PcRemoteFileRepository this$0;

    public PcRemoteFileRepository$prepareFile$2(PcRemoteFileRepository r100, Continuation<? super PcRemoteFileRepository$prepareFile$2> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return PcRemoteFileRepository.b(this.this$0, null, null, this);
    }
}
