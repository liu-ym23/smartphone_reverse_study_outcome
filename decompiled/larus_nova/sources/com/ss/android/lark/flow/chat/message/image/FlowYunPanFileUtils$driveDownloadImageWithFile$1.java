package com.ss.android.lark.flow.chat.message.image;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.flow.chat.message.image.FlowYunPanFileUtils", f = "FlowYunPanFileUtils.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_PRE_DECODE_AUTO_PAUSE}, m = "driveDownloadImageWithFile", n = {}, s = {})
public final class FlowYunPanFileUtils$driveDownloadImageWithFile$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FlowYunPanFileUtils this$0;

    public FlowYunPanFileUtils$driveDownloadImageWithFile$1(FlowYunPanFileUtils r100, Continuation<? super FlowYunPanFileUtils$driveDownloadImageWithFile$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.f(null, null, this);
    }
}
