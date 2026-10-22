package com.bytedance.assem.arch.viewModel;

import android.util.SparseArray;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import com.bytedance.assem.arch.extensions.HostInjector;
import com.bytedance.assem.arch.extensions.j;
import com.bytedance.assem.arch.viewModel.h;
import com.bytedance.awemeopen.apps.framework.comment.write.model.TextExtraStruct;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KProperty1;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b!\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u00032\u00020\u0004B\b¢\u0006\u0005\b\u0092\u0001\u0010|J\b\u0010\u0006\u001a\u00020\u0005H\u0016J-\u0010\r\u001a\u00020\f2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\t¢\u0006\u0002\b\nJ\b\u0010\u000e\u001a\u00020\fH\u0014J\u0010\u0010\u0011\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010\u0014\u001a\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J'\u0010\u001b\u001a\u00020\f\"\b\b\u0001\u0010\u0016*\u00020\u00152\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00010\u0017H\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u001c\u001a\u00020\fH\u0015J!\u0010\u001e\u001a\u00020\f2\u0017\u0010\u001d\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\t¢\u0006\u0002\b\nH\u0004J\u001c\u0010 \u001a\u00020\f2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\f0\tH\u0004J\r\u0010!\u001a\u00028\u0000¢\u0006\u0004\b!\u0010\"J\u0084\u0001\u0010/\u001a\u00020\f\"\u0004\b\u0001\u0010#2\u0018\u0010&\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010%0$2\u001a\b\u0002\u0010)\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010%0(0'2\u0016\b\u0002\u0010+\u001a\u0010\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\f\u0018\u00010\t2\u0010\b\u0002\u0010-\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010,2\u0016\b\u0002\u0010.\u001a\u0010\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\f\u0018\u00010\tJu\u00106\u001a\u00020\f\"\u0004\b\u0001\u001002\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010$2\u0014\b\u0002\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010(0'2'\b\u0002\u0010+\u001a!\u0012\u0015\u0012\u0013\u0018\u00010*¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(4\u0012\u0004\u0012\u00020\f\u0018\u00010\t2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\f0\tH\u0004J\f\u00108\u001a\u000207*\u000207H\u0004J=\u0010<\u001a\u000207\"\u0004\b\u0001\u0010#*\b\u0012\u0004\u0012\u00028\u0001092#\u0010;\u001a\u001f\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010%\u0012\u0004\u0012\u00028\u00000:¢\u0006\u0002\b\nH\u0004JW\u0010<\u001a\u000207\"\u0004\b\u0001\u0010#\"\u0004\b\u0002\u0010=*\b\u0012\u0004\u0012\u00028\u0001092\u0012\u0010>\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\t2#\u0010;\u001a\u001f\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020%\u0012\u0004\u0012\u00028\u00000:¢\u0006\u0002\b\nH\u0004J/\u0010<\u001a\u000207*\u00020?2#\u0010;\u001a\u001f\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0%\u0012\u0004\u0012\u00028\u00000:¢\u0006\u0002\b\nJ=\u0010<\u001a\u000207\"\u0004\b\u0001\u0010#*\b\u0012\u0004\u0012\u00028\u00010@2#\u0010;\u001a\u001f\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010%\u0012\u0004\u0012\u00028\u00000:¢\u0006\u0002\b\nH\u0004JW\u0010<\u001a\u000207\"\u0004\b\u0001\u0010#\"\u0004\b\u0002\u0010=*\b\u0012\u0004\u0012\u00028\u00010@2\u0012\u0010>\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\t2#\u0010;\u001a\u001f\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020%\u0012\u0004\u0012\u00028\u00000:¢\u0006\u0002\b\nH\u0004J!\u0010A\u001a\u00020\f2\u0017\u0010\u001d\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\t¢\u0006\u0002\b\nH\u0004J\u001d\u0010B\u001a\u00020\f2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\f0\tH\u0084\bJT\u0010G\u001a\u00020\f2\b\u0010C\u001a\u0004\u0018\u00010\u00152\u0010\u0010E\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010D2\u0006\u0010\u001d\u001a\u00020\u00152(\b\u0002\u0010F\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010D\u0012\u0004\u0012\u00020\f\u0018\u00010:J \u0010I\u001a\u00020\f2\b\u0010C\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u001d\u001a\u00020\u00152\u0006\u0010H\u001a\u00020\u0015J\u001f\u0010L\u001a\u00020\f2\u0017\u0010K\u001a\u0013\u0012\u0004\u0012\u00020J\u0012\u0004\u0012\u00020\f0\t¢\u0006\u0002\b\nJ\u001f\u0010M\u001a\u00020\f2\u0017\u0010K\u001a\u0013\u0012\u0004\u0012\u00020J\u0012\u0004\u0012\u00020\f0\t¢\u0006\u0002\b\nJ\u000f\u0010N\u001a\u00028\u0000H$¢\u0006\u0004\bN\u0010\"R(\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00050O8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\u0018\u0010V\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010Y\u001a\u00020X8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010ZR\u001b\u0010_\u001a\u00020J8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^R\"\u0010`\u001a\u00020X8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b`\u0010Z\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\"\u0010e\u001a\u00020X8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\be\u0010Z\u001a\u0004\bf\u0010b\"\u0004\bg\u0010dR\u001a\u0010h\u001a\u00020X8\u0016X\u0096D¢\u0006\f\n\u0004\bh\u0010Z\u001a\u0004\bh\u0010bR\u001b\u0010l\u001a\u00020J8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bi\u0010j\u001a\u0004\bk\u0010^R\u001b\u0010q\u001a\u00020m8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bn\u0010j\u001a\u0004\bo\u0010pR\u001e\u0010s\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00170r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bs\u0010tR*\u0010u\u001a\u0004\u0018\u00010\u000f8\u0000@\u0000X\u0081\u000e¢\u0006\u0018\n\u0004\bu\u0010v\u0012\u0004\b{\u0010|\u001a\u0004\bw\u0010x\"\u0004\by\u0010zR.\u0010}\u001a\u0004\u0018\u00010\u00128\u0000@\u0000X\u0081\u000e¢\u0006\u001c\n\u0004\b}\u0010~\u0012\u0005\b\u0083\u0001\u0010|\u001a\u0005\b\u007f\u0010\u0080\u0001\"\u0006\b\u0081\u0001\u0010\u0082\u0001R6\u0010\u0084\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000\u00078\u0000@\u0000X\u0081.¢\u0006\u001f\n\u0006\b\u0084\u0001\u0010\u0085\u0001\u0012\u0005\b\u008a\u0001\u0010|\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001\"\u0006\b\u0088\u0001\u0010\u0089\u0001R)\u0010\u008b\u0001\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0004\u0012\u00020\f\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008b\u0001\u0010\u008c\u0001R0\u0010I\u001a\u001b\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0015\u0018\u00010:¢\u0006\u0002\b\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bI\u0010\u008d\u0001R\u001b\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008e\u0001\u0010\u008f\u0001R\u001b\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0090\u0001\u0010\u008f\u0001R\u0013\u0010\u0091\u0001\u001a\u00020X8F¢\u0006\u0007\u001a\u0005\b\u0091\u0001\u0010b¨\u0006\u0093\u0001"}, d2 = {"Lcom/bytedance/assem/arch/viewModel/AssemViewModel;", "Lcom/bytedance/assem/arch/viewModel/h;", "S", "Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/LifecycleOwner;", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "Lcom/bytedance/assem/arch/viewModel/f;", "dispatcher", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "argsAcceptor", "", "initialize", "onPrepared", "Lcom/bytedance/assem/arch/core/b;", "dataStore", "injectHierarchyDataStore", "Lcom/bytedance/assem/arch/core/d;", "serviceStore", "injectHierarchyServiceStore", "", "OPT", "Lqx3/a;", "assemRepository", "putCreatedRepository$assem_release", "(Lqx3/a;)V", "putCreatedRepository", "onCleared", "reducer", "setState", "block", "withState", "getState", "()Lcom/bytedance/assem/arch/viewModel/h;", "T", "Lkotlin/reflect/KProperty1;", "Lcom/bytedance/assem/arch/extensions/c;", "prop", "Lcom/bytedance/assem/arch/viewModel/i;", "Lcom/bytedance/assem/arch/extensions/j;", "config", "", "onError", "Lkotlin/Function0;", "onLoading", "onSuccess", "asyncSubscribe", "A", "prop1", "Lkotlin/ParameterName;", "name", "e", "subscriber", "selectSubscribe", "Lio/reactivex/disposables/Disposable;", "disposeOnClear", "Lio/reactivex/Single;", "Lkotlin/Function2;", "stateReducer", "execute", "V", "mapper", "Lio/reactivex/Completable;", "Lio/reactivex/Observable;", "setStateImmediate", "withStateImmediate", "item", "", "payloads", "callback", "syncItem2State", "onItemChange", "syncState2Item", "Lkotlinx/coroutines/CoroutineScope;", "task", "runOnWorkThread", "runOnUIThread", "defaultState", "Ljava/lang/ref/WeakReference;", "lifecycleRef", "Ljava/lang/ref/WeakReference;", "getLifecycleRef", "()Ljava/lang/ref/WeakReference;", "setLifecycleRef", "(Ljava/lang/ref/WeakReference;)V", "initialState", "Lcom/bytedance/assem/arch/viewModel/h;", "", "_initialized", "Z", "assemVMScope$delegate", "Lcom/bytedance/assem/arch/viewModel/d;", "getAssemVMScope", "()Lkotlinx/coroutines/CoroutineScope;", "assemVMScope", "usedInReusedScene", "getUsedInReusedScene", "()Z", "setUsedInReusedScene", "(Z)V", "useOwnerLifecycle", "getUseOwnerLifecycle", "setUseOwnerLifecycle", "isHolderVM", "mainThreadVMScope$delegate", "Lkotlin/Lazy;", "getMainThreadVMScope", "mainThreadVMScope", "Lio/reactivex/disposables/CompositeDisposable;", "disposables$delegate", "getDisposables", "()Lio/reactivex/disposables/CompositeDisposable;", "disposables", "Landroid/util/SparseArray;", "repos", "Landroid/util/SparseArray;", "hierarchyDataStore", "Lcom/bytedance/assem/arch/core/b;", "getHierarchyDataStore", "()Lcom/bytedance/assem/arch/core/b;", "setHierarchyDataStore", "(Lcom/bytedance/assem/arch/core/b;)V", "hierarchyDataStore$annotations", "()V", "hierarchyServiceStore", "Lcom/bytedance/assem/arch/core/d;", "getHierarchyServiceStore", "()Lcom/bytedance/assem/arch/core/d;", "setHierarchyServiceStore", "(Lcom/bytedance/assem/arch/core/d;)V", "hierarchyServiceStore$annotations", "vmDispatcher", "Lcom/bytedance/assem/arch/viewModel/f;", "getVmDispatcher", "()Lcom/bytedance/assem/arch/viewModel/f;", "setVmDispatcher", "(Lcom/bytedance/assem/arch/viewModel/f;)V", "vmDispatcher$annotations", "itemSync2StateCallback", "Lkotlin/jvm/functions/Function1;", "Lkotlin/jvm/functions/Function2;", "_item", "Ljava/lang/Object;", "onItemChangeCallback", "isInitialized", "<init>", "assem_release"}, k = 1, mv = {1, 4, 0})
public abstract class AssemViewModel<S extends h> extends ViewModel implements LifecycleOwner {
    private volatile boolean _initialized;
    private Object _item;
    private final com.bytedance.assem.arch.viewModel.d assemVMScope$delegate;
    private final Lazy disposables$delegate;
    private com.bytedance.assem.arch.core.b hierarchyDataStore;
    private com.bytedance.assem.arch.core.d hierarchyServiceStore;
    private S initialState;
    private final boolean isHolderVM;
    private Function1<Object, Unit> itemSync2StateCallback;
    public WeakReference<Lifecycle> lifecycleRef;
    private final Lazy mainThreadVMScope$delegate;
    private Object onItemChangeCallback;
    private final SparseArray<qx3.a<?>> repos;
    private Function2<Object, ? super S, ? extends Object> syncState2Item;
    private boolean useOwnerLifecycle;
    private boolean usedInReusedScene;
    public f<S> vmDispatcher;

