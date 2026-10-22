package yhc;

import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes40.dex */
public final class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f567707a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f567708b = null;

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0035: MOVE (r0 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]) (LINE:53), block:B:15:0x0034 */
    public static String c() {
        BufferedReader r100 = null;
        BufferedReader r101 = new BufferedReader(new InputStreamReader(a(Runtime.getRuntime(), "getprop ro.soc.model").getInputStream()), 1024);     // Catch: Throwable -> L7 IOException -> L9
        String r102 = r101.readLine();     // Catch: IOException -> L20 Throwable -> L14
        r101.close();     // Catch: IOException -> L20 Throwable -> L14
        r101.close();     // Catch: IOException -> L19
    L6:
        return r102;
    L11:
        if (r101 != null) goto L26;
    L13:
        return null;
    L26:
        r101.close();     // Catch: IOException -> L21
        goto L13
    L14:
        th = move-exception;
        th = th;
        r100 = r2;
    L16:
        if (r100 != null) goto L28;
    L18:
        throw th;
    L28:
        r100.close();     // Catch: IOException -> L22
    L9:
        r101 = null;
    L7:
        th = th;
        goto L16
    }

    static {
        f567708b = new String[]{"SM8450"};
    }

    public static String b() {
        if (f567707a != null) goto L29;
        StringBuilder r100 = new StringBuilder();     // Catch: Exception -> L27
        String[] r101 = Build.SUPPORTED_ABIS;     // Catch: Exception -> L27
        if (r101.length <= 0) goto L21;
        int r102 = 0;
        if (r101[0].contains("v8a") == false) goto L15;
        String r103 = c();     // Catch: Exception -> L27
        int r104 = 0;
    L9:
        String[] r105 = f567708b;     // Catch: Exception -> L27
        if (r104 >= r105.length) goto L15;
        if (r103.contains(r105[r104]) == true) goto L13;
        r104 = r104 + 1;     // Catch: Exception -> L27
        goto L9
    L13:
        r100.append("arm64-v9a, ");     // Catch: Exception -> L27
    L15:
        String[] r106 = Build.SUPPORTED_ABIS;     // Catch: Exception -> L27
        if (r102 >= r106.length) goto L23;
        r100.append(r106[r102]);     // Catch: Exception -> L27
        if (r102 == (r106.length - 1)) goto L20;
        r100.append(", ");     // Catch: Exception -> L27
    L20:
        r102 = r102 + 1;     // Catch: Exception -> L27
    L23:
        if (TextUtils.isEmpty(r100.toString()) == false) goto L25;
        f567707a = "unknown";     // Catch: Exception -> L27
    L25:
        f567707a = r100.toString();     // Catch: Exception -> L27
        goto L29
    L21:
        r100 = new StringBuilder(Build.CPU_ABI);     // Catch: Exception -> L27
    L27:
        f567707a = "unknown";
    L29:
        return f567707a;
    }

    public static Process a(Runtime r110, String r111) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r111};
        f06.b r112 = new f06.b();
        f06.d r113 = r100.b(102900, "java/lang/Runtime", "exec", r110, r101, "java.lang.Process", r112);
        if (r113.f474982a == false) goto L6;
        r100.a(102900, "java/lang/Runtime", "exec", r110, r101, null, r112, false);
        return (Process) r113.f474983b;
    L6:
        Process r114 = r110.exec(r111);
        r100.a(102900, "java/lang/Runtime", "exec", r110, r101, r114, r112, true);
        return r114;
    }
}
