package com.larus.im.internal.database.delegate;

import com.ss.android.dypay.api.DyPayConstant;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.database.delegate.ConversationDaoSource", f = "ConversationDaoSource.kt", i = {0, 0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_GET_NETWORK_CONNECT_COUNT}, m = "tryUpdateNew", n = {"conversationId", DyPayConstant.KEY_START_TIME}, s = {"L$0", "J$0"})
public final class ConversationDaoSource$tryUpdateNew$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ConversationDaoSource this$0;

    public ConversationDaoSource$tryUpdateNew$1(ConversationDaoSource r100, Continuation<? super ConversationDaoSource$tryUpdateNew$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        ConversationDaoSource r101 = this.this$0;
        int r102 = ConversationDaoSource.f347923e;
        return r101.y(null, null, this);
    }
}
