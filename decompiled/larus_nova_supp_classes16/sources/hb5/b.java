package hb5;

import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import e0c.k;
import f0c.g;
import io.reactivex.Flowable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b extends c0c.b implements hb5.a {
    public final /* synthetic */ hb5.a b;
    public final v c;
    public final com.ss.android.lark.passportc.convention.b<hb5.a> d;

    public static final class a {
    }

    static {
    }

    @Override // hb5.a
    public final Flowable<Object> Sc() {
        return this.b.Sc();
    }

    @Override // hb5.a
    public final void checkAndInit() {
        this.b.checkAndInit();
    }

    public final void lf(f0c.b r4) {
        Intrinsics.checkNotNullParameter(r4, "toState");
        tt5.a.h("AppInitializeProxy", "destroy");
        Intrinsics.checkNotNullParameter(r4, "toState");
    }

    public b(j r4, v r5) {
        UserSession r1 = r4.b();
        if (r1 != null) goto L5;
        r1 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<hb5.a> r0 = new com.ss.android.lark.passportc.convention.b(k.b(r5.c(r1), hb5.a.class), hb5.a.class);
        Intrinsics.checkNotNullParameter(r4, "passportService");
        Intrinsics.checkNotNullParameter(r5, "accessor");
        Intrinsics.checkNotNullParameter(r0, "proxy");
        super(r4);
        this.b = (hb5.a) r0.b();
        this.c = r5;
        this.d = r0;
    }

    public final void qf(g r2, g r3) {
        tt5.a.h("AppInitializeProxy", "preparing");
        v r4 = this.c;
        if (r3 == null) goto L6;
        UserSession r5 = r3.b;
        if (r5 == null) goto L6;
    L7:
        hb5.a r6 = (hb5.a) k.b(r4.c(r5), hb5.a.class);
        this.d.e(r6);
        return;
    L6:
        r5 = ContainerConstsKt.a();
        goto L7
    }
}
