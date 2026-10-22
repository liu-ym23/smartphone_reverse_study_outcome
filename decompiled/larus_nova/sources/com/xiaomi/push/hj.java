package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* JADX INFO: loaded from: classes41.dex */
public class hj implements hp<hj, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final hw f464035a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final ie f885a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final hw f464036b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final hw f464037c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final hw f464038d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final hw f464039e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final hw f464040f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final hw f464041g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final hw f464042h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final hw f464043i = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f886a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public gt f887a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f888a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private BitSet f889a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f890b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public String f891c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public String f892d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public String f893e;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public String f894f;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public String f895g;

    public int hashCode() {
        return 0;
    }

    static {
        f885a = new ie("XmPushActionSubscriptionResult");
        f464035a = new hw("", (byte) 11, 1);
        f464036b = new hw("", (byte) 12, 2);
        f464037c = new hw("", (byte) 11, 3);
        f464038d = new hw("", (byte) 11, 4);
        f464039e = new hw("", (byte) 10, 6);
        f464040f = new hw("", (byte) 11, 7);
        f464041g = new hw("", (byte) 11, 8);
        f464042h = new hw("", (byte) 11, 9);
        f464043i = new hw("", (byte) 11, 10);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m9247a() {
        if (this.f890b == null) goto L6;
        return;
    L6:
        throw new ia("Required field 'id' was not present! Struct: " + toString());
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public boolean m9250b() {
        if (this.f887a == null) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public boolean m9251c() {
        if (this.f890b == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean d() {
        if (this.f891c == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean e() {
        return this.f889a.get(0);
    }

    public boolean f() {
        if (this.f892d == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean g() {
        if (this.f893e == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean h() {
        if (this.f894f == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean i() {
        if (this.f895g == null) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("XmPushActionSubscriptionResult(");
        boolean r101 = false;
        if (m9248a() == false) goto L9;
        r100.append("debug:");
        String r102 = this.f888a;
        if (r102 != null) goto L7;
        r100.append("null");
    L8:
        boolean r103 = false;
    L11:
        if (m9250b() == false) goto L18;
        if (r103 == true) goto L14;
        r100.append(", ");
    L14:
        r100.append("target:");
        gt r104 = this.f887a;
        if (r104 != null) goto L17;
        r100.append("null");
    L19:
        if (r101 == true) goto L21;
        r100.append(", ");
    L21:
        r100.append("id:");
        String r105 = this.f890b;
        if (r105 != null) goto L24;
        r100.append("null");
    L26:
        if (d() == false) goto L32;
        r100.append(", ");
        r100.append("appId:");
        String r106 = this.f891c;
        if (r106 != null) goto L30;
        r100.append("null");
        goto L32
    L30:
        r100.append(r106);
    L32:
        if (e() == false) goto L35;
        r100.append(", ");
        r100.append("errorCode:");
        r100.append(this.f886a);
    L35:
        if (f() == false) goto L41;
        r100.append(", ");
        r100.append("reason:");
        String r107 = this.f892d;
        if (r107 != null) goto L39;
        r100.append("null");
        goto L41
    L39:
        r100.append(r107);
    L41:
        if (g() == false) goto L47;
        r100.append(", ");
        r100.append("topic:");
        String r108 = this.f893e;
        if (r108 != null) goto L45;
        r100.append("null");
        goto L47
    L45:
        r100.append(r108);
    L47:
        if (h() == false) goto L53;
        r100.append(", ");
        r100.append("packageName:");
        String r109 = this.f894f;
        if (r109 != null) goto L51;
        r100.append("null");
        goto L53
    L51:
        r100.append(r109);
    L53:
        if (i() == false) goto L58;
        r100.append(", ");
        r100.append("category:");
        String r110 = this.f895g;
        if (r110 != null) goto L57;
        r100.append("null");
        goto L58
    L57:
        r100.append(r110);
    L58:
        r100.append(")");
        return r100.toString();
    L24:
        r100.append(r105);
        goto L26
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

    public hj() {
        this.f889a = new BitSet(1);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m9248a() {
        if (this.f888a == null) goto L5;
        return true;
    L5:
        return false;
    }

    public String b() {
        return this.f893e;
    }

    public String c() {
        return this.f895g;
    }

    public String a() {
        return this.f890b;
    }

    public int a(hj r100) {
        if (getClass().equals(r100.getClass()) == false) goto L5;
        int r101 = Boolean.valueOf(m9248a()).compareTo(Boolean.valueOf(r100.m9248a()));
        if (r101 == 0) goto L10;
        return r101;
    L10:
        if (m9248a() == false) goto L14;
        int r102 = hq.a(this.f888a, r100.f888a);
        if (r102 == 0) goto L14;
        return r102;
    L14:
        int r103 = Boolean.valueOf(m9250b()).compareTo(Boolean.valueOf(r100.m9250b()));
        if (r103 == 0) goto L18;
        return r103;
    L18:
        if (m9250b() == false) goto L22;
        int r104 = hq.a(this.f887a, r100.f887a);
        if (r104 == 0) goto L22;
        return r104;
    L22:
        int r105 = Boolean.valueOf(m9251c()).compareTo(Boolean.valueOf(r100.m9251c()));
        if (r105 == 0) goto L26;
        return r105;
    L26:
        if (m9251c() == false) goto L30;
        int r106 = hq.a(this.f890b, r100.f890b);
        if (r106 == 0) goto L30;
        return r106;
    L30:
        int r107 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(r100.d()));
        if (r107 == 0) goto L34;
        return r107;
    L34:
        if (d() == false) goto L38;
        int r108 = hq.a(this.f891c, r100.f891c);
        if (r108 == 0) goto L38;
        return r108;
    L38:
        int r109 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(r100.e()));
        if (r109 == 0) goto L42;
        return r109;
    L42:
        if (e() == false) goto L46;
        int r110 = hq.a(this.f886a, r100.f886a);
        if (r110 == 0) goto L46;
        return r110;
    L46:
        int r111 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(r100.f()));
        if (r111 == 0) goto L50;
        return r111;
    L50:
        if (f() == false) goto L54;
        int r112 = hq.a(this.f892d, r100.f892d);
        if (r112 == 0) goto L54;
        return r112;
    L54:
        int r113 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(r100.g()));
        if (r113 == 0) goto L58;
        return r113;
    L58:
        if (g() == false) goto L62;
        int r114 = hq.a(this.f893e, r100.f893e);
        if (r114 == 0) goto L62;
        return r114;
    L62:
        int r115 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(r100.h()));
        if (r115 == 0) goto L66;
        return r115;
    L66:
        if (h() == false) goto L70;
        int r116 = hq.a(this.f894f, r100.f894f);
        if (r116 == 0) goto L70;
        return r116;
    L70:
        int r117 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(r100.i()));
        if (r117 == 0) goto L74;
        return r117;
    L74:
        if (i() == false) goto L78;
        int r118 = hq.a(this.f895g, r100.f895g);
        if (r118 == 0) goto L80;
        return r118;
    L80:
        return 0;
    L78:
        return 0;
    L5:
        return getClass().getName().compareTo(r100.getClass().getName());
    }

    @Override // com.xiaomi.push.hp
    public void b(hz r100) {
        m9247a();
        r100.a(f885a);
        if (this.f888a == null) goto L8;
        if (m9248a() == false) goto L8;
        r100.a(f464035a);
        r100.a(this.f888a);
        r100.b();
    L8:
        if (this.f887a == null) goto L13;
        if (m9250b() == false) goto L13;
        r100.a(f464036b);
        this.f887a.b(r100);
        r100.b();
    L13:
        if (this.f890b == null) goto L16;
        r100.a(f464037c);
        r100.a(this.f890b);
        r100.b();
    L16:
        if (this.f891c == null) goto L21;
        if (d() == false) goto L21;
        r100.a(f464038d);
        r100.a(this.f891c);
        r100.b();
    L21:
        if (e() == false) goto L24;
        r100.a(f464039e);
        r100.a(this.f886a);
        r100.b();
    L24:
        if (this.f892d == null) goto L29;
        if (f() == false) goto L29;
        r100.a(f464040f);
        r100.a(this.f892d);
        r100.b();
    L29:
        if (this.f893e == null) goto L34;
        if (g() == false) goto L34;
        r100.a(f464041g);
        r100.a(this.f893e);
        r100.b();
    L34:
        if (this.f894f == null) goto L39;
        if (h() == false) goto L39;
        r100.a(f464042h);
        r100.a(this.f894f);
        r100.b();
    L39:
        if (this.f895g != null) goto L41;
    L43:
        r100.c();
        r100.mo9279a();
        return;
    L41:
        if (i() == false) goto L43;
        r100.a(f464043i);
        r100.a(this.f895g);
        r100.b();
        goto L43
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(Object r100) {
        return a((hj) r100);
    }

    public boolean equals(Object r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if ((r100 instanceof hj) == true) goto L8;
        return false;
    L8:
        return m9249a((hj) r100);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m9249a(hj r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        boolean r101 = m9248a();
        boolean r102 = r100.m9248a();
        if (r101 == true) goto L8;
        if (r102 == true) goto L8;
    L14:
        boolean r103 = m9250b();
        boolean r104 = r100.m9250b();
        if (r103 == true) goto L17;
        if (r104 == true) goto L17;
    L23:
        boolean r105 = m9251c();
        boolean r106 = r100.m9251c();
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
        return true;
    L80:
        if (r117 == false) goto L88;
        if (r118 == false) goto L88;
        if (this.f895g.equals(r100.f895g) == true) goto L89;
        return false;
    L89:
        return true;
    L88:
        return false;
    L71:
        if (r115 == false) goto L88;
        if (r116 == false) goto L88;
        if (this.f894f.equals(r100.f894f) == true) goto L77;
        return false;
    L62:
        if (r113 == false) goto L88;
        if (r114 == false) goto L88;
        if (this.f893e.equals(r100.f893e) == true) goto L68;
        return false;
    L53:
        if (r111 == false) goto L88;
        if (r112 == false) goto L88;
        if (this.f892d.equals(r100.f892d) == true) goto L59;
        return false;
    L44:
        if (r109 == false) goto L88;
        if (r110 == false) goto L88;
        if (this.f886a == r100.f886a) goto L50;
        return false;
    L35:
        if (r107 == false) goto L88;
        if (r108 == false) goto L88;
        if (this.f891c.equals(r100.f891c) == true) goto L41;
        return false;
    L26:
        if (r105 == false) goto L88;
        if (r106 == false) goto L88;
        if (this.f890b.equals(r100.f890b) == true) goto L32;
        return false;
    L17:
        if (r103 == false) goto L88;
        if (r104 == false) goto L88;
        if (this.f887a.m9175a(r100.f887a) == true) goto L23;
        return false;
    L8:
        if (r101 == false) goto L88;
        if (r102 == false) goto L88;
        if (this.f888a.equals(r100.f888a) == true) goto L14;
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
            case 1: goto L36;
            case 2: goto L33;
            case 3: goto L29;
            case 4: goto L26;
            case 5: goto L9;
            case 6: goto L23;
            case 7: goto L19;
            case 8: goto L16;
            case 9: goto L13;
            case 10: goto L10;
            default: goto L9;
        };
    L9:
        ic.a(r100, r102);
    L39:
        r100.g();
        goto L3
    L10:
        if (r102 != 11) goto L12;
        this.f895g = r100.mo9276a();
        goto L39
    L12:
        ic.a(r100, r102);
        goto L39
    L13:
        if (r102 != 11) goto L15;
        this.f894f = r100.mo9276a();
        goto L39
    L15:
        ic.a(r100, r102);
        goto L39
    L16:
        if (r102 != 11) goto L18;
        this.f893e = r100.mo9276a();
        goto L39
    L18:
        ic.a(r100, r102);
        goto L39
    L19:
        if (r102 != 11) goto L21;
        this.f892d = r100.mo9276a();
        goto L39
    L21:
        ic.a(r100, r102);
        goto L39
    L26:
        if (r102 != 11) goto L28;
        this.f891c = r100.mo9276a();
        goto L39
    L28:
        ic.a(r100, r102);
        goto L39
    L29:
        if (r102 != 11) goto L31;
        this.f890b = r100.mo9276a();
        goto L39
    L31:
        ic.a(r100, r102);
        goto L39
    L36:
        if (r102 != 11) goto L38;
        this.f888a = r100.mo9276a();
        goto L39
    L38:
        ic.a(r100, r102);
        goto L39
    L23:
        if (r102 != 10) goto L25;
        this.f886a = r100.mo9270a();
        a(true);
        goto L39
    L25:
        ic.a(r100, r102);
        goto L39
    L33:
        if (r102 != 12) goto L35;
        gt r103 = new gt();
        this.f887a = r103;
        r103.a(r100);
        goto L39
    L35:
        ic.a(r100, r102);
        goto L39
    L5:
        r100.f();
        m9247a();
    }

    public void a(boolean r100) {
        this.f889a.set(0, r100);
    }
}
