package com.bytedance.android.shopping.card_list.container;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.InflateException;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.adapter.api.j;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.core.jedi.ReflectViewModelFactory;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.k1;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.api.mall.MallPageName;
import com.bytedance.android.shopping.card_list.common_params.CardListContainerConfig;
import com.bytedance.android.shopping.card_list.components.CardListPopupLayerComponent;
import com.bytedance.android.shopping.card_list.container.init.BaseCardListContainer;
import com.bytedance.android.shopping.card_list.container.init.CardListObjectContainer;
import com.bytedance.android.shopping.card_list.container.init.g;
import com.bytedance.android.shopping.card_list.params.CardPassThroughData;
import com.bytedance.android.shopping.card_list.params.CartPassThroughData;
import com.bytedance.android.shopping.card_list.utils.h;
import com.bytedance.android.shopping.card_list.widgets.CardListRootFrameLayoutContainer;
import com.bytedance.android.shopping.extensions.m;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.android.shopping.yata.biz.popup.PopupLayer;
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
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.reflect.KProperty1;
import nj.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u00042\u00020\u00062\u00020\u0007:\u0001\nB\u0007¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/card_list/container/CardListDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "Lcom/bytedance/android/shopping/card_list/widgets/CardListRootFrameLayoutContainer$a;", "Lcom/bytedance/jedi/arch/JediView;", "Lcom/bytedance/jedi/arch/ViewModelFactoryOwner;", "Lcom/bytedance/android/ec/core/jedi/ReflectViewModelFactory;", "Lp83/b;", "Lcom/bytedance/android/shopping/card_list/container/init/g;", "<init>", "()V", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CardListDialogFragment extends DialogFragment implements CardListRootFrameLayoutContainer.a, JediView, ViewModelFactoryOwner<ReflectViewModelFactory>, p83.b, g {
    public static final /* synthetic */ int m = 0;
    public final ReflectViewModelFactory d;
    public final Lazy e;
    public final BaseCardListContainer f;
    public final Lazy g;
    public final b h;
    public final Lazy i;
    public final AtomicBoolean j;
    public final Lazy k;
    public com.bytedance.android.shopping.card_list.container.a l;

    public static final class a {
    }

    public static final class b implements ul.c {
        public b() {
        }

        public final void a(boolean r1) {
        }
    }

    public static final class c implements DialogInterface.OnKeyListener {
        public final /* synthetic */ CardListDialogFragment a;

        public c(CardListDialogFragment r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public final boolean onKey(DialogInterface r2, int r3, KeyEvent r4) {
            boolean r0 = false;
            if (r3 == 4) goto L5;
        L29:
            return false;
        L5:
            if (r4.getAction() != 1) goto L29;
            BaseCardListContainer r5 = this.a.f;
            if (r5.g() == false) goto L24;
            CardListPopupLayerComponent r6 = (CardListPopupLayerComponent) r5.h.getValue();
            if (r6 == null) goto L24;
            FrameLayout r7 = r6.f;
            if (r7 != null) goto L13;
        L15:
            if (r0 != true) goto L24;
            CardListPopupLayerComponent r8 = (CardListPopupLayerComponent) r5.h.getValue();
            if (r8 == null) goto L21;
            PopupLayer r9 = r8.g();
            if (r9 == null) goto L21;
            r9.h(null);
        L21:
            CardListPopupLayerComponent r10 = (CardListPopupLayerComponent) r5.h.getValue();
            if (r10 == null) goto L28;
            r10.h();
        L28:
            return true;
        L13:
            if (r7.getVisibility() != 0) goto L15;
            r0 = true;
        L24:
            CardListObjectContainer r11 = r5.a;
            if (r11 != null) goto L27;
            Intrinsics.throwUninitializedPropertyAccessException("objectContainer");
        L27:
            r11.a();
            goto L28
        }
    }

    static {
    }

    public final CardPassThroughData T90() {
        return (CardPassThroughData) this.e.getValue();
    }

    public final boolean U90() {
        return ((Boolean) this.g.getValue()).booleanValue();
    }

    public final void dismissAllowingStateLoss() {
        int r0 = h.a;
        if (h.a(T90().getSplitActivityScene()) == false) goto L7;
        d r1 = com.bytedance.android.ec.sdk.helper.d.b.getPadSplitService();
        if (r1 == null) goto L7;
        getActivity();
        r1.m();
    L7:
        dm.a.a("CardListFragment").i("fragment dismissAllowingStateLoss");
        super.dismissAllowingStateLoss();     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L17;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    @Override // com.bytedance.android.shopping.card_list.container.init.g
    public final int k4() {
        int r0 = h.a;
        if (h.a(T90().getSplitActivityScene()) == false) goto L8;
        d r1 = com.bytedance.android.ec.sdk.helper.d.b.getPadSplitService();
        if (r1 == null) goto L9;
        r1.getSpiltWidth();
        return 0;
    L9:
        return 0;
    L8:
        return k1.m(requireContext());
    }

    @Override // com.bytedance.android.shopping.card_list.container.init.g
    public final int x20() {
        int r0 = h.a;
        if (h.a(T90().getSplitActivityScene()) == false) goto L8;
        d r1 = com.bytedance.android.ec.sdk.helper.d.b.getPadSplitService();
        if (r1 == null) goto L9;
        r1.getScreenHeight();
        return 0;
    L9:
        return 0;
    L8:
        return k1.j(requireContext());
    }

    public CardListDialogFragment() {
        this.d = new ReflectViewModelFactory();
        this.e = LazyKt.lazy(new CardListDialogFragment$schemaData$2(this));
        this.f = new BaseCardListContainer();
        this.g = LazyKt.lazy(new CardListDialogFragment$isCartHalfPanel$2(this));
        this.h = new b();
        this.i = LazyKt.lazy(new CardListDialogFragment$foldStatusChangeListener$2(this));
        this.j = new AtomicBoolean(false);
        this.k = LazyKt.lazy(new CardListDialogFragment$config$2(this));
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
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        this.f.h();
        boolean r0 = ECServiceManager.a;
        ((s83.g) ECServiceManager.c(s83.g.class)).t(T90().getSchemaParams());
        CartPassThroughData r1 = T90().getCartSchemaData();
        if (r1 == null) goto L5;
        String r2 = r1.getNewSourceType();
    L7:
        if (Intrinsics.areEqual(r2, MallPageName.X_TAB_MALL) == false) goto L14;
        FragmentActivity r3 = getActivity();
        if (r3 == null) goto L14;
        int r4 = ECSdk.a;
        s83.g r5 = (s83.g) ECSdk.a(s83.g.class);
        if (r5 == null) goto L14;
        r5.e0(r3, true);
    L14:
        if (U90() == false) goto L16;
        List r6 = ul.b.a;
        ul.b.a(this.h);
    L16:
        d r7 = com.bytedance.android.ec.sdk.helper.d.b.getPadSplitService();
        if (r7 == null) goto L19;
        CardListDialogFragment$foldStatusChangeListener$2.a r8 = (CardListDialogFragment$foldStatusChangeListener$2.a) this.i.getValue();
        r7.e();
    L19:
        V90(false);
        return;
    L5:
        r2 = null;
        goto L7
    }

    public final void onDestroyView() {
        super.onDestroyView();
        Dialog r0 = getDialog();
        if (r0 == null) goto L14;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L15;
        View r2 = S90(r1);
        if (r2 == null) goto L16;
        ViewTreeObserver r3 = r2.getViewTreeObserver();
        if (r3 != null) goto L11;
        return;
    L11:
        if (r3.isAlive() == false) goto L18;
        r3.removeOnPreDrawListener(this.l);
        return;
    L18:
        return;
    L16:
        return;
    L15:
        return;
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        String r1 = null;
        if (this.j.get() == true) goto L15;
        if (getShowsDialog() == false) goto L13;
        Dialog r2 = getDialog();
        if (r2 == null) goto L11;
        Window r3 = r2.getWindow();
        if (r3 == null) goto L11;
        View r4 = S90(r3);
    L12:
        SpringAnimation r0 = new SpringAnimation(r4, DynamicAnimation.TRANSLATION_Y, 0.0f);
        r0.getSpring().setStiffness(798.55f);
        r0.getSpring().setDampingRatio(0.999f);
        r0.setStartVelocity(0.0f);
        r0.start();
    L11:
        r4 = null;
    L13:
        boolean r5 = ECServiceManager.a;
        ((s83.g) ECServiceManager.c(s83.g.class)).b(T90().getSchemaParams());
    L15:
        if (U90() == false) goto L18;
        List r6 = ul.b.a;
        ul.b.b(this.h);
    L18:
        if (U90() == false) goto L20;
    L22:
        this.f.c();
        CartPassThroughData r7 = T90().getCartSchemaData();
        if (r7 == null) goto L26;
        r1 = r7.getNewSourceType();
    L26:
        if (Intrinsics.areEqual(r1, MallPageName.X_TAB_MALL) == false) goto L33;
        FragmentActivity r8 = getActivity();
        if (r8 == null) goto L34;
        int r9 = ECSdk.a;
        s83.g r10 = (s83.g) ECSdk.a(s83.g.class);
        if (r10 == null) goto L35;
        r10.e0(r8, false);
        return;
    L35:
        return;
    L34:
        return;
    L33:
        return;
    L20:
        if (getShowsDialog() == false) goto L22;
        V90(true);
        goto L22
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        if (U90() == false) goto L9;
        Dialog r0 = getDialog();
        if (r0 == null) goto L15;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L16;
        r1.setWindowAnimations(2131954184);
        return;
    L16:
        return;
    L15:
        return;
    L9:
        Dialog r2 = getDialog();
        if (r2 == null) goto L18;
        Window r3 = r2.getWindow();
        if (r3 == null) goto L19;
        r3.setWindowAnimations(2131953433);
        return;
    L19:
        return;
    }

    public final ViewModelProvider.Factory getViewModelFactory() {
        return this.d;
    }

    /* JADX INFO: renamed from: getReceiver, reason: collision with other method in class */
    public final IdentitySubscriber m424getReceiver() {
        return JediView.DefaultImpls.getReceiver(this);
    }

    public static View S90(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public final void V90(boolean r5) {
        View r0 = getView();
        if ((r0 instanceof FrameLayout) == true) goto L5;
        r0 = null;
    L5:
        FrameLayout r1 = (FrameLayout) r0;
        if (r1 == null) goto L22;
        if (r5 == false) goto L16;
        int r6 = ECSdk.a;
        IAdapterService r7 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r7 == null) goto L23;
        j r8 = r7.getLiveWindowService();
        if (r8 == null) goto L24;
        com.bytedance.android.ec.adapter.api.a r2 = new com.bytedance.android.ec.adapter.api.a();
        String r3 = ((CardListContainerConfig) this.k.getValue()).getPageName();
        if (r3 != null) goto L15;
        r3 = "";
    L15:
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r2.a = r3;
        Unit r4 = Unit.INSTANCE;
        r8.a(this, r1, r2);
        return;
    L24:
        return;
    L23:
        return;
    L16:
        int r9 = ECSdk.a;
        IAdapterService r10 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r10 == null) goto L26;
        j r11 = r10.getLiveWindowService();
        if (r11 == null) goto L27;
        r11.stopShowFloat();
        return;
    L27:
        return;
    L26:
        return;
    }

    @Override // com.bytedance.android.shopping.card_list.widgets.CardListRootFrameLayoutContainer.a
    public final void c(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "ev");
        this.f.a(r2);
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        setStyle(1, 2131952001);
    }

    public final void onSaveInstanceState(Bundle r3) {
        Intrinsics.checkNotNullParameter(r3, "outState");
        super.onSaveInstanceState(r3);
        r3.putBoolean("CARD_LIST_PAGE_LOAD_AGAIN", true);
    }

    public final void onViewCreated(View r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r11, FreqActions.ACTION_VIEW);
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r11, r12);
        Bundle r0 = getArguments();
        if (r0 == null) goto L6;
        String r1 = r0.getString("PrefetchSessionId");
        if (r1 == null) goto L6;
    L7:
        String r6 = r1;
        View r3 = getView();
        if (r3 == null) goto L10;
        this.f.b(r12, r3, T90(), (CardListContainerConfig) this.k.getValue(), r6, null, this, this);
    L10:
        boolean r13 = r11 instanceof CardListRootFrameLayoutContainer;
        Object r14 = r11;
        if (r13 == true) goto L13;
        r14 = null;
    L13:
        CardListRootFrameLayoutContainer r15 = (CardListRootFrameLayoutContainer) r14;
        if (r15 == null) goto L18;
        Intrinsics.checkNotNullParameter(this, "listener");
        if (((ArrayList) r15.e).contains(this) == true) goto L18;
        ((ArrayList) r15.e).add(this);
    L18:
        d r16 = com.bytedance.android.ec.sdk.helper.d.b.getPadSplitService();
        if (r16 == null) goto L22;
        CardListDialogFragment$foldStatusChangeListener$2.a r17 = (CardListDialogFragment$foldStatusChangeListener$2.a) this.i.getValue();
        r16.b();
        return;
    L22:
        return;
    L6:
        r1 = "";
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

    /* JADX WARN: Multi-variable type inference failed */
    public final View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
    L8:
        e = move-exception;
        ECExceptionMonitor.e(e);
        View r6 = null;
    L10:
        Dialog r0 = getDialog();
        if (r0 == null) goto L15;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L15;
        r1.setBackgroundDrawableResource(2131101135);
    L15:
        Dialog r2 = getDialog();
        if (r2 == null) goto L22;
        Window r7 = r2.getWindow();
        if (r7 == null) goto L22;
        View r8 = S90(r7);
        if (r8 == null) goto L22;
        r8.setPadding(0, 0, 0, 0);
    L22:
        Dialog r9 = getDialog();
        if (r9 == null) goto L27;
        Window r10 = r9.getWindow();
        if (r10 == null) goto L27;
        WindowManager.LayoutParams r11 = r10.getAttributes();
    L29:
        if (r11 == null) goto L31;
        r11.width = -1;
    L31:
        if (r11 == null) goto L33;
        r11.height = -1;
    L33:
        Dialog r12 = getDialog();
        if (r12 == null) goto L38;
        Window r13 = r12.getWindow();
        if (r13 == null) goto L38;
        r13.setAttributes(r11);
    L38:
        Dialog r14 = getDialog();
        if (r14 == null) goto L41;
        r14.setOnDismissListener(this);
    L41:
        Dialog r15 = getDialog();
        if (r15 == null) goto L44;
        r15.setOnKeyListener(new c(this));
    L44:
        Dialog r16 = getDialog();
        if (r16 == null) goto L49;
        Window r17 = r16.getWindow();
        if (r17 == null) goto L49;
        Ref.ObjectRef r18 = new Ref.ObjectRef();
        r18.element = null;
        this.l = new com.bytedance.android.shopping.card_list.container.a(r17, r18);
        S90(r17).getViewTreeObserver().addOnPreDrawListener(this.l);
    L49:
        Dialog r19 = getDialog();
        if (r19 == null) goto L54;
        Window r20 = r19.getWindow();
        if (r20 == null) goto L54;
        m.a(r20, true);
    L54:
        return r6;
    L27:
        r11 = null;
        goto L29
    L4:
        if (U90() == false) goto L6;
        r6 = th.a.c(requireContext(), 2131560615, r4, false);     // Catch: InflateException -> L8
    L55:
        goto L10
    L6:
        r6 = th.a.c(requireContext(), 2131559255, r4, false);     // Catch: InflateException -> L8
        goto L55
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
