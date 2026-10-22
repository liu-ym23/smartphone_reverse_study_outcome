package s47;

import com.bytedance.pia.core.setting.Config;
import com.bytedance.pia.core.setting.Settings;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;

/* JADX INFO: loaded from: classes21.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, FutureTask<n>> f540673a = null;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final t f540674a = null;

        static {
            f540674a = new t();
        }
    }

    public t() {
    }

    static {
        f540673a = new ConcurrentHashMap();
    }

    public static n a(String r100, String r101, Object r102, Config r103, boolean r104) {
        n.a r105 = new n.a();
        r105.f540652b = r100;
        r105.f540651a = r101;
        r105.f540653c = r102;
        r105.f540655e = r103;
        String r106 = r105.b();
        if (r106 != null) goto L5;
        return null;
    L5:
        if (r106.isEmpty() == true) goto L28;
        if (r104 == false) goto L9;
        FutureTask<n> r107 = f540673a.remove(r106);
        if (r107 != null) goto L26;
        com.bytedance.pia.core.utils.d.n("[Runtime] lack warmup task.");
    L23:
        return r105.a();
    L26:
        Lazy<Settings> r108 = Settings.f266286f;     // Catch: Throwable -> L19
        if (Settings.a.a().m() == false) goto L15;
        n r109 = r107.get();     // Catch: Throwable -> L19
    L16:
        if (r109 == null) goto L23;
        com.bytedance.pia.core.utils.d.i("[Runtime] consume warmup success.");     // Catch: Throwable -> L19
        return r109;
    L15:
        r109 = r107.get(Settings.a.a().f(), TimeUnit.MILLISECONDS);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        com.bytedance.pia.core.utils.d.c("[Runtime] consume warmup fail. " + th);
        goto L23
    L9:
        return r105.a();
    L28:
        return null;
    }
}
