package xp7;

import android.os.Handler;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import java.io.IOException;

/* JADX INFO: loaded from: classes22.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Handler f564734a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f564735b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f564736c;

    public a() {
    }

    public static String a() throws IOException {
        byte[] r100 = new byte[64];
        PolarisFileInputStreamWrapper r101 = new PolarisFileInputStreamWrapper("/proc/self/cmdline");
        int r102 = r101.read(r100);     // Catch: Throwable -> L16
        int r103 = 0;
    L4:
        if (r103 >= 64) goto L9;
        if (r100[r103] == 0) goto L11;
        r103 = r103 + 1;     // Catch: Throwable -> L16
    L11:
        if (r103 <= 0) goto L13;
        r102 = r103;
    L13:
        String r104 = new String(r100, 0, r102);     // Catch: Throwable -> L16
        r101.close();
        return r104;
    L9:
        r103 = -1;
    L16:
        th = move-exception;
        r101.close();
        throw th;
    }
}
