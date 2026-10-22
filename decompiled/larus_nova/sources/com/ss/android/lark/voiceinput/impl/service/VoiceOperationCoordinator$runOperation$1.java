package com.ss.android.lark.voiceinput.impl.service;

import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.voiceinput.impl.service.VoiceOperationCoordinator", f = "VoiceOperationCoordinator.kt", i = {0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_FIRST_PACKET_TIME}, m = "runOperation", n = {WikiFolderPushPlugin.OPT}, s = {"L$0"})
final class VoiceOperationCoordinator$runOperation$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ VoiceOperationCoordinator this$0;

    public VoiceOperationCoordinator$runOperation$1(VoiceOperationCoordinator r100, Continuation<? super VoiceOperationCoordinator$runOperation$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return VoiceOperationCoordinator.a(this.this$0, null, this);
    }
}
