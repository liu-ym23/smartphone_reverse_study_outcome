package h84;

import android.accounts.Account;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.bdinstall.c1;
import com.bytedance.bdinstall.v;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.UUID;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a implements g84.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f484103a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p f484104b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final o f484105c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f484106d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f484107e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f484108f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile String f484109g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f484110h;

    public void d(p r100, c r101) {
    }

    @Override // g84.a
    public String c() {
        if (TextUtils.isEmpty(this.f484108f) == false) goto L5;
        SharedPreferences r100 = i84.a.a(this.f484103a, this.f484104b.f484151h);     // Catch: Exception -> L14
        String r101 = r100.getString("clientudid", null);     // Catch: Exception -> L14
        if (c1.h(r101) == true) goto L10;
        r101 = UUID.randomUUID().toString();     // Catch: Exception -> L14
        SharedPreferences.Editor r102 = r100.edit();     // Catch: Exception -> L14
        r102.putString("clientudid", r101);     // Catch: Exception -> L14
        r102.apply();     // Catch: Exception -> L14
    L10:
        if (TextUtils.isEmpty(r101) == true) goto L12;
        r101 = r101 + this.f484110h;     // Catch: Exception -> L14
    L12:
        this.f484108f = r101;     // Catch: Exception -> L14
        return r101;
    L14:
        e = move-exception;
        e.printStackTrace();
        return "";
    L5:
        return this.f484108f;
    }

    @Override // g84.a
    public final String getDeviceId() {
        if (TextUtils.isEmpty(this.f484109g) == false) goto L5;
        this.f484109g = this.f484105c.b("", "");
        return this.f484109g;
    L5:
        return this.f484109g;
    }

    @Override // g84.a
    public String getOpenUdid() {
        if (TextUtils.isEmpty(this.f484107e) == true) goto L37;
        return this.f484107e;
    L37:
        String r100 = i84.e.a(this.f484103a.getContentResolver());     // Catch: Exception -> L9
    L11:
        SharedPreferences r101 = i84.a.a(this.f484103a, this.f484104b.f484151h);
        String r102 = r101.getString("openudid", null);
        if (c1.h(r100) == false) goto L17;
        if ("9774d56d682e549c".equals(r100) == false) goto L30;
    L17:
        if (c1.h(r102) == true) goto L28;
        r102 = new BigInteger(80, new SecureRandom()).toString(16);     // Catch: Exception -> L29
        if (r102.charAt(0) != '-') goto L21;
        r102 = r102.substring(1);     // Catch: Exception -> L29
    L21:
        int r103 = 13 - r102.length();     // Catch: Exception -> L29
        if (r103 <= 0) goto L28;
        StringBuilder r104 = new StringBuilder();     // Catch: Exception -> L29
    L24:
        if (r103 <= 0) goto L26;
        r104.append('F');     // Catch: Exception -> L29
        r103 = r103 - 1;     // Catch: Exception -> L29
        goto L24
    L26:
        r104.append(r102);     // Catch: Exception -> L29
        r100 = r104.toString();     // Catch: Exception -> L29
    L28:
        r100 = r102;
    L30:
        SharedPreferences.Editor r105 = r101.edit();
        r105.putString("openudid", r100);
        r105.apply();
        if (TextUtils.isEmpty(r100) == true) goto L34;
        r100 = r100 + this.f484110h;
    L34:
        if (TextUtils.isEmpty(r100) == true) goto L36;
        this.f484107e = r100;
    L36:
        return r100;
    L9:
        e = move-exception;
        e.printStackTrace();
        r100 = null;
        goto L11
    }

    @Override // g84.a
    public final void a(String r100) {
        if (c1.c(r100) == true) goto L5;
        return;
    L5:
        if (c1.f(r100, this.f484109g) == true) goto L10;
        this.f484109g = this.f484105c.b(r100, this.f484109g);
        return;
    }

    @Override // g84.a
    public final void b(Account r100) {
        c r101 = this.f484106d;
        if (r101 == null) goto L11;
        String r102 = this.f484104b.f484151h.a();
        if (r100 == null) goto L12;
        r101.f484115d = r100;
        if (r101.f484116e.size() <= 0) goto L13;
        b r103 = new b(r101, r100);
        v.c(r102).execute(r103);
        return;
    L13:
        return;
    L12:
        return;
    }

    public a(Context r100, p r101) {
        if (r101.f484146c == false) goto L5;
        String r102 = "_local";
    L6:
        this.f484110h = r102;
        Context r103 = r100.getApplicationContext();
        this.f484103a = r103;
        this.f484104b = r101;
        o r104 = new o(r103, r101.f484145b, r101.f484151h);
        this.f484105c = r104;
        boolean r105 = false;
        if (i84.a.a(r100, r101.f484151h).getBoolean("is_migrate", false) == true) goto L17;
        c r106 = new c(r100, r101.f484149f, r101.f484151h);
        this.f484106d = r106;
        r104.f484122a = r106;
        if (i84.p.f() == false) goto L15;
        if (r100.getApplicationInfo().targetSdkVersion < 30) goto L13;
        r105 = true;
    L13:
        if (r105 == true) goto L17;
    L15:
        if (r101.f484150g == false) goto L17;
        d(r101, r106);
    L17:
        b(r101.f484148e);
        return;
    L5:
        r102 = "";
        goto L6
    }
}
