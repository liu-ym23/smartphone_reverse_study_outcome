package com.larus.dora.impl.device.ailab;

/* JADX INFO: loaded from: classes27.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f333529a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f333530b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f333531c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f333532d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f333533e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f333534f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f333529a == r101.f333529a) goto L12;
        return false;
    L12:
        if (this.f333530b == r101.f333530b) goto L15;
        return false;
    L15:
        if (this.f333531c == r101.f333531c) goto L18;
        return false;
    L18:
        if (this.f333532d == r101.f333532d) goto L21;
        return false;
    L21:
        if (this.f333533e == r101.f333533e) goto L24;
        return false;
    L24:
        if (this.f333534f == r101.f333534f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f333529a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f333530b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f333531c == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.f333532d == false) goto L17;
        int r107 = 1231;
    L18:
        int r108 = (r106 + r107) * 31;
        if (this.f333533e == false) goto L21;
        int r109 = 1231;
    L22:
        int r110 = (r108 + r109) * 31;
        if (this.f333534f == true) goto L27;
        r100 = 1237;
    L27:
        return r110 + r100;
    L21:
        r109 = 1237;
        goto L22
    L17:
        r107 = 1237;
        goto L18
    L13:
        r105 = 1237;
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "AiLabAbility(isSupportWakeupGestureUnify=" + this.f333529a + ", isSupportMultiUserModel=" + this.f333530b + ", isSupportDecouplingWakeup=" + this.f333531c + ", isSupportWakeupStartAndEndSound=" + this.f333532d + ", isSupportVisualIntentSound=" + this.f333533e + ", isSupportNaturalWakeup=" + this.f333534f + ')';
    }

    public a(boolean r100, boolean r101, boolean r102, boolean r103, boolean r104, boolean r105) {
        this.f333529a = r100;
        this.f333530b = r101;
        this.f333531c = r102;
        this.f333532d = r103;
        this.f333533e = r104;
        this.f333534f = r105;
    }
}
