package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes41.dex */
public class gz implements hp<gz, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final hw f463926a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final ie f757a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final hw f463927b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final hw f463928c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final hw f463929d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final hw f463930e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final hw f463931f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final hw f463932g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final hw f463933h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final hw f463934i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final hw f463935j = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f758a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public gt f759a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f760a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private BitSet f761a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<String> f762a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f763a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f764b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public String f765c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public String f766d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public String f767e;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public String f768f;

    public int hashCode() {
        return 0;
    }

    static {
        f757a = new ie("XmPushActionCommandResult");
        f463926a = new hw("", (byte) 12, 2);
        f463927b = new hw("", (byte) 11, 3);
        f463928c = new hw("", (byte) 11, 4);
        f463929d = new hw("", (byte) 11, 5);
        f463930e = new hw("", (byte) 10, 7);
        f463931f = new hw("", (byte) 11, 8);
        f463932g = new hw("", (byte) 11, 9);
        f463933h = new hw("", (byte) 15, 10);
        f463934i = new hw("", (byte) 11, 12);
        f463935j = new hw("", (byte) 2, 13);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m9192a() {
        if (this.f760a == null) goto L14;
        if (this.f764b == null) goto L12;
        if (this.f765c == null) goto L10;
        return;
    L10:
        throw new ia("Required field 'cmdName' was not present! Struct: " + toString());
    L12:
        throw new ia("Required field 'appId' was not present! Struct: " + toString());
    L14:
        throw new ia("Required field 'id' was not present! Struct: " + toString());
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public boolean m9195b() {
        if (this.f760a == null) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public boolean m9196c() {
        if (this.f764b == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean d() {
        if (this.f765c == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean e() {
        return this.f761a.get(0);
    }

    public boolean f() {
        if (this.f766d == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean g() {
        if (this.f767e == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean h() {
        if (this.f762a == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean i() {
        if (this.f768f == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean j() {
        return this.f761a.get(1);
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("XmPushActionCommandResult(");
        if (m9193a() == false) goto L9;
        r100.append("target:");
        gt r101 = this.f759a;
        if (r101 != null) goto L7;
        r100.append("null");
    L8:
        boolean r102 = false;
    L11:
        if (r102 == true) goto L13;
        r100.append(", ");
    L13:
        r100.append("id:");
        String r103 = this.f760a;
        if (r103 != null) goto L16;
        r100.append("null");
    L17:
        r100.append(", ");
        r100.append("appId:");
        String r104 = this.f764b;
        if (r104 != null) goto L20;
        r100.append("null");
    L21:
        r100.append(", ");
        r100.append("cmdName:");
        String r105 = this.f765c;
        if (r105 != null) goto L24;
        r100.append("null");
    L25:
        r100.append(", ");
        r100.append("errorCode:");
        r100.append(this.f758a);
        if (f() == false) goto L32;
        r100.append(", ");
        r100.append("reason:");
        String r106 = this.f766d;
        if (r106 != null) goto L30;
        r100.append("null");
        goto L32
    L30:
        r100.append(r106);
    L32:
        if (g() == false) goto L38;
        r100.append(", ");
        r100.append("packageName:");
        String r107 = this.f767e;
        if (r107 != null) goto L36;
        r100.append("null");
        goto L38
    L36:
        r100.append(r107);
    L38:
        if (h() == false) goto L44;
        r100.append(", ");
        r100.append("cmdArgs:");
        List<String> r108 = this.f762a;
        if (r108 != null) goto L42;
        r100.append("null");
        goto L44
    L42:
        r100.append(r108);
    L44:
        if (i() == false) goto L50;
        r100.append(", ");
        r100.append("category:");
        String r109 = this.f768f;
        if (r109 != null) goto L48;
        r100.append("null");
        goto L50
    L48:
        r100.append(r109);
    L50:
        if (j() == false) goto L52;
        r100.append(", ");
        r100.append("response2Client:");
        r100.append(this.f763a);
    L52:
        r100.append(")");
        return r100.toString();
    L24:
        r100.append(r105);
        goto L25
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

    public gz() {
        this.f761a = new BitSet(2);
        this.f763a = true;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m9193a() {
        if (this.f759a == null) goto L5;
        return true;
    L5:
        return false;
    }

    public String b() {
        return this.f765c;
    }

    public String c() {
        return this.f768f;
    }

    public String a() {
        return this.f760a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public List<String> m9191a() {
        return this.f762a;
    }

    public int a(gz r100) {
        if (getClass().equals(r100.getClass()) == false) goto L5;
        int r101 = Boolean.valueOf(m9193a()).compareTo(Boolean.valueOf(r100.m9193a()));
        if (r101 == 0) goto L10;
        return r101;
    L10:
        if (m9193a() == false) goto L14;
        int r102 = hq.a(this.f759a, r100.f759a);
        if (r102 == 0) goto L14;
        return r102;
    L14:
        int r103 = Boolean.valueOf(m9195b()).compareTo(Boolean.valueOf(r100.m9195b()));
        if (r103 == 0) goto L18;
        return r103;
    L18:
        if (m9195b() == false) goto L22;
        int r104 = hq.a(this.f760a, r100.f760a);
        if (r104 == 0) goto L22;
        return r104;
    L22:
        int r105 = Boolean.valueOf(m9196c()).compareTo(Boolean.valueOf(r100.m9196c()));
        if (r105 == 0) goto L26;
        return r105;
    L26:
        if (m9196c() == false) goto L30;
        int r106 = hq.a(this.f764b, r100.f764b);
        if (r106 == 0) goto L30;
        return r106;
    L30:
        int r107 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(r100.d()));
        if (r107 == 0) goto L34;
        return r107;
    L34:
        if (d() == false) goto L38;
        int r108 = hq.a(this.f765c, r100.f765c);
        if (r108 == 0) goto L38;
        return r108;
    L38:
        int r109 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(r100.e()));
        if (r109 == 0) goto L42;
        return r109;
    L42:
        if (e() == false) goto L46;
        int r110 = hq.a(this.f758a, r100.f758a);
        if (r110 == 0) goto L46;
        return r110;
    L46:
        int r111 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(r100.f()));
        if (r111 == 0) goto L50;
        return r111;
    L50:
        if (f() == false) goto L54;
        int r112 = hq.a(this.f766d, r100.f766d);
        if (r112 == 0) goto L54;
        return r112;
    L54:
        int r113 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(r100.g()));
        if (r113 == 0) goto L58;
        return r113;
    L58:
        if (g() == false) goto L62;
        int r114 = hq.a(this.f767e, r100.f767e);
        if (r114 == 0) goto L62;
        return r114;
    L62:
        int r115 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(r100.h()));
        if (r115 == 0) goto L66;
        return r115;
    L66:
        if (h() == false) goto L70;
        int r116 = hq.a(this.f762a, r100.f762a);
        if (r116 == 0) goto L70;
        return r116;
    L70:
        int r117 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(r100.i()));
        if (r117 == 0) goto L74;
        return r117;
    L74:
        if (i() == false) goto L78;
        int r118 = hq.a(this.f768f, r100.f768f);
        if (r118 == 0) goto L78;
        return r118;
    L78:
        int r119 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(r100.j()));
        if (r119 == 0) goto L82;
        return r119;
    L82:
        if (j() == false) goto L86;
        int r120 = hq.a(this.f763a, r100.f763a);
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
        m9192a();
        r100.a(f757a);
        if (this.f759a == null) goto L8;
        if (m9193a() == false) goto L8;
        r100.a(f463926a);
        this.f759a.b(r100);
        r100.b();
    L8:
        if (this.f760a == null) goto L11;
        r100.a(f463927b);
        r100.a(this.f760a);
        r100.b();
    L11:
        if (this.f764b == null) goto L14;
        r100.a(f463928c);
        r100.a(this.f764b);
        r100.b();
    L14:
        if (this.f765c == null) goto L16;
        r100.a(f463929d);
        r100.a(this.f765c);
        r100.b();
    L16:
        r100.a(f463930e);
        r100.a(this.f758a);
        r100.b();
        if (this.f766d == null) goto L22;
        if (f() == false) goto L22;
        r100.a(f463931f);
        r100.a(this.f766d);
        r100.b();
    L22:
        if (this.f767e == null) goto L27;
        if (g() == false) goto L27;
        r100.a(f463932g);
        r100.a(this.f767e);
        r100.b();
    L27:
        if (this.f762a == null) goto L36;
        if (h() == false) goto L36;
        r100.a(f463933h);
        r100.a(new hx((byte) 11, this.f762a.size()));
        Iterator<String> r101 = this.f762a.iterator();
    L32:
        if (r101.hasNext() == false) goto L34;
        r100.a(r101.next());
        goto L32
    L34:
        r100.e();
        r100.b();
    L36:
        if (this.f768f == null) goto L41;
        if (i() == false) goto L41;
        r100.a(f463934i);
        r100.a(this.f768f);
        r100.b();
    L41:
        if (j() == false) goto L43;
        r100.a(f463935j);
        r100.a(this.f763a);
        r100.b();
    L43:
        r100.c();
        r100.mo9279a();
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(Object r100) {
        return a((gz) r100);
    }

    public boolean equals(Object r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if ((r100 instanceof gz) == true) goto L8;
        return false;
    L8:
        return m9194a((gz) r100);
    }

    @Override // com.xiaomi.push.hp
    public void a(hz r100) {
        r100.mo9275a();
    L3:
        hw r101 = r100.mo9271a();
        byte r102 = r101.f464095a;
        if (r102 == 0) goto L5;
        switch(r101.f951a) {
            case 2: goto L49;
            case 3: goto L45;
            case 4: goto L42;
            case 5: goto L39;
            case 6: goto L13;
            case 7: goto L36;
            case 8: goto L32;
            case 9: goto L29;
            case 10: goto L22;
            case 11: goto L13;
            case 12: goto L18;
            case 13: goto L15;
            default: goto L13;
        };
    L13:
        ic.a(r100, r102);
    L52:
        r100.g();
        goto L3
    L18:
        if (r102 != 11) goto L20;
        this.f768f = r100.mo9276a();
        goto L52
    L20:
        ic.a(r100, r102);
        goto L52
    L29:
        if (r102 != 11) goto L31;
        this.f767e = r100.mo9276a();
        goto L52
    L31:
        ic.a(r100, r102);
        goto L52
    L32:
        if (r102 != 11) goto L34;
        this.f766d = r100.mo9276a();
        goto L52
    L34:
        ic.a(r100, r102);
        goto L52
    L39:
        if (r102 != 11) goto L41;
        this.f765c = r100.mo9276a();
        goto L52
    L41:
        ic.a(r100, r102);
        goto L52
    L42:
        if (r102 != 11) goto L44;
        this.f764b = r100.mo9276a();
        goto L52
    L44:
        ic.a(r100, r102);
        goto L52
    L45:
        if (r102 != 11) goto L47;
        this.f760a = r100.mo9276a();
        goto L52
    L47:
        ic.a(r100, r102);
        goto L52
    L15:
        if (r102 != 2) goto L17;
        this.f763a = r100.mo9281a();
        b(true);
        goto L52
    L17:
        ic.a(r100, r102);
        goto L52
    L22:
        if (r102 != 15) goto L28;
        hx r103 = r100.mo9272a();
        this.f762a = new ArrayList(r103.f952a);
        int r104 = 0;
    L25:
        if (r104 >= r103.f952a) goto L27;
        this.f762a.add(r100.mo9276a());
        r104 = r104 + 1;
        goto L25
    L27:
        r100.i();
        goto L52
    L28:
        ic.a(r100, r102);
        goto L52
    L36:
        if (r102 != 10) goto L38;
        this.f758a = r100.mo9270a();
        a(true);
        goto L52
    L38:
        ic.a(r100, r102);
        goto L52
    L49:
        if (r102 != 12) goto L51;
        gt r105 = new gt();
        this.f759a = r105;
        r105.a(r100);
        goto L52
    L51:
        ic.a(r100, r102);
        goto L52
    L5:
        r100.f();
        if (e() == false) goto L10;
        m9192a();
        return;
    L10:
        throw new ia("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
    }

    public void b(boolean r100) {
        this.f761a.set(1, r100);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m9194a(gz r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        boolean r101 = m9193a();
        boolean r102 = r100.m9193a();
        if (r101 == true) goto L8;
        if (r102 == true) goto L8;
    L14:
        boolean r103 = m9195b();
        boolean r104 = r100.m9195b();
        if (r103 == true) goto L17;
        if (r104 == true) goto L17;
    L23:
        boolean r105 = m9196c();
        boolean r106 = r100.m9196c();
        if (r105 == true) goto L26;
        if (r106 == true) goto L26;
    L32:
        boolean r107 = d();
        boolean r108 = r100.d();
        if (r107 == true) goto L35;
        if (r108 == true) goto L35;
    L42:
        if (this.f758a == r100.f758a) goto L44;
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
        return true;
    L83:
        if (r117 == false) goto L91;
        if (r118 == false) goto L91;
        if (this.f763a == r100.f763a) goto L92;
        return false;
    L92:
        return true;
    L91:
        return false;
    L74:
        if (r115 == false) goto L91;
        if (r116 == false) goto L91;
        if (this.f768f.equals(r100.f768f) == true) goto L80;
        return false;
    L65:
        if (r113 == false) goto L91;
        if (r114 == false) goto L91;
        if (this.f762a.equals(r100.f762a) == true) goto L71;
        return false;
    L56:
        if (r111 == false) goto L91;
        if (r112 == false) goto L91;
        if (this.f767e.equals(r100.f767e) == true) goto L62;
        return false;
    L47:
        if (r109 == false) goto L91;
        if (r110 == false) goto L91;
        if (this.f766d.equals(r100.f766d) == true) goto L53;
        return false;
    L35:
        if (r107 == false) goto L91;
        if (r108 == false) goto L91;
        if (this.f765c.equals(r100.f765c) == true) goto L42;
        return false;
    L26:
        if (r105 == false) goto L91;
        if (r106 == false) goto L91;
        if (this.f764b.equals(r100.f764b) == true) goto L32;
        return false;
    L17:
        if (r103 == false) goto L91;
        if (r104 == false) goto L91;
        if (this.f760a.equals(r100.f760a) == true) goto L23;
        return false;
    L8:
        if (r101 == false) goto L91;
        if (r102 == false) goto L91;
        if (this.f759a.m9175a(r100.f759a) == true) goto L14;
        return false;
    }

    public void a(boolean r100) {
        this.f761a.set(0, r100);
    }
}
