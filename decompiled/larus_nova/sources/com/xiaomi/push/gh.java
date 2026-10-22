package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes41.dex */
public class gh implements hp<gh, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final hw f463698a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final ie f618a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<gi> f619a;

    public int hashCode() {
        return 0;
    }

    static {
        f618a = new ie("ClientUploadData");
        f463698a = new hw("", (byte) 15, 1);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m9128a() {
        if (this.f619a == null) goto L6;
        return;
    L6:
        throw new ia("Required field 'uploadDataItems' was not present! Struct: " + toString());
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("ClientUploadData(uploadDataItems:");
        List<gi> r101 = this.f619a;
        if (r101 != null) goto L5;
        r100.append("null");
    L6:
        r100.append(")");
        return r100.toString();
    L5:
        r100.append(r101);
        goto L6
    }

    public gh() {
    }

    public int a() {
        List<gi> r100 = this.f619a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.size();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m9129a() {
        if (this.f619a == null) goto L5;
        return true;
    L5:
        return false;
    }

    public int a(gh r100) {
        if (getClass().equals(r100.getClass()) == false) goto L5;
        int r101 = Boolean.valueOf(m9129a()).compareTo(Boolean.valueOf(r100.m9129a()));
        if (r101 == 0) goto L10;
        return r101;
    L10:
        if (m9129a() == false) goto L14;
        int r102 = hq.a(this.f619a, r100.f619a);
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
        m9128a();
        r100.a(f618a);
        if (this.f619a == null) goto L9;
        r100.a(f463698a);
        r100.a(new hx((byte) 12, this.f619a.size()));
        Iterator<gi> r101 = this.f619a.iterator();
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
        return a((gh) r100);
    }

    public boolean equals(Object r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if ((r100 instanceof gh) == true) goto L8;
        return false;
    L8:
        return m9130a((gh) r100);
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
        this.f619a = new ArrayList(r103.f952a);
        int r104 = 0;
    L14:
        if (r104 >= r103.f952a) goto L16;
        gi r105 = new gi();
        r105.a(r100);
        this.f619a.add(r105);
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
        m9128a();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m9130a(gh r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        boolean r101 = m9129a();
        boolean r102 = r100.m9129a();
        if (r101 == true) goto L8;
        if (r102 == true) goto L8;
        return true;
    L8:
        if (r101 == false) goto L16;
        if (r102 == false) goto L16;
        if (this.f619a.equals(r100.f619a) == true) goto L17;
        return false;
    L17:
        return true;
    L16:
        return false;
    }

    public void a(gi r100) {
        if (this.f619a != null) goto L5;
        this.f619a = new ArrayList();
    L5:
        this.f619a.add(r100);
    }
}
