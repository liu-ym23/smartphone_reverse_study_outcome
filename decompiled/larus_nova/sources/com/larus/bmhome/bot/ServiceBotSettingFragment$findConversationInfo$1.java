package com.larus.bmhome.bot;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.bot.ServiceBotSettingFragment", f = "ServiceBotSettingFragment.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HTTP_REQ_FINSIH_TIME}, m = "findConversationInfo", n = {}, s = {})
final class ServiceBotSettingFragment$findConversationInfo$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ServiceBotSettingFragment this$0;

    public ServiceBotSettingFragment$findConversationInfo$1(ServiceBotSettingFragment r100, Continuation<? super ServiceBotSettingFragment$findConversationInfo$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return ServiceBotSettingFragment.U90(this.this$0, null, this);
    }
}
