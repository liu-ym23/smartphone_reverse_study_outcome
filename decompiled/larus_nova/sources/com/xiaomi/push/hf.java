package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes41.dex */
public class hf implements hp<hf, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final hw f463988a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final ie f831a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final hw f463989b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final hw f463990c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final hw f463991d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final hw f463992e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final hw f463993f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final hw f463994g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final hw f463995h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final hw f463996i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final hw f463997j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final hw f463998k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final hw f463999l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final hw f464000m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final hw f464001n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final hw f464002o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final hw f464003p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final hw f464004q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final hw f464005r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final hw f464006s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final hw f464007t = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f832a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f833a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public gt f834a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f835a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private BitSet f836a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<String> f837a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f838a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f839b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long f840b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f841b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public long f842c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public String f843c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public String f844d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public String f845e;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public String f846f;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public String f847g;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    public String f848h;

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    public String f849i;

    /* JADX INFO: renamed from: j, reason: collision with other field name */
    public String f850j;

    /* JADX INFO: renamed from: k, reason: collision with other field name */
    public String f851k;

    /* JADX INFO: renamed from: l, reason: collision with other field name */
    public String f852l;

    public int hashCode() {
        return 0;
    }

    static {
        f831a = new ie("XmPushActionRegistrationResult");
        f463988a = new hw("", (byte) 11, 1);
        f463989b = new hw("", (byte) 12, 2);
        f463990c = new hw("", (byte) 11, 3);
        f463991d = new hw("", (byte) 11, 4);
        f463992e = new hw("", (byte) 10, 6);
        f463993f = new hw("", (byte) 11, 7);
        f463994g = new hw("", (byte) 11, 8);
        f463995h = new hw("", (byte) 11, 9);
        f463996i = new hw("", (byte) 11, 10);
        f463997j = new hw("", (byte) 10, 11);
        f463998k = new hw("", (byte) 11, 12);
        f463999l = new hw("", (byte) 11, 13);
        f464000m = new hw("", (byte) 10, 14);
        f464001n = new hw("", (byte) 11, 15);
        f464002o = new hw("", (byte) 8, 16);
        f464003p = new hw("", (byte) 11, 17);
        f464004q = new hw("", (byte) 8, 18);
        f464005r = new hw("", (byte) 11, 19);
        f464006s = new hw("", (byte) 2, 20);
        f464007t = new hw("", (byte) 15, 21);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m9229a() {
        if (this.f841b == null) goto L10;
        if (this.f843c == null) goto L8;
        return;
    L8:
        throw new ia("Required field 'appId' was not present! Struct: " + toString());
    L10:
        throw new ia("Required field 'id' was not present! Struct: " + toString());
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public boolean m9232b() {
        if (this.f834a == null) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public boolean m9233c() {
        if (this.f841b == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean d() {
        if (this.f843c == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean e() {
        return this.f836a.get(0);
    }

    public boolean f() {
        if (this.f844d == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean g() {
        if (this.f845e == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean h() {
        if (this.f846f == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean i() {
        if (this.f847g == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean j() {
        return this.f836a.get(1);
    }

    public boolean k() {
        if (this.f848h == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean l() {
        if (this.f849i == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean m() {
        return this.f836a.get(2);
    }

    public boolean n() {
        if (this.f850j == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean o() {
        return this.f836a.get(3);
    }

    public boolean p() {
        if (this.f851k == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean q() {
        return this.f836a.get(4);
    }

    public boolean r() {
        if (this.f852l == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean s() {
        return this.f836a.get(5);
    }

    public boolean t() {
        if (this.f837a == null) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("XmPushActionRegistrationResult(");
        boolean r101 = false;
        if (m9230a() == false) goto L9;
        r100.append("debug:");
        String r102 = this.f835a;
        if (r102 != null) goto L7;
        r100.append("null");
    L8:
        boolean r103 = false;
    L11:
        if (m9232b() == false) goto L18;
        if (r103 == true) goto L14;
        r100.append(", ");
    L14:
        r100.append("target:");
        gt r104 = this.f834a;
        if (r104 != null) goto L17;
        r100.append("null");
    L19:
        if (r101 == true) goto L21;
        r100.append(", ");
    L21:
        r100.append("id:");
        String r105 = this.f841b;
        if (r105 != null) goto L24;
        r100.append("null");
    L25:
        r100.append(", ");
        r100.append("appId:");
        String r106 = this.f843c;
        if (r106 != null) goto L28;
        r100.append("null");
    L29:
        r100.append(", ");
        r100.append("errorCode:");
        r100.append(this.f833a);
        if (f() == false) goto L36;
        r100.append(", ");
        r100.append("reason:");
        String r107 = this.f844d;
        if (r107 != null) goto L34;
        r100.append("null");
        goto L36
    L34:
        r100.append(r107);
    L36:
        if (g() == false) goto L42;
        r100.append(", ");
        r100.append("regId:");
        String r108 = this.f845e;
        if (r108 != null) goto L40;
        r100.append("null");
        goto L42
    L40:
        r100.append(r108);
    L42:
        if (i() == false) goto L48;
        r100.append(", ");
        r100.append("packageName:");
        String r109 = this.f847g;
        if (r109 != null) goto L46;
        r100.append("null");
        goto L48
    L46:
        r100.append(r109);
    L48:
        if (j() == false) goto L51;
        r100.append(", ");
        r100.append("registeredAt:");
        r100.append(this.f840b);
    L51:
        if (k() == false) goto L57;
        r100.append(", ");
        r100.append("aliasName:");
        String r110 = this.f848h;
        if (r110 != null) goto L55;
        r100.append("null");
        goto L57
    L55:
        r100.append(r110);
    L57:
        if (l() == false) goto L63;
        r100.append(", ");
        r100.append("clientId:");
        String r111 = this.f849i;
        if (r111 != null) goto L61;
        r100.append("null");
        goto L63
    L61:
        r100.append(r111);
    L63:
        if (m() == false) goto L66;
        r100.append(", ");
        r100.append("costTime:");
        r100.append(this.f842c);
    L66:
        if (n() == false) goto L72;
        r100.append(", ");
        r100.append("appVersion:");
        String r112 = this.f850j;
        if (r112 != null) goto L70;
        r100.append("null");
        goto L72
    L70:
        r100.append(r112);
    L72:
        if (o() == false) goto L75;
        r100.append(", ");
        r100.append("pushSdkVersionCode:");
        r100.append(this.f832a);
    L75:
        if (p() == false) goto L81;
        r100.append(", ");
        r100.append("hybridPushEndpoint:");
        String r113 = this.f851k;
        if (r113 != null) goto L79;
        r100.append("null");
        goto L81
    L79:
        r100.append(r113);
    L81:
        if (q() == false) goto L84;
        r100.append(", ");
        r100.append("appVersionCode:");
        r100.append(this.f839b);
    L84:
        if (r() == false) goto L90;
        r100.append(", ");
        r100.append("region:");
        String r114 = this.f852l;
        if (r114 != null) goto L88;
        r100.append("null");
        goto L90
    L88:
        r100.append(r114);
    L90:
        if (s() == false) goto L93;
        r100.append(", ");
        r100.append("isHybridFrame:");
        r100.append(this.f838a);
    L93:
        if (t() == false) goto L98;
        r100.append(", ");
        r100.append("autoMarkPkgs:");
        List<String> r115 = this.f837a;
        if (r115 != null) goto L97;
        r100.append("null");
        goto L98
    L97:
        r100.append(r115);
    L98:
        r100.append(")");
        return r100.toString();
    L28:
        r100.append(r106);
        goto L29
    L24:
        r100.append(com.xiaomi.push.service.aj.a(r105));
        goto L25
    L17:
        r100.append(r104);
        goto L19
    L18:
        r101 = r103;
        goto L19
    L7:
        r100.append(r102);
        goto L8
    L9:
        r103 = true;
        goto L11
    }

    public hf() {
        this.f836a = new BitSet(6);
        this.f838a = false;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m9230a() {
        if (this.f835a == null) goto L5;
        return true;
    L5:
        return false;
    }

    public String b() {
        return this.f846f;
    }

    public String c() {
        return this.f847g;
    }

    public long a() {
        return this.f833a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m9227a() {
        return this.f841b;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public List<String> m9228a() {
        return this.f837a;
    }

    public int a(hf r100) {
        if (getClass().equals(r100.getClass()) == false) goto L5;
        int r101 = Boolean.valueOf(m9230a()).compareTo(Boolean.valueOf(r100.m9230a()));
        if (r101 == 0) goto L10;
        return r101;
    L10:
        if (m9230a() == false) goto L14;
        int r102 = hq.a(this.f835a, r100.f835a);
        if (r102 == 0) goto L14;
        return r102;
    L14:
        int r103 = Boolean.valueOf(m9232b()).compareTo(Boolean.valueOf(r100.m9232b()));
        if (r103 == 0) goto L18;
        return r103;
    L18:
        if (m9232b() == false) goto L22;
        int r104 = hq.a(this.f834a, r100.f834a);
        if (r104 == 0) goto L22;
        return r104;
    L22:
        int r105 = Boolean.valueOf(m9233c()).compareTo(Boolean.valueOf(r100.m9233c()));
        if (r105 == 0) goto L26;
        return r105;
    L26:
        if (m9233c() == false) goto L30;
        int r106 = hq.a(this.f841b, r100.f841b);
        if (r106 == 0) goto L30;
        return r106;
    L30:
        int r107 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(r100.d()));
        if (r107 == 0) goto L34;
        return r107;
    L34:
        if (d() == false) goto L38;
        int r108 = hq.a(this.f843c, r100.f843c);
        if (r108 == 0) goto L38;
        return r108;
    L38:
        int r109 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(r100.e()));
        if (r109 == 0) goto L42;
        return r109;
    L42:
        if (e() == false) goto L46;
        int r110 = hq.a(this.f833a, r100.f833a);
        if (r110 == 0) goto L46;
        return r110;
    L46:
        int r111 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(r100.f()));
        if (r111 == 0) goto L50;
        return r111;
    L50:
        if (f() == false) goto L54;
        int r112 = hq.a(this.f844d, r100.f844d);
        if (r112 == 0) goto L54;
        return r112;
    L54:
        int r113 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(r100.g()));
        if (r113 == 0) goto L58;
        return r113;
    L58:
        if (g() == false) goto L62;
        int r114 = hq.a(this.f845e, r100.f845e);
        if (r114 == 0) goto L62;
        return r114;
    L62:
        int r115 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(r100.h()));
        if (r115 == 0) goto L66;
        return r115;
    L66:
        if (h() == false) goto L70;
        int r116 = hq.a(this.f846f, r100.f846f);
        if (r116 == 0) goto L70;
        return r116;
    L70:
        int r117 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(r100.i()));
        if (r117 == 0) goto L74;
        return r117;
    L74:
        if (i() == false) goto L78;
        int r118 = hq.a(this.f847g, r100.f847g);
        if (r118 == 0) goto L78;
        return r118;
    L78:
        int r119 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(r100.j()));
        if (r119 == 0) goto L82;
        return r119;
    L82:
        if (j() == false) goto L86;
        int r120 = hq.a(this.f840b, r100.f840b);
        if (r120 == 0) goto L86;
        return r120;
    L86:
        int r121 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(r100.k()));
        if (r121 == 0) goto L90;
        return r121;
    L90:
        if (k() == false) goto L94;
        int r122 = hq.a(this.f848h, r100.f848h);
        if (r122 == 0) goto L94;
        return r122;
    L94:
        int r123 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(r100.l()));
        if (r123 == 0) goto L98;
        return r123;
    L98:
        if (l() == false) goto L102;
        int r124 = hq.a(this.f849i, r100.f849i);
        if (r124 == 0) goto L102;
        return r124;
    L102:
        int r125 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(r100.m()));
        if (r125 == 0) goto L106;
        return r125;
    L106:
        if (m() == false) goto L110;
        int r126 = hq.a(this.f842c, r100.f842c);
        if (r126 == 0) goto L110;
        return r126;
    L110:
        int r127 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(r100.n()));
        if (r127 == 0) goto L114;
        return r127;
    L114:
        if (n() == false) goto L118;
        int r128 = hq.a(this.f850j, r100.f850j);
        if (r128 == 0) goto L118;
        return r128;
    L118:
        int r129 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(r100.o()));
        if (r129 == 0) goto L122;
        return r129;
    L122:
        if (o() == false) goto L126;
        int r130 = hq.a(this.f832a, r100.f832a);
        if (r130 == 0) goto L126;
        return r130;
    L126:
        int r131 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(r100.p()));
        if (r131 == 0) goto L130;
        return r131;
    L130:
        if (p() == false) goto L134;
        int r132 = hq.a(this.f851k, r100.f851k);
        if (r132 == 0) goto L134;
        return r132;
    L134:
        int r133 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(r100.q()));
        if (r133 == 0) goto L138;
        return r133;
    L138:
        if (q() == false) goto L142;
        int r134 = hq.a(this.f839b, r100.f839b);
        if (r134 == 0) goto L142;
        return r134;
    L142:
        int r135 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(r100.r()));
        if (r135 == 0) goto L146;
        return r135;
    L146:
        if (r() == false) goto L150;
        int r136 = hq.a(this.f852l, r100.f852l);
        if (r136 == 0) goto L150;
        return r136;
    L150:
        int r137 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(r100.s()));
        if (r137 == 0) goto L154;
        return r137;
    L154:
        if (s() == false) goto L158;
        int r138 = hq.a(this.f838a, r100.f838a);
        if (r138 == 0) goto L158;
        return r138;
    L158:
        int r139 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(r100.t()));
        if (r139 == 0) goto L162;
        return r139;
    L162:
        if (t() == false) goto L166;
        int r140 = hq.a(this.f837a, r100.f837a);
        if (r140 == 0) goto L168;
        return r140;
    L168:
        return 0;
    L166:
        return 0;
    L5:
        return getClass().getName().compareTo(r100.getClass().getName());
    }

    @Override // com.xiaomi.push.hp
    public void b(hz r100) {
        m9229a();
        r100.a(f831a);
        if (this.f835a == null) goto L8;
        if (m9230a() == false) goto L8;
        r100.a(f463988a);
        r100.a(this.f835a);
        r100.b();
    L8:
        if (this.f834a == null) goto L13;
        if (m9232b() == false) goto L13;
        r100.a(f463989b);
        this.f834a.b(r100);
        r100.b();
    L13:
        if (this.f841b == null) goto L16;
        r100.a(f463990c);
        r100.a(this.f841b);
        r100.b();
    L16:
        if (this.f843c == null) goto L18;
        r100.a(f463991d);
        r100.a(this.f843c);
        r100.b();
    L18:
        r100.a(f463992e);
        r100.a(this.f833a);
        r100.b();
        if (this.f844d == null) goto L24;
        if (f() == false) goto L24;
        r100.a(f463993f);
        r100.a(this.f844d);
        r100.b();
    L24:
        if (this.f845e == null) goto L29;
        if (g() == false) goto L29;
        r100.a(f463994g);
        r100.a(this.f845e);
        r100.b();
    L29:
        if (this.f846f == null) goto L34;
        if (h() == false) goto L34;
        r100.a(f463995h);
        r100.a(this.f846f);
        r100.b();
    L34:
        if (this.f847g == null) goto L39;
        if (i() == false) goto L39;
        r100.a(f463996i);
        r100.a(this.f847g);
        r100.b();
    L39:
        if (j() == false) goto L42;
        r100.a(f463997j);
        r100.a(this.f840b);
        r100.b();
    L42:
        if (this.f848h == null) goto L47;
        if (k() == false) goto L47;
        r100.a(f463998k);
        r100.a(this.f848h);
        r100.b();
    L47:
        if (this.f849i == null) goto L52;
        if (l() == false) goto L52;
        r100.a(f463999l);
        r100.a(this.f849i);
        r100.b();
    L52:
        if (m() == false) goto L55;
        r100.a(f464000m);
        r100.a(this.f842c);
        r100.b();
    L55:
        if (this.f850j == null) goto L60;
        if (n() == false) goto L60;
        r100.a(f464001n);
        r100.a(this.f850j);
        r100.b();
    L60:
        if (o() == false) goto L63;
        r100.a(f464002o);
        r100.mo9280a(this.f832a);
        r100.b();
    L63:
        if (this.f851k == null) goto L68;
        if (p() == false) goto L68;
        r100.a(f464003p);
        r100.a(this.f851k);
        r100.b();
    L68:
        if (q() == false) goto L71;
        r100.a(f464004q);
        r100.mo9280a(this.f839b);
        r100.b();
    L71:
        if (this.f852l == null) goto L76;
        if (r() == false) goto L76;
        r100.a(f464005r);
        r100.a(this.f852l);
        r100.b();
    L76:
        if (s() == false) goto L79;
        r100.a(f464006s);
        r100.a(this.f838a);
        r100.b();
    L79:
        if (this.f837a != null) goto L81;
    L87:
        r100.c();
        r100.mo9279a();
        return;
    L81:
        if (t() == false) goto L87;
        r100.a(f464007t);
        r100.a(new hx((byte) 11, this.f837a.size()));
        Iterator<String> r101 = this.f837a.iterator();
    L84:
        if (r101.hasNext() == false) goto L86;
        r100.a(r101.next());
        goto L84
    L86:
        r100.e();
        r100.b();
        goto L87
    }

    public void c(boolean r100) {
        this.f836a.set(2, r100);
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(Object r100) {
        return a((hf) r100);
    }

    public void d(boolean r100) {
        this.f836a.set(3, r100);
    }

    public void e(boolean r100) {
        this.f836a.set(4, r100);
    }

    public boolean equals(Object r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if ((r100 instanceof hf) == true) goto L8;
        return false;
    L8:
        return m9231a((hf) r100);
    }

    public void f(boolean r100) {
        this.f836a.set(5, r100);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m9231a(hf r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        boolean r101 = m9230a();
        boolean r102 = r100.m9230a();
        if (r101 == true) goto L8;
        if (r102 == true) goto L8;
    L14:
        boolean r103 = m9232b();
        boolean r104 = r100.m9232b();
        if (r103 == true) goto L17;
        if (r104 == true) goto L17;
    L23:
        boolean r105 = m9233c();
        boolean r106 = r100.m9233c();
        if (r105 == true) goto L26;
        if (r106 == true) goto L26;
    L32:
        boolean r107 = d();
        boolean r108 = r100.d();
        if (r107 == true) goto L35;
        if (r108 == true) goto L35;
    L42:
        if (this.f833a == r100.f833a) goto L44;
        return false;
    L44:
        boolean r109 = f();
        boolean r110 = r100.f();
        if (r109 == true) goto L47;
        if (r110 == true) goto L47;
    L53:
        boolean r111 = g();
        boolean r112 = r100.g();
        if (r111 == true) goto L56;
        if (r112 == true) goto L56;
    L62:
        boolean r113 = h();
        boolean r114 = r100.h();
        if (r113 == true) goto L65;
        if (r114 == true) goto L65;
    L71:
        boolean r115 = i();
        boolean r116 = r100.i();
        if (r115 == true) goto L74;
        if (r116 == true) goto L74;
    L80:
        boolean r117 = j();
        boolean r118 = r100.j();
        if (r117 == true) goto L83;
        if (r118 == true) goto L83;
    L89:
        boolean r119 = k();
        boolean r120 = r100.k();
        if (r119 == true) goto L92;
        if (r120 == true) goto L92;
    L98:
        boolean r121 = l();
        boolean r122 = r100.l();
        if (r121 == true) goto L101;
        if (r122 == true) goto L101;
    L107:
        boolean r123 = m();
        boolean r124 = r100.m();
        if (r123 == true) goto L110;
        if (r124 == true) goto L110;
    L116:
        boolean r125 = n();
        boolean r126 = r100.n();
        if (r125 == true) goto L119;
        if (r126 == true) goto L119;
    L125:
        boolean r127 = o();
        boolean r128 = r100.o();
        if (r127 == true) goto L128;
        if (r128 == true) goto L128;
    L134:
        boolean r129 = p();
        boolean r130 = r100.p();
        if (r129 == true) goto L137;
        if (r130 == true) goto L137;
    L143:
        boolean r131 = q();
        boolean r132 = r100.q();
        if (r131 == true) goto L146;
        if (r132 == true) goto L146;
    L152:
        boolean r133 = r();
        boolean r134 = r100.r();
        if (r133 == true) goto L155;
        if (r134 == true) goto L155;
    L161:
        boolean r135 = s();
        boolean r136 = r100.s();
        if (r135 == true) goto L164;
        if (r136 == true) goto L164;
    L170:
        boolean r137 = t();
        boolean r138 = r100.t();
        if (r137 == true) goto L173;
        if (r138 == true) goto L173;
        return true;
    L173:
        if (r137 == false) goto L181;
        if (r138 == false) goto L181;
        if (this.f837a.equals(r100.f837a) == true) goto L182;
        return false;
    L182:
        return true;
    L181:
        return false;
    L164:
        if (r135 == false) goto L181;
        if (r136 == false) goto L181;
        if (this.f838a == r100.f838a) goto L170;
        return false;
    L155:
        if (r133 == false) goto L181;
        if (r134 == false) goto L181;
        if (this.f852l.equals(r100.f852l) == true) goto L161;
        return false;
    L146:
        if (r131 == false) goto L181;
        if (r132 == false) goto L181;
        if (this.f839b == r100.f839b) goto L152;
        return false;
    L137:
        if (r129 == false) goto L181;
        if (r130 == false) goto L181;
        if (this.f851k.equals(r100.f851k) == true) goto L143;
        return false;
    L128:
        if (r127 == false) goto L181;
        if (r128 == false) goto L181;
        if (this.f832a == r100.f832a) goto L134;
        return false;
    L119:
        if (r125 == false) goto L181;
        if (r126 == false) goto L181;
        if (this.f850j.equals(r100.f850j) == true) goto L125;
        return false;
    L110:
        if (r123 == false) goto L181;
        if (r124 == false) goto L181;
        if (this.f842c == r100.f842c) goto L116;
        return false;
    L101:
        if (r121 == false) goto L181;
        if (r122 == false) goto L181;
        if (this.f849i.equals(r100.f849i) == true) goto L107;
        return false;
    L92:
        if (r119 == false) goto L181;
        if (r120 == false) goto L181;
        if (this.f848h.equals(r100.f848h) == true) goto L98;
        return false;
    L83:
        if (r117 == false) goto L181;
        if (r118 == false) goto L181;
        if (this.f840b == r100.f840b) goto L89;
        return false;
    L74:
        if (r115 == false) goto L181;
        if (r116 == false) goto L181;
        if (this.f847g.equals(r100.f847g) == true) goto L80;
        return false;
    L65:
        if (r113 == false) goto L181;
        if (r114 == false) goto L181;
        if (this.f846f.equals(r100.f846f) == true) goto L71;
        return false;
    L56:
        if (r111 == false) goto L181;
        if (r112 == false) goto L181;
        if (this.f845e.equals(r100.f845e) == true) goto L62;
        return false;
    L47:
        if (r109 == false) goto L181;
        if (r110 == false) goto L181;
        if (this.f844d.equals(r100.f844d) == true) goto L53;
        return false;
    L35:
        if (r107 == false) goto L181;
        if (r108 == false) goto L181;
        if (this.f843c.equals(r100.f843c) == true) goto L42;
        return false;
    L26:
        if (r105 == false) goto L181;
        if (r106 == false) goto L181;
        if (this.f841b.equals(r100.f841b) == true) goto L32;
        return false;
    L17:
        if (r103 == false) goto L181;
        if (r104 == false) goto L181;
        if (this.f834a.m9175a(r100.f834a) == true) goto L23;
        return false;
    L8:
        if (r101 == false) goto L181;
        if (r102 == false) goto L181;
        if (this.f835a.equals(r100.f835a) == true) goto L14;
        return false;
    }

    public void b(boolean r100) {
        this.f836a.set(1, r100);
    }

    @Override // com.xiaomi.push.hp
    public void a(hz r100) {
        r100.mo9275a();
    L3:
        hw r101 = r100.mo9271a();
        byte r102 = r101.f464095a;
        if (r102 == 0) goto L5;
        switch(r101.f951a) {
            case 1: goto L78;
            case 2: goto L75;
            case 3: goto L71;
            case 4: goto L68;
            case 5: goto L13;
            case 6: goto L65;
            case 7: goto L62;
            case 8: goto L59;
            case 9: goto L56;
            case 10: goto L53;
            case 11: goto L50;
            case 12: goto L47;
            case 13: goto L44;
            case 14: goto L41;
            case 15: goto L38;
            case 16: goto L35;
            case 17: goto L32;
            case 18: goto L29;
            case 19: goto L26;
            case 20: goto L23;
            case 21: goto L15;
            default: goto L13;
        };
    L13:
        ic.a(r100, r102);
    L81:
        r100.g();
        goto L3
    L26:
        if (r102 != 11) goto L28;
        this.f852l = r100.mo9276a();
        goto L81
    L28:
        ic.a(r100, r102);
        goto L81
    L29:
        if (r102 != 8) goto L31;
        this.f839b = r100.mo9269a();
        e(true);
        goto L81
    L31:
        ic.a(r100, r102);
        goto L81
    L32:
        if (r102 != 11) goto L34;
        this.f851k = r100.mo9276a();
        goto L81
    L34:
        ic.a(r100, r102);
        goto L81
    L35:
        if (r102 != 8) goto L37;
        this.f832a = r100.mo9269a();
        d(true);
        goto L81
    L37:
        ic.a(r100, r102);
        goto L81
    L38:
        if (r102 != 11) goto L40;
        this.f850j = r100.mo9276a();
        goto L81
    L40:
        ic.a(r100, r102);
        goto L81
    L41:
        if (r102 != 10) goto L43;
        this.f842c = r100.mo9270a();
        c(true);
        goto L81
    L43:
        ic.a(r100, r102);
        goto L81
    L44:
        if (r102 != 11) goto L46;
        this.f849i = r100.mo9276a();
        goto L81
    L46:
        ic.a(r100, r102);
        goto L81
    L47:
        if (r102 != 11) goto L49;
        this.f848h = r100.mo9276a();
        goto L81
    L49:
        ic.a(r100, r102);
        goto L81
    L50:
        if (r102 != 10) goto L52;
        this.f840b = r100.mo9270a();
        b(true);
        goto L81
    L52:
        ic.a(r100, r102);
        goto L81
    L53:
        if (r102 != 11) goto L55;
        this.f847g = r100.mo9276a();
        goto L81
    L55:
        ic.a(r100, r102);
        goto L81
    L56:
        if (r102 != 11) goto L58;
        this.f846f = r100.mo9276a();
        goto L81
    L58:
        ic.a(r100, r102);
        goto L81
    L59:
        if (r102 != 11) goto L61;
        this.f845e = r100.mo9276a();
        goto L81
    L61:
        ic.a(r100, r102);
        goto L81
    L62:
        if (r102 != 11) goto L64;
        this.f844d = r100.mo9276a();
        goto L81
    L64:
        ic.a(r100, r102);
        goto L81
    L65:
        if (r102 != 10) goto L67;
        this.f833a = r100.mo9270a();
        a(true);
        goto L81
    L67:
        ic.a(r100, r102);
        goto L81
    L68:
        if (r102 != 11) goto L70;
        this.f843c = r100.mo9276a();
        goto L81
    L70:
        ic.a(r100, r102);
        goto L81
    L71:
        if (r102 != 11) goto L73;
        this.f841b = r100.mo9276a();
        goto L81
    L73:
        ic.a(r100, r102);
        goto L81
    L78:
        if (r102 != 11) goto L80;
        this.f835a = r100.mo9276a();
        goto L81
    L80:
        ic.a(r100, r102);
        goto L81
    L15:
        if (r102 != 15) goto L21;
        hx r103 = r100.mo9272a();
        this.f837a = new ArrayList(r103.f952a);
        int r104 = 0;
    L18:
        if (r104 >= r103.f952a) goto L20;
        this.f837a.add(r100.mo9276a());
        r104 = r104 + 1;
        goto L18
    L20:
        r100.i();
        goto L81
    L21:
        ic.a(r100, r102);
        goto L81
    L23:
        if (r102 != 2) goto L25;
        this.f838a = r100.mo9281a();
        f(true);
        goto L81
    L25:
        ic.a(r100, r102);
        goto L81
    L75:
        if (r102 != 12) goto L77;
        gt r105 = new gt();
        this.f834a = r105;
        r105.a(r100);
        goto L81
    L77:
        ic.a(r100, r102);
        goto L81
    L5:
        r100.f();
        if (e() == false) goto L10;
        m9229a();
        return;
    L10:
        throw new ia("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
    }

    public void a(boolean r100) {
        this.f836a.set(0, r100);
    }
}
