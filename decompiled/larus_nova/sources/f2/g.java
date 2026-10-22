package f2;

import com.bytedance.ai.applet.grantingV2.McpGrantingManager;
import com.bytedance.ai.model.AppletRuntimeManager;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes43.dex */
public final class g implements g2.e {
    public g() {
    }

    @Override // g2.e
    public final void onActivityDestroy() {
    }

    @Override // g2.e
    public final void onActivityPaused() {
    }

    @Override // g2.e
    public final void onActivityResumed() {
    }

    @Override // g2.e
    public final void onContextCleared(final String r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        McpGrantingManager.f34644a.getClass();
        com.bytedance.ai.utils.g.f37637a.i("McpGrantingManagerV2", "onContextCleared");
        McpGrantingManager.d("context_cleared", null);
        AppletRuntimeManager r101 = AppletRuntimeManager.INSTANCE;
        Function1 r102 = new f(r100);
        r101.getClass();
        AppletRuntimeManager.g(r102);
    }

    @Override // g2.e
    public final void onViewCreated(final String r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        AppletRuntimeManager r101 = AppletRuntimeManager.INSTANCE;
        Function1 r102 = new e(r100);
        r101.getClass();
        AppletRuntimeManager.g(r102);
    }

    @Override // g2.e
    public final void onViewDestroyed(final String r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r101 = AppletRuntimeManager.f36749d;
        if (r101 == null) goto L7;
        int r102 = r101.R(r100);
    L9:
        if (r102 <= 0) goto L12;
        com.bytedance.ai.utils.g.f37637a.i("AppletEnv", "skip unBindSession(" + r100 + "), activeChatUICount=" + r102);
        return;
    L12:
        com.bytedance.ai.utils.g.f37637a.i("AppletEnv", "unBindSession(" + r100 + ')');
        AppletRuntimeManager.g(new d(r100));
        return;
    L7:
        r102 = 0;
        goto L9
    }
}
