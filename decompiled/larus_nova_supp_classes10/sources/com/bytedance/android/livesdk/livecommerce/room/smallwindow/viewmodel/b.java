package com.bytedance.android.livesdk.livecommerce.room.smallwindow.viewmodel;

import android.os.Handler;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import java.util.List;
import vi2.v0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b implements v0<yi2.a> {
    public final /* synthetic */ a a;

    public b(a r1) {
        this.a = r1;
    }

    @Override // vi2.v0
    public final void onError(Throwable r2) {
        if (r2 != null) goto L4;
        r2 = new Throwable("query LiveSmallWindowInfo fail");
    L4:
        ECExceptionMonitor.e(r2);
    }

    @Override // vi2.v0
    public final void onSuccess(yi2.a r7) {
        yi2.a r8 = r7;
        dm.a.a("LiveSmallWindowViewModel").a(String.valueOf(r8));
        if (r8 == null) goto L17;
        List<yi2.b> r0 = r8.b();
        if (r0 == null) goto L18;
        Long r9 = r8.a();
        if (r9 == null) goto L9;
        long r1 = r9.longValue();
    L11:
        if (r1 <= 0) goto L13;
        ((Handler) this.a.a.getValue()).postDelayed(this.a.b, r1 * ((long) 1000));
    L13:
        a.b r10 = this.a.c;
        if (r10 == null) goto L19;
        r10.d(r0);
        return;
    L19:
        return;
    L9:
        r1 = -1;
        goto L11
    L18:
        return;
    }
}
