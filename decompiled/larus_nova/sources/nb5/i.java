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

/* JADX INFO: loaded from: classes16.dex */
public final class i extends c0c.b implements NetService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ NetService f518515b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f518516c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.convention.b<NetService> f518517d;

    @Override // com.bytedance.ee.bear.contract.NetService
    public final /* synthetic */ void C7(NetService.b r100) {
    }

    @Override // com.bytedance.ee.bear.contract.NetService
    public final <R extends Result> NetService.d<R> Rb(Type r100) {
        return this.f518515b.Rb(r100);
    }

    @Override // com.bytedance.ee.bear.contract.NetService
    public final <R extends Result> NetService.d<R> Vc(NetService.c<R> r100) {
        return this.f518515b.Vc(r100);
    }

    @Override // com.bytedance.ee.bear.contract.NetService
    public final void b() {
        this.f518515b.b();
    }

    @Override // com.bytedance.ee.bear.contract.NetService
    public final Response g6(Request r100) {
        return this.f518515b.g6(r100);
    }

    @Override // com.bytedance.ee.bear.contract.NetService
    public final NetService.a getConfig() {
        return this.f518515b.getConfig();
    }

    @Override // com.bytedance.ee.bear.contract.NetService
    public final int getEnv() {
        return this.f518515b.getEnv();
    }

    @Override // com.bytedance.ee.bear.contract.NetService
    public final boolean w6() {
        return this.f518515b.w6();
    }

    @Override // com.bytedance.ee.bear.contract.NetService
    public final void z8(Request r100, Callback r101) {
        this.f518515b.z8(r100, r101);
    }

    public i(j r100, v r101) {
        UserSession r102 = r100.b();
        if (r102 != null) goto L5;
        r102 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<NetService> r103 = new com.ss.android.lark.passportc.convention.b(k.b(r101.c(r102), NetService.class), NetService.class);
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        Intrinsics.checkNotNullParameter(r103, "proxy");
        super(r100);
        this.f518515b = r103.b();
        this.f518516c = r101;
        this.f518517d = r103;
    }

    @Override // c0c.b
    public final void qf(f0c.g r100, f0c.g r101) {
        v r102 = this.f518516c;
        if (r101 == null) goto L6;
        UserSession r103 = r101.f475034b;
        if (r103 == null) goto L6;
    L7:
        NetService r104 = (NetService) k.b(r102.c(r103), NetService.class);
        this.f518517d.e(r104);
        return;
    L6:
        r103 = ContainerConstsKt.a();
        goto L7
    }
}
