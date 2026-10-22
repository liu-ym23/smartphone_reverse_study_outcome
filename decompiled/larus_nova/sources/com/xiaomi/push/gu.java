package com.xiaomi.push;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes41.dex */
public class gu implements hp<gu, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final hw f463883a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final ie f705a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final hw f463884b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final hw f463885c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final hw f463886d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final hw f463887e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final hw f463888f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final hw f463889g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final hw f463890h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final hw f463891i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final hw f463892j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final hw f463893k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final hw f463894l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final hw f463895m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final hw f463896n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final hw f463897o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final hw f463898p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final hw f463899q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final hw f463900r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final hw f463901s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final hw f463902t = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f706a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f707a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public gt f708a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public hh f709a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f710a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private BitSet f711a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Map<String, String> f712a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public short f713a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f714a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f715b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public short f716b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public String f717c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public String f718d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public String f719e;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public String f720f;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public String f721g;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    public String f722h;

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    public String f723i;

    /* JADX INFO: renamed from: j, reason: collision with other field name */
    public String f724j;

    /* JADX INFO: renamed from: k, reason: collision with other field name */
    public String f725k;

    /* JADX INFO: renamed from: l, reason: collision with other field name */
    public String f726l;

    public int hashCode() {
        return 0;
    }

    static {
        f705a = new ie("XmPushActionAckMessage");
        f463883a = new hw("", (byte) 11, 1);
        f463884b = new hw("", (byte) 12, 2);
        f463885c = new hw("", (byte) 11, 3);
        f463886d = new hw("", (byte) 11, 4);
        f463887e = new hw("", (byte) 10, 5);
        f463888f = new hw("", (byte) 11, 6);
        f463889g = new hw("", (byte) 11, 7);
        f463890h = new hw("", (byte) 12, 8);
        f463891i = new hw("", (byte) 11, 9);
        f463892j = new hw("", (byte) 11, 10);
        f463893k = new hw("", (byte) 2, 11);
        f463894l = new hw("", (byte) 11, 12);
        f463895m = new hw("", (byte) 11, 13);
        f463896n = new hw("", (byte) 11, 14);
        f463897o = new hw("", (byte) 6, 15);
        f463898p = new hw("", (byte) 6, 16);
        f463899q = new hw("", (byte) 11, 20);
        f463900r = new hw("", (byte) 11, 21);
        f463901s = new hw("", (byte) 8, 22);
        f463902t = new hw("", HTTP.CR, 23);
    }

    public void a() {
        if (this.f715b == null) goto L10;
        if (this.f717c == null) goto L8;
        return;
    L8:
        throw new ia("Required field 'appId' was not present! Struct: " + toString());
    L10:
        throw new ia("Required field 'id' was not present! Struct: " + toString());
    }

    public boolean b() {
        if (this.f708a == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean c() {
        if (this.f715b == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean d() {
        if (this.f717c == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean e() {
        return this.f711a.get(0);
    }

    public boolean f() {
        if (this.f718d == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean g() {
        if (this.f719e == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean h() {
        if (this.f709a == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean i() {
        if (this.f720f == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean j() {
        if (this.f721g == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean k() {
        return this.f711a.get(1);
    }

    public boolean l() {
        if (this.f722h == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean m() {
        if (this.f723i == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean n() {
        if (this.f724j == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean o() {
        return this.f711a.get(2);
    }

    public boolean p() {
        return this.f711a.get(3);
    }

    public boolean q() {
        if (this.f725k == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean r() {
        if (this.f726l == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean s() {
        return this.f711a.get(4);
    }

    public boolean t() {
        if (this.f712a == null) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("XmPushActionAckMessage(");
        boolean r101 = false;
        if (m9176a() == false) goto L9;
        r100.append("debug:");
        String r102 = this.f710a;
        if (r102 != null) goto L7;
        r100.append("null");
    L8:
        boolean r103 = false;
    L11:
        if (b() == false) goto L18;
        if (r103 == true) goto L14;
        r100.append(", ");
    L14:
        r100.append("target:");
        gt r104 = this.f708a;
        if (r104 != null) goto L17;
        r100.append("null");
    L19:
        if (r101 == true) goto L21;
        r100.append(", ");
    L21:
        r100.append("id:");
        String r105 = this.f715b;
        if (r105 != null) goto L24;
        r100.append("null");
    L25:
        r100.append(", ");
        r100.append("appId:");
        String r106 = this.f717c;
        if (r106 != null) goto L28;
        r100.append("null");
    L29:
        r100.append(", ");
        r100.append("messageTs:");
        r100.append(this.f707a);
        if (f() == false) goto L36;
        r100.append(", ");
        r100.append("topic:");
        String r107 = this.f718d;
        if (r107 != null) goto L34;
        r100.append("null");
        goto L36
    L34:
        r100.append(r107);
    L36:
        if (g() == false) goto L42;
        r100.append(", ");
        r100.append("aliasName:");
        String r108 = this.f719e;
        if (r108 != null) goto L40;
        r100.append("null");
        goto L42
    L40:
        r100.append(r108);
    L42:
        if (h() == false) goto L48;
        r100.append(", ");
        r100.append("request:");
        hh r109 = this.f709a;
        if (r109 != null) goto L46;
        r100.append("null");
        goto L48
    L46:
        r100.append(r109);
    L48:
        if (i() == false) goto L54;
        r100.append(", ");
        r100.append("packageName:");
        String r110 = this.f720f;
        if (r110 != null) goto L52;
        r100.append("null");
        goto L54
    L52:
        r100.append(r110);
    L54:
        if (j() == false) goto L60;
        r100.append(", ");
        r100.append("category:");
        String r111 = this.f721g;
        if (r111 != null) goto L58;
        r100.append("null");
        goto L60
    L58:
        r100.append(r111);
    L60:
        if (k() == false) goto L63;
        r100.append(", ");
        r100.append("isOnline:");
        r100.append(this.f714a);
    L63:
        if (l() == false) goto L69;
        r100.append(", ");
        r100.append("regId:");
        String r112 = this.f722h;
        if (r112 != null) goto L67;
        r100.append("null");
        goto L69
    L67:
        r100.append(r112);
    L69:
        if (m() == false) goto L75;
        r100.append(", ");
        r100.append("callbackUrl:");
        String r113 = this.f723i;
        if (r113 != null) goto L73;
        r100.append("null");
        goto L75
    L73:
        r100.append(r113);
    L75:
        if (n() == false) goto L81;
        r100.append(", ");
        r100.append("userAccount:");
        String r114 = this.f724j;
        if (r114 != null) goto L79;
        r100.append("null");
        goto L81
    L79:
        r100.append(r114);
    L81:
        if (o() == false) goto L84;
        r100.append(", ");
        r100.append("deviceStatus:");
        r100.append(this.f713a);
    L84:
        if (p() == false) goto L87;
        r100.append(", ");
        r100.append("geoMsgStatus:");
        r100.append(this.f716b);
    L87:
        if (q() == false) goto L93;
        r100.append(", ");
        r100.append("imeiMd5:");
        String r115 = this.f725k;
        if (r115 != null) goto L91;
        r100.append("null");
        goto L93
    L91:
        r100.append(r115);
    L93:
        if (r() == false) goto L99;
        r100.append(", ");
        r100.append("deviceId:");
        String r116 = this.f726l;
        if (r116 != null) goto L97;
        r100.append("null");
        goto L99
    L97:
        r100.append(r116);
    L99:
        if (s() == false) goto L102;
        r100.append(", ");
        r100.append("passThrough:");
        r100.append(this.f706a);
    L102:
        if (t() == false) goto L107;
        r100.append(", ");
        r100.append("extra:");
        Map<String, String> r117 = this.f712a;
        if (r117 != null) goto L106;
        r100.append("null");
        goto L107
    L106:
        r100.append(r117);
    L107:
        r100.append(")");
        return r100.toString();
    L28:
        r100.append(r106);
        goto L29
    L24:
        r100.append(r105);
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

    public gu() {
        this.f711a = new BitSet(5);
        this.f714a = false;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m9176a() {
        if (this.f710a == null) goto L5;
        return true;
    L5:
        return false;
    }

    public int a(gu r100) {
        if (getClass().equals(r100.getClass()) == false) goto L5;
        int r101 = Boolean.valueOf(m9176a()).compareTo(Boolean.valueOf(r100.m9176a()));
        if (r101 == 0) goto L10;
        return r101;
    L10:
        if (m9176a() == false) goto L14;
        int r102 = hq.a(this.f710a, r100.f710a);
        if (r102 == 0) goto L14;
        return r102;
    L14:
        int r103 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(r100.b()));
        if (r103 == 0) goto L18;
        return r103;
    L18:
        if (b() == false) goto L22;
        int r104 = hq.a(this.f708a, r100.f708a);
        if (r104 == 0) goto L22;
        return r104;
    L22:
        int r105 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(r100.c()));
        if (r105 == 0) goto L26;
        return r105;
    L26:
        if (c() == false) goto L30;
        int r106 = hq.a(this.f715b, r100.f715b);
        if (r106 == 0) goto L30;
        return r106;
    L30:
        int r107 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(r100.d()));
        if (r107 == 0) goto L34;
        return r107;
    L34:
        if (d() == false) goto L38;
        int r108 = hq.a(this.f717c, r100.f717c);
        if (r108 == 0) goto L38;
        return r108;
    L38:
        int r109 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(r100.e()));
        if (r109 == 0) goto L42;
        return r109;
    L42:
        if (e() == false) goto L46;
        int r110 = hq.a(this.f707a, r100.f707a);
        if (r110 == 0) goto L46;
        return r110;
    L46:
        int r111 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(r100.f()));
        if (r111 == 0) goto L50;
        return r111;
    L50:
        if (f() == false) goto L54;
        int r112 = hq.a(this.f718d, r100.f718d);
        if (r112 == 0) goto L54;
        return r112;
    L54:
        int r113 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(r100.g()));
        if (r113 == 0) goto L58;
        return r113;
    L58:
        if (g() == false) goto L62;
        int r114 = hq.a(this.f719e, r100.f719e);
        if (r114 == 0) goto L62;
        return r114;
    L62:
        int r115 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(r100.h()));
        if (r115 == 0) goto L66;
        return r115;
    L66:
        if (h() == false) goto L70;
        int r116 = hq.a(this.f709a, r100.f709a);
        if (r116 == 0) goto L70;
        return r116;
    L70:
        int r117 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(r100.i()));
        if (r117 == 0) goto L74;
        return r117;
    L74:
        if (i() == false) goto L78;
        int r118 = hq.a(this.f720f, r100.f720f);
        if (r118 == 0) goto L78;
        return r118;
    L78:
        int r119 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(r100.j()));
        if (r119 == 0) goto L82;
        return r119;
    L82:
        if (j() == false) goto L86;
        int r120 = hq.a(this.f721g, r100.f721g);
        if (r120 == 0) goto L86;
        return r120;
    L86:
        int r121 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(r100.k()));
        if (r121 == 0) goto L90;
        return r121;
    L90:
        if (k() == false) goto L94;
        int r122 = hq.a(this.f714a, r100.f714a);
        if (r122 == 0) goto L94;
        return r122;
    L94:
        int r123 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(r100.l()));
        if (r123 == 0) goto L98;
        return r123;
    L98:
        if (l() == false) goto L102;
        int r124 = hq.a(this.f722h, r100.f722h);
        if (r124 == 0) goto L102;
        return r124;
    L102:
        int r125 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(r100.m()));
        if (r125 == 0) goto L106;
        return r125;
    L106:
        if (m() == false) goto L110;
        int r126 = hq.a(this.f723i, r100.f723i);
        if (r126 == 0) goto L110;
        return r126;
    L110:
        int r127 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(r100.n()));
        if (r127 == 0) goto L114;
        return r127;
    L114:
        if (n() == false) goto L118;
        int r128 = hq.a(this.f724j, r100.f724j);
        if (r128 == 0) goto L118;
        return r128;
    L118:
        int r129 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(r100.o()));
        if (r129 == 0) goto L122;
        return r129;
    L122:
        if (o() == false) goto L126;
        int r130 = hq.a(this.f713a, r100.f713a);
        if (r130 == 0) goto L126;
        return r130;
    L126:
        int r131 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(r100.p()));
        if (r131 == 0) goto L130;
        return r131;
    L130:
        if (p() == false) goto L134;
        int r132 = hq.a(this.f716b, r100.f716b);
        if (r132 == 0) goto L134;
        return r132;
    L134:
        int r133 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(r100.q()));
        if (r133 == 0) goto L138;
        return r133;
    L138:
        if (q() == false) goto L142;
        int r134 = hq.a(this.f725k, r100.f725k);
        if (r134 == 0) goto L142;
        return r134;
    L142:
        int r135 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(r100.r()));
        if (r135 == 0) goto L146;
        return r135;
    L146:
        if (r() == false) goto L150;
        int r136 = hq.a(this.f726l, r100.f726l);
        if (r136 == 0) goto L150;
        return r136;
    L150:
        int r137 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(r100.s()));
        if (r137 == 0) goto L154;
        return r137;
    L154:
        if (s() == false) goto L158;
        int r138 = hq.a(this.f706a, r100.f706a);
        if (r138 == 0) goto L158;
        return r138;
    L158:
        int r139 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(r100.t()));
        if (r139 == 0) goto L162;
        return r139;
    L162:
        if (t() == false) goto L166;
        int r140 = hq.a(this.f712a, r100.f712a);
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
        a();
        r100.a(f705a);
        if (this.f710a == null) goto L8;
        if (m9176a() == false) goto L8;
        r100.a(f463883a);
        r100.a(this.f710a);
        r100.b();
    L8:
        if (this.f708a == null) goto L13;
        if (b() == false) goto L13;
        r100.a(f463884b);
        this.f708a.b(r100);
        r100.b();
    L13:
        if (this.f715b == null) goto L16;
        r100.a(f463885c);
        r100.a(this.f715b);
        r100.b();
    L16:
        if (this.f717c == null) goto L18;
        r100.a(f463886d);
        r100.a(this.f717c);
        r100.b();
    L18:
        r100.a(f463887e);
        r100.a(this.f707a);
        r100.b();
        if (this.f718d == null) goto L24;
        if (f() == false) goto L24;
        r100.a(f463888f);
        r100.a(this.f718d);
        r100.b();
    L24:
        if (this.f719e == null) goto L29;
        if (g() == false) goto L29;
        r100.a(f463889g);
        r100.a(this.f719e);
        r100.b();
    L29:
        if (this.f709a == null) goto L34;
        if (h() == false) goto L34;
        r100.a(f463890h);
        this.f709a.b(r100);
        r100.b();
    L34:
        if (this.f720f == null) goto L39;
        if (i() == false) goto L39;
        r100.a(f463891i);
        r100.a(this.f720f);
        r100.b();
    L39:
        if (this.f721g == null) goto L44;
        if (j() == false) goto L44;
        r100.a(f463892j);
        r100.a(this.f721g);
        r100.b();
    L44:
        if (k() == false) goto L47;
        r100.a(f463893k);
        r100.a(this.f714a);
        r100.b();
    L47:
        if (this.f722h == null) goto L52;
        if (l() == false) goto L52;
        r100.a(f463894l);
        r100.a(this.f722h);
        r100.b();
    L52:
        if (this.f723i == null) goto L57;
        if (m() == false) goto L57;
        r100.a(f463895m);
        r100.a(this.f723i);
        r100.b();
    L57:
        if (this.f724j == null) goto L62;
        if (n() == false) goto L62;
        r100.a(f463896n);
        r100.a(this.f724j);
        r100.b();
    L62:
        if (o() == false) goto L65;
        r100.a(f463897o);
        r100.a(this.f713a);
        r100.b();
    L65:
        if (p() == false) goto L68;
        r100.a(f463898p);
        r100.a(this.f716b);
        r100.b();
    L68:
        if (this.f725k == null) goto L73;
        if (q() == false) goto L73;
        r100.a(f463899q);
        r100.a(this.f725k);
        r100.b();
    L73:
        if (this.f726l == null) goto L78;
        if (r() == false) goto L78;
        r100.a(f463900r);
        r100.a(this.f726l);
        r100.b();
    L78:
        if (s() == false) goto L81;
        r100.a(f463901s);
        r100.mo9280a(this.f706a);
        r100.b();
    L81:
        if (this.f712a != null) goto L83;
    L89:
        r100.c();
        r100.mo9279a();
        return;
    L83:
        if (t() == false) goto L89;
        r100.a(f463902t);
        r100.a(new hy((byte) 11, (byte) 11, this.f712a.size()));
        Iterator<Map.Entry<String, String>> r101 = this.f712a.entrySet().iterator();
    L86:
        if (r101.hasNext() == false) goto L88;
        Map.Entry<String, String> r102 = r101.next();
        r100.a(r102.getKey());
        r100.a(r102.getValue());
        goto L86
    L88:
        r100.d();
        r100.b();
        goto L89
    }

    public void c(boolean r100) {
        this.f711a.set(2, r100);
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(Object r100) {
        return a((gu) r100);
    }

    public void d(boolean r100) {
        this.f711a.set(3, r100);
    }

    public void e(boolean r100) {
        this.f711a.set(4, r100);
    }

    public boolean equals(Object r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if ((r100 instanceof gu) == true) goto L8;
        return false;
    L8:
        return m9177a((gu) r100);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m9177a(gu r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        boolean r101 = m9176a();
        boolean r102 = r100.m9176a();
        if (r101 == true) goto L8;
        if (r102 == true) goto L8;
    L14:
        boolean r103 = b();
        boolean r104 = r100.b();
        if (r103 == true) goto L17;
        if (r104 == true) goto L17;
    L23:
        boolean r105 = c();
        boolean r106 = r100.c();
        if (r105 == true) goto L26;
        if (r106 == true) goto L26;
    L32:
        boolean r107 = d();
        boolean r108 = r100.d();
        if (r107 == true) goto L35;
        if (r108 == true) goto L35;
    L42:
        if (this.f707a == r100.f707a) goto L44;
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
        if (this.f712a.equals(r100.f712a) == true) goto L182;
        return false;
    L182:
        return true;
    L181:
        return false;
    L164:
        if (r135 == false) goto L181;
        if (r136 == false) goto L181;
        if (this.f706a == r100.f706a) goto L170;
        return false;
    L155:
        if (r133 == false) goto L181;
        if (r134 == false) goto L181;
        if (this.f726l.equals(r100.f726l) == true) goto L161;
        return false;
    L146:
        if (r131 == false) goto L181;
        if (r132 == false) goto L181;
        if (this.f725k.equals(r100.f725k) == true) goto L152;
        return false;
    L137:
        if (r129 == false) goto L181;
        if (r130 == false) goto L181;
        if (this.f716b == r100.f716b) goto L143;
        return false;
    L128:
        if (r127 == false) goto L181;
        if (r128 == false) goto L181;
        if (this.f713a == r100.f713a) goto L134;
        return false;
    L119:
        if (r125 == false) goto L181;
        if (r126 == false) goto L181;
        if (this.f724j.equals(r100.f724j) == true) goto L125;
        return false;
    L110:
        if (r123 == false) goto L181;
        if (r124 == false) goto L181;
        if (this.f723i.equals(r100.f723i) == true) goto L116;
        return false;
    L101:
        if (r121 == false) goto L181;
        if (r122 == false) goto L181;
        if (this.f722h.equals(r100.f722h) == true) goto L107;
        return false;
    L92:
        if (r119 == false) goto L181;
        if (r120 == false) goto L181;
        if (this.f714a == r100.f714a) goto L98;
        return false;
    L83:
        if (r117 == false) goto L181;
        if (r118 == false) goto L181;
        if (this.f721g.equals(r100.f721g) == true) goto L89;
        return false;
    L74:
        if (r115 == false) goto L181;
        if (r116 == false) goto L181;
        if (this.f720f.equals(r100.f720f) == true) goto L80;
        return false;
    L65:
        if (r113 == false) goto L181;
        if (r114 == false) goto L181;
        if (this.f709a.m9239a(r100.f709a) == true) goto L71;
        return false;
    L56:
        if (r111 == false) goto L181;
        if (r112 == false) goto L181;
        if (this.f719e.equals(r100.f719e) == true) goto L62;
        return false;
    L47:
        if (r109 == false) goto L181;
        if (r110 == false) goto L181;
        if (this.f718d.equals(r100.f718d) == true) goto L53;
        return false;
    L35:
        if (r107 == false) goto L181;
        if (r108 == false) goto L181;
        if (this.f717c.equals(r100.f717c) == true) goto L42;
        return false;
    L26:
        if (r105 == false) goto L181;
        if (r106 == false) goto L181;
        if (this.f715b.equals(r100.f715b) == true) goto L32;
        return false;
    L17:
        if (r103 == false) goto L181;
        if (r104 == false) goto L181;
        if (this.f708a.m9175a(r100.f708a) == true) goto L23;
        return false;
    L8:
        if (r101 == false) goto L181;
        if (r102 == false) goto L181;
        if (this.f710a.equals(r100.f710a) == true) goto L14;
        return false;
    }

    public void b(boolean r100) {
        this.f711a.set(1, r100);
    }

    public gu c(String r100) {
        this.f718d = r100;
        return this;
    }

    public gu d(String r100) {
        this.f719e = r100;
        return this;
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
            case 3: goto L72;
            case 4: goto L69;
            case 5: goto L66;
            case 6: goto L62;
            case 7: goto L59;
            case 8: goto L56;
            case 9: goto L53;
            case 10: goto L50;
            case 11: goto L47;
            case 12: goto L44;
            case 13: goto L41;
            case 14: goto L38;
            case 15: goto L35;
            case 16: goto L32;
            case 17: goto L13;
            case 18: goto L13;
            case 19: goto L13;
            case 20: goto L29;
            case 21: goto L26;
            case 22: goto L23;
            case 23: goto L15;
            default: goto L13;
        };
    L13:
        ic.a(r100, r102);
    L81:
        r100.g();
        goto L3
    L26:
        if (r102 != 11) goto L28;
        this.f726l = r100.mo9276a();
        goto L81
    L28:
        ic.a(r100, r102);
        goto L81
    L29:
        if (r102 != 11) goto L31;
        this.f725k = r100.mo9276a();
        goto L81
    L31:
        ic.a(r100, r102);
        goto L81
    L32:
        if (r102 != 6) goto L34;
        this.f716b = r100.mo9278a();
        d(true);
        goto L81
    L34:
        ic.a(r100, r102);
        goto L81
    L35:
        if (r102 != 6) goto L37;
        this.f713a = r100.mo9278a();
        c(true);
        goto L81
    L37:
        ic.a(r100, r102);
        goto L81
    L38:
        if (r102 != 11) goto L40;
        this.f724j = r100.mo9276a();
        goto L81
    L40:
        ic.a(r100, r102);
        goto L81
    L41:
        if (r102 != 11) goto L43;
        this.f723i = r100.mo9276a();
        goto L81
    L43:
        ic.a(r100, r102);
        goto L81
    L44:
        if (r102 != 11) goto L46;
        this.f722h = r100.mo9276a();
        goto L81
    L46:
        ic.a(r100, r102);
        goto L81
    L47:
        if (r102 != 2) goto L49;
        this.f714a = r100.mo9281a();
        b(true);
        goto L81
    L49:
        ic.a(r100, r102);
        goto L81
    L50:
        if (r102 != 11) goto L52;
        this.f721g = r100.mo9276a();
        goto L81
    L52:
        ic.a(r100, r102);
        goto L81
    L53:
        if (r102 != 11) goto L55;
        this.f720f = r100.mo9276a();
        goto L81
    L55:
        ic.a(r100, r102);
        goto L81
    L56:
        if (r102 != 12) goto L58;
        hh r103 = new hh();
        this.f709a = r103;
        r103.a(r100);
        goto L81
    L58:
        ic.a(r100, r102);
        goto L81
    L59:
        if (r102 != 11) goto L61;
        this.f719e = r100.mo9276a();
        goto L81
    L61:
        ic.a(r100, r102);
        goto L81
    L62:
        if (r102 != 11) goto L64;
        this.f718d = r100.mo9276a();
        goto L81
    L64:
        ic.a(r100, r102);
        goto L81
    L69:
        if (r102 != 11) goto L71;
        this.f717c = r100.mo9276a();
        goto L81
    L71:
        ic.a(r100, r102);
        goto L81
    L72:
        if (r102 != 11) goto L74;
        this.f715b = r100.mo9276a();
        goto L81
    L74:
        ic.a(r100, r102);
        goto L81
    L75:
        if (r102 != 12) goto L77;
        gt r104 = new gt();
        this.f708a = r104;
        r104.a(r100);
        goto L81
    L77:
        ic.a(r100, r102);
        goto L81
    L78:
        if (r102 != 11) goto L80;
        this.f710a = r100.mo9276a();
        goto L81
    L80:
        ic.a(r100, r102);
        goto L81
    L15:
        if (r102 != 13) goto L21;
        hy r105 = r100.mo9273a();
        this.f712a = new HashMap(r105.f953a * 2);
        int r106 = 0;
    L18:
        if (r106 >= r105.f953a) goto L20;
        this.f712a.put(r100.mo9276a(), r100.mo9276a());
        r106 = r106 + 1;
        goto L18
    L20:
        r100.h();
        goto L81
    L21:
        ic.a(r100, r102);
        goto L81
    L23:
        if (r102 != 8) goto L25;
        this.f706a = r100.mo9269a();
        e(true);
        goto L81
    L25:
        ic.a(r100, r102);
        goto L81
    L66:
        if (r102 != 10) goto L68;
        this.f707a = r100.mo9270a();
        a(true);
        goto L81
    L68:
        ic.a(r100, r102);
        goto L81
    L5:
        r100.f();
        if (e() == false) goto L10;
        a();
        return;
    L10:
        throw new ia("Required field 'messageTs' was not found in serialized data! Struct: " + toString());
    }

    public gu b(String r100) {
        this.f717c = r100;
        return this;
    }

    public gu a(long r100) {
        this.f707a = r100;
        a(true);
        return this;
    }

    public gu a(short r100) {
        this.f713a = r100;
        c(true);
        return this;
    }

    public void a(boolean r100) {
        this.f711a.set(0, r100);
    }

    public gu a(String r100) {
        this.f715b = r100;
        return this;
    }
}
