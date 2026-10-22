package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui;

import android.os.Handler;
import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class j<T> implements Consumer {
    public final /* synthetic */ KtvComponentUIWidget a;

    public j(KtvComponentUIWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r6) {
        List r7 = (List) r6;
        KtvComponentUIWidget r8 = this.a;
        if (r8.d != 0) goto L8;
        String r0 = je0.d.a();
        if (r0 != null) goto L7;
        r0 = "";
    L7:
        r8.d = com.bytedance.android.livesdk.ktvimpl.base.sei.t.h(r0);
    L8:
        KtvComponentUIWidget r9 = this.a;
        r9.getClass();
        Handler r1 = com.bytedance.android.live.core.utils.i0.c();
        if (r1 == null) goto L12;
        r1.post(new f(r9));
        return;
    }
}
