package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui;

import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.KtvComponentContext;
import com.bytedance.bpea.cert.token.TokenCert;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class z<T> implements Consumer {
    public final /* synthetic */ KtvComponentUIWidget a;

    public z(KtvComponentUIWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        od2.b r6 = (od2.b) r5;
        KtvComponentContext r0 = KtvComponentContext.Companion.getContext();
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.n<Integer> r1 = r0.getKtvComponentStatus();
        if (r1 == null) goto L7;
        Integer r2 = (Integer) r1.getValue();
    L8:
        if (r2 != null) goto L11;
        return;
    L11:
        if (r2.intValue() != 1) goto L14;
        KtvComponentUIWidget r3 = this.a;
        String r4 = r6.a;
        String r7 = r6.c;
        TokenCert r8 = KtvComponentUIWidget.y1;
        r3.nr(r4, null, r7);
        return;
    L14:
        return;
    L7:
        r2 = null;
        goto L8
    }
}
