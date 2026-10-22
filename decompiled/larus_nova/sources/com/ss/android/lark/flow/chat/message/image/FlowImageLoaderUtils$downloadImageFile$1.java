package com.ss.android.lark.flow.chat.message.image;

import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.flow.chat.message.image.FlowImageLoaderUtils", f = "FlowImageLoaderUtils.kt", i = {0, 0, 0, 0}, l = {372, MediaPlayer.MEDIA_PLAYER_OPTION_QUEUE_MAX_FULL}, m = "downloadImageFile", n = {PerfLog.PARAM_KEY_CONTEXT_ID, "type", "photoItem", "isOnlyCache"}, s = {"L$0", "L$1", "L$2", "Z$0"})
final class FlowImageLoaderUtils$downloadImageFile$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ f this$0;

    public FlowImageLoaderUtils$downloadImageFile$1(f r100, Continuation<? super FlowImageLoaderUtils$downloadImageFile$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return f.a(this.this$0, null, null, null, false, this);
    }
}
