package g94;

import com.bytedance.bdp.appbase.base.log.BdpAppLogService;
import com.bytedance.bdp.appbase.base.log.BdpAppLogServiceImpl;
import com.bytedance.bdp.bdpbase.manager.BdpManager;

/* JADX INFO: loaded from: classes11.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static BdpAppLogService f480507a;

    public static BdpAppLogService c() {
        if (f480507a != null) goto L9;
        BdpAppLogService r100 = (BdpAppLogService) BdpManager.getInst().getService(BdpAppLogService.class);
        if (r100 != null) goto L7;
        r100 = new BdpAppLogServiceImpl();
        BdpManager.getInst().registerService(BdpAppLogService.class, r100);
    L7:
        f480507a = r100;
    L9:
        return f480507a;
    }

    public static void a(String r100, Object... r101) {
        c().d(r100, r101);
    }

    public static void b(String r100, Object... r101) {
        c().e(r100, r101);
    }

    public static void d(String r100, Object... r101) {
        c().i(r100, r101);
    }

    public static void e(String r100, Object... r101) {
        c().w(r100, r101);
    }
}
