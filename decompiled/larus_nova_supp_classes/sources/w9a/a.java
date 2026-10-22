package w9a;

import baa.c;
import com.obric.aiagent.product.platform.api.app.ObricActivityManager;
import com.obric.aiagent.product.platform.api.app.ObricActivityTaskManager;
import com.obric.aiagent.product.platform.api.rom.RomInfo;
import com.obric.aiagent.product.platform.api.view.ObricWindowManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public interface a {
    public static final C0015a a = null;

    /* JADX INFO: renamed from: w9a.a$a, reason: collision with other inner class name */
    public static final class C0015a {
        public static final /* synthetic */ C0015a a = null;

        static {
            a = new C0015a();
        }

        public C0015a() {
        }

        public static c a() {
            c.a r0 = c.c;
            monitor-enter(r0);
            c r1 = c.d.getValue();     // Catch: Throwable -> L7
            monitor-exit(r0);
            return r1;
        L7:
            th = move-exception;
            throw th;
        }
    }

    static {
        a = C0015a.a;
    }

    void a();

    RomInfo b();

    ObricActivityManager.Companion c();

    void d();

    ObricActivityTaskManager.Companion e();

    ObricWindowManager.Companion windowManager();
}
