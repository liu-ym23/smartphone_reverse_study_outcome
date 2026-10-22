package com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right;

import com.bytedance.android.livesdk.livecommerce.event.p0;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException;
import io.reactivex.functions.Consumer;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ f a;
    public final /* synthetic */ sk2.a b;

    public e(f r1, sk2.a r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r6) {
        Throwable r7 = (Throwable) r6;
        this.a.a.b.invoke(null);
        sk2.a r0 = this.b;
        if (r0 != null) goto L5;
        p0 r8 = new p0();
        r8.f("explain_retry_result", BDLocationException.ERROR_TIMEOUT);
        r8.k();
        Unit r9 = Unit.INSTANCE;
        return;
    L5:
        if ((r7 instanceof CronetIOException) == true) goto L7;
        r7 = null;
    L7:
        CronetIOException r10 = (CronetIOException) r7;
        if (r10 == null) goto L10;
        r0.b(Integer.valueOf(r10.getStatusCode()));
    L10:
        r0.a.c("explain_retry_result", BDLocationException.ERROR_TIMEOUT);
        r0.c(-1);
        r0.a.i(null);
    }
}
