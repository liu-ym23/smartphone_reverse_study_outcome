package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import com.bytedance.android.livesdk.chatroom.utils.o3;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class r0<T> implements Consumer {
    public final /* synthetic */ RealTimeChorusMainViewWidget a;

    public r0(RealTimeChorusMainViewWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        od2.b r6 = (od2.b) r5;
        o3.e(this.a).B();
        this.a.br(r6.a, r6.b, r6.c, null);
    }
}
