package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui;

import com.bytedance.bpea.cert.token.TokenCert;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class v<T> implements Consumer {
    public final /* synthetic */ KtvComponentUIWidget a;

    public v(KtvComponentUIWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        com.bytedance.android.livesdk.chatroom.viewmodel.k r3 = (com.bytedance.android.livesdk.chatroom.viewmodel.k) r2;
        KtvComponentUIWidget r4 = this.a;
        TokenCert r0 = KtvComponentUIWidget.y1;
        r4.Wq();
        this.a.Tq();
        KtvComponentUIWidget.Eq(this.a);
    }
}
