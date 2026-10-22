package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class m1<T> implements Consumer {
    public final /* synthetic */ KtvRoomGuestWidget a;

    public m1(KtvRoomGuestWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        KtvRoomGuestWidget r0 = this.a;
        int r1 = KtvRoomGuestWidget.G2;
        r0.mr((com.bytedance.android.livesdk.chatroom.viewmodel.i) r3);
    }
}
