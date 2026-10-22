package com.obric.assistant.settings.autogui;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.settings.autogui.ObricAutoGuiSettingsImpl", f = "ObricAutoGuiSettingsImpl.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_AVUNSYNC_DURATION_MS}, m = "getAutoActionA16UserAvailableApps", n = {}, s = {})
public final class ObricAutoGuiSettingsImpl$getAutoActionA16UserAvailableApps$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ObricAutoGuiSettingsImpl this$0;

    public ObricAutoGuiSettingsImpl$getAutoActionA16UserAvailableApps$1(ObricAutoGuiSettingsImpl r100, Continuation<? super ObricAutoGuiSettingsImpl$getAutoActionA16UserAvailableApps$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(this);
    }
}
