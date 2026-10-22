package com.bytedance.crash.protector;

import com.bytedance.crash.i;
import com.bytedance.crash.util.g;
import com.bytedance.crash.util.p;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public static synchronized void a(JSONObject r100) {
        monitor-enter(b.class);
        CrashProtectorConfig r101 = new CrashProtectorConfig();     // Catch: Throwable -> L7
        CrashProtectorConfig.e(r100);     // Catch: Throwable -> L7
        r101.d();     // Catch: Throwable -> L7
        b(r101.f203340d, r101.f203341e);     // Catch: Throwable -> L7
        monitor-exit(b.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static boolean b(byte[] r110, int r111) {
        PolarisFileWrapper r100 = new PolarisFileWrapper(i.c(), "crash_protector.config");     // Catch: Throwable -> L65
        PolarisFileOutputStreamWrapper r101 = null;
        if (r110 == null) goto L34;
        if (r111 <= 0) goto L34;
        if (r100.exists() == false) goto L34;
        if (r100.length() != r111) goto L34;
        PolarisFileInputStreamWrapper r102 = new PolarisFileInputStreamWrapper(r100);     // Catch: Exception -> L29 Throwable -> L65
        byte[] r103 = new byte[4096];     // Catch: Exception -> L64 Throwable -> L65
        int r104 = 0;
    L68:
        int r105 = r102.read(r103);     // Catch: Exception -> L63 Throwable -> L65
        if (r105 <= 0) goto L31;
        int r106 = r104 + r105;     // Catch: Exception -> L63 Throwable -> L65
        if (r106 > r111) goto L31;
        int r107 = 0;
    L22:
        if (r107 >= r105) goto L28;
        if (r103[r107] != r110[r104 + r107]) goto L25;
        r107 = r107 + 1;
        goto L22
    L25:
        r102.close();     // Catch: Exception -> L63 Throwable -> L65
    L28:
        r104 = r106;
    L31:
        g.a(r102);     // Catch: Throwable -> L65
        if (r104 != r111) goto L34;
        boolean r108 = true;
    L35:
        if (r108 == false) goto L39;
        p.e("config not changed");     // Catch: Throwable -> L65
        return true;
    L39:
        if (r100.exists() == false) goto L41;
        r100.delete();     // Catch: Throwable -> L65
    L41:
        if (r110 == null) goto L60;
        if (r111 <= 0) goto L60;
        PolarisFileWrapper r109 = new PolarisFileWrapper(i.c(), "crash_protector.config.tmp");     // Catch: Throwable -> L65
        if (r109.exists() == false) goto L47;
    L66:
        PolarisFileOutputStreamWrapper r112 = new PolarisFileOutputStreamWrapper(r109, false);     // Catch: Throwable -> L57
        r112.write(r110, 0, r111);     // Catch: Throwable -> L55
        r112.flush();     // Catch: Throwable -> L55
        g.a(r112);     // Catch: Throwable -> L65
        if (r109.renameTo(r100) == false) goto L61;
        p.e("update config file done");     // Catch: Throwable -> L65
        return true;
    L55:
        th = th;
        r101 = r112;
    L58:
        g.a(r101);     // Catch: Throwable -> L65
        throw th;     // Catch: Throwable -> L65
    L57:
        th = th;
        goto L58
    L47:
        if (r109.createNewFile() == true) goto L66;
        return false;
    L60:
        return false;
    L30:
        r104 = 0;
    L29:
        r102 = null;
    L34:
        r108 = false;
    L61:
        p.c("failed to update config file");
        return false;
    }
}
