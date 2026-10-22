package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui;

import com.bytedance.android.live.base.model.user.UserAttr;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.bpea.cert.token.TokenCert;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c0<T> implements Consumer {
    public final /* synthetic */ KtvComponentUIWidget a;

    public c0(KtvComponentUIWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        if (((UserAttr) r2).isAdmin() == false) goto L5;
        ALogger.d("KtvComponentUIWidget", "observeAdminChanged.isAdmin");
    L6:
        KtvComponentUIWidget r3 = this.a;
        TokenCert r0 = KtvComponentUIWidget.y1;
        r3.tr();
        return;
    L5:
        ALogger.d("KtvComponentUIWidget", "observeAdminChanged.notAdmin");
        goto L6
    }
}
