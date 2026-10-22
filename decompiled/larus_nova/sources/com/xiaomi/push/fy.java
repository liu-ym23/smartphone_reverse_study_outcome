package com.xiaomi.push;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes41.dex */
public class fy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile int f463632a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static long f595a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static ae f596a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static com.xiaomi.push.providers.a f597a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final Object f598a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static String f599a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static List<a> f600a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f463634a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public long f601a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public String f602a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f463635b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public long f603b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public String f604b;

        public boolean a(a r100) {
            if (TextUtils.equals(r100.f602a, this.f602a) == true) goto L5;
            return false;
        L5:
            if (TextUtils.equals(r100.f604b, this.f604b) == true) goto L7;
            return false;
        L7:
            if (r100.f463634a == this.f463634a) goto L9;
            return false;
        L9:
            if (r100.f463635b == this.f463635b) goto L11;
            return false;
        L11:
            if (Math.abs(r100.f601a - this.f601a) > 5000) goto L20;
            return true;
        L20:
            return false;
        }

        public a(String r100, long r101, int r102, int r103, String r104, long r105) {
            this.f602a = r100;
            this.f601a = r101;
            this.f463634a = r102;
            this.f463635b = r103;
            this.f604b = r104;
            this.f603b = r105;
        }
    }

    static {
        f596a = new ae(true);
        f463632a = -1;
        f595a = System.currentTimeMillis();
        f598a = new Object();
        f600a = Collections.synchronizedList(new ArrayList());
        f599a = "";
        f597a = null;
    }

    public static /* synthetic */ Object a() {
        return f598a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static /* synthetic */ List m9114a() {
        return f600a;
    }

    private static void a(a r100) {
        Iterator<a> r101 = f600a.iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        a r102 = r101.next();
        if (r102.a(r100) == false) goto L4;
        r102.f603b += r100.f603b;
        return;
    L9:
        f600a.add(r100);
    }

    private static int b(Context r100) {
        au r101 = at.m8812a();
        if (r101 != null) goto L7;
        return -1;
    L7:
        return r101.a();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static synchronized String m9113a(Context r100) {
        monitor-enter(fy.class);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (TextUtils.isEmpty(f599a) == true) goto L10;
        String r101 = f599a;     // Catch: Throwable -> L12
        monitor-exit(fy.class);
        return r101;
    L10:
        monitor-exit(fy.class);
        return "";
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static synchronized void m9116a(String r100) {
        monitor-enter(fy.class);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (j.m9300d() == false) goto L7;
    L9:
        monitor-exit(fy.class);
        return;
    L7:
        if (TextUtils.isEmpty(r100) == true) goto L9;
        f599a = r100;     // Catch: Throwable -> L11
        goto L9
    }

    public static int a(Context r100) {
        if (f463632a != (-1)) goto L6;
        f463632a = b(r100);
    L6:
        return f463632a;
    }

    public static int a(String r100) {
        return r100.getBytes("UTF-8").length;
    L5:
        return r100.getBytes().length;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static com.xiaomi.push.providers.a m9112a(Context r100) {
        com.xiaomi.push.providers.a r101 = f597a;
        if (r101 == null) goto L5;
        return r101;
    L5:
        com.xiaomi.push.providers.a r102 = new com.xiaomi.push.providers.a(r100);
        f597a = r102;
        return r102;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static void m9115a(Context r100) {
        f463632a = b(r100);
    }

    public static /* synthetic */ void a(Context r100, List r101) {
        b(r100, r101);
    }

    private static void b(Context r100, List<a> r101) {
        Object r102 = com.xiaomi.push.providers.a.f970a;     // Catch: Throwable -> L19
        monitor-enter(r102);     // Catch: Throwable -> L19
        SQLiteDatabase r103 = m9112a(r100).getWritableDatabase();     // Catch: Throwable -> L16
        r103.beginTransaction();     // Catch: Throwable -> L16
        Iterator<a> r104 = r101.iterator();     // Catch: Throwable -> L13
    L7:
        if (r104.hasNext() == false) goto L9;
        a r105 = r104.next();     // Catch: Throwable -> L13
        ContentValues r106 = new ContentValues();     // Catch: Throwable -> L13
        r106.put("package_name", r105.f602a);     // Catch: Throwable -> L13
        r106.put("message_ts", Long.valueOf(r105.f601a));     // Catch: Throwable -> L13
        r106.put("network_type", Integer.valueOf(r105.f463634a));     // Catch: Throwable -> L13
        r106.put(HTTP.CONTENT_RANGE_BYTES, Long.valueOf(r105.f603b));     // Catch: Throwable -> L13
        r106.put("rcv", Integer.valueOf(r105.f463635b));     // Catch: Throwable -> L13
        r106.put("imsi", r105.f604b);     // Catch: Throwable -> L13
        r103.insert("traffic", null, r106);     // Catch: Throwable -> L13
        goto L7
    L9:
        r103.setTransactionSuccessful();     // Catch: Throwable -> L13
        r103.endTransaction();     // Catch: Throwable -> L16
        monitor-exit(r102);     // Catch: Throwable -> L16
        return;
    L13:
        th = move-exception;
        r103.endTransaction();     // Catch: Throwable -> L16
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        com.xiaomi.channel.commonutils.logger.b.a(th);
    }

    private static void a(final Context r110, String r111, long r112, boolean r113, long r114) {
        if (r110 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r111) == false) goto L7;
        return;
    L7:
        if ("com.xiaomi.xmsf".equals(r110.getPackageName()) == true) goto L9;
        return;
    L9:
        if ("com.xiaomi.xmsf".equals(r111) == true) goto L34;
        int r100 = a(r110);
        if ((-1) != r100) goto L14;
        return;
    L14:
        Object r101 = f598a;
        monitor-enter(r101);
        boolean r115 = f600a.isEmpty();     // Catch: Throwable -> L25
        if (r100 != 0) goto L19;
        String r102 = m9113a(r110);     // Catch: Throwable -> L25
    L20:
        int r116 = r113 ? 1 : 0;
        a(new a(r111, r114, r100, r116, r102, r112));     // Catch: Throwable -> L25
        monitor-exit(r101);     // Catch: Throwable -> L25
        if (r115 == false) goto L31;
        f596a.a(new AnonymousClass1(r110), 5000);
        return;
    L31:
        return;
    L19:
        r102 = "";
    L25:
        th = move-exception;
        throw th;
    }

    private static long a(int r100, long r101, boolean r102, long r103, boolean r104) {
        if (r102 == false) goto L10;
        if (r104 == false) goto L10;
        long r105 = f595a;
        f595a = r103;
        if ((r103 - r105) <= 30000) goto L10;
        if (r101 <= 1024) goto L10;
        return r101 * 2;
    L10:
        if (r100 != 0) goto L12;
        int r106 = 13;
    L14:
        return (r101 * ((long) r106)) / 10;
    L12:
        r106 = 11;
        goto L14
    }

    public static void a(Context r100, String r101, long r110, boolean r111, boolean r112, long r113) {
        a(r100, r101, a(a(r100), r110, r111, r113, r112), r111, r113);
    }
}
