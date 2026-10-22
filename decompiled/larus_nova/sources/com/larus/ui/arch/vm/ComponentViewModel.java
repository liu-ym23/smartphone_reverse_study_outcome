package com.larus.ui.arch.vm;

import android.util.SparseArray;
import androidx.collection.ArrayMap;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.larus.ui.arch.vm.internal.ComponentStateOperator;
import com.larus.ui.arch.vm.internal.c;
import com.larus.ui.arch.vm.internal.m;
import com.larus.ui.arch.vm.internal.n;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KCallable;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty1;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.e;
import w1a.b;
import w1a.d;
import w1a.h;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\b\u0017\u0018\u0000 ]*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u00032\u00020\u0004:\u0001]B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00028\u0000H\u0000¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010!\u001a\u00020\u001c2\u0006\u0010\n\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\"J\b\u0010#\u001a\u00020\u001cH\u0004J\b\u0010&\u001a\u00020\u001cH\u0015J!\u0010'\u001a\u00020\u001c2\u0017\u0010(\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000)¢\u0006\u0002\b*H\u0004J!\u0010+\u001a\u00020\u001c2\u0017\u0010(\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000)¢\u0006\u0002\b*H\u0004J\u001c\u0010,\u001a\u00020\u001c2\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001c0)H\u0004J\u000b\u0010.\u001a\u00028\u0000¢\u0006\u0002\u0010/Js\u00100\u001a\u00020128\b\u0002\u00102\u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(5\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(6\u0012\u0004\u0012\u00020\u00140\u00132\b\b\u0002\u00107\u001a\u0002082\"\u00109\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0:\u0012\u0006\u0012\u0004\u0018\u00010;0\u0013¢\u0006\u0002\u0010<JS\u00100\u001a\u000201\"\u0004\b\u0001\u0010=2\u0012\u0010>\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H=0?2\b\b\u0002\u00107\u001a\u0002082\"\u00109\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H=\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0:\u0012\u0006\u0012\u0004\u0018\u00010;0\u0013¢\u0006\u0002\u0010@J[\u0010A\u001a\u000201\"\u0004\b\u0001\u0010=2\u0006\u0010B\u001a\u00020C2\u0012\u0010>\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H=0?2\b\b\u0002\u00107\u001a\u0002082\"\u00109\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H=\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0:\u0012\u0006\u0012\u0004\u0018\u00010;0\u0013¢\u0006\u0002\u0010DJs\u00100\u001a\u000201\"\u0004\b\u0001\u0010=\"\u0004\b\u0002\u0010E2\u0012\u0010>\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H=0?2\u0012\u0010F\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002HE0?2\b\b\u0002\u00107\u001a\u0002082(\u00109\u001a$\b\u0001\u0012\u0004\u0012\u0002H=\u0012\u0004\u0012\u0002HE\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0:\u0012\u0006\u0012\u0004\u0018\u00010;0G¢\u0006\u0002\u0010HJ\u0093\u0001\u00100\u001a\u000201\"\u0004\b\u0001\u0010=\"\u0004\b\u0002\u0010E\"\u0004\b\u0003\u0010I2\u0012\u0010>\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H=0?2\u0012\u0010F\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002HE0?2\u0012\u0010J\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002HI0?2\b\b\u0002\u00107\u001a\u0002082.\u00109\u001a*\b\u0001\u0012\u0004\u0012\u0002H=\u0012\u0004\u0012\u0002HE\u0012\u0004\u0012\u0002HI\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0:\u0012\u0006\u0012\u0004\u0018\u00010;0K¢\u0006\u0002\u0010LJ³\u0001\u00100\u001a\u000201\"\u0004\b\u0001\u0010=\"\u0004\b\u0002\u0010E\"\u0004\b\u0003\u0010I\"\u0004\b\u0004\u0010M2\u0012\u0010>\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H=0?2\u0012\u0010F\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002HE0?2\u0012\u0010J\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002HI0?2\u0012\u0010N\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002HM0?2\b\b\u0002\u00107\u001a\u00020824\u00109\u001a0\b\u0001\u0012\u0004\u0012\u0002H=\u0012\u0004\u0012\u0002HE\u0012\u0004\u0012\u0002HI\u0012\u0004\u0012\u0002HM\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0:\u0012\u0006\u0012\u0004\u0018\u00010;0O¢\u0006\u0002\u0010PJÓ\u0001\u00100\u001a\u000201\"\u0004\b\u0001\u0010=\"\u0004\b\u0002\u0010E\"\u0004\b\u0003\u0010I\"\u0004\b\u0004\u0010M\"\u0004\b\u0005\u0010Q2\u0012\u0010>\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H=0?2\u0012\u0010F\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002HE0?2\u0012\u0010J\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002HI0?2\u0012\u0010N\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002HM0?2\u0012\u0010R\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002HQ0?2\b\b\u0002\u00107\u001a\u0002082:\u00109\u001a6\b\u0001\u0012\u0004\u0012\u0002H=\u0012\u0004\u0012\u0002HE\u0012\u0004\u0012\u0002HI\u0012\u0004\u0012\u0002HM\u0012\u0004\u0012\u0002HQ\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0:\u0012\u0006\u0012\u0004\u0018\u00010;0S¢\u0006\u0002\u0010TJ{\u0010U\u001a\u000201\"\u0004\b\u0001\u0010V2\u0018\u0010W\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u0002HV0X0?2&\b\u0002\u0010Y\u001a \b\u0001\u0012\u0004\u0012\u00020Z\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0:\u0012\u0006\u0012\u0004\u0018\u00010;\u0018\u00010\u00132&\b\u0002\u0010[\u001a \b\u0001\u0012\u0004\u0012\u0002HV\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0:\u0012\u0006\u0012\u0004\u0018\u00010;\u0018\u00010\u0013¢\u0006\u0002\u0010\\R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00028\u0000X\u0082.¢\u0006\u0004\n\u0002\u0010\u000bR!\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR \u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%¨\u0006^"}, d2 = {"Lcom/larus/ui/arch/vm/ComponentViewModel;", ExifInterface.LATITUDE_SOUTH, "Lcom/larus/ui/arch/vm/external/ComponentState;", "Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/LifecycleOwner;", "<init>", "()V", "lifecycleWeekRef", "Ljava/lang/ref/WeakReference;", "Landroidx/lifecycle/Lifecycle;", "initialState", "Lcom/larus/ui/arch/vm/external/ComponentState;", "stateOperator", "Lcom/larus/ui/arch/vm/internal/ComponentStateOperator;", "getStateOperator", "()Lcom/larus/ui/arch/vm/internal/ComponentStateOperator;", "stateOperator$delegate", "Lkotlin/Lazy;", "defaultAreEquivalent", "Lkotlin/Function2;", "", "viewModelScope", "Lkotlinx/coroutines/CoroutineScope;", "getViewModelScope", "()Lkotlinx/coroutines/CoroutineScope;", "viewModelScope$delegate", "Lcom/larus/ui/arch/vm/internal/CoroutineScopeLazy;", "injectParams", "", NewBroadcastMonitor.STAGE.LIFECYCLE, "state", "injectParams$component_release", "(Landroidx/lifecycle/Lifecycle;Lcom/larus/ui/arch/vm/external/ComponentState;)V", "validateState", "(Lcom/larus/ui/arch/vm/external/ComponentState;)V", "onPrepared", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "onCleared", "setState", "reducer", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "setStateImmediate", "withState", "block", "getState", "()Lcom/larus/ui/arch/vm/external/ComponentState;", "onEach", "Lkotlinx/coroutines/Job;", "areEquivalent", "Lkotlin/ParameterName;", "name", "old", "new", "deliveryMode", "Lcom/larus/ui/arch/vm/external/DeliveryMode;", "action", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function2;Lcom/larus/ui/arch/vm/external/DeliveryMode;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Job;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "prop1", "Lkotlin/reflect/KProperty1;", "(Lkotlin/reflect/KProperty1;Lcom/larus/ui/arch/vm/external/DeliveryMode;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Job;", "onEachDelay", "delayMs", "", "(JLkotlin/reflect/KProperty1;Lcom/larus/ui/arch/vm/external/DeliveryMode;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Job;", "B", "prop2", "Lkotlin/Function3;", "(Lkotlin/reflect/KProperty1;Lkotlin/reflect/KProperty1;Lcom/larus/ui/arch/vm/external/DeliveryMode;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/Job;", "C", "prop3", "Lkotlin/Function4;", "(Lkotlin/reflect/KProperty1;Lkotlin/reflect/KProperty1;Lkotlin/reflect/KProperty1;Lcom/larus/ui/arch/vm/external/DeliveryMode;Lkotlin/jvm/functions/Function4;)Lkotlinx/coroutines/Job;", "D", "prop4", "Lkotlin/Function5;", "(Lkotlin/reflect/KProperty1;Lkotlin/reflect/KProperty1;Lkotlin/reflect/KProperty1;Lkotlin/reflect/KProperty1;Lcom/larus/ui/arch/vm/external/DeliveryMode;Lkotlin/jvm/functions/Function5;)Lkotlinx/coroutines/Job;", ExifInterface.LONGITUDE_EAST, "prop5", "Lkotlin/Function6;", "(Lkotlin/reflect/KProperty1;Lkotlin/reflect/KProperty1;Lkotlin/reflect/KProperty1;Lkotlin/reflect/KProperty1;Lkotlin/reflect/KProperty1;Lcom/larus/ui/arch/vm/external/DeliveryMode;Lkotlin/jvm/functions/Function6;)Lkotlinx/coroutines/Job;", "onAsync", ExifInterface.GPS_DIRECTION_TRUE, "asyncProp", "Lcom/larus/ui/arch/vm/external/Async;", "onFail", "", "onSuccess", "(Lkotlin/reflect/KProperty1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Job;", "Companion", "component_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class ComponentViewModel<S extends w1a.b> extends ViewModel implements LifecycleOwner {
    public static final int $stable = 0;
    public static final a Companion = null;
    public static final String TAG = "ComponentViewModel";
    private final Function2<S, S, Boolean> defaultAreEquivalent;
    private S initialState;
    private WeakReference<Lifecycle> lifecycleWeekRef;
    private final Lazy stateOperator$delegate;
    private final m viewModelScope$delegate;

    /* JADX INFO: loaded from: classes31.dex */
    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
        $stable = 8;
    }

    public static /* synthetic */ boolean Mo(w1a.b r100, w1a.b r101) {
        return defaultAreEquivalent$lambda$1(r100, r101);
    }

    public static /* synthetic */ ComponentStateOperator yo(ComponentViewModel r100) {
        return stateOperator_delegate$lambda$0(r100);
    }

    public final void onPrepared() {
    }

    private final ComponentStateOperator<S> getStateOperator() {
        return (ComponentStateOperator) this.stateOperator$delegate.getValue();
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        WeakReference<Lifecycle> r100 = this.lifecycleWeekRef;
        if (r100 == null) goto L10;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("lifecycleWeekRef");
        r100 = null;
    L6:
        Lifecycle r101 = r100.get();
        if (r101 == null) goto L12;
        return r101;
    L12:
        return EmptyLifecycle.f375184a;
    L10:
        return EmptyLifecycle.f375184a;
    }

    public final CoroutineScope getViewModelScope() {
        return this.viewModelScope$delegate.getValue();
    }

    public ComponentViewModel() {
        this.stateOperator$delegate = LazyKt.lazy(new com.larus.ui.arch.vm.a(this));
        this.defaultAreEquivalent = new b();
        this.viewModelScope$delegate = new m();
    }

    public final S getState() {
        return getStateOperator().b().f375268d;
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        int r100 = y1a.a.f565679a;
        y1a.a.a(TAG, "onCleared " + getClass().getCanonicalName());
        CoroutineScopeKt.cancel$default(getViewModelScope(), null, 1, null);
    }

    public static final /* synthetic */ w1a.b access$getInitialState$p(ComponentViewModel r100) {
        return r100.initialState;
    }

    private static final ComponentStateOperator stateOperator_delegate$lambda$0(ComponentViewModel r100) {
        CoroutineScope r101 = r100.getViewModelScope();
        S r102 = r100.initialState;
        if (r102 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("initialState");
        r102 = null;
    L6:
        return new ComponentStateOperator(r100, r101, r102);
    }

    private final void validateState(S r100) {
        KClass r101 = Reflection.getOrCreateKotlinClass(r100.getClass());
        Intrinsics.checkNotNullParameter(r101, "<this>");
        Field[] r102 = JvmClassMappingKt.getJavaClass(r101).getDeclaredFields();
        ArrayList r103 = new ArrayList();
        int r104 = r102.length;
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L8;
        Field r106 = r102[r105];
        if (Modifier.isTransient(r106.getModifiers()) == true) goto L7;
        r103.add(r106);
    L7:
        r105 = r105 + 1;
        goto L3
    L8:
        Iterator r107 = r103.iterator();
    L10:
        if (r107.hasNext() == false) goto L43;
        Field r108 = (Field) r107.next();
        if (Modifier.isFinal(r108.getModifiers()) == true) goto L14;
        String r109 = "State property " + r108.getName() + " must be a val, not a var.";
    L39:
        if (r109 == null) goto L10;
        throw new IllegalArgumentException("Invalid property in state " + Reflection.getOrCreateKotlinClass(r101.getClass()).getSimpleName() + ": " + r109);
    L14:
        Intrinsics.checkNotNull(r108);
        if (v1a.a.a(r108, new KClass[]{Reflection.getOrCreateKotlinClass(ArrayList.class)}) == false) goto L18;
        r109 = "You cannot use ArrayList for " + r108.getName() + ".\nUse the immutable listOf(...) method instead. You can append it with `val newList = listA + listB`";
        goto L39
    L18:
        if (v1a.a.a(r108, new KClass[]{Reflection.getOrCreateKotlinClass(SparseArray.class)}) == false) goto L21;
        r109 = "You cannot use SparseArray for " + r108.getName() + ".\nUse the immutable listOf(...) method instead. You can append it with `val newList = listA + listB`";
        goto L39
    L21:
        if (v1a.a.a(r108, new KClass[]{Reflection.getOrCreateKotlinClass(LongSparseArray.class)}) == false) goto L24;
        r109 = "You cannot use LongSparseArray for " + r108.getName() + ".\nUse the immutable listOf(...) method instead. You can append it with `val newList = listA + listB`";
        goto L39
    L24:
        if (v1a.a.a(r108, new KClass[]{Reflection.getOrCreateKotlinClass(SparseArrayCompat.class)}) == false) goto L27;
        r109 = "You cannot use SparseArrayCompat for " + r108.getName() + ".\nUse the immutable listOf(...) method instead. You can append it with `val newList = listA + listB`";
        goto L39
    L27:
        if (v1a.a.a(r108, new KClass[]{Reflection.getOrCreateKotlinClass(ArrayMap.class)}) == false) goto L30;
        r109 = "You cannot use ArrayMap for " + r108.getName() + ".\nUse the immutable mapOf(...) method instead. You can append it with `val newMap = mapA + mapB`";
        goto L39
    L30:
        if (v1a.a.a(r108, new KClass[]{Reflection.getOrCreateKotlinClass(android.util.ArrayMap.class)}) == false) goto L33;
        r109 = "You cannot use ArrayMap for " + r108.getName() + ".\nUse the immutable mapOf(...) method instead. You can append it with `val newMap = mapA + mapB`";
        goto L39
    L33:
        if (v1a.a.a(r108, new KClass[]{Reflection.getOrCreateKotlinClass(HashMap.class)}) == false) goto L36;
        r109 = "You cannot use HashMap for " + r108.getName() + ".\nUse the immutable mapOf(...) method instead. You can append it with `val newMap = mapA + mapB`";
        goto L39
    L36:
        if (v1a.a.a(r108, new KClass[]{Reflection.getOrCreateKotlinClass(Function.class), Reflection.getOrCreateKotlinClass(KCallable.class)}) == false) goto L38;
        r109 = "You cannot use functions inside Component state. Only pure data should be represented: " + r108.getName();
        goto L39
    L38:
        r109 = null;
        goto L39
    }

    public final void setState(final Function1<? super S, ? extends S> r100) {
        Intrinsics.checkNotNullParameter(r100, "reducer");
        final ComponentStateOperator<S> r101 = getStateOperator();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "reducer");
        if (x1a.a.f562150a == false) goto L5;
        n<S> r102 = r101.b();
        Function1<S, S> r103 = new c(r100, r101);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "reducer");
        r102.f375265a.mo10962trySendJP2dKIU(r103);
        return;
    L5:
        n<S> r104 = r101.b();
        r104.getClass();
        Intrinsics.checkNotNullParameter(r100, "reducer");
        r104.f375265a.mo10962trySendJP2dKIU(r100);
    }

    public final void setStateImmediate(Function1<? super S, ? extends S> r100) {
        Intrinsics.checkNotNullParameter(r100, "reducer");
        ComponentStateOperator<S> r101 = getStateOperator();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "reducer");
        n<S> r102 = r101.b();
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "stateReducer");
        S r103 = r100.invoke(r102.f375268d);
        if (Intrinsics.areEqual(r102.f375268d, r103) == true) goto L6;
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        r102.f375268d = r103;
        r102.f375267c.tryEmit(r103);
        return;
    }

    public final void withState(Function1<? super S, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        ComponentStateOperator<S> r101 = getStateOperator();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "action");
        n<S> r102 = r101.b();
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "block");
        r102.f375266b.mo10962trySendJP2dKIU(r100);
    }

    public static final /* synthetic */ void access$validateState(ComponentViewModel r100, w1a.b r101) {
        r100.validateState(r101);
    }

    private static final boolean defaultAreEquivalent$lambda$1(w1a.b r100, w1a.b r101) {
        Intrinsics.checkNotNullParameter(r100, "old");
        Intrinsics.checkNotNullParameter(r101, "new");
        return Intrinsics.areEqual(r100, r101);
    }

    public final void injectParams$component_release(Lifecycle r100, S r101) {
        Intrinsics.checkNotNullParameter(r100, NewBroadcastMonitor.STAGE.LIFECYCLE);
        Intrinsics.checkNotNullParameter(r101, "state");
        if (this.initialState != null) goto L9;
        this.lifecycleWeekRef = new WeakReference(r100);
        this.initialState = r101;
        boolean r102 = x1a.a.f562150a;
        if (x1a.a.f562150a == false) goto L7;
        BuildersKt.launch$default(getViewModelScope(), Dispatchers.getDefault(), null, new ComponentViewModel$injectParams$1(this, null), 2, null);
    L7:
        onPrepared();
        return;
    }

    public final <T> Job onAsync(KProperty1<S, ? extends w1a.a<? extends T>> r100, Function2<? super Throwable, ? super Continuation<? super Unit>, ? extends Object> r101, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "asyncProp");
        return getStateOperator().c(r100, r101, r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Job onEach(Function2<? super S, ? super S, Boolean> r100, d r101, Function2<? super S, ? super Continuation<? super Unit>, ? extends Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "areEquivalent");
        Intrinsics.checkNotNullParameter(r101, "deliveryMode");
        Intrinsics.checkNotNullParameter(r102, "action");
        ComponentStateOperator<S> r103 = getStateOperator();
        r103.getClass();
        Intrinsics.checkNotNullParameter(r100, "areEquivalent");
        Intrinsics.checkNotNullParameter(r101, "deliveryMode");
        Intrinsics.checkNotNullParameter(r102, "action");
        return r103.j(e.o(r103.a(), r100), r103.f375187a, r101, r102);
    }

    public final <A> Job onEach(KProperty1<S, ? extends A> r100, d r101, Function2<? super A, ? super Continuation<? super Unit>, ? extends Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "prop1");
        Intrinsics.checkNotNullParameter(r101, "deliveryMode");
        Intrinsics.checkNotNullParameter(r102, "action");
        return getStateOperator().h(r100, r101, r102);
    }

    public final <A, B> Job onEach(KProperty1<S, ? extends A> r100, KProperty1<S, ? extends B> r101, d r102, Function3<? super A, ? super B, ? super Continuation<? super Unit>, ? extends Object> r103) {
        Intrinsics.checkNotNullParameter(r100, "prop1");
        Intrinsics.checkNotNullParameter(r101, "prop2");
        Intrinsics.checkNotNullParameter(r102, "deliveryMode");
        Intrinsics.checkNotNullParameter(r103, "action");
        return getStateOperator().g(r100, r101, r102, r103);
    }

    public final <A> Job onEachDelay(long r100, KProperty1<S, ? extends A> r110, d r111, Function2<? super A, ? super Continuation<? super Unit>, ? extends Object> r112) {
        Intrinsics.checkNotNullParameter(r110, "prop1");
        Intrinsics.checkNotNullParameter(r111, "deliveryMode");
        Intrinsics.checkNotNullParameter(r112, "action");
        return getStateOperator().i(r100, r110, r111, r112);
    }

    public final <A, B, C> Job onEach(KProperty1<S, ? extends A> r100, KProperty1<S, ? extends B> r101, KProperty1<S, ? extends C> r110, d r111, Function4<? super A, ? super B, ? super C, ? super Continuation<? super Unit>, ? extends Object> r112) {
        Intrinsics.checkNotNullParameter(r100, "prop1");
        Intrinsics.checkNotNullParameter(r101, "prop2");
        Intrinsics.checkNotNullParameter(r110, "prop3");
        Intrinsics.checkNotNullParameter(r111, "deliveryMode");
        Intrinsics.checkNotNullParameter(r112, "action");
        return getStateOperator().f(r100, r101, r110, r111, r112);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Job onAsync$default(ComponentViewModel r100, KProperty1 r101, Function2 r102, Function2 r103, int r104, Object r105) {
        if (r105 != null) goto L12;
        if ((r104 & 2) == 0) goto L7;
        r102 = null;
    L7:
        if ((r104 & 4) == 0) goto L10;
        r103 = null;
    L10:
        return r100.onAsync(r101, r102, r103);
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onAsync");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Job onEach$default(ComponentViewModel r100, Function2 r101, d r102, Function2 r103, int r104, Object r105) {
        if (r105 != null) goto L12;
        if ((r104 & 1) == 0) goto L7;
        r101 = r100.defaultAreEquivalent;
    L7:
        if ((r104 & 2) == 0) goto L10;
        r102 = new h(0);
    L10:
        return r100.onEach(r101, r102, r103);
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onEach");
    }

    public final <A, B, C, D> Job onEach(KProperty1<S, ? extends A> r100, KProperty1<S, ? extends B> r110, KProperty1<S, ? extends C> r111, KProperty1<S, ? extends D> r112, d r113, Function5<? super A, ? super B, ? super C, ? super D, ? super Continuation<? super Unit>, ? extends Object> r114) {
        Intrinsics.checkNotNullParameter(r100, "prop1");
        Intrinsics.checkNotNullParameter(r110, "prop2");
        Intrinsics.checkNotNullParameter(r111, "prop3");
        Intrinsics.checkNotNullParameter(r112, "prop4");
        Intrinsics.checkNotNullParameter(r113, "deliveryMode");
        Intrinsics.checkNotNullParameter(r114, "action");
        return getStateOperator().e(r100, r110, r111, r112, r113, r114);
    }

    public static /* synthetic */ Job onEach$default(ComponentViewModel r100, KProperty1 r101, d r102, Function2 r103, int r104, Object r105) {
        if (r105 != null) goto L9;
        if ((r104 & 2) == 0) goto L7;
        r102 = new h(0);
    L7:
        return r100.onEach(r101, r102, r103);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onEach");
    }

    public static /* synthetic */ Job onEach$default(ComponentViewModel r100, KProperty1 r101, KProperty1 r102, d r103, Function3 r104, int r105, Object r106) {
        if (r106 != null) goto L9;
        if ((r105 & 4) == 0) goto L7;
        r103 = new h(0);
    L7:
        return r100.onEach(r101, r102, r103, r104);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onEach");
    }

    public static /* synthetic */ Job onEachDelay$default(ComponentViewModel r100, long r101, KProperty1 r102, d r110, Function2 r111, int r112, Object r113) {
        if (r113 != null) goto L9;
        if ((r112 & 4) == 0) goto L7;
        r110 = new h(0);
    L7:
        return r100.onEachDelay(r101, r102, r110, r111);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onEachDelay");
    }

    public final <A, B, C, D, E> Job onEach(KProperty1<S, ? extends A> r110, KProperty1<S, ? extends B> r111, KProperty1<S, ? extends C> r112, KProperty1<S, ? extends D> r113, KProperty1<S, ? extends E> r114, d r115, Function6<? super A, ? super B, ? super C, ? super D, ? super E, ? super Continuation<? super Unit>, ? extends Object> r116) {
        Intrinsics.checkNotNullParameter(r110, "prop1");
        Intrinsics.checkNotNullParameter(r111, "prop2");
        Intrinsics.checkNotNullParameter(r112, "prop3");
        Intrinsics.checkNotNullParameter(r113, "prop4");
        Intrinsics.checkNotNullParameter(r114, "prop5");
        Intrinsics.checkNotNullParameter(r115, "deliveryMode");
        Intrinsics.checkNotNullParameter(r116, "action");
        return getStateOperator().d(r110, r111, r112, r113, r114, r115, r116);
    }

    public static /* synthetic */ Job onEach$default(ComponentViewModel r100, KProperty1 r101, KProperty1 r102, KProperty1 r103, d r110, Function4 r111, int r112, Object r113) {
        if (r113 != null) goto L9;
        if ((r112 & 8) == 0) goto L7;
        r110 = new h(0);
    L7:
        return r100.onEach(r101, r102, r103, r110, r111);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onEach");
    }

    public static /* synthetic */ Job onEach$default(ComponentViewModel r100, KProperty1 r101, KProperty1 r102, KProperty1 r110, KProperty1 r111, d r112, Function5 r113, int r114, Object r115) {
        if (r115 != null) goto L9;
        if ((r114 & 16) == 0) goto L7;
        r112 = new h(0);
    L7:
        return r100.onEach(r101, r102, r110, r111, r112, r113);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onEach");
    }

    public static /* synthetic */ Job onEach$default(ComponentViewModel r110, KProperty1 r111, KProperty1 r112, KProperty1 r113, KProperty1 r114, KProperty1 r115, d r116, Function6 r117, int r118, Object r119) {
        if (r119 != null) goto L10;
        if ((r118 & 32) == 0) goto L6;
        d r100 = new h(0);
    L8:
        return r110.onEach(r111, r112, r113, r114, r115, r100, r117);
    L6:
        r100 = r116;
        goto L8
    L10:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onEach");
    }
}
