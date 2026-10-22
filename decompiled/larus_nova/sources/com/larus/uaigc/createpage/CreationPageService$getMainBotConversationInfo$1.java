package com.larus.uaigc.createpage;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.uaigc.createpage.CreationPageService", f = "CreationPageService.kt", i = {0, 1}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_NOTIFY_ALL_SEI_THRESHOLD, 372, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_DECODE_MS_GAPS}, m = "getMainBotConversationInfo", n = {"callback", "callback"}, s = {"L$0", "L$0"})
public final class CreationPageService$getMainBotConversationInfo$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CreationPageService this$0;

    public CreationPageService$getMainBotConversationInfo$1(CreationPageService r100, Continuation<? super CreationPageService$getMainBotConversationInfo$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.i(null, this);
    }
}
