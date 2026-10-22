package o75;

import b95.l;
import com.bytedance.ee.bear.drive.cache.t;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import e0c.k;
import f0c.g;
import g85.f;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class c extends c0c.b implements a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a f522271b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f522272c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.convention.b<a> f522273d;

    @Override // o75.a
    public final l H7() {
        return this.f522271b.H7();
    }

    @Override // o75.a
    public final com.bytedance.ee.bear.drive.config.strategy.d Ic(Class<? extends com.bytedance.ee.bear.drive.config.strategy.d> r100) {
        return this.f522271b.Ic(r100);
    }

    @Override // o75.a
    public final com.bytedance.ee.bear.drive.report.c Ke() {
        return this.f522271b.Ke();
    }

    @Override // o75.a
    public final com.bytedance.ee.bear.drive.report.a Tb() {
        return this.f522271b.Tb();
    }

    @Override // o75.a
    @Deprecated(message = "Deprecated in Java")
    public final t getCacheManager() {
        return this.f522271b.getCacheManager();
    }

    @Override // o75.a
    public final q75.a getDriveConfig() {
        return this.f522271b.getDriveConfig();
    }

    @Override // o75.a
    public final f getMimeTypeManager() {
        return this.f522271b.getMimeTypeManager();
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
        this.f522271b = r103.b();
        this.f522272c = r101;
        this.f522273d = r103;
    }

    @Override // c0c.b
    public final void qf(g r100, g r101) {
        v r102 = this.f522272c;
        if (r101 == null) goto L6;
        UserSession r103 = r101.f475034b;
        if (r103 == null) goto L6;
    L7:
        a r104 = (a) k.b(r102.c(r103), a.class);
        this.f522273d.e(r104);
        return;
    L6:
        r103 = ContainerConstsKt.a();
        goto L7
    }
}
