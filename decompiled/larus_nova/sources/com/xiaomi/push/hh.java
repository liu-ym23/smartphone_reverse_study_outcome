package com.xiaomi.push;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes41.dex */
public class hh implements hp<hh, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final hw f464015a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final ie f862a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final hw f464016b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final hw f464017c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final hw f464018d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final hw f464019e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final hw f464020f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final hw f464021g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final hw f464022h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final hw f464023i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final hw f464024j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final hw f464025k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final hw f464026l = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public gq f863a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public gt f864a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f865a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private BitSet f866a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Map<String, String> f867a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f868a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f869b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public String f870c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public String f871d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public String f872e;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public String f873f;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public String f874g;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    public String f875h;

    public int hashCode() {
        return 0;
    }

    static {
        f862a = new ie("XmPushActionSendMessage");
        f464015a = new hw("", (byte) 11, 1);
        f464016b = new hw("", (byte) 12, 2);
        f464017c = new hw("", (byte) 11, 3);
        f464018d = new hw("", (byte) 11, 4);
        f464019e = new hw("", (byte) 11, 5);
        f464020f = new hw("", (byte) 11, 6);
        f464021g = new hw("", (byte) 11, 7);
        f464022h = new hw("", (byte) 12, 8);
        f464023i = new hw("", (byte) 2, 9);
        f464024j = new hw("", HTTP.CR, 10);
        f464025k = new hw("", (byte) 11, 11);
        f464026l = new hw("", (byte) 11, 12);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m9237a() {
        if (this.f869b == null) goto L10;
        if (this.f870c == null) goto L8;
        return;
    L8:
        throw new ia("Required field 'appId' was not present! Struct: " + toString());
    L10:
        throw new ia("Required field 'id' was not present! Struct: " + toString());
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public boolean m9240b() {
        if (this.f864a == null) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public boolean m9241c() {
        if (this.f869b == null) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: d, reason: collision with other method in class */
    public boolean m9242d() {
        if (this.f870c == null) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: e, reason: collision with other method in class */
    public boolean m9243e() {
        if (this.f871d == null) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: f, reason: collision with other method in class */
    public boolean m9244f() {
        if (this.f872e == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean g() {
        if (this.f873f == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean h() {
        if (this.f863a == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean i() {
        return this.f866a.get(0);
    }

    public boolean j() {
        if (this.f867a == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean k() {
        if (this.f874g == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean l() {
        if (this.f875h == null) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("XmPushActionSendMessage(");
        boolean r101 = false;
        if (m9238a() == false) goto L9;
        r100.append("debug:");
        String r102 = this.f865a;
        if (r102 != null) goto L7;
        r100.append("null");
    L8:
        boolean r103 = false;
    L11:
        if (m9240b() == false) goto L18;
        if (r103 == true) goto L14;
        r100.append(", ");
    L14:
        r100.append("target:");
        gt r104 = this.f864a;
        if (r104 != null) goto L17;
        r100.append("null");
    L19:
        if (r101 == true) goto L21;
        r100.append(", ");
    L21:
        r100.append("id:");
        String r105 = this.f869b;
        if (r105 != null) goto L24;
        r100.append("null");
    L25:
        r100.append(", ");
        r100.append("appId:");
        String r106 = this.f870c;
        if (r106 != null) goto L28;
        r100.append("null");
    L30:
        if (m9243e() == false) goto L36;
        r100.append(", ");
        r100.append("packageName:");
        String r107 = this.f871d;
        if (r107 != null) goto L34;
        r100.append("null");
        goto L36
    L34:
        r100.append(r107);
    L36:
        if (m9244f() == false) goto L42;
        r100.append(", ");
        r100.append("topic:");
        String r108 = this.f872e;
        if (r108 != null) goto L40;
        r100.append("null");
        goto L42
    L40:
        r100.append(r108);
    L42:
        if (g() == false) goto L48;
        r100.append(", ");
        r100.append("aliasName:");
        String r109 = this.f873f;
        if (r109 != null) goto L46;
        r100.append("null");
        goto L48
    L46:
        r100.append(r109);
    L48:
        if (h() == false) goto L54;
        r100.append(", ");
        r100.append("message:");
        gq r110 = this.f863a;
        if (r110 != null) goto L52;
        r100.append("null");
        goto L54
    L52:
        r100.append(r110);
    L54:
        if (i() == false) goto L57;
        r100.append(", ");
        r100.append("needAck:");
        r100.append(this.f868a);
    L57:
        if (j() == false) goto L63;
        r100.append(", ");
        r100.append("params:");
        Map<String, String> r111 = this.f867a;
        if (r111 != null) goto L61;
        r100.append("null");
        goto L63
    L61:
        r100.append(r111);
    L63:
        if (k() == false) goto L69;
        r100.append(", ");
        r100.append("category:");
        String r112 = this.f874g;
        if (r112 != null) goto L67;
        r100.append("null");
        goto L69
    L67:
        r100.append(r112);
    L69:
        if (l() == false) goto L74;
        r100.append(", ");
        r100.append("userAccount:");
        String r113 = this.f875h;
        if (r113 != null) goto L73;
        r100.append("null");
        goto L74
    L73:
        r100.append(r113);
    L74:
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

    public hh() {
        this.f866a = new BitSet(1);
        this.f868a = true;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m9238a() {
        if (this.f865a == null) goto L5;
        return true;
    L5:
        return false;
    }

    public String b() {
        return this.f870c;
    }

    public String c() {
        return this.f872e;
    }

    public String d() {
        return this.f873f;
    }

    public String e() {
        return this.f874g;
    }

    public String f() {
        return this.f875h;
    }

    public gq a() {
        return this.f863a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m9236a() {
        return this.f869b;
    }

    public int a(hh r100) {
        if (getClass().equals(r100.getClass()) == false) goto L5;
        int r101 = Boolean.valueOf(m9238a()).compareTo(Boolean.valueOf(r100.m9238a()));
        if (r101 == 0) goto L10;
        return r101;
    L10:
        if (m9238a() == false) goto L14;
        int r102 = hq.a(this.f865a, r100.f865a);
        if (r102 == 0) goto L14;
        return r102;
    L14:
        int r103 = Boolean.valueOf(m9240b()).compareTo(Boolean.valueOf(r100.m9240b()));
        if (r103 == 0) goto L18;
        return r103;
    L18:
        if (m9240b() == false) goto L22;
        int r104 = hq.a(this.f864a, r100.f864a);
        if (r104 == 0) goto L22;
        return r104;
    L22:
        int r105 = Boolean.valueOf(m9241c()).compareTo(Boolean.valueOf(r100.m9241c()));
        if (r105 == 0) goto L26;
        return r105;
    L26:
        if (m9241c() == false) goto L30;
        int r106 = hq.a(this.f869b, r100.f869b);
        if (r106 == 0) goto L30;
        return r106;
    L30:
        int r107 = Boolean.valueOf(m9242d()).compareTo(Boolean.valueOf(r100.m9242d()));
        if (r107 == 0) goto L34;
        return r107;
    L34:
        if (m9242d() == false) goto L38;
        int r108 = hq.a(this.f870c, r100.f870c);
        if (r108 == 0) goto L38;
        return r108;
    L38:
        int r109 = Boolean.valueOf(m9243e()).compareTo(Boolean.valueOf(r100.m9243e()));
        if (r109 == 0) goto L42;
        return r109;
    L42:
        if (m9243e() == false) goto L46;
        int r110 = hq.a(this.f871d, r100.f871d);
        if (r110 == 0) goto L46;
        return r110;
    L46:
        int r111 = Boolean.valueOf(m9244f()).compareTo(Boolean.valueOf(r100.m9244f()));
        if (r111 == 0) goto L50;
        return r111;
    L50:
        if (m9244f() == false) goto L54;
        int r112 = hq.a(this.f872e, r100.f872e);
        if (r112 == 0) goto L54;
        return r112;
    L54:
        int r113 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(r100.g()));
        if (r113 == 0) goto L58;
        return r113;
    L58:
        if (g() == false) goto L62;
        int r114 = hq.a(this.f873f, r100.f873f);
        if (r114 == 0) goto L62;
        return r114;
    L62:
        int r115 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(r100.h()));
        if (r115 == 0) goto L66;
        return r115;
    L66:
        if (h() == false) goto L70;
        int r116 = hq.a(this.f863a, r100.f863a);
        if (r116 == 0) goto L70;
        return r116;
    L70:
        int r117 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(r100.i()));
        if (r117 == 0) goto L74;
        return r117;
    L74:
        if (i() == false) goto L78;
        int r118 = hq.a(this.f868a, r100.f868a);
        if (r118 == 0) goto L78;
        return r118;
    L78:
        int r119 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(r100.j()));
        if (r119 == 0) goto L82;
        return r119;
    L82:
        if (j() == false) goto L86;
        int r120 = hq.a(this.f867a, r100.f867a);
        if (r120 == 0) goto L86;
        return r120;
    L86:
        int r121 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(r100.k()));
        if (r121 == 0) goto L90;
        return r121;
    L90:
        if (k() == false) goto L94;
        int r122 = hq.a(this.f874g, r100.f874g);
        if (r122 == 0) goto L94;
        return r122;
    L94:
        int r123 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(r100.l()));
        if (r123 == 0) goto L98;
        return r123;
    L98:
        if (l() == false) goto L102;
        int r124 = hq.a(this.f875h, r100.f875h);
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
        m9237a();
        r100.a(f862a);
        if (this.f865a == null) goto L8;
        if (m9238a() == false) goto L8;
        r100.a(f464015a);
        r100.a(this.f865a);
        r100.b();
    L8:
        if (this.f864a == null) goto L13;
        if (m9240b() == false) goto L13;
        r100.a(f464016b);
        this.f864a.b(r100);
        r100.b();
    L13:
        if (this.f869b == null) goto L16;
        r100.a(f464017c);
        r100.a(this.f869b);
        r100.b();
    L16:
        if (this.f870c == null) goto L19;
        r100.a(f464018d);
        r100.a(this.f870c);
        r100.b();
    L19:
        if (this.f871d == null) goto L24;
        if (m9243e() == false) goto L24;
        r100.a(f464019e);
        r100.a(this.f871d);
        r100.b();
    L24:
        if (this.f872e == null) goto L29;
        if (m9244f() == false) goto L29;
        r100.a(f464020f);
        r100.a(this.f872e);
        r100.b();
    L29:
        if (this.f873f == null) goto L34;
        if (g() == false) goto L34;
        r100.a(f464021g);
        r100.a(this.f873f);
        r100.b();
    L34:
        if (this.f863a == null) goto L39;
        if (h() == false) goto L39;
        r100.a(f464022h);
        this.f863a.b(r100);
        r100.b();
    L39:
        if (i() == false) goto L42;
        r100.a(f464023i);
        r100.a(this.f868a);
        r100.b();
    L42:
        if (this.f867a == null) goto L51;
        if (j() == false) goto L51;
        r100.a(f464024j);
        r100.a(new hy((byte) 11, (byte) 11, this.f867a.size()));
        Iterator<Map.Entry<String, String>> r101 = this.f867a.entrySet().iterator();
    L47:
        if (r101.hasNext() == false) goto L49;
        Map.Entry<String, String> r102 = r101.next();
        r100.a(r102.getKey());
        r100.a(r102.getValue());
        goto L47
    L49:
        r100.d();
        r100.b();
    L51:
        if (this.f874g == null) goto L56;
        if (k() == false) goto L56;
        r100.a(f464025k);
        r100.a(this.f874g);
        r100.b();
    L56:
        if (this.f875h != null) goto L58;
    L60:
        r100.c();
        r100.mo9279a();
        return;
    L58:
        if (l() == false) goto L60;
        r100.a(f464026l);
        r100.a(this.f875h);
        r100.b();
        goto L60
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(Object r100) {
        return a((hh) r100);
    }

    public boolean equals(Object r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if ((r100 instanceof hh) == true) goto L8;
        return false;
    L8:
        return m9239a((hh) r100);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m9239a(hh r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        boolean r101 = m9238a();
        boolean r102 = r100.m9238a();
        if (r101 == true) goto L8;
        if (r102 == true) goto L8;
    L14:
        boolean r103 = m9240b();
        boolean r104 = r100.m9240b();
        if (r103 == true) goto L17;
        if (r104 == true) goto L17;
    L23:
        boolean r105 = m9241c();
        boolean r106 = r100.m9241c();
        if (r105 == true) goto L26;
        if (r106 == true) goto L26;
    L32:
        boolean r107 = m9242d();
        boolean r108 = r100.m9242d();
        if (r107 == true) goto L35;
        if (r108 == true) goto L35;
    L41:
        boolean r109 = m9243e();
        boolean r110 = r100.m9243e();
        if (r109 == true) goto L44;
        if (r110 == true) goto L44;
    L50:
        boolean r111 = m9244f();
        boolean r112 = r100.m9244f();
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
        if (this.f875h.equals(r100.f875h) == true) goto L116;
        return false;
    L116:
        return true;
    L115:
        return false;
    L98:
        if (r121 == false) goto L115;
        if (r122 == false) goto L115;
        if (this.f874g.equals(r100.f874g) == true) goto L104;
        return false;
    L89:
        if (r119 == false) goto L115;
        if (r120 == false) goto L115;
        if (this.f867a.equals(r100.f867a) == true) goto L95;
        return false;
    L80:
        if (r117 == false) goto L115;
        if (r118 == false) goto L115;
        if (this.f868a == r100.f868a) goto L86;
        return false;
    L71:
        if (r115 == false) goto L115;
        if (r116 == false) goto L115;
        if (this.f863a.m9158a(r100.f863a) == true) goto L77;
        return false;
    L62:
        if (r113 == false) goto L115;
        if (r114 == false) goto L115;
        if (this.f873f.equals(r100.f873f) == true) goto L68;
        return false;
    L53:
        if (r111 == false) goto L115;
        if (r112 == false) goto L115;
        if (this.f872e.equals(r100.f872e) == true) goto L59;
        return false;
    L44:
        if (r109 == false) goto L115;
        if (r110 == false) goto L115;
        if (this.f871d.equals(r100.f871d) == true) goto L50;
        return false;
    L35:
        if (r107 == false) goto L115;
        if (r108 == false) goto L115;
        if (this.f870c.equals(r100.f870c) == true) goto L41;
        return false;
    L26:
        if (r105 == false) goto L115;
        if (r106 == false) goto L115;
        if (this.f869b.equals(r100.f869b) == true) goto L32;
        return false;
    L17:
        if (r103 == false) goto L115;
        if (r104 == false) goto L115;
        if (this.f864a.m9175a(r100.f864a) == true) goto L23;
        return false;
    L8:
        if (r101 == false) goto L115;
        if (r102 == false) goto L115;
        if (this.f865a.equals(r100.f865a) == true) goto L14;
        return false;
    }

    @Override // com.xiaomi.push.hp
    public void a(hz r100) {
        r100.mo9275a();
    L3:
        hw r101 = r100.mo9271a();
        byte r102 = r101.f464095a;
        if (r102 == 0) goto L5;
        switch(r101.f951a) {
            case 1: goto L48;
            case 2: goto L45;
            case 3: goto L42;
            case 4: goto L39;
            case 5: goto L36;
            case 6: goto L33;
            case 7: goto L30;
            case 8: goto L27;
            case 9: goto L24;
            case 10: goto L17;
            case 11: goto L13;
            case 12: goto L10;
            default: goto L9;
        };
    L9:
        ic.a(r100, r102);
    L51:
        r100.g();
        goto L3
    L10:
        if (r102 != 11) goto L12;
        this.f875h = r100.mo9276a();
        goto L51
    L12:
        ic.a(r100, r102);
        goto L51
    L13:
        if (r102 != 11) goto L15;
        this.f874g = r100.mo9276a();
        goto L51
    L15:
        ic.a(r100, r102);
        goto L51
    L24:
        if (r102 != 2) goto L26;
        this.f868a = r100.mo9281a();
        a(true);
        goto L51
    L26:
        ic.a(r100, r102);
        goto L51
    L27:
        if (r102 != 12) goto L29;
        gq r103 = new gq();
        this.f863a = r103;
        r103.a(r100);
        goto L51
    L29:
        ic.a(r100, r102);
        goto L51
    L30:
        if (r102 != 11) goto L32;
        this.f873f = r100.mo9276a();
        goto L51
    L32:
        ic.a(r100, r102);
        goto L51
    L33:
        if (r102 != 11) goto L35;
        this.f872e = r100.mo9276a();
        goto L51
    L35:
        ic.a(r100, r102);
        goto L51
    L36:
        if (r102 != 11) goto L38;
        this.f871d = r100.mo9276a();
        goto L51
    L38:
        ic.a(r100, r102);
        goto L51
    L39:
        if (r102 != 11) goto L41;
        this.f870c = r100.mo9276a();
        goto L51
    L41:
        ic.a(r100, r102);
        goto L51
    L42:
        if (r102 != 11) goto L44;
        this.f869b = r100.mo9276a();
        goto L51
    L44:
        ic.a(r100, r102);
        goto L51
    L45:
        if (r102 != 12) goto L47;
        gt r104 = new gt();
        this.f864a = r104;
        r104.a(r100);
        goto L51
    L47:
        ic.a(r100, r102);
        goto L51
    L48:
        if (r102 != 11) goto L50;
        this.f865a = r100.mo9276a();
        goto L51
    L50:
        ic.a(r100, r102);
        goto L51
    L17:
        if (r102 != 13) goto L23;
        hy r105 = r100.mo9273a();
        this.f867a = new HashMap(r105.f953a * 2);
        int r106 = 0;
    L20:
        if (r106 >= r105.f953a) goto L22;
        String r107 = r100.mo9276a();
        String r108 = r100.mo9276a();
        this.f867a.put(r107, r108);
        r106 = r106 + 1;
        goto L20
    L22:
        r100.h();
        goto L51
    L23:
        ic.a(r100, r102);
        goto L51
    L5:
        r100.f();
        m9237a();
    }

    public void a(boolean r100) {
        this.f866a.set(0, r100);
    }
}
