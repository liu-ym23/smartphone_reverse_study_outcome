package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes41.dex */
public class ej implements hp<ej, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final hw f463479a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final ie f493a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final hw f463480b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final hw f463481c = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f494a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<ei> f495a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f496b;

    public int hashCode() {
        return 0;
    }

    static {
        f493a = new ie("StatsEvents");
        f463479a = new hw("", (byte) 11, 1);
        f463480b = new hw("", (byte) 11, 2);
        f463481c = new hw("", (byte) 15, 3);
    }

    public void a() {
        if (this.f494a == null) goto L10;
        if (this.f495a == null) goto L8;
        return;
    L8:
        throw new ia("Required field 'events' was not present! Struct: " + toString());
    L10:
        throw new ia("Required field 'uuid' was not present! Struct: " + toString());
    }

    public boolean b() {
        if (this.f496b == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean c() {
        if (this.f495a == null) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("StatsEvents(uuid:");
        String r101 = this.f494a;
        if (r101 != null) goto L5;
        r100.append("null");
    L7:
        if (b() == false) goto L12;
        r100.append(", ");
        r100.append("operator:");
        String r102 = this.f496b;
        if (r102 != null) goto L11;
        r100.append("null");
        goto L12
    L11:
        r100.append(r102);
    L12:
        r100.append(", ");
        r100.append("events:");
        List<ei> r103 = this.f495a;
        if (r103 != null) goto L15;
        r100.append("null");
    L16:
        r100.append(")");
        return r100.toString();
    L15:
        r100.append(r103);
        goto L16
    L5:
        r100.append(r101);
        goto L7
    }

    public ej() {
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m9045a() {
        if (this.f494a == null) goto L5;
        return true;
    L5:
        return false;
    }

    public int a(ej r100) {
        if (getClass().equals(r100.getClass()) == false) goto L5;
        int r101 = Boolean.valueOf(m9045a()).compareTo(Boolean.valueOf(r100.m9045a()));
        if (r101 == 0) goto L10;
        return r101;
    L10:
        if (m9045a() == false) goto L14;
        int r102 = hq.a(this.f494a, r100.f494a);
        if (r102 == 0) goto L14;
        return r102;
    L14:
        int r103 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(r100.b()));
        if (r103 == 0) goto L18;
        return r103;
    L18:
        if (b() == false) goto L22;
        int r104 = hq.a(this.f496b, r100.f496b);
        if (r104 == 0) goto L22;
        return r104;
    L22:
        int r105 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(r100.c()));
        if (r105 == 0) goto L26;
        return r105;
    L26:
        if (c() == false) goto L30;
        int r106 = hq.a(this.f495a, r100.f495a);
        if (r106 == 0) goto L32;
        return r106;
    L32:
        return 0;
    L30:
        return 0;
    L5:
        return getClass().getName().compareTo(r100.getClass().getName());
    }

    @Override // com.xiaomi.push.hp
    public void b(hz r100) {
        a();
        r100.a(f493a);
        if (this.f494a == null) goto L6;
        r100.a(f463479a);
        r100.a(this.f494a);
        r100.b();
    L6:
        if (this.f496b == null) goto L11;
        if (b() == false) goto L11;
        r100.a(f463480b);
        r100.a(this.f496b);
        r100.b();
    L11:
        if (this.f495a == null) goto L17;
        r100.a(f463481c);
        r100.a(new hx((byte) 12, this.f495a.size()));
        Iterator<ei> r101 = this.f495a.iterator();
    L14:
        if (r101.hasNext() == false) goto L16;
        r101.next().b(r100);
        goto L14
    L16:
        r100.e();
        r100.b();
    L17:
        r100.c();
        r100.mo9279a();
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(Object r100) {
        return a((ej) r100);
    }

    public boolean equals(Object r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if ((r100 instanceof ej) == true) goto L8;
        return false;
    L8:
        return m9046a((ej) r100);
    }

    @Override // com.xiaomi.push.hp
    public void a(hz r100) {
        r100.mo9275a();
    L3:
        hw r101 = r100.mo9271a();
        byte r102 = r101.f464095a;
        if (r102 == 0) goto L5;
        short r103 = r101.f951a;
        if (r103 != 1) goto L10;
        if (r102 != 11) goto L27;
        this.f494a = r100.mo9276a();
    L28:
        r100.g();
        goto L3
    L27:
        ic.a(r100, r102);
        goto L28
    L10:
        if (r103 != 2) goto L12;
        if (r102 != 11) goto L24;
        this.f496b = r100.mo9276a();
        goto L28
    L24:
        ic.a(r100, r102);
        goto L28
    L12:
        if (r103 == 3) goto L15;
        ic.a(r100, r102);
        goto L28
    L15:
        if (r102 != 15) goto L21;
        hx r104 = r100.mo9272a();
        this.f495a = new ArrayList(r104.f952a);
        int r105 = 0;
    L18:
        if (r105 >= r104.f952a) goto L20;
        ei r106 = new ei();
        r106.a(r100);
        this.f495a.add(r106);
        r105 = r105 + 1;
        goto L18
    L20:
        r100.i();
        goto L28
    L21:
        ic.a(r100, r102);
        goto L28
    L5:
        r100.f();
        a();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m9046a(ej r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        boolean r101 = m9045a();
        boolean r102 = r100.m9045a();
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
        return true;
    L26:
        if (r105 == false) goto L34;
        if (r106 == false) goto L34;
        if (this.f495a.equals(r100.f495a) == true) goto L35;
        return false;
    L35:
        return true;
    L34:
        return false;
    L17:
        if (r103 == false) goto L34;
        if (r104 == false) goto L34;
        if (this.f496b.equals(r100.f496b) == true) goto L23;
        return false;
    L8:
        if (r101 == false) goto L34;
        if (r102 == false) goto L34;
        if (this.f494a.equals(r100.f494a) == true) goto L14;
        return false;
    }

    public ej a(String r100) {
        this.f496b = r100;
        return this;
    }

    public ej(String r100, List<ei> r101) {
        this();
        this.f494a = r100;
        this.f495a = r101;
    }
}
