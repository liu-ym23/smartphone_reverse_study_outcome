package com.google.android.gms.common.util;

import android.app.Application;
import android.os.Build;
import android.os.Process;
import android.os.StrictMode;
import av7.d;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.google.android.gms.common.internal.Preconditions;
import java.io.BufferedReader;
import java.io.IOException;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public class ProcessUtils {

    /* JADX INFO: renamed from: zza, reason: collision with root package name */
    @Nullable
    private static String f274604zza;

    /* JADX INFO: renamed from: zzb, reason: collision with root package name */
    private static int f274605zzb;

    private ProcessUtils() {
    }

    public static String getMyProcessName() {
        if (f274604zza != null) goto L30;
        if (Build.VERSION.SDK_INT < 28) goto L7;
        f274604zza = Application.getProcessName();
        goto L30
    L7:
        int r100 = f274605zzb;
        if (r100 != 0) goto L10;
        r100 = Process.myPid();
        f274605zzb = r100;
    L10:
        String r101 = null;
        r101 = null;
        r101 = null;
        BufferedReader r102 = null;
        if (r100 > 0) goto L34;
    L28:
        f274604zza = r101;
        goto L30
    L34:
        String r103 = "/proc/" + r100 + "/cmdline";     // Catch: Throwable -> L23 IOException -> L26
        StrictMode.ThreadPolicy r104 = StrictMode.allowThreadDiskReads();     // Catch: Throwable -> L23 IOException -> L26
        BufferedReader r105 = new BufferedReader(new PolarisFileReaderWrapper(r103));     // Catch: Throwable -> L20
        StrictMode.setThreadPolicy(r104);     // Catch: Throwable -> L23 IOException -> L26
        String r106 = r105.readLine();     // Catch: Throwable -> L18 IOException -> L31
        Preconditions.checkNotNull(r106);     // Catch: Throwable -> L18 IOException -> L31
        r101 = r106.trim();     // Catch: Throwable -> L18 IOException -> L31
    L18:
        th = th;
        r102 = r105;
    L24:
        d.a(r102);
        throw th;
    L27:
        d.a(r105);
        goto L28
    L20:
        th = move-exception;
        StrictMode.setThreadPolicy(r104);     // Catch: Throwable -> L23 IOException -> L26
        throw th;     // Catch: Throwable -> L23 IOException -> L26
    L26:
        r105 = null;
    L23:
        th = th;
    L30:
        return f274604zza;
    }
}
