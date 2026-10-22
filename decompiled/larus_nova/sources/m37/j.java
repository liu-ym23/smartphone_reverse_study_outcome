package m37;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;

/* JADX INFO: loaded from: classes21.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f511782a;

    public static boolean a(Context r100) {
        String r101 = f511782a;
        if (TextUtils.isEmpty(r101) == false) goto L28;
        int r102 = Process.myPid();     // Catch: Exception -> L12
        Iterator<ActivityManager.RunningAppProcessInfo> r103 = ((ActivityManager) r100.getSystemService("activity")).getRunningAppProcesses().iterator();     // Catch: Exception -> L12
    L7:
        if (r103.hasNext() == false) goto L14;
        ActivityManager.RunningAppProcessInfo r104 = r103.next();     // Catch: Exception -> L12
        if (r104.pid != r102) goto L7;
        r101 = r104.processName;     // Catch: Exception -> L12
        f511782a = r101;     // Catch: Exception -> L12
    L14:
        String r105 = null;
        BufferedReader r106 = new BufferedReader(new InputStreamReader(new PolarisFileInputStreamWrapper("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L23
        StringBuilder r107 = new StringBuilder();     // Catch: Throwable -> L22
    L17:
        int r108 = r106.read();     // Catch: Throwable -> L22
        if (r108 <= 0) goto L20;
        r107.append((char) r108);     // Catch: Throwable -> L22
        goto L17
    L20:
        r105 = r107.toString();     // Catch: Throwable -> L22
    L38:
        r106.close();     // Catch: Exception -> L37
    L26:
        r101 = r105;
        f511782a = r101;
    L24:
        if (r106 == null) goto L26;
    L23:
        r106 = null;
    L12:
        e = move-exception;
        e.printStackTrace();
    L28:
        if (r101 != null) goto L30;
    L32:
        if (r101 != null) goto L34;
        return false;
    L34:
        if (r101.equals(r100.getPackageName()) == false) goto L51;
        return true;
    L51:
        return false;
    L30:
        if (r101.contains(":") == false) goto L32;
        return false;
    }
}
