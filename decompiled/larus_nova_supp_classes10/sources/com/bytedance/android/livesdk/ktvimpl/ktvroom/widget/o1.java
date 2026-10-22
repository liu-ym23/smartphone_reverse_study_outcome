package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class o1<T> implements Consumer {
    public final /* synthetic */ KtvRoomGuestWidget a;

    public o1(KtvRoomGuestWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        boolean r3 = ((Boolean) r2).booleanValue();
        this.a.rtcManger().w(r3);
    }
}
