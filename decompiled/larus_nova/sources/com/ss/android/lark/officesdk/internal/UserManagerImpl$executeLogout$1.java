package com.ss.android.lark.officesdk.internal;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.internal.UserManagerImpl", f = "UserManagerImpl.kt", i = {0, 0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS}, m = "executeLogout", n = {"command", "uid"}, s = {"L$0", "L$1"})
final class UserManagerImpl$executeLogout$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UserManagerImpl this$0;

    public UserManagerImpl$executeLogout$1(UserManagerImpl r100, Continuation<? super UserManagerImpl$executeLogout$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return UserManagerImpl.c(this.this$0, null, this);
    }
}
