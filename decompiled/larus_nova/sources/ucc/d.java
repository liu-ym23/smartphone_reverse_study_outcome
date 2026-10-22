package ucc;

import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import e0c.k;
import f0c.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class d extends c0c.b implements a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a f549702b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f549703c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.convention.b<a> f549704d;

    @Override // ucc.a
    public final int V3(String r100) {
        return this.f549702b.V3(r100);
    }

    @Override // ucc.a
    public final void b7(String r100, int r101) {
        this.f549702b.b7(r100, r101);
    }

    @Override // ucc.a
    public final void oa(String r100) {
        this.f549702b.oa(r100);
    }

    public d(j r100, v r101) {
        UserSession r102 = r100.b();
        if (r102 != null) goto L5;
        r102 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<a> r103 = new com.ss.android.lark.passportc.convention.b(k.b(r101.c(r102), a.class), a.class);
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        Intrinsics.checkNotNullParameter(r103, "proxy");
        super(r100);
        this.f549702b = r103.b();
        this.f549703c = r101;
        this.f549704d = r103;
    }

    @Override // c0c.b
    public final void qf(g r100, g r101) {
        if (r101 == null) goto L5;
        UserSession r102 = r101.f475034b;
        if (r102 == null) goto L5;
    L6:
        a r103 = (a) k.b(this.f549703c.c(r102), a.class);
        this.f549704d.e(r103);
        return;
    L5:
        r102 = ContainerConstsKt.a();
        goto L6
    }
}
