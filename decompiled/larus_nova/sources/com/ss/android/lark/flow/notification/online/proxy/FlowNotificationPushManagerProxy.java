package com.ss.android.lark.flow.notification.online.proxy;

import c0c.b;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import e0c.k;
import f0c.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class FlowNotificationPushManagerProxy extends b implements zsb.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zsb.a f423770b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f423771c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.convention.b<zsb.a> f423772d;

    public static final class a {
    }

    static {
    }

    @Override // c0c.b
    public final void mf(g r100) {
        Intrinsics.checkNotNullParameter(r100, "user");
        Intrinsics.checkNotNullParameter(r100, "user");
        thb.a.b("FlowNotificationPushManagerProxy", "destroy, sessionKey = " + r100.f475034b.f438137a);
    }

    @Override // zsb.a
    public final void n9(ctb.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f423772d.d(new com.ss.android.lark.passportc.convention.b.C5239b(ctb.a.class, r100));
    }

    @Override // c0c.b
    public final void of(g r100) {
        Intrinsics.checkNotNullParameter(r100, "user");
        Intrinsics.checkNotNullParameter(r100, "user");
        thb.a.b("FlowNotificationPushManagerProxy", "onPrepared, sessionKey = " + r100.f475034b.f438137a);
    }

    @Override // zsb.a
    public final void t4(final ctb.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f423772d.a(new com.ss.android.lark.passportc.convention.b.C5239b(ctb.a.class, r100), new com.ss.android.lark.passportc.convention.b.c(new FlowNotificationPushManagerProxy$addPushNotificationListener$1(r100), new FlowNotificationPushManagerProxy$addPushNotificationListener$2(r100)));
    }

    public FlowNotificationPushManagerProxy(j r100, v r101) {
        UserSession r102 = r100.b();
        if (r102 != null) goto L5;
        r102 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<zsb.a> r103 = new com.ss.android.lark.passportc.convention.b(k.b(r101.c(r102), zsb.a.class), zsb.a.class);
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        Intrinsics.checkNotNullParameter(r103, "proxy");
        super(r100);
        this.f423770b = r103.b();
        this.f423771c = r101;
        this.f423772d = r103;
    }

    @Override // c0c.b
    public final void qf(g r100, g r101) {
        v r102 = this.f423771c;
        if (r101 == null) goto L6;
        UserSession r103 = r101.f475034b;
        if (r103 == null) goto L6;
    L7:
        zsb.a r104 = (zsb.a) k.b(r102.c(r103), zsb.a.class);
        this.f423772d.e(r104);
        thb.a.b("FlowNotificationPushManagerProxy", "preparing, updateInstance hashCode: " + r104.hashCode());
        return;
    L6:
        r103 = ContainerConstsKt.a();
        goto L7
    }
}
