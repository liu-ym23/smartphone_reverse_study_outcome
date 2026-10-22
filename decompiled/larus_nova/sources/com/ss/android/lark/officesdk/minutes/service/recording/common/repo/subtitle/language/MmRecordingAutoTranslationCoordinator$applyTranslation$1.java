package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.MmRecordingAutoTranslationCoordinator", f = "MmRecordingAutoTranslationCoordinator.kt", i = {0}, l = {245, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HTTP_REQ_FINSIH_TIME}, m = "applyTranslation", n = {"action"}, s = {"L$0"})
public final class MmRecordingAutoTranslationCoordinator$applyTranslation$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmRecordingAutoTranslationCoordinator this$0;

    public MmRecordingAutoTranslationCoordinator$applyTranslation$1(MmRecordingAutoTranslationCoordinator r100, Continuation<? super MmRecordingAutoTranslationCoordinator$applyTranslation$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        MmRecordingAutoTranslationCoordinator r101 = this.this$0;
        int r102 = MmRecordingAutoTranslationCoordinator.f435254k;
        return r101.c(null, this);
    }
}
