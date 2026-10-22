package vl7;

import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.ug.sdk.luckydog.api.log.d;
import com.bytedance.ug.sdk.luckydog.base.utils.memory.Status;

/* JADX INFO: loaded from: classes22.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f555681a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f555682b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f555683c = -1;

    public static long d() {
        String r100 = PatternProtector.compile("[^0-9]").matcher(Status.get(Process.myPid()).getValue("VmSize")).replaceAll("").trim();     // Catch: Throwable -> L13
        long r101 = 0;
        if (TextUtils.isEmpty(r100) == false) goto L18;
    L11:
        long r102 = r101 / 1024;     // Catch: Throwable -> L13
        d.d("MemoryUtils", "vmSize:" + r102 + "M");     // Catch: Throwable -> L13
        return r102;
    L18:
        r101 = CastLongProtector.parseLong(r100);     // Catch: Exception -> L9 Throwable -> L13
    L9:
        e = move-exception;
        d.b("MemoryUtils", e.toString());     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        d.b("MemoryUtils", th.toString());
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0026 -> B:15:0x0031). Please report as a decompilation issue!!! */
    public static boolean e() {
        if (f555683c != (-1)) goto L21;
    L13:
        e = move-exception;
        d.b("MemoryUtils", e.toString());
    L12:
        ?? r100 = 0;
    L15:
        f555683c = r100;
        StringBuilder r101 = new StringBuilder("is64BitApp:");
        if (f555683c != 1) goto L18;
        boolean r102 = true;
    L19:
        r101.append(r102);
        d.d("MemoryUtils", r101.toString());
        goto L21
    L18:
        r102 = false;
        goto L19
    L5:
        if (Build.VERSION.SDK_INT < 23) goto L7;
        r100 = Process.is64Bit();     // Catch: Exception -> L13
        goto L15
    L7:
        String r103 = System.getProperty("os.arch");     // Catch: Exception -> L13
        if (r103 == null) goto L12;
        if (r103.contains(BDLocationException.ERROR_RESTRICTED_MODE_ON) == false) goto L12;
        r100 = 1;
    L21:
        if (f555683c != 1) goto L26;
        return true;
    L26:
        return false;
    }

    public static boolean f() {
        if (f555682b != (-1)) goto L29;
        if (f555681a == null) goto L32;
    L23:
        f555682b = f555681a.contains(BDLocationException.ERROR_RESTRICTED_MODE_ON) ? 1 : 0;
        StringBuilder r100 = new StringBuilder("is64BitDevice:");
        if (f555682b != 1) goto L26;
        boolean r101 = true;
    L27:
        r100.append(r101);
        d.d("MemoryUtils", r100.toString());
        goto L29
    L26:
        r101 = false;
        goto L27
    L32:
        StringBuilder r102 = new StringBuilder();     // Catch: Exception -> L21
        if (Build.SUPPORTED_ABIS.length <= 0) goto L15;
        int r103 = 0;
    L9:
        String[] r104 = Build.SUPPORTED_ABIS;     // Catch: Exception -> L21
        if (r103 >= r104.length) goto L17;
        r102.append(r104[r103]);     // Catch: Exception -> L21
        if (r103 == (r104.length - 1)) goto L14;
        r102.append(", ");     // Catch: Exception -> L21
    L14:
        r103 = r103 + 1;     // Catch: Exception -> L21
    L17:
        if (TextUtils.isEmpty(r102.toString()) == false) goto L19;
        f555681a = "";     // Catch: Exception -> L21
    L19:
        f555681a = r102.toString();     // Catch: Exception -> L21
        goto L23
    L15:
        r102 = new StringBuilder(Build.CPU_ABI);     // Catch: Exception -> L21
    L21:
        e = move-exception;
        d.b("MemoryUtils", e.toString());
        f555681a = "";
    L29:
        if (f555682b != 1) goto L37;
        return true;
    L37:
        return false;
    }

    public static long b() {
        long r100 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        return ((Runtime.getRuntime().maxMemory() - r100) / 1024) / 1024;
    }

    public static long c() {
        if (d() > 0) goto L7;
        return -1;
    L7:
        if (f() == true) goto L9;
        long r100 = 2764;
        long r101 = d();
    L13:
        long r102 = r100 - r101;
    L14:
        d.d("MemoryUtils", "free vm memory size:" + r102 + "m");
        return r102;
    L9:
        if (e() == false) goto L11;
        r102 = Long.MAX_VALUE;
        goto L14
    L11:
        r100 = 3788;
        r101 = d();
        goto L13
    }

    public static int a(byte[] r100, int r101) {
    L3:
        if (r101 >= r100.length) goto L17;
        byte r102 = r100[r101];
        if (r102 == 10) goto L24;
        if (Character.isDigit(r102) == true) goto L9;
        r101 = r101 + 1;
        goto L3
    L9:
        int r103 = r101 + 1;
    L11:
        if (r103 >= r100.length) goto L16;
        if (Character.isDigit(r100[r103]) == false) goto L16;
        r103 = r103 + 1;
    L16:
        return CastIntegerProtector.parseInt(new String(r100, 0, r101, r103 - r101));
    L24:
        return -1;
    L17:
        return -1;
    }
}
