package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui;

import com.bytedance.android.livesdk.ktvimpl.base.lyrics.KtvListenerLyricPresenter;
import com.bytedance.android.livesdk.ktvimpl.base.lyrics.LyricComponentListenerPresenter;
import com.bytedance.bpea.cert.token.TokenCert;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class m<T> implements Observer {
    public final /* synthetic */ KtvComponentUIWidget a;

    public m(KtvComponentUIWidget r1) {
        this.a = r1;
    }

    public final void onChanged(Object r4) {
        com.bytedance.android.livesdk.ktvimpl.base.sei.k r5 = (com.bytedance.android.livesdk.ktvimpl.base.sei.k) r4;
        KtvComponentUIWidget r0 = this.a;
        if (r5 != null) goto L5;
        TokenCert r6 = KtvComponentUIWidget.y1;
        r0.getClass();
        return;
    L5:
        LyricComponentListenerPresenter r1 = r0.p;
        if (r1 == null) goto L8;
        r1.c(r5.d());
    L8:
        r0.T.getClass();
        KtvListenerLyricPresenter r2 = r0.v;
        if (r2 == null) goto L13;
        r2.c(r5);
        return;
    }
}
