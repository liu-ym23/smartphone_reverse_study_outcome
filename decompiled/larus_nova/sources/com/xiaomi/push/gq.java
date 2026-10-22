package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* JADX INFO: loaded from: classes41.dex */
public class gq implements hp<gq, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final hw f463843a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final ie f660a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final hw f463844b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final hw f463845c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final hw f463846d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final hw f463847e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final hw f463848f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final hw f463849g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final hw f463850h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final hw f463851i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final hw f463852j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final hw f463853k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final hw f463854l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final hw f463855m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final hw f463856n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final hw f463857o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final hw f463858p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final hw f463859q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final hw f463860r = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f661a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public gr f662a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public gt f663a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f664a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private BitSet f665a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f666a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long f667b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f668b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public long f669c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public String f670c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public String f671d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public String f672e;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public String f673f;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public String f674g;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    public String f675h;

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    public String f676i;

    /* JADX INFO: renamed from: j, reason: collision with other field name */
    public String f677j;

    /* JADX INFO: renamed from: k, reason: collision with other field name */
    public String f678k;

    /* JADX INFO: renamed from: l, reason: collision with other field name */
    public String f679l;

    public int hashCode() {
        return 0;
    }

    static {
        f660a = new ie("PushMessage");
        f463843a = new hw("", (byte) 12, 1);
        f463844b = new hw("", (byte) 11, 2);
        f463845c = new hw("", (byte) 11, 3);
        f463846d = new hw("", (byte) 11, 4);
        f463847e = new hw("", (byte) 10, 5);
        f463848f = new hw("", (byte) 10, 6);
        f463849g = new hw("", (byte) 11, 7);
        f463850h = new hw("", (byte) 11, 8);
        f463851i = new hw("", (byte) 11, 9);
        f463852j = new hw("", (byte) 11, 10);
        f463853k = new hw("", (byte) 11, 11);
        f463854l = new hw("", (byte) 12, 12);
        f463855m = new hw("", (byte) 11, 13);
        f463856n = new hw("", (byte) 2, 14);
        f463857o = new hw("", (byte) 11, 15);
        f463858p = new hw("", (byte) 10, 16);
        f463859q = new hw("", (byte) 11, 20);
        f463860r = new hw("", (byte) 11, 21);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m9156a() {
        if (this.f664a == null) goto L14;
        if (this.f668b == null) goto L12;
        if (this.f670c == null) goto L10;
        return;
    L10:
        throw new ia("Required field 'payload' was not present! Struct: " + toString());
    L12:
        throw new ia("Required field 'appId' was not present! Struct: " + toString());
    L14:
        throw new ia("Required field 'id' was not present! Struct: " + toString());
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public boolean m9159b() {
        if (this.f664a == null) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public boolean m9160c() {
        if (this.f668b == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean d() {
        if (this.f670c == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean e() {
        return this.f665a.get(0);
    }

    public boolean f() {
        return this.f665a.get(1);
    }

    public boolean g() {
        if (this.f671d == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean h() {
        if (this.f672e == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean i() {
        if (this.f673f == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean j() {
        if (this.f674g == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean k() {
        if (this.f675h == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean l() {
        if (this.f662a == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean m() {
        if (this.f676i == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean n() {
        return this.f665a.get(2);
    }

    public boolean o() {
        if (this.f677j == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean p() {
        return this.f665a.get(3);
    }

    public boolean q() {
        if (this.f678k == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean r() {
        if (this.f679l == null) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("PushMessage(");
        if (m9157a() == false) goto L9;
        r100.append("to:");
        gt r101 = this.f663a;
        if (r101 != null) goto L7;
        r100.append("null");
    L8:
        boolean r102 = false;
    L11:
        if (r102 == true) goto L13;
        r100.append(", ");
    L13:
        r100.append("id:");
        String r103 = this.f664a;
        if (r103 != null) goto L16;
        r100.append("null");
    L17:
        r100.append(", ");
        r100.append("appId:");
        String r104 = this.f668b;
        if (r104 != null) goto L20;
        r100.append("null");
    L21:
        r100.append(", ");
        r100.append("payload:");
        String r105 = this.f670c;
        if (r105 != null) goto L24;
        r100.append("null");
    L26:
        if (e() == false) goto L29;
        r100.append(", ");
        r100.append("createAt:");
        r100.append(this.f661a);
    L29:
        if (f() == false) goto L32;
        r100.append(", ");
        r100.append("ttl:");
        r100.append(this.f667b);
    L32:
        if (g() == false) goto L38;
        r100.append(", ");
        r100.append("collapseKey:");
        String r106 = this.f671d;
        if (r106 != null) goto L36;
        r100.append("null");
        goto L38
    L36:
        r100.append(r106);
    L38:
        if (h() == false) goto L44;
        r100.append(", ");
        r100.append("packageName:");
        String r107 = this.f672e;
        if (r107 != null) goto L42;
        r100.append("null");
        goto L44
    L42:
        r100.append(r107);
    L44:
        if (i() == false) goto L50;
        r100.append(", ");
        r100.append("regId:");
        String r108 = this.f673f;
        if (r108 != null) goto L48;
        r100.append("null");
        goto L50
    L48:
        r100.append(r108);
    L50:
        if (j() == false) goto L56;
        r100.append(", ");
        r100.append("category:");
        String r109 = this.f674g;
        if (r109 != null) goto L54;
        r100.append("null");
        goto L56
    L54:
        r100.append(r109);
    L56:
        if (k() == false) goto L62;
        r100.append(", ");
        r100.append("topic:");
        String r110 = this.f675h;
        if (r110 != null) goto L60;
        r100.append("null");
        goto L62
    L60:
        r100.append(r110);
    L62:
        if (l() == false) goto L68;
        r100.append(", ");
        r100.append("metaInfo:");
        gr r111 = this.f662a;
        if (r111 != null) goto L66;
        r100.append("null");
        goto L68
    L66:
        r100.append(r111);
    L68:
        if (m() == false) goto L74;
        r100.append(", ");
        r100.append("aliasName:");
        String r112 = this.f676i;
        if (r112 != null) goto L72;
        r100.append("null");
        goto L74
    L72:
        r100.append(r112);
    L74:
        if (n() == false) goto L77;
        r100.append(", ");
        r100.append("isOnline:");
        r100.append(this.f666a);
    L77:
        if (o() == false) goto L83;
        r100.append(", ");
        r100.append("userAccount:");
        String r113 = this.f677j;
        if (r113 != null) goto L81;
        r100.append("null");
        goto L83
    L81:
        r100.append(r113);
    L83:
        if (p() == false) goto L86;
        r100.append(", ");
        r100.append("miid:");
        r100.append(this.f669c);
    L86:
        if (q() == false) goto L92;
        r100.append(", ");
        r100.append("imeiMd5:");
        String r114 = this.f678k;
        if (r114 != null) goto L90;
        r100.append("null");
        goto L92
    L90:
        r100.append(r114);
    L92:
        if (r() == false) goto L97;
        r100.append(", ");
        r100.append("deviceId:");
        String r115 = this.f679l;
        if (r115 != null) goto L96;
        r100.append("null");
        goto L97
    L96:
        r100.append(r115);
    L97:
        r100.append(")");
        return r100.toString();
    L24:
        r100.append(r105);
        goto L26
    L20:
        r100.append(r104);
        goto L21
    L16:
        r100.append(r103);
        goto L17
    L7:
        r100.append(r101);
        goto L8
    L9:
        r102 = true;
        goto L11
    }

    public gq() {
        this.f665a = new BitSet(4);
        this.f666a = false;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m9157a() {
        if (this.f663a == null) goto L5;
        return true;
    L5:
        return false;
    }

    public String b() {
        return this.f668b;
    }

    public String c() {
        return this.f670c;
    }

    public long a() {
        return this.f661a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m9155a() {
        return this.f664a;
    }

    public int a(gq r100) {
        if (getClass().equals(r100.getClass()) == false) goto L5;
        int r101 = Boolean.valueOf(m9157a()).compareTo(Boolean.valueOf(r100.m9157a()));
        if (r101 == 0) goto L10;
        return r101;
    L10:
        if (m9157a() == false) goto L14;
        int r102 = hq.a(this.f663a, r100.f663a);
        if (r102 == 0) goto L14;
        return r102;
    L14:
        int r103 = Boolean.valueOf(m9159b()).compareTo(Boolean.valueOf(r100.m9159b()));
        if (r103 == 0) goto L18;
        return r103;
    L18:
        if (m9159b() == false) goto L22;
        int r104 = hq.a(this.f664a, r100.f664a);
        if (r104 == 0) goto L22;
        return r104;
    L22:
        int r105 = Boolean.valueOf(m9160c()).compareTo(Boolean.valueOf(r100.m9160c()));
        if (r105 == 0) goto L26;
        return r105;
    L26:
        if (m9160c() == false) goto L30;
        int r106 = hq.a(this.f668b, r100.f668b);
        if (r106 == 0) goto L30;
        return r106;
    L30:
        int r107 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(r100.d()));
        if (r107 == 0) goto L34;
        return r107;
    L34:
        if (d() == false) goto L38;
        int r108 = hq.a(this.f670c, r100.f670c);
        if (r108 == 0) goto L38;
        return r108;
    L38:
        int r109 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(r100.e()));
        if (r109 == 0) goto L42;
        return r109;
    L42:
        if (e() == false) goto L46;
        int r110 = hq.a(this.f661a, r100.f661a);
        if (r110 == 0) goto L46;
        return r110;
    L46:
        int r111 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(r100.f()));
        if (r111 == 0) goto L50;
        return r111;
    L50:
        if (f() == false) goto L54;
        int r112 = hq.a(this.f667b, r100.f667b);
        if (r112 == 0) goto L54;
        return r112;
    L54:
        int r113 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(r100.g()));
        if (r113 == 0) goto L58;
        return r113;
    L58:
        if (g() == false) goto L62;
        int r114 = hq.a(this.f671d, r100.f671d);
        if (r114 == 0) goto L62;
        return r114;
    L62:
        int r115 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(r100.h()));
        if (r115 == 0) goto L66;
        return r115;
    L66:
        if (h() == false) goto L70;
        int r116 = hq.a(this.f672e, r100.f672e);
        if (r116 == 0) goto L70;
        return r116;
    L70:
        int r117 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(r100.i()));
        if (r117 == 0) goto L74;
        return r117;
    L74:
        if (i() == false) goto L78;
        int r118 = hq.a(this.f673f, r100.f673f);
        if (r118 == 0) goto L78;
        return r118;
    L78:
        int r119 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(r100.j()));
        if (r119 == 0) goto L82;
        return r119;
    L82:
        if (j() == false) goto L86;
        int r120 = hq.a(this.f674g, r100.f674g);
        if (r120 == 0) goto L86;
        return r120;
    L86:
        int r121 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(r100.k()));
        if (r121 == 0) goto L90;
        return r121;
    L90:
        if (k() == false) goto L94;
        int r122 = hq.a(this.f675h, r100.f675h);
        if (r122 == 0) goto L94;
        return r122;
    L94:
        int r123 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(r100.l()));
        if (r123 == 0) goto L98;
        return r123;
    L98:
        if (l() == false) goto L102;
        int r124 = hq.a(this.f662a, r100.f662a);
        if (r124 == 0) goto L102;
        return r124;
    L102:
        int r125 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(r100.m()));
        if (r125 == 0) goto L106;
        return r125;
    L106:
        if (m() == false) goto L110;
        int r126 = hq.a(this.f676i, r100.f676i);
        if (r126 == 0) goto L110;
        return r126;
    L110:
        int r127 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(r100.n()));
        if (r127 == 0) goto L114;
        return r127;
    L114:
        if (n() == false) goto L118;
        int r128 = hq.a(this.f666a, r100.f666a);
        if (r128 == 0) goto L118;
        return r128;
    L118:
        int r129 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(r100.o()));
        if (r129 == 0) goto L122;
        return r129;
    L122:
        if (o() == false) goto L126;
        int r130 = hq.a(this.f677j, r100.f677j);
        if (r130 == 0) goto L126;
        return r130;
    L126:
        int r131 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(r100.p()));
        if (r131 == 0) goto L130;
        return r131;
    L130:
        if (p() == false) goto L134;
        int r132 = hq.a(this.f669c, r100.f669c);
        if (r132 == 0) goto L134;
        return r132;
    L134:
        int r133 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(r100.q()));
        if (r133 == 0) goto L138;
        return r133;
    L138:
        if (q() == false) goto L142;
        int r134 = hq.a(this.f678k, r100.f678k);
        if (r134 == 0) goto L142;
        return r134;
    L142:
        int r135 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(r100.r()));
        if (r135 == 0) goto L146;
        return r135;
    L146:
        if (r() == false) goto L150;
        int r136 = hq.a(this.f679l, r100.f679l);
        if (r136 == 0) goto L152;
        return r136;
    L152:
        return 0;
    L150:
        return 0;
    L5:
        return getClass().getName().compareTo(r100.getClass().getName());
    }

    @Override // com.xiaomi.push.hp
    public void b(hz r100) {
        m9156a();
        r100.a(f660a);
        if (this.f663a == null) goto L8;
        if (m9157a() == false) goto L8;
        r100.a(f463843a);
        this.f663a.b(r100);
        r100.b();
    L8:
        if (this.f664a == null) goto L11;
        r100.a(f463844b);
        r100.a(this.f664a);
        r100.b();
    L11:
        if (this.f668b == null) goto L14;
        r100.a(f463845c);
        r100.a(this.f668b);
        r100.b();
    L14:
        if (this.f670c == null) goto L17;
        r100.a(f463846d);
        r100.a(this.f670c);
        r100.b();
    L17:
        if (e() == false) goto L20;
        r100.a(f463847e);
        r100.a(this.f661a);
        r100.b();
    L20:
        if (f() == false) goto L23;
        r100.a(f463848f);
        r100.a(this.f667b);
        r100.b();
    L23:
        if (this.f671d == null) goto L28;
        if (g() == false) goto L28;
        r100.a(f463849g);
        r100.a(this.f671d);
        r100.b();
    L28:
        if (this.f672e == null) goto L33;
        if (h() == false) goto L33;
        r100.a(f463850h);
        r100.a(this.f672e);
        r100.b();
    L33:
        if (this.f673f == null) goto L38;
        if (i() == false) goto L38;
        r100.a(f463851i);
        r100.a(this.f673f);
        r100.b();
    L38:
        if (this.f674g == null) goto L43;
        if (j() == false) goto L43;
        r100.a(f463852j);
        r100.a(this.f674g);
        r100.b();
    L43:
        if (this.f675h == null) goto L48;
        if (k() == false) goto L48;
        r100.a(f463853k);
        r100.a(this.f675h);
        r100.b();
    L48:
        if (this.f662a == null) goto L53;
        if (l() == false) goto L53;
        r100.a(f463854l);
        this.f662a.b(r100);
        r100.b();
    L53:
        if (this.f676i == null) goto L58;
        if (m() == false) goto L58;
        r100.a(f463855m);
        r100.a(this.f676i);
        r100.b();
    L58:
        if (n() == false) goto L61;
        r100.a(f463856n);
        r100.a(this.f666a);
        r100.b();
    L61:
        if (this.f677j == null) goto L66;
        if (o() == false) goto L66;
        r100.a(f463857o);
        r100.a(this.f677j);
        r100.b();
    L66:
        if (p() == false) goto L69;
        r100.a(f463858p);
        r100.a(this.f669c);
        r100.b();
    L69:
        if (this.f678k == null) goto L74;
        if (q() == false) goto L74;
        r100.a(f463859q);
        r100.a(this.f678k);
        r100.b();
    L74:
        if (this.f679l != null) goto L76;
    L78:
        r100.c();
        r100.mo9279a();
        return;
    L76:
        if (r() == false) goto L78;
        r100.a(f463860r);
        r100.a(this.f679l);
        r100.b();
        goto L78
    }

    public void c(boolean r100) {
        this.f665a.set(2, r100);
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(Object r100) {
        return a((gq) r100);
    }

    public void d(boolean r100) {
        this.f665a.set(3, r100);
    }

    public boolean equals(Object r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if ((r100 instanceof gq) == true) goto L8;
        return false;
    L8:
        return m9158a((gq) r100);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m9158a(gq r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        boolean r101 = m9157a();
        boolean r102 = r100.m9157a();
        if (r101 == true) goto L8;
        if (r102 == true) goto L8;
    L14:
        boolean r103 = m9159b();
        boolean r104 = r100.m9159b();
        if (r103 == true) goto L17;
        if (r104 == true) goto L17;
    L23:
        boolean r105 = m9160c();
        boolean r106 = r100.m9160c();
        if (r105 == true) goto L26;
        if (r106 == true) goto L26;
    L32:
        boolean r107 = d();
        boolean r108 = r100.d();
        if (r107 == true) goto L35;
        if (r108 == true) goto L35;
    L41:
        boolean r109 = e();
        boolean r110 = r100.e();
        if (r109 == true) goto L44;
        if (r110 == true) goto L44;
    L50:
        boolean r111 = f();
        boolean r112 = r100.f();
        if (r111 == true) goto L53;
        if (r112 == true) goto L53;
    L59:
        boolean r113 = g();
        boolean r114 = r100.g();
        if (r113 == true) goto L62;
        if (r114 == true) goto L62;
    L68:
        boolean r115 = h();
        boolean r116 = r100.h();
        if (r115 == true) goto L71;
        if (r116 == true) goto L71;
    L77:
        boolean r117 = i();
        boolean r118 = r100.i();
        if (r117 == true) goto L80;
        if (r118 == true) goto L80;
    L86:
        boolean r119 = j();
        boolean r120 = r100.j();
        if (r119 == true) goto L89;
        if (r120 == true) goto L89;
    L95:
        boolean r121 = k();
        boolean r122 = r100.k();
        if (r121 == true) goto L98;
        if (r122 == true) goto L98;
    L104:
        boolean r123 = l();
        boolean r124 = r100.l();
        if (r123 == true) goto L107;
        if (r124 == true) goto L107;
    L113:
        boolean r125 = m();
        boolean r126 = r100.m();
        if (r125 == true) goto L116;
        if (r126 == true) goto L116;
    L122:
        boolean r127 = n();
        boolean r128 = r100.n();
        if (r127 == true) goto L125;
        if (r128 == true) goto L125;
    L131:
        boolean r129 = o();
        boolean r130 = r100.o();
        if (r129 == true) goto L134;
        if (r130 == true) goto L134;
    L140:
        boolean r131 = p();
        boolean r132 = r100.p();
        if (r131 == true) goto L143;
        if (r132 == true) goto L143;
    L149:
        boolean r133 = q();
        boolean r134 = r100.q();
        if (r133 == true) goto L152;
        if (r134 == true) goto L152;
    L158:
        boolean r135 = r();
        boolean r136 = r100.r();
        if (r135 == true) goto L161;
        if (r136 == true) goto L161;
        return true;
    L161:
        if (r135 == false) goto L169;
        if (r136 == false) goto L169;
        if (this.f679l.equals(r100.f679l) == true) goto L170;
        return false;
    L170:
        return true;
    L169:
        return false;
    L152:
        if (r133 == false) goto L169;
        if (r134 == false) goto L169;
        if (this.f678k.equals(r100.f678k) == true) goto L158;
        return false;
    L143:
        if (r131 == false) goto L169;
        if (r132 == false) goto L169;
        if (this.f669c == r100.f669c) goto L149;
        return false;
    L134:
        if (r129 == false) goto L169;
        if (r130 == false) goto L169;
        if (this.f677j.equals(r100.f677j) == true) goto L140;
        return false;
    L125:
        if (r127 == false) goto L169;
        if (r128 == false) goto L169;
        if (this.f666a == r100.f666a) goto L131;
        return false;
    L116:
        if (r125 == false) goto L169;
        if (r126 == false) goto L169;
        if (this.f676i.equals(r100.f676i) == true) goto L122;
        return false;
    L107:
        if (r123 == false) goto L169;
        if (r124 == false) goto L169;
        if (this.f662a.m9167a(r100.f662a) == true) goto L113;
        return false;
    L98:
        if (r121 == false) goto L169;
        if (r122 == false) goto L169;
        if (this.f675h.equals(r100.f675h) == true) goto L104;
        return false;
    L89:
        if (r119 == false) goto L169;
        if (r120 == false) goto L169;
        if (this.f674g.equals(r100.f674g) == true) goto L95;
        return false;
    L80:
        if (r117 == false) goto L169;
        if (r118 == false) goto L169;
        if (this.f673f.equals(r100.f673f) == true) goto L86;
        return false;
    L71:
        if (r115 == false) goto L169;
        if (r116 == false) goto L169;
        if (this.f672e.equals(r100.f672e) == true) goto L77;
        return false;
    L62:
        if (r113 == false) goto L169;
        if (r114 == false) goto L169;
        if (this.f671d.equals(r100.f671d) == true) goto L68;
        return false;
    L53:
        if (r111 == false) goto L169;
        if (r112 == false) goto L169;
        if (this.f667b == r100.f667b) goto L59;
        return false;
    L44:
        if (r109 == false) goto L169;
        if (r110 == false) goto L169;
        if (this.f661a == r100.f661a) goto L50;
        return false;
    L35:
        if (r107 == false) goto L169;
        if (r108 == false) goto L169;
        if (this.f670c.equals(r100.f670c) == true) goto L41;
        return false;
    L26:
        if (r105 == false) goto L169;
        if (r106 == false) goto L169;
        if (this.f668b.equals(r100.f668b) == true) goto L32;
        return false;
    L17:
        if (r103 == false) goto L169;
        if (r104 == false) goto L169;
        if (this.f664a.equals(r100.f664a) == true) goto L23;
        return false;
    L8:
        if (r101 == false) goto L169;
        if (r102 == false) goto L169;
        if (this.f663a.m9175a(r100.f663a) == true) goto L14;
        return false;
    }

    public void b(boolean r100) {
        this.f665a.set(1, r100);
    }

    @Override // com.xiaomi.push.hp
    public void a(hz r100) {
        r100.mo9275a();
    L3:
        hw r101 = r100.mo9271a();
        byte r102 = r101.f464095a;
        if (r102 == 0) goto L5;
        short r103 = r101.f951a;
        if (r103 != 20) goto L10;
        if (r102 != 11) goto L68;
        this.f678k = r100.mo9276a();
    L69:
        r100.g();
        goto L3
    L68:
        ic.a(r100, r102);
        goto L69
    L10:
        if (r103 != 21) goto L12;
        if (r102 != 11) goto L65;
        this.f679l = r100.mo9276a();
        goto L69
    L65:
        ic.a(r100, r102);
        goto L69
    L12:
        switch(r103) {
            case 1: goto L60;
            case 2: goto L57;
            case 3: goto L54;
            case 4: goto L51;
            case 5: goto L48;
            case 6: goto L45;
            case 7: goto L42;
            case 8: goto L39;
            case 9: goto L36;
            case 10: goto L33;
            case 11: goto L30;
            case 12: goto L27;
            case 13: goto L24;
            case 14: goto L21;
            case 15: goto L17;
            case 16: goto L14;
            default: goto L13;
        };
    L13:
        ic.a(r100, r102);
        goto L69
    L14:
        if (r102 != 10) goto L16;
        this.f669c = r100.mo9270a();
        d(true);
        goto L69
    L16:
        ic.a(r100, r102);
        goto L69
    L17:
        if (r102 != 11) goto L19;
        this.f677j = r100.mo9276a();
        goto L69
    L19:
        ic.a(r100, r102);
        goto L69
    L24:
        if (r102 != 11) goto L26;
        this.f676i = r100.mo9276a();
        goto L69
    L26:
        ic.a(r100, r102);
        goto L69
    L27:
        if (r102 != 12) goto L29;
        gr r104 = new gr();
        this.f662a = r104;
        r104.a(r100);
        goto L69
    L29:
        ic.a(r100, r102);
        goto L69
    L30:
        if (r102 != 11) goto L32;
        this.f675h = r100.mo9276a();
        goto L69
    L32:
        ic.a(r100, r102);
        goto L69
    L33:
        if (r102 != 11) goto L35;
        this.f674g = r100.mo9276a();
        goto L69
    L35:
        ic.a(r100, r102);
        goto L69
    L36:
        if (r102 != 11) goto L38;
        this.f673f = r100.mo9276a();
        goto L69
    L38:
        ic.a(r100, r102);
        goto L69
    L39:
        if (r102 != 11) goto L41;
        this.f672e = r100.mo9276a();
        goto L69
    L41:
        ic.a(r100, r102);
        goto L69
    L42:
        if (r102 != 11) goto L44;
        this.f671d = r100.mo9276a();
        goto L69
    L44:
        ic.a(r100, r102);
        goto L69
    L45:
        if (r102 != 10) goto L47;
        this.f667b = r100.mo9270a();
        b(true);
        goto L69
    L47:
        ic.a(r100, r102);
        goto L69
    L48:
        if (r102 != 10) goto L50;
        this.f661a = r100.mo9270a();
        a(true);
        goto L69
    L50:
        ic.a(r100, r102);
        goto L69
    L51:
        if (r102 != 11) goto L53;
        this.f670c = r100.mo9276a();
        goto L69
    L53:
        ic.a(r100, r102);
        goto L69
    L54:
        if (r102 != 11) goto L56;
        this.f668b = r100.mo9276a();
        goto L69
    L56:
        ic.a(r100, r102);
        goto L69
    L57:
        if (r102 != 11) goto L59;
        this.f664a = r100.mo9276a();
        goto L69
    L59:
        ic.a(r100, r102);
        goto L69
    L60:
        if (r102 != 12) goto L62;
        gt r105 = new gt();
        this.f663a = r105;
        r105.a(r100);
        goto L69
    L62:
        ic.a(r100, r102);
        goto L69
    L21:
        if (r102 != 2) goto L23;
        this.f666a = r100.mo9281a();
        c(true);
        goto L69
    L23:
        ic.a(r100, r102);
        goto L69
    L5:
        r100.f();
        m9156a();
    }

    public void a(boolean r100) {
        this.f665a.set(0, r100);
    }
}
