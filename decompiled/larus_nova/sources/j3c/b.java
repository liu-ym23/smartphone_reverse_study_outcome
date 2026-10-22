package j3c;

import android.content.Context;
import com.ss.android.lark.http.netstate.NetworkUtils;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import com.ss.android.lark.utils.statistics.PerfLog;
import e0c.k;
import f0c.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class b extends c0c.b implements k3c.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ k3c.a f497157b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f497158c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.convention.b<k3c.a> f497159d;

    @Override // k3c.a
    public final void B5(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f497157b.B5(r100);
    }

    @Override // k3c.a
    public final void hd(NetworkUtils.NetworkType r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        this.f497157b.hd(r100);
    }

    @Override // k3c.a
    public final void w1(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f497157b.w1(r100);
    }

    public b(j r100, v r101) {
        UserSession r102 = r100.b();
        if (r102 != null) goto L5;
        r102 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<k3c.a> r103 = new com.ss.android.lark.passportc.convention.b(k.b(r101.c(r102), k3c.a.class), k3c.a.class);
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        Intrinsics.checkNotNullParameter(r103, "proxy");
        super(r100);
        this.f497157b = r103.b();
        this.f497158c = r101;
        this.f497159d = r103;
    }

    @Override // c0c.b
    public final void pf(g r100, f0c.b r101) {
        Intrinsics.checkNotNullParameter(r101, "toState");
        v r102 = this.f497158c;
        g r103 = r101.a();
        if (r103 == null) goto L6;
        UserSession r104 = r103.f475034b;
        if (r104 == null) goto L6;
    L7:
        k3c.a r105 = (k3c.a) k.b(r102.c(r104), k3c.a.class);
        this.f497159d.e(r105);
        return;
    L6:
        r104 = ContainerConstsKt.a();
        goto L7
    }
}
