package com.ss.android.lark.rustinfrabridge.netstate.impl;

import android.content.Context;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import com.ss.android.lark.utils.statistics.PerfLog;
import e0c.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class UserNetStateServiceProxy extends c0c.b implements g3c.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g3c.a f439703b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f439704c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.convention.b<g3c.a> f439705d;

    public UserNetStateServiceProxy() {
        throw null;
    }

    @Override // g3c.a
    public final void Je(final h3c.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f439705d.a(new com.ss.android.lark.passportc.convention.b.C5239b(h3c.a.class, r100), new com.ss.android.lark.passportc.convention.b.c(new UserNetStateServiceProxy$addConnStateListener$1(r100), new UserNetStateServiceProxy$addConnStateListener$2(r100)));
    }

    @Override // g3c.a
    public final void i5(h3c.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f439705d.d(new com.ss.android.lark.passportc.convention.b.C5239b(h3c.a.class, r100));
    }

    @Override // g3c.a
    public final void v0(final Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f439705d.a(new com.ss.android.lark.passportc.convention.b.C5239b(UserNetStateServiceProxy.class, this), new com.ss.android.lark.passportc.convention.b.c(new UserNetStateServiceProxy$registerPush$1(r100), UserNetStateServiceProxy$registerPush$2.INSTANCE));
    }

    public UserNetStateServiceProxy(j r100, v r101) {
        UserSession r102 = r100.b();
        if (r102 != null) goto L5;
        r102 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<g3c.a> r103 = new com.ss.android.lark.passportc.convention.b(k.b(r101.c(r102), g3c.a.class), g3c.a.class);
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        Intrinsics.checkNotNullParameter(r103, "proxy");
        super(r100);
        this.f439703b = r103.b();
        this.f439704c = r101;
        this.f439705d = r103;
    }

    @Override // c0c.b
    public final void pf(f0c.g r100, f0c.b r101) {
        Intrinsics.checkNotNullParameter(r101, "toState");
        v r102 = this.f439704c;
        f0c.g r103 = r101.a();
        if (r103 == null) goto L6;
        UserSession r104 = r103.f475034b;
        if (r104 == null) goto L6;
    L7:
        g3c.a r105 = (g3c.a) k.b(r102.c(r104), g3c.a.class);
        this.f439705d.e(r105);
        return;
    L6:
        r104 = ContainerConstsKt.a();
        goto L7
    }
}
