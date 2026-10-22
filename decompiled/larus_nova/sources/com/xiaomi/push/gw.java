package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* JADX INFO: loaded from: classes41.dex */
public class gw implements hp<gw, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final hw f463913a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final ie f739a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final hw f463914b = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f740a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private BitSet f741a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f742b;

    public void a() {
    }

    public int hashCode() {
        return 0;
    }

    static {
        f739a = new ie("XmPushActionCheckClientInfo");
        f463913a = new hw("", (byte) 8, 1);
        f463914b = new hw("", (byte) 8, 2);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m9183a() {
        return this.f741a.get(0);
    }

    public boolean b() {
        return this.f741a.get(1);
    }

    public String toString() {
        return "XmPushActionCheckClientInfo(miscConfigVersion:" + this.f740a + ", pluginConfigVersion:" + this.f742b + ")";
    }

    public gw() {
        this.f741a = new BitSet(2);
    }

    @Override // com.xiaomi.push.hp
    public void a(hz r100) {
        r100.mo9275a();
    L3:
        hw r101 = r100.mo9271a();
        byte r102 = r101.f464095a;
        if (r102 == 0) goto L5;
        short r103 = r101.f951a;
        if (r103 != 1) goto L18;
        if (r102 != 8) goto L25;
        this.f740a = r100.mo9269a();
        a(true);
    L26:
        r100.g();
        goto L3
    L25:
        ic.a(r100, r102);
        goto L26
    L18:
        if (r103 == 2) goto L20;
        ic.a(r100, r102);
        goto L26
    L20:
        if (r102 != 8) goto L22;
        this.f742b = r100.mo9269a();
        b(true);
        goto L26
    L22:
        ic.a(r100, r102);
        goto L26
    L5:
        r100.f();
        if (m9183a() == false) goto L14;
        if (b() == false) goto L12;
        a();
        return;
    L12:
        throw new ia("Required field 'pluginConfigVersion' was not found in serialized data! Struct: " + toString());
    L14:
        throw new ia("Required field 'miscConfigVersion' was not found in serialized data! Struct: " + toString());
    }

    @Override // com.xiaomi.push.hp
    public void b(hz r100) {
        a();
        r100.a(f739a);
        r100.a(f463913a);
        r100.mo9280a(this.f740a);
        r100.b();
        r100.a(f463914b);
        r100.mo9280a(this.f742b);
        r100.b();
        r100.c();
        r100.mo9279a();
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(Object r100) {
        return a((gw) r100);
    }

    public boolean equals(Object r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if ((r100 instanceof gw) == true) goto L8;
        return false;
    L8:
        return m9184a((gw) r100);
    }

    public int a(gw r100) {
        if (getClass().equals(r100.getClass()) == false) goto L5;
        int r101 = Boolean.valueOf(m9183a()).compareTo(Boolean.valueOf(r100.m9183a()));
        if (r101 == 0) goto L10;
        return r101;
    L10:
        if (m9183a() == false) goto L14;
        int r102 = hq.a(this.f740a, r100.f740a);
        if (r102 == 0) goto L14;
        return r102;
    L14:
        int r103 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(r100.b()));
        if (r103 == 0) goto L18;
        return r103;
    L18:
        if (b() == false) goto L22;
        int r104 = hq.a(this.f742b, r100.f742b);
        if (r104 == 0) goto L24;
        return r104;
    L24:
        return 0;
    L22:
        return 0;
    L5:
        return getClass().getName().compareTo(r100.getClass().getName());
    }

    public gw b(int r100) {
        this.f742b = r100;
        b(true);
        return this;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m9184a(gw r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (this.f740a == r100.f740a) goto L9;
        return false;
    L9:
        if (this.f742b == r100.f742b) goto L11;
        return false;
    L11:
        return true;
    }

    public void b(boolean r100) {
        this.f741a.set(1, r100);
    }

    public gw a(int r100) {
        this.f740a = r100;
        a(true);
        return this;
    }

    public void a(boolean r100) {
        this.f741a.set(0, r100);
    }
}
