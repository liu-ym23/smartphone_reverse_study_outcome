package f94;

import com.bytedance.bdp.appbase.base.info.BdpAppInfoService;
import com.bytedance.bdp.bdpbase.manager.BdpManager;
import com.bytedance.bdp.serviceapi.hostimpl.info.BdpInfoService;

/* JADX INFO: loaded from: classes11.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f475964a;

    public a() {
    }

    public static a c() {
        if (f475964a != null) goto L15;
        monitor-enter(com.bytedance.bdp.appbase.base.utils.a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f475964a != null) goto L9;
        f475964a = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(com.bytedance.bdp.appbase.base.utils.a.class);     // Catch: Throwable -> L11
    L15:
        return f475964a;
    }

    public static String a() {
        return ((BdpInfoService) BdpManager.getInst().getService(BdpInfoService.class)).getHostInfo().getChannel();
    }

    public static String b(String r100) {
        BdpAppInfoService r101 = (BdpAppInfoService) BdpManager.getInst().getService(BdpAppInfoService.class);
        String r102 = r101.getDeviceId(r100);
        if (r102 != null) goto L5;
        g94.b.e("BdpAppInfoUtil", new Object[]{"BdpAppInfoService impl: ".concat(r101.getClass().getSimpleName())});
    L5:
        return r102;
    }
}
