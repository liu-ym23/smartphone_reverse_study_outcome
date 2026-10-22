package iu8;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import com.larus.common.apphost.AppHost;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a {
    public static final void b() {
        nu8.a.e("ProcessUtils", "killCurrentProcess");
        Process.killProcess(Process.myPid());
        System.exit(0);
        throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
    }

    public static final void c() {
        nu8.a.e("ProcessUtils", "restartApp");
        Application r100 = AppHost.f326268a.getApplication();
        Intent r101 = r100.getPackageManager().getLaunchIntentForPackage(r100.getPackageName());
        if (r101 == null) goto L6;
        r101.addFlags(67108864);
        r100.startActivity(r101);
    L6:
        b();
        throw null;
    }

    public static final int a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Object r101 = r100.getSystemService("activity");     // Catch: Throwable -> L10
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.app.ActivityManager");     // Catch: Throwable -> L10
        Iterator<ActivityManager.RunningAppProcessInfo> r102 = ((ActivityManager) r101).getRunningAppProcesses().iterator();     // Catch: Throwable -> L10
    L5:
        if (r102.hasNext() == false) goto L12;
        ActivityManager.RunningAppProcessInfo r103 = r102.next();     // Catch: Throwable -> L10
        if (Intrinsics.areEqual(r100.getPackageName(), r103.processName) == false) goto L5;
        nu8.a.a("ProcessUtils", "main process pid is " + r103.pid);     // Catch: Throwable -> L10
        return r103.pid;
    L12:
        nu8.a.a("ProcessUtils", "not found main process pid -1");
        return -1;
    L10:
        th = move-exception;
        nu8.a.f("ProcessUtils", th, "getMainProcessPid failed ");
        goto L12
    }
}
