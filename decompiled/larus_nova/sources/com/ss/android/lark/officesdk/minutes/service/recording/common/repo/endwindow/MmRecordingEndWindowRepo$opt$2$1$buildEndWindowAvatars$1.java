package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow;

import com.baidu.platform.comapi.map.MapController;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.MmRecordingEndWindowRepo$opt$2$1", f = "MmRecordingEndWindowRepo.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY, 221}, m = "buildEndWindowAvatars", n = {"subtitles", "meetingId", "avatarList", "avatarUserIdSet", "avatarKeySet", "selfId", "meetingId", "avatarList", "avatarUserIdSet", "avatarKeySet", MapController.ITEM_LAYER_TAG, "displaySpeaker", "avatarUserId", "fakeNameId"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "L$7", "L$8"})
public final class MmRecordingEndWindowRepo$opt$2$1$buildEndWindowAvatars$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmRecordingEndWindowRepo$opt$2.AnonymousClass1 this$0;

    public MmRecordingEndWindowRepo$opt$2$1$buildEndWindowAvatars$1(MmRecordingEndWindowRepo$opt$2.AnonymousClass1 r100, Continuation<? super MmRecordingEndWindowRepo$opt$2$1$buildEndWindowAvatars$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.T0(null, null, this);
    }
}
