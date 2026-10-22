package com.larus.dora.impl.serviceimpl;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.serviceimpl.VisionService", f = "VisionService.kt", i = {0, 0, 0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CHECK_PACKET_CORRUPT, 320}, m = "deleteAlbum", n = {"mediaIds", "createTimes", "uid"}, s = {"L$0", "L$1", "L$2"})
public final class VisionService$deleteAlbum$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ VisionService this$0;

    public VisionService$deleteAlbum$1(VisionService r100, Continuation<? super VisionService$deleteAlbum$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.j(null, null, null, this);
    }
}
