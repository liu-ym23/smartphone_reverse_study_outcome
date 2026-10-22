package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.anchor;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class m<T> implements Consumer {
    public final /* synthetic */ KtvComponentAnchorLogicWidget a;

    public m(KtvComponentAnchorLogicWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        if (((com.bytedance.android.livesdk.chatroom.viewmodel.i) r3).a != 9) goto L6;
        KtvComponentAnchorLogicWidget r4 = this.a;
        int r0 = KtvComponentAnchorLogicWidget.q;
        r4.yq(false, "function_switch");
        return;
    }
}
