package com.vivo.push.util;

import android.text.TextUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes41.dex */
public final class ai {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final SimpleDateFormat f462556a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final SimpleDateFormat f462557b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile ai f462558c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private CopyOnWriteArrayList<a> f462559d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f462560e;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f462561a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f462562b;

        public final long a() {
            return this.f462561a;
        }

        public final long b() {
            return this.f462562b;
        }

        public a(long r100, long r101) {
            this.f462561a = r100;
            this.f462562b = r101;
        }
    }

    static {
        f462556a = new SimpleDateFormat("yyyy-MM-dd");
        f462557b = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    }

    public static synchronized ai a() {
        monitor-enter(ai.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f462558c != null) goto L7;
        f462558c = new ai();     // Catch: Throwable -> L10
    L7:
        ai r100 = f462558c;     // Catch: Throwable -> L10
        monitor-exit(ai.class);
        return r100;
    }

    private ai() {
        this.f462559d = new CopyOnWriteArrayList();
    }

    public final boolean a(String r210) {
        String r100 = " ";
        if (TextUtils.isEmpty(r210) == false) goto L5;
        return true;
    L5:
        char r101 = 0;
        if (TextUtils.isEmpty(r210) == false) goto L9;
        t.c("WindowPeriodManager", "invalid period");
    L35:
        if (ah.a(this.f462559d) == false) goto L37;
        return true;
    L37:
        long r102 = System.currentTimeMillis() - ag.a();
        Iterator<a> r103 = this.f462559d.iterator();
    L39:
        if (r103.hasNext() == false) goto L45;
        a r104 = r103.next();
        if (r102 < r104.a()) goto L39;
        if (r102 > r104.b()) goto L39;
        return true;
    L45:
        return false;
    L9:
        if (TextUtils.equals(r210, this.f462560e) == false) goto L11;
        t.c("WindowPeriodManager", "has already updated");
        goto L35
    L11:
        this.f462560e = r210;
        this.f462559d.clear();
        Date r105 = new Date();
        long r106 = ag.a();
        String[] r107 = r210.split(com.alipay.sdk.m.u.i.f25853b);
        int r110 = r107.length;
        int r111 = 0;
    L12:
        if (r111 >= r110) goto L35;
        String[] r112 = r107[r111].split("-");
        if (r112.length != 2) goto L33;
        SimpleDateFormat r108 = f462557b;     // Catch: Exception -> L20
        StringBuilder r113 = new StringBuilder();     // Catch: Exception -> L20
        SimpleDateFormat r114 = f462556a;     // Catch: Exception -> L20
        r113.append(r114.format(r105));     // Catch: Exception -> L20
        r113.append(r100);     // Catch: Exception -> L20
        r113.append(r112[r101]);     // Catch: Exception -> L20
        long r115 = r108.parse(r113.toString()).getTime();     // Catch: Exception -> L20
        long r116 = r108.parse(r114.format(r105) + r100 + r112[1]).getTime();     // Catch: Exception -> L18
        long r117 = r115;
    L24:
        if (r106 <= 0) goto L33;
        if (r117 <= 0) goto L33;
        if (r116 <= 0) goto L33;
        if (r117 >= r116) goto L33;
        this.f462559d.add(new a(r117 - r106, r116 - r106));
        t.c("WindowPeriodManager", "set window period to [" + r112[0] + ", " + r112[1] + "]");
    L18:
        e = e;
    L22:
        t.a("WindowPeriodManager", "parse window period failed." + e.getMessage());
        r117 = r115;
        r116 = -1;
    L20:
        e = e;
        r115 = -1;
    L33:
        r111 = r111 + 1;
        r100 = r100;
        r105 = r105;
        r101 = 0;
        goto L12
    }
}
