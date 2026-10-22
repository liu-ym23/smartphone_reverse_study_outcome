package com.bytedance.android.shopping.feed.fragment;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cf.p;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.BtmSDKWrapper;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.common.api.IECCommonService;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.legacy.AbsFragment;
import com.bytedance.android.ec.core.monitor.MonitorScenes;
import com.bytedance.android.ec.core.monitor.RecyclerViewPerformanceMonitor;
import com.bytedance.android.ec.core.monitor.q;
import com.bytedance.android.ec.core.opt.ab.m;
import com.bytedance.android.ec.core.opt.ab.n;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.g1;
import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.innerflow.jedi.JediBaseFragment;
import com.bytedance.android.ec.innerflow.jedi.LoadMoreRecyclerViewAdapter;
import com.bytedance.android.ec.model.inflowfeed.Promotion;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBaseStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductExtraStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.anchorv3.AnchorV3Param;
import com.bytedance.android.shopping.anchorv3.PageInternalFlowStyle;
import com.bytedance.android.shopping.anchorv3.repository.dto.InnerFlowPageStyleDTO;
import com.bytedance.android.shopping.anchorv3.repository.dto.PageStyle;
import com.bytedance.android.shopping.api.IEShoppingService;
import com.bytedance.android.shopping.api.anchorv3.ECLogExtraData;
import com.bytedance.android.shopping.api.anchorv3.ECUIParam;
import com.bytedance.android.shopping.buynow.data.model.BuyNowCloseMethod;
import com.bytedance.android.shopping.feed.adapter.ProductFeedAdapter;
import com.bytedance.android.shopping.feed.adapter.QuickDividerItemDecoration;
import com.bytedance.android.shopping.feed.adapter.VideoProductFeedSnapHelper$bindRecyclerView$1;
import com.bytedance.android.shopping.feed.adapter.VideoProductFeedSpanSizeLookup;
import com.bytedance.android.shopping.feed.banner.VideoProductFeedBanner;
import com.bytedance.android.shopping.feed.event.FeedProductEventTracker;
import com.bytedance.android.shopping.feed.event.c2;
import com.bytedance.android.shopping.feed.event.e2;
import com.bytedance.android.shopping.feed.event.i2;
import com.bytedance.android.shopping.feed.event.j1;
import com.bytedance.android.shopping.feed.event.n1;
import com.bytedance.android.shopping.feed.event.o1;
import com.bytedance.android.shopping.feed.event.y;
import com.bytedance.android.shopping.feed.model.InflowGuessFeedResponse;
import com.bytedance.android.shopping.feed.resourcecard.frequency.MallDivertShowJudge;
import com.bytedance.android.shopping.feed.resourcecard.viewholder.ResourceCardVH;
import com.bytedance.android.shopping.feed.utils.VideoProductFeedGCBlock;
import com.bytedance.android.shopping.feed.utils.d0;
import com.bytedance.android.shopping.feed.utils.r;
import com.bytedance.android.shopping.feed.utils.t;
import com.bytedance.android.shopping.feed.view.InnerFeedPageHeadWidget;
import com.bytedance.android.shopping.feed.view.InnerFeedPageRightWidget;
import com.bytedance.android.shopping.feed.view.bottombar.InflowFeedBottomBarView;
import com.bytedance.android.shopping.feed.viewholder.BaseProductFeedCardVH;
import com.bytedance.android.shopping.feed.viewholder.GuessULikeProductCardDetailVH;
import com.bytedance.android.shopping.feed.viewmodel.ProductFeedViewModel;
import com.bytedance.android.shopping.feed.widget.BaseCardDetailView;
import com.bytedance.android.shopping.feed.widget.BaseCardHeaderView;
import com.bytedance.android.shopping.feed.widget.InflowBottomCartView;
import com.bytedance.android.shopping.inflow.view.TopRoundRelativeLayout;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.android.shopping.track.TrackerProvider;
import com.bytedance.android.shopping.utils.e0;
import com.bytedance.apm.ApmAgent;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.crash.Npth;
import com.bytedance.jedi.arch.ISubscriber;
import com.bytedance.jedi.arch.lifecycleAwareLazy;
import com.bytedance.services.apm.api.EnsureManager;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import hl.o;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt;
import kotlin.reflect.KClass;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u001cB\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0007J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0007H\u0007J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\tH\u0007J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u000bH\u0007J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\rH\u0007J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u000fH\u0007J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0011H\u0007J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0013H\u0007J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0015H\u0007J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0016H\u0007J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0018H\u0007¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/shopping/feed/fragment/ProductFeedContentFragment;", "Lcom/bytedance/android/ec/innerflow/jedi/JediBaseFragment;", "Lje3/b;", "Lcom/bytedance/android/shopping/feed/event/y;", "event", "", "closePageEvent", "Lcom/bytedance/android/shopping/feed/event/n1;", "onRecommendUpdated", "Lcom/bytedance/android/shopping/feed/event/i2;", "onGetTopicProductInfo", "Ldh3/c;", "onGetSameProductId", "Lcom/bytedance/android/shopping/feed/event/j1;", "onMarketingMemberSuccess", "Lhl/o;", "onReserveCommodityInfo", "Lhl/g;", "onAddShopCartSuccess", "Lhl/h;", "onAddShopCartSuccessFromSku", "Lhl/b;", "Lqk/a;", "onCloseProductFeedPageEvent", "Lr83/c;", "onCloseProductFeedPageByMallEvent", "<init>", "()V", "a", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProductFeedContentFragment extends JediBaseFragment implements je3.b {
    public static final /* synthetic */ int I = 0;
    public final com.bytedance.android.shopping.feed.adapter.b A;
    public com.bytedance.android.shopping.feed.d B;
    public final b C;
    public final boolean D;
    public final boolean E;
    public final boolean F;
    public final boolean G;
    public p H;
    public final lifecycleAwareLazy g;
    public InnerFeedPageHeadWidget h;
    public InnerFeedPageRightWidget i;
    public TopRoundRelativeLayout j;
    public RecyclerView k;
    public View l;
    public ViewGroup m;
    public BaseCardDetailView n;
    public ProductFeedAdapter o;
    public int p;
    public String q;
    public boolean r;
    public boolean s;
    public com.bytedance.android.shopping.feed.viewmodel.b t;
    public com.bytedance.android.shopping.feed.view.d u;
    public boolean v;
    public boolean w;
    public boolean x;
    public Function0<Unit> y;
    public Function1<? super Integer, Unit> z;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ ProductFeedContentFragment a;

        public b(ProductFeedContentFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            ProductFeedContentFragment r3 = this.a;
            int r0 = ProductFeedContentFragment.I;
            if (r3.isDetached() == false) goto L5;
            return;
        L5:
            if (((AbsFragment) r3).e == false) goto L7;
            return;
        L7:
            if (r3.getActivity() == null) goto L16;
            com.bytedance.android.shopping.feed.view.d r4 = r3.u;
            if (r4 == null) goto L15;
            r4.close(false);
            return;
        L15:
            return;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ ProductFeedContentFragment a;

        public c(ProductFeedContentFragment r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ProductFeedContentFragment r0 = this.a;     // Catch: Throwable -> L13
            int r1 = ProductFeedContentFragment.I;     // Catch: Throwable -> L13
            if (r0.isDetached() == false) goto L5;
            return;
        L5:
            if (((AbsFragment) r0).e == false) goto L7;
            return;
        L7:
            if (r0.getActivity() == null) goto L21;
            com.bytedance.android.shopping.feed.view.d r2 = r0.u;     // Catch: Throwable -> L13
            if (r2 == null) goto L22;
            r2.close(false);     // Catch: Throwable -> L13
            return;
        L22:
            return;
        L21:
            return;
        L13:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L23;
            throw th;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ ProductFeedContentFragment a;
        public final /* synthetic */ qk.a b;

        public d(ProductFeedContentFragment r1, qk.a r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ProductFeedContentFragment r0 = this.a;     // Catch: Throwable -> L13
            boolean r1 = this.b.a;     // Catch: Throwable -> L13
            if (r0.isDetached() == false) goto L5;
            return;
        L5:
            if (((AbsFragment) r0).e == false) goto L7;
            return;
        L7:
            if (r0.getActivity() == null) goto L21;
            com.bytedance.android.shopping.feed.view.d r2 = r0.u;     // Catch: Throwable -> L13
            if (r2 == null) goto L22;
            r2.close(r1);     // Catch: Throwable -> L13
            return;
        L22:
            return;
        L21:
            return;
        L13:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L23;
            throw th;
        }
    }

    public static final class e<T> implements Observer {
        public final /* synthetic */ ProductFeedContentFragment a;

        public e(ProductFeedContentFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            if (((Boolean) r3).booleanValue() == false) goto L11;
            Context r4 = this.a.getContext();
            if (r4 == null) goto L7;
            int r0 = ae3.a.a;
            Intrinsics.checkNotNullParameter(r4, "context");
            ae3.a.a(r4, r4.getString(2131896503), 0);
        L7:
            Function1<? super Integer, Unit> r5 = this.a.z;
            if (r5 == null) goto L12;
            Unit r6 = (Unit) r5.invoke(3);
            return;
        L12:
            return;
        }
    }

    public static final class f<T> implements Observer {
        public final /* synthetic */ ProductFeedContentFragment a;

        public f(ProductFeedContentFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r1) {
            if (((Boolean) r1).booleanValue() == false) goto L8;
            Function0<Unit> r2 = this.a.y;
            if (r2 == null) goto L9;
            Unit r3 = (Unit) r2.invoke();
            return;
        L9:
            return;
        }
    }

    public static final class g<T> implements Observer {
        public final /* synthetic */ ProductFeedContentFragment a;

        public g(ProductFeedContentFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            Context r0 = this.a.getContext();
            UIUtils.displayToast(r0, (String) r3, 0);
        }
    }

    public static final class h<T> implements Observer {
        public final /* synthetic */ ProductFeedContentFragment a;

        public h(ProductFeedContentFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            Boolean r4 = (Boolean) r3;
            ProductFeedContentFragment r5 = this.a;
            com.bytedance.android.shopping.feed.d r0 = r5.B;
            if (r0 == null) goto L7;
            MutableLiveData<InflowGuessFeedResponse> r1 = r0.a;
            if (r1 == null) goto L7;
            r1.observe(r5, new com.bytedance.android.shopping.feed.fragment.d(this));
        L7:
            ProductFeedContentFragment r6 = this.a;
            com.bytedance.android.shopping.feed.d r2 = r6.B;
            if (r2 == null) goto L13;
            MutableLiveData<InflowGuessFeedResponse> r7 = r2.b;
            if (r7 == null) goto L14;
            r7.observe(r6, new com.bytedance.android.shopping.feed.fragment.e(this));
            return;
        L14:
            return;
        }
    }

    public static final class i implements Runnable {
        public final /* synthetic */ ProductFeedContentFragment a;

        public i(ProductFeedContentFragment r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.U90().loadMemberMarketingInfo();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final ProductFeedViewModel U90() {
        return (ProductFeedViewModel) this.g.getValue();
    }

    static {
        Lazy r0 = BtmSDKWrapper.a;
        BtmSDKWrapper.c(ProductFeedContentFragment.class, "a1.b7365");
    }

    public final void Y90() {
        TopRoundRelativeLayout r0 = this.j;
        if (r0 == null) goto L5;
        r0.setBorderRadius(0);
    L5:
        InnerFeedPageHeadWidget r1 = this.h;
        if (r1 == null) goto L8;
        r1.setVisibility(0);
    L8:
        this.A.g = true;
        X90(true, false);
        View r2 = this.l;
        if (r2 == null) goto L12;
        r2.setVisibility(8);
        return;
    }

    public final void Z90() {
        InnerFeedPageHeadWidget r0 = this.h;
        if (r0 == null) goto L5;
        r0.e();
    L5:
        int r1 = T90(getContext());
        TopRoundRelativeLayout r2 = this.j;
        if (r2 == null) goto L8;
        r2.setBorderRadius(r1);
    L8:
        View r3 = this.l;
        if (r3 == null) goto L11;
        r3.setVisibility(0);
    L11:
        this.v = true;
    }

    public final void aa0() {
        BaseCardDetailView r0 = this.n;
        if (r0 == null) goto L27;
        BaseCardHeaderView r1 = r0.getCardHeaderView();
        if (r1 == null) goto L28;
        VideoProductFeedBanner r2 = r1.b;
        if (r2.n == true) goto L29;
        com.bytedance.android.shopping.feed.banner.c r3 = r2.z;
        boolean r4 = r3.e;
        boolean r5 = false;
        if (r4 == false) goto L14;
        if (r4 == true) goto L12;
        return;
    L12:
        if (r3.f == false) goto L31;
        r3.f = false;
        r3.a();
        Message r6 = Message.obtain();
        r6.what = 1;
        r6.obj = Float.valueOf(r3.g);
        r3.a.sendMessage(r6);
        return;
    L31:
        return;
    L14:
        com.bytedance.android.shopping.feed.banner.c.a r7 = r3.d;
        if (r7 == null) goto L17;
        r7.a();
    L18:
        if (r5 == true) goto L21;
        return;
    L21:
        if (r3.e == true) goto L23;
    L25:
        r3.e = true;
        r3.a();
        Message r8 = Message.obtain();
        r8.what = 1;
        r8.obj = Float.valueOf(0.0f);
        r3.a.sendMessage(r8);
        return;
    L23:
        if (r3.f == true) goto L25;
        return;
    L17:
        r5 = true;
        goto L18
    L29:
        return;
    L28:
        return;
    }

    public ProductFeedContentFragment() {
        final KClass r0 = Reflection.getOrCreateKotlinClass(ProductFeedViewModel.class);
        final Function0<String> r1 = new ProductFeedContentFragment$$special$$inlined$viewModel$1(r0);
        final ProductFeedContentFragment$$special$$inlined$viewModel$2 r2 = ProductFeedContentFragment$$special$$inlined$viewModel$2.INSTANCE;
        this.g = new lifecycleAwareLazy(this, r1, new ProductFeedContentFragment$$special$$inlined$viewModel$3(this, r1, r0, r2));
        this.q = BuyNowCloseMethod.OTHERS;
        this.s = true;
        this.w = true;
        this.x = true;
        this.A = new com.bytedance.android.shopping.feed.adapter.b();
        this.C = new b(this);
        this.D = ld3.d.e(ld3.d.b());
        this.E = ld3.d.e(ld3.d.a());
        int r3 = ld3.c.a;
        int r4 = m.a;
        Object r5 = 0;
        boolean r6 = ECServiceManager.a;
        s83.g r7 = (s83.g) ECServiceManager.c(s83.g.class);
        if (r7 == null) goto L8;
        s83.a r8 = r7.q();
        if (r8 == null) goto L8;
        Object r9 = r8.e("ec_inflow_drop_frame_monitor");
        if (r9 == null) goto L8;
    L174:
        this.F = ld3.d.e(((Number) r9).intValue());
        int r10 = ld3.f.a;
        int r11 = com.bytedance.android.ec.core.opt.ab.p.a;
        Object r12 = Boolean.TRUE;
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L179
        jj4.b r14 = jj4.b.b;     // Catch: Throwable -> L179
        Object r15 = jj4.a.a("ecom_product_inflow_event_fix", Boolean.class, r12, false);     // Catch: Throwable -> L179
        if (r15 != null) goto L185;
        Intrinsics.throwNpe();     // Catch: Throwable -> L179
    L185:
        this.G = ((Boolean) r15).booleanValue();
        return;
    L179:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        Object r17 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r17) == true) goto L184;
        r12 = r17;
    L184:
        r15 = r12;
    L8:
        int r18 = n.a;
        int r19 = com.bytedance.android.ec.base.settings.a.a;
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L165
        Object r21 = null;
        Object r22 = com.bytedance.android.ec.base.settings.d.c.get("ec_inflow_drop_frame_monitor");     // Catch: Throwable -> L60
        if (r22 != null) goto L15;
    L57:
        Object r23 = null;
    L58:
        Object r24 = Result.constructor-impl(r23);     // Catch: Throwable -> L60
    L62:
        Throwable r25 = Result.exceptionOrNull-impl(r24);     // Catch: Throwable -> L165
        if (r25 == null) goto L66;
        EnsureManager.ensureNotReachHere(r25);     // Catch: Throwable -> L165
    L66:
        if (Result.isFailure-impl(r24) == false) goto L69;
        r24 = null;
    L69:
        if ((r24 instanceof Integer) == true) goto L71;
        r24 = null;
    L71:
        Integer r26 = (Integer) r24;     // Catch: Throwable -> L165
        if (r26 != null) goto L78;
        Object r27 = com.bytedance.android.ec.base.settings.d.a.get("ec_inflow_drop_frame_monitor");     // Catch: Throwable -> L165
        if ((r27 instanceof Integer) == true) goto L77;
        r27 = null;
    L77:
        r26 = (Integer) r27;     // Catch: Throwable -> L165
    L78:
        if (r26 == null) goto L80;
        r9 = r26;
        goto L174
    L80:
        int r28 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L165
        Object r29 = com.bytedance.android.ec.base.settings.d.c.get("ec_inflow_drop_frame_monitor");     // Catch: Throwable -> L130
        if (r29 != null) goto L85;
    L127:
        Object r30 = null;
    L128:
        Object r31 = Result.constructor-impl(r30);     // Catch: Throwable -> L130
    L132:
        Throwable r32 = Result.exceptionOrNull-impl(r31);     // Catch: Throwable -> L156
        if (r32 == null) goto L136;
        EnsureManager.ensureNotReachHere(r32);     // Catch: Throwable -> L156
    L136:
        if (Result.isFailure-impl(r31) == false) goto L139;
        r31 = null;
    L139:
        if ((r31 instanceof Integer) == true) goto L141;
        r31 = null;
    L141:
        Integer r33 = (Integer) r31;     // Catch: Throwable -> L156
        if (r33 == null) goto L144;
        r9 = r33;
    L163:
        com.bytedance.android.ec.base.settings.d.d("ec_inflow_drop_frame_monitor", r9);     // Catch: Throwable -> L165
        goto L174
    L144:
        IHybridHostService r34 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L156
        if (r34 == null) goto L147;
        Object r35 = r34.getHostABValue("ec_inflow_drop_frame_monitor", r5);     // Catch: Throwable -> L156
    L148:
        if (r35 != null) goto L150;
    L162:
        r9 = r5;
        goto L163
    L150:
        if ((r35 instanceof Integer) == false) goto L153;
        r21 = r35;
    L153:
        r9 = (Integer) r21;     // Catch: Throwable -> L156
        if (r9 != null) goto L163;
    L156:
        th = move-exception;
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L165
        r9 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L165
        Throwable r37 = Result.exceptionOrNull-impl(r9);     // Catch: Throwable -> L165
        if (r37 == null) goto L161;
        EnsureManager.ensureNotReachHere(r37);     // Catch: Throwable -> L165
    L161:
        if (Result.isFailure-impl(r9) == false) goto L163;
    L147:
        r35 = null;
        goto L148
    L85:
        if ((r29 instanceof Integer) == true) goto L87;
        Object r38 = null;
    L88:
        r30 = (Integer) r38;     // Catch: Throwable -> L130
        if (r30 != null) goto L128;
        if ((r29 instanceof Number) == false) goto L115;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L100;
        Float r39 = Float.valueOf(((Number) r29).floatValue());     // Catch: Throwable -> L130
        if ((r39 instanceof Integer) == true) goto L98;
        r39 = null;
    L98:
        r30 = (Integer) r39;     // Catch: Throwable -> L130
        goto L128
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L106;
        Double r40 = Double.valueOf(((Number) r29).doubleValue());     // Catch: Throwable -> L130
        if ((r40 instanceof Integer) == true) goto L104;
        r40 = null;
    L104:
        r30 = (Integer) r40;     // Catch: Throwable -> L130
        goto L128
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L109;
        r30 = Integer.valueOf(((Number) r29).intValue());     // Catch: Throwable -> L130
        goto L128
    L109:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L115;
        Long r41 = Long.valueOf(((Number) r29).longValue());     // Catch: Throwable -> L130
        if ((r41 instanceof Integer) == true) goto L113;
        r41 = null;
    L113:
        r30 = (Integer) r41;     // Catch: Throwable -> L130
    L115:
        if ((r29 instanceof JSONObject) == false) goto L117;
    L189:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L123
        Object r42 = SDKSettingsCacheManager.a().fromJson(r29.toString(), Integer.class);     // Catch: Throwable -> L123
        if ((r42 instanceof Integer) == true) goto L121;
        r42 = null;
    L121:
        Object r43 = Result.constructor-impl((Integer) r42);     // Catch: Throwable -> L123
    L125:
        r30 = r43;
        if (Result.isFailure-impl(r30) == false) goto L128;
    L123:
        th = move-exception;
        Result.Companion r44 = Result.Companion;     // Catch: Throwable -> L130
        r43 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L130
        goto L125
    L117:
        if ((r29 instanceof JSONArray) == false) goto L127;
    L87:
        r38 = r29;
    L130:
        th = move-exception;
        Result.Companion r45 = Result.Companion;     // Catch: Throwable -> L156
        r31 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L156
        goto L132
    L15:
        if ((r22 instanceof Integer) == true) goto L17;
        Object r46 = null;
    L18:
        r23 = (Integer) r46;     // Catch: Throwable -> L60
        if (r23 != null) goto L58;
        if ((r22 instanceof Number) == false) goto L45;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L30;
        Float r47 = Float.valueOf(((Number) r22).floatValue());     // Catch: Throwable -> L60
        if ((r47 instanceof Integer) == true) goto L28;
        r47 = null;
    L28:
        r23 = (Integer) r47;     // Catch: Throwable -> L60
        goto L58
    L30:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L36;
        Double r48 = Double.valueOf(((Number) r22).doubleValue());     // Catch: Throwable -> L60
        if ((r48 instanceof Integer) == true) goto L34;
        r48 = null;
    L34:
        r23 = (Integer) r48;     // Catch: Throwable -> L60
        goto L58
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L39;
        r23 = Integer.valueOf(((Number) r22).intValue());     // Catch: Throwable -> L60
        goto L58
    L39:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L45;
        Long r49 = Long.valueOf(((Number) r22).longValue());     // Catch: Throwable -> L60
        if ((r49 instanceof Integer) == true) goto L43;
        r49 = null;
    L43:
        r23 = (Integer) r49;     // Catch: Throwable -> L60
    L45:
        if ((r22 instanceof JSONObject) == false) goto L47;
    L187:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L53
        Object r50 = SDKSettingsCacheManager.a().fromJson(r22.toString(), Integer.class);     // Catch: Throwable -> L53
        if ((r50 instanceof Integer) == true) goto L51;
        r50 = null;
    L51:
        Object r51 = Result.constructor-impl((Integer) r50);     // Catch: Throwable -> L53
    L55:
        r23 = r51;
        if (Result.isFailure-impl(r23) == false) goto L58;
    L53:
        th = move-exception;
        Result.Companion r52 = Result.Companion;     // Catch: Throwable -> L60
        r51 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L60
        goto L55
    L47:
        if ((r22 instanceof JSONArray) == false) goto L57;
    L17:
        r46 = r22;
    L60:
        th = move-exception;
        Result.Companion r53 = Result.Companion;     // Catch: Throwable -> L165
        r24 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L165
    L165:
        th = move-exception;
        Result.Companion r54 = Result.Companion;
        Object r55 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r56 = Result.exceptionOrNull-impl(r55);
        if (r56 == null) goto L170;
        EnsureManager.ensureNotReachHere(r56);
    L170:
        if (Result.isFailure-impl(r55) == true) goto L173;
        r5 = r55;
    L173:
        r9 = r5;
        goto L174
    }

    public final boolean V90() {
        AnchorV3Param r0 = U90().m907getAnchorV3Param();
        if (r0 == null) goto L7;
        PromotionProductStruct r1 = r0.getCurrentPromotion();
        if (r1 == null) goto L7;
        return r1.isOnlyHeadImg();
    L7:
        return false;
    }

    public final void W90() {
        withState(U90(), new ProductFeedContentFragment$notifyListChanged$1(this));
    }

    public final void initBackground() {
        InnerFlowPageStyleDTO r0 = U90().getInnerFlowPageStyle();
        Integer r1 = null;
        if (r0 == null) goto L5;
        PageStyle r2 = r0.getPageStyle();
    L6:
        Context r3 = getContext();
        if (r3 != null) goto L9;
        return;
    L9:
        if (this.D == true) goto L11;
        if (r2 == null) goto L21;
        r1 = r2.getBgHighLight();
    L21:
        if (r1 != null) goto L24;
    L42:
        ViewGroup r4 = this.m;
        if (r4 == null) goto L57;
        int r5 = g1.a;
        r4.setBackground(new com.bytedance.android.shopping.feed.widget.d(g1.a.b(r3, 2131233536), new ColorDrawable(g1.a.a(r3, 2131106019))));
        return;
    L57:
        return;
    L24:
        if (r1.intValue() != 1) goto L42;
        AnchorV3Param r6 = U90().m907getAnchorV3Param();
        if (r6 != null) goto L28;
    L34:
        ViewGroup r7 = this.m;
        if (r7 == null) goto L37;
        int r8 = g1.a;
        r7.setBackgroundColor(g1.a.a(r3, 2131106019));
    L37:
        ViewGroup r9 = this.m;
        if (r9 == null) goto L54;
        Drawable r10 = r9.getBackground();
        if (r10 == null) goto L55;
        r10.setAlpha(0);
        return;
    L55:
        return;
    L54:
        return;
    L28:
        if (r6.isFullScreen() != true) goto L34;
        ViewGroup r11 = this.m;
        if (r11 == null) goto L51;
        Drawable r12 = r11.getBackground();
        if (r12 == null) goto L52;
        r12.setAlpha(255);
        return;
    L52:
        return;
    L51:
        return;
    L11:
        if (this.E == false) goto L15;
        ViewGroup r13 = this.m;
        if (r13 == null) goto L47;
        int r14 = g1.a;
        r13.setBackgroundColor(g1.a.a(r3, 2131102482));
        return;
    L47:
        return;
    L15:
        ViewGroup r15 = this.m;
        if (r15 == null) goto L49;
        int r16 = g1.a;
        r15.setBackgroundColor(g1.a.a(r3, 2131102483));
        return;
    L49:
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final void onDestroy() {
        super/*com.bytedance.android.ec.core.legacy.AbsFragment*/.onDestroy();
        FeedProductEventTracker r0 = FeedProductEventTracker.a;
        ProductFeedViewModel r1 = U90();
        String r2 = this.q;
        Context r3 = getContext();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "mViewModel");
        FeedProductEventTracker.q("inflow_commodity_duration", r1, r2, r3);
        FeedProductEventTracker.q("commodity_duration", r1, r2, r3);
        int r4 = if.a.a;
        EventBus.getDefault().post(new b53.a());
        s0.e(this);
        U90().getInnerGuessULikeFiltersHelper().b.clear();
        ProductFeedAdapter r5 = this.o;
        if (r5 != null) goto L5;
    L7:
        HashMap<String, Queue<View>> r6 = com.bytedance.android.shopping.feed.view.i.a;
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L10;
        boolean r7 = true;
    L11:
        if (r7 == false) goto L38;
        com.bytedance.android.shopping.feed.view.i.a.clear();
        if (com.bytedance.android.ec.core.anchorv3.c.a() == false) goto L15;
    L21:
        t.a = false;
        ECLiveHybridUtil.p("ecGetTagProductInfo", d0.b);
        ECLiveHybridUtil.p("closeInnerHalfPanel", xd3.a.a);
        d0.a.clear();
        U90().getAnchorV3ParamLiveData().removeObservers(this);
        Context r8 = getContext();
        if (r8 == null) goto L24;
        com.bytedance.android.ec.core.imagex.t.c(r8);
    L24:
        InnerFeedPageHeadWidget r9 = this.h;
        if (r9 == null) goto L33;
        int r10 = ECSdk.a;
        IEShoppingService r11 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r11 == null) goto L33;
        if (r11.shouldShowSaasCouponUrge() != true) goto L33;
        n83.j r12 = r9.r;
        if (r12 == null) goto L33;
        r12.b();
    L33:
        int r13 = ud3.f.a;
        dm.a.a("InnerFlowAdRequestHelper").i("resetSession");
        ud3.f.a = 0;
        ud3.f.b = 0;
        p r14 = this.H;
        if (r14 == null) goto L39;
        r14.onDestroy();
        return;
    L39:
        return;
    L15:
        if (com.bytedance.android.ec.core.anchorv3.c.g() == false) goto L21;
        int r15 = ECSdk.a;
        IEShoppingService r16 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r16 == null) goto L21;
        p83.d r17 = r16.getAnchorV3Service();
        if (r17 == null) goto L21;
        r17.e();
        goto L21
    L38:
        throw new IllegalStateException("only main thread can touch");
    L10:
        r7 = false;
        goto L11
    L5:
        if (ld3.b.b() == false) goto L7;
        com.bytedance.android.shopping.feed.a<ResourceCardVH> r18 = r5.B;
        r18.c = false;
        r18.a.clear();
        com.bytedance.android.shopping.feed.a<GuessULikeProductCardDetailVH> r19 = r5.A;
        r19.c = false;
        r19.a.clear();
        goto L7
    }

    public final void onPause() {
        super/*com.bytedance.android.ec.core.legacy.AbsFragment*/.onPause();
        U90().setInflowResume(false);
        BaseCardDetailView r0 = this.n;
        if (r0 == null) goto L9;
        BaseCardHeaderView r1 = r0.getCardHeaderView();
        if (r1 == null) goto L9;
        com.bytedance.android.shopping.feed.banner.c r2 = r1.b.z;
        if (r2.e == false) goto L9;
        r2.f = true;
        r2.a();
    L9:
        com.bytedance.android.shopping.monitor.d r3 = com.bytedance.android.shopping.monitor.d.h;
        ApmAgent.removePerfTag("e_commerce", "ec_product_feed_page");
        HashMap r4 = new HashMap();
        r4.put("e_commerce", "e_commerce_exit");
        Npth.addTags(r4);
        p r5 = this.H;
        if (r5 == null) goto L13;
        r5.onPause();
        return;
    }

    public final void onResume() {
        super/*com.bytedance.android.ec.core.legacy.AbsFragment*/.onResume();
        U90().setInflowResume(true);
        this.q = BuyNowCloseMethod.OTHERS;
        com.bytedance.android.shopping.feed.viewmodel.b r0 = this.t;
        if (r0 != null) goto L5;
    L10:
        aa0();
        com.bytedance.android.shopping.monitor.d r1 = com.bytedance.android.shopping.monitor.d.h;
        ApmAgent.addPerfTag("e_commerce", "ec_product_feed_page");
        com.bytedance.android.shopping.monitor.d.j("ec_product_feed_page");
        if (this.w == false) goto L13;
        U90().setResumeTime(System.currentTimeMillis());
        this.w = false;
    L14:
        p r2 = this.H;
        if (r2 == null) goto L18;
        r2.onResume();
        return;
    L18:
        return;
    L13:
        U90().getCartNum();
        goto L14
    L5:
        if (r0.a == false) goto L9;
        int r3 = r0.b + 1;
        if (r3 >= r0.d.size()) goto L9;
        ProductFeedViewModel r4 = r0.g;
        int r5 = com.bytedance.android.shopping.feed.utils.m.d;
        r4.loadGuessULike(true, com.bytedance.android.shopping.feed.utils.m.a.a(r0.e, r0.d.subList(0, r3)));
        r0.c = r0.b;
    L9:
        r0.a = false;
        goto L10
    }

    public final void onStart() {
        super/*androidx.fragment.app.Fragment*/.onStart();
        p r0 = this.H;
        if (r0 == null) goto L6;
        r0.onStart();
        return;
    }

    public final void onStop() {
        super/*com.bytedance.android.ec.core.legacy.AbsFragment*/.onStop();
        p r0 = this.H;
        if (r0 == null) goto L6;
        r0.onStop();
        return;
    }

    public final void onDetach() {
        super/*androidx.fragment.app.Fragment*/.onDetach();
    }

    public static int T90(Context r2) {
        if (r2 == null) goto L6;
        Resources r3 = r2.getResources();
        if (r3 == null) goto L6;
        return (int) r3.getDimension(2131166563);
    L6:
        Resources r0 = Resources.getSystem();
        return MathKt.roundToInt(TypedValue.applyDimension(1, 20, WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics())));
    }

    public final Pair<Object, RecyclerView.ViewHolder> S90(String r6) {
        ProductFeedAdapter r0 = this.o;
        int r1 = 0;
        RecyclerView.ViewHolder r2 = null;
        if (r0 == null) goto L42;
        List<? extends Object> r3 = r0.x;
        if (r3 == null) goto L42;
        Iterator<T> r4 = r3.iterator();
    L8:
        if (r4.hasNext() == false) goto L42;
        Object r5 = r4.next();
        if ((r5 instanceof PromotionProductStruct) == true) goto L12;
        Object r7 = null;
    L13:
        PromotionProductStruct r8 = (PromotionProductStruct) r7;
        if (r8 == null) goto L18;
        PromotionProductBaseStruct r9 = r8.getBaseInfo();
        if (r9 == null) goto L18;
        String r10 = r9.getPromotionId();
    L20:
        if (Intrinsics.areEqual(r10, r6) == false) goto L22;
    L39:
        boolean r11 = true;
    L40:
        if (r11 == false) goto L8;
    L43:
        ProductFeedAdapter r12 = this.o;
        if (r12 == null) goto L48;
        List<? extends Object> r13 = r12.x;
        if (r13 == null) goto L48;
        r1 = CollectionsKt.indexOf(r13, r5);
    L48:
        RecyclerView r14 = this.k;
        if (r14 == null) goto L52;
        r2 = r14.findViewHolderForAdapterPosition(r1);
    L52:
        return new Pair(r5, r2);
    L22:
        if ((r5 instanceof rd3.a) == true) goto L24;
        Object r15 = null;
    L25:
        rd3.a r16 = (rd3.a) r15;
        if (r16 == null) goto L34;
        Promotion r17 = r16.f();
        if (r17 == null) goto L34;
        PromotionProductStruct r18 = r17.getPromotionInfo();
        if (r18 == null) goto L34;
        PromotionProductBaseStruct r19 = r18.getBaseInfo();
        if (r19 == null) goto L34;
        String r20 = r19.getPromotionId();
    L36:
        if (Intrinsics.areEqual(r20, r6) == true) goto L39;
        r11 = false;
    L34:
        r20 = null;
        goto L36
    L24:
        r15 = r5;
    L18:
        r10 = null;
        goto L20
    L12:
        r7 = r5;
    L42:
        r5 = null;
        goto L43
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void closePageEvent(y r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        this.q = r2.a;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onAddShopCartSuccess(hl.g r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        PromotionProductStruct r0 = U90().getPromotion();
        if (r0 == null) goto L7;
        PromotionProductExtraStruct r1 = r0.getExtraInfo();
        if (r1 == null) goto L7;
        r1.setCartNum(r3.a);
    L7:
        InnerFeedPageHeadWidget r2 = this.h;
        if (r2 == null) goto L11;
        r2.c(r3);
        return;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onAddShopCartSuccessFromSku(hl.b r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        if (com.bytedance.android.ec.core.anchorv3.c.a() == false) goto L6;
        return;
    L6:
        if (com.bytedance.android.ec.core.anchorv3.c.g() == true) goto L8;
        return;
    L8:
        PromotionProductStruct r0 = U90().getPromotion();
        if (r0 == null) goto L13;
        PromotionProductExtraStruct r1 = r0.getExtraInfo();
        if (r1 == null) goto L13;
        r1.setCartNum(r5.a);
    L13:
        InnerFeedPageHeadWidget r2 = this.h;
        if (r2 == null) goto L16;
        r2.c(new hl.g(r5.a, true));
    L16:
        int r3 = ld3.c.a;
        String r4 = r5.k;
        if (r4 == null) goto L38;
        Pair<Object, RecyclerView.ViewHolder> r6 = S90(r4);
        Object r7 = r6.component1();
        RecyclerView.ViewHolder r8 = (RecyclerView.ViewHolder) r6.component2();
        if ((r8 instanceof BaseProductFeedCardVH) == true) goto L21;
        r8 = null;
    L21:
        BaseProductFeedCardVH r9 = (BaseProductFeedCardVH) r8;
        if (r9 == null) goto L33;
        BaseCardDetailView r10 = r9.r;
        if (r10 == null) goto L33;
        InflowFeedBottomBarView r11 = r10.getBottomBarView();
        if (r11 == null) goto L33;
        String r12 = r5.b;
        View r13 = r11.f.getChildAt(0);
        if ((r13 instanceof InflowBottomCartView) == true) goto L30;
        r13 = null;
    L30:
        InflowBottomCartView r14 = (InflowBottomCartView) r13;
        if (r14 == null) goto L33;
        r14.b(r12);
    L33:
        FeedProductEventTracker r15 = FeedProductEventTracker.a;
        Context r16 = getContext();
        if ((r7 instanceof rd3.a) == true) goto L36;
        r7 = null;
    L36:
        r15.getClass();
        FeedProductEventTracker.i(r16, (rd3.a) r7);
        return;
    }

    public final void onAttach(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super/*androidx.fragment.app.Fragment*/.onAttach(r2);
        U90().setCouponPageSchema(null);
        U90().setHalfScreenCouponPageSchema(null);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onCloseProductFeedPageByMallEvent(r83.c r4) {
        Intrinsics.checkNotNullParameter(r4, "event");
        dm.a.a("ProductFeedContentFragment").i("onCloseProductFeedPageByMallEvent: " + r4 + ", fragment isActive: " + ((AbsFragment) this).d);
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L10
        if (((AbsFragment) this).d == true) goto L8;
        View r6 = getView();     // Catch: Throwable -> L10
        if (r6 == null) goto L8;
        r6.post(new c(this));     // Catch: Throwable -> L10
    L8:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onCloseProductFeedPageEvent(qk.a r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        dm.a.a("ProductFeedContentFragment").i("onCloseProductFeedPageEvent: " + r5);
        View r0 = getView();
        if (r0 == null) goto L6;
        r0.postDelayed(new d(this, r5), 500);
        return;
    }

    public final void onCreate(Bundle r6) {
        super/*com.bytedance.android.ec.core.legacy.AbsFragment*/.onCreate(r6);
        Lazy r7 = BtmSDKWrapper.a;
        Bundle r8 = getArguments();
        String r1 = null;
        if (r8 == null) goto L5;
        Object r9 = r8.get("param_key");
    L7:
        if ((r9 instanceof AnchorV3Param) == true) goto L9;
        r9 = null;
    L9:
        AnchorV3Param r10 = (AnchorV3Param) r9;
        if (r10 == null) goto L12;
        String r11 = r10.getSourceBtmToken();
    L13:
        BtmSDKWrapper.b(this, "a1.b7365", r11);
        ProductFeedViewModel r12 = U90();
        Bundle r2 = getArguments();
        if (r2 == null) goto L16;
        Object r3 = r2.get("page_style");
    L18:
        if ((r3 instanceof InnerFlowPageStyleDTO) == true) goto L20;
        r3 = null;
    L20:
        r12.setInnerFlowPageStyle((InnerFlowPageStyleDTO) r3);
        Context r13 = getContext();
        if (r13 == null) goto L23;
        this.t = new com.bytedance.android.shopping.feed.viewmodel.b(r13, U90());
    L23:
        U90().isAutoExpandedLiveData().observe(this, new e(this));
        U90().setPreloadDataCenter(this.B);
        U90().getShowProductFeedDragGestureLiveData().observe(this, new f(this));
        U90().setFlowFragment(this);
        U90().getToastLiveData().observe(this, new g(this));
        U90().getFirstLoadingGuessULikeLiveData().observe(this, new h(this));
        Bundle r14 = getArguments();
        if (r14 == null) goto L26;
        Object r15 = r14.get("param_key");
    L28:
        if ((r15 instanceof AnchorV3Param) == true) goto L30;
        r15 = null;
    L30:
        AnchorV3Param r16 = (AnchorV3Param) r15;
        if (r16 == null) goto L42;
        ECUIParam r0 = r16.getUiParam();
        if (r0 == null) goto L39;
        int r4 = ECSdk.a;
        IECCommonService r5 = (IECCommonService) ECSdk.a(IECCommonService.class);
        if (r5 == null) goto L37;
        p r17 = r5.createPageStateListenerHelper(r0.getPageStateListenerId(), r0.getPageStateListenerExtra());
    L38:
        this.H = r17;
        goto L39
    L37:
        r17 = null;
    L39:
        U90().setAnchorV3Param(r16);
        Context r18 = getContext();
        if (r18 == null) goto L42;
        TrackerProvider.a r19 = TrackerProvider.Companion;
        int r20 = o1.b;
        o1 r21 = o1.a.a(r16, BtmSDK.INSTANCE.getPageId(PageFinder.via(this)));
        r19.getClass();
        TrackerProvider.a.a(r18, r21);
    L42:
        s0.c(this);
        Context r22 = getContext();
        if (r22 == null) goto L45;
        com.bytedance.android.ec.core.imagex.t.b(r22, U90().getImageCallerContext());
    L45:
        e0.a();
        p r23 = this.H;
        if (r23 == null) goto L48;
        r23.onCreate();
    L48:
        int r24 = ld3.f.a;
        int r25 = com.bytedance.android.ec.core.opt.ab.p.a;
        Object r26 = Boolean.TRUE;
        Result.Companion r27 = Result.Companion;     // Catch: Throwable -> L53
        jj4.b r28 = jj4.b.b;     // Catch: Throwable -> L53
        Object r29 = jj4.a.a("ecom_shop_video_inner_flow_btm_opt", Boolean.class, r26, false);     // Catch: Throwable -> L53
        if (r29 != null) goto L60;
        Intrinsics.throwNpe();     // Catch: Throwable -> L53
    L60:
        if (((Boolean) r29).booleanValue() == false) goto L84;
        BcmParams r30 = new BcmParams();
        AnchorV3Param r31 = U90().m907getAnchorV3Param();
        if (r31 == null) goto L71;
        String r32 = r31.getVideoId();
        if (r32 == null) goto L71;
        if (com.bytedance.android.shopping.anchorv3.a.b(r32) == true) goto L69;
        r32 = null;
    L69:
        if (r32 == null) goto L71;
        r30.put("video_id", r32);
    L71:
        AnchorV3Param r33 = U90().m907getAnchorV3Param();
        if (r33 == null) goto L80;
        String r34 = r33.getAuthorId();
        if (r34 == null) goto L80;
        if (com.bytedance.android.shopping.anchorv3.a.b(r34) == false) goto L78;
        r1 = r34;
    L78:
        if (r1 == null) goto L80;
        r30.put("author_id", r1);
    L80:
        BtmSDK.INSTANCE.setBcmPageParams(PageFinder.via(this), r30, false);
        return;
    L84:
        return;
    L53:
        th = move-exception;
        Result.Companion r35 = Result.Companion;
        Object r36 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r36) == true) goto L58;
        r26 = r36;
    L58:
        r29 = r26;
        goto L60
    L26:
        r15 = null;
        goto L28
    L16:
        r3 = null;
        goto L18
    L12:
        r11 = null;
        goto L13
    L5:
        r9 = null;
        goto L7
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onGetSameProductId(dh3.c r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        U90().getInnerGuessULikeFiltersHelper().c(r2.a);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onGetTopicProductInfo(i2 r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        U90().getInnerGuessULikeFiltersHelper().c(r2.a);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onMarketingMemberSuccess(j1 r4) {
        Intrinsics.checkNotNullParameter(r4, "event");
        dm.a.a("marketing_card").i("receive onMarketingMemberSuccess");
        View r5 = getView();
        if (r5 == null) goto L6;
        r5.postDelayed(new i(this), 2000);
        return;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onRecommendUpdated(n1 r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        com.bytedance.android.shopping.feed.viewmodel.b r3 = this.t;
        if (r3 == null) goto L6;
        r3.a = true;
        return;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onReserveCommodityInfo(o r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        final String r4 = r3.a;
        withState(U90(), new AnonymousClass1(this, r4));
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onAddShopCartSuccessFromSku(hl.h r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        int r0 = ld3.c.a;
        PromotionProductStruct r1 = U90().getPromotion();
        if (r1 == null) goto L7;
        PromotionProductExtraStruct r2 = r1.getExtraInfo();
        if (r2 == null) goto L7;
        r2.setCartNum(r5.a);
    L7:
        InnerFeedPageHeadWidget r3 = this.h;
        if (r3 == null) goto L10;
        r3.c(new hl.g(r5.a, r5.c));
    L10:
        Pair<Object, RecyclerView.ViewHolder> r4 = S90(r5.d);
        Object r6 = r4.component1();
        RecyclerView.ViewHolder r7 = (RecyclerView.ViewHolder) r4.component2();
        if ((r7 instanceof BaseProductFeedCardVH) == true) goto L13;
        r7 = null;
    L13:
        BaseProductFeedCardVH r8 = (BaseProductFeedCardVH) r7;
        if (r8 == null) goto L25;
        BaseCardDetailView r9 = r8.r;
        if (r9 == null) goto L25;
        InflowFeedBottomBarView r10 = r9.getBottomBarView();
        if (r10 == null) goto L25;
        String r11 = r5.b;
        View r12 = r10.f.getChildAt(0);
        if ((r12 instanceof InflowBottomCartView) == true) goto L22;
        r12 = null;
    L22:
        InflowBottomCartView r13 = (InflowBottomCartView) r12;
        if (r13 == null) goto L25;
        r13.b(r11);
    L25:
        FeedProductEventTracker r14 = FeedProductEventTracker.a;
        Context r15 = getContext();
        if ((r6 instanceof rd3.a) == true) goto L28;
        r6 = null;
    L28:
        r14.getClass();
        FeedProductEventTracker.i(r15, (rd3.a) r6);
    }

    public final void X90(boolean r11, boolean r12) {
        if (isDetached() == false) goto L5;
        return;
    L5:
        if (((AbsFragment) this).e == false) goto L7;
        return;
    L7:
        if (getActivity() != null) goto L10;
        return;
    L10:
        if (r11 == true) goto L12;
    L24:
        U90().isExpandedLiveData().setValue(Boolean.valueOf(r11));
        InnerFeedPageHeadWidget r2 = this.h;
        if (r2 == null) goto L94;
        r2.m = r11;
        if (r11 == true) goto L29;
        int r5 = ld3.c.a;
        ProductFeedViewModel r6 = r2.o;
        if (r6 == null) goto L84;
        InnerFlowPageStyleDTO r7 = r6.getInnerFlowPageStyle();
        if (r7 == null) goto L84;
        PageStyle r8 = r7.getPageStyle();
        if (r8 == null) goto L84;
        Integer r9 = r8.getHeaderCartDisplay();
    L85:
        if (r9 == null) goto L94;
        if (r9.intValue() != 1) goto L94;
        if (r2.j == true) goto L94;
        r2.j = true;
        String r3 = BtmSDK.INSTANCE.createBtmId(new BtmItemBuilder("a1.b7365.c0472.d8100", Boolean.FALSE).withView(r2.f).build());
        Context r4 = r2.getContext();
        if (r4 == null) goto L94;
        FeedProductEventTracker.N(FeedProductEventTracker.a, r4, r3, "half_screen", 2);
    L84:
        r9 = null;
        goto L85
    L29:
        if (r2.a.getVisibility() != 0) goto L31;
        boolean r10 = true;
    L33:
        if (r10 == true) goto L35;
    L37:
        ProductFeedViewModel r13 = r2.o;
        if (r13 == null) goto L44;
        InnerFlowPageStyleDTO r14 = r13.getInnerFlowPageStyle();
        if (r14 == null) goto L44;
        PageStyle r15 = r14.getPageStyle();
        if (r15 == null) goto L44;
        Integer r16 = r15.getHeaderMallDisplay();
    L45:
        if (r16 != null) goto L48;
    L60:
        ProductFeedViewModel r17 = r2.o;
        if (r17 == null) goto L67;
        InnerFlowPageStyleDTO r18 = r17.getInnerFlowPageStyle();
        if (r18 == null) goto L67;
        PageStyle r19 = r18.getPageStyle();
        if (r19 == null) goto L67;
        Integer r20 = r19.getHeaderCartDisplay();
    L68:
        if (r20 == null) goto L94;
        if (r20.intValue() != 1) goto L94;
        if (r2.i == true) goto L94;
        r2.i = true;
        String r21 = BtmSDK.INSTANCE.createBtmId(new BtmItemBuilder("a1.b7365.c0472.d8100", Boolean.FALSE).withView(r2.f).build());
        Context r22 = r2.getContext();
        if (r22 == null) goto L94;
        FeedProductEventTracker.N(FeedProductEventTracker.a, r22, r21, null, 10);
    L67:
        r20 = null;
        goto L68
    L48:
        if (r16.intValue() != 1) goto L60;
        if (r2.k == true) goto L60;
        String r23 = BtmSDK.INSTANCE.createBtmId(new BtmItemBuilder("a1.b7365.c0472.d7908", Boolean.FALSE).withView(r2.d).build());
        c2 r24 = new c2();
        r24.a = "product_flow_page_top";
        ProductFeedViewModel r25 = r2.o;
        if (r25 == null) goto L58;
        AnchorV3Param r26 = r25.m907getAnchorV3Param();
        if (r26 == null) goto L58;
        ECLogExtraData r27 = r26.getLogExtraData();
        if (r27 == null) goto L58;
        String r28 = r27.getEnterFrom();
    L59:
        r24.b = r28;
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        r24.appendParam("btm_id", r23, com.bytedance.android.ec.core.event.a.b.a.a);
        r24.post(null, null);
        r2.k = true;
    L58:
        r28 = null;
    L44:
        r16 = null;
        goto L45
    L35:
        if (r2.l == true) goto L37;
        String r29 = BtmSDK.INSTANCE.createBtmId(new BtmItemBuilder("a1.b7365.c0472.d0205", Boolean.FALSE).withView(r2.a).build());
        e2 r30 = new e2();
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        com.bytedance.android.ec.core.event.a.b.a.a r31 = com.bytedance.android.ec.core.event.a.b.a.a;
        r30.appendParam("btm_id", r29, r31);
        r30.appendParam(SimilarProductParam.ENTER_FROM, "ecom_video_product_inner", r31);
        r30.post(null, null);
        r2.l = true;
        goto L37
    L31:
        r10 = false;
    L94:
        com.bytedance.android.shopping.feed.adapter.b r32 = this.A;
        r32.g = r11;
        if (r11 == true) goto L102;
        boolean r33 = r32.e;
        if (r33 == false) goto L99;
        r32.f = r33;
    L99:
        r32.d.attachToRecyclerView(null);
        r32.e = false;
        RecyclerView r1 = r32.a;
        if (r1 == null) goto L102;
        r1.smoothScrollToPosition(0);
    L102:
        if (r12 == false) goto L109;
        p r110 = this.H;
        if (r110 == null) goto L110;
        r110.a(r11);
        return;
    L110:
        return;
    L109:
        return;
    L12:
        if (this.x == false) goto L24;
        this.x = false;
        FeedProductEventTracker r34 = FeedProductEventTracker.a;
        Context r35 = getContext();
        ProductFeedViewModel r36 = U90();
        ProductFeedAdapter r37 = this.o;
        if (r37 == null) goto L16;
        String r38 = r37.B2();
    L17:
        r34.getClass();
        FeedProductEventTracker.Q("slide_product_internal_flow_v2", r35, r36, r38);
        if (this.G == false) goto L24;
        Context r39 = getContext();
        ProductFeedViewModel r40 = U90();
        ProductFeedAdapter r41 = this.o;
        if (r41 == null) goto L22;
        String r42 = r41.B2();
    L23:
        r34.getClass();
        FeedProductEventTracker.Q("slide_product_internal_flow", r39, r40, r42);
        goto L24
    L22:
        r42 = null;
        goto L23
    L16:
        r38 = null;
        goto L17
    }

    public final void onViewCreated(View r18, Bundle r19) {
        Intrinsics.checkNotNullParameter(r18, FreqActions.ACTION_VIEW);
        super/*com.bytedance.android.ec.core.legacy.AbsFragment*/.onViewCreated(r18, r19);
        AnchorV3Param r2 = U90().m907getAnchorV3Param();
        boolean r11 = true;
        if (r2 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == false) goto L20;
        com.bytedance.android.shopping.feed.viewmodel.b r4 = this.t;
        if (r4 == null) goto L13;
        ProductFeedViewModel r5 = r4.g;
        int r6 = com.bytedance.android.shopping.feed.utils.m.d;
        r5.loadGuessULike(false, com.bytedance.android.shopping.feed.utils.m.a.a(r4.e, r4.d));
    L13:
        AnchorV3Param r7 = U90().m907getAnchorV3Param();
        if (r7 == null) goto L20;
        String r8 = r7.getFullPageMonitorName();
        if (r8 == null) goto L20;
        com.bytedance.android.ec.monitor.duration.d r9 = com.bytedance.android.ec.monitor.duration.i.a.get(r8);
        if (r9 == null) goto L20;
        r9.a("guess_u_like_api_start");
    L20:
        Intrinsics.checkNotNullParameter(r18, FreqActions.ACTION_VIEW);
        this.k = r18.findViewById(2131383144);
        this.h = (InnerFeedPageHeadWidget) r18.findViewById(2131383132);
        this.i = (InnerFeedPageRightWidget) r18.findViewById(2131383145);
        this.j = (TopRoundRelativeLayout) r18.findViewById(2131383126);
        this.l = r18.findViewById(2131383151);
        this.m = (ViewGroup) r18.findViewById(2131383141);
        if (ld3.b.b() == false) goto L23;
    L24:
        RecyclerView r0 = this.k;
        if (r0 == null) goto L27;
        r0.setItemViewCacheSize(0);
    L27:
        RecyclerView r1 = this.k;
        String r13 = null;
        if (r1 == null) goto L30;
        final ProductFeedAdapter r10 = new ProductFeedAdapter(U90(), r1, this);
        ((LoadMoreRecyclerViewAdapter) r10).p = new ProductFeedContentFragment$initRecyclerView$$inlined$let$lambda$1(r10, this);
    L31:
        this.o = r10;
        InnerFlowPageStyleDTO r12 = U90().getInnerFlowPageStyle();
        if (r12 == null) goto L34;
        r12.getPageStyle();
    L34:
        RecyclerView r14 = this.k;
        if (r14 == null) goto L55;
        r14.setItemAnimator(null);
        r14.setAdapter(this.o);
        ProductFeedAdapter r15 = this.o;
        if (r15 == null) goto L43;
        AnchorV3Param r16 = U90().m907getAnchorV3Param();
        if (r16 == null) goto L41;
        String r17 = r16.getMonitorName();
    L42:
        r15.C = r17;
        goto L43
    L41:
        r17 = null;
    L43:
        ProductFeedAdapter r20 = this.o;
        if (r20 == null) goto L50;
        AnchorV3Param r21 = U90().m907getAnchorV3Param();
        if (r21 == null) goto L48;
        String r22 = r21.getNewMonitorName();
    L49:
        r20.D = r22;
        goto L50
    L48:
        r22 = null;
    L50:
        GridLayoutManager r23 = new GridLayoutManager(r14.getContext(), 2);
        ProductFeedAdapter r24 = this.o;
        if (r24 == null) goto L53;
        r23.setSpanSizeLookup(new VideoProductFeedSpanSizeLookup(r24, U90().m907getAnchorV3Param()));
        r14.addItemDecoration(new QuickDividerItemDecoration(r24, new com.bytedance.android.shopping.feed.adapter.a(r24, U90())));
    L53:
        Unit r25 = Unit.INSTANCE;
        r14.setLayoutManager(r23);
    L55:
        if (V90() == true) goto L63;
        AnchorV3Param r26 = U90().m907getAnchorV3Param();
        if (r26 == null) goto L61;
        PromotionProductStruct r27 = r26.getCurrentPromotion();
        if (r27 == null) goto L61;
        boolean r28 = r27.isUseAnchorInfo();
    L62:
        if (r28 == true) goto L63;
    L66:
        RecyclerView r29 = this.k;
        if (r29 == null) goto L69;
        r29.addOnScrollListener(new VideoProductFeedGCBlock());
    L69:
        RecyclerView r30 = this.k;
        if (r30 == null) goto L72;
        r30.addOnScrollListener(new RecyclerViewPerformanceMonitor(MonitorScenes.EC_PRODUCT_FEED_PAGE));
    L72:
        RecyclerView r31 = this.k;
        if (r31 == null) goto L75;
        r31.addOnScrollListener(new ProductFeedContentFragment$initRecyclerView$4(this));
    L75:
        RecyclerView r32 = this.k;
        if (r32 == null) goto L78;
        r32.addOnScrollListener(new ProductFeedContentFragment$initRecyclerView$5(this));
    L78:
        RecyclerView r33 = this.k;
        if (r33 == null) goto L82;
        final com.bytedance.android.shopping.feed.adapter.b r34 = this.A;
        ProductFeedViewModel r35 = U90();
        r34.getClass();
        Intrinsics.checkNotNullParameter(r33, "recyclerView");
        Intrinsics.checkNotNullParameter(r35, "productFeedViewModel");
        r34.a = r33;
        r34.b = r35;
        r33.addOnScrollListener(new VideoProductFeedSnapHelper$bindRecyclerView$1(r34));
    L82:
        if (this.F == false) goto L87;
        q r36 = new q("ec_video_product_feed");
        RecyclerView r37 = this.k;
        if (r37 == null) goto L87;
        jh.b.c.getClass();
        jh.b.a.c(r36).c(r37);
    L87:
        if (V90() == true) goto L94;
        InnerFeedPageHeadWidget r38 = this.h;
        if (r38 == null) goto L91;
        r38.b(U90(), this.C);
    L91:
        InnerFeedPageRightWidget r39 = this.i;
        if (r39 == null) goto L94;
        r39.a(U90(), new com.bytedance.android.shopping.feed.fragment.b(this));
    L94:
        AnchorV3Param r40 = U90().m907getAnchorV3Param();
        if (r40 != null) goto L97;
    L99:
        Z90();
    L100:
        initBackground();
        U90().getAnchorV3ParamLiveData().observe(this, new com.bytedance.android.shopping.feed.fragment.c(this));
        ISubscriber.DefaultImpls.selectSubscribe$default(this, U90(), ProductFeedContentFragment$initScribe$1.INSTANCE, ProductFeedContentFragment$initScribe$2.INSTANCE, null, new ProductFeedContentFragment$initScribe$3(this), 4, null);
        ISubscriber.DefaultImpls.selectSubscribe$default(this, U90(), ProductFeedContentFragment$initScribe$4.INSTANCE, ProductFeedContentFragment$initScribe$5.INSTANCE, ProductFeedContentFragment$initScribe$6.INSTANCE, ProductFeedContentFragment$initScribe$7.INSTANCE, null, new ProductFeedContentFragment$initScribe$8(this), 16, null);
        ISubscriber.DefaultImpls.selectSubscribe$default(this, U90(), ProductFeedContentFragment$initScribe$9.INSTANCE, ProductFeedContentFragment$initScribe$10.INSTANCE, null, new ProductFeedContentFragment$initScribe$11(this), 4, null);
        ISubscriber.DefaultImpls.selectSubscribe$default(this, U90(), ProductFeedContentFragment$initScribe$12.INSTANCE, null, new ProductFeedContentFragment$initScribe$13(this), 2, null);
        ISubscriber.DefaultImpls.selectSubscribe$default(this, U90(), ProductFeedContentFragment$initScribe$14.INSTANCE, null, new ProductFeedContentFragment$initScribe$15(this), 2, null);
        ISubscriber.DefaultImpls.selectSubscribe$default(this, U90(), ProductFeedContentFragment$initScribe$16.INSTANCE, null, new ProductFeedContentFragment$initScribe$17(this), 2, null);
        ISubscriber.DefaultImpls.selectSubscribe$default(this, U90(), ProductFeedContentFragment$initScribe$18.INSTANCE, null, new ProductFeedContentFragment$initScribe$19(this), 2, null);
        ISubscriber.DefaultImpls.selectSubscribe$default(this, U90(), ProductFeedContentFragment$initScribe$20.INSTANCE, null, new ProductFeedContentFragment$initScribe$21(this), 2, null);
        ISubscriber.DefaultImpls.selectSubscribe$default(this, U90(), ProductFeedContentFragment$initScribe$22.INSTANCE, null, new ProductFeedContentFragment$initScribe$23(this), 2, null);
        ECLiveHybridUtil.m("ecGetTagProductInfo", d0.b);
        ECLiveHybridUtil.m("closeInnerHalfPanel", xd3.a.a);
        ECLiveHybridUtil.m("submit_orders_pay_result", r.b);
        AnchorV3Param r41 = U90().m907getAnchorV3Param();
        if (r41 == null) goto L106;
        PromotionProductStruct r42 = r41.getCurrentPromotion();
        if (r42 == null) goto L106;
        if (r42.isApiBack() == true) goto L106;
    L128:
        r11 = false;
    L129:
        if (r11 == false) goto L134;
        FeedProductEventTracker r43 = FeedProductEventTracker.a;
        Context r44 = getContext();
        AnchorV3Param r45 = U90().m907getAnchorV3Param();
        ProductFeedAdapter r46 = this.o;
        if (r46 == null) goto L133;
        r13 = r46.B2();
    L133:
        r43.getClass();
        FeedProductEventTracker.s(r44, r45, r13);
    L134:
        AnchorV3Param r47 = U90().m907getAnchorV3Param();
        if (r47 == null) goto L138;
        String r48 = r47.getVideoId();
        if (r48 == null) goto L138;
    L139:
        MallDivertShowJudge.h.getClass();
        MallDivertShowJudge r49 = MallDivertShowJudge.a.a();
        r49.getClass();
        Intrinsics.checkNotNullParameter(r48, "videoId");
        r49.e = r48;
        List<Function2<String, Float, Unit>> r50 = je3.a.a;
        Intrinsics.checkNotNullParameter(this, "page");
        Iterator r51 = ((ArrayList) je3.a.d).iterator();
    L141:
        if (r51.hasNext() == false) goto L145;
        if (Intrinsics.areEqual((je3.b) ((WeakReference) r51.next()).get(), this) == false) goto L141;
        return;
    L145:
        ((ArrayList) je3.a.d).add(new WeakReference(this));
        return;
    L138:
        r48 = "";
    L106:
        AnchorV3Param r52 = U90().m907getAnchorV3Param();
        if (r52 == null) goto L112;
        PromotionProductStruct r53 = r52.getCurrentPromotion();
        if (r53 == null) goto L112;
        if (r53.isPreload() == true) goto L128;
    L112:
        AnchorV3Param r54 = U90().m907getAnchorV3Param();
        if (r54 == null) goto L120;
        List r55 = r54.getPromotions();
        if (r55 == null) goto L120;
        PromotionProductStruct r56 = (PromotionProductStruct) CollectionsKt.getOrNull(r55, 0);
        if (r56 == null) goto L120;
        if (r56.isApiBack() == false) goto L128;
    L120:
        AnchorV3Param r57 = U90().m907getAnchorV3Param();
        if (r57 == null) goto L129;
        List r58 = r57.getPromotions();
        if (r58 == null) goto L129;
        PromotionProductStruct r59 = (PromotionProductStruct) CollectionsKt.getOrNull(r58, 0);
        if (r59 == null) goto L129;
        if (r59.isPreload() != true) goto L129;
    L97:
        if (r40.isFullScreen() != true) goto L99;
        Y90();
    L61:
        r28 = false;
    L63:
        RecyclerView r60 = this.k;
        if (r60 == null) goto L66;
        r60.setOnTouchListener(new com.bytedance.android.shopping.feed.fragment.a(this));
        goto L66
    L30:
        r10 = null;
        goto L31
    L23:
        if (ld3.b.a() == false) goto L27;
    L5:
        if (r2.getPageInternalFlowStyle() != PageInternalFlowStyle.PageInternalFlowStyleFirstCartTile.ordinal()) goto L8;
        r3 = false;
        goto L9
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        com.bytedance.android.shopping.monitor.d r5 = com.bytedance.android.shopping.monitor.d.h;
        ApmAgent.addPerfTag("e_commerce", "ec_product_feed_page");
        com.bytedance.android.shopping.monitor.d.j("ec_product_feed_page");
        if (this.D == false) goto L5;
        int r6 = 2131560626;
    L6:
        ShoppingAsyncInflater.a r7 = ShoppingAsyncInflater.e;
        Context r0 = requireContext();
        r7.getClass();
        return ShoppingAsyncInflater.a.a(r0).aU(r6, r3, false);
    L5:
        r6 = 2131560625;
        goto L6
    }
}
