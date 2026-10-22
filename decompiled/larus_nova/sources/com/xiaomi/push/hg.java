package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* JADX INFO: loaded from: classes41.dex */
public class hg implements hp<hg, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final hw f464008a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final ie f853a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final hw f464009b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final hw f464010c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final hw f464011d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final hw f464012e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final hw f464013f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final hw f464014g = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f854a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public gt f855a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f856a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private BitSet f857a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f858b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public String f859c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public String f860d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public String f861e;

    public int hashCode() {
        return 0;
    }

    static {
        f853a = new ie("XmPushActionSendFeedbackResult");
        f464008a = new hw("", (byte) 11, 1);
        f464009b = new hw("", (byte) 12, 2);
        f464010c = new hw("", (byte) 11, 3);
        f464011d = new hw("", (byte) 11, 4);
        f464012e = new hw("", (byte) 10, 6);
        f464013f = new hw("", (byte) 11, 7);
        f464014g = new hw("", (byte) 11, 8);
    }

    public void a() {
        if (this.f858b == null) goto L10;
        if (this.f859c == null) goto L8;
        return;
    L8:
        throw new ia("Required field 'appId' was not present! Struct: " + toString());
    L10:
        throw new ia("Required field 'id' was not present! Struct: " + toString());
    }

    public boolean b() {
        if (this.f855a == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean c() {
        if (this.f858b == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean d() {
        if (this.f859c == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean e() {
        return this.f857a.get(0);
    }

    public boolean f() {
        if (this.f860d == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean g() {
        if (this.f861e == null) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("XmPushActionSendFeedbackResult(");
        boolean r101 = false;
        if (m9234a() == false) goto L9;
        r100.append("debug:");
        String r102 = this.f856a;
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
        gt r104 = this.f855a;
        if (r104 != null) goto L17;
        r100.append("null");
    L19:
        if (r101 == true) goto L21;
        r100.append(", ");
    L21:
        r100.append("id:");
        String r105 = this.f858b;
        if (r105 != null) goto L24;
        r100.append("null");
    L25:
        r100.append(", ");
        r100.append("appId:");
        String r106 = this.f859c;
        if (r106 != null) goto L28;
        r100.append("null");
    L29:
        r100.append(", ");
        r100.append("errorCode:");
        r100.append(this.f854a);
        if (f() == false) goto L36;
        r100.append(", ");
        r100.append("reason:");
        String r107 = this.f860d;
        if (r107 != null) goto L34;
        r100.append("null");
        goto L36
    L34:
        r100.append(r107);
    L36:
        if (g() == false) goto L41;
        r100.append(", ");
        r100.append("category:");
        String r108 = this.f861e;
        if (r108 != null) goto L40;
        r100.append("null");
        goto L41
    L40:
        r100.append(r108);
    L41:
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

    public hg() {
        this.f857a = new BitSet(1);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m9234a() {
        if (this.f856a == null) goto L5;
        return true;
    L5:
        return false;
    }

    public int a(hg r100) {
        if (getClass().equals(r100.getClass()) == false) goto L5;
        int r101 = Boolean.valueOf(m9234a()).compareTo(Boolean.valueOf(r100.m9234a()));
        if (r101 == 0) goto L10;
        return r101;
    L10:
        if (m9234a() == false) goto L14;
        int r102 = hq.a(this.f856a, r100.f856a);
        if (r102 == 0) goto L14;
        return r102;
    L14:
        int r103 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(r100.b()));
        if (r103 == 0) goto L18;
        return r103;
    L18:
        if (b() == false) goto L22;
        int r104 = hq.a(this.f855a, r100.f855a);
        if (r104 == 0) goto L22;
        return r104;
    L22:
        int r105 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(r100.c()));
        if (r105 == 0) goto L26;
        return r105;
    L26:
        if (c() == false) goto L30;
        int r106 = hq.a(this.f858b, r100.f858b);
        if (r106 == 0) goto L30;
        return r106;
    L30:
        int r107 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(r100.d()));
        if (r107 == 0) goto L34;
        return r107;
    L34:
        if (d() == false) goto L38;
        int r108 = hq.a(this.f859c, r100.f859c);
        if (r108 == 0) goto L38;
        return r108;
    L38:
        int r109 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(r100.e()));
        if (r109 == 0) goto L42;
        return r109;
    L42:
        if (e() == false) goto L46;
        int r110 = hq.a(this.f854a, r100.f854a);
        if (r110 == 0) goto L46;
        return r110;
    L46:
        int r111 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(r100.f()));
        if (r111 == 0) goto L50;
        return r111;
    L50:
        if (f() == false) goto L54;
        int r112 = hq.a(this.f860d, r100.f860d);
        if (r112 == 0) goto L54;
        return r112;
    L54:
        int r113 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(r100.g()));
        if (r113 == 0) goto L58;
        return r113;
    L58:
        if (g() == false) goto L62;
        int r114 = hq.a(this.f861e, r100.f861e);
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
        a();
        r100.a(f853a);
        if (this.f856a == null) goto L8;
        if (m9234a() == false) goto L8;
        r100.a(f464008a);
        r100.a(this.f856a);
        r100.b();
    L8:
        if (this.f855a == null) goto L13;
        if (b() == false) goto L13;
        r100.a(f464009b);
        this.f855a.b(r100);
        r100.b();
    L13:
        if (this.f858b == null) goto L16;
        r100.a(f464010c);
        r100.a(this.f858b);
        r100.b();
    L16:
        if (this.f859c == null) goto L18;
        r100.a(f464011d);
        r100.a(this.f859c);
        r100.b();
    L18:
        r100.a(f464012e);
        r100.a(this.f854a);
        r100.b();
        if (this.f860d == null) goto L24;
        if (f() == false) goto L24;
        r100.a(f464013f);
        r100.a(this.f860d);
        r100.b();
    L24:
        if (this.f861e != null) goto L26;
    L28:
        r100.c();
        r100.mo9279a();
        return;
    L26:
        if (g() == false) goto L28;
        r100.a(f464014g);
        r100.a(this.f861e);
        r100.b();
        goto L28
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(Object r100) {
        return a((hg) r100);
    }

    public boolean equals(Object r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if ((r100 instanceof hg) == true) goto L8;
        return false;
    L8:
        return m9235a((hg) r100);
    }

    @Override // com.xiaomi.push.hp
    public void a(hz r100) {
        r100.mo9275a();
    L3:
        hw r101 = r100.mo9271a();
        byte r102 = r101.f464095a;
        if (r102 == 0) goto L5;
        switch(r101.f951a) {
            case 1: goto L34;
            case 2: goto L31;
            case 3: goto L27;
            case 4: goto L24;
            case 5: goto L13;
            case 6: goto L21;
            case 7: goto L17;
            case 8: goto L14;
            default: goto L13;
        };
    L13:
        ic.a(r100, r102);
    L37:
        r100.g();
        goto L3
    L14:
        if (r102 != 11) goto L16;
        this.f861e = r100.mo9276a();
        goto L37
    L16:
        ic.a(r100, r102);
        goto L37
    L17:
        if (r102 != 11) goto L19;
        this.f860d = r100.mo9276a();
        goto L37
    L19:
        ic.a(r100, r102);
        goto L37
    L24:
        if (r102 != 11) goto L26;
        this.f859c = r100.mo9276a();
        goto L37
    L26:
        ic.a(r100, r102);
        goto L37
    L27:
        if (r102 != 11) goto L29;
        this.f858b = r100.mo9276a();
        goto L37
    L29:
        ic.a(r100, r102);
        goto L37
    L34:
        if (r102 != 11) goto L36;
        this.f856a = r100.mo9276a();
        goto L37
    L36:
        ic.a(r100, r102);
        goto L37
    L21:
        if (r102 != 10) goto L23;
        this.f854a = r100.mo9270a();
        a(true);
        goto L37
    L23:
        ic.a(r100, r102);
        goto L37
    L31:
        if (r102 != 12) goto L33;
        gt r103 = new gt();
        this.f855a = r103;
        r103.a(r100);
        goto L37
    L33:
        ic.a(r100, r102);
        goto L37
    L5:
        r100.f();
        if (e() == false) goto L10;
        a();
        return;
    L10:
        throw new ia("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m9235a(hg r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        boolean r101 = m9234a();
        boolean r102 = r100.m9234a();
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
        if (this.f854a == r100.f854a) goto L44;
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
        return true;
    L56:
        if (r111 == false) goto L64;
        if (r112 == false) goto L64;
        if (this.f861e.equals(r100.f861e) == true) goto L65;
        return false;
    L65:
        return true;
    L64:
        return false;
    L47:
        if (r109 == false) goto L64;
        if (r110 == false) goto L64;
        if (this.f860d.equals(r100.f860d) == true) goto L53;
        return false;
    L35:
        if (r107 == false) goto L64;
        if (r108 == false) goto L64;
        if (this.f859c.equals(r100.f859c) == true) goto L42;
        return false;
    L26:
        if (r105 == false) goto L64;
        if (r106 == false) goto L64;
        if (this.f858b.equals(r100.f858b) == true) goto L32;
        return false;
    L17:
        if (r103 == false) goto L64;
        if (r104 == false) goto L64;
        if (this.f855a.m9175a(r100.f855a) == true) goto L23;
        return false;
    L8:
        if (r101 == false) goto L64;
        if (r102 == false) goto L64;
        if (this.f856a.equals(r100.f856a) == true) goto L14;
        return false;
    }

    public void a(boolean r100) {
        this.f857a.set(0, r100);
    }
}
