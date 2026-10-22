package com.bytedance.applog.priority.original;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applog.priority.original.AppSession", f = "AppSession.kt", i = {0, 0, 1, 1, 2}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_KEEP_FORMAT_THREAD_ALIVE, 301, 310}, m = "packHistorySessionEventsExcludeSession", n = {"this", "sessionId", "this", "sessionId", "this"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0"})
public final class AppSession$packHistorySessionEventsExcludeSession$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AppSession this$0;

    public AppSession$packHistorySessionEventsExcludeSession$1(AppSession r100, Continuation<? super AppSession$packHistorySessionEventsExcludeSession$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(null, this);
    }
}
