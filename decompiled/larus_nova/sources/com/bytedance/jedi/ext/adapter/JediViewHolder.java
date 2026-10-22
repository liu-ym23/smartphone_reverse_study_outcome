package com.bytedance.jedi.ext.adapter;

import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.jedi.arch.Async;
import com.bytedance.jedi.arch.IReceiver;
import com.bytedance.jedi.arch.ISubscriber;
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
import com.bytedance.jedi.ext.adapter.internal.JediViewHolderProxy;
import com.bytedance.jedi.ext.adapter.internal.JediViewHolderProxyProvider;
import com.bytedance.jedi.ext.adapter.multitype.MultiTypeViewHolder;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\u0004\b\u0001\u0010\u00032\b\u0012\u0004\u0012\u00028\u00010\u00042\u00020\u00052\u00020\u00062\b\u0012\u0004\u0012\u00028\u00000\u0007J\u000f\u0010\u000b\u001a\u00020\bH\u0001¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\r\u001a\u00020\bH\u0001¢\u0006\u0004\b\f\u0010\nJ\u000f\u0010\u000f\u001a\u00020\bH\u0001¢\u0006\u0004\b\u000e\u0010\nJ\u000f\u0010\u0011\u001a\u00020\bH\u0001¢\u0006\u0004\b\u0010\u0010\nJ\u000f\u0010\u0013\u001a\u00020\bH\u0001¢\u0006\u0004\b\u0012\u0010\nJ\u000f\u0010\u0015\u001a\u00020\bH\u0001¢\u0006\u0004\b\u0014\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/bytedance/jedi/ext/adapter/JediViewHolder;", "Lcom/bytedance/jedi/arch/IReceiver;", "R", "ITEM", "Lcom/bytedance/jedi/ext/adapter/multitype/MultiTypeViewHolder;", "Landroidx/lifecycle/LifecycleOwner;", "Landroidx/lifecycle/LifecycleObserver;", "", "", "create$ext_adapter_release", "()V", "create", "start$ext_adapter_release", "start", "resume$ext_adapter_release", "resume", "pause$ext_adapter_release", "pause", "stop$ext_adapter_release", "stop", "destroy$ext_adapter_release", MapMonitorConst.EVENT_DESTROY, "ext_adapter_release"}, k = 1, mv = {1, 4, 0})
public abstract class JediViewHolder<R extends IReceiver, ITEM> extends MultiTypeViewHolder<ITEM> implements LifecycleOwner, LifecycleObserver, IReceiver, ISubscriber {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f250957j = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LifecycleOwner f250958e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public JediViewHolderProxyProvider f250959f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public JediViewHolderProxy f250960g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f250961h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f250962i;

