package com.obric.assistant.authenticationsession;

import com.ss.android.dypay.api.DyPayConstant;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.authenticationsession.SessionAuthenticationServiceImpl", f = "SessionAuthenticationServiceImpl.kt", i = {0, 0, 0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_GET_PLAYER_REQ_OFFSET}, m = "waitForAiFingerprintUnlock", n = {"cancellationSignal", DyPayConstant.KEY_START_TIME, "checkCount"}, s = {"L$0", "J$0", "I$0"})
final class SessionAuthenticationServiceImpl$waitForAiFingerprintUnlock$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SessionAuthenticationServiceImpl this$0;

    public SessionAuthenticationServiceImpl$waitForAiFingerprintUnlock$1(SessionAuthenticationServiceImpl r100, Continuation<? super SessionAuthenticationServiceImpl$waitForAiFingerprintUnlock$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return SessionAuthenticationServiceImpl.a(this.this$0, null, this);
    }
}
