package com.larus.dora.impl.sysinfo;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.sysinfo.DoraSystemInfoManager", f = "DoraSystemInfoManager.kt", i = {0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_STALL_200}, m = "fullUploadSysInfo", n = {"sysInfoList"}, s = {"L$0"})
final class DoraSystemInfoManager$fullUploadSysInfo$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraSystemInfoManager this$0;

    public DoraSystemInfoManager$fullUploadSysInfo$1(DoraSystemInfoManager r100, Continuation<? super DoraSystemInfoManager$fullUploadSysInfo$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return DoraSystemInfoManager.b(this.this$0, this);
    }
}
