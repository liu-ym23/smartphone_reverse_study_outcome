package com.ss.android.lark.flow.notification.online.proxy;

import c0c.b;
import com.ss.android.lark.notification.export.entity.CurrentProcess;
import com.ss.android.lark.notification.export.entity.Notice;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import e0c.k;
import f0c.g;
import kotlin.jvm.internal.Intrinsics;
import zsb.c;

/* JADX INFO: loaded from: classes36.dex */
public final class a extends b implements c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f423773b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f423774c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.convention.b<c> f423775d;

    /* JADX INFO: renamed from: com.ss.android.lark.flow.notification.online.proxy.a$a, reason: collision with other inner class name */
    public static final class C5005a {
    }

    static {
    }

    @Override // c0c.b
    public final void mf(g r100) {
        Intrinsics.checkNotNullParameter(r100, "user");
        Intrinsics.checkNotNullParameter(r100, "user");
        thb.a.b("NotificationPushManagerProxy", "destroy, sessionKey = " + r100.f475034b.f438137a);
    }

    @Override // c0c.b
    public final void of(g r100) {
        Intrinsics.checkNotNullParameter(r100, "user");
        Intrinsics.checkNotNullParameter(r100, "user");
        thb.a.b("NotificationPushManagerProxy", "onPrepared, sessionKey = " + r100.f475034b.f438137a);
    }

    public a(j r100, v r101) {
        UserSession r102 = r100.b();
        if (r102 != null) goto L5;
        r102 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<c> r103 = new com.ss.android.lark.passportc.convention.b(k.b(r101.c(r102), c.class), c.class);
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        Intrinsics.checkNotNullParameter(r103, "proxy");
        super(r100);
        this.f423773b = r103.b();
        this.f423774c = r101;
        this.f423775d = r103;
    }

    @Override // zsb.c
    public final void R2(Notice r100, CurrentProcess r101) {
        this.f423775d.b().R2(r100, r101);
    }

    @Override // c0c.b
    public final void qf(g r100, g r101) {
        v r102 = this.f423774c;
        if (r101 == null) goto L6;
        UserSession r103 = r101.f475034b;
        if (r103 == null) goto L6;
    L7:
        c r104 = (c) k.b(r102.c(r103), c.class);
        this.f423775d.e(r104);
        thb.a.b("NotificationPushManagerProxy", "preparing, updateInstance hashCode: " + r104.hashCode());
        return;
    L6:
        r103 = ContainerConstsKt.a();
        goto L7
    }
}
