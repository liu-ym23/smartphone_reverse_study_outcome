package tl1;

import android.widget.TextView;
import com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.setting.ReplayBarrageSettingDataContext;
import com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.setting.danmuinterceptor.AbsReplayDanmakuSettingSeekView;
import com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.setting.seekbar.RangeSeekBar;
import com.bytedance.android.livesdk.chatroom.vs_base.base.setting.config.ReplayBarrageSetting;
import com.bytedance.android.livesdk.sharedpref.e;
import com.bytedance.android.livesdk.sharedpref.f;
import com.bytedance.live.datacontext.n;
import kotlin.jvm.internal.Intrinsics;
import nq1.d;

/* JADX INFO: loaded from: classes7.dex */
public final class a implements ul1.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbsReplayDanmakuSettingSeekView f546612a;

    @Override // ul1.a
    public final void a() {
    }

    @Override // ul1.a
    public final void b() {
        ReplayBarrageSettingDataContext r100 = ReplayBarrageSettingDataContext.Companion.getContext();
        if (r100 == null) goto L7;
        n<ReplayBarrageSetting> r101 = r100.getBarrageSetting();
        if (r101 == null) goto L7;
        ReplayBarrageSetting r102 = r101.getValue();
    L8:
        if (r102 == null) goto L11;
        this.f546612a.getClass();
        Intrinsics.checkNotNullParameter(r102, "setting");
        e<ReplayBarrageSetting> r103 = d.f520100i;
        r103.getClass();
        f.d(r103, r102);
        xs2.b.a().post(new com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.setting.a(r102));
        return;
    L11:
        return;
    L7:
        r102 = null;
        goto L8
    }

    public a(AbsReplayDanmakuSettingSeekView r100) {
        this.f546612a = r100;
    }

    @Override // ul1.a
    public final void c(RangeSeekBar r100, float r101) {
        if (r100 == null) goto L4;
        int r102 = r100.getStepCount();
    L5:
        if (r102 > 0) goto L11;
        AbsReplayDanmakuSettingSeekView r103 = this.f546612a;
        TextView r104 = r103.f109178c;
        if (r104 == null) goto L9;
        r104.setText(r103.R5((int) r101));
    L9:
        this.f546612a.T5((int) r101);
        return;
    L11:
        return;
    L4:
        r102 = 0;
        goto L5
    }

    @Override // ul1.a
    public final void d(RangeSeekBar r100, int r101, boolean r102) {
        if (r102 == false) goto L4;
        return;
    L4:
        if (r100 == null) goto L6;
        int r103 = r100.getStepCount();
    L7:
        if (r103 <= 0) goto L13;
        AbsReplayDanmakuSettingSeekView r104 = this.f546612a;
        TextView r105 = r104.f109178c;
        if (r105 == null) goto L11;
        r105.setText(r104.R5(r101));
    L11:
        this.f546612a.T5(r101);
        return;
    L13:
        return;
    L6:
        r103 = 0;
        goto L7
    }
}
