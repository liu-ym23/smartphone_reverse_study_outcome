package com.obric.assistant.zeus.plugin;

import com.ss.android.dypay.api.DyPayConstant;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.zeus.plugin.ZeusPluginServiceImpl", f = "ZeusPluginServiceImpl.kt", i = {0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_TRAN_CONNECT_TIME}, m = "preInstallPlugin", n = {DyPayConstant.KEY_START_TIME}, s = {"J$0"})
public final class ZeusPluginServiceImpl$preInstallPlugin$1 extends ContinuationImpl {
    long J$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ZeusPluginServiceImpl this$0;

    public ZeusPluginServiceImpl$preInstallPlugin$1(ZeusPluginServiceImpl r100, Continuation<? super ZeusPluginServiceImpl$preInstallPlugin$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.g(null, 0, this);
    }
}