    public static final class a<V> implements Callable<Unit> {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2() {
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Unit call() {
            call2();
            return Unit.INSTANCE;
        }
    }

    public static final class b<T, R> implements Function<T, R> {
        public final /* synthetic */ Function1 a;

        public b(Function1 r1) {
            this.a = r1;
        }

        public final Object apply(Object r3) {
            return new com.bytedance.assem.arch.extensions.i(this.a.invoke(r3));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V] */
    public static final class c<T, R, V> implements Function<Throwable, com.bytedance.assem.arch.extensions.c<? extends V>> {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final Object apply(Object r2) {
            return new com.bytedance.assem.arch.extensions.e((Throwable) r2);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V] */
    public static final class d<T, V> implements Consumer<com.bytedance.assem.arch.extensions.c<? extends V>> {
        public final /* synthetic */ AssemViewModel a;
        public final /* synthetic */ Thread b;
        public final /* synthetic */ Function2 c;

        public d(AssemViewModel r1, Thread r2, Function2 r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r3) {
            final com.bytedance.assem.arch.extensions.c r4 = (com.bytedance.assem.arch.extensions.c) r3;
            if (this.b == ThreadMethodProxy.currentThread()) goto L7;
            this.a.setState(new AssemViewModel$execute$7$1(this, r4));
            return;
        L7:
            throw new IllegalStateException("you need schedule upstream to another thread, you can call subscribeOn(IO)".toString());
        }
    }

