package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes41.dex */
public class gn implements hp<gn, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final hw f463797a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final ie f644a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final hw f463798b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final hw f463799c = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f645a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public gk f646a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private BitSet f647a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<gp> f648a;

    public int hashCode() {
        return 0;
    }

    static {
        f644a = new ie("NormalConfig");
        f463797a = new hw("", (byte) 8, 1);
        f463798b = new hw("", (byte) 15, 2);
        f463799c = new hw("", (byte) 8, 3);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m9145a() {
        if (this.f648a == null) goto L6;
        return;
    L6:
        throw new ia("Required field 'configItems' was not present! Struct: " + toString());
    }

    public boolean b() {
        if (this.f648a == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean c() {
        if (this.f646a == null) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("NormalConfig(version:");
        r100.append(this.f645a);
        r100.append(", ");
        r100.append("configItems:");
        List<gp> r101 = this.f648a;
        if (r101 != null) goto L5;
        r100.append("null");
    L7:
        if (c() == false) goto L12;
        r100.append(", ");
        r100.append("type:");
        gk r102 = this.f646a;
        if (r102 != null) goto L11;
        r100.append("null");
        goto L12
    L11:
        r100.append(r102);
    L12:
        r100.append(")");
        return r100.toString();
    L5:
        r100.append(r101);
        goto L7
    }

    public gn() {
        this.f647a = new BitSet(1);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m9146a() {
        return this.f647a.get(0);
    }

    public int a() {
        return this.f645a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public gk m9144a() {
        return this.f646a;
    }

    public int a(gn r100) {
        if (getClass().equals(r100.getClass()) == false) goto L5;
        int r101 = Boolean.valueOf(m9146a()).compareTo(Boolean.valueOf(r100.m9146a()));
        if (r101 == 0) goto L10;
        return r101;
    L10:
        if (m9146a() == false) goto L14;
        int r102 = hq.a(this.f645a, r100.f645a);
        if (r102 == 0) goto L14;
        return r102;
    L14:
        int r103 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(r100.b()));
        if (r103 == 0) goto L18;
        return r103;
    L18:
        if (b() == false) goto L22;
        int r104 = hq.a(this.f648a, r100.f648a);
        if (r104 == 0) goto L22;
        return r104;
    L22:
        int r105 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(r100.c()));
        if (r105 == 0) goto L26;
        return r105;
    L26:
        if (c() == false) goto L30;
        int r106 = hq.a(this.f646a, r100.f646a);
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
        m9145a();
        r100.a(f644a);
        r100.a(f463797a);
        r100.mo9280a(this.f645a);
        r100.b();
        if (this.f648a == null) goto L10;
        r100.a(f463798b);
        r100.a(new hx((byte) 12, this.f648a.size()));
        Iterator<gp> r101 = this.f648a.iterator();
    L6:
        if (r101.hasNext() == false) goto L8;
        r101.next().b(r100);
        goto L6
    L8:
        r100.e();
        r100.b();
    L10:
        if (this.f646a != null) goto L12;
    L14:
        r100.c();
        r100.mo9279a();
        return;
    L12:
        if (c() == false) goto L14;
        r100.a(f463799c);
        r100.mo9280a(this.f646a.a());
        r100.b();
        goto L14
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(Object r100) {
        return a((gn) r100);
    }

    public boolean equals(Object r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if ((r100 instanceof gn) == true) goto L8;
        return false;
    L8:
        return m9147a((gn) r100);
    }

    @Override // com.xiaomi.push.hp
    public void a(hz r100) {
        r100.mo9275a();
    L3:
        hw r101 = r100.mo9271a();
        byte r102 = r101.f464095a;
        if (r102 == 0) goto L5;
        short r103 = r101.f951a;
        if (r103 != 1) goto L14;
        if (r102 != 8) goto L31;
        this.f645a = r100.mo9269a();
        a(true);
    L32:
        r100.g();
        goto L3
    L31:
        ic.a(r100, r102);
        goto L32
    L14:
        if (r103 == 2) goto L22;
        if (r103 == 3) goto L18;
        ic.a(r100, r102);
        goto L32
    L18:
        if (r102 != 8) goto L20;
        this.f646a = gk.a(r100.mo9269a());
        goto L32
    L20:
        ic.a(r100, r102);
        goto L32
    L22:
        if (r102 != 15) goto L28;
        hx r104 = r100.mo9272a();
        this.f648a = new ArrayList(r104.f952a);
        int r105 = 0;
    L25:
        if (r105 >= r104.f952a) goto L27;
        gp r106 = new gp();
        r106.a(r100);
        this.f648a.add(r106);
        r105 = r105 + 1;
        goto L25
    L27:
        r100.i();
        goto L32
    L28:
        ic.a(r100, r102);
        goto L32
    L5:
        r100.f();
        if (m9146a() == false) goto L10;
        m9145a();
        return;
    L10:
        throw new ia("Required field 'version' was not found in serialized data! Struct: " + toString());
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m9147a(gn r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (this.f645a == r100.f645a) goto L8;
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
        return true;
    L20:
        if (r103 == false) goto L28;
        if (r104 == false) goto L28;
        if (this.f646a.equals(r100.f646a) == true) goto L29;
        return false;
    L29:
        return true;
    L28:
        return false;
    L11:
        if (r101 == false) goto L28;
        if (r102 == false) goto L28;
        if (this.f648a.equals(r100.f648a) == true) goto L17;
        return false;
    }

    public void a(boolean r100) {
        this.f647a.set(0, r100);
    }
}
