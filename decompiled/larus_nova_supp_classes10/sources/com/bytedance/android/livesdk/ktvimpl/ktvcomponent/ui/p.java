package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui;

import com.bytedance.bpea.cert.token.TokenCert;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class p<T> implements Observer {
    public final /* synthetic */ KtvComponentUIWidget a;

    public p(KtvComponentUIWidget r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        List r3 = (List) r2;
        KtvComponentUIWidget r4 = this.a;
        TokenCert r0 = KtvComponentUIWidget.y1;
        r4.Nq();
    }
}
