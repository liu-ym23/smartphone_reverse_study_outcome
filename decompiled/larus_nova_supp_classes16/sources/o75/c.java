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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c extends c0c.b implements a {
    public final /* synthetic */ a b;
    public final v c;
    public final com.ss.android.lark.passportc.convention.b<a> d;

    @Override // o75.a
    public final l H7() {
        return this.b.H7();
    }

    @Override // o75.a
    public final com.bytedance.ee.bear.drive.config.strategy.d Ic(Class<? extends com.bytedance.ee.bear.drive.config.strategy.d> r2) {
        return this.b.Ic(r2);
    }

    @Override // o75.a
    public final com.bytedance.ee.bear.drive.report.c Ke() {
        return this.b.Ke();
    }

    @Override // o75.a
    public final com.bytedance.ee.bear.drive.report.a Tb() {
        return this.b.Tb();
    }

    @Override // o75.a
    @Deprecated(message = "Deprecated in Java")
    public final t getCacheManager() {
        return this.b.getCacheManager();
    }

    @Override // o75.a
    public final q75.a getDriveConfig() {
        return this.b.getDriveConfig();
    }

    @Override // o75.a
    public final f getMimeTypeManager() {
        return this.b.getMimeTypeManager();
    }

    public c(j r4, v r5) {
        UserSession r1 = r4.b();
        if (r1 != null) goto L5;
        r1 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<a> r0 = new com.ss.android.lark.passportc.convention.b(k.b(r5.c(r1), a.class), a.class);
        Intrinsics.checkNotNullParameter(r4, "passport");
        Intrinsics.checkNotNullParameter(r5, "accessor");
        Intrinsics.checkNotNullParameter(r0, "proxy");
        super(r4);
        this.b = (a) r0.b();
        this.c = r5;
        this.d = r0;
    }

    public final void qf(g r1, g r2) {
        v r3 = this.c;
        if (r2 == null) goto L6;
        UserSession r4 = r2.b;
        if (r4 == null) goto L6;
    L7:
        a r5 = (a) k.b(r3.c(r4), a.class);
        this.d.e(r5);
        return;
    L6:
        r4 = ContainerConstsKt.a();
        goto L7
    }
}
