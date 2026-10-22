package com.xiaomi.push;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;

/* JADX INFO: loaded from: classes41.dex */
public class ha implements hp<ha, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final hw f463937a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final ie f769a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final hw f463938b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final hw f463939c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final hw f463940d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final hw f463941e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final hw f463942f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final hw f463943g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final hw f463944h = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ge f770a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public gr f771a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public gt f772a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f773a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ByteBuffer f774a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private BitSet f775a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f776a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f777b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f778b;

    public int hashCode() {
        return 0;
    }

    static {
        f769a = new ie("XmPushActionContainer");
        f463937a = new hw("", (byte) 8, 1);
        f463938b = new hw("", (byte) 2, 2);
        f463939c = new hw("", (byte) 2, 3);
        f463940d = new hw("", (byte) 11, 4);
        f463941e = new hw("", (byte) 11, 5);
        f463942f = new hw("", (byte) 11, 6);
        f463943g = new hw("", (byte) 12, 7);
        f463944h = new hw("", (byte) 12, 8);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m9199a() {
        if (this.f770a == null) goto L14;
        if (this.f774a == null) goto L12;
        if (this.f772a == null) goto L10;
        return;
    L10:
        throw new ia("Required field 'target' was not present! Struct: " + toString());
    L12:
        throw new ia("Required field 'pushAction' was not present! Struct: " + toString());
    L14:
        throw new ia("Required field 'action' was not present! Struct: " + toString());
    }

    public boolean c() {
        return this.f775a.get(0);
    }

    public boolean d() {
        return this.f775a.get(1);
    }

    public boolean e() {
        if (this.f774a == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean f() {
        if (this.f773a == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean g() {
        if (this.f777b == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean h() {
        if (this.f772a == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean i() {
        if (this.f771a == null) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("XmPushActionContainer(action:");
        ge r101 = this.f770a;
        if (r101 != null) goto L5;
        r100.append("null");
    L6:
        r100.append(", ");
        r100.append("encryptAction:");
        r100.append(this.f776a);
        r100.append(", ");
        r100.append("isRequest:");
        r100.append(this.f778b);
        if (f() == false) goto L13;
        r100.append(", ");
        r100.append("appid:");
        String r102 = this.f773a;
        if (r102 != null) goto L11;
        r100.append("null");
        goto L13
    L11:
        r100.append(r102);
    L13:
        if (g() == false) goto L18;
        r100.append(", ");
        r100.append("packageName:");
        String r103 = this.f777b;
        if (r103 != null) goto L17;
        r100.append("null");
        goto L18
    L17:
        r100.append(r103);
    L18:
        r100.append(", ");
        r100.append("target:");
        gt r104 = this.f772a;
        if (r104 != null) goto L21;
        r100.append("null");
    L23:
        if (i() == false) goto L28;
        r100.append(", ");
        r100.append("metaInfo:");
        gr r105 = this.f771a;
        if (r105 != null) goto L27;
        r100.append("null");
        goto L28
    L27:
        r100.append(r105);
    L28:
        r100.append(")");
        return r100.toString();
    L21:
        r100.append(r104);
        goto L23
    L5:
        r100.append(r101);
        goto L6
    }

    public ha() {
        this.f775a = new BitSet(2);
        this.f776a = true;
        this.f778b = true;
    }

    public String b() {
        return this.f777b;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public byte[] m9203a() {
        a(hq.a(this.f774a));
        return this.f774a.array();
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public boolean m9205b() {
        return this.f776a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m9201a() {
        if (this.f770a == null) goto L5;
        return true;
    L5:
        return false;
    }

    public ge a() {
        return this.f770a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public gr m9197a() {
        return this.f771a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m9198a() {
        return this.f773a;
    }

    public int a(ha r100) {
        if (getClass().equals(r100.getClass()) == false) goto L5;
        int r101 = Boolean.valueOf(m9201a()).compareTo(Boolean.valueOf(r100.m9201a()));
        if (r101 == 0) goto L10;
        return r101;
    L10:
        if (m9201a() == false) goto L14;
        int r102 = hq.a(this.f770a, r100.f770a);
        if (r102 == 0) goto L14;
        return r102;
    L14:
        int r103 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(r100.c()));
        if (r103 == 0) goto L18;
        return r103;
    L18:
        if (c() == false) goto L22;
        int r104 = hq.a(this.f776a, r100.f776a);
        if (r104 == 0) goto L22;
        return r104;
    L22:
        int r105 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(r100.d()));
        if (r105 == 0) goto L26;
        return r105;
    L26:
        if (d() == false) goto L30;
        int r106 = hq.a(this.f778b, r100.f778b);
        if (r106 == 0) goto L30;
        return r106;
    L30:
        int r107 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(r100.e()));
        if (r107 == 0) goto L34;
        return r107;
    L34:
        if (e() == false) goto L38;
        int r108 = hq.a(this.f774a, r100.f774a);
        if (r108 == 0) goto L38;
        return r108;
    L38:
        int r109 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(r100.f()));
        if (r109 == 0) goto L42;
        return r109;
    L42:
        if (f() == false) goto L46;
        int r110 = hq.a(this.f773a, r100.f773a);
        if (r110 == 0) goto L46;
        return r110;
    L46:
        int r111 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(r100.g()));
        if (r111 == 0) goto L50;
        return r111;
    L50:
        if (g() == false) goto L54;
        int r112 = hq.a(this.f777b, r100.f777b);
        if (r112 == 0) goto L54;
        return r112;
    L54:
        int r113 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(r100.h()));
        if (r113 == 0) goto L58;
        return r113;
    L58:
        if (h() == false) goto L62;
        int r114 = hq.a(this.f772a, r100.f772a);
        if (r114 == 0) goto L62;
        return r114;
    L62:
        int r115 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(r100.i()));
        if (r115 == 0) goto L66;
        return r115;
    L66:
        if (i() == false) goto L70;
        int r116 = hq.a(this.f771a, r100.f771a);
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
        m9199a();
        r100.a(f769a);
        if (this.f770a == null) goto L5;
        r100.a(f463937a);
        r100.mo9280a(this.f770a.a());
        r100.b();
    L5:
        r100.a(f463938b);
        r100.a(this.f776a);
        r100.b();
        r100.a(f463939c);
        r100.a(this.f778b);
        r100.b();
        if (this.f774a == null) goto L9;
        r100.a(f463940d);
        r100.a(this.f774a);
        r100.b();
    L9:
        if (this.f773a == null) goto L14;
        if (f() == false) goto L14;
        r100.a(f463941e);
        r100.a(this.f773a);
        r100.b();
    L14:
        if (this.f777b == null) goto L19;
        if (g() == false) goto L19;
        r100.a(f463942f);
        r100.a(this.f777b);
        r100.b();
    L19:
        if (this.f772a == null) goto L22;
        r100.a(f463943g);
        this.f772a.b(r100);
        r100.b();
    L22:
        if (this.f771a != null) goto L24;
    L26:
        r100.c();
        r100.mo9279a();
        return;
    L24:
        if (i() == false) goto L26;
        r100.a(f463944h);
        this.f771a.b(r100);
        r100.b();
        goto L26
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(Object r100) {
        return a((ha) r100);
    }

    public boolean equals(Object r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if ((r100 instanceof ha) == true) goto L8;
        return false;
    L8:
        return m9202a((ha) r100);
    }

    @Override // com.xiaomi.push.hp
    public void a(hz r100) {
        r100.mo9275a();
    L3:
        hw r101 = r100.mo9271a();
        byte r102 = r101.f464095a;
        if (r102 == 0) goto L5;
        switch(r101.f951a) {
            case 1: goto L40;
            case 2: goto L36;
            case 3: goto L33;
            case 4: goto L30;
            case 5: goto L27;
            case 6: goto L24;
            case 7: goto L21;
            case 8: goto L18;
            default: goto L17;
        };
    L17:
        ic.a(r100, r102);
    L43:
        r100.g();
        goto L3
    L18:
        if (r102 != 12) goto L20;
        gr r103 = new gr();
        this.f771a = r103;
        r103.a(r100);
        goto L43
    L20:
        ic.a(r100, r102);
        goto L43
    L21:
        if (r102 != 12) goto L23;
        gt r104 = new gt();
        this.f772a = r104;
        r104.a(r100);
        goto L43
    L23:
        ic.a(r100, r102);
        goto L43
    L24:
        if (r102 != 11) goto L26;
        this.f777b = r100.mo9276a();
        goto L43
    L26:
        ic.a(r100, r102);
        goto L43
    L27:
        if (r102 != 11) goto L29;
        this.f773a = r100.mo9276a();
        goto L43
    L29:
        ic.a(r100, r102);
        goto L43
    L30:
        if (r102 != 11) goto L32;
        this.f774a = r100.mo9277a();
        goto L43
    L32:
        ic.a(r100, r102);
        goto L43
    L33:
        if (r102 != 2) goto L35;
        this.f778b = r100.mo9281a();
        m9204b(true);
        goto L43
    L35:
        ic.a(r100, r102);
        goto L43
    L36:
        if (r102 != 2) goto L38;
        this.f776a = r100.mo9281a();
        m9200a(true);
        goto L43
    L38:
        ic.a(r100, r102);
        goto L43
    L40:
        if (r102 != 8) goto L42;
        this.f770a = ge.a(r100.mo9269a());
        goto L43
    L42:
        ic.a(r100, r102);
        goto L43
    L5:
        r100.f();
        if (c() == false) goto L14;
        if (d() == false) goto L12;
        m9199a();
        return;
    L12:
        throw new ia("Required field 'isRequest' was not found in serialized data! Struct: " + toString());
    L14:
        throw new ia("Required field 'encryptAction' was not found in serialized data! Struct: " + toString());
    }

    public ha b(boolean r100) {
        this.f778b = r100;
        m9204b(true);
        return this;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m9202a(ha r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        boolean r101 = m9201a();
        boolean r102 = r100.m9201a();
        if (r101 == true) goto L8;
        if (r102 == true) goto L8;
    L15:
        if (this.f776a == r100.f776a) goto L18;
        return false;
    L18:
        if (this.f778b == r100.f778b) goto L20;
        return false;
    L20:
        boolean r103 = e();
        boolean r104 = r100.e();
        if (r103 == true) goto L23;
        if (r104 == true) goto L23;
    L29:
        boolean r105 = f();
        boolean r106 = r100.f();
        if (r105 == true) goto L32;
        if (r106 == true) goto L32;
    L38:
        boolean r107 = g();
        boolean r108 = r100.g();
        if (r107 == true) goto L41;
        if (r108 == true) goto L41;
    L47:
        boolean r109 = h();
        boolean r110 = r100.h();
        if (r109 == true) goto L50;
        if (r110 == true) goto L50;
    L56:
        boolean r111 = i();
        boolean r112 = r100.i();
        if (r111 == true) goto L59;
        if (r112 == true) goto L59;
        return true;
    L59:
        if (r111 == false) goto L67;
        if (r112 == false) goto L67;
        if (this.f771a.m9167a(r100.f771a) == true) goto L68;
        return false;
    L68:
        return true;
    L67:
        return false;
    L50:
        if (r109 == false) goto L67;
        if (r110 == false) goto L67;
        if (this.f772a.m9175a(r100.f772a) == true) goto L56;
        return false;
    L41:
        if (r107 == false) goto L67;
        if (r108 == false) goto L67;
        if (this.f777b.equals(r100.f777b) == true) goto L47;
        return false;
    L32:
        if (r105 == false) goto L67;
        if (r106 == false) goto L67;
        if (this.f773a.equals(r100.f773a) == true) goto L38;
        return false;
    L23:
        if (r103 == false) goto L67;
        if (r104 == false) goto L67;
        if (this.f774a.equals(r100.f774a) == true) goto L29;
        return false;
    L8:
        if (r101 == false) goto L67;
        if (r102 == false) goto L67;
        if (this.f770a.equals(r100.f770a) == true) goto L15;
        return false;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public void m9204b(boolean r100) {
        this.f775a.set(1, r100);
    }

    public ha a(boolean r100) {
        this.f776a = r100;
        m9200a(true);
        return this;
    }

    public ha b(String r100) {
        this.f777b = r100;
        return this;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m9200a(boolean r100) {
        this.f775a.set(0, r100);
    }

    public ha a(ge r100) {
        this.f770a = r100;
        return this;
    }

    public ha a(gr r100) {
        this.f771a = r100;
        return this;
    }

    public ha a(gt r100) {
        this.f772a = r100;
        return this;
    }

    public ha a(String r100) {
        this.f773a = r100;
        return this;
    }

    public ha a(ByteBuffer r100) {
        this.f774a = r100;
        return this;
    }
}
