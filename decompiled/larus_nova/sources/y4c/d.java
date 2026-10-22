package y4c;

import com.bytedance.lark.rustclient.api.l;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.h;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import e0c.k;
import f0c.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class d extends c0c.b implements a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a f566173b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f566174c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.convention.b<a> f566175d;

    @Override // y4c.a
    public final void destroy() {
        this.f566173b.destroy();
    }

    @Override // y4c.a
    public final l g() {
        return this.f566173b.g();
    }

    @Override // c0c.b
    public final void lf(f0c.b r100) {
        Intrinsics.checkNotNullParameter(r100, "toState");
        Intrinsics.checkNotNullParameter(r100, "toState");
        this.f566175d.c().destroy();
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
        this.f566173b = r103.b();
        this.f566174c = r101;
        this.f566175d = r103;
        h.a(this);
    }

    @Override // c0c.b
    public final void qf(g r100, g r101) {
        v r102 = this.f566174c;
        if (r101 == null) goto L6;
        UserSession r103 = r101.f475034b;
        if (r103 == null) goto L6;
    L7:
        a r104 = (a) k.b(r102.c(r103), a.class);
        this.f566175d.e(r104);
        return;
    L6:
        r103 = ContainerConstsKt.a();
        goto L7
    }
}
