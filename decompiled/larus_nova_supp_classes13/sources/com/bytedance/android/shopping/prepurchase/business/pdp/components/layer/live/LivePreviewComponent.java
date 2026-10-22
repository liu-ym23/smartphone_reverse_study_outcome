package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.live;

import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import cf.l;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.adapter.api.j;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.livesdk.ec.adapter.api.FloatWindowState;
import com.bytedance.android.livesdk.ec.adapter.api.LiveVolume;
import com.bytedance.android.livesdk.ec.adapter.api.Scene;
import com.bytedance.android.shopping.anchorv4.components.WindowConfig;
import com.bytedance.android.shopping.anchorv4.components.k0;
import com.bytedance.android.shopping.anchorv4.components.l0;
import com.bytedance.android.shopping.anchorv4.params.AnchorV4Param;
import com.bytedance.android.shopping.anchorv4.video.AnchorV4PlayerStateManager;
import com.bytedance.android.shopping.prepurchase.arch.container.state.i;
import com.bytedance.android.shopping.prepurchase.business.pdp.components.m;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import vg3.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class LivePreviewComponent extends m implements p {
    public static final /* synthetic */ int s = 0;
    public final String m;
    public final Lazy n;
    public final Lazy o;
    public boolean p;
    public final Lazy q;
    public final l0 r;

    public static final class a<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {
        public final /* synthetic */ LivePreviewComponent a;

        public a(LivePreviewComponent r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference failed for: r1v4, types: [com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.live.LivePreviewComponent$tryShowLiveWindow$3] */
        /* JADX WARN: Type inference failed for: r7v2, types: [com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.live.LivePreviewComponent$tryShowLiveWindow$2] */
        @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
        public final void onChanged(Object r10) {
            boolean r11 = ((Boolean) r10).booleanValue();
            final LivePreviewComponent r0 = this.a;
            if (k0.a(r0.g2()) == false) goto L41;
            final DialogFragment r1 = r0.i2();
            int r2 = ECSdk.a;
            final IAdapterService r3 = (IAdapterService) ECSdk.a(IAdapterService.class);
            Boolean r4 = null;
            if (r3 == null) goto L8;
            final j r5 = r3.getLiveWindowService();
        L9:
            if (r3 == null) goto L15;
            wu1.a r6 = r3.getECLiveStateController();
            if (r6 == null) goto L15;
            Scene r7 = Scene.LIVE;
            Pair r8 = r6.c();
            if (r8 == null) goto L15;
            FloatWindowState r9 = (FloatWindowState) r8.getFirst();
        L16:
            dm.a.a("LiveWindow").b("半屏页面：显示直播小窗状态 show: " + r11 + " state: " + r9, null);
            final LivePreviewComponent$tryShowLiveWindow$1 r12 = new LivePreviewComponent$tryShowLiveWindow$1(r0);
            ?? r13 = new LivePreviewComponent$tryShowLiveWindow$2(r0, r5, r1, r12);
            ?? r14 = new LivePreviewComponent$tryShowLiveWindow$3(r0, r5, r3);
            if (r9 == null) goto L23;
            int r15 = b.a[r9.ordinal()];
            if (r15 != 1) goto L22;
            r13.invoke(new LivePreviewComponent$tryShowLiveWindow$4(r0));
            goto L41
        L22:
            if (r15 != 2) goto L23;
            r14.m2552invoke();
        L23:
            if (r11 == false) goto L38;
            r13.invoke(new LivePreviewComponent$tryShowLiveWindow$5(r0));
            vg3.a r16 = (vg3.a) r0.N1(vg3.a.class);
            if (r16 == null) goto L30;
            AnchorV4PlayerStateManager r17 = r16.e();
            if (r17 == null) goto L30;
            r4 = r17.n();
        L30:
            if (Intrinsics.areEqual(r4, Boolean.TRUE) == false) goto L32;
            LiveVolume r18 = LiveVolume.MUTE;
        L33:
            IAdapterService r19 = (IAdapterService) ECSdk.a(IAdapterService.class);
            if (r19 == null) goto L41;
            wu1.a r20 = r19.getECLiveStateController();
            if (r20 == null) goto L41;
            Scene r21 = Scene.LIVE;
            r20.d(r18);
            goto L41
        L32:
            r18 = LiveVolume.UNMUTE;
            goto L33
        L38:
            r14.m2552invoke();
        L15:
            r9 = null;
            goto L16
        L8:
            r5 = null;
        L41:
            LivePreviewComponent r22 = this.a;
            r22.r.h(r11, r22.p);
        }
    }

    private final FragmentActivity getActivity() {
        return (FragmentActivity) this.n.getValue();
    }

    public final DialogFragment i2() {
        return (DialogFragment) this.q.getValue();
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final List<Class<?>> M1() {
        return CollectionsKt.listOf(vg3.a.class);
    }

    public LivePreviewComponent() {
        this.m = "com.bytedance.android.shopping.anchorv4.containers.AnchorV4Fragment";
        this.n = LazyKt.lazy(new LivePreviewComponent$activity$2(this));
        this.o = LazyKt.lazy(new LivePreviewComponent$window$2(this));
        this.q = LazyKt.lazy(new LivePreviewComponent$fragment$2(this));
        this.r = new l0();
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void S1() {
        super.S1();
        int r0 = 1;
        this.p = true;
        this.r.d(i2());
        int r3 = 2;
        if (Intrinsics.areEqual(g2().getNativeParams().getClearScreenUpon(), "clear_screen_upon_card") == false) goto L9;
        int r1 = lf.a.a;
        if (Intrinsics.areEqual(((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(O1())).b.d.a(), Boolean.TRUE) == false) goto L7;
        r0 = 2;
    L7:
        lf.a.a(r0, "clear_screen_upon_card");
        return;
    L9:
        if (Intrinsics.areEqual(g2().getNativeParams().getClearScreenUpon(), "clear_screen_upon_list") == false) goto L17;
        int r2 = lf.a.a;
        if (Intrinsics.areEqual(((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(O1())).b.d.a(), Boolean.TRUE) == true) goto L14;
        r3 = 1;
    L14:
        lf.a.a(r3, "clear_screen_upon_list");
        lf.a.b(true);
        return;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void T1() {
        super.T1();
        boolean r0 = false;
        h2(false);
        Window r2 = null;
        if (g2().getNativeParams().getFullMode() == true) goto L39;
        String r1 = g2().getNativeParams().getItemId();
        if (r1 != null) goto L7;
    L17:
        boolean r3 = false;
    L18:
        WindowConfig r4 = g2().getNativeParams().getWindowConfig();
        if (r4 == null) goto L21;
        Boolean r5 = Boolean.valueOf(r4.getVideoPriority());
    L22:
        Boolean r6 = ih3.g.b.hasLivePlayingMute();
        WindowConfig r7 = g2().getNativeParams().getWindowConfig();
        if (r7 != null) goto L25;
    L27:
        if (r0 == true) goto L32;
        WindowConfig r8 = g2().getNativeParams().getWindowConfig();
        if (r8 == null) goto L32;
        r8.setForceMute(Intrinsics.areEqual(r6, Boolean.TRUE));
    L32:
        if ((!Intrinsics.areEqual(r5, Boolean.FALSE)) == false) goto L39;
        if (r3 == false) goto L39;
        com.bytedance.android.shopping.anchorv3.utils.j.a();
        int r9 = ECSdk.a;
        IAdapterService r10 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r10 == null) goto L39;
        j r11 = r10.getLiveWindowService();
        if (r11 == null) goto L39;
        r11.stopShowFloat();
        goto L39
    L25:
        if (r7.getForceMute() != true) goto L27;
        r0 = true;
        goto L27
    L21:
        r5 = null;
        goto L22
    L7:
        if (r1.length() <= 0) goto L9;
        boolean r12 = true;
    L10:
        if (r12 == true) goto L12;
    L14:
        boolean r13 = false;
    L15:
        if (r13 != true) goto L17;
        r3 = true;
        goto L18
    L12:
        if ((!Intrinsics.areEqual(r1, "0")) == false) goto L14;
        r13 = true;
        goto L15
    L9:
        r12 = false;
    L39:
        l0 r14 = this.r;
        DialogFragment r15 = i2();
        r14.getClass();
        if (r15 == null) goto L46;
        int r16 = ECSdk.a;
        IAdapterService r17 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r17 == null) goto L46;
        com.bytedance.android.ec.adapter.api.e r18 = r17.getFragmentDispatcher();
        if (r18 == null) goto L46;
        r18.onActivityCreated(r15);
    L46:
        this.r.g(i2());
        l0 r19 = this.r;
        Dialog r20 = i2().getDialog();
        if (r20 == null) goto L49;
        r2 = r20.getWindow();
    L49:
        r19.i(r2);
        com.bytedance.android.shopping.prepurchase.arch.container.state.d<Boolean> r21 = ((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(O1())).b.d;
        com.bytedance.android.shopping.prepurchase.arch.container.state.a r22 = com.bytedance.android.shopping.prepurchase.arch.container.state.j.a;
        i<Boolean> r23 = new i();
        r23.c = true;
        r21.b(this, r23, new a(this));
    }

    @Override // vg3.p
    public final boolean U0() {
        AnchorV4Param r0 = g2();
        if (r0 != null) goto L5;
    L6:
        AnchorV4PlayerStateManager.t.getClass();
        if (AnchorV4PlayerStateManager.b.c() == true) goto L12;
        return false;
    L12:
        return true;
    L5:
        if (k0.a(r0) != true) goto L6;
        return true;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void U1() {
        super.U1();
        h2(true);
        this.r.c(i2());
        this.r.b(i2());
        l0 r0 = this.r;
        DialogFragment r1 = i2();
        AnchorV4Param r2 = g2();
        r0.getClass();
        l0.a(r1, r2);
        if (Intrinsics.areEqual(g2().getNativeParams().getClearScreenUpon(), "clear_screen_upon_card") == false) goto L9;
        if (Intrinsics.areEqual(((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(O1())).b.d.a(), Boolean.TRUE) == false) goto L7;
        lf.a.a(5, "clear_screen_upon_card");
    L16:
        int r3 = ECSdk.a;
        IAdapterService r4 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r4 == null) goto L24;
        j r5 = r4.getLiveWindowService();
        if (r5 != null) goto L21;
        return;
    L21:
        if (r5.isFloatWindowShowing() == false) goto L26;
        r5.stopShowFloat();
        return;
    L26:
        return;
    L24:
        return;
    L7:
        lf.a.a(4, "clear_screen_upon_card");
        goto L16
    L9:
        if (Intrinsics.areEqual(g2().getNativeParams().getClearScreenUpon(), "clear_screen_upon_list") == false) goto L16;
        if (Intrinsics.areEqual(((com.bytedance.android.shopping.prepurchase.business.pdp.e) com.bytedance.android.shopping.prepurchase.arch.container.e.a(O1())).b.d.a(), Boolean.TRUE) == false) goto L15;
        lf.a.a(3, "clear_screen_upon_list");
        int r6 = ECSdk.a;
        l r7 = (l) ECSdk.a(l.class);
        if (r7 == null) goto L15;
        r7.f(getActivity(), LivePreviewComponent.class.getName(), (Window) this.o.getValue());
    L15:
        lf.a.b(false);
        goto L16
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void V1() {
        super.V1();
        this.p = false;
        l0 r0 = this.r;
        DialogFragment r1 = i2();
        if (r1 == null) goto L11;
        FrameLayout r2 = r0.e;
        if (r2 == null) goto L13;
        int r3 = ECSdk.a;
        IAdapterService r4 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r4 == null) goto L14;
        com.bytedance.android.ec.adapter.api.e r5 = r4.getFragmentDispatcher();
        if (r5 == null) goto L15;
        r5.onPause(r1, r2);
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    L11:
        r0.getClass();
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void W1() {
        super.W1();
        int r0 = ECSdk.a;
        l r1 = (l) ECSdk.a(l.class);
        if (r1 == null) goto L5;
        r1.b(getActivity(), this.m, (Window) this.o.getValue());
    L5:
        this.r.e(i2());
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void X1() {
        super.X1();
        int r0 = ECSdk.a;
        l r1 = (l) ECSdk.a(l.class);
        if (r1 == null) goto L5;
        r1.a(getActivity(), this.m, (Window) this.o.getValue());
    L5:
        this.r.f(i2(), getActivity());
    }

    public final void h2(boolean r3) {
        boolean r0 = g2().getNativeParams().getFromLive();
        Lazy r1 = ECAppInfoService.a;
        if (ECAppInfoService.h() == false) goto L9;
        if (r0 == false) goto L10;
        int r2 = ECSdk.a;
        IAdapterService r4 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r4 == null) goto L11;
        r4.setAutoUnmute(r3);
        return;
    L11:
        return;
    L10:
        return;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.Component
    public final View c2(LayoutInflater r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        Intrinsics.checkNotNullParameter(r3, "container");
        FrameLayout r4 = new FrameLayout(r2.getContext());
        r4.setId(2131378443);
        return r4;
    }
}
