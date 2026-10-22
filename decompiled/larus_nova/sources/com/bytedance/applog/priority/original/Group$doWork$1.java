package com.bytedance.applog.priority.original;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applog.priority.original.Group", f = "Group.kt", i = {0, 0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_SECURE_BUFFER_THRESHOLD}, m = "doWork", n = {"this", "header"}, s = {"L$0", "L$1"})
final class Group$doWork$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ Group this$0;

    public Group$doWork$1(Group r100, Continuation<? super Group$doWork$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.d(null, 0, this);
    }
}
