package com.bytedance.webx.seclink.setting;

import android.content.SharedPreferences;
import android.os.Handler;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes22.dex */
public final class c {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static volatile c f272627m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f272628a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<String> f272629b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f272630c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f272631d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f272632e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public SharedPreferences f272633f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.bytedance.webx.seclink.setting.a f272634g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public com.bytedance.webx.seclink.setting.a f272635h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final com.bytedance.webx.seclink.setting.a f272636i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Map<String, com.bytedance.webx.seclink.setting.a.c> f272637j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f272638k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f272639l;

    public class a implements f.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f272640a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f272641b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ c f272642c;

        public a(c r100, long r101, String r102) {
            this.f272642c = r100;
            this.f272640a = r101;
            this.f272641b = r102;
        }
    }

    public static c d() {
        if (f272627m != null) goto L15;
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f272627m != null) goto L9;
        f272627m = new c();     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
    L15:
        return f272627m;
    }

    public final com.bytedance.webx.seclink.setting.a c() {
        com.bytedance.webx.seclink.setting.a r100 = this.f272634g;
        if (r100 != null) goto L5;
    L7:
        com.bytedance.webx.seclink.setting.a r101 = this.f272635h;
        if (r101 == null) goto L13;
        if (r101.f272605a == null) goto L13;
        return r101;
    L13:
        return this.f272636i;
    L5:
        if (r100.f272605a == null) goto L7;
        return r100;
    }

    public final long f() {
        if (cr7.a.f465093b == null) goto L12;
        com.bytedance.webx.seclink.setting.a r100 = c();
        if (r100 == null) goto L9;
        com.bytedance.webx.seclink.setting.a.C3815a r101 = r100.f272605a;
        if (r101 == null) goto L9;
        boolean r102 = r101.f272613f;
    L10:
        if (r102 == false) goto L12;
        long r103 = cr7.a.f465093b.f482373h;
    L19:
        return Math.min(Math.max(0, r103), 1500);
    L9:
        r102 = false;
    L12:
        com.bytedance.webx.seclink.setting.a r104 = c();
        if (r104 == null) goto L17;
        com.bytedance.webx.seclink.setting.a.C3815a r105 = r104.f272605a;
        if (r105 == null) goto L17;
        r103 = (long) (r105.f272614g * 1000.0d);
    L17:
        r103 = 500;
        goto L19
    }

    public final void j() {
        if (this.f272639l == false) goto L5;
        return;
    L5:
        this.f272639l = true;
        com.bytedance.webx.seclink.setting.a r100 = c();
        if (r100 == null) goto L14;
        com.bytedance.webx.seclink.setting.a.C3815a r101 = r100.f272605a;
        if (r101 == null) goto L14;
        List<String> r102 = r101.f272615h;
        if (r102 == null) goto L14;
        ArrayList r103 = (ArrayList) r102;
        if (r103.isEmpty() == true) goto L14;
        String r104 = (String) ListProtector.get(r102, this.f272630c % r103.size());
    L15:
        long r105 = System.currentTimeMillis();
        f r106 = new f(r104, ir7.e.a(), new a(this, r105, r104));
        Handler r107 = e.a.f272646a.f272645b;
        if (r107 == null) goto L19;
        r107.post(r106);
        return;
    L19:
        return;
    L14:
        r104 = null;
        goto L15
    }

    public c() {
        this.f272628a = 0;
        this.f272630c = 0;
        this.f272631d = 0;
        this.f272632e = 0;
        DefaultSettings.f272604d.getClass();
        Lazy r100 = DefaultSettings.f272603c;
        KProperty r101 = DefaultSettings.f272601a[0];
        com.bytedance.webx.seclink.setting.a r102 = (com.bytedance.webx.seclink.setting.a) r100.getValue();
        this.f272636i = r102;
        this.f272637j = new HashMap();
        this.f272638k = false;
        this.f272639l = false;
        HashSet r103 = new HashSet();
        this.f272629b = r103;
        r103.add("http");
        r103.add("https");
        h(r102);
    }

    public final String g() {
        com.bytedance.webx.seclink.setting.a r100 = c();
        if (r100 == null) goto L11;
        com.bytedance.webx.seclink.setting.a.C3815a r101 = r100.f272605a;
        if (r101 == null) goto L11;
        List<String> r102 = r101.f272616i;
        if (r102 == null) goto L11;
        ArrayList r103 = (ArrayList) r102;
        if (r103.isEmpty() == true) goto L11;
        String r104 = (String) ListProtector.get(r102, this.f272631d % r103.size());
    L13:
        if (TextUtils.isEmpty(r104) == false) goto L19;
        gr7.a r105 = cr7.a.f465093b;
        if (r105 != null) goto L20;
        return "";
    L20:
        return r105.f482371f;
    L19:
        return r104;
    L11:
        r104 = null;
        goto L13
    }

    public static void a(c r100) {
        SharedPreferences r101 = r100.f272633f;
        if (r101 == null) goto L5;
        boolean r102 = r101.getBoolean("need_update_setting", false);
    L6:
        if (r102 == true) goto L33;
        com.bytedance.webx.seclink.setting.a r103 = r100.f272635h;
        if (r103 == null) goto L33;
        com.bytedance.webx.seclink.setting.a.b r104 = r103.f272607c;
        if (r104 != null) goto L12;
    L18:
        if (r102 == true) goto L33;
        Map<String, com.bytedance.webx.seclink.setting.a.c> r105 = r103.f272606b;
        if (r105 == null) goto L33;
        if (((HashMap) r105).size() <= 0) goto L33;
        Iterator r106 = ((HashMap) r100.f272635h.f272606b).keySet().iterator();
    L25:
        if (r106.hasNext() == false) goto L33;
        String r107 = (String) r106.next();
        com.bytedance.webx.seclink.setting.a.c r108 = (com.bytedance.webx.seclink.setting.a.c) ((HashMap) r100.f272635h.f272606b).get(r107);
        if (r108 == null) goto L25;
        if (r108.f272622b == false) goto L32;
        if (r108.f272624d == true) goto L25;
    L32:
        r102 = true;
        goto L33
    L12:
        if (r104.f272617a == true) goto L14;
    L17:
        r102 = true;
        goto L18
    L14:
        if (r104.f272619c == false) goto L17;
        r102 = false;
    L33:
        if (r102 == false) goto L43;
        r100.f272632e = 0;
        r100.j();
        return;
    L43:
        return;
    L5:
        r102 = false;
        goto L6
    }

    public static boolean i(String r100) {
        com.bytedance.webx.seclink.setting.a r101 = d().c();
        if (r101 != null) goto L5;
        return true;
    L5:
        if (r101.f272605a == null) goto L16;
        com.bytedance.webx.seclink.setting.a.c r102 = d().e(r100);
        if (r102 == null) goto L11;
        return r102.f272622b;
    L11:
        if (r101.f272607c.f272617a == true) goto L17;
        return false;
    L17:
        return true;
    L16:
        return true;
    }

    public final com.bytedance.webx.seclink.setting.a.c e(String r100) {
        Map<String, com.bytedance.webx.seclink.setting.a.c> r101 = this.f272637j;
        if (r101 != null) goto L5;
    L9:
        com.bytedance.webx.seclink.setting.a.c r102 = null;
    L11:
        if (TextUtils.isEmpty(r100) == true) goto L20;
        com.bytedance.webx.seclink.setting.a r103 = c();
        if (r103 == null) goto L21;
        Map<String, com.bytedance.webx.seclink.setting.a.c> r104 = r103.f272606b;
        if (r104 != null) goto L17;
        return r102;
    L17:
        if (((HashMap) r104).isEmpty() == false) goto L19;
        return r102;
    L19:
        return (com.bytedance.webx.seclink.setting.a.c) ((HashMap) r103.f272606b).get(r100);
    L21:
        return r102;
    L20:
        return r102;
    L5:
        if (((HashMap) r101).isEmpty() == true) goto L9;
        r102 = (com.bytedance.webx.seclink.setting.a.c) ((HashMap) this.f272637j).get(r100);
        if (r102 == null) goto L11;
        return r102;
    }

    public final void h(com.bytedance.webx.seclink.setting.a r100) {
        com.bytedance.webx.seclink.setting.a r101 = c();
        if (r101 == null) goto L7;
        com.bytedance.webx.seclink.setting.a.C3815a r102 = r101.f272605a;
        if (r102 == null) goto L7;
        boolean r103 = r102.f272613f;
    L8:
        if (r103 == false) goto L10;
        return;
    L10:
        if (r100 == null) goto L23;
        com.bytedance.webx.seclink.setting.a.C3815a r104 = r100.f272605a;
        if (r104 == null) goto L24;
        int r105 = r104.f272610c;
        long r106 = r104.f272611d * 1000;
        long r107 = r104.f272612e * 1000;
        if (r105 <= 0) goto L17;
        hr7.d.f486907h = r105;
    L17:
        if (r106 <= 0) goto L20;
        hr7.d.f486908i = r106;
    L20:
        if (r107 <= 0) goto L25;
        hr7.d.f486909j = r107;
        return;
    L25:
        return;
    L24:
        return;
    L23:
        return;
    L7:
        r103 = false;
        goto L8
    }

    public final void b(String r100, Object r101) {
    L21:
        e = move-exception;
        e.printStackTrace();
        return;
    L3:
        if (this.f272633f != null) goto L6;
        this.f272633f = cr7.a.getContext().getSharedPreferences("sec_link_config", 0);     // Catch: Exception -> L21
    L6:
        if (this.f272633f == null) goto L26;
        if (r101 != null) goto L9;
        return;
    L9:
        if (TextUtils.isEmpty(r100) == true) goto L28;
        SharedPreferences.Editor r102 = this.f272633f.edit();     // Catch: Exception -> L21
        if ((r101 instanceof String) == false) goto L14;
        r102.putString(r100, (String) r101);     // Catch: Exception -> L21
    L19:
        r102.commit();     // Catch: Exception -> L21
        return;
    L14:
        if ((r101 instanceof Boolean) == false) goto L17;
        r102.putBoolean(r100, ((Boolean) r101).booleanValue());     // Catch: Exception -> L21
        goto L19
    L17:
        if ((r101 instanceof Integer) == false) goto L19;
        r102.putInt(r100, ((Integer) r101).intValue());     // Catch: Exception -> L21
        goto L19
    L28:
        return;
    }
}
