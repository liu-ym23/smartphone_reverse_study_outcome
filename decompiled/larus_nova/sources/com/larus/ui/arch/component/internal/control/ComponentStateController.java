package com.larus.ui.arch.component.internal.control;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal;
import com.larus.ui.arch.component.internal.attach.Attachable;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0001\u0018\u0000 ;2\u00020\u0001:\u0001;B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001aH\u0002J\u001d\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\"H\u0000¢\u0006\u0002\b#J\b\u0010$\u001a\u00020\u001aH\u0002J\b\u0010%\u001a\u00020\u001aH\u0002J\b\u0010&\u001a\u00020\u001aH\u0002J\b\u0010'\u001a\u00020\u001aH\u0002J\u0015\u0010(\u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\"H\u0000¢\u0006\u0002\b)J\b\u0010*\u001a\u00020\u001aH\u0002J.\u0010+\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\b\b\u0002\u00100\u001a\u00020\rH\u0002J\u001a\u00101\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020/2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0002J\u0010\u00102\u001a\u00020\u001a2\b\u00103\u001a\u0004\u0018\u00010\u0005J\u000e\u00104\u001a\u00020\u001a2\u0006\u00103\u001a\u00020\u0005J\u000e\u00105\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\u0010J\u000e\u00106\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\u0010J$\u00107\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\u00102\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\b\b\u0002\u00100\u001a\u00020\rJ\u000e\u00108\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\u0010J\u000e\u00109\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\u0010J\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R*\u0010\u0016\u001a\u0004\u0018\u00010\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0006@BX\u0087\u000e¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\t\u001a\u0004\b\u0018\u0010\u000b¨\u0006<"}, d2 = {"Lcom/larus/ui/arch/component/internal/control/ComponentStateController;", "Landroidx/lifecycle/LifecycleEventObserver;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", PerfLog.PARAM_KEY_CONTEXT_ID, "", "<init>", "(Landroidx/lifecycle/LifecycleOwner;Ljava/lang/Object;)V", "getContext$annotations", "()V", "getContext", "()Ljava/lang/Object;", "fragmentViewCreated", "", "componentList", "", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", NewBroadcastMonitor.STAGE.LIFECYCLE, "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "value", "containerView", "getContainerView$annotations", "getContainerView", "onStateChanged", "", "source", "event", "Landroidx/lifecycle/Lifecycle$Event;", WidgetCostModule.TYPE_ON_CREATE, "onFragmentViewCreated", "view", "attachable", "Lcom/larus/ui/arch/component/internal/attach/Attachable;", "onFragmentViewCreated$component_release", WidgetCostModule.TYPE_ON_START, "onResume", "onPause", "onStop", "onFragmentViewDestroyed", "onFragmentViewDestroyed$component_release", LiveCommonConstants.REASON_ON_DEDTROY, "handleLifecycleState", "dstState", "Landroidx/lifecycle/Lifecycle$State;", "component", "Lcom/larus/ui/arch/component/external/delegate/BaseComponentFeatureInternal;", "byLazy", "lazyHandleOnParentViewCreated", "attachToParent", KtvSubElement.CONTAINER, "setContainerView", "attachLazySlotComponent", "attachLazyComponent", "changeLazyComponentState", "attachComponent", "detachComponent", "getChildren", "Companion", "component_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ComponentStateController implements LifecycleEventObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LifecycleOwner f375165a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f375166b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f375167c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<ComponentFeature> f375168d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object f375169e;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f375170a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f375171b = null;

        static {
            int[] r100 = new int[Lifecycle.Event.values().length];
            r100[Lifecycle.Event.ON_CREATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L19
        L35:
            r100[Lifecycle.Event.ON_START.ordinal()] = 2;     // Catch: NoSuchFieldError -> L20
        L47:
            r100[Lifecycle.Event.ON_RESUME.ordinal()] = 3;     // Catch: NoSuchFieldError -> L21
        L37:
            r100[Lifecycle.Event.ON_PAUSE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L22
        L39:
            r100[Lifecycle.Event.ON_STOP.ordinal()] = 5;     // Catch: NoSuchFieldError -> L23
        L29:
            r100[Lifecycle.Event.ON_DESTROY.ordinal()] = 6;     // Catch: NoSuchFieldError -> L24
        L12:
            f375170a = r100;
            int[] r101 = new int[Lifecycle.State.values().length];
            r101[Lifecycle.State.CREATED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L25
        L43:
            r101[Lifecycle.State.STARTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L26
        L31:
            r101[Lifecycle.State.RESUMED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L27
        L41:
            r101[Lifecycle.State.DESTROYED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L28
        L17:
            f375171b = r101;
        }
    }

    static {
    }

    public final Lifecycle d() {
        return this.f375165a.getLifecycle();
    }

    public final Object getContext() {
        return this.f375166b;
    }

    public final void a(ComponentFeature r100) {
        Intrinsics.checkNotNullParameter(r100, "component");
        if (d().getCurrentState().compareTo(Lifecycle.State.DESTROYED) > 0) goto L5;
        return;
    L5:
        ((ArrayList) this.f375168d).add(r100);
        r100.getClass();
        Intrinsics.checkNotNullParameter(this, "<set-?>");
        r100.f375151e = this;
        int r101 = y1a.a.f565679a;
        y1a.a.a("ComponentStateController", "component: " + Reflection.getOrCreateKotlinClass(r100.getClass()).getSimpleName() + ", lifecycle " + this.f375165a);
        r100.D2(this.f375165a);
    }

    public final void b(Object r100) {
        this.f375169e = r100;
        d().removeObserver(this);
        d().addObserver(this);
    }

    public ComponentStateController(LifecycleOwner r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f375165a = r100;
        this.f375166b = r101;
        this.f375168d = new ArrayList();
    }

    public final void f(BaseComponentFeatureInternal r100, Attachable r101) {
        if (this.f375167c == false) goto L7;
        if (r101 == null) goto L8;
        r100.v2(r101);
        y1a.a.a("ComponentStateController", "lazyHandleOnParentViewCreated");
        return;
    L8:
        return;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner r100, Lifecycle.Event r101) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, "event");
        int r102 = y1a.a.f565679a;
        y1a.a.a("ComponentStateController", "onStateChanged " + r101 + ", " + Reflection.getOrCreateKotlinClass(r100.getClass()).getSimpleName());
        switch(b.f375170a[r101.ordinal()]) {
            case 1: goto L26;
            case 2: goto L22;
            case 3: goto L18;
            case 4: goto L14;
            case 5: goto L10;
            case 6: goto L5;
            default: goto L37;
        };
    L5:
        Iterator r103 = ((ArrayList) this.f375168d).iterator();
    L7:
        if (r103.hasNext() == false) goto L9;
        e(Lifecycle.State.DESTROYED, (ComponentFeature) r103.next(), null, false);
        goto L7
    L9:
        ((ArrayList) this.f375168d).clear();
        d().removeObserver(this);
        this.f375169e = null;
        return;
    L10:
        Iterator r104 = ((ArrayList) this.f375168d).iterator();
    L12:
        if (r104.hasNext() == false) goto L38;
        e(Lifecycle.State.CREATED, (ComponentFeature) r104.next(), null, false);
        goto L12
    L38:
        return;
    L14:
        Iterator r105 = ((ArrayList) this.f375168d).iterator();
    L16:
        if (r105.hasNext() == false) goto L39;
        e(Lifecycle.State.STARTED, (ComponentFeature) r105.next(), null, false);
        goto L16
    L39:
        return;
    L18:
        Iterator r106 = ((ArrayList) this.f375168d).iterator();
    L20:
        if (r106.hasNext() == false) goto L40;
        e(Lifecycle.State.RESUMED, (ComponentFeature) r106.next(), null, false);
        goto L20
    L40:
        return;
    L22:
        Iterator r107 = ((ArrayList) this.f375168d).iterator();
    L24:
        if (r107.hasNext() == false) goto L41;
        e(Lifecycle.State.STARTED, (ComponentFeature) r107.next(), null, false);
        goto L24
    L41:
        return;
    L26:
        Iterator r108 = ((ArrayList) this.f375168d).iterator();
    L28:
        if (r108.hasNext() == false) goto L42;
        e(Lifecycle.State.CREATED, (ComponentFeature) r108.next(), null, false);
        goto L28
    L42:
        return;
    }

    public final void c(ComponentFeature r100, Attachable r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "component");
        if (((ArrayList) this.f375168d).contains(r100) == true) goto L5;
        return;
    L5:
        if (r100.getLifecycle().getCurrentState() == d().getCurrentState()) goto L9;
        e(d().getCurrentState(), r100, r101, r102);
        return;
    }

    public final void e(Lifecycle.State r100, BaseComponentFeatureInternal r101, Attachable r102, boolean r103) {
        int r104 = b.f375171b[r100.ordinal()];
        if (r104 != 1) goto L5;
        Lifecycle.State r105 = r101.getLifecycle().getCurrentState();
        Lifecycle.State r106 = Lifecycle.State.CREATED;
        if (r105.compareTo(r106) < 0) goto L71;
        if (r103 == false) goto L79;
        f(r101, r102);
    L79:
        if (r101.getLifecycle().getCurrentState().compareTo(Lifecycle.State.STARTED) <= 0) goto L82;
        r101.w2();
    L82:
        if (r101.getLifecycle().getCurrentState().compareTo(r106) > 0) goto L84;
        return;
    L84:
        if (r101.f375150d == true) goto L104;
        r101.f375147a.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
        r101.onStop();
        return;
    L104:
        return;
    L71:
        if (r101.f375150d == true) goto L74;
        r101.onCreate();
        r101.f375147a.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
    L74:
        if (r103 == false) goto L98;
        f(r101, r102);
        return;
    L98:
        return;
    L5:
        if (r104 != 2) goto L7;
        Lifecycle.State r107 = r101.getLifecycle().getCurrentState();
        Lifecycle.State r108 = Lifecycle.State.STARTED;
        if (r107.compareTo(r108) >= 0) goto L64;
        if (r101.getLifecycle().getCurrentState().compareTo(Lifecycle.State.CREATED) < 0) goto L54;
    L57:
        if (r103 == false) goto L60;
        f(r101, r102);
    L60:
        if (r101.f375150d == true) goto L103;
        r101.onStart();
        r101.f375147a.handleLifecycleEvent(Lifecycle.Event.ON_START);
        return;
    L103:
        return;
    L54:
        if (r101.f375150d == true) goto L57;
        r101.onCreate();
        r101.f375147a.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        goto L57
    L64:
        if (r101.getLifecycle().getCurrentState().compareTo(r108) <= 0) goto L96;
        if (r103 == false) goto L67;
        f(r101, r102);
    L67:
        r101.w2();
        return;
    L96:
        return;
    L7:
        if (r104 == 3) goto L28;
        if (r104 == 4) goto L13;
        if (r103 == false) goto L88;
        f(r101, r102);
        return;
    L88:
        return;
    L13:
        if (r101.getLifecycle().getCurrentState().compareTo(Lifecycle.State.RESUMED) < 0) goto L16;
        r101.w2();
    L16:
        if (r101.getLifecycle().getCurrentState().compareTo(Lifecycle.State.STARTED) < 0) goto L22;
        if (r101.f375150d == true) goto L22;
        r101.f375147a.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
        r101.onStop();
    L22:
        if (r101.getLifecycle().getCurrentState().compareTo(Lifecycle.State.CREATED) >= 0) goto L24;
        return;
    L24:
        if (r101.f375150d == true) goto L101;
        r101.f375147a.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        r101.getViewModelStore().clear();
        r101.onDestroy();
        return;
    L101:
        return;
    L28:
        if (r101.getLifecycle().getCurrentState().compareTo(Lifecycle.State.RESUMED) < 0) goto L30;
        if (r103 == false) goto L93;
        f(r101, r102);
        return;
    L93:
        return;
    L30:
        if (r101.getLifecycle().getCurrentState().compareTo(Lifecycle.State.CREATED) < 0) goto L32;
    L35:
        if (r103 == false) goto L38;
        f(r101, r102);
    L38:
        if (r101.getLifecycle().getCurrentState().compareTo(Lifecycle.State.STARTED) >= 0) goto L44;
        if (r101.f375150d == true) goto L44;
        r101.onStart();
        r101.f375147a.handleLifecycleEvent(Lifecycle.Event.ON_START);
    L44:
        if (r101.f375150d == true) goto L102;
        r101.onResume();
        r101.f375147a.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
        return;
    L102:
        return;
    L32:
        if (r101.f375150d == true) goto L35;
        r101.onCreate();
        r101.f375147a.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        goto L35
    }
}
