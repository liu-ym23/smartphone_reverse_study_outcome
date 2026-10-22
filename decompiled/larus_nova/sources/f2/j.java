package f2;

import com.bytedance.ai.model.AppletRuntimeManager;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes43.dex */
public final class j implements g2.c {
    public j() {
    }

    @Override // g2.c
    public final void onAllActivityDestroyed() {
    }

    @Override // g2.c
    public final void onAppBackground() {
        AppletRuntimeManager r100 = AppletRuntimeManager.INSTANCE;
        Function1 r101 = new h();
        r100.getClass();
        AppletRuntimeManager.g(r101);
        AppletRuntimeManager.f36751f = true;
    }

    @Override // g2.c
    public final void onAppForeground() {
        AppletRuntimeManager r100 = AppletRuntimeManager.INSTANCE;
        Function1 r101 = new i();
        r100.getClass();
        AppletRuntimeManager.g(r101);
        AppletRuntimeManager.f36751f = false;
    }
}
