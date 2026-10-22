package com.larus.avlink.gallery.thumbnail;

import com.ss.ttvideoengine.TTVideoEngineInterface;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.avlink.gallery.thumbnail.ThumbnailManager", f = "ThumbnailManager.kt", i = {0, 0, 1}, l = {TTVideoEngineInterface.PLAYER_OPTION_HW_ENABLE_DYNAMIC_FRAME_DROPPING, TTVideoEngineInterface.PLAYER_OPTION_HW_DYNAMIC_FRAME_DROPPING_CHECK_PERIOD}, m = "deleteThumbnail", n = {"sn", "imageUuid", "imageUuid"}, s = {"L$0", "J$0", "J$0"})
public final class ThumbnailManager$deleteThumbnail$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ThumbnailManager this$0;

    public ThumbnailManager$deleteThumbnail$1(ThumbnailManager r100, Continuation<? super ThumbnailManager$deleteThumbnail$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.i(0, null, this);
    }
}
