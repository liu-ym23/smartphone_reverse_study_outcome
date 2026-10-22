package com.xiaomi.push;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes41.dex */
public class gi implements hp<gi, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final hw f463699a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final ie f620a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final hw f463700b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final hw f463701c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final hw f463702d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final hw f463703e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final hw f463704f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final hw f463705g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final hw f463706h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final hw f463707i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final hw f463708j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final hw f463709k = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f621a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f622a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private BitSet f623a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Map<String, String> f624a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f625a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long f626b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f627b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public String f628c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public String f629d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public String f630e;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public String f631f;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public String f632g;

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m9133a() {
    }

    public int hashCode() {
        return 0;
    }

    static {
        f620a = new ie("ClientUploadDataItem");
        f463699a = new hw("", (byte) 11, 1);
        f463700b = new hw("", (byte) 11, 2);
        f463701c = new hw("", (byte) 11, 3);
        f463702d = new hw("", (byte) 10, 4);
        f463703e = new hw("", (byte) 10, 5);
        f463704f = new hw("", (byte) 2, 6);
        f463705g = new hw("", (byte) 11, 7);
        f463706h = new hw("", (byte) 11, 8);
        f463707i = new hw("", (byte) 11, 9);
        f463708j = new hw("", HTTP.CR, 10);
        f463709k = new hw("", (byte) 11, 11);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m9135a() {
        if (this.f622a == null) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public boolean m9137b() {
        if (this.f627b == null) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public boolean m9138c() {
        if (this.f628c == null) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: d, reason: collision with other method in class */
    public boolean m9139d() {
        return this.f623a.get(0);
    }

    /* JADX INFO: renamed from: e, reason: collision with other method in class */
    public boolean m9140e() {
        return this.f623a.get(1);
    }

    public boolean f() {
        return this.f623a.get(2);
    }

    public boolean g() {
        if (this.f629d == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean h() {
        if (this.f630e == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean i() {
        if (this.f631f == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean j() {
        if (this.f624a == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean k() {
        if (this.f632g == null) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("ClientUploadDataItem(");
        boolean r101 = false;
        if (m9135a() == false) goto L9;
        r100.append("channel:");
        String r102 = this.f622a;
        if (r102 != null) goto L7;
        r100.append("null");
    L8:
        boolean r103 = false;
    L11:
        if (m9137b() == false) goto L20;
        if (r103 == true) goto L14;
        r100.append(", ");
    L14:
        r100.append(fyb.a.KEY_DATA);
        String r104 = this.f627b;
        if (r104 != null) goto L17;
        r100.append("null");
    L18:
        r103 = false;
        goto L20
    L17:
        r100.append(r104);
    L20:
        if (m9138c() == false) goto L29;
        if (r103 == true) goto L23;
        r100.append(", ");
    L23:
        r100.append("name:");
        String r105 = this.f628c;
        if (r105 != null) goto L26;
        r100.append("null");
    L27:
        r103 = false;
        goto L29
    L26:
        r100.append(r105);
    L29:
        if (m9139d() == false) goto L34;
        if (r103 == true) goto L32;
        r100.append(", ");
    L32:
        r100.append("counter:");
        r100.append(this.f621a);
        r103 = false;
    L34:
        if (m9140e() == false) goto L39;
        if (r103 == true) goto L37;
        r100.append(", ");
    L37:
        r100.append("timestamp:");
        r100.append(this.f626b);
        r103 = false;
    L39:
        if (f() == false) goto L44;
        if (r103 == true) goto L42;
        r100.append(", ");
    L42:
        r100.append("fromSdk:");
        r100.append(this.f625a);
        r103 = false;
    L44:
        if (g() == false) goto L53;
        if (r103 == true) goto L47;
        r100.append(", ");
    L47:
        r100.append("category:");
        String r106 = this.f629d;
        if (r106 != null) goto L50;
        r100.append("null");
    L51:
        r103 = false;
        goto L53
    L50:
        r100.append(r106);
    L53:
        if (h() == false) goto L62;
        if (r103 == true) goto L56;
        r100.append(", ");
    L56:
        r100.append("sourcePackage:");
        String r107 = this.f630e;
        if (r107 != null) goto L59;
        r100.append("null");
    L60:
        r103 = false;
        goto L62
    L59:
        r100.append(r107);
    L62:
        if (i() == false) goto L71;
        if (r103 == true) goto L65;
        r100.append(", ");
    L65:
        r100.append("id:");
        String r108 = this.f631f;
        if (r108 != null) goto L68;
        r100.append("null");
    L69:
        r103 = false;
        goto L71
    L68:
        r100.append(r108);
    L71:
        if (j() == false) goto L78;
        if (r103 == true) goto L74;
        r100.append(", ");
    L74:
        r100.append("extra:");
        Map<String, String> r109 = this.f624a;
        if (r109 != null) goto L77;
        r100.append("null");
    L80:
        if (k() == false) goto L87;
        if (r101 == true) goto L83;
        r100.append(", ");
    L83:
        r100.append("pkgName:");
        String r110 = this.f632g;
        if (r110 != null) goto L86;
        r100.append("null");
        goto L87
    L86:
        r100.append(r110);
    L87:
        r100.append(")");
        return r100.toString();
    L77:
        r100.append(r109);
        goto L80
    L78:
        r101 = r103;
        goto L80
    L7:
        r100.append(r102);
        goto L8
    L9:
        r103 = true;
        goto L11
    }

    public gi() {
        this.f623a = new BitSet(3);
    }

    public long a() {
        return this.f626b;
    }

    public String b() {
        return this.f628c;
    }

    public String c() {
        return this.f630e;
    }

    public String d() {
        return this.f631f;
    }

    public String e() {
        return this.f632g;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m9131a() {
        return this.f622a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public Map<String, String> m9132a() {
        return this.f624a;
    }

    public int a(gi r100) {
        if (getClass().equals(r100.getClass()) == false) goto L5;
        int r101 = Boolean.valueOf(m9135a()).compareTo(Boolean.valueOf(r100.m9135a()));
        if (r101 == 0) goto L10;
        return r101;
    L10:
        if (m9135a() == false) goto L14;
        int r102 = hq.a(this.f622a, r100.f622a);
        if (r102 == 0) goto L14;
        return r102;
    L14:
        int r103 = Boolean.valueOf(m9137b()).compareTo(Boolean.valueOf(r100.m9137b()));
        if (r103 == 0) goto L18;
        return r103;
    L18:
        if (m9137b() == false) goto L22;
        int r104 = hq.a(this.f627b, r100.f627b);
        if (r104 == 0) goto L22;
        return r104;
    L22:
        int r105 = Boolean.valueOf(m9138c()).compareTo(Boolean.valueOf(r100.m9138c()));
        if (r105 == 0) goto L26;
        return r105;
    L26:
        if (m9138c() == false) goto L30;
        int r106 = hq.a(this.f628c, r100.f628c);
        if (r106 == 0) goto L30;
        return r106;
    L30:
        int r107 = Boolean.valueOf(m9139d()).compareTo(Boolean.valueOf(r100.m9139d()));
        if (r107 == 0) goto L34;
        return r107;
    L34:
        if (m9139d() == false) goto L38;
        int r108 = hq.a(this.f621a, r100.f621a);
        if (r108 == 0) goto L38;
        return r108;
    L38:
        int r109 = Boolean.valueOf(m9140e()).compareTo(Boolean.valueOf(r100.m9140e()));
        if (r109 == 0) goto L42;
        return r109;
    L42:
        if (m9140e() == false) goto L46;
        int r110 = hq.a(this.f626b, r100.f626b);
        if (r110 == 0) goto L46;
        return r110;
    L46:
        int r111 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(r100.f()));
        if (r111 == 0) goto L50;
        return r111;
    L50:
        if (f() == false) goto L54;
        int r112 = hq.a(this.f625a, r100.f625a);
        if (r112 == 0) goto L54;
        return r112;
    L54:
        int r113 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(r100.g()));
        if (r113 == 0) goto L58;
        return r113;
    L58:
        if (g() == false) goto L62;
        int r114 = hq.a(this.f629d, r100.f629d);
        if (r114 == 0) goto L62;
        return r114;
    L62:
        int r115 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(r100.h()));
        if (r115 == 0) goto L66;
        return r115;
    L66:
        if (h() == false) goto L70;
        int r116 = hq.a(this.f630e, r100.f630e);
        if (r116 == 0) goto L70;
        return r116;
    L70:
        int r117 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(r100.i()));
        if (r117 == 0) goto L74;
        return r117;
    L74:
        if (i() == false) goto L78;
        int r118 = hq.a(this.f631f, r100.f631f);
        if (r118 == 0) goto L78;
        return r118;
    L78:
        int r119 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(r100.j()));
        if (r119 == 0) goto L82;
        return r119;
    L82:
        if (j() == false) goto L86;
        int r120 = hq.a(this.f624a, r100.f624a);
        if (r120 == 0) goto L86;
        return r120;
    L86:
        int r121 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(r100.k()));
        if (r121 == 0) goto L90;
        return r121;
    L90:
        if (k() == false) goto L94;
        int r122 = hq.a(this.f632g, r100.f632g);
        if (r122 == 0) goto L96;
        return r122;
    L96:
        return 0;
    L94:
        return 0;
    L5:
        return getClass().getName().compareTo(r100.getClass().getName());
    }

    @Override // com.xiaomi.push.hp
    public void b(hz r100) {
        m9133a();
        r100.a(f620a);
        if (this.f622a == null) goto L8;
        if (m9135a() == false) goto L8;
        r100.a(f463699a);
        r100.a(this.f622a);
        r100.b();
    L8:
        if (this.f627b == null) goto L13;
        if (m9137b() == false) goto L13;
        r100.a(f463700b);
        r100.a(this.f627b);
        r100.b();
    L13:
        if (this.f628c == null) goto L18;
        if (m9138c() == false) goto L18;
        r100.a(f463701c);
        r100.a(this.f628c);
        r100.b();
    L18:
        if (m9139d() == false) goto L21;
        r100.a(f463702d);
        r100.a(this.f621a);
        r100.b();
    L21:
        if (m9140e() == false) goto L24;
        r100.a(f463703e);
        r100.a(this.f626b);
        r100.b();
    L24:
        if (f() == false) goto L27;
        r100.a(f463704f);
        r100.a(this.f625a);
        r100.b();
    L27:
        if (this.f629d == null) goto L32;
        if (g() == false) goto L32;
        r100.a(f463705g);
        r100.a(this.f629d);
        r100.b();
    L32:
        if (this.f630e == null) goto L37;
        if (h() == false) goto L37;
        r100.a(f463706h);
        r100.a(this.f630e);
        r100.b();
    L37:
        if (this.f631f == null) goto L42;
        if (i() == false) goto L42;
        r100.a(f463707i);
        r100.a(this.f631f);
        r100.b();
    L42:
        if (this.f624a == null) goto L51;
        if (j() == false) goto L51;
        r100.a(f463708j);
        r100.a(new hy((byte) 11, (byte) 11, this.f624a.size()));
        Iterator<Map.Entry<String, String>> r101 = this.f624a.entrySet().iterator();
    L47:
        if (r101.hasNext() == false) goto L49;
        Map.Entry<String, String> r102 = r101.next();
        r100.a(r102.getKey());
        r100.a(r102.getValue());
        goto L47
    L49:
        r100.d();
        r100.b();
    L51:
        if (this.f632g != null) goto L53;
    L55:
        r100.c();
        r100.mo9279a();
        return;
    L53:
        if (k() == false) goto L55;
        r100.a(f463709k);
        r100.a(this.f632g);
        r100.b();
        goto L55
    }

    public void c(boolean r100) {
        this.f623a.set(2, r100);
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(Object r100) {
        return a((gi) r100);
    }

    public gi d(String r100) {
        this.f629d = r100;
        return this;
    }

    public gi e(String r100) {
        this.f630e = r100;
        return this;
    }

    public boolean equals(Object r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if ((r100 instanceof gi) == true) goto L8;
        return false;
    L8:
        return m9136a((gi) r100);
    }

    public gi f(String r100) {
        this.f631f = r100;
        return this;
    }

    public gi g(String r100) {
        this.f632g = r100;
        return this;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m9136a(gi r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        boolean r101 = m9135a();
        boolean r102 = r100.m9135a();
        if (r101 == true) goto L8;
        if (r102 == true) goto L8;
    L14:
        boolean r103 = m9137b();
        boolean r104 = r100.m9137b();
        if (r103 == true) goto L17;
        if (r104 == true) goto L17;
    L23:
        boolean r105 = m9138c();
        boolean r106 = r100.m9138c();
        if (r105 == true) goto L26;
        if (r106 == true) goto L26;
    L32:
        boolean r107 = m9139d();
        boolean r108 = r100.m9139d();
        if (r107 == true) goto L35;
        if (r108 == true) goto L35;
    L41:
        boolean r109 = m9140e();
        boolean r110 = r100.m9140e();
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
    L95:
        boolean r121 = k();
        boolean r122 = r100.k();
        if (r121 == true) goto L98;
        if (r122 == true) goto L98;
        return true;
    L98:
        if (r121 == false) goto L106;
        if (r122 == false) goto L106;
        if (this.f632g.equals(r100.f632g) == true) goto L107;
        return false;
    L107:
        return true;
    L106:
        return false;
    L89:
        if (r119 == false) goto L106;
        if (r120 == false) goto L106;
        if (this.f624a.equals(r100.f624a) == true) goto L95;
        return false;
    L80:
        if (r117 == false) goto L106;
        if (r118 == false) goto L106;
        if (this.f631f.equals(r100.f631f) == true) goto L86;
        return false;
    L71:
        if (r115 == false) goto L106;
        if (r116 == false) goto L106;
        if (this.f630e.equals(r100.f630e) == true) goto L77;
        return false;
    L62:
        if (r113 == false) goto L106;
        if (r114 == false) goto L106;
        if (this.f629d.equals(r100.f629d) == true) goto L68;
        return false;
    L53:
        if (r111 == false) goto L106;
        if (r112 == false) goto L106;
        if (this.f625a == r100.f625a) goto L59;
        return false;
    L44:
        if (r109 == false) goto L106;
        if (r110 == false) goto L106;
        if (this.f626b == r100.f626b) goto L50;
        return false;
    L35:
        if (r107 == false) goto L106;
        if (r108 == false) goto L106;
        if (this.f621a == r100.f621a) goto L41;
        return false;
    L26:
        if (r105 == false) goto L106;
        if (r106 == false) goto L106;
        if (this.f628c.equals(r100.f628c) == true) goto L32;
        return false;
    L17:
        if (r103 == false) goto L106;
        if (r104 == false) goto L106;
        if (this.f627b.equals(r100.f627b) == true) goto L23;
        return false;
    L8:
        if (r101 == false) goto L106;
        if (r102 == false) goto L106;
        if (this.f622a.equals(r100.f622a) == true) goto L14;
        return false;
    }

    public gi b(long r100) {
        this.f626b = r100;
        b(true);
        return this;
    }

    public gi c(String r100) {
        this.f628c = r100;
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
            case 1: goto L45;
            case 2: goto L42;
            case 3: goto L39;
            case 4: goto L36;
            case 5: goto L33;
            case 6: goto L30;
            case 7: goto L27;
            case 8: goto L24;
            case 9: goto L21;
            case 10: goto L14;
            case 11: goto L10;
            default: goto L9;
        };
    L9:
        ic.a(r100, r102);
    L48:
        r100.g();
        goto L3
    L10:
        if (r102 != 11) goto L12;
        this.f632g = r100.mo9276a();
        goto L48
    L12:
        ic.a(r100, r102);
        goto L48
    L21:
        if (r102 != 11) goto L23;
        this.f631f = r100.mo9276a();
        goto L48
    L23:
        ic.a(r100, r102);
        goto L48
    L24:
        if (r102 != 11) goto L26;
        this.f630e = r100.mo9276a();
        goto L48
    L26:
        ic.a(r100, r102);
        goto L48
    L27:
        if (r102 != 11) goto L29;
        this.f629d = r100.mo9276a();
        goto L48
    L29:
        ic.a(r100, r102);
        goto L48
    L30:
        if (r102 != 2) goto L32;
        this.f625a = r100.mo9281a();
        c(true);
        goto L48
    L32:
        ic.a(r100, r102);
        goto L48
    L33:
        if (r102 != 10) goto L35;
        this.f626b = r100.mo9270a();
        b(true);
        goto L48
    L35:
        ic.a(r100, r102);
        goto L48
    L36:
        if (r102 != 10) goto L38;
        this.f621a = r100.mo9270a();
        m9134a(true);
        goto L48
    L38:
        ic.a(r100, r102);
        goto L48
    L39:
        if (r102 != 11) goto L41;
        this.f628c = r100.mo9276a();
        goto L48
    L41:
        ic.a(r100, r102);
        goto L48
    L42:
        if (r102 != 11) goto L44;
        this.f627b = r100.mo9276a();
        goto L48
    L44:
        ic.a(r100, r102);
        goto L48
    L45:
        if (r102 != 11) goto L47;
        this.f622a = r100.mo9276a();
        goto L48
    L47:
        ic.a(r100, r102);
        goto L48
    L14:
        if (r102 != 13) goto L20;
        hy r103 = r100.mo9273a();
        this.f624a = new HashMap(r103.f953a * 2);
        int r104 = 0;
    L17:
        if (r104 >= r103.f953a) goto L19;
        String r105 = r100.mo9276a();
        String r106 = r100.mo9276a();
        this.f624a.put(r105, r106);
        r104 = r104 + 1;
        goto L17
    L19:
        r100.h();
        goto L48
    L20:
        ic.a(r100, r102);
        goto L48
    L5:
        r100.f();
        m9133a();
    }

    public void b(boolean r100) {
        this.f623a.set(1, r100);
    }

    public gi a(long r100) {
        this.f621a = r100;
        m9134a(true);
        return this;
    }

    public gi b(String r100) {
        this.f627b = r100;
        return this;
    }

    public gi a(boolean r100) {
        this.f625a = r100;
        c(true);
        return this;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m9134a(boolean r100) {
        this.f623a.set(0, r100);
    }

    public gi a(String r100) {
        this.f622a = r100;
        return this;
    }

    public gi a(Map<String, String> r100) {
        this.f624a = r100;
        return this;
    }

    public void a(String r100, String r101) {
        if (this.f624a != null) goto L5;
        this.f624a = new HashMap();
    L5:
        this.f624a.put(r100, r101);
    }
}
