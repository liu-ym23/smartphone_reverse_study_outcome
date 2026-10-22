package com.suite.lark.component.navroute.api;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.SystemClock;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.suite.lark.component.navroute.NavRouter;
import com.suite.lark.component.navroute.api.a;
import com.suite.lark.component.navroute.lifecycle.NavHostLifecycleRegistry;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000s\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000*\u0001\u001f\b&\u0018\u0000*\u0010\b\u0000\u0010\u0001*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0004J\u0010\u0010'\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0017J\u0010\u0010(\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0004J\u0010\u0010)\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0004J\b\u0010*\u001a\u00020$H\u0017J\u0010\u0010+\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0004J\b\u0010,\u001a\u00020$H\u0017J\u0010\u0010-\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0004J\b\u0010.\u001a\u00020$H\u0017J\b\u00102\u001a\u000203H\u0016J\u0010\u00104\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0002J\u000e\u00105\u001a\u00020$2\u0006\u0010/\u001a\u00020\u0017J\u000e\u00106\u001a\u00020$2\u0006\u00107\u001a\u00020\u0014J\b\u00108\u001a\u00020\bH\u0016J\u0010\u00109\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020:H&R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u00020\u0019X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0010\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010 R\u0011\u0010/\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b0\u00101¨\u0006;"}, d2 = {"Lcom/suite/lark/component/navroute/api/BaseNavRouteHost;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/suite/lark/component/navroute/api/IRouter;", "Lcom/suite/lark/component/navroute/api/NavRouteHost;", "Landroidx/lifecycle/LifecycleOwner;", "<init>", "()V", "navController", "Lcom/suite/lark/component/navroute/NavRouteController;", "lifecycleRegistry", "Lcom/suite/lark/component/navroute/lifecycle/NavHostLifecycleRegistry;", "getLifecycleRegistry", "()Lcom/suite/lark/component/navroute/lifecycle/NavHostLifecycleRegistry;", "lifecycleRegistry$delegate", "Lkotlin/Lazy;", "routerInterceptors", "", "Lcom/suite/lark/component/router/utils/ObjectRef;", "Lcom/suite/lark/component/navroute/interceptor/RouterNavRouteInterceptor;", "enableOnBackPressed", "", "bindToLifecycleRef", "Ljava/lang/ref/WeakReference;", "Landroidx/lifecycle/Lifecycle;", "lastResumeTime", "", "getLastResumeTime", "()J", "setLastResumeTime", "(J)V", "bindToLifecycleObserver", "com/suite/lark/component/navroute/api/BaseNavRouteHost$bindToLifecycleObserver$1", "Lcom/suite/lark/component/navroute/api/BaseNavRouteHost$bindToLifecycleObserver$1;", "getRouterName", "", "performCreate", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", WidgetCostModule.TYPE_ON_CREATE, "performAfterCreate", "performResume", "onResume", "performPause", "onPause", "performDestroy", LiveCommonConstants.REASON_ON_DEDTROY, NewBroadcastMonitor.STAGE.LIFECYCLE, "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "getNavHostLifecycle", "Lcom/suite/lark/component/navroute/lifecycle/NavHostLifecycle;", "handleBackPress", "bindWithLifecycle", "enableBackPressed", "enable", "getNavController", "createNavRouteController", "Landroidx/navigation/NavController;", "router_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseNavRouteHost<T extends a<?, ?>> implements f<T>, LifecycleOwner {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.suite.lark.component.navroute.a f460238a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f460239b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f460240c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public WeakReference<Lifecycle> f460241d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f460242e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final BaseNavRouteHost$bindToLifecycleObserver$1 f460243f;

    public abstract com.suite.lark.component.navroute.a g(BaseNavRouteHost$onCreate$1 r100);

    @Override // com.suite.lark.component.navroute.api.f
    public abstract /* synthetic */ Context getContext();

    @Override // com.suite.lark.component.navroute.api.f
    public final com.suite.lark.component.navroute.a getNavController() {
        com.suite.lark.component.navroute.a r100 = this.f460238a;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("navController");
        return null;
    L6:
        return r100;
    }

    public final NavHostLifecycleRegistry h() {
        return (NavHostLifecycleRegistry) this.f460239b.getValue();
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.suite.lark.component.navroute.api.BaseNavRouteHost$bindToLifecycleObserver$1] */
    public BaseNavRouteHost() {
        this.f460239b = LazyKt.lazy(new BaseNavRouteHost$lifecycleRegistry$2(this));
        new ArrayList();
        this.f460241d = new WeakReference(null);
        this.f460242e = SystemClock.elapsedRealtime();
        this.f460243f = new BaseNavRouteHost$bindToLifecycleObserver$1(this);
    }

    @Override // com.suite.lark.component.navroute.api.f
    public String b() {
        return e();
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public final Lifecycle getLifecycle() {
        return h();
    }

    public void onDestroy() {
        h().handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        Lifecycle r100 = this.f460241d.get();
        if (r100 == null) goto L5;
        r100.removeObserver(this.f460243f);
    L5:
        this.f460241d.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.suite.lark.component.navroute.api.BaseNavRouteHost$onCreate$1] */
    public void i(final Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        com.suite.lark.component.navroute.a r101 = g(new BaseNavRouteHost$onCreate$1(r100));
        this.f460238a = r101;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("navController");
        r101 = null;
    L5:
        r101.getClass();
        Intrinsics.checkNotNullParameter(this, "lifecycleOwner");
        r101.f460215c.setLifecycleOwner(this);
        com.suite.lark.component.navroute.a r102 = getNavController();
        if ((this instanceof ViewModelStoreOwner) == false) goto L8;
        ViewModelStore r103 = ((ViewModelStoreOwner) this).getViewModelStore();
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "viewModelStore");
        r102.f460215c.setViewModelStore(r103);
    L8:
        Object r104 = r100;
    L10:
        if ((r104 instanceof ContextWrapper) == false) goto L15;
        if ((r104 instanceof OnBackPressedDispatcherOwner) == true) goto L13;
        r104 = ((ContextWrapper) r104).getBaseContext();
        goto L10
    L13:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type androidx.activity.OnBackPressedDispatcherOwner");
        OnBackPressedDispatcher r105 = ((OnBackPressedDispatcherOwner) r100).getOnBackPressedDispatcher();
        r102.getClass();
        Intrinsics.checkNotNullParameter(r105, "backPressedDispatcher");
        r102.f460215c.setOnBackPressedDispatcher(r105);
    L15:
        boolean r106 = this.f460240c;
        r102.f460215c.enableOnBackPressed(r106);
    }

    public final void j(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        NavRouter.a r101 = NavRouter.f460191a;
        Intrinsics.checkNotNullParameter(this, "navHost");
        NavHostLifecycleRegistry r102 = h();
        r102.i(new com.suite.lark.component.navroute.c(this, r102));
        h().handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
    }
}
