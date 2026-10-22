package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class l1<T> implements Consumer {
    public final /* synthetic */ KtvRoomGuestWidget a;

    public l1(KtvRoomGuestWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        KtvRoomGuestWidget r0 = this.a;
        boolean r4 = ((Boolean) r3).booleanValue();
        int r1 = KtvRoomGuestWidget.G2;
        r0.lr(r4);
    }
}
