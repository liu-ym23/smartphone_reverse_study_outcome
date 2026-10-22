package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* JADX INFO: loaded from: classes41.dex */
public class gt implements hp<gt, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final hw f463877a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final ie f697a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final hw f463878b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final hw f463879c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final hw f463880d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final hw f463881e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final hw f463882f = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f698a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f699a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private BitSet f700a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f701a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f702b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public String f703c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public String f704d;

    public int hashCode() {
        return 0;
    }

    static {
        f697a = new ie("Target");
        f463877a = new hw("", (byte) 10, 1);
        f463878b = new hw("", (byte) 11, 2);
        f463879c = new hw("", (byte) 11, 3);
        f463880d = new hw("", (byte) 11, 4);
        f463881e = new hw("", (byte) 2, 5);
        f463882f = new hw("", (byte) 11, 7);
    }

    public void a() {
        if (this.f699a == null) goto L6;
        return;
    L6:
        throw new ia("Required field 'userId' was not present! Struct: " + toString());
    }

    public boolean b() {
        if (this.f699a == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean c() {
        if (this.f702b == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean d() {
        if (this.f703c == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean e() {
        return this.f700a.get(1);
    }

    public boolean f() {
        if (this.f704d == null) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("Target(channelId:");
        r100.append(this.f698a);
        r100.append(", ");
        r100.append("userId:");
        String r101 = this.f699a;
        if (r101 != null) goto L5;
        r100.append("null");
    L7:
        if (c() == false) goto L13;
        r100.append(", ");
        r100.append("server:");
        String r102 = this.f702b;
        if (r102 != null) goto L11;
        r100.append("null");
        goto L13
    L11:
        r100.append(r102);
    L13:
        if (d() == false) goto L19;
        r100.append(", ");
        r100.append("resource:");
        String r103 = this.f703c;
        if (r103 != null) goto L17;
        r100.append("null");
        goto L19
    L17:
        r100.append(r103);
    L19:
        if (e() == false) goto L22;
        r100.append(", ");
        r100.append("isPreview:");
        r100.append(this.f701a);
    L22:
        if (f() == false) goto L27;
        r100.append(", ");
        r100.append("token:");
        String r104 = this.f704d;
        if (r104 != null) goto L26;
        r100.append("null");
        goto L27
    L26:
        r100.append(r104);
    L27:
        r100.append(")");
        return r100.toString();
    L5:
        r100.append(r101);
        goto L7
    }

    public gt() {
        this.f700a = new BitSet(2);
        this.f698a = 5;
        this.f702b = "xiaomi.com";
        this.f703c = "";
        this.f701a = false;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m9174a() {
        return this.f700a.get(0);
    }

    public int a(gt r100) {
        if (getClass().equals(r100.getClass()) == false) goto L5;
        int r101 = Boolean.valueOf(m9174a()).compareTo(Boolean.valueOf(r100.m9174a()));
        if (r101 == 0) goto L10;
        return r101;
    L10:
        if (m9174a() == false) goto L14;
        int r102 = hq.a(this.f698a, r100.f698a);
        if (r102 == 0) goto L14;
        return r102;
    L14:
        int r103 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(r100.b()));
        if (r103 == 0) goto L18;
        return r103;
    L18:
        if (b() == false) goto L22;
        int r104 = hq.a(this.f699a, r100.f699a);
        if (r104 == 0) goto L22;
        return r104;
    L22:
        int r105 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(r100.c()));
        if (r105 == 0) goto L26;
        return r105;
    L26:
        if (c() == false) goto L30;
        int r106 = hq.a(this.f702b, r100.f702b);
        if (r106 == 0) goto L30;
        return r106;
    L30:
        int r107 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(r100.d()));
        if (r107 == 0) goto L34;
        return r107;
    L34:
        if (d() == false) goto L38;
        int r108 = hq.a(this.f703c, r100.f703c);
        if (r108 == 0) goto L38;
        return r108;
    L38:
        int r109 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(r100.e()));
        if (r109 == 0) goto L42;
        return r109;
    L42:
        if (e() == false) goto L46;
        int r110 = hq.a(this.f701a, r100.f701a);
        if (r110 == 0) goto L46;
        return r110;
    L46:
        int r111 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(r100.f()));
        if (r111 == 0) goto L50;
        return r111;
    L50:
        if (f() == false) goto L54;
        int r112 = hq.a(this.f704d, r100.f704d);
        if (r112 == 0) goto L56;
        return r112;
    L56:
        return 0;
    L54:
        return 0;
    L5:
        return getClass().getName().compareTo(r100.getClass().getName());
    }

    @Override // com.xiaomi.push.hp
    public void b(hz r100) {
        a();
        r100.a(f697a);
        r100.a(f463877a);
        r100.a(this.f698a);
        r100.b();
        if (this.f699a == null) goto L6;
        r100.a(f463878b);
        r100.a(this.f699a);
        r100.b();
    L6:
        if (this.f702b == null) goto L11;
        if (c() == false) goto L11;
        r100.a(f463879c);
        r100.a(this.f702b);
        r100.b();
    L11:
        if (this.f703c == null) goto L16;
        if (d() == false) goto L16;
        r100.a(f463880d);
        r100.a(this.f703c);
        r100.b();
    L16:
        if (e() == false) goto L19;
        r100.a(f463881e);
        r100.a(this.f701a);
        r100.b();
    L19:
        if (this.f704d != null) goto L21;
    L23:
        r100.c();
        r100.mo9279a();
        return;
    L21:
        if (f() == false) goto L23;
        r100.a(f463882f);
        r100.a(this.f704d);
        r100.b();
        goto L23
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(Object r100) {
        return a((gt) r100);
    }

    public boolean equals(Object r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if ((r100 instanceof gt) == true) goto L8;
        return false;
    L8:
        return m9175a((gt) r100);
    }

    @Override // com.xiaomi.push.hp
    public void a(hz r100) {
        r100.mo9275a();
    L3:
        hw r101 = r100.mo9271a();
        byte r102 = r101.f464095a;
        if (r102 == 0) goto L5;
        short r103 = r101.f951a;
        if (r103 == 1) goto L40;
        if (r103 != 2) goto L16;
        if (r102 != 11) goto L38;
        this.f699a = r100.mo9276a();
    L43:
        r100.g();
        goto L3
    L38:
        ic.a(r100, r102);
        goto L43
    L16:
        if (r103 != 3) goto L18;
        if (r102 != 11) goto L35;
        this.f702b = r100.mo9276a();
        goto L43
    L35:
        ic.a(r100, r102);
        goto L43
    L18:
        if (r103 != 4) goto L20;
        if (r102 != 11) goto L32;
        this.f703c = r100.mo9276a();
        goto L43
    L32:
        ic.a(r100, r102);
        goto L43
    L20:
        if (r103 != 5) goto L22;
        if (r102 != 2) goto L29;
        this.f701a = r100.mo9281a();
        b(true);
        goto L43
    L29:
        ic.a(r100, r102);
        goto L43
    L22:
        if (r103 == 7) goto L24;
        ic.a(r100, r102);
        goto L43
    L24:
        if (r102 != 11) goto L26;
        this.f704d = r100.mo9276a();
        goto L43
    L26:
        ic.a(r100, r102);
        goto L43
    L40:
        if (r102 != 10) goto L42;
        this.f698a = r100.mo9270a();
        a(true);
        goto L43
    L42:
        ic.a(r100, r102);
        goto L43
    L5:
        r100.f();
        if (m9174a() == false) goto L10;
        a();
        return;
    L10:
        throw new ia("Required field 'channelId' was not found in serialized data! Struct: " + toString());
    }

    public void b(boolean r100) {
        this.f700a.set(1, r100);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m9175a(gt r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (this.f698a == r100.f698a) goto L8;
        return false;
    L8:
        boolean r101 = b();
        boolean r102 = r100.b();
        if (r101 == true) goto L11;
        if (r102 == true) goto L11;
    L17:
        boolean r103 = c();
        boolean r104 = r100.c();
        if (r103 == true) goto L20;
        if (r104 == true) goto L20;
    L26:
        boolean r105 = d();
        boolean r106 = r100.d();
        if (r105 == true) goto L29;
        if (r106 == true) goto L29;
    L35:
        boolean r107 = e();
        boolean r108 = r100.e();
        if (r107 == true) goto L38;
        if (r108 == true) goto L38;
    L44:
        boolean r109 = f();
        boolean r110 = r100.f();
        if (r109 == true) goto L47;
        if (r110 == true) goto L47;
        return true;
    L47:
        if (r109 == false) goto L55;
        if (r110 == false) goto L55;
        if (this.f704d.equals(r100.f704d) == true) goto L56;
        return false;
    L56:
        return true;
    L55:
        return false;
    L38:
        if (r107 == false) goto L55;
        if (r108 == false) goto L55;
        if (this.f701a == r100.f701a) goto L44;
        return false;
    L29:
        if (r105 == false) goto L55;
        if (r106 == false) goto L55;
        if (this.f703c.equals(r100.f703c) == true) goto L35;
        return false;
    L20:
        if (r103 == false) goto L55;
        if (r104 == false) goto L55;
        if (this.f702b.equals(r100.f702b) == true) goto L26;
        return false;
    L11:
        if (r101 == false) goto L55;
        if (r102 == false) goto L55;
        if (this.f699a.equals(r100.f699a) == true) goto L17;
        return false;
    }

    public void a(boolean r100) {
        this.f700a.set(0, r100);
    }
}
