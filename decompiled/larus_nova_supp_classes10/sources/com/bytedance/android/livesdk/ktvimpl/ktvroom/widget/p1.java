package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import com.bytedance.android.livesdk.ktvimpl.ktvroom.subwidget.KtvRoomContainerWidget;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class p1<T> implements Consumer {
    public final /* synthetic */ KtvRoomGuestWidget a;

    public p1(KtvRoomGuestWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Integer r4 = (Integer) r3;
        jy0.b.a("SpatialAudio_KtvRoomGuestWidget", "CurrentStrategyId onValueChanged " + r4);
        hg6.g r0 = this.a.P2();
        if (r0 == null) goto L6;
        r0.i(com.bytedance.android.live.liveinteract.spatial.a.e(r4.intValue()));
    L6:
        if (com.bytedance.android.live.liveinteract.spatial.a.e(r4.intValue()) == false) goto L13;
        KtvRoomContainerWidget r5 = this.a.Y;
        if (r5 == null) goto L14;
        qe2.a r6 = r5.e;
        if (r6 == null) goto L15;
        r6.b();
        return;
    L15:
        return;
    L14:
        return;
    }
}
