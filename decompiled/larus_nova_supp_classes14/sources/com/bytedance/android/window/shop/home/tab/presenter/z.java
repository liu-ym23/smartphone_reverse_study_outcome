package com.bytedance.android.window.shop.home.tab.presenter;

import com.bytedance.android.ec.host.api.service.IECHostService;
import com.bytedance.android.ec.sdk.ECSdk;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class z implements Runnable {
    public final /* synthetic */ WindowH5TabPresenter a;
    public final /* synthetic */ String b;

    public z(WindowH5TabPresenter r1, String r2, String r3) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        this.a.y().getHeight();
        int r0 = zq3.d.a;
        Map r1 = zq3.d.b(this.a.D(), null, null);
        String r2 = this.b;
        if (r2 == null) goto L5;
        r1 = MapsKt.plus(r1, MapsKt.mapOf(TuplesKt.to("init_data", r2)));
    L5:
        this.a.getClass();
        MapsKt.plus(r1, MapsKt.mapOf(TuplesKt.to("open_time", Long.valueOf(System.currentTimeMillis()))));
        int r3 = ECSdk.a;
        IECHostService r4 = (IECHostService) ECSdk.a(IECHostService.class);
        if (r4 == null) goto L9;
        r4.getECAnnieXHostService();
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
