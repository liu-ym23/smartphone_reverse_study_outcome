package tz4;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.ee.bear.container.f;
import com.bytedance.ee.bear.document.s2;
import com.bytedance.ee.bear.document.v4;
import com.bytedance.ee.bear.list.create.r0;
import com.larus.office.base.service.OfficeSdkServiceV2;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import com.ss.android.lark.utils.statistics.PerfLog;
import e0c.k;
import f0c.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class e extends c0c.b implements ik5.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ik5.a f548048b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f548049c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.convention.b<ik5.a> f548050d;

    public static final class a {
    }

    static {
    }

    @Override // ik5.a
    public final qd5.a A4() {
        return this.f548048b.A4();
    }

    @Override // ik5.a
    public final com.bytedance.ee.bear.list.recent.b Bb() {
        return this.f548048b.Bb();
    }

    @Override // ik5.a
    public final Fragment C6(String r100, Long r101, String r110, hk5.a r111, f r112) {
        Intrinsics.checkNotNullParameter(r100, "url");
        return this.f548048b.C6(r100, r101, r110, r111, r112);
    }

    @Override // ik5.a
    public final com.bytedance.ee.bear.list.move.e D2() {
        return this.f548048b.D2();
    }

    @Override // ik5.a
    public final com.bytedance.ee.bear.list.cover.a F9() {
        return this.f548048b.F9();
    }

    @Override // ik5.a
    public final String J9() {
        return this.f548048b.J9();
    }

    @Override // ik5.a
    public final void Ka(sbb.e r100, v4 r101) {
        Intrinsics.checkNotNullParameter(r100, "documentType");
        Intrinsics.checkNotNullParameter(r101, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        this.f548048b.Ka(r100, r101);
    }

    @Override // ik5.a
    public final r0 Q3() {
        return this.f548048b.Q3();
    }

    @Override // ik5.a
    public final void Qd(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        this.f548048b.Qd(r100);
    }

    @Override // ik5.a
    public final com.bytedance.ee.bear.list.delete.f R() {
        return this.f548048b.R();
    }

    @Override // ik5.a
    public final j15.a R4(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "fileName");
        return this.f548048b.R4(r100, r101);
    }

    @Override // ik5.a
    public final nd5.a T2() {
        return this.f548048b.T2();
    }

    @Override // ik5.a
    public final void Ta(OfficeSdkServiceV2.d r100) {
        Intrinsics.checkNotNullParameter(r100, "dependency");
        this.f548048b.Ta(r100);
    }

    @Override // ik5.a
    public final v4 a5(sbb.e r100) {
        Intrinsics.checkNotNullParameter(r100, "documentType");
        return this.f548048b.a5(r100);
    }

    @Override // ik5.a
    public final jk5.a ff() {
        return this.f548048b.ff();
    }

    @Override // ik5.a
    public final void ga() {
        this.f548048b.ga();
    }

    @Override // ik5.a
    public final void r2(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "from");
        this.f548048b.r2(r100, r101);
    }

    @Override // ik5.a
    public final rd5.a t2() {
        return this.f548048b.t2();
    }

    @Override // ik5.a
    public final j15.b y4(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "fileName");
        return this.f548048b.y4(r100, r101);
    }

    @Override // ik5.a
    public final void z2(s2 r100) {
        Intrinsics.checkNotNullParameter(r100, "resInfo");
        this.f548048b.z2(r100);
    }

    public e(j r100, v r101) {
        UserSession r102 = r100.b();
        if (r102 != null) goto L5;
        r102 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<ik5.a> r103 = new com.ss.android.lark.passportc.convention.b(k.b(r101.c(r102), ik5.a.class), ik5.a.class);
        Intrinsics.checkNotNullParameter(r100, "passportService");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        Intrinsics.checkNotNullParameter(r103, "proxy");
        super(r100);
        this.f548048b = r103.b();
        this.f548049c = r101;
        this.f548050d = r103;
    }

    @Override // c0c.b
    public final void qf(g r100, g r101) {
        tt5.a.h("UserDocsSdkProxy", "preparing");
        v r102 = this.f548049c;
        if (r101 == null) goto L6;
        UserSession r103 = r101.f475034b;
        if (r103 == null) goto L6;
    L7:
        ik5.a r104 = (ik5.a) k.b(r102.c(r103), ik5.a.class);
        this.f548050d.e(r104);
        return;
    L6:
        r103 = ContainerConstsKt.a();
        goto L7
    }
}
