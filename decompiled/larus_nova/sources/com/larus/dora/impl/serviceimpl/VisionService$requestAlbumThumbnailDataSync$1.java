package com.larus.dora.impl.serviceimpl;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.serviceimpl.VisionService", f = "VisionService.kt", i = {0, 0, 0, 0, 0, 0, 0, 1}, l = {270, MediaPlayer.MEDIA_PLAYER_OPTION_READ_MODE}, m = "requestAlbumThumbnailDataSync", n = {"uid", "sessionId", "mediaId", "createTime", "type", "timeout", DBDefinition.RETRY_COUNT, "type"}, s = {"L$0", "L$1", "J$0", "J$1", "B$0", "J$2", "I$0", "B$0"})
public final class VisionService$requestAlbumThumbnailDataSync$1 extends ContinuationImpl {
    byte B$0;
    int I$0;
    long J$0;
    long J$1;
    long J$2;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ VisionService this$0;

    public VisionService$requestAlbumThumbnailDataSync$1(VisionService r100, Continuation<? super VisionService$requestAlbumThumbnailDataSync$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        this.result = r110;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.v(0, 0, (byte) 0, 0, this);
    }
}
