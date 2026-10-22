package eu5;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Debug;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.utils.LarkContext;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import ju5.k;

/* JADX INFO: loaded from: classes19.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f474081a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f474082b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f474083c;

    public g() {
    }

    public static String c() {
        if (TextUtils.isEmpty(f474081a) == false) goto L15;
        monitor-enter(g.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (TextUtils.isEmpty(f474081a) == false) goto L9;
        f474081a = d(LarkContext.getApplication());     // Catch: Throwable -> L11
    L9:
        monitor-exit(g.class);     // Catch: Throwable -> L11
    L15:
        return f474081a;
    }

    public static String h() {
        if (TextUtils.isEmpty(f474082b) == false) goto L11;
        String r100 = c();
        int r101 = r100.indexOf(":");
        if (r101 < 0) goto L9;
        int r102 = r101 + 1;
        if (r102 >= r100.length()) goto L9;
        f474082b = r100.subSequence(r102, r100.length()).toString();
    L9:
        f474082b = "";
    L11:
        return f474082b;
    }

    public static boolean j() {
        boolean r100 = f474083c;
        if (r100 == false) goto L5;
        return r100;
    L5:
        String r101 = c();
        if (TextUtils.isEmpty(r101) == true) goto L11;
        if (r101.contains(":") == true) goto L11;
        f474083c = true;
    L11:
        return f474083c;
    }

    public static boolean i() {
        return !c().contains(":");
    }

    public static String a(String r100) {
        if (j() == false) goto L9;
        if (((HashSet) k.f500501a).contains(r100) == true) goto L7;
        return r100;
    L7:
        return r100 + "_p0";
    L9:
        return r100 + "_" + h();
    }

    public static long b(int r100) {
        BufferedReader r101 = new BufferedReader(new PolarisFileReaderWrapper("/proc/" + r100 + "/status"));     // Catch: Exception -> L12
    L4:
        String r102 = r101.readLine();     // Catch: Exception -> L12
        if (r102 == null) goto L10;
        if (r102.startsWith("VmRSS:") == false) goto L4;
        int r103 = CastIntegerProtector.parseInt(r102.split("\\s+")[1]);     // Catch: Exception -> L12
        r101.close();     // Catch: Exception -> L12
        return ((long) r103) / 1024;
    L10:
        r101.close();     // Catch: Exception -> L12
        tt5.a.h("ProcessUtils", "getProcessMemoryPss err: VmRSS is not found");     // Catch: Exception -> L12
        return 0;
    L12:
        e = move-exception;
        tt5.a.e("ProcessUtils", "getProcessMemoryPss err:", e, false);
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.BufferedReader] */
    public static String d(Context r100) {
        PolarisFileWrapper r101 = new PolarisFileWrapper("/proc/self/cmdline");
        ?? r102 = r101.exists();
        if (r102 == 0) goto L37;
        r102 = r101.isDirectory();
        if (r102 != 0) goto L37;
        r102 = 0;
        r102 = 0;
        ?? r103 = 0;
        ?? r104 = new BufferedReader(new InputStreamReader(new PolarisFileInputStreamWrapper(r101)));     // Catch: Throwable -> L21 Exception -> L23
        String r105 = r104.readLine();     // Catch: Throwable -> L17 Exception -> L19
        boolean r106 = TextUtils.isEmpty(r105);     // Catch: Throwable -> L17 Exception -> L19
        if (r106 == true) goto L15;
        String r107 = r105.trim();     // Catch: Throwable -> L17 Exception -> L19
        r104.close();     // Catch: Exception -> L13
        r103 = r106;
    L49:
        return r107;
    L13:
        e = move-exception;
        e.printStackTrace();
        r103 = r106;
        goto L49
    L15:
        r104.close();     // Catch: Exception -> L28
        r102 = r106;
    L55:
    L19:
        e = e;
        r102 = r104;
    L24:
        tt5.a.e("ProcessUtils", "cmdfile_open_fails", e, false);     // Catch: Throwable -> L21
        if (r102 == 0) goto L37;
        r102.close();     // Catch: Exception -> L28
        r102 = r102;
    L17:
        th = th;
    L31:
        if (r104 != 0) goto L58;
    L36:
        throw th;
    L58:
        r104.close();     // Catch: Exception -> L34
    L34:
        e = move-exception;
        e.printStackTrace();
    L21:
        th = th;
        r104 = r103;
    L23:
        e = e;
    L28:
        e = move-exception;
        e.printStackTrace();
    L37:
        ActivityManager r108 = (ActivityManager) r100.getSystemService("activity");
        String r109 = "";
        if (r108 == null) goto L47;
        List<ActivityManager.RunningAppProcessInfo> r110 = r108.getRunningAppProcesses();
        if (r110 == null) goto L47;
        Iterator<ActivityManager.RunningAppProcessInfo> r111 = r110.iterator();
    L42:
        r102 = r111.hasNext();
        if (r102 == 0) goto L47;
        ActivityManager.RunningAppProcessInfo r112 = r111.next();
        if (r112.pid != Process.myPid()) goto L42;
        r109 = r112.processName.trim();
    L47:
        r107 = r109;
        r103 = r102;
        goto L49
    }

    public static Integer e(Context r100) {
        List<ActivityManager.RunningAppProcessInfo> r101 = ((ActivityManager) r100.getSystemService("activity")).getRunningAppProcesses();
        if (hu5.a.d(r101) == false) goto L6;
        tt5.a.k("ProcessUtils", "killSandBoxProcesses list empty");
        return null;
    L6:
        Iterator<ActivityManager.RunningAppProcessInfo> r102 = r101.iterator();
    L8:
        if (r102.hasNext() == false) goto L13;
        ActivityManager.RunningAppProcessInfo r103 = r102.next();
        if (r103.processName.contains("sandboxed_process") == false) goto L8;
        return Integer.valueOf(r103.pid);
    L13:
        tt5.a.h("ProcessUtils", "sandbox_process process not found");
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public static int f(Context r100) {
        Integer r101 = e(r100);
        int r102 = 0;
        r102 = 0;
        r102 = 0;
        if (r101 != null) goto L21;
        return 0;
    L21:
        Debug.MemoryInfo[] r103 = ((ActivityManager) r100.getSystemService("activity")).getProcessMemoryInfo(new int[]{r101.intValue()});     // Catch: Throwable -> L17
        if (r103 != null) goto L9;
    L15:
        tt5.a.k("ProcessUtils", "processMemoryInfo is illegal");     // Catch: Throwable -> L17
    L20:
    L19:
        return r102;
    L9:
        if (r103.length == 0) goto L15;
        Debug.MemoryInfo r104 = r103[0];     // Catch: Throwable -> L17
        if (r104 != null) goto L14;
        tt5.a.k("ProcessUtils", "memoryInfo is null");     // Catch: Throwable -> L17
        goto L20
    L14:
        int r105 = r104.getTotalPss() / 1024;     // Catch: Throwable -> L17
        tt5.a.h("ProcessUtils", "sandbox_process process TotalPss: " + r105);     // Catch: Throwable -> L17
        r102 = r105;
    L17:
        th = move-exception;
        tt5.a.e("ProcessUtils", "getRenderProcessMemory", th, r102);
        goto L19
    }

    public static ArrayList<String> g(Context r100) {
        ArrayList<String> r101 = new ArrayList();
        List<ActivityManager.RunningAppProcessInfo> r102 = ((ActivityManager) r100.getSystemService("activity")).getRunningAppProcesses();
        if (hu5.a.d(r102) == false) goto L6;
        tt5.a.k("ProcessUtils", "killSandBoxProcesses list empty");
        return r101;
    L6:
        Iterator<ActivityManager.RunningAppProcessInfo> r103 = r102.iterator();
    L8:
        if (r103.hasNext() == false) goto L14;
        ActivityManager.RunningAppProcessInfo r104 = r103.next();
        if (r104.processName.contains("sandboxed_process") == false) goto L8;
        if (r101.contains(r104.processName) == true) goto L8;
        r101.add(r104.processName);
        goto L8
    L14:
        tt5.a.h("ProcessUtils", "sandbox_process process not found");
        return r101;
    }
}
