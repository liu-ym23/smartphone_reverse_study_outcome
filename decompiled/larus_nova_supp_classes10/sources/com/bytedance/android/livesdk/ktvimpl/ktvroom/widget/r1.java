package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class r1<T> implements Consumer {
    public final /* synthetic */ KtvRoomGuestWidget a;

    public r1(KtvRoomGuestWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Intrinsics.checkNotNullParameter((jd0.f) r2, "event");
        KtvRoomGuestWidget r3 = this.a;
        int r0 = KtvRoomGuestWidget.G2;
        r3.getClass();
    }
}
