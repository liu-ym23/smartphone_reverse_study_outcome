package hb5;

import com.bytedance.map.api.monitor.MapMonitorConst;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import e0c.k;
import f0c.g;
import io.reactivex.Flowable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class b extends c0c.b implements hb5.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ hb5.a f484486b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f484487c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.convention.b<hb5.a> f484488d;

    public static final class a {
    }

    static {
    }

    @Override // hb5.a
    public final Flowable<Object> Sc() {
        return this.f484486b.Sc();
    }

    @Override // hb5.a
    public final void checkAndInit() {
        this.f484486b.checkAndInit();
    }

    @Override // c0c.b
    public final void lf(f0c.b r100) {
        Intrinsics.checkNotNullParameter(r100, "toState");
        tt5.a.h("AppInitializeProxy", MapMonitorConst.EVENT_DESTROY);
        Intrinsics.checkNotNullParameter(r100, "toState");
    }

    public b(j r100, v r101) {
        UserSession r102 = r100.b();
        if (r102 != null) goto L5;
        r102 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<hb5.a> r103 = new com.ss.android.lark.passportc.convention.b(k.b(r101.c(r102), hb5.a.class), hb5.a.class);
        Intrinsics.checkNotNullParameter(r100, "passportService");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        Intrinsics.checkNotNullParameter(r103, "proxy");
        super(r100);
        this.f484486b = r103.b();
        this.f484487c = r101;
        this.f484488d = r103;
    }

    @Override // c0c.b
    public final void qf(g r100, g r101) {
        tt5.a.h("AppInitializeProxy", "preparing");
        v r102 = this.f484487c;
        if (r101 == null) goto L6;
        UserSession r103 = r101.f475034b;
        if (r103 == null) goto L6;
    L7:
        hb5.a r104 = (hb5.a) k.b(r102.c(r103), hb5.a.class);
        this.f484488d.e(r104);
        return;
    L6:
        r103 = ContainerConstsKt.a();
        goto L7
    }
}
