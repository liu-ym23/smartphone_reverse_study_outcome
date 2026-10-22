package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui;

import com.bytedance.bpea.cert.token.TokenCert;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class x<T> implements Observer {
    public final /* synthetic */ KtvComponentUIWidget a;

    public x(KtvComponentUIWidget r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        Boolean r3 = (Boolean) r2;
        com.bytedance.android.live.ktv.common.midi.e.b("KtvComponentUIWidget", " hideFeedback ");
        KtvComponentUIWidget r4 = this.a;
        TokenCert r0 = KtvComponentUIWidget.y1;
        r4.tr();
    }
}
