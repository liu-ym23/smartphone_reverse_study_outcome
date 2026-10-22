package lrc;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes41.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f510483a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f510484b;

    public static String a(Context r110) {
        boolean r100 = f510484b;
        if (r100 == false) goto L6;
    L73:
        if (r100 == false) goto L76;
        return "";
    L76:
        if (TextUtils.isEmpty(f510483a) == false) goto L78;
        return "unknown";
    L78:
        int r111 = f510483a.indexOf(":");
        if (r111 != (-1)) goto L81;
        return "unknown";
    L81:
        return f510483a.substring(r111 + 1);
    L6:
        if (TextUtils.isEmpty(f510483a) == true) goto L8;
        String r112 = f510483a;
    L67:
        f510483a = r112;
        if (TextUtils.isEmpty(r112) == false) goto L70;
    L72:
        r100 = f510484b;
        goto L73
    L70:
        if (f510483a.indexOf(":") != (-1)) goto L72;
        f510484b = true;
        goto L72
    L8:
        BufferedReader r101 = null;
        Application r102 = (Application) r110.getApplicationContext();     // Catch: Exception -> L11
        Field r103 = r102.getClass().getField("mLoadedApk");     // Catch: Exception -> L11
        r103.setAccessible(true);     // Catch: Exception -> L11
        Object r104 = r103.get(r102);     // Catch: Exception -> L11
        Field r105 = r104.getClass().getDeclaredField("mActivityThread");     // Catch: Exception -> L11
        r105.setAccessible(true);     // Catch: Exception -> L11
        Object r106 = r105.get(r104);     // Catch: Exception -> L11
        String r107 = (String) r106.getClass().getDeclaredMethod("getProcessName", new Class[0]).invoke(r106, new Object[0]);     // Catch: Exception -> L11
    L13:
        f510483a = r107;
        if (TextUtils.isEmpty(r107) == true) goto L16;
        r112 = f510483a;
        goto L67
    L16:
        PolarisFileWrapper r108 = new PolarisFileWrapper("/proc/self/cmdline");
        if (r108.exists() == true) goto L19;
    L51:
        String r109 = "";
    L52:
        f510483a = r109;
        if (TextUtils.isEmpty(r109) == true) goto L55;
        r112 = f510483a;
        goto L67
    L55:
        ActivityManager r113 = (ActivityManager) r110.getSystemService("activity");
        if (r113 == null) goto L65;
        List<ActivityManager.RunningAppProcessInfo> r114 = r113.getRunningAppProcesses();
        if (r114 == null) goto L65;
        Iterator<ActivityManager.RunningAppProcessInfo> r115 = r114.iterator();
    L61:
        if (r115.hasNext() == false) goto L65;
        ActivityManager.RunningAppProcessInfo r116 = r115.next();
        if (r116.pid != Process.myPid()) goto L61;
        r112 = r116.processName.trim();
    L66:
        f510483a = r112;
    L65:
        r112 = "";
        goto L66
    L19:
        if (r108.isDirectory() == true) goto L51;
        BufferedReader r117 = new BufferedReader(new InputStreamReader(new PolarisFileInputStreamWrapper(r108)));     // Catch: Throwable -> L32 Exception -> L34
        String r118 = r117.readLine();     // Catch: Throwable -> L28 Exception -> L30
        if (TextUtils.isEmpty(r118) == true) goto L88;
        r109 = r118.trim();     // Catch: Throwable -> L28 Exception -> L30
        r117.close();     // Catch: Exception -> L26
    L26:
        e = move-exception;
        e.printStackTrace();
        goto L52
    L88:
        r117.close();     // Catch: Exception -> L40
    L40:
        e = move-exception;
        e.printStackTrace();
    L30:
        Exception e100 = e;
    L84:
        e100.printStackTrace();     // Catch: Throwable -> L42
        if (r117 == null) goto L51;
    L42:
        th = th;
        r101 = r117;
    L44:
        r117 = r101;
    L45:
        if (r117 != null) goto L90;
    L50:
        throw th;
    L90:
        r117.close();     // Catch: Exception -> L48
    L48:
        e = move-exception;
        e.printStackTrace();
    L28:
        th = th;
        goto L45
    L34:
        e = move-exception;
        r117 = null;
        e100 = e;
    L32:
        th = th;
    L11:
        e = move-exception;
        e.printStackTrace();
        r107 = null;
        goto L13
    }
}
