package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui;

import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.KtvComponentContext;
import com.bytedance.bpea.cert.token.TokenCert;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class s<T> implements Consumer {
    public final /* synthetic */ KtvComponentUIWidget a;

    public s(KtvComponentUIWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        com.bytedance.android.livesdk.ktvimpl.base.util.i r4 = (com.bytedance.android.livesdk.ktvimpl.base.util.i) r3;
        KtvComponentContext r5 = KtvComponentContext.Companion.getContext();
        if (r5 == null) goto L8;
        com.bytedance.live.datacontext.n<Float> r6 = r5.getBallRelativeY();
        if (r6 == null) goto L9;
        KtvComponentUIWidget r0 = this.a;
        TokenCert r1 = KtvComponentUIWidget.y1;
        r6.setValue(Float.valueOf(r0.Mq()));
        return;
    L9:
        return;
    }
}
