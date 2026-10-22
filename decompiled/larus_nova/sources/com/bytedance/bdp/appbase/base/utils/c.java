package com.bytedance.bdp.appbase.base.utils;

import android.os.Process;
import android.os.SystemClock;
import com.bytedance.bdp.bdpbase.util.f;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

/* JADX INFO: loaded from: classes11.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f200656a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f200657a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f200658b;

        public a() {
        }
    }

    static {
        new HashMap(3);
        f200656a = 0;
    }

    public static a a() {
        a r100 = new a();
        if (b() == false) goto L32;
        long r101 = -1;
        BufferedReader r110 = null;
        BufferedReader r111 = new BufferedReader(new InputStreamReader(new PolarisFileInputStreamWrapper("/proc/" + Process.myPid() + "/stat")), 1000);     // Catch: Throwable -> L10
        String r102 = r111.readLine();     // Catch: Throwable -> L8
        r111.close();     // Catch: Throwable -> L8
        String[] r103 = r102.split(" ");     // Catch: Throwable -> L8
        long r112 = ((Long.parseLong(r103[13]) + Long.parseLong(r103[14])) + Long.parseLong(r103[15])) + Long.parseLong(r103[16]);
        f.b(r111);
    L14:
        r100.f200657a = r112;
        if (b() == true) goto L39;
    L27:
        r100.f200658b = r101;
        goto L32
    L39:
        BufferedReader r104 = new BufferedReader(new InputStreamReader(new PolarisFileInputStreamWrapper("/proc/stat")), 1000);     // Catch: Throwable -> L21
        String r105 = r104.readLine();     // Catch: Throwable -> L19
        r104.close();     // Catch: Throwable -> L19
        String[] r106 = r105.split(" ");     // Catch: Throwable -> L19
        r101 = (((((Long.parseLong(r106[2]) + Long.parseLong(r106[3])) + Long.parseLong(r106[4])) + Long.parseLong(r106[6])) + Long.parseLong(r106[5])) + Long.parseLong(r106[7])) + Long.parseLong(r106[8]);
        f.b(r104);
    L19:
        th = th;
        r110 = r104;
    L43:
        g94.b.b("CpuUsageUtil", new Object[]{th});     // Catch: Throwable -> L24
        f.b(r110);
    L24:
        th = move-exception;
        f.b(r110);
        throw th;
    L21:
        th = th;
    L8:
        th = th;
    L41:
        g94.b.b("CpuUsageUtil", new Object[]{th});     // Catch: Throwable -> L28
        f.b(r111);
        r112 = -1;
    L28:
        th = move-exception;
        f.b(r111);
        throw th;
    L10:
        th = th;
        r111 = null;
    L32:
        if (r100.f200657a > 0) goto L34;
    L35:
        r100.f200657a = Process.getElapsedCpuTime();
        r100.f200658b = SystemClock.uptimeMillis() * ((long) Runtime.getRuntime().availableProcessors());
    L36:
        return r100;
    L34:
        if (r100.f200658b > 0) goto L36;
        goto L35
    }

    public static boolean b() {
        int r100 = f200656a;
        if (r100 != 0) goto L12;
        PolarisFileWrapper r101 = new PolarisFileWrapper("/proc/stat");
        if (r101.exists() == true) goto L7;
    L10:
        f200656a = 2;
        return false;
    L7:
        if (r101.canRead() == false) goto L10;
        f200656a = 1;
        return true;
    L12:
        if (r100 != 1) goto L15;
        return true;
    L15:
        return false;
    }
}
