package com.bytedance.android.livesdk.livecommerce.promotionlist.presenter;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Space;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.livesdk.livecommerce.iron.ui.ECCustomizedElementView;
import com.bytedance.android.livesdk.livecommerce.iron.ui.IronPromotionListBackgroundView;
import com.bytedance.android.livesdk.livecommerce.iron.widgets.IronPromotionListToast;
import com.bytedance.android.livesdk.livecommerce.promotionlist.LivePromotionListParams;
import com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.LivePromotionListViewModel;
import com.bytedance.android.livesdk.livecommerce.room.api.ControllerExtensionsKt;
import com.bytedance.android.livesdk.livecommerce.room.controller.ControllerCenter;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.PromotionListController;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.utils.ECDisplayUtils;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.livecommerce.utils.o0;
import com.bytedance.android.livesdk.livecommerce.view.ECHostLiveNoPromotionLayoutImpl;
import com.bytedance.android.livesdk.livecommerce.view.ECLoadingStateView;
import com.bytedance.android.shopping.ligo.context.LigoViewManager;
import com.bytedance.android.ui.ec.widget.toast.ECToast;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import com.ss.android.ugc.aweme.kiwi.util.Query;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class LivePromotionListGroupPresenter extends com.bytedance.android.livesdk.livecommerce.promotionlist.base.a implements w83.c, z83.a {
    public static final /* synthetic */ int D = 0;
    public LigoViewManager A;
    public final Set<ViewGroup> B;
    public boolean C;
    public ECLoadingStateView j;
    public ECHostLiveNoPromotionLayoutImpl k;
    public IronPromotionListBackgroundView l;
    public IronPromotionListToast m;
    public boolean n;
    public View o;
    public FrameLayout p;
    public Space q;
    public Space r;
    public FrameLayout s;
    public int t;
    public boolean u;
    public final Lazy v;
    public boolean w;
    public float x;
    public final List<we3.c> y;
    public com.bytedance.android.shopping.ligo.context.b<?> z;

    public static final class a {
    }

    static {
    }

    public final void k0() {
        nj.d r0 = com.bytedance.android.ec.sdk.helper.d.b.getPadSplitService();
        if (r0 != null) goto L5;
        return;
    L5:
        int r2 = 0;
        if (d0().isInSplitScreen() == false) goto L8;
        r0.getSpiltWidth();
    L11:
        int r1 = ECDisplayUtils.a(Y().c());
        FrameLayout r3 = this.s;
        if (r3 == null) goto L16;
        LigoViewManager r4 = this.A;
        if (r4 == null) goto L16;
        r4.o(r3, r2, r1);
    L16:
        FrameLayout r5 = this.p;
        if (r5 == null) goto L22;
        LigoViewManager r6 = this.A;
        if (r6 == null) goto L23;
        r6.o(r5, r2, r1);
        return;
    L23:
        return;
    L22:
        return;
    L8:
        Context r7 = Y().c();
        ECDisplayUtils.ScreenType r8 = ECDisplayUtils.a;
        if (r7 == null) goto L11;
        Resources r9 = r7.getResources();
        r2 = WindowDisplayMetricsOverride.apply(r9, r9.getDisplayMetrics()).widthPixels;
        goto L11
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotionlist.base.a
    public final void c0() {
        super.c0();
        com.bytedance.android.shopping.ligo.context.b<?> r0 = this.z;
        if (r0 == null) goto L13;
        monitor-enter(r0);
        Intrinsics.checkNotNullParameter(this, "listener");     // Catch: Throwable -> L10
        if (r0.a.contains(this) == false) goto L8;
        r0.a.remove(this);     // Catch: Throwable -> L10
    L8:
        monitor-exit(r0);
    L10:
        th = move-exception;
        throw th;
    L13:
        IronPromotionListToast r1 = this.m;
        if (r1 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("toastView");
    L16:
        r1.a();
        IronPromotionListBackgroundView r2 = this.l;
        if (r2 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("backgroundView");
    L20:
        if (r2.l == true) goto L22;
    L24:
        boolean r3 = false;
    L25:
        if (r3 == false) goto L27;
        IronPromotionListBackgroundView r4 = r2;
    L28:
        if (r4 == null) goto L33;
        ECCustomizedElementView r5 = r2.j;
        if (r5 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("rightInterestView");
    L32:
        r5.e();
    L33:
        LivePromotionListParams r6 = d0().getListParams();
        if (r6 != null) goto L36;
    L38:
        Iterator<T> r7 = this.B.iterator();
    L40:
        if (r7.hasNext() == false) goto L44;
        ViewGroup r8 = (ViewGroup) r7.next();
        LigoViewManager r9 = this.A;
        if (r9 == null) goto L40;
        r9.d(r8);
        goto L40
    L44:
        this.B.clear();
        this.C = false;
        ((ArrayList) this.y).clear();
        return;
    L36:
        if (r6.getRoomId() == null) goto L38;
        ((LinkedHashMap) i0().K).clear();
        goto L38
    L27:
        r4 = null;
        goto L28
    L22:
        if (r2.j == null) goto L24;
        r3 = true;
        goto L25
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotionlist.base.a
    public final void e0() {
        final gi2.a r0 = d0().getPromotionListParams();
        r0.getClass();
        Intrinsics.checkNotNullParameter(this, "abilityProvider");
        com.bytedance.android.shopping.ligo.context.b<?> r1 = new com.bytedance.android.shopping.ligo.context.b(this);
        r0.a = r1;
        LiveRoomParams r2 = r0.getParamsModel(Reflection.getOrCreateKotlinClass(LiveRoomParams.class));
        PromotionListController.a r3 = PromotionListController.T;
        if (r2 == null) goto L5;
        String r5 = r2.getRoomId();
    L6:
        if (r2 == null) goto L8;
        String r4 = r2.getRoomUniqueKey();
    L9:
        r3.getClass();
        PromotionListController.a.c(r5, r4).J = r1;
        this.z = r1;
        monitor-enter(r1);
        Intrinsics.checkNotNullParameter(this, "listener");     // Catch: Throwable -> L64
        if (r1.a.contains(this) == true) goto L14;
        r1.a.add(this);     // Catch: Throwable -> L64
    L14:
        monitor-exit(r1);
        LinkedHashMap r6 = new LinkedHashMap();
        LiveRoomParams r7 = r0.getParamsModel(Reflection.getOrCreateKotlinClass(LiveRoomParams.class));
        if (r7 == null) goto L31;
        Map r8 = r7.generaInitialData();
        if (r8 == null) goto L31;
        Map r9 = MapsKt.toMutableMap(r8);
        if (r9 == null) goto L31;
        LinkedHashMap r10 = new LinkedHashMap();     // Catch: Exception -> L29
        JSONObject r11 = r7.addToCartEntranceInfo();     // Catch: Exception -> L29
        Iterator<String> r12 = r11.keys();     // Catch: Exception -> L29
    L23:
        if (r12.hasNext() == false) goto L27;
        String r13 = r12.next();     // Catch: Exception -> L29
        if (r9.containsKey(r13) == true) goto L23;
        r10.put(r13, r11.get(r13));     // Catch: Exception -> L29
        goto L23
    L27:
        Unit r14 = Unit.INSTANCE;     // Catch: Exception -> L29
        r9.put("cart_track_params", r10);     // Catch: Exception -> L29
    L32:
        if (r9 == null) goto L34;
        r6.putAll(r9);
    L34:
        r6.put("ecom_scene_id", ControllerCenter.b(null).a());
        String r15 = d0().getParams().getLiveListChannel();
        if (r15 == null) goto L37;
        r6.put("live_list_channel", r15);
    L37:
        Fragment r16 = ((QFragmentPresenter) this).e;
        Function0<Map<String, ? extends Object>> r17 = new LivePromotionListGroupPresenter$init$1$1(r0);
        Intrinsics.checkNotNullParameter(r16, "lifecycleOwner");
        this.A = new LigoViewManager(r16, r6, r0.a, r17, null, new gi2.b(r0));
        d0().setLigoContext(this.z);
        d0().setLigoViewManager(this.A);
        ECLoadingStateView r18 = (ECLoadingStateView) Z().b(2131371364).f();
        r18.setRetryClickListener(new i(this));
        Unit r19 = Unit.INSTANCE;
        this.j = r18;
        ECHostLiveNoPromotionLayoutImpl r20 = (ECHostLiveNoPromotionLayoutImpl) Z().b(2131381072).f();
        r20.setIronNoPromotion(th.a.g(Y().c(), 2131896834));
        this.k = r20;
        this.l = (IronPromotionListBackgroundView) Z().b(2131376517).f();
        this.m = (IronPromotionListToast) Z().b(2131375635).f();
        FrameLayout r21 = (FrameLayout) Z().b(2131372689).f();
        r21.addOnLayoutChangeListener(new j(this));
        this.p = r21;
        this.p = (FrameLayout) Z().b(2131372689).f();
        Space r22 = (Space) Z().b(2131378149).f();
        r22.addOnLayoutChangeListener(new k(this));
        this.q = r22;
        this.r = (Space) Z().b(2131378128).f();
        this.s = (FrameLayout) Z().b(2131372799).f();
        if (d0().isInSplitScreen() == false) goto L40;
        Query r23 = Z().b(2131376696);
        com.bytedance.android.ec.core.widget.f.a(r23, new LivePromotionListGroupPresenter$initViews$$inlined$apply$lambda$1(this));
        r23.g(0);
        ConstraintLayout r24 = Z().f();
        ConstraintSet r25 = new ConstraintSet();
        r25.clone(r24);
        r25.setVerticalBias(2131383373, 0.5f);
        r25.applyTo(r24);
    L41:
        com.bytedance.android.shopping.ligo.context.b<?> r26 = this.z;
        if (r26 == null) goto L44;
        r26.e("livelist_tab", (ViewGroup) Z().b(2131372865).f(), Z().b(2131365291).f());
    L44:
        com.bytedance.android.shopping.ligo.context.b<?> r27 = this.z;
        if (r27 == null) goto L47;
        r27.e("livelist", (ViewGroup) Z().b(2131372823).f(), Z().b(2131372822).f());
    L47:
        com.bytedance.android.shopping.ligo.context.b<?> r28 = this.z;
        if (r28 == null) goto L51;
        r28.e("livelist_banner", (ViewGroup) Z().b(2131372751).f(), Z().b(2131374206).f());
    L51:
        if (this.z == null) goto L54;
        Intrinsics.checkNotNullParameter(LivePromotionListGroupPresenter$initLigoTokenViews$1.INSTANCE, "function");
    L54:
        if (this.z == null) goto L56;
        Intrinsics.checkNotNullParameter(LivePromotionListGroupPresenter$initLigoTokenViews$2.INSTANCE, "function");
    L56:
        com.bytedance.android.ec.core.arch.state.c.a(d0(), ECQuickUtilKt.a(Y()), LivePromotionListGroupPresenter$observeData$1.INSTANCE, new LivePromotionListGroupPresenter$observeData$2(this));
        com.bytedance.android.ec.core.arch.state.c.a(d0(), ECQuickUtilKt.a(Y()), LivePromotionListGroupPresenter$observeData$3.INSTANCE, new LivePromotionListGroupPresenter$observeData$4(this));
        com.bytedance.android.ec.core.arch.state.c.a(d0(), ECQuickUtilKt.a(Y()), LivePromotionListGroupPresenter$observeData$5.INSTANCE, new LivePromotionListGroupPresenter$observeData$6(this));
        com.bytedance.android.ec.core.arch.state.c.a(d0(), ECQuickUtilKt.a(Y()), LivePromotionListGroupPresenter$observeData$7.INSTANCE, new LivePromotionListGroupPresenter$observeData$8(this));
        com.bytedance.android.ec.core.arch.state.c.a(d0(), ECQuickUtilKt.a(Y()), LivePromotionListGroupPresenter$observeData$9.INSTANCE, new LivePromotionListGroupPresenter$observeData$10(this));
        com.bytedance.android.ec.core.arch.state.c.a(d0(), Y().e(), LivePromotionListGroupPresenter$observeData$11.INSTANCE, new LivePromotionListGroupPresenter$observeData$12(this));
        com.bytedance.android.ec.core.arch.event.c.c(d0(), ECQuickUtilKt.a(Y()), Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.n.class), new LivePromotionListGroupPresenter$observeData$13(this));
        com.bytedance.android.ec.core.arch.event.c.c(d0(), ECQuickUtilKt.a(Y()), Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.x.class), new LivePromotionListGroupPresenter$observeData$14(this));
        com.bytedance.android.ec.core.arch.event.c.c(d0(), ECQuickUtilKt.a(Y()), Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.k.class), new LivePromotionListGroupPresenter$observeData$15(this));
        com.bytedance.android.ec.core.arch.event.c.c(d0(), ECQuickUtilKt.a(Y()), Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.d.class), new LivePromotionListGroupPresenter$observeData$16(this));
        com.bytedance.android.ec.core.arch.event.c.c(d0(), ECQuickUtilKt.a(Y()), Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.C0097a.class), new LivePromotionListGroupPresenter$observeData$17(this));
        com.bytedance.android.ec.core.arch.event.c.c(d0(), ECQuickUtilKt.a(Y()), Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.g0.class), new LivePromotionListGroupPresenter$observeData$18(this));
        com.bytedance.android.ec.core.arch.event.c.c(d0(), ECQuickUtilKt.a(Y()), Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.v.class), new LivePromotionListGroupPresenter$observeData$19(this));
        d0().getListHeaderViewModel().a.observe(ECQuickUtilKt.a(Y()), new n(this));
        d0().getListHeaderViewModel().b.observe(ECQuickUtilKt.a(Y()), new o(this));
        if (d0().isInSplitScreen() == false) goto L59;
        com.bytedance.android.ec.core.arch.event.c.c(d0(), ECQuickUtilKt.a(Y()), Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.c0.class), new LivePromotionListGroupPresenter$observeData$22(this));
    L59:
        com.bytedance.android.shopping.ligo.context.b<?> r29 = this.z;
        if (r29 == null) goto L62;
        r29.c("bottom_open_region_height", new p(this));
    L62:
        d0().updateECShoppingCartTask();
        return;
    L40:
        Z().b(2131376696).c();
        ConstraintLayout r30 = Z().f();
        ConstraintSet r31 = new ConstraintSet();
        r31.clone(r30);
        r31.setVerticalBias(2131383373, 1.0f);
        r31.applyTo(r30);
    L29:
        e = move-exception;
        ye.a.b(e);
    L31:
        r9 = null;
    L64:
        th = move-exception;
        throw th;
    L8:
        r4 = null;
        goto L9
    L5:
        r5 = null;
        goto L6
    }

    public final PromotionListController i0() {
        RoomContextController r0 = d0().getRoomContextController();
        LivePromotionListParams r1 = d0().getListParams();
        if (r1 == null) goto L5;
        String r2 = r1.getRoomId();
    L7:
        return ControllerExtensionsKt.c(r0, r2).A().r;
    L5:
        r2 = null;
        goto L7
    }

    public static final void h0(LivePromotionListGroupPresenter r6) {
        Space r0 = r6.q;
        if (r0 == null) goto L5;
        int r2 = r6.t;
        Context r3 = r6.Y().c();
        boolean r4 = r6.d0().isInSplitScreen();
        Lazy r5 = UtilityKotlinExtentionsKt.a;
        Intrinsics.checkNotNullParameter(r3, "context");
        o0.f(r0, (int) UtilityKotlinExtentionsKt.a(r2, r3, r4));
    L5:
        Space r1 = r6.r;
        if (r1 == null) goto L8;
        int r7 = r6.t;
        Context r8 = r6.Y().c();
        boolean r9 = r6.d0().isInSplitScreen();
        Lazy r10 = UtilityKotlinExtentionsKt.a;
        Intrinsics.checkNotNullParameter(r8, "context");
        o0.f(r1, (int) UtilityKotlinExtentionsKt.a(r7, r8, r9));
    L8:
        r6.x = UtilityKotlinExtentionsKt.a(r6.t, r6.Y().c(), r6.d0().isInSplitScreen());
    }

    public void onEvent(z83.b r7) {
        Intrinsics.checkNotNullParameter(r7, "event");
        if ((r7 instanceof we3.b.b) == false) goto L6;
        com.bytedance.android.ec.core.arch.event.c.d(d0(), new com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.g(((we3.b.b) r7).b));
        return;
    L6:
        if ((r7 instanceof we3.b.d) == false) goto L9;
        LivePromotionListViewModel r0 = d0();
        ((we3.b.d) r7).getClass();
        com.bytedance.android.ec.core.arch.event.c.d(r0, new com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.f0());
        return;
    L9:
        if ((r7 instanceof we3.b.a) == false) goto L17;
        boolean r8 = ((we3.b.a) r7).b;
        View r1 = ((QFragmentPresenter) this).e.getView();
        if (r1 != null) goto L13;
        return;
    L13:
        if (r8 == false) goto L15;
        r1.animate().translationY(0.0f).setDuration(300).start();
        return;
    L15:
        r1.animate().translationY(r1.getMeasuredHeight()).setDuration(300).start();
        return;
    L17:
        if ((r7 instanceof we3.b.c) == false) goto L29;
        we3.b.c r9 = (we3.b.c) r7;
        if (r9.b == false) goto L22;
        d0().refreshPromotionListWithLoading();
        return;
    L22:
        if (r9.c == false) goto L24;
        d0().updateWhenBackFromOtherPage(0, true);
    L26:
        if (r9.d == false) goto L38;
        com.bytedance.android.ec.core.arch.event.c.d(d0(), com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.f.a);
        return;
    L38:
        return;
    L24:
        LivePromotionListViewModel.updateWhenBackFromOtherPage$default(d0(), null, false, 3, null);
        goto L26
    L29:
        if ((r7 instanceof we3.a.c) == false) goto L40;
        com.bytedance.android.ec.core.arch.event.c.d(d0(), new com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.h0(new com.bytedance.android.livesdk.livecommerce.promotionlist.utils.instant.a(new ll.a(0), "quit", true, null)));
        return;
    }

    public LivePromotionListGroupPresenter(Fragment r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2, r3);
        this.u = true;
        this.v = LazyKt.lazy(new LivePromotionListGroupPresenter$shoppingCartView$2(this));
        this.y = new ArrayList();
        this.B = new LinkedHashSet();
    }

    public final void j0(String r3, boolean r4) {
        Context r0 = Y().c();
        if (a2.b(r3) == false) goto L6;
        ECToast.INSTANCE.showToast(r0, r3, Boolean.valueOf(r4));
        return;
    }

    public final void l0(boolean r5, boolean r6) {
        int r0 = 0;
        if (r6 == false) goto L18;
        if (r5 == true) goto L8;
        r0 = 8;
    L8:
        this.w = r5;
        d0().updateAllViewsVisible(r5);
        Y().d().q(com.bytedance.android.livesdk.livecommerce.iron.listheader.c.class, r0);
        QUIManager r1 = Y().d();
        if (d0().disableUpdateInteractionData() == false) goto L11;
        int r3 = 8;
    L12:
        r1.q(nj2.f.class, r3);
        Y().d().q(nj2.e.class, r0);
        Y().d().q(nj2.b.class, r0);
        Y().d().q(nj2.c.class, r0);
        if (r5 == true) goto L24;
        View r7 = this.o;
        if (r7 == null) goto L25;
        r7.setVisibility(8);
        return;
    L25:
        return;
    L24:
        return;
    L11:
        r3 = r0;
        goto L12
    L18:
        if (this.w == false) goto L27;
        if (r5 == true) goto L22;
        r0 = 4;
    L22:
        Y().d().q(nj2.b.class, r0);
        Y().d().q(nj2.c.class, r0);
        return;
    }
}
