package com.ss.android.lark.audit.userscope.audit;

import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import com.ss.android.lark.pb.security_event.Event;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class i extends c0c.b implements l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l f409495b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f409496c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.convention.b<l> f409497d;

    @Override // com.ss.android.lark.audit.userscope.audit.j
    public final void Qe(Event r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        this.f409495b.Qe(r100);
    }

    @Override // com.ss.android.lark.audit.userscope.audit.l
    public final void a4() {
        this.f409495b.a4();
    }

    @Override // c0c.b
    public final void qf(f0c.g r100, f0c.g r101) {
        v r102 = this.f409496c;
        if (r101 == null) goto L6;
        UserSession r103 = r101.f475034b;
        if (r103 == null) goto L6;
    L7:
        l r104 = (l) e0c.k.b(r102.c(r103), l.class);
        this.f409497d.e(r104);
        return;
    L6:
        r103 = ContainerConstsKt.a();
        goto L7
    }

    @Inject
    public i(com.ss.android.lark.passportc.api.j r100, v r101, com.ss.android.lark.passportc.convention.b<l> r102) {
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        Intrinsics.checkNotNullParameter(r102, "proxy");
        super(r100);
        this.f409495b = r102.b();
        this.f409496c = r101;
        this.f409497d = r102;
    }
}
