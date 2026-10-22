package com.xiaomi.push;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes41.dex */
public class hd implements hp<hd, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final hw f463947a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final ie f783a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final hw f463948b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final hw f463949c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final hw f463950d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final hw f463951e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final hw f463952f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final hw f463953g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final hw f463954h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final hw f463955i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final hw f463956j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final hw f463957k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final hw f463958l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final hw f463959m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final hw f463960n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final hw f463961o = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f784a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public gt f785a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f786a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ByteBuffer f787a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private BitSet f788a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Map<String, String> f789a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f790a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f791b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f792b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public String f793c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public String f794d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public String f795e;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public String f796f;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public String f797g;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    public String f798h;

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    public String f799i;

    public int hashCode() {
        return 0;
    }

    static {
        f783a = new ie("XmPushActionNotification");
        f463947a = new hw("", (byte) 11, 1);
        f463948b = new hw("", (byte) 12, 2);
        f463949c = new hw("", (byte) 11, 3);
        f463950d = new hw("", (byte) 11, 4);
        f463951e = new hw("", (byte) 11, 5);
        f463952f = new hw("", (byte) 2, 6);
        f463953g = new hw("", (byte) 11, 7);
        f463954h = new hw("", HTTP.CR, 8);
        f463955i = new hw("", (byte) 11, 9);
        f463956j = new hw("", (byte) 11, 10);
        f463957k = new hw("", (byte) 11, 12);
        f463958l = new hw("", (byte) 11, 13);
        f463959m = new hw("", (byte) 11, 14);
        f463960n = new hw("", (byte) 10, 15);
        f463961o = new hw("", (byte) 2, 20);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m9214a() {
        if (this.f791b == null) goto L6;
        return;
    L6:
        throw new ia("Required field 'id' was not present! Struct: " + toString());
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public boolean m9219b() {
        if (this.f785a == null) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public boolean m9220c() {
        if (this.f791b == null) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: d, reason: collision with other method in class */
    public boolean m9221d() {
        if (this.f793c == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean e() {
        if (this.f794d == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean f() {
        return this.f788a.get(0);
    }

    public boolean g() {
        if (this.f795e == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean h() {
        if (this.f789a == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean i() {
        if (this.f796f == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean j() {
        if (this.f797g == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean k() {
        if (this.f798h == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean l() {
        if (this.f799i == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean m() {
        if (this.f787a == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean n() {
        return this.f788a.get(1);
    }

    public boolean o() {
        return this.f788a.get(2);
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("XmPushActionNotification(");
        boolean r101 = false;
        if (m9216a() == false) goto L9;
        r100.append("debug:");
        String r102 = this.f786a;
        if (r102 != null) goto L7;
        r100.append("null");
    L8:
        boolean r103 = false;
    L11:
        if (m9219b() == false) goto L18;
        if (r103 == true) goto L14;
        r100.append(", ");
    L14:
        r100.append("target:");
        gt r104 = this.f785a;
        if (r104 != null) goto L17;
        r100.append("null");
    L19:
        if (r101 == true) goto L21;
        r100.append(", ");
    L21:
        r100.append("id:");
        String r105 = this.f791b;
        if (r105 != null) goto L24;
        r100.append("null");
    L26:
        if (m9221d() == false) goto L32;
        r100.append(", ");
        r100.append("appId:");
        String r106 = this.f793c;
        if (r106 != null) goto L30;
        r100.append("null");
        goto L32
    L30:
        r100.append(r106);
    L32:
        if (e() == false) goto L37;
        r100.append(", ");
        r100.append("type:");
        String r107 = this.f794d;
        if (r107 != null) goto L36;
        r100.append("null");
        goto L37
    L36:
        r100.append(r107);
    L37:
        r100.append(", ");
        r100.append("requireAck:");
        r100.append(this.f790a);
        if (g() == false) goto L44;
        r100.append(", ");
        r100.append("payload:");
        String r108 = this.f795e;
        if (r108 != null) goto L42;
        r100.append("null");
        goto L44
    L42:
        r100.append(r108);
    L44:
        if (h() == false) goto L50;
        r100.append(", ");
        r100.append("extra:");
        Map<String, String> r109 = this.f789a;
        if (r109 != null) goto L48;
        r100.append("null");
        goto L50
    L48:
        r100.append(r109);
    L50:
        if (i() == false) goto L56;
        r100.append(", ");
        r100.append("packageName:");
        String r110 = this.f796f;
        if (r110 != null) goto L54;
        r100.append("null");
        goto L56
    L54:
        r100.append(r110);
    L56:
        if (j() == false) goto L62;
        r100.append(", ");
        r100.append("category:");
        String r111 = this.f797g;
        if (r111 != null) goto L60;
        r100.append("null");
        goto L62
    L60:
        r100.append(r111);
    L62:
        if (k() == false) goto L68;
        r100.append(", ");
        r100.append("regId:");
        String r112 = this.f798h;
        if (r112 != null) goto L66;
        r100.append("null");
        goto L68
    L66:
        r100.append(r112);
    L68:
        if (l() == false) goto L74;
        r100.append(", ");
        r100.append("aliasName:");
        String r113 = this.f799i;
        if (r113 != null) goto L72;
        r100.append("null");
        goto L74
    L72:
        r100.append(r113);
    L74:
        if (m() == false) goto L80;
        r100.append(", ");
        r100.append("binaryExtra:");
        ByteBuffer r114 = this.f787a;
        if (r114 != null) goto L78;
        r100.append("null");
        goto L80
    L78:
        hq.a(r114, r100);
    L80:
        if (n() == false) goto L83;
        r100.append(", ");
        r100.append("createdTs:");
        r100.append(this.f784a);
    L83:
        if (o() == false) goto L85;
        r100.append(", ");
        r100.append("alreadyLogClickInXmq:");
        r100.append(this.f792b);
    L85:
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

    public hd() {
        this.f788a = new BitSet(3);
        this.f790a = true;
        this.f792b = false;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public byte[] m9218a() {
        a(hq.a(this.f787a));
        return this.f787a.array();
    }

    public String b() {
        return this.f793c;
    }

    public String c() {
        return this.f794d;
    }

    public String d() {
        return this.f796f;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m9216a() {
        if (this.f786a == null) goto L5;
        return true;
    L5:
        return false;
    }

    public gt a() {
        return this.f785a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m9212a() {
        return this.f791b;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public Map<String, String> m9213a() {
        return this.f789a;
    }

    public int a(hd r100) {
        if (getClass().equals(r100.getClass()) == false) goto L5;
        int r101 = Boolean.valueOf(m9216a()).compareTo(Boolean.valueOf(r100.m9216a()));
        if (r101 == 0) goto L10;
        return r101;
    L10:
        if (m9216a() == false) goto L14;
        int r102 = hq.a(this.f786a, r100.f786a);
        if (r102 == 0) goto L14;
        return r102;
    L14:
        int r103 = Boolean.valueOf(m9219b()).compareTo(Boolean.valueOf(r100.m9219b()));
        if (r103 == 0) goto L18;
        return r103;
    L18:
        if (m9219b() == false) goto L22;
        int r104 = hq.a(this.f785a, r100.f785a);
        if (r104 == 0) goto L22;
        return r104;
    L22:
        int r105 = Boolean.valueOf(m9220c()).compareTo(Boolean.valueOf(r100.m9220c()));
        if (r105 == 0) goto L26;
        return r105;
    L26:
        if (m9220c() == false) goto L30;
        int r106 = hq.a(this.f791b, r100.f791b);
        if (r106 == 0) goto L30;
        return r106;
    L30:
        int r107 = Boolean.valueOf(m9221d()).compareTo(Boolean.valueOf(r100.m9221d()));
        if (r107 == 0) goto L34;
        return r107;
    L34:
        if (m9221d() == false) goto L38;
        int r108 = hq.a(this.f793c, r100.f793c);
        if (r108 == 0) goto L38;
        return r108;
    L38:
        int r109 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(r100.e()));
        if (r109 == 0) goto L42;
        return r109;
    L42:
        if (e() == false) goto L46;
        int r110 = hq.a(this.f794d, r100.f794d);
        if (r110 == 0) goto L46;
        return r110;
    L46:
        int r111 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(r100.f()));
        if (r111 == 0) goto L50;
        return r111;
    L50:
        if (f() == false) goto L54;
        int r112 = hq.a(this.f790a, r100.f790a);
        if (r112 == 0) goto L54;
        return r112;
    L54:
        int r113 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(r100.g()));
        if (r113 == 0) goto L58;
        return r113;
    L58:
        if (g() == false) goto L62;
        int r114 = hq.a(this.f795e, r100.f795e);
        if (r114 == 0) goto L62;
        return r114;
    L62:
        int r115 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(r100.h()));
        if (r115 == 0) goto L66;
        return r115;
    L66:
        if (h() == false) goto L70;
        int r116 = hq.a(this.f789a, r100.f789a);
        if (r116 == 0) goto L70;
        return r116;
    L70:
        int r117 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(r100.i()));
        if (r117 == 0) goto L74;
        return r117;
    L74:
        if (i() == false) goto L78;
        int r118 = hq.a(this.f796f, r100.f796f);
        if (r118 == 0) goto L78;
        return r118;
    L78:
        int r119 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(r100.j()));
        if (r119 == 0) goto L82;
        return r119;
    L82:
        if (j() == false) goto L86;
        int r120 = hq.a(this.f797g, r100.f797g);
        if (r120 == 0) goto L86;
        return r120;
    L86:
        int r121 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(r100.k()));
        if (r121 == 0) goto L90;
        return r121;
    L90:
        if (k() == false) goto L94;
        int r122 = hq.a(this.f798h, r100.f798h);
        if (r122 == 0) goto L94;
        return r122;
    L94:
        int r123 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(r100.l()));
        if (r123 == 0) goto L98;
        return r123;
    L98:
        if (l() == false) goto L102;
        int r124 = hq.a(this.f799i, r100.f799i);
        if (r124 == 0) goto L102;
        return r124;
    L102:
        int r125 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(r100.m()));
        if (r125 == 0) goto L106;
        return r125;
    L106:
        if (m() == false) goto L110;
        int r126 = hq.a(this.f787a, r100.f787a);
        if (r126 == 0) goto L110;
        return r126;
    L110:
        int r127 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(r100.n()));
        if (r127 == 0) goto L114;
        return r127;
    L114:
        if (n() == false) goto L118;
        int r128 = hq.a(this.f784a, r100.f784a);
        if (r128 == 0) goto L118;
        return r128;
    L118:
        int r129 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(r100.o()));
        if (r129 == 0) goto L122;
        return r129;
    L122:
        if (o() == false) goto L126;
        int r130 = hq.a(this.f792b, r100.f792b);
        if (r130 == 0) goto L128;
        return r130;
    L128:
        return 0;
    L126:
        return 0;
    L5:
        return getClass().getName().compareTo(r100.getClass().getName());
    }

    @Override // com.xiaomi.push.hp
    public void b(hz r100) {
        m9214a();
        r100.a(f783a);
        if (this.f786a == null) goto L8;
        if (m9216a() == false) goto L8;
        r100.a(f463947a);
        r100.a(this.f786a);
        r100.b();
    L8:
        if (this.f785a == null) goto L13;
        if (m9219b() == false) goto L13;
        r100.a(f463948b);
        this.f785a.b(r100);
        r100.b();
    L13:
        if (this.f791b == null) goto L16;
        r100.a(f463949c);
        r100.a(this.f791b);
        r100.b();
    L16:
        if (this.f793c == null) goto L21;
        if (m9221d() == false) goto L21;
        r100.a(f463950d);
        r100.a(this.f793c);
        r100.b();
    L21:
        if (this.f794d != null) goto L23;
    L25:
        r100.a(f463952f);
        r100.a(this.f790a);
        r100.b();
        if (this.f795e == null) goto L31;
        if (g() == false) goto L31;
        r100.a(f463953g);
        r100.a(this.f795e);
        r100.b();
    L31:
        if (this.f789a == null) goto L40;
        if (h() == false) goto L40;
        r100.a(f463954h);
        r100.a(new hy((byte) 11, (byte) 11, this.f789a.size()));
        Iterator<Map.Entry<String, String>> r101 = this.f789a.entrySet().iterator();
    L36:
        if (r101.hasNext() == false) goto L38;
        Map.Entry<String, String> r102 = r101.next();
        r100.a(r102.getKey());
        r100.a(r102.getValue());
        goto L36
    L38:
        r100.d();
        r100.b();
    L40:
        if (this.f796f == null) goto L45;
        if (i() == false) goto L45;
        r100.a(f463955i);
        r100.a(this.f796f);
        r100.b();
    L45:
        if (this.f797g == null) goto L50;
        if (j() == false) goto L50;
        r100.a(f463956j);
        r100.a(this.f797g);
        r100.b();
    L50:
        if (this.f798h == null) goto L55;
        if (k() == false) goto L55;
        r100.a(f463957k);
        r100.a(this.f798h);
        r100.b();
    L55:
        if (this.f799i == null) goto L60;
        if (l() == false) goto L60;
        r100.a(f463958l);
        r100.a(this.f799i);
        r100.b();
    L60:
        if (this.f787a == null) goto L65;
        if (m() == false) goto L65;
        r100.a(f463959m);
        r100.a(this.f787a);
        r100.b();
    L65:
        if (n() == false) goto L68;
        r100.a(f463960n);
        r100.a(this.f784a);
        r100.b();
    L68:
        if (o() == false) goto L70;
        r100.a(f463961o);
        r100.a(this.f792b);
        r100.b();
    L70:
        r100.c();
        r100.mo9279a();
        return;
    L23:
        if (e() == false) goto L25;
        r100.a(f463951e);
        r100.a(this.f794d);
        r100.b();
        goto L25
    }

    public void c(boolean r100) {
        this.f788a.set(2, r100);
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(Object r100) {
        return a((hd) r100);
    }

    public hd d(String r100) {
        this.f796f = r100;
        return this;
    }

    public boolean equals(Object r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if ((r100 instanceof hd) == true) goto L8;
        return false;
    L8:
        return m9217a((hd) r100);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m9217a(hd r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        boolean r101 = m9216a();
        boolean r102 = r100.m9216a();
        if (r101 == true) goto L8;
        if (r102 == true) goto L8;
    L14:
        boolean r103 = m9219b();
        boolean r104 = r100.m9219b();
        if (r103 == true) goto L17;
        if (r104 == true) goto L17;
    L23:
        boolean r105 = m9220c();
        boolean r106 = r100.m9220c();
        if (r105 == true) goto L26;
        if (r106 == true) goto L26;
    L32:
        boolean r107 = m9221d();
        boolean r108 = r100.m9221d();
        if (r107 == true) goto L35;
        if (r108 == true) goto L35;
    L41:
        boolean r109 = e();
        boolean r110 = r100.e();
        if (r109 == true) goto L44;
        if (r110 == true) goto L44;
    L51:
        if (this.f790a == r100.f790a) goto L53;
        return false;
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
    L89:
        boolean r119 = k();
        boolean r120 = r100.k();
        if (r119 == true) goto L92;
        if (r120 == true) goto L92;
    L98:
        boolean r121 = l();
        boolean r122 = r100.l();
        if (r121 == true) goto L101;
        if (r122 == true) goto L101;
    L107:
        boolean r123 = m();
        boolean r124 = r100.m();
        if (r123 == true) goto L110;
        if (r124 == true) goto L110;
    L116:
        boolean r125 = n();
        boolean r126 = r100.n();
        if (r125 == true) goto L119;
        if (r126 == true) goto L119;
    L125:
        boolean r127 = o();
        boolean r128 = r100.o();
        if (r127 == true) goto L128;
        if (r128 == true) goto L128;
        return true;
    L128:
        if (r127 == false) goto L136;
        if (r128 == false) goto L136;
        if (this.f792b == r100.f792b) goto L137;
        return false;
    L137:
        return true;
    L136:
        return false;
    L119:
        if (r125 == false) goto L136;
        if (r126 == false) goto L136;
        if (this.f784a == r100.f784a) goto L125;
        return false;
    L110:
        if (r123 == false) goto L136;
        if (r124 == false) goto L136;
        if (this.f787a.equals(r100.f787a) == true) goto L116;
        return false;
    L101:
        if (r121 == false) goto L136;
        if (r122 == false) goto L136;
        if (this.f799i.equals(r100.f799i) == true) goto L107;
        return false;
    L92:
        if (r119 == false) goto L136;
        if (r120 == false) goto L136;
        if (this.f798h.equals(r100.f798h) == true) goto L98;
        return false;
    L83:
        if (r117 == false) goto L136;
        if (r118 == false) goto L136;
        if (this.f797g.equals(r100.f797g) == true) goto L89;
        return false;
    L74:
        if (r115 == false) goto L136;
        if (r116 == false) goto L136;
        if (this.f796f.equals(r100.f796f) == true) goto L80;
        return false;
    L65:
        if (r113 == false) goto L136;
        if (r114 == false) goto L136;
        if (this.f789a.equals(r100.f789a) == true) goto L71;
        return false;
    L56:
        if (r111 == false) goto L136;
        if (r112 == false) goto L136;
        if (this.f795e.equals(r100.f795e) == true) goto L62;
        return false;
    L44:
        if (r109 == false) goto L136;
        if (r110 == false) goto L136;
        if (this.f794d.equals(r100.f794d) == true) goto L51;
        return false;
    L35:
        if (r107 == false) goto L136;
        if (r108 == false) goto L136;
        if (this.f793c.equals(r100.f793c) == true) goto L41;
        return false;
    L26:
        if (r105 == false) goto L136;
        if (r106 == false) goto L136;
        if (this.f791b.equals(r100.f791b) == true) goto L32;
        return false;
    L17:
        if (r103 == false) goto L136;
        if (r104 == false) goto L136;
        if (this.f785a.m9175a(r100.f785a) == true) goto L23;
        return false;
    L8:
        if (r101 == false) goto L136;
        if (r102 == false) goto L136;
        if (this.f786a.equals(r100.f786a) == true) goto L14;
        return false;
    }

    public void b(boolean r100) {
        this.f788a.set(1, r100);
    }

    public hd c(String r100) {
        this.f794d = r100;
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
            case 1: goto L63;
            case 2: goto L60;
            case 3: goto L56;
            case 4: goto L53;
            case 5: goto L50;
            case 6: goto L47;
            case 7: goto L44;
            case 8: goto L37;
            case 9: goto L33;
            case 10: goto L30;
            case 11: goto L13;
            case 12: goto L27;
            case 13: goto L24;
            case 14: goto L21;
            case 15: goto L18;
            case 16: goto L13;
            case 17: goto L13;
            case 18: goto L13;
            case 19: goto L13;
            case 20: goto L14;
            default: goto L13;
        };
    L13:
        ic.a(r100, r102);
    L66:
        r100.g();
        goto L3
    L14:
        if (r102 != 2) goto L16;
        this.f792b = r100.mo9281a();
        c(true);
        goto L66
    L16:
        ic.a(r100, r102);
        goto L66
    L21:
        if (r102 != 11) goto L23;
        this.f787a = r100.mo9277a();
        goto L66
    L23:
        ic.a(r100, r102);
        goto L66
    L24:
        if (r102 != 11) goto L26;
        this.f799i = r100.mo9276a();
        goto L66
    L26:
        ic.a(r100, r102);
        goto L66
    L27:
        if (r102 != 11) goto L29;
        this.f798h = r100.mo9276a();
        goto L66
    L29:
        ic.a(r100, r102);
        goto L66
    L30:
        if (r102 != 11) goto L32;
        this.f797g = r100.mo9276a();
        goto L66
    L32:
        ic.a(r100, r102);
        goto L66
    L33:
        if (r102 != 11) goto L35;
        this.f796f = r100.mo9276a();
        goto L66
    L35:
        ic.a(r100, r102);
        goto L66
    L44:
        if (r102 != 11) goto L46;
        this.f795e = r100.mo9276a();
        goto L66
    L46:
        ic.a(r100, r102);
        goto L66
    L47:
        if (r102 != 2) goto L49;
        this.f790a = r100.mo9281a();
        m9215a(true);
        goto L66
    L49:
        ic.a(r100, r102);
        goto L66
    L50:
        if (r102 != 11) goto L52;
        this.f794d = r100.mo9276a();
        goto L66
    L52:
        ic.a(r100, r102);
        goto L66
    L53:
        if (r102 != 11) goto L55;
        this.f793c = r100.mo9276a();
        goto L66
    L55:
        ic.a(r100, r102);
        goto L66
    L56:
        if (r102 != 11) goto L58;
        this.f791b = r100.mo9276a();
        goto L66
    L58:
        ic.a(r100, r102);
        goto L66
    L63:
        if (r102 != 11) goto L65;
        this.f786a = r100.mo9276a();
        goto L66
    L65:
        ic.a(r100, r102);
        goto L66
    L18:
        if (r102 != 10) goto L20;
        this.f784a = r100.mo9270a();
        b(true);
        goto L66
    L20:
        ic.a(r100, r102);
        goto L66
    L37:
        if (r102 != 13) goto L43;
        hy r103 = r100.mo9273a();
        this.f789a = new HashMap(r103.f953a * 2);
        int r104 = 0;
    L40:
        if (r104 >= r103.f953a) goto L42;
        this.f789a.put(r100.mo9276a(), r100.mo9276a());
        r104 = r104 + 1;
        goto L40
    L42:
        r100.h();
        goto L66
    L43:
        ic.a(r100, r102);
        goto L66
    L60:
        if (r102 != 12) goto L62;
        gt r105 = new gt();
        this.f785a = r105;
        r105.a(r100);
        goto L66
    L62:
        ic.a(r100, r102);
        goto L66
    L5:
        r100.f();
        if (f() == false) goto L10;
        m9214a();
        return;
    L10:
        throw new ia("Required field 'requireAck' was not found in serialized data! Struct: " + toString());
    }

    public hd b(String r100) {
        this.f793c = r100;
        return this;
    }

    public hd a(byte[] r100) {
        a(ByteBuffer.wrap(r100));
        return this;
    }

    public hd a(boolean r100) {
        this.f790a = r100;
        m9215a(true);
        return this;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m9215a(boolean r100) {
        this.f788a.set(0, r100);
    }

    public hd a(String r100) {
        this.f791b = r100;
        return this;
    }

    public hd a(ByteBuffer r100) {
        this.f787a = r100;
        return this;
    }

    public hd a(Map<String, String> r100) {
        this.f789a = r100;
        return this;
    }

    public hd(String r100, boolean r101) {
        this();
        this.f791b = r100;
        this.f790a = r101;
        m9215a(true);
    }

    public void a(String r100, String r101) {
        if (this.f789a != null) goto L5;
        this.f789a = new HashMap();
    L5:
        this.f789a.put(r100, r101);
    }
}
