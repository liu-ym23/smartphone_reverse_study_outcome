package com.ss.android.lark.passportc.api;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final d f438111g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f438112a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ExecuteStrategy f438113b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j0c.a f438114c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Scene f438115d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ReturnType f438116e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f438117f;

    public static final class a {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d() {
        boolean r100 = false;
        Object[] r101 = 0 == true ? 1 : 0;
        this(r100, null, r101, 63);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (this.f438112a == r101.f438112a) goto L12;
        return false;
    L12:
        if (this.f438113b == r101.f438113b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f438114c, r101.f438114c) == true) goto L18;
        return false;
    L18:
        if (this.f438115d == r101.f438115d) goto L21;
        return false;
    L21:
        if (this.f438116e == r101.f438116e) goto L24;
        return false;
    L24:
        if (this.f438117f == r101.f438117f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f438112a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = ((r101 * 31) + this.f438113b.hashCode()) * 31;
        j0c.a r103 = this.f438114c;
        int r104 = 0;
        if (r103 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r102 + r105) * 31;
        Scene r107 = this.f438115d;
        if (r107 == null) goto L14;
        r104 = r107.hashCode();
    L14:
        int r108 = (((r106 + r104) * 31) + this.f438116e.hashCode()) * 31;
        if (this.f438117f == true) goto L19;
        r100 = 1237;
    L19:
        return r108 + r100;
    L9:
        r105 = r103.hashCode();
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "ExecuteMode(executeTask=" + this.f438112a + ", executeStrategy=" + this.f438113b + ", preExecuteTaskResult=" + this.f438114c + ", scene=" + this.f438115d + ", returnType=" + this.f438116e + ", enqueueSynchronously=" + this.f438117f + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        boolean r100 = false;
        Object[] r101 = 0 == true ? 1 : 0;
        f438111g = new d(r100, null, r101, 62);
    }

    public static d a(d r100, Scene r101) {
        boolean r102 = r100.f438112a;
        ExecuteStrategy r103 = r100.f438113b;
        j0c.a r104 = r100.f438114c;
        ReturnType r105 = r100.f438116e;
        boolean r106 = r100.f438117f;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r103, "executeStrategy");
        Intrinsics.checkNotNullParameter(r105, "returnType");
        return new d(r102, r103, r104, r101, r105, r106);
    }

    public /* synthetic */ d(boolean r100, Scene r101, ReturnType r110, int r111) {
        if ((r111 & 1) == 0) goto L5;
        boolean r102 = false;
    L7:
        if ((r111 & 2) == 0) goto L9;
        ExecuteStrategy r103 = ExecuteStrategy.NORMAL;
    L11:
        if ((r111 & 8) == 0) goto L13;
        Scene r104 = null;
    L15:
        if ((r111 & 16) == 0) goto L17;
        r110 = ReturnType.All;
    L17:
        this(r102, r103, null, r104, r110, false);
        return;
    L13:
        r104 = r101;
        goto L15
    L9:
        r103 = null;
        goto L11
    L5:
        r102 = r100;
        goto L7
    }

    public d(boolean r100, ExecuteStrategy r101, j0c.a r102, Scene r103, ReturnType r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r101, "executeStrategy");
        Intrinsics.checkNotNullParameter(r104, "returnType");
        this.f438112a = r100;
        this.f438113b = r101;
        this.f438114c = r102;
        this.f438115d = r103;
        this.f438116e = r104;
        this.f438117f = r105;
    }
}
