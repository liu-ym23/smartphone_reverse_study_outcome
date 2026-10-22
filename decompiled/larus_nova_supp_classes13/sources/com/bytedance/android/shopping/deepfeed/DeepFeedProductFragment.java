package com.bytedance.android.shopping.deepfeed;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ProcessLifecycleOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.common.api.feedback.IECFeedbackService;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.monitor.MonitorScenes;
import com.bytedance.android.ec.core.monitor.fps.RealFpsMonitor;
import com.bytedance.android.ec.core.utils.k1;
import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.ec.hybrid.card.event.ECEventCenter;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.hybrid.monitor.HybridRecyclerViewPerformanceMonitor;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.shopping.buynow.data.model.PageScrollStatus;
import com.bytedance.android.shopping.deepfeed.data.DeepFeedProductDataCenter;
import com.bytedance.android.shopping.deepfeed.data.DeepFeedQueryParam;
import com.bytedance.android.shopping.deepfeed.data.repo.AbsDeepFeedRequest;
import com.bytedance.android.shopping.deepfeed.data.repo.DeepFeedAbValues;
import com.bytedance.android.shopping.deepfeed.data.repo.o;
import com.bytedance.android.shopping.deepfeed.event.DeepFeedCardStayCoordinator;
import com.bytedance.android.shopping.deepfeed.event.DeepFeedCardStayTracker;
import com.bytedance.android.shopping.deepfeed.event.DeepFeedProductEventTracker;
import com.bytedance.android.shopping.deepfeed.fold.DeepFeedFoldHelper;
import com.bytedance.android.shopping.deepfeed.slice.view.lottie.DeepFeedCouponLottieCache;
import com.bytedance.android.shopping.deepfeed.slice.view.video.DeepFeedSliceVideoView;
import com.bytedance.android.shopping.deepfeed.ui.DeepFeedProductAdapter;
import com.bytedance.android.shopping.deepfeed.ui.DeepFeedProductRecyclerview;
import com.bytedance.android.shopping.deepfeed.ui.DeepFeedProductSnapHelper;
import com.bytedance.android.shopping.deepfeed.ui.vh.AbsDeepFeedProductVH;
import com.bytedance.android.shopping.deepfeed.ui.vh.DeepFeedProductSlcVH;
import com.bytedance.android.shopping.deepfeed.ui.view.AdapterScreenHelp$Companion$createAdapterScreenByLife$1;
import com.bytedance.android.shopping.deepfeed.ui.view.DeepFeedProductView;
import com.bytedance.android.shopping.deepfeed.ui.view.DeepFeedTopBarManager;
import com.bytedance.android.shopping.deepfeed.utlis.DeepFeedFooterExitAnimator;
import com.bytedance.android.shopping.deepfeed.viewmodel.DeepFeedProductViewModel;
import com.bytedance.android.shopping.deepfeed.weights.DeepFeedFragmentView;
import com.bytedance.android.shopping.deepfeed.weights.DeepFeedProductHeaderView;
import com.bytedance.android.shopping.deepfeed.weights.DeepFeedProductInfoExtraView;
import com.bytedance.android.shopping.deepfeed.weights.n;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductPackData;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductPackDataElements;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductV2;
import com.bytedance.android.shopping.jedi.JediBaseFragment;
import com.bytedance.android.shopping.jedi.LoadMoreRecyclerViewAdapter;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.android.ui.ec.widget.loading.ECDuxLoadingAnimationView;
import com.bytedance.common.utility.Logger;
import com.bytedance.jedi.arch.ext.list.DiffableAdapter;
import com.bytedance.jedi.arch.lifecycleAwareLazy;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.bytedance.pitaya.api.PTYMessageHandler;
import com.bytedance.services.apm.api.EnsureManager;
import com.gyf.barlibrary.ImmersionBar;
import com.larus.apm.impl.protector.RunnableProtector;
import he3.l1;
import he3.p0;
import he3.q0;
import he3.z0;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\t\nB\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0007¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/DeepFeedProductFragment;", "Lcom/bytedance/android/shopping/jedi/JediBaseFragment;", "Lcom/bytedance/android/shopping/deepfeed/action/g;", "Lge3/a;", "event", "", "changeResetScroll", "<init>", "()V", "a", "PitayaMessageHandler", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DeepFeedProductFragment extends JediBaseFragment implements com.bytedance.android.shopping.deepfeed.action.g {
    public static final /* synthetic */ int k1 = 0;
    public final Function1<AbsDeepFeedProductVH, Unit> A;
    public final Function1<AbsDeepFeedProductVH, Unit> B;
    public final Lazy C;
    public final Lazy D;
    public boolean E;
    public final Lazy F;
    public com.bytedance.android.shopping.deepfeed.ui.view.g G;
    public Runnable H;
    public final Lazy H0;
    public com.bytedance.android.shopping.deepfeed.viewmodel.b I;
    public final b J;
    public final String K;
    public boolean L;
    public final com.bytedance.android.shopping.deepfeed.utlis.f L0;
    public final boolean M;
    public final boolean N;
    public View O;
    public View P;
    public final Function0<Unit> P0;
    public View Q;
    public final int[] R;
    public final int[] S;
    public OrientationHelper T;
    public int U;
    public int V;
    public final Lazy V0;
    public String W;
    public final Lazy X;
    public Runnable Y;
    public final Lazy Z;
    public final f b1;
    public final RealFpsMonitor g;
    public final DeepFeedProductFragment$onScrollListener$1 g1;
    public DeepFeedQueryParam h;
    public final Lazy h1;
    public final lifecycleAwareLazy i;
    public final Lazy j;
    public final com.bytedance.android.shopping.deepfeed.slice.e k;
    public final Lazy k0;
    public DeepFeedProductRecyclerview l;
    public final DeepFeedProductSnapHelper m;
    public DeepFeedProductAdapter n;
    public FrameLayout o;
    public boolean p;
    public com.bytedance.android.shopping.deepfeed.ui.c p0;
    public boolean q;
    public int r;
    public int s;
    public int t;
    public boolean u;
    public AbsDeepFeedProductVH v;
    public AbsDeepFeedProductVH w;
    public DeepFeedProductSlcVH x;
    public boolean y;
    public boolean z;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/DeepFeedProductFragment$PitayaMessageHandler;", "Lcom/bytedance/pitaya/api/PTYMessageHandler;", "viewModel", "Lcom/bytedance/android/shopping/deepfeed/viewmodel/DeepFeedProductViewModel;", "(Lcom/bytedance/android/shopping/deepfeed/viewmodel/DeepFeedProductViewModel;)V", "onMessage", "Lorg/json/JSONObject;", "message", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class PitayaMessageHandler implements PTYMessageHandler {
        private final DeepFeedProductViewModel viewModel;

        public PitayaMessageHandler(DeepFeedProductViewModel r2) {
            Intrinsics.checkNotNullParameter(r2, "viewModel");
            this.viewModel = r2;
        }

        public JSONObject onMessage(JSONObject r4) {
            Intrinsics.checkNotNullParameter(r4, "message");
            this.viewModel.dispatchPitayaAutoSlideEvent(r4.optInt("result", 0), r4.optString(PdpOpenThirdParam.KEY_PRODUCT_ID), r4.toString());
            return null;
        }
    }

    public static final class a {
    }

    public static final class b implements ViewTreeObserver.OnWindowFocusChangeListener {
        public final /* synthetic */ DeepFeedProductFragment a;

        public b(DeepFeedProductFragment r1) {
            this.a = r1;
        }

        @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
        public final void onWindowFocusChanged(boolean r2) {
            if (r2 == false) goto L5;
            DeepFeedProductFragment r3 = this.a;
            int r0 = DeepFeedProductFragment.k1;
            r3.Z90();
            return;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ DeepFeedProductFragment a;

        public c(DeepFeedProductFragment r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            DeepFeedProductFragment.S90(this.a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ DeepFeedProductFragment a;

        public d(DeepFeedProductFragment r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Runnable r0 = this.a.H;     // Catch: Throwable -> L7
            if (r0 == null) goto L5;
            r0.run();     // Catch: Throwable -> L7
        L5:
            this.a.H = null;     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }
    }

    public static final class e implements Runnable {
        public final /* synthetic */ com.bytedance.android.shopping.deepfeed.event.a a;
        public final /* synthetic */ boolean b;

        public e(com.bytedance.android.shopping.deepfeed.event.a r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            com.bytedance.android.shopping.deepfeed.event.a r0 = this.a;
            String r2 = null;
            if (this.b == true) goto L5;
            r0.f = null;
            r0.c();
            return;
        L5:
            com.bytedance.android.shopping.deepfeed.event.a.e r1 = r0.f;
            if (r1 != null) goto L9;
            return;
        L9:
            if ((SystemClock.elapsedRealtime() - r1.d) <= 5000) goto L11;
            r0.f = null;
            r0.c();
            return;
        L11:
            r1.g = true;
            com.bytedance.android.shopping.deepfeed.event.a.d r3 = r0.c;
            if (r3 != null) goto L14;
        L24:
            com.bytedance.android.shopping.deepfeed.event.a.d r4 = r0.c;
            if (r4 == null) goto L28;
            r2 = r4.n;
        L28:
            if ((!Intrinsics.areEqual(r2, "enter_detail")) == false) goto L33;
            r0.c();
            return;
        L33:
            return;
        L14:
            if (r3.m == true) goto L16;
        L18:
            boolean r5 = false;
        L19:
            if (r5 == true) goto L22;
            r3 = null;
        L22:
            if (r3 == null) goto L24;
            r0.e(r3, "enter_detail");
            goto L24
        L16:
            if (Intrinsics.areEqual(r3.n, "enter_detail") == false) goto L18;
            r5 = true;
            goto L19
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class f implements v83.a {
        public f() {
        }
    }

    static {
    }

    public final void X90() {
        this.p = true;
        this.r = this.s;
        DeepFeedProductRecyclerview r0 = this.l;
        if (r0 == null) goto L34;
        RecyclerView.LayoutManager r1 = r0.getLayoutManager();
        if (r1 == null) goto L35;
        View r2 = this.m.findSnapView(r1);
        if (r2 == null) goto L36;
        int r3 = r1.getPosition(r2);
        DeepFeedProductRecyclerview r4 = this.l;
        RecyclerView.ViewHolder r5 = null;
        if (r4 == null) goto L11;
        RecyclerView.ViewHolder r6 = r4.findViewHolderForAdapterPosition(r3);
    L13:
        if ((r6 instanceof AbsDeepFeedProductVH) == true) goto L15;
        r6 = null;
    L15:
        AbsDeepFeedProductVH r7 = (AbsDeepFeedProductVH) r6;
        if (r7 == null) goto L18;
        ka0(r7);
    L18:
        DeepFeedProductRecyclerview r8 = this.l;
        if (r8 == null) goto L21;
        RecyclerView.ViewHolder r9 = r8.findViewHolderForAdapterPosition(r3 + 1);
    L23:
        if ((r9 instanceof AbsDeepFeedProductVH) == false) goto L26;
        r5 = r9;
    L26:
        AbsDeepFeedProductVH r10 = (AbsDeepFeedProductVH) r5;
        this.w = r10;
        DeepFeedProductAdapter r11 = this.n;
        if (r11 == null) goto L29;
        r11.D2(r3, r7, false, false);
    L29:
        DeepFeedProductAdapter r12 = this.n;
        if (r12 == null) goto L32;
        r12.E2(r10);
    L32:
        fa0().b();
        return;
    L21:
        r9 = null;
        goto L23
    L11:
        r6 = null;
        goto L13
    L36:
        return;
    L35:
        return;
    }

    public final com.bytedance.android.shopping.deepfeed.action.b aa0() {
        return (com.bytedance.android.shopping.deepfeed.action.b) this.j.getValue();
    }

    public final com.bytedance.android.shopping.deepfeed.event.d ba0() {
        return (com.bytedance.android.shopping.deepfeed.event.d) this.F.getValue();
    }

    public final com.bytedance.android.shopping.deepfeed.event.a da0() {
        return (com.bytedance.android.shopping.deepfeed.event.a) this.k0.getValue();
    }

    public final Handler ea0() {
        return (Handler) this.C.getValue();
    }

    public final DeepFeedCardStayCoordinator fa0() {
        return (DeepFeedCardStayCoordinator) this.Z.getValue();
    }

    public final DeepFeedProductViewModel ga0() {
        return (DeepFeedProductViewModel) this.i.getValue();
    }

    public final void onDestroy() {
        this.y = false;
        aa0().getClass();
        DeepFeedCardStayTracker r1 = fa0().a();
        r1.i = false;
        AbsDeepFeedProductVH r2 = (AbsDeepFeedProductVH) r1.r.invoke();
        if (r2 == null) goto L5;
        r2.s4("exit");
    L5:
        r1.a("page_exit");
        if (r1.j == false) goto L9;
        ProcessLifecycleOwner.get().getLifecycle().removeObserver(r1.m);
        r1.j = false;
    L9:
        DeepFeedProductHeaderView.H0.clear();
        DeepFeedSliceVideoView.q.getClass();
        DeepFeedSliceVideoView.o.clear();
        ((LinkedHashMap) DeepFeedSliceVideoView.p).clear();
        com.bytedance.android.shopping.deepfeed.event.a r3 = da0();
        if (r3 == null) goto L12;
        r3.c();
        r3.f = null;
    L12:
        DeepFeedProductEventTracker r4 = ga0().getEventTracker();
        if (r4 == null) goto L21;
        com.bytedance.android.shopping.deepfeed.ui.c r5 = this.p0;
        if (r5 != null) goto L17;
    L19:
        String r6 = PageScrollStatus.slide;
    L20:
        Intrinsics.checkNotNullParameter(r6, "closeMethod");
        r4.doEventAction("close_inflow_page", new Pair[]{TuplesKt.to("close_method", r6)});
        goto L21
    L17:
        if (r5.o() != true) goto L19;
        r6 = "click";
    L21:
        long r8 = System.currentTimeMillis();
        Pair[] r7 = new Pair[1];
        DeepFeedQueryParam r9 = ga0().getFeedParam();
        if (r9 == null) goto L24;
        String r10 = r9.deepFeedFilters();
    L25:
        r7[0] = TuplesKt.to("filters", r10);
        ECEventCenter.c(new com.bytedance.android.ec.hybrid.card.event.b("ec.event.deepFeedFilters", r8, "ec_mall_deep_feed", false, MapsKt.mutableMapOf(r7), false, 40));
        int r11 = tc3.f.a;
        if ((!Intrinsics.areEqual(tc3.a.a().o(), Boolean.TRUE)) == true) goto L29;
        com.bytedance.android.ec.hybrid.a.d().submit(new k(new DeepFeedProductFragment$removePitayaListener$1(this)));
    L29:
        Runnable r12 = this.Y;
        if (r12 == null) goto L32;
        ea0().removeCallbacks(r12);
    L32:
        this.Y = null;
        super.onDestroy();
        s0.e(this);
        Lazy r13 = DeepFeedFoldHelper.a;
        DeepFeedFoldHelper.b(getActivity());
        ImmersionBar.with(this).destroy();
        this.L0.b();
        this.x = null;
        com.bytedance.android.shopping.deepfeed.ui.vh.l.f = false;
        com.bytedance.android.shopping.deepfeed.ui.vh.l.d = null;
        com.bytedance.android.shopping.deepfeed.ui.vh.l.e = null;
        com.bytedance.android.shopping.deepfeed.ui.vh.l.a.evictAll();
        com.bytedance.android.shopping.deepfeed.ui.vh.l.b.evictAll();
        com.bytedance.android.shopping.deepfeed.ui.vh.l.c.evictAll();
        com.bytedance.android.shopping.deepfeed.ui.view.a.e = null;
        com.bytedance.android.shopping.deepfeed.slice.e r0 = this.k;
        SlcRenderContext r14 = r0.a;
        if (r14 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("slcCtx");
    L35:
        r14.d();
        com.bytedance.android.ecom.slice.ext.template.gecko.c r15 = r0.b;
        if (r15 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("slcLoader");
    L38:
        r15.release();
        ((LinkedHashMap) r0.d).clear();
        return;
    L24:
        r10 = null;
        goto L25
    }

    public final boolean Y90() {
        DeepFeedProductAdapter r0 = this.n;
        if (r0 == null) goto L9;
        int[] r2 = new int[2];
        LoadMoreRecyclerViewAdapter.LoadMoreViewHolder r1 = r0.q;
        if (r1 == null) goto L11;
        View r3 = ((RecyclerView.ViewHolder) r1).itemView;
        if (r3 == null) goto L11;
        r3.getLocationOnScreen(r2);
    L11:
        if (r2 != null) goto L13;
        return false;
    L13:
        if (r2.length == 2) goto L15;
        return false;
    L15:
        if (r2[1] <= 0) goto L20;
        return true;
    L20:
        return false;
    L9:
        r2 = null;
        goto L11
    }

    public final void la0() {
        String r0 = ca0(this.V);
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.length() <= 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 != true) goto L14;
        int r2 = ECSdk.a;
        ca3.c r3 = (ca3.c) ECSdk.a(ca3.c.class);
        if (r3 == null) goto L15;
        r3.b("mall", CollectionsKt.listOf(r0), null);
        return;
    L15:
        return;
    L14:
        return;
    L7:
        r1 = false;
        goto L8
    }

    @Override // com.bytedance.android.shopping.deepfeed.action.g
    public final boolean mx() {
        ((dd3.b) this.V0.getValue()).getClass();
        dd3.d r0 = (dd3.d) this.H0.getValue();
        if (r0 == null) goto L7;
        r0.c();
        return false;
    L7:
        return false;
    }

    /* JADX WARN: Type inference failed for: r0v25, types: [com.bytedance.android.shopping.deepfeed.DeepFeedProductFragment$onScrollListener$1] */
    public DeepFeedProductFragment() {
        jh.b.a r0 = jh.b.c;
        MonitorScenes r1 = MonitorScenes.FPS_SCENE_MALL_DEEP_FEED;
        r0.getClass();
        this.g = jh.b.a.b(r1);
        final KClass r2 = Reflection.getOrCreateKotlinClass(DeepFeedProductViewModel.class);
        final Function0<String> r3 = new DeepFeedProductFragment$$special$$inlined$viewModel$1(r2);
        final DeepFeedProductFragment$$special$$inlined$viewModel$2 r4 = DeepFeedProductFragment$$special$$inlined$viewModel$2.INSTANCE;
        this.i = new lifecycleAwareLazy(this, r3, new DeepFeedProductFragment$$special$$inlined$viewModel$3(this, r3, r2, r4));
        this.j = LazyKt.lazy(new DeepFeedProductFragment$deepFeedContext$2(this));
        this.k = new com.bytedance.android.shopping.deepfeed.slice.e();
        this.m = new DeepFeedProductSnapHelper();
        boolean r5 = true;
        Object r6 = 1;
        this.p = true;
        this.u = this.q;
        this.A = new DeepFeedProductFragment$initCurCenterVH$1(this);
        this.B = new DeepFeedProductFragment$initCurCenterNextVH$1(this);
        this.C = LazyKt.lazy(DeepFeedProductFragment$mainHandler$2.INSTANCE);
        this.D = LazyKt.lazy(new DeepFeedProductFragment$netErrorHelp$2(this));
        this.E = true;
        this.F = LazyKt.lazy(DeepFeedProductFragment$deepFeedLoadingEvent$2.INSTANCE);
        this.J = new b(this);
        this.K = "DeepFeedProductFragment";
        int r7 = com.bytedance.android.ec.hybrid.tools.f.a;
        int r8 = com.bytedance.android.ec.base.settings.c.a;
        Object r9 = null;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L78
        Object r11 = com.bytedance.android.ec.base.settings.d.c.get("mall_deep_feed_load_more_dismiss");     // Catch: Throwable -> L53
        if (r11 != null) goto L8;
    L50:
        Object r12 = null;
    L51:
        Object r13 = Result.constructor-impl(r12);     // Catch: Throwable -> L53
    L55:
        Throwable r14 = Result.exceptionOrNull-impl(r13);     // Catch: Throwable -> L78
        if (r14 == null) goto L59;
        EnsureManager.ensureNotReachHere(r14);     // Catch: Throwable -> L78
    L59:
        if (Result.isFailure-impl(r13) == false) goto L62;
        r13 = null;
    L62:
        if ((r13 instanceof Integer) == true) goto L64;
        r13 = null;
    L64:
        Object r15 = (Integer) r13;     // Catch: Throwable -> L78
        if (r15 != null) goto L86;
        IHybridHostService r16 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L78
        if (r16 == null) goto L70;
        Object r17 = r16.getHostABValue("mall_deep_feed_load_more_dismiss", r6);     // Catch: Throwable -> L78
    L71:
        if (r17 != null) goto L73;
    L84:
        r15 = r6;
        goto L86
    L73:
        if ((r17 instanceof Integer) == true) goto L75;
        r17 = null;
    L75:
        r15 = (Integer) r17;     // Catch: Throwable -> L78
        if (r15 != null) goto L86;
    L70:
        r17 = null;
    L86:
        if (((Number) r15).intValue() != 1) goto L88;
        boolean r18 = true;
    L89:
        this.M = r18;
        int r19 = com.bytedance.android.ec.base.settings.a.a;
        Object r20 = com.bytedance.android.ec.base.settings.d.c.get("mall_deep_feed_rebuild_load_pack");     // Catch: Throwable -> L139
        if (r20 != null) goto L94;
    L136:
        Object r21 = null;
    L137:
        Object r22 = Result.constructor-impl(r21);     // Catch: Throwable -> L139
    L141:
        Throwable r23 = Result.exceptionOrNull-impl(r22);     // Catch: Throwable -> L245
        if (r23 == null) goto L145;
        EnsureManager.ensureNotReachHere(r23);     // Catch: Throwable -> L245
    L145:
        if (Result.isFailure-impl(r22) == false) goto L148;
        r22 = null;
    L148:
        if ((r22 instanceof Integer) == true) goto L150;
        r22 = null;
    L150:
        Object r24 = (Integer) r22;     // Catch: Throwable -> L245
        if (r24 != null) goto L157;
        Object r25 = com.bytedance.android.ec.base.settings.d.a.get("mall_deep_feed_rebuild_load_pack");     // Catch: Throwable -> L245
        if ((r25 instanceof Integer) == true) goto L156;
        r25 = null;
    L156:
        r24 = (Integer) r25;     // Catch: Throwable -> L245
    L157:
        if (r24 != null) goto L255;
        int r26 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L245
        Object r27 = com.bytedance.android.ec.base.settings.d.c.get("mall_deep_feed_rebuild_load_pack");     // Catch: Throwable -> L209
        if (r27 != null) goto L164;
    L206:
        Object r28 = null;
    L207:
        Object r29 = Result.constructor-impl(r28);     // Catch: Throwable -> L209
    L211:
        Throwable r30 = Result.exceptionOrNull-impl(r29);     // Catch: Throwable -> L235
        if (r30 == null) goto L215;
        EnsureManager.ensureNotReachHere(r30);     // Catch: Throwable -> L235
    L215:
        if (Result.isFailure-impl(r29) == false) goto L218;
        r29 = null;
    L218:
        if ((r29 instanceof Integer) == true) goto L220;
        r29 = null;
    L220:
        r24 = (Integer) r29;     // Catch: Throwable -> L235
        if (r24 != null) goto L243;
        IHybridHostService r31 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L235
        if (r31 == null) goto L226;
        Object r32 = r31.getHostABValue("mall_deep_feed_rebuild_load_pack", r6);     // Catch: Throwable -> L235
    L227:
        if (r32 != null) goto L229;
    L234:
        r24 = r6;
        goto L243
    L229:
        if ((r32 instanceof Integer) == false) goto L232;
        r9 = r32;
    L232:
        Object r33 = (Integer) r9;     // Catch: Throwable -> L235
        if (r33 == null) goto L234;
    L242:
        r24 = r33;
        goto L243
    L226:
        r32 = null;
    L243:
        com.bytedance.android.ec.base.settings.d.d("mall_deep_feed_rebuild_load_pack", r24);     // Catch: Throwable -> L245
        goto L255
    L164:
        if ((r27 instanceof Integer) == true) goto L166;
        Object r34 = null;
    L167:
        r28 = (Integer) r34;     // Catch: Throwable -> L209
        if (r28 != null) goto L207;
        if ((r27 instanceof Number) == false) goto L194;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L179;
        Float r35 = Float.valueOf(((Number) r27).floatValue());     // Catch: Throwable -> L209
        if ((r35 instanceof Integer) == true) goto L177;
        r35 = null;
    L177:
        r28 = (Integer) r35;     // Catch: Throwable -> L209
        goto L207
    L179:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L185;
        Double r36 = Double.valueOf(((Number) r27).doubleValue());     // Catch: Throwable -> L209
        if ((r36 instanceof Integer) == true) goto L183;
        r36 = null;
    L183:
        r28 = (Integer) r36;     // Catch: Throwable -> L209
        goto L207
    L185:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L188;
        r28 = Integer.valueOf(((Number) r27).intValue());     // Catch: Throwable -> L209
        goto L207
    L188:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L194;
        Long r37 = Long.valueOf(((Number) r27).longValue());     // Catch: Throwable -> L209
        if ((r37 instanceof Integer) == true) goto L192;
        r37 = null;
    L192:
        r28 = (Integer) r37;     // Catch: Throwable -> L209
    L194:
        if ((r27 instanceof JSONObject) == false) goto L196;
    L274:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L202
        Object r38 = SDKSettingsCacheManager.a().fromJson(r27.toString(), Integer.class);     // Catch: Throwable -> L202
        if ((r38 instanceof Integer) == true) goto L200;
        r38 = null;
    L200:
        Object r39 = Result.constructor-impl((Integer) r38);     // Catch: Throwable -> L202
    L204:
        r28 = r39;
        if (Result.isFailure-impl(r28) == false) goto L207;
    L202:
        th = move-exception;
        Result.Companion r40 = Result.Companion;     // Catch: Throwable -> L209
        r39 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L209
        goto L204
    L196:
        if ((r27 instanceof JSONArray) == false) goto L206;
    L166:
        r34 = r27;
    L235:
        th = move-exception;
        Result.Companion r41 = Result.Companion;     // Catch: Throwable -> L245
        r33 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L245
        Throwable r42 = Result.exceptionOrNull-impl(r33);     // Catch: Throwable -> L245
        if (r42 == null) goto L240;
        EnsureManager.ensureNotReachHere(r42);     // Catch: Throwable -> L245
    L240:
        if (Result.isFailure-impl(r33) == false) goto L242;
        r33 = r6;
    L209:
        th = move-exception;
        Result.Companion r43 = Result.Companion;     // Catch: Throwable -> L235
        r29 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L235
    L255:
        if (((Number) r24).intValue() == 1) goto L258;
        r5 = false;
    L258:
        this.N = r5;
        this.R = new int[2];
        this.S = new int[2];
        this.X = LazyKt.lazy(new DeepFeedProductFragment$pitayaMessageHandler$2(this));
        this.Z = LazyKt.lazy(new DeepFeedProductFragment$stayCoordinator$2(this));
        this.k0 = LazyKt.lazy(new DeepFeedProductFragment$gestureTrackCoordinator$2(this));
        this.H0 = LazyKt.lazy(DeepFeedProductFragment$deepFeedPopup$2.INSTANCE);
        this.L0 = new com.bytedance.android.shopping.deepfeed.utlis.f(new DeepFeedProductFragment$playerStateManager$1(this));
        this.P0 = new DeepFeedProductFragment$loadMoreListener$1(this);
        this.V0 = LazyKt.lazy(new DeepFeedProductFragment$deepFeedLynxContainer$2(this));
        this.b1 = new f();
        this.g1 = new DeepFeedProductFragment$onScrollListener$1(this);
        this.h1 = LazyKt.lazy(DeepFeedProductFragment$lottieJsons$2.INSTANCE);
        return;
    L94:
        if ((r20 instanceof Integer) == true) goto L96;
        Object r44 = null;
    L97:
        r21 = (Integer) r44;     // Catch: Throwable -> L139
        if (r21 != null) goto L137;
        if ((r20 instanceof Number) == false) goto L124;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L109;
        Float r45 = Float.valueOf(((Number) r20).floatValue());     // Catch: Throwable -> L139
        if ((r45 instanceof Integer) == true) goto L107;
        r45 = null;
    L107:
        r21 = (Integer) r45;     // Catch: Throwable -> L139
        goto L137
    L109:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L115;
        Double r46 = Double.valueOf(((Number) r20).doubleValue());     // Catch: Throwable -> L139
        if ((r46 instanceof Integer) == true) goto L113;
        r46 = null;
    L113:
        r21 = (Integer) r46;     // Catch: Throwable -> L139
        goto L137
    L115:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L118;
        r21 = Integer.valueOf(((Number) r20).intValue());     // Catch: Throwable -> L139
        goto L137
    L118:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L124;
        Long r47 = Long.valueOf(((Number) r20).longValue());     // Catch: Throwable -> L139
        if ((r47 instanceof Integer) == true) goto L122;
        r47 = null;
    L122:
        r21 = (Integer) r47;     // Catch: Throwable -> L139
    L124:
        if ((r20 instanceof JSONObject) == false) goto L126;
    L272:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L132
        Object r48 = SDKSettingsCacheManager.a().fromJson(r20.toString(), Integer.class);     // Catch: Throwable -> L132
        if ((r48 instanceof Integer) == true) goto L130;
        r48 = null;
    L130:
        Object r49 = Result.constructor-impl((Integer) r48);     // Catch: Throwable -> L132
    L134:
        r21 = r49;
        if (Result.isFailure-impl(r21) == false) goto L137;
    L132:
        th = move-exception;
        Result.Companion r50 = Result.Companion;     // Catch: Throwable -> L139
        r49 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L139
        goto L134
    L126:
        if ((r20 instanceof JSONArray) == false) goto L136;
    L96:
        r44 = r20;
    L245:
        th = move-exception;
        Result.Companion r51 = Result.Companion;
        Object r52 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r53 = Result.exceptionOrNull-impl(r52);
        if (r53 == null) goto L250;
        EnsureManager.ensureNotReachHere(r53);
    L250:
        if (Result.isFailure-impl(r52) == true) goto L253;
        r6 = r52;
    L253:
        r24 = r6;
    L139:
        th = move-exception;
        Result.Companion r54 = Result.Companion;     // Catch: Throwable -> L245
        r22 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L245
        goto L141
    L88:
        r18 = false;
        goto L89
    L8:
        if ((r11 instanceof Integer) == true) goto L10;
        Object r55 = null;
    L11:
        r12 = (Integer) r55;     // Catch: Throwable -> L53
        if (r12 != null) goto L51;
        if ((r11 instanceof Number) == false) goto L38;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L23;
        Float r56 = Float.valueOf(((Number) r11).floatValue());     // Catch: Throwable -> L53
        if ((r56 instanceof Integer) == true) goto L21;
        r56 = null;
    L21:
        r12 = (Integer) r56;     // Catch: Throwable -> L53
        goto L51
    L23:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L29;
        Double r57 = Double.valueOf(((Number) r11).doubleValue());     // Catch: Throwable -> L53
        if ((r57 instanceof Integer) == true) goto L27;
        r57 = null;
    L27:
        r12 = (Integer) r57;     // Catch: Throwable -> L53
        goto L51
    L29:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L32;
        r12 = Integer.valueOf(((Number) r11).intValue());     // Catch: Throwable -> L53
        goto L51
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L38;
        Long r58 = Long.valueOf(((Number) r11).longValue());     // Catch: Throwable -> L53
        if ((r58 instanceof Integer) == true) goto L36;
        r58 = null;
    L36:
        r12 = (Integer) r58;     // Catch: Throwable -> L53
    L38:
        if ((r11 instanceof JSONObject) == false) goto L40;
    L270:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L46
        Object r59 = SDKSettingsCacheManager.a().fromJson(r11.toString(), Integer.class);     // Catch: Throwable -> L46
        if ((r59 instanceof Integer) == true) goto L44;
        r59 = null;
    L44:
        Object r60 = Result.constructor-impl((Integer) r59);     // Catch: Throwable -> L46
    L48:
        r12 = r60;
        if (Result.isFailure-impl(r12) == false) goto L51;
    L46:
        th = move-exception;
        Result.Companion r61 = Result.Companion;     // Catch: Throwable -> L53
        r60 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L53
        goto L48
    L40:
        if ((r11 instanceof JSONArray) == false) goto L50;
    L10:
        r55 = r11;
    L53:
        th = move-exception;
        Result.Companion r62 = Result.Companion;     // Catch: Throwable -> L78
        r13 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L78
    L78:
        th = move-exception;
        Result.Companion r63 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r64 = Result.exceptionOrNull-impl(r15);
        if (r64 == null) goto L83;
        EnsureManager.ensureNotReachHere(r64);
    L83:
        if (Result.isFailure-impl(r15) == false) goto L86;
        goto L84
    }

    public final void Z90() {
        if (isResumed() == true) goto L5;
        return;
    L5:
        if (isHidden() == true) goto L16;
        View r0 = getView();
        if (r0 != null) goto L9;
        return;
    L9:
        if (r0.isShown() != true) goto L19;
        com.bytedance.android.shopping.deepfeed.viewmodel.b r1 = this.I;
        if (r1 == null) goto L18;
        this.I = null;
        ga0().refreshAfterCouponWaistReturn(r1);
        return;
    L18:
        return;
    L19:
        return;
    }

    public final boolean ia0() {
        DeepFeedQueryParam r0 = ga0().getFeedParam();
        if (r0 == null) goto L7;
        DeepFeedAbValues r1 = r0.getAbValues();
        if (r1 == null) goto L7;
        Boolean r2 = r1.getStyleOpt();
    L9:
        return Intrinsics.areEqual(r2, Boolean.TRUE);
    L7:
        r2 = null;
        goto L9
    }

    public final void onDestroyView() {
        View r0 = getView();
        if (r0 == null) goto L8;
        ViewTreeObserver r1 = r0.getViewTreeObserver();
        if (r1 == null) goto L8;
        r1.removeOnWindowFocusChangeListener(this.J);
    L8:
        if (da0() == null) goto L16;
        Object r2 = getView();
        if ((r2 instanceof DeepFeedFragmentView) == true) goto L12;
        r2 = null;
    L12:
        DeepFeedFragmentView r3 = (DeepFeedFragmentView) r2;
        if (r3 == null) goto L15;
        r3.setTouchObserver(null);
    L15:
        this.O = null;
        this.P = null;
        this.Q = null;
    L16:
        super.onDestroyView();
    }

    public final void onPause() {
        super.onPause();
        fa0().a().i = false;
        com.bytedance.android.shopping.deepfeed.event.a r0 = da0();
        if (r0 != null) goto L5;
    L7:
        DeepFeedProductRecyclerview r1 = this.l;
        if (r1 == null) goto L24;
        RecyclerView.LayoutManager r2 = r1.getLayoutManager();
        if (r2 == null) goto L24;
        View r3 = this.m.findSnapView(r2);
        if (r3 == null) goto L24;
        int r4 = r2.getPosition(r3);
        DeepFeedProductRecyclerview r5 = this.l;
        RecyclerView.ViewHolder r6 = null;
        if (r5 == null) goto L16;
        RecyclerView.ViewHolder r7 = r5.findViewHolderForAdapterPosition(r4);
    L18:
        if ((r7 instanceof AbsDeepFeedProductVH) == false) goto L21;
        r6 = r7;
    L21:
        AbsDeepFeedProductVH r8 = (AbsDeepFeedProductVH) r6;
        if (r8 == null) goto L24;
        r8.e4();
        goto L24
    L16:
        r7 = null;
    L24:
        boolean r9 = ECServiceManager.a;
        ((s83.g) ECServiceManager.c(s83.g.class)).o(this.b1);
        return;
    L5:
        if (r0.f != null) goto L7;
        r0.c();
        goto L7
    }

    public final void onResume() {
        super.onResume();
        DeepFeedCardStayTracker r0 = fa0().a();
        r0.i = true;
        if (r0.h == true) goto L5;
    L8:
        com.bytedance.android.shopping.deepfeed.action.d r1 = ga0().getActionHelper();
        if (r1 == null) goto L11;
        r1.d = false;
    L11:
        com.bytedance.android.shopping.deepfeed.event.a r2 = da0();
        RecyclerView.ViewHolder r3 = null;
        if (r2 == null) goto L31;
        com.bytedance.android.shopping.deepfeed.event.a.e r4 = r2.f;
        if (r4 == null) goto L31;
        if (r4.g == true) goto L20;
        r2.f = null;
        r2.c();
        goto L31
    L20:
        if (r2.o == false) goto L30;
        DeepFeedProductEventTracker r5 = (DeepFeedProductEventTracker) r2.n.invoke();
        if (r5 == null) goto L30;
        long r6 = r4.c;
        long r8 = System.currentTimeMillis();
        String r10 = r4.b;
        String r11 = r4.e;
        com.bytedance.android.shopping.deepfeed.event.a.b r7 = r4.f;
        if (r7 == null) goto L26;
        Map<? extends String, ? extends Object> r9 = com.bytedance.android.shopping.deepfeed.event.a.i(r7);
    L27:
        if (r9 != null) goto L29;
        r9 = MapsKt.emptyMap();
    L29:
        Intrinsics.checkNotNullParameter(r10, "enterType");
        Intrinsics.checkNotNullParameter(r11, "entryGestureType");
        Intrinsics.checkNotNullParameter(r9, "previousGesture");
        Map<String, ? extends Object> r12 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("enter_detail_time", Long.valueOf(r6)), TuplesKt.to("detail_back_time", Long.valueOf(r8)), TuplesKt.to("enter_type", r10), TuplesKt.to("entry_gesture_type", r11)});
        r12.putAll(r9);
        Unit r13 = Unit.INSTANCE;
        r5.doEventAction("ec_back_deep_feed", r12);
        goto L30
    L26:
        r9 = null;
    L30:
        r2.f = null;
        r2.c();
    L31:
        ga0().onResume();
        ea0().postDelayed(new d(this), 600);
        if (this.H != null) goto L50;
        DeepFeedProductRecyclerview r14 = this.l;
        if (r14 == null) goto L50;
        RecyclerView.LayoutManager r15 = r14.getLayoutManager();
        if (r15 == null) goto L50;
        View r16 = this.m.findSnapView(r15);
        if (r16 == null) goto L50;
        int r17 = r15.getPosition(r16);
        DeepFeedProductRecyclerview r18 = this.l;
        if (r18 == null) goto L42;
        RecyclerView.ViewHolder r19 = r18.findViewHolderForAdapterPosition(r17);
    L44:
        if ((r19 instanceof AbsDeepFeedProductVH) == false) goto L47;
        r3 = r19;
    L47:
        AbsDeepFeedProductVH r20 = (AbsDeepFeedProductVH) r3;
        if (r20 == null) goto L50;
        r20.f4();
        goto L50
    L42:
        r19 = null;
    L50:
        Z90();
        boolean r21 = ECServiceManager.a;
        ((s83.g) ECServiceManager.c(s83.g.class)).i0(this.b1);
        return;
    L5:
        if (r0.g == true) goto L8;
        r0.c();
        goto L8
    }

    public final void onStop() {
        com.bytedance.android.shopping.deepfeed.event.a r0 = da0();
        if (r0 != null) goto L5;
    L13:
        super.onStop();
        ga0().onStop();
        AbsDeepFeedProductVH r1 = this.v;
        if (r1 == null) goto L17;
        r1.g4();
        return;
    L17:
        return;
    L5:
        if (isRemoving() == true) goto L11;
        FragmentActivity r2 = getActivity();
        boolean r3 = true;
        if (r2 != null) goto L9;
    L12:
        ea0().post(new e(r0, r3));
        goto L13
    L9:
        if (r2.isFinishing() != true) goto L12;
    L11:
        r3 = false;
        goto L12
    }

    public static final void S90(DeepFeedProductFragment r4) {
        DeepFeedProductAdapter r0 = r4.n;
        boolean r1 = false;
        if (r0 == null) goto L11;
        List r2 = DiffableAdapter.DefaultImpls.getCurrentList(r0);
        if (r2 == null) goto L11;
        if (r2.isEmpty() == true) goto L11;
        boolean r3 = ha0(r2);
    L13:
        if (r3 == false) goto L19;
        AbsDeepFeedProductVH r5 = r4.v;
        if (r5 == null) goto L19;
        if (r5.m4() != true) goto L19;
        ((com.bytedance.android.shopping.deepfeed.ui.ability.a) r4.D.getValue()).c();
        return;
    L19:
        DeepFeedProductAdapter r6 = r4.n;
        if (r6 == null) goto L34;
        List r7 = DiffableAdapter.DefaultImpls.getCurrentList(r6);
        if (r7 == null) goto L34;
        if (r7.isEmpty() == true) goto L34;
        InFeedProductV2 r8 = (InFeedProductV2) CollectionsKt.firstOrNull(r7);
        if (r8 == null) goto L34;
        z0 r9 = r8.getRespExtra();
        if (r9 == null) goto L34;
        if (r9.a != true) goto L34;
        r1 = true;
    L34:
        if (r1 == true) goto L38;
        ((com.bytedance.android.shopping.deepfeed.ui.ability.a) r4.D.getValue()).c();
        return;
    L38:
        return;
    L11:
        r3 = false;
        goto L13
    }

    public static final boolean T90(DeepFeedProductFragment r1) {
        r1.getClass();
        return Intrinsics.areEqual(tc3.a.a().j(), Boolean.TRUE);
    }

    public static final boolean U90(DeepFeedProductFragment r1) {
        r1.getClass();
        return Intrinsics.areEqual(tc3.a.a().k(), Boolean.TRUE);
    }

    public static boolean ha0(List r1) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L11
        Iterator r2 = r1.iterator();     // Catch: Throwable -> L11
    L4:
        if (r2.hasNext() == false) goto L9;
        if (((InFeedProductV2) r2.next()).isSkeletonData() == false) goto L4;
        return true;
    L9:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L11
        return false;
    L11:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return false;
    }

    public final void V90(Map<String, Object> r8) {
        ga0().markNextCardSlideDown(true, r8);
        DeepFeedProductRecyclerview r9 = this.l;
        if (r9 == null) goto L22;
        Intrinsics.checkNotNullParameter(r9, "$this$smoothScrollToTop");
        RecyclerView.LayoutManager r0 = r9.getLayoutManager();
        if (r0 == null) goto L7;
        int r1 = r0.getChildCount();
    L9:
        if (r1 < 2) goto L28;
        View r3 = null;
        int r4 = 0;
    L11:
        if (r4 >= r1) goto L30;
        RecyclerView.LayoutManager r5 = r9.getLayoutManager();
        if (r5 == null) goto L21;
        View r6 = r5.getChildAt(r4);
        if (r6 == null) goto L21;
        if (r9.getChildAdapterPosition(r6) != 1) goto L20;
        if (r3 == null) goto L20;
        r9.smoothScrollBy(0, r3.getHeight());
        return;
    L20:
        r3 = r6;
    L21:
        r4 = r4 + 1;
        goto L11
    L30:
        return;
    L28:
        return;
    L7:
        r1 = 0;
        goto L9
    }

    public final String ca0(int r4) {
        DeepFeedProductAdapter r0 = this.n;
        if (r0 == null) goto L5;
        InFeedProductV2 r5 = (InFeedProductV2) DiffableAdapter.DefaultImpls.getItem(r0, r4, false);
    L6:
        if (r5 == null) goto L21;
        InFeedProductPackData r6 = r5.getPackData();
        if (r6 == null) goto L22;
        InFeedProductPackDataElements r7 = r6.getElements();
        if (r7 == null) goto L23;
        List<p0> r8 = r7.getProducts();
        if (r8 == null) goto L24;
        p0 r9 = (p0) CollectionsKt.firstOrNull(r8);
        if (r9 == null) goto L25;
        q0 r10 = r9.j();
        if (r10 == null) goto L26;
        l1 r11 = r10.a();
        if (r11 != null) goto L20;
        return null;
    L20:
        return r11.a();
    L26:
        return null;
    L25:
        return null;
    L24:
        return null;
    L23:
        return null;
    L22:
        return null;
    L21:
        return null;
    L5:
        r5 = null;
        goto L6
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void changeResetScroll(ge3.a r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        OrientationHelper r3 = this.T;
        if (r3 != null) goto L5;
        return;
    L5:
        if (this.q == false) goto L10;
        if (W90(this.v, r3) == false) goto L14;
        X90();
        return;
    L14:
        return;
    L10:
        if (W90(this.w, r3) == false) goto L16;
        X90();
        return;
    }

    public final void ka0(final AbsDeepFeedProductVH r5) {
        this.v = r5;
        r5.M = new DeepFeedProductFragment$onCurVHChange$1(this, r5);
        if (r5.l4() == false) goto L10;
        com.bytedance.android.shopping.deepfeed.ui.c r6 = this.p0;
        if (r6 == null) goto L8;
        r6.l(false);
    L8:
        if (this.E == false) goto L14;
        com.bytedance.android.shopping.deepfeed.event.d r7 = ba0();
        r7.getClass();
        r7.a = System.currentTimeMillis();
        ga0().loadFeed(false);
        ea0().postDelayed(new c(this), 3000);
        this.E = false;
        return;
    L14:
        return;
    L10:
        com.bytedance.android.shopping.deepfeed.ui.c r8 = this.p0;
        if (r8 == null) goto L16;
        r8.l(true);
        return;
    }

    /* JADX WARN: Type inference failed for: r4v6, types: [android.view.ViewGroup, com.bytedance.android.shopping.deepfeed.weights.DeepFeedProductInfoExtraView] */
    public final void na0(boolean r4) {
        DeepFeedProductRecyclerview r0 = this.l;
        if (r0 == null) goto L22;
        RecyclerView.LayoutManager r1 = r0.getLayoutManager();
        if (r1 == null) goto L23;
        ConstraintLayout r2 = this.m.findSnapView(r1);
        if (r2 == null) goto L24;
        ma0(r1, r2, true, r4);
        fa0().b();
        la0();
        if (tc3.f.b() == true) goto L11;
        return;
    L11:
        if ((r2 instanceof DeepFeedProductView) == true) goto L13;
        r2 = null;
    L13:
        ConstraintLayout r3 = (DeepFeedProductView) r2;
        if (r3 == null) goto L26;
        ?? r5 = (DeepFeedProductInfoExtraView) r3.findViewById(2131375257);
        if (r5 != 0) goto L18;
        return;
    L18:
        if (tc3.f.b() == false) goto L28;
        r5.post(new n(r5));
        return;
    L28:
        return;
    L26:
        return;
    L24:
        return;
    L23:
        return;
    }

    public final void onConfigurationChanged(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(r2);
        com.bytedance.android.shopping.deepfeed.ui.c r3 = this.p0;
        if (r3 == null) goto L5;
        r3.B();
    L5:
        Lazy r4 = DeepFeedFoldHelper.a;
        DeepFeedFoldHelper.b(getActivity());
        DeepFeedFoldHelper.d();
        com.bytedance.android.shopping.deepfeed.ui.view.a r5 = com.bytedance.android.shopping.deepfeed.ui.view.a.e;
        if (r5 == null) goto L9;
        r5.a();
        return;
    }

    public final void onCreate(Bundle r9) {
        super.onCreate(r9);
        Context r0 = getContext();
        if (r0 == null) goto L5;
        this.k.d(r0);
    L5:
        s0.c(this);
        DeepFeedCardStayTracker r1 = fa0().a();
        if (r1.j == true) goto L9;
        ProcessLifecycleOwner.get().getLifecycle().addObserver(r1.m);
        r1.j = true;
    L9:
        Object r2 = null;
        if (r9 == null) goto L12;
        Serializable r3 = r9.getSerializable("deep_feed_query_params");
    L14:
        if ((r3 instanceof DeepFeedQueryParam) == true) goto L16;
        r3 = null;
    L16:
        DeepFeedQueryParam r4 = (DeepFeedQueryParam) r3;
        if (r4 != null) goto L42;
        Bundle r5 = getArguments();
        if (r5 == null) goto L22;
        String r6 = r5.getString("deep_feed_param_cache_key");
    L23:
        if (r6 == null) goto L34;
        StringBuilder r7 = new StringBuilder("get params from cachekey ");
        r7.append(r6);
        r7.append(",  ");
        HashMap<String, com.bytedance.android.shopping.deepfeed.data.repo.l> r8 = DeepFeedProductDataCenter.a;
        Intrinsics.checkNotNullParameter(r6, "key");
        ConcurrentHashMap<String, DeepFeedQueryParam> r10 = DeepFeedProductDataCenter.b;
        r7.append(r10.get(r6));
        Logger.i("caihn", r7.toString());
        Intrinsics.checkNotNullParameter(r6, "key");
        r4 = r10.remove(r6);
        if (r4 != null) goto L42;
        Bundle r11 = getArguments();
        if (r11 == null) goto L29;
        Serializable r12 = r11.getSerializable("deep_feed_query_params");
    L31:
        if ((r12 instanceof DeepFeedQueryParam) == true) goto L33;
        r12 = null;
    L33:
        r4 = (DeepFeedQueryParam) r12;
        goto L42
    L29:
        r12 = null;
        goto L31
    L34:
        Bundle r13 = getArguments();
        if (r13 == null) goto L37;
        Serializable r14 = r13.getSerializable("deep_feed_query_params");
    L39:
        if ((r14 instanceof DeepFeedQueryParam) == true) goto L41;
        r14 = null;
    L41:
        r4 = (DeepFeedQueryParam) r14;
        goto L42
    L37:
        r14 = null;
        goto L39
    L22:
        r6 = null;
    L42:
        if (r4 == null) goto L44;
        DeepFeedQueryParam r15 = DeepFeedProductDataCenter.a(r4).o;
    L45:
        this.h = r15;
        if (r15 == null) goto L51;
        DeepFeedProductViewModel r16 = ga0();
        com.bytedance.android.shopping.deepfeed.action.d r17 = new com.bytedance.android.shopping.deepfeed.action.d(getContext(), this);
        r17.a = new DeepFeedProductFragment$onCreate$$inlined$also$lambda$1(this);
        com.bytedance.android.shopping.deepfeed.event.a r18 = da0();
        if (r18 == null) goto L50;
        r17.b = new DeepFeedProductFragment$onCreate$3$2$1(r18);
        r17.c = new DeepFeedProductFragment$onCreate$3$2$2(r18);
    L50:
        Unit r19 = Unit.INSTANCE;
        r16.setup(r15, r17);
    L51:
        boolean r20 = false;
        if (r9 != null) goto L54;
        com.bytedance.android.shopping.deepfeed.data.repo.l r21 = ga0().getResp();
        if (r21 == null) goto L66;
        o r22 = r21.b();
        if (r22 == null) goto L66;
        ((AbsDeepFeedRequest) r22).v(false);
    L66:
        this.L0.a(getContext());
        if (ia0() == false) goto L71;
        Context r23 = getContext();
        if (r23 == null) goto L71;
        com.bytedance.android.shopping.deepfeed.ui.view.a r24 = com.bytedance.android.shopping.deepfeed.ui.view.a.e;
        Intrinsics.checkNotNullParameter(r23, "context");
        Intrinsics.checkNotNullParameter(this, "lifecycleOwner");
        com.bytedance.android.shopping.deepfeed.ui.view.a.e = new com.bytedance.android.shopping.deepfeed.ui.view.a(r23);
        getLifecycle().addObserver(new AdapterScreenHelp$Companion$createAdapterScreenByLife$1());
    L71:
        DeepFeedFoldHelper.d();
        DeepFeedFoldHelper.a();
        DeepFeedFoldHelper.b(getActivity());
        int r25 = ECSdk.a;
        IECFeedbackService r26 = (IECFeedbackService) ECSdk.a(IECFeedbackService.class);
        if (r26 == null) goto L123;
        r26.registerScreenCapture(getContext(), this);
    L123:
        Result.Companion r27 = Result.Companion;     // Catch: Throwable -> L76
        boolean r28 = ECServiceManager.a;     // Catch: Throwable -> L76
        Object r29 = Result.constructor-impl(((s83.g) ECServiceManager.c(s83.g.class)).R());     // Catch: Throwable -> L76
    L79:
        if (Result.isFailure-impl(r29) == false) goto L81;
        r29 = null;
    L81:
        Boolean r30 = (Boolean) r29;
        if (r30 == null) goto L84;
        boolean r31 = r30.booleanValue();
    L85:
        int r32 = tc3.f.a;
        Integer r33 = tc3.a.a().l();
        if (r33 != null) goto L89;
    L91:
        if (r20 == false) goto L93;
        int r34 = ed3.b.a;
        Intrinsics.checkNotNullParameter("deep_feed_manual_mute_status", "key");
        com.bytedance.android.shopping.deepfeed.utlis.f.b = r31;
    L105:
        if ((!Intrinsics.areEqual(tc3.a.a().o(), Boolean.TRUE)) == true) goto L108;
        com.bytedance.android.ec.hybrid.a.d().submit(new k(new DeepFeedProductFragment$registerPitayaListener$1(this)));
    L108:
        int r35 = ed3.b.a;
        Object r36 = ((Map) this.h1.getValue()).get("deleteLists");
        if ((r36 instanceof List) == true) goto L111;
        r36 = null;
    L111:
        List r37 = (List) r36;
        if (r37 != null) goto L114;
        r37 = CollectionsKt.emptyList();
    L114:
        DeepFeedCouponLottieCache.a.getClass();
        DeepFeedCouponLottieCache.c(r37);
        Object r38 = ((Map) this.h1.getValue()).get("jsonList");
        if ((r38 instanceof List) == false) goto L118;
        r2 = r38;
    L118:
        List r39 = (List) r2;
        if (r39 != null) goto L121;
        r39 = CollectionsKt.emptyList();
    L121:
        DeepFeedCouponLottieCache.d(r39);
        return;
    L93:
        Boolean r40 = com.bytedance.android.shopping.deepfeed.utlis.f.d;
        if (r40 != null) goto L103;
        Integer r41 = tc3.a.a().l();
        if (r41 != null) goto L99;
    L101:
        r31 = true;
    L102:
        com.bytedance.android.shopping.deepfeed.utlis.f.b = r31;
        goto L105
    L99:
        if (r41.intValue() != 1) goto L101;
    L103:
        com.bytedance.android.shopping.deepfeed.utlis.f.b = r40.booleanValue();
        goto L105
    L89:
        if (r33.intValue() != 2) goto L91;
        r20 = true;
        goto L91
    L84:
        r31 = true;
    L76:
        th = move-exception;
        Result.Companion r42 = Result.Companion;
        r29 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L79
    L54:
        if (this.N == false) goto L56;
        ga0().initOnRebuild(r15);
        ga0().loadProductPack(AnonymousClass4.INSTANCE);
    L56:
        com.bytedance.android.shopping.deepfeed.data.repo.l r43 = ga0().getResp();
        if (r43 == null) goto L66;
        o r44 = r43.b();
        if (r44 == null) goto L66;
        ((AbsDeepFeedRequest) r44).v(true);
        goto L66
    L44:
        r15 = null;
        goto L45
    L12:
        r3 = null;
        goto L14
    }

    public final void onSaveInstanceState(Bundle r3) {
        Intrinsics.checkNotNullParameter(r3, "outState");
        super.onSaveInstanceState(r3);
        DeepFeedQueryParam r0 = this.h;
        if (r0 == null) goto L6;
        r3.putSerializable("deep_feed_query_params", r0);
        return;
    }

    public final boolean W90(AbsDeepFeedProductVH r5, OrientationHelper r6) {
        if (r5 == null) goto L17;
        View r0 = ((RecyclerView.ViewHolder) r5).itemView;
        if (r0 != null) goto L6;
        return false;
    L6:
        if ((r6.getDecoratedStart(r0) - r6.getStartAfterPadding()) >= 0) goto L8;
        return true;
    L8:
        if (r5.getAdapterPosition() != 4) goto L12;
        if ((r6.getEndAfterPadding() - r6.getDecoratedStart(r0)) >= 10) goto L12;
        return true;
    L12:
        if (r5.getAdapterPosition() != 4) goto L14;
        return false;
    L14:
        if ((r6.getEndAfterPadding() - r6.getDecoratedStart(r0)) >= this.U) goto L23;
        return true;
    L23:
        return false;
    L17:
        return false;
    }

    public final void onViewCreated(View r12, Bundle r13) {
        Intrinsics.checkNotNullParameter(r12, FreqActions.ACTION_VIEW);
        super.onViewCreated(r12, r13);
        r12.setBackgroundColor(ColorProtector.parseColor("#161823"));
        r12.getViewTreeObserver().addOnWindowFocusChangeListener(this.J);
        com.bytedance.android.shopping.deepfeed.event.a r14 = da0();
        Boolean r1 = null;
        if (r14 != null) goto L5;
    L12:
        DeepFeedQueryParam r15 = ga0().getFeedParam();
        if (r15 == null) goto L17;
        DeepFeedAbValues r16 = r15.getAbValues();
        if (r16 == null) goto L17;
        Integer r17 = r16.getDeepFeedUseSlc();
    L18:
        final int r2 = 1;
        if (r17 != null) goto L22;
    L24:
        com.bytedance.android.shopping.deepfeed.ui.c r18 = new DeepFeedTopBarManager(r12, this);
    L25:
        this.p0 = r18;
        r18.f(ga0(), aa0(), new DeepFeedProductFragment$initView$2(this));
        int r19 = (int) (((double) k1.j(getContext())) * 0.11d);
        int r3 = com.bytedance.android.shopping.deepfeed.utlis.k.a;
        this.U = r19 - com.bytedance.android.shopping.deepfeed.utlis.k.a(getContext());
        this.o = (FrameLayout) r12.findViewById(2131386811);
        View r110 = r12.findViewById(2131368172);
        int r4 = 0;
        if (r110 == null) goto L28;
        GradientDrawable r5 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{ColorProtector.parseColor("#80000000"), ColorProtector.parseColor("#00000000")});
        Intrinsics.checkNotNullParameter(r110, "$this$setBackgroundCompat");
        r110.setBackground(r5);
    L28:
        this.l = (DeepFeedProductRecyclerview) r12.findViewById(2131384926);
        DeepFeedProductAdapter r111 = new DeepFeedProductAdapter(this, this.k, aa0());
        r111.setShowFooter(true);
        if (ia0() == false) goto L31;
        r111.D = true;
    L31:
        Context r6 = getContext();
        if (r6 == null) goto L40;
        ECDuxLoadingAnimationView r7 = new ECDuxLoadingAnimationView(r6, null, 0, 6, null);
        FrameLayout.LayoutParams r8 = new FrameLayout.LayoutParams(-1, -1);
        r8.gravity = 17;
        r7.setLayoutParams(r8);
        Intrinsics.checkNotNullParameter(r7, FreqActions.ACTION_VIEW);
        r111.p = r7;
        if (ia0() == false) goto L40;
        if (this.M == false) goto L40;
        DeepFeedProductRecyclerview r0 = this.l;
        if (r0 == null) goto L40;
        r0.setItemAnimator(new DeepFeedFooterExitAnimator(r7, r0));
    L40:
        r111.j = 0;
        r111.l = 0;
        r111.k = 0;
        r111.i = 0;
        r111.h = com.bytedance.android.shopping.extensions.b.b(120);
        r111.d = com.bytedance.android.shopping.extensions.j.b(2131105684);
        r111.c = com.bytedance.android.shopping.extensions.j.b(2131105958);
        String r9 = com.bytedance.android.shopping.extensions.j.c(2131914048);
        TextView r10 = r111.f;
        if (r10 == null) goto L43;
        r10.setText(r9);
    L43:
        r111.e = r9;
        TextView r11 = r111.f;
        if (r11 == null) goto L46;
        r11.setGravity(49);
    L46:
        r111.s = 49;
        int r20 = com.bytedance.android.shopping.extensions.b.b(16);
        r111.m = Integer.valueOf(r20);
        TextView r21 = r111.f;
        if (r21 == null) goto L49;
        r21.setPadding(0, r20, 0, 0);
    L49:
        r111.resetLoadMoreState();
        r111.r = this.P0;
        r111.B = this.A;
        r111.C = this.B;
        Unit r22 = Unit.INSTANCE;
        this.n = r111;
        DeepFeedProductRecyclerview r23 = this.l;
        if (r23 == null) goto L60;
        r23.setAdapter(r111);
        r23.setLayoutManager(new LinearLayoutManager(requireContext(), 1, false));
        r23.addOnScrollListener(this.g1);
        this.m.attachToRecyclerView(r23);     // Catch: IllegalStateException -> L54
    L59:
        this.g.b(r23);
    L54:
        e = move-exception;
        String r112 = e.getMessage();
        if (r112 != null) goto L58;
        r112 = "";
    L58:
        ECExceptionMonitor.c(r112);
    L60:
        DeepFeedProductRecyclerview r113 = this.l;
        if (r113 == null) goto L65;
        RecyclerView.LayoutManager r114 = r113.getLayoutManager();
        if (r114 == null) goto L65;
        this.T = OrientationHelper.createVerticalHelper(r114);
    L65:
        com.bytedance.android.shopping.deepfeed.ui.view.g r115 = new com.bytedance.android.shopping.deepfeed.ui.view.g(r12, aa0());
        aa0().getClass();
        Intrinsics.checkNotNullParameter(r115, "tips");
        Unit r24 = Unit.INSTANCE;
        this.G = r115;
        DeepFeedQueryParam r116 = ga0().getFeedParam();
        if (r116 == null) goto L73;
        DeepFeedAbValues r117 = r116.getAbValues();
        if (r117 == null) goto L73;
        Integer r118 = r117.getSlideToastFreqCount();
        if (r118 == null) goto L73;
        r4 = r118.intValue();
    L73:
        if (r4 <= 0) goto L91;
        DeepFeedQueryParam r25 = ga0().getFeedParam();
        if (r25 == null) goto L82;
        DeepFeedAbValues r26 = r25.getAbValues();
        if (r26 == null) goto L82;
        Integer r27 = r26.getSlideToastFreqCount();
        if (r27 == null) goto L82;
        r2 = r27.intValue();
    L82:
        DeepFeedQueryParam r28 = ga0().getFeedParam();
        if (r28 == null) goto L89;
        DeepFeedAbValues r29 = r28.getAbValues();
        if (r29 == null) goto L89;
        Double r30 = r29.getSlideToastFreqCycle();
        if (r30 == null) goto L89;
        final double r31 = r30.doubleValue();
    L90:
        com.bytedance.android.shopping.deepfeed.action.b r32 = aa0();
        Function1<Integer, Unit> r33 = new DeepFeedProductFragment$initTip$2(this, r31, r2);
        r32.getClass();
        Intrinsics.checkNotNullParameter(r33, "listener");
        Intrinsics.checkNotNullParameter(r33, "listener");
    L89:
        r31 = -1.0d;
    L91:
        ga0().injectDeepFeedContext(aa0());
        DeepFeedQueryParam r34 = ga0().getFeedParam();
        if (r34 == null) goto L97;
        DeepFeedAbValues r35 = r34.getAbValues();
        if (r35 == null) goto L97;
        r1 = r35.getEnterProductAutoSlide();
    L97:
        if (Intrinsics.areEqual(r1, Boolean.TRUE) == false) goto L99;
        com.bytedance.android.shopping.deepfeed.action.b r36 = aa0();
        Function1<com.bytedance.android.shopping.deepfeed.viewmodel.a, Unit> r37 = new DeepFeedProductFragment$initView$6(this);
        r36.getClass();
        Intrinsics.checkNotNullParameter(r37, "listener");
        Intrinsics.checkNotNullParameter(r37, "listener");
    L99:
        com.bytedance.android.shopping.deepfeed.action.b r38 = aa0();
        Function1<com.bytedance.android.shopping.deepfeed.viewmodel.b, Unit> r39 = new DeepFeedProductFragment$initView$7(this);
        r38.getClass();
        Intrinsics.checkNotNullParameter(r39, "listener");
        ga0().getShowCouponTipsStatus().observe(getViewLifecycleOwner(), new com.bytedance.android.shopping.deepfeed.d(this));
        ga0().getFirstCardPopup().observe(getViewLifecycleOwner(), new com.bytedance.android.shopping.deepfeed.c(this));
        DeepFeedProductRecyclerview r119 = this.l;
        if (r119 == null) goto L102;
        r119.addOnScrollListener(new HybridRecyclerViewPerformanceMonitor("homepage_mall_depp_feed", new JSONObject()));
    L102:
        DeepFeedProductRecyclerview r120 = this.l;
        if (r120 == null) goto L107;
        IHybridHostService r40 = com.bytedance.android.ec.hybrid.a.h();
        if (r40 == null) goto L107;
        r40.attachDropFrameMonitorTo("ec_mall_product_deep_feed", r120);
    L107:
        ga0().getPitayaAutoSlideEvent().observe(getViewLifecycleOwner(), new g(this));
        ga0().getInFeedCardList().observe(getViewLifecycleOwner(), new i(this));
        ga0().getInFeedLoadStatus().observe(getViewLifecycleOwner(), new j(this));
        ga0().logPageView(r12);
        ga0().loadFeed(Y90());
        return;
    L22:
        if (r17.intValue() != 1) goto L24;
        r18 = new com.bytedance.android.shopping.deepfeed.slice.view.a(this.k, r12, this);
    L17:
        r17 = null;
        goto L18
    L5:
        if ((r12 instanceof DeepFeedFragmentView) == true) goto L7;
        Object r41 = null;
    L8:
        DeepFeedFragmentView r42 = (DeepFeedFragmentView) r41;
        if (r42 == null) goto L11;
        r42.setTouchObserver(new DeepFeedProductFragment$initView$1$1(r14));
    L11:
        this.O = r12.findViewById(2131386879);
        this.P = r12.findViewById(2131389050);
        this.Q = r12.findViewById(2131386223);
        goto L12
    L7:
        r41 = r12;
        goto L8
    }

    public final View onCreateView(LayoutInflater r13, ViewGroup r14, Bundle r15) {
        Intrinsics.checkNotNullParameter(r13, "inflater");
        FragmentActivity r16 = getActivity();
        if (r16 == null) goto L5;
        HashMap<String, com.bytedance.android.shopping.deepfeed.data.repo.l> r0 = DeepFeedProductDataCenter.a;
        Intrinsics.checkNotNullParameter(r16, "activity");
        int r1 = com.bytedance.android.shopping.deepfeed.data.b.a;
        DeepFeedProductDataCenter.b();
        Intrinsics.checkNotNullParameter(r16, "activity");
        long r7 = System.currentTimeMillis();
        com.bytedance.android.shopping.deepfeed.data.b.a r17 = new com.bytedance.android.shopping.deepfeed.data.b.a(new com.bytedance.android.shopping.deepfeed.data.b.C0051b(r7, r7, r7));
    L6:
        if (r17 == null) goto L12;
        com.bytedance.android.shopping.deepfeed.data.b.C0051b r2 = r17.b;
        if (r2 == null) goto L12;
        com.bytedance.android.shopping.deepfeed.data.repo.l r3 = ga0().getResp();
        if (r3 == null) goto L12;
        uc3.f r4 = r3.g();
        com.bytedance.android.shopping.deepfeed.data.repo.j r5 = (com.bytedance.android.shopping.deepfeed.data.repo.j) r4;
        r5.l(r2.a, r2.b, r2.c, r2.d, r2.e, r2.f);
    L12:
        if (r17 == null) goto L17;
        View r18 = r17.a;
        if (r18 == null) goto L17;
        return r18;
    L17:
        return th.a.c(r13.getContext(), 2131564647, r14, false);
    L5:
        r17 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean ja0(DeepFeedFragmentView r6, View r7, float r8, float r9) {
        if (r7 != null) goto L5;
        return false;
    L5:
        if (r7.isShown() == true) goto L7;
        return false;
    L7:
        if (r7.getWidth() > 0) goto L9;
        return false;
    L9:
        if (r7.getHeight() <= 0) goto L28;
        r6.getLocationOnScreen(this.R);
        r7.getLocationOnScreen(this.S);
        int[] r10 = this.S;
        int r1 = r10[0];
        int[] r3 = this.R;
        int r2 = r1 - r3[0];
        int r11 = r10[1] - r3[1];
        if (r8 >= r2) goto L14;
        return false;
    L14:
        if (r8 < (r2 + r7.getWidth())) goto L16;
        return false;
    L16:
        if (r9 >= r11) goto L18;
        return false;
    L18:
        if (r9 >= (r11 + r7.getHeight())) goto L27;
        return true;
    L27:
        return false;
    L28:
        return false;
    }

    public final void ma0(RecyclerView.LayoutManager r4, View r5, boolean r6, boolean r7) {
        int r8 = r4.getPosition(r5);
        this.V = r8;
        DeepFeedProductRecyclerview r9 = this.l;
        RecyclerView.ViewHolder r0 = null;
        if (r9 == null) goto L5;
        RecyclerView.ViewHolder r10 = r9.findViewHolderForAdapterPosition(r8);
    L7:
        if ((r10 instanceof AbsDeepFeedProductVH) == true) goto L9;
        r10 = null;
    L9:
        AbsDeepFeedProductVH r11 = (AbsDeepFeedProductVH) r10;
        if (r11 != null) goto L12;
    L14:
        DeepFeedProductRecyclerview r1 = this.l;
        if (r1 == null) goto L17;
        RecyclerView.ViewHolder r12 = r1.findViewHolderForAdapterPosition(this.V + 1);
    L19:
        if ((r12 instanceof AbsDeepFeedProductVH) == false) goto L22;
        r0 = r12;
    L22:
        AbsDeepFeedProductVH r2 = (AbsDeepFeedProductVH) r0;
        this.w = r2;
        DeepFeedProductAdapter r13 = this.n;
        if (r13 == null) goto L25;
        r13.D2(this.V, r11, r6, r7);
    L25:
        DeepFeedProductAdapter r14 = this.n;
        if (r14 == null) goto L29;
        r14.E2(r2);
        return;
    L29:
        return;
    L17:
        r12 = null;
        goto L19
    L12:
        if ((!Intrinsics.areEqual(r11, this.v)) == false) goto L14;
        ka0(r11);
        this.p = true;
        this.r = 0;
        goto L14
    L5:
        r10 = null;
        goto L7
    }
}
