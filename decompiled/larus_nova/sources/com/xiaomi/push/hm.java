package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes41.dex */
public class hm implements hp<hm, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final hw f464065a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final ie f921a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final hw f464066b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final hw f464067c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final hw f464068d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final hw f464069e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final hw f464070f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final hw f464071g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final hw f464072h = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public gt f922a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f923a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<String> f924a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f925b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public String f926c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public String f927d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public String f928e;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public String f929f;

    public int hashCode() {
        return 0;
    }

    static {
        f921a = new ie("XmPushActionUnSubscription");
        f464065a = new hw("", (byte) 11, 1);
        f464066b = new hw("", (byte) 12, 2);
        f464067c = new hw("", (byte) 11, 3);
        f464068d = new hw("", (byte) 11, 4);
        f464069e = new hw("", (byte) 11, 5);
        f464070f = new hw("", (byte) 11, 6);
        f464071g = new hw("", (byte) 11, 7);
        f464072h = new hw("", (byte) 15, 8);
    }

    public void a() {
        if (this.f925b == null) goto L14;
        if (this.f926c == null) goto L12;
        if (this.f927d == null) goto L10;
        return;
    L10:
        throw new ia("Required field 'topic' was not present! Struct: " + toString());
    L12:
        throw new ia("Required field 'appId' was not present! Struct: " + toString());
    L14:
        throw new ia("Required field 'id' was not present! Struct: " + toString());
    }

    public boolean b() {
        if (this.f922a == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean c() {
        if (this.f925b == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean d() {
        if (this.f926c == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean e() {
        if (this.f927d == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean f() {
        if (this.f928e == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean g() {
        if (this.f929f == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean h() {
        if (this.f924a == null) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("XmPushActionUnSubscription(");
        boolean r101 = false;
        if (m9257a() == false) goto L9;
        r100.append("debug:");
        String r102 = this.f923a;
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
        gt r104 = this.f922a;
        if (r104 != null) goto L17;
        r100.append("null");
    L19:
        if (r101 == true) goto L21;
        r100.append(", ");
    L21:
        r100.append("id:");
        String r105 = this.f925b;
        if (r105 != null) goto L24;
        r100.append("null");
    L25:
        r100.append(", ");
        r100.append("appId:");
        String r106 = this.f926c;
        if (r106 != null) goto L28;
        r100.append("null");
    L29:
        r100.append(", ");
        r100.append("topic:");
        String r107 = this.f927d;
        if (r107 != null) goto L32;
        r100.append("null");
    L34:
        if (f() == false) goto L40;
        r100.append(", ");
        r100.append("packageName:");
        String r108 = this.f928e;
        if (r108 != null) goto L38;
        r100.append("null");
        goto L40
    L38:
        r100.append(r108);
    L40:
        if (g() == false) goto L46;
        r100.append(", ");
        r100.append("category:");
        String r109 = this.f929f;
        if (r109 != null) goto L44;
        r100.append("null");
        goto L46
    L44:
        r100.append(r109);
    L46:
        if (h() == false) goto L51;
        r100.append(", ");
        r100.append("aliases:");
        List<String> r110 = this.f924a;
        if (r110 != null) goto L50;
        r100.append("null");
        goto L51
    L50:
        r100.append(r110);
    L51:
        r100.append(")");
        return r100.toString();
    L32:
        r100.append(r107);
        goto L34
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

    public hm() {
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m9257a() {
        if (this.f923a == null) goto L5;
        return true;
    L5:
        return false;
    }

    public int a(hm r100) {
        if (getClass().equals(r100.getClass()) == false) goto L5;
        int r101 = Boolean.valueOf(m9257a()).compareTo(Boolean.valueOf(r100.m9257a()));
        if (r101 == 0) goto L10;
        return r101;
    L10:
        if (m9257a() == false) goto L14;
        int r102 = hq.a(this.f923a, r100.f923a);
        if (r102 == 0) goto L14;
        return r102;
    L14:
        int r103 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(r100.b()));
        if (r103 == 0) goto L18;
        return r103;
    L18:
        if (b() == false) goto L22;
        int r104 = hq.a(this.f922a, r100.f922a);
        if (r104 == 0) goto L22;
        return r104;
    L22:
        int r105 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(r100.c()));
        if (r105 == 0) goto L26;
        return r105;
    L26:
        if (c() == false) goto L30;
        int r106 = hq.a(this.f925b, r100.f925b);
        if (r106 == 0) goto L30;
        return r106;
    L30:
        int r107 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(r100.d()));
        if (r107 == 0) goto L34;
        return r107;
    L34:
        if (d() == false) goto L38;
        int r108 = hq.a(this.f926c, r100.f926c);
        if (r108 == 0) goto L38;
        return r108;
    L38:
        int r109 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(r100.e()));
        if (r109 == 0) goto L42;
        return r109;
    L42:
        if (e() == false) goto L46;
        int r110 = hq.a(this.f927d, r100.f927d);
        if (r110 == 0) goto L46;
        return r110;
    L46:
        int r111 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(r100.f()));
        if (r111 == 0) goto L50;
        return r111;
    L50:
        if (f() == false) goto L54;
        int r112 = hq.a(this.f928e, r100.f928e);
        if (r112 == 0) goto L54;
        return r112;
    L54:
        int r113 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(r100.g()));
        if (r113 == 0) goto L58;
        return r113;
    L58:
        if (g() == false) goto L62;
        int r114 = hq.a(this.f929f, r100.f929f);
        if (r114 == 0) goto L62;
        return r114;
    L62:
        int r115 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(r100.h()));
        if (r115 == 0) goto L66;
        return r115;
    L66:
        if (h() == false) goto L70;
        int r116 = hq.a(this.f924a, r100.f924a);
        if (r116 == 0) goto L72;
        return r116;
    L72:
        return 0;
    L70:
        return 0;
    L5:
        return getClass().getName().compareTo(r100.getClass().getName());
    }

    @Override // com.xiaomi.push.hp
    public void b(hz r100) {
        a();
        r100.a(f921a);
        if (this.f923a == null) goto L8;
        if (m9257a() == false) goto L8;
        r100.a(f464065a);
        r100.a(this.f923a);
        r100.b();
    L8:
        if (this.f922a == null) goto L13;
        if (b() == false) goto L13;
        r100.a(f464066b);
        this.f922a.b(r100);
        r100.b();
    L13:
        if (this.f925b == null) goto L16;
        r100.a(f464067c);
        r100.a(this.f925b);
        r100.b();
    L16:
        if (this.f926c == null) goto L19;
        r100.a(f464068d);
        r100.a(this.f926c);
        r100.b();
    L19:
        if (this.f927d == null) goto L22;
        r100.a(f464069e);
        r100.a(this.f927d);
        r100.b();
    L22:
        if (this.f928e == null) goto L27;
        if (f() == false) goto L27;
        r100.a(f464070f);
        r100.a(this.f928e);
        r100.b();
    L27:
        if (this.f929f == null) goto L32;
        if (g() == false) goto L32;
        r100.a(f464071g);
        r100.a(this.f929f);
        r100.b();
    L32:
        if (this.f924a != null) goto L34;
    L40:
        r100.c();
        r100.mo9279a();
        return;
    L34:
        if (h() == false) goto L40;
        r100.a(f464072h);
        r100.a(new hx((byte) 11, this.f924a.size()));
        Iterator<String> r101 = this.f924a.iterator();
    L37:
        if (r101.hasNext() == false) goto L39;
        r100.a(r101.next());
        goto L37
    L39:
        r100.e();
        r100.b();
        goto L40
    }

    public hm c(String r100) {
        this.f927d = r100;
        return this;
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(Object r100) {
        return a((hm) r100);
    }

    public hm d(String r100) {
        this.f928e = r100;
        return this;
    }

    public hm e(String r100) {
        this.f929f = r100;
        return this;
    }

    public boolean equals(Object r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if ((r100 instanceof hm) == true) goto L8;
        return false;
    L8:
        return m9258a((hm) r100);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m9258a(hm r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        boolean r101 = m9257a();
        boolean r102 = r100.m9257a();
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
        return true;
    L71:
        if (r115 == false) goto L79;
        if (r116 == false) goto L79;
        if (this.f924a.equals(r100.f924a) == true) goto L80;
        return false;
    L80:
        return true;
    L79:
        return false;
    L62:
        if (r113 == false) goto L79;
        if (r114 == false) goto L79;
        if (this.f929f.equals(r100.f929f) == true) goto L68;
        return false;
    L53:
        if (r111 == false) goto L79;
        if (r112 == false) goto L79;
        if (this.f928e.equals(r100.f928e) == true) goto L59;
        return false;
    L44:
        if (r109 == false) goto L79;
        if (r110 == false) goto L79;
        if (this.f927d.equals(r100.f927d) == true) goto L50;
        return false;
    L35:
        if (r107 == false) goto L79;
        if (r108 == false) goto L79;
        if (this.f926c.equals(r100.f926c) == true) goto L41;
        return false;
    L26:
        if (r105 == false) goto L79;
        if (r106 == false) goto L79;
        if (this.f925b.equals(r100.f925b) == true) goto L32;
        return false;
    L17:
        if (r103 == false) goto L79;
        if (r104 == false) goto L79;
        if (this.f922a.m9175a(r100.f922a) == true) goto L23;
        return false;
    L8:
        if (r101 == false) goto L79;
        if (r102 == false) goto L79;
        if (this.f923a.equals(r100.f923a) == true) goto L14;
        return false;
    }

    public hm b(String r100) {
        this.f926c = r100;
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
            case 1: goto L37;
            case 2: goto L34;
            case 3: goto L30;
            case 4: goto L27;
            case 5: goto L24;
            case 6: goto L21;
            case 7: goto L18;
            case 8: goto L11;
            default: goto L9;
        };
    L9:
        ic.a(r100, r102);
    L40:
        r100.g();
        goto L3
    L18:
        if (r102 != 11) goto L20;
        this.f929f = r100.mo9276a();
        goto L40
    L20:
        ic.a(r100, r102);
        goto L40
    L21:
        if (r102 != 11) goto L23;
        this.f928e = r100.mo9276a();
        goto L40
    L23:
        ic.a(r100, r102);
        goto L40
    L24:
        if (r102 != 11) goto L26;
        this.f927d = r100.mo9276a();
        goto L40
    L26:
        ic.a(r100, r102);
        goto L40
    L27:
        if (r102 != 11) goto L29;
        this.f926c = r100.mo9276a();
        goto L40
    L29:
        ic.a(r100, r102);
        goto L40
    L30:
        if (r102 != 11) goto L32;
        this.f925b = r100.mo9276a();
        goto L40
    L32:
        ic.a(r100, r102);
        goto L40
    L37:
        if (r102 != 11) goto L39;
        this.f923a = r100.mo9276a();
        goto L40
    L39:
        ic.a(r100, r102);
        goto L40
    L11:
        if (r102 != 15) goto L17;
        hx r103 = r100.mo9272a();
        this.f924a = new ArrayList(r103.f952a);
        int r104 = 0;
    L14:
        if (r104 >= r103.f952a) goto L16;
        String r105 = r100.mo9276a();
        this.f924a.add(r105);
        r104 = r104 + 1;
        goto L14
    L16:
        r100.i();
        goto L40
    L17:
        ic.a(r100, r102);
        goto L40
    L34:
        if (r102 != 12) goto L36;
        gt r106 = new gt();
        this.f922a = r106;
        r106.a(r100);
        goto L40
    L36:
        ic.a(r100, r102);
        goto L40
    L5:
        r100.f();
        a();
    }

    public hm a(String r100) {
        this.f925b = r100;
        return this;
    }
}
