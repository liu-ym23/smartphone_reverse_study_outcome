package com.ss.android.lark.monitor;

import android.app.Application;
import com.larksuite.framework.thread.CoreThreadPool;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes36.dex */
public final class LarkMetrics implements k.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Application f432307a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public y f432308b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CopyOnWriteArrayList<com.ss.android.lark.monitor.a> f432309c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public i f432310d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ScheduledExecutorService f432311e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.ss.android.lark.monitor.traffic.j f432312f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public k f432313g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f432314h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f432315i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile boolean f432316j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile boolean f432317k;

    @Retention(RetentionPolicy.SOURCE)
    public @interface SwitchType {
        public static final int BACK_TO_BACK = 2;
        public static final int BACK_TO_FORE = 0;
        public static final int FORE_TO_BACK = 1;
        public static final int FORE_TO_FORE = 3;
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final LarkMetrics f432318a = null;

        static {
            f432318a = new LarkMetrics();
        }
    }

    public LarkMetrics() {
        this.f432309c = new CopyOnWriteArrayList();
        this.f432315i = System.currentTimeMillis();
        this.f432316j = true;
        this.f432317k = false;
    }

    public final void a(final i r100) {
        Iterator r101 = ((ArrayList) r100.f432399c).iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        String r102 = (String) r101.next();
        if (r100.f432401e.contains(r102) == false) goto L4;
        return;
    L8:
        this.f432310d = r100;
        this.f432317k = r100.f432404h;
        if (r100.f432400d == false) goto L11;
        com.ss.android.lark.monitor.traffic.j r103 = new com.ss.android.lark.monitor.traffic.j(r100);
        this.f432312f = r103;
        this.f432309c.add(r103);
    L11:
        int r104 = w.f432536a;
        ScheduledExecutorService r105 = CoreThreadPool.getDefault().getScheduleThreadPool();
        this.f432311e = r105;
        r105.execute(new h(this, r100));
    }

    public final void b(final String r100) {
        boolean r101 = this.f432316j;
        this.f432316j = false;
        if (r101 == true) goto L5;
    L7:
        this.f432311e.execute(new g(this, r100));
        return;
    L5:
        if ((System.currentTimeMillis() - this.f432315i) >= 5000) goto L7;
    }
}
