package com.ss.android.lark.officesdk.minutes.service.recording.hardware;

import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.hardware.HardwareRecordingManager", f = "HardwareRecordingManager.kt", i = {0, 0, 1, 1, 2, 2}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_RTC_ENABLE_RTC_UNINIT_LOCK_FREE, MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_HTTP_REQ_FINISH_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_HTTP_REQ_FINISH_TIME}, m = "onVcMicMuted", n = {"$this$withLock_u24default$iv", "isMuted", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "isMuted", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "isMuted"}, s = {"L$0", "Z$0", "L$0", "Z$0", "L$0", "Z$0"})
final class HardwareRecordingManager$onVcMicMuted$1 extends ContinuationImpl {
    Object L$0;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ d this$0;

    public HardwareRecordingManager$onVcMicMuted$1(d r100, Continuation<? super HardwareRecordingManager$onVcMicMuted$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.f(false, this);
    }
}
