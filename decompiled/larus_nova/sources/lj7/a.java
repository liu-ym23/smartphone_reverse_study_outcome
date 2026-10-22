package lj7;

import android.text.TextUtils;
import com.bytedance.ug.sdk.luckycat.impl.manager.m;
import com.bytedance.ug.sdk.luckycat.impl.manager.p;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadTimer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes22.dex */
public final class a extends TimerTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f509505a;

    public a() {
        this.f509505a = b.C6702b.f509509a;
    }

    public final void a() {
        String r100 = m.a.f271349a.i();
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("luckycat", "ConfigUpdateManager onConfigUpdate");
        b.a r101 = this.f509505a.f509508c;
        if (r101 == null) goto L8;
        ((p) r101).f271355a.d(r100);
    L8:
        b r102 = this.f509505a;
        PthreadTimer r103 = r102.f509506a;
        if (r103 == null) goto L11;
        r103.cancel();
        r102.f509506a = null;
    L11:
        a r104 = r102.f509507b;
        if (r104 == null) goto L15;
        r104.cancel();
        r102.f509507b = null;
        return;
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
