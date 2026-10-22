package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* JADX INFO: loaded from: classes41.dex */
public class gp implements hp<gp, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final hw f463836a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final ie f651a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final hw f463837b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final hw f463838c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final hw f463839d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final hw f463840e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final hw f463841f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final hw f463842g = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f652a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f653a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f654a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private BitSet f655a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f656a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f657b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f658b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public int f659c;

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m9150a() {
    }

    public int hashCode() {
        return 0;
    }

    static {
        f651a = new ie("OnlineConfigItem");
        f463836a = new hw("", (byte) 8, 1);
        f463837b = new hw("", (byte) 8, 2);
        f463838c = new hw("", (byte) 2, 3);
        f463839d = new hw("", (byte) 8, 4);
        f463840e = new hw("", (byte) 10, 5);
        f463841f = new hw("", (byte) 11, 6);
        f463842g = new hw("", (byte) 2, 7);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m9151a() {
        return this.f655a.get(0);
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public boolean m9153b() {
        return this.f655a.get(1);
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public boolean m9154c() {
        return this.f655a.get(2);
    }

    public boolean d() {
        return this.f655a.get(3);
    }

    public boolean e() {
        return this.f655a.get(4);
    }

    public boolean f() {
        if (this.f654a == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean h() {
        return this.f655a.get(5);
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("OnlineConfigItem(");
        boolean r101 = false;
        if (m9151a() == false) goto L5;
        r100.append("key:");
        r100.append(this.f652a);
        boolean r102 = false;
    L7:
        if (m9153b() == false) goto L12;
        if (r102 == true) goto L10;
        r100.append(", ");
    L10:
        r100.append("type:");
        r100.append(this.f657b);
        r102 = false;
    L12:
        if (m9154c() == false) goto L17;
        if (r102 == true) goto L15;
        r100.append(", ");
    L15:
        r100.append("clear:");
        r100.append(this.f656a);
        r102 = false;
    L17:
        if (d() == false) goto L22;
        if (r102 == true) goto L20;
        r100.append(", ");
    L20:
        r100.append("intValue:");
        r100.append(this.f659c);
        r102 = false;
    L22:
        if (e() == false) goto L27;
        if (r102 == true) goto L25;
        r100.append(", ");
    L25:
        r100.append("longValue:");
        r100.append(this.f653a);
        r102 = false;
    L27:
        if (f() == false) goto L34;
        if (r102 == true) goto L30;
        r100.append(", ");
    L30:
        r100.append("stringValue:");
        String r103 = this.f654a;
        if (r103 != null) goto L33;
        r100.append("null");
    L36:
        if (h() == false) goto L40;
        if (r101 == true) goto L39;
        r100.append(", ");
    L39:
        r100.append("boolValue:");
        r100.append(this.f658b);
    L40:
        r100.append(")");
        return r100.toString();
    L33:
        r100.append(r103);
        goto L36
    L34:
        r101 = r102;
        goto L36
    L5:
        r102 = true;
        goto L7
    }

    public gp() {
        this.f655a = new BitSet(6);
    }

    public boolean g() {
        return this.f658b;
    }

    public int a() {
        return this.f652a;
    }

    public int b() {
        return this.f657b;
    }

    public int c() {
        return this.f659c;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public long m9148a() {
        return this.f653a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m9149a() {
        return this.f654a;
    }

    public int a(gp r100) {
        if (getClass().equals(r100.getClass()) == false) goto L5;
        int r101 = Boolean.valueOf(m9151a()).compareTo(Boolean.valueOf(r100.m9151a()));
        if (r101 == 0) goto L10;
        return r101;
    L10:
        if (m9151a() == false) goto L14;
        int r102 = hq.a(this.f652a, r100.f652a);
        if (r102 == 0) goto L14;
        return r102;
    L14:
        int r103 = Boolean.valueOf(m9153b()).compareTo(Boolean.valueOf(r100.m9153b()));
        if (r103 == 0) goto L18;
        return r103;
    L18:
        if (m9153b() == false) goto L22;
        int r104 = hq.a(this.f657b, r100.f657b);
        if (r104 == 0) goto L22;
        return r104;
    L22:
        int r105 = Boolean.valueOf(m9154c()).compareTo(Boolean.valueOf(r100.m9154c()));
        if (r105 == 0) goto L26;
        return r105;
    L26:
        if (m9154c() == false) goto L30;
        int r106 = hq.a(this.f656a, r100.f656a);
        if (r106 == 0) goto L30;
        return r106;
    L30:
        int r107 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(r100.d()));
        if (r107 == 0) goto L34;
        return r107;
    L34:
        if (d() == false) goto L38;
        int r108 = hq.a(this.f659c, r100.f659c);
        if (r108 == 0) goto L38;
        return r108;
    L38:
        int r109 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(r100.e()));
        if (r109 == 0) goto L42;
        return r109;
    L42:
        if (e() == false) goto L46;
        int r110 = hq.a(this.f653a, r100.f653a);
        if (r110 == 0) goto L46;
        return r110;
    L46:
        int r111 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(r100.f()));
        if (r111 == 0) goto L50;
        return r111;
    L50:
        if (f() == false) goto L54;
        int r112 = hq.a(this.f654a, r100.f654a);
        if (r112 == 0) goto L54;
        return r112;
    L54:
        int r113 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(r100.h()));
        if (r113 == 0) goto L58;
        return r113;
    L58:
        if (h() == false) goto L62;
        int r114 = hq.a(this.f658b, r100.f658b);
        if (r114 == 0) goto L64;
        return r114;
    L64:
        return 0;
    L62:
        return 0;
    L5:
        return getClass().getName().compareTo(r100.getClass().getName());
    }

    @Override // com.xiaomi.push.hp
    public void b(hz r100) {
        m9150a();
        r100.a(f651a);
        if (m9151a() == false) goto L6;
        r100.a(f463836a);
        r100.mo9280a(this.f652a);
        r100.b();
    L6:
        if (m9153b() == false) goto L9;
        r100.a(f463837b);
        r100.mo9280a(this.f657b);
        r100.b();
    L9:
        if (m9154c() == false) goto L12;
        r100.a(f463838c);
        r100.a(this.f656a);
        r100.b();
    L12:
        if (d() == false) goto L15;
        r100.a(f463839d);
        r100.mo9280a(this.f659c);
        r100.b();
    L15:
        if (e() == false) goto L18;
        r100.a(f463840e);
        r100.a(this.f653a);
        r100.b();
    L18:
        if (this.f654a == null) goto L23;
        if (f() == false) goto L23;
        r100.a(f463841f);
        r100.a(this.f654a);
        r100.b();
    L23:
        if (h() == false) goto L25;
        r100.a(f463842g);
        r100.a(this.f658b);
        r100.b();
    L25:
        r100.c();
        r100.mo9279a();
    }

    public void c(boolean r100) {
        this.f655a.set(2, r100);
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(Object r100) {
        return a((gp) r100);
    }

    public void d(boolean r100) {
        this.f655a.set(3, r100);
    }

    public void e(boolean r100) {
        this.f655a.set(4, r100);
    }

    public boolean equals(Object r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if ((r100 instanceof gp) == true) goto L8;
        return false;
    L8:
        return m9152a((gp) r100);
    }

    public void f(boolean r100) {
        this.f655a.set(5, r100);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m9152a(gp r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        boolean r101 = m9151a();
        boolean r102 = r100.m9151a();
        if (r101 == true) goto L8;
        if (r102 == true) goto L8;
    L14:
        boolean r103 = m9153b();
        boolean r104 = r100.m9153b();
        if (r103 == true) goto L17;
        if (r104 == true) goto L17;
    L23:
        boolean r105 = m9154c();
        boolean r106 = r100.m9154c();
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
        boolean r113 = h();
        boolean r114 = r100.h();
        if (r113 == true) goto L62;
        if (r114 == true) goto L62;
        return true;
    L62:
        if (r113 == false) goto L70;
        if (r114 == false) goto L70;
        if (this.f658b == r100.f658b) goto L71;
        return false;
    L71:
        return true;
    L70:
        return false;
    L53:
        if (r111 == false) goto L70;
        if (r112 == false) goto L70;
        if (this.f654a.equals(r100.f654a) == true) goto L59;
        return false;
    L44:
        if (r109 == false) goto L70;
        if (r110 == false) goto L70;
        if (this.f653a == r100.f653a) goto L50;
        return false;
    L35:
        if (r107 == false) goto L70;
        if (r108 == false) goto L70;
        if (this.f659c == r100.f659c) goto L41;
        return false;
    L26:
        if (r105 == false) goto L70;
        if (r106 == false) goto L70;
        if (this.f656a == r100.f656a) goto L32;
        return false;
    L17:
        if (r103 == false) goto L70;
        if (r104 == false) goto L70;
        if (this.f657b == r100.f657b) goto L23;
        return false;
    L8:
        if (r101 == false) goto L70;
        if (r102 == false) goto L70;
        if (this.f652a == r100.f652a) goto L14;
        return false;
    }

    public void b(boolean r100) {
        this.f655a.set(1, r100);
    }

    @Override // com.xiaomi.push.hp
    public void a(hz r100) {
        r100.mo9275a();
    L3:
        hw r101 = r100.mo9271a();
        byte r102 = r101.f464095a;
        if (r102 == 0) goto L5;
        switch(r101.f951a) {
            case 1: goto L30;
            case 2: goto L27;
            case 3: goto L24;
            case 4: goto L21;
            case 5: goto L18;
            case 6: goto L14;
            case 7: goto L10;
            default: goto L9;
        };
    L9:
        ic.a(r100, r102);
    L33:
        r100.g();
        goto L3
    L10:
        if (r102 != 2) goto L12;
        this.f658b = r100.mo9281a();
        f(true);
        goto L33
    L12:
        ic.a(r100, r102);
        goto L33
    L21:
        if (r102 != 8) goto L23;
        this.f659c = r100.mo9269a();
        d(true);
        goto L33
    L23:
        ic.a(r100, r102);
        goto L33
    L24:
        if (r102 != 2) goto L26;
        this.f656a = r100.mo9281a();
        c(true);
        goto L33
    L26:
        ic.a(r100, r102);
        goto L33
    L27:
        if (r102 != 8) goto L29;
        this.f657b = r100.mo9269a();
        b(true);
        goto L33
    L29:
        ic.a(r100, r102);
        goto L33
    L30:
        if (r102 != 8) goto L32;
        this.f652a = r100.mo9269a();
        a(true);
        goto L33
    L32:
        ic.a(r100, r102);
        goto L33
    L14:
        if (r102 != 11) goto L16;
        this.f654a = r100.mo9276a();
        goto L33
    L16:
        ic.a(r100, r102);
        goto L33
    L18:
        if (r102 != 10) goto L20;
        this.f653a = r100.mo9270a();
        e(true);
        goto L33
    L20:
        ic.a(r100, r102);
        goto L33
    L5:
        r100.f();
        m9150a();
    }

    public void a(boolean r100) {
        this.f655a.set(0, r100);
    }
}
