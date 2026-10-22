package com.larus.kmp.voice_setting.platform;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.kmp.voice_setting.platform.AndroidVoiceFileGateway", f = "VoicePlatformGateways.android.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_TRAN_CONNECT_TIME}, m = "copyAsset", n = {}, s = {})
public final class AndroidVoiceFileGateway$copyAsset$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AndroidVoiceFileGateway this$0;

    public AndroidVoiceFileGateway$copyAsset$1(AndroidVoiceFileGateway r100, Continuation<? super AndroidVoiceFileGateway$copyAsset$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, null, this);
    }
}
