package w4b;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.entity.UserSession;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class z extends c0c.b implements c.o {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c.o f558284b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.ss.android.lark.passportc.internal.v f558285c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.convention.b<c.o> f558286d;

    public static final class a {
    }

    static {
    }

    @Override // w4b.c.o
    public final String Fc() {
        return this.f558284b.Fc();
    }

    @Override // w4b.c.o
    public final String fe() {
        return this.f558284b.fe();
    }

    @Override // w4b.c.o
    public final String userId() {
        return this.f558284b.userId();
    }

    public z(com.ss.android.lark.passportc.api.j r100, com.ss.android.lark.passportc.internal.v r101) {
        UserSession r102 = r100.b();
        if (r102 != null) goto L5;
        r102 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<c.o> r103 = new com.ss.android.lark.passportc.convention.b(e0c.k.b(r101.c(r102), c.o.class), c.o.class);
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        Intrinsics.checkNotNullParameter(r103, "instanceHolder");
        super(r100);
        this.f558284b = r103.b();
        this.f558285c = r101;
        this.f558286d = r103;
    }

    @Override // c0c.b
    public final void qf(f0c.g r100, f0c.g r101) {
        Log.i("PassportDependencyProxy", "preparing PassportDependency");
        com.ss.android.lark.passportc.internal.v r102 = this.f558285c;
        if (r101 == null) goto L6;
        UserSession r103 = r101.f475034b;
        if (r103 == null) goto L6;
    L7:
        c.o r104 = (c.o) e0c.k.b(r102.c(r103), c.o.class);
        this.f558286d.e(r104);
        return;
    L6:
        r103 = ContainerConstsKt.a();
        goto L7
    }
}
