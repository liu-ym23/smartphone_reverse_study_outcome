package com.bytedance.android.shopping.sku.inner.container;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.btm.api.BtmSDKWrapper;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.async.DisposableScope;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.jedi.ReflectViewModelFactory;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.k1;
import com.bytedance.android.ec.model.live.LiveClearScreenMode;
import com.bytedance.android.ec.model.live.LiveScreenMoveMode;
import com.bytedance.android.ec.model.sku.SkuParams;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.shopping.abscontainer.common_biz.platform.SliceTemplateManager;
import com.bytedance.android.shopping.api.IEShoppingService;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.android.shopping.sku.common.ability.SkuAbilityType;
import com.bytedance.android.shopping.sku.common.ability.SkuCommonAbility;
import com.bytedance.android.shopping.sku.common.monitor.error.SkuErrorMonitorType;
import com.bytedance.android.shopping.sku.common.monitor.fps.SkuYataFpsMonitor;
import com.bytedance.android.shopping.sku.common.utils.SkuCommonLog;
import com.bytedance.android.shopping.sku.inner.controller.SkuYataRecyclerBottomSheetController;
import com.bytedance.android.shopping.sku.inner.controller.SkuYataSliceServerTimeController;
import com.bytedance.android.shopping.sku.inner.controller.SkuYataStatusController;
import com.bytedance.android.shopping.sku.inner.slice.SkuYataTemplateManager;
import com.bytedance.android.shopping.sku.inner.yata.abilities.SkuYataAbilityProvider;
import com.bytedance.android.shopping.sku.params.schema.SkuSchemaParams;
import com.bytedance.android.shopping.yata.init.AndroidYataBuilderManager;
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
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u00032\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t:\u0001\u000eB\u0007¢\u0006\u0004\b\f\u0010\rJ\n\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/shopping/sku/inner/container/SkuFullScreenFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/bytedance/jedi/arch/JediView;", "Lcom/bytedance/jedi/arch/ViewModelFactoryOwner;", "Lcom/bytedance/android/ec/core/jedi/ReflectViewModelFactory;", "Lcom/bytedance/android/ec/core/async/b;", "Lcom/bytedance/android/shopping/sku/inner/container/b;", "Lcom/bytedance/android/shopping/sku/inner/yata/abilities/a;", "Lcom/bytedance/android/ec/core/gallery2/opt/b;", "Lcom/bytedance/android/ec/model/live/s;", "Landroid/content/Context;", "getContext", "<init>", "()V", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SkuFullScreenFragment extends Fragment implements JediView, ViewModelFactoryOwner<ReflectViewModelFactory>, com.bytedance.android.ec.core.async.b, com.bytedance.android.shopping.sku.inner.container.b, com.bytedance.android.shopping.sku.inner.yata.abilities.a, com.bytedance.android.ec.core.gallery2.opt.b, com.bytedance.android.ec.model.live.s {
    public static final /* synthetic */ int t = 0;
    public Map<Integer, View> d;
    public final lifecycleAwareLazy e;
    public Context f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;
    public AndroidYaTaInstance m;
    public SlcRenderContext n;
    public final Lazy o;
    public final Lazy p;
    public final SkuCommonAbility q;
    public final Lazy r;
    public final /* synthetic */ DisposableScope s;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ SkuFullScreenFragment a;

        public b(SkuFullScreenFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r11) {
            SkuFullScreenFragment r12 = this.a;
            AndroidYaTaInstance r0 = r12.m;
            Object r1 = null;
            if (r0 == null) goto L5;
            Boolean r2 = Boolean.valueOf(r0.J());
        L7:
            if (com.bytedance.android.shopping.extensions.k.i(r2) == true) goto L47;
            AndroidYaTaInstance r4 = r12.m;
            if (r4 == null) goto L12;
            Object r13 = r4.i("side_slip");
        L14:
            if ((r13 instanceof Map) == true) goto L16;
            r13 = null;
        L16:
            Map r14 = (Map) r13;
            if (r14 == null) goto L19;
            Object r3 = r14.get("target_component_name");
        L21:
            if ((r3 instanceof String) == true) goto L23;
            r3 = null;
        L23:
            String r5 = (String) r3;
            if (r14 == null) goto L26;
            Object r6 = r14.get("target_yata_key");
        L28:
            if ((r6 instanceof String) == true) goto L30;
            r6 = null;
        L30:
            String r7 = (String) r6;
            if (r14 == null) goto L33;
            Object r15 = r14.get("quit_event_name");
        L35:
            if ((r15 instanceof String) == false) goto L38;
            r1 = r15;
        L38:
            String r8 = (String) r1;
            if (r5 == null) goto L48;
            if (r7 == null) goto L48;
            if (r8 == null) goto L48;
            com.bytedance.kmp.ec.yata.store.node.c r16 = com.bytedance.android.shopping.buynow.utils.h.a(r4, r5, r7);
            if (r16 == null) goto L48;
            r4.k().d(com.bytedance.kmp.ec.yata.event.common.e.a.a(r4, null, r16.getKey(), r8, null, "onBackKeyPressed"));
        L48:
            boolean r17 = false;
        L49:
            if (r17 == false) goto L51;
            return;
        L51:
            this.a.close(0);
            return;
        L33:
            r15 = null;
            goto L35
        L26:
            r6 = null;
            goto L28
        L19:
            r3 = null;
            goto L21
        L12:
            r13 = null;
        L47:
            r17 = true;
            goto L49
        L5:
            r2 = null;
            goto L7
        }
    }

    public final SkuYataStatusController U90() {
        return (SkuYataStatusController) this.g.getValue();
    }

    public final SkuYataViewModel V90() {
        return (SkuYataViewModel) this.e.getValue();
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

    @Override // com.bytedance.android.shopping.sku.inner.container.b
    public final String tag() {
        return "SkuSkuFullScreenFragmentPage";
    }

    @Override // com.bytedance.android.shopping.sku.inner.container.b
    public final com.bytedance.android.shopping.sku.common.ability.c zJ() {
        return null;
    }

    static {
        Lazy r0 = BtmSDKWrapper.a;
        BtmSDKWrapper.c(SkuFullScreenFragment.class, "a1.b5267");
    }

    @Override // com.bytedance.android.shopping.sku.inner.container.b
    public final SkuYataSliceServerTimeController AG() {
        return (SkuYataSliceServerTimeController) this.i.getValue();
    }

    @Override // com.bytedance.android.shopping.sku.inner.yata.abilities.a
    public final void KJ() {
        SkuCommonLog.c("SkuSkuFullScreenFragmentPage", "onUpScreenFinish");
        com.bytedance.android.shopping.sku.common.utils.e.a r0 = com.bytedance.android.shopping.sku.common.utils.e.a;
        com.bytedance.android.shopping.sku.common.utils.e.b(new SkuFullScreenFragment$onUpScreenFinish$1(this));
    }

    public final CompositeDisposable compositeDisposable() {
        return this.s.a();
    }

    @Override // com.bytedance.android.shopping.sku.inner.container.b
    public final com.bytedance.android.ecom.arch.slice.render.context.b d8() {
        int r0 = com.bytedance.android.shopping.sku.common.utils.c.a;
        float r1 = com.bytedance.android.shopping.sku.common.utils.c.a(ECAppInfoService.e.getCurrentActivity()).a;
        nj.d r2 = com.bytedance.android.ec.sdk.helper.d.b.getPadSplitService();
        if (r2 == null) goto L5;
        r2.getSpiltWidth();
        float r3 = 0;
    L6:
        float r4 = (r1 * 375.0f) / r3;
        com.bytedance.android.ecom.arch.slice.render.context.b.f.getClass();
        return com.bytedance.android.ecom.arch.slice.render.context.b.a.d(r4, 1.0f, 1.0f);
    L5:
        r3 = 360.0f;
        goto L6
    }

    public Context getContext() {
        if (this.f != null) goto L10;
        Context r0 = super.getContext();
        if (r0 == null) goto L7;
        Context r1 = th.a.e(r0, true);
    L8:
        this.f = r1;
        goto L10
    L7:
        r1 = null;
    L10:
        return this.f;
    }

    public final ViewModelProvider.Factory getViewModelFactory() {
        return new ReflectViewModelFactory();
    }

    @Override // com.bytedance.android.shopping.sku.inner.container.b
    public final PageFinder tS() {
        return (PageFinder) this.p.getValue();
    }

    public SkuFullScreenFragment() {
        this.s = new DisposableScope();
        this.d = new LinkedHashMap();
        final KClass r0 = Reflection.getOrCreateKotlinClass(SkuYataViewModel.class);
        final Function0<String> r1 = new SkuFullScreenFragment$$special$$inlined$viewModel$1(r0);
        final SkuFullScreenFragment$$special$$inlined$viewModel$2 r2 = SkuFullScreenFragment$$special$$inlined$viewModel$2.INSTANCE;
        this.e = new lifecycleAwareLazy(this, r1, new SkuFullScreenFragment$$special$$inlined$viewModel$3(this, r1, r0, r2));
        this.g = LazyKt.lazy(new SkuFullScreenFragment$statusController$2(this));
        this.h = LazyKt.lazy(new SkuFullScreenFragment$panelSizeController$2(this));
        this.i = LazyKt.lazy(SkuFullScreenFragment$sliceServerTimeController$2.INSTANCE);
        this.j = LazyKt.lazy(new SkuFullScreenFragment$assembleDataController$2(this));
        this.k = LazyKt.lazy(new SkuFullScreenFragment$eventController$2(this));
        this.l = LazyKt.lazy(SkuFullScreenFragment$floatViewController$2.INSTANCE);
        this.o = LazyKt.lazy(SkuFullScreenFragment$yataFunctionCenter$2.INSTANCE);
        this.p = LazyKt.lazy(new SkuFullScreenFragment$btmPageFinder$2(this));
        int r3 = SkuCommonAbility.j;
        SkuAbilityType r4 = SkuAbilityType.SKU;
        Intrinsics.checkNotNullParameter(r4, "type");
        this.q = new SkuCommonAbility(r4);
        this.r = LazyKt.lazy(new SkuFullScreenFragment$orientationListener$2(this));
    }

    @Override // com.bytedance.android.shopping.sku.inner.container.b
    public final Activity P2() {
        return getActivity();
    }

    @Override // com.bytedance.android.shopping.sku.inner.container.b
    public final RecyclerView QB() {
        return T90();
    }

    public final RecyclerView T90() {
        View r0 = getView();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.findViewById(2131386834);
    }

    public final boolean W90() {
        if (V90().getSkuParams().isSplitScreen() == true) goto L5;
    L7:
        return false;
    L5:
        if (V90().getSkuParams().getSplitScreenHalfMode() == true) goto L7;
        return true;
    }

    @Override // com.bytedance.android.shopping.sku.inner.container.b
    public final ViewGroup cM() {
        return (ViewGroup) S90(2131386844);
    }

    @Override // com.bytedance.android.shopping.sku.inner.container.b
    public final Context context() {
        return requireContext();
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

    @Override // com.bytedance.android.shopping.sku.inner.container.b
    public final View i() {
        return getView();
    }

    @Override // com.bytedance.android.shopping.sku.inner.container.b
    public final SkuYataStatusController n20() {
        return U90();
    }

    public final void onDestroy() {
        super.onDestroy();
        SkuCommonLog.c("SkuSkuFullScreenFragmentPage", "onDestroy");
        com.bytedance.android.shopping.sku.inner.controller.d r0 = (com.bytedance.android.shopping.sku.inner.controller.d) this.l.getValue();
        if (r0.c == false) goto L5;
        List r1 = ul.b.a;
        ul.b.a(r0.b);
        r0.c = false;
    L5:
        nj.d r2 = com.bytedance.android.ec.sdk.helper.d.b.getPadSplitService();
        if (r2 == null) goto L8;
        nj.c r3 = (nj.c) this.r.getValue();
        r2.e();
    L8:
        this.q.u(requireContext(), V90().getStaticState().e);
        Map<String, mh3.a> r4 = mh3.a.m;
        mh3.a.C0219a.b(V90().getSkuParams().getMonitorId());
        V90().release();
    }

    public final void onDestroyView() {
        super.onDestroyView();
        SkuCommonLog.c("SkuSkuFullScreenFragmentPage", "onDestroyView");
        clearDisposable();
        mh3.a r0 = V90().getMonitorManager();
        if (r0 == null) goto L7;
        SkuYataFpsMonitor r1 = r0.d;
        if (r1 == null) goto L7;
        r1.b();
    L7:
        AndroidYaTaInstance r2 = this.m;
        if (r2 == null) goto L10;
        r2.d();
    L10:
        U90();
        ((LinkedHashMap) this.d).clear();
    }

    public final void onDetach() {
        super.onDetach();
        SkuCommonLog.c("SkuSkuFullScreenFragmentPage", "onDetach");
        com.bytedance.android.shopping.sku.inner.controller.b r0 = (com.bytedance.android.shopping.sku.inner.controller.b) this.k.getValue();
        ECLiveHybridUtil.p("closeHalfSku", r0.a);
        r0.b.dq().a();
    }

    public final void onResume() {
        super.onResume();
        SkuCommonLog.c("SkuSkuFullScreenFragmentPage", "onResume");
        this.q.onResume();
    }

    public final void onStart() {
        super.onStart();
        SkuCommonLog.c("SkuSkuFullScreenFragmentPage", "onStart");
        this.q.onStart();
        if (W90() == true) goto L10;
        ConstraintLayout r0 = S90(2131381805);
        r0.setOnClickListener(new b(this));
        String r1 = a2.d(V90().getSkuParams().getMaskBackgroundColor());
        if (r1 == null) goto L7;
        int r2 = ColorProtector.parseColor(r1);
    L8:
        r0.setBackgroundColor(r2);
        return;
    L7:
        r2 = Color.argb((int) (V90().getSkuParams().getMaskAlpha() * 255), 0, 0, 0);
        goto L8
    }

    public final void onStop() {
        super.onStop();
        this.q.onStop();
    }

    @Override // com.bytedance.android.shopping.sku.inner.container.b
    public final SkuYataViewModel qn() {
        return V90();
    }

    public final LiveScreenMoveMode AC() {
        return LiveScreenMoveMode.LIVE_SCREEN_MOVE_UP;
    }

    @Override // com.bytedance.android.shopping.sku.inner.container.b
    public final SlcRenderContext Ul() {
        return this.n;
    }

    @Override // com.bytedance.android.shopping.sku.inner.container.b
    public final AndroidYaTaInstance bV() {
        return this.m;
    }

    public final LiveClearScreenMode cy() {
        return LiveClearScreenMode.CLEAR_SCREEN_MODE_FULL;
    }

    @Override // com.bytedance.android.shopping.sku.inner.container.b
    public final SkuCommonAbility dq() {
        return this.q;
    }

    /* JADX INFO: renamed from: getReceiver, reason: collision with other method in class */
    public final IdentitySubscriber m2813getReceiver() {
        return JediView.DefaultImpls.getReceiver(this);
    }

    @Override // com.bytedance.android.shopping.sku.inner.yata.abilities.a
    public final void EJ(final com.bytedance.kmp.ec.yata.common.biz.callback.a r3) {
        Intrinsics.checkNotNullParameter(r3, "model");
        SkuCommonLog.c("SkuSkuFullScreenFragmentPage", "onUplinkStart");
        com.bytedance.android.shopping.sku.common.utils.e.a r0 = com.bytedance.android.shopping.sku.common.utils.e.a;
        com.bytedance.android.shopping.sku.common.utils.e.b(new SkuFullScreenFragment$onUplinkStart$1(this, r3));
    }

    public final void Q70(Map r4) {
        Intrinsics.checkNotNullParameter("gallery_viewer_module_show", "eventName");
        Intrinsics.checkNotNullParameter(r4, "params");
        V90().getTracker().b(PageFinder.via(this), "gallery_viewer_module_show", r4);
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

    @Override // com.bytedance.android.shopping.sku.inner.container.b
    public final void close(int r2) {
        V90().getStaticState().e.a = r2;
        nj.d r3 = com.bytedance.android.ec.sdk.helper.d.b.getPadSplitService();
        if (r3 == null) goto L6;
        getActivity();
        r3.m();
        return;
    }

    public final void onActivityCreated(Bundle r10) {
        super.onActivityCreated(r10);
        SkuCommonLog.c("SkuSkuFullScreenFragmentPage", "onActivityCreated");
        if (W90() == true) goto L10;
        TranslateAnimation r11 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        r11.setDuration(390);
        r11.setInterpolator(new com.bytedance.android.shopping.anchorv4.helper.a0());
        View r0 = S90(2131386851);
        if (r0 == null) goto L9;
        r0.startAnimation(r11);
        return;
    L9:
        return;
    }

    public final void onAttach(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super.onAttach(r4);
        SkuCommonLog.c("SkuSkuFullScreenFragmentPage", "onAttach");
        SkuYataTemplateManager.a();
        this.q.getClass();
        SliceTemplateManager.a();
        SkuYataTemplateManager.b(r4);
        com.bytedance.android.shopping.sku.inner.controller.b r5 = (com.bytedance.android.shopping.sku.inner.controller.b) this.k.getValue();
        ECLiveHybridUtil.m("closeHalfSku", r5.a);
        r5.b.dq().w(r5.b, new com.bytedance.android.shopping.sku.inner.controller.c(r5));
    }

    public final void onCreate(Bundle r9) {
        super.onCreate(r9);
        Lazy r10 = SkuCommonLog.a;
        SkuCommonLog.a("SkuSkuFullScreenFragmentPage", AnonymousClass1.INSTANCE);
        Bundle r11 = getArguments();
        Serializable r1 = null;
        if (r11 == null) goto L5;
        String r12 = r11.getString("source_btm_token");
    L6:
        Lazy r2 = BtmSDKWrapper.a;
        BtmSDKWrapper.b(this, "a1.b5267", r12);
        SkuCommonLog.c("SkuSkuFullScreenFragmentPage", "sourceBtmToken:" + r12);
        Bundle r13 = getArguments();
        if (r13 == null) goto L9;
        Serializable r14 = r13.getSerializable("sku_params");
    L11:
        if ((r14 instanceof SkuParams) == true) goto L13;
        r14 = null;
    L13:
        SkuParams r3 = (SkuParams) r14;
        if (r3 == null) goto L30;
        Bundle r15 = getArguments();
        if (r15 == null) goto L19;
        Serializable r16 = r15.getSerializable("sku_schema_params");
    L21:
        if ((r16 instanceof SkuSchemaParams) == false) goto L24;
        r1 = r16;
    L24:
        SkuSchemaParams r4 = (SkuSchemaParams) r1;
        Bundle r17 = getArguments();
        if (r17 == null) goto L28;
        String r18 = r17.getString("session_id");
        if (r18 == null) goto L28;
    L29:
        V90().init(r3, r4, (PageFinder) this.p.getValue(), r18, this);
        this.q.x(new SkuFullScreenFragment$initData$1(this), new SkuFullScreenFragment$initData$2(this));
        close(0);
    L28:
        r18 = UUID.randomUUID().toString();
        goto L29
    L19:
        r16 = null;
    L30:
        V90().getTracker().d();
        V90().requestQuery(SkuYataQueryFrom.FIRST_SCREEN);
        com.bytedance.android.shopping.utils.e0.a();
        getContext();
        int r19 = ECSdk.a;
        IEShoppingService r20 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r20 == null) goto L36;
        sc3.c r21 = r20.getBuyNowService();
        if (r21 == null) goto L37;
        r21.c();
        return;
    L37:
        return;
    L36:
        return;
    L9:
        r14 = null;
        goto L11
    L5:
        r12 = null;
        goto L6
    }

    public final void onViewCreated(View r13, Bundle r14) {
        Intrinsics.checkNotNullParameter(r13, FreqActions.ACTION_VIEW);
        super.onViewCreated(r13, r14);
        SkuCommonLog.c("SkuSkuFullScreenFragmentPage", "onViewCreated");
        ((PageFinder) this.p.getValue()).view = r13;
        U90().c(SkuYataStatusController.StatusType.SKELETON);
        RecyclerView r15 = T90();
        boolean r0 = true;
        if (r15 == null) goto L5;
        r15.setLayoutManager(new LinearLayoutManager(r15.getContext(), 1, false));
    L5:
        ConcurrentHashMap r16 = a43.a.a;
        if (Intrinsics.areEqual(l43.a.a("legou_sku_buy_layout_opt"), 1) == false) goto L10;
        View r17 = S90(2131386851);
        if (r17 == null) goto L10;
        r17.setBackgroundResource(2131248234);
    L10:
        new SkuYataRecyclerBottomSheetController(T90()).a();
        LinearLayout r18 = (LinearLayout) S90(2131386841);
        if (r18 == null) goto L13;
        r18.setOnClickListener(new f(this));
    L13:
        ImageView r19 = (ImageView) S90(2131386849);
        if (r19 == null) goto L16;
        r19.setOnClickListener(new g(this));
    L16:
        LinearLayout r3 = (LinearLayout) S90(2131386871);
        if (r3 == null) goto L19;
        r3.setOnClickListener(new h(this));
    L19:
        View r4 = S90(2131381866);
        if (r4 == null) goto L22;
        r4.setOnClickListener(i.a);
    L22:
        ConstraintLayout r5 = S90(2131386851);
        Window r6 = null;
        if (r5 == null) goto L46;
        ConstraintLayout r7 = S90(2131386851);
        if (r7 == null) goto L44;
        ViewGroup.LayoutParams r8 = r7.getLayoutParams();
        if (r8 == null) goto L44;
        if (W90() == false) goto L31;
        float r9 = d8().a;
        Resources r10 = Resources.getSystem();
        float r11 = r9 / WindowDisplayMetricsOverride.apply(r10, r10.getDisplayMetrics()).density;
        int r12 = com.bytedance.android.shopping.sku.common.utils.c.a;
        Number r20 = Float.valueOf((((com.bytedance.android.shopping.sku.common.utils.c.a(getActivity()).b - k1.g()) - k1.q()) - com.bytedance.android.shopping.extensions.b.b(26)) - (com.bytedance.android.shopping.extensions.b.b(21) * r11));
    L36:
        SkuCommonLog.c("SkuSkuFullScreenFragmentPage", "contentHeight:" + r20);
        r8.height = r20.intValue();
        if (Intrinsics.areEqual(r20, 0) == false) goto L43;
        mh3.a r110 = V90().getMonitorManager();
        if (r110 == null) goto L43;
        com.bytedance.android.shopping.sku.common.monitor.error.a r111 = r110.c;
        if (r111 == null) goto L43;
        SkuErrorMonitorType r21 = SkuErrorMonitorType.SERIOUS_BUSINESS_ERROR;
        String r22 = "contentHeight is 0;  heightPercent:" + V90().getSkuParams().getHeightPercent();
        Map<String, com.bytedance.android.shopping.sku.common.monitor.error.a> r23 = com.bytedance.android.shopping.sku.common.monitor.error.a.b;
        r111.a(r21, r22, null);
    L43:
        Unit r112 = Unit.INSTANCE;
    L45:
        r5.setLayoutParams(r8);
        goto L46
    L31:
        com.bytedance.android.shopping.sku.inner.controller.e r24 = (com.bytedance.android.shopping.sku.inner.controller.e) this.h.getValue();
        Integer r25 = V90().getSkuParams().getHeightPercent();
        if (r25 == null) goto L34;
        int r26 = r25.intValue();
    L35:
        r20 = Integer.valueOf(r24.a(r26));
        goto L36
    L34:
        r26 = 73;
    L44:
        r8 = null;
    L46:
        com.bytedance.android.shopping.sku.inner.controller.d r113 = (com.bytedance.android.shopping.sku.inner.controller.d) this.l.getValue();
        View r27 = S90(2131386871);
        r113.getClass();
        r113.a = new WeakReference(r27);
        mh3.a r114 = V90().getMonitorManager();
        if (r114 == null) goto L52;
        SkuYataFpsMonitor r115 = r114.d;
        if (r115 == null) goto L52;
        r115.a(T90());
    L52:
        if (W90() == false) goto L54;
        S90(2131381805).setBackgroundColor(ColorProtector.parseColor("#F5F6F9"));
    L54:
        ConstraintLayout r116 = S90(2131386851);
        if (r116 == null) goto L57;
        r116.setOnClickListener(j.a);
    L57:
        int r117 = AndroidYataBuilderManager.a;
        com.bytedance.kmp.ec.yata.b r118 = AndroidYataBuilderManager.a("yata_sku", new SkuYataAbilityProvider(requireContext(), this), null, null, SkuFullScreenFragment$initYataSlice$1.INSTANCE);
        com.bytedance.kmp.ec.yata.b.c(r118, (LinearLayout) S90(2131386845));
        com.bytedance.kmp.ec.yata.b.a(r118, S90(2131386834));
        com.bytedance.kmp.ec.yata.b.b(r118, (LinearLayout) S90(2131386844));
        com.bytedance.kmp.ec.yata.b.d(r118, "top", (LinearLayout) S90(2131386871));
        r118.e((FrameLayout) S90(2131382786));
        AndroidYaTaInstance r119 = r118.a;
        this.m = r119;
        if (r119 == null) goto L60;
        r119.E(new k(this));
    L60:
        AndroidYaTaInstance r120 = this.m;
        if (r120 == null) goto L63;
        r120.D(new l(this));
    L63:
        ((oh3.a) this.o.getValue()).getClass();
        oh3.a.a(this);
        AndroidYaTaInstance r121 = this.m;
        if (r121 == null) goto L66;
        SlcRenderContext r122 = (SlcRenderContext) r121.I(Reflection.getOrCreateKotlinClass(SlcRenderContext.class));
    L67:
        this.n = r122;
        if (r122 == null) goto L70;
        r122.j = false;
    L70:
        if (r122 == null) goto L72;
        int r123 = e0.a;
        r122.k = ECSettingKeys.Y().a();
    L72:
        SlcRenderContext r124 = this.n;
        if (r124 == null) goto L75;
        r124.g = true;
    L75:
        if (r124 == null) goto L77;
        r124.f = d8();
    L77:
        SkuYataSliceServerTimeController r125 = (SkuYataSliceServerTimeController) this.i.getValue();
        SlcRenderContext r126 = this.n;
        r125.getClass();
        if (r126 == null) goto L80;
        r126.r(System.currentTimeMillis() / ((long) 1000));
    L80:
        Activity r127 = com.bytedance.android.shopping.anchorv3.utils.d0.a.getActivity(getContext());
        if (r127 == null) goto L93;
        Window r128 = r127.getWindow();
        if (r128 == null) goto L93;
        View r129 = r128.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L89;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r130 = ThreadMethodProxy.currentThread();
        if (r130 == com.larus.home.impl.utils.c.a) goto L89;
        com.larus.home.impl.utils.c.a(r130, "getDecorView");
    L89:
        if (r129 == null) goto L93;
        SlcRenderContext r131 = this.n;
        if (r131 == null) goto L98;
        r131.q(new com.bytedance.android.ecom.arch.slice.render.context.e(true, r129, true, new n(r129)));
    L98:
        SkuCommonAbility r132 = this.q;
        SlcRenderContext r133 = this.n;
        FragmentActivity r28 = getActivity();
        if (r28 == null) goto L101;
        r6 = r28.getWindow();
    L101:
        r132.g(r133, r6, T90(), (ViewGroup) S90(2131386844));
        RecyclerView r134 = T90();
        if (r134 == null) goto L104;
        r134.addOnItemTouchListener(new SkuFullScreenFragment$initYataSlice$6(this));
    L104:
        ISubscriber.DefaultImpls.selectSubscribe$default(this, V90(), SkuFullScreenFragment$initSubscribe$1.INSTANCE, null, new SkuFullScreenFragment$initSubscribe$2(this), 2, null);
        ISubscriber.DefaultImpls.selectSubscribe$default(this, V90(), SkuFullScreenFragment$initSubscribe$3.INSTANCE, null, new SkuFullScreenFragment$initSubscribe$4(this), 2, null);
        nj.d r135 = com.bytedance.android.ec.sdk.helper.d.b.getPadSplitService();
        if (r135 == null) goto L107;
        nj.c r136 = (nj.c) this.r.getValue();
        r135.b();
    L107:
        boolean r137 = ECAppInfoService.e.i();
        if (r137 == false) goto L130;
        wg.a.h(S90(2131368571), r137);
        ((TextView) S90(2131368571)).setOnClickListener(d.a);
        TextView r138 = (TextView) S90(2131368571);
        int r2 = q.a;
        if (V90().getSkuSchemaParams() != null) goto L114;
        r0 = false;
    L114:
        if (r0 == false) goto L116;
        String r1 = "组件化sku\nschema重构";
    L117:
        r138.setText(r1);
        View r139 = getView();
        if (r139 == null) goto L122;
        TextView r140 = (TextView) r139.findViewById(2131368572);
        if (r140 == null) goto L122;
        wg.a.h(r140, r137);
    L122:
        View r141 = getView();
        if (r141 == null) goto L128;
        TextView r142 = (TextView) r141.findViewById(2131368572);
        if (r142 == null) goto L129;
        r142.setOnClickListener(new e(this));
        return;
    L129:
        return;
    L128:
        return;
    L116:
        r1 = "组件化sku\n非schema重构";
        goto L117
    L130:
        return;
    L93:
        Map<String, mh3.a> r143 = mh3.a.m;
        mh3.a r144 = mh3.a.C0219a.c(V90().getSkuParams().getMonitorId());
        if (r144 == null) goto L98;
        com.bytedance.android.shopping.sku.common.monitor.error.a r145 = r144.c;
        if (r145 == null) goto L98;
        SkuErrorMonitorType r146 = SkuErrorMonitorType.SERIOUS_BUSINESS_ERROR;
        Map<String, com.bytedance.android.shopping.sku.common.monitor.error.a> r29 = com.bytedance.android.shopping.sku.common.monitor.error.a.b;
        r145.a(r146, "SkuSkuFullScreenFragmentPage-fragment.getActivityDecorView failed ", null);
        goto L98
    L66:
        r122 = null;
        goto L67
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
        SkuCommonLog.c("SkuSkuFullScreenFragmentPage", "onCreateView");
        return r2.inflate(2131564880, r3, false);
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
