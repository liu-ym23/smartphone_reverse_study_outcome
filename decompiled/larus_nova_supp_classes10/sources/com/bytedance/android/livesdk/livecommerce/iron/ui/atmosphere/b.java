package com.bytedance.android.livesdk.livecommerce.iron.ui.atmosphere;

import com.bytedance.android.ec.core.widget.ECHotAtmosphereView;
import com.bytedance.android.ec.model.response.ECHotAtmosphere;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b implements Runnable {
    public final /* synthetic */ ECAtmosphereView a;
    public final /* synthetic */ ECHotAtmosphere b;

    public b(ECAtmosphereView r1, ECHotAtmosphere r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        this.a.j.setVisibility(8);
        ECAtmosphereView r0 = this.a;
        ECAtmosphereView.b r1 = r0.e;
        if (r1 == null) goto L6;
        r1.e(r0.i);
    L6:
        if (this.a.i.getVisibility() == 0) goto L8;
        ECHotAtmosphereView.g(this.a.i, true, false, null, 6);
        ECAtmosphereView r2 = this.a;
        r2.c(r2.i, true, -1L);
    L8:
        ECHotAtmosphereView r3 = this.a.i;
        r3.l(false);
        ECHotAtmosphereView.k(r3, this.b, false, 6);
        ECAtmosphereView.b r4 = this.a.e;
        if (r4 == null) goto L12;
        r4.c();
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
