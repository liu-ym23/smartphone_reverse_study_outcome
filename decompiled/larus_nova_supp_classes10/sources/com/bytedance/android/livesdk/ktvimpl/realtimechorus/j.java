package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import io.reactivex.functions.Consumer;
import java.lang.ref.WeakReference;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class j<T> implements Consumer {
    public final /* synthetic */ RTChorusMusicInfoView a;
    public final /* synthetic */ WeakReference b;

    public j(RTChorusMusicInfoView r1, WeakReference r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r9) {
        Long r10 = (Long) r9;
        if (KtvSettingHelper.r().booleanValue() == false) goto L5;
        RTChorusMusicInfoView r11 = (RTChorusMusicInfoView) this.b.get();
    L6:
        if (r11 == null) goto L23;
        Pair r0 = (Pair) r11.p.getValue();
        if (r0 == null) goto L24;
        com.bytedance.android.live.ktv.common.model.bean.a r1 = (com.bytedance.android.live.ktv.common.model.bean.a) r0.getSecond();
        if (r1 == null) goto L25;
        long r2 = r1.b - ((long) 1000);
        if (r2 >= 0) goto L14;
        r2 = 0;
    L14:
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r3 = r11.o;
        if (r3 == null) goto L17;
        KtvRoomLyricsStateMachineConfig.d r4 = r3.getCurState();
    L19:
        if ((r4 instanceof KtvRoomLyricsStateMachineConfig.d.f) == false) goto L21;
        r11.p.setValue(new Pair(r0.getFirst(), new com.bytedance.android.live.ktv.common.model.bean.a(((com.bytedance.android.live.ktv.common.model.bean.a) r0.getSecond()).a, r2)));
    L21:
        r11.U5(r2);
        return;
    L17:
        r4 = null;
        goto L19
    L25:
        return;
    L24:
        return;
    L23:
        return;
    L5:
        r11 = this.a;
        goto L6
    }
}
