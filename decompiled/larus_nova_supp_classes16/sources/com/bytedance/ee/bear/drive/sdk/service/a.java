package com.bytedance.ee.bear.drive.sdk.service;

import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import e0c.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a extends c0c.b implements f {
    public final /* synthetic */ f b;
    public final v c;
    public final com.ss.android.lark.passportc.convention.b<f> d;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.sdk.service.a$a, reason: collision with other inner class name */
    public static final class C0167a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.drive.sdk.service.f
    public final g d0() {
        return this.b.d0();
    }

    @Override // com.bytedance.ee.bear.drive.sdk.service.f
    public final void onDestroy() {
        this.b.onDestroy();
    }

    public final void lf(f0c.b r4) {
        Intrinsics.checkNotNullParameter(r4, "toState");
        tt5.a.h("DriveSdkServiceProxy", "destroy");
        Intrinsics.checkNotNullParameter(r4, "toState");
        ((f) this.d.c()).onDestroy();
    }

    public a(j r4, v r5) {
        UserSession r1 = r4.b();
        if (r1 != null) goto L5;
        r1 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<f> r0 = new com.ss.android.lark.passportc.convention.b(k.b(r5.c(r1), f.class), f.class);
        Intrinsics.checkNotNullParameter(r4, "passportService");
        Intrinsics.checkNotNullParameter(r5, "accessor");
        Intrinsics.checkNotNullParameter(r0, "proxy");
        super(r4);
        this.b = (f) r0.b();
        this.c = r5;
        this.d = r0;
    }

    public final void qf(f0c.g r2, f0c.g r3) {
        tt5.a.h("DriveSdkServiceProxy", "preparing");
        v r4 = this.c;
        if (r3 == null) goto L6;
        UserSession r5 = r3.b;
        if (r5 == null) goto L6;
    L7:
        f r6 = (f) k.b(r4.c(r5), f.class);
        this.d.e(r6);
        return;
    L6:
        r5 = ContainerConstsKt.a();
        goto L7
    }
}
