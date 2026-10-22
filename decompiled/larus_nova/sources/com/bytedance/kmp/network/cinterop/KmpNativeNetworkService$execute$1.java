package com.bytedance.kmp.network.cinterop;

import androidx.core.app.NotificationCompat;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(k = 3, mv = {1, 7, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.kmp.network.cinterop.KmpNativeNetworkService", f = "KmpNativeNetworkService.kt", i = {0, 0, 0, 0, 0, 1, 1, 2, 2, 2, 3, 3, 3}, l = {340, 145, MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_STALL_300, MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_STALL_300}, m = "execute", n = {"request", "nativeRequest", NotificationCompat.CATEGORY_CALL, "$this$withLock_u24default$iv", "requestId", "request", "requestId", "request", "$this$withLock_u24default$iv", "requestId", "request", "$this$withLock_u24default$iv", "requestId"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "L$0", "I$0", "L$0", "L$2", "I$0", "L$0", "L$2", "I$0"})
public final class KmpNativeNetworkService$execute$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ KmpNativeNetworkService this$0;

    public KmpNativeNetworkService$execute$1(KmpNativeNetworkService r100, Continuation<? super KmpNativeNetworkService$execute$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.Z1(null, this);
    }
}
