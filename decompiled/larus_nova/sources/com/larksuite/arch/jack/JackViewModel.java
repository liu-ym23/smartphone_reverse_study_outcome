package com.larksuite.arch.jack;

import android.os.Handler;
import androidx.arch.core.util.Function;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.larksuite.arch.jack.j;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\n\u001a\u00028\u0000H$¢\u0006\u0002\u0010\u000bJ\u001f\u0010\u0014\u001a\u00020\u00152\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\u0017¢\u0006\u0002\b\u0018J\u000e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0002J\b\u0010\u001a\u001a\u00020\u0015H\u0016J\b\u0010\u001b\u001a\u00020\u0015H\u0015J\u001a\u0010\u001c\u001a\u00020\u00152\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00150\u0017J!\u0010\u001e\u001a\u00020\u00152\u0017\u0010\u001f\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\u0017¢\u0006\u0002\b\u0018H\u0004J9\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u000e\b\u0002\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000%2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00150\u0017H\u0000¢\u0006\u0002\b'JY\u0010(\u001a\u00020!\"\u0004\b\u0001\u0010)2\u0006\u0010\"\u001a\u00020#2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H)0+2\u0014\b\u0002\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H)0,0%2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00150\u0017H\u0000¢\u0006\u0002\b-J\u0093\u0001\u0010.\u001a\u00020!\"\u0004\b\u0001\u0010/2\u0006\u0010\"\u001a\u00020#2\u0018\u0010*\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u0002H/000+2\u001a\b\u0002\u0010$\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H/000,0%2\u0016\b\u0002\u00101\u001a\u0010\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00172\u0010\b\u0002\u00103\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u0001042\u0016\b\u0002\u00105\u001a\u0010\u0012\u0004\u0012\u0002H/\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0017H\u0000¢\u0006\u0002\b6Jy\u0010(\u001a\u00020!\"\u0004\b\u0001\u0010)\"\u0004\b\u0002\u001072\u0006\u0010\"\u001a\u00020#2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H)0+2\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H70+2\u001a\b\u0002\u0010$\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H)\u0012\u0004\u0012\u0002H7090%2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00150\u0017H\u0000¢\u0006\u0002\b-J\u0099\u0001\u0010(\u001a\u00020!\"\u0004\b\u0001\u0010)\"\u0004\b\u0002\u00107\"\u0004\b\u0003\u0010:2\u0006\u0010\"\u001a\u00020#2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H)0+2\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H70+2\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H:0+2 \b\u0002\u0010$\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u0002H)\u0012\u0004\u0012\u0002H7\u0012\u0004\u0012\u0002H:0<0%2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00150\u0017H\u0000¢\u0006\u0002\b-J¹\u0001\u0010(\u001a\u00020!\"\u0004\b\u0001\u0010)\"\u0004\b\u0002\u00107\"\u0004\b\u0003\u0010:\"\u0004\b\u0004\u0010=2\u0006\u0010\"\u001a\u00020#2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H)0+2\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H70+2\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H:0+2\u0012\u0010>\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H=0+2&\b\u0002\u0010$\u001a \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u0002H)\u0012\u0004\u0012\u0002H7\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u0002H=0?0%2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00150\u0017H\u0000¢\u0006\u0002\b-JÙ\u0001\u0010(\u001a\u00020!\"\u0004\b\u0001\u0010)\"\u0004\b\u0002\u00107\"\u0004\b\u0003\u0010:\"\u0004\b\u0004\u0010=\"\u0004\b\u0005\u0010@2\u0006\u0010\"\u001a\u00020#2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H)0+2\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H70+2\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H:0+2\u0012\u0010>\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H=0+2\u0012\u0010A\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H@0+2,\b\u0002\u0010$\u001a&\u0012\"\u0012 \u0012\u0004\u0012\u0002H)\u0012\u0004\u0012\u0002H7\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u0002H=\u0012\u0004\u0012\u0002H@0B0%2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00150\u0017H\u0000¢\u0006\u0002\b-JL\u0010C\u001a\u00020!\"\u0004\b\u0001\u0010D2\u0006\u0010\"\u001a\u00020#2\f\u0010$\u001a\b\u0012\u0004\u0012\u0002HD0%2\u0012\u0010E\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002HD0\u00172\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00150\u0017H\u0002J\f\u0010F\u001a\u00020!*\u00020!H\u0004R\u0012\u0010\u0006\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0007R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011¨\u0006G"}, d2 = {"Lcom/larksuite/arch/jack/JackViewModel;", ExifInterface.LATITUDE_SOUTH, "Lcom/larksuite/arch/jack/State;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "initialState", "Lcom/larksuite/arch/jack/State;", "liveData", "Landroidx/lifecycle/MutableLiveData;", "defaultState", "()Lcom/larksuite/arch/jack/State;", "disposables", "Lcom/larksuite/arch/jack/CompositeDisposable;", "mainHandler", "Landroid/os/Handler;", "getMainHandler", "()Landroid/os/Handler;", "mainHandler$delegate", "Lkotlin/Lazy;", "initialize", "", "argsAcceptor", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "getLiveData", "onPrepared", "onCleared", "withState", "block", "setState", "reducer", "subscribeInternal", "Lcom/larksuite/arch/jack/Disposable;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "config", "Lcom/larksuite/arch/jack/SubscriptionConfig;", "subscriber", "subscribeInternal$jack_release", "selectSubscribeInternal", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "prop1", "Lkotlin/reflect/KProperty1;", "Lcom/larksuite/arch/jack/Tuple1;", "selectSubscribeInternal$jack_release", "asyncSubscribeInternal", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/larksuite/arch/jack/Async;", LynxVideoManagerLite.EVENT_ON_ERROR, "", "onLoading", "Lkotlin/Function0;", "onSuccess", "asyncSubscribeInternal$jack_release", "B", "prop2", "Lcom/larksuite/arch/jack/Tuple2;", "C", "prop3", "Lcom/larksuite/arch/jack/Tuple3;", "D", "prop4", "Lcom/larksuite/arch/jack/Tuple4;", ExifInterface.LONGITUDE_EAST, "prop5", "Lcom/larksuite/arch/jack/Tuple5;", "selectSubscribeMapped", "R", "mapper", "disposeOnClear", "jack_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class JackViewModel<S extends j> extends ViewModel {
    private final com.larksuite.arch.jack.b disposables;
    private S initialState;
    private MutableLiveData<S> liveData;
    private final Lazy mainHandler$delegate;

    public static final class a implements k<S> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JackViewModel<S> f282780a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LifecycleOwner f282781b;

        @Override // com.larksuite.arch.jack.k
        public final void a(Observer<S> r100) {
            Intrinsics.checkNotNullParameter(r100, "observer");
            JackViewModel.access$getLiveData(this.f282780a).removeObserver(r100);
        }

        @Override // com.larksuite.arch.jack.k
        public final void b(StateFlow r100) {
            Intrinsics.checkNotNullParameter(r100, "observer");
            JackViewModel.access$getLiveData(this.f282780a).observe(this.f282781b, r100);
        }

        public a(JackViewModel<S> r100, LifecycleOwner r101) {
            this.f282780a = r100;
            this.f282781b = r101;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JackViewModel<S> f282782a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1<S, S> f282783b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(JackViewModel<S> r100, Function1<? super S, ? extends S> r101) {
            this.f282782a = r100;
            this.f282783b = r101;
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
        @Override // java.lang.Runnable
        public final void run() {
            MutableLiveData r100 = JackViewModel.access$getLiveData(this.f282782a);     // Catch: Throwable -> L4
            Function1<S, S> r101 = this.f282783b;     // Catch: Throwable -> L4
            T r102 = JackViewModel.access$getLiveData(this.f282782a).getValue();     // Catch: Throwable -> L4
            Intrinsics.checkNotNull(r102);     // Catch: Throwable -> L4
            r100.setValue(r101.invoke(r102));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1<S, Unit> f282784a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JackViewModel<S> f282785b;

        /* JADX WARN: Multi-variable type inference failed */
        public c(Function1<? super S, Unit> r100, JackViewModel<S> r101) {
            this.f282784a = r100;
            this.f282785b = r101;
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
        @Override // java.lang.Runnable
        public final void run() {
            Function1<S, Unit> r100 = this.f282784a;     // Catch: Throwable -> L4
            T r101 = JackViewModel.access$getLiveData(this.f282785b).getValue();     // Catch: Throwable -> L4
            Intrinsics.checkNotNull(r101);     // Catch: Throwable -> L4
            r100.invoke(r101);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public abstract S defaultState();

    public void onPrepared() {
    }

    private final MutableLiveData<S> getLiveData() {
        if (this.liveData != null) goto L5;
        initialize(AnonymousClass1.INSTANCE);
    L5:
        MutableLiveData<S> r100 = this.liveData;
        if (r100 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("liveData");
        return null;
    L9:
        return r100;
    }

    private final Handler getMainHandler() {
        return (Handler) this.mainHandler$delegate.getValue();
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        this.disposables.dispose();
        getMainHandler().removeCallbacksAndMessages(null);
    }

    public JackViewModel() {
        this.disposables = new com.larksuite.arch.jack.b();
        this.mainHandler$delegate = LazyKt.lazy(JackViewModel$mainHandler$2.INSTANCE);
    }

    public static final /* synthetic */ MutableLiveData access$getLiveData(JackViewModel r100) {
        return r100.getLiveData();
    }

    public final com.larksuite.arch.jack.c disposeOnClear(com.larksuite.arch.jack.c r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        com.larksuite.arch.jack.b r101 = this.disposables;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "d");
        if (r101.f282795b == true) goto L16;
        monitor-enter(r101);
    L13:
        th = move-exception;
        throw th;
    L6:
        if (r101.f282795b == true) goto L10;
        r101.f282794a.add(r100);     // Catch: Throwable -> L13
        monitor-exit(r101);
    L17:
        return r100;
    L10:
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(r101);
    L16:
        r100.dispose();
        goto L17
    }

    public final synchronized void initialize(Function1<? super S, ? extends S> r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "argsAcceptor");     // Catch: Throwable -> L10
        if (this.initialState != null) goto L7;
        S r101 = r100.invoke(defaultState());     // Catch: Throwable -> L10
        this.liveData = new MutableLiveData(r101);     // Catch: Throwable -> L10
        this.initialState = r101;     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);
        return;
    L7:
        g.f282798a.a("init state again, will be ignore, model:" + this);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public final void setState(Function1<? super S, ? extends S> r100) {
        Intrinsics.checkNotNullParameter(r100, "reducer");
        Handler r101 = getMainHandler();
        Runnable r102 = new b(this, r100);
        g.a r103 = g.f282798a;
        Function<? super Runnable, ? extends Runnable> r104 = g.f282799b;
        if (r104 == null) goto L8;
        Runnable r105 = r104.apply(r102);
        if (r105 == null) goto L8;
        r102 = r105;
    L8:
        r101.post(r102);
    }

    public final void withState(Function1<? super S, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        Handler r101 = getMainHandler();
        Runnable r102 = new c(r100, this);
        g.a r103 = g.f282798a;
        Function<? super Runnable, ? extends Runnable> r104 = g.f282799b;
        if (r104 == null) goto L8;
        Runnable r105 = r104.apply(r102);
        if (r105 == null) goto L8;
        r102 = r105;
    L8:
        r101.post(r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final com.larksuite.arch.jack.c subscribeInternal$jack_release(LifecycleOwner r100, l<S> r101, Function1<? super S, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        Intrinsics.checkNotNullParameter(r101, "config");
        Intrinsics.checkNotNullParameter(r102, "subscriber");
        return selectSubscribeMapped(r100, r101, JackViewModel$subscribeInternal$2.INSTANCE, r102);
    }

    private final <R> com.larksuite.arch.jack.c selectSubscribeMapped(LifecycleOwner r100, l<R> r101, Function1<? super S, ? extends R> r102, Function1<? super S, Unit> r103) {
        int r104 = StateFlow.f282786h;
        a r105 = new a(this, r100);
        Intrinsics.checkNotNullParameter(r100, "owner");
        Intrinsics.checkNotNullParameter(r105, "observable");
        StateFlow r106 = new StateFlow(r100, r105);
        Intrinsics.checkNotNullParameter(r102, "mapper");
        r106.f282789c = r102;
        boolean r107 = r101.f282807b;
        r106.f282792f = r101.f282806a;
        Intrinsics.checkNotNullParameter(r103, "subscriber");
        r106.f282790d = r103;
        LifecycleOwner r108 = r106.f282787a;
        if (r108 == null) goto L11;
        r108.getLifecycle().addObserver(r106);
        k<S> r109 = r106.f282788b;
        if (r109 == 0) goto L9;
        r109.b(r106);
        return disposeOnClear(r106);
    L9:
        throw new IllegalArgumentException("cannot access observable after destroy".toString());
    L11:
        throw new IllegalArgumentException("cannot access owner after destroy".toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <A> com.larksuite.arch.jack.c selectSubscribeInternal$jack_release(LifecycleOwner r100, final KProperty1<S, ? extends A> r101, l<n<A>> r102, Function1<? super S, Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        Intrinsics.checkNotNullParameter(r101, "prop1");
        Intrinsics.checkNotNullParameter(r102, "config");
        Intrinsics.checkNotNullParameter(r103, "subscriber");
        return selectSubscribeMapped(r100, r102, new JackViewModel$selectSubscribeInternal$1(r101), r103);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <A, B> com.larksuite.arch.jack.c selectSubscribeInternal$jack_release(LifecycleOwner r100, final KProperty1<S, ? extends A> r101, final KProperty1<S, ? extends B> r102, l<o<A, B>> r103, Function1<? super S, Unit> r104) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        Intrinsics.checkNotNullParameter(r101, "prop1");
        Intrinsics.checkNotNullParameter(r102, "prop2");
        Intrinsics.checkNotNullParameter(r103, "config");
        Intrinsics.checkNotNullParameter(r104, "subscriber");
        return selectSubscribeMapped(r100, r103, new JackViewModel$selectSubscribeInternal$2(r101, r102), r104);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ com.larksuite.arch.jack.c subscribeInternal$jack_release$default(JackViewModel r100, LifecycleOwner r101, l r102, Function1 r103, int r104, Object r105) {
        if (r105 != null) goto L9;
        if ((r104 & 2) == 0) goto L7;
        r102 = new l();
    L7:
        return r100.subscribeInternal$jack_release(r101, r102, r103);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: subscribeInternal");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> com.larksuite.arch.jack.c asyncSubscribeInternal$jack_release(LifecycleOwner r100, final KProperty1<S, ? extends com.larksuite.arch.jack.a<? extends T>> r101, l<n<com.larksuite.arch.jack.a<T>>> r102, final Function1<? super Throwable, Unit> r103, final Function0<Unit> r104, final Function1<? super T, Unit> r105) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        Intrinsics.checkNotNullParameter(r101, "prop1");
        Intrinsics.checkNotNullParameter(r102, "config");
        return selectSubscribeMapped(r100, r102, new JackViewModel$asyncSubscribeInternal$1(r101), new JackViewModel$asyncSubscribeInternal$2(r101, r104, r103, r105));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <A, B, C> com.larksuite.arch.jack.c selectSubscribeInternal$jack_release(LifecycleOwner r100, final KProperty1<S, ? extends A> r101, final KProperty1<S, ? extends B> r102, final KProperty1<S, ? extends C> r103, l<p<A, B, C>> r104, Function1<? super S, Unit> r105) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        Intrinsics.checkNotNullParameter(r101, "prop1");
        Intrinsics.checkNotNullParameter(r102, "prop2");
        Intrinsics.checkNotNullParameter(r103, "prop3");
        Intrinsics.checkNotNullParameter(r104, "config");
        Intrinsics.checkNotNullParameter(r105, "subscriber");
        return selectSubscribeMapped(r100, r104, new JackViewModel$selectSubscribeInternal$3(r101, r102, r103), r105);
    }

    public static com.larksuite.arch.jack.c selectSubscribeInternal$jack_release$default(JackViewModel r100, LifecycleOwner r101, KProperty1 r102, l r103, Function1 r104, int r105, Object r106) {
        if (r106 != null) goto L9;
        if ((r105 & 4) == 0) goto L7;
        r103 = new l();
    L7:
        return r100.selectSubscribeInternal$jack_release(r101, r102, r103, r104);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectSubscribeInternal");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <A, B, C, D> com.larksuite.arch.jack.c selectSubscribeInternal$jack_release(LifecycleOwner r100, final KProperty1<S, ? extends A> r101, final KProperty1<S, ? extends B> r102, final KProperty1<S, ? extends C> r103, final KProperty1<S, ? extends D> r104, l<q<A, B, C, D>> r105, Function1<? super S, Unit> r106) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        Intrinsics.checkNotNullParameter(r101, "prop1");
        Intrinsics.checkNotNullParameter(r102, "prop2");
        Intrinsics.checkNotNullParameter(r103, "prop3");
        Intrinsics.checkNotNullParameter(r104, "prop4");
        Intrinsics.checkNotNullParameter(r105, "config");
        Intrinsics.checkNotNullParameter(r106, "subscriber");
        return selectSubscribeMapped(r100, r105, new JackViewModel$selectSubscribeInternal$4(r101, r102, r103, r104), r106);
    }

    public static com.larksuite.arch.jack.c selectSubscribeInternal$jack_release$default(JackViewModel r100, LifecycleOwner r101, KProperty1 r102, KProperty1 r103, l r110, Function1 r111, int r112, Object r113) {
        if (r113 != null) goto L9;
        if ((r112 & 8) == 0) goto L7;
        r110 = new l();
    L7:
        return r100.selectSubscribeInternal$jack_release(r101, r102, r103, r110, r111);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectSubscribeInternal");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <A, B, C, D, E> com.larksuite.arch.jack.c selectSubscribeInternal$jack_release(LifecycleOwner r100, final KProperty1<S, ? extends A> r101, final KProperty1<S, ? extends B> r110, final KProperty1<S, ? extends C> r111, final KProperty1<S, ? extends D> r112, final KProperty1<S, ? extends E> r113, l<r<A, B, C, D, E>> r114, Function1<? super S, Unit> r115) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        Intrinsics.checkNotNullParameter(r101, "prop1");
        Intrinsics.checkNotNullParameter(r110, "prop2");
        Intrinsics.checkNotNullParameter(r111, "prop3");
        Intrinsics.checkNotNullParameter(r112, "prop4");
        Intrinsics.checkNotNullParameter(r113, "prop5");
        Intrinsics.checkNotNullParameter(r114, "config");
        Intrinsics.checkNotNullParameter(r115, "subscriber");
        return selectSubscribeMapped(r100, r114, new JackViewModel$selectSubscribeInternal$5(r101, r110, r111, r112, r113), r115);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static com.larksuite.arch.jack.c asyncSubscribeInternal$jack_release$default(JackViewModel r100, LifecycleOwner r101, KProperty1 r102, l r110, Function1 r111, Function0 r112, Function1 r113, int r114, Object r115) {
        if (r115 != null) goto L21;
        if ((r114 & 4) == 0) goto L6;
        r110 = new l();
    L6:
        l r103 = r110;
        if ((r114 & 8) == 0) goto L9;
        Function1 r104 = null;
    L11:
        if ((r114 & 16) == 0) goto L13;
        Function0 r105 = null;
    L15:
        if ((r114 & 32) == 0) goto L17;
        Function1 r106 = null;
    L19:
        return r100.asyncSubscribeInternal$jack_release(r101, r102, r103, r104, r105, r106);
    L17:
        r106 = r113;
        goto L19
    L13:
        r105 = r112;
        goto L15
    L9:
        r104 = r111;
        goto L11
    L21:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: asyncSubscribeInternal");
    }

    public static com.larksuite.arch.jack.c selectSubscribeInternal$jack_release$default(JackViewModel r100, LifecycleOwner r101, KProperty1 r102, KProperty1 r110, KProperty1 r111, l r112, Function1 r113, int r114, Object r115) {
        if (r115 != null) goto L9;
        if ((r114 & 16) == 0) goto L7;
        r112 = new l();
    L7:
        return r100.selectSubscribeInternal$jack_release(r101, r102, r110, r111, r112, r113);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectSubscribeInternal");
    }

    public static com.larksuite.arch.jack.c selectSubscribeInternal$jack_release$default(JackViewModel r100, LifecycleOwner r110, KProperty1 r111, KProperty1 r112, KProperty1 r113, KProperty1 r114, l r115, Function1 r116, int r117, Object r118) {
        if (r118 != null) goto L10;
        if ((r117 & 32) == 0) goto L6;
        l r101 = new l();
    L8:
        return r100.selectSubscribeInternal$jack_release(r110, r111, r112, r113, r114, r101, r116);
    L6:
        r101 = r115;
        goto L8
    L10:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectSubscribeInternal");
    }

    public static com.larksuite.arch.jack.c selectSubscribeInternal$jack_release$default(JackViewModel r110, LifecycleOwner r111, KProperty1 r112, KProperty1 r113, KProperty1 r114, KProperty1 r115, KProperty1 r116, l r117, Function1 r118, int r119, Object r210) {
        if (r210 != null) goto L10;
        if ((r119 & 64) == 0) goto L6;
        l r100 = new l();
    L8:
        return r110.selectSubscribeInternal$jack_release(r111, r112, r113, r114, r115, r116, r100, r118);
    L6:
        r100 = r117;
        goto L8
    L10:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectSubscribeInternal");
    }
}
