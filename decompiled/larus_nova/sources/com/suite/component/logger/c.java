package com.suite.component.logger;

import com.suite.component.logger.api.LogLevel;
import com.suite.component.logger.api.h;
import java.util.HashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class c {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final Object f460112w = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static c f460113x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static int f460114y;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LogLevel f460115a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f460116b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f460117c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String[] f460118d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function0<String> f460119e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f460120f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f460121g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f460122h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f460123i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Throwable f460124j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f460125k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f460126l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f460127m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f460128n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f460129o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public HashMap<String, Object> f460130p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public HashMap<String, Object> f460131q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public h f460132r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public e f460133s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public c f460134t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f460135u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f460136v;

    public static final class a {
        @JvmStatic
        public static c a() {
            Object r100 = c.f460112w;
            monitor-enter(r100);
            c r101 = c.f460113x;     // Catch: Throwable -> L10
            if (r101 == null) goto L7;
            c.f460113x = r101.f460134t;     // Catch: Throwable -> L10
            r101.f460134t = null;     // Catch: Throwable -> L10
            r101.f460135u = 0;     // Catch: Throwable -> L10
            c.f460114y--;     // Catch: Throwable -> L10
        L8:
            monitor-exit(r100);
            return r101;
        L7:
            r101 = new c();     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            throw th;
        }
    }

    static {
        f460112w = new Object();
    }

    public final void a() {
        int r100 = this.f460135u;
        int r101 = this.f460136v;
        if ((r100 & r101) != r101) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
        return;
    L8:
        this.f460135u = r100 | r101;
        this.f460115a = LogLevel.ERROR;
        this.f460116b = "";
        this.f460117c = "";
        this.f460119e = null;
        this.f460120f = null;
        this.f460121g = null;
        this.f460122h = null;
        this.f460123i = -1;
        this.f460125k = -1;
        this.f460126l = "";
        this.f460127m = -1;
        this.f460128n = "";
        this.f460129o = -1;
        this.f460124j = null;
        HashMap<String, Object> r103 = this.f460130p;
        if (r103 == null) goto L11;
        r103.clear();
    L11:
        HashMap<String, Object> r104 = this.f460131q;
        if (r104 == null) goto L14;
        r104.clear();
    L14:
        this.f460132r = null;
        this.f460133s = null;
        Object r105 = f460112w;
        monitor-enter(r105);
        int r106 = f460114y;     // Catch: Throwable -> L22
        if (r106 >= 50) goto L19;
        this.f460134t = f460113x;     // Catch: Throwable -> L22
        f460113x = this;     // Catch: Throwable -> L22
        f460114y = r106 + 1;     // Catch: Throwable -> L22
    L19:
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L22
        monitor-exit(r105);
        return;
    L22:
        th = move-exception;
        throw th;
    L5:
        r102 = false;
        goto L6
    }

    public c() {
        this.f460115a = LogLevel.INFO;
        this.f460116b = "";
        this.f460117c = "";
        this.f460123i = -1;
        this.f460125k = -1;
        this.f460126l = "";
        this.f460127m = -1;
        this.f460128n = "";
        this.f460129o = -1;
        this.f460136v = 1;
    }

    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f460117c = r100;
    }

    public final void c(Map<String, ? extends Object> r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        if (r101 == false) goto L11;
        return;
    L11:
        if (this.f460130p != null) goto L13;
        this.f460130p = new HashMap(4);
    L13:
        HashMap<String, Object> r102 = this.f460130p;
        if (r102 == null) goto L17;
        r102.putAll(r100);
        return;
    L17:
        return;
    L4:
        if (r100.isEmpty() == true) goto L7;
        r101 = false;
        goto L8
    }
}
