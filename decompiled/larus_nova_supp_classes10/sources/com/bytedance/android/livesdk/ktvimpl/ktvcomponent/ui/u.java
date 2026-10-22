package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class u<T> implements Consumer {
    public final /* synthetic */ KtvComponentUIWidget a;

    public u(KtvComponentUIWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r1) {
        com.bytedance.android.livesdk.chatroom.viewmodel.i r2 = (com.bytedance.android.livesdk.chatroom.viewmodel.i) r1;
        KtvComponentUIWidget.Eq(this.a);
    }
}
