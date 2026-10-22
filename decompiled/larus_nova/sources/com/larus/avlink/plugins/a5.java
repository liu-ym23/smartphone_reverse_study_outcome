package com.larus.avlink.plugins;

import com.larus.avlink.e.DoraImageEvent;
import com.larus.avlink.e.DoraImageManager;
import com.larus.voicecall.api.bean.DoraTraceParam;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class a5 {
    public long A;
    public long B;
    public long C;
    public long D;
    public long E;
    public String F;
    public final long G;
    public long H;
    public long I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public long f293796J;
    public Long K;
    public Long L;
    public Long M;
    public Long N;
    public Long O;
    public Long P;
    public DoraTraceParam.b Q;
    public Long R;
    public Long S;
    public Long T;
    public Long U;
    public Long V;
    public Long W;
    public String X;
    public int Y;
    public long Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f293797a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public long f293798a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f293799b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public int f293800b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f293801c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public int f293802c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f293803d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f293804e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f293805f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f293806g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f293807h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Long f293808i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Long f293809j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Long f293810k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Long f293811l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Long f293812m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f293813n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Long f293814o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Long f293815p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Long f293816q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f293817r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Long f293818s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f293819t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f293820u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f293821v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Boolean f293822w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Long f293823x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Long f293824y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Long f293825z;

    public final long a() {
        Long r100 = this.f293808i;
        if (r100 == null) goto L8;
        r100.longValue();
        Long r101 = this.f293810k;
        if (r101 == null) goto L8;
        r101.longValue();
        Long r102 = this.f293808i;
        Intrinsics.checkNotNull(r102);
        long r103 = r102.longValue();
        Long r104 = this.f293810k;
        Intrinsics.checkNotNull(r104);
        return r103 - r104.longValue();
    L8:
        return 0;
    }

    public final com.larus.avlink.model.a b() {
        Integer r100 = null;
        if (this.f293803d == false) goto L6;
        return null;
    L6:
        if (v88.a.a(Integer.valueOf(this.f293804e)) == false) goto L40;
        Map<String, com.larus.avlink.model.a> r101 = DoraImageManager.f291761a;
        Integer r102 = Integer.valueOf(this.f293804e);
        if (v88.a.c(r102) == false) goto L11;
    L13:
        int r103 = 2;
    L14:
        Map<String, com.larus.avlink.model.a> r104 = DoraImageManager.f291761a;
        monitor-enter(r104);
    L37:
        th = move-exception;
        throw th;
    L17:
        if (r104.isEmpty() == false) goto L19;
        com.larus.avlink.model.a r105 = null;
    L35:
        monitor-exit(r104);
    L41:
        StringBuilder r106 = new StringBuilder("imageid: ");
        if (r105 == null) goto L44;
        r100 = r105.f293422a;
    L44:
        r106.append(r100);
        com.larus.avlink.n1.d("QueryTraceModel", r106.toString());
        return r105;
    L19:
        Iterator<T> r107 = r104.values().iterator();     // Catch: Throwable -> L37
        Object r108 = null;
    L21:
        if (r107.hasNext() == false) goto L34;
        Object r109 = r107.next();     // Catch: Throwable -> L37
        com.larus.avlink.model.a r110 = (com.larus.avlink.model.a) r109;     // Catch: Throwable -> L37
        boolean r111 = false;
        if (r110.f293434m != r103) goto L32;
        z98.d r112 = r110.M.get(DoraImageEvent.IMAGE_UPLOAD_FINISH);     // Catch: Throwable -> L37
        if (r112 != null) goto L27;
    L29:
        boolean r113 = false;
    L30:
        if (r113 == false) goto L32;
        r111 = true;
        goto L32
    L27:
        if (r112.f571057a != true) goto L29;
        r113 = true;
    L32:
        if (r111 == false) goto L21;
        r108 = r109;
        goto L21
    L34:
        r105 = (com.larus.avlink.model.a) r108;     // Catch: Throwable -> L37
        goto L35
    L11:
        if (v88.a.b(r102) == false) goto L13;
        r103 = 17;
        goto L14
    L40:
        Map<String, com.larus.avlink.model.a> r114 = DoraImageManager.f291761a;
        r105 = DoraImageManager.b(this.f293805f);
        goto L41
    }

    public a5(boolean r110, boolean r111, int r112, boolean r210, int r211) {
        Intrinsics.checkNotNullParameter("", "messageId");
        this.f293797a = r110;
        this.f293799b = r111;
        this.f293801c = r112;
        this.f293803d = r210;
        this.f293804e = r211;
        this.f293805f = "";
        this.f293806g = false;
        this.f293807h = null;
        this.f293808i = null;
        this.f293809j = null;
        this.f293810k = null;
        this.f293811l = null;
        this.f293812m = null;
        this.f293813n = false;
        this.f293814o = 0L;
        this.f293815p = 0L;
        this.f293816q = 0L;
        this.f293817r = 0;
        this.f293818s = 0L;
        this.f293819t = null;
        this.f293820u = null;
        this.f293821v = null;
        this.f293822w = null;
        this.f293823x = null;
        this.f293824y = 0L;
        this.f293825z = 0L;
        this.A = 0;
        this.B = 0;
        this.C = 0;
        this.D = 0;
        this.E = 0;
        this.F = null;
        this.G = 0;
        this.H = 0;
        this.I = 0;
        this.f293796J = 0;
        this.K = 0L;
        this.L = 0L;
        this.M = 0L;
        this.N = 0L;
        this.O = 0L;
        this.P = 0L;
        this.Q = null;
        this.R = null;
        this.S = null;
        this.T = null;
        this.U = null;
        this.V = null;
        this.W = null;
        this.X = null;
        this.Y = 0;
        this.Z = -1;
        this.f293798a0 = -1;
        this.f293800b0 = -1;
        this.f293802c0 = -1;
    }
}
