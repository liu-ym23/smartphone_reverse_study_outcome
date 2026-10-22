package yra;

import com.ss.android.ainote.AINoteContext;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import e0c.k;
import f0c.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class d extends c0c.b implements e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f568941b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f568942c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.convention.b<e> f568943d;

    @Override // yra.e
    public final String getUserId() {
        return this.f568941b.getUserId();
    }

    @Override // yra.e
    public final AINoteContext wc() {
        return this.f568941b.wc();
    }

    public d(j r100, v r101) {
        UserSession r102 = r100.b();
        if (r102 != null) goto L5;
        r102 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<e> r103 = new com.ss.android.lark.passportc.convention.b(k.b(r101.c(r102), e.class), e.class);
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        Intrinsics.checkNotNullParameter(r103, "proxy");
        super(r100);
        this.f568941b = r103.b();
        this.f568942c = r101;
        this.f568943d = r103;
    }

    @Override // c0c.b
    public final void qf(g r100, g r101) {
        v r102 = this.f568942c;
        if (r101 == null) goto L6;
        UserSession r103 = r101.f475034b;
        if (r103 == null) goto L6;
    L7:
        e r104 = (e) k.b(r102.c(r103), e.class);
        this.f568943d.e(r104);
        return;
    L6:
        r103 = ContainerConstsKt.a();
        goto L7
    }
}
