package com.xiaomi.push;

import com.ss.android.download.api.constant.BaseConstants;
import com.ss.ttm.player.MediaPlayer;
import com.xiaomi.push.service.XMPushService;
import java.util.ArrayList;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes41.dex */
public class en {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f463492a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private long f508a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private aw f509a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private em f510a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private String f511a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private boolean f512a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final en f463494a = null;

        static {
            f463494a = new en();
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized ei m9052a() {
        monitor-enter(this);
        ei r100 = new ei();     // Catch: Throwable -> L6
        r100.a(at.m8815a(this.f510a.f505a));     // Catch: Throwable -> L6
        r100.f482a = 0;     // Catch: Throwable -> L6
        r100.f486b = 1;     // Catch: Throwable -> L6
        r100.d((int) (System.currentTimeMillis() / 1000));     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public en() {
        this.f512a = false;
        this.f509a = aw.a();
    }

    public boolean b() {
        m9051a();
        if (this.f512a == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f509a.m8827a() <= 0) goto L7;
        return true;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized ej m9053a() {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (b() == true) goto L6;
        ej r100 = null;
    L12:
        monitor-exit(this);
        return r100;
    L6:
        if (at.d(this.f510a.f505a) == true) goto L8;
        int r101 = MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS;
    L9:
        r100 = a(r101);     // Catch: Throwable -> L14
        goto L12
    L8:
        r101 = 750;
        goto L9
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private void m9051a() {
        if (this.f512a == true) goto L5;
        return;
    L5:
        if ((System.currentTimeMillis() - this.f508a) <= this.f463492a) goto L9;
        this.f512a = false;
        this.f508a = 0;
        return;
    }

    public static em a() {
        en r100 = a.f463494a;
        monitor-enter(r100);
        em r101 = r100.f510a;     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static en m9050a() {
        return a.f463494a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m9055a() {
        return this.f512a;
    }

    private ej a(int r100) {
        ArrayList r101 = new ArrayList();
        ej r102 = new ej(this.f511a, r101);
        if (at.d(this.f510a.f505a) == true) goto L5;
        r102.a(i.i(this.f510a.f505a));
    L5:
        ih r103 = new ih(r100);
        hz r104 = new Cif.a().a(r103);
        r102.b(r104);     // Catch: ht -> L21
    L7:
        LinkedList<aw.a> r105 = this.f509a.m8828a();
    L23:
        if (r105.size() <= 0) goto L20;
        ei r106 = a(r105.getLast());     // Catch: Throwable -> L22
        if (r106 == null) goto L14;
        r106.b(r104);     // Catch: Throwable -> L22
    L14:
        if (r103.a() > r100) goto L20;
        if (r106 == null) goto L18;
        r101.add(r106);     // Catch: Throwable -> L22
    L18:
        r105.removeLast();     // Catch: Throwable -> L22
    L20:
        return r102;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m9054a(int r100) {
        if (r100 <= 0) goto L12;
        int r101 = r100 * 1000;
        if (r101 <= 604800000) goto L7;
        r101 = BaseConstants.Time.WEEK;
    L7:
        if (this.f463492a == r101) goto L9;
    L10:
        this.f512a = true;
        this.f508a = System.currentTimeMillis();
        this.f463492a = r101;
        com.xiaomi.channel.commonutils.logger.b.c("enable dot duration = " + r101 + " start = " + this.f508a);
        return;
    L9:
        if (this.f512a == false) goto L10;
        return;
    }

    private ei a(aw.a r100) {
        if (r100.f254a != 0) goto L8;
        Object r101 = r100.f255a;
        if ((r101 instanceof ei) == true) goto L10;
        return null;
    L10:
        return (ei) r101;
    L8:
        ei r102 = m9052a();
        r102.a(eh.f463453k.a());
        r102.c(r100.f254a);
        r102.c(r100.f256a);
        return r102;
    }

    public synchronized void a(XMPushService r100) {
        monitor-enter(this);
        this.f510a = new em(r100);     // Catch: Throwable -> L6
        this.f511a = "";     // Catch: Throwable -> L6
        com.xiaomi.push.service.ax.a().a(new AnonymousClass1(this));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void a(ei r100) {
        monitor-enter(this);
        this.f509a.a(r100);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
