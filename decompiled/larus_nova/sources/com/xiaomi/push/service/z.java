package com.xiaomi.push.service;

import android.os.Process;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import com.xiaomi.push.cd;
import com.xiaomi.push.dn;
import com.xiaomi.push.en;
import java.io.BufferedReader;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes41.dex */
public class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f464364a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static ThreadPoolExecutor f1154a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final Pattern f1155a = null;

    static {
        f1155a = PatternProtector.compile("([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3})");
        f464364a = 0;
        f1154a = new PThreadPoolExecutor(1, 1, 20, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("ush/service/z"));
    }

    public static void b() {
        String r100 = a("/proc/self/net/tcp");
        if (TextUtils.isEmpty(r100) == true) goto L5;
        com.xiaomi.channel.commonutils.logger.b.m8718a("dump tcp for uid = " + Process.myUid());
        com.xiaomi.channel.commonutils.logger.b.m8718a(r100);
    L5:
        String r101 = a("/proc/self/net/tcp6");
        if (TextUtils.isEmpty(r101) == true) goto L9;
        com.xiaomi.channel.commonutils.logger.b.m8718a("dump tcp6 for uid = " + Process.myUid());
        com.xiaomi.channel.commonutils.logger.b.m8718a(r101);
        return;
    }

    public static void a() {
        long r100 = System.currentTimeMillis();
        if (f1154a.getActiveCount() <= 0) goto L8;
        if ((r100 - f464364a) >= 1800000) goto L8;
        return;
    L8:
        if (en.m9050a().m9055a() == false) goto L15;
        dn.a r101 = ax.a().m9377a();
        if (r101 != null) goto L12;
        return;
    L12:
        if (r101.e() <= 0) goto L17;
        f464364a = r100;
        a(r101.m8943a(), true);
        return;
    L17:
        return;
    }

    private static String a(String r100) {
        BufferedReader r101 = new BufferedReader(new PolarisFileReaderWrapper(new PolarisFileWrapper(r100)));     // Catch: Throwable -> L13 Exception -> L17
        StringBuilder r102 = new StringBuilder();     // Catch: Throwable -> L11 Exception -> L20
    L5:
        String r103 = r101.readLine();     // Catch: Throwable -> L11 Exception -> L20
        if (r103 == null) goto L8;
        r102.append("\n");     // Catch: Throwable -> L11 Exception -> L20
        r102.append(r103);     // Catch: Throwable -> L11 Exception -> L20
        goto L5
    L8:
        String r104 = r102.toString();     // Catch: Throwable -> L11 Exception -> L20
        com.xiaomi.push.v.a(r101);
        return r104;
    L11:
        Throwable th10 = th;
    L15:
        com.xiaomi.push.v.a(r101);
        throw th10;
    L18:
        com.xiaomi.push.v.a(r101);
        return null;
    L17:
        r101 = null;
    L13:
        th = move-exception;
        r101 = null;
        th10 = th;
        goto L15
    }

    private static boolean b(String r100) {
        long r101 = System.currentTimeMillis();
        com.xiaomi.channel.commonutils.logger.b.m8718a("ConnectivityTest: begin to connect to " + r100);     // Catch: Throwable -> L5
        Socket r102 = new Socket();     // Catch: Throwable -> L5
        r102.connect(cd.m8893a(r100, 5222), 5000);     // Catch: Throwable -> L5
        r102.setTcpNoDelay(true);     // Catch: Throwable -> L5
        com.xiaomi.channel.commonutils.logger.b.m8718a("ConnectivityTest: connect to " + r100 + " in " + (System.currentTimeMillis() - r101));     // Catch: Throwable -> L5
        r102.close();     // Catch: Throwable -> L5
        return true;
    L5:
        th = move-exception;
        com.xiaomi.channel.commonutils.logger.b.d("ConnectivityTest: could not connect to:" + r100 + " exception: " + th.getClass().getSimpleName() + " description: " + th.getMessage());
        return false;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static /* synthetic */ boolean m9431a(String r100) {
        return b(r100);
    }

    public static void a(final List<String> r100, final boolean r101) {
        f1154a.execute(new AnonymousClass1(r100, r101));
    }
}
