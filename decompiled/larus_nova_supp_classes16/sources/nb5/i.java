package nb5;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import e0c.k;
import java.lang.reflect.Type;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class i extends c0c.b implements NetService {
    public final /* synthetic */ NetService b;
    public final v c;
    public final com.ss.android.lark.passportc.convention.b<NetService> d;

    @Override // com.bytedance.ee.bear.contract.NetService
    public final /* synthetic */ void C7(NetService.b r1) {
    }

    @Override // com.bytedance.ee.bear.contract.NetService
    public final <R extends Result> NetService.d<R> Rb(Type r2) {
        return this.b.Rb(r2);
    }

    @Override // com.bytedance.ee.bear.contract.NetService
    public final <R extends Result> NetService.d<R> Vc(NetService.c<R> r2) {
        return this.b.Vc(r2);
    }

    @Override // com.bytedance.ee.bear.contract.NetService
    public final void b() {
        this.b.b();
    }

    @Override // com.bytedance.ee.bear.contract.NetService
    public final Response g6(Request r2) {
        return this.b.g6(r2);
    }

    @Override // com.bytedance.ee.bear.contract.NetService
    public final NetService.a getConfig() {
        return this.b.getConfig();
    }

    @Override // com.bytedance.ee.bear.contract.NetService
    public final int getEnv() {
        return this.b.getEnv();
    }

    @Override // com.bytedance.ee.bear.contract.NetService
    public final boolean w6() {
        return this.b.w6();
    }

    @Override // com.bytedance.ee.bear.contract.NetService
    public final void z8(Request r2, Callback r3) {
        this.b.z8(r2, r3);
    }

    public i(j r4, v r5) {
        UserSession r1 = r4.b();
        if (r1 != null) goto L5;
        r1 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<NetService> r0 = new com.ss.android.lark.passportc.convention.b(k.b(r5.c(r1), NetService.class), NetService.class);
        Intrinsics.checkNotNullParameter(r4, "passport");
        Intrinsics.checkNotNullParameter(r5, "accessor");
        Intrinsics.checkNotNullParameter(r0, "proxy");
        super(r4);
        this.b = (NetService) r0.b();
        this.c = r5;
        this.d = r0;
    }

    public final void qf(f0c.g r1, f0c.g r2) {
        v r3 = this.c;
        if (r2 == null) goto L6;
        UserSession r4 = r2.b;
        if (r4 == null) goto L6;
    L7:
        NetService r5 = (NetService) k.b(r3.c(r4), NetService.class);
        this.d.e(r5);
        return;
    L6:
        r4 = ContainerConstsKt.a();
        goto L7
    }
}
