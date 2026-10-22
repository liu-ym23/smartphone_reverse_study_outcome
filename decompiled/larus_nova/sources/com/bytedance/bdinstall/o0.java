package com.bytedance.bdinstall;

import android.accounts.Account;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.bytedance.bdinstall.util.DeviceCategory;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class o0 {
    public final boolean A;
    public final boolean B;
    public final boolean C;
    public final boolean D;
    public final c0 E;
    public final boolean F;
    public final x0 G;
    public final boolean H;
    public final boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final boolean f199727J;
    public final boolean K;
    public final DeviceCategory L;
    public final f84.c M;
    public final TelephonyManager N;
    public boolean O;
    public SharedPreferences P;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f199728a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g0 f199729b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f199730c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f199731d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f199732e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f199733f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f199734g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f199735h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f199736i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final x f199737j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f199738k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f199739l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f199740m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final JSONObject f199741n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Map<String, Object> f199742o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f199743p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final h f199744q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f199745r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final b0 f199746s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final h0 f199747t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final boolean f199748u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final a84.a f199749v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final boolean f199750w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final boolean f199751x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Account f199752y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final z f199753z;

    public final String a() {
        return String.valueOf(this.f199728a);
    }

    public final long b() {
        h r100 = this.f199744q;
        if (r100.f199647e != 0) goto L8;
        PackageInfo r101 = r100.f199649g.b(new Object[0]);
        if (r101 == null) goto L8;
        return r101.versionCode;
    L8:
        return r100.f199647e;
    }

    public final SharedPreferences c() {
        if (this.P != null) goto L10;
        if (this.O == false) goto L7;
        String r100 = this.f199731d;
    L8:
        this.P = this.f199730c.getSharedPreferences(r100, 0);
        goto L10
    L7:
        r100 = this.f199731d + "_" + this.f199728a;
    L10:
        return this.P;
    }

    public final long d() {
        h r100 = this.f199744q;
        if (r100.f199646d != 0) goto L8;
        PackageInfo r101 = r100.f199649g.b(new Object[0]);
        if (r101 == null) goto L8;
        return r101.versionCode;
    L8:
        return r100.f199646d;
    }

    public final String e() {
        h r100 = this.f199744q;
        if (TextUtils.isEmpty(r100.f199643a) == false) goto L8;
        PackageInfo r101 = r100.f199649g.b(new Object[0]);
        if (r101 == null) goto L8;
        return r101.versionName;
    L8:
        return r100.f199643a;
    }

    public final long f() {
        h r100 = this.f199744q;
        if (r100.f199645c != 0) goto L8;
        PackageInfo r101 = r100.f199649g.b(new Object[0]);
        if (r101 == null) goto L8;
        return r101.versionCode;
    L8:
        return r100.f199645c;
    }

    public Context getContext() {
        return this.f199730c;
    }

    public o0(l r100) {
        this.P = null;
        this.f199730c = r100.f199700k;
        this.f199728a = r100.f199698i;
        g0 r101 = r100.f199699j;
        if (r101 != null) goto L6;
        r101 = new p();
    L6:
        this.f199729b = r101;
        if (TextUtils.isEmpty(r100.f199701l) == false) goto L9;
        String r102 = "applog_stats";
    L10:
        this.f199731d = r102;
        this.f199732e = r100.f199702m;
        this.f199733f = r100.f199708s;
        this.f199734g = r100.f199709t;
        this.f199735h = r100.f199710u;
        this.f199736i = r100.f199711v;
        this.f199737j = r100.f199712w;
        this.f199738k = r100.f199713x;
        this.f199739l = r100.f199714y;
        this.f199740m = r100.f199715z;
        this.f199741n = r100.A;
        this.f199742o = r100.B;
        this.f199753z = r100.f199696g;
        this.A = r100.f199697h;
        this.B = r100.f199695f;
        this.f199743p = r100.f199694e;
        this.C = r100.f199693d;
        this.D = true;
        this.E = r100.f199692c;
        this.F = r100.f199691b;
        this.G = r100.f199690a;
        this.f199744q = new h(r100);
        this.f199752y = r100.C;
        this.f199745r = r100.D;
        f0 r103 = r100.E;
        this.f199746s = new b0.a();
        this.f199747t = r100.F;
        this.f199748u = r100.G;
        this.H = true;
        this.f199749v = r100.H;
        this.f199750w = r100.I;
        this.f199751x = r100.f199689J;
        this.I = r100.K;
        this.f199727J = true;
        this.K = r100.L;
        this.L = r100.M;
        f84.c r104 = r100.N;
        this.N = r100.O;
        if (r104 == null) goto L13;
        this.M = r104;
        r104.f475869a = this;
        return;
    L13:
        f84.c r105 = new f84.c();
        this.M = r105;
        r105.f475869a = this;
        return;
    L9:
        r102 = r100.f199701l;
        goto L10
    }
}
