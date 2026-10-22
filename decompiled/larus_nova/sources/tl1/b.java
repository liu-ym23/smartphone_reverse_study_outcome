package tl1;

import android.widget.TextView;
import com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.setting.danmuinterceptor.AbsReplayDanmakuSettingSeekView;
import com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.setting.seekbar.RangeSeekBar;
import com.bytedance.android.livesdk.chatroom.vs_base.base.setting.config.ReplayBarrageSetting;
import io.reactivex.functions.Consumer;
import sh6.c;

/* JADX INFO: loaded from: classes7.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbsReplayDanmakuSettingSeekView f546613a;

    public b(AbsReplayDanmakuSettingSeekView r100) {
        this.f546613a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ReplayBarrageSetting r101 = (ReplayBarrageSetting) c.b((sh6.b) r100);
        if (r101 == null) goto L19;
        int r102 = this.f546613a.S5(r101);
        RangeSeekBar r103 = this.f546613a.f109177b;
        if (r103 == null) goto L7;
        int r104 = r103.getStepCount();
    L8:
        if (r104 <= 0) goto L12;
        RangeSeekBar r105 = this.f546613a.f109177b;
        if (r105 == null) goto L15;
        r105.setStep(r102);
    L15:
        AbsReplayDanmakuSettingSeekView r106 = this.f546613a;
        TextView r107 = r106.f109178c;
        if (r107 == null) goto L20;
        r107.setText(r106.R5(r102));
        return;
    L20:
        return;
    L12:
        RangeSeekBar r108 = this.f546613a.f109177b;
        if (r108 == null) goto L15;
        r108.setProgress(r102);
        goto L15
    L7:
        r104 = 0;
        goto L8
    }
}
