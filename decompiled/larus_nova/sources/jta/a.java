package jta;

import android.accounts.Account;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.concurrent.TTExecutors;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import java.util.Iterator;
import java.util.UUID;

/* JADX INFO: loaded from: classes6.dex */
public abstract class a implements mta.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f500343e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static String f500344f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile String f500345g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f500346a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final nta.e f500347b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final nta.b f500348c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f500349d;

    public final String c() {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (StringUtils.isEmpty(f500345g) == true) goto L8;
        String r100 = f500345g;     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L12
        return r100;
    L8:
        f500345g = this.f500347b.d("", "");     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L12
        return f500345g;
    }

    public final String b() {
        if (TextUtils.isEmpty(f500344f) == false) goto L5;
        SharedPreferences r100 = this.f500346a.getSharedPreferences(kta.b.a(), 0);     // Catch: Exception -> L14
        String r101 = r100.getString("clientudid", null);     // Catch: Exception -> L14
        if (pta.b.b(r101) == true) goto L10;
        r101 = UUID.randomUUID().toString();     // Catch: Exception -> L14
        SharedPreferences.Editor r102 = r100.edit();     // Catch: Exception -> L14
        r102.putString("clientudid", r101);     // Catch: Exception -> L14
        r102.commit();     // Catch: Exception -> L14
    L10:
        if (StringUtils.isEmpty(r101) == true) goto L12;
        r101 = r101 + this.f500349d;     // Catch: Exception -> L14
    L12:
        f500344f = r101;     // Catch: Exception -> L14
        return r101;
    L14:
        e = move-exception;
        ita.j.g("DeviceParamsProvider exception when making client_udid: ", e);
        return "";
    L5:
        return f500344f;
    }

    public final void a(String r100) {
        if (TextUtils.equals(r100, "device_id") == false) goto L6;
        f500345g = null;
    L6:
        if (TextUtils.equals(r100, "openudid") == false) goto L9;
        f500343e = null;
    L9:
        if (TextUtils.equals(r100, "clientudid") == false) goto L11;
        f500344f = null;
    L11:
        this.f500347b.b(r100);
    }

    public final void d(Account r100) {
        nta.b r101 = this.f500348c;
        if (r100 == null) goto L24;
        monitor-enter(r101);
        r101.f520538c = r100;     // Catch: Throwable -> L21
        if (r101.f520539d.size() > 0) goto L10;
        monitor-exit(r101);     // Catch: Throwable -> L21
        return;
    L10:
        if (r101.f520540e == null) goto L19;
        Iterator<String> r102 = r101.f520540e.iterator();     // Catch: Throwable -> L21
    L13:
        if (r102.hasNext() == false) goto L19;
        String r103 = r102.next();     // Catch: Throwable -> L21
        r101.f520537b.setUserData(r101.f520538c, r103, null);     // Catch: Exception -> L17 Throwable -> L21
    L17:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L21
    L19:
        monitor-exit(r101);     // Catch: Throwable -> L21
        ThreadPlus.submitRunnable(new nta.a(r101, r100));
        return;
    L21:
        th = move-exception;
        throw th;
    L24:
        r101.getClass();
    }

    public a(Context r100, boolean r101) {
        if (r101 == false) goto L5;
        String r102 = "_local";
    L6:
        this.f500349d = r102;
        Context r103 = r100.getApplicationContext();
        this.f500346a = r103;
        d r104 = new d(r100, kta.b.f506099c);
        nta.e r105 = new nta.e(r103);
        this.f500347b = r105;
        nta.b r106 = new nta.b(r103);
        this.f500348c = r106;
        r105.f520541a = r106;
        pta.d.a r107 = pta.d.f530685a;
        int r108 = Build.VERSION.SDK_INT;
        boolean r109 = false;
        if (r108 < 30) goto L9;
    L14:
        boolean r110 = true;
    L15:
        if (r110 == true) goto L17;
    L20:
        g r111 = g.f500367a;
    L21:
        g r112 = g.f500367a;
        c r113 = new c(r104);
        TTExecutors.getIOThreadPool().submit(r113);
        return;
    L17:
        if (r100.getApplicationInfo().targetSdkVersion < 30) goto L19;
        r109 = true;
    L19:
        if (r109 == true) goto L21;
    L9:
        if (r108 == 29) goto L11;
    L13:
        r110 = false;
        goto L15
    L11:
        if (Build.VERSION.PREVIEW_SDK_INT <= 0) goto L13;
    L5:
        r102 = "";
        goto L6
    }
}
