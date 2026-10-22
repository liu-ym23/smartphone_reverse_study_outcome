package w48;

import com.larus.common.mssdk.api.SecurityService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;

/* JADX INFO: loaded from: classes4.dex */
public final class i implements com.bytedance.applog.d {

    public static final class a extends a84.a.C0026a {
        @Override // a84.a.C0026a, a84.a
        public final long a() {
            SecurityService r100 = (SecurityService) ServiceManager.get().getService(SecurityService.class);
            if (r100 == null) goto L5;
            r100.a();
            long r101 = 600;
        L6:
            FLogger.f375446a.d("SecurityService", "getAdIdWaitTime = " + r101);
            return r101;
        L5:
            r101 = 100;
            goto L6
        }

        public a() {
        }
    }

    public i() {
    }

    @Override // com.bytedance.applog.d
    public final void b() {
    }

    @Override // com.bytedance.applog.d
    public final void a(com.bytedance.bdinstall.l r100) {
        if (r100 == null) goto L5;
        r100.H = new a();
        return;
    }
}
