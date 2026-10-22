package qm7;

import android.text.TextUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadTimer;
import java.util.TimerTask;
import rk7.m;

/* JADX INFO: loaded from: classes22.dex */
public final class a extends TimerTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f533893a;

    public a() {
        this.f533893a = b.C7360b.f533897a;
    }

    public final void a() {
        rm7.c r100 = rm7.c.a.f538587a;
        if (r100.f538576a == null) goto L5;
        String r101 = m.h();
    L7:
        if (TextUtils.isEmpty(r101) == false) goto L10;
        return;
    L10:
        if (um7.e.f550694a <= 2) goto L12;
    L12:
        r100.g("ConfigUpdateManager onConfigUpdate");
        b.a r102 = this.f533893a.f533896c;
        if (r102 == null) goto L15;
        ((rm7.e) r102).f538589a.h();
    L15:
        b r103 = this.f533893a;
        PthreadTimer r104 = r103.f533894a;
        if (r104 == null) goto L18;
        r104.cancel();
        r103.f533894a = null;
    L18:
        a r105 = r103.f533895b;
        if (r105 == null) goto L22;
        r105.cancel();
        r103.f533895b = null;
        return;
    L22:
        return;
    L5:
        r101 = "";
        goto L7
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
}
