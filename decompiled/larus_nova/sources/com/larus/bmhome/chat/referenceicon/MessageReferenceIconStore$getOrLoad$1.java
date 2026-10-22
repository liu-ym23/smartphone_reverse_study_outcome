package com.larus.bmhome.chat.referenceicon;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.referenceicon.MessageReferenceIconStore", f = "MessageReferenceIconStore.kt", i = {0, 0, 1, 1}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO, 202}, m = "getOrLoad", n = {"key", "loader", "key", "nonNullSharedLoad"}, s = {"L$0", "L$1", "L$0", "L$1"})
public final class MessageReferenceIconStore$getOrLoad$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MessageReferenceIconStore this$0;

    public MessageReferenceIconStore$getOrLoad$1(MessageReferenceIconStore r100, Continuation<? super MessageReferenceIconStore$getOrLoad$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        MessageReferenceIconStore r101 = this.this$0;
        MessageReferenceIconStore r102 = MessageReferenceIconStore.f308518a;
        return r101.h(null, null, this);
    }
}
