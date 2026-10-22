package com.bytedance.sdk.account.identitytoken;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0086@"}, d2 = {"Lcom/bytedance/sdk/account/identitytoken/GetIdentityTokenScene;", "scene", "", "enterFrom", "Lkotlin/coroutines/Continuation;", "Lcom/bytedance/sdk/account/identitytoken/a;", "continuation", "", "getIdentityTokenSuspend"}, k = 3, mv = {1, 4, 0})
@DebugMetadata(c = "com.bytedance.sdk.account.identitytoken.IdentityTokenManager", f = "IdentityTokenManager.kt", i = {0, 0, 0, 0, 0, 0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_PREPARE_CACHE_MS}, m = "getIdentityTokenSuspend", n = {"this", "scene", "enterFrom", "getTokenStart", "getFromCacheResult", "triggerScene"}, s = {"L$0", "L$1", "L$2", "J$0", "L$3", "L$4"})
public final class IdentityTokenManager$getIdentityTokenSuspend$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ IdentityTokenManager this$0;

    public IdentityTokenManager$getIdentityTokenSuspend$1(IdentityTokenManager r100, Continuation r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(null, null, this);
    }
}
