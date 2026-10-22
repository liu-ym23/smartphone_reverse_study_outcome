package com.tencent.open.log;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.mira.conig.Constants;
import com.bytedance.security.android.aopcheck.PolarisFileWriterWrapper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.tencent.tauth.Tencent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/* JADX INFO: loaded from: classes31.dex */
public class a extends Tracer implements Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b f461775a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private FileWriter f461776b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private FileWriter f461777c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private File f461778d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private File f461779e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private char[] f461780f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile f f461781g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile f f461782h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private volatile f f461783i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private volatile f f461784j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private volatile boolean f461785k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private HandlerThread f461786l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Handler f461787m;

    private void j() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.f461783i != this.f461781g) goto L6;
        this.f461783i = this.f461782h;     // Catch: Throwable -> L9
        this.f461784j = this.f461781g;     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);     // Catch: Throwable -> L9
        return;
    L6:
        this.f461783i = this.f461781g;     // Catch: Throwable -> L9
        this.f461784j = this.f461782h;     // Catch: Throwable -> L9
        goto L7
    }

    private void h() {
        FileWriter r100 = this.f461776b;     // Catch: IOException -> L6
        if (r100 == null) goto L11;
        r100.flush();     // Catch: IOException -> L6
        this.f461776b.close();     // Catch: IOException -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        SLog.e(SLog.TAG, "-->closeFileWriter() exception:", e);
    }

    private void i() {
        FileWriter r100 = this.f461777c;     // Catch: IOException -> L6
        if (r100 == null) goto L11;
        r100.flush();     // Catch: IOException -> L6
        this.f461777c.close();     // Catch: IOException -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        SLog.e(SLog.TAG, "-->closeAppSpecificFileWriter() exception:", e);
    }

    public void a() {
        if (this.f461787m.hasMessages(1024) == false) goto L5;
        this.f461787m.removeMessages(1024);
    L5:
        this.f461787m.sendEmptyMessage(1024);
    }

    private void f() {
        if (ThreadMethodProxy.currentThread() == this.f461786l) goto L6;
        return;
    L6:
        if (this.f461785k == false) goto L8;
        return;
    L8:
        this.f461785k = true;
        j();
        this.f461784j.a(g(), this.f461780f);     // Catch: Throwable -> L11 IOException -> L13
    L10:
        this.f461784j.b();
        this.f461785k = false;
        return;
    L13:
        e = move-exception;
        SLog.e("FileTracer", "flushBuffer exception", e);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        this.f461784j.b();
        throw th;
    }

    private Writer[] g() {
        File[] r100 = c().a();
        if (r100 == null) goto L30;
        if (r100.length < 2) goto L30;
        File r101 = r100[0];
        if (r101 == null) goto L11;
        if (r101.equals(this.f461778d) == true) goto L11;
    L13:
        this.f461778d = r101;
        h();
        this.f461776b = new PolarisFileWriterWrapper(this.f461778d, true);     // Catch: IOException -> L16
    L17:
        File r102 = r100[1];
        if (r102 == null) goto L22;
        if (r102.equals(this.f461779e) == true) goto L22;
    L24:
        this.f461779e = r102;
        i();
        this.f461777c = new PolarisFileWriterWrapper(this.f461779e, true);     // Catch: IOException -> L27
    L28:
        a(r102);
    L27:
        this.f461777c = null;
        SLog.e(SLog.TAG, "-->obtainFileWriter() app specific file permission denied");
    L22:
        if (this.f461777c != null) goto L30;
        if (r102 == null) goto L30;
    L16:
        this.f461776b = null;
        SLog.e(SLog.TAG, "-->obtainFileWriter() old log file permission denied");
    L11:
        if (this.f461776b != null) goto L17;
        if (r101 == null) goto L17;
    L30:
        return new Writer[]{this.f461776b, this.f461777c};
    }

    public void b() {
        h();
        i();
        this.f461786l.quit();
    }

    public b c() {
        return this.f461775a;
    }

    public a(b r100) {
        this(c.f461799b, true, g.f461819a, r100);
    }

    private void a(File r110) {
        File r111 = r110.getParentFile();
        if (r111 != null) goto L5;
        return;
    L5:
        if (r111.exists() == true) goto L7;
        return;
    L7:
        if (r111.isDirectory() == false) goto L32;
        File[] r112 = r111.listFiles();
        if (r112 != null) goto L12;
        return;
    L12:
        int r100 = r112.length;
        int r101 = 0;
    L13:
        if (r101 >= r100) goto L33;
        File r102 = r112[r101];
        if (b(r102) == false) goto L25;
        String r103 = r102.getName();
        String r104 = r103.substring(32, 43);
        long r105 = System.currentTimeMillis();
        if (Tencent.USE_ONE_HOUR == false) goto L20;
        long r106 = 3600000;
    L22:
        if (b.a(r105 - r106).compareTo(r104) <= 0) goto L25;
        SLog.d("FileTracer", "delete name=" + r103 + ", success=" + r102.delete());
        goto L25
    L20:
        r106 = Constants.DOWNLOAD_TEMP_FILE_PAST_TIME;
    L25:
        r101 = r101 + 1;
        goto L13
    L33:
        return;
    }

    private boolean b(File r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        String r101 = r100.getName();
        SLog.d("FileTracer", "name=" + r101);
        if (TextUtils.isEmpty(r101) == false) goto L9;
        return false;
    L9:
        if (r101.length() == 47) goto L12;
        return false;
    L12:
        if (r101.startsWith("com.tencent.mobileqq_connectSdk.") == true) goto L14;
        return false;
    L14:
        if (r101.endsWith(".log") == false) goto L18;
        return true;
    L18:
        return false;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message r100) {
        if (r100.what != 1024) goto L8;
        f();
        return true;
    L8:
        return true;
    }

    private void a(String r100) {
        this.f461783i.a(r100);
        if (this.f461783i.a() < c().d()) goto L6;
        a();
        return;
    }

    public void a(b r100) {
        this.f461775a = r100;
    }

    public a(int r100, boolean r101, g r102, b r103) {
        super(r100, r101, r102);
        this.f461785k = false;
        a(r103);
        this.f461781g = new f();
        this.f461782h = new f();
        this.f461783i = this.f461781g;
        this.f461784j = this.f461782h;
        this.f461780f = new char[r103.d()];
        PthreadHandlerThreadV2 r104 = new PthreadHandlerThreadV2(r103.c(), r103.f());
        this.f461786l = r104;
        ThreadMethodProxy.start(r104);
        if (ThreadMethodProxy.isAlive(this.f461786l) == true) goto L5;
        return;
    L5:
        if (this.f461786l.getLooper() == null) goto L9;
        this.f461787m = new Handler(this.f461786l.getLooper(), this);
        return;
    }

    @Override // com.tencent.open.log.Tracer
    public void doTrace(int r100, Thread r110, long r111, String r112, String r113, Throwable r114) {
        a(e().a(r100, r110, r111, r112, r113, r114));
    }
}
