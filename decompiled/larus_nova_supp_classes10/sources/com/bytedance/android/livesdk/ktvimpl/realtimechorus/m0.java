package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.util.KSongTuningPanelHelperKt;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class m0<T> implements Consumer {
    public final /* synthetic */ RealTimeChorusMainViewWidget.e a;

    public m0(RealTimeChorusMainViewWidget.e r1) {
        this.a = r1;
    }

    public final void accept(Object r6) {
        jd0.q r7 = (jd0.q) r6;
        RealTimeChorusMainViewWidget r8 = this.a.a;
        n1 r0 = r8.F2;
        if (r0 == null) goto L15;
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r1 = KSongTuningPanelHelperKt.d();
        if (r1 == null) goto L7;
        r1.m(r0.a, false, true);
    L7:
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r2 = KSongTuningPanelHelperKt.d();
        if (r2 == null) goto L10;
        r2.e0(r0.b);
    L10:
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r3 = KSongTuningPanelHelperKt.d();
        if (r3 == null) goto L13;
        r3.j(r0.c);
    L13:
        r8.F2 = null;
        return;
    }
}
