package v1b;

import com.ss.android.lark.chameleonv2.container.webcontainer.ChameleonWebViewManager;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import e0c.k;
import f0c.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class c extends c0c.b implements a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a f552656b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f552657c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.convention.b<a> f552658d;

    @Override // v1b.a
    public final ChameleonWebViewManager F2() {
        return this.f552656b.F2();
    }

    @Override // v1b.a
    public final void destroyAll() {
        this.f552656b.destroyAll();
    }

    @Override // c0c.b
    public final void lf(f0c.b r100) {
        Intrinsics.checkNotNullParameter(r100, "toState");
        Intrinsics.checkNotNullParameter(r100, "toState");
        this.f552658d.c().destroyAll();
    }

    public c(j r100, v r101) {
        UserSession r102 = r100.b();
        if (r102 != null) goto L5;
        r102 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<a> r103 = new com.ss.android.lark.passportc.convention.b(k.b(r101.c(r102), a.class), a.class);
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        Intrinsics.checkNotNullParameter(r103, "proxy");
        super(r100);
        this.f552656b = r103.b();
        this.f552657c = r101;
        this.f552658d = r103;
    }

    @Override // c0c.b
    public final void qf(g r100, g r101) {
        v r102 = this.f552657c;
        if (r101 == null) goto L6;
        UserSession r103 = r101.f475034b;
        if (r103 == null) goto L6;
    L7:
        a r104 = (a) k.b(r102.c(r103), a.class);
        this.f552658d.e(r104);
        return;
    L6:
        r103 = ContainerConstsKt.a();
        goto L7
    }
}
