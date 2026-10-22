package oeb;

import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import e0c.k;
import f0c.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class c extends c0c.b implements d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f523051b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f523052c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.convention.b<d> f523053d;

    @Override // oeb.d
    public final boolean get() {
        return this.f523051b.get();
    }

    @Override // oeb.d
    public void update(boolean r100) {
        this.f523051b.update(r100);
    }

    public c(j r100, v r101) {
        UserSession r102 = r100.b();
        if (r102 != null) goto L5;
        r102 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<d> r103 = new com.ss.android.lark.passportc.convention.b(k.b(r101.c(r102), d.class), d.class);
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        Intrinsics.checkNotNullParameter(r103, "instanceHolder");
        super(r100);
        this.f523051b = r103.b();
        this.f523052c = r101;
        this.f523053d = r103;
    }

    @Override // c0c.b
    public final void qf(g r100, g r101) {
        v r102 = this.f523052c;
        if (r101 == null) goto L6;
        UserSession r103 = r101.f475034b;
        if (r103 == null) goto L6;
    L7:
        d r104 = (d) k.b(r102.c(r103), d.class);
        this.f523053d.e(r104);
        return;
    L6:
        r103 = ContainerConstsKt.a();
        goto L7
    }
}
