package com.bytedance.android.livesdk.livecommerce.iron.ui.atmosphere;

import com.bytedance.android.ec.model.response.ECAtmosphereItem;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a implements Runnable {
    public final /* synthetic */ ECAtmosphereView a;
    public final /* synthetic */ ECAtmosphereItem b;

    public a(ECAtmosphereView r1, ECAtmosphereItem r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        this.a.i.setVisibility(8);
        ECAtmosphereView r0 = this.a;
        r0.j.b(this.b, r0.e);
        ECAtmosphereView r1 = this.a;
        r1.c(r1.j, true, Long.valueOf(this.b.getShowDuration()));
        ECAtmosphereView.b r2 = this.a.e;
        if (r2 == null) goto L6;
        r2.d(this.b);
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