    static {
        f250957j = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(JediViewHolder.class), "lifecycleRegistry", "getLifecycleRegistry()Landroid/arch/lifecycle/LifecycleRegistry;"))};
    }

    private final LifecycleRegistry getLifecycleRegistry() {
        Lazy r100 = this.f250961h;
        KProperty r101 = f250957j[0];
        return (LifecycleRegistry) r100.getValue();
    }

    public void Y3(List<Object> r100) {
    }

    public void Z3() {
    }

    @Override // com.bytedance.jedi.ext.adapter.multitype.MultiTypeViewHolder
    public final void bind(ITEM r100, int r101) {
    }

    @Override // com.bytedance.jedi.arch.ISubscriber
    public final boolean getUniqueOnlyGlobal() {
        return false;
    }

    public void onCreate() {
    }

    public void onDestroy() {
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    @Override // com.bytedance.jedi.ext.adapter.multitype.MultiTypeViewHolder
    public void T3() {
        JediViewHolderProxy r100 = this.f250960g;
        if (r100 != null) goto L5;
    L7:
        this.f250962i = true;
        Lifecycle.State r101 = getLifecycle().getCurrentState();
        int r102 = e.f250989a[r101.ordinal()];
        if (r102 != 2) goto L10;
        start$ext_adapter_release();
        resume$ext_adapter_release();
        return;
    L10:
        if (r102 != 3) goto L16;
        resume$ext_adapter_release();
        return;
    L16:
        return;
    L5:
        if (this != r100.f251003b) goto L7;
        r100.f251004c = false;
        goto L7
    }

    @Override // com.bytedance.jedi.ext.adapter.multitype.MultiTypeViewHolder
    public void V3() {
        JediViewHolderProxy r100 = this.f250960g;
        if (r100 != null) goto L5;
    L7:
        X3();
        return;
    L5:
        if (this != r100.f251003b) goto L7;
        r100.f251004c = true;
        goto L7
    }

    public final LifecycleOwner W3() {
        LifecycleOwner r100 = this.f250958e;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("parent");
    L5:
        return r100;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public final void create$ext_adapter_release() {
        JediViewHolderProxyProvider r100 = this.f250959f;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException(ShortVideoSegments.KEY_PROP_PROVIDER);
    L5:
        com.bytedance.jedi.ext.adapter.internal.b r101 = r100.f251021b;
        int r102 = this.f251038c;
        if (r102 >= 0) goto L8;
        r101.getClass();
    L11:
        boolean r103 = false;
    L12:
        if (r103 == true) goto L18;
        onCreate();
        JediViewHolderProxyProvider r104 = this.f250959f;
        if (r104 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException(ShortVideoSegments.KEY_PROP_PROVIDER);
    L16:
        r104.f251021b.a(this.f251038c, true);
        getLifecycleRegistry().handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        return;
    L18:
        return;
    L8:
        if (r102 >= ((ArrayList) r101.f251030a).size()) goto L11;
        r103 = ((Boolean) ListProtector.get(r101.f251030a, r102)).booleanValue();
        goto L12
    }

    @Override // com.bytedance.jedi.arch.ISubscriber
    public final LifecycleOwnerHolder getLifecycleOwnerHolder() {
        JediViewHolderProxy r100 = this.f250960g;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.jedi.arch.LifecycleOwnerHolder");
    }

    @Override // com.bytedance.jedi.arch.ISubscriber
    public final ReceiverHolder<R> getReceiverHolder() {
        JediViewHolderProxy r100 = this.f250960g;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.jedi.arch.ReceiverHolder<VH>");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void pause$ext_adapter_release() {
        if (this.f250962i == false) goto L6;
        onPause();
        getLifecycleRegistry().handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
        return;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void resume$ext_adapter_release() {
        if (this.f250962i == false) goto L6;
        onResume();
        getLifecycleRegistry().handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
        return;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public final void start$ext_adapter_release() {
        if (this.f250962i == false) goto L10;
        onStart();
        LifecycleRegistry r100 = getLifecycleRegistry();
        Lifecycle.Event r101 = Lifecycle.Event.ON_START;
        r100.handleLifecycleEvent(r101);
        JediViewHolderProxy r102 = this.f250960g;
        if (r102 != null) goto L7;
        return;
    L7:
        if (this != r102.f251003b) goto L12;
        r102.f251002a = false;
        r102.f251007f = true;
        r102.getLifecycleRegistry().handleLifecycleEvent(r101);
        return;
    L12:
        return;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public final void stop$ext_adapter_release() {
        if (this.f250962i == false) goto L10;
        onStop();
        LifecycleRegistry r100 = getLifecycleRegistry();
        Lifecycle.Event r101 = Lifecycle.Event.ON_STOP;
        r100.handleLifecycleEvent(r101);
        JediViewHolderProxy r102 = this.f250960g;
        if (r102 != null) goto L7;
        return;
    L7:
        if (this != r102.f251003b) goto L12;
        r102.f251002a = false;
        r102.getLifecycleRegistry().handleLifecycleEvent(r101);
        return;
    L12:
        return;
    }

    public final void X3() {
        Lifecycle.State r100 = getLifecycle().getCurrentState();
        int r101 = e.f250990b[r100.ordinal()];
        if (r101 != 1) goto L5;
        pause$ext_adapter_release();
        stop$ext_adapter_release();
    L11:
        this.f250962i = false;
        return;
    L5:
        if (r101 != 2) goto L7;
    L9:
        stop$ext_adapter_release();
        goto L11
    L7:
        if (r101 == 3) goto L9;
        goto L9
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void destroy$ext_adapter_release() {
        onDestroy();
        LifecycleOwner r100 = this.f250958e;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("parent");
    L5:
        r100.getLifecycle().removeObserver(this);
        X3();
        getLifecycleRegistry().handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public final Lifecycle getLifecycle() {
        return getLifecycleRegistry();
    }

    public JediViewHolder(View r100) {
        super(r100);
        this.f250961h = LazyKt.lazy(new JediViewHolder$lifecycleRegistry$2(this));
    }

    @Override // com.bytedance.jedi.arch.ISubscriber
    public final <VM1 extends JediViewModel<S1>, S1 extends State, R> R withState(VM1 r100, Function1<? super S1, ? extends R> r101) {
        return (R) ISubscriber.DefaultImpls.withState(this, r100, r101);
    }

    @Override // com.bytedance.jedi.arch.ISubscriber
    public final <M1 extends Middleware<S1, PROP1>, PROP1 extends State, S1 extends State, R> R withSubstate(Middleware<S1, PROP1> r100, Function1<? super PROP1, ? extends R> r101) {
        return (R) ISubscriber.DefaultImpls.withSubstate(this, r100, r101);
    }

    @Override // com.bytedance.jedi.ext.adapter.multitype.MultiTypeViewHolder
    public final void U3(ITEM r100, int r101, List<Object> r102) {
        super.U3(r100, r101, r102);
        if (r102 == null) goto L26;
        List<Object> r103 = r102;
        boolean r104 = false;
        if ((r103 instanceof Collection) == true) goto L7;
    L9:
        Iterator<T> r105 = r103.iterator();
    L11:
        if (r105.hasNext() == false) goto L25;
        Object r106 = r105.next();
        if ((r106 instanceof Pair) == true) goto L15;
        r106 = null;
    L15:
        Pair r107 = (Pair) r106;
        if (r107 == null) goto L18;
        Object r108 = r107.getSecond();
    L20:
        if (r108 != c.f250964a) goto L22;
        boolean r109 = true;
    L23:
        if (r109 == false) goto L11;
        r104 = true;
        goto L25
    L22:
        r109 = false;
        goto L23
    L18:
        r108 = null;
    L25:
        if (r104 == false) goto L26;
    L58:
        Y3(r102);
        return;
    L7:
        if (r103.isEmpty() == false) goto L9;
    L26:
        this.f250962i = true;
        LifecycleOwner r110 = this.f250958e;
        if (r110 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("parent");
    L29:
        r110.getLifecycle().removeObserver(this);
        X3();
        JediViewHolderProxyProvider r111 = this.f250959f;
        if (r111 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException(ShortVideoSegments.KEY_PROP_PROVIDER);
    L32:
        com.bytedance.jedi.ext.adapter.internal.d r112 = r111.f251022c;
        if (r101 >= 0) goto L35;
        r112.getClass();
    L38:
        JediViewHolderProxy r113 = null;
    L39:
        if (r113 != null) goto L42;
        r113 = r111.f251020a.invoke();
        r111.f251022c.b(r101, r113);
    L42:
        JediViewHolderProxy r114 = this.f250960g;
        if (r113 == r114) goto L51;
        if (r114 == null) goto L51;
        if (this != r114.f251003b) goto L51;
        JediViewHolderProxyProvider r115 = this.f250959f;
        if (r115 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException(ShortVideoSegments.KEY_PROP_PROVIDER);
    L50:
        r114.a(r115.f251023d, null);
    L51:
        JediViewHolderProxyProvider r116 = this.f250959f;
        if (r116 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException(ShortVideoSegments.KEY_PROP_PROVIDER);
    L54:
        r113.a(r116.f251023d, this);
        this.f250962i = true;
        LifecycleOwner r117 = this.f250958e;
        if (r117 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("parent");
    L57:
        r117.getLifecycle().addObserver(this);
        goto L58
    L35:
        if (r101 >= ((ArrayList) r112.f251032a).size()) goto L38;
        r113 = (JediViewHolderProxy) ListProtector.get(r112.f251032a, r101);
        goto L39
    }

    @Override // com.bytedance.jedi.arch.ISubscriber
    public final <S extends State> Disposable subscribe(JediViewModel<S> r100, SubscriptionConfig<S> r101, Function2<? super R, ? super S, Unit> r102) {
        return ISubscriber.DefaultImpls.subscribe(this, r100, r101, r102);
    }

    @Override // com.bytedance.jedi.arch.ISubscriber
    public final <VM1 extends JediViewModel<S1>, S1 extends State, VM2 extends JediViewModel<S2>, S2 extends State, R> R withState(VM1 r100, VM2 r101, Function2<? super S1, ? super S2, ? extends R> r102) {
        return (R) ISubscriber.DefaultImpls.withState(this, r100, r101, r102);
    }

    @Override // com.bytedance.jedi.arch.ISubscriber
    public final <M1 extends Middleware<S1, PROP1>, PROP1 extends State, S1 extends State, M2 extends Middleware<S2, PROP2>, PROP2 extends State, S2 extends State, R> R withSubstate(Middleware<S1, PROP1> r100, Middleware<S2, PROP2> r101, Function2<? super PROP1, ? super PROP2, ? extends R> r102) {
        return (R) ISubscriber.DefaultImpls.withSubstate(this, r100, r101, r102);
    }

    @Override // com.bytedance.jedi.arch.ISubscriber
    public final <S extends State, A> Disposable selectSubscribe(JediViewModel<S> r100, KProperty1<S, ? extends A> r101, SubscriptionConfig<Tuple1<A>> r102, Function2<? super R, ? super A, Unit> r103) {
        return ISubscriber.DefaultImpls.selectSubscribe(this, r100, r101, r102, r103);
    }

    @Override // com.bytedance.jedi.arch.ISubscriber
    public final <VM1 extends JediViewModel<S1>, S1 extends State, VM2 extends JediViewModel<S2>, S2 extends State, VM3 extends JediViewModel<S3>, S3 extends State, R> R withState(VM1 r100, VM2 r101, VM3 r102, Function3<? super S1, ? super S2, ? super S3, ? extends R> r103) {
        return (R) ISubscriber.DefaultImpls.withState(this, r100, r101, r102, r103);
    }

    @Override // com.bytedance.jedi.arch.ISubscriber
    public final <M1 extends Middleware<S1, PROP1>, PROP1 extends State, S1 extends State, M2 extends Middleware<S2, PROP2>, PROP2 extends State, S2 extends State, M3 extends Middleware<S3, PROP3>, PROP3 extends State, S3 extends State, R> R withSubstate(Middleware<S1, PROP1> r100, Middleware<S2, PROP2> r101, Middleware<S3, PROP3> r102, Function3<? super PROP1, ? super PROP2, ? super PROP3, ? extends R> r103) {
        return (R) ISubscriber.DefaultImpls.withSubstate(this, r100, r101, r102, r103);
    }

    @Override // com.bytedance.jedi.arch.ISubscriber
    public final <S extends State, A, B> Disposable selectSubscribe(JediViewModel<S> r100, KProperty1<S, ? extends A> r101, KProperty1<S, ? extends B> r102, SubscriptionConfig<Tuple2<A, B>> r103, Function3<? super R, ? super A, ? super B, Unit> r104) {
        return ISubscriber.DefaultImpls.selectSubscribe(this, r100, r101, r102, r103, r104);
    }

    @Override // com.bytedance.jedi.arch.ISubscriber
    public final <VM1 extends JediViewModel<S1>, S1 extends State, VM2 extends JediViewModel<S2>, S2 extends State, VM3 extends JediViewModel<S3>, S3 extends State, VM4 extends JediViewModel<S4>, S4 extends State, R> R withState(VM1 r100, VM2 r101, VM3 r102, VM4 r103, Function4<? super S1, ? super S2, ? super S3, ? super S4, ? extends R> r104) {
        return (R) ISubscriber.DefaultImpls.withState(this, r100, r101, r102, r103, r104);
    }

    @Override // com.bytedance.jedi.arch.ISubscriber
    public final <M1 extends Middleware<S1, PROP1>, PROP1 extends State, S1 extends State, M2 extends Middleware<S2, PROP2>, PROP2 extends State, S2 extends State, M3 extends Middleware<S3, PROP3>, PROP3 extends State, S3 extends State, M4 extends Middleware<S4, PROP4>, PROP4 extends State, S4 extends State, R> R withSubstate(Middleware<S1, PROP1> r100, Middleware<S2, PROP2> r101, Middleware<S3, PROP3> r102, Middleware<S4, PROP4> r103, Function4<? super PROP1, ? super PROP2, ? super PROP3, ? super PROP4, ? extends R> r104) {
        return (R) ISubscriber.DefaultImpls.withSubstate(this, r100, r101, r102, r103, r104);
    }

    @Override // com.bytedance.jedi.arch.ISubscriber
    public final <S extends State, T> Disposable asyncSubscribe(JediViewModel<S> r100, KProperty1<S, ? extends Async<? extends T>> r101, SubscriptionConfig<Tuple1<Async<T>>> r102, Function2<? super R, ? super Throwable, Unit> r103, Function1<? super R, Unit> r104, Function2<? super R, ? super T, Unit> r105) {
        return ISubscriber.DefaultImpls.asyncSubscribe(this, r100, r101, r102, r103, r104, r105);
    }

    @Override // com.bytedance.jedi.arch.ISubscriber
    public final <S extends State, A, B, C> Disposable selectSubscribe(JediViewModel<S> r100, KProperty1<S, ? extends A> r101, KProperty1<S, ? extends B> r102, KProperty1<S, ? extends C> r103, SubscriptionConfig<Tuple3<A, B, C>> r104, Function4<? super R, ? super A, ? super B, ? super C, Unit> r105) {
        return ISubscriber.DefaultImpls.selectSubscribe(this, r100, r101, r102, r103, r104, r105);
    }

    @Override // com.bytedance.jedi.arch.ISubscriber
    public final <VM1 extends JediViewModel<S1>, S1 extends State, VM2 extends JediViewModel<S2>, S2 extends State, VM3 extends JediViewModel<S3>, S3 extends State, VM4 extends JediViewModel<S4>, S4 extends State, VM5 extends JediViewModel<S5>, S5 extends State, R> R withState(VM1 r100, VM2 r101, VM3 r102, VM4 r103, VM5 r104, Function5<? super S1, ? super S2, ? super S3, ? super S4, ? super S5, ? extends R> r105) {
        return (R) ISubscriber.DefaultImpls.withState(this, r100, r101, r102, r103, r104, r105);
    }

    @Override // com.bytedance.jedi.arch.ISubscriber
    public final <M1 extends Middleware<S1, PROP1>, PROP1 extends State, S1 extends State, M2 extends Middleware<S2, PROP2>, PROP2 extends State, S2 extends State, M3 extends Middleware<S3, PROP3>, PROP3 extends State, S3 extends State, M4 extends Middleware<S4, PROP4>, PROP4 extends State, S4 extends State, M5 extends Middleware<S5, PROP5>, PROP5 extends State, S5 extends State, R> R withSubstate(Middleware<S1, PROP1> r100, Middleware<S2, PROP2> r101, Middleware<S3, PROP3> r102, Middleware<S4, PROP4> r103, Middleware<S5, PROP5> r104, Function5<? super PROP1, ? super PROP2, ? super PROP3, ? super PROP4, ? super PROP5, ? extends R> r105) {
        return (R) ISubscriber.DefaultImpls.withSubstate(this, r100, r101, r102, r103, r104, r105);
    }

    @Override // com.bytedance.jedi.arch.ISubscriber
    public final <S extends State, A, B, C, D> Disposable selectSubscribe(JediViewModel<S> r100, KProperty1<S, ? extends A> r101, KProperty1<S, ? extends B> r102, KProperty1<S, ? extends C> r103, KProperty1<S, ? extends D> r104, SubscriptionConfig<Tuple4<A, B, C, D>> r105, Function5<? super R, ? super A, ? super B, ? super C, ? super D, Unit> r106) {
        return ISubscriber.DefaultImpls.selectSubscribe(this, r100, r101, r102, r103, r104, r105, r106);
    }

    @Override // com.bytedance.jedi.arch.ISubscriber
    public final <S extends State, A, B, C, D, E> Disposable selectSubscribe(JediViewModel<S> r100, KProperty1<S, ? extends A> r101, KProperty1<S, ? extends B> r102, KProperty1<S, ? extends C> r103, KProperty1<S, ? extends D> r104, KProperty1<S, ? extends E> r105, SubscriptionConfig<Tuple5<A, B, C, D, E>> r106, Function6<? super R, ? super A, ? super B, ? super C, ? super D, ? super E, Unit> r107) {
        return ISubscriber.DefaultImpls.selectSubscribe(this, r100, r101, r102, r103, r104, r105, r106, r107);
    }
}
