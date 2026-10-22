package com.bytedance.android.shopping.anchorv4.voavhs;

import android.graphics.Bitmap;
import android.util.Pair;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.anchorv3.q;
import com.bytedance.android.shopping.anchorv3.widget.BasePdpRecyclerView;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.anchorv4.helper.t;
import com.bytedance.android.shopping.anchorv4.log.VisibleLogManager;
import com.bytedance.android.shopping.anchorv4.params.AnchorV4Param;
import com.bytedance.android.shopping.anchorv4.tracker.AnchorV4TrackerImpl;
import com.bytedance.android.shopping.anchorv4.vm.AnchorV4VM;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.AnchorV4HeadV2VO;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.GalleryDependencyImpl;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.r;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.w;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.x;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.z;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.container.HeadRecyclerView;
import com.facebook.common.references.CloseableReference;
import com.google.gson.internal.LinkedTreeMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class HeaderDependencyImpl implements u, w {
    public final g a;
    public final AnchorV4VM b;
    public final VisibleLogManager c;
    public final RecyclerView d;

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u
    public final w j0() {
        return this;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u
    public final r P() {
        return new GalleryDependencyImpl(this.b);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u
    public final int R() {
        return this.b.pageStatus().D;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u
    public final boolean S() {
        return this.b.pageStatus().E;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u
    public final String U() {
        LinkedHashMap r0 = t.a;
        com.bytedance.android.shopping.anchorv4.helper.u r1 = t.a(getSessionId());
        if (r1 == null) goto L9;
        s73.c r2 = r1.b;
        if (r2 == null) goto L9;
        Pair r3 = r2.a;
        if (r3 == null) goto L9;
        return (String) r3.first;
    L9:
        return null;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u
    public final int W4() {
        Integer r0 = (Integer) this.b.getState(HeaderDependencyImpl$getChangeKeyPosition$changeKeyPosition$1.INSTANCE);
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.intValue();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u
    public final void a() {
        com.bytedance.android.shopping.anchorv4.containers.g r0 = this.b.containerAbility();
        if (r0 == null) goto L6;
        r0.a();
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u
    public final boolean b() {
        return this.b.pageStatus().A;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u
    public final boolean b0() {
        return this.b.getFromCache();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u
    public final AnchorV4Param c() {
        return this.b.getAnchorV4Param();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u
    public final boolean d() {
        return this.b.isInSplit();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u
    public final com.bytedance.android.shopping.anchorv4.perf.monitor.c d0() {
        com.bytedance.android.shopping.anchorv4.perf.monitor.c.a r0 = com.bytedance.android.shopping.anchorv4.perf.monitor.c.k;
        AnchorV4VM r1 = this.b;
        r0.getClass();
        return com.bytedance.android.shopping.anchorv4.perf.monitor.c.a.a(r1);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u
    public final com.bytedance.android.shopping.anchorv4.video.f e() {
        return this.b.getPlayerStateManager();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u
    public final vg3.c e0() {
        return this.b.getCollisionNegotiator();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u
    public final void f() {
        int r0 = com.bytedance.android.shopping.anchorv3.utils.r.a;
        AnchorV4VM r1 = this.b;
        Intrinsics.checkNotNullParameter(r1, "vm");
        com.bytedance.android.shopping.anchorv3.utils.r.b("click_main_img", r1, new HashMap());
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u
    public final Map<String, Object> getEventParams() {
        return this.b.getEventParams();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u
    public final LifecycleOwner getLifecycleOwner() {
        return this.b.getLifecycleOwner();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u
    public final String getSessionId() {
        return this.b.getSessionId();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u
    public final LinkedTreeMap<String, Object> getTrackMeta() {
        return this.b.trackMeta();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u
    public final CloseableReference<Bitmap> h0() {
        return this.b.getWireframeBitmap();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u
    public final Boolean i0() {
        return this.b.getPlayerStateManager().n();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u
    public final boolean isExpanded() {
        return this.b.pageStatus().h;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u
    public final com.bytedance.android.shopping.anchorv4.containers.g k0() {
        return this.b.containerAbility();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u
    public final boolean l() {
        return this.b.pageStatus().z;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u
    public final AnchorV4HeadV2VO m0() {
        return (AnchorV4HeadV2VO) this.b.getState(HeaderDependencyImpl$getHeaderData$1.INSTANCE);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u
    public final boolean n() {
        return this.b.getPdpTaskManager().a;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u
    public final boolean n0() {
        return this.b.pathParams().a;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u
    public final boolean oa() {
        return this.b.pageStatus().r;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u
    public final CommonMeta r0() {
        return this.b.commonMeta();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u
    public final boolean r9() {
        final Ref.BooleanRef r0 = new Ref.BooleanRef();
        r0.element = false;
        this.b.getStateNow(new HeaderDependencyImpl$isPlaybackVideoExist$1(r0));
        return r0.element;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u
    public final x V() {
        return this.a;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u
    public final void T(com.bytedance.android.shopping.anchorv4.vm.h r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.b.watchPageStatusChange(r2);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u
    public final void W(com.bytedance.android.shopping.anchorv4.vm.c r2) {
        Intrinsics.checkNotNullParameter(r2, "headViewStatusListener");
        this.b.getHeadViewStatusListenerList().add(r2);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u
    public final void X(HeadRecyclerView r3) {
        RecyclerView r0 = this.d;
        if ((r0 instanceof BasePdpRecyclerView) == true) goto L5;
        r0 = null;
    L5:
        BasePdpRecyclerView r1 = (BasePdpRecyclerView) r0;
        if (r1 == null) goto L9;
        r1.setInterceptHandler(r3);
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u
    public final void Y(int r2) {
        this.b.notifyHeadSpecialWidthChange(r2);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u
    public final void a0(Boolean r2) {
        this.b.getHeadScrollStateManager().l(r2);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u
    public final void c0(boolean r3) {
        Iterator r0 = this.b.getHeadViewStatusListenerList().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.android.shopping.anchorv4.vm.c) r0.next()).a9(r3);
        goto L4
    L6:
        Iterator r4 = this.b.getHeadViewStatusListenerList().iterator();
    L8:
        if (r4.hasNext() == false) goto L10;
        ((com.bytedance.android.shopping.anchorv4.vm.c) r4.next()).X8();
        goto L8
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u
    public final void p0(z r2) {
        Intrinsics.checkNotNullParameter(r2, "floatVideoHandler");
        this.b.getHeadScrollStateManager().g = r2;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u
    public final void Z(q r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "pdpTask");
        this.b.getPdpTaskManager().i(r2, r3);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u
    public final void f0(int r3, Bitmap r4) {
        Intrinsics.checkNotNullParameter(r4, "bitmap");
        Iterator r0 = this.b.getHeadViewStatusListenerList().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.android.shopping.anchorv4.vm.c) r0.next()).W8(r3, r4);
        goto L4
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u
    public final void l0(Integer r4, int r5) {
        this.b.notifyHeadViewPageScroll(false, r4, Integer.valueOf(r5), true);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u
    public final void q0(int r3, Bitmap r4) {
        Iterator r0 = this.b.getHeadViewStatusListenerList().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.android.shopping.anchorv4.vm.c) r0.next()).Z8(r3, r4);
        goto L4
    }

    public HeaderDependencyImpl(AnchorV4VM r2, VisibleLogManager r3, RecyclerView r4) {
        Intrinsics.checkNotNullParameter(r2, "anchorV4VM");
        Intrinsics.checkNotNullParameter(r3, "visibleLogManager");
        Intrinsics.checkNotNullParameter(r4, "recyclerView");
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.a = new g(r2);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u
    public final void o0(String r9, Map<String, Object> r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r9, "eventName");
        Intrinsics.checkNotNullParameter(r10, "param");
        int r0 = com.bytedance.android.shopping.anchorv4.tracker.a.a;
        AnchorV4TrackerImpl r1 = com.bytedance.android.shopping.anchorv4.tracker.a.b(this.b);
        if (r1 == null) goto L6;
        r1.c = r10;
        AnchorV4TrackerImpl.b(r1, r9, false, null, r11, null, 22);
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.w
    public final void y(com.bytedance.android.shopping.anchorv4.log.d r2, Object r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "watcher");
        Intrinsics.checkNotNullParameter(r3, "identifier");
        this.c.b(r2, r3, r4);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.u
    public final void g0(String r8, Map<String, ? extends Object> r9, String r10, View r11, boolean r12, boolean r13, String r14) {
        Intrinsics.checkNotNullParameter(r8, "eventName");
        int r0 = com.bytedance.android.shopping.anchorv4.tracker.a.a;
        AnchorV4TrackerImpl r1 = com.bytedance.android.shopping.anchorv4.tracker.a.b(this.b);
        if (r1 == null) goto L9;
        r1.c = r9;
        if (r10 != null) goto L7;
        r10 = "a1.b8094.c0.d0";
    L7:
        r1.c(r11, r10, null);
        r1.a(r8, r13, r14, r12, PageFinder.via(r11));
        return;
    }
}
