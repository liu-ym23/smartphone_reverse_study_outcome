package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes41.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile b f463046a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Context f162a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private a f163a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    String f164a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Map<String, a> f165a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f463047a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private Context f166a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public String f167a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f168a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f463048b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public boolean f169b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f463049c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f463050d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f463051e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f463052f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f463053g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f463054h;

        public void b() {
            this.f168a = false;
            b.a(this.f166a).edit().putBoolean("valid", this.f168a).commit();
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public void m8756a() {
            b.a(this.f166a).edit().clear().commit();
            this.f167a = null;
            this.f463048b = null;
            this.f463049c = null;
            this.f463050d = null;
            this.f463052f = null;
            this.f463051e = null;
            this.f168a = false;
            this.f169b = false;
            this.f463054h = null;
            this.f463047a = 1;
        }

        private String a() {
            Context r100 = this.f166a;
            return com.xiaomi.push.g.m9120a(r100, r100.getPackageName());
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public boolean m8757a() {
            return m8758a(this.f167a, this.f463048b);
        }

        public a(Context r100) {
            this.f168a = true;
            this.f169b = false;
            this.f463047a = 1;
            this.f166a = r100;
        }

        public static String a(a r100) {
            JSONObject r101 = new JSONObject();     // Catch: Throwable -> L4
            r101.put("appId", r100.f167a);     // Catch: Throwable -> L4
            r101.put("appToken", r100.f463048b);     // Catch: Throwable -> L4
            r101.put("regId", r100.f463049c);     // Catch: Throwable -> L4
            r101.put("regSec", r100.f463050d);     // Catch: Throwable -> L4
            r101.put("devId", r100.f463052f);     // Catch: Throwable -> L4
            r101.put("vName", r100.f463051e);     // Catch: Throwable -> L4
            r101.put("valid", r100.f168a);     // Catch: Throwable -> L4
            r101.put("paused", r100.f169b);     // Catch: Throwable -> L4
            r101.put("envType", r100.f463047a);     // Catch: Throwable -> L4
            r101.put("regResource", r100.f463053g);     // Catch: Throwable -> L4
            return r101.toString();
        L4:
            th = move-exception;
            com.xiaomi.channel.commonutils.logger.b.a(th);
            return null;
        }

        public void a(int r100) {
            this.f463047a = r100;
        }

        public void a(boolean r100) {
            this.f169b = r100;
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public boolean m8758a(String r100, String r101) {
            boolean r102 = TextUtils.equals(this.f167a, r100);
            boolean r103 = TextUtils.equals(this.f463048b, r101);
            boolean r104 = !TextUtils.isEmpty(this.f463049c);
            boolean r105 = !TextUtils.isEmpty(this.f463050d);
            if (TextUtils.isEmpty(com.xiaomi.push.i.b(this.f166a)) == false) goto L6;
        L4:
            boolean r106 = true;
        L11:
            if (r102 == false) goto L17;
            if (r103 == false) goto L17;
            if (r104 == false) goto L17;
            if (r105 == false) goto L17;
            if (r106 == false) goto L17;
            boolean r107 = true;
        L18:
            if (r107 == true) goto L20;
            com.xiaomi.channel.commonutils.logger.b.e(String.format("register invalid, aid=%s;atn=%s;rid=%s;rse=%s;did=%s", new Object[]{Boolean.valueOf(r102), Boolean.valueOf(r103), Boolean.valueOf(r104), Boolean.valueOf(r105), Boolean.valueOf(r106)}));
        L20:
            return r107;
        L17:
            r107 = false;
            goto L18
        L6:
            if (TextUtils.equals(this.f463052f, com.xiaomi.push.i.h(this.f166a)) == true) goto L4;
            if (TextUtils.equals(this.f463052f, com.xiaomi.push.i.g(this.f166a)) == true) goto L4;
            r106 = false;
            goto L11
        }

        public static a a(Context r100, String r101) {
            JSONObject r102 = new JSONObject(r101);     // Catch: Throwable -> L4
            a r103 = new a(r100);     // Catch: Throwable -> L4
            r103.f167a = JSONObjectProtectorUtils.getString(r102, "appId");     // Catch: Throwable -> L4
            r103.f463048b = JSONObjectProtectorUtils.getString(r102, "appToken");     // Catch: Throwable -> L4
            r103.f463049c = JSONObjectProtectorUtils.getString(r102, "regId");     // Catch: Throwable -> L4
            r103.f463050d = JSONObjectProtectorUtils.getString(r102, "regSec");     // Catch: Throwable -> L4
            r103.f463052f = JSONObjectProtectorUtils.getString(r102, "devId");     // Catch: Throwable -> L4
            r103.f463051e = JSONObjectProtectorUtils.getString(r102, "vName");     // Catch: Throwable -> L4
            r103.f168a = JSONObjectProtectorUtils.getBoolean(r102, "valid");     // Catch: Throwable -> L4
            r103.f169b = JSONObjectProtectorUtils.getBoolean(r102, "paused");     // Catch: Throwable -> L4
            r103.f463047a = JSONObjectProtectorUtils.getInt(r102, "envType");     // Catch: Throwable -> L4
            r103.f463053g = JSONObjectProtectorUtils.getString(r102, "regResource");     // Catch: Throwable -> L4
            return r103;
        L4:
            th = move-exception;
            com.xiaomi.channel.commonutils.logger.b.a(th);
            return null;
        }

        public void a(String r100, String r101) {
            this.f463049c = r100;
            this.f463050d = r101;
            this.f463052f = com.xiaomi.push.i.h(this.f166a);
            this.f463051e = a();
            this.f168a = true;
        }

        public void a(String r100, String r101, String r102) {
            this.f167a = r100;
            this.f463048b = r101;
            this.f463053g = r102;
            SharedPreferences.Editor r103 = b.a(this.f166a).edit();
            r103.putString("appId", this.f167a);
            r103.putString("appToken", r101);
            r103.putString("regResource", r102);
            r103.commit();
        }

        public void b(String r100, String r101, String r102) {
            this.f463049c = r100;
            this.f463050d = r101;
            this.f463052f = com.xiaomi.push.i.h(this.f166a);
            this.f463051e = a();
            this.f168a = true;
            this.f463054h = r102;
            SharedPreferences.Editor r103 = b.a(this.f166a).edit();
            r103.putString("regId", r100);
            r103.putString("regSec", r101);
            r103.putString("devId", this.f463052f);
            r103.putString("vName", a());
            r103.putBoolean("valid", true);
            r103.putString("appRegion", r102);
            r103.commit();
        }

        public void c(String r100, String r101, String r102) {
            this.f167a = r100;
            this.f463048b = r101;
            this.f463053g = r102;
        }
    }

    private void c() {
        this.f163a = new a(this.f162a);
        this.f165a = new HashMap();
        SharedPreferences r100 = a(this.f162a);
        a r101 = this.f163a;
        r101.f167a = r100.getString("appId", null);
        a r102 = this.f163a;
        r102.f463048b = r100.getString("appToken", null);
        a r103 = this.f163a;
        r103.f463049c = r100.getString("regId", null);
        a r104 = this.f163a;
        r104.f463050d = r100.getString("regSec", null);
        a r105 = this.f163a;
        r105.f463052f = r100.getString("devId", null);
        if (TextUtils.isEmpty(this.f163a.f463052f) == false) goto L5;
    L7:
        a r106 = this.f163a;
        r106.f463051e = r100.getString("vName", null);
        a r107 = this.f163a;
        r107.f168a = r100.getBoolean("valid", true);
        a r108 = this.f163a;
        r108.f169b = r100.getBoolean("paused", false);
        a r109 = this.f163a;
        r109.f463047a = r100.getInt("envType", 1);
        a r110 = this.f163a;
        r110.f463053g = r100.getString("regResource", null);
        a r111 = this.f163a;
        r111.f463054h = r100.getString("appRegion", null);
        return;
    L5:
        if (com.xiaomi.push.i.a(this.f163a.f463052f) == false) goto L7;
        a r112 = this.f163a;
        r112.f463052f = com.xiaomi.push.i.h(this.f162a);
        r100.edit().putString("devId", this.f163a.f463052f).commit();
        goto L7
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m8747a() {
        Context r100 = this.f162a;
        return !TextUtils.equals(com.xiaomi.push.g.m9120a(r100, r100.getPackageName()), this.f163a.f463051e);
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public boolean m8750b() {
        if (this.f163a.m8757a() == true) goto L6;
        com.xiaomi.channel.commonutils.logger.b.m8718a("Don't send message before initialization succeeded!");
        return false;
    L6:
        return true;
    }

    /* JADX INFO: renamed from: d, reason: collision with other method in class */
    public boolean m8753d() {
        if (TextUtils.isEmpty(this.f163a.f167a) == false) goto L5;
    L11:
        return false;
    L5:
        if (TextUtils.isEmpty(this.f163a.f463048b) == true) goto L11;
        if (TextUtils.isEmpty(this.f163a.f463049c) == true) goto L11;
        if (TextUtils.isEmpty(this.f163a.f463050d) == true) goto L11;
        return true;
    }

    public String e() {
        return this.f163a.f463053g;
    }

    /* JADX INFO: renamed from: f, reason: collision with other method in class */
    public boolean m8755f() {
        return !this.f163a.f168a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m8745a() {
        this.f163a.m8756a();
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public void m8749b() {
        this.f163a.b();
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public boolean m8752c() {
        return this.f163a.m8757a();
    }

    public String d() {
        return this.f163a.f463050d;
    }

    /* JADX INFO: renamed from: e, reason: collision with other method in class */
    public boolean m8754e() {
        return this.f163a.f169b;
    }

    public String f() {
        return this.f163a.f463054h;
    }

    public int a() {
        return this.f163a.f463047a;
    }

    public String b() {
        return this.f163a.f463048b;
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public String m8751c() {
        return this.f163a.f463049c;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m8744a() {
        return this.f163a.f167a;
    }

    private b(Context r100) {
        this.f162a = r100;
        c();
    }

    public a a(String r100) {
        if (this.f165a.containsKey(r100) == true) goto L5;
        String r101 = "hybrid_app_info_" + r100;
        SharedPreferences r102 = a(this.f162a);
        if (r102.contains(r101) == true) goto L10;
        return null;
    L10:
        a r103 = a.a(this.f162a, r102.getString(r101, ""));
        this.f165a.put(r101, r103);
        return r103;
    L5:
        return this.f165a.get(r100);
    }

    public void b(String r100) {
        this.f165a.remove(r100);
        a(this.f162a).edit().remove("hybrid_app_info_" + r100).commit();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static b m8743a(Context r100) {
        if (f463046a != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f463046a != null) goto L9;
        f463046a = new b(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f463046a;
    }

    public void a(int r100) {
        this.f163a.a(r100);
        a(this.f162a).edit().putInt("envType", r100).commit();
    }

    public void a(boolean r100) {
        this.f163a.a(r100);
        a(this.f162a).edit().putBoolean("paused", r100).commit();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m8746a(String r100) {
        SharedPreferences.Editor r101 = a(this.f162a).edit();
        r101.putString("vName", r100);
        r101.commit();
        this.f163a.f463051e = r100;
    }

    public static SharedPreferences a(Context r100) {
        return r100.getSharedPreferences("mipush", 0);
    }

    public void a(String r100, a r101) {
        this.f165a.put(r100, r101);
        String r102 = "hybrid_app_info_" + r100;
        a(this.f162a).edit().putString(r102, a.a(r101)).commit();
    }

    public boolean a(String r100, String r101) {
        return this.f163a.m8758a(r100, r101);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m8748a(String r100, String r101, String r102) {
        a r103 = a(r102);
        if (r103 != null) goto L5;
    L9:
        return false;
    L5:
        if (TextUtils.equals(r100, r103.f167a) == false) goto L9;
        if (TextUtils.equals(r101, r103.f463048b) == false) goto L9;
        return true;
    }

    public void b(String r100, String r101, String r102) {
        this.f163a.b(r100, r101, r102);
    }

    public void a(String r100, String r101, String r102) {
        this.f163a.a(r100, r101, r102);
    }
}
