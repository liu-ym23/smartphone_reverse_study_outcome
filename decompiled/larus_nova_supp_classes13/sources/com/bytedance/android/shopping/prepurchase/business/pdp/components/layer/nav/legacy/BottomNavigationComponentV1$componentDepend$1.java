package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy;

import android.graphics.Rect;
import android.os.SystemClock;
import android.view.View;
import com.bytedance.android.ec.core.utils.l1;
import com.bytedance.android.ec.model.sku.SkuRestoreState;
import com.bytedance.android.ec.model.sku.SkuStateAddCartGuideInfo;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.shopping.anchorv4.bottom.BottomButtonMeta;
import com.bytedance.android.shopping.anchorv4.bottom.BottomButtonVO;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.anchorv4.dto.meta.PageMeta;
import com.bytedance.android.shopping.anchorv4.params.V4NativeParams;
import com.bytedance.android.shopping.anchorv4.voavhs.baseinfo.ActivityVO;
import com.google.gson.internal.LinkedTreeMap;
import io.reactivex.disposables.Disposable;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import vg3.d0;
import vg3.e0;
import vg3.i0;
import vg3.k0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class BottomNavigationComponentV1$componentDepend$1 implements d {
    public final /* synthetic */ BottomNavigationComponentV1 a;

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy.d
    public final void Q() {
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy.d
    public final void R() {
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy.d
    public final void l() {
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy.d
    public final Integer B() {
        V4NativeParams r0 = this.a.g2().getNativeParams();
        Intrinsics.checkNotNullParameter(r0, "$this$getSecondPanelHeightPercent");
        if (r0.getFullMode() == true) goto L8;
        Integer r1 = r0.getPanelHeightPercent();
        if (r1 == null) goto L8;
        int r2 = r1.intValue();
    L10:
        return Integer.valueOf(r2);
    L8:
        r2 = 73;
        goto L10
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy.d
    public final boolean C() {
        return ((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(this.a.O1())).b.a;
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy.d
    public final BottomButtonMeta D() {
        BottomButtonVO r0 = (BottomButtonVO) ((com.bytedance.android.shopping.prepurchase.arch.container.state.e) this.a.O1().d().getData().l.getValue()).a();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getBottomButtonMeta();
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy.d
    public final Rect O() {
        d0 r0 = (d0) this.a.N1(d0.class);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.O();
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy.d
    public final SkuRestoreState P() {
        e0 r0 = (e0) this.a.N1(e0.class);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.g0();
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy.d
    public final void S() {
        vg3.u r0 = (vg3.u) this.a.N1(vg3.u.class);
        if (r0 == null) goto L6;
        r0.v0(new k0(false, false, 2));
        return;
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy.d
    public final void T() {
        this.a.Z1(vg3.x.class, new BottomNavigationComponentV1$componentDepend$1$scheduleRefresh$1(null));
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy.d
    public final j73.m V() {
        com.bytedance.android.shopping.prepurchase.arch.container.ability.a r0 = this.a.N1(e0.class);
        Intrinsics.checkNotNull(r0);
        return ((e0) r0).b();
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy.l, com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy.k
    public final CommonMeta a() {
        PageMeta r0 = (PageMeta) this.a.O1().d().getData().b.a();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getCommonMeta();
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy.d
    public final LinkedTreeMap<String, Object> b() {
        PageMeta r0 = (PageMeta) this.a.O1().d().getData().b.a();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getTrackMeta();
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy.d, com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy.k
    public final V4NativeParams c() {
        return this.a.g2().getNativeParams();
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy.d
    public final boolean e() {
        return this.a.g2().getNativeParams().getFullMode();
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy.d
    public final String f() {
        return this.a.O1().d().getData().d();
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy.l
    public final String getSessionId() {
        return this.a.g2().getSessionId();
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy.d
    public final int getStatusBarHeight() {
        return this.a.O1().getContainerAbility().i7().c;
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy.d
    public final Boolean i() {
        i0 r0 = (i0) this.a.N1(i0.class);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.i();
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy.d, com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy.k
    public final boolean j() {
        return !Intrinsics.areEqual(((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(this.a.O1())).b.d.a(), Boolean.FALSE);
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy.d
    public final long p() {
        return this.a.s;
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy.d
    public final int r() {
        V4NativeParams r0 = this.a.g2().getNativeParams();
        Intrinsics.checkNotNullParameter(r0, "$this$getPanelHeightPercent");
        if (r0.getFullMode() == true) goto L8;
        Integer r1 = r0.getPanelHeightPercent();
        if (r1 == null) goto L8;
        return r1.intValue();
    L8:
        return 0;
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy.d
    public final ActivityVO X() {
        CommonMeta r0 = a();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getActivityInfo();
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy.l, com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy.k
    public final long getDuration() {
        return SystemClock.uptimeMillis() - this.a.s;
    }

    public BottomNavigationComponentV1$componentDepend$1(BottomNavigationComponentV1 r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy.d
    public final void A(l1.a r5) {
        Intrinsics.checkNotNullParameter(r5, "tickWatch");
        this.a.Z1(vg3.h.class, new BottomNavigationComponentV1$componentDepend$1$listenActivityTick$1(r5, null));
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy.d
    public final void W(BottomTipComponent.a r2) {
        Intrinsics.checkNotNullParameter(r2, "task");
        this.a.O1().b().n0(r2);
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy.l, com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy.k
    public final void d(Function1<? super vg3.z, Unit> r5) {
        Intrinsics.checkNotNullParameter(r5, "function");
        this.a.Z1(vg3.w.class, new BottomNavigationComponentV1$componentDepend$1$tracker$1(r5, null));
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy.d
    public final void g(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "disposable");
        this.a.q.add(r2);
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy.d
    public final void h(List<String> r3) {
        Intrinsics.checkNotNullParameter(r3, "extraElementId");
        i0 r0 = (i0) this.a.N1(i0.class);
        if (r0 == null) goto L6;
        r0.h(r3);
        return;
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy.d
    public final void k(SkuRestoreState r13) {
        if (r13 == null) goto L31;
        SkuStateAddCartGuideInfo r0 = r13.getAddCartGuide();
        if (r0 == null) goto L31;
        if (r0.getGuideType() != 2) goto L31;
        SkuStateAddCartGuideInfo r1 = r13.getAddCartGuide();
        String r2 = null;
        if (r1 == null) goto L10;
        String r3 = r1.getHintText();
    L12:
        if (r3 != null) goto L14;
    L17:
        boolean r4 = true;
    L18:
        if (r4 == true) goto L31;
        if ((!Intrinsics.areEqual(r13.getLastBehavior(), "click")) == true) goto L31;
        com.bytedance.android.shopping.prepurchase.arch.container.state.d<com.bytedance.android.shopping.anchorv4.bottom.b> r5 = this.a.p;
        SkuStateAddCartGuideInfo r6 = r13.getAddCartGuide();
        if (r6 == null) goto L25;
        Integer r7 = Integer.valueOf(r6.getGuideType());
    L26:
        SkuStateAddCartGuideInfo r8 = r13.getAddCartGuide();
        if (r8 == null) goto L29;
        r2 = r8.getHintText();
    L29:
        r5.g(new com.bytedance.android.shopping.anchorv4.bottom.b(r7, r2, r13.getSelectAvatar(), r13.getCheckNames(), r13.getCanAddCart(), r13.getLowerLimit(), false, 64));
        return;
    L25:
        r7 = null;
        goto L26
    L14:
        if (r3.length() == 0) goto L17;
        r4 = false;
        goto L18
    L10:
        r3 = null;
    L31:
        this.a.p.g(new com.bytedance.android.shopping.anchorv4.bottom.b(null, null, null, null, null, 0, true, 63));
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy.d
    public final void refresh(String r5) {
        this.a.Z1(vg3.x.class, new BottomNavigationComponentV1$componentDepend$1$refresh$1(r5, null));
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy.l
    public final void u(String r5) {
        Intrinsics.checkNotNullParameter(r5, "eventName");
        this.a.Z1(vg3.w.class, new BottomNavigationComponentV1$componentDepend$1$logLubanV1$1(r5, null));
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy.d
    public final void U(BottomButtonComponent r5, Object r6) {
        Intrinsics.checkNotNullParameter(r5, "watcher");
        Intrinsics.checkNotNullParameter(r6, "identifier");
        this.a.Z1(vg3.m.class, new BottomNavigationComponentV1$componentDepend$1$attachWatch$1(r5, r6, null));
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy.d
    public final void m(IAction r3, View r4) {
        Intrinsics.checkNotNullParameter(r3, "action");
        this.a.O1().e().r().O0(null, r3, r4, null);
    }
}
