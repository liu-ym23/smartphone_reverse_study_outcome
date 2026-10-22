package com.bytedance.assem.arch.viewModel;

import android.util.SparseArray;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.assem.arch.extensions.HostInjector;
import com.bytedance.assem.arch.extensions.j;
import com.bytedance.assem.arch.viewModel.h;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KProperty1;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b!\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u00032\u00020\u0004B\b¢\u0006\u0005\b\u0092\u0001\u0010|J\b\u0010\u0006\u001a\u00020\u0005H\u0016J-\u0010\r\u001a\u00020\f2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\t¢\u0006\u0002\b\nJ\b\u0010\u000e\u001a\u00020\fH\u0014J\u0010\u0010\u0011\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010\u0014\u001a\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J'\u0010\u001b\u001a\u00020\f\"\b\b\u0001\u0010\u0016*\u00020\u00152\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00010\u0017H\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u001c\u001a\u00020\fH\u0015J!\u0010\u001e\u001a\u00020\f2\u0017\u0010\u001d\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\t¢\u0006\u0002\b\nH\u0004J\u001c\u0010 \u001a\u00020\f2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\f0\tH\u0004J\r\u0010!\u001a\u00028\u0000¢\u0006\u0004\b!\u0010\"J\u0084\u0001\u0010/\u001a\u00020\f\"\u0004\b\u0001\u0010#2\u0018\u0010&\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010%0$2\u001a\b\u0002\u0010)\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010%0(0'2\u0016\b\u0002\u0010+\u001a\u0010\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\f\u0018\u00010\t2\u0010\b\u0002\u0010-\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010,2\u0016\b\u0002\u0010.\u001a\u0010\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\f\u0018\u00010\tJu\u00106\u001a\u00020\f\"\u0004\b\u0001\u001002\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010$2\u0014\b\u0002\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010(0'2'\b\u0002\u0010+\u001a!\u0012\u0015\u0012\u0013\u0018\u00010*¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(4\u0012\u0004\u0012\u00020\f\u0018\u00010\t2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\f0\tH\u0004J\f\u00108\u001a\u000207*\u000207H\u0004J=\u0010<\u001a\u000207\"\u0004\b\u0001\u0010#*\b\u0012\u0004\u0012\u00028\u0001092#\u0010;\u001a\u001f\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010%\u0012\u0004\u0012\u00028\u00000:¢\u0006\u0002\b\nH\u0004JW\u0010<\u001a\u000207\"\u0004\b\u0001\u0010#\"\u0004\b\u0002\u0010=*\b\u0012\u0004\u0012\u00028\u0001092\u0012\u0010>\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\t2#\u0010;\u001a\u001f\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020%\u0012\u0004\u0012\u00028\u00000:¢\u0006\u0002\b\nH\u0004J/\u0010<\u001a\u000207*\u00020?2#\u0010;\u001a\u001f\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0%\u0012\u0004\u0012\u00028\u00000:¢\u0006\u0002\b\nJ=\u0010<\u001a\u000207\"\u0004\b\u0001\u0010#*\b\u0012\u0004\u0012\u00028\u00010@2#\u0010;\u001a\u001f\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010%\u0012\u0004\u0012\u00028\u00000:¢\u0006\u0002\b\nH\u0004JW\u0010<\u001a\u000207\"\u0004\b\u0001\u0010#\"\u0004\b\u0002\u0010=*\b\u0012\u0004\u0012\u00028\u00010@2\u0012\u0010>\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\t2#\u0010;\u001a\u001f\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020%\u0012\u0004\u0012\u00028\u00000:¢\u0006\u0002\b\nH\u0004J!\u0010A\u001a\u00020\f2\u0017\u0010\u001d\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\t¢\u0006\u0002\b\nH\u0004J\u001d\u0010B\u001a\u00020\f2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\f0\tH\u0084\bJT\u0010G\u001a\u00020\f2\b\u0010C\u001a\u0004\u0018\u00010\u00152\u0010\u0010E\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010D2\u0006\u0010\u001d\u001a\u00020\u00152(\b\u0002\u0010F\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010D\u0012\u0004\u0012\u00020\f\u0018\u00010:J \u0010I\u001a\u00020\f2\b\u0010C\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u001d\u001a\u00020\u00152\u0006\u0010H\u001a\u00020\u0015J\u001f\u0010L\u001a\u00020\f2\u0017\u0010K\u001a\u0013\u0012\u0004\u0012\u00020J\u0012\u0004\u0012\u00020\f0\t¢\u0006\u0002\b\nJ\u001f\u0010M\u001a\u00020\f2\u0017\u0010K\u001a\u0013\u0012\u0004\u0012\u00020J\u0012\u0004\u0012\u00020\f0\t¢\u0006\u0002\b\nJ\u000f\u0010N\u001a\u00028\u0000H$¢\u0006\u0004\bN\u0010\"R(\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00050O8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\u0018\u0010V\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010Y\u001a\u00020X8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010ZR\u001b\u0010_\u001a\u00020J8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^R\"\u0010`\u001a\u00020X8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b`\u0010Z\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\"\u0010e\u001a\u00020X8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\be\u0010Z\u001a\u0004\bf\u0010b\"\u0004\bg\u0010dR\u001a\u0010h\u001a\u00020X8\u0016X\u0096D¢\u0006\f\n\u0004\bh\u0010Z\u001a\u0004\bh\u0010bR\u001b\u0010l\u001a\u00020J8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bi\u0010j\u001a\u0004\bk\u0010^R\u001b\u0010q\u001a\u00020m8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bn\u0010j\u001a\u0004\bo\u0010pR\u001e\u0010s\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00170r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bs\u0010tR*\u0010u\u001a\u0004\u0018\u00010\u000f8\u0000@\u0000X\u0081\u000e¢\u0006\u0018\n\u0004\bu\u0010v\u0012\u0004\b{\u0010|\u001a\u0004\bw\u0010x\"\u0004\by\u0010zR.\u0010}\u001a\u0004\u0018\u00010\u00128\u0000@\u0000X\u0081\u000e¢\u0006\u001c\n\u0004\b}\u0010~\u0012\u0005\b\u0083\u0001\u0010|\u001a\u0005\b\u007f\u0010\u0080\u0001\"\u0006\b\u0081\u0001\u0010\u0082\u0001R6\u0010\u0084\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000\u00078\u0000@\u0000X\u0081.¢\u0006\u001f\n\u0006\b\u0084\u0001\u0010\u0085\u0001\u0012\u0005\b\u008a\u0001\u0010|\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001\"\u0006\b\u0088\u0001\u0010\u0089\u0001R)\u0010\u008b\u0001\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0004\u0012\u00020\f\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008b\u0001\u0010\u008c\u0001R0\u0010I\u001a\u001b\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0015\u0018\u00010:¢\u0006\u0002\b\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bI\u0010\u008d\u0001R\u001b\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008e\u0001\u0010\u008f\u0001R\u001b\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0090\u0001\u0010\u008f\u0001R\u0013\u0010\u0091\u0001\u001a\u00020X8F¢\u0006\u0007\u001a\u0005\b\u0091\u0001\u0010b¨\u0006\u0093\u0001"}, d2 = {"Lcom/bytedance/assem/arch/viewModel/AssemViewModel;", "Lcom/bytedance/assem/arch/viewModel/h;", ExifInterface.LATITUDE_SOUTH, "Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/LifecycleOwner;", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "Lcom/bytedance/assem/arch/viewModel/f;", "dispatcher", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "argsAcceptor", "", "initialize", "onPrepared", "Lcom/bytedance/assem/arch/core/b;", "dataStore", "injectHierarchyDataStore", "Lcom/bytedance/assem/arch/core/d;", "serviceStore", "injectHierarchyServiceStore", "", "OPT", "Lqx3/a;", "assemRepository", "putCreatedRepository$assem_release", "(Lqx3/a;)V", "putCreatedRepository", "onCleared", "reducer", "setState", "block", "withState", "getState", "()Lcom/bytedance/assem/arch/viewModel/h;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/reflect/KProperty1;", "Lcom/bytedance/assem/arch/extensions/c;", "prop", "Lcom/bytedance/assem/arch/viewModel/i;", "Lcom/bytedance/assem/arch/extensions/j;", "config", "", LynxVideoManagerLite.EVENT_ON_ERROR, "Lkotlin/Function0;", "onLoading", "onSuccess", "asyncSubscribe", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "prop1", "Lkotlin/ParameterName;", "name", "e", "subscriber", "selectSubscribe", "Lio/reactivex/disposables/Disposable;", "disposeOnClear", "Lio/reactivex/Single;", "Lkotlin/Function2;", "stateReducer", "execute", "V", "mapper", "Lio/reactivex/Completable;", "Lio/reactivex/Observable;", "setStateImmediate", "withStateImmediate", MapController.ITEM_LAYER_TAG, "", "payloads", "callback", "syncItem2State", "onItemChange", "syncState2Item", "Lkotlinx/coroutines/CoroutineScope;", "task", "runOnWorkThread", "runOnUIThread", "defaultState", "Ljava/lang/ref/WeakReference;", "lifecycleRef", "Ljava/lang/ref/WeakReference;", "getLifecycleRef", "()Ljava/lang/ref/WeakReference;", "setLifecycleRef", "(Ljava/lang/ref/WeakReference;)V", "initialState", "Lcom/bytedance/assem/arch/viewModel/h;", "", "_initialized", "Z", "assemVMScope$delegate", "Lcom/bytedance/assem/arch/viewModel/d;", "getAssemVMScope", "()Lkotlinx/coroutines/CoroutineScope;", "assemVMScope", "usedInReusedScene", "getUsedInReusedScene", "()Z", "setUsedInReusedScene", "(Z)V", "useOwnerLifecycle", "getUseOwnerLifecycle", "setUseOwnerLifecycle", "isHolderVM", "mainThreadVMScope$delegate", "Lkotlin/Lazy;", "getMainThreadVMScope", "mainThreadVMScope", "Lio/reactivex/disposables/CompositeDisposable;", "disposables$delegate", "getDisposables", "()Lio/reactivex/disposables/CompositeDisposable;", "disposables", "Landroid/util/SparseArray;", "repos", "Landroid/util/SparseArray;", "hierarchyDataStore", "Lcom/bytedance/assem/arch/core/b;", "getHierarchyDataStore", "()Lcom/bytedance/assem/arch/core/b;", "setHierarchyDataStore", "(Lcom/bytedance/assem/arch/core/b;)V", "hierarchyDataStore$annotations", "()V", "hierarchyServiceStore", "Lcom/bytedance/assem/arch/core/d;", "getHierarchyServiceStore", "()Lcom/bytedance/assem/arch/core/d;", "setHierarchyServiceStore", "(Lcom/bytedance/assem/arch/core/d;)V", "hierarchyServiceStore$annotations", "vmDispatcher", "Lcom/bytedance/assem/arch/viewModel/f;", "getVmDispatcher", "()Lcom/bytedance/assem/arch/viewModel/f;", "setVmDispatcher", "(Lcom/bytedance/assem/arch/viewModel/f;)V", "vmDispatcher$annotations", "itemSync2StateCallback", "Lkotlin/jvm/functions/Function1;", "Lkotlin/jvm/functions/Function2;", "_item", "Ljava/lang/Object;", "onItemChangeCallback", "isInitialized", "<init>", "assem_release"}, k = 1, mv = {1, 4, 0})
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

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f193066a = null;

        static {
            f193066a = new a();
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

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f193067a;

        public b(Function1 r100) {
            this.f193067a = r100;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            return new com.bytedance.assem.arch.extensions.i(this.f193067a.invoke(r100));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V] */
    public static final class c<T, R, V> implements Function<Throwable, com.bytedance.assem.arch.extensions.c<? extends V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f193068a = null;

        static {
            f193068a = new c();
        }

        public c() {
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Throwable r100) {
            return new com.bytedance.assem.arch.extensions.e(r100);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V] */
    public static final class d<T, V> implements Consumer<com.bytedance.assem.arch.extensions.c<? extends V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AssemViewModel f193069a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Thread f193070b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function2 f193071c;

        public d(AssemViewModel r100, Thread r101, Function2 r102) {
            this.f193069a = r100;
            this.f193070b = r101;
            this.f193071c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            final com.bytedance.assem.arch.extensions.c r101 = (com.bytedance.assem.arch.extensions.c) r100;
            if (this.f193070b == ThreadMethodProxy.currentThread()) goto L7;
            this.f193069a.setState(new AssemViewModel$execute$7$1(this, r101));
            return;
        L7:
            throw new IllegalStateException("you need schedule upstream to another thread, you can call subscribeOn(IO)".toString());
        }
    }

    /* JADX INFO: renamed from: com.bytedance.assem.arch.viewModel.AssemViewModel$onCleared$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    final /* synthetic */ class C104301 extends MutablePropertyReference0 {
        public C104301(AssemViewModel r100) {
            super(r100);
        }

        @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
        public String getName() {
            return "vmDispatcher";
        }

        @Override // kotlin.jvm.internal.CallableReference
        public KDeclarationContainer getOwner() {
            return Reflection.getOrCreateKotlinClass(AssemViewModel.class);
        }

        @Override // kotlin.jvm.internal.CallableReference
        public String getSignature() {
            return "getVmDispatcher()Lcom/bytedance/assem/arch/viewModel/IVMDispatcher;";
        }

        @Override // kotlin.reflect.KProperty0
        public Object get() {
            return ((AssemViewModel) this.receiver).getVmDispatcher();
        }

        @Override // kotlin.reflect.KMutableProperty0
        public void set(Object r100) {
            ((AssemViewModel) this.receiver).setVmDispatcher((f) r100);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.assem.arch.viewModel.AssemViewModel$runOnUIThread$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/bytedance/assem/arch/viewModel/h;", ExifInterface.LATITUDE_SOUTH, "Lkotlinx/coroutines/CoroutineScope;", "", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    @DebugMetadata(c = "com.bytedance.assem.arch.viewModel.AssemViewModel$runOnUIThread$1", f = "AssemViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C104311 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1 $task;
        int label;
        private CoroutineScope p$;

        public C104311(Function1 r100, Continuation r101) {
            this.$task = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            C104311 r102 = new C104311(this.$task, r101);
            r102.p$ = (CoroutineScope) r100;
            return r102;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C104311) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r100);
            CoroutineScope r101 = this.p$;
            this.$task.invoke(r101);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.bytedance.assem.arch.viewModel.AssemViewModel$runOnWorkThread$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/bytedance/assem/arch/viewModel/h;", ExifInterface.LATITUDE_SOUTH, "Lkotlinx/coroutines/CoroutineScope;", "", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    @DebugMetadata(c = "com.bytedance.assem.arch.viewModel.AssemViewModel$runOnWorkThread$1", f = "AssemViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C104321 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1 $task;
        int label;
        private CoroutineScope p$;

        public C104321(Function1 r100, Continuation r101) {
            this.$task = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            C104321 r102 = new C104321(this.$task, r101);
            r102.p$ = (CoroutineScope) r100;
            return r102;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C104321) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r100);
            CoroutineScope r101 = this.p$;
            this.$task.invoke(r101);
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
        return this.assemVMScope$delegate.getValue();
    }

    public void onPrepared() {
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        WeakReference<Lifecycle> r100 = this.lifecycleRef;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("lifecycleRef");
    L5:
        Lifecycle r101 = r100.get();
        if (r101 == null) goto L10;
        return r101;
    L10:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final WeakReference<Lifecycle> getLifecycleRef() {
        WeakReference<Lifecycle> r100 = this.lifecycleRef;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("lifecycleRef");
    L5:
        return r100;
    }

    public final S getState() {
        f<S> r100 = this.vmDispatcher;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("vmDispatcher");
    L6:
        return (S) r100.getState();
    }

    public final f<S> getVmDispatcher() {
        f<S> r100 = this.vmDispatcher;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("vmDispatcher");
    L5:
        return r100;
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        com.bytedance.assem.arch.core.b r100 = this.hierarchyDataStore;
        if (r100 == null) goto L5;
        ((LinkedHashMap) r100.f192886a).clear();
    L5:
        com.bytedance.assem.arch.core.d r101 = this.hierarchyServiceStore;
        if (r101 == null) goto L8;
        ((LinkedHashMap) r101.f192888a).clear();
        ((LinkedHashMap) r101.f192889b).clear();
    L8:
        int r102 = this.repos.size();
        int r103 = 0;
    L9:
        if (r103 >= r102) goto L14;
        qx3.a<?> r104 = this.repos.get(r103);
        if (r104 == null) goto L13;
        r104.release();
    L13:
        r103 = r103 + 1;
        goto L9
    L14:
        CoroutineScope r105 = getAssemVMScope();
        CoroutineContext r106 = r105.getCoroutineContext();
        Job.Key r107 = Job.Key;
        Job r108 = (Job) r106.get(r107);
        if (r108 == null) goto L29;
        r108.cancel();
        CoroutineScope r109 = getMainThreadVMScope();
        Job r110 = (Job) r109.getCoroutineContext().get(r107);
        if (r110 == null) goto L27;
        r110.cancel();
        getDisposables().clear();
        f<S> r111 = this.vmDispatcher;
        if (r111 == null) goto L21;
        r111.onClear();
    L21:
        super.onCleared();
        WeakReference<Lifecycle> r112 = this.lifecycleRef;
        if (r112 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("lifecycleRef");
    L24:
        r112.clear();
        return;
    L27:
        throw new IllegalStateException(("Scope cannot be cancelled because it does not have a job: " + r109).toString());
    L29:
        throw new IllegalStateException(("Scope cannot be cancelled because it does not have a job: " + r105).toString());
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

    public static final /* synthetic */ Object access$getOnItemChangeCallback$p(AssemViewModel r100) {
        return r100.onItemChangeCallback;
    }

    public static final /* synthetic */ Function2 access$getSyncState2Item$p(AssemViewModel r100) {
        return r100.syncState2Item;
    }

    public static final /* synthetic */ Object access$get_item$p(AssemViewModel r100) {
        return r100._item;
    }

    public final Disposable disposeOnClear(Disposable r100) {
        getDisposables().add(r100);
        return r100;
    }

    public final void injectHierarchyDataStore(com.bytedance.assem.arch.core.b r100) {
        this.hierarchyDataStore = r100;
    }

    public final void injectHierarchyServiceStore(com.bytedance.assem.arch.core.d r100) {
        this.hierarchyServiceStore = r100;
    }

    public final <OPT> void putCreatedRepository$assem_release(qx3.a<OPT> r100) {
        SparseArray<qx3.a<?>> r101 = this.repos;
        r101.put(r101.size(), r100);
    }

    public final void runOnUIThread(Function1<? super CoroutineScope, Unit> r100) {
        BuildersKt.launch$default(getMainThreadVMScope(), null, null, new C104311(r100, null), 3, null);
    }

    public final void runOnWorkThread(Function1<? super CoroutineScope, Unit> r100) {
        BuildersKt.launch$default(getAssemVMScope(), null, null, new C104321(r100, null), 3, null);
    }

    public final void setHierarchyDataStore(com.bytedance.assem.arch.core.b r100) {
        this.hierarchyDataStore = r100;
    }

    public final void setHierarchyServiceStore(com.bytedance.assem.arch.core.d r100) {
        this.hierarchyServiceStore = r100;
    }

    public final void setLifecycleRef(WeakReference<Lifecycle> r100) {
        this.lifecycleRef = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
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
    public final void setState(final Function1<? super S, ? extends S> r100) {
        f<S> r101 = this.vmDispatcher;
        if (r101 != 0) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("vmDispatcher");
    L5:
        r101.a(new C104341(this, r100));
    }

    public final void setStateImmediate(Function1<? super S, ? extends S> r100) {
        f<S> r101 = this.vmDispatcher;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("vmDispatcher");
    L5:
        r101.h(r100);
    }

    public final void setUseOwnerLifecycle(boolean r100) {
        this.useOwnerLifecycle = r100;
    }

    public final void setUsedInReusedScene(boolean r100) {
        this.usedInReusedScene = r100;
    }

    public final void setVmDispatcher(f<S> r100) {
        this.vmDispatcher = r100;
    }

    public final void withState(Function1<? super S, Unit> r100) {
        f<S> r101 = this.vmDispatcher;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("vmDispatcher");
    L5:
        r101.c(r100);
    }

    public final void withStateImmediate(Function1<? super S, Unit> r100) {
        r100.invoke(getVmDispatcher().getState());
    }

    public static final /* synthetic */ void access$setOnItemChangeCallback$p(AssemViewModel r100, Object r101) {
        r100.onItemChangeCallback = r101;
    }

    public static final /* synthetic */ void access$setSyncState2Item$p(AssemViewModel r100, Function2 r101) {
        r100.syncState2Item = r101;
    }

    public static final /* synthetic */ void access$set_item$p(AssemViewModel r100, Object r101) {
        r100._item = r101;
    }

    public final Disposable execute(Completable r100, Function2<? super S, ? super com.bytedance.assem.arch.extensions.c<Unit>, ? extends S> r101) {
        return execute(r100.toSingle(a.f193066a), r101);
    }

    public final void initialize(f<S> r100, Function1<? super S, ? extends S> r101) {
        if (this.initialState != null) goto L9;
        this.initialState = r101.invoke(defaultState());
        r100.e(getAssemVMScope());
        S r102 = this.initialState;
        if (r102 == null) goto L8;
        r100.f(r102);
        this.vmDispatcher = r100;
        onPrepared();
        this._initialized = true;
        return;
    L8:
        throw new TypeCastException("null cannot be cast to non-null type S");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> Disposable execute(Single<T> r100, Function2<? super S, ? super com.bytedance.assem.arch.extensions.c<? extends T>, ? extends S> r101) {
        return execute(r100.toObservable(), C104291.INSTANCE, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> Disposable execute(Observable<T> r100, Function2<? super S, ? super com.bytedance.assem.arch.extensions.c<? extends T>, ? extends S> r101) {
        return execute(r100, AnonymousClass3.INSTANCE, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T, V> Disposable execute(Observable<T> r100, Function1<? super T, ? extends V> r101, final Function2<? super S, ? super com.bytedance.assem.arch.extensions.c<? extends V>, ? extends S> r102) {
        Lazy r103 = HostInjector.f192919a;
        Thread r104 = ThreadMethodProxy.currentThread();
        setState(new AnonymousClass4(r102));
        return disposeOnClear(r100.map(new b(r101)).onErrorReturn(c.f193068a).subscribe(new d(this, r104, r102)));
    }

    public final void syncState2Item(Object r100, Object r101, Object r102) {
        this.syncState2Item = (Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r101, 2);
        this._item = r100;
        this.onItemChangeCallback = r102;
    }

    public final <T, V> Disposable execute(Single<T> r100, Function1<? super T, ? extends V> r101, Function2<? super S, ? super com.bytedance.assem.arch.extensions.c<? extends V>, ? extends S> r102) {
        return execute(r100.toObservable(), r101, r102);
    }

    public final <A> void selectSubscribe(KProperty1<S, ? extends A> r100, i<j<A>> r101, Function1<? super Throwable, Unit> r102, Function1<? super A, Unit> r103) {
        f<S> r104 = this.vmDispatcher;
        if (r104 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("vmDispatcher");
    L5:
        r104.g(r100, r101, C104331.INSTANCE, r103);
    }

    /* JADX WARN: Multi-variable type inference failed */
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
    public final void syncItem2State(final Object r100, final List<? extends Object> r101, final Object r102, final Function2<Object, ? super List<? extends Object>, Unit> r103) {
        f<S> r104 = this.vmDispatcher;
        if (r104 != 0) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("vmDispatcher");
    L5:
        r104.a(new C104351(r102, r100, r103, r101));
    }

    public final <T> void asyncSubscribe(KProperty1<S, ? extends com.bytedance.assem.arch.extensions.c<? extends T>> r100, i<j<com.bytedance.assem.arch.extensions.c<T>>> r101, Function1<? super Throwable, Unit> r110, Function0<Unit> r111, Function1<? super T, Unit> r112) {
        f<S> r102 = this.vmDispatcher;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("vmDispatcher");
    L5:
        r102.b(r100, r101, AnonymousClass1.INSTANCE, r110, r111, r112);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void selectSubscribe$default(AssemViewModel r100, KProperty1 r101, i r102, Function1 r103, Function1 r104, int r105, Object r106) {
        if (r106 != null) goto L12;
        if ((r105 & 2) == 0) goto L7;
        r102 = new i();
        r102.f193087a = true;
        r102.f193088b = true;
    L7:
        if ((r105 & 4) == 0) goto L9;
        r103 = null;
    L9:
        r100.selectSubscribe(r101, r102, r103, r104);
        return;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectSubscribe");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void syncItem2State$default(AssemViewModel r100, Object r101, List r102, Object r103, Function2 r104, int r105, Object r106) {
        if (r106 != null) goto L9;
        if ((r105 & 8) == 0) goto L6;
        r104 = null;
    L6:
        r100.syncItem2State(r101, r102, r103, r104);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: syncItem2State");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void asyncSubscribe$default(AssemViewModel r100, KProperty1 r101, i r102, Function1 r103, Function0 r110, Function1 r111, int r112, Object r113) {
        if (r113 != null) goto L21;
        if ((r112 & 2) == 0) goto L6;
        r102 = new i();
        r102.f193087a = true;
        r102.f193088b = true;
    L6:
        i r104 = r102;
        if ((r112 & 4) == 0) goto L9;
        Function1 r105 = null;
    L11:
        if ((r112 & 8) == 0) goto L13;
        Function0 r106 = null;
    L15:
        if ((r112 & 16) == 0) goto L17;
        Function1 r107 = null;
    L18:
        r100.asyncSubscribe(r101, r104, r105, r106, r107);
        return;
    L17:
        r107 = r111;
        goto L18
    L13:
        r106 = r110;
        goto L15
    L9:
        r105 = r103;
        goto L11
    L21:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: asyncSubscribe");
    }
}
