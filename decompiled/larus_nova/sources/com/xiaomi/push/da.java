package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes41.dex */
public class da {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile da f463319a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Context f357a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final ConcurrentLinkedQueue<b> f358a;

    public class a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ da f463323a;

        @Override // com.xiaomi.push.da.b, com.xiaomi.push.ae.b
        public void b() {
            da.m8931a(this.f463323a);
        }

        public a(da r100) {
            this.f463323a = r100;
            super(r100);
        }
    }

    public class b extends ae.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f463324a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ da f463325b;

        public boolean a() {
            return true;
        }

        @Override // com.xiaomi.push.ae.b
        public void b() {
        }

        /* JADX INFO: renamed from: b, reason: collision with other method in class */
        public final boolean m8932b() {
            if ((System.currentTimeMillis() - this.f463324a) <= 172800000) goto L5;
            return true;
        L5:
            return false;
        }

        public b(da r100) {
            this.f463325b = r100;
            this.f463324a = System.currentTimeMillis();
        }
    }

    public class c extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f463326a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        final /* synthetic */ da f366a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        File f367a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        String f368a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        boolean f369a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f463327b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        boolean f370b;

        private boolean c() {
            int r100 = 0;
            SharedPreferences r101 = da.a(this.f366a).getSharedPreferences("log.timestamp", 0);
            String r102 = r101.getString("log.requst", "");
            long r103 = System.currentTimeMillis();
            JSONObject r104 = new JSONObject(r102);     // Catch: JSONException -> L5
            r103 = JSONObjectProtectorUtils.getLong(r104, "time");     // Catch: JSONException -> L5
            int r105 = JSONObjectProtectorUtils.getInt(r104, "times");     // Catch: JSONException -> L5
        L7:
            if ((System.currentTimeMillis() - r103) < 86400000) goto L9;
            r103 = System.currentTimeMillis();
        L13:
            JSONObject r106 = new JSONObject();
            r106.put("time", r103);     // Catch: JSONException -> L16
            r106.put("times", r100 + 1);     // Catch: JSONException -> L16
            r101.edit().putString("log.requst", r106.toString()).commit();     // Catch: JSONException -> L16
        L18:
            return true;
        L16:
            e = move-exception;
            com.xiaomi.channel.commonutils.logger.b.c("JSONException on put " + e.getMessage());
            goto L18
        L9:
            if (r105 <= 10) goto L11;
            return false;
        L11:
            r100 = r105;
        L5:
            r105 = 0;
            goto L7
        }

        @Override // com.xiaomi.push.da.b
        public boolean a() {
            if (at.d(da.a(this.f366a)) == false) goto L5;
        L10:
            return true;
        L5:
            if (this.f370b == true) goto L7;
        L9:
            return false;
        L7:
            if (at.m8819a(da.a(this.f366a)) == false) goto L9;
            goto L9
        }

        @Override // com.xiaomi.push.da.b, com.xiaomi.push.ae.b
        public void b() {
            if (c() == false) goto L5;
            HashMap r100 = new HashMap();     // Catch: IOException -> L7
            r100.put("uid", com.xiaomi.push.service.ax.m9373a());     // Catch: IOException -> L7
            r100.put("token", this.f463327b);     // Catch: IOException -> L7
            r100.put(com.alipay.sdk.m.k.b.f25406k, at.m8815a(da.a(this.f366a)));     // Catch: IOException -> L7
            at.a(this.f368a, r100, this.f367a, "file");     // Catch: IOException -> L7
        L5:
            this.f369a = true;     // Catch: IOException -> L7
            return;
        }

        @Override // com.xiaomi.push.ae.b
        /* JADX INFO: renamed from: c, reason: collision with other method in class */
        public void mo8933c() {
            if (this.f369a == true) goto L8;
            int r100 = this.f463326a + 1;
            this.f463326a = r100;
            if (r100 >= 3) goto L8;
            da.m8930a(this.f366a).add(this);
        L8:
            if (this.f369a == false) goto L10;
        L11:
            this.f367a.delete();
        L12:
            da.a(this.f366a, (1 << this.f463326a) * 1000);
            return;
        L10:
            if (this.f463326a < 3) goto L12;
            goto L11
        }

        public c(da r100, String r101, String r102, File r103, boolean r104) {
            this.f366a = r100;
            super(r100);
            this.f368a = r101;
            this.f463327b = r102;
            this.f367a = r103;
            this.f370b = r104;
        }
    }

    private void b() {
        PolarisFileWrapper r100 = new PolarisFileWrapper(this.f357a.getFilesDir() + "/.logcache");     // Catch: NullPointerException -> L11
        if (r100.exists() == true) goto L5;
        return;
    L5:
        if (r100.isDirectory() == false) goto L15;
        File[] r101 = r100.listFiles();     // Catch: NullPointerException -> L11
        int r102 = r101.length;     // Catch: NullPointerException -> L11
        int r103 = 0;
    L7:
        if (r103 >= r102) goto L17;
        r101[r103].delete();     // Catch: NullPointerException -> L11
        r103 = r103 + 1;
        goto L7
    L17:
        return;
    L15:
        return;
    }

    private void c() {
    L3:
        if (this.f358a.isEmpty() == true) goto L11;
        b r100 = this.f358a.peek();
        if (r100 == null) goto L3;
        if (r100.m8932b() == false) goto L9;
    L10:
        com.xiaomi.channel.commonutils.logger.b.c("remove Expired task");
        this.f358a.remove(r100);
        goto L3
    L9:
        if (this.f358a.size() > 6) goto L10;
        return;
    }

    public void a() {
        c();
        a(0);
    }

    private da(Context r100) {
        ConcurrentLinkedQueue<b> r101 = new ConcurrentLinkedQueue();
        this.f358a = r101;
        this.f357a = r100;
        r101.add(new a(this));
        b(0);
    }

    public static da a(Context r100) {
        if (f463319a == null) goto L5;
    L14:
        f463319a.f357a = r100;
        return f463319a;
    L5:
        monitor-enter(da.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f463319a != null) goto L9;
        f463319a = new da(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(da.class);     // Catch: Throwable -> L11
        goto L14
    }

    private void b(long r100) {
        if (this.f358a.isEmpty() == true) goto L6;
        fx.a(new AnonymousClass2(this), r100);
        return;
    }

    private void a(long r100) {
        b r101 = this.f358a.peek();
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.a() == false) goto L9;
        b(r100);
        return;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static /* synthetic */ void m8931a(da r100) {
        r100.b();
    }

    public static /* synthetic */ Context a(da r100) {
        return r100.f357a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static /* synthetic */ ConcurrentLinkedQueue m8930a(da r100) {
        return r100.f358a;
    }

    public static /* synthetic */ void a(da r100, long r101) {
        r100.a(r101);
    }

    public void a(final String r110, final String r111, final Date r112, final Date r113, final int r114, final boolean r115) {
        this.f358a.add(new AnonymousClass1(this, r114, r112, r113, r110, r111, r115));
        b(0);
    }
}
