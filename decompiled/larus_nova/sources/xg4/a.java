package xg4;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.os.SystemClock;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes15.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f563610a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static ActivityManager.ProcessErrorStateInfo f563611b;

    public static boolean b() {
        ActivityManager r100 = (ActivityManager) com.bytedance.crash.i.a().f203223c.getSystemService("activity");
        if (r100 != null) goto L5;
        return false;
    L5:
        int r101 = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> r102 = r100.getRunningAppProcesses();
        if (r102 == null) goto L15;
        Iterator<ActivityManager.RunningAppProcessInfo> r103 = r102.iterator();
    L9:
        if (r103.hasNext() == false) goto L15;
        ActivityManager.RunningAppProcessInfo r104 = r103.next();
        if (r104 == null) goto L9;
        if (r104.pid != r101) goto L9;
        boolean r105 = true;
    L16:
        if (r105 == false) goto L18;
        return false;
    L18:
        List<ActivityManager.ProcessErrorStateInfo> r106 = r100.getProcessesInErrorState();
        if (r106 == null) goto L30;
        Iterator<ActivityManager.ProcessErrorStateInfo> r107 = r106.iterator();
    L22:
        if (r107.hasNext() == false) goto L30;
        ActivityManager.ProcessErrorStateInfo r108 = r107.next();
        if (r108 == null) goto L22;
        if (r108.pid != r101) goto L22;
        if (r108.condition != 1) goto L30;
        boolean r109 = true;
    L31:
        if (r109 == false) goto L33;
        return false;
    L33:
        return true;
    L30:
        r109 = false;
    L15:
        r105 = false;
        goto L16
    }

    public static String a(Context r100) {
        if ((SystemClock.uptimeMillis() - f563610a) >= 5000) goto L37;
        System.out.println("get_anr_info_is_time_out");
        return null;
    L37:
        ActivityManager r101 = (ActivityManager) r100.getSystemService("activity");     // Catch: Throwable -> L36
        if (r101 == null) goto L24;
        int r102 = 0;
    L10:
        if (r102 >= 150) goto L23;
        List<ActivityManager.ProcessErrorStateInfo> r103 = r101.getProcessesInErrorState();     // Catch: Throwable -> L36
        if (r103 == null) goto L19;
        Iterator<ActivityManager.ProcessErrorStateInfo> r104 = r103.iterator();     // Catch: Throwable -> L36
    L15:
        if (r104.hasNext() == false) goto L19;
        ActivityManager.ProcessErrorStateInfo r105 = r104.next();     // Catch: Throwable -> L36
        if (r105.condition != 2) goto L15;
    L25:
        if (r105 != null) goto L27;
        return null;
    L27:
        if (Process.myPid() != r105.pid) goto L44;
        ActivityManager.ProcessErrorStateInfo r106 = f563611b;     // Catch: Throwable -> L36
        if (r106 != null) goto L32;
    L34:
        f563611b = r105;     // Catch: Throwable -> L36
        f563610a = SystemClock.uptimeMillis();     // Catch: Throwable -> L36
        return j.d(r105);
    L32:
        if (j.f(r106, r105) == false) goto L34;
        f563610a = SystemClock.uptimeMillis();     // Catch: Throwable -> L36
        return null;
    L44:
        return null;
    L19:
        r102 = r102 + 1;     // Catch: Throwable -> L36
        if (150 == r102) goto L23;
        SystemClock.sleep(600);     // Catch: Throwable -> L36
    L23:
        System.out.println("get_anr_info_times_out");     // Catch: Throwable -> L36
    L24:
        r105 = null;
        goto L25
    L46:
        return null;
    }

    public static void c(Throwable r100) {
        ch4.c.d("NPTH_ANR_ERROR", r100);
    }
}
