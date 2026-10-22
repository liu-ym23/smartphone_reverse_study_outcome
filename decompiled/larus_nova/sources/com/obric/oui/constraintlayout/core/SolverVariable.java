package com.obric.oui.constraintlayout.core;

import java.util.Arrays;

/* JADX INFO: loaded from: classes34.dex */
public final class SolverVariable implements Comparable<SolverVariable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f399606a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f399607b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f399608c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f399609d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f399610e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f399611f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float[] f399612g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float[] f399613h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Type f399614i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public b[] f399615j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f399616k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f399617l;

    public static final enum Type extends Enum<Type> {
        public static final Type CONSTANT = null;
        public static final Type ERROR = null;
        public static final Type SLACK = null;
        public static final Type UNKNOWN = null;
        public static final Type UNRESTRICTED = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Type[] f399618a = null;

        static {
            Type r100 = new Type("UNRESTRICTED", 0);
            UNRESTRICTED = r100;
            Type r101 = new Type("CONSTANT", 1);
            CONSTANT = r101;
            Type r102 = new Type("SLACK", 2);
            SLACK = r102;
            Type r103 = new Type("ERROR", 3);
            ERROR = r103;
            Type r104 = new Type("UNKNOWN", 4);
            UNKNOWN = r104;
            f399618a = new Type[]{r100, r101, r102, r103, r104};
        }

        public static Type[] values() {
            return (Type[]) f399618a.clone();
        }

        public static Type valueOf(String r100) {
            return (Type) r27.a.a(Type.class, r100);
        }

        public Type(String r100, int r101) {
            super(r100, r101);
        }
    }

    public final void c() {
        this.f399614i = Type.UNKNOWN;
        this.f399609d = 0;
        this.f399607b = -1;
        this.f399608c = -1;
        this.f399610e = 0.0f;
        this.f399611f = false;
        int r100 = this.f399616k;
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L5;
        this.f399615j[r101] = null;
        r101 = r101 + 1;
        goto L3
    L5:
        this.f399616k = 0;
        this.f399617l = 0;
        this.f399606a = false;
        Arrays.fill(this.f399613h, 0.0f);
    }

    public final String toString() {
        return "" + this.f399607b;
    }

    public SolverVariable(Type r100) {
        this.f399607b = -1;
        this.f399608c = -1;
        this.f399609d = 0;
        this.f399611f = false;
        this.f399612g = new float[9];
        this.f399613h = new float[9];
        this.f399615j = new b[16];
        this.f399616k = 0;
        this.f399617l = 0;
        this.f399614i = r100;
    }

    public final void a(b r100) {
        int r101 = 0;
    L3:
        int r102 = this.f399616k;
        if (r101 >= r102) goto L9;
        if (this.f399615j[r101] == r100) goto L7;
        r101 = r101 + 1;
        goto L3
    L7:
        return;
    L9:
        b[] r103 = this.f399615j;
        if (r102 < r103.length) goto L12;
        this.f399615j = (b[]) Arrays.copyOf(r103, r103.length * 2);
    L12:
        b[] r104 = this.f399615j;
        int r105 = this.f399616k;
        r104[r105] = r100;
        this.f399616k = r105 + 1;
    }

    public final void b(b r100) {
        int r101 = this.f399616k;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L12;
        if (this.f399615j[r102] == r100) goto L7;
        r102 = r102 + 1;
    L7:
        if (r102 >= (r101 - 1)) goto L9;
        b[] r103 = this.f399615j;
        int r104 = r102 + 1;
        r103[r102] = r103[r104];
        r102 = r104;
        goto L7
    L9:
        this.f399616k--;
        return;
    }

    @Override // java.lang.Comparable
    public final int compareTo(SolverVariable r100) {
        return this.f399607b - r100.f399607b;
    }

    public final void d(c r100, float r101) {
        this.f399610e = r101;
        this.f399611f = true;
        int r102 = this.f399616k;
        this.f399608c = -1;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        this.f399615j[r103].h(r100, this, false);
        r103 = r103 + 1;
        goto L3
    L5:
        this.f399616k = 0;
    }

    public final void e(c r100, b r101) {
        int r102 = this.f399616k;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        this.f399615j[r103].i(r100, r101, false);
        r103 = r103 + 1;
        goto L3
    L5:
        this.f399616k = 0;
    }
}
