package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import com.bytedance.android.livesdk.ktvimpl.ktvroom.subwidget.KtvRoomContainerWidget;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e1<T> implements Consumer {
    public final /* synthetic */ KtvRoomAnchorWidget a;

    public e1(KtvRoomAnchorWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r1) {
        Long r2 = (Long) r1;
        KtvRoomContainerWidget r3 = this.a.E;
        if (r3 == null) goto L7;
        qe2.a r4 = r3.e;
        if (r4 == null) goto L7;
        int r5 = r4.e();
    L8:
        if (r5 < 0) goto L18;
        KtvRoomContainerWidget r6 = this.a.E;
        if (r6 == null) goto L16;
        qe2.a r7 = r6.e;
        if (r7 == null) goto L17;
        r7.j();
        return;
    L17:
        return;
    L16:
        return;
    L18:
        return;
    L7:
        r5 = 0;
        goto L8
    }
}
