package com.larus.disk.impl;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.disk.impl.IAppDiskServiceImpl", f = "IAppDiskServiceImpl.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_PREPARE_CACHE_MS, MediaPlayer.MEDIA_PLAYER_OPTION_HANDLE_AUDIO_EXTRADATA}, m = "getManualCacheSize", n = {}, s = {})
public final class IAppDiskServiceImpl$getManualCacheSize$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ IAppDiskServiceImpl this$0;

    public IAppDiskServiceImpl$getManualCacheSize$1(IAppDiskServiceImpl r100, Continuation<? super IAppDiskServiceImpl$getManualCacheSize$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(this);
    }
}
