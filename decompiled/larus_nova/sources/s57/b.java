package s57;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.platform.godzilla.common.Logger;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.larus.apm.impl.GodzillaImpl;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import t57.c;
import u57.f;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f540754a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f540755b;

    public interface a {
        List<p57.c> a();

        void b(p57.c r100);

        String getAppVersion();

        int getUpdateVersion();
    }

    @Override // t57.a
    public final String b() {
        return "CloudUncaughtExceptionCatcher";
    }

    @Override // t57.c
    public final void f() {
    }

    public b(GodzillaImpl.d r100, Context r101) {
        this.f540754a = r100;
        this.f540755b = r101;
        if (r101 == null) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("mConfigFetcher and mContext can not be null.");
    }

    @Override // p57.g
    public final boolean a(Thread r110, Throwable r111) {
        a r100 = this.f540754a;
        if (r100 != null) goto L5;
        return false;
    L5:
        List<p57.c> r101 = r100.a();
        if (r101 != null) goto L8;
    L88:
        return false;
    L8:
        if (r101.isEmpty() == true) goto L88;
        String r102 = this.f540754a.getAppVersion();
        this.f540754a.getUpdateVersion();
        String r103 = r110.getName();
        Context r104 = this.f540755b;
        if (TextUtils.isEmpty(f.f548878a) == true) goto L92;
        String r105 = f.f548878a;
    L35:
        Iterator<p57.c> r106 = r101.iterator();
    L37:
        if (r106.hasNext() == false) goto L88;
        p57.c r107 = r106.next();
        if (TextUtils.isEmpty(r107.f527795e) == true) goto L44;
        if (r107.f527795e.equalsIgnoreCase(r102) == false) goto L37;
    L44:
        if (TextUtils.isEmpty(r107.f527794d) == true) goto L49;
        if (r107.f527794d.equalsIgnoreCase(r103) == false) goto L37;
    L49:
        if (TextUtils.isEmpty(r107.f527791a) == true) goto L54;
        if (r107.f527791a.equalsIgnoreCase(r105) == false) goto L37;
    L54:
        if (TextUtils.isEmpty(r107.f527796f) == true) goto L59;
        if (r107.f527796f.equalsIgnoreCase(r111.getMessage()) == false) goto L37;
    L59:
        if (TextUtils.isEmpty(r107.f527797g) == true) goto L64;
        if (r107.f527797g.equalsIgnoreCase(r111.getClass().getName()) == false) goto L37;
    L64:
        if (TextUtils.isEmpty(r107.f527792b) == false) goto L70;
        if (TextUtils.isEmpty(r107.f527793c) == false) goto L70;
        Logger.a("CloudUntExPlugin", "Hint crash," + r107);
        this.f540754a.b(r107);
        return true;
    L70:
        if (TextUtils.isEmpty(r107.f527792b) == false) goto L72;
    L73:
        Logger.a("CloudUntExPlugin", r107.f527792b + "." + r107.f527793c + " does not match.");
    L74:
        StackTraceElement[] r108 = r111.getStackTrace();
        int r112 = r108.length;
        int r113 = 0;
    L75:
        if (r113 >= r112) goto L37;
        StackTraceElement r114 = r108[r113];
        if (TextUtils.isEmpty(r107.f527792b) == true) goto L82;
        if (r107.f527792b.equalsIgnoreCase(r114.getClassName()) == true) goto L82;
    L85:
        r113 = r113 + 1;
    L82:
        if (TextUtils.isEmpty(r107.f527793c) == true) goto L86;
        if (r107.f527793c.equalsIgnoreCase(r114.getMethodName()) == false) goto L85;
    L86:
        Logger.a("CloudUntExPlugin", "Hint crash," + r107);
        this.f540754a.b(r107);
        return true;
    L72:
        if (TextUtils.isEmpty(r107.f527793c) == false) goto L74;
    L92:
        int r109 = Process.myPid();     // Catch: Exception -> L20
        Iterator<ActivityManager.RunningAppProcessInfo> r115 = ((ActivityManager) r104.getSystemService("activity")).getRunningAppProcesses().iterator();     // Catch: Exception -> L20
    L15:
        if (r115.hasNext() == false) goto L22;
        ActivityManager.RunningAppProcessInfo r116 = r115.next();     // Catch: Exception -> L20
        if (r116.pid != r109) goto L15;
        r105 = r116.processName;     // Catch: Exception -> L20
        f.f548878a = r105;     // Catch: Exception -> L20
    L22:
        String r117 = null;
        BufferedReader r118 = new BufferedReader(new InputStreamReader(new PolarisFileInputStreamWrapper("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L31
        StringBuilder r119 = new StringBuilder();     // Catch: Throwable -> L30
    L25:
        int r120 = r118.read();     // Catch: Throwable -> L30
        if (r120 <= 0) goto L28;
        r119.append((char) r120);     // Catch: Throwable -> L30
        goto L25
    L28:
        r117 = r119.toString();     // Catch: Throwable -> L30
    L94:
        r118.close();     // Catch: Exception -> L89
    L34:
        r105 = r117;
        f.f548878a = r105;
    L32:
        if (r118 == null) goto L34;
    L31:
        r118 = null;
    L20:
        e = move-exception;
        e.printStackTrace();
        goto L22
    }
}
