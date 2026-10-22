package com.xiaomi.push;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes41.dex */
public class gv implements hp<gv, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final hw f463903a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final ie f727a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final hw f463904b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final hw f463905c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final hw f463906d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final hw f463907e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final hw f463908f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final hw f463909g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final hw f463910h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final hw f463911i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final hw f463912j = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f728a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public gt f729a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f730a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private BitSet f731a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Map<String, String> f732a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f733b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public String f734c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public String f735d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public String f736e;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public String f737f;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public String f738g;

    public int hashCode() {
        return 0;
    }

    static {
        f727a = new ie("XmPushActionAckNotification");
        f463903a = new hw("", (byte) 11, 1);
        f463904b = new hw("", (byte) 12, 2);
        f463905c = new hw("", (byte) 11, 3);
        f463906d = new hw("", (byte) 11, 4);
        f463907e = new hw("", (byte) 11, 5);
        f463908f = new hw("", (byte) 10, 7);
        f463909g = new hw("", (byte) 11, 8);
        f463910h = new hw("", HTTP.CR, 9);
        f463911i = new hw("", (byte) 11, 10);
        f463912j = new hw("", (byte) 11, 11);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m9179a() {
        if (this.f733b == null) goto L6;
        return;
    L6:
        throw new ia("Required field 'id' was not present! Struct: " + toString());
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public boolean m9182b() {
        if (this.f729a == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean c() {
        if (this.f733b == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean d() {
        if (this.f734c == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean e() {
        if (this.f735d == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean f() {
        return this.f731a.get(0);
    }

    public boolean g() {
        if (this.f736e == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean h() {
        if (this.f732a == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean i() {
        if (this.f737f == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean j() {
        if (this.f738g == null) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("XmPushActionAckNotification(");
        boolean r101 = false;
        if (m9180a() == false) goto L9;
        r100.append("debug:");
        String r102 = this.f730a;
        if (r102 != null) goto L7;
        r100.append("null");
    L8:
        boolean r103 = false;
    L11:
        if (m9182b() == false) goto L18;
        if (r103 == true) goto L14;
        r100.append(", ");
    L14:
        r100.append("target:");
        gt r104 = this.f729a;
        if (r104 != null) goto L17;
        r100.append("null");
    L19:
        if (r101 == true) goto L21;
        r100.append(", ");
    L21:
        r100.append("id:");
        String r105 = this.f733b;
        if (r105 != null) goto L24;
        r100.append("null");
    L26:
        if (d() == false) goto L32;
        r100.append(", ");
        r100.append("appId:");
        String r106 = this.f734c;
        if (r106 != null) goto L30;
        r100.append("null");
        goto L32
    L30:
        r100.append(r106);
    L32:
        if (e() == false) goto L38;
        r100.append(", ");
        r100.append("type:");
        String r107 = this.f735d;
        if (r107 != null) goto L36;
        r100.append("null");
        goto L38
    L36:
        r100.append(r107);
    L38:
        if (f() == false) goto L41;
        r100.append(", ");
        r100.append("errorCode:");
        r100.append(this.f728a);
    L41:
        if (g() == false) goto L47;
        r100.append(", ");
        r100.append("reason:");
        String r108 = this.f736e;
        if (r108 != null) goto L45;
        r100.append("null");
        goto L47
    L45:
        r100.append(r108);
    L47:
        if (h() == false) goto L53;
        r100.append(", ");
        r100.append("extra:");
        Map<String, String> r109 = this.f732a;
        if (r109 != null) goto L51;
        r100.append("null");
        goto L53
    L51:
        r100.append(r109);
    L53:
        if (i() == false) goto L59;
        r100.append(", ");
        r100.append("packageName:");
        String r110 = this.f737f;
        if (r110 != null) goto L57;
        r100.append("null");
        goto L59
    L57:
        r100.append(r110);
    L59:
        if (j() == false) goto L64;
        r100.append(", ");
        r100.append("category:");
        String r111 = this.f738g;
        if (r111 != null) goto L63;
        r100.append("null");
        goto L64
    L63:
        r100.append(r111);
    L64:
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

    public gv() {
        this.f731a = new BitSet(1);
        this.f728a = 0;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m9180a() {
        if (this.f730a == null) goto L5;
        return true;
    L5:
        return false;
    }

    public String b() {
        return this.f735d;
    }

    public String a() {
        return this.f733b;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public Map<String, String> m9178a() {
        return this.f732a;
    }

    public int a(gv r100) {
        if (getClass().equals(r100.getClass()) == false) goto L5;
        int r101 = Boolean.valueOf(m9180a()).compareTo(Boolean.valueOf(r100.m9180a()));
        if (r101 == 0) goto L10;
        return r101;
    L10:
        if (m9180a() == false) goto L14;
        int r102 = hq.a(this.f730a, r100.f730a);
        if (r102 == 0) goto L14;
        return r102;
    L14:
        int r103 = Boolean.valueOf(m9182b()).compareTo(Boolean.valueOf(r100.m9182b()));
        if (r103 == 0) goto L18;
        return r103;
    L18:
        if (m9182b() == false) goto L22;
        int r104 = hq.a(this.f729a, r100.f729a);
        if (r104 == 0) goto L22;
        return r104;
    L22:
        int r105 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(r100.c()));
        if (r105 == 0) goto L26;
        return r105;
    L26:
        if (c() == false) goto L30;
        int r106 = hq.a(this.f733b, r100.f733b);
        if (r106 == 0) goto L30;
        return r106;
    L30:
        int r107 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(r100.d()));
        if (r107 == 0) goto L34;
        return r107;
    L34:
        if (d() == false) goto L38;
        int r108 = hq.a(this.f734c, r100.f734c);
        if (r108 == 0) goto L38;
        return r108;
    L38:
        int r109 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(r100.e()));
        if (r109 == 0) goto L42;
        return r109;
    L42:
        if (e() == false) goto L46;
        int r110 = hq.a(this.f735d, r100.f735d);
        if (r110 == 0) goto L46;
        return r110;
    L46:
        int r111 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(r100.f()));
        if (r111 == 0) goto L50;
        return r111;
    L50:
        if (f() == false) goto L54;
        int r112 = hq.a(this.f728a, r100.f728a);
        if (r112 == 0) goto L54;
        return r112;
    L54:
        int r113 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(r100.g()));
        if (r113 == 0) goto L58;
        return r113;
    L58:
        if (g() == false) goto L62;
        int r114 = hq.a(this.f736e, r100.f736e);
        if (r114 == 0) goto L62;
        return r114;
    L62:
        int r115 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(r100.h()));
        if (r115 == 0) goto L66;
        return r115;
    L66:
        if (h() == false) goto L70;
        int r116 = hq.a(this.f732a, r100.f732a);
        if (r116 == 0) goto L70;
        return r116;
    L70:
        int r117 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(r100.i()));
        if (r117 == 0) goto L74;
        return r117;
    L74:
        if (i() == false) goto L78;
        int r118 = hq.a(this.f737f, r100.f737f);
        if (r118 == 0) goto L78;
        return r118;
    L78:
        int r119 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(r100.j()));
        if (r119 == 0) goto L82;
        return r119;
    L82:
        if (j() == false) goto L86;
        int r120 = hq.a(this.f738g, r100.f738g);
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
        m9179a();
        r100.a(f727a);
        if (this.f730a == null) goto L8;
        if (m9180a() == false) goto L8;
        r100.a(f463903a);
        r100.a(this.f730a);
        r100.b();
    L8:
        if (this.f729a == null) goto L13;
        if (m9182b() == false) goto L13;
        r100.a(f463904b);
        this.f729a.b(r100);
        r100.b();
    L13:
        if (this.f733b == null) goto L16;
        r100.a(f463905c);
        r100.a(this.f733b);
        r100.b();
    L16:
        if (this.f734c == null) goto L21;
        if (d() == false) goto L21;
        r100.a(f463906d);
        r100.a(this.f734c);
        r100.b();
    L21:
        if (this.f735d == null) goto L26;
        if (e() == false) goto L26;
        r100.a(f463907e);
        r100.a(this.f735d);
        r100.b();
    L26:
        if (f() == false) goto L29;
        r100.a(f463908f);
        r100.a(this.f728a);
        r100.b();
    L29:
        if (this.f736e == null) goto L34;
        if (g() == false) goto L34;
        r100.a(f463909g);
        r100.a(this.f736e);
        r100.b();
    L34:
        if (this.f732a == null) goto L43;
        if (h() == false) goto L43;
        r100.a(f463910h);
        r100.a(new hy((byte) 11, (byte) 11, this.f732a.size()));
        Iterator<Map.Entry<String, String>> r101 = this.f732a.entrySet().iterator();
    L39:
        if (r101.hasNext() == false) goto L41;
        Map.Entry<String, String> r102 = r101.next();
        r100.a(r102.getKey());
        r100.a(r102.getValue());
        goto L39
    L41:
        r100.d();
        r100.b();
    L43:
        if (this.f737f == null) goto L48;
        if (i() == false) goto L48;
        r100.a(f463911i);
        r100.a(this.f737f);
        r100.b();
    L48:
        if (this.f738g != null) goto L50;
    L52:
        r100.c();
        r100.mo9279a();
        return;
    L50:
        if (j() == false) goto L52;
        r100.a(f463912j);
        r100.a(this.f738g);
        r100.b();
        goto L52
    }

    public gv c(String r100) {
        this.f735d = r100;
        return this;
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(Object r100) {
        return a((gv) r100);
    }

    public gv d(String r100) {
        this.f736e = r100;
        return this;
    }

    public gv e(String r100) {
        this.f737f = r100;
        return this;
    }

    public boolean equals(Object r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if ((r100 instanceof gv) == true) goto L8;
        return false;
    L8:
        return m9181a((gv) r100);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m9181a(gv r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        boolean r101 = m9180a();
        boolean r102 = r100.m9180a();
        if (r101 == true) goto L8;
        if (r102 == true) goto L8;
    L14:
        boolean r103 = m9182b();
        boolean r104 = r100.m9182b();
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
        if (this.f738g.equals(r100.f738g) == true) goto L98;
        return false;
    L98:
        return true;
    L97:
        return false;
    L80:
        if (r117 == false) goto L97;
        if (r118 == false) goto L97;
        if (this.f737f.equals(r100.f737f) == true) goto L86;
        return false;
    L71:
        if (r115 == false) goto L97;
        if (r116 == false) goto L97;
        if (this.f732a.equals(r100.f732a) == true) goto L77;
        return false;
    L62:
        if (r113 == false) goto L97;
        if (r114 == false) goto L97;
        if (this.f736e.equals(r100.f736e) == true) goto L68;
        return false;
    L53:
        if (r111 == false) goto L97;
        if (r112 == false) goto L97;
        if (this.f728a == r100.f728a) goto L59;
        return false;
    L44:
        if (r109 == false) goto L97;
        if (r110 == false) goto L97;
        if (this.f735d.equals(r100.f735d) == true) goto L50;
        return false;
    L35:
        if (r107 == false) goto L97;
        if (r108 == false) goto L97;
        if (this.f734c.equals(r100.f734c) == true) goto L41;
        return false;
    L26:
        if (r105 == false) goto L97;
        if (r106 == false) goto L97;
        if (this.f733b.equals(r100.f733b) == true) goto L32;
        return false;
    L17:
        if (r103 == false) goto L97;
        if (r104 == false) goto L97;
        if (this.f729a.m9175a(r100.f729a) == true) goto L23;
        return false;
    L8:
        if (r101 == false) goto L97;
        if (r102 == false) goto L97;
        if (this.f730a.equals(r100.f730a) == true) goto L14;
        return false;
    }

    public gv b(String r100) {
        this.f734c = r100;
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
            case 1: goto L44;
            case 2: goto L41;
            case 3: goto L37;
            case 4: goto L34;
            case 5: goto L31;
            case 6: goto L9;
            case 7: goto L28;
            case 8: goto L24;
            case 9: goto L17;
            case 10: goto L13;
            case 11: goto L10;
            default: goto L9;
        };
    L9:
        ic.a(r100, r102);
    L47:
        r100.g();
        goto L3
    L10:
        if (r102 != 11) goto L12;
        this.f738g = r100.mo9276a();
        goto L47
    L12:
        ic.a(r100, r102);
        goto L47
    L13:
        if (r102 != 11) goto L15;
        this.f737f = r100.mo9276a();
        goto L47
    L15:
        ic.a(r100, r102);
        goto L47
    L24:
        if (r102 != 11) goto L26;
        this.f736e = r100.mo9276a();
        goto L47
    L26:
        ic.a(r100, r102);
        goto L47
    L31:
        if (r102 != 11) goto L33;
        this.f735d = r100.mo9276a();
        goto L47
    L33:
        ic.a(r100, r102);
        goto L47
    L34:
        if (r102 != 11) goto L36;
        this.f734c = r100.mo9276a();
        goto L47
    L36:
        ic.a(r100, r102);
        goto L47
    L37:
        if (r102 != 11) goto L39;
        this.f733b = r100.mo9276a();
        goto L47
    L39:
        ic.a(r100, r102);
        goto L47
    L44:
        if (r102 != 11) goto L46;
        this.f730a = r100.mo9276a();
        goto L47
    L46:
        ic.a(r100, r102);
        goto L47
    L17:
        if (r102 != 13) goto L23;
        hy r103 = r100.mo9273a();
        this.f732a = new HashMap(r103.f953a * 2);
        int r104 = 0;
    L20:
        if (r104 >= r103.f953a) goto L22;
        String r105 = r100.mo9276a();
        String r106 = r100.mo9276a();
        this.f732a.put(r105, r106);
        r104 = r104 + 1;
        goto L20
    L22:
        r100.h();
        goto L47
    L23:
        ic.a(r100, r102);
        goto L47
    L28:
        if (r102 != 10) goto L30;
        this.f728a = r100.mo9270a();
        a(true);
        goto L47
    L30:
        ic.a(r100, r102);
        goto L47
    L41:
        if (r102 != 12) goto L43;
        gt r107 = new gt();
        this.f729a = r107;
        r107.a(r100);
        goto L47
    L43:
        ic.a(r100, r102);
        goto L47
    L5:
        r100.f();
        m9179a();
    }

    public gv a(long r100) {
        this.f728a = r100;
        a(true);
        return this;
    }

    public void a(boolean r100) {
        this.f731a.set(0, r100);
    }

    public gv a(gt r100) {
        this.f729a = r100;
        return this;
    }

    public gv a(String r100) {
        this.f733b = r100;
        return this;
    }
}