    /* JADX INFO: renamed from: com.bytedance.assem.arch.viewModel.AssemViewModel$onCleared$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, TextExtraStruct.TYPE_GROUP_CHAT})
    final /* synthetic */ class C02231 extends MutablePropertyReference0 {
        public C02231(AssemViewModel r1) {
            super(r1);
        }

        public String getName() {
            return "vmDispatcher";
        }

        public KDeclarationContainer getOwner() {
            return Reflection.getOrCreateKotlinClass(AssemViewModel.class);
        }

        public String getSignature() {
            return "getVmDispatcher()Lcom/bytedance/assem/arch/viewModel/IVMDispatcher;";
        }

        public Object get() {
            return ((AssemViewModel) ((CallableReference) this).receiver).getVmDispatcher();
        }

        public void set(Object r2) {
            ((AssemViewModel) ((CallableReference) this).receiver).setVmDispatcher((f) r2);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.assem.arch.viewModel.AssemViewModel$runOnUIThread$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/bytedance/assem/arch/viewModel/h;", "S", "Lkotlinx/coroutines/CoroutineScope;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    @DebugMetadata(c = "com.bytedance.assem.arch.viewModel.AssemViewModel$runOnUIThread$1", f = "AssemViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02241 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1 $task;
        int label;
        private CoroutineScope p$;

        public C02241(Function1 r1, Continuation r2) {
            this.$task = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            C02241 r0 = new C02241(this.$task, r4);
            r0.p$ = (CoroutineScope) r3;
            return r0;
        }

        public final Object invoke(Object r1, Object r2) {
            return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            CoroutineScope r3 = this.p$;
            this.$task.invoke(r3);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.bytedance.assem.arch.viewModel.AssemViewModel$runOnWorkThread$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/bytedance/assem/arch/viewModel/h;", "S", "Lkotlinx/coroutines/CoroutineScope;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    @DebugMetadata(c = "com.bytedance.assem.arch.viewModel.AssemViewModel$runOnWorkThread$1", f = "AssemViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02251 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1 $task;
        int label;
        private CoroutineScope p$;

        public C02251(Function1 r1, Continuation r2) {
            this.$task = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            C02251 r0 = new C02251(this.$task, r4);
            r0.p$ = (CoroutineScope) r3;
            return r0;
        }

        public final Object invoke(Object r1, Object r2) {
            return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            CoroutineScope r3 = this.p$;
            this.$task.invoke(r3);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private final CompositeDisposable getDisposables() {
        return (CompositeDisposable) this.disposables$delegate.getValue();
    }

    private final CoroutineScope getMainThreadVMScope() {
        return (CoroutineScope) this.mainThreadVMScope$delegate.getValue();
    }

    public static /* synthetic */ void hierarchyDataStore$annotations() {
    }

    public static /* synthetic */ void hierarchyServiceStore$annotations() {
    }

    public static /* synthetic */ void vmDispatcher$annotations() {
    }

    public abstract S defaultState();

    public final CoroutineScope getAssemVMScope() {
        return (CoroutineScope) this.assemVMScope$delegate.getValue();
    }

    public void onPrepared() {
    }

    public Lifecycle getLifecycle() {
        WeakReference<Lifecycle> r0 = this.lifecycleRef;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("lifecycleRef");
    L5:
        Lifecycle r1 = r0.get();
        if (r1 == null) goto L10;
        return r1;
    L10:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final WeakReference<Lifecycle> getLifecycleRef() {
        WeakReference<Lifecycle> r0 = this.lifecycleRef;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("lifecycleRef");
    L5:
        return r0;
    }

    public final S getState() {
        f<S> r0 = this.vmDispatcher;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("vmDispatcher");
    L6:
        return (S) r0.getState();
    }

    public final f<S> getVmDispatcher() {
        f<S> r0 = this.vmDispatcher;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("vmDispatcher");
    L5:
        return r0;
    }

    public void onCleared() {
        com.bytedance.assem.arch.core.b r0 = this.hierarchyDataStore;
        if (r0 == null) goto L5;
        ((LinkedHashMap) r0.a).clear();
    L5:
        com.bytedance.assem.arch.core.d r1 = this.hierarchyServiceStore;
        if (r1 == null) goto L8;
        ((LinkedHashMap) r1.a).clear();
        ((LinkedHashMap) r1.b).clear();
    L8:
        int r2 = this.repos.size();
        int r3 = 0;
    L9:
        if (r3 >= r2) goto L14;
        qx3.a<?> r4 = this.repos.get(r3);
        if (r4 == null) goto L13;
        r4.release();
    L13:
        r3 = r3 + 1;
        goto L9
    L14:
        CoroutineScope r5 = getAssemVMScope();
        CoroutineContext r6 = r5.getCoroutineContext();
        Job.Key r7 = Job.Key;
        Job r8 = r6.get(r7);
        if (r8 == null) goto L29;
        r8.cancel();
        CoroutineScope r9 = getMainThreadVMScope();
        Job r10 = r9.getCoroutineContext().get(r7);
        if (r10 == null) goto L27;
        r10.cancel();
        getDisposables().clear();
        f<S> r11 = this.vmDispatcher;
        if (r11 == null) goto L21;
        r11.onClear();
    L21:
        super.onCleared();
        WeakReference<Lifecycle> r12 = this.lifecycleRef;
        if (r12 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("lifecycleRef");
    L24:
        r12.clear();
        return;
    L27:
        throw new IllegalStateException(("Scope cannot be cancelled because it does not have a job: " + r9).toString());
    L29:
        throw new IllegalStateException(("Scope cannot be cancelled because it does not have a job: " + r5).toString());
    }

    public AssemViewModel() {
        this.assemVMScope$delegate = new com.bytedance.assem.arch.viewModel.d(isHolderVM());
        this.mainThreadVMScope$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, AssemViewModel$mainThreadVMScope$2.INSTANCE);
        this.disposables$delegate = LazyKt.lazy(AssemViewModel$disposables$2.INSTANCE);
        this.repos = new SparseArray();
    }

    public final com.bytedance.assem.arch.core.b getHierarchyDataStore() {
        return this.hierarchyDataStore;
    }

    public final com.bytedance.assem.arch.core.d getHierarchyServiceStore() {
        return this.hierarchyServiceStore;
    }

    public final boolean getUseOwnerLifecycle() {
        return this.useOwnerLifecycle;
    }

    public final boolean getUsedInReusedScene() {
        return this.usedInReusedScene;
    }

    public boolean isHolderVM() {
        return this.isHolderVM;
    }

    public final boolean isInitialized() {
        return this._initialized;
    }

    public static final /* synthetic */ Object access$getOnItemChangeCallback$p(AssemViewModel r0) {
        return r0.onItemChangeCallback;
    }

    public static final /* synthetic */ Function2 access$getSyncState2Item$p(AssemViewModel r0) {
        return r0.syncState2Item;
    }

    public static final /* synthetic */ Object access$get_item$p(AssemViewModel r0) {
        return r0._item;
    }

    public final Disposable disposeOnClear(Disposable r2) {
        getDisposables().add(r2);
        return r2;
    }

    public final void injectHierarchyDataStore(com.bytedance.assem.arch.core.b r1) {
        this.hierarchyDataStore = r1;
    }

    public final void injectHierarchyServiceStore(com.bytedance.assem.arch.core.d r1) {
        this.hierarchyServiceStore = r1;
    }

    public final <OPT> void putCreatedRepository$assem_release(qx3.a<OPT> r3) {
        SparseArray<qx3.a<?>> r0 = this.repos;
        r0.put(r0.size(), r3);
    }

    public final void runOnUIThread(Function1<? super CoroutineScope, Unit> r7) {
        BuildersKt.launch$default(getMainThreadVMScope(), null, null, new C02241(r7, null), 3, null);
    }

    public final void runOnWorkThread(Function1<? super CoroutineScope, Unit> r7) {
        BuildersKt.launch$default(getAssemVMScope(), null, null, new C02251(r7, null), 3, null);
    }

    public final void setHierarchyDataStore(com.bytedance.assem.arch.core.b r1) {
        this.hierarchyDataStore = r1;
    }

    public final void setHierarchyServiceStore(com.bytedance.assem.arch.core.d r1) {
        this.hierarchyServiceStore = r1;
    }

    public final void setLifecycleRef(WeakReference<Lifecycle> r1) {
        this.lifecycleRef = r1;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void setState(final Function1<? super S, ? extends S> r3) {
        f<S> r0 = this.vmDispatcher;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("vmDispatcher");
    L5:
        r0.a(new C02271(this, r3));
    }

    public final void setStateImmediate(Function1<? super S, ? extends S> r3) {
        f<S> r0 = this.vmDispatcher;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("vmDispatcher");
    L5:
        r0.h(r3);
    }

    public final void setUseOwnerLifecycle(boolean r1) {
        this.useOwnerLifecycle = r1;
    }

    public final void setUsedInReusedScene(boolean r1) {
        this.usedInReusedScene = r1;
    }

    public final void setVmDispatcher(f<S> r1) {
        this.vmDispatcher = r1;
    }

    public final void withState(Function1<? super S, Unit> r3) {
        f<S> r0 = this.vmDispatcher;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("vmDispatcher");
    L5:
        r0.c(r3);
    }

    public final void withStateImmediate(Function1<? super S, Unit> r2) {
        r2.invoke(getVmDispatcher().getState());
    }

    public static final /* synthetic */ void access$setOnItemChangeCallback$p(AssemViewModel r0, Object r1) {
        r0.onItemChangeCallback = r1;
    }

    public static final /* synthetic */ void access$setSyncState2Item$p(AssemViewModel r0, Function2 r1) {
        r0.syncState2Item = r1;
    }

    public static final /* synthetic */ void access$set_item$p(AssemViewModel r0, Object r1) {
        r0._item = r1;
    }

    public final Disposable execute(Completable r2, Function2<? super S, ? super com.bytedance.assem.arch.extensions.c<Unit>, ? extends S> r3) {
        return execute(r2.toSingle(a.a), r3);
    }

    public final void initialize(f<S> r2, Function1<? super S, ? extends S> r3) {
        if (this.initialState != null) goto L9;
        this.initialState = (S) r3.invoke(defaultState());
        r2.e(getAssemVMScope());
        S r4 = this.initialState;
        if (r4 == null) goto L8;
        r2.f(r4);
        this.vmDispatcher = r2;
        onPrepared();
        this._initialized = true;
        return;
    L8:
        throw new TypeCastException("null cannot be cast to non-null type S");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> Disposable execute(Single<T> r2, Function2<? super S, ? super com.bytedance.assem.arch.extensions.c<? extends T>, ? extends S> r3) {
        return execute(r2.toObservable(), C02221.INSTANCE, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> Disposable execute(Observable<T> r2, Function2<? super S, ? super com.bytedance.assem.arch.extensions.c<? extends T>, ? extends S> r3) {
        return execute(r2, AnonymousClass3.INSTANCE, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T, V> Disposable execute(Observable<T> r3, Function1<? super T, ? extends V> r4, final Function2<? super S, ? super com.bytedance.assem.arch.extensions.c<? extends V>, ? extends S> r5) {
        Lazy r0 = HostInjector.a;
        Thread r1 = ThreadMethodProxy.currentThread();
        setState(new AnonymousClass4(r5));
        return disposeOnClear(r3.map(new b(r4)).onErrorReturn(c.a).subscribe(new d(this, r1, r5)));
    }

    public final void syncState2Item(Object r2, Object r3, Object r4) {
        this.syncState2Item = (Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r3, 2);
        this._item = r2;
        this.onItemChangeCallback = r4;
    }

    public final <T, V> Disposable execute(Single<T> r1, Function1<? super T, ? extends V> r2, Function2<? super S, ? super com.bytedance.assem.arch.extensions.c<? extends V>, ? extends S> r3) {
        return execute(r1.toObservable(), r2, r3);
    }

    public final <A> void selectSubscribe(KProperty1<S, ? extends A> r2, i<j<A>> r3, Function1<? super Throwable, Unit> r4, Function1<? super A, Unit> r5) {
        f<S> r6 = this.vmDispatcher;
        if (r6 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("vmDispatcher");
    L5:
        r6.g(r2, r3, C02261.INSTANCE, r5);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void syncItem2State(final Object r3, final List<? extends Object> r4, final Object r5, final Function2<Object, ? super List<? extends Object>, Unit> r6) {
        f<S> r0 = this.vmDispatcher;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("vmDispatcher");
    L5:
        r0.a(new C02281(r5, r3, r6, r4));
    }

    public final <T> void asyncSubscribe(KProperty1<S, ? extends com.bytedance.assem.arch.extensions.c<? extends T>> r8, i<j<com.bytedance.assem.arch.extensions.c<T>>> r9, Function1<? super Throwable, Unit> r10, Function0<Unit> r11, Function1<? super T, Unit> r12) {
        f<S> r0 = this.vmDispatcher;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("vmDispatcher");
    L5:
        r0.b(r8, r9, AnonymousClass1.INSTANCE, r10, r11, r12);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void selectSubscribe$default(AssemViewModel r0, KProperty1 r1, i r2, Function1 r3, Function1 r4, int r5, Object r6) {
        if (r6 != null) goto L12;
        if ((r5 & 2) == 0) goto L7;
        r2 = new i();
        r2.a = true;
        r2.b = true;
    L7:
        if ((r5 & 4) == 0) goto L9;
        r3 = null;
    L9:
        r0.selectSubscribe(r1, r2, r3, r4);
        return;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectSubscribe");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void syncItem2State$default(AssemViewModel r0, Object r1, List r2, Object r3, Function2 r4, int r5, Object r6) {
        if (r6 != null) goto L9;
        if ((r5 & 8) == 0) goto L6;
        r4 = null;
    L6:
        r0.syncItem2State(r1, r2, r3, r4);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: syncItem2State");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void asyncSubscribe$default(AssemViewModel r6, KProperty1 r7, i r8, Function1 r9, Function0 r10, Function1 r11, int r12, Object r13) {
        if (r13 != null) goto L21;
        if ((r12 & 2) == 0) goto L6;
        r8 = new i();
        r8.a = true;
        r8.b = true;
    L6:
        i r2 = r8;
        if ((r12 & 4) == 0) goto L9;
        Function1 r3 = null;
    L11:
        if ((r12 & 8) == 0) goto L13;
        Function0 r4 = null;
    L15:
        if ((r12 & 16) == 0) goto L17;
        Function1 r5 = null;
    L18:
        r6.asyncSubscribe(r7, r2, r3, r4, r5);
        return;
    L17:
        r5 = r11;
        goto L18
    L13:
        r4 = r10;
        goto L15
    L9:
        r3 = r9;
        goto L11
    L21:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: asyncSubscribe");
    }
}
