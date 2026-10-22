package i60;

import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.common.utility.Logger;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes45.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f488346a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static j60.a f488347b;

    public static double b() {
        if (f488347b != null) goto L5;
        f488347b = new j60.a();
    L5:
        f488347b.a();
        Logger.d("CommonMonitorUtil", "cpu Rate: " + f488347b.f497480b + ", cpu speed" + f488347b.f497484f);
        return f488347b.f497480b;
    }

    public static boolean c() {
        PolarisFileWrapper r100 = new PolarisFileWrapper("/proc/stat");
        if (r100.exists() == true) goto L5;
        return false;
    L5:
        if (r100.canRead() == false) goto L10;
        return true;
    L10:
        return false;
    }

    public static double d() {
        Process r100 = null;
        double r101 = AudioStats.AUDIO_AMPLITUDE_NONE;
        r100 = a(Runtime.getRuntime());     // Catch: Throwable -> L37
        BufferedReader r102 = new BufferedReader(new InputStreamReader(r100.getInputStream()));     // Catch: Throwable -> L37
        int r103 = -1;
    L4:
        String r104 = r102.readLine();     // Catch: Throwable -> L37
        if (r104 == null) goto L40;
        String r105 = r104.trim();     // Catch: Throwable -> L37
        if (TextUtils.isEmpty(r105) == true) goto L4;
        if (r105.contains("CPU") == false) goto L19;
        String[] r106 = r105.split("\\s+");     // Catch: Throwable -> L37
        int r110 = 0;
    L14:
        if (r110 >= r106.length) goto L19;
        if (r106[r110].contains("CPU") == true) goto L20;
        r110 = r110 + 1;     // Catch: Throwable -> L37
    L20:
        if (r110 != (-1)) goto L21;
        if (r105.startsWith(String.valueOf(Process.myPid())) == false) goto L4;
        if (r103 == (-1)) goto L4;
        String[] r107 = r105.split("\\s+");     // Catch: Throwable -> L37
        if (r107.length <= r103) goto L4;
        String r108 = r107[r103];     // Catch: Throwable -> L37
        if (r108.endsWith(GXTemplateKey.GAIAX_PE) == false) goto L51;
        r108 = r108.substring(0, r108.lastIndexOf(GXTemplateKey.GAIAX_PE));     // Catch: Throwable -> L37
    L51:
        if (Build.VERSION.SDK_INT >= 26) goto L34;
        r101 = Double.parseDouble(r108);     // Catch: NumberFormatException -> L46 Throwable -> L37
        goto L4
    L34:
        r101 = Double.parseDouble(r108) / ((double) Runtime.getRuntime().availableProcessors());     // Catch: NumberFormatException -> L46 Throwable -> L37
        goto L4
    L21:
        r103 = r110;
    L19:
        r110 = -1;
    L40:
        r100.destroy();
    L41:
        return r101;
    L37:
        th = move-exception;
        Logger.e("CommonMonitorUtil", "", th);     // Catch: Throwable -> L42
        if (r100 == null) goto L41;
    L42:
        th = move-exception;
        if (r100 == null) goto L45;
        r100.destroy();
    L45:
        throw th;
    }

    public static Process a(Runtime r110) {
        f06.c r100 = new f06.c();
        Object[] r101 = {"top -n 1"};
        f06.b r111 = new f06.b();
        f06.d r112 = r100.b(102900, "java/lang/Runtime", "exec", r110, r101, "java.lang.Process", r111);
        if (r112.f474982a == false) goto L6;
        r100.a(102900, "java/lang/Runtime", "exec", r110, r101, null, r111, false);
        return (Process) r112.f474983b;
    L6:
        Process r113 = r110.exec("top -n 1");
        r100.a(102900, "java/lang/Runtime", "exec", r110, r101, r113, r111, true);
        return r113;
    }
}
