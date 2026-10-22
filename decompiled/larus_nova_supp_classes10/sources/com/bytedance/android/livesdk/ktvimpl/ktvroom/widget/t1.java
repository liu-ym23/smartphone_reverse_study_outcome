package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import com.bytedance.android.livesdk.ktvimpl.ktvroom.subwidget.KtvRoomContainerWidget;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class t1<T> implements Consumer {
    public final /* synthetic */ KtvRoomGuestWidget a;

    public t1(KtvRoomGuestWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        zg1.i1 r3 = (zg1.i1) r2;
        Intrinsics.checkNotNullParameter(r3, "event");
        KtvRoomContainerWidget r0 = this.a.Y;
        if (r0 == null) goto L8;
        boolean r4 = r3.b;
        qe2.a r1 = r0.e;
        if (r1 == null) goto L9;
        r1.d(r4);
        return;
    L9:
        return;
    }
}
