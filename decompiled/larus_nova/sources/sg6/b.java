package sg6;

import android.content.Context;
import com.bytedance.android.scope.m;
import com.bytedance.live.bizlink.api.business.anchor2guest.base.BizLinkServiceType;
import com.ss.android.lark.utils.statistics.PerfLog;
import dn0.c;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import qg6.f;
import yz0.g;

/* JADX INFO: loaded from: classes19.dex */
public final class b implements rf6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public sf6.a f541837a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public vg6.b f541838b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g f541839c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final cg6.a f541840d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final f f541841e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final tc0.b f541842f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final bn0.b f541843g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c f541844h;

    @Override // rf6.a
    public final ag6.b L5() {
        sf6.a r100 = this.f541837a;
        if ((r100 instanceof ag6.b) == true) goto L6;
        r100 = null;
    L6:
        return (ag6.b) r100;
    }

    @Override // rf6.a
    public final xf6.a c() {
        sf6.a r100 = this.f541837a;
        if ((r100 instanceof xf6.a) == true) goto L6;
        r100 = null;
    L6:
        return (xf6.a) r100;
    }

    @Override // rf6.a
    public final zf6.b d() {
        sf6.a r100 = this.f541837a;
        if ((r100 instanceof zf6.b) == true) goto L6;
        r100 = null;
    L6:
        return (zf6.b) r100;
    }

    @Override // rf6.a
    public final zf6.a e() {
        sf6.a r100 = this.f541837a;
        if ((r100 instanceof zf6.a) == true) goto L6;
        r100 = null;
    L6:
        return (zf6.a) r100;
    }

    @Override // rf6.a
    public final xf6.b f() {
        sf6.a r100 = this.f541837a;
        if ((r100 instanceof xf6.b) == true) goto L6;
        r100 = null;
    L6:
        return (xf6.b) r100;
    }

    @Override // rf6.a
    public final yf6.a g() {
        sf6.a r100 = this.f541837a;
        if ((r100 instanceof yf6.a) == true) goto L6;
        r100 = null;
    L6:
        return (yf6.a) r100;
    }

    @Override // rf6.a
    public final ag6.a h() {
        sf6.a r100 = this.f541837a;
        if ((r100 instanceof ag6.a) == true) goto L6;
        r100 = null;
    L6:
        return (ag6.a) r100;
    }

    public final vf6.b i() {
        sf6.a r100 = this.f541837a;
        if ((r100 instanceof vf6.b) == true) goto L6;
        r100 = null;
    L6:
        return (vf6.b) r100;
    }

    @Override // rf6.a
    public final bg6.a s2() {
        sf6.a r100 = this.f541837a;
        if ((r100 instanceof bg6.a) == true) goto L6;
        r100 = null;
    L6:
        return (bg6.a) r100;
    }

    @Override // rf6.a
    public final sf6.a a() {
        return this.f541837a;
    }

    public final void j(BizLinkServiceType r100) {
        if (r100 == null) goto L16;
        sf6.a r101 = this.f541837a;
        if (r101 == null) goto L7;
        BizLinkServiceType r102 = r101.j();
    L8:
        if (r102 != r100) goto L24;
        sf6.a r103 = this.f541837a;
        if (r103 == null) goto L12;
        r103.release();
    L12:
        vg6.b r104 = this.f541838b;
        if (r104 == null) goto L15;
        r104.a();
    L15:
        this.f541837a = null;
        return;
    L24:
        return;
    L7:
        r102 = null;
        goto L8
    L16:
        sf6.a r105 = this.f541837a;
        if (r105 == null) goto L19;
        r105.release();
    L19:
        vg6.b r106 = this.f541838b;
        if (r106 == null) goto L22;
        r106.a();
    L22:
        this.f541837a = null;
    }

    @Override // rf6.a
    public final void b(BizLinkServiceType r110, Context r111) {
        Intrinsics.checkNotNullParameter(r110, "bizLinkServiceType");
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        j(null);
        switch(a.f541836a[r110.ordinal()]) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            case 8: goto L6;
            default: goto L5;
        };
    L6:
        sf6.a r112 = new yg6.a(this.f541839c, this.f541840d, this.f541841e, this.f541842f, this.f541843g, r111);
    L14:
        this.f541837a = r112;
        r112.init();
        bn0.b r113 = this.f541843g;
        KClass r114 = Reflection.getOrCreateKotlinClass(yz0.f.class);
        m.f163449e.getClass();
        yz0.f r100 = (yz0.f) m.b(r113).a(r114);
        if (r100 == null) goto L18;
        this.f541838b = new vg6.b(this, this.f541839c, this.f541844h, this.f541841e, r100, this.f541843g);
        return;
    L18:
        return;
    L7:
        r112 = new zg6.a(this.f541839c, this.f541840d, this.f541841e, this.f541842f, this.f541843g, r111);
        goto L14
    L8:
        r112 = new ah6.a(this.f541839c, this.f541840d, this.f541841e, this.f541842f, this.f541843g, r111);
        goto L14
    L9:
        r112 = new wg6.a(this.f541839c, this.f541840d, this.f541841e, this.f541842f, this.f541843g, r111);
        goto L14
    L10:
        r112 = new yg6.b(this.f541839c, this.f541840d, this.f541841e, this.f541842f, this.f541843g);
        goto L14
    L11:
        r112 = new zg6.b(this.f541839c, this.f541840d, this.f541841e, this.f541842f, this.f541843g);
        goto L14
    L12:
        r112 = new ah6.b(this.f541839c, this.f541840d, this.f541841e, this.f541842f, this.f541843g);
        goto L14
    L13:
        r112 = new wg6.b(this.f541839c, this.f541840d, this.f541841e, this.f541842f, this.f541843g);
        goto L14
    L5:
        throw new NoWhenBranchMatchedException();
    }

    public b(g r100, cg6.a r101, f r102, tc0.b r103, bn0.b r104, c r105) {
        Intrinsics.checkNotNullParameter(r100, "roomDataService");
        Intrinsics.checkNotNullParameter(r101, "multiLinkComponentService");
        Intrinsics.checkNotNullParameter(r102, "hostService");
        Intrinsics.checkNotNullParameter(r103, "linkInRoomDataHolderKt");
        Intrinsics.checkNotNullParameter(r104, "multiLinkRoomScope");
        Intrinsics.checkNotNullParameter(r105, "linkSecurityService");
        this.f541839c = r100;
        this.f541840d = r101;
        this.f541841e = r102;
        this.f541842f = r103;
        this.f541843g = r104;
        this.f541844h = r105;
    }
}
