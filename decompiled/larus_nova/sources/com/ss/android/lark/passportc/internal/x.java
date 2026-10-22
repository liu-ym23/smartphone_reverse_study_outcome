package com.ss.android.lark.passportc.internal;

import com.bytedance.common.wschannel.WsConstants;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.entity.UserSession;
import dagger.hilt.dwarf.lifecycle.LifecycleComponentManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class x extends LifecycleComponentManager<UserSession, e0c.l, f0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b0 f438484a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.ss.android.lark.log.c f438485b;

    public x(b0 r100, com.ss.android.lark.log.c r101) {
        Intrinsics.checkNotNullParameter(r100, "componentProviders");
        Intrinsics.checkNotNullParameter(r101, "logger");
        this.f438484a = r100;
        this.f438485b = r101;
    }

    @Override // dagger.hilt.dwarf.lifecycle.LifecycleComponentManager
    public final e0c.l createComponent(UserSession r100, f0 r101) {
        UserSession r102 = r100;
        f0 r103 = r101;
        Intrinsics.checkNotNullParameter(r102, "key");
        Intrinsics.checkNotNullParameter(r103, WsConstants.KEY_PAYLOAD);
        e0c.l r104 = this.f438484a.a().userSession(r102).a(r103).b(r103.getUser().userId).build();
        com.ss.android.lark.log.c r105 = this.f438485b;
        StringBuilder r106 = new StringBuilder("createUserComponent, uid=");
        a r107 = a.f438455a;
        r106.append(ContainerConstsKt.a().f438138b);
        m0c.b.b(r105, r106.toString());
        return r104;
    }
}
