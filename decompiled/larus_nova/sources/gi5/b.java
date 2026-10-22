package gi5;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.middleground.permission.export.ui.model.DocReportPubParam;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import com.ss.android.lark.utils.statistics.PerfLog;
import e0c.k;
import f0c.g;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class b extends c0c.b implements hm5.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ hm5.a f481412b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f481413c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.convention.b<hm5.a> f481414d;

    public static final class a {
    }

    static {
    }

    @Override // hm5.a
    public final ArrayList<Class<? extends XBridgeMethod>> Id() {
        return this.f481412b.Id();
    }

    @Override // hm5.a
    public final void Sb(FragmentManager r100, Context r101, int r110, String r111, DocReportPubParam r112) {
        Intrinsics.checkNotNullParameter(r100, "fm");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "blockUrl");
        Intrinsics.checkNotNullParameter(r112, "pubParam");
        this.f481412b.Sb(r100, r101, r110, r111, r112);
    }

    @Override // hm5.a
    public final void onDestroy() {
        this.f481412b.onDestroy();
    }

    @Override // c0c.b
    public final void lf(f0c.b r100) {
        Intrinsics.checkNotNullParameter(r100, "toState");
        tt5.a.h("LarkPermissionServiceProxy", MapMonitorConst.EVENT_DESTROY);
        Intrinsics.checkNotNullParameter(r100, "toState");
        this.f481414d.c().onDestroy();
    }

    public b(j r100, v r101) {
        UserSession r102 = r100.b();
        if (r102 != null) goto L5;
        r102 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<hm5.a> r103 = new com.ss.android.lark.passportc.convention.b(k.b(r101.c(r102), hm5.a.class), hm5.a.class);
        Intrinsics.checkNotNullParameter(r100, "passportService");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        Intrinsics.checkNotNullParameter(r103, "proxy");
        super(r100);
        this.f481412b = r103.b();
        this.f481413c = r101;
        this.f481414d = r103;
    }

    @Override // c0c.b
    public final void qf(g r100, g r101) {
        tt5.a.h("LarkPermissionServiceProxy", "preparing");
        v r102 = this.f481413c;
        if (r101 == null) goto L6;
        UserSession r103 = r101.f475034b;
        if (r103 == null) goto L6;
    L7:
        hm5.a r104 = (hm5.a) k.b(r102.c(r103), hm5.a.class);
        this.f481414d.e(r104);
        return;
    L6:
        r103 = ContainerConstsKt.a();
        goto L7
    }
}
