package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* JADX INFO: loaded from: classes41.dex */
public class hk implements hp<hk, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final hw f464044a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final ie f896a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final hw f464045b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final hw f464046c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final hw f464047d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final hw f464048e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final hw f464049f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final hw f464050g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final hw f464051h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final hw f464052i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final hw f464053j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final hw f464054k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final hw f464055l = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f897a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public gt f898a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f899a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private BitSet f900a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f901a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f902b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public String f903c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public String f904d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public String f905e;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public String f906f;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public String f907g;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    public String f908h;

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    public String f909i;

    public int hashCode() {
        return 0;
    }

    static {
        f896a = new ie("XmPushActionUnRegistration");
        f464044a = new hw("", (byte) 11, 1);
        f464045b = new hw("", (byte) 12, 2);
        f464046c = new hw("", (byte) 11, 3);
        f464047d = new hw("", (byte) 11, 4);
        f464048e = new hw("", (byte) 11, 5);
        f464049f = new hw("", (byte) 11, 6);
        f464050g = new hw("", (byte) 11, 7);
        f464051h = new hw("", (byte) 11, 8);
        f464052i = new hw("", (byte) 11, 9);
        f464053j = new hw("", (byte) 11, 10);
        f464054k = new hw("", (byte) 2, 11);
        f464055l = new hw("", (byte) 10, 12);
    }

    public void a() {
        if (this.f902b == null) goto L10;
        if (this.f903c == null) goto L8;
        return;
    L8:
        throw new ia("Required field 'appId' was not present! Struct: " + toString());
    L10:
        throw new ia("Required field 'id' was not present! Struct: " + toString());
    }

    public boolean b() {
        if (this.f898a == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean c() {
        if (this.f902b == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean d() {
        if (this.f903c == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean e() {
        if (this.f904d == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean f() {
        if (this.f905e == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean g() {
        if (this.f906f == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean h() {
        if (this.f907g == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean i() {
        if (this.f908h == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean j() {
        if (this.f909i == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean k() {
        return this.f900a.get(0);
    }

    public boolean l() {
        return this.f900a.get(1);
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("XmPushActionUnRegistration(");
        boolean r101 = false;
        if (m9252a() == false) goto L9;
        r100.append("debug:");
        String r102 = this.f899a;
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
        gt r104 = this.f898a;
        if (r104 != null) goto L17;
        r100.append("null");
    L19:
        if (r101 == true) goto L21;
        r100.append(", ");
    L21:
        r100.append("id:");
        String r105 = this.f902b;
        if (r105 != null) goto L24;
        r100.append("null");
    L25:
        r100.append(", ");
        r100.append("appId:");
        String r106 = this.f903c;
        if (r106 != null) goto L28;
        r100.append("null");
    L30:
        if (e() == false) goto L36;
        r100.append(", ");
        r100.append("regId:");
        String r107 = this.f904d;
        if (r107 != null) goto L34;
        r100.append("null");
        goto L36
    L34:
        r100.append(r107);
    L36:
        if (f() == false) goto L42;
        r100.append(", ");
        r100.append("appVersion:");
        String r108 = this.f905e;
        if (r108 != null) goto L40;
        r100.append("null");
        goto L42
    L40:
        r100.append(r108);
    L42:
        if (g() == false) goto L48;
        r100.append(", ");
        r100.append("packageName:");
        String r109 = this.f906f;
        if (r109 != null) goto L46;
        r100.append("null");
        goto L48
    L46:
        r100.append(r109);
    L48:
        if (h() == false) goto L54;
        r100.append(", ");
        r100.append("token:");
        String r110 = this.f907g;
        if (r110 != null) goto L52;
        r100.append("null");
        goto L54
    L52:
        r100.append(r110);
    L54:
        if (i() == false) goto L60;
        r100.append(", ");
        r100.append("deviceId:");
        String r111 = this.f908h;
        if (r111 != null) goto L58;
        r100.append("null");
        goto L60
    L58:
        r100.append(r111);
    L60:
        if (j() == false) goto L66;
        r100.append(", ");
        r100.append("aliasName:");
        String r112 = this.f909i;
        if (r112 != null) goto L64;
        r100.append("null");
        goto L66
    L64:
        r100.append(r112);
    L66:
        if (k() == false) goto L69;
        r100.append(", ");
        r100.append("needAck:");
        r100.append(this.f901a);
    L69:
        if (l() == false) goto L71;
        r100.append(", ");
        r100.append("createdTs:");
        r100.append(this.f897a);
    L71:
        r100.append(")");
        return r100.toString();
    L28:
        r100.append(r106);
        goto L30
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

    public hk() {
        this.f900a = new BitSet(2);
        this.f901a = true;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m9252a() {
        if (this.f899a == null) goto L5;
        return true;
    L5:
        return false;
    }

    public int a(hk r100) {
        if (getClass().equals(r100.getClass()) == false) goto L5;
        int r101 = Boolean.valueOf(m9252a()).compareTo(Boolean.valueOf(r100.m9252a()));
        if (r101 == 0) goto L10;
        return r101;
    L10:
        if (m9252a() == false) goto L14;
        int r102 = hq.a(this.f899a, r100.f899a);
        if (r102 == 0) goto L14;
        return r102;
    L14:
        int r103 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(r100.b()));
        if (r103 == 0) goto L18;
        return r103;
    L18:
        if (b() == false) goto L22;
        int r104 = hq.a(this.f898a, r100.f898a);
        if (r104 == 0) goto L22;
        return r104;
    L22:
        int r105 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(r100.c()));
        if (r105 == 0) goto L26;
        return r105;
    L26:
        if (c() == false) goto L30;
        int r106 = hq.a(this.f902b, r100.f902b);
        if (r106 == 0) goto L30;
        return r106;
    L30:
        int r107 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(r100.d()));
        if (r107 == 0) goto L34;
        return r107;
    L34:
        if (d() == false) goto L38;
        int r108 = hq.a(this.f903c, r100.f903c);
        if (r108 == 0) goto L38;
        return r108;
    L38:
        int r109 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(r100.e()));
        if (r109 == 0) goto L42;
        return r109;
    L42:
        if (e() == false) goto L46;
        int r110 = hq.a(this.f904d, r100.f904d);
        if (r110 == 0) goto L46;
        return r110;
    L46:
        int r111 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(r100.f()));
        if (r111 == 0) goto L50;
        return r111;
    L50:
        if (f() == false) goto L54;
        int r112 = hq.a(this.f905e, r100.f905e);
        if (r112 == 0) goto L54;
        return r112;
    L54:
        int r113 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(r100.g()));
        if (r113 == 0) goto L58;
        return r113;
    L58:
        if (g() == false) goto L62;
        int r114 = hq.a(this.f906f, r100.f906f);
        if (r114 == 0) goto L62;
        return r114;
    L62:
        int r115 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(r100.h()));
        if (r115 == 0) goto L66;
        return r115;
    L66:
        if (h() == false) goto L70;
        int r116 = hq.a(this.f907g, r100.f907g);
        if (r116 == 0) goto L70;
        return r116;
    L70:
        int r117 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(r100.i()));
        if (r117 == 0) goto L74;
        return r117;
    L74:
        if (i() == false) goto L78;
        int r118 = hq.a(this.f908h, r100.f908h);
        if (r118 == 0) goto L78;
        return r118;
    L78:
        int r119 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(r100.j()));
        if (r119 == 0) goto L82;
        return r119;
    L82:
        if (j() == false) goto L86;
        int r120 = hq.a(this.f909i, r100.f909i);
        if (r120 == 0) goto L86;
        return r120;
    L86:
        int r121 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(r100.k()));
        if (r121 == 0) goto L90;
        return r121;
    L90:
        if (k() == false) goto L94;
        int r122 = hq.a(this.f901a, r100.f901a);
        if (r122 == 0) goto L94;
        return r122;
    L94:
        int r123 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(r100.l()));
        if (r123 == 0) goto L98;
        return r123;
    L98:
        if (l() == false) goto L102;
        int r124 = hq.a(this.f897a, r100.f897a);
        if (r124 == 0) goto L104;
        return r124;
    L104:
        return 0;
    L102:
        return 0;
    L5:
        return getClass().getName().compareTo(r100.getClass().getName());
    }

    @Override // com.xiaomi.push.hp
    public void b(hz r100) {
        a();
        r100.a(f896a);
        if (this.f899a == null) goto L8;
        if (m9252a() == false) goto L8;
        r100.a(f464044a);
        r100.a(this.f899a);
        r100.b();
    L8:
        if (this.f898a == null) goto L13;
        if (b() == false) goto L13;
        r100.a(f464045b);
        this.f898a.b(r100);
        r100.b();
    L13:
        if (this.f902b == null) goto L16;
        r100.a(f464046c);
        r100.a(this.f902b);
        r100.b();
    L16:
        if (this.f903c == null) goto L19;
        r100.a(f464047d);
        r100.a(this.f903c);
        r100.b();
    L19:
        if (this.f904d == null) goto L24;
        if (e() == false) goto L24;
        r100.a(f464048e);
        r100.a(this.f904d);
        r100.b();
    L24:
        if (this.f905e == null) goto L29;
        if (f() == false) goto L29;
        r100.a(f464049f);
        r100.a(this.f905e);
        r100.b();
    L29:
        if (this.f906f == null) goto L34;
        if (g() == false) goto L34;
        r100.a(f464050g);
        r100.a(this.f906f);
        r100.b();
    L34:
        if (this.f907g == null) goto L39;
        if (h() == false) goto L39;
        r100.a(f464051h);
        r100.a(this.f907g);
        r100.b();
    L39:
        if (this.f908h == null) goto L44;
        if (i() == false) goto L44;
        r100.a(f464052i);
        r100.a(this.f908h);
        r100.b();
    L44:
        if (this.f909i == null) goto L49;
        if (j() == false) goto L49;
        r100.a(f464053j);
        r100.a(this.f909i);
        r100.b();
    L49:
        if (k() == false) goto L52;
        r100.a(f464054k);
        r100.a(this.f901a);
        r100.b();
    L52:
        if (l() == false) goto L54;
        r100.a(f464055l);
        r100.a(this.f897a);
        r100.b();
    L54:
        r100.c();
        r100.mo9279a();
    }

    public hk c(String r100) {
        this.f904d = r100;
        return this;
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(Object r100) {
        return a((hk) r100);
    }

    public hk d(String r100) {
        this.f906f = r100;
        return this;
    }

    public hk e(String r100) {
        this.f907g = r100;
        return this;
    }

    public boolean equals(Object r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if ((r100 instanceof hk) == true) goto L8;
        return false;
    L8:
        return m9253a((hk) r100);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m9253a(hk r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        boolean r101 = m9252a();
        boolean r102 = r100.m9252a();
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
        return true;
    L107:
        if (r123 == false) goto L115;
        if (r124 == false) goto L115;
        if (this.f897a == r100.f897a) goto L116;
        return false;
    L116:
        return true;
    L115:
        return false;
    L98:
        if (r121 == false) goto L115;
        if (r122 == false) goto L115;
        if (this.f901a == r100.f901a) goto L104;
        return false;
    L89:
        if (r119 == false) goto L115;
        if (r120 == false) goto L115;
        if (this.f909i.equals(r100.f909i) == true) goto L95;
        return false;
    L80:
        if (r117 == false) goto L115;
        if (r118 == false) goto L115;
        if (this.f908h.equals(r100.f908h) == true) goto L86;
        return false;
    L71:
        if (r115 == false) goto L115;
        if (r116 == false) goto L115;
        if (this.f907g.equals(r100.f907g) == true) goto L77;
        return false;
    L62:
        if (r113 == false) goto L115;
        if (r114 == false) goto L115;
        if (this.f906f.equals(r100.f906f) == true) goto L68;
        return false;
    L53:
        if (r111 == false) goto L115;
        if (r112 == false) goto L115;
        if (this.f905e.equals(r100.f905e) == true) goto L59;
        return false;
    L44:
        if (r109 == false) goto L115;
        if (r110 == false) goto L115;
        if (this.f904d.equals(r100.f904d) == true) goto L50;
        return false;
    L35:
        if (r107 == false) goto L115;
        if (r108 == false) goto L115;
        if (this.f903c.equals(r100.f903c) == true) goto L41;
        return false;
    L26:
        if (r105 == false) goto L115;
        if (r106 == false) goto L115;
        if (this.f902b.equals(r100.f902b) == true) goto L32;
        return false;
    L17:
        if (r103 == false) goto L115;
        if (r104 == false) goto L115;
        if (this.f898a.m9175a(r100.f898a) == true) goto L23;
        return false;
    L8:
        if (r101 == false) goto L115;
        if (r102 == false) goto L115;
        if (this.f899a.equals(r100.f899a) == true) goto L14;
        return false;
    }

    public void b(boolean r100) {
        this.f900a.set(1, r100);
    }

    @Override // com.xiaomi.push.hp
    public void a(hz r100) {
        r100.mo9275a();
    L3:
        hw r101 = r100.mo9271a();
        byte r102 = r101.f464095a;
        if (r102 == 0) goto L5;
        switch(r101.f951a) {
            case 1: goto L46;
            case 2: goto L43;
            case 3: goto L39;
            case 4: goto L36;
            case 5: goto L33;
            case 6: goto L30;
            case 7: goto L27;
            case 8: goto L24;
            case 9: goto L21;
            case 10: goto L18;
            case 11: goto L15;
            case 12: goto L11;
            default: goto L9;
        };
    L9:
        ic.a(r100, r102);
    L49:
        r100.g();
        goto L3
    L18:
        if (r102 != 11) goto L20;
        this.f909i = r100.mo9276a();
        goto L49
    L20:
        ic.a(r100, r102);
        goto L49
    L21:
        if (r102 != 11) goto L23;
        this.f908h = r100.mo9276a();
        goto L49
    L23:
        ic.a(r100, r102);
        goto L49
    L24:
        if (r102 != 11) goto L26;
        this.f907g = r100.mo9276a();
        goto L49
    L26:
        ic.a(r100, r102);
        goto L49
    L27:
        if (r102 != 11) goto L29;
        this.f906f = r100.mo9276a();
        goto L49
    L29:
        ic.a(r100, r102);
        goto L49
    L30:
        if (r102 != 11) goto L32;
        this.f905e = r100.mo9276a();
        goto L49
    L32:
        ic.a(r100, r102);
        goto L49
    L33:
        if (r102 != 11) goto L35;
        this.f904d = r100.mo9276a();
        goto L49
    L35:
        ic.a(r100, r102);
        goto L49
    L36:
        if (r102 != 11) goto L38;
        this.f903c = r100.mo9276a();
        goto L49
    L38:
        ic.a(r100, r102);
        goto L49
    L39:
        if (r102 != 11) goto L41;
        this.f902b = r100.mo9276a();
        goto L49
    L41:
        ic.a(r100, r102);
        goto L49
    L46:
        if (r102 != 11) goto L48;
        this.f899a = r100.mo9276a();
        goto L49
    L48:
        ic.a(r100, r102);
        goto L49
    L11:
        if (r102 != 10) goto L13;
        this.f897a = r100.mo9270a();
        b(true);
        goto L49
    L13:
        ic.a(r100, r102);
        goto L49
    L15:
        if (r102 != 2) goto L17;
        this.f901a = r100.mo9281a();
        a(true);
        goto L49
    L17:
        ic.a(r100, r102);
        goto L49
    L43:
        if (r102 != 12) goto L45;
        gt r103 = new gt();
        this.f898a = r103;
        r103.a(r100);
        goto L49
    L45:
        ic.a(r100, r102);
        goto L49
    L5:
        r100.f();
        a();
    }

    public hk b(String r100) {
        this.f903c = r100;
        return this;
    }

    public void a(boolean r100) {
        this.f900a.set(0, r100);
    }

    public hk a(String r100) {
        this.f902b = r100;
        return this;
    }
}
