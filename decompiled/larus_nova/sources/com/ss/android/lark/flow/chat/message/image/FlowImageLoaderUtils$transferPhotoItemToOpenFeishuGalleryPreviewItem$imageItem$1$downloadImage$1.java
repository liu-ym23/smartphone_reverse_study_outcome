package com.ss.android.lark.flow.chat.message.image;

import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.flow.chat.message.image.FlowImageLoaderUtils$transferPhotoItemToOpenFeishuGalleryPreviewItem$imageItem$1", f = "FlowImageLoaderUtils.kt", i = {0, 0, 1, 2}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_POST_PREPARE, 280, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FFMPEG_LOG_LEVEL}, m = "downloadImage", n = {PerfLog.PARAM_KEY_CONTEXT_ID, "type", "file", "file"}, s = {"L$0", "L$1", "L$0", "L$0"})
final class FlowImageLoaderUtils$transferPhotoItemToOpenFeishuGalleryPreviewItem$imageItem$1$downloadImage$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FlowImageLoaderUtils$transferPhotoItemToOpenFeishuGalleryPreviewItem$imageItem$1 this$0;

    public FlowImageLoaderUtils$transferPhotoItemToOpenFeishuGalleryPreviewItem$imageItem$1$downloadImage$1(FlowImageLoaderUtils$transferPhotoItemToOpenFeishuGalleryPreviewItem$imageItem$1 r100, Continuation<? super FlowImageLoaderUtils$transferPhotoItemToOpenFeishuGalleryPreviewItem$imageItem$1$downloadImage$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, null, this);
    }
}
