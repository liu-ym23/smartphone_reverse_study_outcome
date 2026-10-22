package com.xiaomi.mipush.sdk;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.bdlocation.utils.DimLocationCheckUtil;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.xiaomi.push.at;
import com.xiaomi.push.av;
import com.xiaomi.push.az;
import com.xiaomi.push.cr;
import com.xiaomi.push.ds;
import com.xiaomi.push.ge;
import com.xiaomi.push.gf;
import com.xiaomi.push.gi;
import com.xiaomi.push.gj;
import com.xiaomi.push.go;
import com.xiaomi.push.gr;
import com.xiaomi.push.ha;
import com.xiaomi.push.hd;
import com.xiaomi.push.he;
import com.xiaomi.push.hk;
import com.xiaomi.push.ho;
import com.xiaomi.push.hp;
import com.xiaomi.push.service.ah;
import com.xiaomi.push.service.aj;
import com.xiaomi.push.service.an;
import com.xiaomi.push.service.ap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes41.dex */
public class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static u f463086a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final ArrayList<a> f189a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f463087b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private long f190a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Context f191a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Intent f192a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Handler f193a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Messenger f194a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Integer f195a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private String f196a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private List<Message> f197a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private boolean f198a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private String f199b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f463088c;

    /* JADX INFO: renamed from: com.xiaomi.mipush.sdk.u$5, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass5 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f463093a = null;

        static {
            int[] r100 = new int[v.values().length];
            f463093a = r100;
            r100[v.f463095a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            f463093a[v.f463096b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            f463093a[v.f463097c.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            f463093a[v.f463098d.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            f463093a[v.f463099e.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            f463093a[v.f463100f.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    public static class a<T extends hp<T, ?>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        ge f463094a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        T f200a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        boolean f201a;

        public a() {
        }
    }

    static {
        f189a = new ArrayList();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private String m8779a() {
        String r100 = this.f199b;
        if (r100 == null) goto L12;
        return r100;
    L12:
        if (this.f191a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode < 106) goto L9;
        this.f199b = "com.xiaomi.push.service.XMPushService";     // Catch: Exception -> L11
        return "com.xiaomi.push.service.XMPushService";
    L9:
        this.f199b = "com.xiaomi.xmsf.push.service.XMPushService";
        return "com.xiaomi.xmsf.push.service.XMPushService";
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    private boolean m8781c() {
        PackageInfo r100 = this.f191a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4);     // Catch: Throwable -> L12
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.versionCode >= 105) goto L10;
        return false;
    L10:
        return true;
    L12:
        return false;
    }

    private void h() {
        PackageManager r100 = this.f191a.getPackageManager();     // Catch: Throwable -> L7
        ComponentName r101 = new ComponentName(this.f191a, "com.xiaomi.push.service.XMPushService");     // Catch: Throwable -> L7
        if (r100.getComponentEnabledSetting(r101) != 2) goto L5;
        return;
    L5:
        r100.setComponentEnabledSetting(r101, 2, 1);     // Catch: Throwable -> L7
        return;
    }

    private void i() {
        PackageManager r100 = this.f191a.getPackageManager();     // Catch: Throwable -> L7
        ComponentName r101 = new ComponentName(this.f191a, "com.xiaomi.push.service.XMPushService");     // Catch: Throwable -> L7
        if (r100.getComponentEnabledSetting(r101) != 1) goto L5;
        return;
    L5:
        r100.setComponentEnabledSetting(r101, 1, 1);     // Catch: Throwable -> L7
        return;
    }

    /* JADX INFO: renamed from: d, reason: collision with other method in class */
    public void m8793d() {
        ArrayList<a> r100 = f189a;
        monitor-enter(r100);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (ThreadMethodProxy.currentThread() != ThreadMethodProxy.getLooperThread(Looper.getMainLooper())) goto L7;
        boolean r101 = true;
    L8:
        Iterator<a> r102 = r100.iterator();     // Catch: Throwable -> L19
    L10:
        if (r102.hasNext() == false) goto L16;
        a r103 = r102.next();     // Catch: Throwable -> L19
        a(r103.f200a, r103.f463094a, r103.f201a, false, null, true);     // Catch: Throwable -> L19
        if (r101 == true) goto L10;
        Thread.sleep(100);     // Catch: InterruptedException -> L22 Throwable -> L19
        goto L10
    L16:
        f189a.clear();     // Catch: Throwable -> L19
        monitor-exit(r100);     // Catch: Throwable -> L19
        return;
    L7:
        r101 = false;
        goto L8
    }

    private void g() {
        this.f190a = SystemClock.elapsedRealtime();
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public boolean m8791b() {
        if (m8788a() == true) goto L5;
        return true;
    L5:
        if (m8783e() == true) goto L7;
        return true;
    L7:
        if (this.f195a != null) goto L12;
        Integer r100 = Integer.valueOf(ap.a(this.f191a).a());
        this.f195a = r100;
        if (r100.intValue() != 0) goto L12;
        final Handler r101 = new Handler(Looper.getMainLooper());
        ContentObserver r102 = new AnonymousClass3(this, r101);
        this.f191a.getContentResolver().registerContentObserver(ap.a(this.f191a).m9368a(), false, r102);
    L12:
        if (this.f195a.intValue() != 0) goto L18;
        return false;
    L18:
        return true;
    }

    /* JADX INFO: renamed from: e, reason: collision with other method in class */
    public void m8794e() {
        Intent r100 = m8776a();
        r100.setAction("com.xiaomi.mipush.CLEAR_HEADSUPNOTIFICATION");
        Application r101 = (Application) av.a("android.app.ActivityThread", "currentApplication", new Object[0]);
        if (r101 != null) goto L5;
    L7:
        String r102 = null;
    L8:
        String r103 = this.f191a.getPackageName();
        if (TextUtils.isEmpty(r102) == false) goto L11;
    L13:
        r102 = r103;
    L14:
        r100.putExtra(an.F, r102);
        c(r100);
        return;
    L11:
        if (r102.equals(r103) == true) goto L13;
        com.xiaomi.channel.commonutils.logger.b.m8718a("application package name: " + r102 + ", not equals context package name: " + r103);
        goto L14
    L5:
        if (r101.getApplicationContext() == null) goto L7;
        r102 = r101.getApplicationContext().getPackageName();
        goto L8
    }

    public void f() {
        Intent r100 = m8776a();
        r100.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
        r100.putExtra(an.F, this.f191a.getPackageName());
        r100.putExtra(an.K, az.b(this.f191a.getPackageName()));
        c(r100);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private Intent m8776a() {
        if (m8788a() == false) goto L9;
        if ("com.xiaomi.xmsf".equals(this.f191a.getPackageName()) == true) goto L9;
        return d();
    L9:
        return e();
    }

    private Intent b() {
        if ("com.xiaomi.xmsf".equals(this.f191a.getPackageName()) == false) goto L5;
        com.xiaomi.channel.commonutils.logger.b.c("pushChannel xmsf create own channel");
        return e();
    L5:
        return c();
    }

    private Intent c() {
        if (m8788a() == false) goto L6;
        com.xiaomi.channel.commonutils.logger.b.c("pushChannel app start miui china channel");
        return d();
    L6:
        com.xiaomi.channel.commonutils.logger.b.c("pushChannel app start  own channel");
        return e();
    }

    private Intent d() {
        Intent r100 = new Intent();
        String r101 = this.f191a.getPackageName();
        r100.setPackage("com.xiaomi.xmsf");
        r100.setClassName("com.xiaomi.xmsf", m8779a());
        r100.putExtra("mipush_app_package", r101);
        h();
        return r100;
    }

    /* JADX INFO: renamed from: e, reason: collision with other method in class */
    private boolean m8783e() {
        String r100 = this.f191a.getPackageName();
        if (r100.contains("miui") == false) goto L5;
        return true;
    L5:
        if (r100.contains(DimLocationCheckUtil.XIAOMI) == false) goto L8;
        return true;
    L8:
        if ((this.f191a.getApplicationInfo().flags & 1) != 0) goto L14;
        return false;
    L14:
        return true;
    }

    private synchronized int a() {
        monitor-enter(this);
        int r100 = this.f191a.getSharedPreferences("mipush_extra", 0).getInt(Constants.EXTRA_KEY_BOOT_SERVICE_MODE, -1);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    /* JADX INFO: renamed from: d, reason: collision with other method in class */
    private boolean m8782d() {
        if (m8788a() == true) goto L12;
    L10:
        return true;
    L12:
        if (this.f191a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode < 108) goto L8;
        return true;
    L8:
        return false;
    }

    private Intent e() {
        Intent r100 = new Intent();
        String r101 = this.f191a.getPackageName();
        i();
        r100.setComponent(new ComponentName(this.f191a, "com.xiaomi.push.service.XMPushService"));
        r100.putExtra("mipush_app_package", r101);
        return r100;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public final void m8790b() {
        Intent r100 = m8776a();
        r100.setAction("com.xiaomi.mipush.DISABLE_PUSH");
        c(r100);
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public void m8792c() {
        if (this.f192a == null) goto L6;
        g();
        c(this.f192a);
        this.f192a = null;
        return;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m8788a() {
        if (this.f198a == true) goto L5;
    L7:
        return false;
    L5:
        if (1 != b.m8743a(this.f191a).a()) goto L7;
        return true;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m8785a() {
        b(m8776a());
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public long m8784a() {
        return this.f190a;
    }

    private u(Context r100) {
        this.f198a = false;
        this.f193a = null;
        this.f197a = new ArrayList();
        this.f463088c = false;
        this.f199b = null;
        this.f192a = null;
        this.f195a = null;
        this.f191a = r100.getApplicationContext();
        this.f196a = null;
        this.f198a = m8781c();
        f463087b = m8782d();
        final Looper r101 = Looper.getMainLooper();
        this.f193a = new AnonymousClass1(this, r101);
        if (com.xiaomi.push.j.m9295a(r100) == false) goto L5;
        com.xiaomi.push.service.g.a(new AnonymousClass2(this));
    L5:
        Intent r102 = b();
        if (r102 == null) goto L9;
        b(r102);
        return;
    }

    private void c(Intent r100) {
        ah r101 = ah.a(this.f191a);
        int r102 = gj.T.a();
        gf r103 = gf.f463672a;
        int r104 = r101.a(r102, r103.a());
        int r105 = a();
        gf r106 = gf.f463673b;
        if (r104 == r106.a()) goto L5;
    L7:
        boolean r107 = false;
    L8:
        if (r107 == false) goto L10;
        int r108 = r106.a();
    L11:
        if (r108 == r105) goto L13;
        m8789a(r108);
    L13:
        if (r107 == false) goto L15;
        d(r100);
        return;
    L15:
        b(r100);
        return;
    L10:
        r108 = r103.a();
        goto L11
    L5:
        if (f463087b == false) goto L7;
        r107 = true;
        goto L8
    }

    private synchronized void d(Intent r100) {
        monitor-enter(this);
    L21:
        th = move-exception;
        throw th;
    L4:
        if (this.f463088c == false) goto L12;
        Message r101 = a(r100);     // Catch: Throwable -> L21
        if (this.f197a.size() < 50) goto L8;
        ListProtector.remove(this.f197a, 0);     // Catch: Throwable -> L21
    L8:
        this.f197a.add(r101);     // Catch: Throwable -> L21
        monitor-exit(this);
        return;
    L12:
        if (this.f194a != null) goto L14;
        this.f191a.bindService(r100, new AnonymousClass4(this), 1);     // Catch: Throwable -> L21
        this.f463088c = true;     // Catch: Throwable -> L21
        this.f197a.clear();     // Catch: Throwable -> L21
        Message r102 = a(r100);     // Catch: Throwable -> L21
        this.f197a.add(r102);     // Catch: Throwable -> L21
    L19:
        monitor-exit(this);
        return;
    L14:
        Message r103 = a(r100);     // Catch: Throwable -> L21
        this.f194a.send(r103);     // Catch: RemoteException -> L17 Throwable -> L21
    L18:
        this.f194a = null;     // Catch: Throwable -> L21
        this.f463088c = false;     // Catch: Throwable -> L21
        goto L19
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m8789a(int r100) {
        if (b.m8743a(this.f191a).m8750b() == true) goto L5;
        return false;
    L5:
        c(r100);
        hd r101 = new hd();
        r101.a(aj.a());
        r101.b(b.m8743a(this.f191a).m8744a());
        r101.d(this.f191a.getPackageName());
        r101.c(go.G.f650a);
        HashMap r102 = new HashMap();
        r101.f789a = r102;
        r102.put("boot_mode", r100 + "");
        a(this.f191a).a(r101, ge.f463654i, false, null);
        return true;
    }

    public void b(int r100) {
        Intent r101 = m8776a();
        r101.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
        r101.putExtra(an.F, this.f191a.getPackageName());
        r101.putExtra(an.I, r100);
        r101.putExtra(an.K, az.b(this.f191a.getPackageName() + r100));
        c(r101);
    }

    private void b(Intent r100) {
    L9:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.a(e);
        return;
    L3:
        if (com.xiaomi.push.j.m9294a() == false) goto L5;
    L7:
        this.f191a.startService(r100);     // Catch: Exception -> L9
    L12:
        return;
    L5:
        if (Build.VERSION.SDK_INT < 26) goto L7;
        d(r100);     // Catch: Exception -> L9
        goto L12
    }

    private synchronized void c(int r100) {
        monitor-enter(this);
        this.f191a.getSharedPreferences("mipush_extra", 0).edit().putInt(Constants.EXTRA_KEY_BOOT_SERVICE_MODE, r100).commit();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m8786a(Context r100) {
        if (com.xiaomi.push.j.m9294a() == false) goto L5;
        return;
    L5:
        q r101 = h.a(r100);
        if (q.f463077a.equals(r101) == false) goto L9;
        a(null, v.f463097c, d.f463055a, "update");
    L9:
        if (q.f463080d.equals(r101) == false) goto L12;
        a(null, v.f463099e, d.f463057c, "update");
    L12:
        if (q.f463081e.equals(r101) == false) goto L15;
        a(null, v.f463100f, d.f463058d, "update");
        return;
    }

    public final void a(hk r100) {
        byte[] r101 = ho.a(r.a(this.f191a, r100, ge.f463647b));
        if (r101 != null) goto L6;
        com.xiaomi.channel.commonutils.logger.b.m8718a("unregister fail, because msgBytes is null.");
        return;
    L6:
        Intent r102 = m8776a();
        r102.setAction("com.xiaomi.mipush.UNREGISTER_APP");
        r102.putExtra("mipush_app_id", b.m8743a(this.f191a).m8744a());
        r102.putExtra("mipush_payload", r101);
        c(r102);
    }

    public final void a(gi r100) {
        Intent r101 = m8776a();
        byte[] r102 = ho.a(r100);
        if (r102 != null) goto L6;
        com.xiaomi.channel.commonutils.logger.b.m8718a("send TinyData failed, because tinyDataBytes is null.");
        return;
    L6:
        r101.setAction("com.xiaomi.mipush.SEND_TINYDATA");
        r101.putExtra("mipush_payload", r102);
        b(r101);
    }

    public static synchronized u a(Context r100) {
        monitor-enter(u.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f463086a != null) goto L7;
        f463086a = new u(r100);     // Catch: Throwable -> L10
    L7:
        u r101 = f463086a;     // Catch: Throwable -> L10
        monitor-exit(u.class);
        return r101;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m8787a(Intent r100) {
        r100.fillIn(m8776a(), 24);
        c(r100);
    }

    private Message a(Intent r100) {
        Message r101 = Message.obtain();
        r101.what = 17;
        r101.obj = r100;
        return r101;
    }

    public void a(int r100) {
        a(r100, 0);
    }

    public final void a(boolean r100) {
        a(r100, null);
    }

    public static /* synthetic */ Context a(u r100) {
        return r100.f191a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static /* synthetic */ Messenger m8777a(u r100) {
        return r100.f194a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static /* synthetic */ Integer m8778a(u r100) {
        return r100.f195a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static /* synthetic */ List m8780a(u r100) {
        return r100.f197a;
    }

    public final void a(he r100, boolean r101) {
        ds.a(this.f191a.getApplicationContext()).a(this.f191a.getPackageName(), "E100003", r100.a(), 6001, null);
        this.f192a = null;
        b r102 = b.m8743a(this.f191a);
        r102.f164a = r100.a();
        Intent r103 = m8776a();
        byte[] r104 = ho.a(r.a(this.f191a, r100, ge.f463646a));
        if (r104 != null) goto L6;
        com.xiaomi.channel.commonutils.logger.b.m8718a("register fail, because msgBytes is null.");
        return;
    L6:
        r103.setAction("com.xiaomi.mipush.REGISTER_APP");
        r103.putExtra("mipush_app_id", b.m8743a(this.f191a).m8744a());
        r103.putExtra("mipush_payload", r104);
        r103.putExtra("mipush_session", this.f196a);
        r103.putExtra("mipush_env_chanage", r101);
        r103.putExtra("mipush_env_type", b.m8743a(this.f191a).a());
        if (at.m8819a(this.f191a) == true) goto L9;
    L11:
        this.f192a = r103;
        return;
    L9:
        if (m8791b() == false) goto L11;
        g();
        c(r103);
    }

    public final void a(boolean r100, String r101) {
        if (r100 == false) goto L5;
        p r102 = p.a(this.f191a);
        v r103 = v.f463095a;
        r102.a(r103, "syncing");
        p.a(this.f191a).a(v.f463096b, "");
        a(r101, r103, true, null);
        return;
    L5:
        p r104 = p.a(this.f191a);
        v r105 = v.f463096b;
        r104.a(r105, "syncing");
        p.a(this.f191a).a(v.f463095a, "");
        a(r101, r105, true, null);
    }

    public void a(int r100, int r101) {
        Intent r102 = m8776a();
        r102.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
        r102.putExtra(an.F, this.f191a.getPackageName());
        r102.putExtra(an.G, r100);
        r102.putExtra(an.H, r101);
        c(r102);
    }

    public void a(String r100, String r101) {
        Intent r102 = m8776a();
        r102.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
        r102.putExtra(an.F, this.f191a.getPackageName());
        r102.putExtra(an.L, r100);
        r102.putExtra(an.M, r101);
        c(r102);
    }

    public void a(int r100, String r101) {
        Intent r102 = m8776a();
        r102.setAction("com.xiaomi.mipush.thirdparty");
        r102.putExtra("com.xiaomi.mipush.thirdparty_LEVEL", r100);
        r102.putExtra("com.xiaomi.mipush.thirdparty_DESC", r101);
        b(r102);
    }

    public static /* synthetic */ Messenger a(u r100, Messenger r101) {
        r100.f194a = r101;
        return r101;
    }

    public static /* synthetic */ Integer a(u r100, Integer r101) {
        r100.f195a = r101;
        return r101;
    }

    public static /* synthetic */ boolean a(u r100, boolean r101) {
        r100.f463088c = r101;
        return r101;
    }

    public <T extends hp<T, ?>> void a(T r100, ge r101, boolean r102) {
        a r103 = new a();
        r103.f200a = r100;
        r103.f463094a = r101;
        r103.f201a = r102;
        ArrayList<a> r104 = f189a;
        monitor-enter(r104);
        r104.add(r103);     // Catch: Throwable -> L9
        if (r104.size() <= 10) goto L7;
        r104.remove(0);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r104);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public final <T extends hp<T, ?>> void a(T r100, ge r101, gr r102) {
        a(r100, r101, !r101.equals(ge.f463646a), r102);
    }

    private void a(String r110, v r111, boolean r112, HashMap<String, String> r210) {
        String r100 = r110;
        if (b.m8743a(this.f191a).m8750b() == true) goto L5;
        return;
    L5:
        if (at.m8819a(this.f191a) == false) goto L54;
        hd r101 = new hd();
        r101.a(true);
        Intent r102 = m8776a();
        if (TextUtils.isEmpty(r110) == false) goto L21;
        r100 = aj.a();
        r101.a(r100);
        if (r112 == false) goto L12;
        hd r103 = new hd(r100, true);
    L14:
        monitor-enter(p.class);
        p.a(this.f191a).m8772a(r100);     // Catch: Throwable -> L18
        monitor-exit(p.class);     // Catch: Throwable -> L18
    L26:
        switch(AnonymousClass5.f463093a[r111.ordinal()]) {
            case 1: goto L35;
            case 2: goto L31;
            case 3: goto L28;
            case 4: goto L28;
            case 5: goto L28;
            case 6: goto L28;
            default: goto L39;
        };
    L28:
        r101.c(go.N.f650a);
        if (r210 == null) goto L39;
        r101.a(r210);
        goto L39
    L31:
        go r104 = go.F;
        r101.c(r104.f650a);
        r103.c(r104.f650a);
        if (r210 == null) goto L34;
        r101.a(r210);
        r103.a(r210);
    L34:
        r102.setAction("com.xiaomi.mipush.ENABLE_PUSH_MESSAGE");
        goto L39
    L35:
        go r105 = go.E;
        r101.c(r105.f650a);
        r103.c(r105.f650a);
        if (r210 == null) goto L38;
        r101.a(r210);
        r103.a(r210);
    L38:
        r102.setAction("com.xiaomi.mipush.DISABLE_PUSH_MESSAGE");
    L39:
        com.xiaomi.channel.commonutils.logger.b.e("type:" + r111 + ", " + r100);
        r101.b(b.m8743a(this.f191a).m8744a());
        r101.d(this.f191a.getPackageName());
        ge r113 = ge.f463654i;
        a(r101, r113, false, null);
        if (r112 == false) goto L44;
        r103.b(b.m8743a(this.f191a).m8744a());
        r103.d(this.f191a.getPackageName());
        Context r106 = this.f191a;
        byte[] r107 = ho.a(r.a(r106, r103, r113, false, r106.getPackageName(), b.m8743a(this.f191a).m8744a()));
        if (r107 == null) goto L44;
        cr.a(this.f191a.getPackageName(), this.f191a, r103, r113, r107.length);
        r102.putExtra("mipush_payload", r107);
        r102.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
        r102.putExtra("mipush_app_id", b.m8743a(this.f191a).m8744a());
        r102.putExtra("mipush_app_token", b.m8743a(this.f191a).b());
        c(r102);
    L44:
        Message r108 = Message.obtain();
        r108.what = 19;
        int r109 = r111.ordinal();
        r108.obj = r100;
        r108.arg1 = r109;
        if (r210 != null) goto L47;
    L49:
        this.f193a.sendMessageDelayed(r108, 5000);
        return;
    L47:
        if (r210.get("third_sync_reason") == null) goto L49;
        Bundle r114 = new Bundle();
        r114.putString("third_sync_reason", r210.get("third_sync_reason"));
        r108.setData(r114);
    L18:
        th = move-exception;
        throw th;
    L12:
        r103 = null;
        goto L14
    L21:
        r101.a(r100);
        if (r112 == false) goto L24;
        r103 = new hd(r100, true);
        goto L26
    L24:
        r103 = null;
        goto L26
    }

    public final void a(String r100, v r101, d r102, String r103) {
        p.a(this.f191a).a(r101, "syncing");
        HashMap<String, String> r104 = f.m8762a(this.f191a, r102);
        r104.put("third_sync_reason", r103);
        a(r100, r101, false, r104);
    }

    public final <T extends hp<T, ?>> void a(T r100, ge r101, boolean r110, gr r111) {
        a(r100, r101, r110, true, r111, true);
    }

    public final <T extends hp<T, ?>> void a(T r100, ge r101, boolean r110, gr r111, boolean r112) {
        a(r100, r101, r110, true, r111, r112);
    }

    public static /* synthetic */ void a(u r100, String r101, v r102, boolean r103, HashMap r104) {
        r100.a(r101, r102, r103, r104);
    }

    public final <T extends hp<T, ?>> void a(T r110, ge r111, boolean r112, boolean r113, gr r114, boolean r115) {
        a(r110, r111, r112, r113, r114, r115, this.f191a.getPackageName(), b.m8743a(this.f191a).m8744a());
    }

    public final <T extends hp<T, ?>> void a(T r110, ge r111, boolean r112, boolean r113, gr r114, boolean r115, String r116, String r117) {
        a(r110, r111, r112, r113, r114, r115, r116, r117, true);
    }

    public final <T extends hp<T, ?>> void a(T r110, ge r111, boolean r112, boolean r113, gr r114, boolean r115, String r116, String r117, boolean r210) {
        a(r110, r111, r112, r113, r114, r115, r116, r117, r210, true);
    }

    public final <T extends hp<T, ?>> void a(T r110, ge r111, boolean r112, boolean r113, gr r114, boolean r115, String r116, String r117, boolean r118, boolean r119) {
        if (r119 == true) goto L5;
    L9:
        if (r118 == false) goto L11;
        ha r100 = r.a(this.f191a, r110, r111, r112, r116, r117);
    L12:
        if (r114 == null) goto L14;
        r100.a(r114);
    L14:
        byte[] r101 = ho.a(r100);
        if (r101 != null) goto L18;
        com.xiaomi.channel.commonutils.logger.b.m8718a("send message fail, because msgBytes is null.");
        return;
    L18:
        cr.a(this.f191a.getPackageName(), this.f191a, r110, r111, r101.length);
        Intent r102 = m8776a();
        r102.setAction("com.xiaomi.mipush.SEND_MESSAGE");
        r102.putExtra("mipush_payload", r101);
        r102.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", r115);
        c(r102);
        return;
    L11:
        r100 = r.b(this.f191a, r110, r111, r112, r116, r117);
        goto L12
    L5:
        if (b.m8743a(this.f191a).m8752c() == true) goto L9;
        if (r113 == false) goto L8;
        a(r110, r111, r112);
        return;
    L8:
        com.xiaomi.channel.commonutils.logger.b.m8718a("drop the message before initialization.");
    }
}
