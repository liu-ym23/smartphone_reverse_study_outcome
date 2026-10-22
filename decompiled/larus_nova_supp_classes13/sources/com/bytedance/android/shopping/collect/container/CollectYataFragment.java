package com.bytedance.android.shopping.collect.container;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.common.api.feedback.IECFeedbackService;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.async.DisposableScope;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.jedi.ReflectViewModelFactory;
import com.bytedance.android.ec.core.legacy.AbsFragment;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.shopping.collect.controller.CollectYataStatusController;
import com.bytedance.android.shopping.collect.custom_view.CollectGoodsLinkedScrollView;
import com.bytedance.android.shopping.collect.custom_view.CollectRootContainerConstraintLayout;
import com.bytedance.android.shopping.collect.function.base.f;
import com.bytedance.android.shopping.collect.function.base.g;
import com.bytedance.android.shopping.collect.function.base.h;
import com.bytedance.android.shopping.collect.monitor.fps.CollectYataFpsMonitor;
import com.bytedance.android.shopping.collect.repo.model.CollectParams;
import com.bytedance.android.shopping.collect.slice.CollectYataTemplateManager;
import com.bytedance.android.shopping.collect.slice.widgets.ProductCardContainerView;
import com.bytedance.android.shopping.collect.util.CollectCommonLog;
import com.bytedance.android.shopping.collect.yata.ability.CollectYataAbilityProvider;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.android.shopping.yata.init.AndroidYataBuilderManager;
import com.bytedance.android.ui.ec.widget.tools.UnitExtensionKt;
import com.bytedance.jedi.arch.Async;
import com.bytedance.jedi.arch.IReceiver;
import com.bytedance.jedi.arch.ISubscriber;
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
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
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
import ti.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u00032\u00020\u00052\u00020\u00062\u00020\u0006:\u0001\tB\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/collect/container/CollectYataFragment;", "Lcom/bytedance/android/ec/core/legacy/AbsFragment;", "Lcom/bytedance/jedi/arch/JediView;", "Lcom/bytedance/jedi/arch/ViewModelFactoryOwner;", "Lcom/bytedance/android/ec/core/jedi/ReflectViewModelFactory;", "Lcom/bytedance/android/ec/core/async/b;", "", "<init>", "()V", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CollectYataFragment extends AbsFragment implements JediView, ViewModelFactoryOwner<ReflectViewModelFactory>, com.bytedance.android.ec.core.async.b {
    public static final /* synthetic */ int t = 0;
    public final ReflectViewModelFactory f;
    public final lifecycleAwareLazy g;
    public final Lazy h;
    public final Lazy i;
    public RecyclerView j;
    public AndroidYaTaInstance k;
    public final Lazy l;
    public final Lazy m;
    public final kb3.a n;
    public CollectParams o;
    public boolean p;
    public long q;
    public final b r;
    public final /* synthetic */ DisposableScope s;

    public static final class a {
    }

    public static final class b implements kb3.c {
        public b() {
        }

        @Override // kb3.c
        public final void onTouchEvent(MotionEvent r3) {
            if (r3 != null) goto L4;
        L5:
            if (r3 != null) goto L7;
            return;
        L7:
            if (r3.getAction() != 3) goto L13;
        L8:
            ProductCardContainerView r4 = (ProductCardContainerView) CollectYataTemplateManager.c.a.invoke();
            if (r4 == null) goto L14;
            r4.h();
            return;
        L14:
            return;
        L13:
            return;
        L4:
            if (r3.getAction() == 1) goto L8;
            goto L5
        }
    }

    static {
    }

    public final CollectYataStatusController U90() {
        return (CollectYataStatusController) this.h.getValue();
    }

    public final CollectYataViewModel V90() {
        return (CollectYataViewModel) this.g.getValue();
    }

    public final Disposable add(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "disposable");
        this.s.add(r2);
        return r2;
    }

    public final void clearDisposable() {
        this.s.clearDisposable();
    }

    public final void remove(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "disposable");
        this.s.remove(r2);
    }

    public final CompositeDisposable compositeDisposable() {
        return this.s.a();
    }

    public CollectYataFragment() {
        this.s = new DisposableScope();
        this.f = new ReflectViewModelFactory();
        final KClass r0 = Reflection.getOrCreateKotlinClass(CollectYataViewModel.class);
        final Function0<String> r1 = new CollectYataFragment$$special$$inlined$viewModel$1(r0);
        final CollectYataFragment$$special$$inlined$viewModel$2 r2 = CollectYataFragment$$special$$inlined$viewModel$2.INSTANCE;
        this.g = new lifecycleAwareLazy(this, r1, new CollectYataFragment$$special$$inlined$viewModel$3(this, r1, r0, r2));
        this.h = LazyKt.lazy(new CollectYataFragment$statusController$2(this));
        this.i = LazyKt.lazy(new CollectYataFragment$eventController$2(this));
        this.l = LazyKt.lazy(CollectYataFragment$yataFunctionCenter$2.INSTANCE);
        this.m = LazyKt.lazy(new CollectYataFragment$btmPageFinder$2(this));
        this.n = new kb3.a();
        this.r = new b();
    }

    public final CollectGoodsLinkedScrollView S90() {
        View r0 = getView();
        if (r0 != null) goto L7;
        return null;
    L7:
        return (CollectGoodsLinkedScrollView) r0.findViewById(2131367150);
    }

    public final LinearLayout T90() {
        View r0 = getView();
        if (r0 == null) goto L7;
        LinearLayout r1 = (LinearLayout) r0.findViewById(2131367155);
        if (r1 == null) goto L7;
        return r1;
    L7:
        return new LinearLayout(getContext());
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

    public final void onDestroy() {
        long r0 = (System.currentTimeMillis() - this.q) / ((long) 1000);
        int r2 = tb3.a.a;
        Map<? extends String, ? extends Object> r1 = MapsKt.mapOf(new Pair[]{TuplesKt.to("is_page_show", Boolean.valueOf(this.p)), TuplesKt.to("page_duartion", Long.valueOf(r0))});
        CollectYataViewModel r3 = V90();
        Intrinsics.checkNotNullParameter(r1, "params");
        Intrinsics.checkNotNullParameter(r3, "viewModel");
        LinkedHashMap r4 = new LinkedHashMap();
        r4.putAll(r1);
        r4.put("status", "exit");
        Unit r5 = Unit.INSTANCE;
        r3.doEventAction("collect_list_page_monitor", r4, "collect_list_page_monitor_exit");
        super.onDestroy();
        AndroidYaTaInstance r6 = this.k;
        if (r6 == null) goto L5;
        r6.d();
    L5:
        mb3.a r7 = this.n.e;
        if (r7 == null) goto L11;
        Iterator<T> r8 = r7.a.iterator();
    L9:
        if (r8.hasNext() == false) goto L11;
        Pair r9 = (Pair) r8.next();
        ECLiveHybridUtil.p((String) r9.getFirst(), (j) r9.getSecond());
    L11:
        kb3.a r10 = this.n;
        getContext();
        r10.getClass();
        V90().release();
        String r11 = null;
        CollectYataTemplateManager.a = null;
        CollectYataTemplateManager.b = null;
        Map<String, pb3.a> r12 = pb3.a.h;
        CollectParams r13 = this.o;
        if (r13 == null) goto L14;
        r11 = r13.getMonitorId();
    L14:
        pb3.a r14 = pb3.a.h.remove(r11);
        if (r14 == null) goto L22;
        Map<String, com.bytedance.android.shopping.collect.monitor.error.a> r15 = com.bytedance.android.shopping.collect.monitor.error.a.b;
        String r16 = r14.g.getMonitorId();
        if (r16 != null) goto L19;
        r16 = "";
    L19:
        Intrinsics.checkNotNullParameter(r16, "id");
        com.bytedance.android.shopping.collect.monitor.error.a.b.remove(r16);
        return;
    }

    public final ViewModelProvider.Factory getViewModelFactory() {
        return this.f;
    }

    /* JADX INFO: renamed from: getReceiver, reason: collision with other method in class */
    public final IdentitySubscriber m650getReceiver() {
        return JediView.DefaultImpls.getReceiver(this);
    }

    public final void EJ(com.bytedance.kmp.ec.yata.common.biz.callback.a r3) {
        Intrinsics.checkNotNullParameter(r3, "model");
        kb3.a r1 = this.n;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "model");
        com.bytedance.android.shopping.collect.util.e r2 = r1.c;
        if (r2 == null) goto L5;
        Intrinsics.checkNotNullParameter(r3, "model");
        r2.b = true;
    L5:
        com.bytedance.android.shopping.collect.util.a.HandlerC0047a r4 = com.bytedance.android.shopping.collect.util.a.a;
        com.bytedance.android.shopping.collect.util.a.a(new CollectYataFragment$onUplinkStart$1(this));
    }

    public final void W90(com.bytedance.kmp.ec.yata.common.biz.callback.a r3) {
        Intrinsics.checkNotNullParameter(r3, "model");
        kb3.a r1 = this.n;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "model");
        if (r1.c == null) goto L5;
        Intrinsics.checkNotNullParameter(r3, "model");
    L5:
        com.bytedance.android.shopping.collect.util.a.HandlerC0047a r4 = com.bytedance.android.shopping.collect.util.a.a;
        com.bytedance.android.shopping.collect.util.a.a(new CollectYataFragment$onUplinkEnd$1(this));
    }

    public final void onAttach(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super/*androidx.fragment.app.Fragment*/.onAttach(r4);
        CollectCommonLog.c("CollectYataFragmentPage", "onAttach");
        CollectYataTemplateManager.a();
        CollectYataTemplateManager.b(r4);
        com.bytedance.android.shopping.collect.controller.b r5 = (com.bytedance.android.shopping.collect.controller.b) this.i.getValue();
        CollectYataFragment r0 = r5.a;
        kb3.a r1 = r0.n;
        com.bytedance.android.shopping.collect.controller.a r2 = new com.bytedance.android.shopping.collect.controller.a(r5);
        r1.getClass();
        Intrinsics.checkNotNullParameter(r0, "disposableScope");
        Intrinsics.checkNotNullParameter(r2, "callback");
        if (r1.e != null) goto L5;
        r1.e = new mb3.a(r2);
    L5:
        mb3.a r6 = r1.e;
        if (r6 == null) goto L11;
        Iterator<T> r7 = r6.a.iterator();
    L9:
        if (r7.hasNext() == false) goto L13;
        Pair r3 = (Pair) r7.next();
        ECLiveHybridUtil.m((String) r3.getFirst(), (j) r3.getSecond());
        goto L9
    L13:
        return;
    }

    public final void onCreate(Bundle r6) {
        this.q = System.currentTimeMillis();
        super.onCreate(r6);
        Bundle r7 = getArguments();
        ub3.a r0 = null;
        if (r7 == null) goto L5;
        Serializable r8 = r7.getSerializable("collect_params");
    L7:
        if ((r8 instanceof CollectParams) == true) goto L9;
        r8 = null;
    L9:
        CollectParams r9 = (CollectParams) r8;
        if (r9 == null) goto L16;
        this.o = r9;
        CollectYataViewModel r10 = V90();
        CollectParams r1 = this.o;
        PageFinder r2 = (PageFinder) this.m.getValue();
        Function0<AndroidYaTaInstance> r3 = new CollectYataFragment$initData$1(this);
        Context r4 = getContext();
        if (r4 == null) goto L15;
        r0 = new ub3.a(r4);
    L15:
        r10.init(r1, r2, r0, r3);
        kb3.a r11 = this.n;
        Function0<AndroidYaTaInstance> r5 = new CollectYataFragment$initData$3(this);
        CollectParams r12 = this.o;
        CollectYataViewModel r13 = V90();
        LifecycleOwner r14 = JediView.DefaultImpls.getLifecycleOwner(this);
        r11.getClass();
        Intrinsics.checkNotNullParameter(r5, "yaTaInstance");
        Intrinsics.checkNotNullParameter(r13, "collectYataViewModel");
        Intrinsics.checkNotNullParameter(r14, "lifecycleOwner");
        r11.a = r5;
        r11.b = r12;
        r11.d = r14;
        r11.c = new com.bytedance.android.shopping.collect.util.e(r13, r5);
    L16:
        V90().requestQuery(CollectYataQueryFrom.FIRST_ENTER);
        int r15 = ECSdk.a;
        IECFeedbackService r16 = (IECFeedbackService) ECSdk.a(IECFeedbackService.class);
        if (r16 == null) goto L20;
        r16.registerScreenCapture(getContext(), this);
        return;
    L20:
        return;
    L5:
        r8 = null;
        goto L7
    }

    public final void onViewCreated(View r14, Bundle r15) {
        Intrinsics.checkNotNullParameter(r14, FreqActions.ACTION_VIEW);
        super.onViewCreated(r14, r15);
        CollectCommonLog.c("CollectYataFragmentPage", "onViewCreated");
        ((PageFinder) this.m.getValue()).view = r14;
        U90().d(CollectYataStatusController.StatusType.SKELETON);
        CollectGoodsLinkedScrollView r16 = S90();
        if (r16 == null) goto L6;
        RecyclerView r17 = r16.getRv();
        if (r17 == null) goto L6;
    L7:
        this.j = r17;
        r17.setLayoutManager(new LinearLayoutManager(r17.getContext(), 1, false));
        CollectParams r0 = this.o;
        if (r0 != null) goto L10;
    L18:
        pb3.a r18 = V90().getMonitorManager();
        if (r18 == null) goto L23;
        CollectYataFpsMonitor r19 = r18.d;
        if (r19 == null) goto L23;
        r19.a(this.j);
    L23:
        CollectParams r110 = this.o;
        if (r110 != null) goto L26;
    L35:
        View r111 = getView();
        if (r111 == null) goto L40;
        View r112 = r111.findViewById(2131373888);
        if (r112 == null) goto L40;
        r112.setVisibility(8);
    L40:
        int r113 = com.bytedance.kmp.ec.yata.view.render.delegate.v2.a.e;
        com.bytedance.kmp.ec.yata.view.render.delegate.v2.a r1 = com.bytedance.kmp.ec.yata.view.render.delegate.v2.a.a.b(this, "yata_collects");
        SlcRenderContext r4 = r1.b;
        CollectYataAbilityProvider r5 = new CollectYataAbilityProvider(requireContext(), this, r1);
        int r2 = AndroidYataBuilderManager.a;
        SlcRenderContext r3 = r5.m.b;
        r3.p(MapsKt.mapOf(TuplesKt.to("app_theme", r5.c)));
        r3.j = false;
        int r6 = c.a;
        r3.k = ECSettingKeys.t().a();
        r3.g = true;
        com.bytedance.kmp.ec.yata.b r114 = AndroidYataBuilderManager.a("yata_collects", r5, r5.m, null, CollectYataFragment$initYataSlice$1.INSTANCE);
        View r7 = getView();
        if (r7 == null) goto L44;
        LinearLayout r8 = (LinearLayout) r7.findViewById(2131367143);
        if (r8 == null) goto L44;
    L45:
        com.bytedance.kmp.ec.yata.b.c(r114, r8);
        CollectGoodsLinkedScrollView r9 = S90();
        if (r9 == null) goto L49;
        RecyclerView r10 = r9.getRv();
        if (r10 == null) goto L49;
    L50:
        com.bytedance.kmp.ec.yata.b.a(r114, r10);
        View r11 = getView();
        if (r11 == null) goto L54;
        LinearLayout r12 = (LinearLayout) r11.findViewById(2131367142);
        if (r12 == null) goto L54;
    L55:
        com.bytedance.kmp.ec.yata.b.b(r114, r12);
        com.bytedance.kmp.ec.yata.b.d(r114, "sort_panel", T90());
        AndroidYaTaInstance r115 = r114.a;
        this.k = r115;
        if (r115 == null) goto L58;
        r115.c(new ub3.b(V90()));
    L58:
        AndroidYaTaInstance r116 = this.k;
        if (r116 == null) goto L61;
        r4.o("yataInstance", r116);
    L61:
        ((nb3.a) this.l.getValue()).getClass();
        Intrinsics.checkNotNullParameter(this, "fragment");
        Iterator r117 = CollectionsKt.listOf(new Pair[]{TuplesKt.to("selfToast", new h(this)), TuplesKt.to("selfHandleEventWhenAppear", new com.bytedance.android.shopping.collect.function.base.c(this)), TuplesKt.to("selfQuitCollect", new f(this)), TuplesKt.to("selfOpenOrCloseSortPanel", new com.bytedance.android.shopping.collect.function.base.d(this)), TuplesKt.to("selfDelay", new com.bytedance.android.shopping.collect.function.base.a(this)), TuplesKt.to("selfScrollToTop", new com.bytedance.android.shopping.collect.function.base.e(this)), TuplesKt.to("selfPreCheck", new g(this))}).iterator();
    L63:
        if (r117.hasNext() == false) goto L67;
        Pair r13 = (Pair) r117.next();
        AndroidYaTaInstance r20 = this.k;
        if (r20 == null) goto L63;
        r20.B((String) r13.getFirst(), (com.bytedance.kmp.ec.yata.event.common.d) r13.getSecond());
        goto L63
    L67:
        AndroidYaTaInstance r118 = this.k;
        if (r118 == null) goto L70;
        r118.A("selfCheckFooter", new ob3.a());
    L70:
        CollectGoodsLinkedScrollView r119 = S90();
        if (r119 == null) goto L73;
        r119.setCommentAbility(this.n);
    L73:
        ISubscriber.DefaultImpls.selectSubscribe$default(this, V90(), CollectYataFragment$initSubscribe$1.INSTANCE, null, new CollectYataFragment$initSubscribe$2(this), 2, null);
        ISubscriber.DefaultImpls.selectSubscribe$default(this, V90(), CollectYataFragment$initSubscribe$3.INSTANCE, null, new CollectYataFragment$initSubscribe$4(this), 2, null);
        CollectRootContainerConstraintLayout r120 = (CollectRootContainerConstraintLayout) r14.findViewById(2131367134);
        if (r120 == null) goto L76;
        b r121 = this.r;
        Intrinsics.checkNotNullParameter(r121, "listener");
        ((ArrayList) r120.a).add(r121);
    L76:
        CollectParams r122 = this.o;
        if (r122 != null) goto L79;
        return;
    L79:
        if (r122.isFromPersonal() == true) goto L81;
        return;
    L81:
        if (ECSettingKeys.s() == false) goto L93;
        CollectGoodsLinkedScrollView r123 = S90();
        if (r123 == null) goto L94;
        r123.setNeedBlockLongClick(true);
        return;
    L94:
        return;
    L93:
        return;
    L54:
        r12 = new LinearLayout(getContext());
    L49:
        r10 = new RecyclerView(requireContext());
    L44:
        r8 = new LinearLayout(getContext());
        goto L45
    L26:
        if (r110.isFromPersonal() != true) goto L35;
        View r124 = getView();
        if (r124 == null) goto L32;
        View r125 = r124.findViewById(2131373888);
        if (r125 == null) goto L32;
        r125.setVisibility(0);
    L32:
        RecyclerView r126 = this.j;
        if (r126 == null) goto L40;
        r126.setPadding(0, 0, 0, UnitExtensionKt.dp2px(8));
        goto L40
    L10:
        if (r0.isFromPersonal() != true) goto L18;
        if (ECAppInfoService.e.isNightMode() == false) goto L18;
        Context r21 = r17.getContext();
        if (r21 == null) goto L16;
        Drawable r22 = r21.getDrawable(2131101609);
    L17:
        r17.setBackground(r22);
        goto L18
    L16:
        r22 = null;
    L6:
        r17 = new RecyclerView(requireContext());
        goto L7
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

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131559846, r3, false);
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
