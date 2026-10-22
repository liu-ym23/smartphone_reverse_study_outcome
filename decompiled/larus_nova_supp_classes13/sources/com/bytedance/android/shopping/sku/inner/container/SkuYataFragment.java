package com.bytedance.android.shopping.sku.inner.container;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.btm.api.BtmSDKWrapper;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.async.DisposableScope;
import com.bytedance.android.ec.core.buynow.BuyNowPerformanceOpt;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.jedi.ReflectViewModelFactory;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.UIUtils;
import com.bytedance.android.ec.core.utils.k1;
import com.bytedance.android.ec.model.live.LiveClearScreenMode;
import com.bytedance.android.ec.model.live.LiveScreenMoveMode;
import com.bytedance.android.ec.model.sku.SkuParams;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.ecom.arch.slice.render.util.SlcDimensExtensionsKt;
import com.bytedance.android.shopping.abscontainer.common_biz.platform.SliceTemplateManager;
import com.bytedance.android.shopping.api.IEShoppingService;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.android.shopping.sku.common.ability.SkuAbilityType;
import com.bytedance.android.shopping.sku.common.ability.SkuCommonAbility;
import com.bytedance.android.shopping.sku.common.monitor.error.SkuErrorMonitorType;
import com.bytedance.android.shopping.sku.common.monitor.error.SkuRunCatchExtKt;
import com.bytedance.android.shopping.sku.common.monitor.fps.SkuYataFpsMonitor;
import com.bytedance.android.shopping.sku.common.utils.SkuCommonLog;
import com.bytedance.android.shopping.sku.inner.controller.ScrollNotifyController$onBodyContainerInit$1;
import com.bytedance.android.shopping.sku.inner.controller.SkuYataRecyclerBottomSheetController;
import com.bytedance.android.shopping.sku.inner.controller.SkuYataSliceServerTimeController;
import com.bytedance.android.shopping.sku.inner.controller.SkuYataStatusController;
import com.bytedance.android.shopping.sku.inner.slice.SkuYataTemplateManager;
import com.bytedance.android.shopping.sku.inner.yata.abilities.SkuYataAbilityProvider;
import com.bytedance.android.shopping.sku.params.schema.SkuSchemaParams;
import com.bytedance.android.shopping.track.TrackCatcher;
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
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u00042\u00020\u00062\u00020\u00072\u00020\b2\u00020\t:\u0001\u000eB\u0007¢\u0006\u0004\b\f\u0010\rJ\n\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/shopping/sku/inner/container/SkuYataFragment;", "Landroidx/appcompat/app/AppCompatDialogFragment;", "Lcom/bytedance/android/shopping/sku/inner/container/b;", "Lcom/bytedance/jedi/arch/JediView;", "Lcom/bytedance/jedi/arch/ViewModelFactoryOwner;", "Lcom/bytedance/android/ec/core/jedi/ReflectViewModelFactory;", "Lcom/bytedance/android/ec/core/async/b;", "Lcom/bytedance/android/shopping/sku/inner/yata/abilities/a;", "Lcom/bytedance/android/ec/core/gallery2/opt/b;", "Lcom/bytedance/android/ec/model/live/s;", "Landroid/content/Context;", "getContext", "<init>", "()V", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SkuYataFragment extends AppCompatDialogFragment implements b, JediView, ViewModelFactoryOwner<ReflectViewModelFactory>, com.bytedance.android.ec.core.async.b, com.bytedance.android.shopping.sku.inner.yata.abilities.a, com.bytedance.android.ec.core.gallery2.opt.b, com.bytedance.android.ec.model.live.s {
    public static final /* synthetic */ int v = 0;
    public Map<Integer, View> d;
    public final ReflectViewModelFactory e;
    public final lifecycleAwareLazy f;
    public Context g;
    public com.bytedance.android.shopping.buynow.controller.q h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;
    public final Lazy m;
    public com.bytedance.android.shopping.sku.common.ability.c n;
    public AndroidYaTaInstance o;
    public SlcRenderContext p;
    public final Lazy q;
    public final Lazy r;
    public final Lazy s;
    public final SkuCommonAbility t;
    public final /* synthetic */ DisposableScope u;

    public static final class a {
    }

    public final SkuYataStatusController Y90() {
        return (SkuYataStatusController) this.i.getValue();
    }

    public final SkuYataViewModel Z90() {
        return (SkuYataViewModel) this.f.getValue();
    }

    public final Disposable add(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "disposable");
        this.u.add(r2);
        return r2;
    }

    public final void clearDisposable() {
        this.u.clearDisposable();
    }

    public final void remove(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "disposable");
        this.u.remove(r2);
    }

    @Override // com.bytedance.android.shopping.sku.inner.container.b
    public final String tag() {
        return "SkuYataFragmentPage";
    }

    static {
        Lazy r0 = BtmSDKWrapper.a;
        BtmSDKWrapper.c(SkuYataFragment.class, "a1.b5267");
    }

    public final LiveScreenMoveMode AC() {
        com.bytedance.android.shopping.buynow.controller.q r0 = this.h;
        if (r0 == null) goto L8;
        if (r0.h != true) goto L8;
        return LiveScreenMoveMode.LIVE_SCREEN_MOVE_NONE;
    L8:
        return LiveScreenMoveMode.LIVE_SCREEN_MOVE_UP;
    }

    @Override // com.bytedance.android.shopping.sku.inner.container.b
    public final SkuYataSliceServerTimeController AG() {
        return (SkuYataSliceServerTimeController) this.k.getValue();
    }

    @Override // com.bytedance.android.shopping.sku.inner.yata.abilities.a
    public final void KJ() {
        SkuCommonLog.c("SkuYataFragmentPage", "onUpScreenFinish");
        com.bytedance.android.shopping.sku.common.utils.e.a r0 = com.bytedance.android.shopping.sku.common.utils.e.a;
        com.bytedance.android.shopping.sku.common.utils.e.b(new SkuYataFragment$onUpScreenFinish$1(this));
    }

    public final CompositeDisposable compositeDisposable() {
        return this.u.a();
    }

    public final LiveClearScreenMode cy() {
        com.bytedance.android.shopping.buynow.controller.q r0 = this.h;
        if (r0 == null) goto L8;
        if (r0.h != true) goto L8;
        return LiveClearScreenMode.CLEAR_SCREEN_MODE_NONE;
    L8:
        return LiveClearScreenMode.CLEAR_SCREEN_MODE_FULL;
    }

    public Context getContext() {
        if (this.g != null) goto L10;
        Context r0 = super/*androidx.fragment.app.Fragment*/.getContext();
        if (r0 == null) goto L7;
        Context r1 = th.a.e(r0, true);
    L8:
        this.g = r1;
        goto L10
    L7:
        r1 = null;
    L10:
        return this.g;
    }

    @Override // com.bytedance.android.shopping.sku.inner.container.b
    public final PageFinder tS() {
        return (PageFinder) this.r.getValue();
    }

    public SkuYataFragment() {
        this.u = new DisposableScope();
        this.d = new LinkedHashMap();
        this.e = new ReflectViewModelFactory();
        final KClass r0 = Reflection.getOrCreateKotlinClass(SkuYataViewModel.class);
        final Function0<String> r1 = new SkuYataFragment$$special$$inlined$viewModel$1(r0);
        final SkuYataFragment$$special$$inlined$viewModel$2 r2 = SkuYataFragment$$special$$inlined$viewModel$2.INSTANCE;
        this.f = new lifecycleAwareLazy(this, r1, new SkuYataFragment$$special$$inlined$viewModel$3(this, r1, r0, r2));
        this.i = LazyKt.lazy(new SkuYataFragment$statusController$2(this));
        this.j = LazyKt.lazy(new SkuYataFragment$panelSizeController$2(this));
        this.k = LazyKt.lazy(SkuYataFragment$sliceServerTimeController$2.INSTANCE);
        this.l = LazyKt.lazy(new SkuYataFragment$eventController$2(this));
        this.m = LazyKt.lazy(SkuYataFragment$floatViewController$2.INSTANCE);
        this.q = LazyKt.lazy(SkuYataFragment$yataFunctionCenter$2.INSTANCE);
        this.r = LazyKt.lazy(new SkuYataFragment$btmPageFinder$2(this));
        this.s = LazyKt.lazy(new SkuYataFragment$orientationListener$2(this));
        int r3 = SkuCommonAbility.j;
        SkuAbilityType r4 = SkuAbilityType.SKU;
        Intrinsics.checkNotNullParameter(r4, "type");
        this.t = new SkuCommonAbility(r4);
    }

    @Override // com.bytedance.android.shopping.sku.inner.container.b
    public final Activity P2() {
        return getActivity();
    }

    @Override // com.bytedance.android.shopping.sku.inner.container.b
    public final RecyclerView QB() {
        return X90();
    }

    public final RecyclerView X90() {
        View r0 = getView();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.findViewById(2131386834);
    }

    @Override // com.bytedance.android.shopping.sku.inner.container.b
    public final ViewGroup cM() {
        return (ViewGroup) S90(2131386844);
    }

    @Override // com.bytedance.android.shopping.sku.inner.container.b
    public final Context context() {
        return requireContext();
    }

    @Override // com.bytedance.android.shopping.sku.inner.container.b
    public final com.bytedance.android.ecom.arch.slice.render.context.b d8() {
        return e0.a();
    }

    public final void dismiss() {
        SkuRunCatchExtKt.a(Z90().getSkuParams().getMonitorId(), "SkuYataFragmentPage-dismiss", new AnonymousClass1(this));
    }

    public final void dismissAllowingStateLoss() {
        SkuRunCatchExtKt.a(Z90().getSkuParams().getMonitorId(), "SkuYataFragmentPage-dismissAllowingStateLoss", new C03281(this));
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
        return Y90();
    }

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        SkuCommonLog.c("SkuYataFragmentPage", "onDestroy");
        com.bytedance.android.shopping.buynow.controller.q r0 = this.h;
        if (r0 == null) goto L7;
        Handler r1 = r0.c;
        if (r1 == null) goto L7;
        r1.removeCallbacksAndMessages(null);
    L7:
        com.bytedance.android.shopping.sku.inner.controller.d r2 = (com.bytedance.android.shopping.sku.inner.controller.d) this.m.getValue();
        if (r2.c == false) goto L10;
        List r3 = ul.b.a;
        ul.b.a(r2.b);
        r2.c = false;
    L10:
        this.t.u(requireContext(), Z90().getStaticState().e);
        Map<String, mh3.a> r4 = mh3.a.m;
        mh3.a.C0219a.b(Z90().getSkuParams().getMonitorId());
        Z90().release();
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.DialogFragment*/.onDestroyView();
        SkuCommonLog.c("SkuYataFragmentPage", "onDestroyView");
        com.bytedance.android.shopping.buynow.controller.q r0 = this.h;
        if (r0 != null) goto L5;
    L9:
        Lazy r1 = TrackCatcher.a;
        if (TrackCatcher.a.a() == null) goto L12;
        TrackCatcher.b("sku");
    L12:
        clearDisposable();
        nj.d r2 = com.bytedance.android.ec.sdk.helper.d.b.getPadSplitService();
        if (r2 == null) goto L15;
        nj.c r3 = (nj.c) this.s.getValue();
        r2.e();
    L15:
        mh3.a r4 = Z90().getMonitorManager();
        if (r4 == null) goto L20;
        SkuYataFpsMonitor r5 = r4.d;
        if (r5 == null) goto L20;
        r5.b();
    L20:
        AndroidYaTaInstance r6 = this.o;
        if (r6 == null) goto L23;
        r6.d();
    L23:
        Y90();
        ((LinkedHashMap) this.d).clear();
        return;
    L5:
        if (r0.h != true) goto L9;
        boolean r7 = ECServiceManager.a;
        cf.l r8 = (cf.l) ECServiceManager.c(cf.l.class);
        if (r8 == null) goto L9;
        r8.Fa(false, this, LiveClearScreenMode.CLEAR_SCREEN_MODE_FULL, LiveScreenMoveMode.LIVE_SCREEN_MOVE_UP);
        goto L9
    }

    public final void onDetach() {
        super/*androidx.fragment.app.DialogFragment*/.onDetach();
        SkuCommonLog.c("SkuYataFragmentPage", "onDetach");
        com.bytedance.android.shopping.sku.inner.controller.b r0 = (com.bytedance.android.shopping.sku.inner.controller.b) this.l.getValue();
        ECLiveHybridUtil.p("closeHalfSku", r0.a);
        r0.b.dq().a();
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        SkuCommonLog.c("SkuYataFragmentPage", "onResume");
        this.t.onResume();
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super/*androidx.fragment.app.DialogFragment*/.onStart();
        SkuCommonLog.c("SkuYataFragmentPage", "onStart");
        Z90().getSkuParams().getMaskBackgroundColor();
        com.bytedance.android.shopping.buynow.controller.q r0 = this.h;
        if (r0 != null) goto L5;
    L6:
        Dialog r1 = getDialog();
        if (r1 == null) goto L11;
        Window r2 = r1.getWindow();
        if (r2 == null) goto L11;
        r2.addFlags(2);
    L11:
        Dialog r3 = getDialog();
        if (r3 == null) goto L16;
        Window r4 = r3.getWindow();
        if (r4 == null) goto L16;
        r4.setDimAmount(0.8f);
    L16:
        this.t.onStart();
        return;
    L5:
        if (r0.h == true) goto L16;
        goto L6
    }

    public final void onStop() {
        super/*androidx.fragment.app.DialogFragment*/.onStop();
        this.t.onStop();
    }

    @Override // com.bytedance.android.shopping.sku.inner.container.b
    public final SkuYataViewModel qn() {
        return Z90();
    }

    @Override // com.bytedance.android.shopping.sku.inner.container.b
    public final SlcRenderContext Ul() {
        return this.p;
    }

    @Override // com.bytedance.android.shopping.sku.inner.container.b
    public final AndroidYaTaInstance bV() {
        return this.o;
    }

    @Override // com.bytedance.android.shopping.sku.inner.container.b
    public final SkuCommonAbility dq() {
        return this.t;
    }

    public final ViewModelProvider.Factory getViewModelFactory() {
        return this.e;
    }

    @Override // com.bytedance.android.shopping.sku.inner.container.b
    public final com.bytedance.android.shopping.sku.common.ability.c zJ() {
        return this.n;
    }

    /* JADX INFO: renamed from: getReceiver, reason: collision with other method in class */
    public final IdentitySubscriber m2833getReceiver() {
        return JediView.DefaultImpls.getReceiver(this);
    }

    public static final void T90(SkuYataFragment r1) {
        super/*androidx.fragment.app.DialogFragment*/.dismiss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public static final void U90(SkuYataFragment r1) {
        super/*androidx.fragment.app.DialogFragment*/.dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public static final boolean V90(SkuYataFragment r9) {
        com.bytedance.android.shopping.buynow.controller.q r0 = r9.h;
        if (r0 != null) goto L5;
    L7:
        AndroidYaTaInstance r1 = r9.o;
        Object r2 = null;
        if (r1 == null) goto L10;
        Boolean r3 = Boolean.valueOf(r1.J());
    L12:
        if (com.bytedance.android.shopping.extensions.k.i(r3) == true) goto L52;
        AndroidYaTaInstance r4 = r9.o;
        if (r4 == null) goto L17;
        Object r10 = r4.i("side_slip");
    L19:
        if ((r10 instanceof Map) == true) goto L21;
        r10 = null;
    L21:
        Map r11 = (Map) r10;
        if (r11 == null) goto L24;
        Object r5 = r11.get("target_component_name");
    L26:
        if ((r5 instanceof String) == true) goto L28;
        r5 = null;
    L28:
        String r6 = (String) r5;
        if (r11 == null) goto L31;
        Object r7 = r11.get("target_yata_key");
    L33:
        if ((r7 instanceof String) == true) goto L35;
        r7 = null;
    L35:
        String r8 = (String) r7;
        if (r11 == null) goto L38;
        Object r12 = r11.get("quit_event_name");
    L40:
        if ((r12 instanceof String) == false) goto L43;
        r2 = r12;
    L43:
        String r13 = (String) r2;
        if (r6 == null) goto L53;
        if (r8 == null) goto L53;
        if (r13 == null) goto L53;
        com.bytedance.kmp.ec.yata.store.node.c r14 = com.bytedance.android.shopping.buynow.utils.h.a(r4, r6, r8);
        if (r14 == null) goto L53;
        r4.k().d(com.bytedance.kmp.ec.yata.event.common.e.a.a(r4, null, r14.getKey(), r13, null, "onBackKeyPressed"));
    L53:
        return false;
    L38:
        r12 = null;
        goto L40
    L31:
        r7 = null;
        goto L33
    L24:
        r5 = null;
        goto L26
    L17:
        r10 = null;
    L52:
        return true;
    L10:
        r3 = null;
        goto L12
    L5:
        if (r0.b == true) goto L7;
        goto L7
    }

    @Override // com.bytedance.android.shopping.sku.inner.yata.abilities.a
    public final void EJ(final com.bytedance.kmp.ec.yata.common.biz.callback.a r3) {
        Intrinsics.checkNotNullParameter(r3, "model");
        SkuCommonLog.c("SkuYataFragmentPage", "onUplinkStart");
        com.bytedance.android.shopping.sku.common.utils.e.a r0 = com.bytedance.android.shopping.sku.common.utils.e.a;
        com.bytedance.android.shopping.sku.common.utils.e.b(new SkuYataFragment$onUplinkStart$1(this, r3));
    }

    public final void Q70(Map r4) {
        Intrinsics.checkNotNullParameter("gallery_viewer_module_show", "eventName");
        Intrinsics.checkNotNullParameter(r4, "params");
        Z90().getTracker().b(PageFinder.via(this), "gallery_viewer_module_show", r4);
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
        Z90().getStaticState().e.a = r2;
        dismissAllowingStateLoss();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r3 = DialogFragmentLancet.sLastShowStack;
        if (r3 == null) goto L12;
        com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final void onActivityCreated(Bundle r11) {
        super/*androidx.fragment.app.DialogFragment*/.onActivityCreated(r11);
        SkuCommonLog.c("SkuYataFragmentPage", "onActivityCreated");
        Dialog r12 = getDialog();
        if (r12 == null) goto L5;
        r12.setOnKeyListener(new s(this));
    L5:
        com.bytedance.android.shopping.buynow.controller.q r13 = this.h;
        if (r13 != null) goto L8;
    L10:
        TranslateAnimation r14 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        r14.setDuration(390);
        r14.setInterpolator(new com.bytedance.android.shopping.anchorv4.helper.a0());
        View r0 = S90(2131381866);
        if (r0 == null) goto L14;
        r0.startAnimation(r14);
        return;
    L14:
        return;
    L8:
        if (r13.h != true) goto L10;
    }

    public final void onAttach(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super/*androidx.fragment.app.DialogFragment*/.onAttach(r4);
        SkuCommonLog.c("SkuYataFragmentPage", "onAttach");
        SkuYataTemplateManager.a();
        this.t.getClass();
        SliceTemplateManager.a();
        SkuYataTemplateManager.b(r4);
        com.bytedance.android.shopping.sku.inner.controller.b r5 = (com.bytedance.android.shopping.sku.inner.controller.b) this.l.getValue();
        ECLiveHybridUtil.m("closeHalfSku", r5.a);
        r5.b.dq().w(r5.b, new com.bytedance.android.shopping.sku.inner.controller.c(r5));
    }

    public final void onCreate(Bundle r9) {
        super/*androidx.fragment.app.DialogFragment*/.onCreate(r9);
        Lazy r10 = SkuCommonLog.a;
        SkuCommonLog.a("SkuYataFragmentPage", C03291.INSTANCE);
        setStyle(0, 2131954526);
        Bundle r11 = getArguments();
        Serializable r1 = null;
        if (r11 == null) goto L5;
        String r12 = r11.getString("source_btm_token");
    L6:
        Lazy r2 = BtmSDKWrapper.a;
        BtmSDKWrapper.b(this, "a1.b5267", r12);
        SkuCommonLog.c("SkuYataFragmentPage", "sourceBtmToken:" + r12);
        Bundle r13 = getArguments();
        if (r13 == null) goto L9;
        Serializable r14 = r13.getSerializable("sku_params");
    L11:
        if ((r14 instanceof SkuParams) == true) goto L13;
        r14 = null;
    L13:
        SkuParams r3 = (SkuParams) r14;
        if (r3 == null) goto L37;
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
        Z90().init(r3, r4, (PageFinder) this.r.getValue(), r18, this);
        this.t.x(new SkuYataFragment$initData$1(this), new SkuYataFragment$initData$2(this));
        if (this.n != null) goto L37;
        dismissAllowingStateLoss();     // Catch: Exception -> L33
    L33:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r19 = DialogFragmentLancet.sLastShowStack;
        if (r19 == null) goto L37;
        com.bytedance.crash.d.d(r19, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
    L28:
        r18 = UUID.randomUUID().toString();
        goto L29
    L19:
        r16 = null;
    L37:
        Z90().getTracker().d();
        Z90().requestQuery(SkuYataQueryFrom.FIRST_SCREEN);
        com.bytedance.android.shopping.utils.e0.a();
        Context r20 = getContext();
        if (r20 == null) goto L42;
        com.bytedance.android.shopping.sku.common.ability.c r0 = this.n;
        if (r0 == null) goto L42;
        r0.g(r20, Z90().getStaticState().e);
    L42:
        int r21 = ECSdk.a;
        IEShoppingService r22 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r22 == null) goto L50;
        sc3.c r23 = r22.getBuyNowService();
        if (r23 == null) goto L51;
        r23.c();
        return;
    L51:
        return;
    L50:
        return;
    L9:
        r14 = null;
        goto L11
    L5:
        r12 = null;
        goto L6
    }

    public final Dialog onCreateDialog(Bundle r3) {
        SkuCommonLog.c("SkuYataFragmentPage", "onCreateDialog");
        return new SkuYataFixedDialog(requireContext(), getTheme());
    }

    public final void onDismiss(final DialogInterface r3) {
        Intrinsics.checkNotNullParameter(r3, "dialog");     // Catch: Throwable -> L5
        SkuRunCatchExtKt.a(Z90().getSkuParams().getMonitorId(), "SkuYataFragmentPage-onDismiss", new C03301(this, r3));     // Catch: Throwable -> L5
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L5:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public static final /* synthetic */ void W90(SkuYataFragment r0, DialogInterface r1) {
        super/*androidx.fragment.app.DialogFragment*/.onDismiss(r1);
    }

    public final void onViewCreated(View r13, Bundle r14) {
        Intrinsics.checkNotNullParameter(r13, FreqActions.ACTION_VIEW);
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r13, r14);
        SkuCommonLog.c("SkuYataFragmentPage", "onViewCreated");
        ((PageFinder) this.r.getValue()).view = r13;
        Y90().c(SkuYataStatusController.StatusType.SKELETON);
        RecyclerView r15 = X90();
        boolean r0 = false;
        if (r15 == null) goto L5;
        r15.setLayoutManager(new LinearLayoutManager(r15.getContext(), 1, false));
    L5:
        new SkuYataRecyclerBottomSheetController(X90()).a();
        LinearLayout r16 = (LinearLayout) S90(2131386841);
        if (r16 == null) goto L8;
        r16.setOnClickListener(new v(this));
    L8:
        ConcurrentHashMap r17 = a43.a.a;
        if (Intrinsics.areEqual(l43.a.a("legou_sku_buy_layout_opt"), 1) == false) goto L13;
        View r18 = S90(2131386851);
        if (r18 == null) goto L13;
        r18.setBackgroundResource(2131248234);
    L13:
        ImageView r19 = (ImageView) S90(2131386849);
        if (r19 == null) goto L16;
        r19.setOnClickListener(new w(this));
    L16:
        LinearLayout r3 = (LinearLayout) S90(2131386871);
        if (r3 == null) goto L19;
        r3.setOnClickListener(new x(this));
    L19:
        ConstraintLayout r4 = S90(2131386851);
        Window r5 = null;
        if (r4 == null) goto L66;
        ConstraintLayout r2 = S90(2131386851);
        if (r2 == null) goto L64;
        ViewGroup.LayoutParams r6 = r2.getLayoutParams();
        if (r6 == null) goto L64;
        Integer r7 = Z90().getSkuParams().getHeightPercent();
        if (r7 == null) goto L28;
        int r8 = r7.intValue();
    L29:
        ECSettingKeys.j.getClass();
        int r9 = ECSettingKeys.X();
        if (BuyNowPerformanceOpt.m() == false) goto L33;
    L55:
        r8 = r9;
    L56:
        Z90().getTracker().e(MapsKt.mapOf(TuplesKt.to("panel_height_percent", String.valueOf(r8))));
        int r10 = ((com.bytedance.android.shopping.sku.inner.controller.e) this.j.getValue()).a(r8);
        SkuCommonLog.c("SkuYataFragmentPage", "contentHeight:" + r10);
        r6.height = r10;
        if (r10 != 0) goto L63;
        mh3.a r110 = Z90().getMonitorManager();
        if (r110 == null) goto L63;
        com.bytedance.android.shopping.sku.common.monitor.error.a r111 = r110.c;
        if (r111 == null) goto L63;
        SkuErrorMonitorType r11 = SkuErrorMonitorType.SERIOUS_BUSINESS_ERROR;
        String r12 = "contentHeight is 0;  heightPercent:" + Z90().getSkuParams().getHeightPercent();
        Map<String, com.bytedance.android.shopping.sku.common.monitor.error.a> r20 = com.bytedance.android.shopping.sku.common.monitor.error.a.b;
        r111.a(r11, r12, null);
    L63:
        Unit r112 = Unit.INSTANCE;
    L65:
        r4.setLayoutParams(r6);
        goto L66
    L33:
        if (BuyNowPerformanceOpt.p() == false) goto L38;
        if (ECSettingKeys.W().contains(String.valueOf(Z90().getSkuParams().getSceneType())) == false) goto L56;
    L38:
        if (BuyNowPerformanceOpt.o() == false) goto L43;
        if (ECSettingKeys.W().contains(String.valueOf(Z90().getSkuParams().getSceneType())) == true) goto L56;
    L43:
        if (BuyNowPerformanceOpt.n() == false) goto L50;
        Integer r21 = Z90().getSkuParams().getForceHeight();
        if (r21 == null) goto L55;
        if (r21.intValue() == 1) goto L56;
    L50:
        Integer r22 = Z90().getSkuParams().getForceHeight();
        if (r22 == null) goto L56;
        if (r22.intValue() != 1) goto L56;
    L28:
        r8 = 73;
    L64:
        r6 = null;
    L66:
        com.bytedance.android.shopping.sku.inner.controller.d r113 = (com.bytedance.android.shopping.sku.inner.controller.d) this.m.getValue();
        View r23 = S90(2131386871);
        r113.getClass();
        r113.a = new WeakReference(r23);
        mh3.a r114 = Z90().getMonitorManager();
        if (r114 == null) goto L71;
        SkuYataFpsMonitor r115 = r114.d;
        if (r115 == null) goto L71;
        r115.a(X90());
    L71:
        Lazy r116 = UIUtils.a;
        Dialog r117 = getDialog();
        if (r117 == null) goto L74;
        Window r118 = r117.getWindow();
    L75:
        UIUtils.g(r118, "#FFFFFFFF");
        View r119 = S90(2131381805);
        if (r119 == null) goto L78;
        r119.setOnClickListener(new y(this));
    L78:
        View r24 = S90(2131381866);
        if (r24 == null) goto L81;
        r24.setOnClickListener(z.a);
    L81:
        int r25 = com.bytedance.android.shopping.buynow.utils.r.a;
        UIUtils.g(com.bytedance.android.shopping.buynow.utils.r.b(requireContext(), this), "#FFFFFFFF");
        ECSettingKeys.j.getClass();
        if (ECSettingKeys.V() == false) goto L190;
        com.bytedance.android.ecom.arch.slice.render.context.b r26 = e0.a();
        View r27 = getView();
        if (r27 == null) goto L87;
        View r28 = r27.findViewById(2131376195);
    L88:
        if (r28 == null) goto L97;
        ViewGroup.LayoutParams r29 = r28.getLayoutParams();
        if ((r29 instanceof ViewGroup.MarginLayoutParams) == true) goto L92;
        r29 = null;
    L92:
        ViewGroup.MarginLayoutParams r30 = (ViewGroup.MarginLayoutParams) r29;
        if (r30 == null) goto L95;
        r30.width = SlcDimensExtensionsKt.a(80, r26);
        r30.height = SlcDimensExtensionsKt.a(80, r26);
        Unit r31 = Unit.INSTANCE;
    L96:
        r28.setLayoutParams(r30);
        goto L97
    L95:
        r30 = null;
    L97:
        View r32 = getView();
        if (r32 == null) goto L100;
        View r33 = r32.findViewById(2131390547);
    L102:
        if (r33 == null) goto L111;
        ViewGroup.LayoutParams r34 = r33.getLayoutParams();
        if ((r34 instanceof ViewGroup.MarginLayoutParams) == true) goto L106;
        r34 = null;
    L106:
        ViewGroup.MarginLayoutParams r35 = (ViewGroup.MarginLayoutParams) r34;
        if (r35 == null) goto L109;
        r35.width = SlcDimensExtensionsKt.a(165, r26);
        r35.height = SlcDimensExtensionsKt.a(44, r26);
        r35.topMargin = SlcDimensExtensionsKt.a(40, r26);
        Unit r36 = Unit.INSTANCE;
    L110:
        r33.setLayoutParams(r35);
        goto L111
    L109:
        r35 = null;
    L111:
        View r37 = getView();
        if (r37 == null) goto L114;
        View r38 = r37.findViewById(2131390548);
    L115:
        if (r38 == null) goto L124;
        ViewGroup.LayoutParams r39 = r38.getLayoutParams();
        if ((r39 instanceof ViewGroup.MarginLayoutParams) == true) goto L119;
        r39 = null;
    L119:
        ViewGroup.MarginLayoutParams r40 = (ViewGroup.MarginLayoutParams) r39;
        if (r40 == null) goto L122;
        r40.topMargin = SlcDimensExtensionsKt.a(6, r26);
        Unit r41 = Unit.INSTANCE;
    L123:
        r38.setLayoutParams(r40);
        goto L124
    L122:
        r40 = null;
    L124:
        View r42 = getView();
        if (r42 == null) goto L127;
        View r43 = r42.findViewById(2131390546);
    L128:
        if (r43 == null) goto L137;
        ViewGroup.LayoutParams r44 = r43.getLayoutParams();
        if ((r44 instanceof ViewGroup.MarginLayoutParams) == true) goto L132;
        r44 = null;
    L132:
        ViewGroup.MarginLayoutParams r45 = (ViewGroup.MarginLayoutParams) r44;
        if (r45 == null) goto L135;
        r45.topMargin = SlcDimensExtensionsKt.a(8, r26);
        Unit r46 = Unit.INSTANCE;
    L136:
        r43.setLayoutParams(r45);
        goto L137
    L135:
        r45 = null;
    L137:
        View r47 = getView();
        if (r47 == null) goto L140;
        View r48 = r47.findViewById(2131376616);
    L142:
        if (r48 == null) goto L151;
        ViewGroup.LayoutParams r49 = r48.getLayoutParams();
        if ((r49 instanceof ViewGroup.MarginLayoutParams) == true) goto L146;
        r49 = null;
    L146:
        ViewGroup.MarginLayoutParams r50 = (ViewGroup.MarginLayoutParams) r49;
        if (r50 == null) goto L149;
        r50.width = SlcDimensExtensionsKt.a(120, r26);
        r50.height = SlcDimensExtensionsKt.a(120, r26);
        r50.bottomMargin = SlcDimensExtensionsKt.a(12, r26);
        Unit r51 = Unit.INSTANCE;
    L150:
        r48.setLayoutParams(r50);
        goto L151
    L149:
        r50 = null;
    L151:
        View r52 = getView();
        if (r52 == null) goto L154;
        View r53 = r52.findViewById(2131391458);
    L155:
        if (r53 == null) goto L164;
        ViewGroup.LayoutParams r54 = r53.getLayoutParams();
        if ((r54 instanceof ViewGroup.MarginLayoutParams) == true) goto L159;
        r54 = null;
    L159:
        ViewGroup.MarginLayoutParams r55 = (ViewGroup.MarginLayoutParams) r54;
        if (r55 == null) goto L162;
        r55.bottomMargin = SlcDimensExtensionsKt.a(14, r26);
        Unit r56 = Unit.INSTANCE;
    L163:
        r53.setLayoutParams(r55);
        goto L164
    L162:
        r55 = null;
    L164:
        View r57 = getView();
        if (r57 == null) goto L167;
        View r58 = r57.findViewById(2131391459);
    L168:
        if (r58 == null) goto L177;
        ViewGroup.LayoutParams r59 = r58.getLayoutParams();
        if ((r59 instanceof ViewGroup.MarginLayoutParams) == true) goto L172;
        r59 = null;
    L172:
        ViewGroup.MarginLayoutParams r60 = (ViewGroup.MarginLayoutParams) r59;
        if (r60 == null) goto L175;
        r60.bottomMargin = SlcDimensExtensionsKt.a(40, r26);
        Unit r61 = Unit.INSTANCE;
    L176:
        r58.setLayoutParams(r60);
        goto L177
    L175:
        r60 = null;
    L177:
        View r62 = getView();
        if (r62 == null) goto L180;
        View r63 = r62.findViewById(2131386833);
    L181:
        if (r63 == null) goto L190;
        ViewGroup.LayoutParams r64 = r63.getLayoutParams();
        if ((r64 instanceof ViewGroup.MarginLayoutParams) == true) goto L185;
        r64 = null;
    L185:
        ViewGroup.MarginLayoutParams r65 = (ViewGroup.MarginLayoutParams) r64;
        if (r65 == null) goto L188;
        r65.width = SlcDimensExtensionsKt.a(120, r26);
        r65.height = SlcDimensExtensionsKt.a(120, r26);
        r65.bottomMargin = SlcDimensExtensionsKt.a(12, r26);
        Unit r66 = Unit.INSTANCE;
    L189:
        r63.setLayoutParams(r65);
        goto L190
    L188:
        r65 = null;
        goto L189
    L180:
        r63 = null;
        goto L181
    L167:
        r58 = null;
        goto L168
    L154:
        r53 = null;
        goto L155
    L140:
        r48 = null;
        goto L142
    L127:
        r43 = null;
        goto L128
    L114:
        r38 = null;
        goto L115
    L100:
        r33 = null;
        goto L102
    L87:
        r28 = null;
    L190:
        Dialog r67 = getDialog();
        if (r67 == null) goto L193;
        Window r68 = r67.getWindow();
    L194:
        com.bytedance.android.shopping.buynow.controller.q r69 = new com.bytedance.android.shopping.buynow.controller.q(r68, S90(2131381866), S90(2131372607), new SkuYataFragment$initView$8(this));
        this.h = r69;
        r69.a();
        int r120 = AndroidYataBuilderManager.a;
        com.bytedance.kmp.ec.yata.b r121 = AndroidYataBuilderManager.a("yata_sku", new SkuYataAbilityProvider(requireContext(), this), null, null, SkuYataFragment$initYataSlice$1.INSTANCE);
        com.bytedance.kmp.ec.yata.b.c(r121, (LinearLayout) S90(2131386845));
        com.bytedance.kmp.ec.yata.b.a(r121, S90(2131386834));
        com.bytedance.kmp.ec.yata.b.b(r121, (LinearLayout) S90(2131386844));
        com.bytedance.kmp.ec.yata.b.d(r121, "top", (LinearLayout) S90(2131386871));
        r121.e((FrameLayout) S90(2131382786));
        AndroidYaTaInstance r122 = r121.a;
        this.o = r122;
        if (r122 == null) goto L197;
        r122.E(new a0(this));
    L197:
        AndroidYaTaInstance r123 = this.o;
        if (r123 == null) goto L200;
        r123.D(new b0(this));
    L200:
        ((oh3.a) this.q.getValue()).getClass();
        oh3.a.a(this);
        AndroidYaTaInstance r124 = this.o;
        if (r124 == null) goto L203;
        SlcRenderContext r125 = (SlcRenderContext) r124.I(Reflection.getOrCreateKotlinClass(SlcRenderContext.class));
    L204:
        this.p = r125;
        if (r125 == null) goto L207;
        r125.j = false;
    L207:
        if (r125 == null) goto L209;
        int r126 = e0.a;
        r125.k = ECSettingKeys.Y().a();
    L209:
        SlcRenderContext r127 = this.p;
        if (r127 == null) goto L212;
        r127.g = true;
    L212:
        com.bytedance.android.ecom.arch.slice.render.context.b r128 = e0.a();
        SlcRenderContext r129 = this.p;
        if (r129 == null) goto L215;
        r129.f = r128;
    L215:
        if (r129 == null) goto L217;
        int r70 = ai3.g.a;
        r129.p(MapsKt.mapOf(TuplesKt.to("system_navigation_bar_height", Float.valueOf(SlcDimensExtensionsKt.d(Integer.valueOf(k1.e(ECAppInfoService.e.getApplicationContext())), r128)))));
    L217:
        SkuYataSliceServerTimeController r130 = (SkuYataSliceServerTimeController) this.k.getValue();
        SlcRenderContext r131 = this.p;
        r130.getClass();
        if (r131 == null) goto L220;
        r131.r(System.currentTimeMillis() / ((long) 1000));
    L220:
        Activity r132 = com.bytedance.android.shopping.anchorv3.utils.d0.a.getActivity(getContext());
        if (r132 == null) goto L233;
        Window r133 = r132.getWindow();
        if (r133 == null) goto L233;
        View r134 = r133.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L229;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r135 = ThreadMethodProxy.currentThread();
        if (r135 == com.larus.home.impl.utils.c.a) goto L229;
        com.larus.home.impl.utils.c.a(r135, "getDecorView");
    L229:
        if (r134 == null) goto L233;
        SlcRenderContext r136 = this.p;
        if (r136 == null) goto L238;
        r136.q(new com.bytedance.android.ecom.arch.slice.render.context.e(true, r134, true, new d0(r134)));
    L238:
        SkuCommonAbility r137 = this.t;
        SlcRenderContext r138 = this.p;
        Dialog r71 = getDialog();
        if (r71 == null) goto L241;
        r5 = r71.getWindow();
    L241:
        r137.g(r138, r5, X90(), (ViewGroup) S90(2131386844));
        RecyclerView r139 = X90();
        if (r139 == null) goto L244;
        r139.addOnItemTouchListener(new SkuYataFragment$initYataSlice$6(this));
    L244:
        ISubscriber.DefaultImpls.selectSubscribe$default(this, Z90(), SkuYataFragment$initSubscribe$1.INSTANCE, null, new SkuYataFragment$initSubscribe$2(this), 2, null);
        ISubscriber.DefaultImpls.selectSubscribe$default(this, Z90(), SkuYataFragment$initSubscribe$3.INSTANCE, null, new SkuYataFragment$initSubscribe$4(this), 2, null);
        nj.d r140 = com.bytedance.android.ec.sdk.helper.d.b.getPadSplitService();
        if (r140 == null) goto L247;
        nj.c r141 = (nj.c) this.s.getValue();
        r140.b();
    L247:
        AndroidYaTaInstance r142 = this.o;
        RecyclerView r72 = X90();
        final com.bytedance.android.shopping.sku.inner.controller.a r143 = new com.bytedance.android.shopping.sku.inner.controller.a(r142, r72);
        if (r72 == null) goto L250;
        r72.addOnScrollListener(new ScrollNotifyController$onBodyContainerInit$1(r143));
    L250:
        boolean r144 = ECAppInfoService.e.i();
        if (r144 == false) goto L272;
        wg.a.h(S90(2131368571), r144);
        ((TextView) S90(2131368571)).setOnClickListener(t.a);
        TextView r145 = (TextView) S90(2131368571);
        int r73 = q.a;
        if (Z90().getSkuSchemaParams() == null) goto L256;
        r0 = true;
    L256:
        if (r0 == false) goto L258;
        String r1 = "组件化sku\nschema重构";
    L259:
        r145.setText(r1);
        View r146 = getView();
        if (r146 == null) goto L264;
        TextView r147 = (TextView) r146.findViewById(2131368572);
        if (r147 == null) goto L264;
        wg.a.h(r147, r144);
    L264:
        View r148 = getView();
        if (r148 == null) goto L270;
        TextView r149 = (TextView) r148.findViewById(2131368572);
        if (r149 == null) goto L271;
        r149.setOnClickListener(new u(this));
        return;
    L271:
        return;
    L270:
        return;
    L258:
        r1 = "组件化sku\n非schema重构";
        goto L259
    L272:
        return;
    L233:
        Map<String, mh3.a> r150 = mh3.a.m;
        mh3.a r151 = mh3.a.C0219a.c(Z90().getSkuParams().getMonitorId());
        if (r151 == null) goto L238;
        com.bytedance.android.shopping.sku.common.monitor.error.a r152 = r151.c;
        if (r152 == null) goto L238;
        SkuErrorMonitorType r153 = SkuErrorMonitorType.SERIOUS_BUSINESS_ERROR;
        Map<String, com.bytedance.android.shopping.sku.common.monitor.error.a> r74 = com.bytedance.android.shopping.sku.common.monitor.error.a.b;
        r152.a(r153, "SkuYataFragmentPage-fragment.getActivityDecorView failed ", null);
        goto L238
    L203:
        r125 = null;
        goto L204
    L193:
        r68 = null;
        goto L194
    L74:
        r118 = null;
        goto L75
    }

    public final void showNow(FragmentManager r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "manager");
        Fragment r0 = (Fragment) CollectionsKt.lastOrNull(r3.getFragments());     // Catch: Exception -> L13
        Activity r1 = ECAppInfoService.e.getCurrentActivity();     // Catch: Exception -> L13
        if (r1 != null) goto L6;
        return;
    L6:
        if (r1.isFinishing() == true) goto L22;
        Lazy r2 = SkuCommonLog.a;     // Catch: Exception -> L13
        SkuCommonLog.a("SkuYataFragmentPage", C03311.INSTANCE);     // Catch: Exception -> L13
        LandscapeRestrictionOperation r5 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW_NOW;     // Catch: Exception -> L13
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, r4, r5);     // Catch: Exception -> L13
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, this, r5) == true) goto L23;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L16
    L11:
        super/*androidx.fragment.app.DialogFragment*/.showNow(r3, r4);     // Catch: Exception -> L13
        return;
    L23:
        return;
    L22:
        return;
    L13:
        e = move-exception;
        ECExceptionMonitor.e(e);
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
        SkuCommonLog.c("SkuYataFragmentPage", "onCreateView");
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
