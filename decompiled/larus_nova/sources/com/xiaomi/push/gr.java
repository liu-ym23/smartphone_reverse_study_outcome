package com.xiaomi.push;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes41.dex */
public class gr implements hp<gr, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final hw f463861a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final ie f680a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final hw f463862b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final hw f463863c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final hw f463864d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final hw f463865e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final hw f463866f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final hw f463867g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final hw f463868h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final hw f463869i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final hw f463870j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final hw f463871k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final hw f463872l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final hw f463873m = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f681a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f682a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f683a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private BitSet f684a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Map<String, String> f685a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f686a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f687b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f688b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Map<String, String> f689b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public int f690c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public String f691c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public Map<String, String> f692c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public String f693d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public String f694e;

    public int hashCode() {
        return 0;
    }

    static {
        f680a = new ie("PushMetaInfo");
        f463861a = new hw("", (byte) 11, 1);
        f463862b = new hw("", (byte) 10, 2);
        f463863c = new hw("", (byte) 11, 3);
        f463864d = new hw("", (byte) 11, 4);
        f463865e = new hw("", (byte) 11, 5);
        f463866f = new hw("", (byte) 8, 6);
        f463867g = new hw("", (byte) 11, 7);
        f463868h = new hw("", (byte) 8, 8);
        f463869i = new hw("", (byte) 8, 9);
        f463870j = new hw("", HTTP.CR, 10);
        f463871k = new hw("", HTTP.CR, 11);
        f463872l = new hw("", (byte) 2, 12);
        f463873m = new hw("", HTTP.CR, 13);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m9165a() {
        if (this.f683a == null) goto L6;
        return;
    L6:
        throw new ia("Required field 'id' was not present! Struct: " + toString());
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public boolean m9170b() {
        return this.f684a.get(0);
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public boolean m9172c() {
        if (this.f688b == null) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: d, reason: collision with other method in class */
    public boolean m9173d() {
        if (this.f691c == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean e() {
        if (this.f693d == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean f() {
        return this.f684a.get(1);
    }

    public boolean g() {
        if (this.f694e == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean h() {
        return this.f684a.get(2);
    }

    public boolean i() {
        return this.f684a.get(3);
    }

    public boolean j() {
        if (this.f685a == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean k() {
        if (this.f689b == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean m() {
        return this.f684a.get(4);
    }

    public boolean n() {
        if (this.f692c == null) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("PushMetaInfo(id:");
        String r101 = this.f683a;
        if (r101 != null) goto L5;
        r100.append("null");
    L6:
        r100.append(", ");
        r100.append("messageTs:");
        r100.append(this.f682a);
        if (m9172c() == false) goto L13;
        r100.append(", ");
        r100.append("topic:");
        String r102 = this.f688b;
        if (r102 != null) goto L11;
        r100.append("null");
        goto L13
    L11:
        r100.append(r102);
    L13:
        if (m9173d() == false) goto L19;
        r100.append(", ");
        r100.append("title:");
        String r103 = this.f691c;
        if (r103 != null) goto L17;
        r100.append("null");
        goto L19
    L17:
        r100.append(r103);
    L19:
        if (e() == false) goto L25;
        r100.append(", ");
        r100.append("description:");
        String r104 = this.f693d;
        if (r104 != null) goto L23;
        r100.append("null");
        goto L25
    L23:
        r100.append(r104);
    L25:
        if (f() == false) goto L28;
        r100.append(", ");
        r100.append("notifyType:");
        r100.append(this.f681a);
    L28:
        if (g() == false) goto L34;
        r100.append(", ");
        r100.append("url:");
        String r105 = this.f694e;
        if (r105 != null) goto L32;
        r100.append("null");
        goto L34
    L32:
        r100.append(r105);
    L34:
        if (h() == false) goto L37;
        r100.append(", ");
        r100.append("passThrough:");
        r100.append(this.f687b);
    L37:
        if (i() == false) goto L40;
        r100.append(", ");
        r100.append("notifyId:");
        r100.append(this.f690c);
    L40:
        if (j() == false) goto L46;
        r100.append(", ");
        r100.append("extra:");
        Map<String, String> r106 = this.f685a;
        if (r106 != null) goto L44;
        r100.append("null");
        goto L46
    L44:
        r100.append(r106);
    L46:
        if (k() == false) goto L52;
        r100.append(", ");
        r100.append("internal:");
        Map<String, String> r107 = this.f689b;
        if (r107 != null) goto L50;
        r100.append("null");
        goto L52
    L50:
        r100.append(r107);
    L52:
        if (m() == false) goto L55;
        r100.append(", ");
        r100.append("ignoreRegInfo:");
        r100.append(this.f686a);
    L55:
        if (n() == false) goto L60;
        r100.append(", ");
        r100.append("apsProperFields:");
        Map<String, String> r108 = this.f692c;
        if (r108 != null) goto L59;
        r100.append("null");
        goto L60
    L59:
        r100.append(r108);
    L60:
        r100.append(")");
        return r100.toString();
    L5:
        r100.append(com.xiaomi.push.service.aj.a(r101));
        goto L6
    }

    public gr() {
        this.f684a = new BitSet(5);
        this.f686a = false;
    }

    public boolean l() {
        return this.f686a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m9166a() {
        if (this.f683a == null) goto L5;
        return true;
    L5:
        return false;
    }

    public int b() {
        return this.f687b;
    }

    public int c() {
        return this.f690c;
    }

    public String d() {
        return this.f693d;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public gr m9162a() {
        return new gr(this);
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public String m9168b() {
        return this.f688b;
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public String m9171c() {
        return this.f691c;
    }

    public int a() {
        return this.f681a;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public Map<String, String> m9169b() {
        return this.f689b;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public long m9161a() {
        return this.f682a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m9163a() {
        return this.f683a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public Map<String, String> m9164a() {
        return this.f685a;
    }

    public gr(gr r100) {
        BitSet r101 = new BitSet(5);
        this.f684a = r101;
        r101.clear();
        this.f684a.or(r100.f684a);
        if (r100.m9166a() == false) goto L5;
        this.f683a = r100.f683a;
    L5:
        this.f682a = r100.f682a;
        if (r100.m9172c() == false) goto L9;
        this.f688b = r100.f688b;
    L9:
        if (r100.m9173d() == false) goto L12;
        this.f691c = r100.f691c;
    L12:
        if (r100.e() == false) goto L14;
        this.f693d = r100.f693d;
    L14:
        this.f681a = r100.f681a;
        if (r100.g() == false) goto L17;
        this.f694e = r100.f694e;
    L17:
        this.f687b = r100.f687b;
        this.f690c = r100.f690c;
        if (r100.j() == false) goto L25;
        HashMap r102 = new HashMap();
        Iterator<Map.Entry<String, String>> r103 = r100.f685a.entrySet().iterator();
    L21:
        if (r103.hasNext() == false) goto L23;
        Map.Entry<String, String> r104 = r103.next();
        r102.put(r104.getKey(), r104.getValue());
        goto L21
    L23:
        this.f685a = r102;
    L25:
        if (r100.k() == false) goto L31;
        HashMap r105 = new HashMap();
        Iterator<Map.Entry<String, String>> r106 = r100.f689b.entrySet().iterator();
    L28:
        if (r106.hasNext() == false) goto L30;
        Map.Entry<String, String> r107 = r106.next();
        r105.put(r107.getKey(), r107.getValue());
        goto L28
    L30:
        this.f689b = r105;
    L31:
        this.f686a = r100.f686a;
        if (r100.n() == false) goto L42;
        HashMap r108 = new HashMap();
        Iterator<Map.Entry<String, String>> r109 = r100.f692c.entrySet().iterator();
    L35:
        if (r109.hasNext() == false) goto L37;
        Map.Entry<String, String> r110 = r109.next();
        r108.put(r110.getKey(), r110.getValue());
        goto L35
    L37:
        this.f692c = r108;
        return;
    }

    public int a(gr r100) {
        if (getClass().equals(r100.getClass()) == false) goto L5;
        int r101 = Boolean.valueOf(m9166a()).compareTo(Boolean.valueOf(r100.m9166a()));
        if (r101 == 0) goto L10;
        return r101;
    L10:
        if (m9166a() == false) goto L14;
        int r102 = hq.a(this.f683a, r100.f683a);
        if (r102 == 0) goto L14;
        return r102;
    L14:
        int r103 = Boolean.valueOf(m9170b()).compareTo(Boolean.valueOf(r100.m9170b()));
        if (r103 == 0) goto L18;
        return r103;
    L18:
        if (m9170b() == false) goto L22;
        int r104 = hq.a(this.f682a, r100.f682a);
        if (r104 == 0) goto L22;
        return r104;
    L22:
        int r105 = Boolean.valueOf(m9172c()).compareTo(Boolean.valueOf(r100.m9172c()));
        if (r105 == 0) goto L26;
        return r105;
    L26:
        if (m9172c() == false) goto L30;
        int r106 = hq.a(this.f688b, r100.f688b);
        if (r106 == 0) goto L30;
        return r106;
    L30:
        int r107 = Boolean.valueOf(m9173d()).compareTo(Boolean.valueOf(r100.m9173d()));
        if (r107 == 0) goto L34;
        return r107;
    L34:
        if (m9173d() == false) goto L38;
        int r108 = hq.a(this.f691c, r100.f691c);
        if (r108 == 0) goto L38;
        return r108;
    L38:
        int r109 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(r100.e()));
        if (r109 == 0) goto L42;
        return r109;
    L42:
        if (e() == false) goto L46;
        int r110 = hq.a(this.f693d, r100.f693d);
        if (r110 == 0) goto L46;
        return r110;
    L46:
        int r111 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(r100.f()));
        if (r111 == 0) goto L50;
        return r111;
    L50:
        if (f() == false) goto L54;
        int r112 = hq.a(this.f681a, r100.f681a);
        if (r112 == 0) goto L54;
        return r112;
    L54:
        int r113 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(r100.g()));
        if (r113 == 0) goto L58;
        return r113;
    L58:
        if (g() == false) goto L62;
        int r114 = hq.a(this.f694e, r100.f694e);
        if (r114 == 0) goto L62;
        return r114;
    L62:
        int r115 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(r100.h()));
        if (r115 == 0) goto L66;
        return r115;
    L66:
        if (h() == false) goto L70;
        int r116 = hq.a(this.f687b, r100.f687b);
        if (r116 == 0) goto L70;
        return r116;
    L70:
        int r117 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(r100.i()));
        if (r117 == 0) goto L74;
        return r117;
    L74:
        if (i() == false) goto L78;
        int r118 = hq.a(this.f690c, r100.f690c);
        if (r118 == 0) goto L78;
        return r118;
    L78:
        int r119 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(r100.j()));
        if (r119 == 0) goto L82;
        return r119;
    L82:
        if (j() == false) goto L86;
        int r120 = hq.a(this.f685a, r100.f685a);
        if (r120 == 0) goto L86;
        return r120;
    L86:
        int r121 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(r100.k()));
        if (r121 == 0) goto L90;
        return r121;
    L90:
        if (k() == false) goto L94;
        int r122 = hq.a(this.f689b, r100.f689b);
        if (r122 == 0) goto L94;
        return r122;
    L94:
        int r123 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(r100.m()));
        if (r123 == 0) goto L98;
        return r123;
    L98:
        if (m() == false) goto L102;
        int r124 = hq.a(this.f686a, r100.f686a);
        if (r124 == 0) goto L102;
        return r124;
    L102:
        int r125 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(r100.n()));
        if (r125 == 0) goto L106;
        return r125;
    L106:
        if (n() == false) goto L110;
        int r126 = hq.a(this.f692c, r100.f692c);
        if (r126 == 0) goto L112;
        return r126;
    L112:
        return 0;
    L110:
        return 0;
    L5:
        return getClass().getName().compareTo(r100.getClass().getName());
    }

    @Override // com.xiaomi.push.hp
    public void b(hz r100) {
        m9165a();
        r100.a(f680a);
        if (this.f683a == null) goto L5;
        r100.a(f463861a);
        r100.a(this.f683a);
        r100.b();
    L5:
        r100.a(f463862b);
        r100.a(this.f682a);
        r100.b();
        if (this.f688b == null) goto L11;
        if (m9172c() == false) goto L11;
        r100.a(f463863c);
        r100.a(this.f688b);
        r100.b();
    L11:
        if (this.f691c == null) goto L16;
        if (m9173d() == false) goto L16;
        r100.a(f463864d);
        r100.a(this.f691c);
        r100.b();
    L16:
        if (this.f693d == null) goto L21;
        if (e() == false) goto L21;
        r100.a(f463865e);
        r100.a(this.f693d);
        r100.b();
    L21:
        if (f() == false) goto L24;
        r100.a(f463866f);
        r100.mo9280a(this.f681a);
        r100.b();
    L24:
        if (this.f694e == null) goto L29;
        if (g() == false) goto L29;
        r100.a(f463867g);
        r100.a(this.f694e);
        r100.b();
    L29:
        if (h() == false) goto L32;
        r100.a(f463868h);
        r100.mo9280a(this.f687b);
        r100.b();
    L32:
        if (i() == false) goto L35;
        r100.a(f463869i);
        r100.mo9280a(this.f690c);
        r100.b();
    L35:
        if (this.f685a == null) goto L44;
        if (j() == false) goto L44;
        r100.a(f463870j);
        r100.a(new hy((byte) 11, (byte) 11, this.f685a.size()));
        Iterator<Map.Entry<String, String>> r101 = this.f685a.entrySet().iterator();
    L40:
        if (r101.hasNext() == false) goto L42;
        Map.Entry<String, String> r102 = r101.next();
        r100.a(r102.getKey());
        r100.a(r102.getValue());
        goto L40
    L42:
        r100.d();
        r100.b();
    L44:
        if (this.f689b == null) goto L53;
        if (k() == false) goto L53;
        r100.a(f463871k);
        r100.a(new hy((byte) 11, (byte) 11, this.f689b.size()));
        Iterator<Map.Entry<String, String>> r103 = this.f689b.entrySet().iterator();
    L49:
        if (r103.hasNext() == false) goto L51;
        Map.Entry<String, String> r104 = r103.next();
        r100.a(r104.getKey());
        r100.a(r104.getValue());
        goto L49
    L51:
        r100.d();
        r100.b();
    L53:
        if (m() == false) goto L56;
        r100.a(f463872l);
        r100.a(this.f686a);
        r100.b();
    L56:
        if (this.f692c != null) goto L58;
    L64:
        r100.c();
        r100.mo9279a();
        return;
    L58:
        if (n() == false) goto L64;
        r100.a(f463873m);
        r100.a(new hy((byte) 11, (byte) 11, this.f692c.size()));
        Iterator<Map.Entry<String, String>> r105 = this.f692c.entrySet().iterator();
    L61:
        if (r105.hasNext() == false) goto L63;
        Map.Entry<String, String> r106 = r105.next();
        r100.a(r106.getKey());
        r100.a(r106.getValue());
        goto L61
    L63:
        r100.d();
        r100.b();
        goto L64
    }

    public gr c(int r100) {
        this.f690c = r100;
        d(true);
        return this;
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(Object r100) {
        return a((gr) r100);
    }

    public void d(boolean r100) {
        this.f684a.set(3, r100);
    }

    public void e(boolean r100) {
        this.f684a.set(4, r100);
    }

    public boolean equals(Object r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if ((r100 instanceof gr) == true) goto L8;
        return false;
    L8:
        return m9167a((gr) r100);
    }

    @Override // com.xiaomi.push.hp
    public void a(hz r100) {
        r100.mo9275a();
    L3:
        hw r101 = r100.mo9271a();
        byte r102 = r101.f464095a;
        if (r102 == 0) goto L5;
        int r103 = 0;
        switch(r101.f951a) {
            case 1: goto L63;
            case 2: goto L60;
            case 3: goto L56;
            case 4: goto L53;
            case 5: goto L50;
            case 6: goto L47;
            case 7: goto L44;
            case 8: goto L41;
            case 9: goto L38;
            case 10: goto L31;
            case 11: goto L24;
            case 12: goto L21;
            case 13: goto L14;
            default: goto L13;
        };
    L13:
        ic.a(r100, r102);
    L66:
        r100.g();
        goto L3
    L14:
        if (r102 != 13) goto L20;
        hy r104 = r100.mo9273a();
        this.f692c = new HashMap(r104.f953a * 2);
    L17:
        if (r103 >= r104.f953a) goto L19;
        this.f692c.put(r100.mo9276a(), r100.mo9276a());
        r103 = r103 + 1;
        goto L17
    L19:
        r100.h();
        goto L66
    L20:
        ic.a(r100, r102);
        goto L66
    L21:
        if (r102 != 2) goto L23;
        this.f686a = r100.mo9281a();
        e(true);
        goto L66
    L23:
        ic.a(r100, r102);
        goto L66
    L24:
        if (r102 != 13) goto L30;
        hy r105 = r100.mo9273a();
        this.f689b = new HashMap(r105.f953a * 2);
    L27:
        if (r103 >= r105.f953a) goto L29;
        this.f689b.put(r100.mo9276a(), r100.mo9276a());
        r103 = r103 + 1;
        goto L27
    L29:
        r100.h();
        goto L66
    L30:
        ic.a(r100, r102);
        goto L66
    L31:
        if (r102 != 13) goto L37;
        hy r106 = r100.mo9273a();
        this.f685a = new HashMap(r106.f953a * 2);
    L34:
        if (r103 >= r106.f953a) goto L36;
        this.f685a.put(r100.mo9276a(), r100.mo9276a());
        r103 = r103 + 1;
        goto L34
    L36:
        r100.h();
        goto L66
    L37:
        ic.a(r100, r102);
        goto L66
    L38:
        if (r102 != 8) goto L40;
        this.f690c = r100.mo9269a();
        d(true);
        goto L66
    L40:
        ic.a(r100, r102);
        goto L66
    L41:
        if (r102 != 8) goto L43;
        this.f687b = r100.mo9269a();
        c(true);
        goto L66
    L43:
        ic.a(r100, r102);
        goto L66
    L44:
        if (r102 != 11) goto L46;
        this.f694e = r100.mo9276a();
        goto L66
    L46:
        ic.a(r100, r102);
        goto L66
    L47:
        if (r102 != 8) goto L49;
        this.f681a = r100.mo9269a();
        b(true);
        goto L66
    L49:
        ic.a(r100, r102);
        goto L66
    L50:
        if (r102 != 11) goto L52;
        this.f693d = r100.mo9276a();
        goto L66
    L52:
        ic.a(r100, r102);
        goto L66
    L53:
        if (r102 != 11) goto L55;
        this.f691c = r100.mo9276a();
        goto L66
    L55:
        ic.a(r100, r102);
        goto L66
    L56:
        if (r102 != 11) goto L58;
        this.f688b = r100.mo9276a();
        goto L66
    L58:
        ic.a(r100, r102);
        goto L66
    L63:
        if (r102 != 11) goto L65;
        this.f683a = r100.mo9276a();
        goto L66
    L65:
        ic.a(r100, r102);
        goto L66
    L60:
        if (r102 != 10) goto L62;
        this.f682a = r100.mo9270a();
        a(true);
        goto L66
    L62:
        ic.a(r100, r102);
        goto L66
    L5:
        r100.f();
        if (m9170b() == false) goto L10;
        m9165a();
        return;
    L10:
        throw new ia("Required field 'messageTs' was not found in serialized data! Struct: " + toString());
    }

    public gr b(int r100) {
        this.f687b = r100;
        c(true);
        return this;
    }

    public void c(boolean r100) {
        this.f684a.set(2, r100);
    }

    public gr d(String r100) {
        this.f693d = r100;
        return this;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m9167a(gr r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        boolean r101 = m9166a();
        boolean r102 = r100.m9166a();
        if (r101 == true) goto L8;
        if (r102 == true) goto L8;
    L15:
        if (this.f682a == r100.f682a) goto L17;
        return false;
    L17:
        boolean r103 = m9172c();
        boolean r104 = r100.m9172c();
        if (r103 == true) goto L20;
        if (r104 == true) goto L20;
    L26:
        boolean r105 = m9173d();
        boolean r106 = r100.m9173d();
        if (r105 == true) goto L29;
        if (r106 == true) goto L29;
    L35:
        boolean r107 = e();
        boolean r108 = r100.e();
        if (r107 == true) goto L38;
        if (r108 == true) goto L38;
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
        boolean r121 = m();
        boolean r122 = r100.m();
        if (r121 == true) goto L101;
        if (r122 == true) goto L101;
    L107:
        boolean r123 = n();
        boolean r124 = r100.n();
        if (r123 == true) goto L110;
        if (r124 == true) goto L110;
        return true;
    L110:
        if (r123 == false) goto L118;
        if (r124 == false) goto L118;
        if (this.f692c.equals(r100.f692c) == true) goto L119;
        return false;
    L119:
        return true;
    L118:
        return false;
    L101:
        if (r121 == false) goto L118;
        if (r122 == false) goto L118;
        if (this.f686a == r100.f686a) goto L107;
        return false;
    L92:
        if (r119 == false) goto L118;
        if (r120 == false) goto L118;
        if (this.f689b.equals(r100.f689b) == true) goto L98;
        return false;
    L83:
        if (r117 == false) goto L118;
        if (r118 == false) goto L118;
        if (this.f685a.equals(r100.f685a) == true) goto L89;
        return false;
    L74:
        if (r115 == false) goto L118;
        if (r116 == false) goto L118;
        if (this.f690c == r100.f690c) goto L80;
        return false;
    L65:
        if (r113 == false) goto L118;
        if (r114 == false) goto L118;
        if (this.f687b == r100.f687b) goto L71;
        return false;
    L56:
        if (r111 == false) goto L118;
        if (r112 == false) goto L118;
        if (this.f694e.equals(r100.f694e) == true) goto L62;
        return false;
    L47:
        if (r109 == false) goto L118;
        if (r110 == false) goto L118;
        if (this.f681a == r100.f681a) goto L53;
        return false;
    L38:
        if (r107 == false) goto L118;
        if (r108 == false) goto L118;
        if (this.f693d.equals(r100.f693d) == true) goto L44;
        return false;
    L29:
        if (r105 == false) goto L118;
        if (r106 == false) goto L118;
        if (this.f691c.equals(r100.f691c) == true) goto L35;
        return false;
    L20:
        if (r103 == false) goto L118;
        if (r104 == false) goto L118;
        if (this.f688b.equals(r100.f688b) == true) goto L26;
        return false;
    L8:
        if (r101 == false) goto L118;
        if (r102 == false) goto L118;
        if (this.f683a.equals(r100.f683a) == true) goto L15;
        return false;
    }

    public void b(boolean r100) {
        this.f684a.set(1, r100);
    }

    public gr c(String r100) {
        this.f691c = r100;
        return this;
    }

    public gr a(int r100) {
        this.f681a = r100;
        b(true);
        return this;
    }

    public gr b(String r100) {
        this.f688b = r100;
        return this;
    }

    public void a(boolean r100) {
        this.f684a.set(0, r100);
    }

    public gr a(String r100) {
        this.f683a = r100;
        return this;
    }

    public gr a(Map<String, String> r100) {
        this.f685a = r100;
        return this;
    }

    public void a(String r100, String r101) {
        if (this.f685a != null) goto L5;
        this.f685a = new HashMap();
    L5:
        this.f685a.put(r100, r101);
    }

    public void b(String r100, String r101) {
        if (this.f689b != null) goto L5;
        this.f689b = new HashMap();
    L5:
        this.f689b.put(r100, r101);
    }
}
