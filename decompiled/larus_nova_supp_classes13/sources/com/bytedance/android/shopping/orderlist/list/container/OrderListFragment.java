package com.bytedance.android.shopping.orderlist.list.container;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ProcessLifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.android.ec.common.api.feedback.IECFeedbackService;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.jedi.ReflectViewModelFactory;
import com.bytedance.android.ec.core.utils.l0;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.shopping.buynow.data.model.BuyNowUrlType;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.orderlist.common.controller.OrderBottomBarHandler;
import com.bytedance.android.shopping.orderlist.common.controller.OrderCommonPageConfig;
import com.bytedance.android.shopping.orderlist.common.controller.OrderCommonTemplateManager;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.android.shopping.orderlist.common.monitor.business.OrderCommonBusinessMonitor;
import com.bytedance.android.shopping.orderlist.common.monitor.error.OrderCommonErrorMonitorKt;
import com.bytedance.android.shopping.orderlist.common.monitor.firstscreen.FirstScreenPoint;
import com.bytedance.android.shopping.orderlist.common.monitor.firstscreen.OrderCommonFirstScreenMonitor;
import com.bytedance.android.shopping.orderlist.common.monitor.firstscreen.OrderCommonFirstScreenMonitorKt;
import com.bytedance.android.shopping.orderlist.common.monitor.fps.OrderCommonDropFrameMonitor;
import com.bytedance.android.shopping.orderlist.common.monitor.fps.OrderCommonFpsMonitor;
import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import com.bytedance.android.shopping.orderlist.common.widgets.state.OrderCommonHeadBarView;
import com.bytedance.android.shopping.orderlist.list.cache.SingleOrderListCache;
import com.bytedance.android.shopping.orderlist.list.network.OrderListRequestViewModel;
import com.bytedance.android.shopping.orderlist.list.starter.OrderListParams;
import com.bytedance.android.shopping.orderlist.list.starter.OrderListStarter;
import com.bytedance.android.shopping.orderlist.list.viewmodel.OrderListViewModel;
import com.bytedance.android.shopping.orderlist.list.widget.linkedlist.OrderListLinkedScrollView;
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
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
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
import kotlin.text.StringsKt;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u00032\u00020\u00052\u00020\u00062\u00020\u0007:\u0001\u000eB\u0007¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0007¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/list/container/OrderListFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/bytedance/jedi/arch/JediView;", "Lcom/bytedance/jedi/arch/ViewModelFactoryOwner;", "Lcom/bytedance/android/ec/core/jedi/ReflectViewModelFactory;", "Lcom/bytedance/android/shopping/orderlist/common/controller/f;", "Leg3/a;", "Lc53/d;", "Lcom/bytedance/android/shopping/orderlist/list/network/a;", "event", "", "onChunkEvent", "<init>", "()V", "Companion", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OrderListFragment extends Fragment implements JediView, ViewModelFactoryOwner<ReflectViewModelFactory>, com.bytedance.android.shopping.orderlist.common.controller.f, eg3.a, c53.d {
    public static final /* synthetic */ int P = 0;
    public final Lazy A;
    public final Lazy B;
    public final Lazy C;
    public final Lazy D;
    public eg3.b E;
    public OrderListStickyController F;
    public final Lazy G;
    public final Lazy H;
    public c I;
    public boolean J;
    public ig3.a K;
    public OrderCommonDropFrameMonitor L;
    public OrderCommonDropFrameMonitor M;
    public final OrderListFragment$appLifecycleObserver$1 N;
    public final /* synthetic */ c53.b O;
    public Map<Integer, View> d;
    public final ReflectViewModelFactory e;
    public final lifecycleAwareLazy f;
    public OrderListRequestViewModel g;
    public com.bytedance.android.shopping.orderlist.list.network.b h;
    public OrderListStarter i;
    public com.bytedance.kmp.ec.yata.view.render.delegate.v2.a j;
    public AndroidYaTaInstance k;
    public SlcRenderContext l;
    public d m;
    public final Lazy n;
    public boolean o;
    public final List<Function0<Unit>> p;
    public OrderListRequestType q;
    public boolean r;
    public boolean s;
    public boolean t;
    public long u;
    public OrderListLinkedScrollView v;
    public View w;
    public boolean x;
    public String y;
    public final Lazy z;

    public static final class Companion {
        public static OrderListFragment a(OrderListParams r5, String r6, Uri r7) {
            long r0 = System.currentTimeMillis();
            Lazy r2 = OrderCommonLog.a;
            OrderCommonLog.c("OrderListFragment", OrderListFragment$Companion$create$1.INSTANCE);
            OrderListFragment r3 = new OrderListFragment();
            Bundle r4 = new Bundle();
            r4.putSerializable("ORDER_LIST_PARAM", r5);
            r4.putParcelable("ORDER_LIST_URI", r7);
            r4.putSerializable("PrefetchSessionId", r6);
            r4.putSerializable("container_init_start", Long.valueOf(r0));
            Unit r8 = Unit.INSTANCE;
            r3.setArguments(r4);
            return r3;
        }
    }

    static {
    }

    public final OrderListStateController W90() {
        return (OrderListStateController) this.z.getValue();
    }

    public final OrderListViewModel Y90() {
        return (OrderListViewModel) this.f.getValue();
    }

    public final Disposable add(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "disposable");
        this.O.add(r2);
        return r2;
    }

    public final void doClear() {
        this.O.doClear();
    }

    public final void remove(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "disposable");
        this.O.remove(r2);
    }

    @Override // eg3.a
    public final OrderBottomBarHandler Md() {
        return (OrderBottomBarHandler) this.B.getValue();
    }

    @Override // eg3.a
    public final OrderCommonBusinessMonitor T50() {
        ig3.a r0 = this.K;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.c;
    }

    public final void onPause() {
        Lazy r0 = OrderCommonLog.a;
        OrderCommonLog.c("OrderListFragment", C02891.INSTANCE);
        super.onPause();
        OrderCommonErrorMonitorKt.c(Y90().getTracker(), "OrderListFragment-onPause", new AnonymousClass2(this));
    }

    public final void onResume() {
        Lazy r0 = OrderCommonLog.a;
        OrderCommonLog.c("OrderListFragment", C02901.INSTANCE);
        super.onResume();
        OrderCommonErrorMonitorKt.c(Y90().getTracker(), "OrderListFragment-onResume", new C02912(this));
    }

    public final void onStart() {
        Lazy r0 = OrderCommonLog.a;
        OrderCommonLog.c("OrderListFragment", C02931.INSTANCE);
        super.onStart();
        c r1 = this.I;
        if (r1 == null) goto L6;
        r1.e();
        return;
    }

    /* JADX WARN: Type inference failed for: r0v24, types: [com.bytedance.android.shopping.orderlist.list.container.OrderListFragment$appLifecycleObserver$1] */
    public OrderListFragment() {
        this.O = new c53.b();
        this.d = new LinkedHashMap();
        this.e = new ReflectViewModelFactory();
        final KClass r0 = Reflection.getOrCreateKotlinClass(OrderListViewModel.class);
        final Function0<String> r1 = new OrderListFragment$$special$$inlined$viewModel$1(r0);
        final OrderListFragment$$special$$inlined$viewModel$2 r2 = OrderListFragment$$special$$inlined$viewModel$2.INSTANCE;
        this.f = new lifecycleAwareLazy(this, r1, new OrderListFragment$$special$$inlined$viewModel$3(this, r1, r0, r2));
        OrderListRequestType r3 = OrderListRequestType.FIRST_REQUEST;
        this.h = new com.bytedance.android.shopping.orderlist.list.network.b(r3, 0, false, false, false, false, null, null, 1022);
        this.n = LazyKt.lazy(new OrderListFragment$yataAbilityProvider$2(this));
        this.o = true;
        this.p = new ArrayList();
        this.q = r3;
        this.z = LazyKt.lazy(new OrderListFragment$stateController$2(this));
        this.A = LazyKt.lazy(new OrderListFragment$headRefreshLayout$2(this));
        this.B = LazyKt.lazy(new OrderListFragment$bottomBarHandler$2(this));
        this.C = LazyKt.lazy(new OrderListFragment$freqManager$2(this));
        this.D = LazyKt.lazy(new OrderListFragment$selfSaveTriggerManager$2(this));
        this.G = LazyKt.lazy(new OrderListFragment$screenShotComponent$2(this));
        this.H = LazyKt.lazy(new OrderListFragment$viewPreloadHelper$2(this));
        this.N = new OrderListFragment$appLifecycleObserver$1(this);
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
        OrderCommonErrorMonitorKt.c(Y90().getTracker(), "onDestroyView", new C02881(this));
        ((LinkedHashMap) this.d).clear();
    }

    public final void onStop() {
        OrderCommonErrorMonitorKt.c(Y90().getTracker(), "OrderListFragment-onStop", new C02941(this));
    }

    public final ViewModelProvider.Factory getViewModelFactory() {
        return this.e;
    }

    /* JADX INFO: renamed from: getReceiver, reason: collision with other method in class */
    public final IdentitySubscriber m2093getReceiver() {
        return JediView.DefaultImpls.getReceiver(this);
    }

    public static final /* synthetic */ OrderListLinkedScrollView T90(OrderListFragment r1) {
        OrderListLinkedScrollView r2 = r1.v;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("linkedScrollView");
    L5:
        return r2;
    }

    public static final /* synthetic */ void V90(OrderListFragment r0) {
        super.onStop();
    }

    @Override // com.bytedance.android.shopping.orderlist.common.controller.f
    public final void PC(final boolean r3) {
        OrderCommonErrorMonitorKt.c(Y90().getTracker(), "OrderListFragment-onUpScreenFinish", new OrderListFragment$onUpScreenFinish$1(this, r3));
    }

    public final View S90(int r3) {
        if (this.d != null) goto L5;
        this.d = new LinkedHashMap();
    L5:
        Map<Integer, View> r0 = this.d;
        LinkedHashMap r1 = (LinkedHashMap) r0;
        View r2 = (View) r1.get(Integer.valueOf(r3));
        if (r2 != null) goto L14;
        View r4 = getView();
        if (r4 == null) goto L12;
        View r5 = r4.findViewById(r3);
        if (r5 == null) goto L12;
        this.d.put(Integer.valueOf(r3), r5);
        return r5;
    L12:
        return null;
    L14:
        return r2;
    }

    public final String X90(final String r9) {
        AndroidYaTaInstance r0 = this.k;
        final String r1 = null;
        if (r0 == null) goto L9;
        List r2 = r0.p("tab_bar_group");
        if (r2 == null) goto L9;
        com.bytedance.kmp.ec.yata.store.node.c r3 = (com.bytedance.kmp.ec.yata.store.node.c) CollectionsKt.firstOrNull(r2);
        if (r3 == null) goto L9;
        Map r4 = r3.s();
    L10:
        if (r4 == null) goto L12;
        final Object r5 = r4.get("skeleton_anchor_slice_keys");
    L13:
        boolean r6 = false;
        if ((r5 instanceof List) == false) goto L17;
        List r7 = (List) r5;
    L23:
        boolean r8 = Intrinsics.areEqual(r9, "biz_primary");
        if (r7 == null) goto L26;
        Object r10 = CollectionsKt.getOrNull(r7, r8 ? 1 : 0);
    L28:
        if ((r10 instanceof String) == true) goto L30;
        r10 = null;
    L30:
        String r11 = (String) r10;
        if (r11 == null) goto L39;
        String r12 = StringsKt.trim(r11).toString();
        if (r12 == null) goto L39;
        if (r12.length() <= 0) goto L37;
        r6 = true;
    L37:
        if (r6 == false) goto L39;
        r1 = r12;
    L39:
        Lazy r13 = OrderCommonLog.a;
        final int r14 = r8 ? 1 : 0;
        OrderCommonLog.c("OrderListFragment", new OrderListFragment$getStatusTabSkeletonAnchorSliceKey$1(r9, r14, r5, r1));
        return r1;
    L26:
        r10 = null;
        goto L28
    L17:
        if ((r5 instanceof JSONArray) == false) goto L22;
        JSONArray r15 = (JSONArray) r5;
        int r16 = r15.length();
        ArrayList r17 = new ArrayList(r16);
        int r18 = 0;
    L19:
        if (r18 >= r16) goto L21;
        r17.add(r15.opt(r18));
        r18 = r18 + 1;
        goto L19
    L21:
        r7 = r17;
        goto L23
    L22:
        r7 = null;
        goto L23
    L12:
        r5 = null;
    L9:
        r4 = null;
        goto L10
    }

    public final void Z90(SlcRenderContext r3) {
        if (r3 == null) goto L4;
        Lazy r0 = OrderCommonPageConfig.a;
        r3.f = OrderCommonPageConfig.b(Y90().isSplitMode());
    L4:
        if (r3 == null) goto L6;
        Lazy r1 = OrderCommonPageConfig.a;
        r3.j = ECSettingKeys.F().getClickDebounceSwitch();
    L6:
        if (r3 == null) goto L9;
        Lazy r2 = OrderCommonPageConfig.a;
        r3.k = ECSettingKeys.F().getClickDebounceDuration();
    L9:
        if (r3 == null) goto L11;
        r3.g = true;
    L11:
        if (r3 == null) goto L13;
        r3.y = true;
    L13:
        if (r3 == null) goto L15;
        r3.p(MapsKt.mapOf(TuplesKt.to("system_font_scale", Float.valueOf(k.e(ECAppInfoService.e.getCurrentFontScale(), 1.0f)))));
    L15:
        if (r3 == null) goto L18;
        Lazy r4 = OrderCommonPageConfig.a;
        r3.D = ECSettingKeys.F().getDrawableResetPreFetch();
        return;
    }

    public final void aa0(SingleOrderListCache r9) {
        Intrinsics.checkNotNullParameter(r9, "cache");
        boolean r0 = true;
        this.t = true;
        this.u = System.currentTimeMillis();
        gg3.c r2 = r9.getResponse();
        Boolean r3 = null;
        if (r2 == null) goto L9;
        com.bytedance.kmp.ec.yata.common.protocol.data.e r4 = r2.i();
        if (r4 == null) goto L9;
        com.bytedance.kmp.ec.yata.common.protocol.data.c r5 = r4.g();
        if (r5 == null) goto L9;
        aa6.b r6 = com.bytedance.kmp.ec.yata.common.protocol.data.d.d(r5);
    L10:
        Intrinsics.checkNotNull(r6);
        com.bytedance.kmp.ec.yata.common.protocol.utils.e r1 = new com.bytedance.kmp.ec.yata.common.protocol.utils.e(r6);
        OrderListFragment$renderWithCache$1 r7 = OrderListFragment$renderWithCache$1.INSTANCE;
        Intrinsics.checkNotNullParameter(r7, "action");
        r1.b.p((Map) r7.invoke(r1.a.h()));
        OrderListRequestViewModel r8 = this.g;
        if (r8 == null) goto L20;
        if (r8.k == null) goto L15;
    L18:
        r3 = Boolean.valueOf(r0);
        goto L20
    L15:
        if (r8.o.a.size() > 0) goto L18;
        r0 = false;
    L20:
        if (k.i(r3) == false) goto L22;
        return;
    L22:
        Lazy r10 = OrderCommonLog.a;
        OrderCommonLog.c("OrderListRequestViewModel", OrderListFragment$renderWithCache$2.INSTANCE);
        AndroidYaTaInstance r11 = this.k;
        if (r11 == null) goto L26;
        r11.z(r9.getResponse().i().g(), aa6.a.a.b, new com.bytedance.kmp.ec.yata.common.perf.d("biz_order_list_cache"), com.bytedance.kmp.ec.yata.common.protocol.data.f.b(r9.getResponse()), new OrderListFragment$renderWithCache$3(this));
        return;
    L26:
        return;
    L9:
        r6 = null;
        goto L10
    }

    public final Disposable ignore(Disposable r3) {
        Intrinsics.checkNotNullParameter(r3, "disposable");
        this.O.getClass();
        Intrinsics.checkNotNullParameter(r3, "disposable");
        return r3;
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onChunkEvent(com.bytedance.android.shopping.orderlist.list.network.a r4) {
        Intrinsics.checkNotNullParameter(r4, "event");
        if (r4.a == false) goto L11;
        Lazy r0 = OrderCommonLog.a;
        OrderCommonLog.a("OrderListFragment", AnonymousClass1.INSTANCE);
        com.bytedance.kmp.ec.yata.common.protocol.data.e r5 = r4.c;
        if (r5 == null) goto L17;
        OrderListLinkedScrollView r1 = this.v;
        if (r1 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("linkedScrollView");
    L9:
        r1.getFootRefreshHelper().c(r5);
        return;
    L17:
        return;
    L11:
        if (r4.b == false) goto L19;
        Lazy r6 = OrderCommonLog.a;
        OrderCommonLog.a("OrderListFragment", AnonymousClass3.INSTANCE);
        OrderListLinkedScrollView r7 = this.v;
        if (r7 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("linkedScrollView");
    L15:
        r7.getFootRefreshHelper().f();
        return;
    }

    public final void onCreate(final Bundle r7) {
        OrderCommonFirstScreenMonitorKt.a("initData", new OrderListFragment$initData$1(this, r7));
        Bundle r0 = getArguments();
        String r1 = null;
        if (r0 == null) goto L5;
        Long r2 = Long.valueOf(r0.getLong("container_init_start"));
    L6:
        k.h(r2);
        ig3.a r3 = this.K;
        if (r3 == null) goto L11;
        OrderCommonFirstScreenMonitor r4 = r3.a;
        if (r4 == null) goto L11;
        r4.a(FirstScreenPoint.CONTAINER_INIT_END);
    L11:
        ig3.a r5 = this.K;
        if (r5 == null) goto L16;
        OrderCommonFirstScreenMonitor r6 = r5.a;
        if (r6 == null) goto L16;
        r6.a(FirstScreenPoint.PAGE_INIT_START);
    L16:
        ig3.a r8 = this.K;
        if (r8 == null) goto L21;
        OrderCommonFirstScreenMonitor r9 = r8.a;
        if (r9 == null) goto L21;
        r9.f(MapsKt.mapOf(TuplesKt.to("btm", k.j(Y90().getStaticState().p))), this);
    L21:
        ig3.a r10 = this.K;
        if (r10 == null) goto L29;
        OrderCommonFpsMonitor r11 = r10.b;
        if (r11 == null) goto L29;
        Map r12 = MapsKt.mapOf(TuplesKt.to("btm", k.j(Y90().getStaticState().p)));
        Intrinsics.checkNotNullParameter(r12, "params");
        Iterator r13 = r12.entrySet().iterator();
    L27:
        if (r13.hasNext() == false) goto L29;
        Map.Entry r14 = (Map.Entry) r13.next();
        ((JSONObject) r11.c.getValue()).put((String) r14.getKey(), r14.getValue());
    L29:
        ig3.a r15 = this.K;
        if (r15 == null) goto L38;
        OrderCommonFirstScreenMonitor r16 = r15.a;
        if (r16 == null) goto L38;
        OrderListParams r17 = Y90().getStaticState().g;
        if (r17 == null) goto L36;
        boolean r18 = r17.ifMustReport();
    L37:
        r16.b(r18);
        goto L38
    L36:
        r18 = false;
    L38:
        super.onCreate(r7);
        OrderListViewModel r19 = Y90();
        nj.d r20 = com.bytedance.android.ec.sdk.helper.d.b.getPadSplitService();
        if (r20 == null) goto L41;
        l0.c(getActivity());
        r20.j();
        r1 = "";
    L41:
        r19.setSplitMode(Intrinsics.areEqual(r1, BuyNowUrlType.ORDER_LIST));
        ProcessLifecycleOwner.get().getLifecycle().addObserver(this.N);
        AtomicBoolean r21 = OrderCommonTemplateManager.a;
        Intrinsics.checkNotNullParameter(this, "fragment");
        OrderCommonTemplateManager.b = new WeakReference(this);
        int r22 = ECSdk.a;
        IECFeedbackService r23 = (IECFeedbackService) ECSdk.a(IECFeedbackService.class);
        if (r23 == null) goto L46;
        r23.registerScreenCapture(getContext(), this);
        return;
    L46:
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final void onSaveInstanceState(final Bundle r3) {
        Intrinsics.checkNotNullParameter(r3, "outState");
        OrderCommonErrorMonitorKt.c(Y90().getTracker(), "OrderListFragment-onSaveInstanceState1", new C02921(this, r3));
    }

    public static final /* synthetic */ void U90(OrderListFragment r0, Bundle r1) {
        super.onSaveInstanceState(r1);
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, FreqActions.ACTION_VIEW);
        super.onViewCreated(r2, r3);
        OrderCommonErrorMonitorKt.c(Y90().getTracker(), "OrderListFragment-onViewCreated", new C02951(this));
    }

    @Override // com.bytedance.android.shopping.orderlist.common.controller.f
    public final void sA(final boolean r3, final com.bytedance.kmp.ec.yata.common.biz.callback.a r4) {
        OrderCommonErrorMonitorKt.c(Y90().getTracker(), "OrderListFragment-onRequestStart", new OrderListFragment$onRequestStart$1(this, r3, r4));
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

    public final View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        View r6 = r3.inflate(2131564138, r4, false);
        OrderListViewModel r7 = Y90();
        nj.d r8 = com.bytedance.android.ec.sdk.helper.d.b.getPadSplitService();
        ImageView r0 = null;
        if (r8 == null) goto L5;
        l0.c(getActivity());
        r8.j();
        String r9 = "";
    L6:
        r7.setSplitMode(Intrinsics.areEqual(r9, BuyNowUrlType.ORDER_LIST));
        if (Y90().isSplitMode() == false) goto L14;
        if (r6 == null) goto L12;
        ConstraintLayout r10 = (OrderCommonHeadBarView) r6.findViewById(2131381635);
        if (r10 == null) goto L12;
        r0 = (ImageView) r10.findViewById(2131385334);
    L12:
        if (r0 == null) goto L14;
        r0.setImageResource(2131245952);
    L14:
        return r6;
    L5:
        r9 = null;
        goto L6
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

    @Override // com.bytedance.android.shopping.orderlist.common.controller.f
    public final void Ti(final boolean r2, final boolean r3, final gg3.c r4, com.bytedance.kmp.ec.yata.common.biz.callback.a r5) {
        Intrinsics.checkNotNullParameter(r4, "response");
        OrderCommonErrorMonitorKt.c(Y90().getTracker(), "OrderListFragment-onRequestEnd", new OrderListFragment$onRequestEnd$1(this, r2, r3, r4));
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
