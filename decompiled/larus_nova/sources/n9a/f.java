package n9a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.IBinder;
import com.obric.aiagent.assistant.idl.IAgentIDL;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f518415a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f518416b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f518417c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f518418d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f518419e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy f518420f = null;

    public f() {
    }

    static {
        f518415a = new f();
        f518416b = LazyKt.lazy(new a());
        f518417c = LazyKt.lazy(new b());
        f518418d = LazyKt.lazy(new c());
        f518419e = LazyKt.lazy(new d());
        f518420f = LazyKt.lazy(new e());
    }

    public static Intent a() {
        ConcurrentHashMap<String, com.obric.aiagent.ipc.control.b<Intent, IBinder>> r100 = com.obric.aiagent.ipc.control.b.f384694b;
        return com.obric.aiagent.ipc.control.b.C4585b.a(f518415a.getContext(), new Intent(IAgentIDL.ACTION_BIND_IPC));
    }

    public static ApplicationInfo b() {
        Intent r100 = (Intent) f518417c.getValue();
        if (r100 == null) goto L7;
        String r101 = r100.getPackage();
        if (r101 == null) goto L7;
        return f518415a.getContext().getPackageManager().getApplicationInfo(r101, 128);
    L7:
        return null;
    }

    private final Context getContext() {
        return (Context) f518416b.getValue();
    }
}
