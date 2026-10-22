package com.bytedance.android.shopping.buynow.container;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cf.t;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.base.api.ai.IECAIHostService;
import com.bytedance.android.ec.base.api.ai.framework.component.BackComponent;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.common.api.IECCommonService;
import com.bytedance.android.ec.common.api.feedback.IECFeedbackService;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.async.DisposableScope;
import com.bytedance.android.ec.core.buynow.BuyNowBizCode;
import com.bytedance.android.ec.core.buynow.BuyNowPerformanceOpt;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.jedi.ReflectViewModelFactory;
import com.bytedance.android.ec.core.monitor.MonitorScenes;
import com.bytedance.android.ec.core.monitor.param.ECParamTrackerCenter;
import com.bytedance.android.ec.core.utils.UIUtils;
import com.bytedance.android.ec.core.utils.k1;
import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.ec.core.widget.DoubleColorBallAnimationView;
import com.bytedance.android.ec.host.api.service.IECHostService;
import com.bytedance.android.ec.hybrid.ECHybridExtensionsKt;
import com.bytedance.android.ec.model.live.LiveClearScreenMode;
import com.bytedance.android.ec.model.live.LiveScreenMoveMode;
import com.bytedance.android.ec.model.order.IOrderSchema;
import com.bytedance.android.ec.model.sku.SkuParams;
import com.bytedance.android.ec.model.sku.SkuProductDetailInfo;
import com.bytedance.android.ec.model.sku.SkuShowAndDismissState;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.ecom.arch.slice.render.util.SlcDimensExtensionsKt;
import com.bytedance.android.ecom.arch.slice.render.util.keyboard.SlcKeyboardMonitor;
import com.bytedance.android.shopping.abscontainer.arch.core.starter.QueryMethod;
import com.bytedance.android.shopping.abscontainer.arch.platform.net.PlatformHttpRequestAPI;
import com.bytedance.android.shopping.abscontainer.common_biz.platform.SliceTemplateManager;
import com.bytedance.android.shopping.anchorv4.helper.a0;
import com.bytedance.android.shopping.api.ultimate.UltimateBuyParams;
import com.bytedance.android.shopping.base.event.EventActionImpl;
import com.bytedance.android.shopping.buynow.components.SkeletonMode;
import com.bytedance.android.shopping.buynow.controller.BuyNowCeilingController$onBodyContainerInit$1;
import com.bytedance.android.shopping.buynow.controller.BuyNowElevatorGuideController;
import com.bytedance.android.shopping.buynow.controller.BuyNowElevatorGuideController$onBodyContainerInit$1;
import com.bytedance.android.shopping.buynow.controller.CheckPayStatusController;
import com.bytedance.android.shopping.buynow.controller.ScrollNotifyController$onBodyContainerInit$1;
import com.bytedance.android.shopping.buynow.controller.UltimateBuyNowHeaderCeilingController$onBodyContainerInit$1;
import com.bytedance.android.shopping.buynow.controller.p;
import com.bytedance.android.shopping.buynow.controller.q;
import com.bytedance.android.shopping.buynow.controller.s;
import com.bytedance.android.shopping.buynow.controller.w;
import com.bytedance.android.shopping.buynow.data.model.BuyNowCloseMethod;
import com.bytedance.android.shopping.buynow.data.model.BuyNowOrderSchema;
import com.bytedance.android.shopping.buynow.data.model.BuyNowPayType;
import com.bytedance.android.shopping.buynow.data.model.CheckOrderTriggerOrigin;
import com.bytedance.android.shopping.buynow.data.model.CheckPointType;
import com.bytedance.android.shopping.buynow.data.model.CheckStatus;
import com.bytedance.android.shopping.buynow.data.model.PageStartupStatus;
import com.bytedance.android.shopping.buynow.data.model.PageType;
import com.bytedance.android.shopping.buynow.data.model.RequestErrorType;
import com.bytedance.android.shopping.buynow.data.remote.BuyNowApi;
import com.bytedance.android.shopping.buynow.data.remote.ContinuePayApi;
import com.bytedance.android.shopping.buynow.monitor.firstscreen.BuyNowFirstScreenMonitor;
import com.bytedance.android.shopping.buynow.monitor.param.BuyNowFirstScreenNode;
import com.bytedance.android.shopping.buynow.slice.BuyNowTemplateMgr;
import com.bytedance.android.shopping.buynow.starter.BuyNowStarter;
import com.bytedance.android.shopping.buynow.starter.BuyNowStarterOpt;
import com.bytedance.android.shopping.buynow.tracker.BuyNowLog;
import com.bytedance.android.shopping.buynow.ultimate.data.remote.UltimateBuyNowApi;
import com.bytedance.android.shopping.buynow.utils.r;
import com.bytedance.android.shopping.buynow.viewmodel.BuyNowViewModel;
import com.bytedance.android.shopping.buynow.widgets.BuyNowErrorView;
import com.bytedance.android.shopping.buynow.widgets.BuyNowLoadingView;
import com.bytedance.android.shopping.buynow.widgets.BuyNowTouchMaskView;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.android.shopping.sku.outer.action.SkuOuterPanelAction;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.android.shopping.track.TrackCatcher;
import com.bytedance.android.shopping.yata.init.AndroidYataBuilderManager;
import com.bytedance.android.ui.base.widget.round.BackgroundDrawable;
import com.bytedance.android.ui.base.widget.round.RoundConstraintLayout;
import com.bytedance.android.ui.base.widget.round.RoundLinearLayout;
import com.bytedance.android.ui.base.widget.round.RoundView;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import com.bytedance.jedi.arch.Async;
import com.bytedance.jedi.arch.IReceiver;
import com.bytedance.jedi.arch.IdentitySubscriber;
import com.bytedance.jedi.arch.JediView;
import com.bytedance.jedi.arch.JediViewModel;
import com.bytedance.jedi.arch.LifecycleOwnerHolder;
import com.bytedance.jedi.arch.Middleware;
import com.bytedance.jedi.arch.ReceiverHolder;
import com.bytedance.jedi.arch.State;
import com.bytedance.jedi.arch.SubscriptionConfig;
import com.bytedance.jedi.arch.Tuple1;
import com.bytedance.jedi.arch.Tuple2;
import com.bytedance.jedi.arch.Tuple3;
import com.bytedance.jedi.arch.Tuple4;
import com.bytedance.jedi.arch.Tuple5;
import com.bytedance.jedi.arch.ViewModelFactoryOwner;
import com.bytedance.jedi.arch.lifecycleAwareLazy;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import com.bytedance.kmp.ec.yata.common.biz.YataPageInfo;
import com.bytedance.kmp.ec.yata.view.render.controller.common.YataPerfLinearLayout;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty1;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u00032\u00020\u00052\u00020\u00052\u00020\u00062\u00020\u0007:\u0001\nB\u0007¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/buynow/container/BuyNowFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/bytedance/jedi/arch/JediView;", "Lcom/bytedance/jedi/arch/ViewModelFactoryOwner;", "Lcom/bytedance/android/ec/core/jedi/ReflectViewModelFactory;", "", "Lcom/bytedance/android/ec/core/async/b;", "Lcom/bytedance/android/ec/core/gallery2/opt/b;", "<init>", "()V", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BuyNowFragment extends Fragment implements JediView, ViewModelFactoryOwner<ReflectViewModelFactory>, com.bytedance.android.ec.core.async.b, com.bytedance.android.ec.core.gallery2.opt.b {
    public static int J;
    public Disposable A;
    public SkeletonMode B;
    public com.bytedance.kmp.ec.yata.view.render.delegate.v2.a C;
    public IOrderSchema D;
    public boolean E;
    public View F;
    public int G;
    public int H;
    public final /* synthetic */ DisposableScope I;
    public Map<Integer, View> d;
    public final ReflectViewModelFactory e;
    public final lifecycleAwareLazy f;
    public com.bytedance.android.shopping.buynow.starter.n g;
    public com.bytedance.android.shopping.buynow.eventcenter.a h;
    public com.bytedance.android.shopping.sku.common.ability.c i;
    public ia3.b j;
    public final Lazy k;
    public BuyNowElevatorGuideController l;
    public w m;
    public final Lazy n;
    public q o;
    public final Lazy p;
    public AndroidYaTaInstance q;
    public SlcRenderContext r;
    public ia3.a s;
    public final Map<String, RecyclerView> t;
    public boolean u;
    public ia3.d v;
    public pa3.a w;
    public qa3.a x;
    public b y;
    public Disposable z;

    public static final class a {
        public a() {
        }

        public static BuyNowFragment a(String r2, Uri r3, BuyNowOrderSchema r4, String r5, float r6, boolean r7, int r8) {
            int r0 = BuyNowFragment.J;
            if ((r8 & 16) == 0) goto L6;
            r6 = 1.0f;
        L6:
            if ((r8 & 32) == 0) goto L8;
            r7 = false;
        L8:
            BuyNowLog.d("BuyNowFragment", "create BuyNowFragment");
            BuyNowFragment r9 = new BuyNowFragment();
            Bundle r1 = new Bundle();
            r1.putString("PrefetchSessionId", r2);
            r1.putParcelable("Schema", r3);
            r1.putParcelable("OrderSchema", r4);
            r1.putString("source_btm_token", r5);
            r1.putFloat("height_percent", r6);
            r1.putBoolean("IsSplitScreen", r7);
            Unit r10 = Unit.INSTANCE;
            r9.setArguments(r1);
            return r9;
        }

        public static BuyNowFragment b(String r112, la3.e r113, UltimateBuyParams r114, String r115, float r116, Uri r117, BuyNowOrderSchema r118, boolean r119) {
            BuyNowLog.d("BuyNowFragment", "create BuyNowFragment as sku_buynow");
            BuyNowFragment r1 = new BuyNowFragment();
            Bundle r2 = new Bundle();
            r2.putString("PrefetchSessionId", r112);
            r2.putSerializable("ultimate_buy_params", r114);
            r2.putBoolean("IsSplitScreen", r119);
            r2.putParcelable("OrderSchema", r118);
            r2.putString("source_btm_token", r115);
            r2.putFloat("height_percent", r116);
            r2.putParcelable("Schema", r117);
            Unit r3 = Unit.INSTANCE;
            r1.setArguments(r2);
            SkuParams r111 = new SkuParams(null, null, null, null, null, 0, null, null, null, false, false, null, null, false, null, "", null, false, null, null, null, null, null, null, null, false, 0, 0, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, false, false, false, null, null, null, null, 0.0f, null, null, null, null, null, null, null, null, null, null, null, null, 0, "BuyNowFragment", null, null, null, null, null, false, null, null, null, null, null, null, null, 0, 0, false, null, null, null, false, null, null, null, null, null, null, null, null, -32769, -1, -257, 31, null);
            if (r113 == null) goto L5;
            t r6 = r113.a;
        L7:
            if (r113 == null) goto L9;
            Function1<String, Unit> r8 = r113.b;
        L10:
            if (r113 == null) goto L12;
            Function1<SkuShowAndDismissState, Unit> r9 = r113.c;
        L13:
            if (r113 == null) goto L15;
            Function1<SkuProductDetailInfo, Unit> r10 = r113.d;
        L16:
            r1.i = new SkuOuterPanelAction(r111, r6, null, r8, r9, r10, null, null, null);
            return r1;
        L15:
            r10 = null;
            goto L16
        L12:
            r9 = null;
            goto L13
        L9:
            r8 = null;
            goto L10
        L5:
            r6 = null;
            goto L7
        }
    }

    public static final class b implements ul.c {
        public final /* synthetic */ BuyNowFragment a;

        public b(BuyNowFragment r1) {
            this.a = r1;
        }

        public final void a(boolean r3) {
            YataPerfLinearLayout r0 = this.a.S90(2131386837);
            if (r0 == null) goto L6;
            wg.a.h(r0, r3);
            return;
        }
    }

    public static final class c implements SlcKeyboardMonitor.b {
        public final /* synthetic */ View a;

        public c(View r1) {
            this.a = r1;
        }

        public final void a(SlcKeyboardMonitor.SlcApplyWindowInsetsListener r3) {
            Intrinsics.checkNotNullParameter(r3, "listener");
            ViewCompat.setOnApplyWindowInsetsListener(this.a, new f(r3));
        }

        public final void b(SlcKeyboardMonitor.SlcApplyWindowInsetsListener r2) {
            Intrinsics.checkNotNullParameter(r2, "listener");
            ViewCompat.setOnApplyWindowInsetsListener(this.a, null);
        }
    }

    public static final class d implements BuyNowErrorView.a {
        public final /* synthetic */ BuyNowFragment a;
        public final /* synthetic */ la3.d b;
        public final /* synthetic */ ma3.b c;

        public static final class a implements Action {
            public final /* synthetic */ d a;

            public a(d r1) {
                this.a = r1;
            }

            public final void run() {
                d r0 = this.a;
                ia3.b r1 = r0.a.j;
                if (r1 == null) goto L15;
                ma3.b r2 = r0.c;
                if (r2 == null) goto L8;
                la3.d r3 = r2.g();
                if (r3 == null) goto L8;
            L10:
                if (this.a.a.B != SkeletonMode.NORMAL) goto L12;
                boolean r4 = true;
            L13:
                r1.a(r3, new ia3.c(true, r4));
                return;
            L12:
                r4 = false;
            L8:
                r3 = new la3.c();
                goto L10
            }
        }

        @Override // com.bytedance.android.shopping.buynow.widgets.BuyNowErrorView.a
        public final void a() {
            Context r0 = this.a.getContext();
            BuyNowFragment r1 = this.a;
            com.bytedance.android.shopping.buynow.starter.n r2 = r1.g;
            boolean r3 = true;
            if (r0 == null) goto L8;
            if (r2 == null) goto L8;
            r1.ca0(false, true, null);
            r2.i(r0, false);
            if (this.a.W90().getStaticState().c() == false) goto L17;
            this.a.W90().setAutoRetry(false);
            BuyNowViewModel r4 = this.a.W90();
            r4.setRetryCount(r4.getRetryCount() + 1);
        L17:
            this.a.W90().getTracker().g(this.b.b(), this.b.a());
            return;
        L8:
            com.bytedance.android.shopping.buynow.tracker.a r5 = r1.W90().getTracker();
            StringBuilder r6 = new StringBuilder("localContext == null is ");
            if (r0 != null) goto L11;
            boolean r7 = true;
        L12:
            r6.append(r7);
            r6.append(", starter == null is ");
            if (r2 == null) goto L16;
            r3 = false;
        L16:
            r6.append(r3);
            com.bytedance.android.shopping.buynow.monitor.error.a.b(r5, "runtime_error", r6.toString());
            goto L17
        L11:
            r7 = false;
            goto L12
        }

        @Override // com.bytedance.android.shopping.buynow.widgets.BuyNowErrorView.a
        public final void b() {
            BuyNowFragment r0 = this.a;
            ia3.b r1 = r0.j;
            if (r1 == null) goto L5;
            r1.b(new ia3.c(false, r0.B, false, true, true, null));
        L5:
            Disposable r2 = this.a.A;
            if (r2 == null) goto L8;
            r2.dispose();
        L8:
            BuyNowFragment r3 = this.a;
            r3.A = Completable.timer(100, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread()).subscribe(new a(this));
            BuyNowFragment r4 = this.a;
            Disposable r5 = r4.A;
            if (r5 == null) goto L11;
            com.bytedance.android.ec.core.async.a.a(r5, r4);
        L11:
            this.a.W90().getTracker().g(this.b.b(), this.b.a());
        }

        @Override // com.bytedance.android.shopping.buynow.widgets.BuyNowErrorView.a
        public final void onQuit() {
            com.bytedance.android.shopping.buynow.controller.f.b(this.a.getContext(), BuyNowCloseMethod.NETWORK_ERROR, this.a);
        }

        public d(BuyNowFragment r1, la3.d r2, ma3.b r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class e implements Action {
        public final /* synthetic */ BuyNowFragment a;
        public final /* synthetic */ com.bytedance.kmp.ec.yata.common.biz.callback.a b;

        public e(BuyNowFragment r1, com.bytedance.kmp.ec.yata.common.biz.callback.a r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void run() {
            BuyNowFragment r0 = this.a;
            ia3.b r1 = r0.j;
            if (r1 == null) goto L6;
            r1.b(new ia3.c(false, r0.B, false, true, true, this.b));
            return;
        }
    }

    static {
        new a();
    }

    public final BuyNowViewModel W90() {
        return (BuyNowViewModel) this.f.getValue();
    }

    public final Disposable add(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "disposable");
        this.I.add(r2);
        return r2;
    }

    public final void clearDisposable() {
        this.I.clearDisposable();
    }

    public final void remove(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "disposable");
        this.I.remove(r2);
    }

    public final void X90() {
        int r0 = com.bytedance.android.shopping.buynow.utils.b.a;
        if (com.bytedance.android.shopping.buynow.utils.b.a(W90()) == false) goto L5;
    L6:
        b r1 = new b(this);
        this.y = r1;
        ul.b.b(r1);
        return;
    L5:
        if (W90().getStaticState().c() == true) goto L6;
    }

    public final boolean Z90() {
        int r0 = com.bytedance.android.shopping.buynow.controller.f.a;
        AndroidYaTaInstance r1 = this.q;
        if (r1 == null) goto L5;
        Boolean r2 = Boolean.valueOf(r1.J());
    L7:
        if (com.bytedance.android.shopping.extensions.k.i(r2) == false) goto L10;
        return true;
    L10:
        return com.bytedance.android.shopping.buynow.controller.f.d(r1);
    L5:
        r2 = null;
        goto L7
    }

    public final CompositeDisposable compositeDisposable() {
        return this.I.a();
    }

    public BuyNowFragment() {
        this.I = new DisposableScope();
        this.d = new LinkedHashMap();
        this.e = new ReflectViewModelFactory();
        final KClass r0 = Reflection.getOrCreateKotlinClass(BuyNowViewModel.class);
        final Function0<String> r1 = new BuyNowFragment$$special$$inlined$viewModel$1(r0);
        final BuyNowFragment$$special$$inlined$viewModel$2 r2 = BuyNowFragment$$special$$inlined$viewModel$2.INSTANCE;
        this.f = new lifecycleAwareLazy(this, r1, new BuyNowFragment$$special$$inlined$viewModel$3(this, r1, r0, r2));
        LazyThreadSafetyMode r3 = LazyThreadSafetyMode.NONE;
        this.k = LazyKt.lazy(r3, new BuyNowFragment$addressStickyController$2(this));
        this.n = LazyKt.lazy(r3, new BuyNowFragment$checkPayStatusController$2(this));
        this.p = LazyKt.lazy(new BuyNowFragment$orientationListener$2(this));
        this.t = new LinkedHashMap();
    }

    public final BuyNowBizCode V90() {
        if (W90().getStaticState().c() == false) goto L6;
        return BuyNowBizCode.YATA_SKUBUY;
    L6:
        if (W90().getStaticState().b() == false) goto L9;
        return BuyNowBizCode.CONTINUE_PAY;
    L9:
        return BuyNowBizCode.BUY;
    }

    public final boolean fa0() {
        if (W90().getStaticState().m == false) goto L11;
        IOrderSchema r0 = this.D;
        if (r0 == null) goto L7;
        String r1 = r0.getQueryParam("split_screen_half_mode");
    L9:
        if (Boolean.parseBoolean(r1) == true) goto L11;
        return true;
    L7:
        r1 = null;
    L11:
        return false;
    }

    public final LifecycleOwner getLifecycleOwner() {
        return JediView.DefaultImpls.getLifecycleOwner(this);
    }

    public final LifecycleOwnerHolder getLifecycleOwnerHolder() {
        return JediView.DefaultImpls.getLifecycleOwnerHolder(this);
    }

    public final IReceiver getReceiver() {
        return JediView.DefaultImpls.getReceiver(this);
    }

    public final ReceiverHolder<IdentitySubscriber> getReceiverHolder() {
        return JediView.DefaultImpls.getReceiverHolder(this);
    }

    public final boolean getUniqueOnlyGlobal() {
        return JediView.DefaultImpls.getUniqueOnlyGlobal(this);
    }

    public final void onDestroyView() {
        super.onDestroyView();
        if (W90().getStaticState().c() == false) goto L8;
        Lazy r0 = TrackCatcher.a;
        if (TrackCatcher.a.a() == null) goto L12;
        TrackCatcher.b("step_order");
    L12:
        Context r1 = getContext();
        if (r1 == null) goto L15;
        W90().getSkuService().u(r1, W90().getSkuPageState());
    L15:
        q r2 = this.o;
        boolean r3 = true;
        if (r2 != null) goto L18;
    L24:
        AndroidYaTaInstance r4 = this.q;
        if (r4 == null) goto L27;
        Object r5 = r4.i("close_page_request_params");
    L29:
        if ((r5 instanceof Map) == true) goto L31;
        r5 = null;
    L31:
        Map r6 = (Map) r5;
        if (r6 == null) goto L46;
        Object r7 = r6.get("api_path");
        if ((r7 instanceof String) == true) goto L36;
        r7 = null;
    L36:
        String r8 = (String) r7;
        if (r8 == null) goto L46;
        Object r9 = r6.get("request_params");
        if ((r9 instanceof Map) == true) goto L42;
        r9 = null;
    L42:
        Map r10 = (Map) r9;
        if (r10 != null) goto L45;
        r10 = MapsKt.emptyMap();
    L45:
        PlatformHttpRequestAPI r11 = g43.i.a;
        g43.i.a(QueryMethod.POST, r8, r10, r43.a.class, BuyNowFragment$reportQuitPage$1$1.INSTANCE);
    L46:
        q r12 = this.o;
        if (r12 == null) goto L51;
        Handler r13 = r12.c;
        if (r13 == null) goto L51;
        r13.removeCallbacksAndMessages(null);
    L51:
        int r14 = com.bytedance.android.shopping.buynow.controller.f.a;
        com.bytedance.android.shopping.buynow.controller.f.c(W90(), BuyNowCloseMethod.OTHERS);
        Map r15 = ECParamTrackerCenter.a;
        ECParamTrackerCenter.a(W90().getStaticState().b);
        clearDisposable();
        nj.d r16 = com.bytedance.android.ec.sdk.helper.d.b.getPadSplitService();
        if (r16 == null) goto L54;
        BuyNowFragment$orientationListener$2.a r17 = (BuyNowFragment$orientationListener$2.a) this.p.getValue();
        r16.e();
    L54:
        com.bytedance.kmp.ec.yata.view.render.delegate.v2.a r18 = this.C;
        if (r18 == null) goto L57;
        r18.a.release();
        r18.b.d();
    L57:
        s0.e(this);
        com.bytedance.android.shopping.buynow.eventcenter.a r19 = this.h;
        if (r19 == null) goto L64;
        s0.e(r19);
        Iterator r20 = ((HashMap) r19.a).entrySet().iterator();
    L61:
        if (r20.hasNext() == false) goto L63;
        Map.Entry r21 = (Map.Entry) r20.next();
        ECLiveHybridUtil.p((String) r21.getKey(), (ti.j) r21.getValue());
        goto L61
    L63:
        r19.f.getSkuService().a();
    L64:
        W90().getAsyncTwoStageController().b(W90());
        AndroidYaTaInstance r22 = this.q;
        if (r22 == null) goto L67;
        r22.d();
    L67:
        com.bytedance.android.shopping.buynow.slice.counter.d.c = null;
        int r23 = com.bytedance.android.shopping.buynow.starter.k.a;
        com.bytedance.android.shopping.buynow.starter.n r24 = com.bytedance.android.shopping.buynow.starter.k.c(W90().getStaticState().b);
        if (r24 == null) goto L70;
        r24.release();
    L70:
        Map<String, pa3.a> r25 = pa3.a.c;
        String r26 = W90().getStaticState().b;
        if (r26 != null) goto L73;
    L76:
        if (r3 == true) goto L79;
        pa3.a.c.remove(r26);
    L79:
        ((LinkedHashMap) this.d).clear();
        return;
    L73:
        if (r26.length() == 0) goto L76;
        r3 = false;
        goto L76
    L27:
        r5 = null;
        goto L29
    L18:
        if (r2.h != true) goto L24;
        Fragment r27 = getParentFragment();
        if (r27 == null) goto L24;
        boolean r28 = ECServiceManager.a;
        cf.l r29 = (cf.l) ECServiceManager.c(cf.l.class);
        if (r29 == null) goto L24;
        r29.Fa(false, r27, LiveClearScreenMode.CLEAR_SCREEN_MODE_FULL, LiveScreenMoveMode.LIVE_SCREEN_MOVE_UP);
        goto L24
    L8:
        if (W90().getStaticState().a() == false) goto L12;
        Lazy r30 = TrackCatcher.a;
        if (TrackCatcher.a.a() == null) goto L12;
        TrackCatcher.b("normal_order");
        goto L12
    }

    public final void onPause() {
        super.onPause();
        BuyNowLog.d("BuyNowFragment", "onPause");
        W90().setResumed(false);
    }

    public final void onResume() {
        super.onResume();
        BuyNowLog.d("BuyNowFragment", "onResume");
        W90().getSkuService().onResume();
        W90().setResumed(true);
        W90().handleAsyncEvent();
        CheckPayStatusController r0 = (CheckPayStatusController) this.n.getValue();
        if (r0.c == true) goto L19;
        com.bytedance.android.shopping.buynow.eventcenter.handle.a r2 = r0.f.W90().getCheckParams();
        Integer r3 = null;
        if (r2 == null) goto L7;
        Boolean r4 = r2.g;
    L9:
        if (com.bytedance.android.shopping.extensions.k.i(r4) == false) goto L19;
        com.bytedance.android.shopping.buynow.eventcenter.handle.a r5 = r0.f.W90().getCheckParams();
        if (r5 == null) goto L13;
        r3 = r5.c;
    L13:
        int r6 = BuyNowPayType.ALIPAY.getType();
        if (r3 == null) goto L19;
        if (r3.intValue() != r6) goto L19;
        r0.c = true;
        return;
    L7:
        r4 = null;
    L19:
        com.bytedance.android.shopping.buynow.eventcenter.handle.a r1 = r0.f.W90().getCheckParams();
        if (r1 != null) goto L22;
        return;
    L22:
        if (Intrinsics.areEqual(r0.f.W90().getCheckStatus(), CheckStatus.TTPAY) == true) goto L24;
        return;
    L24:
        if (Intrinsics.areEqual(r1.f, Boolean.TRUE) == false) goto L30;
        r0.f.W90().getTracker().f(CheckOrderTriggerOrigin.PAGE_VISIBLE);
        r0.b(r1.a, r1.b, r1.d, r1.e);
        return;
    }

    public final void onStart() {
        super.onStart();
        BuyNowLog.d("BuyNowFragment", "onStart");
        W90().getSkuService().onStart();
        if (W90().getStaticState().c() == false) goto L13;
        q r0 = this.o;
        if (r0 != null) goto L7;
    L9:
        TranslateAnimation r1 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        r1.setDuration(390);
        r1.setInterpolator(new a0());
        View r2 = S90(2131381866);
        if (r2 == null) goto L14;
        r2.startAnimation(r1);
        return;
    L14:
        return;
    L7:
        if (r0.h != true) goto L9;
        return;
    }

    public final void onStop() {
        super.onStop();
        W90().getSkuService().onStop();
    }

    public final ViewModelProvider.Factory getViewModelFactory() {
        return this.e;
    }

    /* JADX INFO: renamed from: getReceiver, reason: collision with other method in class */
    public final IdentitySubscriber m244getReceiver() {
        return JediView.DefaultImpls.getReceiver(this);
    }

    public final void Q70(Map r3) {
        Intrinsics.checkNotNullParameter("gallery_viewer_module_show", "eventName");
        Intrinsics.checkNotNullParameter(r3, "params");
        W90().getTracker().b("gallery_viewer_module_show", r3);
    }

    public final View S90(int r3) {
        if (this.d != null) goto L5;
        this.d = new LinkedHashMap();
    L5:
        View r0 = this.d.get(Integer.valueOf(r3));
        if (r0 != null) goto L14;
        View r1 = getView();
        if (r1 == null) goto L12;
        View r2 = r1.findViewById(r3);
        if (r2 == null) goto L12;
        this.d.put(Integer.valueOf(r3), r2);
        return r2;
    L12:
        return null;
    L14:
        return r0;
    }

    public final void T90(com.bytedance.android.shopping.buynow.starter.d r14) {
        q r0 = this.o;
        if (r0 == null) goto L5;
        r0.b();
    L5:
        com.bytedance.kmp.ec.yata.view.render.delegate.v2.a r1 = this.C;
        if (r1 == null) goto L11;
        com.bytedance.android.ecom.slice.ext.template.gecko.c r2 = r1.a;
        if (r2 == null) goto L11;
        r2.a();
    L11:
        if (r14.g == false) goto L21;
        W90().getStaticState().i = true;
        com.bytedance.android.shopping.buynow.tracker.a r3 = W90().getTracker();
        Pair[] r4 = new Pair[2];
        if (W90().getStaticState().i == false) goto L15;
        String r5 = "1";
    L16:
        r4[0] = TuplesKt.to("has_used_cache", r5);
        if (r14.h == false) goto L19;
        String r6 = "prefetch";
    L20:
        r4[1] = TuplesKt.to("cache_type", r6);
        r3.a(MapsKt.mapOf(r4));
        goto L21
    L19:
        r6 = "twice_open";
        goto L20
    L15:
        r5 = "0";
    L21:
        boolean r7 = r14.g;
        boolean r8 = W90().getStaticState().i;
        String r9 = null;
        if (ECAppInfoService.e.i() == false) goto L48;
        Context r10 = getContext();
        if (r10 == null) goto L48;
        if (r7 == false) goto L31;
        TextView r11 = (TextView) S90(2131388304);
        if (r11 == null) goto L34;
        r11.setBackgroundColor(th.a.a(r10, 2131101675));
    L34:
        int r12 = com.bytedance.android.shopping.buynow.container.a.a;
        Bundle r13 = getArguments();
        if (r13 == null) goto L37;
        Serializable r15 = r13.getSerializable("ultimate_buy_params");
    L39:
        if ((r15 instanceof UltimateBuyParams) == true) goto L41;
        r15 = null;
    L41:
        UltimateBuyParams r16 = (UltimateBuyParams) r15;
        Bundle r17 = getArguments();
        if (r17 == null) goto L44;
        Uri r18 = (Uri) r17.getParcelable("Schema");
    L45:
        String r19 = com.bytedance.android.shopping.buynow.container.a.a(r16, r18, r8, W90().getStaticState().a);
        TextView r20 = (TextView) S90(2131388304);
        if (r20 == null) goto L48;
        r20.setText(r19);
        goto L48
    L44:
        r18 = null;
        goto L45
    L37:
        r15 = null;
        goto L39
    L31:
        TextView r21 = (TextView) S90(2131388304);
        if (r21 == null) goto L34;
        r21.setBackgroundColor(th.a.a(r10, 2131100729));
    L48:
        BuyNowLog.d("BuyNowFragment", "bindResponseIfReady");
        if ((!Intrinsics.areEqual(W90().getStaticState().g, PageType.CONTINUEPAY)) == false) goto L55;
        JSONObject r22 = new JSONObject();
        nl.c r23 = W90().getStaticState().a;
        if (r23 == null) goto L53;
        String r24 = r23.getQueryParam("pre_session_id");
    L54:
        KtSafeMethodExtensionKt.safePut(r22, "pre_session_id", r24);
        KtSafeMethodExtensionKt.safePut(r22, "buynow_session_id", W90().getStaticState().b);
        KtSafeMethodExtensionKt.safePut(r22, "page_scene", Integer.valueOf(!Intrinsics.areEqual(W90().getStaticState().g, PageType.BUYNOW) ? 1 : 0));
        Unit r25 = Unit.INSTANCE;
        ECLiveHybridUtil.f("ecom.buynow.show", r22);
        goto L55
    L53:
        r24 = null;
    L55:
        ma3.b r110 = r14.b;
        if (r110 == null) goto L58;
        Boolean r26 = Boolean.valueOf(com.bytedance.kmp.ec.yata.common.protocol.data.f.d(r110));
    L60:
        if (com.bytedance.android.shopping.extensions.k.i(r26) == false) goto L127;
        if (r110 == null) goto L63;
        com.bytedance.android.shopping.sku.common.ability.b r27 = W90().getSkuService();
        com.bytedance.android.shopping.sku.inner.repo.a r28 = new com.bytedance.android.shopping.sku.inner.repo.a(r110.i(), 6);
        r28.d(r110.a());
        r28.e(r110.b());
        r28.f(r110.c());
        Unit r29 = Unit.INSTANCE;
        r27.m(r28);
    L63:
        W90().getStaticState().c = r14.a;
        W90().getStaticState().h = r14.f;
        BuyNowLog.a("BuyNowPrefetcher", "handle response isCache " + r14.g + " isPrefetchCache " + r14.h);
        if (r14.g == false) goto L126;
        ma3.b r111 = r14.b;
        SlcRenderContext r30 = this.r;
        if (r30 == null) goto L72;
        if (r111 == null) goto L70;
        String r31 = com.bytedance.kmp.ec.yata.common.protocol.data.f.b(r111);
        if (r31 == null) goto L70;
    L71:
        r30.h = MapsKt.mapOf(TuplesKt.to("log_id", r31));
    L70:
        r31 = "";
    L72:
        com.bytedance.android.shopping.sku.common.ability.b r32 = W90().getSkuService();
        if (r111 == null) goto L75;
        String r33 = com.bytedance.kmp.ec.yata.common.protocol.data.f.b(r111);
    L76:
        r32.s(r33);
        Disposable r34 = this.z;
        if (r34 == null) goto L79;
        r34.dispose();
    L79:
        BuyNowViewModel r35 = W90();
        if (r111 == null) goto L82;
        com.bytedance.kmp.ec.yata.common.protocol.data.c r36 = r111.i();
    L83:
        r35.updateTrackerCommonParams(r36, true);
        pa3.a r37 = this.w;
        if (r37 == null) goto L102;
        BuyNowFirstScreenMonitor r38 = r37.a;
        if (r38 == null) goto L102;
        MonitorScenes r39 = MonitorScenes.EC_PERF_PAGE_SHOW_BUY_NOW;
        if (r111 == null) goto L90;
        Integer r40 = r111.a();
    L91:
        int r41 = com.bytedance.android.shopping.extensions.k.f(r40);
        if (r111 == null) goto L94;
        String r42 = r111.b();
    L95:
        com.bytedance.android.shopping.extensions.k.j(r42);
        Intrinsics.checkNotNullParameter(r39, "scene");
        if (r41 == 0) goto L99;
        r38.d = true;
    L99:
        if (r38.f == true) goto L102;
        r38.f = true;
        goto L102
    L94:
        r42 = null;
        goto L95
    L90:
        r40 = null;
    L102:
        pa3.a r43 = this.w;
        if (r43 == null) goto L107;
        BuyNowFirstScreenMonitor r44 = r43.a;
        if (r44 == null) goto L107;
        r44.a(BuyNowFirstScreenNode.CACHE_RENDER_START, System.currentTimeMillis());
    L107:
        AndroidYaTaInstance r45 = this.q;
        if (r45 == null) goto L117;
        if (r111 == null) goto L111;
        com.bytedance.kmp.ec.yata.common.protocol.data.c r46 = r111.i();
    L112:
        aa6.a.b.a r47 = aa6.a.b.a.b;
        com.bytedance.kmp.ec.yata.common.perf.d r48 = new com.bytedance.kmp.ec.yata.common.perf.d("biz_first_enter");
        if (r111 == null) goto L115;
        r9 = com.bytedance.kmp.ec.yata.common.protocol.data.f.b(r111);
    L115:
        r45.x(r46, r47, r48, r9);
        goto L117
    L111:
        r46 = null;
    L117:
        if (W90().getStaticState().c() == true) goto L120;
        int r112 = com.bytedance.android.shopping.buynow.utils.b.a;
        if (com.bytedance.android.shopping.buynow.utils.b.a(W90()) == true) goto L120;
        return;
    L120:
        RoundConstraintLayout r113 = S90(2131367761);
        if (r113 == null) goto L123;
        r113.setVisibility(0);
    L123:
        YataPerfLinearLayout r114 = S90(2131386837);
        if (r114 == null) goto L130;
        r114.setVisibility(0);
        return;
    L130:
        return;
    L82:
        r36 = null;
        goto L83
    L75:
        r33 = null;
        goto L76
    L126:
        ba0(false, true, true, r14.c, r14.b, new ma3.a(r14.d, r14.e));
        return;
    L127:
        ba0(false, false, true, r14.c, r110, new ma3.a(r14.d, r14.e));
        return;
    L58:
        r26 = null;
        goto L60
    }

    public final String U90(boolean r2) {
        if (W90().getStaticState().c() == false) goto L9;
        UltimateBuyNowApi.a.getClass();
        if (r2 == false) goto L7;
        return "/order/component/confirmOrder/";
    L7:
        return "/order/component/confirmOrderEdit/";
    L9:
        if (W90().getStaticState().b() == false) goto L14;
        ContinuePayApi.a.getClass();
        if (r2 == false) goto L13;
        return "/order/yata/getPayMethod";
    L13:
        return "/order/yata/getPayMethodEdit";
    L14:
        BuyNowApi.a.getClass();
        if (r2 == false) goto L17;
        return "/order/yata/confirmOrderRender";
    L17:
        return "/order/yata/confirmOrderEdit";
    }

    public final void Y90(SlcRenderContext r8) {
        if (r8 == null) goto L5;
        r8.f = W90().getBuyNowPageConfig().a();
    L5:
        if (r8 == null) goto L7;
        W90().getBuyNowPageConfig().getClass();
        r8.g = true;
    L7:
        if (r8 == null) goto L9;
        W90().getBuyNowPageConfig().getClass();
        r8.y = true;
    L9:
        LinkedHashMap r1 = new LinkedHashMap();
        if (r8 == null) goto L13;
        r8.p(r1);
    L13:
        if (r8 == null) goto L15;
        r8.j = false;
    L15:
        if (r8 == null) goto L17;
        W90().getBuyNowPageConfig().getClass();
        r8.k = 1000;
    L17:
        boolean r2 = W90().getStaticState().c();
        int r3 = r.a;
        Object r4 = getContext();
        Intrinsics.checkNotNullParameter(this, "fragment");
        if ((r4 instanceof o) == true) goto L20;
        r4 = null;
    L20:
        o r5 = (o) r4;
        if (r5 != null) goto L26;
        Fragment r6 = getParentFragment();
        if ((r6 instanceof o) == true) goto L25;
        r6 = null;
    L25:
        r5 = (o) r6;
    L26:
        if (r5 == null) goto L28;
        View r7 = r5.G9();
    L29:
        if (r2 == false) goto L34;
        if (r7 == null) goto L34;
        boolean r9 = W90().getStaticState().c();
        if (r8 == null) goto L49;
        W90().getBuyNowPageConfig().getClass();
        r8.q(new com.bytedance.android.ecom.arch.slice.render.context.e(true, r7, r9, new c(r7)));
        return;
    L49:
        return;
    L34:
        if (r8 == null) goto L51;
        W90().getBuyNowPageConfig().getClass();
        Object r10 = getContext();
        Intrinsics.checkNotNullParameter(this, "fragment");
        if ((r10 instanceof o) == true) goto L38;
        r10 = null;
    L38:
        o r11 = (o) r10;
        if (r11 != null) goto L44;
        Fragment r12 = getParentFragment();
        if ((r12 instanceof o) == true) goto L43;
        r12 = null;
    L43:
        r11 = (o) r12;
    L44:
        if (r11 == null) goto L46;
        View r13 = r11.s7();
    L47:
        r8.q(new com.bytedance.android.ecom.arch.slice.render.context.e(true, r13, false, null));
        return;
    L46:
        r13 = null;
        goto L47
    L51:
        return;
    L28:
        r7 = null;
        goto L29
    }

    public final void aa0(com.bytedance.android.shopping.sku.common.data.e r3) {
        Intrinsics.checkNotNullParameter(r3, "nextData");
        Context r0 = getContext();
        if (r0 == null) goto L8;
        com.bytedance.android.shopping.buynow.starter.n r1 = this.g;
        if (r1 == null) goto L9;
        r1.c(r0, r3);
        return;
    L9:
        return;
    }

    public final void onCreate(Bundle r15) {
        Lazy r0 = BuyNowLog.a;
        BuyNowLog.d("BuyNowFragment", "onCreate " + r15);
        BuyNowLog.d("BuyNowFragment", "initData");
        W90().getStaticState().e = System.currentTimeMillis();
        Bundle r1 = getArguments();
        String r2 = null;
        if (r1 == null) goto L5;
        Serializable r3 = r1.getSerializable("ultimate_buy_params");
    L7:
        if ((r3 instanceof UltimateBuyParams) == true) goto L9;
        r3 = null;
    L9:
        UltimateBuyParams r4 = (UltimateBuyParams) r3;
        W90().setUltimateBuyParams(r4);
        Bundle r5 = getArguments();
        if (r5 == null) goto L12;
        String r6 = r5.getString("PrefetchSessionId");
    L13:
        W90().getStaticState().b = r6;
        com.bytedance.android.shopping.buynow.viewmodel.a r7 = W90().getStaticState();
        Bundle r8 = getArguments();
        if (r8 != null) goto L16;
    L18:
        boolean r9 = false;
    L19:
        r7.m = r9;
        this.g = com.bytedance.android.shopping.buynow.starter.k.a(r6);
        Bundle r10 = getArguments();
        if (r10 == null) goto L26;
        BuyNowOrderSchema r11 = (BuyNowOrderSchema) r10.getParcelable("OrderSchema");
        if (r11 == null) goto L26;
        int r12 = ECSdk.a;
        IECCommonService r13 = (IECCommonService) ECSdk.a(IECCommonService.class);
        if (r13 == null) goto L26;
        IOrderSchema r14 = r13.convertToOrderSchema(r11.a, r11.b);
    L27:
        this.D = r14;
        if (r14 == null) goto L30;
        r14.z0();
    L30:
        if (r4 == null) goto L32;
        SkuParams r16 = r4.getSkuParams();
    L33:
        if (r16 == null) goto L35;
        SkuParams r17 = r4.getSkuParams();
    L41:
        if (r17 == null) goto L43;
        r17.setUniqueId(r6);
    L43:
        if (r17 == null) goto L47;
        com.bytedance.android.shopping.sku.common.ability.c r18 = this.i;
        if (r18 == null) goto L47;
        r18.e(r17);
    L47:
        com.bytedance.android.shopping.buynow.viewmodel.a r19 = W90().getStaticState();
        com.bytedance.android.shopping.buynow.starter.n r20 = this.g;
        if (r20 == null) goto L50;
        nl.c r21 = r20.a();
    L51:
        r19.a = r21;
        com.bytedance.android.shopping.buynow.viewmodel.a r22 = W90().getStaticState();
        com.bytedance.android.shopping.buynow.starter.n r23 = this.g;
        if (r23 == null) goto L54;
        r23.getSourceBtmToken();
    L54:
        r22.getClass();
        com.bytedance.android.shopping.buynow.viewmodel.a r24 = W90().getStaticState();
        com.bytedance.android.shopping.buynow.starter.n r25 = this.g;
        if (r25 == null) goto L59;
        s r26 = r25.b();
        if (r26 == null) goto L59;
        Map<String, ? extends Object> r27 = r26.a;
    L60:
        r24.j = r27;
        com.bytedance.android.shopping.buynow.viewmodel.a r28 = W90().getStaticState();
        com.bytedance.android.shopping.buynow.starter.n r29 = this.g;
        if (r29 == null) goto L65;
        s r30 = r29.b();
        if (r30 == null) goto L65;
        String r31 = r30.b;
    L66:
        r28.k = r31;
        com.bytedance.android.shopping.buynow.viewmodel.a r32 = W90().getStaticState();
        if (r4 != null) goto L91;
        com.bytedance.android.shopping.buynow.starter.n r33 = this.g;
        if (r33 == null) goto L73;
        nl.c r34 = r33.a();
        if (r34 == null) goto L73;
        String r35 = r34.getQueryParam("ultimate_buy_ab");
    L75:
        if (com.bytedance.android.shopping.extensions.k.r(r35, 0) <= 0) goto L85;
        com.bytedance.android.shopping.buynow.starter.n r36 = this.g;
        if (r36 == null) goto L81;
        nl.c r37 = r36.a();
        if (r37 == null) goto L81;
        String r38 = r37.getQueryParam("ultimate_buy_version");
    L83:
        if (com.bytedance.android.shopping.extensions.k.r(r38, 0) <= 0) goto L85;
    L81:
        r38 = null;
    L85:
        com.bytedance.android.shopping.buynow.starter.n r39 = this.g;
        if (r39 != null) goto L88;
    L90:
        String r40 = PageType.BUYNOW;
    L92:
        r32.getClass();
        Intrinsics.checkNotNullParameter(r40, "<set-?>");
        r32.g = r40;
        Bundle r41 = getArguments();
        if (r41 == null) goto L95;
        Float r42 = Float.valueOf(r41.getFloat("height_percent"));
    L96:
        W90().getStaticState().f = r42;
        BtmSDK r43 = BtmSDK.INSTANCE;
        int r44 = com.bytedance.android.shopping.buynow.utils.c.a;
        String r45 = com.bytedance.android.shopping.buynow.utils.c.a(W90().getStaticState().g);
        Bundle r46 = getArguments();
        if (r46 == null) goto L99;
        String r47 = r46.getString("source_btm_token");
    L100:
        r43.registerBtmPageOnCreate(this, r45, r47);
        com.bytedance.android.shopping.buynow.starter.n r48 = this.g;
        if (r48 == null) goto L103;
        r48.d(this);
    L103:
        W90().getStaticState().d = PageFinder.via(r43.getPageId(PageFinder.via(this)));
        if (W90().getStaticState().c() == false) goto L107;
        SkeletonMode r49 = SkeletonMode.ULTIMATE;
    L113:
        this.B = r49;
        com.bytedance.android.shopping.buynow.tracker.a r50 = W90().getTracker();
        com.bytedance.android.shopping.buynow.starter.n r51 = this.g;
        if (r51 == null) goto L116;
        Map<String, ? extends Object> r52 = r51.j();
    L117:
        EventActionImpl r53 = r50.d;
        if (r52 != null) goto L120;
        int r54 = com.bytedance.android.shopping.buynow.tracker.a.i;
        r52 = com.bytedance.android.shopping.buynow.tracker.a.C0029a.a(r50.h.getStaticState().b, r50.h.getStaticState().c(), r50.h.getStaticState().b(), r50.h.getStaticState().a, r50.h.getUltimateBuyParams());
    L120:
        r53.appendEventParams(r52);
        Map<String, pa3.a> r55 = pa3.a.c;
        this.w = pa3.a.C0222a.a(r6);
        if (W90().getStaticState().c() == false) goto L134;
        ECSettingKeys.j.getClass();
        if (ECSettingKeys.V() == false) goto L129;
        BuyNowViewModel r56 = W90();
        if (ECSettingKeys.T() != 1) goto L127;
        boolean r110 = true;
    L128:
        r56.setBuyNowPageConfig(new com.bytedance.android.shopping.buynow.starter.b(true, r110, false, 390.0f, 4));
        goto L134
    L127:
        r110 = false;
        goto L128
    L129:
        BuyNowViewModel r57 = W90();
        if (ECSettingKeys.T() != 1) goto L132;
        boolean r111 = true;
    L133:
        r57.setBuyNowPageConfig(new com.bytedance.android.shopping.buynow.starter.b(false, r111, false, 0.0f, 12));
        goto L134
    L132:
        r111 = false;
    L134:
        W90().getBuyNowPageConfig().c = W90().getStaticState().m;
        int r58 = BuyNowTemplateMgr.a;
        BuyNowTemplateMgr.a(requireContext(), V90(), false);
        SliceTemplateManager.a();
        if (BuyNowPerformanceOpt.i() == false) goto L164;
        if (getContext() == null) goto L151;
        int r59 = com.bytedance.kmp.ec.yata.view.render.delegate.v2.a.e;
        com.bytedance.android.shopping.buynow.viewmodel.a r60 = W90().getStaticState();
        Intrinsics.checkNotNullParameter(r60, "$this$getBizCode");
        String r61 = r60.g;
        int r62 = r61.hashCode();
        if (r62 == (-1132693887)) goto L147;
        if (r62 == 21618209) goto L144;
    L149:
        String r63 = BuyNowBizCode.BUY.getValue();
    L150:
        com.bytedance.kmp.ec.yata.view.render.delegate.v2.a r64 = com.bytedance.kmp.ec.yata.view.render.delegate.v2.a.a.b(this, r63);
        r64.c = false;
        r64.d = false;
        Y90(r64.b);
        r64.a.b(r64.b);
        Unit r65 = Unit.INSTANCE;
        this.C = r64;
        goto L151
    L144:
        if (r61.equals(PageType.ULTIMATEBUYNOW) == false) goto L149;
        r63 = BuyNowBizCode.YATA_SKUBUY.getValue();
        goto L150
    L147:
        if (r61.equals(PageType.CONTINUEPAY) == false) goto L149;
        r63 = BuyNowBizCode.CONTINUE_PAY.getValue();
    L151:
        com.bytedance.android.shopping.buynow.starter.n r66 = this.g;
        if (r66 != null) goto L154;
    L160:
        com.bytedance.android.shopping.buynow.starter.n r67 = this.g;
        if (r67 == null) goto L164;
        r67.k(new BuyNowFragment$preCreateTemplateView$2(this));
        goto L164
    L154:
        if (r66.g() != true) goto L160;
        com.bytedance.kmp.ec.yata.view.render.delegate.v2.a r68 = this.C;
        if (r68 == null) goto L164;
        com.bytedance.android.ecom.slice.ext.template.gecko.c r69 = r68.a;
        if (r69 == null) goto L164;
        r69.a();
    L164:
        if (ja3.a.c(W90().getStaticState().a) == true) goto L166;
        int r70 = com.bytedance.android.shopping.buynow.opt.a.a;
        com.bytedance.android.shopping.buynow.opt.a.a(requireContext());
    L166:
        W90().getSkuService().x(new AnonymousClass1(this), new AnonymousClass2(this));
        super.onCreate(r15);
        if (r15 != null) goto L169;
    L171:
        nl.c r112 = W90().getStaticState().a;
        if (r112 == null) goto L174;
        r2 = r112.getQueryParam("scene_type");
    L174:
        com.bytedance.android.shopping.buynow.tracker.a r113 = W90().getTracker();
        Pair[] r71 = new Pair[2];
        UltimateBuyParams r72 = W90().getUltimateBuyParams();
        if (r72 == null) goto L182;
        SkuParams r73 = r72.getSkuParams();
        if (r73 == null) goto L182;
        String r74 = String.valueOf(r73.getSceneType());
        if (r74 == null) goto L182;
        r2 = r74;
    L182:
        if (r2 != null) goto L184;
        r2 = "";
    L184:
        r71[0] = TuplesKt.to("scene_type", r2);
        int r75 = J + 1;
        J = r75;
        r71[1] = TuplesKt.to("start_count", Integer.valueOf(r75));
        r113.a(MapsKt.mapOf(r71));
        if (W90().getStaticState().c() == false) goto L193;
        Context r114 = getContext();
        if (r114 == null) goto L191;
        com.bytedance.android.shopping.sku.common.ability.c r76 = this.i;
        if (r76 == null) goto L191;
        r76.g(r114, W90().getSkuPageState());
    L191:
        this.x = new qa3.a(MonitorScenes.SLICE_YATA_SKU_BUY);
    L196:
        pa3.a r115 = this.w;
        if (r115 == null) goto L201;
        BuyNowFirstScreenMonitor r116 = r115.a;
        if (r116 == null) goto L201;
        r116.a(BuyNowFirstScreenNode.PAGE_START, System.currentTimeMillis());
    L201:
        W90().getTracker().k(CheckPointType.ENTER_PAGE, new LinkedHashMap());
        if (W90().getStaticState().a() == false) goto L207;
        int r117 = ECSdk.a;
        IECFeedbackService r118 = (IECFeedbackService) ECSdk.a(IECFeedbackService.class);
        if (r118 == null) goto L207;
        r118.registerScreenCapture(getContext(), this);
    L207:
        if (W90().getStaticState().c() == false) goto L212;
        Lazy r119 = TrackCatcher.a;
        if (TrackCatcher.a.a() == null) goto L217;
        TrackCatcher.a("step_order");
        return;
    L217:
        return;
    L212:
        if (W90().getStaticState().a() == false) goto L219;
        Lazy r120 = TrackCatcher.a;
        if (TrackCatcher.a.a() == null) goto L220;
        TrackCatcher.a("normal_order");
        return;
    L220:
        return;
    L219:
        return;
    L193:
        if (W90().getStaticState().b() == false) goto L195;
        this.x = new qa3.a(MonitorScenes.SLICE_YATA_CONTINUE_PAY);
        goto L196
    L195:
        this.x = new qa3.a(MonitorScenes.SLICE_YATA_BUYNOW);
        goto L196
    L169:
        if ((getParentFragment() instanceof BuyNowHalfScreenDialogFragment) == false) goto L171;
        return;
    L116:
        r52 = null;
        goto L117
    L107:
        if (ja3.a.d(W90().getStaticState().a) == false) goto L110;
        r49 = SkeletonMode.ONLY_PAY;
        goto L113
    L110:
        if (W90().getStaticState().b() == false) goto L112;
        r49 = SkeletonMode.CONTINUE_PAY;
        goto L113
    L112:
        r49 = SkeletonMode.NORMAL;
        goto L113
    L99:
        r47 = null;
        goto L100
    L95:
        r42 = null;
        goto L96
    L88:
        if (r39.f() != true) goto L90;
        r40 = PageType.CONTINUEPAY;
    L73:
        r35 = null;
    L91:
        r40 = PageType.ULTIMATEBUYNOW;
    L65:
        r31 = null;
    L59:
        r27 = null;
        goto L60
    L50:
        r21 = null;
        goto L51
    L35:
        IOrderSchema r77 = this.D;
        if (r77 != null) goto L38;
    L40:
        r17 = null;
        goto L41
    L38:
        if (r77.C() != true) goto L40;
        r17 = new com.bytedance.android.shopping.sku.inner.ultimate.h(null, this.D, W90().getStaticState().m, 1).b;
        goto L41
    L32:
        r16 = null;
    L26:
        r14 = null;
        goto L27
    L16:
        if (r8.getBoolean("IsSplitScreen") != true) goto L18;
        r9 = true;
        goto L19
    L12:
        r6 = null;
        goto L13
    L5:
        r3 = null;
        goto L7
    }

    public final void onSaveInstanceState(Bundle r3) {
        Intrinsics.checkNotNullParameter(r3, "outState");
        super.onSaveInstanceState(r3);
        r3.putBoolean("LOAD_AGAIN", true);
    }

    public final void ea0(Bundle r18, Bundle r19) {
        BuyNowLog.d("BuyNowFragment", "requestData");
        com.bytedance.android.shopping.buynow.starter.d r4 = null;
        Serializable r5 = null;
        String r6 = null;
        com.bytedance.android.shopping.buynow.starter.d r7 = null;
        if (r19 == null) goto L46;
        if (r19.getBoolean("LOAD_AGAIN") != true) goto L46;
        Context r8 = getContext();
        if (r8 != null) goto L10;
        com.bytedance.android.shopping.buynow.monitor.error.a.b(W90().getTracker(), "LOAD_AGAIN_ERROR", "requestData context is null");
        return;
    L10:
        if (r18 == null) goto L12;
        Uri r9 = (Uri) r18.getParcelable("Schema");
    L13:
        if (r9 == null) goto L15;
    L20:
        BuyNowLog.d("BuyNowFragment", "requestData after check " + r18 + ' ' + r19);
        if (r9 == null) goto L27;
        int r10 = BuyNowStarter.w;
        String r11 = r18.getString("PrefetchSessionId");
        Serializable r3 = r18.getSerializable("ultimate_buy_params");
        if ((r3 instanceof UltimateBuyParams) == false) goto L26;
        r5 = r3;
    L26:
        this.g = BuyNowStarter.a.b(r9, null, r11, (UltimateBuyParams) r5, null, null, r18.getString("source_btm_token"), 176);
    L36:
        com.bytedance.android.shopping.buynow.starter.n r1 = this.g;
        if (r1 == null) goto L39;
        r1.e(new BuyNowFragment$requestData$2(this));
    L39:
        com.bytedance.android.shopping.buynow.starter.n r2 = this.g;
        if (r2 == null) goto L42;
        r2.d(this);
    L42:
        com.bytedance.android.shopping.buynow.starter.n r12 = this.g;
        if (r12 == null) goto L64;
        r12.i(r8, true);
        return;
    L64:
        return;
    L27:
        IOrderSchema r13 = this.D;
        if (r13 == null) goto L36;
        int r14 = BuyNowStarterOpt.q;
        if (r18 == null) goto L32;
        String r15 = r18.getString("PrefetchSessionId");
    L33:
        if (r18 == null) goto L35;
        r6 = r18.getString("source_btm_token");
    L35:
        this.g = BuyNowStarterOpt.a.a(r13, null, r15, r6, false, 40);
        goto L36
    L32:
        r15 = null;
        goto L33
    L15:
        if (this.D != null) goto L20;
        if (W90().getUltimateBuyParams() != null) goto L20;
        com.bytedance.android.shopping.buynow.monitor.error.a.b(W90().getTracker(), "LOAD_AGAIN_ERROR", "requestData schema and ultimateBuyParams is null");
        return;
    L12:
        r9 = null;
    L46:
        if (W90().getStaticState().c() == false) goto L55;
        com.bytedance.android.shopping.buynow.starter.n r16 = this.g;
        if (r16 == null) goto L50;
        r7 = r16.h();
    L50:
        if (r7 == null) goto L52;
        T90(r7);
    L52:
        com.bytedance.android.shopping.buynow.starter.n r17 = this.g;
        if (r17 == null) goto L66;
        r17.e(new BuyNowFragment$requestData$3(this));
        return;
    L66:
        return;
    L55:
        com.bytedance.android.shopping.buynow.starter.n r20 = this.g;
        if (r20 == null) goto L58;
        r4 = r20.h();
    L58:
        if (r4 == null) goto L60;
        T90(r4);
        return;
    L60:
        com.bytedance.android.shopping.buynow.starter.n r21 = this.g;
        if (r21 == null) goto L69;
        r21.e(new BuyNowFragment$requestData$4(this));
        return;
    }

    public final void onViewCreated(View r28, Bundle r29) {
        Intrinsics.checkNotNullParameter(r28, FreqActions.ACTION_VIEW);
        super.onViewCreated(r28, r29);
        Lazy r0 = BuyNowLog.a;
        StringBuilder r1 = new StringBuilder("onViewCreated start ");
        if (r29 == null) goto L5;
        boolean r2 = true;
    L6:
        r1.append(r2);
        BuyNowLog.d("BuyNowFragment", r1.toString());
        FragmentActivity r3 = getActivity();
        if (r3 != null) goto L9;
        return;
    L9:
        int r4 = BuyNowTemplateMgr.a;
        BuyNowTemplateMgr.b(W90(), V90());
        com.bytedance.android.bcm.api.b.e(PageFinder.via(this), "page_show", new BcmParams());
        qa3.a r5 = this.x;
        if (r5 == null) goto L12;
        RecyclerView r6 = S90(2131364334);
        Intrinsics.checkNotNullParameter(r6, "recyclerView");
        r5.a.c(r6);
    L12:
        int r7 = r.a;
        Window r8 = r.a(getContext(), this);
        if (r8 == null) goto L19;
        qa3.a r9 = this.x;
        if (r9 == null) goto L19;
        Intrinsics.checkNotNullParameter(r8, "window");
        jh.c r10 = r9.a;
        r10.getClass();
        Intrinsics.checkNotNullParameter(r8, "window");
        int r11 = ECSdk.a;
        cj.a r12 = (cj.a) ECSdk.a(cj.a.class);
        if (r12 == null) goto L19;
        String r13 = r10.a.a;
        r12.a();
    L19:
        pa3.a r14 = this.w;
        if (r14 == null) goto L24;
        BuyNowFirstScreenMonitor r15 = r14.a;
        if (r15 == null) goto L24;
        r15.a(BuyNowFirstScreenNode.YATA_INIT_START, System.currentTimeMillis());
    L24:
        int r16 = AndroidYataBuilderManager.a;
        String r17 = V90().getValue();
        com.bytedance.android.shopping.buynow.yata.a r18 = new com.bytedance.android.shopping.buynow.yata.a(requireActivity(), this, W90());
        com.bytedance.kmp.ec.yata.view.render.delegate.v2.a r19 = this.C;
        com.bytedance.android.shopping.buynow.starter.n r20 = this.g;
        if (r20 == null) goto L27;
        YataPageInfo r21 = r20.getPageInfo();
    L28:
        com.bytedance.kmp.ec.yata.b r22 = AndroidYataBuilderManager.a(r17, r18, r19, r21, BuyNowFragment$initYataInstance$1.INSTANCE);
        com.bytedance.kmp.ec.yata.b.c(r22, (LinearLayout) S90(2131374285));
        com.bytedance.kmp.ec.yata.b.a(r22, S90(2131364334));
        com.bytedance.kmp.ec.yata.b.b(r22, (LinearLayout) S90(2131373142));
        com.bytedance.kmp.ec.yata.b.d(r22, "header_address", (LinearLayout) S90(2131374276));
        com.bytedance.kmp.ec.yata.b.d(r22, "ceiling_container", (LinearLayout) S90(2131365368));
        com.bytedance.kmp.ec.yata.b.d(r22, "dialog", (LinearLayout) S90(2131368977));
        com.bytedance.kmp.ec.yata.b.d(r22, "guide", (LinearLayout) S90(2131371514));
        com.bytedance.kmp.ec.yata.b.d(r22, "top", (LinearLayout) S90(2131386837));
        com.bytedance.kmp.ec.yata.b.d(r22, "header_ceiling", (LinearLayout) S90(2131374283));
        com.bytedance.kmp.ec.yata.b.d(r22, BuyNowCloseMethod.MASK, (LinearLayout) S90(2131379666));
        r22.e((FrameLayout) S90(2131382786));
        this.q = r22.a;
        if (W90().getStaticState().c() == false) goto L46;
        AndroidYaTaInstance r23 = this.q;
        if (r23 == null) goto L37;
        Object[] r24 = ECSettingKeys.l0().getExtendFields().toArray(new String[0]);
        if (r24 == null) goto L36;
        String[] r25 = (String[]) r24;
        r23.C((String[]) Arrays.copyOf(r25, r25.length));
        goto L37
    L36:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L37:
        AndroidYaTaInstance r26 = this.q;
        if (r26 == null) goto L40;
        r26.E(new j(this));
    L40:
        AndroidYaTaInstance r27 = this.q;
        if (r27 == null) goto L43;
        r27.D(new k(this));
    L43:
        AndroidYaTaInstance r30 = this.q;
        if (r30 == null) goto L46;
        r30.k().e = new l(this);
    L46:
        W90().setYataInstance(this.q);
        AndroidYaTaInstance r31 = this.q;
        if (r31 == null) goto L49;
        SlcRenderContext r32 = (SlcRenderContext) r31.I(Reflection.getOrCreateKotlinClass(SlcRenderContext.class));
    L50:
        this.r = r32;
        if (BuyNowPerformanceOpt.i() == true) goto L53;
        Y90(this.r);
    L53:
        pa3.a r33 = this.w;
        if (r33 == null) goto L58;
        BuyNowFirstScreenMonitor r34 = r33.a;
        if (r34 == null) goto L58;
        r34.a(BuyNowFirstScreenNode.YATA_INIT_END, System.currentTimeMillis());
    L58:
        BuyNowLog.d("BuyNowFragment", "initView start");
        Context r35 = getContext();
        if (r35 != null) goto L61;
        Unit r36 = Unit.INSTANCE;
        int r37 = 2131373142;
    L477:
        com.bytedance.android.shopping.buynow.eventcenter.a r38 = new com.bytedance.android.shopping.buynow.eventcenter.a(r3, this, S90(2131364334), (LinearLayout) S90(r37), W90(), this.q, (CheckPayStatusController) this.n.getValue(), this.w, this.t, requireContext());
        this.h = r38;
        r38.a();
        ca0(false, true, null);
        pa3.a r39 = this.w;
        if (r39 == null) goto L482;
        BuyNowFirstScreenMonitor r40 = r39.a;
        if (r40 == null) goto L482;
        r40.a(BuyNowFirstScreenNode.PAGE_INIT_END, System.currentTimeMillis());
    L482:
        ea0(getArguments(), r29);
        X90();
        nj.d r41 = com.bytedance.android.ec.sdk.helper.d.b.getPadSplitService();
        if (r41 == null) goto L488;
        nj.d.a.a(r41, (BuyNowFragment$orientationListener$2.a) this.p.getValue());
        return;
    L488:
        return;
    L61:
        Float r42 = W90().getStaticState().f;
        int r110 = 26;
        if (fa0() == true) goto L64;
    L74:
        if (r42 == null) goto L120;
        if ((!Intrinsics.areEqual(r42, 1.0f)) == false) goto L120;
        ECSettingKeys.j.getClass();
        float r43 = (float) (((double) ECSettingKeys.X()) / 100.0d);
        if (W90().getStaticState().c() == false) goto L110;
        nl.c r44 = W90().getStaticState().a;
        if (r44 == null) goto L82;
        String r45 = r44.getQueryParam("scene_type");
    L83:
        nl.c r46 = W90().getStaticState().a;
        if (r46 == null) goto L86;
        String r47 = r46.getQueryParam("force_height");
    L88:
        if (BuyNowPerformanceOpt.m() == false) goto L91;
        Float r48 = Float.valueOf(r43);
    L108:
        r42 = r48;
    L109:
        W90().getTracker().a(MapsKt.mapOf(TuplesKt.to("panel_height_percent", String.valueOf((int) (r42.floatValue() * 100)))));
        goto L110
    L91:
        if (BuyNowPerformanceOpt.p() == false) goto L96;
        if (CollectionsKt.contains(ECSettingKeys.W(), r45) == false) goto L109;
        r48 = Float.valueOf(r43);
        goto L108
    L96:
        if (BuyNowPerformanceOpt.o() == false) goto L101;
        if (CollectionsKt.contains(ECSettingKeys.W(), r45) == true) goto L109;
        r48 = Float.valueOf(r43);
        goto L108
    L101:
        if (BuyNowPerformanceOpt.n() == false) goto L106;
        if ((!Intrinsics.areEqual(r47, "1")) == false) goto L109;
        r48 = Float.valueOf(r43);
        goto L108
    L106:
        if (Intrinsics.areEqual(r47, "1") == false) goto L109;
        r48 = Float.valueOf(r43);
        goto L108
    L86:
        r47 = null;
        goto L88
    L82:
        r45 = null;
    L110:
        RoundLinearLayout r49 = S90(2131379429);
        if (r49 == null) goto L145;
        RoundLinearLayout r50 = S90(2131379429);
        if (r50 == null) goto L117;
        ViewGroup.LayoutParams r51 = r50.getLayoutParams();
        if (r51 == null) goto L117;
        r51.height = (int) (com.bytedance.android.shopping.buynow.utils.g.a(r35).b * r42.floatValue());
        Unit r52 = Unit.INSTANCE;
    L118:
        r49.setLayoutParams(r51);
    L117:
        r51 = null;
    L145:
        boolean r53 = ECAppInfoService.e.i();
        if (r53 == false) goto L179;
        TextView r54 = (TextView) S90(2131388304);
        if (r53 == false) goto L151;
        int r55 = 0;
    L152:
        r54.setVisibility(r55);
        ((TextView) S90(2131388304)).setOnClickListener(new com.bytedance.android.shopping.buynow.container.c(this));
        ((TextView) S90(2131388304)).setOnLongClickListener(com.bytedance.android.shopping.buynow.container.d.a);
        int r56 = com.bytedance.android.shopping.buynow.container.a.a;
        Bundle r57 = getArguments();
        if (r57 == null) goto L155;
        Serializable r58 = r57.getSerializable("ultimate_buy_params");
    L157:
        if ((r58 instanceof UltimateBuyParams) == true) goto L159;
        r58 = null;
    L159:
        UltimateBuyParams r59 = (UltimateBuyParams) r58;
        Bundle r60 = getArguments();
        if (r60 == null) goto L162;
        Uri r61 = (Uri) r60.getParcelable("Schema");
    L163:
        String r62 = com.bytedance.android.shopping.buynow.container.a.a(r59, r61, false, W90().getStaticState().a);
        TextView r63 = (TextView) S90(2131388304);
        if (r63 == null) goto L167;
        r63.setText(r62);
    L167:
        if (W90().getStaticState().c() == false) goto L179;
        View r64 = getView();
        if (r64 == null) goto L173;
        TextView r65 = (TextView) r64.findViewById(2131368572);
        if (r65 == null) goto L173;
        wg.a.h(r65, r53);
    L173:
        View r66 = getView();
        if (r66 == null) goto L179;
        TextView r67 = (TextView) r66.findViewById(2131368572);
        if (r67 == null) goto L179;
        r67.setOnClickListener(new com.bytedance.android.shopping.buynow.container.e(this));
        goto L179
    L162:
        r61 = null;
        goto L163
    L155:
        r58 = null;
        goto L157
    L151:
        r55 = 8;
    L179:
        if (W90().getStaticState().c() == false) goto L181;
    L186:
        RoundConstraintLayout r68 = (BuyNowLoadingView) S90(2131379091);
        ViewGroup.LayoutParams r69 = ((BuyNowLoadingView) S90(2131379091)).getLayoutParams();
        if ((r69 instanceof ConstraintLayout.LayoutParams) == true) goto L189;
        r69 = null;
    L189:
        ViewGroup.LayoutParams r70 = (ConstraintLayout.LayoutParams) r69;
        if (r70 == null) goto L192;
        ((ConstraintLayout.LayoutParams) r70).topToTop = 2131379429;
        Unit r71 = Unit.INSTANCE;
    L193:
        r68.setLayoutParams(r70);
    L195:
        if (W90().getStaticState().c() == false) goto L271;
        BuyNowErrorView r72 = (BuyNowErrorView) S90(2131371766);
        if (r72 == null) goto L210;
        BuyNowErrorView r111 = (BuyNowErrorView) S90(2131371766);
        if (r111 == null) goto L201;
        ViewGroup.LayoutParams r73 = r111.getLayoutParams();
    L203:
        if ((r73 instanceof ConstraintLayout.LayoutParams) == true) goto L205;
        r73 = null;
    L205:
        ViewGroup.LayoutParams r74 = (ConstraintLayout.LayoutParams) r73;
        if (r74 == null) goto L208;
        ((ConstraintLayout.LayoutParams) r74).topToTop = 2131374315;
        Unit r112 = Unit.INSTANCE;
    L209:
        r72.setLayoutParams(r74);
        goto L210
    L208:
        r74 = null;
        goto L209
    L201:
        r73 = null;
    L210:
        RoundView r75 = S90(2131367762);
        if (r75 == null) goto L213;
        r75.setVisibility(0);
    L213:
        Context r76 = getContext();
        if (r76 == null) goto L303;
        ConcurrentHashMap r77 = a43.a.a;
        if (Intrinsics.areEqual(l43.a.a("legou_sku_buy_layout_opt"), 1) == false) goto L241;
        RoundConstraintLayout r78 = S90(2131367761);
        if (r78 == null) goto L220;
        Drawable r79 = r78.getBackground();
    L222:
        if ((r79 instanceof BackgroundDrawable) == true) goto L224;
        r79 = null;
    L224:
        BackgroundDrawable r80 = (BackgroundDrawable) r79;
        if (r80 == null) goto L229;
        BackgroundDrawable r81 = r80.setBgColor(th.a.a(r76, 2131101837));
        if (r81 == null) goto L229;
        r81.invalidate();
        Unit r82 = Unit.INSTANCE;
    L229:
        RoundLinearLayout r84 = S90(2131379429);
        if (r84 == null) goto L232;
        Drawable r85 = r84.getBackground();
    L234:
        if ((r85 instanceof BackgroundDrawable) == true) goto L236;
        r85 = null;
    L236:
        BackgroundDrawable r86 = (BackgroundDrawable) r85;
        if (r86 == null) goto L265;
        BackgroundDrawable r87 = r86.setBgColor(th.a.a(r76, 2131101837));
        if (r87 == null) goto L265;
        r87.invalidate();
        Unit r88 = Unit.INSTANCE;
    L265:
        RecyclerView r89 = (BuyNowRecyclerView) S90(2131364334);
        if (r89 == null) goto L268;
        r89.setBackgroundColor(th.a.a(r76, 2131106784));
        Unit r90 = Unit.INSTANCE;
    L268:
        ConstraintLayout r91 = S90(2131374300);
        if (r91 == null) goto L303;
        r91.setBackgroundColor(th.a.a(r76, 2131106784));
        Unit r92 = Unit.INSTANCE;
        goto L303
    L232:
        r85 = null;
        goto L234
    L220:
        r79 = null;
        goto L222
    L241:
        RoundConstraintLayout r94 = S90(2131367761);
        if (r94 == null) goto L244;
        Drawable r95 = r94.getBackground();
    L246:
        if ((r95 instanceof BackgroundDrawable) == true) goto L248;
        r95 = null;
    L248:
        BackgroundDrawable r96 = (BackgroundDrawable) r95;
        if (r96 == null) goto L253;
        BackgroundDrawable r97 = r96.setBgColor(th.a.a(r76, 2131101874));
        if (r97 == null) goto L253;
        r97.invalidate();
        Unit r98 = Unit.INSTANCE;
    L253:
        RoundLinearLayout r99 = S90(2131379429);
        if (r99 == null) goto L256;
        Drawable r100 = r99.getBackground();
    L258:
        if ((r100 instanceof BackgroundDrawable) == true) goto L260;
        r100 = null;
    L260:
        BackgroundDrawable r101 = (BackgroundDrawable) r100;
        if (r101 == null) goto L265;
        BackgroundDrawable r102 = r101.setBgColor(th.a.a(r76, 2131101874));
        if (r102 == null) goto L265;
        r102.invalidate();
        Unit r103 = Unit.INSTANCE;
        goto L265
    L256:
        r100 = null;
        goto L258
    L244:
        r95 = null;
    L303:
        SimpleDraweeView r104 = S90(2131373148);
        if (W90().getStaticState().c() == false) goto L313;
        SimpleDraweeView r105 = (SimpleDraweeView) S90(2131391837);
        RoundConstraintLayout r113 = (BuyNowLoadingView) S90(2131379091);
        ViewGroup.LayoutParams r114 = ((BuyNowLoadingView) S90(2131379091)).getLayoutParams();
        if ((r114 instanceof ConstraintLayout.LayoutParams) == true) goto L308;
        r114 = null;
    L308:
        ViewGroup.LayoutParams r115 = (ConstraintLayout.LayoutParams) r114;
        if (r115 == null) goto L311;
        ((ConstraintLayout.LayoutParams) r115).bottomToTop = 2131391837;
        Unit r106 = Unit.INSTANCE;
    L312:
        r113.setLayoutParams(r115);
        SimpleDraweeView r210 = r105;
    L315:
        if (Intrinsics.areEqual(W90().getStaticState().g, PageType.ULTIMATEBUYNOW) == true) goto L317;
    L319:
        q r107 = this.o;
        if (r107 == null) goto L322;
        r107.a();
        Unit r108 = Unit.INSTANCE;
    L322:
        com.bytedance.android.shopping.buynow.controller.a r109 = (com.bytedance.android.shopping.buynow.controller.a) this.k.getValue();
        r109.getClass();
        int r116 = com.bytedance.android.shopping.buynow.utils.b.a;
        if (com.bytedance.android.shopping.buynow.utils.b.a(r109.f) == false) goto L339;
        RecyclerView r117 = r109.e;
        ViewGroup.LayoutParams r118 = r117.getLayoutParams();
        if ((r118 instanceof ConstraintLayout.LayoutParams) == true) goto L327;
        r118 = null;
    L327:
        ViewGroup.LayoutParams r119 = (ConstraintLayout.LayoutParams) r118;
        if (r119 == null) goto L330;
        ((ConstraintLayout.LayoutParams) r119).topToTop = 0;
        Unit r120 = Unit.INSTANCE;
    L331:
        r117.setLayoutParams(r119);
        ExtensionsKt.gone(r109.c);
        View r121 = r109.d;
        ViewGroup.LayoutParams r122 = r121.getLayoutParams();
        if ((r122 instanceof ConstraintLayout.LayoutParams) == true) goto L334;
        r122 = null;
    L334:
        ViewGroup.MarginLayoutParams r123 = (ConstraintLayout.LayoutParams) r122;
        if (r123 == null) goto L337;
        ((ConstraintLayout.LayoutParams) r123).topToTop = 0;
        ((ConstraintLayout.LayoutParams) r123).startToStart = 0;
        ((ConstraintLayout.LayoutParams) r123).endToEnd = 0;
        ((ConstraintLayout.LayoutParams) r123).bottomToBottom = -1;
        r123.height = -2;
        Unit r124 = Unit.INSTANCE;
    L338:
        r121.setLayoutParams(r123);
        goto L339
    L337:
        r123 = null;
        goto L338
    L330:
        r119 = null;
    L339:
        BuyNowViewModel r211 = W90();
        View r212 = S90(2131380638);
        BuyNowErrorView r125 = (BuyNowErrorView) S90(2131371766);
        r125.b(W90().getBuyNowPageConfig());
        Unit r126 = Unit.INSTANCE;
        BuyNowLoadingView r127 = (BuyNowLoadingView) S90(2131379091);
        com.bytedance.android.shopping.buynow.starter.b r128 = W90().getBuyNowPageConfig();
        r127.getClass();
        Intrinsics.checkNotNullParameter(r128, "buyNowPageConfig");
        DoubleColorBallAnimationView r129 = r127.a;
        ViewGroup.LayoutParams r130 = r129.getLayoutParams();
        if (r130 == null) goto L342;
        r130.width = SlcDimensExtensionsKt.a(24, r128.a());
        r130.height = SlcDimensExtensionsKt.a(28, r128.a());
    L343:
        r129.setLayoutParams(r130);
        this.j = new ia3.b(r211, r212, r127, r210, r125, S90(2131371752), (BuyNowTouchMaskView) S90(2131379672));
        this.s = new ia3.a(S90(2131368977));
        this.v = new ia3.d(S90(2131379666));
        ((ImageView) S90(2131380639)).setOnClickListener(new i(this, r35));
        ImageView r131 = (ImageView) S90(2131380639);
        if (W90().getStaticState().m == false) goto L346;
        r131.setImageResource(2131232449);
    L346:
        ((ImageView) S90(2131371752)).setOnClickListener(new g(this, r35));
        com.bytedance.android.ecom.arch.slice.render.util.i.e((TextView) S90(2131380642), 500);
        final LinearLayoutManager r132 = new LinearLayoutManager(r35);
        RecyclerView r133 = (BuyNowRecyclerView) S90(2131364334);
        r133.setLayoutManager(r132);
        r133.setClipChildren(false);
        if (ja3.a.c(W90().getStaticState().a) == false) goto L349;
        jh.b.a r134 = jh.b.c;
        MonitorScenes r135 = MonitorScenes.FPS_SCENE_BUY_NOW_HALF_SCREEN;
        r134.getClass();
        jh.b.a.b(r135).b(r133);
    L350:
        r133.addOnScrollListener(new BuyNowFragment$initRecyclerView$$inlined$apply$lambda$1(this));
        r133.addOnChildAttachStateChangeListener(new BuyNowFragment$initRecyclerView$1$2());
        r133.addOnItemTouchListener(new BuyNowFragment$initRecyclerView$$inlined$apply$lambda$2(this));
        final BuyNowElevatorGuideController r136 = new BuyNowElevatorGuideController(S90(2131371514), W90(), this.q);
        this.l = r136;
        RecyclerView r137 = S90(2131364334);
        Intrinsics.checkNotNullParameter(r137, "recyclerView");
        Intrinsics.checkNotNullParameter(r132, "layoutManager");
        r137.addOnScrollListener(new BuyNowElevatorGuideController$onBodyContainerInit$1(r136, r132));
        if (W90().getStaticState().c() == false) goto L355;
        final w r138 = new w(this.q, W90(), S90(2131374285), S90(2131374283), S90(2131364334));
        this.m = r138;
        r138.f.addOnScrollListener(new UltimateBuyNowHeaderCeilingController$onBodyContainerInit$1(r138));
        final p r139 = new p(this.q, S90(2131364334));
        r139.b.addOnScrollListener(new ScrollNotifyController$onBodyContainerInit$1(r139));
        AndroidYaTaInstance r140 = this.q;
        if (r140 == null) goto L355;
        r140.c(new xa3.a(this.m));
    L355:
        final com.bytedance.android.shopping.buynow.controller.b r141 = new com.bytedance.android.shopping.buynow.controller.b(this.q, S90(2131365368), S90(2131364334));
        final SlcRenderContext r142 = this.r;
        r141.d.addOnScrollListener(new BuyNowCeilingController$onBodyContainerInit$1(r141, r142));
        if (ja3.a.c(W90().getStaticState().a) == true) goto L358;
    L486:
        Result.Companion r143 = Result.Companion;     // Catch: Throwable -> L361
        Object r144 = Result.constructor-impl(Integer.valueOf(eh.b.b(getContext())));     // Catch: Throwable -> L361
    L364:
        if (Result.isFailure-impl(r144) == false) goto L367;
        com.bytedance.android.shopping.buynow.monitor.error.a.b(W90().getTracker(), "runtime_error", "BuyNowFragment + failure getting status bar height");
    L367:
        if (Result.isFailure-impl(r144) == false) goto L369;
        r144 = 20;
    L369:
        int r145 = ((Number) r144).intValue();
        if (W90().getStaticState().m == false) goto L372;
        float r146 = W90().getBuyNowPageConfig().a().a;
        Resources r147 = Resources.getSystem();
        int r148 = (int) (30 - (11 * (r146 / WindowDisplayMetricsOverride.apply(r147, r147.getDisplayMetrics()).density)));
    L373:
        View r149 = S90(2131380638);
        r149.setPadding(r149.getPaddingLeft(), r148 + r145, r149.getPaddingRight(), r149.getPaddingBottom());
        View r150 = S90(2131374315);
        ViewGroup.LayoutParams r151 = r150.getLayoutParams();
        if ((r151 instanceof ViewGroup.MarginLayoutParams) == true) goto L376;
        r151 = null;
    L376:
        ViewGroup.MarginLayoutParams r152 = (ViewGroup.MarginLayoutParams) r151;
        if (r152 == null) goto L380;
        r152.topMargin = r145;
        r150.setLayoutParams(r152);
    L380:
        if (fa0() == true) goto L384;
        if (ja3.a.c(W90().getStaticState().a) == false) goto L384;
    L385:
        ((FrameLayout) S90(2131381805)).setOnClickListener(new h(this));
    L387:
        if (W90().getStaticState().m == true) goto L389;
    L392:
        SimpleDraweeView r153 = S90(2131373148);
        ViewGroup.LayoutParams r154 = S90(2131373148).getLayoutParams();
        if (r154 == null) goto L395;
        r154.height = SlcDimensExtensionsKt.a(64, W90().getBuyNowPageConfig().a());
        Unit r155 = Unit.INSTANCE;
    L396:
        r153.setLayoutParams(r154);
        TextView r156 = (TextView) S90(2131380642);
        ViewGroup.LayoutParams r157 = ((TextView) S90(2131380642)).getLayoutParams();
        if (r157 == null) goto L399;
        r157.height = SlcDimensExtensionsKt.a(44, W90().getBuyNowPageConfig().a());
        Unit r158 = Unit.INSTANCE;
    L400:
        r156.setLayoutParams(r157);
        r156.setTextSize(0, SlcDimensExtensionsKt.c(17, W90().getBuyNowPageConfig().a()));
        ImageView r159 = (ImageView) S90(2131380639);
        ViewGroup.LayoutParams r160 = ((ImageView) S90(2131380639)).getLayoutParams();
        if (r160 != null) goto L403;
        r160 = null;
    L408:
        r159.setLayoutParams(r160);
        if (ja3.a.c(W90().getStaticState().a) == true) goto L467;
        int r161 = ECSdk.a;
        IECHostService r162 = (IECHostService) ECSdk.a(IECHostService.class);
        if (r162 == null) goto L414;
        IECAIHostService r163 = r162.getECHostAIService();
    L415:
        if (r163 == null) goto L467;
        if (r163.isInApplet() != true) goto L467;
        Context r164 = getContext();
        if (r164 != null) goto L425;
        View r165 = getView();
        if (r165 == null) goto L424;
        r164 = r165.getContext();
        goto L425
    L424:
        r164 = null;
    L425:
        if (r164 == null) goto L467;
        FrameLayout r166 = (FrameLayout) S90(2131380638);
        if (r166 == null) goto L467;
        ViewGroup.LayoutParams r167 = r166.getLayoutParams();
        if (r167 == null) goto L433;
        r167.height = com.bytedance.android.shopping.extensions.b.b(44) + r166.getPaddingTop();
        Unit r168 = Unit.INSTANCE;
    L434:
        r166.setLayoutParams(r167);
        wg.a.f(S90(2131380642), 0, 0, 0, com.bytedance.android.shopping.extensions.b.b(9));
        BackComponent r169 = r163.createBackComponent(r164);
        if (r169 == null) goto L467;
        r169.setScene("buy_now");
        r169.setOnClickListener(new m(this));
        View r170 = r169.getView();
        IECHostService r171 = (IECHostService) ECSdk.a(IECHostService.class);
        if (r171 == null) goto L439;
        IECAIHostService r172 = r171.getECHostAIService();
    L440:
        if (r172 != null) goto L442;
    L443:
        FrameLayout r173 = (FrameLayout) S90(2131380640);
        if (r173 == null) goto L467;
        ViewGroup.LayoutParams r174 = r173.getLayoutParams();
        if ((r174 instanceof ViewGroup.MarginLayoutParams) == true) goto L449;
        r174 = null;
    L449:
        ViewGroup.MarginLayoutParams r175 = (ViewGroup.MarginLayoutParams) r174;
        if (r175 == null) goto L452;
        r175.width = com.bytedance.android.shopping.extensions.b.b(60);
        r175.height = com.bytedance.android.shopping.extensions.b.b(60);
        r175.setMarginStart(0);
        r175.leftMargin = 0;
        r173.setLayoutParams(r175);
    L452:
        r173.setClipChildren(false);
        r173.setClipToPadding(false);
        ViewParent r176 = r170.getParent();
        if ((r176 instanceof ViewGroup) == true) goto L455;
        r176 = null;
    L455:
        ViewGroup r177 = (ViewGroup) r176;
        if (r177 == null) goto L458;
        r177.removeView(r170);
    L458:
        View r178 = this.F;
        if (r178 == null) goto L466;
        ViewParent r179 = r178.getParent();
        if ((r179 instanceof ViewGroup) == true) goto L463;
        r179 = null;
    L463:
        ViewGroup r180 = (ViewGroup) r179;
        if (r180 == null) goto L466;
        r180.removeView(r178);
    L466:
        this.F = r170;
        r173.removeAllViews();
        r173.addView(r170, new FrameLayout.LayoutParams(-1, -1));
        r173.setVisibility(0);
        goto L467
    L442:
        if (r172.isGoToLandingPage() == true) goto L467;
    L439:
        r172 = null;
        goto L440
    L433:
        r167 = null;
        goto L434
    L414:
        r163 = null;
    L467:
        View r181 = getView();
        if (r181 == null) goto L472;
        View r182 = r181.findViewById(2131379429);
        if (r182 == null) goto L472;
        r182.setClickable(true);
    L472:
        Lazy r183 = UIUtils.a;
        int r184 = r.a;
        UIUtils.g(r.b(requireContext(), this), "#FFFFFFFF");
        if (W90().getStaticState().c() == false) goto L475;
        r37 = 2131373142;
        W90().getSkuService().g(this.r, r.a(getContext(), this), (RecyclerView) S90(2131364334), (ViewGroup) S90(2131373142));
    L476:
        BuyNowLog.d("BuyNowFragment", "initView end");
        goto L477
    L475:
        r37 = 2131373142;
        goto L476
    L403:
        if (W90().getStaticState().m == true) goto L406;
        r110 = 24;
    L406:
        r160.width = SlcDimensExtensionsKt.a(Integer.valueOf(r110), W90().getBuyNowPageConfig().a());
        r160.height = SlcDimensExtensionsKt.a(Integer.valueOf(r110), W90().getBuyNowPageConfig().a());
        Unit r185 = Unit.INSTANCE;
        goto L408
    L399:
        r157 = null;
        goto L400
    L395:
        r154 = null;
        goto L396
    L389:
        if (fa0() == false) goto L391;
        ((FrameLayout) S90(2131381805)).setBackgroundColor(ColorProtector.parseColor("#F5F6F9"));
        goto L392
    L391:
        ((FrameLayout) S90(2131381805)).setBackgroundColor(Color.argb((int) 127.5d, 0, 0, 0));
    L384:
        if (W90().getStaticState().c() == false) goto L387;
    L372:
        r148 = 0;
    L361:
        th = move-exception;
        Result.Companion r186 = Result.Companion;
        r144 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L364
    L358:
        if (fa0() == false) goto L380;
    L349:
        jh.b.a r187 = jh.b.c;
        MonitorScenes r188 = MonitorScenes.FPS_SCENE_BUY_NOW_FULLSCREEN_SCREEN;
        r187.getClass();
        jh.b.a.b(r188).b(r133);
        goto L350
    L342:
        r130 = null;
        goto L343
    L317:
        if (W90().getStaticState().m == true) goto L319;
        this.o = new q(r.a(getContext(), this), S90(2131381866), S90(2131372607), new BuyNowFragment$initView$6(this));
        goto L319
    L311:
        r115 = null;
        goto L312
    L313:
        r210 = r104;
        goto L315
    L271:
        Context r189 = getContext();
        if (r189 == null) goto L303;
        RoundConstraintLayout r190 = S90(2131367761);
        if (r190 == null) goto L276;
        Drawable r191 = r190.getBackground();
    L278:
        if ((r191 instanceof BackgroundDrawable) == true) goto L280;
        r191 = null;
    L280:
        BackgroundDrawable r192 = (BackgroundDrawable) r191;
        if (r192 == null) goto L285;
        BackgroundDrawable r193 = r192.setBgColor(th.a.a(r189, 2131101874));
        if (r193 == null) goto L285;
        r193.invalidate();
        Unit r194 = Unit.INSTANCE;
    L285:
        RoundLinearLayout r195 = S90(2131379429);
        if (r195 == null) goto L288;
        Drawable r196 = r195.getBackground();
    L290:
        if ((r196 instanceof BackgroundDrawable) == true) goto L292;
        r196 = null;
    L292:
        BackgroundDrawable r197 = (BackgroundDrawable) r196;
        if (r197 == null) goto L297;
        BackgroundDrawable r198 = r197.setBgColor(th.a.a(r189, 2131101874));
        if (r198 == null) goto L297;
        r198.invalidate();
        Unit r199 = Unit.INSTANCE;
    L297:
        RecyclerView r200 = (BuyNowRecyclerView) S90(2131364334);
        if (r200 == null) goto L300;
        r200.setBackgroundColor(th.a.a(r189, 2131106784));
        Unit r201 = Unit.INSTANCE;
    L300:
        ConstraintLayout r202 = S90(2131374300);
        if (r202 == null) goto L303;
        r202.setBackgroundColor(th.a.a(r189, 2131106784));
        Unit r203 = Unit.INSTANCE;
        goto L303
    L288:
        r196 = null;
        goto L290
    L276:
        r191 = null;
        goto L278
    L192:
        r70 = null;
        goto L193
    L181:
        if (W90().getStaticState().b() == true) goto L186;
        if (ja3.a.d(W90().getStaticState().a) == true) goto L186;
        int r204 = com.bytedance.android.shopping.buynow.utils.b.a;
        if (com.bytedance.android.shopping.buynow.utils.b.a(W90()) == false) goto L195;
    L120:
        if (W90().getStaticState().b() == false) goto L139;
        RoundLinearLayout r205 = S90(2131379429);
        if (r205 == null) goto L145;
        RoundLinearLayout r206 = S90(2131379429);
        if (r206 == null) goto L136;
        ViewGroup.LayoutParams r207 = r206.getLayoutParams();
        if (r207 == null) goto L136;
        nl.c r208 = W90().getStaticState().a;
        if (r208 == null) goto L134;
        String r209 = r208.getQueryParam("height");
        if (r209 == null) goto L134;
        Integer r213 = ECHybridExtensionsKt.i(r209);
        if (r213 == null) goto L134;
        int r214 = r213.intValue();
    L135:
        r207.height = r214;
        Unit r215 = Unit.INSTANCE;
    L137:
        r205.setLayoutParams(r207);
    L134:
        r214 = r207.height;
    L136:
        r207 = null;
        goto L137
    L139:
        if (W90().getStaticState().a() == false) goto L145;
        View r216 = S90(2131381866);
        if (r216 == null) goto L145;
        ViewGroup.LayoutParams r217 = r216.getLayoutParams();
        if (r217 == null) goto L145;
        r217.height = -1;
        goto L145
    L64:
        if ((!Intrinsics.areEqual(r42, 1.0f)) == false) goto L74;
        RoundLinearLayout r218 = S90(2131379429);
        if (r218 == null) goto L145;
        RoundLinearLayout r219 = S90(2131379429);
        if (r219 == null) goto L72;
        ViewGroup.LayoutParams r220 = r219.getLayoutParams();
        if (r220 == null) goto L72;
        float r1100 = W90().getBuyNowPageConfig().a().a;
        Resources r221 = Resources.getSystem();
        r220.height = (int) ((((com.bytedance.android.shopping.buynow.utils.g.a(r35).b - k1.q()) - k1.g()) - com.bytedance.android.shopping.extensions.b.b(26)) - (com.bytedance.android.shopping.extensions.b.b(21) * (r1100 / WindowDisplayMetricsOverride.apply(r221, r221.getDisplayMetrics()).density)));
        Unit r222 = Unit.INSTANCE;
    L73:
        r218.setLayoutParams(r220);
    L72:
        r220 = null;
        goto L73
    L49:
        r32 = null;
        goto L50
    L27:
        r21 = null;
        goto L28
    L5:
        r2 = false;
        goto L6
    }

    public final <VM1 extends JediViewModel<S1>, S1 extends State, R> R withState(VM1 r2, Function1<? super S1, ? extends R> r3) {
        Intrinsics.checkNotNullParameter(r2, "viewModel1");
        Intrinsics.checkNotNullParameter(r3, "block");
        return (R) JediView.DefaultImpls.withState(this, r2, r3);
    }

    public final <M1 extends Middleware<S1, PROP1>, PROP1 extends State, S1 extends State, R> R withSubstate(Middleware<S1, PROP1> r2, Function1<? super PROP1, ? extends R> r3) {
        Intrinsics.checkNotNullParameter(r2, "middleware1");
        Intrinsics.checkNotNullParameter(r3, "block");
        return (R) JediView.DefaultImpls.withSubstate(this, r2, r3);
    }

    public final void ca0(boolean r12, boolean r13, com.bytedance.kmp.ec.yata.common.biz.callback.a r14) {
        Lazy r0 = BuyNowLog.a;
        BuyNowLog.d("BuyNowFragment", "onRequestStart " + r12 + ' ' + r13);
        String r1 = null;
        if (r13 == false) goto L11;
        ia3.b r2 = this.j;
        if (r2 == null) goto L49;
        SkeletonMode r4 = this.B;
        if (r4 != SkeletonMode.NORMAL) goto L9;
        boolean r5 = true;
    L10:
        r2.b(new ia3.c(true, r4, r5, true, !W90().getStaticState().c(), r14));
        goto L49
    L9:
        r5 = false;
    L49:
        BuyNowViewModel r15 = W90();
        if (r14 == null) goto L52;
        r1 = r14.c;
    L52:
        r15.trackRequestStartCheckPoint(r13, r1);
        return;
    L11:
        if (r14 == null) goto L13;
        String r3 = r14.c;
    L14:
        AndroidYaTaInstance r6 = W90().getYataInstance();
        if (r6 == null) goto L17;
        Object r7 = r6.i("delay_loading_map");
    L19:
        if ((r7 instanceof Map) == true) goto L21;
        r7 = null;
    L21:
        Map r8 = (Map) r7;
        if (r8 == null) goto L24;
        Object r9 = r8.get(r3);
    L26:
        if ((r9 instanceof Integer) == true) goto L28;
        r9 = null;
    L28:
        int r10 = com.bytedance.android.shopping.extensions.k.f((Integer) r9);
        if (r10 <= 0) goto L39;
        ia3.b r11 = this.j;
        if (r11 == null) goto L33;
        r11.b(new ia3.c(false, this.B, false, true, false, r14));
    L33:
        Disposable r16 = this.z;
        if (r16 == null) goto L36;
        r16.dispose();
    L36:
        Disposable r17 = Completable.timer(r10, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread()).subscribe(new e(this, r14));
        this.z = r17;
        if (r17 == null) goto L42;
        com.bytedance.android.ec.core.async.a.a(r17, this);
    L42:
        W90().setEditStartTime(System.currentTimeMillis());
        BuyNowViewModel r18 = W90();
        if (r14 == null) goto L45;
        String r19 = r14.c;
    L46:
        r18.setEditOperatorType(r19);
        if (this.E == true) goto L49;
        this.E = true;
        W90().getTracker().a(MapsKt.mapOf(TuplesKt.to("edited", "1")));
        goto L49
    L45:
        r19 = null;
        goto L46
    L39:
        ia3.b r20 = this.j;
        if (r20 == null) goto L42;
        r20.b(new ia3.c(false, this.B, false, true, true, r14));
        goto L42
    L24:
        r9 = null;
        goto L26
    L17:
        r7 = null;
        goto L19
    L13:
        r3 = null;
        goto L14
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131559215, r3, false);
    }

    public final <S extends State> Disposable subscribe(JediViewModel<S> r2, SubscriptionConfig<S> r3, Function2<? super IdentitySubscriber, ? super S, Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "$this$subscribe");
        Intrinsics.checkNotNullParameter(r3, "config");
        Intrinsics.checkNotNullParameter(r4, "subscriber");
        return JediView.DefaultImpls.subscribe(this, r2, r3, r4);
    }

    public final <VM1 extends JediViewModel<S1>, S1 extends State, VM2 extends JediViewModel<S2>, S2 extends State, R> R withState(VM1 r2, VM2 r3, Function2<? super S1, ? super S2, ? extends R> r4) {
        Intrinsics.checkNotNullParameter(r2, "viewModel1");
        Intrinsics.checkNotNullParameter(r3, "viewModel2");
        Intrinsics.checkNotNullParameter(r4, "block");
        return (R) JediView.DefaultImpls.withState(this, r2, r3, r4);
    }

    public final <M1 extends Middleware<S1, PROP1>, PROP1 extends State, S1 extends State, M2 extends Middleware<S2, PROP2>, PROP2 extends State, S2 extends State, R> R withSubstate(Middleware<S1, PROP1> r2, Middleware<S2, PROP2> r3, Function2<? super PROP1, ? super PROP2, ? extends R> r4) {
        Intrinsics.checkNotNullParameter(r2, "middleware1");
        Intrinsics.checkNotNullParameter(r3, "middleware2");
        Intrinsics.checkNotNullParameter(r4, "block");
        return (R) JediView.DefaultImpls.withSubstate(this, r2, r3, r4);
    }

    public final void da0(boolean r10, ma3.b r11, boolean r12, Throwable r13) {
        String r3 = null;
        if (r13 == null) goto L5;
        String r4 = RequestErrorType.CODE_ERROR;
    L16:
        if (r11 == null) goto L18;
        Integer r5 = r11.a();
    L19:
        if (r5 != null) goto L21;
        String r6 = null;
    L22:
        int r7 = r4.hashCode();
        if (r7 == (-1409607232)) goto L44;
        if (r7 == 120785050) goto L37;
        if (r7 == 852885499) goto L30;
    L50:
        com.bytedance.android.shopping.buynow.tracker.a r14 = W90().getTracker();
        String r15 = String.valueOf(System.currentTimeMillis());
        String r0 = com.bytedance.android.shopping.extensions.k.j(r6);
        if (r11 == null) goto L53;
        String r16 = r11.b();
    L54:
        String r17 = com.bytedance.android.shopping.extensions.k.j(r16);
        r14.getClass();
        Intrinsics.checkNotNullParameter(r15, "receiveTime");
        Intrinsics.checkNotNullParameter(r0, "statusCode");
        Intrinsics.checkNotNullParameter(r17, "statusMsg");
        Pair[] r8 = new Pair[5];
        nl.c r9 = r14.h.getStaticState().a;
        if (r9 == null) goto L57;
        r3 = r9.getQueryParam(PdpOpenThirdParam.KEY_PRODUCT_ID);
    L57:
        r8[0] = TuplesKt.to(PdpOpenThirdParam.KEY_PRODUCT_ID, com.bytedance.android.shopping.extensions.k.j(String.valueOf(r3)));
        r8[1] = TuplesKt.to("receive_time", r15);
        r8[2] = TuplesKt.to("statusCode", r0);
        r8[3] = TuplesKt.to("statusMsg", r17);
        r8[4] = TuplesKt.to("is_first", Integer.valueOf(com.bytedance.android.shopping.extensions.k.q(Boolean.valueOf(r12))));
        r14.b("order_load_abnormal", MapsKt.mutableMapOf(r8));
        return;
    L53:
        r16 = null;
        goto L54
    L30:
        if (r4.equals(RequestErrorType.CODE_ERROR) == false) goto L50;
        W90().setAvailability(0);
        com.bytedance.android.shopping.buynow.tracker.a r1 = W90().getTracker();
        if (r10 == false) goto L34;
        String r18 = "confirmOrderRender";
    L35:
        com.bytedance.android.shopping.buynow.monitor.error.a.d(r1, r18, r13);
        goto L50
    L34:
        r18 = "confirmOrderEdit";
        goto L35
    L37:
        if (r4.equals(RequestErrorType.NETWORK_ERROR) == false) goto L50;
        W90().setAvailability(0);
        com.bytedance.android.shopping.buynow.tracker.a r19 = W90().getTracker();
        if (r11 == null) goto L41;
        String r2 = com.bytedance.kmp.ec.yata.common.protocol.data.f.b(r11);
    L42:
        com.bytedance.android.shopping.buynow.monitor.error.a.c(r19, "network error", r6, r2, U90(r10));
        goto L50
    L41:
        r2 = null;
        goto L42
    L44:
        if (r4.equals(RequestErrorType.NO_YATA_DATA) == false) goto L50;
        W90().setAvailability(0);
        com.bytedance.android.shopping.buynow.tracker.a r110 = W90().getTracker();
        if (r11 == null) goto L48;
        String r20 = com.bytedance.kmp.ec.yata.common.protocol.data.f.b(r11);
    L49:
        com.bytedance.android.shopping.buynow.monitor.error.a.c(r110, "no yata_data", r6, r20, U90(r10));
        goto L50
    L48:
        r20 = null;
        goto L49
    L21:
        r6 = String.valueOf(r11.a());
        goto L22
    L18:
        r5 = null;
        goto L19
    L5:
        if (r11 == null) goto L7;
        Integer r21 = r11.a();
    L8:
        if (r21 != null) goto L11;
    L12:
        r4 = RequestErrorType.NETWORK_ERROR;
        goto L16
    L11:
        if (r21.intValue() != 0) goto L12;
        if (r11.i() != null) goto L59;
        r4 = RequestErrorType.NO_YATA_DATA;
        goto L16
    L59:
        return;
    L7:
        r21 = null;
        goto L8
    }

    public final <S extends State, A> Disposable selectSubscribe(JediViewModel<S> r2, KProperty1<S, ? extends A> r3, SubscriptionConfig<Tuple1<A>> r4, Function2<? super IdentitySubscriber, ? super A, Unit> r5) {
        Intrinsics.checkNotNullParameter(r2, "$this$selectSubscribe");
        Intrinsics.checkNotNullParameter(r3, "prop1");
        Intrinsics.checkNotNullParameter(r4, "config");
        Intrinsics.checkNotNullParameter(r5, "subscriber");
        return JediView.DefaultImpls.selectSubscribe(this, r2, r3, r4, r5);
    }

    public final <VM1 extends JediViewModel<S1>, S1 extends State, VM2 extends JediViewModel<S2>, S2 extends State, VM3 extends JediViewModel<S3>, S3 extends State, R> R withState(VM1 r2, VM2 r3, VM3 r4, Function3<? super S1, ? super S2, ? super S3, ? extends R> r5) {
        Intrinsics.checkNotNullParameter(r2, "viewModel1");
        Intrinsics.checkNotNullParameter(r3, "viewModel2");
        Intrinsics.checkNotNullParameter(r4, "viewModel3");
        Intrinsics.checkNotNullParameter(r5, "block");
        return (R) JediView.DefaultImpls.withState(this, r2, r3, r4, r5);
    }

    public final <M1 extends Middleware<S1, PROP1>, PROP1 extends State, S1 extends State, M2 extends Middleware<S2, PROP2>, PROP2 extends State, S2 extends State, M3 extends Middleware<S3, PROP3>, PROP3 extends State, S3 extends State, R> R withSubstate(Middleware<S1, PROP1> r2, Middleware<S2, PROP2> r3, Middleware<S3, PROP3> r4, Function3<? super PROP1, ? super PROP2, ? super PROP3, ? extends R> r5) {
        Intrinsics.checkNotNullParameter(r2, "middleware1");
        Intrinsics.checkNotNullParameter(r3, "middleware2");
        Intrinsics.checkNotNullParameter(r4, "middleware3");
        Intrinsics.checkNotNullParameter(r5, "block");
        return (R) JediView.DefaultImpls.withSubstate(this, r2, r3, r4, r5);
    }

    public final <S extends State, A, B> Disposable selectSubscribe(JediViewModel<S> r2, KProperty1<S, ? extends A> r3, KProperty1<S, ? extends B> r4, SubscriptionConfig<Tuple2<A, B>> r5, Function3<? super IdentitySubscriber, ? super A, ? super B, Unit> r6) {
        Intrinsics.checkNotNullParameter(r2, "$this$selectSubscribe");
        Intrinsics.checkNotNullParameter(r3, "prop1");
        Intrinsics.checkNotNullParameter(r4, "prop2");
        Intrinsics.checkNotNullParameter(r5, "config");
        Intrinsics.checkNotNullParameter(r6, "subscriber");
        return JediView.DefaultImpls.selectSubscribe(this, r2, r3, r4, r5, r6);
    }

    public final <VM1 extends JediViewModel<S1>, S1 extends State, VM2 extends JediViewModel<S2>, S2 extends State, VM3 extends JediViewModel<S3>, S3 extends State, VM4 extends JediViewModel<S4>, S4 extends State, R> R withState(VM1 r2, VM2 r3, VM3 r4, VM4 r5, Function4<? super S1, ? super S2, ? super S3, ? super S4, ? extends R> r6) {
        Intrinsics.checkNotNullParameter(r2, "viewModel1");
        Intrinsics.checkNotNullParameter(r3, "viewModel2");
        Intrinsics.checkNotNullParameter(r4, "viewModel3");
        Intrinsics.checkNotNullParameter(r5, "viewModel4");
        Intrinsics.checkNotNullParameter(r6, "block");
        return (R) JediView.DefaultImpls.withState(this, r2, r3, r4, r5, r6);
    }

    public final <M1 extends Middleware<S1, PROP1>, PROP1 extends State, S1 extends State, M2 extends Middleware<S2, PROP2>, PROP2 extends State, S2 extends State, M3 extends Middleware<S3, PROP3>, PROP3 extends State, S3 extends State, M4 extends Middleware<S4, PROP4>, PROP4 extends State, S4 extends State, R> R withSubstate(Middleware<S1, PROP1> r2, Middleware<S2, PROP2> r3, Middleware<S3, PROP3> r4, Middleware<S4, PROP4> r5, Function4<? super PROP1, ? super PROP2, ? super PROP3, ? super PROP4, ? extends R> r6) {
        Intrinsics.checkNotNullParameter(r2, "middleware1");
        Intrinsics.checkNotNullParameter(r3, "middleware2");
        Intrinsics.checkNotNullParameter(r4, "middleware3");
        Intrinsics.checkNotNullParameter(r5, "middleware4");
        Intrinsics.checkNotNullParameter(r6, "block");
        return (R) JediView.DefaultImpls.withSubstate(this, r2, r3, r4, r5, r6);
    }

    public final <S extends State, T> Disposable asyncSubscribe(JediViewModel<S> r2, KProperty1<S, ? extends Async<? extends T>> r3, SubscriptionConfig<Tuple1<Async<T>>> r4, Function2<? super IdentitySubscriber, ? super Throwable, Unit> r5, Function1<? super IdentitySubscriber, Unit> r6, Function2<? super IdentitySubscriber, ? super T, Unit> r7) {
        Intrinsics.checkNotNullParameter(r2, "$this$asyncSubscribe");
        Intrinsics.checkNotNullParameter(r3, "prop");
        Intrinsics.checkNotNullParameter(r4, "config");
        return JediView.DefaultImpls.asyncSubscribe(this, r2, r3, r4, r5, r6, r7);
    }

    public final void ba0(boolean r21, boolean r22, boolean r23, boolean r24, ma3.b r25, ma3.a r26) {
        String r6 = W90().getEditOperatorType();
        String r12 = "";
        boolean r14 = true;
        if (r24 == false) goto L5;
    L7:
        if (r22 == false) goto L21;
        SlcRenderContext r8 = this.r;
        if (r8 == null) goto L16;
        if (r25 == null) goto L15;
        String r9 = com.bytedance.kmp.ec.yata.common.protocol.data.f.b(r25);
        if (r9 == null) goto L15;
        r12 = r9;
    L15:
        r8.h = MapsKt.mapOf(TuplesKt.to("log_id", r12));
    L16:
        com.bytedance.android.shopping.sku.common.ability.b r10 = W90().getSkuService();
        if (r25 == null) goto L19;
        String r11 = com.bytedance.kmp.ec.yata.common.protocol.data.f.b(r25);
    L20:
        r10.s(r11);
        goto L21
    L19:
        r11 = null;
    L21:
        Lazy r13 = BuyNowLog.a;
        BuyNowLog.d("BuyNowFragment", "onRequestEnd " + r21 + ' ' + r22 + ' ' + r23);
        Disposable r15 = this.z;
        if (r15 == null) goto L25;
        r15.dispose();
    L25:
        if (W90().getStaticState().c() == false) goto L35;
        if (r23 == false) goto L35;
        com.bytedance.android.shopping.buynow.tracker.a r16 = W90().getTracker();
        int r17 = W90().getRetryCount();
        boolean r18 = W90().isAutoRetry();
        r16.getClass();
        if (r17 <= 0) goto L35;
        if (r22 == false) goto L32;
        String r19 = "skubuy_query_retry_success";
    L33:
        r16.b(r19, MapsKt.mapOf(new Pair[]{TuplesKt.to("retry_count", Integer.valueOf(r17)), TuplesKt.to("is_auto_retry", Boolean.valueOf(r18))}));
        goto L35
    L32:
        r19 = "skubuy_query_retry_failed";
    L35:
        if (r22 == true) goto L91;
        if (r23 == false) goto L91;
        if (getContext() != null) goto L40;
    L54:
        if (r25 == null) goto L57;
        la3.d r20 = r25.g();
        if (r20 == null) goto L57;
    L58:
        ia3.b r110 = this.j;
        if (r110 == null) goto L61;
        d r111 = new d(this, r20, r25);
        Intrinsics.checkNotNullParameter(r111, "callback");
        r110.e.setCallback(r111);
    L61:
        if (r25 == null) goto L64;
        la3.d r27 = r25.g();
        if (r27 == null) goto L64;
    L66:
        if (W90().getStaticState().c() == true) goto L69;
        int r112 = com.bytedance.android.shopping.buynow.utils.b.a;
        if (com.bytedance.android.shopping.buynow.utils.b.a(W90()) == true) goto L69;
    L75:
        ia3.b r113 = this.j;
        if (r113 != null) goto L78;
    L82:
        com.bytedance.android.shopping.buynow.tracker.a r7 = W90().getTracker();
        Pair[] r114 = new Pair[7];
        r114[0] = TuplesKt.to("title", r27.f());
        r114[1] = TuplesKt.to("desc", r27.d());
        r114[2] = TuplesKt.to("icon", r27.e());
        r114[3] = TuplesKt.to("button_name", r27.b());
        r114[4] = TuplesKt.to("button_action", r27.a());
        if (r25 == null) goto L85;
        Integer r28 = r25.a();
    L86:
        r114[5] = TuplesKt.to("status_code", r28);
        if (r25 == null) goto L89;
        String r29 = r25.b();
    L90:
        r114[6] = TuplesKt.to("status_msg", r29);
        r7.k(CheckPointType.ERROR_PAGE_SHOW, MapsKt.mutableMapOf(r114));
        W90().setPageStartupStatus(PageStartupStatus.PAGE_ERROR);
    L95:
        if (r22 == false) goto L101;
        BuyNowViewModel r30 = W90();
        if (r25 == null) goto L99;
        com.bytedance.kmp.ec.yata.common.protocol.data.c r31 = r25.i();
    L100:
        r30.updateTrackerCommonParams(r31, r23);
    L102:
        if (r23 == false) goto L116;
        W90().setPageStartupStatus(PageStartupStatus.RENDERING);
        com.bytedance.android.shopping.buynow.tracker.a r32 = W90().getTracker();
        if (r25 == null) goto L106;
        com.bytedance.kmp.ec.yata.common.protocol.data.c r33 = r25.i();
    L107:
        com.bytedance.android.shopping.sku.common.controller.a r115 = r32.h.getAsyncTwoStageController();
        if (r33 == null) goto L110;
        Map<String, ? extends Object> r34 = r33.g();
    L112:
        if (r115.a(r34, "page_view") == false) goto L114;
        com.bytedance.android.shopping.sku.common.controller.a r35 = r32.h.getAsyncTwoStageController();
        Map r36 = MapsKt.mapOf(TuplesKt.to("availability", r32.h.getAvailability()));
        r35.getClass();
        Intrinsics.checkNotNullParameter("page_view", "cacheKey");
        Intrinsics.checkNotNullParameter("page_view", "eventName");
        Intrinsics.checkNotNullParameter(r36, "params");
        r35.b.put("page_view", TuplesKt.to("page_view", r36));
    L115:
        BuyNowLog.d("BuyNowFragment", "onPageView");
        goto L116
    L114:
        r32.c("page_view", MapsKt.mapOf(TuplesKt.to("availability", r32.h.getAvailability())));
        goto L115
    L110:
        r34 = null;
        goto L112
    L106:
        r33 = null;
    L116:
        if (r22 == false) goto L170;
        if (r23 == false) goto L170;
        pa3.a r37 = this.w;
        if (r37 == null) goto L137;
        BuyNowFirstScreenMonitor r38 = r37.a;
        if (r38 == null) goto L137;
        MonitorScenes r39 = MonitorScenes.EC_PERF_PAGE_SHOW_BUY_NOW;
        if (r25 == null) goto L125;
        Integer r116 = r25.a();
    L126:
        int r117 = com.bytedance.android.shopping.extensions.k.f(r116);
        if (r25 == null) goto L129;
        String r118 = r25.b();
    L130:
        com.bytedance.android.shopping.extensions.k.j(r118);
        Intrinsics.checkNotNullParameter(r39, "scene");
        if (r117 == 0) goto L134;
        r38.d = true;
    L134:
        if (r38.f == true) goto L137;
        r38.f = true;
        goto L137
    L129:
        r118 = null;
        goto L130
    L125:
        r116 = null;
    L137:
        pa3.a r40 = this.w;
        if (r40 == null) goto L143;
        BuyNowFirstScreenMonitor r41 = r40.a;
        if (r41 == null) goto L143;
        r41.a(BuyNowFirstScreenNode.YATA_RENDER_START, System.currentTimeMillis());
    L143:
        if (W90().getStaticState().i == false) goto L150;
        AndroidYaTaInstance r42 = this.q;
        if (r42 == null) goto L161;
        if (r25 == null) goto L148;
        com.bytedance.kmp.ec.yata.common.protocol.data.c r43 = r25.i();
    L149:
        r42.x(r43, aa6.a.b.a.b, new com.bytedance.kmp.ec.yata.common.perf.d("biz_first_enter_has_used_cache"), null);
        goto L161
    L148:
        r43 = null;
    L161:
        if (W90().getStaticState().c() == true) goto L164;
        int r44 = com.bytedance.android.shopping.buynow.utils.b.a;
        if (com.bytedance.android.shopping.buynow.utils.b.a(W90()) == false) goto L170;
    L164:
        RoundConstraintLayout r45 = S90(2131367761);
        if (r45 == null) goto L167;
        r45.setVisibility(0);
    L167:
        YataPerfLinearLayout r46 = S90(2131386837);
        if (r46 == null) goto L170;
        r46.setVisibility(0);
        goto L170
    L150:
        AndroidYaTaInstance r47 = this.q;
        if (r47 == null) goto L161;
        if (r25 == null) goto L154;
        com.bytedance.kmp.ec.yata.common.protocol.data.c r48 = r25.i();
    L155:
        aa6.a.b.a r119 = aa6.a.b.a.b;
        com.bytedance.kmp.ec.yata.common.perf.d r120 = new com.bytedance.kmp.ec.yata.common.perf.d("biz_first_enter");
        if (r25 == null) goto L158;
        String r121 = com.bytedance.kmp.ec.yata.common.protocol.data.f.b(r25);
    L159:
        r47.x(r48, r119, r120, r121);
        goto L161
    L158:
        r121 = null;
        goto L159
    L154:
        r48 = null;
    L170:
        if (r24 == false) goto L185;
        if (r23 == false) goto L185;
        if (r22 == false) goto L185;
        pa3.a r1 = this.w;
        if (r1 == null) goto L185;
        BuyNowFirstScreenMonitor r2 = r1.a;
        if (r2 == null) goto L185;
        Map r49 = MapsKt.plus(W90().getTracker().d.c(), MapsKt.mapOf(TuplesKt.to("response_size", Integer.valueOf(W90().getStaticState().h))));
        Intrinsics.checkNotNullParameter(r49, "commonEventParams");
        Intrinsics.checkNotNullParameter(this, "fragment");
        Iterator r50 = r49.entrySet().iterator();
    L179:
        if (r50.hasNext() == false) goto L181;
        Map.Entry r51 = (Map.Entry) r50.next();
        r2.h.put((String) r51.getKey(), String.valueOf(r51.getValue()));
        goto L179
    L181:
        BtmSDK r52 = BtmSDK.INSTANCE;
        int r53 = com.bytedance.android.shopping.buynow.utils.c.a;
        Iterator r54 = r52.createReportParams(com.bytedance.android.shopping.buynow.utils.c.a(W90().getStaticState().g), PageFinder.via(this)).entrySet().iterator();
    L183:
        if (r54.hasNext() == false) goto L185;
        Map.Entry r55 = (Map.Entry) r54.next();
        r2.h.put((String) r55.getKey(), String.valueOf(r55.getValue()));
    L185:
        if (r23 == true) goto L200;
        if (r25 == null) goto L188;
        com.bytedance.kmp.ec.yata.common.protocol.data.c r3 = r25.i();
    L189:
        if (r3 != null) goto L200;
        if (r25 == null) goto L192;
        String r56 = r25.b();
    L193:
        if (r56 != null) goto L195;
    L198:
        if (r14 == false) goto L200;
        com.bytedance.android.shopping.buynow.utils.m.b("网络存在异常，请稍后重试");
        goto L200
    L195:
        if (r56.length() == 0) goto L198;
        r14 = false;
        goto L198
    L192:
        r56 = null;
        goto L193
    L188:
        r3 = null;
    L200:
        BuyNowViewModel.trackRequestEndCheckPoint$default(W90(), r22, r23, r25, r6, r26.b, null, 32, null);
        BuyNowLog.d("BuyNowFragment", "onRequestEnd finished");
        return;
    L99:
        r31 = null;
        goto L100
    L101:
        da0(r23, r25, r24, r26.a);
        goto L102
    L89:
        r29 = null;
        goto L90
    L85:
        r28 = null;
        goto L86
    L78:
        if (this.B != SkeletonMode.NORMAL) goto L80;
        boolean r57 = true;
    L81:
        r113.a(r27, new ia3.c(true, r57));
        goto L82
    L80:
        r57 = false;
    L69:
        RoundConstraintLayout r122 = S90(2131367761);
        if (r122 == null) goto L72;
        r122.setVisibility(4);
    L72:
        YataPerfLinearLayout r123 = S90(2131386837);
        if (r123 == null) goto L75;
        r123.setVisibility(4);
    L64:
        r27 = new la3.c();
    L57:
        r20 = new la3.c();
        goto L58
    L40:
        if (this.g == null) goto L54;
        if (this.G <= 0) goto L54;
        if (r26.a == null) goto L54;
        if (W90().getStaticState().c() == false) goto L54;
        Context r58 = getContext();
        if (r58 == null) goto L54;
        this.G--;
        W90().setAutoRetry(true);
        BuyNowViewModel r4 = W90();
        r4.setRetryCount(r4.getRetryCount() + 1);
        com.bytedance.android.shopping.buynow.starter.n r5 = this.g;
        if (r5 == null) goto L52;
        r5.i(r58, false);
    L52:
        da0(r23, r25, r24, r26.a);
        return;
    L91:
        if (r22 == true) goto L95;
        ia3.b r59 = this.j;
        if (r59 == null) goto L95;
        r59.c();
        goto L95
    L5:
        if (W90().getEditStartTime() <= 0) goto L7;
        long r124 = System.currentTimeMillis() - W90().getEditStartTime();
        com.bytedance.android.shopping.buynow.tracker.a r60 = W90().getTracker();
        String r61 = W90().getEditOperatorType();
        String r125 = W90().getStaticState().g;
        r60.getClass();
        Intrinsics.checkNotNullParameter(r125, "pageType");
        r60.b("ies_ecommerce_fe_custom_log", MapsKt.mapOf(new Pair[]{TuplesKt.to("type", "LATENCY_LOG"), TuplesKt.to("EVENT_PAGE_TECHNOLOGY", "YATA_Android"), TuplesKt.to("EVENT_ORIGIN_FEATURE", "TEMAI"), TuplesKt.to("btm", com.bytedance.android.shopping.buynow.utils.c.a(r125)), TuplesKt.to("api_path", "buynow_/order/yata/confirmOrderEdit"), TuplesKt.to("time_interval", Long.valueOf(r124)), TuplesKt.to("operator_type", r61)}));
        W90().setEditStartTime(0);
        W90().setEditOperatorType("");
        goto L7
    }

    public final <S extends State, A, B, C> Disposable selectSubscribe(JediViewModel<S> r2, KProperty1<S, ? extends A> r3, KProperty1<S, ? extends B> r4, KProperty1<S, ? extends C> r5, SubscriptionConfig<Tuple3<A, B, C>> r6, Function4<? super IdentitySubscriber, ? super A, ? super B, ? super C, Unit> r7) {
        Intrinsics.checkNotNullParameter(r2, "$this$selectSubscribe");
        Intrinsics.checkNotNullParameter(r3, "prop1");
        Intrinsics.checkNotNullParameter(r4, "prop2");
        Intrinsics.checkNotNullParameter(r5, "prop3");
        Intrinsics.checkNotNullParameter(r6, "config");
        Intrinsics.checkNotNullParameter(r7, "subscriber");
        return JediView.DefaultImpls.selectSubscribe(this, r2, r3, r4, r5, r6, r7);
    }

    public final <VM1 extends JediViewModel<S1>, S1 extends State, VM2 extends JediViewModel<S2>, S2 extends State, VM3 extends JediViewModel<S3>, S3 extends State, VM4 extends JediViewModel<S4>, S4 extends State, VM5 extends JediViewModel<S5>, S5 extends State, R> R withState(VM1 r2, VM2 r3, VM3 r4, VM4 r5, VM5 r6, Function5<? super S1, ? super S2, ? super S3, ? super S4, ? super S5, ? extends R> r7) {
        Intrinsics.checkNotNullParameter(r2, "viewModel1");
        Intrinsics.checkNotNullParameter(r3, "viewModel2");
        Intrinsics.checkNotNullParameter(r4, "viewModel3");
        Intrinsics.checkNotNullParameter(r5, "viewModel4");
        Intrinsics.checkNotNullParameter(r6, "viewModel5");
        Intrinsics.checkNotNullParameter(r7, "block");
        return (R) JediView.DefaultImpls.withState(this, r2, r3, r4, r5, r6, r7);
    }

    public final <M1 extends Middleware<S1, PROP1>, PROP1 extends State, S1 extends State, M2 extends Middleware<S2, PROP2>, PROP2 extends State, S2 extends State, M3 extends Middleware<S3, PROP3>, PROP3 extends State, S3 extends State, M4 extends Middleware<S4, PROP4>, PROP4 extends State, S4 extends State, M5 extends Middleware<S5, PROP5>, PROP5 extends State, S5 extends State, R> R withSubstate(Middleware<S1, PROP1> r2, Middleware<S2, PROP2> r3, Middleware<S3, PROP3> r4, Middleware<S4, PROP4> r5, Middleware<S5, PROP5> r6, Function5<? super PROP1, ? super PROP2, ? super PROP3, ? super PROP4, ? super PROP5, ? extends R> r7) {
        Intrinsics.checkNotNullParameter(r2, "middleware1");
        Intrinsics.checkNotNullParameter(r3, "middleware2");
        Intrinsics.checkNotNullParameter(r4, "middleware3");
        Intrinsics.checkNotNullParameter(r5, "middleware4");
        Intrinsics.checkNotNullParameter(r6, "middleware5");
        Intrinsics.checkNotNullParameter(r7, "block");
        return (R) JediView.DefaultImpls.withSubstate(this, r2, r3, r4, r5, r6, r7);
    }

    public final <S extends State, A, B, C, D> Disposable selectSubscribe(JediViewModel<S> r2, KProperty1<S, ? extends A> r3, KProperty1<S, ? extends B> r4, KProperty1<S, ? extends C> r5, KProperty1<S, ? extends D> r6, SubscriptionConfig<Tuple4<A, B, C, D>> r7, Function5<? super IdentitySubscriber, ? super A, ? super B, ? super C, ? super D, Unit> r8) {
        Intrinsics.checkNotNullParameter(r2, "$this$selectSubscribe");
        Intrinsics.checkNotNullParameter(r3, "prop1");
        Intrinsics.checkNotNullParameter(r4, "prop2");
        Intrinsics.checkNotNullParameter(r5, "prop3");
        Intrinsics.checkNotNullParameter(r6, "prop4");
        Intrinsics.checkNotNullParameter(r7, "config");
        Intrinsics.checkNotNullParameter(r8, "subscriber");
        return JediView.DefaultImpls.selectSubscribe(this, r2, r3, r4, r5, r6, r7, r8);
    }

    public final <S extends State, A, B, C, D, E> Disposable selectSubscribe(JediViewModel<S> r2, KProperty1<S, ? extends A> r3, KProperty1<S, ? extends B> r4, KProperty1<S, ? extends C> r5, KProperty1<S, ? extends D> r6, KProperty1<S, ? extends E> r7, SubscriptionConfig<Tuple5<A, B, C, D, E>> r8, Function6<? super IdentitySubscriber, ? super A, ? super B, ? super C, ? super D, ? super E, Unit> r9) {
        Intrinsics.checkNotNullParameter(r2, "$this$selectSubscribe");
        Intrinsics.checkNotNullParameter(r3, "prop1");
        Intrinsics.checkNotNullParameter(r4, "prop2");
        Intrinsics.checkNotNullParameter(r5, "prop3");
        Intrinsics.checkNotNullParameter(r6, "prop4");
        Intrinsics.checkNotNullParameter(r7, "prop5");
        Intrinsics.checkNotNullParameter(r8, "config");
        Intrinsics.checkNotNullParameter(r9, "subscriber");
        return JediView.DefaultImpls.selectSubscribe(this, r2, r3, r4, r5, r6, r7, r8, r9);
    }
}
