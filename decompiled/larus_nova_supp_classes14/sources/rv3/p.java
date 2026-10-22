package rv3;

import android.os.Handler;
import com.bytedance.ai.applet.app.AppletAppActivity;
import com.bytedance.ai.applet.app.AppletApplication;
import com.bytedance.ai.applet.services.AppletAppManagerService;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class p implements Function0<Unit> {
    public final /* synthetic */ n.a a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    public p(n.a r1, String r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object invoke() {
        Handler r2 = n.a;     // Catch: RuntimeException -> L12
        n.c = this.a;     // Catch: RuntimeException -> L12
        AppletAppActivity r3 = null;
        n.d = null;     // Catch: RuntimeException -> L12
        n.e = false;     // Catch: RuntimeException -> L12
        Handler r4 = n.a;     // Catch: RuntimeException -> L12
        n.h(null);     // Catch: RuntimeException -> L12
        if (n.b == true) goto L7;
        AppletAppManagerService.INSTANCE.registerAppLifecycleCallbacks(n.i);     // Catch: RuntimeException -> L12
        n.b = true;     // Catch: RuntimeException -> L12
    L7:
        AppletAppManagerService.INSTANCE.getClass();     // Catch: RuntimeException -> L12
        AppletApplication r5 = AppletAppManagerService.a("db_1GFLTGc");     // Catch: RuntimeException -> L12
        n.f = r5;     // Catch: RuntimeException -> L12
        if (r5 == null) goto L10;
        r3 = r5.d;     // Catch: RuntimeException -> L12
    L10:
        n.a(r3);     // Catch: RuntimeException -> L12
        n.d();     // Catch: RuntimeException -> L12
        int r6 = com.larus.navigation.api.c.a;     // Catch: RuntimeException -> L12
        com.larus.navigation.api.c.d("nav_prewarm_page", "watching outlinkId=" + this.b + " locationIdentifier=" + this.c);     // Catch: RuntimeException -> L12
    L15:
        return Unit.INSTANCE;
    L12:
        e = move-exception;
        int r7 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.c("nav_prewarm_page", "watch failed: " + e.getMessage(), e);
        goto L15
    }
}
