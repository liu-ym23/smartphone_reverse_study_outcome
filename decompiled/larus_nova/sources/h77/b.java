package h77;

import com.bytedance.android.service.manager.PushServiceManager;
import com.bytedance.push.settings.PushOnlineSettings;
import com.larus.apm.impl.protector.RunnableProtector;
import j77.i;

/* JADX INFO: loaded from: classes21.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f483995a;

    @Override // java.lang.Runnable
    public final void run() {
        PushOnlineSettings r100 = (PushOnlineSettings) i.a(this.f483995a.f483992a, PushOnlineSettings.class);     // Catch: Throwable -> L8
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.s() == false) goto L15;
        PushServiceManager.get().getIRedBadgeExternalService().removeCount(this.f483995a.f483992a);     // Catch: Throwable -> L8
        return;
    L15:
        return;
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    }

    public b(a r100) {
        this.f483995a = r100;
    }
}
