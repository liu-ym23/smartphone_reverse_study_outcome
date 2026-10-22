package com.ss.android.lark.tab.service;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class h extends c0c.b implements IChatTabService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IChatTabService f441151b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f441152c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.convention.b<IChatTabService> f441153d;

    public static final class a {
    }

    static {
    }

    public h(com.ss.android.lark.passportc.api.j r100, v r101) {
        UserSession r102 = r100.b();
        if (r102 != null) goto L5;
        r102 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<IChatTabService> r103 = new com.ss.android.lark.passportc.convention.b(e0c.k.b(r101.c(r102), IChatTabService.class), IChatTabService.class);
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        Intrinsics.checkNotNullParameter(r103, "instanceHolder");
        super(r100);
        this.f441151b = r103.b();
        this.f441152c = r101;
        this.f441153d = r103;
    }

    @Override // c0c.b
    public final void qf(f0c.g r100, f0c.g r101) {
        Log.i("ChatTabServiceProxy", "preparing IChatTabService");
        v r102 = this.f441152c;
        if (r101 == null) goto L6;
        UserSession r103 = r101.f475034b;
        if (r103 == null) goto L6;
    L7:
        IChatTabService r104 = (IChatTabService) e0c.k.b(r102.c(r103), IChatTabService.class);
        this.f441153d.e(r104);
        return;
    L6:
        r103 = ContainerConstsKt.a();
        goto L7
    }
}
