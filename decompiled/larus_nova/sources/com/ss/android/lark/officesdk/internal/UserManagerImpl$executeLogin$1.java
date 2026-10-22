package com.ss.android.lark.officesdk.internal;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.internal.UserManagerImpl", f = "UserManagerImpl.kt", i = {0, 0, 1, 2, 2}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_VSYNC_HELPER, MediaPlayer.MEDIA_PLAYER_OPTION_DANGER_BUFFER_THRESHOLD, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_START_INDEX}, m = "executeLogin", n = {"command", "onlineUid", "command", "command", "onlineBeginMs"}, s = {"L$0", "L$1", "L$0", "L$0", "J$0"})
final class UserManagerImpl$executeLogin$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UserManagerImpl this$0;

    public UserManagerImpl$executeLogin$1(UserManagerImpl r100, Continuation<? super UserManagerImpl$executeLogin$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return UserManagerImpl.b(this.this$0, null, this);
    }
}
