package com.bytedance.android.shopping.inflow.compat;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.android.ec.core.jedi.ReflectViewModelFactory;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.n1;
import com.bytedance.android.shopping.anchorv3.compat.CompatFrameLayout;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
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
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import java.util.LinkedList;
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
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u00032\u00020\u0005:\u0002\b\tB\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/inflow/compat/ToggleBottomSheetFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "Lcom/bytedance/jedi/arch/JediView;", "Lcom/bytedance/jedi/arch/ViewModelFactoryOwner;", "Lcom/bytedance/android/ec/core/jedi/ReflectViewModelFactory;", "Landroid/content/DialogInterface$OnShowListener;", "<init>", "()V", "a", "b", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class ToggleBottomSheetFragment extends BottomSheetDialogFragment implements JediView, ViewModelFactoryOwner<ReflectViewModelFactory>, DialogInterface.OnShowListener {
    public final ReflectViewModelFactory d;
    public View e;
    public BottomSheetBehavior<View> f;
    public final Lazy g;
    public final LinkedList<b> h;
    public final int i;
    public final boolean j;
    public final boolean k;
    public final boolean l;

    public static final class a {
    }

    public interface b {
        void a(boolean r1);
    }

    public static final class c implements Runnable {
        public final /* synthetic */ ToggleBottomSheetFragment a;

        public c(ToggleBottomSheetFragment r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Dialog r0 = this.a.getDialog();     // Catch: Throwable -> L8
            if (r0 == null) goto L11;
            Window r1 = r0.getWindow();     // Catch: Throwable -> L8
            if (r1 == null) goto L15;
            r1.setWindowAnimations(2131954184);     // Catch: Throwable -> L8
            return;
        L15:
            return;
        L11:
            return;
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        }
    }

    public static final class d extends BottomSheetBehavior.BottomSheetCallback {
        public final /* synthetic */ ToggleBottomSheetFragment a;
        public final /* synthetic */ DialogInterface b;

        public d(ToggleBottomSheetFragment r1, DialogInterface r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onSlide(View r2, float r3) {
            Intrinsics.checkNotNullParameter(r2, FreqActions.ACTION_VIEW);
            this.a.W90(r3);
        }

        public final void onStateChanged(View r3, int r4) {
            Intrinsics.checkNotNullParameter(r3, FreqActions.ACTION_VIEW);
            this.a.X90(r4);
            if (r4 != 5) goto L6;
            this.b.dismiss();
        L6:
            if (r4 != 3) goto L12;
            this.a.V90(true);
            Iterator<T> r5 = this.a.h.iterator();
        L9:
            if (r5.hasNext() == false) goto L12;
            ((b) r5.next()).a(true);
        L12:
            if (r4 != 4) goto L17;
            this.a.V90(false);
            Iterator<T> r6 = this.a.h.iterator();
        L15:
            if (r6.hasNext() == false) goto L20;
            ((b) r6.next()).a(false);
            goto L15
        L20:
            return;
        }
    }

    static {
    }

    public abstract int S90();

    public int T90() {
        return -1;
    }

    public void V90(boolean r1) {
    }

    public void W90(float r1) {
    }

    public void X90(int r1) {
    }

    public abstract int getLayoutId();

    public abstract String getTAG();

    public int U90() {
        n1.i.getClass();
        return n1.a.b();
    }

    public ToggleBottomSheetFragment() {
        this.d = new ReflectViewModelFactory();
        this.g = LazyKt.lazy(new ToggleBottomSheetFragment$designBottomSheet$2(this));
        this.h = new LinkedList();
        this.i = 4;
        this.j = true;
        this.k = true;
        this.l = true;
    }

    public final LifecycleOwner getLifecycleOwner() {
        return JediView.DefaultImpls.getLifecycleOwner(this);
    }

    public final LifecycleOwnerHolder getLifecycleOwnerHolder() {
        return JediView.DefaultImpls.getLifecycleOwnerHolder(this);
    }

    public final /* bridge */ /* synthetic */ IReceiver getReceiver() {
        return m929getReceiver();
    }

    public final ReceiverHolder<IdentitySubscriber> getReceiverHolder() {
        return JediView.DefaultImpls.getReceiverHolder(this);
    }

    public final boolean getUniqueOnlyGlobal() {
        return JediView.DefaultImpls.getUniqueOnlyGlobal(this);
    }

    public void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        View r0 = getView();     // Catch: Exception -> L7
        if (r0 == null) goto L12;
        r0.postDelayed(new c(this), 300);     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        ECExceptionMonitor.e(e);
    }

    public final ViewModelProvider.Factory getViewModelFactory() {
        return this.d;
    }

    /* JADX INFO: renamed from: getReceiver, reason: collision with other method in class */
    public final IdentitySubscriber m929getReceiver() {
        return JediView.DefaultImpls.getReceiver(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onActivityCreated(Bundle r2) {
        super/*androidx.fragment.app.DialogFragment*/.onActivityCreated(r2);
        Dialog r3 = getDialog();
        if (r3 == null) goto L7;
        Window r4 = r3.getWindow();
        if (r4 == null) goto L7;
        r4.setBackgroundDrawableResource(2131101135);
    L7:
        Dialog r5 = getDialog();
        if (r5 == null) goto L10;
        r5.setOnDismissListener(this);
    L10:
        Dialog r6 = getDialog();
        if (r6 == null) goto L13;
        r6.setOnShowListener(this);
    L13:
        Dialog r7 = getDialog();
        if (r7 == null) goto L17;
        r7.setOnKeyListener(new com.bytedance.android.shopping.inflow.compat.c(this));
        return;
    }

    public void onCreate(Bundle r3) {
        Dialog r0 = getDialog();
        if (r0 == null) goto L5;
        r0.requestWindowFeature(1);
    L5:
        super/*androidx.fragment.app.DialogFragment*/.onCreate(r3);
    }

    public final Dialog onCreateDialog(Bundle r4) {
        return new ToggleBottomSheetDialog(requireActivity(), S90(), AnonymousClass1.INSTANCE);
    }

    public void onShow(final DialogInterface r4) {
        Intrinsics.checkNotNullParameter(r4, "dialog");
        View r0 = (View) this.g.getValue();
        if (r0 == null) goto L33;
        this.e = r0;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        r1.width = -1;
        if (this.k == false) goto L7;
        int r2 = T90();
    L8:
        r1.height = r2;
        BottomSheetBehavior<View> r3 = BottomSheetBehavior.from(r0);
        this.f = r3;
        if (r3 == null) goto L11;
        r3.setBottomSheetCallback(new d(this, r4));
    L11:
        BottomSheetBehavior<View> r5 = this.f;
        if (r5 == null) goto L14;
        r5.setSkipCollapsed(!this.l);
    L14:
        BottomSheetBehavior<View> r6 = this.f;
        if (r6 == null) goto L17;
        r6.setState(this.i);
    L17:
        BottomSheetBehavior<View> r7 = this.f;
        if (r7 == null) goto L20;
        r7.setHideable(this.j);
    L20:
        BottomSheetBehavior<View> r8 = this.f;
        if (r8 == null) goto L24;
        r8.setPeekHeight(U90());
    L24:
        if ((r0 instanceof CompatFrameLayout) == true) goto L26;
        r0 = null;
    L26:
        CompatFrameLayout r9 = (CompatFrameLayout) r0;
        if (r9 == null) goto L29;
        Function0<Unit> r10 = new ToggleBottomSheetFragment$onShow$$inlined$let$lambda$2(this, r4);
        Intrinsics.checkNotNullParameter(r10, "dcb");
        r9.b = r10;
    L29:
        View r11 = getView();
        if (r11 == null) goto L34;
        r11.getHeight();
        return;
    L34:
        return;
    L7:
        r2 = U90();
        goto L8
    }

    public final void Y90(Activity r2, FragmentManager r3) {
        if (r3 == null) goto L21;
        r3.beginTransaction().remove(this).commitAllowingStateLoss();     // Catch: Exception -> L13
        if (r2 != null) goto L6;
        return;
    L6:
        if (r2.isFinishing() == true) goto L23;
        String r4 = getTAG();     // Catch: Exception -> L13
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;     // Catch: Exception -> L13
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, r4, r0);     // Catch: Exception -> L13
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, this, r0) == true) goto L24;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L16
    L11:
        super/*androidx.fragment.app.DialogFragment*/.show(r3, r4);     // Catch: Exception -> L13
        return;
    L24:
        return;
    L23:
        return;
    L13:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return;
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
        Context r5 = getContext();
        if (r5 != null) goto L7;
        return null;
    L7:
        return th.a.c(r5, getLayoutId(), r3, false);
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
