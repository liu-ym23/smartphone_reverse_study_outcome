package z84;

import android.app.Application;
import com.bytedance.bdp.bdpbase.manager.BdpManager;
import com.bytedance.bdp.serviceapi.hostimpl.info.BdpContextService;

/* JADX INFO: loaded from: classes11.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Application f570912a;

    public static Application a() {
        if (f570912a != null) goto L6;
        f570912a = ((BdpContextService) BdpManager.getInst().getService(BdpContextService.class)).getHostApplication();
    L6:
        return f570912a;
    }
}
