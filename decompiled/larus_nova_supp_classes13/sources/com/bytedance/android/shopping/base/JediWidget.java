package com.bytedance.android.shopping.base;

import android.app.Activity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.android.ec.core.jedi.ReflectViewModelFactory;
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
import com.bytedance.jedi.ext.adapter.a;
import com.bytedance.widget.Widget;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003B\u0007¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\b\u001a\u00020\u00058DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/base/JediWidget;", "Lcom/bytedance/widget/Widget;", "Lcom/bytedance/jedi/arch/JediView;", "Lcom/bytedance/jedi/arch/ViewModelFactoryOwner;", "Lcom/bytedance/android/ec/core/jedi/ReflectViewModelFactory;", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "activity", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class JediWidget extends Widget implements JediView, ViewModelFactoryOwner<ReflectViewModelFactory> {
    public final ReflectViewModelFactory a;

    public JediWidget() {
        this.a = new ReflectViewModelFactory();
    }

    public final Activity getActivity() {
        return a.a(this);
    }

    public final LifecycleOwner getLifecycleOwner() {
        return JediView.DefaultImpls.getLifecycleOwner(this);
    }

    public final LifecycleOwnerHolder getLifecycleOwnerHolder() {
        return JediView.DefaultImpls.getLifecycleOwnerHolder(this);
    }

    public final /* bridge */ /* synthetic */ IReceiver getReceiver() {
        return m230getReceiver();
    }

    public final ReceiverHolder<IdentitySubscriber> getReceiverHolder() {
        return JediView.DefaultImpls.getReceiverHolder(this);
    }

    public final boolean getUniqueOnlyGlobal() {
        return JediView.DefaultImpls.getUniqueOnlyGlobal(this);
    }

    public final ViewModelProvider.Factory getViewModelFactory() {
        return this.a;
    }

    /* JADX INFO: renamed from: getReceiver, reason: collision with other method in class */
    public final IdentitySubscriber m230getReceiver() {
        return JediView.DefaultImpls.getReceiver(this);
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
