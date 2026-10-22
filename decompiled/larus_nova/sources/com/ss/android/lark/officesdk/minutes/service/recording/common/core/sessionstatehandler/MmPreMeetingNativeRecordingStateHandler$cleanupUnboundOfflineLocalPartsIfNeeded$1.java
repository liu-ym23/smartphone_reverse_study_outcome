package com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler;

import com.ss.ttvideoengine.TTVideoEngineInterface;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.MmPreMeetingNativeRecordingStateHandler", f = "MmPreMeetingNativeRecordingStateHandler.kt", i = {1, 1}, l = {962, TTVideoEngineInterface.PLAYER_OPTION_MC_MAX_WIDTH}, m = "cleanupUnboundOfflineLocalPartsIfNeeded", n = {"sessionKey", "isD1204OfflineLocalRecording"}, s = {"L$0", "Z$0"})
public final class MmPreMeetingNativeRecordingStateHandler$cleanupUnboundOfflineLocalPartsIfNeeded$1 extends ContinuationImpl {
    Object L$0;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmPreMeetingNativeRecordingStateHandler this$0;

    public MmPreMeetingNativeRecordingStateHandler$cleanupUnboundOfflineLocalPartsIfNeeded$1(MmPreMeetingNativeRecordingStateHandler r100, Continuation<? super MmPreMeetingNativeRecordingStateHandler$cleanupUnboundOfflineLocalPartsIfNeeded$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.i(this);
    }
}
