package com.bytedance.android.livesdk.livecommerce.promotionlist;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.BtmSDKWrapper;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.opt.ab.v;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.model.live.LiveClearScreenMode;
import com.bytedance.android.ec.model.live.LiveScreenMoveMode;
import com.bytedance.android.ec.opt.prerender.PrerenderDialog;
import com.bytedance.android.ec.opt.prerender.PrerenderDialogFragment;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.q;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.event.l0;
import com.bytedance.android.livesdk.livecommerce.model.ECV2RoomTagOfflineInfo;
import com.bytedance.android.livesdk.livecommerce.network.response.PromotionCategory;
import com.bytedance.android.livesdk.livecommerce.opt.ECLivePerformanceMonitor;
import com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.LivePromotionListViewModel;
import com.bytedance.android.livesdk.livecommerce.room.api.ControllerExtensionsKt;
import com.bytedance.android.livesdk.livecommerce.room.controller.RealRoomController;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.EntryController;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.PromotionListController;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.controller.z;
import com.bytedance.android.livesdk.livecommerce.room.hover.ECLiveDialogHoverManager;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import com.bytedance.android.livesdk.livecommerce.utils.ECDisplayUtils;
import com.bytedance.android.livesdk.livecommerce.utils.ECPreloadGeckoChannelUtil;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.livecommerce.view.ECLottieAnimationView;
import com.bytedance.android.shopping.ligo.container.event.LiveLigoListJumpToOtherPageEventData;
import com.bytedance.android.shopping.utils.e0;
import com.bytedance.apm.ApmAgent;
import com.bytedance.bdlocation.sensor.SensorBatchGpsCollector;
import com.bytedance.crash.Npth;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.gyf.barlibrary.OSUtils;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QViewModelOwner;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0001\bB\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotionlist/LivePromotionListFragment;", "Lcom/bytedance/android/ec/opt/prerender/PrerenderDialogFragment;", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QViewModelOwner;", "Lfh2/a;", "Lcom/bytedance/android/livesdk/livecommerce/room/controller/z;", "Lnl2/c;", "<init>", "()V", "a", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LivePromotionListFragment extends PrerenderDialogFragment implements QViewModelOwner, fh2.a, z, nl2.c {
    public static final /* synthetic */ int F = 0;
    public long A;
    public boolean B;
    public boolean C;
    public final com.bytedance.android.livesdk.livecommerce.promotionlist.b D;
    public final /* synthetic */ nl2.a E;
    public final com.bytedance.android.ec.core.arch.viewmodel.c i;
    public final QUIManager j;
    public ViewGroup k;
    public final String l;
    public final List<ECLottieAnimationView> m;
    public Function0<? extends View> n;
    public final Lazy o;
    public fi2.a p;
    public boolean q;
    public Map<String, String> r;
    public LiveRoomParams s;
    public ml.b t;
    public RoomContextController u;
    public final Lazy v;
    public wj2.g w;
    public long x;
    public boolean y;
    public boolean z;

    public static final class a {
    }

    public static final class b<V> implements Callable {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        @Override // java.util.concurrent.Callable
        public final Boolean call() {
            boolean r0 = ECPreloadGeckoChannelUtil.a;
            return Boolean.valueOf(ECPreloadGeckoChannelUtil.b(ECLiveABUtils.INSTANCE.getEC_LIVE_LIST_ACCESS_CHANNELS(), 2));
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ LivePromotionListFragment a;

        public c(LivePromotionListFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            LivePromotionListFragment r2 = this.a;
            r2.getClass();
            r2.dismissAllowingStateLoss();
        }
    }

    public static final class d implements com.bytedance.android.livesdk.livecommerce.promotionlist.a {
        public final /* synthetic */ LivePromotionListFragment a;

        @Override // com.bytedance.android.livesdk.livecommerce.promotionlist.a
        public final LivePromotionListViewModel f() {
            LivePromotionListFragment r0 = this.a;
            int r1 = LivePromotionListFragment.F;
            return r0.ha0();
        }

        @Override // com.bytedance.android.livesdk.livecommerce.promotionlist.a
        public Context getContext() {
            return this.a.getContext();
        }

        @Override // com.bytedance.android.livesdk.livecommerce.promotionlist.a
        public final ViewGroup getRootView() {
            ViewGroup r0 = this.a.k;
            if (r0 == null) goto L6;
            if (r0 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("rootView");
            return r0;
        L8:
            return r0;
        L6:
            return null;
        }

        public d(LivePromotionListFragment r1) {
            this.a = r1;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.promotionlist.LivePromotionListFragment$onCreate$2, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    final /* synthetic */ class AnonymousClass2 extends MutablePropertyReference0Impl {
        public AnonymousClass2(LivePromotionListFragment r7) {
            super(r7, LivePromotionListFragment.class, "listService", "getListService()Lcom/bytedance/android/livesdk/livecommerce/jump/IIronLiveRoomService;", 0);
        }

        public Object get() {
            fi2.a r0 = ((LivePromotionListFragment) ((CallableReference) this).receiver).p;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("listService");
        L5:
            return r0;
        }

        public void set(Object r2) {
            fi2.a r3 = (fi2.a) r2;
            ((LivePromotionListFragment) ((CallableReference) this).receiver).p = r3;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.promotionlist.LivePromotionListFragment$onDestroy$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    final /* synthetic */ class C02911 extends MutablePropertyReference0Impl {
        public C02911(LivePromotionListFragment r7) {
            super(r7, LivePromotionListFragment.class, "listService", "getListService()Lcom/bytedance/android/livesdk/livecommerce/jump/IIronLiveRoomService;", 0);
        }

        public Object get() {
            fi2.a r0 = ((LivePromotionListFragment) ((CallableReference) this).receiver).p;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("listService");
        L5:
            return r0;
        }

        public void set(Object r2) {
            fi2.a r3 = (fi2.a) r2;
            ((LivePromotionListFragment) ((CallableReference) this).receiver).p = r3;
        }
    }

    @Override // nl2.c
    public final Disposable add(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "disposable");
        this.E.add(r2);
        return r2;
    }

    public final LivePromotionListParams da0() {
        return (LivePromotionListParams) this.o.getValue();
    }

    public final LivePromotionListViewModel ha0() {
        return (LivePromotionListViewModel) this.i.getValue();
    }

    public final void onDestroyView() {
        dm.a.a("LivePromotionListFragment").i("fragment onDestroyView()");
        ControllerExtensionsKt.c(this.u, da0().getRoomId()).A().t.M().c(false);
        ECLiveABUtils r1 = ECLiveABUtils.INSTANCE;
        if (r1.getEC_LIVE_ENABLE_CARD_ADAPTATION() != 1) goto L23;
        RoomContextController r0 = this.u;
        if (r0 == null) goto L24;
        RealRoomController r2 = r0.A();
        if (r2 == null) goto L24;
        PromotionListController r3 = r2.r;
        if (r3 == null) goto L24;
        ECLiveDialogHoverManager r4 = r3.R;
        if (r4 == null) goto L24;
        if (r1.getLIST_FPS_OPT_CONFIG().getEnableClearFullScreen() == false) goto L15;
    L17:
        LiveClearScreenMode r5 = LiveClearScreenMode.CLEAR_SCREEN_MODE_FULL;
    L19:
        if (wj2.h.a() == false) goto L21;
        LiveScreenMoveMode r6 = LiveScreenMoveMode.LIVE_SCREEN_MOVE_UP;
    L22:
        r4.b(this, r5, r6);
        goto L24
    L21:
        r6 = LiveScreenMoveMode.LIVE_SCREEN_MOVE_NONE;
        goto L22
    L15:
        if (r1.getEC_LIVE_LIST_CLEAR_LIVE_PENDANT() != 0) goto L17;
        r5 = LiveClearScreenMode.CLEAR_SCREEN_MODE_HALF;
    L24:
        com.bytedance.android.shopping.ligo.context.b<?> r7 = ha0().getLigoContext();
        if (r7 == null) goto L27;
        r7.g(new we3.a.c(new LiveLigoListJumpToOtherPageEventData("close_list", null, 2, null)));
    L27:
        super.onDestroyView();
        return;
    L23:
        ia0(this, false);
        goto L24
    }

    static {
        Lazy r0 = BtmSDKWrapper.a;
        BtmSDKWrapper.c(LivePromotionListFragment.class, "a1.b0715");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [android.view.View] */
    @Override // fh2.a
    public final View En() {
        Function0<? extends View> r0 = this.n;
        ECLottieAnimationView r1 = null;
        if (r0 == null) goto L5;
        View r2 = (View) r0.invoke();
    L6:
        if (r2 != null) goto L18;
        ArrayList r3 = (ArrayList) this.m;
        if (r3.size() <= ha0().getCurrentSelectedTabPosition()) goto L10;
        boolean r4 = true;
    L11:
        if (r4 == true) goto L14;
        r3 = null;
    L14:
        if (r3 == null) goto L17;
        r1 = (ECLottieAnimationView) ListProtector.get(r3, ha0().getCurrentSelectedTabPosition());
    L17:
        return r1;
    L10:
        r4 = false;
        goto L11
    L18:
        return r2;
    L5:
        r2 = null;
        goto L6
    }

    public final boolean W90() {
        ECLiveABUtils.INSTANCE.getEC_LIVE_PROMOTION_LIST_SPLIT_FPS_OPT();
        return true;
    }

    public final int ba0() {
        String r1 = da0().getCouponId();
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L18;
        boolean r3 = EntryController.M1;
        String r4 = da0().getRoomId();
        LiveRoomParams r5 = this.s;
        if (r5 == null) goto L13;
        String r6 = r5.getRoomUniqueKey();
    L15:
        if (EntryController.a.b(r4, r6).U != 1) goto L17;
        int r7 = EComABUtils.liveListPanelHeightInstant();
    L20:
        return RangesKt.coerceIn(r7, 0, 100);
    L17:
        r7 = EComABUtils.liveListPanelHeight();
        goto L20
    L13:
        r6 = null;
        goto L15
    L18:
        r7 = 73;
        goto L20
    L5:
        if (r1.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    public final void dismissAllowingStateLoss() {
        dm.a.a("LivePromotionListFragment").i("fragment dismissAllowingStateLoss");
        S90();
    }

    public final void eN() {
        ECLiveABUtils r0 = ECLiveABUtils.INSTANCE;
        if (r0.getEC_LIVE_ENABLE_CARD_ADAPTATION() != 1) goto L23;
        RoomContextController r1 = this.u;
        if (r1 == null) goto L25;
        RealRoomController r2 = r1.A();
        if (r2 == null) goto L26;
        PromotionListController r3 = r2.r;
        if (r3 == null) goto L27;
        ECLiveDialogHoverManager r4 = r3.R;
        if (r4 != null) goto L13;
        return;
    L13:
        if (r0.getLIST_FPS_OPT_CONFIG().getEnableClearFullScreen() == false) goto L15;
    L17:
        LiveClearScreenMode r5 = LiveClearScreenMode.CLEAR_SCREEN_MODE_FULL;
    L19:
        if (wj2.h.a() == false) goto L21;
        LiveScreenMoveMode r6 = LiveScreenMoveMode.LIVE_SCREEN_MOVE_UP;
    L22:
        r4.c(this, r5, r6);
        return;
    L21:
        r6 = LiveScreenMoveMode.LIVE_SCREEN_MOVE_NONE;
        goto L22
    L15:
        if (r0.getEC_LIVE_LIST_CLEAR_LIVE_PENDANT() != 0) goto L17;
        r5 = LiveClearScreenMode.CLEAR_SCREEN_MODE_HALF;
        goto L19
    L27:
        return;
    L26:
        return;
    L25:
        return;
    L23:
        ia0(this, true);
    }

    public final Map<String, String> ga0() {
        Map<String, String> r0 = this.r;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return new HashMap();
    }

    public final ViewModelProvider.Factory o6() {
        return new ViewModelProvider.NewInstanceFactory();
    }

    public final void onDestroy() {
        dm.a.a("LivePromotionListFragment").i("fragment onDestroy()");
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        CompositeDisposable r0 = this.E.a;
        if (r0 == null) goto L5;
        r0.clear();
    L5:
        ha0().onDestroy();
        com.bytedance.android.livesdk.livecommerce.promotionlist.b r1 = this.D;
        r1.getClass();
        dm.a.a("LivePromotionListSubscriberDelegate").a("unregisterJsEventSubscriber");
        ECLiveHybridUtil.p("ecom.auction.panel_state", r1.c);
        ECLiveHybridUtil.p("ecom.promotion_list.state", r1.d);
        ECLiveHybridUtil.p("ecom.promotion_list.close", r1.e);
        ECLiveHybridUtil.p("freshPromotionList", (LivePromotionListSubscriberDelegate$freshPromotionListJsEventSubscriber$2.a) r1.a.getValue());
        ECLiveHybridUtil.p("updateAddress", (LivePromotionListSubscriberDelegate$addressUpdateBackJsEventSubscriber$2.a) r1.b.getValue());
        ECLiveHybridUtil.p("ecom_add_on_cart_product_update", r1.f);
        ECLiveHybridUtil.p("PromotionListClickBuyOrItem", r1.g);
        ECLiveHybridUtil.p("ecom.fans_club.join_result", r1.h);
        ECLiveHybridUtil.p("ecom.fans_club.exit_result", r1.i);
        ECLiveHybridUtil.p("instant_list_store_switch", r1.j);
        ECLiveHybridUtil.p("update_shop_cart_list", r1.k);
        ECLiveHybridUtil.p("ecom.promotion_list.addon_floor_change", r1.l);
        com.bytedance.android.ec.core.opt.ab.d.a();
        if (da0().isFromLiveRoom() == true) goto L11;
        com.bytedance.android.livesdk.livecommerce.view.countdown.d r2 = com.bytedance.android.livesdk.livecommerce.view.countdown.d.a.a;
        if (r2.c.booleanValue() == true) goto L11;
        r2.a();
    L11:
        Window r3 = null;
        l0.a = null;
        this.j.r(nj2.d.class);
        if (this.p == null) goto L52;
        ECLiveABUtils r4 = ECLiveABUtils.INSTANCE;
        if (r4.getEC_LIVE_ENABLE_CARD_ADAPTATION() != 1) goto L34;
        RoomContextController r5 = this.u;
        if (r5 == null) goto L38;
        RealRoomController r6 = r5.A();
        if (r6 == null) goto L38;
        PromotionListController r7 = r6.r;
        if (r7 == null) goto L38;
        ECLiveDialogHoverManager r8 = r7.R;
        if (r8 == null) goto L38;
        if (r4.getLIST_FPS_OPT_CONFIG().getEnableClearFullScreen() == false) goto L26;
    L28:
        LiveClearScreenMode r9 = LiveClearScreenMode.CLEAR_SCREEN_MODE_FULL;
    L30:
        if (wj2.h.a() == false) goto L32;
        LiveScreenMoveMode r10 = LiveScreenMoveMode.LIVE_SCREEN_MOVE_UP;
    L33:
        r8.b(this, r9, r10);
        goto L38
    L32:
        r10 = LiveScreenMoveMode.LIVE_SCREEN_MOVE_NONE;
        goto L33
    L26:
        if (r4.getEC_LIVE_LIST_CLEAR_LIVE_PENDANT() != 0) goto L28;
        r9 = LiveClearScreenMode.CLEAR_SCREEN_MODE_HALF;
    L38:
        wj2.g r11 = this.w;
        if ((r11 instanceof wj2.g.c) == true) goto L41;
        r11 = null;
    L41:
        wj2.g.c r12 = (wj2.g.c) r11;
        if (r12 != null) goto L44;
    L45:
        fi2.a r13 = this.p;
        if (r13 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("listService");
    L48:
        FragmentActivity r14 = getActivity();
        String r15 = this.l;
        PrerenderDialog r16 = ((PrerenderDialogFragment) this).g;
        if (r16 == null) goto L51;
        r3 = r16.getWindow();
    L51:
        r13.a(r14, r15, r3);
        goto L52
    L44:
        if (r12.b == true) goto L52;
    L34:
        fi2.a r17 = this.p;
        if (r17 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("listService");
    L37:
        r17.b(Z90(0));
    L52:
        RealRoomController r18 = ControllerExtensionsKt.c(this.u, da0().getRoomId()).A();
        r18.getClass();
        Intrinsics.checkNotNullParameter(this, "listener");
        if (EComABUtils.isLiveListMemoryLeakSwitch() == false) goto L56;
        ((ArrayList) r18.F).remove(this);
        return;
    }

    public final void onPause() {
        dm.a.a("LivePromotionListFragment").i("fragment onPause()");
        super/*androidx.fragment.app.Fragment*/.onPause();
        Handler r0 = com.bytedance.android.livesdk.livecommerce.utils.k.a;
        this.A = SystemClock.elapsedRealtime();
        Map<String, com.bytedance.android.livesdk.livecommerce.opt.f> r1 = com.bytedance.android.livesdk.livecommerce.opt.f.b;
        ApmAgent.removePerfTag("e_commerce", "ec_live_promotion_list");
        HashMap r2 = new HashMap();
        r2.put("e_commerce", "e_commerce_exit");
        Npth.addTags(r2);
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_ENABLE_CARD_ADAPTATION() == 1) goto L9;
        fi2.a r3 = this.p;
        if (r3 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("listService");
    L7:
        r3.b(Z90(0));
        return;
    }

    public final void onResume() {
        dm.a.a("LivePromotionListFragment").i("fragment onResume()");
        super/*androidx.fragment.app.Fragment*/.onResume();
        com.bytedance.android.livesdk.livecommerce.utils.k.h(4);
        Map<String, com.bytedance.android.livesdk.livecommerce.opt.f> r0 = com.bytedance.android.livesdk.livecommerce.opt.f.b;
        ApmAgent.addPerfTag("e_commerce", "ec_live_promotion_list");
        HashMap r2 = new HashMap();
        r2.put("e_commerce", "ec_live_promotion_list");
        Npth.addTags(r2);
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_ENABLE_CARD_ADAPTATION() == 1) goto L8;
        fi2.a r1 = this.p;
        if (r1 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("listService");
    L7:
        r1.b(Z90(1));
    L8:
        ha0().updateDialogShowing(true);
        if (this.z == false) goto L12;
        this.z = false;
        return;
    L12:
        if ((SystemClock.elapsedRealtime() - this.A) <= 1000) goto L18;
        LivePromotionListViewModel.updateWhenBackFromOtherPage$default(ha0(), null, false, 3, null);
        LivePromotionListViewModel r3 = ha0().getSecondViewModel();
        if (r3 == null) goto L19;
        LivePromotionListViewModel.updateWhenBackFromOtherPage$default(r3, null, false, 3, null);
        return;
    L19:
        return;
    }

    public final void onStart() {
        dm.a.a("LivePromotionListFragment").i("fragment onStart()");
        Dialog r0 = ((PrerenderDialogFragment) this).g;
        Window r1 = null;
        if (r0 != null) goto L5;
    L12:
        super/*androidx.fragment.app.Fragment*/.onStart();
        wj2.g r2 = this.w;
        if ((r2 instanceof wj2.g.c) == true) goto L15;
        r2 = null;
    L15:
        wj2.g.c r3 = (wj2.g.c) r2;
        if (r3 != null) goto L18;
    L19:
        fi2.a r4 = this.p;
        if (r4 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("listService");
    L22:
        FragmentActivity r5 = getActivity();
        String r6 = this.l;
        PrerenderDialog r7 = ((PrerenderDialogFragment) this).g;
        if (r7 == null) goto L25;
        r1 = r7.getWindow();
    L25:
        r4.d(r5, r6, r1, new C02922(this));
    L27:
        if (EComABUtils.enableLiveListNewWindowStyle() == false) goto L34;
        PrerenderDialog r8 = ((PrerenderDialogFragment) this).g;
        if (r8 == null) goto L35;
        Window r9 = r8.getWindow();
        if (r9 == null) goto L36;
        r9.setDimAmount(0.0f);
        return;
    L36:
        return;
    L35:
        return;
    L34:
        return;
    L18:
        if (r3.b == true) goto L27;
    L5:
        if (this.q == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L12;
        Window r10 = r0.getWindow();
        if (r10 == null) goto L12;
        r10.setWindowAnimations(2131952327);
        goto L12
    }

    public final void onStop() {
        dm.a.a("LivePromotionListFragment").i("fragment onStop()");
        super/*androidx.fragment.app.Fragment*/.onStop();
        this.q = true;
        wj2.g r1 = this.w;
        Window r3 = null;
        if ((r1 instanceof wj2.g.c) == true) goto L5;
        r1 = null;
    L5:
        wj2.g.c r2 = (wj2.g.c) r1;
        if (r2 != null) goto L8;
    L9:
        fi2.a r0 = this.p;
        if (r0 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("listService");
    L12:
        FragmentActivity r4 = getActivity();
        String r5 = this.l;
        PrerenderDialog r6 = ((PrerenderDialogFragment) this).g;
        if (r6 == null) goto L15;
        r3 = r6.getWindow();
    L15:
        r0.a(r4, r5, r3);
        return;
    L8:
        if (r2.b != true) goto L9;
    }

    @Override // fh2.a
    public final boolean p() {
        PrerenderDialog r0 = ((PrerenderDialogFragment) this).g;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isShowing() != true) goto L7;
        return true;
    }

    public final void show() {
        dm.a.a("LivePromotionListFragment").i("fragment show");
        super.show();
    }

    @Override // fh2.a
    public final void ya() {
        Iterator<T> r0 = this.m.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        LottieAnimationView r1 = (ECLottieAnimationView) r0.next();
        r1.clearAnimation();
        r1.playAnimation();
        goto L4
    }

    public LivePromotionListFragment() {
        this.E = new nl2.a();
        Function0<ViewModelProvider.Factory> r0 = new LivePromotionListFragment$viewModel$2(this);
        final Function0<Fragment> r1 = new LivePromotionListFragment$$special$$inlined$viewModels$1(this);
        this.i = com.bytedance.android.ec.core.arch.viewmodel.b.a(this, Reflection.getOrCreateKotlinClass(LivePromotionListViewModel.class), new LivePromotionListFragment$$special$$inlined$viewModels$2(r1), r0);
        this.j = new QUIManager();
        this.l = "com.bytedance.android.livesdk.livecommerce.promotionlist.LivePromotionListFragment";
        this.m = new ArrayList();
        this.o = LazyKt.lazy(new LivePromotionListFragment$params$2(this));
        this.v = LazyKt.lazy(LivePromotionListFragment$enableSwitchResolution$2.INSTANCE);
        this.z = true;
        this.D = new com.bytedance.android.livesdk.livecommerce.promotionlist.b(new d(this));
    }

    public final Integer U90() {
        if (EComABUtils.enableLiveListNewWindowStyle() == false) goto L5;
        int r0 = 2131952352;
    L7:
        return Integer.valueOf(r0);
    L5:
        r0 = 2131952353;
        goto L7
    }

    public final boolean V90() {
        if (EComABUtils.liveListPageAdaptTranslucent() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final int aa0() {
        Context r0 = getContext();
        String r1 = da0().getRoomId();
        LiveRoomParams r2 = this.s;
        if (r2 == null) goto L5;
        String r3 = r2.getRoomUniqueKey();
    L6:
        int r4 = com.bytedance.android.livesdk.livecommerce.promotionlist.base.c.a;
        return (int) (ECDisplayUtils.a(r0) * (com.bytedance.android.livesdk.livecommerce.promotionlist.base.c.a(r1, r3) / 100.0f));
    L5:
        r3 = null;
        goto L6
    }

    public final String ca0() {
        return da0().getLiveListChannel();
    }

    @Override // fh2.a
    public final float[] dt() {
        com.bytedance.android.shopping.ligo.context.b<?> r0 = ha0().getLigoContext();
        if (r0 == null) goto L32;
        String r1 = (String) r0.d("cart_icon_loc");
        if (r1 == null) goto L32;
        List r2 = StringsKt.split$default(r1, new String[]{","}, false, 0, 6, null);
        if (r2.size() != 2) goto L32;
        int r3 = 0;
        String r4 = (String) ListProtector.get(r2, 0);
        if (r4 == null) goto L31;
        Integer r5 = StringsKt.toIntOrNull(StringsKt.trim(r4).toString());
        String r6 = (String) ListProtector.get(r2, 1);
        if (r6 == null) goto L29;
        Integer r7 = StringsKt.toIntOrNull(StringsKt.trim(r6).toString());
        if (r5 == null) goto L32;
        if (r5.intValue() < 0) goto L32;
        if (r7 == null) goto L32;
        if (r7.intValue() < 0) goto L32;
        Resources r8 = Resources.getSystem();
        float r9 = WindowDisplayMetricsOverride.apply(r8, r8.getDisplayMetrics()).scaledDensity;
        int[] r10 = new int[2];
        View r11 = getView();
        if (r11 == null) goto L24;
        r11.getLocationOnScreen(r10);
    L24:
        float[] r12 = new float[2];
        r12[0] = (r5.intValue() * r9) + 0;
        int r13 = r10[1];
        View r14 = getView();
        if (r14 == null) goto L27;
        r3 = r14.getHeight();
    L27:
        r12[1] = (r13 + r3) - (r7.intValue() * r9);
        return r12;
    L29:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    L31:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    L32:
        return null;
    }

    public final String ea0() {
        return da0().getExtraEntranceInfo();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.z
    public final void onLiveEnd() {
        dismissAllowingStateLoss();
    }

    public static int Z90(int r1) {
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L7;
    L12:
        return 4;
    L7:
        if (ECLiveABUtils.INSTANCE.getLIST_FPS_OPT_CONFIG().getEnableClearFullScreen() == false) goto L14;
        return 6;
    L14:
        return 1;
    L10:
        if (ECLiveABUtils.INSTANCE.getLIST_FPS_OPT_CONFIG().getEnableClearFullScreen() == false) goto L12;
        return 5;
    }

    public final void T90(Exception r2) {
        Intrinsics.checkNotNullParameter(r2, "e");
        ECExceptionMonitor.e(r2);
    }

    @Override // fh2.a
    public final void X80(ECV2RoomTagOfflineInfo r14) {
        Intrinsics.checkNotNullParameter(r14, "roomTagOfflineInfo");
        if (p() == false) goto L6;
        LivePromotionListViewModel.refreshProductList$default(ha0(), 1, null, null, null, true, true, false, r14.userToast, true, 78, null);
        return;
    }

    public final Pair fa0(String r9) {
        Intrinsics.checkNotNullParameter(r9, "productId");
        Function1<String, Pair<float[], float[]>> r0 = ha0().getGetCardLoc();
        if (r0 == null) goto L26;
        Pair r10 = (Pair) r0.invoke(r9);
        if (r10 == null) goto L26;
        float[] r1 = (float[]) r10.component1();
        float[] r11 = (float[]) r10.component2();
        Resources r2 = Resources.getSystem();
        Float r3 = Float.valueOf(WindowDisplayMetricsOverride.apply(r2, r2.getDisplayMetrics()).scaledDensity);
        int r4 = 0;
        if (r3.floatValue() <= 0) goto L9;
        boolean r5 = true;
    L10:
        if (r5 == true) goto L13;
        r3 = null;
    L13:
        if (r3 == null) goto L15;
        float r6 = r3.floatValue();
    L27:
        ArrayList r7 = new ArrayList(r1.length);     // Catch: Exception -> L24
        int r8 = r1.length;     // Catch: Exception -> L24
        int r12 = 0;
    L17:
        if (r12 >= r8) goto L19;
        r7.add(Float.valueOf(r1[r12] / r6));     // Catch: Exception -> L24
        r12 = r12 + 1;     // Catch: Exception -> L24
        goto L17
    L19:
        float[] r13 = CollectionsKt.toFloatArray(r7);     // Catch: Exception -> L24
        ArrayList r14 = new ArrayList(r11.length);     // Catch: Exception -> L24
        int r15 = r11.length;     // Catch: Exception -> L24
    L20:
        if (r4 >= r15) goto L22;
        r14.add(Float.valueOf(r11[r4] / r6));     // Catch: Exception -> L24
        r4 = r4 + 1;     // Catch: Exception -> L24
        goto L20
    L22:
        return new Pair(r13, CollectionsKt.toFloatArray(r14));
    L24:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L26
    L15:
        r6 = 1.0f;
        goto L27
    L9:
        r5 = false;
    L26:
        return null;
    }

    public final void ja0(boolean r2) {
        if (r2 == true) goto L4;
        View r3 = getView();
        if (r3 == null) goto L15;
        r3.setVisibility(0);
        return;
    L15:
        return;
    L4:
        if (EComABUtils.useLiveListHoverMode() == false) goto L12;
        View r4 = getView();
        if (r4 == null) goto L13;
        r4.setVisibility(8);
        return;
    L13:
        return;
    }

    public final void ka0(PromotionCategory r2) {
        ha0().scrollToTop(r2);
    }

    public final void onActivityCreated(Bundle r4) {
        dm.a.a("LivePromotionListFragment").i("fragment onActivityCreated()");
        super/*androidx.fragment.app.Fragment*/.onActivityCreated(r4);
        com.bytedance.android.ec.core.arch.event.c.c(ha0(), this, Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.g.class), new LivePromotionListFragment$observeData$1(this));
        com.bytedance.android.ec.core.arch.event.c.c(ha0(), this, Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.b0.class), new LivePromotionListFragment$observeData$2(this));
        com.bytedance.android.ec.core.arch.event.c.c(ha0(), this, Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.z.class), new LivePromotionListFragment$observeData$3(this));
        com.bytedance.android.ec.core.arch.event.c.c(ha0(), this, Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.p.class), new LivePromotionListFragment$observeData$4(this));
        com.bytedance.android.ec.core.arch.event.c.c(ha0(), this, Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.b.class), new LivePromotionListFragment$observeData$5(this));
        RealRoomController r5 = ControllerExtensionsKt.c(this.u, da0().getRoomId()).A();
        r5.getClass();
        Intrinsics.checkNotNullParameter(this, "listener");
        ((ArrayList) r5.F).add(this);
        AppCompatDialog r6 = ((PrerenderDialogFragment) this).g;
        if ((r6 instanceof AppCompatDialog) == true) goto L6;
        r6 = null;
    L6:
        if (r6 == null) goto L8;
        r6.supportRequestWindowFeature(1);
    L8:
        com.bytedance.android.livesdk.livecommerce.promotionlist.b r7 = this.D;
        r7.getClass();
        dm.a.a("LivePromotionListSubscriberDelegate").a("registerJsEventSubscriber");
        ECLiveHybridUtil.m("freshPromotionList", (LivePromotionListSubscriberDelegate$freshPromotionListJsEventSubscriber$2.a) r7.a.getValue());
        ECLiveHybridUtil.m("updateAddress", (LivePromotionListSubscriberDelegate$addressUpdateBackJsEventSubscriber$2.a) r7.b.getValue());
        ECLiveHybridUtil.m("ecom.auction.panel_state", r7.c);
        ECLiveHybridUtil.m("ecom.promotion_list.state", r7.d);
        ECLiveHybridUtil.m("ecom.promotion_list.close", r7.e);
        ECLiveHybridUtil.m("ecom_add_on_cart_product_update", r7.f);
        ECLiveHybridUtil.m("PromotionListClickBuyOrItem", r7.g);
        ECLiveHybridUtil.m("ecom.fans_club.join_result", r7.h);
        ECLiveHybridUtil.m("ecom.fans_club.exit_result", r7.i);
        ECLiveHybridUtil.m("instant_list_store_switch", r7.j);
        ECLiveHybridUtil.m("update_shop_cart_list", r7.k);
        ECLiveHybridUtil.m("ecom.promotion_list.addon_floor_change", r7.l);
        com.bytedance.android.ec.core.opt.ab.d.a();
        this.x = System.currentTimeMillis();
        ECLiveHybridUtil.f("ecom.goodsList.state", new JSONObject().put("is_show", true).put("room_id", da0().getRoomId()));
        if (da0().isFromLiveRoom() == true) goto L24;
        com.bytedance.android.livesdk.livecommerce.view.countdown.d r8 = com.bytedance.android.livesdk.livecommerce.view.countdown.d.a.a;
        com.bytedance.android.livesdk.livecommerce.view.countdown.c r1 = r8.b;
        if (r1 != null) goto L13;
    L15:
        r8.c = Boolean.FALSE;
        ((CopyOnWriteArrayList) r8.a).clear();
        com.bytedance.android.livesdk.livecommerce.view.countdown.c r2 = new com.bytedance.android.livesdk.livecommerce.view.countdown.c(r8);
        r8.b = r2;
        monitor-enter(r2);
        r2.a = false;     // Catch: Throwable -> L21
        r2.b = true;     // Catch: Throwable -> L21
        com.bytedance.android.livesdk.livecommerce.view.countdown.e r9 = r2.c;     // Catch: Throwable -> L21
        r9.sendMessage(r9.obtainMessage(1));     // Catch: Throwable -> L21
        monitor-exit(r2);
    L21:
        th = move-exception;
        throw th;
    L13:
        if (r1.b() == false) goto L15;
    L24:
        l0.a = da0().getExtraEntranceInfo();
        if (((Boolean) this.v.getValue()).booleanValue() == false) goto L30;
        UtilityKotlinExtentionsKt.j(SensorBatchGpsCollector.DEFAULT_NETWORK_FALLBACK_TIMEOUT_MS, new AnonymousClass1(this), 2);
        return;
    }

    public final void onAttach(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        dm.a.a("LivePromotionListFragment").i("fragment onAttach()");
        com.bytedance.android.ec.core.opt.ab.d.a();
        super.onAttach(r4);
        if (V90() == false) goto L12;
        PrerenderDialog r5 = ((PrerenderDialogFragment) this).g;
        if (r5 == null) goto L12;
        r5.supportRequestWindowFeature(1);
        Window r6 = r5.getWindow();
        if (r6 == null) goto L12;
        if (OSUtils.isEMUI3_x() == true) goto L11;
        r6.clearFlags(67108864);
        r6.addFlags(Integer.MIN_VALUE);
        r6.setStatusBarColor(0);
        goto L12
    L11:
        r6.addFlags(67108864);
    L12:
        wj2.g r7 = this.w;
        if ((r7 instanceof wj2.g.c) == true) goto L15;
        r7 = null;
    L15:
        wj2.g.c r8 = (wj2.g.c) r7;
        if (r8 != null) goto L18;
        return;
    L18:
        if (r8.b != true) goto L28;
        PrerenderDialog r9 = ((PrerenderDialogFragment) this).g;
        if (r9 == null) goto L29;
        Window r10 = r9.getWindow();
        if (r10 == null) goto L30;
        WindowManager.LayoutParams r11 = r10.getAttributes();
        if (r11 == null) goto L31;
        r11.type = 1;
        return;
    L31:
        return;
    L30:
        return;
    L29:
        return;
    }

    public final void onCreate(Bundle r8) {
        dm.a.a("LivePromotionListFragment").i("fragment onCreate()");
        int r1 = ph.a.a;
        Context r2 = requireContext();
        Intrinsics.checkNotNullParameter(r2, "context");
        if (com.bytedance.android.ec.core.opt.ab.j.a().e() == false) goto L7;
        int r3 = ph.a.a;
        int r4 = ECSdk.a;
        cj.b r5 = (cj.b) ECSdk.a(cj.b.class);
        if (r5 == null) goto L7;
        r5.e(r2);
    L7:
        Handler r6 = ph.d.a;
        if (v.a().c() == false) goto L12;
        long r7 = v.a().a();
        if (r7 <= 0) goto L12;
        ph.d.a(true);
        ph.d.a.postDelayed(ph.c.a, r7);
    L12:
        super/*androidx.fragment.app.Fragment*/.onCreate(r8);
        Lazy r9 = BtmSDKWrapper.a;
        Bundle r10 = getArguments();
        if (r10 == null) goto L15;
        String r11 = r10.getString("source_btm_token");
    L16:
        BtmSDKWrapper.b(this, "a1.b0715", r11);
        int r12 = 0;
        if (da0().getRoomId().length() != 0) goto L19;
        boolean r13 = true;
    L20:
        if (r13 == false) goto L22;
    L26:
        String r14 = "分佣参数 room_id: " + da0().getRoomId() + "，author_id: " + da0().getAnchorId() + " 不能为空";
        com.bytedance.android.ec.sdk.helper.j.b("LivePromotionListFragment", r14);
        ECExceptionMonitor.e(new RuntimeException(r14));
    L27:
        jc.b r15 = com.bytedance.android.bcm.api.b.a;
        PageFinder r16 = PageFinder.via(this);
        BcmParams r0 = new BcmParams();
        r0.put("room_id", da0().getRoomId());
        r0.put("author_id", da0().getAnchorId());
        Unit r17 = Unit.INSTANCE;
        com.bytedance.android.bcm.api.b.d(r16, r0, true);
        if (this.p != null) goto L31;
        this.p = new xh2.b(da0().getRoomId(), this.u);
    L31:
        if (V90() == false) goto L33;
        ((PrerenderDialogFragment) this).e = -1;
    L37:
        PrerenderDialog r18 = ((PrerenderDialogFragment) this).g;
        if (r18 == null) goto L40;
        r18.k = 2131952326;
    L40:
        if (r18 == null) goto L42;
        r18.l = 300;
    L42:
        e0.a();
        ECLiveABUtils r19 = ECLiveABUtils.INSTANCE;
        if (r19.getEC_LIVE_LIST_ACCESS_ENABLE() == true) goto L45;
    L48:
        com.bytedance.android.ec.core.opt.ab.d.a();
        return;
    L45:
        if (r19.getLIST_FPS_OPT_CONFIG().getEnableOpt() == false) goto L47;
        Single.fromCallable(b.a).subscribeOn(Schedulers.io()).subscribe();
        goto L48
    L47:
        boolean r20 = ECPreloadGeckoChannelUtil.a;
        ECPreloadGeckoChannelUtil.b(r19.getEC_LIVE_LIST_ACCESS_CHANNELS(), 2);
        goto L48
    L33:
        int r21 = ECDisplayUtils.a(getContext());
        Context r22 = requireContext();
        int r23 = r22.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (r23 <= 0) goto L36;
        r12 = r22.getResources().getDimensionPixelSize(r23);
    L36:
        ((PrerenderDialogFragment) this).e = r21 - r12;
        goto L37
    L22:
        if (da0().getAnchorId().length() != 0) goto L24;
        boolean r24 = true;
    L25:
        if (r24 == false) goto L27;
    L24:
        r24 = false;
        goto L25
    L19:
        r13 = false;
        goto L20
    L15:
        r11 = null;
        goto L16
    }

    public final void onDismiss(DialogInterface r7) {
        super.onDismiss(r7);
        ControllerExtensionsKt.c(this.u, da0().getRoomId()).A().r.getClass();
        String r1 = null;
        if (ha0().isPromotionListParamsInitialized() == false) goto L11;
        sg2.v r8 = new sg2.v("livesdk_live_list_show_duration", ha0().getPromotionListParams());
        r8.c("duration", String.valueOf(System.currentTimeMillis() - this.x));
        String r2 = da0().getLiveListChannel();
        if (r2 != null) goto L7;
        r2 = "";
    L7:
        r8.c("live_list_channel", r2);
        String r3 = da0().getOpenMethod();
        if (r3 != null) goto L10;
        r3 = "";
    L10:
        r8.c("open_method", r3);
        r8.i(null);
    L11:
        ECLiveHybridUtil.f("ecom.goodsList.state", new JSONObject().put("is_show", false).put("room_id", da0().getRoomId()));
        ECContext r9 = ControllerExtensionsKt.c(this.u, da0().getRoomId()).r();
        if (r9 != null) goto L14;
    L22:
        ECLivePerformanceMonitor.b r10 = ECLivePerformanceMonitor.x;
        LiveRoomParams r11 = this.s;
        if (r11 == null) goto L25;
        String r12 = r11.getRoomId();
    L26:
        LiveRoomParams r0 = this.s;
        if (r0 == null) goto L29;
        r1 = r0.getRoomUniqueKey();
    L29:
        ECLivePerformanceMonitor r13 = ECLivePerformanceMonitor.c.a(r12, r1);
        if (r13 == null) goto L32;
        r13.p(1, false);
    L32:
        this.y = false;
        xh.c.a("Live").i("good_list", "good_list");
        ((Boolean) this.v.getValue()).booleanValue();
        return;
    L25:
        r12 = null;
        goto L26
    L14:
        if ((!r9.isCleared()) == true) goto L17;
        r9 = null;
    L17:
        if (r9 == null) goto L22;
        r9.isPromotionListShow().setValue(Boolean.FALSE);
        ECLivePerformanceMonitor r14 = (ECLivePerformanceMonitor) r9.getEcLivePerformanceMonitor().getValue();
        if (cg4.a.a(r14.r) == false) goto L21;
        r14.r = null;
    L21:
        r14.e = "";
        r14.d = false;
        goto L22
    }

    @Override // fh2.a
    public final void vm(boolean r4) {
        if (r4 == false) goto L5;
        ha0().refreshPromotionListForStoreChange(false);
        return;
    L5:
        LivePromotionListViewModel.updateWhenBackFromOtherPage$default(ha0(), null, false, 3, null);
        LivePromotionListViewModel r5 = ha0().getSecondViewModel();
        if (r5 == null) goto L10;
        LivePromotionListViewModel.updateWhenBackFromOtherPage$default(r5, null, false, 3, null);
        return;
    }

    public static void ia0(LivePromotionListFragment r9, boolean r10) {
        int r0 = wj2.h.a;
        boolean r8 = ((Boolean) EComABUtils.getLiveSettingValue("ec_live_list_panel_event_sync_notify", Boolean.TRUE)).booleanValue();
        r9.getClass();
        if (wj2.h.a() == false) goto L16;
        wj2.g r1 = r9.w;
        if ((r1 instanceof wj2.g.c) == true) goto L7;
        r1 = null;
    L7:
        wj2.g.c r2 = (wj2.g.c) r1;
        if (r2 != null) goto L10;
    L11:
        fi2.a r3 = r9.p;
        if (r3 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("listService");
    L14:
        r3.notifyPanelEventByLiveList(r10, r9.aa0(), ((Number) EComABUtils.getLiveSettingValue("ec_live_list_panel_event_open_animator_duration", 300L)).longValue(), ((Number) EComABUtils.getLiveSettingValue("ec_live_list_panel_event_close_animator_duration", 200L)).longValue(), r8);
        return;
    L10:
        if (r2.a != true) goto L11;
        return;
    }

    public final float[] Y90(float[] r7, int r8) {
        Intrinsics.checkNotNullParameter(r7, "srcLoc");
        if (r7.length == 2) goto L5;
        return null;
    L5:
        Resources r0 = Resources.getSystem();
        float r1 = WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).scaledDensity;
        int r3 = 0;
        if (r8 == 0) goto L17;
        if (r8 != 1) goto L19;
        int[] r9 = new int[2];
        View r2 = getView();
        if (r2 == null) goto L12;
        r2.getLocationOnScreen(r9);
    L12:
        float[] r4 = new float[2];
        r4[0] = (r7[0] * r1) + 0;
        int r10 = r9[1];
        View r5 = getView();
        if (r5 == null) goto L15;
        r3 = r5.getHeight();
    L15:
        r4[1] = (r10 + r3) - (r7[1] * r1);
        return r4;
    L19:
        return null;
    L17:
        return new float[]{r7[0] * r1, r7[1] * r1};
    }

    public final void onViewCreated(View r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r11, "view");
        dm.a.a("LivePromotionListFragment").i("fragment onViewCreated()");
        if (this.B == true) goto L5;
        this.B = true;
        super.onViewCreated(r11, r12);
    L5:
        LivePromotionListViewModel r1 = ha0();
        Context r2 = requireContext();
        LivePromotionListParams r3 = da0();
        fi2.a r4 = this.p;
        if (r4 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("listService");
    L8:
        LiveRoomParams r5 = this.s;
        String r6 = BtmSDK.INSTANCE.getPageId(PageFinder.via(this));
        boolean r7 = this.y;
        wj2.g r8 = this.w;
        RoomContextController r13 = this.u;
        if (r13 != null) goto L11;
        int r14 = RoomContextController.h;
        r13 = RoomContextController.a.a();
    L11:
        r1.init(r2, r3, r4, r5, r6, r7, r8, r13);
        ml.b r15 = this.t;
        if (r15 == null) goto L14;
        com.bytedance.android.ec.core.arch.event.c.e(ha0(), new com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.y(r15));
    L14:
        this.j.c(nj2.d.class, null);
        ViewGroup r16 = this.k;
        if (r16 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L17:
        r16.setOnClickListener(new c(this));
        ECLiveABUtils r17 = ECLiveABUtils.INSTANCE;
        if (r17.getEC_LIVE_SPLIT_TIPS() <= 0) goto L24;
        int r18 = q.a.getInt("ec_live_split_tips_" + r17.getEC_LIVE_SPLIT_TIPS(), 0);
        nj.d r19 = com.bytedance.android.ec.sdk.helper.d.b.getPadSplitService();
        if (r18 > 0) goto L25;
        if (r19 == null) goto L26;
        r19.isFold();
        return;
    L26:
        return;
    L25:
        return;
    }

    public final void X90(String r4, boolean r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r4, "component");
        dm.a.a("LivePromotionListFragment").i("change " + r4 + " visibility to " + r5 + ", needResetState=" + r6);
        com.bytedance.android.ec.core.arch.event.c.d(ha0(), new com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.a.d(r4, r5, r6));
    }

    public final View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        dm.a.a("LivePromotionListFragment").i("fragment onCreateView()");
        Map<String, com.bytedance.android.livesdk.livecommerce.opt.f> r6 = com.bytedance.android.livesdk.livecommerce.opt.f.b;
        ApmAgent.addPerfTag("e_commerce", "ec_live_promotion_list");
        HashMap r0 = new HashMap();
        r0.put("e_commerce", "ec_live_promotion_list");
        Npth.addTags(r0);
        ShoppingAsyncInflater.a r7 = ShoppingAsyncInflater.e;
        FragmentActivity r8 = requireActivity();
        r7.getClass();
        ShoppingAsyncInflater r9 = ShoppingAsyncInflater.a.a(r8);
        this.y = r9.b(2131564662);
        View r10 = r9.aU(2131564662, r4, false);
        if (r10 == null) goto L17;
        ViewGroup r11 = (ViewGroup) r10;
        this.k = r11;
        View r12 = r11.findViewById(2131383372);
        View r13 = r11.findViewById(2131392857);
        ViewGroup.LayoutParams r14 = r12.getLayoutParams();
        if (r14 == null) goto L7;
        r14.height = aa0();
    L7:
        if (r13 == null) goto L11;
        ViewGroup.LayoutParams r15 = r13.getLayoutParams();
        if (r15 == null) goto L11;
        r15.height = aa0();
    L11:
        r12.setClickable(true);
        com.bytedance.android.ec.core.opt.ab.d.a();
        QUIManager r16 = this.j;
        ViewGroup r1 = this.k;
        if (r1 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L14:
        r16.l(new nj2.d(r1, this), requireContext(), true);
        QUIManager r17 = this.j;
        r17.a = this;
        return r17.p();
    L17:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }
}
