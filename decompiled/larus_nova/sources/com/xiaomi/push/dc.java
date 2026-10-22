package com.xiaomi.push;

import android.content.Context;
import android.os.Handler;
import android.os.Process;
import android.util.Log;
import android.util.Pair;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.xiaomi.channel.commonutils.logger.LoggerInterface;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes41.dex */
public class dc implements LoggerInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile dc f463330a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static String f371a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final SimpleDateFormat f372a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static List<Pair<String, Throwable>> f373a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Context f374a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Handler f375a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f463331b;

    static {
        f372a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss aaa");
        f371a = "/MiPushLog";
        f373a = Collections.synchronizedList(new ArrayList());
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private void m8935a() {
        BufferedWriter r100 = null;
        PolarisFileWrapper r101 = new PolarisFileWrapper(this.f374a.getFilesDir(), f371a);     // Catch: Throwable -> L52 Exception -> L67
        if (u.m9432a(r101) == true) goto L8;
        r101.toString();     // Catch: Throwable -> L52 Exception -> L67
        return;
    L8:
        if (r101.exists() == false) goto L12;
        if (r101.isDirectory() == false) goto L12;
    L14:
        PolarisFileWrapper r102 = new PolarisFileWrapper(r101, "log.lock");     // Catch: Throwable -> L52 Exception -> L67
        if (r102.exists() == true) goto L17;
    L18:
        r102.createNewFile();     // Catch: Throwable -> L52 Exception -> L67
    L19:
        RandomAccessFile r103 = new RandomAccessFile(r102, "rw");     // Catch: Throwable -> L52 Exception -> L67
        FileLock r104 = r103.getChannel().lock();     // Catch: Throwable -> L49 Exception -> L51
        BufferedWriter r105 = new BufferedWriter(new OutputStreamWriter(new PolarisFileOutputStreamWrapper(new PolarisFileWrapper(r101, "log1.txt"), true)));     // Catch: Throwable -> L47 Exception -> L84
    L104:
    L46:
        r100 = r105;
    L44:
        th = th;
        r100 = r105;
    L54:
        if (r100 != null) goto L89;
    L58:
        if (r104 != null) goto L60;
    L64:
        if (r103 == null) goto L109;
        r103.close();     // Catch: IOException -> L83
        throw th;
    L110:
        throw th;
    L109:
        throw th;
    L60:
        if (r104.isValid() == false) goto L64;
        r104.release();     // Catch: IOException -> L63
        goto L64
    L89:
        r100.close();     // Catch: IOException -> L57
        goto L58
    L23:
        if (f373a.isEmpty() == true) goto L29;
        Pair<String, Throwable> r106 = f373a.remove(0);     // Catch: Throwable -> L44 Exception -> L46
        String r107 = (String) r106.first;     // Catch: Throwable -> L44 Exception -> L46
        if (r106.second == null) goto L28;
        r107 = (r107 + "\n") + Log.getStackTraceString((Throwable) r106.second);     // Catch: Throwable -> L44 Exception -> L46
    L28:
        r105.write(r107 + "\n");     // Catch: Throwable -> L44 Exception -> L46
        goto L104
    L29:
        r105.flush();     // Catch: Throwable -> L44 Exception -> L46
        r105.close();     // Catch: Throwable -> L44 Exception -> L46
        PolarisFileWrapper r108 = new PolarisFileWrapper(r101, "log1.txt");     // Catch: Throwable -> L47 Exception -> L84
        if (r108.length() < 1048576) goto L38;
        PolarisFileWrapper r109 = new PolarisFileWrapper(r101, "log0.txt");     // Catch: Throwable -> L47 Exception -> L84
        if (r109.exists() == true) goto L35;
    L37:
        r108.renameTo(r109);     // Catch: Throwable -> L47 Exception -> L84
        goto L68
    L35:
        if (r109.isFile() == false) goto L37;
        r109.delete();     // Catch: Throwable -> L47 Exception -> L84
    L38:
        if (r104 != null) goto L40;
    L97:
        r103.close();     // Catch: IOException -> L82
        return;
    L112:
        return;
    L40:
        if (r104.isValid() == false) goto L97;
        r104.release();     // Catch: IOException -> L81
        goto L97
    L47:
        th = th;
    L68:
        if (r100 != null) goto L91;
    L72:
        if (r104 != null) goto L74;
    L78:
        if (r103 != null) goto L97;
        return;
    L74:
        if (r104.isValid() == false) goto L78;
        r104.release();     // Catch: IOException -> L77
        goto L78
    L91:
        r100.close();     // Catch: IOException -> L71
        goto L72
    L51:
        r104 = null;
    L49:
        th = th;
        r104 = null;
        goto L54
    L17:
        if (r102.isDirectory() == false) goto L19;
    L12:
        if (r101.mkdirs() == true) goto L14;
        return;
    L67:
        r104 = null;
        r103 = null;
    L52:
        th = th;
        r104 = null;
        r103 = null;
        goto L54
    }

    public static /* synthetic */ SimpleDateFormat a() {
        return f372a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static /* synthetic */ List m8934a() {
        return f373a;
    }

    private dc(Context r100) {
        this.f374a = r100;
        if (r100.getApplicationContext() == null) goto L5;
        this.f374a = r100.getApplicationContext();
    L5:
        this.f463331b = this.f374a.getPackageName() + "-" + Process.myPid();
        PthreadHandlerThreadV2 r101 = new PthreadHandlerThreadV2("Log2FileHandlerThread");
        ThreadMethodProxy.start(r101);
        this.f375a = new Handler(r101.getLooper());
    }

    public static dc a(Context r100) {
        if (f463330a != null) goto L15;
        monitor-enter(dc.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f463330a != null) goto L9;
        f463330a = new dc(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(dc.class);     // Catch: Throwable -> L11
    L15:
        return f463330a;
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public final void log(String r100) {
        log(r100, null);
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public final void setTag(String r100) {
        this.f463331b = r100;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static /* synthetic */ void m8936a(dc r100) {
        r100.m8935a();
    }

    public static /* synthetic */ String a(dc r100) {
        return r100.f463331b;
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public final void log(final String r100, final Throwable r101) {
        this.f375a.post(new AnonymousClass1(this, r100, r101));
    }
}
