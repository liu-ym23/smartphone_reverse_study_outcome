package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui;

import com.bytedance.bpea.cert.token.TokenCert;
import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class i<T> implements Consumer {
    public final /* synthetic */ KtvComponentUIWidget a;

    public i(KtvComponentUIWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        StringBuilder r0 = new StringBuilder("initSongListChangeObserver chorusSelectedSongList onValueChanged size ");
        List r4 = (List) sh6.c.b((sh6.b) r3);
        if (r4 == null) goto L5;
        int r5 = r4.size();
    L6:
        r0.append(r5);
        com.bytedance.android.livesdk.ktvimpl.chorus.a.a("KtvComponentUIWidget", r0.toString());
        KtvComponentUIWidget r6 = this.a;
        TokenCert r1 = KtvComponentUIWidget.y1;
        r6.sr();
        return;
    L5:
        r5 = 0;
        goto L6
    }
}
