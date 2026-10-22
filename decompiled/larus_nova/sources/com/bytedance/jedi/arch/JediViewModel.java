package com.bytedance.jedi.arch;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.bytedance.jedi.arch.State;
import com.bytedance.jedi.arch.internal.LifecycleAwareObserver;
import com.bytedance.jedi.arch.internal.SmartHandlerSchedulerKt;
import com.bytedance.jedi.arch.internal.StoreOwner;
import com.bytedance.jedi.arch.internal.SubscriptioinExtensionsKt;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000Ô\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0086\u0001\u0010\u001c\u001a\u00020\u001d\"\u0004\b\u0001\u0010\u001e2\u0018\u0010\u001f\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001e0!0 2\u001a\b\u0002\u0010\"\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001e0!0$0#2\u0016\b\u0002\u0010%\u001a\u0010\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020(\u0018\u00010&2\u0010\b\u0002\u0010)\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010*2\u0016\b\u0002\u0010+\u001a\u0010\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u00020(\u0018\u00010&H\u0004J1\u0010,\u001a\u00020(\"\u0004\b\u0001\u0010-\"\u0014\b\u0002\u0010.*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H-0/2\u0006\u00100\u001a\u0002H.H\u0007¢\u0006\u0002\u00101J\u000e\u00102\u001a\b\u0012\u0004\u0012\u00028\u000003H\u0002J\r\u00104\u001a\u00028\u0000H$¢\u0006\u0002\u0010\u0011J\u001f\u00105\u001a\u00020(2\u0017\u00106\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000&¢\u0006\u0002\b7J[\u00108\u001a\u00020\u001d\"\u0004\b\u0001\u0010\u001e2\f\u00109\u001a\b\u0012\u0004\u0012\u0002H\u001e0\u00192\b\u0010:\u001a\u0004\u0018\u00010;2\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020=2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010@2\u0012\u0010A\u001a\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u00020(0&H\u0000¢\u0006\u0002\bBJ\b\u0010C\u001a\u00020(H\u0015J\b\u0010D\u001a\u00020(H\u0014JL\u0010E\u001a\u00020\u001d\"\u0004\b\u0001\u0010F2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002HF0 2\u0014\b\u0002\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002HF0$0#2\u0012\u0010A\u001a\u000e\u0012\u0004\u0012\u0002HF\u0012\u0004\u0012\u00020(0&H\u0004Jr\u0010E\u001a\u00020\u001d\"\u0004\b\u0001\u0010F\"\u0004\b\u0002\u0010G2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002HF0 2\u0012\u0010H\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002HG0 2\u001a\b\u0002\u0010\"\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002HF\u0012\u0004\u0012\u0002HG0I0#2\u0018\u0010A\u001a\u0014\u0012\u0004\u0012\u0002HF\u0012\u0004\u0012\u0002HG\u0012\u0004\u0012\u00020(0JH\u0004J\u0098\u0001\u0010E\u001a\u00020\u001d\"\u0004\b\u0001\u0010F\"\u0004\b\u0002\u0010G\"\u0004\b\u0003\u0010K2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002HF0 2\u0012\u0010H\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002HG0 2\u0012\u0010L\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002HK0 2 \b\u0002\u0010\"\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u0002HF\u0012\u0004\u0012\u0002HG\u0012\u0004\u0012\u0002HK0M0#2\u001e\u0010A\u001a\u001a\u0012\u0004\u0012\u0002HF\u0012\u0004\u0012\u0002HG\u0012\u0004\u0012\u0002HK\u0012\u0004\u0012\u00020(0NH\u0004J¾\u0001\u0010E\u001a\u00020\u001d\"\u0004\b\u0001\u0010F\"\u0004\b\u0002\u0010G\"\u0004\b\u0003\u0010K\"\u0004\b\u0004\u0010O2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002HF0 2\u0012\u0010H\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002HG0 2\u0012\u0010L\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002HK0 2\u0012\u0010P\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002HO0 2&\b\u0002\u0010\"\u001a \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u0002HF\u0012\u0004\u0012\u0002HG\u0012\u0004\u0012\u0002HK\u0012\u0004\u0012\u0002HO0Q0#2$\u0010A\u001a \u0012\u0004\u0012\u0002HF\u0012\u0004\u0012\u0002HG\u0012\u0004\u0012\u0002HK\u0012\u0004\u0012\u0002HO\u0012\u0004\u0012\u00020(0RH\u0004Jä\u0001\u0010E\u001a\u00020\u001d\"\u0004\b\u0001\u0010F\"\u0004\b\u0002\u0010G\"\u0004\b\u0003\u0010K\"\u0004\b\u0004\u0010O\"\u0004\b\u0005\u0010S2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002HF0 2\u0012\u0010H\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002HG0 2\u0012\u0010L\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002HK0 2\u0012\u0010P\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002HO0 2\u0012\u0010T\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002HS0 2,\b\u0002\u0010\"\u001a&\u0012\"\u0012 \u0012\u0004\u0012\u0002HF\u0012\u0004\u0012\u0002HG\u0012\u0004\u0012\u0002HK\u0012\u0004\u0012\u0002HO\u0012\u0004\u0012\u0002HS0U0#2*\u0010A\u001a&\u0012\u0004\u0012\u0002HF\u0012\u0004\u0012\u0002HG\u0012\u0004\u0012\u0002HK\u0012\u0004\u0012\u0002HO\u0012\u0004\u0012\u0002HS\u0012\u0004\u0012\u00020(0VH\u0004J!\u0010W\u001a\u00020(2\u0017\u0010X\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000&¢\u0006\u0002\b7H\u0004J!\u0010Y\u001a\u00020(2\u0017\u0010X\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000&¢\u0006\u0002\b7H\u0005J&\u0010Z\u001a\u00020(2\u0017\u0010X\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000&¢\u0006\u0002\b7H\u0000¢\u0006\u0002\b[J&\u0010\\\u001a\u00020(2\u0017\u0010X\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000&¢\u0006\u0002\b7H\u0000¢\u0006\u0002\b]J,\u0010^\u001a\u00020\u001d2\u000e\b\u0002\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#2\u0012\u0010A\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020(0&H\u0004J\u001c\u0010_\u001a\u00020(2\u0012\u0010`\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020(0&H\u0004J \u0010a\u001a\u00020(2\u0012\u0010`\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020(0&H\u0085\bø\u0001\u0000J!\u0010b\u001a\u00020(2\u0012\u0010`\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020(0&H\u0000¢\u0006\u0002\bcJ\f\u0010d\u001a\u00020\u001d*\u00020\u001dH\u0004J/\u0010e\u001a\u00020\u001d*\u00020f2#\u0010g\u001a\u001f\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020(0!\u0012\u0004\u0012\u00028\u00000J¢\u0006\u0002\b7JW\u0010e\u001a\u00020\u001d\"\u0004\b\u0001\u0010\u001e\"\u0004\b\u0002\u0010h*\b\u0012\u0004\u0012\u0002H\u001e0\u00192\u0012\u0010i\u001a\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u0002Hh0&2#\u0010g\u001a\u001f\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u0002Hh0!\u0012\u0004\u0012\u00028\u00000J¢\u0006\u0002\b7H\u0004J=\u0010e\u001a\u00020\u001d\"\u0004\b\u0001\u0010\u001e*\b\u0012\u0004\u0012\u0002H\u001e0\u00192#\u0010g\u001a\u001f\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001e0!\u0012\u0004\u0012\u00028\u00000J¢\u0006\u0002\b7H\u0004JW\u0010e\u001a\u00020\u001d\"\u0004\b\u0001\u0010\u001e\"\u0004\b\u0002\u0010h*\b\u0012\u0004\u0012\u0002H\u001e0j2\u0012\u0010i\u001a\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u0002Hh0&2#\u0010g\u001a\u001f\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u0002Hh0!\u0012\u0004\u0012\u00028\u00000J¢\u0006\u0002\b7H\u0004J=\u0010e\u001a\u00020\u001d\"\u0004\b\u0001\u0010\u001e*\b\u0012\u0004\u0012\u0002H\u001e0j2#\u0010g\u001a\u001f\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001e0!\u0012\u0004\u0012\u00028\u00000J¢\u0006\u0002\b7H\u0004R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\rR\u001a\u0010\u000e\u001a\u00028\u00008@X\u0081\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0011R!\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u00198@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006k"}, d2 = {"Lcom/bytedance/jedi/arch/JediViewModel;", ExifInterface.LATITUDE_SOUTH, "Lcom/bytedance/jedi/arch/State;", "Landroidx/lifecycle/ViewModel;", "Lcom/bytedance/jedi/arch/ViewModelInitializer;", "()V", "bindingFactory", "Lcom/bytedance/jedi/arch/MiddlewareBindingFactory;", "getBindingFactory", "()Lcom/bytedance/jedi/arch/MiddlewareBindingFactory;", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "initialState", "Lcom/bytedance/jedi/arch/State;", "state", "getState$annotations", "getState", "()Lcom/bytedance/jedi/arch/State;", "storeOwner", "Lcom/bytedance/jedi/arch/internal/StoreOwner;", "getStoreOwner", "()Lcom/bytedance/jedi/arch/internal/StoreOwner;", "storeOwner$delegate", "Lkotlin/Lazy;", "stream", "Lio/reactivex/Observable;", "getStream$arch_release", "()Lio/reactivex/Observable;", "asyncSubscribe", "Lio/reactivex/disposables/Disposable;", ExifInterface.GPS_DIRECTION_TRUE, "prop1", "Lkotlin/reflect/KProperty1;", "Lcom/bytedance/jedi/arch/Async;", "config", "Lcom/bytedance/jedi/arch/SubscriptionConfig;", "Lcom/bytedance/jedi/arch/Tuple1;", LynxVideoManagerLite.EVENT_ON_ERROR, "Lkotlin/Function1;", "", "", "onLoading", "Lkotlin/Function0;", "onSuccess", "bindMiddleware", "PROP", "MW", "Lcom/bytedance/jedi/arch/Middleware;", "middleware", "(Lcom/bytedance/jedi/arch/Middleware;)V", "createStore", "Lcom/bytedance/jedi/arch/Store;", "defaultState", "initialize", "argsAcceptor", "Lkotlin/ExtensionFunctionType;", "lifecycleAwareSubscribe", "source", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "uniqueOnly", "", "force", "observeOn", "Lio/reactivex/Scheduler;", "subscriber", "lifecycleAwareSubscribe$arch_release", "onCleared", WidgetCostModule.TYPE_ON_START, "selectSubscribe", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "prop2", "Lcom/bytedance/jedi/arch/Tuple2;", "Lkotlin/Function2;", "C", "prop3", "Lcom/bytedance/jedi/arch/Tuple3;", "Lkotlin/Function3;", "D", "prop4", "Lcom/bytedance/jedi/arch/Tuple4;", "Lkotlin/Function4;", ExifInterface.LONGITUDE_EAST, "prop5", "Lcom/bytedance/jedi/arch/Tuple5;", "Lkotlin/Function5;", "setState", "reducer", "setStateImmediate", "setStateImmediateInternal", "setStateImmediateInternal$arch_release", "setStateInternal", "setStateInternal$arch_release", "subscribe", "withState", "block", "withStateImmediate", "withStateInternal", "withStateInternal$arch_release", "disposeOnClear", "execute", "Lio/reactivex/Completable;", "stateReducer", "V", "mapper", "Lio/reactivex/Single;", "arch_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class JediViewModel<S extends State> extends ViewModel implements ViewModelInitializer<S> {
    private final MiddlewareBindingFactory bindingFactory;
    private final CompositeDisposable disposables;
    private S initialState;
    private final Lazy storeOwner$delegate;

    public static /* synthetic */ void Mo(Function1 r100, Object r101) {
        lifecycleAwareSubscribe$lambda$6(r100, r101);
    }

    public static /* synthetic */ void No(Function1 r100, Object r101) {
        execute$lambda$3(r100, r101);
    }

    public static /* synthetic */ Unit Oo() {
        return execute$lambda$0();
    }

    public static /* synthetic */ Async Po(Function1 r100, Object r101) {
        return execute$lambda$1(r100, r101);
    }

    public static /* synthetic */ void getState$annotations() {
    }

    public static /* synthetic */ Async yo(Function1 r100, Object r101) {
        return execute$lambda$2(r100, r101);
    }

    public abstract S defaultState();

    public void onStart() {
    }

    private final Store<S> createStore() {
        S r100 = this.initialState;
        if (r100 == null) goto L7;
        Function2<JediViewModel<State>, State, Store<State>> r101 = JediArchPlugins.INSTANCE.getStoreFactory$arch_release();
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type com.bytedance.jedi.arch.JediViewModel<com.bytedance.jedi.arch.State>");
        Object r102 = r101.invoke(this, r100);
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type com.bytedance.jedi.arch.Store<S of com.bytedance.jedi.arch.JediViewModel>");
        return (Store) r102;
    L7:
        throw new IllegalArgumentException(("Cannot visit store before ViewModel(" + getClass() + ") is initialized").toString());
    }

    private final StoreOwner<S> getStoreOwner() {
        return (StoreOwner) this.storeOwner$delegate.getValue();
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        this.disposables.clear();
    }

    public JediViewModel() {
        this.storeOwner$delegate = LazyKt.lazy(new JediViewModel$storeOwner$2(this));
        this.disposables = new CompositeDisposable();
        this.bindingFactory = new MiddlewareBindingFactoryReflectImpl();
    }

    public final S getState() {
        return getStoreOwner().getState();
    }

    public final Observable<S> getStream$arch_release() {
        return getStoreOwner().getObservable();
    }

    private static final Unit execute$lambda$0() {
        return Unit.INSTANCE;
    }

    public final MiddlewareBindingFactory getBindingFactory() {
        return this.bindingFactory;
    }

    public static final /* synthetic */ Store access$createStore(JediViewModel r100) {
        return r100.createStore();
    }

    public final <PROP, MW extends Middleware<S, PROP>> void bindMiddleware(MW r100) {
        Intrinsics.checkNotNullParameter(r100, "middleware");
        r100.prepare$arch_release(this.disposables, this);
    }

    public final Disposable disposeOnClear(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        this.disposables.add(r100);
        return r100;
    }

    @Override // com.bytedance.jedi.arch.ViewModelInitializer
    public final void initialize(Function1<? super S, ? extends S> r100) {
        Intrinsics.checkNotNullParameter(r100, "argsAcceptor");
        if (this.initialState != null) goto L6;
        this.initialState = r100.invoke(defaultState());
        onStart();
        return;
    }

    public final void setState(Function1<? super S, ? extends S> r100) {
        Intrinsics.checkNotNullParameter(r100, "reducer");
        setStateInternal$arch_release(r100);
    }

    public final void setStateImmediate(Function1<? super S, ? extends S> r100) {
        Intrinsics.checkNotNullParameter(r100, "reducer");
        setStateImmediateInternal$arch_release(r100);
    }

    public final void setStateImmediateInternal$arch_release(Function1<? super S, ? extends S> r100) {
        Intrinsics.checkNotNullParameter(r100, "reducer");
        getStoreOwner().setImmediate(r100);
    }

    public final void setStateInternal$arch_release(Function1<? super S, ? extends S> r100) {
        Intrinsics.checkNotNullParameter(r100, "reducer");
        getStoreOwner().set(r100);
    }

    public final void withState(Function1<? super S, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        withStateInternal$arch_release(r100);
    }

    public final void withStateImmediate(Function1<? super S, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        r100.invoke(getState());
    }

    public final void withStateInternal$arch_release(Function1<? super S, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        getStoreOwner().get(r100);
    }

    private static final Async execute$lambda$1(Function1 r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "$tmp0");
        return (Async) r100.invoke(r101);
    }

    private static final Async execute$lambda$2(Function1 r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "$tmp0");
        return (Async) r100.invoke(r101);
    }

    private static final void execute$lambda$3(Function1 r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "$tmp0");
        r100.invoke(r101);
    }

    private static final void lifecycleAwareSubscribe$lambda$6(Function1 r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "$tmp0");
        r100.invoke(r101);
    }

    public final Disposable execute(Completable r100, Function2<? super S, ? super Async<Unit>, ? extends S> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "stateReducer");
        return execute(r100.toSingle(new e()), r101);
    }

    public final Disposable subscribe(SubscriptionConfig<S> r100, Function1<? super S, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "config");
        Intrinsics.checkNotNullParameter(r101, "subscriber");
        return SubscriptioinExtensionsKt.subscribeInternal(this, null, r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> Disposable execute(Single<T> r100, Function2<? super S, ? super Async<? extends T>, ? extends S> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "stateReducer");
        return execute(r100.toObservable(), AnonymousClass1.INSTANCE, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> Disposable execute(Observable<T> r100, Function2<? super S, ? super Async<? extends T>, ? extends S> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "stateReducer");
        return execute(r100, AnonymousClass3.INSTANCE, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T, V> Disposable execute(Observable<T> r100, final Function1<? super T, ? extends V> r101, final Function2<? super S, ? super Async<? extends V>, ? extends S> r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "mapper");
        Intrinsics.checkNotNullParameter(r102, "stateReducer");
        JediArchPlugins r103 = JediArchPlugins.INSTANCE;
        if (r103.isDebug() == true) goto L5;
    L7:
        final boolean r104 = false;
    L8:
        if (r104 == false) goto L10;
        final Thread r105 = ThreadMethodProxy.currentThread();
    L11:
        setState(new AnonymousClass4(r102));
        final Function1<T, Async<? extends V>> r106 = new AnonymousClass5(r101);
        Observable<R> r107 = r100.map(new b(r106));
        final AnonymousClass6 r108 = AnonymousClass6.INSTANCE;
        Observable r109 = r107.onErrorReturn(new c(r108));
        final Function1<Async<? extends V>, Unit> r110 = new AnonymousClass7(r104, r105, this, r102);
        return disposeOnClear(r109.subscribe(new d(r110)));
    L10:
        r105 = null;
        goto L11
    L5:
        if (r103.isTest$arch_release() == true) goto L7;
        r104 = true;
        goto L8
    }

    public final <A> Disposable selectSubscribe(KProperty1<S, ? extends A> r100, SubscriptionConfig<Tuple1<A>> r101, Function1<? super A, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "prop1");
        Intrinsics.checkNotNullParameter(r101, "config");
        Intrinsics.checkNotNullParameter(r102, "subscriber");
        return SubscriptioinExtensionsKt.selectSubscribeInternal(this, null, r100, r101, r102);
    }

    public final <T, V> Disposable execute(Single<T> r100, Function1<? super T, ? extends V> r101, Function2<? super S, ? super Async<? extends V>, ? extends S> r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "mapper");
        Intrinsics.checkNotNullParameter(r102, "stateReducer");
        return execute(r100.toObservable(), r101, r102);
    }

    public final <A, B> Disposable selectSubscribe(KProperty1<S, ? extends A> r100, KProperty1<S, ? extends B> r101, SubscriptionConfig<Tuple2<A, B>> r110, Function2<? super A, ? super B, Unit> r111) {
        Intrinsics.checkNotNullParameter(r100, "prop1");
        Intrinsics.checkNotNullParameter(r101, "prop2");
        Intrinsics.checkNotNullParameter(r110, "config");
        Intrinsics.checkNotNullParameter(r111, "subscriber");
        return SubscriptioinExtensionsKt.selectSubscribeInternal(this, null, r100, r101, r110, r111);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Disposable subscribe$default(JediViewModel r100, SubscriptionConfig r101, Function1 r102, int r103, Object r104) {
        if (r104 != null) goto L9;
        if ((r103 & 1) == 0) goto L7;
        r101 = SubscriptioinExtensionsKt.defaultConfig();
    L7:
        return r100.subscribe(r101, r102);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: subscribe");
    }

    public final <T> Disposable asyncSubscribe(KProperty1<S, ? extends Async<? extends T>> r100, SubscriptionConfig<Tuple1<Async<T>>> r110, Function1<? super Throwable, Unit> r111, Function0<Unit> r112, Function1<? super T, Unit> r113) {
        Intrinsics.checkNotNullParameter(r100, "prop1");
        Intrinsics.checkNotNullParameter(r110, "config");
        return SubscriptioinExtensionsKt.asyncSubscribeInternal(this, null, r100, r110, r111, r112, r113);
    }

    public final <A, B, C> Disposable selectSubscribe(KProperty1<S, ? extends A> r100, KProperty1<S, ? extends B> r110, KProperty1<S, ? extends C> r111, SubscriptionConfig<Tuple3<A, B, C>> r112, Function3<? super A, ? super B, ? super C, Unit> r113) {
        Intrinsics.checkNotNullParameter(r100, "prop1");
        Intrinsics.checkNotNullParameter(r110, "prop2");
        Intrinsics.checkNotNullParameter(r111, "prop3");
        Intrinsics.checkNotNullParameter(r112, "config");
        Intrinsics.checkNotNullParameter(r113, "subscriber");
        return SubscriptioinExtensionsKt.selectSubscribeInternal(this, null, r100, r110, r111, r112, r113);
    }

    public static /* synthetic */ Disposable selectSubscribe$default(JediViewModel r100, KProperty1 r101, SubscriptionConfig r102, Function1 r103, int r104, Object r105) {
        if (r105 != null) goto L9;
        if ((r104 & 2) == 0) goto L7;
        r102 = SubscriptioinExtensionsKt.defaultConfig();
    L7:
        return r100.selectSubscribe(r101, r102, r103);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectSubscribe");
    }

    public final <T> Disposable lifecycleAwareSubscribe$arch_release(Observable<T> r100, LifecycleOwner r101, boolean r102, boolean r103, Scheduler r104, final Function1<? super T, Unit> r105) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r105, "subscriber");
        if (r101 != null) goto L8;
        if (r104 == null) goto L7;
        r100 = r100.observeOn(r104);
    L7:
        return disposeOnClear(r100.subscribe(new a(r105)));
    L8:
        if (r104 == null) goto L11;
        r100 = r100.observeOn(r104);
    L11:
        return disposeOnClear((Disposable) r100.subscribeWith(new LifecycleAwareObserver(r101, !r102, r103, r105)));
    }

    public final <A, B, C, D> Disposable selectSubscribe(KProperty1<S, ? extends A> r110, KProperty1<S, ? extends B> r111, KProperty1<S, ? extends C> r112, KProperty1<S, ? extends D> r113, SubscriptionConfig<Tuple4<A, B, C, D>> r114, Function4<? super A, ? super B, ? super C, ? super D, Unit> r115) {
        Intrinsics.checkNotNullParameter(r110, "prop1");
        Intrinsics.checkNotNullParameter(r111, "prop2");
        Intrinsics.checkNotNullParameter(r112, "prop3");
        Intrinsics.checkNotNullParameter(r113, "prop4");
        Intrinsics.checkNotNullParameter(r114, "config");
        Intrinsics.checkNotNullParameter(r115, "subscriber");
        return SubscriptioinExtensionsKt.selectSubscribeInternal(this, null, r110, r111, r112, r113, r114, r115);
    }

    public static /* synthetic */ Disposable selectSubscribe$default(JediViewModel r100, KProperty1 r101, KProperty1 r102, SubscriptionConfig r103, Function2 r104, int r105, Object r106) {
        if (r106 != null) goto L9;
        if ((r105 & 4) == 0) goto L7;
        r103 = SubscriptioinExtensionsKt.defaultConfig();
    L7:
        return r100.selectSubscribe(r101, r102, r103, r104);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectSubscribe");
    }

    public final <A, B, C, D, E> Disposable selectSubscribe(KProperty1<S, ? extends A> r110, KProperty1<S, ? extends B> r111, KProperty1<S, ? extends C> r112, KProperty1<S, ? extends D> r113, KProperty1<S, ? extends E> r114, SubscriptionConfig<Tuple5<A, B, C, D, E>> r115, Function5<? super A, ? super B, ? super C, ? super D, ? super E, Unit> r116) {
        Intrinsics.checkNotNullParameter(r110, "prop1");
        Intrinsics.checkNotNullParameter(r111, "prop2");
        Intrinsics.checkNotNullParameter(r112, "prop3");
        Intrinsics.checkNotNullParameter(r113, "prop4");
        Intrinsics.checkNotNullParameter(r114, "prop5");
        Intrinsics.checkNotNullParameter(r115, "config");
        Intrinsics.checkNotNullParameter(r116, "subscriber");
        return SubscriptioinExtensionsKt.selectSubscribeInternal(this, null, r110, r111, r112, r113, r114, r115, r116);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Disposable asyncSubscribe$default(JediViewModel r100, KProperty1 r101, SubscriptionConfig r102, Function1 r103, Function0 r110, Function1 r111, int r112, Object r113) {
        if (r113 != null) goto L21;
        if ((r112 & 2) == 0) goto L6;
        r102 = SubscriptioinExtensionsKt.defaultConfig();
    L6:
        SubscriptionConfig r104 = r102;
        if ((r112 & 4) == 0) goto L9;
        Function1 r105 = null;
    L11:
        if ((r112 & 8) == 0) goto L13;
        Function0 r106 = null;
    L15:
        if ((r112 & 16) == 0) goto L17;
        Function1 r107 = null;
    L19:
        return r100.asyncSubscribe(r101, r104, r105, r106, r107);
    L17:
        r107 = r111;
        goto L19
    L13:
        r106 = r110;
        goto L15
    L9:
        r105 = r103;
        goto L11
    L21:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: asyncSubscribe");
    }

    public static /* synthetic */ Disposable selectSubscribe$default(JediViewModel r100, KProperty1 r101, KProperty1 r102, KProperty1 r103, SubscriptionConfig r110, Function3 r111, int r112, Object r113) {
        if (r113 != null) goto L9;
        if ((r112 & 8) == 0) goto L7;
        r110 = SubscriptioinExtensionsKt.defaultConfig();
    L7:
        return r100.selectSubscribe(r101, r102, r103, r110, r111);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectSubscribe");
    }

    public static /* synthetic */ Disposable lifecycleAwareSubscribe$arch_release$default(JediViewModel r100, Observable r101, LifecycleOwner r102, boolean r110, boolean r111, Scheduler r112, Function1 r113, int r114, Object r115) {
        if (r115 != null) goto L9;
        if ((r114 & 16) == 0) goto L7;
        r112 = SmartHandlerSchedulerKt.getSMART_MAIN();
    L7:
        return r100.lifecycleAwareSubscribe$arch_release(r101, r102, r110, r111, r112, r113);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lifecycleAwareSubscribe");
    }

    public static /* synthetic */ Disposable selectSubscribe$default(JediViewModel r100, KProperty1 r101, KProperty1 r102, KProperty1 r110, KProperty1 r111, SubscriptionConfig r112, Function4 r113, int r114, Object r115) {
        if (r115 != null) goto L9;
        if ((r114 & 16) == 0) goto L7;
        r112 = SubscriptioinExtensionsKt.defaultConfig();
    L7:
        return r100.selectSubscribe(r101, r102, r110, r111, r112, r113);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectSubscribe");
    }

    public static /* synthetic */ Disposable selectSubscribe$default(JediViewModel r100, KProperty1 r110, KProperty1 r111, KProperty1 r112, KProperty1 r113, KProperty1 r114, SubscriptionConfig r115, Function5 r116, int r117, Object r118) {
        if (r118 != null) goto L10;
        if ((r117 & 32) == 0) goto L6;
        SubscriptionConfig r101 = SubscriptioinExtensionsKt.defaultConfig();
    L8:
        return r100.selectSubscribe(r110, r111, r112, r113, r114, r101, r116);
    L6:
        r101 = r115;
        goto L8
    L10:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectSubscribe");
    }
}
