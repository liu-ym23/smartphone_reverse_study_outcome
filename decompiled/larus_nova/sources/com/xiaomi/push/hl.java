package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* JADX INFO: loaded from: classes41.dex */
public class hl implements hp<hl, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final hw f464056a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final ie f910a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final hw f464057b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final hw f464058c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final hw f464059d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final hw f464060e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final hw f464061f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final hw f464062g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final hw f464063h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final hw f464064i = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f911a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public gt f912a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f913a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private BitSet f914a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long f915b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f916b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public long f917c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public String f918c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public String f919d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public String f920e;

    public int hashCode() {
        return 0;
    }

    static {
        f910a = new ie("XmPushActionUnRegistrationResult");
        f464056a = new hw("", (byte) 11, 1);
        f464057b = new hw("", (byte) 12, 2);
        f464058c = new hw("", (byte) 11, 3);
        f464059d = new hw("", (byte) 11, 4);
        f464060e = new hw("", (byte) 10, 6);
        f464061f = new hw("", (byte) 11, 7);
        f464062g = new hw("", (byte) 11, 8);
        f464063h = new hw("", (byte) 10, 9);
        f464064i = new hw("", (byte) 10, 10);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m9254a() {
        if (this.f916b == null) goto L10;
        if (this.f918c == null) goto L8;
        return;
    L8:
        throw new ia("Required field 'appId' was not present! Struct: " + toString());
    L10:
        throw new ia("Required field 'id' was not present! Struct: " + toString());
    }

    public boolean b() {
        if (this.f912a == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean c() {
        if (this.f916b == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean d() {
        if (this.f918c == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean e() {
        return this.f914a.get(0);
    }

    public boolean f() {
        if (this.f919d == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean g() {
        if (this.f920e == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean h() {
        return this.f914a.get(1);
    }

    public boolean i() {
        return this.f914a.get(2);
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("XmPushActionUnRegistrationResult(");
        boolean r101 = false;
        if (m9255a() == false) goto L9;
        r100.append("debug:");
        String r102 = this.f913a;
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
        gt r104 = this.f912a;
        if (r104 != null) goto L17;
        r100.append("null");
    L19:
        if (r101 == true) goto L21;
        r100.append(", ");
    L21:
        r100.append("id:");
        String r105 = this.f916b;
        if (r105 != null) goto L24;
        r100.append("null");
    L25:
        r100.append(", ");
        r100.append("appId:");
        String r106 = this.f918c;
        if (r106 != null) goto L28;
        r100.append("null");
    L29:
        r100.append(", ");
        r100.append("errorCode:");
        r100.append(this.f911a);
        if (f() == false) goto L36;
        r100.append(", ");
        r100.append("reason:");
        String r107 = this.f919d;
        if (r107 != null) goto L34;
        r100.append("null");
        goto L36
    L34:
        r100.append(r107);
    L36:
        if (g() == false) goto L42;
        r100.append(", ");
        r100.append("packageName:");
        String r108 = this.f920e;
        if (r108 != null) goto L40;
        r100.append("null");
        goto L42
    L40:
        r100.append(r108);
    L42:
        if (h() == false) goto L45;
        r100.append(", ");
        r100.append("unRegisteredAt:");
        r100.append(this.f915b);
    L45:
        if (i() == false) goto L47;
        r100.append(", ");
        r100.append("costTime:");
        r100.append(this.f917c);
    L47:
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

    public hl() {
        this.f914a = new BitSet(3);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m9255a() {
        if (this.f913a == null) goto L5;
        return true;
    L5:
        return false;
    }

    public String a() {
        return this.f920e;
    }

    public int a(hl r100) {
        if (getClass().equals(r100.getClass()) == false) goto L5;
        int r101 = Boolean.valueOf(m9255a()).compareTo(Boolean.valueOf(r100.m9255a()));
        if (r101 == 0) goto L10;
        return r101;
    L10:
        if (m9255a() == false) goto L14;
        int r102 = hq.a(this.f913a, r100.f913a);
        if (r102 == 0) goto L14;
        return r102;
    L14:
        int r103 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(r100.b()));
        if (r103 == 0) goto L18;
        return r103;
    L18:
        if (b() == false) goto L22;
        int r104 = hq.a(this.f912a, r100.f912a);
        if (r104 == 0) goto L22;
        return r104;
    L22:
        int r105 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(r100.c()));
        if (r105 == 0) goto L26;
        return r105;
    L26:
        if (c() == false) goto L30;
        int r106 = hq.a(this.f916b, r100.f916b);
        if (r106 == 0) goto L30;
        return r106;
    L30:
        int r107 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(r100.d()));
        if (r107 == 0) goto L34;
        return r107;
    L34:
        if (d() == false) goto L38;
        int r108 = hq.a(this.f918c, r100.f918c);
        if (r108 == 0) goto L38;
        return r108;
    L38:
        int r109 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(r100.e()));
        if (r109 == 0) goto L42;
        return r109;
    L42:
        if (e() == false) goto L46;
        int r110 = hq.a(this.f911a, r100.f911a);
        if (r110 == 0) goto L46;
        return r110;
    L46:
        int r111 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(r100.f()));
        if (r111 == 0) goto L50;
        return r111;
    L50:
        if (f() == false) goto L54;
        int r112 = hq.a(this.f919d, r100.f919d);
        if (r112 == 0) goto L54;
        return r112;
    L54:
        int r113 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(r100.g()));
        if (r113 == 0) goto L58;
        return r113;
    L58:
        if (g() == false) goto L62;
        int r114 = hq.a(this.f920e, r100.f920e);
        if (r114 == 0) goto L62;
        return r114;
    L62:
        int r115 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(r100.h()));
        if (r115 == 0) goto L66;
        return r115;
    L66:
        if (h() == false) goto L70;
        int r116 = hq.a(this.f915b, r100.f915b);
        if (r116 == 0) goto L70;
        return r116;
    L70:
        int r117 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(r100.i()));
        if (r117 == 0) goto L74;
        return r117;
    L74:
        if (i() == false) goto L78;
        int r118 = hq.a(this.f917c, r100.f917c);
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
        m9254a();
        r100.a(f910a);
        if (this.f913a == null) goto L8;
        if (m9255a() == false) goto L8;
        r100.a(f464056a);
        r100.a(this.f913a);
        r100.b();
    L8:
        if (this.f912a == null) goto L13;
        if (b() == false) goto L13;
        r100.a(f464057b);
        this.f912a.b(r100);
        r100.b();
    L13:
        if (this.f916b == null) goto L16;
        r100.a(f464058c);
        r100.a(this.f916b);
        r100.b();
    L16:
        if (this.f918c == null) goto L18;
        r100.a(f464059d);
        r100.a(this.f918c);
        r100.b();
    L18:
        r100.a(f464060e);
        r100.a(this.f911a);
        r100.b();
        if (this.f919d == null) goto L24;
        if (f() == false) goto L24;
        r100.a(f464061f);
        r100.a(this.f919d);
        r100.b();
    L24:
        if (this.f920e == null) goto L29;
        if (g() == false) goto L29;
        r100.a(f464062g);
        r100.a(this.f920e);
        r100.b();
    L29:
        if (h() == false) goto L32;
        r100.a(f464063h);
        r100.a(this.f915b);
        r100.b();
    L32:
        if (i() == false) goto L34;
        r100.a(f464064i);
        r100.a(this.f917c);
        r100.b();
    L34:
        r100.c();
        r100.mo9279a();
    }

    public void c(boolean r100) {
        this.f914a.set(2, r100);
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(Object r100) {
        return a((hl) r100);
    }

    public boolean equals(Object r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if ((r100 instanceof hl) == true) goto L8;
        return false;
    L8:
        return m9256a((hl) r100);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m9256a(hl r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        boolean r101 = m9255a();
        boolean r102 = r100.m9255a();
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
        if (this.f911a == r100.f911a) goto L44;
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
        return true;
    L74:
        if (r115 == false) goto L82;
        if (r116 == false) goto L82;
        if (this.f917c == r100.f917c) goto L83;
        return false;
    L83:
        return true;
    L82:
        return false;
    L65:
        if (r113 == false) goto L82;
        if (r114 == false) goto L82;
        if (this.f915b == r100.f915b) goto L71;
        return false;
    L56:
        if (r111 == false) goto L82;
        if (r112 == false) goto L82;
        if (this.f920e.equals(r100.f920e) == true) goto L62;
        return false;
    L47:
        if (r109 == false) goto L82;
        if (r110 == false) goto L82;
        if (this.f919d.equals(r100.f919d) == true) goto L53;
        return false;
    L35:
        if (r107 == false) goto L82;
        if (r108 == false) goto L82;
        if (this.f918c.equals(r100.f918c) == true) goto L42;
        return false;
    L26:
        if (r105 == false) goto L82;
        if (r106 == false) goto L82;
        if (this.f916b.equals(r100.f916b) == true) goto L32;
        return false;
    L17:
        if (r103 == false) goto L82;
        if (r104 == false) goto L82;
        if (this.f912a.m9175a(r100.f912a) == true) goto L23;
        return false;
    L8:
        if (r101 == false) goto L82;
        if (r102 == false) goto L82;
        if (this.f913a.equals(r100.f913a) == true) goto L14;
        return false;
    }

    public void b(boolean r100) {
        this.f914a.set(1, r100);
    }

    @Override // com.xiaomi.push.hp
    public void a(hz r100) {
        r100.mo9275a();
    L3:
        hw r101 = r100.mo9271a();
        byte r102 = r101.f464095a;
        if (r102 == 0) goto L5;
        switch(r101.f951a) {
            case 1: goto L39;
            case 2: goto L36;
            case 3: goto L32;
            case 4: goto L29;
            case 5: goto L13;
            case 6: goto L26;
            case 7: goto L23;
            case 8: goto L20;
            case 9: goto L17;
            case 10: goto L14;
            default: goto L13;
        };
    L13:
        ic.a(r100, r102);
    L42:
        r100.g();
        goto L3
    L14:
        if (r102 != 10) goto L16;
        this.f917c = r100.mo9270a();
        c(true);
        goto L42
    L16:
        ic.a(r100, r102);
        goto L42
    L17:
        if (r102 != 10) goto L19;
        this.f915b = r100.mo9270a();
        b(true);
        goto L42
    L19:
        ic.a(r100, r102);
        goto L42
    L20:
        if (r102 != 11) goto L22;
        this.f920e = r100.mo9276a();
        goto L42
    L22:
        ic.a(r100, r102);
        goto L42
    L23:
        if (r102 != 11) goto L25;
        this.f919d = r100.mo9276a();
        goto L42
    L25:
        ic.a(r100, r102);
        goto L42
    L26:
        if (r102 != 10) goto L28;
        this.f911a = r100.mo9270a();
        a(true);
        goto L42
    L28:
        ic.a(r100, r102);
        goto L42
    L29:
        if (r102 != 11) goto L31;
        this.f918c = r100.mo9276a();
        goto L42
    L31:
        ic.a(r100, r102);
        goto L42
    L32:
        if (r102 != 11) goto L34;
        this.f916b = r100.mo9276a();
        goto L42
    L34:
        ic.a(r100, r102);
        goto L42
    L39:
        if (r102 != 11) goto L41;
        this.f913a = r100.mo9276a();
        goto L42
    L41:
        ic.a(r100, r102);
        goto L42
    L36:
        if (r102 != 12) goto L38;
        gt r103 = new gt();
        this.f912a = r103;
        r103.a(r100);
        goto L42
    L38:
        ic.a(r100, r102);
        goto L42
    L5:
        r100.f();
        if (e() == false) goto L10;
        m9254a();
        return;
    L10:
        throw new ia("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
    }

    public void a(boolean r100) {
        this.f914a.set(0, r100);
    }
}
