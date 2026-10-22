package zoc;

import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import e0c.k;
import f0c.g;
import kotlin.jvm.internal.Intrinsics;
import yoc.h;

/* JADX INFO: loaded from: classes36.dex */
public final class a extends c0c.b implements h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h f573167b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f573168c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.convention.b<h> f573169d;

    /* JADX INFO: renamed from: zoc.a$a, reason: collision with other inner class name */
    public static final class C8485a {
    }

    static {
    }

    @Override // yoc.h
    public final void G6() {
        this.f573167b.G6();
    }

    @Override // yoc.h
    public final int c8() {
        return this.f573167b.c8();
    }

    @Override // yoc.h
    public final void ra(yoc.c r100) {
        Intrinsics.checkNotNullParameter(r100, BrowserDependency.UrlClickType.CARD);
        this.f573167b.ra(r100);
    }

    @Override // yoc.h
    public final void y2(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "id");
        this.f573167b.y2(r100, r101);
    }

    public a(j r100, v r101) {
        UserSession r102 = r100.b();
        if (r102 != null) goto L5;
        r102 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<h> r103 = new com.ss.android.lark.passportc.convention.b(k.b(r101.c(r102), h.class), h.class);
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        Intrinsics.checkNotNullParameter(r103, "instanceHolder");
        super(r100);
        this.f573167b = r103.b();
        this.f573168c = r101;
        this.f573169d = r103;
    }

    @Override // c0c.b
    public final void qf(g r100, g r101) {
        Log.i("FloatingPanelGlobalProxy", "preparing IFloatingPanel");
        v r102 = this.f573168c;
        if (r101 == null) goto L6;
        UserSession r103 = r101.f475034b;
        if (r103 == null) goto L6;
    L7:
        h r104 = (h) k.b(r102.c(r103), h.class);
        this.f573169d.e(r104);
        return;
    L6:
        r103 = ContainerConstsKt.a();
        goto L7
    }
}
