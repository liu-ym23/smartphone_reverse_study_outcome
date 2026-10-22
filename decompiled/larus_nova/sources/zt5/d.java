package zt5;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.middleground.permission.apply.NoPermission;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import e0c.k;
import f0c.g;
import kotlin.jvm.internal.Intrinsics;
import sbb.e;

/* JADX INFO: loaded from: classes19.dex */
public final class d extends c0c.b implements zt5.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zt5.a f573609b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f573610c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.convention.b<zt5.a> f573611d;

    public static final class a {
    }

    static {
    }

    @Override // zt5.a
    public final void F0(FragmentActivity r100, String r110, int r111, String r112, String r113, String r114) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r110, "token");
        Intrinsics.checkNotNullParameter(r112, "ownerId");
        Intrinsics.checkNotNullParameter(r113, "ownerName");
        Intrinsics.checkNotNullParameter(r114, EventConstant.Key.MODULE);
        this.f573609b.F0(r100, r110, r111, r112, r113, r114);
    }

    @Override // zt5.a
    public final au5.a P7(FragmentManager r110, int r210, String r211, e r212, String r213, boolean r214, boolean r215, String r216, boolean r217, boolean r218, String r219, String r310, boolean r311, int r312, boolean r313, BearUrl r314) {
        Intrinsics.checkNotNullParameter(r110, "fm");
        Intrinsics.checkNotNullParameter(r212, "documentType");
        Intrinsics.checkNotNullParameter("forbidden", "userPerm");
        Intrinsics.checkNotNullParameter(r219, "publicPerm");
        Intrinsics.checkNotNullParameter(r310, "ownerId");
        return this.f573609b.P7(r110, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313, r314);
    }

    @Override // zt5.a
    public final void Q0(FragmentActivity r110, String r111, e r112, String r113, String r114, boolean r115, String r116, boolean r117, int r210) {
        Intrinsics.checkNotNullParameter(r110, "activity");
        Intrinsics.checkNotNullParameter(r112, "documentType");
        Intrinsics.checkNotNullParameter("forbidden", "userPerm");
        Intrinsics.checkNotNullParameter("", "publicPerm");
        this.f573609b.Q0(r110, r111, r112, r113, r114, r115, r116, r117, r210);
    }

    @Override // zt5.a
    public final au5.a Q2(FragmentManager r210, int r211, int r212, boolean r213, int r214, boolean r215, String r216, int r217, String r218, boolean r310, boolean r311, String r312, String r313, String r314, boolean r315, boolean r316, boolean r317, int r318) {
        Intrinsics.checkNotNullParameter(r210, "fm");
        Intrinsics.checkNotNullParameter(r216, "token");
        Intrinsics.checkNotNullParameter(r312, EventConstant.Key.MODULE);
        Intrinsics.checkNotNullParameter(r313, "userPerm");
        return this.f573609b.Q2(r210, r211, r212, r213, r214, r215, r216, r217, r218, r310, r311, r312, r313, r314, r315, r316, r317, r318);
    }

    @Override // zt5.a
    public final DialogFragment Ud(FragmentActivity r100, String r101, int r110, boolean r111, Runnable r112) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        return this.f573609b.Ud(r100, r101, r110, r111, r112);
    }

    @Override // zt5.a
    public final au5.a Xd(FragmentManager r100, NoPermission r101) {
        Intrinsics.checkNotNullParameter(r100, "fm");
        Intrinsics.checkNotNullParameter(r101, "noPermission");
        return this.f573609b.Xd(r100, r101);
    }

    @Override // zt5.a
    public final Fragment d6(FragmentManager r100, String r110, int r111, int r112, boolean r113, Runnable r114) {
        Intrinsics.checkNotNullParameter(r100, "fm");
        return this.f573609b.d6(r100, r110, r111, r112, r113, r114);
    }

    @Override // zt5.a
    public final void onDestroy() {
        this.f573609b.onDestroy();
    }

    @Override // c0c.b
    public final void lf(f0c.b r100) {
        Intrinsics.checkNotNullParameter(r100, "toState");
        tt5.a.h("PermissionUIServiceProxy", MapMonitorConst.EVENT_DESTROY);
        Intrinsics.checkNotNullParameter(r100, "toState");
        this.f573611d.c().onDestroy();
    }

    public d(j r100, v r101) {
        UserSession r102 = r100.b();
        if (r102 != null) goto L5;
        r102 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<zt5.a> r103 = new com.ss.android.lark.passportc.convention.b(k.b(r101.c(r102), zt5.a.class), zt5.a.class);
        Intrinsics.checkNotNullParameter(r100, "passportService");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        Intrinsics.checkNotNullParameter(r103, "proxy");
        super(r100);
        this.f573609b = r103.b();
        this.f573610c = r101;
        this.f573611d = r103;
    }

    @Override // c0c.b
    public final void qf(g r100, g r101) {
        tt5.a.h("PermissionUIServiceProxy", "preparing");
        v r102 = this.f573610c;
        if (r101 == null) goto L6;
        UserSession r103 = r101.f475034b;
        if (r103 == null) goto L6;
    L7:
        zt5.a r104 = (zt5.a) k.b(r102.c(r103), zt5.a.class);
        this.f573611d.e(r104);
        return;
    L6:
        r103 = ContainerConstsKt.a();
        goto L7
    }
}
