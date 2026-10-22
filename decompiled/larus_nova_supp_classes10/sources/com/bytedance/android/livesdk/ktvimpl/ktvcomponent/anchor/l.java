package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.anchor;

import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.KtvComponentContext;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class l<T> implements Consumer {
    public final /* synthetic */ KtvComponentAnchorLogicWidget a;

    public l(KtvComponentAnchorLogicWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        KtvComponentAnchorLogicWidget r0 = this.a;
        int r6 = ((com.bytedance.android.livesdk.chatroom.viewmodel.i) r5).a;
        int r1 = KtvComponentAnchorLogicWidget.q;
        r0.getClass();
        if (r6 != 9) goto L5;
        boolean r7 = true;
    L6:
        r0.Lq(!r7);
        if (r7 == false) goto L20;
        KtvComponentContext r8 = KtvComponentContext.Companion.getContext();
        if (r8 == null) goto L13;
        com.bytedance.live.datacontext.n<Integer> r9 = r8.getKtvComponentStatus();
        if (r9 == null) goto L13;
        Integer r10 = (Integer) r9.getValue();
    L14:
        if (r10 != null) goto L17;
        return;
    L17:
        if (r10.intValue() != 1) goto L21;
        r0.yq(false, "function_switch");
        return;
    L21:
        return;
    L13:
        r10 = null;
        goto L14
    L20:
        return;
    L5:
        r7 = false;
        goto L6
    }
}
