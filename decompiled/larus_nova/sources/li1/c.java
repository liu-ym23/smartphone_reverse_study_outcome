package li1;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.ui.y7;
import com.bytedance.android.livesdk.chatroom.ui.z7;
import com.bytedance.android.livesdk.config.i2;
import com.bytedance.android.livesdk.config.y2;
import com.bytedance.android.livesdk.room.Task.api.LiveTaskType;
import com.bytedance.dux.drawable.DoubleColorBallAnimationViewOld;

/* JADX INFO: loaded from: classes7.dex */
public final class c extends com.bytedance.android.livesdk.room.Task.base.a<ls2.d, ls2.c> {
    @Override // gs2.a
    public final String taskID() {
        return "PerformanceUiOptTask";
    }

    @Override // gs2.a
    public final void run() {
        y2 r100 = i2.f120420a.getValue();
        boolean r101 = r100.enable;
        long r102 = r100.delayTime;
        int r103 = z7.f114336a;
        DoubleColorBallAnimationViewOld.setIsOpenInvalidateDelayExp(r101);
        DoubleColorBallAnimationViewOld.setExpDelayTime(r102);
        ALogger.d("LoadingDelayUtil", new y7(r102, r101));
    }

    public c() {
    }

    @Override // gs2.a
    public final LiveTaskType d() {
        return LiveTaskType.MAIN;
    }
}
