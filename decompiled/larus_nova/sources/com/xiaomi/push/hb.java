package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes41.dex */
public class hb implements hp<hb, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final hw f463945a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final ie f779a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<gp> f780a;

    public int hashCode() {
        return 0;
    }

    static {
        f779a = new ie("XmPushActionCustomConfig");
        f463945a = new hw("", (byte) 15, 1);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m9206a() {
        if (this.f780a == null) goto L6;
        return;
    L6:
        throw new ia("Required field 'customConfigs' was not present! Struct: " + toString());
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("XmPushActionCustomConfig(customConfigs:");
        List<gp> r101 = this.f780a;
        if (r101 != null) goto L5;
        r100.append("null");
    L6:
        r100.append(")");
        return r100.toString();
    L5:
        r100.append(r101);
        goto L6
    }

    public hb() {
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m9207a() {
        if (this.f780a == null) goto L5;
        return true;
    L5:
        return false;
    }

    public List<gp> a() {
        return this.f780a;
    }

    public int a(hb r100) {
        if (getClass().equals(r100.getClass()) == false) goto L5;
        int r101 = Boolean.valueOf(m9207a()).compareTo(Boolean.valueOf(r100.m9207a()));
        if (r101 == 0) goto L10;
        return r101;
    L10:
        if (m9207a() == false) goto L14;
        int r102 = hq.a(this.f780a, r100.f780a);
        if (r102 == 0) goto L16;
        return r102;
    L16:
        return 0;
    L14:
        return 0;
    L5:
        return getClass().getName().compareTo(r100.getClass().getName());
    }

    @Override // com.xiaomi.push.hp
    public void b(hz r100) {
        m9206a();
        r100.a(f779a);
        if (this.f780a == null) goto L9;
        r100.a(f463945a);
        r100.a(new hx((byte) 12, this.f780a.size()));
        Iterator<gp> r101 = this.f780a.iterator();
    L6:
        if (r101.hasNext() == false) goto L8;
        r101.next().b(r100);
        goto L6
    L8:
        r100.e();
        r100.b();
    L9:
        r100.c();
        r100.mo9279a();
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(Object r100) {
        return a((hb) r100);
    }

    public boolean equals(Object r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if ((r100 instanceof hb) == true) goto L8;
        return false;
    L8:
        return m9208a((hb) r100);
    }

    @Override // com.xiaomi.push.hp
    public void a(hz r100) {
        r100.mo9275a();
    L3:
        hw r101 = r100.mo9271a();
        byte r102 = r101.f464095a;
        if (r102 == 0) goto L5;
        if (r101.f951a == 1) goto L11;
        ic.a(r100, r102);
    L18:
        r100.g();
        goto L3
    L11:
        if (r102 != 15) goto L17;
        hx r103 = r100.mo9272a();
        this.f780a = new ArrayList(r103.f952a);
        int r104 = 0;
    L14:
        if (r104 >= r103.f952a) goto L16;
        gp r105 = new gp();
        r105.a(r100);
        this.f780a.add(r105);
        r104 = r104 + 1;
        goto L14
    L16:
        r100.i();
        goto L18
    L17:
        ic.a(r100, r102);
        goto L18
    L5:
        r100.f();
        m9206a();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m9208a(hb r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        boolean r101 = m9207a();
        boolean r102 = r100.m9207a();
        if (r101 == true) goto L8;
        if (r102 == true) goto L8;
        return true;
    L8:
        if (r101 == false) goto L16;
        if (r102 == false) goto L16;
        if (this.f780a.equals(r100.f780a) == true) goto L17;
        return false;
    L17:
        return true;
    L16:
        return false;
    }
}
