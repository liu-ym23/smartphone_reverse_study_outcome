package yn;

import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.base.service.ECServiceManager;

/* JADX INFO: loaded from: classes44.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Object f568441a;

    static {
    }

    public static void a(d.c r100) {
        boolean r101 = ECServiceManager.f42805a;
        IAdapterService r102 = (IAdapterService) ECServiceManager.c(IAdapterService.class);
        if (r102 == null) goto L12;
        com.bytedance.android.ec.adapter.api.j r103 = r102.getLiveWindowService();
        if (r103 == null) goto L13;
        Object r104 = f568441a;
        if (r104 == null) goto L9;
        r103.d(r104);
        f568441a = null;
    L9:
        if (r100 == null) goto L14;
        f568441a = r103.f(r100);
        return;
    L14:
        return;
    L13:
        return;
    }
}
