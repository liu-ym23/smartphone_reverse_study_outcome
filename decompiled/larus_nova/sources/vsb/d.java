package vsb;

import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import e0c.k;
import f0c.g;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class d extends c0c.b implements rsb.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ rsb.b f557168b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f557169c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.convention.b<rsb.b> f557170d;

    @Override // rsb.b
    public final void P4() {
        this.f557168b.P4();
    }

    @Override // rsb.b, rsb.a.InterfaceC7530a
    public final void k0(int r100, List<String> r101) {
        this.f557168b.k0(Integer.MIN_VALUE, null);
    }

    public d(j r100, v r101) {
        UserSession r102 = r100.b();
        if (r102 != null) goto L5;
        r102 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<rsb.b> r103 = new com.ss.android.lark.passportc.convention.b(k.b(r101.c(r102), rsb.b.class), rsb.b.class);
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        Intrinsics.checkNotNullParameter(r103, "proxy");
        super(r100);
        this.f557168b = r103.b();
        this.f557169c = r101;
        this.f557170d = r103;
    }

    @Override // c0c.b
    public final void pf(g r100, f0c.b r101) {
        Intrinsics.checkNotNullParameter(r101, "toState");
        v r102 = this.f557169c;
        g r103 = r101.a();
        if (r103 == null) goto L6;
        UserSession r104 = r103.f475034b;
        if (r104 == null) goto L6;
    L7:
        rsb.b r105 = (rsb.b) k.b(r102.c(r104), rsb.b.class);
        this.f557170d.e(r105);
        return;
    L6:
        r104 = ContainerConstsKt.a();
        goto L7
    }
}
