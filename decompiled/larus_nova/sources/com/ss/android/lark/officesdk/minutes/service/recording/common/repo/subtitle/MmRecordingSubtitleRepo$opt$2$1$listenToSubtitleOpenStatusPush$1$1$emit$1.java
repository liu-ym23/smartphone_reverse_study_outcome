package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.MmRecordingSubtitleRepo$opt$2$1$listenToSubtitleOpenStatusPush$1$1", f = "MmRecordingSubtitleRepo.kt", i = {2, 2, 3, 3}, l = {793, 794, 797, 798, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_ANSWER_RECV_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_START_TIME}, m = "emit", n = {"response", "source", "response", "source"}, s = {"L$0", "L$1", "L$0", "L$1"})
public final class MmRecordingSubtitleRepo$opt$2$1$listenToSubtitleOpenStatusPush$1$1$emit$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmRecordingSubtitleRepo$opt$2$1$listenToSubtitleOpenStatusPush$1.AnonymousClass1<T> this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public MmRecordingSubtitleRepo$opt$2$1$listenToSubtitleOpenStatusPush$1$1$emit$1(MmRecordingSubtitleRepo$opt$2$1$listenToSubtitleOpenStatusPush$1.AnonymousClass1<? super T> r100, Continuation<? super MmRecordingSubtitleRepo$opt$2$1$listenToSubtitleOpenStatusPush$1$1$emit$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type kotlin.coroutines.Continuation to com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.MmRecordingSubtitleRepo$opt$2$1$listenToSubtitleOpenStatusPush$1$1$emit$1 for r1v1 'this'  kotlin.coroutines.Continuation
        	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
        	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
        	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r2) {
        r1.result = r2;
        int r2 = r1.label;
        int r2 = r2 | Integer.MIN_VALUE;
        r1.label = r2;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.MmRecordingSubtitleRepo$opt$2$1$listenToSubtitleOpenStatusPush$1.AnonymousClass1<T> r2 = r1.this$0;
        kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation<? super kotlin.Unit>) r1;
        java.lang.Object r2 = r2.a(null, r1);
        return r2;
    }
}
