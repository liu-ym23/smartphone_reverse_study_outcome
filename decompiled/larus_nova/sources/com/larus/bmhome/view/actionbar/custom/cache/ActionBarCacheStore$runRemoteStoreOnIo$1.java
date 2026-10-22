package com.larus.bmhome.view.actionbar.custom.cache;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.view.actionbar.custom.cache.ActionBarCacheStore", f = "ActionBarCacheStore.kt", i = {0, 0, 1}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_TCP_FAST_OPEN, 176}, m = "runRemoteStoreOnIo", n = {"block", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$0"})
public final class ActionBarCacheStore$runRemoteStoreOnIo$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ActionBarCacheStore this$0;

    public ActionBarCacheStore$runRemoteStoreOnIo$1(ActionBarCacheStore r100, Continuation<? super ActionBarCacheStore$runRemoteStoreOnIo$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.j(null, this);
    }
}
