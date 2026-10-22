package com.larus.dora.impl.serviceimpl;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.serviceimpl.VisionService", f = "VisionService.kt", i = {0, 0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_START_INDEX, 304}, m = "requestAlbumListSync", n = {"uid", DBDefinition.RETRY_COUNT}, s = {"L$0", "I$0"})
public final class VisionService$requestAlbumListSync$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ VisionService this$0;

    public VisionService$requestAlbumListSync$1(VisionService r100, Continuation<? super VisionService$requestAlbumListSync$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.u(this);
    }
}
