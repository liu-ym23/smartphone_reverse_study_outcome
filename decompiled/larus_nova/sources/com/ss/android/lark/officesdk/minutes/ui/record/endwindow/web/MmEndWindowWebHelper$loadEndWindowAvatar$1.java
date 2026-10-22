package com.ss.android.lark.officesdk.minutes.ui.record.endwindow.web;

import com.baidu.platform.comapi.map.MapController;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.endwindow.web.MmEndWindowWebHelper", f = "MmEndWindowWebHelper.kt", i = {0, 1}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_FRAME_DROPPING_DTS_MAX_DIFF, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_DOWNLOAD_BYTES}, m = "loadEndWindowAvatar", n = {MapController.ITEM_LAYER_TAG, MapController.ITEM_LAYER_TAG}, s = {"L$0", "L$0"})
public final class MmEndWindowWebHelper$loadEndWindowAvatar$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmEndWindowWebHelper this$0;

    public MmEndWindowWebHelper$loadEndWindowAvatar$1(MmEndWindowWebHelper r100, Continuation<? super MmEndWindowWebHelper$loadEndWindowAvatar$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.h(null, 0, this);
    }
}
