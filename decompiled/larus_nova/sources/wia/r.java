package wia;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.obric.capabilitykit.logger.Logger;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes5.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile String f559890a;

    static {
    }

    public static String a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r101 = f559890a;
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L12;
        return r101;
    L12:
        if (Build.VERSION.SDK_INT < 28) goto L45;
        f559890a = Application.getProcessName();
        Logger.INSTANCE.d("ProcessUtils", "processName = " + f559890a);
    L37:
        return f559890a;
    L45:
        int r103 = Process.myPid();     // Catch: Exception -> L21
        Object r104 = r100.getSystemService("activity");     // Catch: Exception -> L21
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type android.app.ActivityManager");     // Catch: Exception -> L21
        Iterator<ActivityManager.RunningAppProcessInfo> r105 = ((ActivityManager) r104).getRunningAppProcesses().iterator();     // Catch: Exception -> L21
    L16:
        if (r105.hasNext() == false) goto L23;
        ActivityManager.RunningAppProcessInfo r106 = r105.next();     // Catch: Exception -> L21
        if (r106.pid != r103) goto L16;
        Logger.INSTANCE.d("ProcessUtils", "processName = " + r106.processName);     // Catch: Exception -> L21
        f559890a = r106.processName;     // Catch: Exception -> L21
        return f559890a;
    L23:
        String r107 = null;
        BufferedReader r108 = new BufferedReader(new InputStreamReader(new PolarisFileInputStreamWrapper("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L32
        Ref.IntRef r109 = new Ref.IntRef();     // Catch: Throwable -> L31
        StringBuilder r110 = new StringBuilder();     // Catch: Throwable -> L31
    L26:
        int r111 = r108.read();     // Catch: Throwable -> L31
        r109.element = r111;     // Catch: Throwable -> L31
        if (r111 <= 0) goto L29;
        r110.append((char) r111);     // Catch: Throwable -> L31
        goto L26
    L29:
        Logger.INSTANCE.d("ProcessUtils", "get processName = " + r110);     // Catch: Throwable -> L31
        r107 = r110.toString();     // Catch: Throwable -> L31
    L43:
        r108.close();     // Catch: Exception -> L38
    L35:
        f559890a = r107;
    L33:
        if (r108 == null) goto L35;
    L32:
        r108 = null;
    L21:
        e = move-exception;
        e.printStackTrace();
        goto L23
    L5:
        if (r101.length() == 0) goto L8;
        r102 = false;
        goto L9
    }
}
