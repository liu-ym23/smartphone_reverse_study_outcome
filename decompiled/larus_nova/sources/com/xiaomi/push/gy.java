package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes41.dex */
public class gy implements hp<gy, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final hw f463916a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final ie f745a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final hw f463917b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final hw f463918c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final hw f463919d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final hw f463920e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final hw f463921f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final hw f463922g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final hw f463923h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final hw f463924i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final hw f463925j = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f746a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public gt f747a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f748a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private BitSet f749a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<String> f750a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f751a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f752b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f753b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public String f754c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public String f755d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public String f756e;

    public int hashCode() {
        return 0;
    }

    static {
        f745a = new ie("XmPushActionCommand");
        f463916a = new hw("", (byte) 12, 2);
        f463917b = new hw("", (byte) 11, 3);
        f463918c = new hw("", (byte) 11, 4);
        f463919d = new hw("", (byte) 11, 5);
        f463920e = new hw("", (byte) 15, 6);
        f463921f = new hw("", (byte) 11, 7);
        f463922g = new hw("", (byte) 11, 9);
        f463923h = new hw("", (byte) 2, 10);
        f463924i = new hw("", (byte) 2, 11);
        f463925j = new hw("", (byte) 10, 12);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m9187a() {
        if (this.f748a == null) goto L14;
        if (this.f752b == null) goto L12;
        if (this.f754c == null) goto L10;
        return;
    L10:
        throw new ia("Required field 'cmdName' was not present! Struct: " + toString());
    L12:
        throw new ia("Required field 'appId' was not present! Struct: " + toString());
    L14:
        throw new ia("Required field 'id' was not present! Struct: " + toString());
    }

    public boolean b() {
        if (this.f748a == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean c() {
        if (this.f752b == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean d() {
        if (this.f754c == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean e() {
        if (this.f750a == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean f() {
        if (this.f755d == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean g() {
        if (this.f756e == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean h() {
        return this.f749a.get(0);
    }

    public boolean i() {
        return this.f749a.get(1);
    }

    public boolean j() {
        return this.f749a.get(2);
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("XmPushActionCommand(");
        if (m9189a() == false) goto L9;
        r100.append("target:");
        gt r101 = this.f747a;
        if (r101 != null) goto L7;
        r100.append("null");
    L8:
        boolean r102 = false;
    L11:
        if (r102 == true) goto L13;
        r100.append(", ");
    L13:
        r100.append("id:");
        String r103 = this.f748a;
        if (r103 != null) goto L16;
        r100.append("null");
    L17:
        r100.append(", ");
        r100.append("appId:");
        String r104 = this.f752b;
        if (r104 != null) goto L20;
        r100.append("null");
    L21:
        r100.append(", ");
        r100.append("cmdName:");
        String r105 = this.f754c;
        if (r105 != null) goto L24;
        r100.append("null");
    L26:
        if (e() == false) goto L32;
        r100.append(", ");
        r100.append("cmdArgs:");
        List<String> r106 = this.f750a;
        if (r106 != null) goto L30;
        r100.append("null");
        goto L32
    L30:
        r100.append(r106);
    L32:
        if (f() == false) goto L38;
        r100.append(", ");
        r100.append("packageName:");
        String r107 = this.f755d;
        if (r107 != null) goto L36;
        r100.append("null");
        goto L38
    L36:
        r100.append(r107);
    L38:
        if (g() == false) goto L44;
        r100.append(", ");
        r100.append("category:");
        String r108 = this.f756e;
        if (r108 != null) goto L42;
        r100.append("null");
        goto L44
    L42:
        r100.append(r108);
    L44:
        if (h() == false) goto L47;
        r100.append(", ");
        r100.append("updateCache:");
        r100.append(this.f751a);
    L47:
        if (i() == false) goto L50;
        r100.append(", ");
        r100.append("response2Client:");
        r100.append(this.f753b);
    L50:
        if (j() == false) goto L52;
        r100.append(", ");
        r100.append("createdTs:");
        r100.append(this.f746a);
    L52:
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

    public gy() {
        this.f749a = new BitSet(3);
        this.f751a = false;
        this.f753b = true;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m9189a() {
        if (this.f747a == null) goto L5;
        return true;
    L5:
        return false;
    }

    public String a() {
        return this.f754c;
    }

    public int a(gy r100) {
        if (getClass().equals(r100.getClass()) == false) goto L5;
        int r101 = Boolean.valueOf(m9189a()).compareTo(Boolean.valueOf(r100.m9189a()));
        if (r101 == 0) goto L10;
        return r101;
    L10:
        if (m9189a() == false) goto L14;
        int r102 = hq.a(this.f747a, r100.f747a);
        if (r102 == 0) goto L14;
        return r102;
    L14:
        int r103 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(r100.b()));
        if (r103 == 0) goto L18;
        return r103;
    L18:
        if (b() == false) goto L22;
        int r104 = hq.a(this.f748a, r100.f748a);
        if (r104 == 0) goto L22;
        return r104;
    L22:
        int r105 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(r100.c()));
        if (r105 == 0) goto L26;
        return r105;
    L26:
        if (c() == false) goto L30;
        int r106 = hq.a(this.f752b, r100.f752b);
        if (r106 == 0) goto L30;
        return r106;
    L30:
        int r107 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(r100.d()));
        if (r107 == 0) goto L34;
        return r107;
    L34:
        if (d() == false) goto L38;
        int r108 = hq.a(this.f754c, r100.f754c);
        if (r108 == 0) goto L38;
        return r108;
    L38:
        int r109 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(r100.e()));
        if (r109 == 0) goto L42;
        return r109;
    L42:
        if (e() == false) goto L46;
        int r110 = hq.a(this.f750a, r100.f750a);
        if (r110 == 0) goto L46;
        return r110;
    L46:
        int r111 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(r100.f()));
        if (r111 == 0) goto L50;
        return r111;
    L50:
        if (f() == false) goto L54;
        int r112 = hq.a(this.f755d, r100.f755d);
        if (r112 == 0) goto L54;
        return r112;
    L54:
        int r113 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(r100.g()));
        if (r113 == 0) goto L58;
        return r113;
    L58:
        if (g() == false) goto L62;
        int r114 = hq.a(this.f756e, r100.f756e);
        if (r114 == 0) goto L62;
        return r114;
    L62:
        int r115 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(r100.h()));
        if (r115 == 0) goto L66;
        return r115;
    L66:
        if (h() == false) goto L70;
        int r116 = hq.a(this.f751a, r100.f751a);
        if (r116 == 0) goto L70;
        return r116;
    L70:
        int r117 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(r100.i()));
        if (r117 == 0) goto L74;
        return r117;
    L74:
        if (i() == false) goto L78;
        int r118 = hq.a(this.f753b, r100.f753b);
        if (r118 == 0) goto L78;
        return r118;
    L78:
        int r119 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(r100.j()));
        if (r119 == 0) goto L82;
        return r119;
    L82:
        if (j() == false) goto L86;
        int r120 = hq.a(this.f746a, r100.f746a);
        if (r120 == 0) goto L88;
        return r120;
    L88:
        return 0;
    L86:
        return 0;
    L5:
        return getClass().getName().compareTo(r100.getClass().getName());
    }

    @Override // com.xiaomi.push.hp
    public void b(hz r100) {
        m9187a();
        r100.a(f745a);
        if (this.f747a == null) goto L8;
        if (m9189a() == false) goto L8;
        r100.a(f463916a);
        this.f747a.b(r100);
        r100.b();
    L8:
        if (this.f748a == null) goto L11;
        r100.a(f463917b);
        r100.a(this.f748a);
        r100.b();
    L11:
        if (this.f752b == null) goto L14;
        r100.a(f463918c);
        r100.a(this.f752b);
        r100.b();
    L14:
        if (this.f754c == null) goto L17;
        r100.a(f463919d);
        r100.a(this.f754c);
        r100.b();
    L17:
        if (this.f750a == null) goto L26;
        if (e() == false) goto L26;
        r100.a(f463920e);
        r100.a(new hx((byte) 11, this.f750a.size()));
        Iterator<String> r101 = this.f750a.iterator();
    L22:
        if (r101.hasNext() == false) goto L24;
        r100.a(r101.next());
        goto L22
    L24:
        r100.e();
        r100.b();
    L26:
        if (this.f755d == null) goto L31;
        if (f() == false) goto L31;
        r100.a(f463921f);
        r100.a(this.f755d);
        r100.b();
    L31:
        if (this.f756e == null) goto L36;
        if (g() == false) goto L36;
        r100.a(f463922g);
        r100.a(this.f756e);
        r100.b();
    L36:
        if (h() == false) goto L39;
        r100.a(f463923h);
        r100.a(this.f751a);
        r100.b();
    L39:
        if (i() == false) goto L42;
        r100.a(f463924i);
        r100.a(this.f753b);
        r100.b();
    L42:
        if (j() == false) goto L44;
        r100.a(f463925j);
        r100.a(this.f746a);
        r100.b();
    L44:
        r100.c();
        r100.mo9279a();
    }

    public void c(boolean r100) {
        this.f749a.set(2, r100);
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(Object r100) {
        return a((gy) r100);
    }

    public gy d(String r100) {
        this.f755d = r100;
        return this;
    }

    public gy e(String r100) {
        this.f756e = r100;
        return this;
    }

    public boolean equals(Object r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if ((r100 instanceof gy) == true) goto L8;
        return false;
    L8:
        return m9190a((gy) r100);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m9190a(gy r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        boolean r101 = m9189a();
        boolean r102 = r100.m9189a();
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
        return true;
    L89:
        if (r119 == false) goto L97;
        if (r120 == false) goto L97;
        if (this.f746a == r100.f746a) goto L98;
        return false;
    L98:
        return true;
    L97:
        return false;
    L80:
        if (r117 == false) goto L97;
        if (r118 == false) goto L97;
        if (this.f753b == r100.f753b) goto L86;
        return false;
    L71:
        if (r115 == false) goto L97;
        if (r116 == false) goto L97;
        if (this.f751a == r100.f751a) goto L77;
        return false;
    L62:
        if (r113 == false) goto L97;
        if (r114 == false) goto L97;
        if (this.f756e.equals(r100.f756e) == true) goto L68;
        return false;
    L53:
        if (r111 == false) goto L97;
        if (r112 == false) goto L97;
        if (this.f755d.equals(r100.f755d) == true) goto L59;
        return false;
    L44:
        if (r109 == false) goto L97;
        if (r110 == false) goto L97;
        if (this.f750a.equals(r100.f750a) == true) goto L50;
        return false;
    L35:
        if (r107 == false) goto L97;
        if (r108 == false) goto L97;
        if (this.f754c.equals(r100.f754c) == true) goto L41;
        return false;
    L26:
        if (r105 == false) goto L97;
        if (r106 == false) goto L97;
        if (this.f752b.equals(r100.f752b) == true) goto L32;
        return false;
    L17:
        if (r103 == false) goto L97;
        if (r104 == false) goto L97;
        if (this.f748a.equals(r100.f748a) == true) goto L23;
        return false;
    L8:
        if (r101 == false) goto L97;
        if (r102 == false) goto L97;
        if (this.f747a.m9175a(r100.f747a) == true) goto L14;
        return false;
    }

    public void b(boolean r100) {
        this.f749a.set(1, r100);
    }

    public gy c(String r100) {
        this.f754c = r100;
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
            case 2: goto L44;
            case 3: goto L40;
            case 4: goto L37;
            case 5: goto L34;
            case 6: goto L27;
            case 7: goto L23;
            case 8: goto L9;
            case 9: goto L20;
            case 10: goto L17;
            case 11: goto L14;
            case 12: goto L11;
            default: goto L9;
        };
    L9:
        ic.a(r100, r102);
    L47:
        r100.g();
        goto L3
    L14:
        if (r102 != 2) goto L16;
        this.f753b = r100.mo9281a();
        b(true);
        goto L47
    L16:
        ic.a(r100, r102);
        goto L47
    L17:
        if (r102 != 2) goto L19;
        this.f751a = r100.mo9281a();
        a(true);
        goto L47
    L19:
        ic.a(r100, r102);
        goto L47
    L20:
        if (r102 != 11) goto L22;
        this.f756e = r100.mo9276a();
        goto L47
    L22:
        ic.a(r100, r102);
        goto L47
    L23:
        if (r102 != 11) goto L25;
        this.f755d = r100.mo9276a();
        goto L47
    L25:
        ic.a(r100, r102);
        goto L47
    L34:
        if (r102 != 11) goto L36;
        this.f754c = r100.mo9276a();
        goto L47
    L36:
        ic.a(r100, r102);
        goto L47
    L37:
        if (r102 != 11) goto L39;
        this.f752b = r100.mo9276a();
        goto L47
    L39:
        ic.a(r100, r102);
        goto L47
    L40:
        if (r102 != 11) goto L42;
        this.f748a = r100.mo9276a();
        goto L47
    L42:
        ic.a(r100, r102);
        goto L47
    L11:
        if (r102 != 10) goto L13;
        this.f746a = r100.mo9270a();
        c(true);
        goto L47
    L13:
        ic.a(r100, r102);
        goto L47
    L27:
        if (r102 != 15) goto L33;
        hx r103 = r100.mo9272a();
        this.f750a = new ArrayList(r103.f952a);
        int r104 = 0;
    L30:
        if (r104 >= r103.f952a) goto L32;
        String r105 = r100.mo9276a();
        this.f750a.add(r105);
        r104 = r104 + 1;
        goto L30
    L32:
        r100.i();
        goto L47
    L33:
        ic.a(r100, r102);
        goto L47
    L44:
        if (r102 != 12) goto L46;
        gt r106 = new gt();
        this.f747a = r106;
        r106.a(r100);
        goto L47
    L46:
        ic.a(r100, r102);
        goto L47
    L5:
        r100.f();
        m9187a();
    }

    public gy b(String r100) {
        this.f752b = r100;
        return this;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m9188a(String r100) {
        if (this.f750a != null) goto L5;
        this.f750a = new ArrayList();
    L5:
        this.f750a.add(r100);
    }

    public void a(boolean r100) {
        this.f749a.set(0, r100);
    }

    public gy a(String r100) {
        this.f748a = r100;
        return this;
    }
}
