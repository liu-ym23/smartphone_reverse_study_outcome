package au3;

import android.os.Process;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.services.apm.api.IFdCheck;
import com.larus.apm.impl.protector.RunnableProtector;
import cv3.a;
import nu3.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class b$a extends a {
    public final /* synthetic */ b d;

    public final void a() {
        b r0 = this.d;
        if (r0.a == null) goto L28;
        uu3.a r1 = (uu3.a) qu3.c.a(uu3.a.class);
        int r2 = 0;
        if (r1 == null) goto L8;
        boolean r3 = r1.isForeground();
    L25:
        r2 = new PolarisFileWrapper("/proc/" + Process.myPid() + "/fd").listFiles().length;     // Catch: Exception -> L12
    L13:
        if (r2 <= 0) goto L18;
        if (r2 >= r0.a.a) goto L18;
        b.a(new c(r2, null, r3));
        return;
    L18:
        if (r0.f != null) goto L20;
        r0.f = (IFdCheck) ServiceManager.getService(IFdCheck.class);
    L20:
        IFdCheck r4 = r0.f;
        if (r4 == null) goto L29;
        b.a(new c(r2, r4.getFdList(), r3));
        return;
    L29:
        return;
    L8:
        r3 = false;
        goto L25
    }

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

    public b$a(b r3, long r4) {
        this.d = r3;
        super(0, r4);
    }
}
