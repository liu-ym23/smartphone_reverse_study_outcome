package com.larus.canvas.feature.component.logic.provider;

import com.bytedance.sdk.bridge.annotation.BridgePrivilege;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.feature.component.logic.provider.CanvasBottomProvider", f = "CanvasBottomProvider.kt", i = {0, 0, 0, 1, 1, 1}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_MIN_RECEIVED_BEFORE_ACK_DECIMATION, MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_MILLISECOND}, m = "setCreationPrivacy", n = {BridgePrivilege.PRIVATE, "previousStatus", "privateStatus", "creationId", "previousStatus", "privateStatus"}, s = {"Z$0", "I$0", "I$1", "L$0", "I$0", "I$1"})
final class CanvasBottomProvider$setCreationPrivacy$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ i this$0;

    public CanvasBottomProvider$setCreationPrivacy$1(i r100, Continuation<? super CanvasBottomProvider$setCreationPrivacy$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return i.z(this.this$0, false, this);
    }
}
