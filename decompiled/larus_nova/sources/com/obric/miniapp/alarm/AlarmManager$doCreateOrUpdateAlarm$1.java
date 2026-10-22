package com.obric.miniapp.alarm;

import com.bytedance.android.shopping.yata.business.ability.common.TriggerTiming;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.miniapp.alarm.AlarmManager", f = "AlarmManager.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 3}, l = {218, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_FIRST_PACKET_TIME, 274, MediaPlayer.MEDIA_PLAYER_OPTION_SKIP_BUFFER_LIMIT, 301, 307}, m = "doCreateOrUpdateAlarm", n = {"id", "title", "content", "triggerTime", "extraInfo", TriggerTiming.NOW, "intervalMinutes", "repeatCount", "oldAlarm", "oldAlarm"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "J$0", "I$0", "L$0", "L$0"})
final class AlarmManager$doCreateOrUpdateAlarm$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AlarmManager this$0;

    public AlarmManager$doCreateOrUpdateAlarm$1(AlarmManager r100, Continuation<? super AlarmManager$doCreateOrUpdateAlarm$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        this.result = r110;
        this.label |= Integer.MIN_VALUE;
        return AlarmManager.a(this.this$0, null, null, null, null, null, 0, 0, this);
    }
}
