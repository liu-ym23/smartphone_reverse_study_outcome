package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow;

import com.baidu.platform.comapi.map.MapController;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.MmRecordingEndWindowRepo$opt$2$1", f = "MmRecordingEndWindowRepo.kt", i = {0, 0, 0, 0, 0}, l = {160}, m = "buildEndWindowSubtitles", n = {"meetingId", "destination$iv$iv", MapController.ITEM_LAYER_TAG, "displaySpeaker", "content"}, s = {"L$0", "L$1", "L$3", "L$4", "L$5"})
public final class MmRecordingEndWindowRepo$opt$2$1$buildEndWindowSubtitles$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmRecordingEndWindowRepo$opt$2.AnonymousClass1 this$0;

    public MmRecordingEndWindowRepo$opt$2$1$buildEndWindowSubtitles$1(MmRecordingEndWindowRepo$opt$2.AnonymousClass1 r100, Continuation<? super MmRecordingEndWindowRepo$opt$2$1$buildEndWindowSubtitles$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.U0(null, null, this);
    }
}
