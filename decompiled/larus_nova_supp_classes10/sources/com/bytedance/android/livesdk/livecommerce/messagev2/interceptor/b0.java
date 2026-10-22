package com.bytedance.android.livesdk.livecommerce.messagev2.interceptor;

import android.content.Context;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b0 extends a {
    public Context e;
    public String f;
    public com.bytedance.android.livesdk.livecommerce.room.api.c g;

    public b0() {
        super(false);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.a
    public final boolean c(sg2.a r4) {
        Intrinsics.checkNotNullParameter(r4, "message");
        if ((r4 instanceof si2.v) == true) goto L5;
        return false;
    L5:
        si2.v r5 = (si2.v) r4;
        if (r5.msgType != 0) goto L9;
        Context r0 = this.e;
        String r6 = String.valueOf(r5.screenshotTimestamp);
        Observable.create(new v(this, r0)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).flatMap(x.a).flatMap(new y(this, r6)).subscribe(z.a, a0.a);
        return true;
    L9:
        return false;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.a
    public final void e(String r1, boolean r2) {
        this.e = getContext();
        this.f = r1;
        this.g = (com.bytedance.android.livesdk.livecommerce.room.api.c) b(com.bytedance.android.livesdk.livecommerce.room.api.c.class, null);
    }
}
