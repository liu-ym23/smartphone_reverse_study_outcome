package com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.callback;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class h<T> implements Consumer {
    public final /* synthetic */ j a;

    public h(j r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        sh6.b r4 = (sh6.b) r3;
        j r5 = this.a;
        Disposable r0 = r5.b;
        if (r0 != null) goto L5;
    L7:
        ALogger.d("ttlive_ktv_realTimeChorus_KSongTuningMusicControlOuterCallback", "observePlayProgressEvent");
        ec0.a r1 = r5.c;
        if (r1 == null) goto L10;
        Disposable r2 = r1.n(new i(r5));
    L11:
        r5.b = r2;
        return;
    L10:
        r2 = null;
        goto L11
    L5:
        if (r0.isDisposed() == true) goto L7;
        r0.dispose();
        goto L7
    }
}
