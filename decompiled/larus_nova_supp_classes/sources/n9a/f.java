package n9a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class f {
    public static final f a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;
    public static final Lazy d = null;
    public static final Lazy e = null;
    public static final Lazy f = null;

    public f() {
    }

    static {
        a = new f();
        b = LazyKt.lazy(new a());
        c = LazyKt.lazy(new b());
        d = LazyKt.lazy(new c());
        e = LazyKt.lazy(new d());
        f = LazyKt.lazy(new e());
    }

    public static Intent a() {
        ConcurrentHashMap r0 = com.obric.aiagent.ipc.control.b.b;
        return com.obric.aiagent.ipc.control.b.b.a(a.getContext(), new Intent("com.obric.aiagent.action.BIND_ASSISTANT_IPC"));
    }

    public static ApplicationInfo b() {
        Intent r0 = (Intent) c.getValue();
        if (r0 == null) goto L7;
        String r1 = r0.getPackage();
        if (r1 == null) goto L7;
        return a.getContext().getPackageManager().getApplicationInfo(r1, 128);
    L7:
        return null;
    }

    private final Context getContext() {
        return (Context) b.getValue();
    }
}
