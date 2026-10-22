package com.xiaomi.push;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.bridge.annotation.BridgeSyncType;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import com.xiaomi.push.service.XMPushService;
import java.util.Iterator;

/* JADX INFO: loaded from: classes41.dex */
public class ex extends fg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private es f463508a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private et f537a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Thread f538a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private byte[] f539a;

    @Override // com.xiaomi.push.ez
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean mo9075a() {
        return true;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized byte[] m9076a() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.f539a == null) goto L6;
    L8:
        byte[] r100 = this.f539a;     // Catch: Throwable -> L11
        monitor-exit(this);
        return r100;
    L6:
        if (TextUtils.isEmpty(this.f553a) == true) goto L8;
        String r101 = com.xiaomi.push.service.ax.m9373a();     // Catch: Throwable -> L11
        StringBuilder r102 = new StringBuilder();     // Catch: Throwable -> L11
        String r103 = this.f553a;     // Catch: Throwable -> L11
        r102.append(r103.substring(r103.length() / 2));     // Catch: Throwable -> L11
        r102.append(r101.substring(r101.length() / 2));     // Catch: Throwable -> L11
        String r104 = r102.toString();     // Catch: Throwable -> L11
        this.f539a = com.xiaomi.push.service.ar.a(this.f553a.getBytes(), r104.getBytes());     // Catch: Throwable -> L11
        goto L8
    }

    private void h() {
        this.f463508a = new es(this.f567a.getInputStream(), this);     // Catch: Exception -> L5
        this.f537a = new et(this.f567a.getOutputStream(), this);     // Catch: Exception -> L5
        final String r100 = "Blob Reader (" + this.f463515b + ")";     // Catch: Exception -> L5
        PthreadThreadV2 r101 = new AnonymousClass1(this, r100);     // Catch: Exception -> L5
        this.f538a = r101;     // Catch: Exception -> L5
        ThreadMethodProxy.start(r101);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        throw new fh("Error to init reader and writer", e);
    }

    @Override // com.xiaomi.push.fg
    /* JADX INFO: renamed from: a */
    public synchronized void mo9094a() {
        monitor-enter(this);
        h();     // Catch: Throwable -> L6
        this.f537a.a();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public void a(eq r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (com.xiaomi.push.service.e.a(r100) == false) goto L8;
        eq r101 = new eq();
        r101.a(r100.a());
        r101.a(BridgeSyncType.SYNC, "ACK_RTT");
        r101.a(r100.e());
        r101.b(r100.m9064b());
        r101.a(r100.m9067c());
        XMPushService r102 = this.f552a;
        r102.a(new com.xiaomi.push.service.aw(r102, r101));
    L8:
        if (r100.m9061a() == false) goto L11;
        com.xiaomi.channel.commonutils.logger.b.m8718a("[Slim] RCV blob chid=" + r100.a() + "; id=" + r100.e() + "; errCode=" + r100.b() + "; err=" + r100.m9068c());
    L11:
        if (r100.a() == 0) goto L13;
    L18:
        Iterator<ez.a> r103 = this.f556a.values().iterator();
    L20:
        if (r103.hasNext() == false) goto L22;
        r103.next().a(r100);
        goto L20
    L22:
        return;
    L13:
        if ("PING".equals(r100.m9058a()) == false) goto L16;
        com.xiaomi.channel.commonutils.logger.b.m8718a("[Slim] RCV ping id=" + r100.e());
        g();
        goto L18
    L16:
        if ("CLOSE".equals(r100.m9058a()) == false) goto L18;
        c(13, null);
        goto L18
    }

    @Override // com.xiaomi.push.ez
    public void b(eq r110) {
        et r100 = this.f537a;
        if (r100 == null) goto L17;
        int r101 = r100.a(r110);     // Catch: Exception -> L13
        this.f463517d = SystemClock.elapsedRealtime();     // Catch: Exception -> L13
        String r102 = r110.f();     // Catch: Exception -> L13
        if (TextUtils.isEmpty(r102) == true) goto L7;
        fy.a(this.f552a, r102, r101, false, true, System.currentTimeMillis());     // Catch: Exception -> L13
    L7:
        Iterator<ez.a> r103 = this.f559b.values().iterator();     // Catch: Exception -> L13
    L8:
        if (r103.hasNext() == false) goto L12;
        r103.next().a(r110);     // Catch: Exception -> L13
        goto L8
    L12:
        return;
    L13:
        e = move-exception;
        throw new fh(e);
    L17:
        throw new fh("the writer is null.");
    }

    @Override // com.xiaomi.push.fg
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void mo9074a(boolean r100) {
        if (this.f537a == null) goto L7;
        eq r101 = a(r100);
        com.xiaomi.channel.commonutils.logger.b.m8718a("[Slim] SND ping id=" + r101.e());
        b(r101);
        f();
        return;
    L7:
        throw new fh("The BlobWriter is null.");
    }

    public void b(fn r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Iterator<ez.a> r101 = this.f556a.values().iterator();
    L6:
        if (r101.hasNext() == false) goto L8;
        r101.next().a(r100);
        goto L6
    }

    private eq a(boolean r100) {
        ew r101 = new ew();
        if (r100 == false) goto L5;
        r101.a("1");
    L5:
        byte[] r102 = eo.m9056a();
        if (r102 == null) goto L8;
        Cdo.j r103 = new Cdo.j();
        r103.a(a.a(r102));
        r101.a(r103.m9042a(), null);
    L8:
        return r101;
    }

    @Override // com.xiaomi.push.ez
    public synchronized void a(com.xiaomi.push.service.am.b r100) {
        monitor-enter(this);
        ep.a(r100, c(), this);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.xiaomi.push.fg, com.xiaomi.push.ez
    public void a(eq[] r100) {
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        b(r100[r102]);
        r102 = r102 + 1;
        goto L3
    }

    @Override // com.xiaomi.push.ez
    public void a(fn r100) {
        b(eq.a(r100, null));
    }

    public static /* synthetic */ es a(ex r100) {
        return r100.f463508a;
    }

    public ex(XMPushService r100, fa r101) {
        super(r100, r101);
    }

    @Override // com.xiaomi.push.fg
    public synchronized void a(int r100, Exception r101) {
        monitor-enter(this);
        es r102 = this.f463508a;     // Catch: Throwable -> L17
        if (r102 == null) goto L7;
        r102.b();     // Catch: Throwable -> L17
        this.f463508a = null;     // Catch: Throwable -> L17
    L7:
        et r103 = this.f537a;     // Catch: Throwable -> L17
        if (r103 != null) goto L20;
    L14:
        this.f539a = null;     // Catch: Throwable -> L17
        super.a(r100, r101);     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L20:
        r103.b();     // Catch: Exception -> L11 Throwable -> L17
    L13:
        this.f537a = null;     // Catch: Throwable -> L17
        goto L14
    L11:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.d("SlimConnection shutdown cause exception: " + e);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    @Override // com.xiaomi.push.ez
    public synchronized void a(String r100, String r101) {
        monitor-enter(this);
        ep.a(r100, r101, this);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
