package com.bytedance.bdinstall;

import android.accounts.Account;
import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.bytedance.bdinstall.util.DeviceCategory;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class l {
    public JSONObject A;
    public Map<String, Object> B;
    public Account C;
    public boolean D;
    public f0 E;
    public h0 F;
    public boolean G;
    public a84.a H;
    public boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f199689J;
    public boolean K;
    public boolean L;
    public DeviceCategory M;
    public f84.c N;
    public TelephonyManager O;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public x0 f199690a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f199691b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c0 f199692c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f199693d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f199694e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f199695f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public z f199696g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f199697h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f199698i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public g0 f199699j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Context f199700k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f199701l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f199702m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f199703n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f199704o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f199705p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f199706q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f199707r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f199708s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f199709t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f199710u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f199711v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public x f199712w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f199713x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f199714y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f199715z;

    public final o0 a() {
        if (this.f199700k != null) goto L5;
    L29:
        StringBuilder r100 = new StringBuilder("parameters error:");
        if (this.f199700k != null) goto L32;
        boolean r101 = true;
    L33:
        r100.append(r101);
        r100.append(", ");
        r100.append(this.f199698i);
        r100.append(", ");
        r100.append(this.f199709t);
        throw new IllegalArgumentException(r100.toString());
    L32:
        r101 = false;
        goto L33
    L5:
        if (this.f199698i <= 0) goto L29;
        if (TextUtils.isEmpty(this.f199709t) == true) goto L29;
        if (TextUtils.isEmpty(this.f199708s) == true) goto L28;
        int r102 = t.f199790a;
        if (this.f199699j == null) goto L26;
        if (this.f199692c == null) goto L24;
        if (TextUtils.isEmpty(this.f199710u) == false) goto L19;
        this.f199710u = this.f199709t;
    L19:
        if (this.O != null) goto L21;
        this.O = (TelephonyManager) this.f199700k.getSystemService("phone");
    L21:
        i84.d r103 = i84.d.b();
        int r104 = this.f199698i;
        r103.getClass();
        ConcurrentHashMap r105 = new ConcurrentHashMap();
        r105.put(MiPushClient.COMMAND_REGISTER, new z74.c());
        r105.put("activate", new z74.a());
        r105.put("params", new z74.b());
        Map<String, Map<String, l74.c>> r106 = r103.f488618a;
        ConcurrentHashMap r107 = (ConcurrentHashMap) r106;
        r107.put(String.valueOf(r104), r105);
        return new o0(this);
    L24:
        throw new IllegalArgumentException("please set event depend");
    L26:
        throw new IllegalArgumentException("please set network client");
    L28:
        throw new IllegalArgumentException("appName is empty");
    }

    public l() {
        this.D = false;
        this.H = new a84.a.C0026a();
        this.I = true;
        this.f199689J = false;
        this.K = true;
        this.L = false;
    }
}
