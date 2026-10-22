package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.live;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.anchorv3.PdpPerfOpt;
import com.bytedance.android.ec.model.response.ECHotAtmosphere;
import com.bytedance.android.shopping.anchorv3.i;
import com.bytedance.android.shopping.anchorv4.topbanner.TopBannerVO;
import com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent;
import com.bytedance.android.shopping.prepurchase.business.pdp.components.m;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import vg3.l;
import vg3.q;
import vg3.w;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class LiveSearchComponent extends m implements q {
    public static final /* synthetic */ int w = 0;
    public com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.g m;
    public g n;
    public ECHotAtmosphere o;
    public i p;
    public hn.c q;
    public TopBannerVO r;
    public final Lazy s;
    public boolean t;
    public boolean u;
    public boolean v;

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final List<Class<?>> M1() {
        return CollectionsKt.listOf(new Class[]{w.class, l.class});
    }

    public LiveSearchComponent() {
        this.s = LazyKt.lazy(new LiveSearchComponent$statusBarHeight$2(this));
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void T1() {
        super.T1();
        if (g2().getNativeParams().getFromLive() == false) goto L9;
        String r0 = g2().getNativeParams().getLiveRoomId();
        if (r0 == null) goto L9;
        g r1 = new g(this, r0);
        this.n = r1;
        boolean r2 = ECServiceManager.a;
        cf.l r3 = (cf.l) ECServiceManager.c(cf.l.class);
        if (r3 == null) goto L9;
        r3.Ka(r0, r1);
    L9:
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a(O1().d().getData().f(), this, new d(this));
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a(((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(O1())).b.d, this, new e(this));
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a(((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(O1())).b.c, this, new f(this));
        AbsComponent.Y1(this, q.class, this, false, 12);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void U1() {
        super.U1();
        g r0 = this.n;
        if (r0 == null) goto L8;
        boolean r1 = ECServiceManager.a;
        cf.l r2 = (cf.l) ECServiceManager.c(cf.l.class);
        if (r2 == null) goto L9;
        r2.Ca(r0.b, r0);
        return;
    L9:
        return;
    }

    @Override // vg3.q
    public final hn.c G() {
        return this.q;
    }

    @Override // vg3.q
    public final i j() {
        return this.p;
    }

    public final boolean i2(ECHotAtmosphere r4) {
        if (r4.getNumInt() > 0) goto L5;
        return false;
    L5:
        int r5 = r4.type;
        if (r5 == 1) goto L16;
        if (r5 != 2) goto L10;
        return true;
    L10:
        if (r5 == 3) goto L16;
        if (r5 == 4) goto L16;
        return false;
    L16:
        return ECSettingKeys.q0();
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.Component
    public final View c2(LayoutInflater r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        Intrinsics.checkNotNullParameter(r3, "container");
        FrameLayout r4 = new FrameLayout(r2.getContext());
        r4.setId(2131378317);
        return r4;
    }

    public static final void h2(LiveSearchComponent r1, i r2, TopBannerVO r3) {
        r1.getClass();
        c r0 = new c(r1, r2, r3);
        if (PdpPerfOpt.c() == false) goto L5;
        r1.O1().b().e1(r0);
        return;
    L5:
        r0.run();
    }
}
