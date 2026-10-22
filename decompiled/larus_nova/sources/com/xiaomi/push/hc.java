package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes41.dex */
public class hc implements hp<hc, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final hw f463946a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final ie f781a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<gn> f782a;

    public int hashCode() {
        return 0;
    }

    static {
        f781a = new ie("XmPushActionNormalConfig");
        f463946a = new hw("", (byte) 15, 1);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m9209a() {
        if (this.f782a == null) goto L6;
        return;
    L6:
        throw new ia("Required field 'normalConfigs' was not present! Struct: " + toString());
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("XmPushActionNormalConfig(normalConfigs:");
        List<gn> r101 = this.f782a;
        if (r101 != null) goto L5;
        r100.append("null");
    L6:
        r100.append(")");
        return r100.toString();
    L5:
        r100.append(r101);
        goto L6
    }

    public hc() {
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m9210a() {
        if (this.f782a == null) goto L5;
        return true;
    L5:
        return false;
    }

    public List<gn> a() {
        return this.f782a;
    }

    public int a(hc r100) {
        if (getClass().equals(r100.getClass()) == false) goto L5;
        int r101 = Boolean.valueOf(m9210a()).compareTo(Boolean.valueOf(r100.m9210a()));
        if (r101 == 0) goto L10;
        return r101;
    L10:
        if (m9210a() == false) goto L14;
        int r102 = hq.a(this.f782a, r100.f782a);
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
        m9209a();
        r100.a(f781a);
        if (this.f782a == null) goto L9;
        r100.a(f463946a);
        r100.a(new hx((byte) 12, this.f782a.size()));
        Iterator<gn> r101 = this.f782a.iterator();
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
        return a((hc) r100);
    }

    public boolean equals(Object r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if ((r100 instanceof hc) == true) goto L8;
        return false;
    L8:
        return m9211a((hc) r100);
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
        this.f782a = new ArrayList(r103.f952a);
        int r104 = 0;
    L14:
        if (r104 >= r103.f952a) goto L16;
        gn r105 = new gn();
        r105.a(r100);
        this.f782a.add(r105);
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
        m9209a();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m9211a(hc r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        boolean r101 = m9210a();
        boolean r102 = r100.m9210a();
        if (r101 == true) goto L8;
        if (r102 == true) goto L8;
        return true;
    L8:
        if (r101 == false) goto L16;
        if (r102 == false) goto L16;
        if (this.f782a.equals(r100.f782a) == true) goto L17;
        return false;
    L17:
        return true;
    L16:
        return false;
    }
}
