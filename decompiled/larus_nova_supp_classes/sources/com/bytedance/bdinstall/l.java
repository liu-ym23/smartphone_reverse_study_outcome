package com.bytedance.bdinstall;

import a84.a;
import android.accounts.Account;
import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.bytedance.bdinstall.util.DeviceCategory;
import f84.c;
import i84.d;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
import z74.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class l {
    public JSONObject A;
    public Map<String, Object> B;
    public Account C;
    public boolean D;
    public f0 E;
    public h0 F;
    public boolean G;
    public a H;
    public boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f2J;
    public boolean K;
    public boolean L;
    public DeviceCategory M;
    public c N;
    public TelephonyManager O;
    public x0 a;
    public boolean b;
    public c0 c;
    public boolean d;
    public boolean e;
    public boolean f;
    public z g;
    public boolean h;
    public int i;
    public g0 j;
    public Context k;
    public String l;
    public String m;
    public String n;
    public String o;
    public long p;
    public long q;
    public long r;
    public String s;
    public String t;
    public String u;
    public String v;
    public x w;
    public String x;
    public String y;
    public String z;

    public final o0 a() {
        if (this.k != null) goto L5;
    L29:
        StringBuilder r1 = new StringBuilder("parameters error:");
        if (this.k != null) goto L32;
        boolean r2 = true;
    L33:
        r1.append(r2);
        r1.append(", ");
        r1.append(this.i);
        r1.append(", ");
        r1.append(this.t);
        throw new IllegalArgumentException(r1.toString());
    L32:
        r2 = false;
        goto L33
    L5:
        if (this.i <= 0) goto L29;
        if (TextUtils.isEmpty(this.t) == true) goto L29;
        if (TextUtils.isEmpty(this.s) == true) goto L28;
        int r0 = t.a;
        if (this.j == null) goto L26;
        if (this.c == null) goto L24;
        if (TextUtils.isEmpty(this.u) == false) goto L19;
        this.u = this.t;
    L19:
        if (this.O != null) goto L21;
        this.O = (TelephonyManager) this.k.getSystemService("phone");
    L21:
        d r3 = d.b();
        int r4 = this.i;
        r3.getClass();
        ConcurrentHashMap r5 = new ConcurrentHashMap();
        r5.put("register", new z74.c());
        r5.put("activate", new z74.a());
        r5.put("params", new b());
        Map r6 = r3.a;
        ConcurrentHashMap r7 = (ConcurrentHashMap) r6;
        r7.put(String.valueOf(r4), r5);
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
        this.H = new a.C0000a();
        this.I = true;
        this.f2J = false;
        this.K = true;
        this.L = false;
    }
}
