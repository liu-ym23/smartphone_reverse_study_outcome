package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* JADX INFO: loaded from: classes41.dex */
public class gm implements hp<gm, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final hw f463794a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final ie f639a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final hw f463795b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final hw f463796c = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f640a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public gg f641a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f642a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private BitSet f643a;

    public int hashCode() {
        return 0;
    }

    static {
        f639a = new ie("DataCollectionItem");
        f463794a = new hw("", (byte) 10, 1);
        f463795b = new hw("", (byte) 8, 2);
        f463796c = new hw("", (byte) 11, 3);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m9141a() {
        if (this.f641a == null) goto L10;
        if (this.f642a == null) goto L8;
        return;
    L8:
        throw new ia("Required field 'content' was not present! Struct: " + toString());
    L10:
        throw new ia("Required field 'collectionType' was not present! Struct: " + toString());
    }

    public boolean b() {
        if (this.f641a == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean c() {
        if (this.f642a == null) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("DataCollectionItem(collectedAt:");
        r100.append(this.f640a);
        r100.append(", ");
        r100.append("collectionType:");
        gg r101 = this.f641a;
        if (r101 != null) goto L5;
        r100.append("null");
    L6:
        r100.append(", ");
        r100.append("content:");
        String r102 = this.f642a;
        if (r102 != null) goto L9;
        r100.append("null");
    L10:
        r100.append(")");
        return r100.toString();
    L9:
        r100.append(r102);
        goto L10
    L5:
        r100.append(r101);
        goto L6
    }

    public gm() {
        this.f643a = new BitSet(1);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m9142a() {
        return this.f643a.get(0);
    }

    public String a() {
        return this.f642a;
    }

    public int a(gm r100) {
        if (getClass().equals(r100.getClass()) == false) goto L5;
        int r101 = Boolean.valueOf(m9142a()).compareTo(Boolean.valueOf(r100.m9142a()));
        if (r101 == 0) goto L10;
        return r101;
    L10:
        if (m9142a() == false) goto L14;
        int r102 = hq.a(this.f640a, r100.f640a);
        if (r102 == 0) goto L14;
        return r102;
    L14:
        int r103 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(r100.b()));
        if (r103 == 0) goto L18;
        return r103;
    L18:
        if (b() == false) goto L22;
        int r104 = hq.a(this.f641a, r100.f641a);
        if (r104 == 0) goto L22;
        return r104;
    L22:
        int r105 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(r100.c()));
        if (r105 == 0) goto L26;
        return r105;
    L26:
        if (c() == false) goto L30;
        int r106 = hq.a(this.f642a, r100.f642a);
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
        m9141a();
        r100.a(f639a);
        r100.a(f463794a);
        r100.a(this.f640a);
        r100.b();
        if (this.f641a == null) goto L6;
        r100.a(f463795b);
        r100.mo9280a(this.f641a.a());
        r100.b();
    L6:
        if (this.f642a == null) goto L8;
        r100.a(f463796c);
        r100.a(this.f642a);
        r100.b();
    L8:
        r100.c();
        r100.mo9279a();
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(Object r100) {
        return a((gm) r100);
    }

    public boolean equals(Object r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if ((r100 instanceof gm) == true) goto L8;
        return false;
    L8:
        return m9143a((gm) r100);
    }

    @Override // com.xiaomi.push.hp
    public void a(hz r100) {
        r100.mo9275a();
    L3:
        hw r101 = r100.mo9271a();
        byte r102 = r101.f464095a;
        if (r102 == 0) goto L5;
        short r103 = r101.f951a;
        if (r103 == 1) goto L27;
        if (r103 == 2) goto L23;
        if (r103 == 3) goto L19;
        ic.a(r100, r102);
    L30:
        r100.g();
        goto L3
    L19:
        if (r102 != 11) goto L21;
        this.f642a = r100.mo9276a();
        goto L30
    L21:
        ic.a(r100, r102);
        goto L30
    L23:
        if (r102 != 8) goto L25;
        this.f641a = gg.a(r100.mo9269a());
        goto L30
    L25:
        ic.a(r100, r102);
        goto L30
    L27:
        if (r102 != 10) goto L29;
        this.f640a = r100.mo9270a();
        a(true);
        goto L30
    L29:
        ic.a(r100, r102);
        goto L30
    L5:
        r100.f();
        if (m9142a() == false) goto L10;
        m9141a();
        return;
    L10:
        throw new ia("Required field 'collectedAt' was not found in serialized data! Struct: " + toString());
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m9143a(gm r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (this.f640a == r100.f640a) goto L8;
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
        if (this.f642a.equals(r100.f642a) == true) goto L29;
        return false;
    L29:
        return true;
    L28:
        return false;
    L11:
        if (r101 == false) goto L28;
        if (r102 == false) goto L28;
        if (this.f641a.equals(r100.f641a) == true) goto L17;
        return false;
    }

    public gm a(long r100) {
        this.f640a = r100;
        a(true);
        return this;
    }

    public void a(boolean r100) {
        this.f643a.set(0, r100);
    }

    public gm a(gg r100) {
        this.f641a = r100;
        return this;
    }

    public gm a(String r100) {
        this.f642a = r100;
        return this;
    }
}
