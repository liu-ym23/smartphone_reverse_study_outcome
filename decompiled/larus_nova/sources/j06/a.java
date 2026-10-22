package j06;

import com.bytedance.ies.abmock.datacenter.init.IABMockInitConfig;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import i06.c;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile c f496810a;

    public a() {
    }

    public static c a() {
        if (f496810a != null) goto L19;
        monitor-enter(a.class);
    L15:
        th = move-exception;
        throw th;
    L7:
        if (f496810a != null) goto L13;
        IABMockInitConfig r100 = (IABMockInitConfig) ServiceManager.get().getService(IABMockInitConfig.class);     // Catch: Throwable -> L15
        if (r100 != null) goto L11;
        c r101 = null;
    L12:
        f496810a = r101;     // Catch: Throwable -> L15
        goto L13
    L11:
        r101 = r100.getProvider();     // Catch: Throwable -> L15
    L13:
        monitor-exit(a.class);     // Catch: Throwable -> L15
    L19:
        return f496810a;
    }
}
