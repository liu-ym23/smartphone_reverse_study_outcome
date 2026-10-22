package w9a;

import baa.c;
import com.obric.aiagent.product.platform.api.app.ObricActivityManager;
import com.obric.aiagent.product.platform.api.app.ObricActivityTaskManager;
import com.obric.aiagent.product.platform.api.rom.RomInfo;
import com.obric.aiagent.product.platform.api.view.ObricWindowManager;

/* JADX INFO: loaded from: classes.dex */
public interface a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C8084a f558792a = null;

    /* JADX INFO: renamed from: w9a.a$a, reason: collision with other inner class name */
    public static final class C8084a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ C8084a f558793a = null;

        static {
            f558793a = new C8084a();
        }

        public C8084a() {
        }

        public static c a() {
            c.a r100 = c.f18440c;
            monitor-enter(r100);
            c r101 = c.f18441d.getValue();     // Catch: Throwable -> L7
            monitor-exit(r100);
            return r101;
        L7:
            th = move-exception;
            throw th;
        }
    }

    static {
        f558792a = C8084a.f558793a;
    }

    void a();

    RomInfo b();

    ObricActivityManager.Companion c();

    void d();

    ObricActivityTaskManager.Companion e();

    ObricWindowManager.Companion windowManager();
}
