package com.larus.dora.impl.ota.g2;

import com.bytedance.map.api.monitor.MapMonitorConst;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.ota.g2.AndroidG2OtaRuntime", f = "G2OtaRuntime.kt", i = {0, 0, 1, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5}, l = {159, 198, 220, 230, 274, MediaPlayer.MEDIA_PLAYER_OPTION_READ_CACHE_MODE}, m = "execute", n = {"effect", "emit", "effect", "effect", "emit", "effect", "emit", "deleted", "discarded", MapMonitorConst.ATTEMPT, "effect", "emit", com.heytap.mcssdk.constant.b.f276361k}, s = {"L$0", "L$1", "L$0", "L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "I$0", "L$0", "L$1", "L$2"})
public final class AndroidG2OtaRuntime$execute$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AndroidG2OtaRuntime this$0;

    public AndroidG2OtaRuntime$execute$1(AndroidG2OtaRuntime r100, Continuation<? super AndroidG2OtaRuntime$execute$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, null, this);
    }
}
