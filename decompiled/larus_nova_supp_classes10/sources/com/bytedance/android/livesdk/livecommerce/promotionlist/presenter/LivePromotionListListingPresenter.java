package com.bytedance.android.livesdk.livecommerce.promotionlist.presenter;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.common.api.IECCommonService;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.monitor.MonitorScenes;
import com.bytedance.android.ec.core.monitor.fps.RealFpsMonitor;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.ec.opt.prerender.PrerenderDialog;
import com.bytedance.android.ec.opt.prerender.PrerenderDialogFragment;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.livesdk.livecommerce.dynamiccontext.LiveDynamicContext;
import com.bytedance.android.livesdk.livecommerce.eventcenter.LiveEventCenter;
import com.bytedance.android.livesdk.livecommerce.eventcenter.ability.g0;
import com.bytedance.android.livesdk.livecommerce.iron.utils.RecyclerViewExposeUtil$setRecyclerItemExposeListener$1;
import com.bytedance.android.livesdk.livecommerce.iron.widgets.PromotionLinearLayoutManager;
import com.bytedance.android.livesdk.livecommerce.iron.widgets.PromotionRecyclerView;
import com.bytedance.android.livesdk.livecommerce.promotion.card.PromotionCardModuleName;
import com.bytedance.android.livesdk.livecommerce.promotion.card.widget.ECAddCartMotionCommonLayout;
import com.bytedance.android.livesdk.livecommerce.promotion.card.widget.ECAddCartMotionLayout;
import com.bytedance.android.livesdk.livecommerce.promotionlist.LivePromotionListFragment;
import com.bytedance.android.livesdk.livecommerce.promotionlist.LivePromotionListParams;
import com.bytedance.android.livesdk.livecommerce.promotionlist.adapter.LivePromotionListPageAdapter;
import com.bytedance.android.livesdk.livecommerce.promotionlist.utils.instant.InstantAddOnFloorManager;
import com.bytedance.android.livesdk.livecommerce.promotionlist.viewholder.LivePromotionItemViewHolder;
import com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.LivePromotionListViewModel;
import com.bytedance.android.livesdk.livecommerce.room.api.ControllerExtensionsKt;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.PromotionListController;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.shopping.ligo.container.event.AddCartExtraData;
import com.bytedance.android.shopping.ligo.container.event.AddCartProductInfoData;
import com.bytedance.android.shopping.ligo.container.event.LiveLigoCartStatusChangeEventData;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class LivePromotionListListingPresenter extends com.bytedance.android.livesdk.livecommerce.promotionlist.base.a implements com.bytedance.android.livesdk.livecommerce.eventcenter.ability.a {
    public com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.subviewmodel.b j;
    public PromotionRecyclerView k;
    public PromotionLinearLayoutManager l;
    public LivePromotionListPageAdapter m;
    public boolean n;
    public boolean o;
    public final wj2.i p;
    public final Lazy<LivePromotionListListingPresenter$itemDecoration$1.AnonymousClass1> q;
    public final a r;
    public final Lazy s;
    public ca3.b t;
    public boolean u;

    public static final class a implements a93.b<String> {
        public final /* synthetic */ LivePromotionListListingPresenter a;

        public a(LivePromotionListListingPresenter r1) {
            this.a = r1;
        }

        public final void a(Object r3) {
            String r4 = (String) r3;
            wj2.g r5 = this.a.d0().getInitialAction();
            if ((r5 instanceof wj2.g.a) == false) goto L6;
            wj2.g.a r6 = (wj2.g.a) r5;
            this.a.X(r6.a, r6.b);
            this.a.d0().setInitialAction(null);
            return;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.promotionlist.presenter.LivePromotionListListingPresenter$showCardBottomAddOnFloor$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    final /* synthetic */ class AnonymousClass1 extends MutablePropertyReference0Impl {
        public AnonymousClass1(LivePromotionListListingPresenter r7) {
            super(r7, LivePromotionListListingPresenter.class, "adapter", "getAdapter()Lcom/bytedance/android/livesdk/livecommerce/promotionlist/adapter/LivePromotionListPageAdapter;", 0);
        }

        public Object get() {
            return LivePromotionListListingPresenter.h0((LivePromotionListListingPresenter) ((CallableReference) this).receiver);
        }

        public void set(Object r2) {
            LivePromotionListPageAdapter r3 = (LivePromotionListPageAdapter) r2;
            ((LivePromotionListListingPresenter) ((CallableReference) this).receiver).m = r3;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.promotionlist.presenter.LivePromotionListListingPresenter$showCardBottomAddOnFloor$2, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    final /* synthetic */ class AnonymousClass2 extends MutablePropertyReference0Impl {
        public AnonymousClass2(LivePromotionListListingPresenter r7) {
            super(r7, LivePromotionListListingPresenter.class, "layoutManager", "getLayoutManager()Lcom/bytedance/android/livesdk/livecommerce/iron/widgets/PromotionLinearLayoutManager;", 0);
        }

        public Object get() {
            return LivePromotionListListingPresenter.i0((LivePromotionListListingPresenter) ((CallableReference) this).receiver);
        }

        public void set(Object r2) {
            PromotionLinearLayoutManager r3 = (PromotionLinearLayoutManager) r2;
            ((LivePromotionListListingPresenter) ((CallableReference) this).receiver).l = r3;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.promotionlist.presenter.LivePromotionListListingPresenter$showCardBottomAddOnFloor$3, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    final /* synthetic */ class AnonymousClass3 extends MutablePropertyReference0Impl {
        public AnonymousClass3(LivePromotionListListingPresenter r7) {
            super(r7, LivePromotionListListingPresenter.class, "recyclerView", "getRecyclerView()Lcom/bytedance/android/livesdk/livecommerce/iron/widgets/PromotionRecyclerView;", 0);
        }

        public Object get() {
            return LivePromotionListListingPresenter.k0((LivePromotionListListingPresenter) ((CallableReference) this).receiver);
        }

        public void set(Object r2) {
            PromotionRecyclerView r3 = (PromotionRecyclerView) r2;
            ((LivePromotionListListingPresenter) ((CallableReference) this).receiver).k = r3;
        }
    }

    @Override // com.bytedance.android.livesdk.livecommerce.eventcenter.ability.a
    public final Bundle Q() {
        Bundle r0 = new Bundle();
        Integer r1 = d0().getAddCartToastOrder();
        if (r1 == null) goto L5;
        int r2 = r1.intValue();
    L6:
        r0.putInt("add_cart_toast_order", r2);
        return r0;
    L5:
        r2 = 0;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotionlist.base.a
    public final void c0() {
        if (this.g == false) goto L22;
        LivePromotionListPageAdapter r0 = this.m;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L7:
        r0.C2();
        PromotionRecyclerView r1 = this.k;
        if (r1 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L10:
        r1.setAdapter(null);
        PromotionRecyclerView r2 = this.k;
        if (r2 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L13:
        r2.clearOnScrollListeners();
        com.bytedance.android.shopping.ligo.context.b<?> r3 = d0().getLigoContext();
        if (r3 == null) goto L22;
        a r4 = this.r;
        Intrinsics.checkNotNullParameter("cart_icon_loc", "key");
        Intrinsics.checkNotNullParameter(r4, "listener");
        Intrinsics.checkNotNullParameter("live_commerce", "bizName");
        a93.a r5 = (a93.a) ((LinkedHashMap) r3.c).get("cart_icon_loc");
        if (r5 == null) goto L22;
        Intrinsics.checkNotNullParameter(r4, "listener");
        List r6 = r5.c;
        if (r6 == null) goto L21;
        TypeIntrinsics.asMutableCollection(r6).remove(r4);
        goto L22
    L21:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
    L22:
        s0.e(this);
        jh.b.a r7 = jh.b.c;
        String r8 = MonitorScenes.FLUENCY_SCENE_PROMOTIONS_FRAGMENT.getSceneName();
        r7.getClass();
        Intrinsics.checkNotNullParameter(r8, "sceneName");
        jh.b.a.remove(r8);
        Iterator<T> r9 = d0().getTotalPromotions().iterator();
    L24:
        if (r9.hasNext() == false) goto L26;
        ((ql.a) r9.next()).getClientData().h = null;
        goto L24
    L26:
        Lazy r10 = LiveDynamicContext.c;
        com.bytedance.android.livesdk.livecommerce.ability.h r11 = LiveDynamicContext.a.a().a().e();
        if ((r11 instanceof com.bytedance.android.livesdk.livecommerce.eventcenter.ability.c) == true) goto L29;
        r11 = null;
    L29:
        com.bytedance.android.livesdk.livecommerce.eventcenter.ability.c r12 = (com.bytedance.android.livesdk.livecommerce.eventcenter.ability.c) r11;
        if (r12 == null) goto L32;
        r12.a = null;
    L32:
        LiveDynamicContext.a.a().a().c();
        super.c0();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotionlist.base.a
    public final void e0() {
        this.j = d0().getListingViewModel();
        Object r1 = a0();
        if (r1 == null) goto L70;
        PromotionRecyclerView r2 = (PromotionRecyclerView) r1;
        this.k = r2;
        com.bytedance.android.livesdk.livecommerce.ability.h r3 = null;
        r2.setItemAnimator(null);
        PromotionRecyclerView r4 = this.k;
        if (r4 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L7:
        r4.setHasFixedSize(true);
        this.l = new PromotionLinearLayoutManager(Y().c());
        PromotionRecyclerView r5 = this.k;
        if (r5 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L10:
        PromotionLinearLayoutManager r6 = this.l;
        if (r6 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
    L13:
        r5.setLayoutManager(r6);
        LifecycleOwner r7 = ECQuickUtilKt.a(Y());
        LivePromotionListViewModel r8 = d0();
        com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.subviewmodel.a r9 = d0().getFooterViewModel();
        PromotionRecyclerView r10 = this.k;
        if (r10 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L16:
        PromotionLinearLayoutManager r11 = this.l;
        if (r11 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
    L19:
        this.m = new LivePromotionListPageAdapter(r7, r8, r9, r10, r11, d0().getPromotionListEventActionImpl(), d0().getEventMap(), new q(), new r(this), new s(this));
        PromotionRecyclerView r12 = this.k;
        if (r12 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L22:
        LivePromotionListPageAdapter r13 = this.m;
        if (r13 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L25:
        r12.setAdapter(r13);
        PromotionRecyclerView r14 = this.k;
        if (r14 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L28:
        r14.addOnScrollListener(new LivePromotionListListingPresenter$initViews$4(this));
        int r15 = ai2.b.a;
        RecyclerView r16 = this.k;
        if (r16 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L31:
        final t r17 = new t(this);
        Intrinsics.checkNotNullParameter(r16, "recyclerView");
        Intrinsics.checkNotNullParameter(r17, "onExposeListener");
        if (r16.getVisibility() != 0) goto L35;
        r16.addOnScrollListener(new RecyclerViewExposeUtil$setRecyclerItemExposeListener$1(r17));
    L35:
        jh.b.a r18 = jh.b.c;
        MonitorScenes r19 = MonitorScenes.FLUENCY_SCENE_PROMOTIONS_FRAGMENT;
        JSONObject r20 = new JSONObject();
        r20.put("instant_type", String.valueOf(d0().getRoomContextController().A().t.U));
        Unit r21 = Unit.INSTANCE;
        com.bytedance.android.ec.core.monitor.q r22 = new com.bytedance.android.ec.core.monitor.q(r19, null, r20);
        r18.getClass();
        RealFpsMonitor r23 = jh.b.a.a(r22);
        PromotionRecyclerView r24 = this.k;
        if (r24 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L38:
        r23.b(r24);
        Fragment r25 = ((QFragmentPresenter) this).e;
        if ((r25 instanceof LivePromotionListFragment) == true) goto L41;
        r25 = null;
    L41:
        LivePromotionListFragment r26 = (LivePromotionListFragment) r25;
        if (r26 == null) goto L50;
        PrerenderDialog r27 = ((PrerenderDialogFragment) r26).g;
        if (r27 == null) goto L50;
        Window r28 = r27.getWindow();
        if (r28 == null) goto L50;
        Intrinsics.checkNotNullParameter(r28, "window");
        if (ECSettingKeys.a() == false) goto L50;
        int r29 = com.bytedance.android.ec.core.monitor.m.a;
        Intrinsics.checkNotNullParameter(r23.a, "fpsTracer");
        Intrinsics.checkNotNullParameter(r28, "window");
    L50:
        jh.c r30 = jh.b.a.d(r19);
        r30.a("instant_type", String.valueOf(d0().getRoomContextController().A().t.U));
        PromotionRecyclerView r31 = this.k;
        if (r31 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L53:
        r30.c(r31);
        d0().setGetCurrentPosition(new LivePromotionListListingPresenter$initViews$9(this));
        d0().setGetCardLoc(new LivePromotionListListingPresenter$initViews$10(this));
        int r32 = ECSdk.a;
        ca3.c r33 = (ca3.c) ECSdk.a(ca3.c.class);
        if (r33 == null) goto L61;
        ca3.b r34 = r33.attach();
        if (r34 == null) goto L61;
        this.t = r34;
        PromotionRecyclerView r35 = this.k;
        if (r35 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L60:
        r34.a(r35, new x(this));
    L61:
        com.bytedance.android.ec.core.arch.event.c.c(d0(), ECQuickUtilKt.a(Y()), Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.e.class), new LivePromotionListListingPresenter$observeData$1(this));
        com.bytedance.android.ec.core.arch.event.c.c(d0(), ECQuickUtilKt.a(Y()), Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.q.class), new LivePromotionListListingPresenter$observeData$2(this));
        com.bytedance.android.ec.core.arch.event.c.c(d0(), ECQuickUtilKt.a(Y()), Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.t.class), new LivePromotionListListingPresenter$observeData$3(this));
        com.bytedance.android.ec.core.arch.event.c.c(d0(), ECQuickUtilKt.a(Y()), Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.j.class), new LivePromotionListListingPresenter$observeData$4(this));
        com.bytedance.android.ec.core.arch.event.c.c(d0(), ECQuickUtilKt.a(Y()), Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.d0.class), new LivePromotionListListingPresenter$observeData$5(this));
        com.bytedance.android.ec.core.arch.event.c.c(d0(), ECQuickUtilKt.a(Y()), Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.h0.class), new LivePromotionListListingPresenter$observeData$6(this));
        d0().getPageListLiveData().observe(ECQuickUtilKt.a(Y()), new u(this));
        com.bytedance.android.ec.core.arch.state.c.a(d0(), Y().e(), LivePromotionListListingPresenter$observeData$8.INSTANCE, new LivePromotionListListingPresenter$observeData$9(this));
        Lazy r36 = LiveDynamicContext.c;
        LiveDynamicContext.a.a().a().b("show_promotion_card_guide", new g0(new w(this)));
        s0.c(this);
        com.bytedance.android.livesdk.livecommerce.ability.h r37 = LiveDynamicContext.a.a().a().e();
        if ((r37 instanceof com.bytedance.android.livesdk.livecommerce.eventcenter.ability.c) == false) goto L65;
        r3 = r37;
    L65:
        com.bytedance.android.livesdk.livecommerce.eventcenter.ability.c r38 = (com.bytedance.android.livesdk.livecommerce.eventcenter.ability.c) r3;
        if (r38 == null) goto L71;
        Intrinsics.checkNotNullParameter(this, "callback");
        r38.a = this;
        return;
    L71:
        return;
    L70:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.livecommerce.iron.widgets.PromotionRecyclerView");
    }

    public static final /* synthetic */ LivePromotionListPageAdapter h0(LivePromotionListListingPresenter r1) {
        LivePromotionListPageAdapter r2 = r1.m;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L5:
        return r2;
    }

    public static final /* synthetic */ PromotionLinearLayoutManager i0(LivePromotionListListingPresenter r1) {
        PromotionLinearLayoutManager r2 = r1.l;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
    L5:
        return r2;
    }

    public static final PromotionListController j0(LivePromotionListListingPresenter r1) {
        RoomContextController r0 = r1.d0().getRoomContextController();
        LivePromotionListParams r2 = r1.d0().getListParams();
        if (r2 == null) goto L5;
        String r3 = r2.getRoomId();
    L7:
        return ControllerExtensionsKt.c(r0, r3).A().r;
    L5:
        r3 = null;
        goto L7
    }

    public static final /* synthetic */ PromotionRecyclerView k0(LivePromotionListListingPresenter r1) {
        PromotionRecyclerView r2 = r1.k;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L5:
        return r2;
    }

    public static View o0(LivePromotionItemViewHolder r3) {
        com.bytedance.android.ec.common.api.jump.model.g r0 = r3.Y0();
        Integer r1 = null;
        if (r0 == null) goto L5;
        ql.a r2 = r0.a;
    L6:
        if (r2 == null) goto L19;
        com.bytedance.android.ec.model.response.v r4 = r2.getStepperInfo();
        if (r4 == null) goto L19;
        Integer r5 = Integer.valueOf(r4.b());
        if (r5.intValue() <= 0) goto L12;
        boolean r6 = true;
    L13:
        if (r6 == false) goto L15;
        r1 = r5;
    L15:
        if (r1 == null) goto L19;
        r1.intValue();
        return ((RecyclerView.ViewHolder) r3).itemView.findViewById(2131390286);
    L12:
        r6 = false;
    L19:
        return ((RecyclerView.ViewHolder) r3).itemView.findViewById(2131376638);
    L5:
        r2 = null;
        goto L6
    }

    private final void showCardBottomAddOnFloor(com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.h0 r2) {
        if (this.m != null) goto L5;
        return;
    L5:
        if (this.l != null) goto L7;
        return;
    L7:
        if (this.k == null) goto L13;
        ((InstantAddOnFloorManager) this.s.getValue()).showCardBottomAddOnFloor(r2);
        return;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onAddToShopCartSuccess(hl.b r25) {
        Intrinsics.checkNotNullParameter(r25, "event");
        Function0<Integer> r0 = d0().getGetCurrentTab();
        int r1 = 0;
        if (r0 == null) goto L7;
        Integer r2 = (Integer) r0.invoke();
        if (r2 == null) goto L7;
        int r3 = r2.intValue();
    L9:
        if (r3 != (!d0().isDefaultTab())) goto L11;
        boolean r4 = true;
    L12:
        if (r4 == true) goto L14;
        return;
    L14:
        Integer r5 = d0().getAddCartOpt();
        if (r5 != null) goto L18;
    L19:
        int r6 = wj2.f.a;
        if (wj2.f.a(d0().getParams().getRoomId(), d0().getRoomContextController().D()) == true) goto L23;
        boolean r7 = false;
    L24:
        dm.a.a("LiveAddCart").i("checkSearchAddCartAndPlayAnim -> recv AddShopCartSuccessEvent, sourcePage=" + r25.j + ", addCartOpt=" + d0().getAddCartOpt());
        Integer r8 = r25.j;
        jf.e.f r9 = jf.e.f.b;
        if (r8 != null) goto L28;
    L30:
        PromotionListController r10 = ControllerExtensionsKt.c(d0().getRoomContextController(), d0().getParams().getRoomId()).A().r;
        Pair<Integer, Integer> r11 = r10.B;
        if (r11 == null) goto L55;
        int r12 = ((Number) r11.component1()).intValue();
        int r13 = ((Number) r11.component2()).intValue();
        if (r12 <= 0) goto L36;
        if (r13 <= 0) goto L36;
        boolean r14 = true;
    L37:
        if (r14 == true) goto L40;
        r11 = null;
    L40:
        if (r11 == null) goto L55;
        int r15 = ((Number) r11.component1()).intValue();
        int r16 = ((Number) r11.component2()).intValue();
        Pair<Integer, Integer> r17 = r10.C;
        if (r17 == null) goto L53;
        int r18 = ((Number) r17.component1()).intValue();
        int r19 = ((Number) r17.component2()).intValue();
        if (r18 <= 0) goto L47;
        if (r19 <= 0) goto L47;
        boolean r110 = true;
    L48:
        if (r110 == true) goto L51;
        r17 = null;
    L51:
        if (r17 == null) goto L53;
        int r111 = ((Number) r17.component1()).intValue();
        int r112 = ((Number) r17.component2()).intValue();
        int r113 = wj2.c.a;
        wj2.c.b(Y().c(), new float[]{r15, r16}, new float[]{r111, r112}, null, 4088);
        r10.B = null;
        r10.C = null;
    L54:
        boolean r20 = true;
    L57:
        if (r20 == false) goto L59;
        dm.a.a("LiveAddCart").i("onAddToShopCartSuccess -> play add cart anim for search page promotion card.");
    L267:
        if (ECSettingKeys.A() == false) goto L283;
        Integer r21 = r25.c;
        if (r21 == null) goto L283;
        if (r21.intValue() != 201) goto L283;
        Iterator<T> r22 = d0().getTotalPromotions().iterator();
    L275:
        if (r22.hasNext() == false) goto L279;
        Object r23 = r22.next();
        if (Intrinsics.areEqual(((ql.a) r23).getProductId(), r25.d) == false) goto L275;
    L280:
        ql.a r24 = (ql.a) r23;
        if (r24 == null) goto L283;
        Lazy r26 = LiveEventCenter.b;
        LiveEventCenter.a.a().sendEvent("add_cart_success_in_live_list", r24);
        Unit r27 = Unit.INSTANCE;
        goto L283
    L279:
        r23 = null;
    L283:
        com.bytedance.android.shopping.ligo.context.b<?> r28 = d0().getLigoContext();
        if (r28 == null) goto L336;
        String r114 = r25.d;
        String r115 = r25.f;
        String r29 = r25.g;
        if (r29 == null) goto L288;
        Integer r116 = StringsKt.toIntOrNull(r29);
    L290:
        if (Intrinsics.areEqual(r25.h, "edit_cart_from_stepper") == false) goto L292;
        String r117 = "edit_cart_from_stepper";
    L293:
        Integer r30 = r25.c;
        if (r30 != null) goto L297;
    L317:
        AddCartExtraData r118 = null;
    L318:
        r28.g(new we3.a.a(new LiveLigoCartStatusChangeEventData(0, r114, r115, r116, r117, r118)));
        Unit r31 = Unit.INSTANCE;
        return;
    L297:
        if (r30.intValue() != 201) goto L317;
        com.bytedance.android.livesdk.livecommerce.promotionlist.utils.instant.b r32 = d0().getTimestampTracker();
        String r33 = r25.d;
        if (r33 != null) goto L301;
        r33 = "";
    L301:
        Long r34 = r32.a(r33);
        if (r34 == null) goto L304;
        long r35 = r34.longValue();
    L305:
        long r119 = r35;
        long r210 = System.currentTimeMillis();
        Iterator<T> r36 = d0().getTotalPromotions().iterator();
    L307:
        if (r36.hasNext() == false) goto L311;
        Object r37 = r36.next();
        if (Intrinsics.areEqual(((ql.a) r37).getProductId(), r25.d) == false) goto L307;
    L312:
        ql.a r38 = (ql.a) r37;
        if (r38 == null) goto L315;
        AddCartProductInfoData r39 = new AddCartProductInfoData(r38.getProductId(), r38.getTitle(), r38.getPrice());
    L316:
        r118 = new AddCartExtraData("live_product_list", r119, r210, r39);
        goto L318
    L315:
        r39 = new AddCartProductInfoData(null, null, null);
        goto L316
    L311:
        r37 = null;
        goto L312
    L304:
        r35 = -1;
        goto L305
    L292:
        r117 = "edit_cart_from_other";
        goto L293
    L288:
        r116 = null;
        goto L290
    L336:
        return;
    L59:
        int r40 = -1;
        if (r7 == false) goto L161;
        Integer r41 = r25.c;
        if (r41 == null) goto L161;
        if (r41.intValue() != 201) goto L161;
        dm.a.a("LiveAddCart").i("onAddToShopCartSuccess live addCartOpt");
        PromotionLinearLayoutManager r42 = this.l;
        if (r42 != null) goto L69;
        Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
    L69:
        int r43 = r42.findFirstVisibleItemPosition();
        PromotionLinearLayoutManager r44 = this.l;
        if (r44 != null) goto L72;
        Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
    L72:
        int r45 = r44.findLastVisibleItemPosition();
        String r120 = r25.d;
        if (r120 == null) goto L267;
        List<ql.a> r121 = d0().getTotalPromotions();
        if ((r121 instanceof Collection) == true) goto L77;
    L79:
        Iterator<T> r122 = r121.iterator();
    L81:
        if (r122.hasNext() == false) goto L85;
        if (Intrinsics.areEqual(((ql.a) r122.next()).getProductId(), r25.d) == false) goto L81;
        boolean r123 = true;
    L86:
        if (r123 == true) goto L89;
        r120 = null;
    L89:
        if (r120 == null) goto L267;
        Iterator<ql.a> r124 = d0().getTotalPromotions().iterator();
    L92:
        if (r124.hasNext() == false) goto L97;
        if (Intrinsics.areEqual(r124.next().getProductId(), r25.d) == true) goto L95;
        r1 = r1 + 1;
        goto L92
    L95:
        r40 = r1;
    L97:
        LivePromotionListPageAdapter r46 = this.m;
        if (r46 != null) goto L100;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L100:
        int r47 = r40 + (r46.c ? 1 : 0);
        if (r43 > r47) goto L128;
        if (r45 <= r47) goto L128;
        PromotionRecyclerView r48 = this.k;
        if (r48 != null) goto L107;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L107:
        RecyclerView.ViewHolder r49 = r48.findViewHolderForAdapterPosition(r47);
        if ((r49 instanceof LivePromotionItemViewHolder) == true) goto L110;
        r49 = null;
    L110:
        LivePromotionItemViewHolder r50 = (LivePromotionItemViewHolder) r49;
        if (r50 == null) goto L267;
        com.bytedance.android.ec.common.api.jump.model.g r51 = r50.Y0();
        if (r51 == null) goto L123;
        ql.a r52 = r51.a;
        if (r52 == null) goto L123;
        if (r52.shouldShowStepper() != true) goto L123;
        Context r53 = Y().c();
        com.bytedance.android.ec.common.api.jump.model.g r54 = r50.Y0();
        if (r54 == null) goto L121;
        ql.a r55 = r54.a;
    L122:
        n0(r53, r55, o0(r50), true, null, LivePromotionListListingPresenter$onAddToShopCartSuccess$2$1$1.INSTANCE);
        goto L267
    L121:
        r55 = null;
    L123:
        Context r56 = Y().c();
        com.bytedance.android.ec.common.api.jump.model.g r57 = r50.Y0();
        if (r57 == null) goto L126;
        ql.a r58 = r57.a;
    L127:
        n0(r56, r58, r50.F0(PromotionCardModuleName.ImageAreaModule), false, r25.b, LivePromotionListListingPresenter$onAddToShopCartSuccess$2$1$2.INSTANCE);
        goto L267
    L126:
        r58 = null;
    L128:
        PromotionRecyclerView r59 = this.k;
        if (r59 != null) goto L132;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L132:
        if ((r59.findViewHolderForAdapterPosition(r43) instanceof LivePromotionItemViewHolder) == false) goto L141;
        PromotionRecyclerView r60 = this.k;
        if (r60 != null) goto L136;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L136:
        RecyclerView.ViewHolder r61 = r60.findViewHolderForAdapterPosition(r43);
        if (r61 == null) goto L140;
        LivePromotionItemViewHolder r62 = (LivePromotionItemViewHolder) r61;
    L155:
        if (r62 == null) goto L267;
        Context r63 = Y().c();
        com.bytedance.android.ec.common.api.jump.model.g r64 = r62.Y0();
        if (r64 == null) goto L159;
        ql.a r65 = r64.a;
    L160:
        n0(r63, r65, a0(), false, r25.b, LivePromotionListListingPresenter$onAddToShopCartSuccess$2$2$1.INSTANCE);
        goto L267
    L159:
        r65 = null;
        goto L160
    L140:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.livecommerce.promotionlist.viewholder.LivePromotionItemViewHolder");
    L141:
        PromotionRecyclerView r66 = this.k;
        if (r66 != null) goto L145;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L145:
        if ((r66.findViewHolderForAdapterPosition(r45) instanceof LivePromotionItemViewHolder) == false) goto L154;
        PromotionRecyclerView r67 = this.k;
        if (r67 != null) goto L149;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L149:
        RecyclerView.ViewHolder r68 = r67.findViewHolderForAdapterPosition(r45);
        if (r68 == null) goto L153;
        r62 = (LivePromotionItemViewHolder) r68;
        goto L155
    L153:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.livecommerce.promotionlist.viewholder.LivePromotionItemViewHolder");
    L154:
        r62 = null;
    L85:
        r123 = false;
        goto L86
    L77:
        if (r121.isEmpty() == false) goto L79;
    L161:
        Integer r69 = r25.c;
        if (r69 == null) goto L267;
        if (r69.intValue() != 201) goto L267;
        dm.a.a("LiveAddCart").i("onAddToShopCartSuccess live addCart not opt");
        Integer r70 = r25.l;
        if (r70 == null) goto L267;
        if (r70.intValue() != 0) goto L267;
        PromotionLinearLayoutManager r71 = this.l;
        if (r71 != null) goto L174;
        Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
    L174:
        int r72 = r71.findFirstVisibleItemPosition();
        PromotionLinearLayoutManager r73 = this.l;
        if (r73 != null) goto L177;
        Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
    L177:
        int r74 = r73.findLastVisibleItemPosition();
        String r125 = r25.d;
        if (r125 == null) goto L267;
        List<ql.a> r126 = d0().getTotalPromotions();
        if ((r126 instanceof Collection) == true) goto L182;
    L184:
        Iterator<T> r127 = r126.iterator();
    L186:
        if (r127.hasNext() == false) goto L190;
        if (Intrinsics.areEqual(((ql.a) r127.next()).getProductId(), r25.d) == false) goto L186;
        boolean r128 = true;
    L191:
        if (r128 == true) goto L194;
        r125 = null;
    L194:
        if (r125 == null) goto L267;
        Iterator<ql.a> r129 = d0().getTotalPromotions().iterator();
    L197:
        if (r129.hasNext() == false) goto L202;
        if (Intrinsics.areEqual(r129.next().getProductId(), r25.d) == true) goto L200;
        r1 = r1 + 1;
        goto L197
    L200:
        r40 = r1;
    L202:
        LivePromotionListPageAdapter r75 = this.m;
        if (r75 != null) goto L205;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L205:
        int r76 = r40 + (r75.c ? 1 : 0);
        if (r72 > r76) goto L233;
        if (r74 <= r76) goto L233;
        PromotionRecyclerView r77 = this.k;
        if (r77 != null) goto L212;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L212:
        RecyclerView.ViewHolder r78 = r77.findViewHolderForAdapterPosition(r76);
        if ((r78 instanceof LivePromotionItemViewHolder) == true) goto L215;
        r78 = null;
    L215:
        LivePromotionItemViewHolder r79 = (LivePromotionItemViewHolder) r78;
        if (r79 == null) goto L267;
        com.bytedance.android.ec.common.api.jump.model.g r80 = r79.Y0();
        if (r80 == null) goto L228;
        ql.a r81 = r80.a;
        if (r81 == null) goto L228;
        if (r81.shouldShowStepper() != true) goto L228;
        Context r82 = Y().c();
        com.bytedance.android.ec.common.api.jump.model.g r83 = r79.Y0();
        if (r83 == null) goto L226;
        ql.a r85 = r83.a;
    L227:
        n0(r82, r85, o0(r79), true, null, LivePromotionListListingPresenter$onAddToShopCartSuccess$4$1$1.INSTANCE);
        goto L267
    L226:
        r85 = null;
    L228:
        LivePromotionListViewModel r86 = d0();
        View r87 = r79.F0(PromotionCardModuleName.BuyModule);
        com.bytedance.android.ec.common.api.jump.model.g r88 = r79.Y0();
        if (r88 == null) goto L231;
        ql.a r89 = r88.a;
    L232:
        r86.addCartSuccessForAnim(r87, r89, null);
        goto L267
    L231:
        r89 = null;
    L233:
        PromotionRecyclerView r90 = this.k;
        if (r90 != null) goto L237;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L237:
        if ((r90.findViewHolderForAdapterPosition(r72) instanceof LivePromotionItemViewHolder) == false) goto L246;
        PromotionRecyclerView r91 = this.k;
        if (r91 != null) goto L241;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L241:
        RecyclerView.ViewHolder r92 = r91.findViewHolderForAdapterPosition(r72);
        if (r92 == null) goto L245;
        LivePromotionItemViewHolder r93 = (LivePromotionItemViewHolder) r92;
    L260:
        if (r93 == null) goto L267;
        Context r94 = Y().c();
        com.bytedance.android.ec.common.api.jump.model.g r95 = r93.Y0();
        if (r95 == null) goto L264;
        ql.a r96 = r95.a;
    L265:
        n0(r94, r96, a0(), true, null, LivePromotionListListingPresenter$onAddToShopCartSuccess$4$2$1.INSTANCE);
        goto L267
    L264:
        r96 = null;
        goto L265
    L245:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.livecommerce.promotionlist.viewholder.LivePromotionItemViewHolder");
    L246:
        PromotionRecyclerView r97 = this.k;
        if (r97 != null) goto L250;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L250:
        if ((r97.findViewHolderForAdapterPosition(r74) instanceof LivePromotionItemViewHolder) == false) goto L259;
        PromotionRecyclerView r98 = this.k;
        if (r98 != null) goto L254;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L254:
        RecyclerView.ViewHolder r99 = r98.findViewHolderForAdapterPosition(r74);
        if (r99 == null) goto L258;
        r93 = (LivePromotionItemViewHolder) r99;
        goto L260
    L258:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.livecommerce.promotionlist.viewholder.LivePromotionItemViewHolder");
    L259:
        r93 = null;
    L190:
        r128 = false;
        goto L191
    L182:
        if (r126.isEmpty() == false) goto L184;
    L47:
        r110 = false;
    L53:
        r10.B = null;
        r10.C = null;
    L36:
        r14 = false;
    L55:
        r10.B = null;
        r10.C = null;
        r20 = false;
        goto L57
    L28:
        if (r8.intValue() != 5) goto L30;
    L23:
        r7 = true;
        goto L24
    L18:
        if (r5.intValue() == 2) goto L23;
    L11:
        r4 = false;
    L7:
        r3 = 0;
        goto L9
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEditShopCartSuccess(hl.f r17) {
        Intrinsics.checkNotNullParameter(r17, "event");
        Function0<Integer> r1 = d0().getGetCurrentTab();
        boolean r2 = false;
        if (r1 == null) goto L7;
        Integer r3 = (Integer) r1.invoke();
        if (r3 == null) goto L7;
        int r4 = r3.intValue();
    L9:
        if (r4 != (!d0().isDefaultTab())) goto L11;
        r2 = true;
    L11:
        if (r2 == true) goto L13;
        return;
    L13:
        com.bytedance.android.shopping.ligo.context.b<?> r5 = d0().getLigoContext();
        if (r5 == null) goto L42;
        r17.getClass();
        boolean r6 = Intrinsics.areEqual("sub", "sub");
        String r7 = r17.a;
        String r8 = r17.c;
        String r9 = r17.d;
        if (r9 == null) goto L18;
        Integer r10 = StringsKt.toIntOrNull(r9);
    L19:
        com.bytedance.android.livesdk.livecommerce.promotionlist.utils.instant.b r11 = d0().getTimestampTracker();
        String r12 = r17.a;
        if (r12 != null) goto L22;
        r12 = "";
    L22:
        Long r13 = r11.a(r12);
        if (r13 == null) goto L25;
        long r14 = r13.longValue();
    L26:
        long r15 = System.currentTimeMillis();
        Iterator<T> r16 = d0().getTotalPromotions().iterator();
    L28:
        if (r16.hasNext() == false) goto L32;
        Object r18 = r16.next();
        if (Intrinsics.areEqual(((ql.a) r18).getProductId(), r17.a) == false) goto L28;
    L33:
        ql.a r19 = (ql.a) r18;
        if (r19 == null) goto L36;
        AddCartProductInfoData r0 = new AddCartProductInfoData(r19.getProductId(), r19.getTitle(), r19.getPrice());
    L37:
        r5.g(new we3.a.a(new LiveLigoCartStatusChangeEventData(r6 ? 1 : 0, r7, r8, r10, "edit_cart_from_stepper", new AddCartExtraData("live_product_list", r14, r15, r0))));
        return;
    L36:
        r0 = new AddCartProductInfoData(null, null, null);
        goto L37
    L32:
        r18 = null;
        goto L33
    L25:
        r14 = -1;
        goto L26
    L18:
        r10 = null;
        goto L19
    L42:
        return;
    L7:
        r4 = 0;
        goto L9
    }

    public LivePromotionListListingPresenter(Fragment r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "fragment");
        super(r3, r4);
        this.o = true;
        this.p = new wj2.i(new LivePromotionListListingPresenter$scrollHelper$1(this), new LivePromotionListListingPresenter$scrollHelper$2(this));
        this.q = LazyKt.lazy(LivePromotionListListingPresenter$itemDecoration$1.INSTANCE);
        this.r = new a(this);
        this.s = LazyKt.lazy(new LivePromotionListListingPresenter$instantAddOnFloorManager$2(this));
        this.u = true;
    }

    public static final void l0(LivePromotionListListingPresenter r3, List r4) {
        PromotionRecyclerView r0 = r3.k;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L6:
        if (r0.isComputingLayout() == false) goto L26;
        RecyclerView r1 = r3.k;
        if (r1 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L24:
        r1.post(new v(r3, r4));
        return;
    L26:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L16
        Iterator r5 = r4.iterator();     // Catch: Throwable -> L16
    L9:
        if (r5.hasNext() == false) goto L14;
        cf.x r6 = (cf.x) r5.next();     // Catch: Throwable -> L16
        LivePromotionListPageAdapter r7 = r3.m;     // Catch: Throwable -> L16
        if (r7 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");     // Catch: Throwable -> L16
    L13:
        r7.notifyItemChanged(r6.a, r6.getType());     // Catch: Throwable -> L16
        goto L9
    L14:
        Object r8 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L16
    L18:
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L31;
        ECExceptionMonitor.e(r9);
        return;
    L31:
        return;
    L16:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L18
    }

    public static final /* synthetic */ void m0(LivePromotionListListingPresenter r0, com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.h0 r1) {
        r0.showCardBottomAddOnFloor(r1);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.eventcenter.ability.a
    public final void X(String r13, final String r14) {
        Intrinsics.checkNotNullParameter(r13, "productId");
        dm.a.a("LiveAddCart").i("onAddCart");
        PromotionLinearLayoutManager r0 = this.l;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
    L5:
        final int r1 = r0.findFirstVisibleItemPosition();
        PromotionLinearLayoutManager r2 = this.l;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
    L8:
        final int r3 = r2.findLastVisibleItemPosition();
        Integer r4 = d0().getAddCartToastOrder();
        boolean r5 = true;
        ql.a r6 = null;
        if (r4 != null) goto L12;
    L14:
        final Function0<Unit> r7 = null;
    L15:
        List<ql.a> r15 = d0().getTotalPromotions();
        List<ql.a> r8 = r15;
        if ((r8 instanceof Collection) == true) goto L18;
    L20:
        Iterator<T> r9 = r8.iterator();
    L22:
        if (r9.hasNext() == false) goto L26;
        if (Intrinsics.areEqual(((ql.a) r9.next()).getProductId(), r13) == false) goto L22;
        boolean r10 = true;
    L27:
        if (r10 == true) goto L30;
        r15 = null;
    L30:
        if (r15 == null) goto L81;
        Iterator<ql.a> r16 = r15.iterator();
        int r11 = 0;
    L33:
        if (r16.hasNext() == false) goto L38;
        if (Intrinsics.areEqual(r16.next().getProductId(), r13) == true) goto L39;
        r11 = r11 + 1;
    L39:
        LivePromotionListPageAdapter r17 = this.m;
        if (r17 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L42:
        int r12 = r11 + (r17.c ? 1 : 0);
        if (r1 > r12) goto L78;
        if (r3 <= r12) goto L78;
        PromotionRecyclerView r18 = this.k;
        if (r18 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L49:
        RecyclerView.ViewHolder r19 = r18.findViewHolderForAdapterPosition(r12);
        if ((r19 instanceof LivePromotionItemViewHolder) == true) goto L52;
        r19 = null;
    L52:
        ql.a r110 = (LivePromotionItemViewHolder) r19;
        if (r110 == null) goto L75;
        Integer r111 = d0().getAddCartOpt();
        if (r111 != null) goto L58;
    L59:
        int r112 = wj2.f.a;
        if (wj2.f.a(d0().getParams().getRoomId(), d0().getRoomContextController().D()) == true) goto L63;
        r5 = false;
    L63:
        if (r5 == false) goto L71;
        Context r20 = Y().c();
        com.bytedance.android.ec.common.api.jump.model.g r113 = r110.Y0();
        if (r113 == null) goto L68;
        r6 = r113.a;
    L68:
        if (n0(r20, r6, r110.F0(PromotionCardModuleName.ImageAreaModule), false, null, r7) == true) goto L77;
        if (r7 == null) goto L77;
        Unit r114 = (Unit) r7.invoke();
    L77:
        r6 = r110;
    L80:
        if (r6 == null) goto L81;
        return;
    L71:
        View r115 = r110.F0(PromotionCardModuleName.AddCartModule);
        com.bytedance.android.ec.common.api.jump.model.g r21 = r110.Y0();
        if (r21 == null) goto L74;
        r6 = r21.a;
    L74:
        UtilityKotlinExtentionsKt.f(r115, r6, new LivePromotionListListingPresenter$onAddCart$$inlined$let$lambda$1(this, r1, r3, r7));
        goto L77
    L58:
        if (r111.intValue() == 2) goto L63;
    L75:
        if (r7 == null) goto L80;
        r110 = (Unit) r7.invoke();
    L78:
        if (r7 == null) goto L80;
        r6 = (Unit) r7.invoke();
        goto L80
    L38:
        r11 = -1;
    L81:
        if (r7 == null) goto L90;
        Unit r116 = (Unit) r7.invoke();
        return;
    L90:
        return;
    L26:
        r10 = false;
        goto L27
    L18:
        if (r8.isEmpty() == false) goto L20;
    L12:
        if (r4.intValue() != 1) goto L14;
        r7 = new LivePromotionListListingPresenter$onAddCart$showToast$1(this, r14);
        goto L15
    }

    public final void p0(int r4, int r5) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L14
        if (r4 < 0) goto L12;
        PromotionLinearLayoutManager r1 = this.l;     // Catch: Throwable -> L14
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("layoutManager");     // Catch: Throwable -> L14
    L8:
        r1.a = true;     // Catch: Throwable -> L14
        PromotionLinearLayoutManager r2 = this.l;     // Catch: Throwable -> L14
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("layoutManager");     // Catch: Throwable -> L14
    L11:
        r2.scrollToPositionWithOffset(r4, r5);     // Catch: Throwable -> L14
    L12:
        Object r6 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L14
    L16:
        Throwable r7 = Result.exceptionOrNull-impl(r6);
        if (r7 == null) goto L22;
        ECExceptionMonitor.e(r7);
        return;
    L22:
        return;
    L14:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    }

    public final boolean n0(Context r24, ql.a r25, final View r26, final boolean r27, final String r28, final Function0<Unit> r29) {
        final Ref.BooleanRef r14 = new Ref.BooleanRef();
        r14.element = true;
        if (r26 != null) goto L5;
        return true;
    L5:
        int r0 = ECSdk.a;
        final cf.l r6 = (cf.l) ECSdk.a(cf.l.class);
        IECCommonService r1 = (IECCommonService) ECSdk.a(IECCommonService.class);
        if (r25 == null) goto L8;
        String r3 = r25.getCover();
    L9:
        if (r24 == null) goto L60;
        if (r3 == null) goto L60;
        if (r1 == null) goto L60;
        if (r6 == null) goto L14;
        View r2 = r6.Ia();
    L16:
        if (r27 == false) goto L19;
        FrameLayout r5 = new ECAddCartMotionCommonLayout(r24, null, 6, 0);
    L18:
        FrameLayout r15 = r5;
        int r4 = View.MeasureSpec.makeMeasureSpec(0, 0);
        r15.measure(r4, r4);
        int r7 = r15.getMeasuredWidth();
        int r8 = r15.getMeasuredHeight();
        AnimatorSet r11 = new AnimatorSet();
        r11.playTogether(new Animator[]{ObjectAnimator.ofFloat(r15, "scaleX", new float[]{1.0f, 0.3f}), ObjectAnimator.ofFloat(r15, "scaleY", new float[]{1.0f, 0.3f})});
        if (r6 == null) goto L27;
        float[] r16 = r6.Pa();
    L28:
        if (r16 != null) goto L32;
        if (r2 == null) goto L31;
        float[] r9 = cf.m.a(r2);
    L33:
        int r10 = wj2.f.a;
        if (wj2.f.a(d0().getParams().getRoomId(), d0().getRoomContextController().D()) == false) goto L58;
        if (r9 == null) goto L58;
        int r12 = com.bytedance.android.livesdk.livecommerce.promotion.card.utils.b.a;
        float[] r13 = com.bytedance.android.livesdk.livecommerce.promotion.card.utils.b.d(r26);
        if (r28 != null) goto L39;
        String r17 = r3;
    L40:
        final float[] r18 = r16;
        float[] r19 = r9;
        Function0<Unit> r110 = new LivePromotionListListingPresenter$doAddCartMotionOpt$$inlined$lets3$lambda$1(r18, this, r6, r27, r28, r14, r26, r29);
        Intrinsics.checkNotNullParameter(r24, "context");
        Intrinsics.checkNotNullParameter(r13, "sourceLocation");
        Intrinsics.checkNotNullParameter(r19, "destinationLocation");
        if (r19.length == 2) goto L63;
        boolean r111 = false;
    L57:
        r14.element = r111;
        goto L60
    L63:
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L48
        JSONObject r21 = new JSONObject();     // Catch: Throwable -> L48
        r21.put("source_loc_x", ArraysKt.getOrNull(r13, 0));     // Catch: Throwable -> L48
        r21.put("source_loc_y", ArraysKt.getOrNull(r13, 1));     // Catch: Throwable -> L48
        r21.put("destination_loc_x", ArraysKt.getOrNull(r19, 0));     // Catch: Throwable -> L48
        r21.put("destination_loc_y", ArraysKt.getOrNull(r19, 1));     // Catch: Throwable -> L46
        r21.put("delay", 0);     // Catch: Throwable -> L46
        r21.put("animation_image_url", r17);     // Catch: Throwable -> L46
        Object r22 = Result.constructor-impl(r21);     // Catch: Throwable -> L46
    L52:
        if (Result.isFailure-impl(r22) == false) goto L54;
        Object r23 = null;
    L55:
        Lazy r30 = LiveDynamicContext.c;
        com.bytedance.android.livesdk.livecommerce.ability.b.a.a(LiveDynamicContext.a.a().a(), r24, new com.bytedance.android.livesdk.livecommerce.ability.f("LiveList", "live_list_show_add_cart_motion", (JSONObject) r23), null, null, new wj2.e(r110), 12);
        r111 = true;
        goto L57
    L54:
        r23 = r22;
    L46:
        th = th;
    L50:
        Result.Companion r31 = Result.Companion;
        r22 = Result.constructor-impl(ResultKt.createFailure(th));
    L48:
        th = th;
        goto L50
    L39:
        r17 = r28;
    L58:
        int r32 = wj2.c.a;
        int r33 = com.bytedance.android.livesdk.livecommerce.promotion.card.utils.b.a;
        final float[] r34 = r16;
        r14.element = wj2.c.a(r24, com.bytedance.android.livesdk.livecommerce.promotion.card.utils.b.d(r26), r16, r26, r2, 0, r15, Float.valueOf(r7), Float.valueOf(r8), true, r11, new LivePromotionListListingPresenter$doAddCartMotionOpt$$inlined$lets3$lambda$2(r34, this, r6, r27, r28, r14, r26, r29));
        goto L60
    L31:
        r9 = null;
        goto L33
    L32:
        r9 = r16;
        goto L33
    L27:
        r16 = null;
        goto L28
    L19:
        ECAddCartMotionLayout r35 = new ECAddCartMotionLayout(r24, null, 6, 0);
        if (r28 != null) goto L22;
        String r36 = r3;
    L23:
        Intrinsics.checkNotNullParameter(r36, "imgUrl");
        h0.e(r35.a, r36, new com.bytedance.android.ec.core.imagex.r("ec_live", "list_add_cart_view"), null, null, 120);
        r5 = r35;
        goto L18
    L22:
        r36 = r28;
        goto L23
    L14:
        r2 = null;
    L60:
        return r14.element;
    L8:
        r3 = null;
        goto L9
    }
}
