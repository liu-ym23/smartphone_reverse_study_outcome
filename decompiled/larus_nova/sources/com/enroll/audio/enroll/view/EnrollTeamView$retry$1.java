package com.enroll.audio.enroll.view;

import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.ttm.player.MediaPlayer;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.enroll.audio.enroll.view.EnrollTeamView", f = "EnrollTeamView.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_RTC_HARDWARE_DECODE}, m = EventConstant.Value.RETRY, n = {}, s = {})
public final class EnrollTeamView$retry$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ EnrollTeamView this$0;

    public EnrollTeamView$retry$1(EnrollTeamView r100, Continuation<? super EnrollTeamView$retry$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        EnrollTeamView r101 = this.this$0;
        Lazy<List<Integer>> r102 = EnrollTeamView.F;
        return r101.C6(this);
    }
}
