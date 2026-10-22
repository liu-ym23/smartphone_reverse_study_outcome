package com.bytedance.ee.bear.bitable.app.chameleon;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.ee.bear.bitable.utils.c.a f206907a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Unit> f206908b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f206909c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f206910d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f206911e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Integer f206912f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Boolean f206913g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f206914h;

    public final void a() {
        int r100 = 0;
        if (this.f206909c == false) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        boolean r102 = this.f206910d;
        if (r102 == true) goto L22;
        r100 = this.f206911e;
    L22:
        boolean r103 = !r102;
        if (this.f206914h == false) goto L32;
        Integer r104 = this.f206912f;
        if (r104 == null) goto L32;
        if (r104.intValue() != r100) goto L32;
        if (Intrinsics.areEqual(this.f206913g, Boolean.valueOf(r103)) == false) goto L32;
        return;
    L32:
        com.bytedance.ee.bear.bitable.utils.c.a r105 = this.f206907a;
        if (r105 != null) goto L35;
        return;
    L35:
        r105.j(r100, r103, !this.f206914h);
        r105.f();
        this.f206914h = true;
        this.f206912f = Integer.valueOf(r100);
        this.f206913g = Boolean.valueOf(r103);
        return;
    L11:
        if (this.f206914h == true) goto L13;
        return;
    L13:
        com.bytedance.ee.bear.bitable.utils.c.a r106 = this.f206907a;
        if (r106 == null) goto L16;
        r106.g();
    L16:
        this.f206914h = false;
        this.f206912f = null;
        this.f206913g = null;
        this.f206908b.invoke();
        return;
    L5:
        if (this.f206910d == true) goto L8;
        r101 = false;
        goto L9
    }

    public c(com.bytedance.ee.bear.bitable.utils.c.a r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "restoreBaseState");
        this.f206907a = r100;
        this.f206908b = r101;
    }
}
