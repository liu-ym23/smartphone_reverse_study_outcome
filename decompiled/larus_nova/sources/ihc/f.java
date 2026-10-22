package ihc;

import android.app.Application;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import com.ss.android.ugc.route_monitor.RouteMonitorManager;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f489938a;

    public static final class a {
    }

    static {
    }

    public f() {
    }

    public abstract void a();

    public abstract List<String> b();

    public abstract void c();

    public abstract void d();

    public abstract com.ss.android.ugc.route_monitor.impl.d e();

    public abstract void f();

    public abstract void g();

    public abstract void i();

    public static boolean h(String r100) {
        Application r101 = RouteMonitorManager.f454384g.a();
        String r102 = f489938a;
        if (r102 != null) goto L13;
        PackageManager r103 = r101.getPackageManager();
        Intent r104 = r103.getLaunchIntentForPackage(r101.getPackageName());
        if (r104 == null) goto L10;
        ComponentName r105 = r104.resolveActivity(r103);
        if (r105 == null) goto L10;
        String r106 = r105.getClassName();
    L11:
        r102 = r106;
        f489938a = r102;
    L10:
        r106 = null;
    L13:
        return Intrinsics.areEqual(r102, r100);
    }
}
