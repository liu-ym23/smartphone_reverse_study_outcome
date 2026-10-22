package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* JADX INFO: loaded from: classes41.dex */
public class ei implements hp<ei, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final hw f463469a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final ie f481a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final hw f463470b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final hw f463471c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final hw f463472d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final hw f463473e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final hw f463474f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final hw f463475g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final hw f463476h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final hw f463477i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final hw f463478j = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public byte f482a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f483a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f484a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private BitSet f485a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f486b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f487b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public int f488c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public String f489c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public int f490d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public String f491d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public int f492e;

    public int hashCode() {
        return 0;
    }

    static {
        f481a = new ie("StatsEvent");
        f463469a = new hw("", (byte) 3, 1);
        f463470b = new hw("", (byte) 8, 2);
        f463471c = new hw("", (byte) 8, 3);
        f463472d = new hw("", (byte) 11, 4);
        f463473e = new hw("", (byte) 11, 5);
        f463474f = new hw("", (byte) 8, 6);
        f463475g = new hw("", (byte) 11, 7);
        f463476h = new hw("", (byte) 11, 8);
        f463477i = new hw("", (byte) 8, 9);
        f463478j = new hw("", (byte) 8, 10);
    }

    public void a() {
        if (this.f484a == null) goto L6;
        return;
    L6:
        throw new ia("Required field 'connpt' was not present! Struct: " + toString());
    }

    public boolean b() {
        return this.f485a.get(1);
    }

    public boolean c() {
        return this.f485a.get(2);
    }

    public boolean d() {
        if (this.f484a == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean e() {
        if (this.f487b == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean f() {
        return this.f485a.get(3);
    }

    public boolean g() {
        if (this.f489c == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean h() {
        if (this.f491d == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean i() {
        return this.f485a.get(4);
    }

    public boolean j() {
        return this.f485a.get(5);
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("StatsEvent(chid:");
        r100.append(this.f482a);
        r100.append(", ");
        r100.append("type:");
        r100.append(this.f483a);
        r100.append(", ");
        r100.append("value:");
        r100.append(this.f486b);
        r100.append(", ");
        r100.append("connpt:");
        String r101 = this.f484a;
        if (r101 != null) goto L5;
        r100.append("null");
    L7:
        if (e() == false) goto L13;
        r100.append(", ");
        r100.append("host:");
        String r102 = this.f487b;
        if (r102 != null) goto L11;
        r100.append("null");
        goto L13
    L11:
        r100.append(r102);
    L13:
        if (f() == false) goto L16;
        r100.append(", ");
        r100.append("subvalue:");
        r100.append(this.f488c);
    L16:
        if (g() == false) goto L22;
        r100.append(", ");
        r100.append("annotation:");
        String r103 = this.f489c;
        if (r103 != null) goto L20;
        r100.append("null");
        goto L22
    L20:
        r100.append(r103);
    L22:
        if (h() == false) goto L28;
        r100.append(", ");
        r100.append("user:");
        String r104 = this.f491d;
        if (r104 != null) goto L26;
        r100.append("null");
        goto L28
    L26:
        r100.append(r104);
    L28:
        if (i() == false) goto L31;
        r100.append(", ");
        r100.append("time:");
        r100.append(this.f490d);
    L31:
        if (j() == false) goto L33;
        r100.append(", ");
        r100.append("clientIp:");
        r100.append(this.f492e);
    L33:
        r100.append(")");
        return r100.toString();
    L5:
        r100.append(r101);
        goto L7
    }

    public ei() {
        this.f485a = new BitSet(6);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m9043a() {
        return this.f485a.get(0);
    }

    public int a(ei r100) {
        if (getClass().equals(r100.getClass()) == false) goto L5;
        int r101 = Boolean.valueOf(m9043a()).compareTo(Boolean.valueOf(r100.m9043a()));
        if (r101 == 0) goto L10;
        return r101;
    L10:
        if (m9043a() == false) goto L14;
        int r102 = hq.a(this.f482a, r100.f482a);
        if (r102 == 0) goto L14;
        return r102;
    L14:
        int r103 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(r100.b()));
        if (r103 == 0) goto L18;
        return r103;
    L18:
        if (b() == false) goto L22;
        int r104 = hq.a(this.f483a, r100.f483a);
        if (r104 == 0) goto L22;
        return r104;
    L22:
        int r105 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(r100.c()));
        if (r105 == 0) goto L26;
        return r105;
    L26:
        if (c() == false) goto L30;
        int r106 = hq.a(this.f486b, r100.f486b);
        if (r106 == 0) goto L30;
        return r106;
    L30:
        int r107 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(r100.d()));
        if (r107 == 0) goto L34;
        return r107;
    L34:
        if (d() == false) goto L38;
        int r108 = hq.a(this.f484a, r100.f484a);
        if (r108 == 0) goto L38;
        return r108;
    L38:
        int r109 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(r100.e()));
        if (r109 == 0) goto L42;
        return r109;
    L42:
        if (e() == false) goto L46;
        int r110 = hq.a(this.f487b, r100.f487b);
        if (r110 == 0) goto L46;
        return r110;
    L46:
        int r111 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(r100.f()));
        if (r111 == 0) goto L50;
        return r111;
    L50:
        if (f() == false) goto L54;
        int r112 = hq.a(this.f488c, r100.f488c);
        if (r112 == 0) goto L54;
        return r112;
    L54:
        int r113 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(r100.g()));
        if (r113 == 0) goto L58;
        return r113;
    L58:
        if (g() == false) goto L62;
        int r114 = hq.a(this.f489c, r100.f489c);
        if (r114 == 0) goto L62;
        return r114;
    L62:
        int r115 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(r100.h()));
        if (r115 == 0) goto L66;
        return r115;
    L66:
        if (h() == false) goto L70;
        int r116 = hq.a(this.f491d, r100.f491d);
        if (r116 == 0) goto L70;
        return r116;
    L70:
        int r117 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(r100.i()));
        if (r117 == 0) goto L74;
        return r117;
    L74:
        if (i() == false) goto L78;
        int r118 = hq.a(this.f490d, r100.f490d);
        if (r118 == 0) goto L78;
        return r118;
    L78:
        int r119 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(r100.j()));
        if (r119 == 0) goto L82;
        return r119;
    L82:
        if (j() == false) goto L86;
        int r120 = hq.a(this.f492e, r100.f492e);
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
        a();
        r100.a(f481a);
        r100.a(f463469a);
        r100.a(this.f482a);
        r100.b();
        r100.a(f463470b);
        r100.mo9280a(this.f483a);
        r100.b();
        r100.a(f463471c);
        r100.mo9280a(this.f486b);
        r100.b();
        if (this.f484a == null) goto L6;
        r100.a(f463472d);
        r100.a(this.f484a);
        r100.b();
    L6:
        if (this.f487b == null) goto L11;
        if (e() == false) goto L11;
        r100.a(f463473e);
        r100.a(this.f487b);
        r100.b();
    L11:
        if (f() == false) goto L14;
        r100.a(f463474f);
        r100.mo9280a(this.f488c);
        r100.b();
    L14:
        if (this.f489c == null) goto L19;
        if (g() == false) goto L19;
        r100.a(f463475g);
        r100.a(this.f489c);
        r100.b();
    L19:
        if (this.f491d == null) goto L24;
        if (h() == false) goto L24;
        r100.a(f463476h);
        r100.a(this.f491d);
        r100.b();
    L24:
        if (i() == false) goto L27;
        r100.a(f463477i);
        r100.mo9280a(this.f490d);
        r100.b();
    L27:
        if (j() == false) goto L29;
        r100.a(f463478j);
        r100.mo9280a(this.f492e);
        r100.b();
    L29:
        r100.c();
        r100.mo9279a();
    }

    public ei c(int r100) {
        this.f488c = r100;
        d(true);
        return this;
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(Object r100) {
        return a((ei) r100);
    }

    public ei d(int r100) {
        this.f490d = r100;
        e(true);
        return this;
    }

    public void e(boolean r100) {
        this.f485a.set(4, r100);
    }

    public boolean equals(Object r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if ((r100 instanceof ei) == true) goto L8;
        return false;
    L8:
        return m9044a((ei) r100);
    }

    public void f(boolean r100) {
        this.f485a.set(5, r100);
    }

    @Override // com.xiaomi.push.hp
    public void a(hz r100) {
        r100.mo9275a();
    L3:
        hw r101 = r100.mo9271a();
        byte r102 = r101.f464095a;
        if (r102 == 0) goto L5;
        switch(r101.f951a) {
            case 1: goto L50;
            case 2: goto L46;
            case 3: goto L43;
            case 4: goto L40;
            case 5: goto L37;
            case 6: goto L34;
            case 7: goto L31;
            case 8: goto L28;
            case 9: goto L25;
            case 10: goto L22;
            default: goto L21;
        };
    L21:
        ic.a(r100, r102);
    L53:
        r100.g();
        goto L3
    L22:
        if (r102 != 8) goto L24;
        this.f492e = r100.mo9269a();
        f(true);
        goto L53
    L24:
        ic.a(r100, r102);
        goto L53
    L25:
        if (r102 != 8) goto L27;
        this.f490d = r100.mo9269a();
        e(true);
        goto L53
    L27:
        ic.a(r100, r102);
        goto L53
    L28:
        if (r102 != 11) goto L30;
        this.f491d = r100.mo9276a();
        goto L53
    L30:
        ic.a(r100, r102);
        goto L53
    L31:
        if (r102 != 11) goto L33;
        this.f489c = r100.mo9276a();
        goto L53
    L33:
        ic.a(r100, r102);
        goto L53
    L34:
        if (r102 != 8) goto L36;
        this.f488c = r100.mo9269a();
        d(true);
        goto L53
    L36:
        ic.a(r100, r102);
        goto L53
    L37:
        if (r102 != 11) goto L39;
        this.f487b = r100.mo9276a();
        goto L53
    L39:
        ic.a(r100, r102);
        goto L53
    L40:
        if (r102 != 11) goto L42;
        this.f484a = r100.mo9276a();
        goto L53
    L42:
        ic.a(r100, r102);
        goto L53
    L43:
        if (r102 != 8) goto L45;
        this.f486b = r100.mo9269a();
        c(true);
        goto L53
    L45:
        ic.a(r100, r102);
        goto L53
    L46:
        if (r102 != 8) goto L48;
        this.f483a = r100.mo9269a();
        b(true);
        goto L53
    L48:
        ic.a(r100, r102);
        goto L53
    L50:
        if (r102 != 3) goto L52;
        this.f482a = r100.a();
        a(true);
        goto L53
    L52:
        ic.a(r100, r102);
        goto L53
    L5:
        r100.f();
        if (m9043a() == false) goto L18;
        if (b() == false) goto L16;
        if (c() == false) goto L14;
        a();
        return;
    L14:
        throw new ia("Required field 'value' was not found in serialized data! Struct: " + toString());
    L16:
        throw new ia("Required field 'type' was not found in serialized data! Struct: " + toString());
    L18:
        throw new ia("Required field 'chid' was not found in serialized data! Struct: " + toString());
    }

    public ei b(int r100) {
        this.f486b = r100;
        c(true);
        return this;
    }

    public void c(boolean r100) {
        this.f485a.set(2, r100);
    }

    public void d(boolean r100) {
        this.f485a.set(3, r100);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m9044a(ei r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (this.f482a == r100.f482a) goto L9;
        return false;
    L9:
        if (this.f483a == r100.f483a) goto L12;
        return false;
    L12:
        if (this.f486b == r100.f486b) goto L14;
        return false;
    L14:
        boolean r101 = d();
        boolean r102 = r100.d();
        if (r101 == true) goto L17;
        if (r102 == true) goto L17;
    L23:
        boolean r103 = e();
        boolean r104 = r100.e();
        if (r103 == true) goto L26;
        if (r104 == true) goto L26;
    L32:
        boolean r105 = f();
        boolean r106 = r100.f();
        if (r105 == true) goto L35;
        if (r106 == true) goto L35;
    L41:
        boolean r107 = g();
        boolean r108 = r100.g();
        if (r107 == true) goto L44;
        if (r108 == true) goto L44;
    L50:
        boolean r109 = h();
        boolean r110 = r100.h();
        if (r109 == true) goto L53;
        if (r110 == true) goto L53;
    L59:
        boolean r111 = i();
        boolean r112 = r100.i();
        if (r111 == true) goto L62;
        if (r112 == true) goto L62;
    L68:
        boolean r113 = j();
        boolean r114 = r100.j();
        if (r113 == true) goto L71;
        if (r114 == true) goto L71;
        return true;
    L71:
        if (r113 == false) goto L79;
        if (r114 == false) goto L79;
        if (this.f492e == r100.f492e) goto L80;
        return false;
    L80:
        return true;
    L79:
        return false;
    L62:
        if (r111 == false) goto L79;
        if (r112 == false) goto L79;
        if (this.f490d == r100.f490d) goto L68;
        return false;
    L53:
        if (r109 == false) goto L79;
        if (r110 == false) goto L79;
        if (this.f491d.equals(r100.f491d) == true) goto L59;
        return false;
    L44:
        if (r107 == false) goto L79;
        if (r108 == false) goto L79;
        if (this.f489c.equals(r100.f489c) == true) goto L50;
        return false;
    L35:
        if (r105 == false) goto L79;
        if (r106 == false) goto L79;
        if (this.f488c == r100.f488c) goto L41;
        return false;
    L26:
        if (r103 == false) goto L79;
        if (r104 == false) goto L79;
        if (this.f487b.equals(r100.f487b) == true) goto L32;
        return false;
    L17:
        if (r101 == false) goto L79;
        if (r102 == false) goto L79;
        if (this.f484a.equals(r100.f484a) == true) goto L23;
        return false;
    }

    public void b(boolean r100) {
        this.f485a.set(1, r100);
    }

    public ei c(String r100) {
        this.f489c = r100;
        return this;
    }

    public ei d(String r100) {
        this.f491d = r100;
        return this;
    }

    public ei a(byte r100) {
        this.f482a = r100;
        a(true);
        return this;
    }

    public ei b(String r100) {
        this.f487b = r100;
        return this;
    }

    public ei a(int r100) {
        this.f483a = r100;
        b(true);
        return this;
    }

    public void a(boolean r100) {
        this.f485a.set(0, r100);
    }

    public ei a(String r100) {
        this.f484a = r100;
        return this;
    }
}
