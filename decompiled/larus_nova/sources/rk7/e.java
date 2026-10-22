package rk7;

import android.app.Application;
import android.text.TextUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadTimer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes22.dex */
public final class e extends TimerTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f538335a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f538336b;

    public final void a() {
        Application r100 = m.f538347a;
        String r101 = m.h();
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return;
    L5:
        String r102 = d.f538330f;
        com.bytedance.ug.sdk.luckydog.api.log.d.d(r102, "轮询获取did成功， 共等待" + (System.currentTimeMillis() - this.f538336b) + "ms");
        com.bytedance.ug.sdk.luckydog.api.log.d.d(r102, "ConfigUpdateManager onConfigUpdate");
        if (this.f538335a.f538334d == null) goto L10;
        int r103 = bl7.c.f19499a;
        bl7.b r104 = f.d();
        if (r104 == null) goto L10;
        r104.onDeviceIdUpdate(r101);
    L10:
        d r105 = this.f538335a;
        PthreadTimer r106 = r105.f538331a;
        if (r106 == null) goto L13;
        r106.cancel();
    L13:
        r105.f538331a = null;
        e r107 = r105.f538332b;
        if (r107 == null) goto L16;
        r107.cancel();
    L16:
        r105.f538332b = null;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
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

    public e(d r100, long r101) {
        this.f538335a = r100;
        this.f538336b = r101;
    }
}
